package pers.hubery.accountcenter.facade.req;

import io.seata.rm.tcc.api.BusinessActionContextParameter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import pers.hubery.accountcenter.common.money.Money;

import java.util.Date;

import static pers.hubery.accountcenter.facade.constant.FacadeConstant.PARAM_NAME_ACCOUNT_BOOK;
import static pers.hubery.accountcenter.facade.constant.FacadeConstant.PARAM_NAME_SHARDING_INDEX;

/**
 * 转账具体信息，包括涉及账户号、转账金额, 根据接口规范统一继承BaseRequest
 *
 * @author hubery
 * @version AccountingRequest.java v1.0 2022-03-13 11:39 PM
 */
public class AccountingRequest extends AccountCenterBaseRequest {

    /** action means : flow in */
    protected static final String ACTION_IN = "IN";

    /** action means : flow out */
    protected static final String ACTION_OUT = "OUT";

    /** 数据分片索引 */
    @BusinessActionContextParameter(paramName = PARAM_NAME_SHARDING_INDEX)
    private String shardingIndex;

    /** account book, such as : DEPOSIT，TIME-DEPOSIT，LOAN，…… */
    @BusinessActionContextParameter(paramName = PARAM_NAME_ACCOUNT_BOOK)
    private String accountBook;

    /** 账户号 */
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

    /** 转账方向：IN,OUT,FREEZE,UNFREEZE */
    protected String action;

    /**
     * Getter method for property <tt>shardingIndex</tt>.
     *
     * @return property value of shardingIndex
     */
    @Override
    public String getShardingIndex() {
        return shardingIndex;
    }

    /**
     * Setter method for property <tt>shardingIndex</tt>.
     *
     * @param shardingIndex value to be assigned to property shardingIndex
     */
    @Override
    public void setShardingIndex(final String shardingIndex) {
        this.shardingIndex = shardingIndex;
    }

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
     * Getter method for property <tt>action</tt>.
     *
     * @return property value of action
     */
    public String getAction() {
        return action;
    }

    /**
     * Setter method for property <tt>action</tt>.
     *
     * @param action value to be assigned to property action
     */
    public void setAction(final String action) {
        this.action = action;
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
