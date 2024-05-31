package pers.hubery.accountcenter.infra.dal.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pers.hubery.accountcenter.common.context.BizContextHolder;
import pers.hubery.accountcenter.common.model.Balance;
import pers.hubery.accountcenter.infra.dal.converter.BalanceConverter;
import pers.hubery.accountcenter.infra.dal.dataobject.BalanceDO;
import pers.hubery.accountcenter.infra.dal.mapper.BalanceMapper;
import pers.hubery.accountcenter.infra.dal.repository.BalanceRepository;

@Repository("balanceRepository")
public class BalanceRepositoryImpl implements BalanceRepository {

    /**
     * 余额 Mapper
     */
    @Autowired
    private BalanceMapper balanceMapper;

    /**
     * select Balance without lock it
     *
     * @param accountNo   account no
     * @param balanceType balance type
     * @return Balance
     */
    @Override
    public Balance get(String accountNo, String balanceType) {


        BalanceDO data = balanceMapper.select(BizContextHolder.getTenantId(), BizContextHolder.getAccountBook(), accountNo, balanceType);
        return BalanceConverter.convert(data);
    }

    /**
     * select Balance and lock it
     *
     * @param accountNo   account no
     * @param balanceType balance type
     * @return Balance
     */
    @Override
    public Balance lockAndGet(String accountNo, String balanceType) {

        BalanceDO data = balanceMapper.selectForUpdate(BizContextHolder.getTenantId(), BizContextHolder.getAccountBook(), accountNo, balanceType);
        return BalanceConverter.convert(data);
    }

    /**
     * update unreached amount
     *
     * @param balance balance record
     */
    @Override
    public void updateUnreachedAmount(Balance balance) {
        balanceMapper.updateUnreachedAmount(BalanceConverter.convert(balance));
    }

    /**
     * update reserved amount
     *
     * @param balance balance record
     */
    @Override
    public void updateReservedAmount(Balance balance) {
        balanceMapper.updateReservedAmount(BalanceConverter.convert(balance));
    }

    /**
     * update balance amount
     *
     * @param balance balance record
     */
    @Override
    public void updateBalanceAmount(Balance balance) {
        balanceMapper.updateBalanceAmount(BalanceConverter.convert(balance));
    }
}
