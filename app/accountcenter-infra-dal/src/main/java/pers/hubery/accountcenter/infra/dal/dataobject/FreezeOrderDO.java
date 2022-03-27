package pers.hubery.accountcenter.infra.dal.dataobject;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * 账户余额表
 *
 * @author hubery
 * @TableName acc_freeze_order
 */
public class FreezeOrderDO implements Serializable {
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
     * 余额类型
     */
    private String balanceType;

    /**
     * 冻结类型
     */
    private String freezeType;

    /**
     * 冻结单号
     */
    private String freezeOrderNo;

    /**
     * 币种
     */
    private String currency;

    /**
     * 冻结金额
     */
    private Long freezeAmount;

    /**
     * 预留冻结金额，即准备解冻的金额
     */
    private Long reservedFreezeAmount;

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
     * 余额类型
     */
    public String getBalanceType() {
        return balanceType;
    }

    /**
     * 余额类型
     */
    public void setBalanceType(String balanceType) {
        this.balanceType = balanceType;
    }

    /**
     * 冻结类型
     */
    public String getFreezeType() {
        return freezeType;
    }

    /**
     * 冻结类型
     */
    public void setFreezeType(String freezeType) {
        this.freezeType = freezeType;
    }

    /**
     * 冻结单号
     */
    public String getFreezeOrderNo() {
        return freezeOrderNo;
    }

    /**
     * 冻结单号
     */
    public void setFreezeOrderNo(String freezeOrderNo) {
        this.freezeOrderNo = freezeOrderNo;
    }

    /**
     * 币种
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * 币种
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * 冻结金额
     */
    public Long getFreezeAmount() {
        return freezeAmount;
    }

    /**
     * 冻结金额
     */
    public void setFreezeAmount(Long freezeAmount) {
        this.freezeAmount = freezeAmount;
    }

    /**
     * 预留冻结金额，即准备解冻的金额
     */
    public Long getReservedFreezeAmount() {
        return reservedFreezeAmount;
    }

    /**
     * 预留冻结金额，即准备解冻的金额
     */
    public void setReservedFreezeAmount(Long reservedFreezeAmount) {
        this.reservedFreezeAmount = reservedFreezeAmount;
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