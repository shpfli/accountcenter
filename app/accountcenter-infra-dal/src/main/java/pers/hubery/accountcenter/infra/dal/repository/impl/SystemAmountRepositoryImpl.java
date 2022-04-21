package pers.hubery.accountcenter.infra.dal.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pers.hubery.accountcenter.common.model.SystemAmount;
import pers.hubery.accountcenter.infra.dal.mapper.TransactionAmountMapper;
import pers.hubery.accountcenter.infra.dal.repository.SystemAmountRepository;
import pers.hubery.accountcenter.infra.dal.sharding.ShardingRepositoryTemplate;

import java.util.List;

/**
 * implements SystemAmountRepository
 *
 * @author LiPengfei
 * @version SystemAmountRepositoryImpl.java v1.0 2022-03-31 22:50
 */
@Component
public class SystemAmountRepositoryImpl implements SystemAmountRepository {

    /** the logic table name */
    private static final String LOGIC_TABLE_NAME = "tcc_transaction_amount";

    /** transactionAmountMapper */
    @Autowired
    private TransactionAmountMapper transactionAmountMapper;

    /**
     * insert systemAmount record to DB
     *
     * @param systemAmount systemAmount record
     */
    @Override
    public void insert(final SystemAmount systemAmount) {

    }

    /**
     * find all matching SystemAmounts by xid and accountBook
     *
     * @param xid xid
     * @return systemAmountList
     */
    @Override
    public List<SystemAmount> findByXid(final String xid) {
        return null;
    }

    /**
     * find system amount records
     *
     * @param xid         xid
     * @param accountNo   account no
     * @param balanceType balance type
     * @return records
     */
    @Override
    public List<SystemAmount> find(final String xid, final String accountNo, final String balanceType) {
        return null;
    }

    /**
     * delete all matching SystemAmounts by xid and accountBook
     *
     * @param xid xid
     */
    @Override
    public void deleteByXid(final String xid) {

    }

    /**
     * delete specified record
     *
     * @param systemAmount the record to delete
     */
    @Override
    public void delete(final SystemAmount systemAmount) {

    }

    /**
     * update amount of systemAmountRecord
     *
     * @param systemAmount systemAmountRecord
     */
    @Override
    public void updateAmount(final SystemAmount systemAmount) {

    }
}
