package pers.hubery.accountcenter.common.err;

import org.apache.commons.lang3.StringUtils;
import pers.hubery.accountcenter.common.enums.ErrorCodeEnum;

/**
 * 异常基类
 *
 * @author hubery
 * @version BaseException.java v1.0 2022-03-27 22:31
 */
public class BaseException extends RuntimeException {

    /** serialVersionUID */
    private static final long serialVersionUID = 7950011854962586719L;

    /** 错误码 */
    private final ErrorCodeEnum errorCode;

    /**
     * Constructs a new runtime exception with {@code null} as its detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     */
    public BaseException(final ErrorCodeEnum errorCode) {
        super(errorCode.getDefaultMessage());
        this.errorCode = errorCode;
    }

    /**
     * Constructs a new runtime exception with the specified detail message. The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     *
     * @param errorCode error code
     * @param message   the detail message. The detail message is saved for later retrieval by the {@link #getMessage()} method.
     */
    public BaseException(final ErrorCodeEnum errorCode, final String message) {
        super(StringUtils.isBlank(message) ? errorCode.getDefaultMessage() : message);
        this.errorCode = errorCode;
    }

    /**
     * Constructs a new runtime exception with the specified cause and a detail message of <tt>(cause==null ? null : cause.toString())</tt>
     * (which typically contains the class and detail message of
     * <tt>cause</tt>).  This constructor is useful for runtime exceptions
     * that are little more than wrappers for other throwables.
     *
     * @param errorCode error code
     * @param cause     the cause (which is saved for later retrieval by the {@link #getCause()} method).  (A <tt>null</tt> value is
     *                  permitted, and indicates that the cause is nonexistent or unknown.)
     * @since 1.4
     */
    public BaseException(final ErrorCodeEnum errorCode, final Throwable cause) {
        super(errorCode.getDefaultMessage(), cause);
        this.errorCode = errorCode;
    }

    /**
     * Constructs a new runtime exception with the specified detail message and cause.  <p>Note that the detail message associated with
     * {@code cause} is <i>not</i> automatically incorporated in this runtime exception's detail message.
     *
     * @param errorCode error code
     * @param message   the detail message (which is saved for later retrieval by the {@link #getMessage()} method).
     * @param cause     the cause (which is saved for later retrieval by the {@link #getCause()} method).  (A <tt>null</tt> value is
     *                  permitted, and indicates that the cause is nonexistent or unknown.)
     * @since 1.4
     */
    public BaseException(final ErrorCodeEnum errorCode, final String message, final Throwable cause) {
        super(StringUtils.isBlank(message) ? errorCode.getDefaultMessage() : message, cause);
        this.errorCode = errorCode;
    }

    /**
     * Getter method for property <tt>errorCode</tt>.
     *
     * @return property value of errorCode
     */
    public ErrorCodeEnum getErrorCode() {
        return errorCode;
    }
}
