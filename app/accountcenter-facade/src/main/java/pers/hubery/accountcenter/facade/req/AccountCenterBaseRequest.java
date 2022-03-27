package pers.hubery.accountcenter.facade.req;

/**
 * 账户中心请求基类
 *
 * @author hubery
 * @version AccountCenterBaseRequest.java v1.0 2022-03-27 22:17
 */
public class AccountCenterBaseRequest extends BaseShardingRequest {

    /** serialVersionUID */
    private static final long serialVersionUID = -1596426400876927137L;

    /** 账本 */
    private String accountBook;

    /**
     * Getter method for property <tt>accountBook</tt>.
     *
     * @return property value of accountBook
     */
    public String getAccountBook() {
        return accountBook;
    }

    /**
     * Setter method for property <tt>accountBook</tt>.
     *
     * @param accountBook value to be assigned to property accountBook
     */
    public void setAccountBook(final String accountBook) {
        this.accountBook = accountBook;
    }
}
