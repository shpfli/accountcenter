package pers.hubery.accountcenter.core.executor.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pers.hubery.accountcenter.common.enums.ErrorCodeEnum;
import pers.hubery.accountcenter.common.enums.SystemAmountTypeEnum;
import pers.hubery.accountcenter.common.err.SystemException;
import pers.hubery.accountcenter.common.model.AccountingCommand;
import pers.hubery.accountcenter.common.model.Balance;
import pers.hubery.accountcenter.common.model.SystemAmount;
import pers.hubery.accountcenter.common.money.Money;
import pers.hubery.accountcenter.core.executor.AccountingExecutor;
import pers.hubery.accountcenter.core.manager.AccountingRecordManager;
import pers.hubery.accountcenter.core.manager.BalanceManager;
import pers.hubery.accountcenter.core.manager.SystemAmountManager;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Objects;

/**
 * the standard implements of AccountingExecutor
 *
 * @author LiPengfei
 * @version StandardExecutor.java v1.0 2022-03-31 16:24
 */
@Component("standardExecutor")
public class StandardExecutor implements AccountingExecutor {

    /** systemAmountManager */
    @Autowired
    private SystemAmountManager systemAmountManager;

    /** balanceManager */
    @Autowired
    private BalanceManager balanceManager;

    /** accountingRecordManager */
    @Autowired
    private AccountingRecordManager accountingRecordManager;

    /**
     * 增加事务中未达金额
     *
     * @param balance 余额对象
     * @param xid     xid
     * @param amount  amount
     */
    @Override
    public void addUnreachedAmount(final Balance balance, final String xid, final Money amount) {

        // 真正要加的未达金额
        Money toAddUnreachedAmount = amount.clone();

        //1. 查询事务金额Map
        Map<String, SystemAmount> systemAmountMap = systemAmountManager.getSystemAmountMap(
                xid, balance.getAccountNo(), balance.getBalanceType());

        //2. 如果未达金额记录已经存在，则累加即可
        SystemAmount unreachedAmountRecord = systemAmountMap.get(
                SystemAmountTypeEnum.buildAmountType(SystemAmountTypeEnum.UNREACHED_BALANCE));
        if (unreachedAmountRecord != null) {

            //2.1 累加未达金额
            systemAmountManager.addAmount(unreachedAmountRecord, amount);

            //2.2 增加余额记录上的未达金额
            // optimization: 如果余额无上限，则此处无需锁账户累加
            balanceManager.addUnreachedAmount(balance, amount);

            return;
        }

        //3. 如果存在预冻结金额，则优先抵扣
        SystemAmount reservedAmountRecord = systemAmountMap.get(
                SystemAmountTypeEnum.buildAmountType(SystemAmountTypeEnum.RESERVED_BALANCE));
        if (reservedAmountRecord != null) {

            Money reservedAmount = reservedAmountRecord.getAmount();

            if (reservedAmount.greaterThan(amount)) {
                // 3.1 预冻结金额 >= amount, 则足额抵扣，即预冻结金额 -= amount
                systemAmountManager.subtractAmount(reservedAmountRecord, amount);
                balanceManager.subtractReserveAmount(balance, amount);

                return;
            } else {

                // 3.2  预冻结金额 < amount, 则部分抵扣
                systemAmountManager.remove(reservedAmountRecord);
                balanceManager.subtractReserveAmount(balance, reservedAmount);
                toAddUnreachedAmount = amount.subtract(reservedAmount);
            }
        }

        // 4. if toAddUnreachedAmount > 0, 插入未达金额记录
        if (toAddUnreachedAmount.getAmount().compareTo(BigDecimal.ZERO) > 0) {

            SystemAmount systemAmount = SystemAmount.builder()
                    .xid(xid)
                    .accountBook(balance.getAccountBook())
                    .acctNo(balance.getAccountNo())
                    .balanceType(balance.getBalanceType())
                    .amountType(SystemAmountTypeEnum.buildAmountType(SystemAmountTypeEnum.UNREACHED_BALANCE))
                    .amount(toAddUnreachedAmount)
                    .build();

            systemAmountManager.insert(systemAmount);
            balanceManager.addUnreachedAmount(balance, toAddUnreachedAmount);
        }
    }

    /**
     * 增加事务中预冻结金额
     *
     * @param balance 余额对象
     * @param xid     xid
     * @param amount  amount
     */
    @Override
    public void addReservedAmount(final Balance balance, final String xid, final Money amount) {

        // the amount to add into reserved amount
        Money toAddReservedAmount = amount.clone();

        //1. 查询系统金额Map
        Map<String, SystemAmount> systemAmountMap = systemAmountManager.getSystemAmountMap(
                xid, balance.getAccountNo(), balance.getBalanceType());

        //2. 预冻结金额存在，则直接累加即可
        // get unreached amount
        SystemAmount reservedAmountRecord = systemAmountMap.get(
                SystemAmountTypeEnum.buildAmountType(SystemAmountTypeEnum.RESERVED_BALANCE));
        if (reservedAmountRecord != null) {

            //2.1 累加预冻结金额
            systemAmountManager.addAmount(reservedAmountRecord, amount);

            //2.2 累加到余额记录上的总预冻结金额
            balanceManager.addReservedAmount(balance, amount);

            return;
        }

        //3. if unreached amount exits, deduction from unreached amount first.
        SystemAmount unreachedAmountRecord = systemAmountMap.get(
                SystemAmountTypeEnum.buildAmountType(SystemAmountTypeEnum.UNREACHED_BALANCE));
        if (unreachedAmountRecord != null) {

            Money unreachedAmount = unreachedAmountRecord.getAmount();

            if (unreachedAmount.greaterThan(amount)) {
                // 3.1 if unreachedAmount >= amount, 则全部抵扣即： unreachedAmount -= amount
                systemAmountManager.subtractAmount(unreachedAmountRecord, amount);
                balanceManager.subtractUnreachedAmount(balance, amount);

                return;
            } else {

                // 3.2 if unreachedAmount < amount, 部分抵扣
                systemAmountManager.remove(unreachedAmountRecord);
                balanceManager.subtractUnreachedAmount(balance, unreachedAmount);
                //部分抵扣
                toAddReservedAmount = amount.subtract(unreachedAmount);
            }
        }

        // 4. if toAddReservedAmount > 0, insert
        if (toAddReservedAmount.getAmount().compareTo(BigDecimal.ZERO) > 0) {

            SystemAmount systemAmount = SystemAmount.builder()
                    .xid(xid)
                    .accountBook(balance.getAccountBook())
                    .acctNo(balance.getAccountNo())
                    .balanceType(balance.getBalanceType())
                    .amountType(SystemAmountTypeEnum.buildAmountType(SystemAmountTypeEnum.RESERVED_BALANCE))
                    .amount(toAddReservedAmount)
                    .build();

            systemAmountManager.insert(systemAmount);

            balanceManager.addReservedAmount(balance, toAddReservedAmount);
        }

    }

    /**
     * 增加将冻结金额
     *
     * @param balance       balance
     * @param xid           xid
     * @param freezeType    freeze type
     * @param freezeOrderNo freeze order no
     * @param freezeAmount  amount
     */
    @Override
    public void addFreezeUnreachedAmount(final Balance balance, final String xid, final String freezeType, final String freezeOrderNo,
                                         final Money freezeAmount) {

    }

    /**
     * 增加将解冻金额
     *
     * @param balance        balance
     * @param xid            xid
     * @param freezeType     freeze type
     * @param freezeOrderNo  freeze order no
     * @param unfreezeAmount unfreeze amount
     */
    @Override
    public void addUnfreezeReservedAmount(final Balance balance, final String xid, final String freezeType, final String freezeOrderNo,
                                          final Money unfreezeAmount) {

    }

    /**
     * 增加余额
     *
     * @param balance balance
     * @param command accounting command
     */
    @Override
    public void increase(final Balance balance, final AccountingCommand command) {

        // 1. handle balance change
        balanceManager.handleBalanceAmtChange(balance, command.getAmount().clone(), command.getAccountDate(), command.getCreateTime());

        // 2. TODO record daily info

        // 3. record accountingRecord
        accountingRecordManager.record(command, balance.getBalance());
    }

    /**
     * 扣减余额
     *
     * @param balance balance
     * @param command accounting command
     */
    @Override
    public void decrease(final Balance balance, final AccountingCommand command) {

        // 1. handle balance change
        balanceManager.handleBalanceAmtChange(balance, command.getAmount().multiply(-1), command.getAccountDate(), command.getCreateTime());

        // 2. TODO record daily info

        // 3. record accountingRecord
        accountingRecordManager.record(command, balance.getBalance());
    }

    /**
     * 冻结
     *
     * @param balance balance
     * @param command accounting command
     */
    @Override
    public void freeze(final Balance balance, final AccountingCommand command) {

    }

    /**
     * unfreeze frozen amount
     *
     * @param balance balance
     * @param command accounting command
     */
    @Override
    public void unfreeze(final Balance balance, final AccountingCommand command) {

    }

    /**
     * check consistency of db val and given val
     *
     * @param balance balance
     */
    @Override
    public void checkBalanceConsistency(final Balance balance) {

        Balance balanceInDB = balanceManager.getBalanceFromDb(balance.getAccountNo(), balance.getBalanceType());

        if (!Objects.equals(balance, balanceInDB)) {
            throw new SystemException(ErrorCodeEnum.BALANCE_IS_NOT_CONSISTENT_WITH_DB);
        }

    }
}
