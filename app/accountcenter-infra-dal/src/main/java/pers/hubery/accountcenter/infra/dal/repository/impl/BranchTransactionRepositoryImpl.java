package pers.hubery.accountcenter.infra.dal.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pers.hubery.accountcenter.common.model.BranchTransaction;
import pers.hubery.accountcenter.infra.dal.dataobject.BranchTransactionDO;
import pers.hubery.accountcenter.infra.dal.mapper.BranchTransactionMapper;
import pers.hubery.accountcenter.infra.dal.repository.BranchTransactionRepository;
import pers.hubery.accountcenter.infra.dal.sharding.ShardingRepositoryTemplate;

import java.util.List;

/**
 * implements of BranchTransactionRepository
 *
 * @author LiPengfei
 * @version BranchTransactionRepositoryImpl.java v1.0 2022-03-31 22:06
 */
@Component
public class BranchTransactionRepositoryImpl implements BranchTransactionRepository {

    /** the logic table name */
    private static final String LOGIC_TABLE_NAME = "tcc_branch_transaction";

    /** branchTransactionMapper */
    @Autowired
    private BranchTransactionMapper branchTransactionMapper;

    /**
     * insert branch transaction record
     *
     * @param branchTransaction TCC branch transaction
     */
    @Override
    public void insert(final BranchTransaction branchTransaction) {

    }

    /**
     * select by xid and accountBook
     *
     * @param xid TCC main transaction ID
     * @return branch transaction List
     */
    @Override
    public List<BranchTransaction> findByXid(final String xid) {
        return null;
    }

    /**
     * select BranchTransaction by reqBizNo
     *
     * @param reqBizNo reqBizNo
     * @return BranchTransaction
     */
    @Override
    public BranchTransaction selectByReqBizNo(final String reqBizNo) {
        return null;
    }

    /**
     * delete by xid and accountBook
     *
     * @param xid TCC main transaction ID
     */
    @Override
    public void delete(final String xid) {

    }
}
