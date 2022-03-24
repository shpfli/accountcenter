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
}
