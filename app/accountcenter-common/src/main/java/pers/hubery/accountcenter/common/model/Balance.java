package pers.hubery.accountcenter.common.model;

import lombok.Builder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import pers.hubery.accountcenter.common.money.Money;

import java.util.Date;

/**
 * account balance
 *
 * @author LiPengfei
 * @version Balance.java v1.0 2022-03-30 22:02
 */
@Builder
public class Balance {

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
     * balance
     */
    private Money balance;

    /**
     * balance of the previous day
     */
    private Money prevBalance;

    /**
     * unreached amount
     */
    private Money unreachedAmt;

    /**
     * unreached amount
     */
    private Money reserveAmt;

    /**
     * frozen amount
     */
    private Money frozenAmt;

    /**
     * overdraft limit
     */
    private Money overdraftLimit;

    /**
     * the account date of balance last changed
     */
    private String balanceLastChangeDate;

    /**
     * the timestamp of balance last changed
     */
    private Date balanceLastChangeTimestamp;

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
     * Getter method for property <tt>balance</tt>.
     *
     * @return property value of balance
     */
    public Money getBalance() {
        return balance;
    }

    /**
     * Setter method for property <tt>balance</tt>.
     *
     * @param balance value to be assigned to property balance
     */
    public void setBalance(final Money balance) {
        this.balance = balance;
    }

    /**
     * Getter method for property <tt>prevBalance</tt>.
     *
     * @return property value of prevBalance
     */
    public Money getPrevBalance() {
        return prevBalance;
    }

    /**
     * Setter method for property <tt>prevBalance</tt>.
     *
     * @param prevBalance value to be assigned to property prevBalance
     */
    public void setPrevBalance(final Money prevBalance) {
        this.prevBalance = prevBalance;
    }

    /**
     * Getter method for property <tt>unreachedAmt</tt>.
     *
     * @return property value of unreachedAmt
     */
    public Money getUnreachedAmt() {
        return unreachedAmt;
    }

    /**
     * Setter method for property <tt>unreachedAmt</tt>.
     *
     * @param unreachedAmt value to be assigned to property unreachedAmt
     */
    public void setUnreachedAmt(final Money unreachedAmt) {
        this.unreachedAmt = unreachedAmt;
    }

    /**
     * Getter method for property <tt>reserveAmt</tt>.
     *
     * @return property value of reserveAmt
     */
    public Money getReserveAmt() {
        return reserveAmt;
    }

    /**
     * Setter method for property <tt>reserveAmt</tt>.
     *
     * @param reserveAmt value to be assigned to property reserveAmt
     */
    public void setReserveAmt(final Money reserveAmt) {
        this.reserveAmt = reserveAmt;
    }

    /**
     * Getter method for property <tt>frozenAmt</tt>.
     *
     * @return property value of frozenAmt
     */
    public Money getFrozenAmt() {
        return frozenAmt;
    }

    /**
     * Setter method for property <tt>frozenAmt</tt>.
     *
     * @param frozenAmt value to be assigned to property frozenAmt
     */
    public void setFrozenAmt(final Money frozenAmt) {
        this.frozenAmt = frozenAmt;
    }

    /**
     * Getter method for property <tt>overdraftLimit</tt>.
     *
     * @return property value of overdraftLimit
     */
    public Money getOverdraftLimit() {
        return overdraftLimit;
    }

    /**
     * Setter method for property <tt>overdraftLimit</tt>.
     *
     * @param overdraftLimit value to be assigned to property overdraftLimit
     */
    public void setOverdraftLimit(final Money overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    /**
     * Getter method for property <tt>balanceLastChangeDate</tt>.
     *
     * @return property value of balanceLastChangeDate
     */
    public String getBalanceLastChangeDate() {
        return balanceLastChangeDate;
    }

    /**
     * Setter method for property <tt>balanceLastChangeDate</tt>.
     *
     * @param balanceLastChangeDate value to be assigned to property balanceLastChangeDate
     */
    public void setBalanceLastChangeDate(final String balanceLastChangeDate) {
        this.balanceLastChangeDate = balanceLastChangeDate;
    }

    /**
     * Getter method for property <tt>balanceLastChangeTimestamp</tt>.
     *
     * @return property value of balanceLastChangeTimestamp
     */
    public Date getBalanceLastChangeTimestamp() {
        return balanceLastChangeTimestamp;
    }

    /**
     * Setter method for property <tt>balanceLastChangeTimestamp</tt>.
     *
     * @param balanceLastChangeTimestamp value to be assigned to property balanceLastChangeTimestamp
     */
    public void setBalanceLastChangeTimestamp(final Date balanceLastChangeTimestamp) {
        this.balanceLastChangeTimestamp = balanceLastChangeTimestamp;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {return true;}

        if (!(o instanceof Balance)) {return false;}

        final Balance balance1 = (Balance) o;

        return new EqualsBuilder().append(getAccountBook(), balance1.getAccountBook()).append(getAcctNo(),
                        balance1.getAcctNo()).append(getBalanceType(), balance1.getBalanceType()).append(getBalance(),
                        balance1.getBalance())
                .append(
                        getPrevBalance(), balance1.getPrevBalance()).append(getUnreachedAmt(), balance1.getUnreachedAmt()).append(
                        getReserveAmt(),
                        balance1.getReserveAmt()).append(getFrozenAmt(), balance1.getFrozenAmt()).append(getOverdraftLimit(),
                        balance1.getOverdraftLimit()).append(getBalanceLastChangeDate(), balance1.getBalanceLastChangeDate()).append(
                        getBalanceLastChangeTimestamp(), balance1.getBalanceLastChangeTimestamp()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(getAccountBook()).append(getAcctNo()).append(getBalanceType()).append(getBalance())
                .append(
                        getPrevBalance()).append(getUnreachedAmt()).append(getReserveAmt()).append(getFrozenAmt()).append(
                        getOverdraftLimit()).append(
                        getBalanceLastChangeDate()).append(getBalanceLastChangeTimestamp()).toHashCode();
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
