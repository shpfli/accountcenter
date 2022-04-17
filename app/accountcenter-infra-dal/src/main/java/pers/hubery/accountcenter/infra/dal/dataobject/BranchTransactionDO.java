package pers.hubery.accountcenter.infra.dal.dataobject;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * TCC 分支事务表
 * @TableName tcc_branch_transaction
 */
public class BranchTransactionDO implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * 租户ID
     */
    private String tenantId;

    /**
     * business seq no, used to identify a request in biz sight
     */
    private String reqBizNo;

    /**
     * TCC main transaction ID
     */
    private String xid;

    /**
     * TCC branch transaction ID
     */
    private Long branchId;

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
    private Long businessTimestamp;

    /**
     * Currencies
     */
    private String ccy;

    /**
     * action type, such as: IN, OUT, FREEZE, UNFREEZE
     */
    private String action;

    /**
     * changed amount
     */
    private BigDecimal amount;

    /**
     * business reference number
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
    private Long createTimestamp;

    /**
     * update timestamp
     */
    private Long updateTimestamp;

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    public Long getId() {
        return id;
    }

    /**
     * id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 租户ID
     */
    public String getTenantId() {
        return tenantId;
    }

    /**
     * 租户ID
     */
    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    /**
     * business seq no, used to identify a request in biz sight
     */
    public String getReqBizNo() {
        return reqBizNo;
    }

    /**
     * business seq no, used to identify a request in biz sight
     */
    public void setReqBizNo(String reqBizNo) {
        this.reqBizNo = reqBizNo;
    }

    /**
     * TCC main transaction ID
     */
    public String getXid() {
        return xid;
    }

    /**
     * TCC main transaction ID
     */
    public void setXid(String xid) {
        this.xid = xid;
    }

    /**
     * TCC branch transaction ID
     */
    public Long getBranchId() {
        return branchId;
    }

    /**
     * TCC branch transaction ID
     */
    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    /**
     * account book, such as : deposit, loan, ……
     */
    public String getAccountBook() {
        return accountBook;
    }

    /**
     * account book, such as : deposit, loan, ……
     */
    public void setAccountBook(String accountBook) {
        this.accountBook = accountBook;
    }

    /**
     * account number
     */
    public String getAcctNo() {
        return acctNo;
    }

    /**
     * account number
     */
    public void setAcctNo(String acctNo) {
        this.acctNo = acctNo;
    }

    /**
     * balance type
     */
    public String getBalanceType() {
        return balanceType;
    }

    /**
     * balance type
     */
    public void setBalanceType(String balanceType) {
        this.balanceType = balanceType;
    }

    /**
     * account date
     */
    public String getAccountDate() {
        return accountDate;
    }

    /**
     * account date
     */
    public void setAccountDate(String accountDate) {
        this.accountDate = accountDate;
    }

    /**
     * the timestamp of the business happened
     */
    public Long getBusinessTimestamp() {
        return businessTimestamp;
    }

    /**
     * the timestamp of the business happened
     */
    public void setBusinessTimestamp(Long businessTimestamp) {
        this.businessTimestamp = businessTimestamp;
    }

    /**
     * Currencies
     */
    public String getCcy() {
        return ccy;
    }

    /**
     * Currencies
     */
    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    /**
     * action type, such as: IN, OUT, FREEZE, UNFREEZE
     */
    public String getAction() {
        return action;
    }

    /**
     * action type, such as: IN, OUT, FREEZE, UNFREEZE
     */
    public void setAction(String action) {
        this.action = action;
    }

    /**
     * changed amount
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * changed amount
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * business reference number
     */
    public String getReferenceNo() {
        return referenceNo;
    }

    /**
     * business reference number
     */
    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }

    /**
     * the memo
     */
    public String getMemo() {
        return memo;
    }

    /**
     * the memo
     */
    public void setMemo(String memo) {
        this.memo = memo;
    }

    /**
     * channel
     */
    public String getChannel() {
        return channel;
    }

    /**
     * channel
     */
    public void setChannel(String channel) {
        this.channel = channel;
    }

    /**
     * src channel
     */
    public String getSrcChannel() {
        return srcChannel;
    }

    /**
     * src channel
     */
    public void setSrcChannel(String srcChannel) {
        this.srcChannel = srcChannel;
    }

    /**
     * src channel biz no
     */
    public String getSrcChannelBizNo() {
        return srcChannelBizNo;
    }

    /**
     * src channel biz no
     */
    public void setSrcChannelBizNo(String srcChannelBizNo) {
        this.srcChannelBizNo = srcChannelBizNo;
    }

    /**
     * operator
     */
    public String getOperator() {
        return operator;
    }

    /**
     * operator
     */
    public void setOperator(String operator) {
        this.operator = operator;
    }

    /**
     * authUserId
     */
    public String getAuthUserId() {
        return authUserId;
    }

    /**
     * authUserId
     */
    public void setAuthUserId(String authUserId) {
        this.authUserId = authUserId;
    }

    /**
     * fromAppName
     */
    public String getFromAppName() {
        return fromAppName;
    }

    /**
     * fromAppName
     */
    public void setFromAppName(String fromAppName) {
        this.fromAppName = fromAppName;
    }

    /**
     * create timestamp
     */
    public Long getCreateTimestamp() {
        return createTimestamp;
    }

    /**
     * create timestamp
     */
    public void setCreateTimestamp(Long createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    /**
     * update timestamp
     */
    public Long getUpdateTimestamp() {
        return updateTimestamp;
    }

    /**
     * update timestamp
     */
    public void setUpdateTimestamp(Long updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        BranchTransactionDO other = (BranchTransactionDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTenantId() == null ? other.getTenantId() == null : this.getTenantId().equals(other.getTenantId()))
            && (this.getReqBizNo() == null ? other.getReqBizNo() == null : this.getReqBizNo().equals(other.getReqBizNo()))
            && (this.getXid() == null ? other.getXid() == null : this.getXid().equals(other.getXid()))
            && (this.getBranchId() == null ? other.getBranchId() == null : this.getBranchId().equals(other.getBranchId()))
            && (this.getAccountBook() == null ? other.getAccountBook() == null : this.getAccountBook().equals(other.getAccountBook()))
            && (this.getAcctNo() == null ? other.getAcctNo() == null : this.getAcctNo().equals(other.getAcctNo()))
            && (this.getBalanceType() == null ? other.getBalanceType() == null : this.getBalanceType().equals(other.getBalanceType()))
            && (this.getAccountDate() == null ? other.getAccountDate() == null : this.getAccountDate().equals(other.getAccountDate()))
            && (this.getBusinessTimestamp() == null ? other.getBusinessTimestamp() == null : this.getBusinessTimestamp().equals(other.getBusinessTimestamp()))
            && (this.getCcy() == null ? other.getCcy() == null : this.getCcy().equals(other.getCcy()))
            && (this.getAction() == null ? other.getAction() == null : this.getAction().equals(other.getAction()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getReferenceNo() == null ? other.getReferenceNo() == null : this.getReferenceNo().equals(other.getReferenceNo()))
            && (this.getMemo() == null ? other.getMemo() == null : this.getMemo().equals(other.getMemo()))
            && (this.getChannel() == null ? other.getChannel() == null : this.getChannel().equals(other.getChannel()))
            && (this.getSrcChannel() == null ? other.getSrcChannel() == null : this.getSrcChannel().equals(other.getSrcChannel()))
            && (this.getSrcChannelBizNo() == null ? other.getSrcChannelBizNo() == null : this.getSrcChannelBizNo().equals(other.getSrcChannelBizNo()))
            && (this.getOperator() == null ? other.getOperator() == null : this.getOperator().equals(other.getOperator()))
            && (this.getAuthUserId() == null ? other.getAuthUserId() == null : this.getAuthUserId().equals(other.getAuthUserId()))
            && (this.getFromAppName() == null ? other.getFromAppName() == null : this.getFromAppName().equals(other.getFromAppName()))
            && (this.getCreateTimestamp() == null ? other.getCreateTimestamp() == null : this.getCreateTimestamp().equals(other.getCreateTimestamp()))
            && (this.getUpdateTimestamp() == null ? other.getUpdateTimestamp() == null : this.getUpdateTimestamp().equals(other.getUpdateTimestamp()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTenantId() == null) ? 0 : getTenantId().hashCode());
        result = prime * result + ((getReqBizNo() == null) ? 0 : getReqBizNo().hashCode());
        result = prime * result + ((getXid() == null) ? 0 : getXid().hashCode());
        result = prime * result + ((getBranchId() == null) ? 0 : getBranchId().hashCode());
        result = prime * result + ((getAccountBook() == null) ? 0 : getAccountBook().hashCode());
        result = prime * result + ((getAcctNo() == null) ? 0 : getAcctNo().hashCode());
        result = prime * result + ((getBalanceType() == null) ? 0 : getBalanceType().hashCode());
        result = prime * result + ((getAccountDate() == null) ? 0 : getAccountDate().hashCode());
        result = prime * result + ((getBusinessTimestamp() == null) ? 0 : getBusinessTimestamp().hashCode());
        result = prime * result + ((getCcy() == null) ? 0 : getCcy().hashCode());
        result = prime * result + ((getAction() == null) ? 0 : getAction().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getReferenceNo() == null) ? 0 : getReferenceNo().hashCode());
        result = prime * result + ((getMemo() == null) ? 0 : getMemo().hashCode());
        result = prime * result + ((getChannel() == null) ? 0 : getChannel().hashCode());
        result = prime * result + ((getSrcChannel() == null) ? 0 : getSrcChannel().hashCode());
        result = prime * result + ((getSrcChannelBizNo() == null) ? 0 : getSrcChannelBizNo().hashCode());
        result = prime * result + ((getOperator() == null) ? 0 : getOperator().hashCode());
        result = prime * result + ((getAuthUserId() == null) ? 0 : getAuthUserId().hashCode());
        result = prime * result + ((getFromAppName() == null) ? 0 : getFromAppName().hashCode());
        result = prime * result + ((getCreateTimestamp() == null) ? 0 : getCreateTimestamp().hashCode());
        result = prime * result + ((getUpdateTimestamp() == null) ? 0 : getUpdateTimestamp().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", tenantId=").append(tenantId);
        sb.append(", reqBizNo=").append(reqBizNo);
        sb.append(", xid=").append(xid);
        sb.append(", branchId=").append(branchId);
        sb.append(", accountBook=").append(accountBook);
        sb.append(", acctNo=").append(acctNo);
        sb.append(", balanceType=").append(balanceType);
        sb.append(", accountDate=").append(accountDate);
        sb.append(", businessTimestamp=").append(businessTimestamp);
        sb.append(", ccy=").append(ccy);
        sb.append(", action=").append(action);
        sb.append(", amount=").append(amount);
        sb.append(", referenceNo=").append(referenceNo);
        sb.append(", memo=").append(memo);
        sb.append(", channel=").append(channel);
        sb.append(", srcChannel=").append(srcChannel);
        sb.append(", srcChannelBizNo=").append(srcChannelBizNo);
        sb.append(", operator=").append(operator);
        sb.append(", authUserId=").append(authUserId);
        sb.append(", fromAppName=").append(fromAppName);
        sb.append(", createTimestamp=").append(createTimestamp);
        sb.append(", updateTimestamp=").append(updateTimestamp);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}