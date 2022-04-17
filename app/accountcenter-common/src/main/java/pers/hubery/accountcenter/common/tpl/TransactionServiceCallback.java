package pers.hubery.accountcenter.common.tpl;

/**
 * service callback
 *
 * @author LiPengfei
 * @version FacadeServiceCallback.java v1.0 2022-03-30 14:19
 */
public interface TransactionServiceCallback {

    /**
     * pre-process before start transaction, such as : param check
     */
    void beforeTransaction();

    /**
     * process in transaction
     */
    void processInTransaction();

    /**
     * post-process after transaction committed
     */
    void afterTransaction();
}
