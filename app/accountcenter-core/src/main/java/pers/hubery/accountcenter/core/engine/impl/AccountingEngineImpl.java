package pers.hubery.accountcenter.core.engine.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import pers.hubery.accountcenter.common.enums.ErrorCodeEnum;
import pers.hubery.accountcenter.common.err.InvalidParamException;
import pers.hubery.accountcenter.common.model.AccountingCommand;
import pers.hubery.accountcenter.common.model.Balance;
import pers.hubery.accountcenter.common.model.BalanceKey;
import pers.hubery.accountcenter.common.model.SystemAmount;
import pers.hubery.accountcenter.core.accountant.Accountant;
import pers.hubery.accountcenter.core.engine.AccountingEngine;
import pers.hubery.accountcenter.core.manager.BalanceManager;
import pers.hubery.accountcenter.core.manager.SystemAmountManager;
import pers.hubery.accountcenter.core.reserver.AccountingReserver;
import pers.hubery.accountcenter.core.unreserver.SystemAmountUnreserver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 账务引擎实现
 *
 * @author LiPengfei
 * @version AccountingEngineImpl.java v1.0 2022-03-30 21:30
 */
@Component("accountingEngine")
public class AccountingEngineImpl implements AccountingEngine {

    /** 余额 Manager */
    @Autowired
    private BalanceManager balanceManager;

    /** 系统金额 Manager */
    @Autowired
    private SystemAmountManager systemAmountManager;

    /** 余额增加资金预留器 */
    @Autowired
    @Qualifier("increaseReserver")
    private AccountingReserver increaseReserver;

    /** 余额减少资金预留器 */
    @Autowired
    @Qualifier("decreaseReserver")
    private AccountingReserver decreaseReserver;

    /** 系统金额还原器 */
    @Autowired
    @Qualifier("systemAmountUnreserver")
    private SystemAmountUnreserver systemAmountUnreserver;

    /** 会计员 */
    @Autowired
    @Qualifier("accountant")
    private Accountant accountant;

    /**
     * TCC 事务一阶段资金预留
     *
     * @param xid     xid
     * @param command accounting command
     */
    @Override
    public void reserve(final String xid, final AccountingCommand command) {

        // 1. TODO 记账模式决策
        // But, as a demo, we directly use the standard accounting mod.

        // 2. 锁余额
        Balance balance = balanceManager.lockBalance(command.getAccountNo(), command.getBalanceType());

        // 3. 资金预留
        switch (command.getAction()) {
            case IN:
                increaseReserver.reserve(xid, balance, command);
                break;
            case OUT:
                decreaseReserver.reserve(xid, balance, command);
                break;
            case FREEZE:
                //TODO SUPPORT
            case UNFREEZE:
                //TODO SUPPORT
            default:
                throw new UnsupportedOperationException();
        }
    }

    /**
     * unreserver
     *
     * @param xid xid
     */
    @Override
    public void unreserve(final String xid) {

        //1. 查询所有系统金额记录，并删除
        List<SystemAmount> systemAmountList = systemAmountManager.getAndRemove(xid);

        //2. 根据余额分组
        Map<BalanceKey, List<SystemAmount>> systemAmountMap = new HashMap<>();
        // do group
        systemAmountList.forEach(item -> {

            //build key
            BalanceKey key = new BalanceKey(item.getAccountBook(), item.getAcctNo(), item.getBalanceType());

            //the subList of the balance
            List<SystemAmount> subList = systemAmountMap.computeIfAbsent(key, k -> new ArrayList<>());
            subList.add(item);
        });

        // 3. 遍历每个余额记录，依次还原系统金额
        systemAmountMap.keySet().stream()
                //对余额排序，防止死锁
                .sorted()
                .forEachOrdered(balanceKey -> {

                    // 3.1 TODO 决策是否锁余额

                    // 3.2 先全部锁余额
                    Balance balance = balanceManager.lockBalance(balanceKey.acctNo, balanceKey.balanceType);

                    // 系统金额列表
                    List<SystemAmount> subList = systemAmountMap.get(balanceKey);

                    // 3.3 还原
                    subList.forEach(item -> systemAmountUnreserver.unreserve(balance, item));
                });

    }

    /**
     * 记账
     *
     * @param command accounting command
     */
    @Override
    public void doAccount(final AccountingCommand command) {

        // 1. TODO 决策记账模式

        // 2. lock balance first
        Balance balance = balanceManager.lockBalance(command.getAccountNo(), command.getBalanceType());

        // 3. do account
        accountant.account(balance, command);
    }

    /**
     * execute accounting command
     *
     * @param accountingCommandList accounting command List
     */
    @Override
    public void doAccount(final List<AccountingCommand> accountingCommandList) {

        if (CollectionUtils.isEmpty(accountingCommandList)) {
            return;
        }

        //1. 根据余额分组
        Map<BalanceKey, List<AccountingCommand>> accountingCommandMap = new HashMap<>();

        accountingCommandList.forEach(command -> {
            //1.1 build key
            BalanceKey key = new BalanceKey(command.getAccountBook(), command.getAccountNo(), command.getBalanceType());

            //1.2 get mapping list
            List<AccountingCommand> subList = accountingCommandMap.computeIfAbsent(key, k -> new ArrayList<>());

            //1.3 add to list
            subList.add(command);
        });

        //2. 先对余额排序，然后依次记账
        accountingCommandMap.keySet().stream().sorted().forEachOrdered(balanceKey -> {

            // 2.1 TODO 决策是否锁余额

            // 2.2 lock balance first
            Balance balance = balanceManager.lockBalance(balanceKey.acctNo, balanceKey.balanceType);

            accountingCommandMap.get(balanceKey).stream()
                    //2.3 按照记账时间对指令排序，
                    .sorted((x, y) -> x.getCreateTime().compareTo(y.getCreateTime()))

                    //2.4 依次记账
                    .forEachOrdered(command -> accountant.account(balance, command));
        });
    }

}
