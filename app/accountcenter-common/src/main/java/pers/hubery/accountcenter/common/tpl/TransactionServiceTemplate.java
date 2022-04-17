package pers.hubery.accountcenter.common.tpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.support.TransactionTemplate;
import pers.hubery.accountcenter.common.enums.ErrorCodeEnum;
import pers.hubery.accountcenter.common.err.SystemException;

/**
 * 服务模板
 *
 * @author LiPengfei
 * @version TransactionServiceTemplate.java v1.0 2022-03-30 14:18
 */
public class TransactionServiceTemplate {

    /** Logger */
    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionServiceTemplate.class);

    /**
     * 执行业务逻辑
     *
     * @param transactionTemplate transactionTemplate
     * @param callback            FacadeServiceCallback
     */
    public static void process(TransactionTemplate transactionTemplate, TransactionServiceCallback callback) {

        if (transactionTemplate == null) {
            throw new SystemException(ErrorCodeEnum.SYSTEM_EXCEPTION, "transactionTemplate cannot be null");
        }

        // 1. before transaction
        callback.beforeTransaction();

        // 2. process in transaction
        transactionTemplate.executeWithoutResult((transactionStatus) -> {
                    try {
                        callback.processInTransaction();
                    } catch (Throwable e) {
                        transactionStatus.setRollbackOnly();
                        LOGGER.error(e.getMessage(), e);
                        throw e;
                    }

                }

        );

        // 3. after transaction
        callback.afterTransaction();
    }
}