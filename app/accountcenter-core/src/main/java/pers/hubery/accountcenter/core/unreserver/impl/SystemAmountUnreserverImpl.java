package pers.hubery.accountcenter.core.unreserver.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pers.hubery.accountcenter.common.enums.SystemAmountTypeEnum;
import pers.hubery.accountcenter.common.err.BizException;
import pers.hubery.accountcenter.common.model.Balance;
import pers.hubery.accountcenter.common.model.SystemAmount;
import pers.hubery.accountcenter.core.manager.BalanceManager;
import pers.hubery.accountcenter.core.manager.SystemAmountManager;
import pers.hubery.accountcenter.core.unreserver.SystemAmountUnreserver;

/**
 * 系统金额还原器实现
 *
 * @author LiPengfei
 * @version SystemAmountUnreserverImpl.java v1.0 2022-03-31 17:43
 */
@Component("systemAmountUnreserver")
public class SystemAmountUnreserverImpl implements SystemAmountUnreserver {

    /** systemAmountManager */
    @Autowired
    private SystemAmountManager systemAmountManager;

    /** balanceManager */
    @Autowired
    private BalanceManager balanceManager;

    /**
     * 还原系统金额
     *
     * @param balance      the balance
     * @param systemAmount the SystemAmount
     */
    @Override
    public void unreserve(final Balance balance, final SystemAmount systemAmount) {

        //1. 解析金额类型枚举
        SystemAmountTypeEnum amountTypeEnum = SystemAmountTypeEnum.parseSystemAmountTypeEnum(systemAmount.getAmountType());

        //2. 还原系统金额
        switch (amountTypeEnum) {
            case UNREACHED_BALANCE:
                balanceManager.subtractUnreachedAmount(balance, systemAmount.getAmount());
                break;
            case RESERVED_BALANCE:
                balanceManager.subtractReserveAmount(balance, systemAmount.getAmount());
                break;
            default:
                throw new UnsupportedOperationException();
        }

        //3. 删除系统金额记录
        systemAmountManager.remove(systemAmount);

    }
}
