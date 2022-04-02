package pers.hubery.accountcenter.common.money;

import java.math.BigDecimal;

/**
 * 检查金额溢出
 *
 * @author Hubery
 * @version CheckOverflow.java v1.0 2022-03-29 18:34
 */
public class CheckOverflow {

    // Long最大值:9223372036854775807
    static final BigDecimal MAX_LONG = new BigDecimal(Long.MAX_VALUE);

    // Long最小值:-9223372036854775808
    static final BigDecimal MIN_LONG = new BigDecimal(Long.MIN_VALUE);

    public CheckOverflow() {
    }

    private static void checkNoOverflow(boolean b) {
        if (!b) {
            throw new ArithmeticException("overflow");
        }
    }

    public static long bigDecimalChecked(BigDecimal a) {
        if (a.compareTo(MAX_LONG) > 0 || a.compareTo(MIN_LONG) < 0) {
            checkNoOverflow(false);
        }

        long result = a.longValue();
        return result;
    }

    public static double doubleCheckedMultiply(double a, long cent) {
        double result = a * (double) cent;
        if (result > 9.223372036854776E18D || result < -9.223372036854776E18D) {
            checkNoOverflow(false);
        }

        return result;
    }

    public static int intCheckedAdd(int a, int b) {
        long result = (long) a + (long) b;
        checkNoOverflow(result == (long) ((int) result));
        return (int) result;
    }

    public static int intCheckedSubtract(int a, int b) {
        long result = (long) a - (long) b;
        checkNoOverflow(result == (long) ((int) result));
        return (int) result;
    }

    public static int intCheckedMultiply(int a, int b) {
        long result = (long) a * (long) b;
        checkNoOverflow(result == (long) ((int) result));
        return (int) result;
    }

    public static long longCheckedAdd(long a, long b) {
        long result = a + b;
        checkNoOverflow((a ^ b) < 0L | (a ^ result) >= 0L);
        return result;
    }

    public static long longCheckedSubtract(long a, long b) {
        long result = a - b;
        checkNoOverflow((a ^ b) >= 0L | (a ^ result) >= 0L);
        return result;
    }

    public static long longCheckedMultiply(long a, long b) {
        int leadingZeros = Long.numberOfLeadingZeros(a) + Long.numberOfLeadingZeros(~a) + Long.numberOfLeadingZeros(b)
                + Long.numberOfLeadingZeros(~b);
        if (leadingZeros > 65) {
            return a * b;
        } else {
            checkNoOverflow(leadingZeros >= 64);
            checkNoOverflow(a >= 0L | b != -9223372036854775808L);
            long result = a * b;
            checkNoOverflow(a == 0L || result / a == b);
            return result;
        }
    }
}
