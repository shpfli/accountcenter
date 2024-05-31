package pers.hubery.accountcenter.infra.dal.dataobject;

import lombok.Data;

import java.io.Serializable;

/**
 * 账务流水表
 *
 * @author hubery
 * @TableName acc_accounting_log
 */
@Data
public class AccountingLogDO implements Serializable {

    private static final long serialVersionUID = 1L;

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
     * 会计日
     */
    private String accountingDate;

    /**
     * 记账时间
     */
    private Long accountingTimestamp;

    /**
     * 业务时间戳
     */
    private Long businessTimestamp;

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
}