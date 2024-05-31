package pers.hubery.accountcenter.infra.dal.dataobject;

import lombok.Data;

import java.io.Serializable;

/**
 * 账户余额表
 *
 * @author hubery
 * @TableName acc_balance
 */
@Data
public class BalanceDO implements Serializable {

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

}