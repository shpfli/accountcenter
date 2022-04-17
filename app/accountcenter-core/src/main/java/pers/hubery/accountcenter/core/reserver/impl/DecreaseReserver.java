package pers.hubery.accountcenter.core.reserver.impl;

import org.springframework.stereotype.Component;
import pers.hubery.accountcenter.common.model.AccountingCommand;
import pers.hubery.accountcenter.common.model.Balance;
import pers.hubery.accountcenter.core.executor.AccountingExecutor;

/**
 * the reserver to deal with balance decrease
 *
 * @author LiPengfei
 * @version IncreaseReserver.java v1.0 2022-03-31 14:54
 */
@Component("decreaseReserver")
public class DecreaseReserver extends AbstractAccountingReserver {

    /**
     * 前置处理
     *
     * @param xid     xid
     * @param balance balance
     * @param command accounting command
     */
    @Override
    protected void preReserve(final String xid, final Balance balance, final AccountingCommand command) {

    }

    /**
     * 资金预留
     *
     * @param executor 账务处理器
     * @param xid      xid
     * @param balance  balance
     * @param command  accounting command
     */
    @Override
    protected void doReserve(final AccountingExecutor executor, final String xid, final Balance balance,
                             final AccountingCommand command) {

        executor.addReservedAmount(balance, xid, command.getAmount());
    }

    /**
     * 后置处理
     *
     * @param executor 账务处理器
     * @param xid      xid
     * @param balance  balance
     * @param command  accounting command
     */
    @Override
    protected void postReserve(final AccountingExecutor executor, final String xid, final Balance balance,
                               final AccountingCommand command) {

        // check consistency of memory and db
        executor.checkBalanceConsistency(balance);
    }
}
