package pers.hubery.accountcenter.biz;

import io.seata.rm.tcc.api.BusinessActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.hubery.accountcenter.biz.tpl.AccountCenterServiceCallback;
import pers.hubery.accountcenter.biz.tpl.AccountCenterServiceTemplate;
import pers.hubery.accountcenter.common.context.BizContext;
import pers.hubery.accountcenter.common.context.BizContextHolder;
import pers.hubery.accountcenter.common.enums.AccountingActionEnum;
import pers.hubery.accountcenter.common.enums.ErrorCodeEnum;
import pers.hubery.accountcenter.common.model.AccountingCommand;
import pers.hubery.accountcenter.common.util.Asserter;
import pers.hubery.accountcenter.core.service.TccBalanceChangeService;
import pers.hubery.accountcenter.facade.AccountingFacade;
import pers.hubery.accountcenter.facade.req.AccountingRequest;
import pers.hubery.accountcenter.facade.req.DecreaseRequest;
import pers.hubery.accountcenter.facade.req.IncreaseRequest;
import pers.hubery.accountcenter.facade.rsp.AccountingResponse;

import static pers.hubery.accountcenter.facade.constant.FacadeConstant.PARAM_NAME_ACCOUNT_BOOK;
import static pers.hubery.accountcenter.facade.constant.FacadeConstant.PARAM_NAME_SHARDING_INDEX;

/**
 * 余额变动服务 facade 实现
 *
 * @author LiPengfei
 * @version BalanceChangeFacadeImpl.java v1.0 2022-03-25 09:41
 */
@Service
public class BalanceChangeFacadeImpl implements AccountingFacade {

    /** LOGGER */
    private static final Logger LOGGER = LoggerFactory.getLogger(BalanceChangeFacadeImpl.class);

    /** tccBalanceChangeService */
    @Autowired
    private TccBalanceChangeService tccBalanceChangeService;

    /**
     * 增加余额，TCC第一阶段--try阶段
     *
     * @param context         businessActionContext
     * @param increaseRequest 余额增加请求
     * @return 返回交易子流水号
     */
    @Override
    public AccountingResponse increaseBalance(final BusinessActionContext context, final IncreaseRequest increaseRequest) {
        AccountingResponse response = new AccountingResponse();

        AccountCenterServiceTemplate.process(increaseRequest, response, new AccountCenterServiceCallback() {
            @Override
            public void validateRequest() {

            }

            @Override
            public void doBizCheck() {

            }

            @Override
            public void doService() {
                tccBalanceChangeService.prepare(context.getXid(), context.getBranchId(), buildCommand(increaseRequest));
            }
        });

        return response;
    }

    /**
     * 减少余额，TCC第一阶段--try阶段
     *
     * @param context         businessActionContext
     * @param decreaseRequest 余额减少请求
     * @return 返回交易子流水号
     */
    @Override
    public AccountingResponse decreaseBalance(final BusinessActionContext context, final DecreaseRequest decreaseRequest) {
        AccountingResponse response = new AccountingResponse();

        AccountCenterServiceTemplate.process(decreaseRequest, response, new AccountCenterServiceCallback() {
            @Override
            public void validateRequest() {

            }

            @Override
            public void doBizCheck() {

            }

            @Override
            public void doService() {
                tccBalanceChangeService.prepare(context.getXid(), context.getBranchId(), buildCommand(decreaseRequest));
            }
        });

        return response;
    }

    /**
     * 第一阶段成功时，根据上下文事务id进行事务提交。TCC第二阶段--confirm阶段。
     *
     * @param context TCC 事务上下文
     * @return 提交执行结果
     */
    @Override
    public boolean confirm(final BusinessActionContext context) {

        try {

            // 1. valid param
            String shardingIndex = (String) context.getActionContext(PARAM_NAME_SHARDING_INDEX);
            String accountBook = (String) context.getActionContext(PARAM_NAME_ACCOUNT_BOOK);

            // 2. init bizContext
            BizContext bizContext = BizContext.builder()
                    .shardingIndex(shardingIndex)
                    .build();
            BizContextHolder.set(bizContext);

            //3. preCheck

            //4. process business
            tccBalanceChangeService.commit(context.getXid(), context.getBranchId(), accountBook);

            // no exception means success
            return true;

        } catch (Throwable e) {
            LOGGER.error("unknown exception!", e);
        } finally {

            // 最后一定要清理上下文
            BizContextHolder.clear();
        }

        return false;
    }

    /**
     * 第一阶段失败时，根据上下文事务id进行回滚。TCC第二阶段--cancel阶段。
     *
     * @param context TCC 事务上下文
     * @return 回滚执行结果
     */
    @Override
    public boolean cancel(final BusinessActionContext context) {
        try {

            // 1. valid param
            String shardingIndex = (String) context.getActionContext(PARAM_NAME_SHARDING_INDEX);
            String accountBook = (String) context.getActionContext(PARAM_NAME_ACCOUNT_BOOK);

            // 2. init bizContext
            BizContext bizContext = BizContext.builder()
                    .shardingIndex(shardingIndex)
                    .build();
            BizContextHolder.set(bizContext);

            //3. preCheck

            //4. process business
            tccBalanceChangeService.rollback(context.getXid(), context.getBranchId(), accountBook);

            // no exception means success
            return true;

        } catch (Throwable e) {
            LOGGER.error("unknown exception!", e);
        } finally {

            // 最后一定要清理上下文
            BizContextHolder.clear();
        }

        return false;
    }

    /**
     * build AccountingCommand
     *
     * @param request BalanceChangeRequest
     * @return AccountingCommand
     */
    private static AccountingCommand buildCommand(AccountingRequest request) {

        Asserter.assertNotNull(request, ErrorCodeEnum.REQUEST_CANNOT_BE_NULL);

        return AccountingCommand.builder()
                /* 请求业务流水号，唯一识别一笔业务请求，同一笔业务请求重复调用该值不变，用于业务幂等判断 */
                .reqBizNo(request.getRequestUniqueId())
                /* 账本，例如：DEPOSIT-活期存款，TIME-DEPOSIT-定期存款，LOAN-贷款，…… */
                .accountBook(request.getAccountBook())
                /* 账号 */
                .accountNo(request.getAccountNo())
                /* balance type*/
                .balanceType(request.getBalanceType())
                /*  account date */
                .accountDate(request.getAccountDate())
                /* the timestamp of the business happened */
                .businessTimestamp(request.getBusinessTimestamp())
                /* 交易金额 */
                .amount(request.getAmount())
                /* 交易流水号，用于关联同一笔交易的借贷双方或多方，同一个交易流水号下的交易应该借贷平衡 */
                .referenceNo(request.getReferenceNo())
                /* memo */
                .memo(request.getMemo())
                /* 余额变动动作：IN,OUT,FREEZE,UNFREEZE */
                .action(AccountingActionEnum.getByCode(request.getAction()))
                .build();

    }
}
