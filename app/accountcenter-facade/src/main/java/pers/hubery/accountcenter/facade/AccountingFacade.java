package pers.hubery.accountcenter.facade;

import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.rm.tcc.api.BusinessActionContextParameter;
import io.seata.rm.tcc.api.LocalTCC;
import io.seata.rm.tcc.api.TwoPhaseBusinessAction;
import pers.hubery.accountcenter.facade.req.DecreaseRequest;
import pers.hubery.accountcenter.facade.req.IncreaseRequest;
import pers.hubery.accountcenter.facade.rsp.AccountingResponse;

/**
 * 记账服务 facade
 *
 * @author lipengfei
 */
@LocalTCC
public interface AccountingFacade {

    /**
     * 增加余额，TCC第一阶段--try阶段
     *
     * @param context         businessActionContext
     * @param increaseRequest 余额增加请求
     * @return 返回交易子流水号
     */
    @TwoPhaseBusinessAction(name = "increaseBalance", commitMethod = "confirm", rollbackMethod = "cancel")
    AccountingResponse increaseBalance(final BusinessActionContext context,
                                       @BusinessActionContextParameter(isParamInProperty = true, isShardingParam = true)
                                               IncreaseRequest increaseRequest);

    /**
     * 减少余额，TCC第一阶段--try阶段
     *
     * @param context         businessActionContext
     * @param decreaseRequest 余额减少请求
     * @return 返回交易子流水号
     */
    @TwoPhaseBusinessAction(name = "decreaseBalance", commitMethod = "confirm", rollbackMethod = "cancel")
    AccountingResponse decreaseBalance(final BusinessActionContext context,
                                       @BusinessActionContextParameter(isParamInProperty = true, isShardingParam = true)
                                               DecreaseRequest decreaseRequest);

    /**
     * TCC第二阶段--confirm
     *
     * @param context TCC 事务上下文
     * @return 提交执行结果
     */
    boolean confirm(BusinessActionContext context);

    /**
     * TCC第二阶段--cancel
     *
     * @param context TCC 事务上下文
     * @return 回滚执行结果
     */
    boolean cancel(BusinessActionContext context);
}
