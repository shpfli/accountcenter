package pers.hubery.accountcenter.core.accountant;

import pers.hubery.accountcenter.common.model.AccountingCommand;
import pers.hubery.accountcenter.common.model.Balance;

/**
 * the interface of accountant
 *
 * @author LiPengfei
 * @version Accountant.java v1.0 2022-03-31 15:25
 */
public interface Accountant {

    /**
     * 根据指定记账
     *
     * @param balance balance
     * @param command command
     */
    void account(Balance balance, AccountingCommand command);
}
