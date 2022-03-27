package pers.hubery.accountcenter.facade.rsp;

/**
 * 查询响应
 *
 * @author hubery
 * @version QueryResponse.java v1.0 2022-03-27 21:35
 */
public class QueryResponse<T> extends BaseResponse {

    /** 查询结果 */
    private T result;

    /**
     * Getter method for property <tt>result</tt>.
     *
     * @return property value of result
     */
    public T getResult() {
        return result;
    }

    /**
     * Setter method for property <tt>result</tt>.
     *
     * @param result value to be assigned to property result
     */
    public void setResult(final T result) {
        this.result = result;
    }
}
