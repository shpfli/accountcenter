package pers.hubery.accountcenter.facade.req;

/**
 * 账户查询请求
 *
 * @author hubery
 * @version AccountQueryRequest.java v1.0 2022-03-27 21:21
 */
public class AccountQueryRequest extends AccountCenterBaseRequest {

    /** serialVersionUID */
    private static final long serialVersionUID = -3870264807797043149L;

    /** 账本 */
    private String accountBook;

    /** 账号 */
    private String accountNo;

    /**
     * Getter method for property <tt>accountBook</tt>.
     *
     * @return property value of accountBook
     */
    @Override
    public String getAccountBook() {
        return accountBook;
    }

    /**
     * Setter method for property <tt>accountBook</tt>.
     *
     * @param accountBook value to be assigned to property accountBook
     */
    @Override
    public void setAccountBook(final String accountBook) {
        this.accountBook = accountBook;
    }

    /**
     * Getter method for property <tt>accountNo</tt>.
     *
     * @return property value of accountNo
     */
    public String getAccountNo() {
        return accountNo;
    }

    /**
     * Setter method for property <tt>accountNo</tt>.
     *
     * @param accountNo value to be assigned to property accountNo
     */
    public void setAccountNo(final String accountNo) {
        this.accountNo = accountNo;
    }
}
