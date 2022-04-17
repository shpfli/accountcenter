package pers.hubery.accountcenter.common.enums;

import java.util.Objects;

/**
 * 分布式事务状态枚举
 *
 * @author LiPengfei
 * @version TccTransactionStatus.java v1.0 2022-03-30 18:32
 */
public enum TccTransactionStatus {

    /** 预处理阶段 */
    PREPARED("P", "PREPARED"),

    /** 已回滚 */
    ROLLBACK("R", "ROLLBACK"),

    /** 已提交 */
    COMMIT("C", "COMMIT"),
    ;

    /** 枚举值编码 */
    private final String code;

    /** 枚举描述 */
    private final String description;

    /**
     * constructor
     *
     * @param code        枚举值编码
     * @param description 枚举描述
     */
    TccTransactionStatus(final String code, final String description) {
        this.code = code;
        this.description = description;
    }

    /**
     * 根据枚举编码值获取枚举实例
     *
     * @param code 枚举编码值
     * @return 枚举实例
     */
    public static TccTransactionStatus getByCode(String code) {
        if (null == code) {
            return null;
        }

        for (TccTransactionStatus e : values()) {
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