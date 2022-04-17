package pers.hubery.accountcenter.common.enums;

import java.util.Objects;

/**
 * 账户状态枚举
 *
 * @author hubery
 * @version AccountStatusEnum.java v1.0 2022-03-24 09:59
 */
public enum AccountStatusEnum {

    /** 激活状态 */
    ACTIVE("A", "ACTIVE"),

    /** 失效状态 */
    INACTIVE("I", "INACTIVE"),

    /** 销户状态 */
    CANCEL("C", "CANCELED");

    /** 枚举编码值 */
    private final String code;

    /** enum description */
    private final String desc;

    AccountStatusEnum(final String code, final String desc) {
        this.code = code;
        this.desc = desc;
    }

    /**
     * 根据枚举 code 获取枚举对象
     *
     * @param code 枚举 code
     * @return 枚举对象
     */
    public static AccountStatusEnum getByCode(String code) {

        for (AccountStatusEnum item : values()) {
            if (Objects.equals(item.getCode(), code)) {
                return item;
            }
        }
        return null;
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
