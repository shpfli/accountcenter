package pers.hubery.accountcenter.infra.dal.dataobject;

import java.io.Serializable;

/**
 * TCC 主事务表
 * @TableName tcc_main_transaction
 */
public class MainTransactionDO implements Serializable {
    /**
     * 租户ID
     */
    private String tenantId;

    /**
     * TCC事务 ID
     */
    private String xid;

    /**
     * account book, such as : deposit, loan, ……
     */
    private String accountBook;

    /**
     * 事务状态：P-预处理，R-已回滚，C-已提交
     */
    private String status;

    /**
     * 创建时间（毫秒数）
     */
    private Long createTime;

    /**
     * 修改时间（毫秒数）
     */
    private Long modifyTime;

    private static final long serialVersionUID = 1L;

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
     * TCC事务 ID
     */
    public String getXid() {
        return xid;
    }

    /**
     * TCC事务 ID
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
     * 事务状态：P-预处理，R-已回滚，C-已提交
     */
    public String getStatus() {
        return status;
    }

    /**
     * 事务状态：P-预处理，R-已回滚，C-已提交
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 创建时间（毫秒数）
     */
    public Long getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间（毫秒数）
     */
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    /**
     * 修改时间（毫秒数）
     */
    public Long getModifyTime() {
        return modifyTime;
    }

    /**
     * 修改时间（毫秒数）
     */
    public void setModifyTime(Long modifyTime) {
        this.modifyTime = modifyTime;
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
        MainTransactionDO other = (MainTransactionDO) that;
        return (this.getTenantId() == null ? other.getTenantId() == null : this.getTenantId().equals(other.getTenantId()))
            && (this.getXid() == null ? other.getXid() == null : this.getXid().equals(other.getXid()))
            && (this.getAccountBook() == null ? other.getAccountBook() == null : this.getAccountBook().equals(other.getAccountBook()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getModifyTime() == null ? other.getModifyTime() == null : this.getModifyTime().equals(other.getModifyTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTenantId() == null) ? 0 : getTenantId().hashCode());
        result = prime * result + ((getXid() == null) ? 0 : getXid().hashCode());
        result = prime * result + ((getAccountBook() == null) ? 0 : getAccountBook().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getModifyTime() == null) ? 0 : getModifyTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", tenantId=").append(tenantId);
        sb.append(", xid=").append(xid);
        sb.append(", accountBook=").append(accountBook);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}