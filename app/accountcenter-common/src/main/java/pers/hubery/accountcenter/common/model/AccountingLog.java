package pers.hubery.accountcenter.common.model;

import lombok.Builder;
import pers.hubery.accountcenter.common.money.Money;

import java.util.Date;

/**
 * accounting record
 *
 * @author LiPengfei
 * @version AccountingLog.java v1.0 2022-04-10 22:49
 */
@Builder
public class AccountingLog {

    /**
     * record no used to identify the record all through the bank
     */
    private String recordNo;

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
     * account date
     */
    private String accountDate;

    /**
     * the timestamp of the business happened
     */
    private Date businessTimestamp;

    /**
     * changed amount
     */
    private Money changedAmount;

    /**
     * balance after this transaction
     */
    private Money balance;

    /**
     * the instruction number, same as req_biz_no
     */
    private String instructionNo;

    /**
     * transaction reference number
     */
    private String referenceNo;

    /**
     * the memo
     */
    private String memo;

    /**
     * channel
     */
    private String channel;

    /**
     * src channel
     */
    private String srcChannel;

    /**
     * src channel biz no
     */
    private String srcChannelBizNo;

    /**
     * operator
     */
    private String operator;

    /**
     * authUserId
     */
    private String authUserId;

    /**
     * fromAppName
     */
    private String fromAppName;

    /**
     * create timestamp
     */
    private Date createTimestamp;

    /**
     * update timestamp
     */
    private Date updateTimestamp;

    /**
     * Getter method for property <tt>recordNo</tt>.
     *
     * @return property value of recordNo
     */
    public String getRecordNo() {
        return recordNo;
    }

    /**
     * Setter method for property <tt>recordNo</tt>.
     *
     * @param recordNo value to be assigned to property recordNo
     */
    public void setRecordNo(final String recordNo) {
        this.recordNo = recordNo;
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
     * Getter method for property <tt>accountDate</tt>.
     *
     * @return property value of accountDate
     */
    public String getAccountDate() {
        return accountDate;
    }

    /**
     * Setter method for property <tt>accountDate</tt>.
     *
     * @param accountDate value to be assigned to property accountDate
     */
    public void setAccountDate(final String accountDate) {
        this.accountDate = accountDate;
    }

    /**
     * Getter method for property <tt>businessTimestamp</tt>.
     *
     * @return property value of businessTimestamp
     */
    public Date getBusinessTimestamp() {
        return businessTimestamp;
    }

    /**
     * Setter method for property <tt>businessTimestamp</tt>.
     *
     * @param businessTimestamp value to be assigned to property businessTimestamp
     */
    public void setBusinessTimestamp(final Date businessTimestamp) {
        this.businessTimestamp = businessTimestamp;
    }

    /**
     * Getter method for property <tt>changedAmount</tt>.
     *
     * @return property value of changedAmount
     */
    public Money getChangedAmount() {
        return changedAmount;
    }

    /**
     * Setter method for property <tt>changedAmount</tt>.
     *
     * @param changedAmount value to be assigned to property changedAmount
     */
    public void setChangedAmount(final Money changedAmount) {
        this.changedAmount = changedAmount;
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
     * Getter method for property <tt>instructionNo</tt>.
     *
     * @return property value of instructionNo
     */
    public String getInstructionNo() {
        return instructionNo;
    }

    /**
     * Setter method for property <tt>instructionNo</tt>.
     *
     * @param instructionNo value to be assigned to property instructionNo
     */
    public void setInstructionNo(final String instructionNo) {
        this.instructionNo = instructionNo;
    }

    /**
     * Getter method for property <tt>referenceNo</tt>.
     *
     * @return property value of referenceNo
     */
    public String getReferenceNo() {
        return referenceNo;
    }

    /**
     * Setter method for property <tt>referenceNo</tt>.
     *
     * @param referenceNo value to be assigned to property referenceNo
     */
    public void setReferenceNo(final String referenceNo) {
        this.referenceNo = referenceNo;
    }

    /**
     * Getter method for property <tt>memo</tt>.
     *
     * @return property value of memo
     */
    public String getMemo() {
        return memo;
    }

    /**
     * Setter method for property <tt>memo</tt>.
     *
     * @param memo value to be assigned to property memo
     */
    public void setMemo(final String memo) {
        this.memo = memo;
    }

    /**
     * Getter method for property <tt>channel</tt>.
     *
     * @return property value of channel
     */
    public String getChannel() {
        return channel;
    }

    /**
     * Setter method for property <tt>channel</tt>.
     *
     * @param channel value to be assigned to property channel
     */
    public void setChannel(final String channel) {
        this.channel = channel;
    }

    /**
     * Getter method for property <tt>srcChannel</tt>.
     *
     * @return property value of srcChannel
     */
    public String getSrcChannel() {
        return srcChannel;
    }

    /**
     * Setter method for property <tt>srcChannel</tt>.
     *
     * @param srcChannel value to be assigned to property srcChannel
     */
    public void setSrcChannel(final String srcChannel) {
        this.srcChannel = srcChannel;
    }

    /**
     * Getter method for property <tt>srcChannelBizNo</tt>.
     *
     * @return property value of srcChannelBizNo
     */
    public String getSrcChannelBizNo() {
        return srcChannelBizNo;
    }

    /**
     * Setter method for property <tt>srcChannelBizNo</tt>.
     *
     * @param srcChannelBizNo value to be assigned to property srcChannelBizNo
     */
    public void setSrcChannelBizNo(final String srcChannelBizNo) {
        this.srcChannelBizNo = srcChannelBizNo;
    }

    /**
     * Getter method for property <tt>operator</tt>.
     *
     * @return property value of operator
     */
    public String getOperator() {
        return operator;
    }

    /**
     * Setter method for property <tt>operator</tt>.
     *
     * @param operator value to be assigned to property operator
     */
    public void setOperator(final String operator) {
        this.operator = operator;
    }

    /**
     * Getter method for property <tt>authUserId</tt>.
     *
     * @return property value of authUserId
     */
    public String getAuthUserId() {
        return authUserId;
    }

    /**
     * Setter method for property <tt>authUserId</tt>.
     *
     * @param authUserId value to be assigned to property authUserId
     */
    public void setAuthUserId(final String authUserId) {
        this.authUserId = authUserId;
    }

    /**
     * Getter method for property <tt>fromAppName</tt>.
     *
     * @return property value of fromAppName
     */
    public String getFromAppName() {
        return fromAppName;
    }

    /**
     * Setter method for property <tt>fromAppName</tt>.
     *
     * @param fromAppName value to be assigned to property fromAppName
     */
    public void setFromAppName(final String fromAppName) {
        this.fromAppName = fromAppName;
    }

    /**
     * Getter method for property <tt>createTimestamp</tt>.
     *
     * @return property value of createTimestamp
     */
    public Date getCreateTimestamp() {
        return createTimestamp;
    }

    /**
     * Setter method for property <tt>createTimestamp</tt>.
     *
     * @param createTimestamp value to be assigned to property createTimestamp
     */
    public void setCreateTimestamp(final Date createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    /**
     * Getter method for property <tt>updateTimestamp</tt>.
     *
     * @return property value of updateTimestamp
     */
    public Date getUpdateTimestamp() {
        return updateTimestamp;
    }

    /**
     * Setter method for property <tt>updateTimestamp</tt>.
     *
     * @param updateTimestamp value to be assigned to property updateTimestamp
     */
    public void setUpdateTimestamp(final Date updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
    }
}
