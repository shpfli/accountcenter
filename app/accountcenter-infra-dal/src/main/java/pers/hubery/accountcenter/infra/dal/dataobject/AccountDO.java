package pers.hubery.accountcenter.infra.dal.dataobject;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * 账户表
 *
 * @author hubery
 * @TableName acc_account
 */
public class AccountDO implements Serializable {

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
     * 账户状态：A-ACTIVE, I-INACTIVE, C-CANCEL
     */
    private String accountStatus;

    /**
     * 限制状态：00-无限制，10-只进不出，01-只出不进，11-不进不出
     */
    private String limitedStatus;

    /**
     * 客户号
     */
    private String clientNo;

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
     * 账户状态：A-ACTIVE, I-INACTIVE, C-CANCEL
     */
    public String getAccountStatus() {
        return accountStatus;
    }

    /**
     * 账户状态：A-ACTIVE, I-INACTIVE, C-CANCEL
     */
    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    /**
     * 限制状态：00-无限制，10-只进不出，01-只出不进，11-不进不出
     */
    public String getLimitedStatus() {
        return limitedStatus;
    }

    /**
     * 限制状态：00-无限制，10-只进不出，01-只出不进，11-不进不出
     */
    public void setLimitedStatus(String limitedStatus) {
        this.limitedStatus = limitedStatus;
    }

    /**
     * 客户号
     */
    public String getClientNo() {
        return clientNo;
    }

    /**
     * 客户号
     */
    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
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

    /**
     * returns a string representation of the object.
     *
     * @return a string representation of the object.
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SIMPLE_STYLE);
    }
}