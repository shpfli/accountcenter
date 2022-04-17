package pers.hubery.accountcenter.common.money;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 数值类型为 Long 类型的计算器，即计算结果超过 Long 类型的计算结果，则会抛出异常
 *
 * @author hubery
 * @version LongCalculator.java v1.0 2022-04-17 17:35
 */
public class LongCalculator {

    /**
     * long 类型数值相加
     *
     * @param x long 类型数值
     * @param y long 类型数值
     * @return x + y
     */
    public static long add(long x, long y) {
        return Math.addExact(x, y);
    }

    /**
     * long 类型数值相减
     *
     * @param x long 类型数值
     * @param y long 类型数值
     * @return x - y
     */
    public static long subtract(long x, long y) {
        return Math.subtractExact(x, y);
    }

    /**
     * long 类型数值相乘
     *
     * @param x long 类型数值
     * @param y long 类型数值
     * @return x * y
     */
    public static long multiply(final long x, final long y) {
        return Math.multiplyExact(x, y);
    }

    /**
     * 乘法运算
     *
     * @param x long 类型数值
     * @param y double 类型数值
     * @return Math.round(x * y)
     */
    public static long multiply(final long x, final double y) {

        double result = y * (double) x;

        if (result > Long.MAX_VALUE || result < Long.MIN_VALUE) {
            throw new ArithmeticException("overflow");
        }

        return Math.round(result);
    }

    /**
     * 以指定的 roundingMode 转化给定的 BigDecimal 为 long 类型
     *
     * @param val          BigDecimal 类型数值
     * @param roundingMode roundingMode
     * @return long 类型数值
     */
    public static long round(BigDecimal val, RoundingMode roundingMode) {
        BigDecimal newVal = val.setScale(0, roundingMode);
        return newVal.longValueExact();
    }

}
