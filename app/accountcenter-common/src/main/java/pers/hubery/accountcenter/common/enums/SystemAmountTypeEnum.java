package pers.hubery.accountcenter.common.enums;

import org.apache.commons.lang3.StringUtils;

import java.text.MessageFormat;
import java.util.Objects;

/**
 * 系统金额枚举
 *
 * @author LiPengfei
 * @version SystemAmountTypeEnum.java v1.0 2022-03-31 16:28
 */
public enum SystemAmountTypeEnum {

    /** 未达金额，将要增加的金额 */
    UNREACHED_BALANCE("BU", "UNREACHED BALANCE"),

    /** 预冻结金额，将要减少的金额 */
    RESERVED_BALANCE("BR", "RESERVED BALANCE"),

    /** 冻结未达金额，将要冻结的金额 */
    UNREACHED_FROZEN("FU", "UNREACHED FROZEN AMOUNT"),

    /** 将要解冻的金额，将要解冻的金额 */
    RESERVED_FROZEN("FR", "RESERVED FROZEN AMOUNT"),

    ;

    /** 冻结金额类型由金额类型，冻结类型，冻结单通过连接符拼接而成 */
    private static final String CONNECTOR = "-";

    /** 编码值 */
    private final String code;

    /** 枚举描述 */
    private final String description;

    /**
     * constructor
     *
     * @param code        枚举值编码
     * @param description 枚举描述
     */
    SystemAmountTypeEnum(final String code, final String description) {
        this.code = code;
        this.description = description;
    }

    /**
     * 根据枚举编码值获取枚举实例
     *
     * @param code 枚举编码值
     * @return 枚举实例
     */
    public static SystemAmountTypeEnum getByCode(String code) {
        if (null == code) {
            return null;
        }

        for (SystemAmountTypeEnum e : values()) {
            if (Objects.equals(e.getCode(), code)) {
                return e;
            }
        }

        return null;
    }

    /**
     * build SystemAmountType
     *
     * @param amountTypeEnum amount type enum
     * @return amountType
     */
    public static String buildAmountType(final SystemAmountTypeEnum amountTypeEnum) {
        return buildAmountType(amountTypeEnum, null, null);
    }

    /**
     * build SystemAmountType
     *
     * @param amountTypeEnum amount type enum
     * @param freezeType     freeze type
     * @param freezeOrderNo  freeze order
     * @return amountType
     */
    public static String buildAmountType(SystemAmountTypeEnum amountTypeEnum, String freezeType, String freezeOrderNo) {

        switch (amountTypeEnum) {
            case RESERVED_FROZEN:
            case UNREACHED_FROZEN:
                if (StringUtils.isEmpty(freezeType) || StringUtils.isEmpty(freezeOrderNo)) {
                    throw new IllegalArgumentException("freezeType and freezeOrderNo cannot be empty.");
                }
                return amountTypeEnum.getCode() + CONNECTOR + freezeType + CONNECTOR + freezeOrderNo;
            case UNREACHED_BALANCE:
            case RESERVED_BALANCE:
            default:
                return amountTypeEnum.getCode();
        }
    }

    /**
     * parse systemAmountTypeEnum from systemAmountType
     *
     * @param amountType systemAmountType
     * @return systemAmountTypeEnum
     */
    public static SystemAmountTypeEnum parseSystemAmountTypeEnum(String amountType) {

        for (SystemAmountTypeEnum item : values()) {
            if (StringUtils.startsWith(amountType, item.getCode())) {
                return item;
            }
        }

        throw new IllegalArgumentException(MessageFormat.format("unidentifiable amountType : {}", amountType));
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