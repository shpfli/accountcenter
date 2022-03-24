package pers.hubery.accountcenter.common.context;

/**
 * 业务上下文 Holder
 *
 * @author hubery
 * @version BizContextHolder.java v1.0 2022-03-24 10:19
 */
public class BizContextHolder {

    /** 业务上下文线程变量 */
    private static final ThreadLocal<BizContext> BIZ_CONTEXT_THREAD_LOCAL = new ThreadLocal<BizContext>();

    /**
     * 获取业务上下文
     *
     * @return 业务上下文
     */
    public static BizContext get() {
        return BIZ_CONTEXT_THREAD_LOCAL.get();
    }

    /**
     * 设置业务上下文
     *
     * @param bizContext 业务上下文
     */
    public static void set(BizContext bizContext) {
        BIZ_CONTEXT_THREAD_LOCAL.set(bizContext);
    }

    /**
     * 清理业务上下文
     */
    public static void clear() {
        BIZ_CONTEXT_THREAD_LOCAL.remove();
    }

    /**
     * 从上下文中获取 accountBook
     *
     * @return accountBook
     */
    public static String getAccountBook() {

        BizContext bizContext = get();

        if (bizContext == null) {
            return null;
        }

        return bizContext.getAccountBook();
    }

    /**
     * 从上下文中获取 tenantId
     *
     * @return tenantId
     */
    public static String getTenantId() {

        BizContext bizContext = get();

        if (bizContext == null) {
            return null;
        }

        return bizContext.getTenantId();
    }
}
