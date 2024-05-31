package pers.hubery.accountcenter.common.enums;

import lombok.Getter;

@Getter
public enum BooleanEnum {

    TRUE(true, 1),
    FALSE(false, 0);


    /**
     * 枚举对应的 boolean 值
     */
    private final boolean value;

    /**
     * 枚举对应的 int 值
     */
    private final int intValue;


    /**
     * 构造器
     *
     * @param value    boolean 值
     * @param intValue int 值
     */
    BooleanEnum(boolean value, int intValue) {
        this.value = value;
        this.intValue = intValue;
    }

    /**
     * 将int类型的value转化为boolean值
     *
     * @param origin int 类型的 value
     * @return boolean 类型的 value
     */
    public static Boolean convert(Integer origin) {

        if (origin == null) {
            return null;
        }

        for (BooleanEnum booleanEnum : values()) {
            if (booleanEnum.getIntValue() == origin) {
                return booleanEnum.value;
            }
        }

        return null;
    }

    /**
     * 将boolean类型的value转化为int值
     *
     * @param origin boolean 值
     * @return int 值
     */
    public static Integer convert(Boolean origin) {
        if (origin == null) {
            return null;
        }

        for (BooleanEnum booleanEnum : values()) {
            if (booleanEnum.value == origin) {
                return booleanEnum.getIntValue();
            }
        }

        return null;
    }
}
