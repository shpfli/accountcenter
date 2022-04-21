package pers.hubery.accountcenter.infra.dal.domain;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * account amount prepare record
 * @TableName tcc_transaction_amount
 */
public class TransactionAmountDO implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * 租户ID
     */
    private String tenantId;

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
    private String accountNo;

    /**
     * balance type
     */
    private String balanceType;

    /**
     * amount type, such as : BR - reserved balance, BU - unreached balance, FR - reserved freeze amount for unfreeze, FU - unreached freeze amount
     */
    private String amountType;

    /**
     * Currencies
     */
    private String currency;

    /**
     * amount
     */
    private BigDecimal amount;

    /**
     * create timestamp
     */
    private Long createdTime;

    /**
     * update timestamp
     */
    private Long modifiedTime;

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
    public String getAccountNo() {
        return accountNo;
    }

    /**
     * account number
     */
    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
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
     * amount type, such as : BR - reserved balance, BU - unreached balance, FR - reserved freeze amount for unfreeze, FU - unreached freeze amount
     */
    public String getAmountType() {
        return amountType;
    }

    /**
     * amount type, such as : BR - reserved balance, BU - unreached balance, FR - reserved freeze amount for unfreeze, FU - unreached freeze amount
     */
    public void setAmountType(String amountType) {
        this.amountType = amountType;
    }

    /**
     * Currencies
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Currencies
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * amount
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * amount
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * create timestamp
     */
    public Long getCreatedTime() {
        return createdTime;
    }

    /**
     * create timestamp
     */
    public void setCreatedTime(Long createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * update timestamp
     */
    public Long getModifiedTime() {
        return modifiedTime;
    }

    /**
     * update timestamp
     */
    public void setModifiedTime(Long modifiedTime) {
        this.modifiedTime = modifiedTime;
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
        TransactionAmountDO other = (TransactionAmountDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTenantId() == null ? other.getTenantId() == null : this.getTenantId().equals(other.getTenantId()))
            && (this.getXid() == null ? other.getXid() == null : this.getXid().equals(other.getXid()))
            && (this.getAccountBook() == null ? other.getAccountBook() == null : this.getAccountBook().equals(other.getAccountBook()))
            && (this.getAccountNo() == null ? other.getAccountNo() == null : this.getAccountNo().equals(other.getAccountNo()))
            && (this.getBalanceType() == null ? other.getBalanceType() == null : this.getBalanceType().equals(other.getBalanceType()))
            && (this.getAmountType() == null ? other.getAmountType() == null : this.getAmountType().equals(other.getAmountType()))
            && (this.getCurrency() == null ? other.getCurrency() == null : this.getCurrency().equals(other.getCurrency()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getModifiedTime() == null ? other.getModifiedTime() == null : this.getModifiedTime().equals(other.getModifiedTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTenantId() == null) ? 0 : getTenantId().hashCode());
        result = prime * result + ((getXid() == null) ? 0 : getXid().hashCode());
        result = prime * result + ((getAccountBook() == null) ? 0 : getAccountBook().hashCode());
        result = prime * result + ((getAccountNo() == null) ? 0 : getAccountNo().hashCode());
        result = prime * result + ((getBalanceType() == null) ? 0 : getBalanceType().hashCode());
        result = prime * result + ((getAmountType() == null) ? 0 : getAmountType().hashCode());
        result = prime * result + ((getCurrency() == null) ? 0 : getCurrency().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getModifiedTime() == null) ? 0 : getModifiedTime().hashCode());
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
        sb.append(", xid=").append(xid);
        sb.append(", accountBook=").append(accountBook);
        sb.append(", accountNo=").append(accountNo);
        sb.append(", balanceType=").append(balanceType);
        sb.append(", amountType=").append(amountType);
        sb.append(", currency=").append(currency);
        sb.append(", amount=").append(amount);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}