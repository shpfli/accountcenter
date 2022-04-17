package pers.hubery.accountcenter.core.accountant.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import pers.hubery.accountcenter.common.model.AccountingCommand;
import pers.hubery.accountcenter.common.model.Balance;
import pers.hubery.accountcenter.core.accountant.Accountant;
import pers.hubery.accountcenter.core.executor.AccountingExecutor;

/**
 * Accountant implements
 *
 * @author LiPengfei
 * @version AccountantImpl.java v1.0 2022-03-31 16:37
 */
@Component("accountant")
public class AccountantImpl implements Accountant {

    /** the AccountingExecutor impl by standard accounting mod */
    @Autowired
    @Qualifier("standardExecutor")
    private AccountingExecutor standardExecutor;

    /**
     * 根据指定记账
     *
     * @param balance balance
     * @param command command
     */
    @Override
    public void account(final Balance balance, final AccountingCommand command) {

        // 1. TODO 决策记账模式
        AccountingExecutor executor = standardExecutor;

        // 2. do account
        switch (command.getAction()) {
            case IN:
                executor.increase(balance, command);
                break;
            case OUT:
                executor.decrease(balance, command);
                break;
            case FREEZE:
                executor.freeze(balance, command);
                break;
            case UNFREEZE:
                executor.unfreeze(balance, command);
                break;
            default:
                throw new UnsupportedOperationException("unsupported accounting action : " + command.getAction());
        }
    }
}
