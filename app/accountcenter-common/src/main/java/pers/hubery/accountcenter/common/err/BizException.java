package pers.hubery.accountcenter.common.err;

import pers.hubery.accountcenter.common.enums.ErrorCodeEnum;

/**
 * 业务异常
 *
 * @author hubery
 * @version BizException.java v1.0 2022-03-27 23:36
 */
public class BizException extends BaseException {

    /** serialVersionUID */
    private static final long serialVersionUID = -7356377708193997485L;

    /**
     * Constructs a new runtime exception with {@code null} as its detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     *
     * @param errorCode error code
     */
    public BizException(final ErrorCodeEnum errorCode) {
        super(errorCode);
    }

    /**
     * Constructs a new runtime exception with the specified detail message. The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     *
     * @param errorCode error code
     * @param message   the detail message. The detail message is saved for later retrieval by the {@link #getMessage()} method.
     */
    public BizException(final ErrorCodeEnum errorCode, final String message) {
        super(errorCode, message);
    }

    /**
     * Constructs a new runtime exception with the specified cause and a detail message of <tt>(cause==null ? null : cause.toString())</tt>
     * (which typically contains the class and detail message of
     * <tt>cause</tt>).  This constructor is useful for runtime exceptions
     * that are little more than wrappers for other throwables.
     *
     * @param cause     the cause (which is saved for later retrieval by the {@link #getCause()} method).  (A <tt>null</tt> value is
     *                  permitted, and indicates that the cause is nonexistent or unknown.)
     * @param errorCode error code
     * @since 1.4
     */
    public BizException(final Throwable cause, final ErrorCodeEnum errorCode) {
        super(errorCode, cause);
    }

    /**
     * Constructs a new runtime exception with the specified detail message and cause.  <p>Note that the detail message associated with
     * {@code cause} is <i>not</i> automatically incorporated in this runtime exception's detail message.
     *
     * @param message   the detail message (which is saved for later retrieval by the {@link #getMessage()} method).
     * @param cause     the cause (which is saved for later retrieval by the {@link #getCause()} method).  (A <tt>null</tt> value is
     *                  permitted, and indicates that the cause is nonexistent or unknown.)
     * @param errorCode error code
     * @since 1.4
     */
    public BizException(final String message, final Throwable cause,
                        final ErrorCodeEnum errorCode) {
        super(errorCode, message, cause);
    }
}
