package pers.hubery.accountcenter.common.model;

import lombok.experimental.SuperBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import pers.hubery.accountcenter.common.enums.AccountingActionEnum;
import pers.hubery.accountcenter.common.money.Money;

import java.util.Date;

/**
 * accounting command, used to simple accounting
 *
 * @author LiPengfei
 * @version AccountingCommand.java v1.0 2022-03-31 15:15
 */
@SuperBuilder
public class AccountingCommand {

    /** 请求业务流水号，唯一识别一笔业务请求，同一笔业务请求重复调用该值不变，用于业务幂等判断 */
    private String reqBizNo;

    /** 账本，例如：DEPOSIT-活期存款，TIME-DEPOSIT-定期存款，LOAN-贷款，…… */
    private String accountBook;

    /** 账号 */
    private String accountNo;

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

    /** 交易金额 */
    private Money amount;

    /** 交易流水号，用于关联同一笔交易的借贷双方或多方，同一个交易流水号下的交易应该借贷平衡 */
    private String referenceNo;

    /** memo */
    private String memo;

    /** 余额变动动作：IN,OUT,FREEZE,UNFREEZE */
    private AccountingActionEnum action;

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

    /** 账务受理时间，请求到达后落库时间 */
    private Date createTime;

    /**
     * Getter method for property <tt>createTime</tt>.
     *
     * @return property value of createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * Setter method for property <tt>createTime</tt>.
     *
     * @param createTime value to be assigned to property createTime
     */
    public void setCreateTime(final Date createTime) {
        this.createTime = createTime;
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
     * @return a string representation of the object
     * @see Object#toString()
     */
    @Override
    public String toString() {

        return ReflectionToStringBuilder.toString(this, ToStringStyle.SIMPLE_STYLE);
    }
}
