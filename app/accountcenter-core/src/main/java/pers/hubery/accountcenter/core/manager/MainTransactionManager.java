package pers.hubery.accountcenter.core.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pers.hubery.accountcenter.common.context.BizContextHolder;
import pers.hubery.accountcenter.common.enums.ErrorCodeEnum;
import pers.hubery.accountcenter.common.enums.TccTransactionStatusEnum;
import pers.hubery.accountcenter.common.err.SystemException;
import pers.hubery.accountcenter.common.model.MainTransaction;
import pers.hubery.accountcenter.infra.dal.repository.MainTransactionRepository;

import java.text.MessageFormat;

/**
 * main transaction manager
 *
 * @author LiPengfei
 * @version MainTransactionManager.java v1.0 2022-03-30 18:44
 */
@Component
public class MainTransactionManager {

    /** 主事务记录仓库 */
    @Autowired
    private MainTransactionRepository mainTransactionRepository;

    /**
     * 初始化主事务记录
     *
     * @param xid 分布式事务ID
     * @return 主事务记录
     */
    public MainTransaction initMainTransaction(String xid) {

        //1. lock first
        MainTransaction mainTransaction = mainTransactionRepository.lock(xid);

        if (mainTransaction == null) {

            //2. if not exist. then insert
            mainTransactionRepository.insert(xid, TccTransactionStatusEnum.PREPARED);

            //3. lock again
            mainTransaction = mainTransactionRepository.lock(xid);

            if (mainTransaction == null) {

                //防御代码
                throw new SystemException(ErrorCodeEnum.SYSTEM_EXCEPTION,
                        MessageFormat.format(
                                "inert 主事务记录后，仍然查询不到！ xid:{}, tenantId:{}, accountBook:{}",
                                xid, BizContextHolder.getTenantId(), BizContextHolder.getAccountBook()));
            }
        }

        return mainTransaction;
    }

    /**
     * 锁查主事务记录
     *
     * @param xid 分布式事务ID
     * @return 主事务记录
     */
    public MainTransaction lockMainTransaction(String xid) {
        return mainTransactionRepository.lock(xid);
    }

    /**
     * 处理空回滚
     *
     * @param xid 分布式事务ID
     */
    public void processEmptyRollback(String xid) {

        //insert rollback record to prevent prepare request come later.
        mainTransactionRepository.insert(xid, TccTransactionStatusEnum.ROLLBACK);
    }

    /**
     * 更新事务状态
     *
     * @param xid          分布式事务ID
     * @param targetStatus 目标状态
     */
    public void updateStatus(final String xid, final TccTransactionStatusEnum targetStatus) {

        mainTransactionRepository.updateStatus(xid, targetStatus);
    }
}
