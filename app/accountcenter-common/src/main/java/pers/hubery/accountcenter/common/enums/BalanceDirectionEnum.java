package pers.hubery.accountcenter.common.enums;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

@Getter
public enum BalanceDirectionEnum {

    DEBIT("D", "DEBIT"),

    CREDIT("C", "CREDIT");


    /**
     * 枚举编码值
     */
    private final String code;

    /**
     * enum description
     */
    private final String desc;

    BalanceDirectionEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    /**
     * 根据code获取枚举
     *
     * @param code 枚举编码值
     * @return 枚举对象
     */
    public static BalanceDirectionEnum getByCode(String code) {

        for (BalanceDirectionEnum balanceDirectionEnum : values()) {
            if (StringUtils.equals(balanceDirectionEnum.getCode(), code)) {
                return balanceDirectionEnum;
            }
        }
        return null;
    }

}
