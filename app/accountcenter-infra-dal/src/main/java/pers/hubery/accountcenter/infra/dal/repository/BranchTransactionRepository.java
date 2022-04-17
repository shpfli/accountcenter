package pers.hubery.accountcenter.infra.dal.repository;


import pers.hubery.accountcenter.common.model.BranchTransaction;

import java.util.List;

/**
 * TCC branch transaction repository
 *
 * @author lipengfei
 */
public interface BranchTransactionRepository {

    /**
     * insert branch transaction record
     *
     * @param branchTransaction TCC branch transaction
     */
    void insert(BranchTransaction branchTransaction);

    /**
     * select by xid and accountBook
     *
     * @param xid         TCC main transaction ID
     * @param accountBook account book, such as : deposit, loan, ……
     * @return branch transaction List
     */
    List<BranchTransaction> selectByXidAndAccountBook(String xid, String accountBook);

    /**
     * select BranchTransaction by reqBizNo
     *
     * @param reqBizNo reqBizNo
     * @return BranchTransaction
     */
    BranchTransaction selectByReqBizNo(String reqBizNo);

    /**
     * delete by xid and accountBook
     *
     * @param xid         TCC main transaction ID
     * @param accountBook account book, such as : deposit, loan, ……
     */
    void delete(String xid, String accountBook);

}




