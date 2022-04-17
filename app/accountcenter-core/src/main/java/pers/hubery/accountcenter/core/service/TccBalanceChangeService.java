package pers.hubery.accountcenter.core.service;

import pers.hubery.accountcenter.common.model.AccountingCommand;

/**
 * 基于TCC协议的余额变动服务
 *
 * @author LiPengfei
 * @version TccBalanceChangeService.java v1.0 2022-03-30 11:37
 */
public interface TccBalanceChangeService {

    /**
     * 执行资金预处理
     *
     * @param xid               TCC 事务 ID
     * @param branchId          TCC 参与者 ID
     * @param balanceChangeInfo 余额变动信息
     */
    void prepare(String xid, long branchId, AccountingCommand balanceChangeInfo);

    /**
     * 回滚
     *
     * @param xid         TCC 事务 ID
     * @param branchId    TCC 参与者 ID
     * @param accountBook account book, such as : deposit, loan, ……
     */
    void rollback(String xid, Long branchId, final String accountBook);

    /**
     * 提交
     *
     * @param xid         TCC 事务 ID
     * @param branchId    TCC 参与者 ID
     * @param accountBook
     */
    void commit(String xid, Long branchId, final String accountBook);

}
