package pers.hubery.accountcenter.infra.dal.repository;

import pers.hubery.accountcenter.common.model.SystemAmount;

import java.util.List;

/**
 * the repository of SystemAmount
 *
 * @author LiPengfei
 * @version SystemAmountRepository.java v1.0 2022-03-31 17:10
 */
public interface SystemAmountRepository {

    /**
     * insert systemAmount record to DB
     *
     * @param systemAmount systemAmount record
     */
    void insert(SystemAmount systemAmount);

    /**
     * find all matching SystemAmounts by xid and accountBook
     *
     * @param xid         xid
     * @return systemAmountList
     */
    List<SystemAmount> findByXid(String xid);

    /**
     * find system amount records
     *
     * @param xid         xid
     * @param accountNo   account no
     * @param balanceType balance type
     * @return records
     */
    List<SystemAmount> find(String xid, String accountNo, String balanceType);

    /**
     * delete all matching SystemAmounts by xid and accountBook
     *  @param xid         xid
     *
     */
    void deleteByXid(String xid);

    /**
     * delete specified record
     *
     * @param systemAmount the record to delete
     */
    void delete(SystemAmount systemAmount);

    /**
     * update amount of systemAmountRecord
     *
     * @param systemAmount systemAmountRecord
     */
    void updateAmount(SystemAmount systemAmount);
}
