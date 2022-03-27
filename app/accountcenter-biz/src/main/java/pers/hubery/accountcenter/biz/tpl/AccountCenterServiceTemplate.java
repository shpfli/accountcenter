package pers.hubery.accountcenter.biz.tpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pers.hubery.accountcenter.common.context.BizContext;
import pers.hubery.accountcenter.common.context.BizContextHolder;
import pers.hubery.accountcenter.common.enums.ErrorCodeEnum;
import pers.hubery.accountcenter.common.err.BaseException;
import pers.hubery.accountcenter.common.util.Asserter;
import pers.hubery.accountcenter.facade.req.AccountCenterBaseRequest;
import pers.hubery.accountcenter.facade.rsp.BaseResponse;

/**
 * 账户中心服务模板
 *
 * @author hubery
 * @version ServiceTemplate.java v1.0 2022-03-27 22:09
 */
public class AccountCenterServiceTemplate {

    /** LOGGER */
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountCenterServiceTemplate.class);

    public static void process(AccountCenterBaseRequest request, BaseResponse response, AccountCenterServiceCallback callback) {

        try {

            // 1. 参数校验
            callback.validateRequest();

            // 2. 上下文初始化
            String tenantId = request.getTenantId();
            String shardingIndex = request.getShardingIndex();
            String accountBook = request.getAccountBook();

            Asserter.assertNotBlank(tenantId, ErrorCodeEnum.TENANT_ID_CANNOT_BE_NULL);
            Asserter.assertNotBlank(shardingIndex, ErrorCodeEnum.SHARDING_INDEX_CANNOT_BE_NULL);
            Asserter.assertNotBlank(accountBook, ErrorCodeEnum.ACCOUNT_BOOK_CANNOT_BE_NULL);

            // 业务上下文
            BizContext bizContext = BizContext.builder()
                    .tenantId(tenantId)
                    .accountBook(accountBook)
                    .shardingIndex(shardingIndex).build();

            BizContextHolder.set(bizContext);

            // 3. 业务校验
            callback.doBizCheck();

            // 4. 执行 service
            callback.doService();

            // 设置处理成功
            response.setSuccess(true);

        } catch (BaseException e) {
            LOGGER.error(e.getMessage(), e);

            ErrorCodeEnum errorCode = e.getErrorCode();
            if (errorCode == null) {
                errorCode = ErrorCodeEnum.UNKNOWN_EXCEPTION;
            }

            response.setSuccess(false);
            response.setErrorCode(errorCode.getCode());
            response.setErrorMsg(e.getMessage());

        } catch (Throwable e) {
            
            LOGGER.error(e.getMessage(), e);
            response.setSuccess(false);
            response.setErrorCode(ErrorCodeEnum.SYSTEM_EXCEPTION.getCode());
            response.setErrorMsg(e.getMessage());

        } finally {
            // 清理业务上下文
            BizContextHolder.clear();
        }
    }
}
