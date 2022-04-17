package pers.hubery.accountcenter.core.unreserver;

import pers.hubery.accountcenter.common.model.Balance;
import pers.hubery.accountcenter.common.model.SystemAmount;

/**
 * 系统金额还原器
 *
 * @author LiPengfei
 * @version SystemAmountUnreserver.java v1.0 2022-03-31 17:39
 */
public interface SystemAmountUnreserver {

    /**
     * 还原系统金额
     *
     * @param balance      the balance
     * @param systemAmount the SystemAmount
     */
    void unreserve(Balance balance, SystemAmount systemAmount);
}
