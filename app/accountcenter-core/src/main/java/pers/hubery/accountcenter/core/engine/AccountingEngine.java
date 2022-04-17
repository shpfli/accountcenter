package pers.hubery.accountcenter.core.engine;

import pers.hubery.accountcenter.common.model.AccountingCommand;

import java.util.List;

/**
 * 账务引擎
 *
 * @author LiPengfei
 * @version AccountingEngine.java v1.0 2022-03-30 19:13
 */
public interface AccountingEngine {

    /**
     * TCC 事务一阶段资金预留
     *
     * @param xid     xid
     * @param command accounting command
     */
    void reserve(String xid, AccountingCommand command);

    /**
     * 资金预留解除
     *
     * @param xid xid
     */
    void unreserve(String xid);

    /**
     * 记账
     *
     * @param command accounting command
     */
    void doAccount(AccountingCommand command);

    /**
     * 批量记账
     *
     * @param accountingCommandList accounting command List
     */
    void doAccount(List<AccountingCommand> accountingCommandList);

}
