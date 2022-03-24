package pers.hubery.accountcenter.common.enums;

/**
 * 账户状态枚举
 *
 * @author hubery
 * @version AccountStatusEnum.java v1.0 2022-03-24 09:59
 */
public enum AccountStatusEnum {

    /** ACTIVE */
    ACTIVE("A", "ACTIVE"),

    /** INACTIVE */
    INACTIVE("I", "INACTIVE"),

    /** CANCELED */
    CANCEL("C", "CANCELED");

    /** enum code */
    private final String code;

    /** enum description */
    private final String desc;

    AccountStatusEnum(final String code, final String desc) {
        this.code = code;
        this.desc = desc;
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
     * Getter method for property <tt>desc</tt>.
     *
     * @return property value of desc
     */
    public String getDesc() {
        return desc;
    }
}
