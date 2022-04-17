package pers.hubery.accountcenter.common.model;

import lombok.Builder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import pers.hubery.accountcenter.common.enums.AccountingActionEnum;
import pers.hubery.accountcenter.common.money.Money;

import java.util.Date;

/**
 * TCC branch transaction
 *
 * @TableName tcc_branch_transaction
 */
@Builder
public class BranchTransaction {

    /**
     * TCC main transaction ID
     */
    private String xid;

    /**
     * TCC branch transaction ID
     */
    private Long branchId;

    /**
     * business seq no, used to identify a request in biz sight
     */
    private String reqBizNo;

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
     * action type, such as: IN, OUT, FREEZE, UNFREEZE
     */
    private AccountingActionEnum action;

    /**
     * the amount
     */
    private Money amount;

    /**
     * business reference number
     */
    private String referenceNo;

    /** memo */
    private String memo;

    /** 上游渠道 */
    private String channel;

    /** 发起渠道，如：手机银行->支付->核心，对核心来说支付是上游渠道，手机银行是发起渠道 */
    private String srcChannel;

    /** 发起渠道业务流水号 （全行维度唯一定义一笔业务的流水号） */
    private String srcChannelBizNo;

    /** 操作员 */
    private String operator;

    /** 检查员 */
    private String authUserId;

    /** 请求来源系统名称 */
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
     * Getter method for property <tt>branchId</tt>.
     *
     * @return property value of branchId
     */
    public Long getBranchId() {
        return branchId;
    }

    /**
     * Setter method for property <tt>branchId</tt>.
     *
     * @param branchId value to be assigned to property branchId
     */
    public void setBranchId(final Long branchId) {
        this.branchId = branchId;
    }

    /**
     * Getter method for property <tt>reqBizNo</tt>.
     *
     * @return property value of reqBizNo
     */
    public String getReqBizNo() {
        return reqBizNo;
    }

    /**
     * Setter method for property <tt>reqBizNo</tt>.
     *
     * @param reqBizNo value to be assigned to property reqBizNo
     */
    public void setReqBizNo(final String reqBizNo) {
        this.reqBizNo = reqBizNo;
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
     * Getter method for property <tt>action</tt>.
     *
     * @return property value of action
     */
    public AccountingActionEnum getAction() {
        return action;
    }

    /**
     * Setter method for property <tt>action</tt>.
     *
     * @param action value to be assigned to property action
     */
    public void setAction(final AccountingActionEnum action) {
        this.action = action;
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

    @Override
    public boolean equals(final Object o) {
        if (this == o) {return true;}

        if (!(o instanceof BranchTransaction)) {return false;}

        final BranchTransaction that = (BranchTransaction) o;

        return new EqualsBuilder().append(getXid(), that.getXid())
                .append(getReqBizNo(), that.getReqBizNo()).append(getAccountBook(), that.getAccountBook()).append(getAcctNo(),
                        that.getAcctNo())
                .append(getBalanceType(), that.getBalanceType()).append(getAccountDate(), that.getAccountDate()).append(
                        getBusinessTimestamp(),
                        that.getBusinessTimestamp()).append(getAction(), that.getAction()).append(getAmount(), that.getAmount()).append(
                        getReferenceNo(), that.getReferenceNo()).append(getMemo(), that.getMemo()).append(getChannel(), that.getChannel())
                .append(getSrcChannel(), that.getSrcChannel()).append(getSrcChannelBizNo(), that.getSrcChannelBizNo()).append(getOperator(),
                        that.getOperator()).append(getAuthUserId(), that.getAuthUserId()).append(getFromAppName(), that.getFromAppName())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(getXid()).append(getReqBizNo()).append(getAccountBook()).append(
                getAcctNo()).append(getBalanceType()).append(getAccountDate()).append(getBusinessTimestamp()).append(getAction()).append(
                getAmount()).append(getReferenceNo()).append(getMemo()).append(getChannel()).append(getSrcChannel()).append(
                getSrcChannelBizNo()).append(getOperator()).append(getAuthUserId()).append(getFromAppName()).toHashCode();
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