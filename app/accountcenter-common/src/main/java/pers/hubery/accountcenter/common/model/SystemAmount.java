package pers.hubery.accountcenter.common.model;

import lombok.Builder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import pers.hubery.accountcenter.common.money.Money;

/**
 * the VO of system amount
 *
 * @author LiPengfei
 * @version SystemAmount.java v1.0 2022-03-31 17:07
 */
@Builder
public class SystemAmount {

    /**
     * TCC main transaction ID
     */
    private String xid;

    /**
     * account book, such as : deposit, loan, ……
     */
    private String accountBook;

    /**
     * account number
     */
    private String acctNo;

    /**
     * balance type
     */
    private String balanceType;

    /**
     * amount type
     */
    private String amountType;

    /**
     * amount
     */
    private Money amount;

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
     * Getter method for property <tt>acctNo</tt>.
     *
     * @return property value of acctNo
     */
    public String getAcctNo() {
        return acctNo;
    }

    /**
     * Setter method for property <tt>acctNo</tt>.
     *
     * @param acctNo value to be assigned to property acctNo
     */
    public void setAcctNo(final String acctNo) {
        this.acctNo = acctNo;
    }

    /**
     * Getter method for property <tt>balanceType</tt>.
     *
     * @return property value of balanceType
     */
    public String getBalanceType() {
        return balanceType;
    }

    /**
     * Setter method for property <tt>balanceType</tt>.
     *
     * @param balanceType value to be assigned to property balanceType
     */
    public void setBalanceType(final String balanceType) {
        this.balanceType = balanceType;
    }

    /**
     * Getter method for property <tt>amountType</tt>.
     *
     * @return property value of amountType
     */
    public String getAmountType() {
        return amountType;
    }

    /**
     * Setter method for property <tt>amountType</tt>.
     *
     * @param amountType value to be assigned to property amountType
     */
    public void setAmountType(final String amountType) {
        this.amountType = amountType;
    }

    /**
     * Getter method for property <tt>amount</tt>.
     *
     * @return property value of amount
     */
    public Money getAmount() {
        return amount;
    }

    /**
     * Setter method for property <tt>amount</tt>.
     *
     * @param amount value to be assigned to property amount
     */
    public void setAmount(final Money amount) {
        this.amount = amount;
    }

    /**
     * @return a string representation of the object
     * @see Object#toString()
     */
    @Override
    public String toString() {

        return ReflectionToStringBuilder.toString(this, ToStringStyle.SIMPLE_STYLE);
    }
}
