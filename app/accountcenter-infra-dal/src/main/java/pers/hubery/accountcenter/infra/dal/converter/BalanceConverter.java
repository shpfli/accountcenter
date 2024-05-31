package pers.hubery.accountcenter.infra.dal.converter;

import pers.hubery.accountcenter.common.enums.BalanceDirectionEnum;
import pers.hubery.accountcenter.common.enums.BooleanEnum;
import pers.hubery.accountcenter.common.model.Balance;
import pers.hubery.accountcenter.common.money.Money;
import pers.hubery.accountcenter.infra.dal.dataobject.BalanceDO;

import java.util.Date;

/**
 * 余额 Converter
 */
public class BalanceConverter {


    /**
     * convert BalanceDO to Balance
     *
     * @param data BalanceDO
     * @return Balance
     */
    public static Balance convert(BalanceDO data) {

        if (data == null) {
            return null;
        }

        Balance balance = new Balance();
        balance.setTenantId(data.getTenantId());
        balance.setAccountBook(data.getAccountBook());
        balance.setAccountNo(data.getAccountNo());
        balance.setBalanceType(data.getBalanceType());

        Money balanceAmount = new Money(data.getBalance(), data.getCurrency());
        balance.setBalance(balanceAmount);

        balance.setUnreachedAmt(new Money(data.getUnreachedAmount(), data.getCurrency()));
        balance.setReserveAmt(new Money(data.getReservedAmount(), data.getCurrency()));
        balance.setFrozenAmt(new Money(data.getFrozenAmount(), data.getCurrency()));
        balance.setOverdraftLimit(new Money(data.getOverdraftLimit(), data.getCurrency()));

        balance.setHasUpperLimit(data.getHasUpperLimit() == 1);
        balance.setBalanceDirection(BalanceDirectionEnum.getByCode(data.getBalanceDirection()));
        balance.setBalanceLastChangeTimestamp(new Date(data.getLastAccountingTime()));

        return balance;
    }

    /**
     * convert Balance to BalanceDO
     *
     * @param data Balance 对象
     * @return BalanceDO 对象
     */
    public static BalanceDO convert(Balance data) {

        if (data == null) {
            return null;
        }

        BalanceDO balance = new BalanceDO();
        balance.setTenantId(data.getTenantId());
        balance.setAccountBook(data.getAccountBook());
        balance.setAccountNo(data.getAccountNo());
        balance.setBalanceType(data.getBalanceType());

        balance.setCurrency(data.getBalance().getCurrencyCode());
        balance.setBalance(data.getBalance().getCent());
        balance.setUnreachedAmount(data.getUnreachedAmt().getCent());
        balance.setReservedAmount(data.getReserveAmt().getCent());
        balance.setFrozenAmount(data.getFrozenAmt().getCent());
        balance.setOverdraftLimit(data.getOverdraftLimit().getCent());

        balance.setHasUpperLimit(BooleanEnum.convert(data.isHasUpperLimit()));

        balance.setBalanceDirection(data.getBalanceDirection().getCode());
        balance.setLastAccountingTime(data.getBalanceLastChangeTimestamp().getTime());

        return balance;
    }
}
