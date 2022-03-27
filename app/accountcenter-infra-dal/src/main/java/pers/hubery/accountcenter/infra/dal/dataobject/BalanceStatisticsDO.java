package pers.hubery.accountcenter.infra.dal.dataobject;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * 账户余额变动统计表
 *
 * @author hubery
 * @TableName acc_balance_statistics
 */
public class BalanceStatisticsDO implements Serializable {
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
     * 统计规则：D-按日统计, M-按月统计, Y-按年统计, ……
     */
    private String statisticsRule;

    /**
     * 统计周期，例如按日统计时记录日期，按年统计时记录年份
     */
    private String statisticsPeriod;

    /**
     * 币种
     */
    private String currency;

    /**
     * 流入次数
     */
    private Long influxCount;

    /**
     * 流入金额
     */
    private Long influxAmount;

    /**
     * 流出次数
     */
    private Long outfluxCount;

    /**
     * 流出金额
     */
    private Long outfluxAmount;

    /**
     * 期末余额
     */
    private Long endBalance;

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
     * 统计规则：D-按日统计, M-按月统计, Y-按年统计, ……
     */
    public String getStatisticsRule() {
        return statisticsRule;
    }

    /**
     * 统计规则：D-按日统计, M-按月统计, Y-按年统计, ……
     */
    public void setStatisticsRule(String statisticsRule) {
        this.statisticsRule = statisticsRule;
    }

    /**
     * 统计周期，例如按日统计时记录日期，按年统计时记录年份
     */
    public String getStatisticsPeriod() {
        return statisticsPeriod;
    }

    /**
     * 统计周期，例如按日统计时记录日期，按年统计时记录年份
     */
    public void setStatisticsPeriod(String statisticsPeriod) {
        this.statisticsPeriod = statisticsPeriod;
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
     * 流入次数
     */
    public Long getInfluxCount() {
        return influxCount;
    }

    /**
     * 流入次数
     */
    public void setInfluxCount(Long influxCount) {
        this.influxCount = influxCount;
    }

    /**
     * 流入金额
     */
    public Long getInfluxAmount() {
        return influxAmount;
    }

    /**
     * 流入金额
     */
    public void setInfluxAmount(Long influxAmount) {
        this.influxAmount = influxAmount;
    }

    /**
     * 流出次数
     */
    public Long getOutfluxCount() {
        return outfluxCount;
    }

    /**
     * 流出次数
     */
    public void setOutfluxCount(Long outfluxCount) {
        this.outfluxCount = outfluxCount;
    }

    /**
     * 流出金额
     */
    public Long getOutfluxAmount() {
        return outfluxAmount;
    }

    /**
     * 流出金额
     */
    public void setOutfluxAmount(Long outfluxAmount) {
        this.outfluxAmount = outfluxAmount;
    }

    /**
     * 期末余额
     */
    public Long getEndBalance() {
        return endBalance;
    }

    /**
     * 期末余额
     */
    public void setEndBalance(Long endBalance) {
        this.endBalance = endBalance;
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