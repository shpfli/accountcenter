package pers.hubery.accountcenter.infra.dal.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pers.hubery.accountcenter.common.enums.TccTransactionStatusEnum;
import pers.hubery.accountcenter.common.model.MainTransaction;
import pers.hubery.accountcenter.infra.dal.dataobject.MainTransactionDO;
import pers.hubery.accountcenter.infra.dal.mapper.MainTransactionMapper;
import pers.hubery.accountcenter.infra.dal.repository.MainTransactionRepository;
import pers.hubery.accountcenter.infra.dal.sharding.ShardingRepositoryTemplate;

/**
 * implements of MainTransactionRepository
 *
 * @author LiPengfei
 * @version MainTransactionRepositoryImpl.java v1.0 2022-03-31 21:22
 */
@Component
public class MainTransactionRepositoryImpl implements MainTransactionRepository {

    /** the logic table name */
    private static final String LOGIC_TABLE_NAME = "tcc_main_transaction";

    /** balance mapper */
    @Autowired
    private MainTransactionMapper mainTransactionMapper;

    /**
     * insert Main Transaction record
     *
     * @param xid    main transaction id
     * @param status transaction status
     */
    @Override
    public void insert(final String xid, final TccTransactionStatusEnum status) {

    }

    /**
     * lock Main Transaction record
     *
     * @param xid main transaction id
     * @return MainTransaction
     */
    @Override
    public MainTransaction lock(final String xid) {
        return null;
    }

    /**
     * update the transaction status
     *
     * @param xid          main transaction id
     * @param targetStatus target status
     */
    @Override
    public void updateStatus(final String xid, final TccTransactionStatusEnum targetStatus) {

    }
}
