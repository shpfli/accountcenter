package pers.hubery.accountcenter.common.enums;

/**
 * 错误码
 *
 * @author hubery
 * @version ErrorCodeEnum.java v1.0 2022-03-27 22:24
 */
public enum ErrorCodeEnum {

    /** tenantId 不能为空 */
    TENANT_ID_CANNOT_BE_NULL("TENANT_ID_CANNOT_BE_NULL", "tenantId 不能为空！"),

    /** shardingIndex 不能为空 */
    SHARDING_INDEX_CANNOT_BE_NULL("SHARDING_INDEX_CANNOT_BE_NULL", "shardingIndex 不能为空！"),

    /** accountBook 不能为空 */
    ACCOUNT_BOOK_CANNOT_BE_NULL("ACCOUNT_BOOK_CANNOT_BE_NULL", "accountBook 不能为空！"),

    /** accountNo 不能为空 */
    ACCOUNT_NO_CANNOT_BE_NULL("ACCOUNT_NO_CANNOT_BE_NULL", "accountNo 不能为空！"),

    /** accountNo 不能为空 */
    ACCOUNT_NOT_EXISTS("ACCOUNT_NO_CANNOT_BE_NULL", "accountNo 不能为空！"),

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
