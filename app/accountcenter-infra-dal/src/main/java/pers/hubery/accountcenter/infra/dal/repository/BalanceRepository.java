package pers.hubery.accountcenter.infra.dal.repository;

import pers.hubery.accountcenter.common.model.Balance;

/**
 * the repository of balance
 *
 * @author LiPengfei
 * @version BalanceRepository.java v1.0 2022-03-30 22:01
 */
public interface BalanceRepository {

    /**
     * select Balance without lock it
     *
     * @param accountNo   account no
     * @param balanceType balance type
     * @return Balance
     */
    Balance get(String accountNo, String balanceType);

    /**
     * select Balance and lock it
     *
     * @param accountNo   account no
     * @param balanceType balance type
     * @return Balance
     */
    Balance lockAndGet(String accountNo, String balanceType);

    /**
     * update unreached amount
     *
     * @param balance balance record
     */
    void updateUnreachedAmount(Balance balance);

    /**
     * update reserved amount
     *
     * @param balance balance record
     */
    void updateReservedAmount(Balance balance);

    /**
     * update balance amount
     *
     * @param balance balance record
     */
    void updateBalanceAmount(Balance balance);
}
