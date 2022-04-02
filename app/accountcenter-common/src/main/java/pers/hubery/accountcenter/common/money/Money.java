package pers.hubery.accountcenter.common.money;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Currency;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 金额类型
 * <p>说明：Money类设计为immutable，保证线程安全，以及计算的安全。</p>
 *
 * @author Hubery
 * @version Money.java v1.0 2022-03-29 18:28
 */
public final class Money implements Serializable, Comparable<Money>, Cloneable {

    private static final long serialVersionUID = -5826989138501956672L;

    private long cent;

    private Currency currency;

    private static final int[] CENT_FACTORS = new int[] {1, 10, 100, 1000, 10000, 100000};

    private static final Pattern MONEY_PATTERN = Pattern.compile("^\\[[-]?(([1-9][0-9]*)|0)(\\.[0-9]{1,})?\\,[0-9][0-9][0-9]\\]$");

    public Money(BigDecimal amount, String currencyCode) {
        this.setCurrencyCode(currencyCode);
        this.cent = this.rounding(amount.movePointRight(this.currency.getDefaultFractionDigits()), 6);
    }

    public Money(BigDecimal amount, CurrencyEnum currencyEnum) {
        this(amount, currencyEnum.getCurrencyCode());
    }

    public Money(BigDecimal amount, Currency currency) {
        this((BigDecimal) amount, currency, 6);
    }

    public Money(BigDecimal amount, Currency currency, int roundingMode) {
        this.setCurrency(currency);
        this.cent = this.rounding(amount.movePointRight(currency.getDefaultFractionDigits()), roundingMode);
    }

    public BigDecimal getAmount() {
        return BigDecimal.valueOf(this.cent, this.currency.getDefaultFractionDigits());
    }

    /**
     * 建议仅在DAL层OR Mapping时使用；其他场景不要直接使用。
     *
     * @return
     */
    @Deprecated
    public long getCent() {
        return this.cent;
    }

    public Currency getCurrency() {
        return this.currency;
    }

    public final int getCentFactor() {
        return CENT_FACTORS[this.currency.getDefaultFractionDigits()];
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof Money && this.equals((Money) other);
    }

    public boolean equals(Money other) {
        return this.currency.equals(other.currency) && this.cent == other.cent;
    }

    @Override
    public int hashCode() {
        return (int) (this.cent ^ this.cent >>> 32);
    }

    @Override
    public Money clone() {
        return new Money(this.getAmount(), this.getCurrencyCode());
    }

    @Override
    public int compareTo(Money other) {
        this.assertSameCurrencyAs(other);
        if (this.cent < other.cent) {
            return -1;
        } else {
            return this.cent == other.cent ? 0 : 1;
        }
    }

    public boolean greaterThan(Money other) {
        return this.compareTo(other) > 0;
    }

    public Money add(Money other) {
        this.assertSameCurrencyAs(other);
        return this.newMoneyWithSameCurrency(CheckOverflow.longCheckedAdd(this.cent, other.cent));
    }

    public Money subtract(Money other) {
        this.assertSameCurrencyAs(other);
        return this.newMoneyWithSameCurrency(CheckOverflow.longCheckedSubtract(this.cent, other.cent));
    }

    public Money multiply(long val) {
        return this.newMoneyWithSameCurrency(CheckOverflow.longCheckedMultiply(this.cent, val));
    }

    public Money multiply(double val) {
        return this.newMoneyWithSameCurrency(Math.round(CheckOverflow.doubleCheckedMultiply(val, this.cent)));
    }

    public Money multiply(BigDecimal val) {
        return this.multiply(val, 6);
    }

    public Money multiply(BigDecimal val, int roundingMode) {
        BigDecimal newCent = BigDecimal.valueOf(this.cent).multiply(val);
        return this.newMoneyWithSameCurrency(this.rounding(newCent, roundingMode));
    }

    public Money divide(double val) {
        return this.divide(new BigDecimal(val));
    }

    public Money divide(BigDecimal val) {
        return this.divide(val, 6);
    }

    public Money divide(BigDecimal val, int roundingMode) {
        BigDecimal newCent = BigDecimal.valueOf(this.cent).divide(val, roundingMode);
        return this.newMoneyWithSameCurrency(CheckOverflow.bigDecimalChecked(newCent));
    }

    @Override
    public String toString() {
        return "Money [cent=" + this.cent + ", currency=" + this.currency + "]";
    }

    public void setCent(long l) {
        this.cent = l;
    }

    public void setCurrency(Currency currency) {
        CurrencyEnum supportCurrency = CurrencyEnum.getByCurrencyCode(currency.getCurrencyCode());
        if (null == supportCurrency) {
            throw new RuntimeException();
        } else {
            this.currency = currency;
        }
    }

    public void setCurrencyCode(String currencyCode) {
        this.setCurrency(Currency.getInstance(currencyCode));
    }

    public String getCurrencyCode() {
        return this.currency.getCurrencyCode();
    }

    protected void assertSameCurrencyAs(Money other) {
        if (!this.currency.equals(other.currency)) {
            throw new IllegalArgumentException("Money math currency mismatch.");
        }
    }

    protected long rounding(BigDecimal val, int roundingMode) {
        BigDecimal newVal = val.setScale(0, roundingMode);
        return CheckOverflow.bigDecimalChecked(newVal);
    }

    protected Money newMoneyWithSameCurrency(long cent) {
        Money money = new Money(BigDecimal.ZERO, this.currency);
        money.cent = cent;
        return money;
    }

    public String dump() {
        String lineSeparator = System.getProperty("line.separator");
        StringBuffer sb = new StringBuffer();
        sb.append("cent = ").append(this.cent).append(lineSeparator);
        sb.append("currency = ").append(this.currency);
        return sb.toString();
    }

    public static Money add(Money origin, Money addAmount) {
        if (null == origin) {
            return addAmount;
        }
        if (null == addAmount) {
            return origin;
        }
        return origin.add(addAmount);
    }

    public static Money addContinues(Money origin, Money... addAmounts) {
        return addAmounts.length == 1 ? add(origin, addAmounts[0]) : addContinues(add(origin, addAmounts[0]),
                (Money[]) Arrays.copyOfRange(addAmounts, 1, addAmounts.length));
    }

    public static Money substract(Money origin, Money minusAmount) {
        if (null == origin) {
            if (null == minusAmount) {
                return null;
            } else {
                return new Money(minusAmount.getAmount(), minusAmount.getCurrency()).multiply(-1L);
            }
        }

        if (null == minusAmount) {
            return origin;
        } else {
            return origin.subtract(minusAmount);
        }
    }

    public static Money substractContinues(Money origin, Money... minusAmounts) {
        return minusAmounts.length == 1 ? substract(origin, minusAmounts[0]) : substractContinues(substract(origin, minusAmounts[0]),
                (Money[]) Arrays.copyOfRange(minusAmounts, 1, minusAmounts.length));
    }

    public static int compare(Money left, Money right) {
        Money result = substract(left, right);
        if (null != result && result.getCent() != 0L) {
            return result.getCent() > 0L ? 1 : -1;
        } else {
            return 0;
        }
    }

    public static boolean moneyGreaterThanZero(Money money) {
        return null != money && money.getCent() > 0L;
    }

    public static CurrencyEnum resolveCurrency(Money money) {
        return null == money ? null : CurrencyEnum.getByCurrencyCode(money.getCurrencyCode());
    }

    public static Money findMin(Money left, Money right) {
        if (left != null && right != null) {
            return left.compareTo(right) < 0 ? left.clone() : right.clone();
        } else {
            return null;
        }
    }

}
