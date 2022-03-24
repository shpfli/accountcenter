package pers.hubery.accountcenter.infra.dal.dataobject;

import java.io.Serializable;

/**
 * 账户关系表
 * @TableName acc_account_rel
 */
public class AccountRelDO implements Serializable {
    /**
     * 自增物理主键，业务不得使用
     */
    private Long id;

    /**
     * 租户ID
     */
    private String tenantId;

    /**
     * 账本
     */
    private String accountBook;

    /**
     * 账号
     */
    private String accountNo;

    /**
     * 上级账户
     */
    private String superiorAccountNo;

    /**
     * 联动模式：SYNC-同步联动，ASYNC-异步联动
     */
    private String linkageMode;

    /**
     * 创建时间（毫秒数）
     */
    private Long createdTime;

    /**
     * 修改时间（毫秒数）
     */
    private Long modifiedTime;

    private static final long serialVersionUID = 1L;

    /**
     * 自增物理主键，业务不得使用
     */
    public Long getId() {
        return id;
    }

    /**
     * 自增物理主键，业务不得使用
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
     * 账本
     */
    public String getAccountBook() {
        return accountBook;
    }

    /**
     * 账本
     */
    public void setAccountBook(String accountBook) {
        this.accountBook = accountBook;
    }

    /**
     * 账号
     */
    public String getAccountNo() {
        return accountNo;
    }

    /**
     * 账号
     */
    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    /**
     * 上级账户
     */
    public String getSuperiorAccountNo() {
        return superiorAccountNo;
    }

    /**
     * 上级账户
     */
    public void setSuperiorAccountNo(String superiorAccountNo) {
        this.superiorAccountNo = superiorAccountNo;
    }

    /**
     * 联动模式：SYNC-同步联动，ASYNC-异步联动
     */
    public String getLinkageMode() {
        return linkageMode;
    }

    /**
     * 联动模式：SYNC-同步联动，ASYNC-异步联动
     */
    public void setLinkageMode(String linkageMode) {
        this.linkageMode = linkageMode;
    }

    /**
     * 创建时间（毫秒数）
     */
    public Long getCreatedTime() {
        return createdTime;
    }

    /**
     * 创建时间（毫秒数）
     */
    public void setCreatedTime(Long createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * 修改时间（毫秒数）
     */
    public Long getModifiedTime() {
        return modifiedTime;
    }

    /**
     * 修改时间（毫秒数）
     */
    public void setModifiedTime(Long modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}