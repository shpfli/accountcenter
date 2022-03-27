package pers.hubery.accountcenter.biz.tpl;

/**
 * 服务回调
 *
 * @author hubery
 * @version ServiceCallback.java v1.0 2022-03-27 22:09
 */
public interface AccountCenterServiceCallback {

    /**
     * 参数合法校验
     */
    void validateRequest();

    /**
     * 业务校验
     */
    void doBizCheck();

    /**
     * 执行服务
     */
    void doService();
}
