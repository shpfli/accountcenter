package pers.hubery.accountcenter.common.util;

import org.apache.commons.lang3.StringUtils;
import pers.hubery.accountcenter.common.enums.ErrorCodeEnum;
import pers.hubery.accountcenter.common.err.InvalidParamException;

/**
 * Asserter
 *
 * @author hubery
 * @version Asserter.java v1.0 2022-03-27 22:22
 */
public class Asserter {
    /**
     * 断言对象非空
     *
     * @param param     目标参数
     * @param errorCode 错误码
     */
    public static void assertNotNull(Object param, ErrorCodeEnum errorCode) {

        if (param == null) {
            throw new InvalidParamException(errorCode);
        }
    }

    /**
     * 断言对象非空
     *
     * @param param     目标参数
     * @param errorCode 错误码
     * @param message   错误信息
     */
    public static void assertNotNull(Object param, ErrorCodeEnum errorCode, String message) {

        if (param == null) {
            throw new InvalidParamException(errorCode, message);
        }
    }

    /**
     * 断言字符串非空
     *
     * @param param     目标参数
     * @param errorCode 错误码
     */
    public static void assertNotBlank(String param, ErrorCodeEnum errorCode) {

        if (StringUtils.isBlank(param)) {
            throw new InvalidParamException(errorCode);
        }
    }

    /**
     * 断言字符串非空
     *
     * @param param     目标参数
     * @param errorCode 错误码
     * @param message   错误信息
     */
    public static void assertNotBlank(String param, ErrorCodeEnum errorCode, String message) {

        if (StringUtils.isBlank(param)) {
            throw new InvalidParamException(errorCode, message);
        }
    }
}
