package pers.hubery.accountcenter.common.model;

import lombok.Data;
import pers.hubery.accountcenter.common.enums.BalanceDirectionEnum;
import pers.hubery.accountcenter.common.money.Money;

import java.util.Date;

/**
 * account balance
 *
 * @author LiPengfei
 * @version Balance.java v1.0 2022-03-30 22:02
 */
@Data
public class Balance {

    /**
     * 租户ID
     */
    private String tenantId;

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
     * balance
     */
    private Money balance;

    /**
     * balance of the previous day
     */
    private Money prevBalance;

    /**
     * unreached amount
     */
    private Money unreachedAmt;

    /**
     * unreached amount
     */
    private Money reserveAmt;

    /**
     * frozen amount
     */
    private Money frozenAmt;

    /**
     * overdraft limit
     */
    private Money overdraftLimit;

    /**
     * 是否有上限
     */
    private boolean hasUpperLimit;

    /**
     * the account date of balance last changed
     */
    private String balanceLastChangeDate;

    /**
     * 余额方向
     */
    private BalanceDirectionEnum balanceDirection;

    /**
     * the timestamp of balance last changed
     */
    private Date balanceLastChangeTimestamp;


    public Balance() {
    }
}
