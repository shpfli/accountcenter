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
     *
     * @param xid         main transaction id
     * @param accountBook account book
     * @param status      transaction status
     */
    void insert(final String xid, final String accountBook, final TccTransactionStatusEnum status);

    /**
     * lock Main Transaction record
     *
     * @param xid         main transaction id
     * @param accountBook account book
     * @return MainTransaction
     */
    MainTransaction lock(String xid, String accountBook);

    /**
     * update the transaction status
     *
     * @param xid          main transaction id
     * @param accountBook  account book
     * @param targetStatus target status
     */
    void updateStatus(String xid, String accountBook, TccTransactionStatusEnum targetStatus);
}
