package pers.hubery.accountcenter.common.enums;

import java.util.Objects;

/**
 * 记账动作
 *
 * @author LiPengfei
 * @version AccountingActionEnum.java v1.0 2022-03-30 11:43
 */
public enum AccountingActionEnum {

    /** 借 */
    DEBIT("D", "借"),

    /** 贷 */
    CREDIT("C", "贷"),

    /** 流入 */
    IN("I", "流入"),

    /** 流出 */
    OUT("O", "流出"),

    /** 冻结 */
    FREEZE("F", "冻结"),

    /** 解冻 */
    UNFREEZE("U", "解冻"),

    ;

    /** 编码 */
    private final String code;

    /** 描述 */
    private final String description;

    /**
     * constructor
     *
     * @param code        枚举值编码
     * @param description 枚举描述
     */
    AccountingActionEnum(final String code, final String description) {
        this.code = code;
        this.description = description;
    }

    /**
     * 根据 code 值获取枚举实例
     *
     * @param code 枚举编码值
     * @return 枚举实例
     */
    public static AccountingActionEnum getByCode(String code) {
        if (null == code) {
            return null;
        }

        for (AccountingActionEnum e : values()) {
            if (Objects.equals(e.getCode(), code)) {
                return e;
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
     * Getter method for property <tt>description</tt>.
     *
     * @return property value of description
     */
    public String getDescription() {
        return description;
    }

}