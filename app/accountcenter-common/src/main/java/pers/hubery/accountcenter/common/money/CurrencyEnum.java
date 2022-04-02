package pers.hubery.accountcenter.common.money;

import org.apache.commons.lang3.StringUtils;

/**
 * 币种枚举
 *
 * @author Hubery
 * @version CurrencyEnum.java v1.0 2022-03-29 18:30
 */
public enum CurrencyEnum {

    // IDR 印尼盾
    IDR("IDR", "360", new String(new char[] {'R', 'p'})),

    // SGD 新加坡元
    SGD("SGD", "702", new String(new char[] {'S', '$'})),

    // PHP 菲律宾比索
    PHP("PHP", "608", new String(new char[] {'₱'})),

    // MYR 马来西亚林吉特
    MYR("MYR", "458", new String(new char[] {'R', 'M'})),

    // THB 泰铢
    THB("THB", "764", new String(new char[] {'฿'})),

    // VND 越南盾
    VND("VND", "704", new String(new char[] {'₫'})),

    // CNY
    CNY("CNY", "156", new String(new char[] {'￥'})),

    // USD
    USD("USD", "840", new String(new char[] {'U', 'S', ' ', '$'})),

    // HKD
    HKD("HKD", "344", new String(new char[] {'H', 'K', '$'})),

    // TWD
    TWD("TWD", "901", new String(new char[] {'N', 'T', '$'})),

    // EUR
    EUR("EUR", "978", new String(new char[] {'€'})),

    // GPB
    GBP("GBP", "826", new String(new char[] {'￡'})),

    // JPY
    JPY("JPY", "392", new String(new char[] {'¥'})),

    // BRL
    BRL("BRL", "986", new String(new char[] {'R', '$'})),

    // RUB
    RUB("RUB", "643", new String(new char[] {'р', 'у', 'б', '.'})),

    // AUD
    AUD("AUD", "036", new String(new char[] {'A', 'U', ' ', '$'})),

    // CAD
    CAD("CAD", "124", new String(new char[] {'C', '$'})),

    // INR
    INR("INR", "356", new String(new char[] {'R', 's', '.'})),

    // UAH
    UAH("UAH", "980", new String(new char[] {'г', 'р', 'н', '.'})),

    // MXN
    MXN("MXN", "484", new String(new char[] {'M', 'X', 'N', '$'})),

    // CHF
    CHF("CHF", "756", new String(new char[] {'C', 'H', 'F'})),

    ;

    /** 币种 code */
    private final String currencyCode;

    /** 币种值 */
    private final String currencyValue;

    /** 币种 label */
    private final String currencyLabel;

    /**
     * 构造器
     *
     * @param currencyCode  币种 code
     * @param currencyValue 币种值
     * @param currencyLabel 币种 label
     */
    CurrencyEnum(String currencyCode, String currencyValue, String currencyLabel) {
        this.currencyCode = currencyCode;
        this.currencyValue = currencyValue;
        this.currencyLabel = currencyLabel;
    }

    /**
     * 根据币种值获取币种枚举
     *
     * @param currencyValue 币种值
     * @return 币种枚举
     */
    public static CurrencyEnum getByCurrencyValue(final String currencyValue) {

        for (CurrencyEnum item : CurrencyEnum.values()) {
            if (StringUtils.equals(item.getCurrencyValue(), currencyValue)) {
                return item;
            }
        }

        return null;
    }

    /**
     * 根据币种code获取币种枚举
     *
     * @param currencyCode 币种值
     * @return 币种枚举
     */
    public static CurrencyEnum getByCurrencyCode(final String currencyCode) {

        for (CurrencyEnum item : CurrencyEnum.values()) {
            if (StringUtils.equals(item.getCurrencyCode(), currencyCode)) {
                return item;
            }
        }
        return null;
    }

    /**
     * Getter method for property <tt>currencyCode</tt>.
     *
     * @return property value of currencyCode
     */
    public String getCurrencyCode() {
        return currencyCode;
    }

    /**
     * Getter method for property <tt>currencyValue</tt>.
     *
     * @return property value of currencyValue
     */
    public String getCurrencyValue() {
        return currencyValue;
    }

    /**
     * Getter method for property <tt>currencyLabel</tt>.
     *
     * @return property value of currencyLabel
     */
    public String getCurrencyLabel() {
        return currencyLabel;
    }
}
