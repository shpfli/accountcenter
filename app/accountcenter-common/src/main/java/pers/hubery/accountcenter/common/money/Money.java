package pers.hubery.accountcenter.common.money;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Currency;

/**
 * 金额类型
 * <p>说明：Money类设计为immutable，保证线程安全，以及计算的安全。</p>
 *
 * @author Hubery
 * @version Money.java v1.0 2022-03-29 18:28
 */
public final class Money implements Serializable, Comparable<Money>, Cloneable {

    /** serialVersionUID */
    private static final long serialVersionUID = -8748976332088466314L;

    /** 金额转化为币种最小单位存储 */
    private long cent;

    /** 币种 */
    private Currency currency;

    /**
     * 默认舍入策略：HALF_EVEN。
     * <p>舍入模式向“最近的邻居”舍入，除非两个邻居的距离相等，在这种情况下，向偶数邻居舍入。</p>
     * <p>如果丢弃分数左边的数字是奇数，则表现为ROUND_HALF_UP; 如果它是偶数，则表现为ROUND_HALF_DOWN。</p>
     * 请注意，当对一系列计算重复应用时，这种舍入模式可以使累积误差最小化。
     */
    private static final RoundingMode DEFAULT_ROUNDING_MODE = RoundingMode.HALF_EVEN;

    /**
     * 构造器
     *
     * @param amount       BigDecimal 类型的金额数值，单位为主币单位元
     * @param currencyCode 币种 code，例如：CNY
     */
    public Money(BigDecimal amount, String currencyCode) {
        this.setCurrencyCode(currencyCode);
        this.cent = LongCalculator.round(amount.movePointRight(this.currency.getDefaultFractionDigits()), DEFAULT_ROUNDING_MODE);
    }


    /**
     * 构造器
     *
     * @param amount       long类型金额
     * @param currencyCode 币种 code，例如：CNY
     */
    public Money(long amount, String currencyCode) {
        this.setCurrencyCode(currencyCode);
        this.cent = amount;
    }

    /**
     * 构造器
     *
     * @param amount       BigDecimal 类型的金额数值，单位为主币单位元
     * @param currencyEnum 币种枚举
     */
    public Money(BigDecimal amount, CurrencyEnum currencyEnum) {
        this(amount, currencyEnum.getCurrencyCode());
    }

    /**
     * 构造器
     *
     * @param amount   BigDecimal 类型的金额数值，单位为主币单位元
     * @param currency 币种实例
     */
    public Money(BigDecimal amount, Currency currency) {
        this(amount, currency, DEFAULT_ROUNDING_MODE);
    }

    /**
     * 构造器
     *
     * @param amount       BigDecimal 类型的金额数值，单位为主币单位元
     * @param currency     币种实例
     * @param roundingMode 舍入模式
     */
    public Money(BigDecimal amount, Currency currency, RoundingMode roundingMode) {
        this.setCurrency(currency);
        this.cent = LongCalculator.round(amount.movePointRight(currency.getDefaultFractionDigits()), roundingMode);
    }


    /**
     * 以指定 cent 创建相同币种的 Money 对象
     *
     * @param cent 指定的 cent
     * @return 新的 Money 对象
     */
    private Money newMoneyWithSameCurrency(long cent) {
        Money money = new Money(BigDecimal.ZERO, this.currency);
        money.cent = cent;
        return money;
    }

    /**
     * 判断指定 Money 的数值是否不小于0
     *
     * @return this.cent >= 0返回true，否则 false
     */
    public boolean noLessThanZero() {
        return this.getCent() >= 0L;
    }

    /**
     * 判断指定 Money 的数值是否正数（大于0）
     *
     * @return 为正返回true，否则 false
     */
    public boolean isPositive() {
        return this.getCent() > 0L;
    }

    /**
     * 判断指定 Money 的数值是否负数（小于0）
     *
     * @return 为负返回true，否则 false
     */
    public boolean isNegative() {
        return this.getCent() < 0L;
    }

    /**
     * 是否比指定的金额大
     *
     * @param other 比较对象
     * @return 自身更大返回 true ；否则 false
     */
    public boolean greaterThan(Money other) {
        return this.compareTo(other) > 0;
    }

    /**
     * Compares this object with the specified object for order.  Returns a negative integer, zero, or a positive integer as this object is
     * less than, equal to, or greater than the specified object.
     *
     * <p>The implementor must ensure <tt>sgn(x.compareTo(y)) ==
     * -sgn(y.compareTo(x))</tt> for all <tt>x</tt> and <tt>y</tt>.  (This implies that <tt>x.compareTo(y)</tt> must throw an exception iff
     * <tt>y.compareTo(x)</tt> throws an exception.)
     *
     * <p>The implementor must also ensure that the relation is transitive:
     * <tt>(x.compareTo(y)&gt;0 &amp;&amp; y.compareTo(z)&gt;0)</tt> implies
     * <tt>x.compareTo(z)&gt;0</tt>.
     *
     * <p>Finally, the implementor must ensure that <tt>x.compareTo(y)==0</tt>
     * implies that <tt>sgn(x.compareTo(z)) == sgn(y.compareTo(z))</tt>, for all <tt>z</tt>.
     *
     * <p>It is strongly recommended, but <i>not</i> strictly required that
     * <tt>(x.compareTo(y)==0) == (x.equals(y))</tt>.  Generally speaking, any
     * class that implements the <tt>Comparable</tt> interface and violates this condition should clearly indicate this fact.  The
     * recommended language is "Note: this class has a natural ordering that is inconsistent with equals."
     *
     * <p>In the foregoing description, the notation
     * <tt>sgn(</tt><i>expression</i><tt>)</tt> designates the mathematical
     * <i>signum</i> function, which is defined to return one of <tt>-1</tt>,
     * <tt>0</tt>, or <tt>1</tt> according to whether the value of
     * <i>expression</i> is negative, zero or positive.
     *
     * @param other the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it from being compared to this object.
     */
    @Override
    public int compareTo(final Money other) {

        this.assertSameCurrencyAs(other);

        return Long.compare(this.cent, other.cent);
    }

    /**
     * 金额相加，返回新的 Money 对象
     * <p>双方币种必须相同</p>
     *
     * @param other 要加的 Money 对象
     * @return 新的 Money 对象，其数值等于之前的两个 Money 数值之和
     */
    public Money add(Money other) {
        this.assertSameCurrencyAs(other);
        return this.newMoneyWithSameCurrency(LongCalculator.add(this.cent, other.cent));
    }

    /**
     * 金额减去指定的Money的数值
     * <p>双方币种必须相同</p>
     *
     * @param other 要减的 Money 对象
     * @return 新的 Money 对象，其数值等于之前this的数值减去指定的Money的数值
     */
    public Money subtract(Money other) {
        this.assertSameCurrencyAs(other);
        return this.newMoneyWithSameCurrency(LongCalculator.subtract(this.cent, other.cent));
    }

    /**
     * 金额乘以指定的数值
     *
     * @param val long 类型数值
     * @return 新的 Money 对象，其数值等于之前this的数值乘以指定的数值
     */
    public Money multiply(long val) {
        return this.newMoneyWithSameCurrency(LongCalculator.multiply(this.cent, val));
    }

    /**
     * 金额乘以指定的数值
     *
     * @param val double 类型数值
     * @return 新的 Money 对象，其数值等于之前this的数值乘以指定的数值(Math.round(this.cent * val))
     */
    public Money multiply(double val) {

        return this.newMoneyWithSameCurrency(LongCalculator.multiply(this.cent, val));
    }

    /**
     * 金额乘以指定数值，采用默认舍入方式
     *
     * @param val 乘数
     * @return 新的 Money 对象
     */
    public Money multiply(BigDecimal val) {
        return this.multiply(val, DEFAULT_ROUNDING_MODE);
    }

    /**
     * 金额乘以指定数值，采用指定舍入方式
     *
     * @param val          乘数
     * @param roundingMode 舍入方式
     * @return 新的 Money 对象
     */
    public Money multiply(BigDecimal val, RoundingMode roundingMode) {

        BigDecimal newCent = BigDecimal.valueOf(this.cent).multiply(val);

        return this.newMoneyWithSameCurrency(LongCalculator.round(newCent, roundingMode));
    }

    /**
     * 金额除以指定数值
     *
     * @param val 指定 double 类型数值
     * @return 新的 Money 对象
     */
    public Money divide(double val) {
        return this.divide(new BigDecimal(val));
    }

    /**
     * 金额除以指定数值，采用默认的 RoundingMode
     *
     * @param val 指定 BigDecimal 类型数值
     * @return 新的 Money 对象
     */
    public Money divide(BigDecimal val) {
        return this.divide(val, DEFAULT_ROUNDING_MODE);
    }

    /**
     * 金额除以指定数值，采用指定的 RoundingMode
     *
     * @param val          指定 BigDecimal 类型数值
     * @param roundingMode 指定的 RoundingMode
     * @return 新的 Money 对象
     */
    public Money divide(BigDecimal val, RoundingMode roundingMode) {
        BigDecimal newCent = BigDecimal.valueOf(this.cent).divide(val, roundingMode);
        return this.newMoneyWithSameCurrency(newCent.longValueExact());
    }

    /**
     * Money 相加
     *
     * @param origin    被加数
     * @param addAmount 加数
     * @return 相加后的新 Money 对象
     */
    public static Money add(Money origin, Money addAmount) {

        if (origin == null) {
            if (addAmount == null) {
                return null;
            } else {
                return addAmount.clone();
            }
        }

        if (addAmount == null) {

            return origin.clone();
        } else {
            return origin.add(addAmount);
        }

    }

    /**
     * Money 连续相加
     *
     * @param origin     被加数
     * @param addAmounts 加数
     * @return 相加后的新 Money 对象
     */
    public static Money addContinues(Money origin, Money... addAmounts) {
        return addAmounts.length == 1 ?
                add(origin, addAmounts[0])
                : addContinues(add(origin, addAmounts[0]), Arrays.copyOfRange(addAmounts, 1, addAmounts.length));
    }

    /**
     * Money 相减
     *
     * @param origin      被减数
     * @param minusAmount 减数
     * @return 计算后的新 Money 对象
     */
    public static Money subtract(Money origin, Money minusAmount) {

        if (null == origin) {
            if (null == minusAmount) {
                return null;
            } else {
                return minusAmount.multiply(-1L);
            }
        }

        if (null == minusAmount) {
            return origin.clone();
        } else {
            return origin.subtract(minusAmount);
        }
    }

    /**
     * Money 连续相减
     *
     * @param origin       被减数
     * @param minusAmounts 减数
     * @return 计算后的新 Money 对象
     */
    public static Money subtractContinues(Money origin, Money... minusAmounts) {
        return minusAmounts.length == 1 ?
                subtract(origin, minusAmounts[0])
                : subtractContinues(subtract(origin, minusAmounts[0]), Arrays.copyOfRange(minusAmounts, 1, minusAmounts.length));
    }

    /**
     * 取最小值
     *
     * @param x 待比较的 Money 对象
     * @param y 待比较的 Money 对象
     * @return 新 Money 对象，其值等于两者中最小的值
     */
    public static Money min(Money x, Money y) {
        if (x != null && y != null) {
            return x.compareTo(y) < 0 ? x.clone() : y.clone();
        } else {
            return null;
        }
    }

    /**
     * 断言指定对象的币种与自身相同，否则抛出IllegalArgumentException
     *
     * @param other 判断对象
     * @throws IllegalArgumentException 币种不匹配时抛出该异常
     */
    private void assertSameCurrencyAs(Money other) {
        if (!this.currency.equals(other.currency)) {
            throw new IllegalArgumentException("Money math currency mismatch.");
        }
    }

    /**
     * get 金额数值
     *
     * @return BigDecimal 类型的金额数值，单位为主币单位元
     */
    public BigDecimal getAmount() {
        return BigDecimal.valueOf(this.cent, this.currency.getDefaultFractionDigits());
    }

    /**
     * 获取 Money 对象的 cent 值
     *
     * @return cent 的数值
     */
    public long getCent() {
        return cent;
    }

    /**
     * 获取金额币种
     *
     * @return 币种
     */
    public Currency getCurrency() {
        return this.currency;
    }

    /**
     * 获取币种 code
     *
     * @return 币种 code
     */
    public String getCurrencyCode() {
        return this.currency.getCurrencyCode();
    }

    /**
     * 获取该金额的币种枚举
     *
     * @return 币种枚举类型
     */
    public CurrencyEnum getCurrencyEnum() {
        return CurrencyEnum.getByCurrencyCode(this.getCurrencyCode());
    }

    /**
     * 设置币种
     *
     * @param currency 币种实例
     */
    private void setCurrency(Currency currency) {

        CurrencyEnum supportCurrency = CurrencyEnum.getByCurrencyCode(currency.getCurrencyCode());

        if (null == supportCurrency) {
            throw new UnsupportedOperationException("暂不支持该币种：" + currency.getCurrencyCode());
        } else {
            this.currency = currency;
        }
    }

    /**
     * 设置币种
     *
     * @param currencyCode 币种 code
     */
    private void setCurrencyCode(String currencyCode) {
        this.setCurrency(Currency.getInstance(currencyCode));
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

    /**
     * clone a new Money with the same cent and currency
     *
     * @return 新的 Money 对象
     */
    @Override
    public Money clone() {
        return new Money(this.getAmount(), this.getCurrency());
    }

    /**
     * returns a string representation of the object.
     *
     * @return a string representation of the object.
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return "Money [cent=" + this.cent + ", currency=" + this.currency + "]";
    }
}
