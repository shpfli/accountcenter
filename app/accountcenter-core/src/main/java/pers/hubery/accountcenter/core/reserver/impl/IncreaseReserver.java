package pers.hubery.accountcenter.core.reserver.impl;

import org.springframework.stereotype.Component;
import pers.hubery.accountcenter.common.model.AccountingCommand;
import pers.hubery.accountcenter.common.model.Balance;
import pers.hubery.accountcenter.core.executor.AccountingExecutor;

/**
 * 余额增加资金预留器
 *
 * @author LiPengfei
 * @version IncreaseReserver.java v1.0 2022-03-31 14:54
 */
@Component("increaseReserver")
public class IncreaseReserver extends AbstractAccountingReserver {

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

        executor.addUnreachedAmount(balance, xid, command.getAmount());
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

        // 兜底检查资金连续性
        executor.checkBalanceConsistency(balance);
    }
}
