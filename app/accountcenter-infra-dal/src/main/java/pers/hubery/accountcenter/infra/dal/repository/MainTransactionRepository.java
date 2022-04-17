package pers.hubery.accountcenter.infra.dal.repository;

import pers.hubery.accountcenter.common.enums.TccTransactionStatusEnum;
import pers.hubery.accountcenter.common.model.MainTransaction;

/**
 * the repository of tcc main transaction
 *
 * @author LiPengfei
 * @version MainTransactionRepository.java v1.0 2022-03-30 18:13
 */
public interface MainTransactionRepository {

    /**
     * insert Main Transaction record
     *  @param xid         main transaction id
     * @param status      transaction status
     */
    void insert(final String xid, final TccTransactionStatusEnum status);

    /**
     * lock Main Transaction record
     *
     * @param xid         main transaction id
     * @return MainTransaction
     */
    MainTransaction lock(String xid);

    /**
     * update the transaction status
     *  @param xid          main transaction id
     * @param targetStatus target status
     */
    void updateStatus(String xid, TccTransactionStatusEnum targetStatus);
}
