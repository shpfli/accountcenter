package pers.hubery.accountcenter.core.reserver;

import pers.hubery.accountcenter.common.model.AccountingCommand;
import pers.hubery.accountcenter.common.model.Balance;

/**
 * 资金预留器接口
 *
 * @author LiPengfei
 * @version AccountingReserver.java v1.0 2022-03-31 14:46
 */
public interface AccountingReserver {

    /**
     * 资金预留
     *
     * @param xid     xid
     * @param balance balance
     * @param command accounting command
     */
    void reserve(final String xid, final Balance balance, AccountingCommand command);
}
