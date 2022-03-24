package pers.hubery.accountcenter.infra.dal.dataobject;

import java.io.Serializable;

/**
 * 账户余额表
 * @TableName acc_balance
 */
public class BalanceDO implements Serializable {
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
     * 币种
     */
    private String currency;

    /**
     * 余额
     */
    private Long balance;

    /**
     * 未达金额
     */
    private Long unreachedAmount;

    /**
     * 预留金额
     */
    private Long reservedAmount;

    /**
     * 冻结金额
     */
    private Long frozenAmount;

    /**
     * 可透支额度
     */
    private Long overdraftLimit;

    /**
     * 余额是否有上限，例如记录用信额度时，业务上要控制账户余额不超过授信额度。如果无上限限制，可以不记未达金额，以优化记账速度。
     */
    private Integer hasUpperLimit;

    /**
     * 余额方向，D-debit, C-credit, 如果为空则不可使用借贷记账法
     */
    private String balanceDirection;

    /**
     * 最后一次余额变动时间
     */
    private Long lastAccountingTime;

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
     * 余额
     */
    public Long getBalance() {
        return balance;
    }

    /**
     * 余额
     */
    public void setBalance(Long balance) {
        this.balance = balance;
    }

    /**
     * 未达金额
     */
    public Long getUnreachedAmount() {
        return unreachedAmount;
    }

    /**
     * 未达金额
     */
    public void setUnreachedAmount(Long unreachedAmount) {
        this.unreachedAmount = unreachedAmount;
    }

    /**
     * 预留金额
     */
    public Long getReservedAmount() {
        return reservedAmount;
    }

    /**
     * 预留金额
     */
    public void setReservedAmount(Long reservedAmount) {
        this.reservedAmount = reservedAmount;
    }

    /**
     * 冻结金额
     */
    public Long getFrozenAmount() {
        return frozenAmount;
    }

    /**
     * 冻结金额
     */
    public void setFrozenAmount(Long frozenAmount) {
        this.frozenAmount = frozenAmount;
    }

    /**
     * 可透支额度
     */
    public Long getOverdraftLimit() {
        return overdraftLimit;
    }

    /**
     * 可透支额度
     */
    public void setOverdraftLimit(Long overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    /**
     * 余额是否有上限，例如记录用信额度时，业务上要控制账户余额不超过授信额度。如果无上限限制，可以不记未达金额，以优化记账速度。
     */
    public Integer getHasUpperLimit() {
        return hasUpperLimit;
    }

    /**
     * 余额是否有上限，例如记录用信额度时，业务上要控制账户余额不超过授信额度。如果无上限限制，可以不记未达金额，以优化记账速度。
     */
    public void setHasUpperLimit(Integer hasUpperLimit) {
        this.hasUpperLimit = hasUpperLimit;
    }

    /**
     * 余额方向，D-debit, C-credit, 如果为空则不可使用借贷记账法
     */
    public String getBalanceDirection() {
        return balanceDirection;
    }

    /**
     * 余额方向，D-debit, C-credit, 如果为空则不可使用借贷记账法
     */
    public void setBalanceDirection(String balanceDirection) {
        this.balanceDirection = balanceDirection;
    }

    /**
     * 最后一次余额变动时间
     */
    public Long getLastAccountingTime() {
        return lastAccountingTime;
    }

    /**
     * 最后一次余额变动时间
     */
    public void setLastAccountingTime(Long lastAccountingTime) {
        this.lastAccountingTime = lastAccountingTime;
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