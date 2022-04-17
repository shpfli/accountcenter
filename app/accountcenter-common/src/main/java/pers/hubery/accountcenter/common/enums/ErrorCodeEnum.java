package pers.hubery.accountcenter.common.enums;

/**
 * 错误码
 *
 * @author hubery
 * @version ErrorCodeEnum.java v1.0 2022-03-27 22:24
 */
public enum ErrorCodeEnum {

    /** 请求对象不能为空 */
    REQUEST_CANNOT_BE_NULL("REQUEST_CANNOT_BE_NULL", "请求对象不能为空"),

    /** tenantId 不能为空 */
    TENANT_ID_CANNOT_BE_NULL("TENANT_ID_CANNOT_BE_NULL", "tenantId 不能为空！"),

    /** shardingIndex 不能为空 */
    SHARDING_INDEX_CANNOT_BE_NULL("SHARDING_INDEX_CANNOT_BE_NULL", "shardingIndex 不能为空！"),

    /** accountBook 不能为空 */
    ACCOUNT_BOOK_CANNOT_BE_NULL("ACCOUNT_BOOK_CANNOT_BE_NULL", "accountBook 不能为空！"),

    /** accountNo 不能为空 */
    ACCOUNT_NO_CANNOT_BE_BLANK("ACCOUNT_NO_CANNOT_BE_BLANK", "accountNo 不能为空！"),

    /** 记账指令不能为空 */
    ACCOUNTING_COMMAND_CANNOT_BE_NULL("ACCOUNTING_COMMAND_CANNOT_BE_NULL", "记账指令不能为空！"),

    /** 业务流水号不能为空 */
    BIZ_SEQ_NO_CANNOT_BE_BLANK("BIZ_SEQ_NO_CANNOT_BE_BLANK", "业务流水号不能为空"),

    /** xid不能为空 */
    XID_CANNOT_BE_BLANK("XID_CANNOT_BE_BLANK", "xid 不能为空"),

    /** accountNo 不能为空 */
    ACCOUNT_NOT_EXISTS("ACCOUNT_NO_CANNOT_BE_NULL", "accountNo 不能为空！"),

    // 业务异常
    /** 事务已经被回滚 */
    TRANSACTION_HAS_ALREADY_BEEN_ROLLBACK("90001", "事务已经被回滚"),

    /** 事务已经被提交 */
    TRANSACTION_HAS_ALREADY_BEEN_COMMIT("90002", "事务已经被提交"),

    /** 空提交 */
    EMPTY_COMMIT("90003", "空提交"),

    /** 分支事务不存在 */
    BRANCH_TRANSACTION_NOT_FOUND("90004", "分支事务不存在"),

    /** 记账指令不存在 */
    NO_ACCOUNTING_COMMAND_FOUND("90005", "记账指令不存在"),

    //系统异常
    /** 内存余额与DB中不一致 */
    BALANCE_IS_NOT_CONSISTENT_WITH_DB("BALANCE_IS_NOT_CONSISTENT_WITH_DB", "内存余额与DB中不一致"),

    /** 数据库异常 */
    DB_EXCEPTION("DB_EXCEPTION", "数据库异常！"),

    /** 未知异常 */
    UNKNOWN_EXCEPTION("UNKNOWN_EXCEPTION", "未知异常！"),

    /** 系统内部异常 */
    SYSTEM_EXCEPTION("SYSTEM_EXCEPTION", "系统异常！"),

    ;

    /** 枚举值 code */
    private final String code;

    /** 枚举值 message */
    private final String defaultMessage;

    /**
     * 默认构造器
     *
     * @param code           错误码 code
     * @param defaultMessage 默认错误信息
     */
    ErrorCodeEnum(final String code, final String defaultMessage) {
        this.code = code;
        this.defaultMessage = defaultMessage;
    }

    /**
     * Getter method for property <tt>code</tt>.
     *
     * @return property value of code
     */
    public String getCode() {
        return code;
    }

    /**
     * Getter method for property <tt>message</tt>.
     *
     * @return property value of message
     */
    public String getDefaultMessage() {
        return defaultMessage;
    }
}
