package pers.hubery.accountcenter.common.model;

import lombok.Builder;
import pers.hubery.accountcenter.common.enums.TccTransactionStatusEnum;

/**
 * TCC main transaction
 *
 * @author LiPengfei
 * @version MainTransaction.java v1.0 2022-03-30 18:34
 */
@Builder
public class MainTransaction {

    /** TCC事务 ID */
    private String xid;

    /**
     * account book, such as : deposit, loan, ……
     */
    private String accountBook;

    /**
     * 事务状态：P-预处理，R-已回滚，C-已提交
     */
    private TccTransactionStatusEnum status;

    /**
     * Getter method for property <tt>xid</tt>.
     *
     * @return property value of xid
     */
    public String getXid() {
        return xid;
    }

    /**
     * Setter method for property <tt>xid</tt>.
     *
     * @param xid value to be assigned to property xid
     */
    public void setXid(final String xid) {
        this.xid = xid;
    }

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

    /**
     * Getter method for property <tt>status</tt>.
     *
     * @return property value of status
     */
    public TccTransactionStatusEnum getStatus() {
        return status;
    }

    /**
     * Setter method for property <tt>status</tt>.
     *
     * @param status value to be assigned to property status
     */
    public void setStatus(final TccTransactionStatusEnum status) {
        this.status = status;
    }
}
