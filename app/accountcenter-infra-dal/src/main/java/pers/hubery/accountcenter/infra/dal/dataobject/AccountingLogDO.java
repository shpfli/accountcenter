package pers.hubery.accountcenter.infra.dal.dataobject;

import java.io.Serializable;

/**
 * 账务流水表
 * @TableName acc_accounting_log
 */
public class AccountingLogDO implements Serializable {
    /**
     * 自增物理主键，业务不得使用
     */
    private Long id;

    /**
     * 租户ID
     */
    private String tenantId;

    /**
     * 账务流水号，全局唯一
     */
    private String accountingLogId;

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
     * 记账时间
     */
    private Long accountingTime;

    /**
     * 会计日
     */
    private Long accountingDate;

    /**
     * 币种
     */
    private String currency;

    /**
     * 变动金额，正数表示流入，负数表示流出
     */
    private Long changedAmount;

    /**
     * 变动后余额
     */
    private Long balance;

    /**
     * 记账请求唯一ID，用于业务幂等
     */
    private String requestUniqueId;

    /**
     * 交易流水号
     */
    private String transSeqNo;

    /**
     * 交易机构
     */
    private String transInst;

    /**
     * 对手方账户信息
     */
    private String oppositeAccountInfo;

    /**
     * 产品码
     */
    private String productCode;

    /**
     * 事件码
     */
    private String eventCode;

    /**
     * 业务产品码
     */
    private String bizProductCode;

    /**
     * 业务事件码
     */
    private String bizEventCode;

    /**
     * 端产品码
     */
    private String cnlProductCode;

    /**
     * 端事件码
     */
    private String cnlEventCode;

    /**
     * 产品码
     */
    private String cnlNo;

    /**
     * 备注
     */
    private String memo;

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
     * 账务流水号，全局唯一
     */
    public String getAccountingLogId() {
        return accountingLogId;
    }

    /**
     * 账务流水号，全局唯一
     */
    public void setAccountingLogId(String accountingLogId) {
        this.accountingLogId = accountingLogId;
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
     * 记账时间
     */
    public Long getAccountingTime() {
        return accountingTime;
    }

    /**
     * 记账时间
     */
    public void setAccountingTime(Long accountingTime) {
        this.accountingTime = accountingTime;
    }

    /**
     * 会计日
     */
    public Long getAccountingDate() {
        return accountingDate;
    }

    /**
     * 会计日
     */
    public void setAccountingDate(Long accountingDate) {
        this.accountingDate = accountingDate;
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
     * 变动金额，正数表示流入，负数表示流出
     */
    public Long getChangedAmount() {
        return changedAmount;
    }

    /**
     * 变动金额，正数表示流入，负数表示流出
     */
    public void setChangedAmount(Long changedAmount) {
        this.changedAmount = changedAmount;
    }

    /**
     * 变动后余额
     */
    public Long getBalance() {
        return balance;
    }

    /**
     * 变动后余额
     */
    public void setBalance(Long balance) {
        this.balance = balance;
    }

    /**
     * 记账请求唯一ID，用于业务幂等
     */
    public String getRequestUniqueId() {
        return requestUniqueId;
    }

    /**
     * 记账请求唯一ID，用于业务幂等
     */
    public void setRequestUniqueId(String requestUniqueId) {
        this.requestUniqueId = requestUniqueId;
    }

    /**
     * 交易流水号
     */
    public String getTransSeqNo() {
        return transSeqNo;
    }

    /**
     * 交易流水号
     */
    public void setTransSeqNo(String transSeqNo) {
        this.transSeqNo = transSeqNo;
    }

    /**
     * 交易机构
     */
    public String getTransInst() {
        return transInst;
    }

    /**
     * 交易机构
     */
    public void setTransInst(String transInst) {
        this.transInst = transInst;
    }

    /**
     * 对手方账户信息
     */
    public String getOppositeAccountInfo() {
        return oppositeAccountInfo;
    }

    /**
     * 对手方账户信息
     */
    public void setOppositeAccountInfo(String oppositeAccountInfo) {
        this.oppositeAccountInfo = oppositeAccountInfo;
    }

    /**
     * 产品码
     */
    public String getProductCode() {
        return productCode;
    }

    /**
     * 产品码
     */
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    /**
     * 事件码
     */
    public String getEventCode() {
        return eventCode;
    }

    /**
     * 事件码
     */
    public void setEventCode(String eventCode) {
        this.eventCode = eventCode;
    }

    /**
     * 业务产品码
     */
    public String getBizProductCode() {
        return bizProductCode;
    }

    /**
     * 业务产品码
     */
    public void setBizProductCode(String bizProductCode) {
        this.bizProductCode = bizProductCode;
    }

    /**
     * 业务事件码
     */
    public String getBizEventCode() {
        return bizEventCode;
    }

    /**
     * 业务事件码
     */
    public void setBizEventCode(String bizEventCode) {
        this.bizEventCode = bizEventCode;
    }

    /**
     * 端产品码
     */
    public String getCnlProductCode() {
        return cnlProductCode;
    }

    /**
     * 端产品码
     */
    public void setCnlProductCode(String cnlProductCode) {
        this.cnlProductCode = cnlProductCode;
    }

    /**
     * 端事件码
     */
    public String getCnlEventCode() {
        return cnlEventCode;
    }

    /**
     * 端事件码
     */
    public void setCnlEventCode(String cnlEventCode) {
        this.cnlEventCode = cnlEventCode;
    }

    /**
     * 产品码
     */
    public String getCnlNo() {
        return cnlNo;
    }

    /**
     * 产品码
     */
    public void setCnlNo(String cnlNo) {
        this.cnlNo = cnlNo;
    }

    /**
     * 备注
     */
    public String getMemo() {
        return memo;
    }

    /**
     * 备注
     */
    public void setMemo(String memo) {
        this.memo = memo;
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