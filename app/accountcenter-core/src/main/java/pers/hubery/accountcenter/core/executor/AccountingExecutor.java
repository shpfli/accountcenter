package pers.hubery.accountcenter.core.executor;

import pers.hubery.accountcenter.common.model.AccountingCommand;
import pers.hubery.accountcenter.common.model.Balance;
import pers.hubery.accountcenter.common.money.Money;

/**
 * 账务处理器接口
 *
 * @author LiPengfei
 * @version AccountingExecutor.java v1.0 2022-03-31 15:37
 */
public interface AccountingExecutor {

    /**
     * 增加未达金额
     *
     * @param balance balance
     * @param xid     xid
     * @param amount  amount
     */
    void addUnreachedAmount(Balance balance, final String xid, final Money amount);

    /**
     * 增加预冻结金额
     *
     * @param balance balance
     * @param xid     xid
     * @param amount  amount
     */
    void addReservedAmount(Balance balance, final String xid, final Money amount);

    /**
     * 增加冻结未达金额
     *
     * @param balance       balance
     * @param xid           xid
     * @param freezeType    freeze type
     * @param freezeOrderNo freeze order no
     * @param freezeAmount  freeze amount
     */
    void addFreezeUnreachedAmount(Balance balance, final String xid, final String freezeType, final String freezeOrderNo,
                                  final Money freezeAmount);

    /**
     * 增加预解冻金额
     *
     * @param balance        balance
     * @param xid            xid
     * @param freezeType     freeze type
     * @param freezeOrderNo  freeze order no
     * @param unfreezeAmount unfreeze amount
     */
    void addUnfreezeReservedAmount(Balance balance, final String xid, final String freezeType, final String freezeOrderNo,
                                   final Money unfreezeAmount);

    /**
     * 增加余额
     *
     * @param balance balance
     * @param command accounting command
     */
    void increase(Balance balance, AccountingCommand command);

    /**
     * 减少余额
     *
     * @param balance balance
     * @param command accounting command
     */
    void decrease(Balance balance, AccountingCommand command);

    /**
     * 冻结
     *
     * @param balance balance
     * @param command accounting command
     */
    void freeze(Balance balance, AccountingCommand command);

    /**
     * 解冻
     *
     * @param balance balance
     * @param command accounting command
     */
    void unfreeze(Balance balance, AccountingCommand command);

    /**
     * 一致性检查
     *
     * @param balance balance
     */
    void checkBalanceConsistency(Balance balance);
}
