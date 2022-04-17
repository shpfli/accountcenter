package pers.hubery.accountcenter.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.util.CollectionUtils;
import pers.hubery.accountcenter.common.enums.ErrorCodeEnum;
import pers.hubery.accountcenter.common.enums.TccTransactionStatusEnum;
import pers.hubery.accountcenter.common.err.BizException;
import pers.hubery.accountcenter.common.model.AccountingCommand;
import pers.hubery.accountcenter.common.model.BranchTransaction;
import pers.hubery.accountcenter.common.model.MainTransaction;
import pers.hubery.accountcenter.common.tpl.TransactionServiceCallback;
import pers.hubery.accountcenter.common.tpl.TransactionServiceTemplate;
import pers.hubery.accountcenter.common.util.Asserter;
import pers.hubery.accountcenter.core.engine.AccountingEngine;
import pers.hubery.accountcenter.core.manager.BranchTransactionManager;
import pers.hubery.accountcenter.core.manager.MainTransactionManager;
import pers.hubery.accountcenter.core.service.TccBalanceChangeService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 余额变动服务实现
 *
 * @author LiPengfei
 * @version TccBalanceChangeServiceImpl.java v1.0 2022-03-30 14:05
 */
@Service("tccBalanceChangeService")
public class TccBalanceChangeServiceImpl implements TccBalanceChangeService {

    /** 账务库事务模板 */
    @Autowired
    private TransactionTemplate transactionTemplate;

    /** 主事务记录 manager */
    @Autowired
    private MainTransactionManager mainTransactionManager;

    /** 分支事务记录 manager */
    @Autowired
    private BranchTransactionManager branchTransactionManager;

    /** 账务引擎 */
    @Autowired
    private AccountingEngine accountingEngine;

    /**
     * 执行资金预处理
     *
     * @param xid      TCC 事务 ID
     * @param branchId TCC 参与者 ID
     * @param command  余额变动信息
     */
    @Override
    public void prepare(final String xid, final long branchId, final AccountingCommand command) {

        TransactionServiceTemplate.process(transactionTemplate, new TransactionServiceCallback() {
            @Override
            public void beforeTransaction() {

                // 校验分布式事务 ID 非空
                Asserter.assertNotBlank(xid, ErrorCodeEnum.XID_CANNOT_BE_BLANK);
                // 校验 tccAccountingCommand 非空
                Asserter.assertNotNull(command, ErrorCodeEnum.ACCOUNTING_COMMAND_CANNOT_BE_NULL);
                // 业务流水号不能为空
                Asserter.assertNotBlank(command.getReqBizNo(), ErrorCodeEnum.BIZ_SEQ_NO_CANNOT_BE_BLANK);
                // 账号不能为空
                Asserter.assertNotBlank(command.getAccountNo(), ErrorCodeEnum.ACCOUNT_NO_CANNOT_BE_BLANK);
            }

            @Override
            public void processInTransaction() {

                //1. 初始化主事务记录
                MainTransaction mainTransaction = mainTransactionManager.initMainTransaction(xid);

                //2. do check
                if (mainTransaction.getStatus() == TccTransactionStatusEnum.ROLLBACK) {
                    throw new BizException(ErrorCodeEnum.TRANSACTION_HAS_ALREADY_BEEN_ROLLBACK);
                }
                if (mainTransaction.getStatus() == TccTransactionStatusEnum.COMMIT) {
                    throw new BizException(ErrorCodeEnum.TRANSACTION_HAS_ALREADY_BEEN_COMMIT);
                }

                //3. 资金预留
                accountingEngine.reserve(xid, command);

                //4. 记录分支事务
                BranchTransaction branchTransaction = BranchTransaction.builder()
                        .xid(xid)
                        .branchId(branchId)
                        .reqBizNo(command.getReqBizNo())
                        .accountBook(command.getAccountBook())
                        .acctNo(command.getAccountNo())
                        .balanceType(command.getBalanceType())
                        .accountDate(command.getAccountDate())
                        .action(command.getAction())
                        .amount(command.getAmount())
                        .businessTimestamp(command.getBusinessTimestamp())
                        .referenceNo(command.getReferenceNo())
                        .memo(command.getMemo())
                        .operator(command.getOperator())
                        .authUserId(command.getAuthUserId())
                        .channel(command.getChannel())
                        .srcChannel(command.getSrcChannel())
                        .srcChannelBizNo(command.getSrcChannelBizNo())
                        .fromAppName(command.getFromAppName())
                        .build();

                branchTransactionManager.recordBranchTransaction(branchTransaction);
            }

            @Override
            public void afterTransaction() {

            }
        });

    }

    /**
     * rollback
     *
     * @param xid         TCC main transaction ID
     * @param branchId    TCC branch transaction ID
     * @param accountBook account book, such as : deposit, loan, ……
     */
    @Override
    public void rollback(final String xid, final Long branchId, final String accountBook) {

        TransactionServiceTemplate.process(transactionTemplate, new TransactionServiceCallback() {
            @Override
            public void beforeTransaction() {

                // 校验分布式事务 ID 非空
                Asserter.assertNotBlank(xid, ErrorCodeEnum.XID_CANNOT_BE_BLANK);

                // TODO param check
            }

            @Override
            public void processInTransaction() {

                //1. 锁查主事务记录
                MainTransaction mainTransaction = mainTransactionManager.lockMainTransaction(xid);

                //2. 检查
                if (mainTransaction == null) {
                    // 2.1 空回滚
                    mainTransactionManager.processEmptyRollback(xid);
                    return;
                }

                if (mainTransaction.getStatus() == TccTransactionStatusEnum.ROLLBACK) {
                    // 2.2 已回滚
                    return;
                }
                if (mainTransaction.getStatus() == TccTransactionStatusEnum.COMMIT) {
                    // 2.3 已提交
                    throw new BizException(ErrorCodeEnum.TRANSACTION_HAS_ALREADY_BEEN_COMMIT);
                }

                //3. 还原系统金额
                accountingEngine.unreserve(xid);

                //4. 删除分支事务
                branchTransactionManager.remove(xid);

                //5. 更新主事务状态
                mainTransactionManager.updateStatus(xid, TccTransactionStatusEnum.ROLLBACK);
            }

            @Override
            public void afterTransaction() {

            }
        });

    }

    /**
     * commit tcc transaction
     *
     * @param xid         TCC main transaction ID
     * @param branchId    TCC branch transaction ID
     * @param accountBook account book, such as : deposit, loan, ……
     */
    @Override
    public void commit(final String xid, final Long branchId, final String accountBook) {

        TransactionServiceTemplate.process(transactionTemplate, new TransactionServiceCallback() {
            @Override
            public void beforeTransaction() {

                // 校验分布式事务 ID 非空
                Asserter.assertNotBlank(xid, ErrorCodeEnum.XID_CANNOT_BE_BLANK);

            }

            @Override
            public void processInTransaction() {

                //1. 锁查主事务记录
                MainTransaction mainTransaction = mainTransactionManager.lockMainTransaction(xid);

                //2.状态检查
                if (mainTransaction == null) {
                    // 2.1 空提交
                    throw new BizException(ErrorCodeEnum.EMPTY_COMMIT);
                }

                if (mainTransaction.getStatus() == TccTransactionStatusEnum.ROLLBACK) {
                    // 2.2 已经回滚
                    throw new BizException(ErrorCodeEnum.TRANSACTION_HAS_ALREADY_BEEN_ROLLBACK);
                }
                if (mainTransaction.getStatus() == TccTransactionStatusEnum.COMMIT) {
                    // 2.3 重复提交
                    return;
                }

                //3. 还原系统金额
                accountingEngine.unreserve(xid);

                //4. 查询分支事务列表
                List<BranchTransaction> branchTransactionList = branchTransactionManager.get(xid);

                if (CollectionUtils.isEmpty(branchTransactionList)) {
                    throw new BizException(ErrorCodeEnum.BRANCH_TRANSACTION_NOT_FOUND);
                }

                //5. convert to TccAccountingCommand
                List<AccountingCommand> commandList = branchTransactionList.stream().map(branchTransaction ->
                        AccountingCommand.builder()
                                .reqBizNo(branchTransaction.getReqBizNo())
                                .accountBook(branchTransaction.getAccountBook())
                                .accountNo(branchTransaction.getAcctNo())
                                .balanceType(branchTransaction.getBalanceType())
                                .accountDate(branchTransaction.getAccountDate())
                                .businessTimestamp(branchTransaction.getBusinessTimestamp())
                                .action(branchTransaction.getAction())
                                .amount(branchTransaction.getAmount())
                                .referenceNo(branchTransaction.getReferenceNo())
                                .memo(branchTransaction.getMemo())
                                .channel(branchTransaction.getChannel())
                                .srcChannel(branchTransaction.getSrcChannel())
                                .srcChannelBizNo(branchTransaction.getSrcChannelBizNo())
                                .operator(branchTransaction.getOperator())
                                .authUserId(branchTransaction.getAuthUserId())
                                .fromAppName(branchTransaction.getFromAppName())
                                .createTime(branchTransaction.getCreateTimestamp())
                                .build()
                ).collect(Collectors.toList());

                //6. 记账
                accountingEngine.doAccount(commandList);

                //7. 删除分支事务
                branchTransactionManager.remove(xid);

                //8. 更新主事务状态
                mainTransactionManager.updateStatus(xid, TccTransactionStatusEnum.COMMIT);
            }

            @Override
            public void afterTransaction() {

            }
        });

    }
}
