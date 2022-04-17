package pers.hubery.accountcenter.core.reserver.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import pers.hubery.accountcenter.common.model.AccountingCommand;
import pers.hubery.accountcenter.common.model.Balance;
import pers.hubery.accountcenter.core.executor.AccountingExecutor;
import pers.hubery.accountcenter.core.reserver.AccountingReserver;

/**
 * 资金预留器基类
 *
 * @author LiPengfei
 * @version AbstractAccountingReserver.java v1.0 2022-03-31 14:47
 */
public abstract class AbstractAccountingReserver implements AccountingReserver {

    /** 标准记账处理器 */
    @Autowired
    @Qualifier("standardExecutor")
    private AccountingExecutor standardExecutor;

    /**
     * 资金预留
     *
     * @param xid     xid
     * @param balance balance
     * @param command accounting command
     */
    @Override
    public void reserve(final String xid, final Balance balance, final AccountingCommand command) {

        // 1. 前置处理
        preReserve(xid, balance, command);

        // 2. 资金预留
        // TODO 决策记账模式
        doReserve(standardExecutor, xid, balance, command);

        // 3. 后置处理
        postReserve(standardExecutor, xid, balance, command);
    }

    /**
     * 前置处理
     *
     * @param xid     xid
     * @param balance balance
     * @param command accounting command
     */
    protected abstract void preReserve(final String xid, final Balance balance, final AccountingCommand command);

    /**
     * 资金预留
     *
     * @param executor 账务处理器
     * @param xid      xid
     * @param balance  balance
     * @param command  accounting command
     */
    protected abstract void doReserve(final AccountingExecutor executor, final String xid, final Balance balance,
                                      final AccountingCommand command);

    /**
     * 后置处理
     *
     * @param executor 账务处理器
     * @param xid      xid
     * @param balance  balance
     * @param command  accounting command
     */
    protected abstract void postReserve(final AccountingExecutor executor,
                                        final String xid, final Balance balance, final AccountingCommand command);

}
