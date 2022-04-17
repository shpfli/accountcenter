package pers.hubery.accountcenter.core.manager;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pers.hubery.accountcenter.common.enums.ErrorCodeEnum;
import pers.hubery.accountcenter.common.err.BizException;
import pers.hubery.accountcenter.common.model.Balance;
import pers.hubery.accountcenter.common.money.Money;
import pers.hubery.accountcenter.infra.dal.repository.BalanceRepository;

import java.util.Date;

/**
 * balance manager
 *
 * @author LiPengfei
 * @version BalanceManager.java v1.0 2022-03-30 22:07
 */
@Component
public class BalanceManager {

    /** balance repository */
    @Autowired
    private BalanceRepository balanceRepository;

    /**
     * 查询余额记录
     *
     * @param accountNo   account no
     * @param balanceType balance type
     * @return Balance
     */
    public Balance getBalanceFromDb(String accountNo, String balanceType) {

        Balance result = balanceRepository.get(accountNo, balanceType);

        if (result == null) {
            throw new BizException(ErrorCodeEnum.ACCOUNT_NOT_EXISTS, "account doesn't exist. accountNo : " + accountNo);
        }

        return result;
    }

    /**
     * 锁查余额记录
     *
     * @param accountNo   account no
     * @param balanceType balance type     * @return Balance
     */
    public Balance lockBalance(String accountNo, String balanceType) {

        Balance result = balanceRepository.lockAndGet(accountNo, balanceType);

        if (result == null) {
            throw new BizException(ErrorCodeEnum.ACCOUNT_NOT_EXISTS, "account doesn't exist. accountNo : " + accountNo);
        }

        return result;
    }

    /**
     * handle balance amt change
     *
     * @param balance        balance object
     * @param changedAmount  changedAmount. changedAmount > 0 means add; changedAmount < 0, means subtract
     * @param accountDate    account date
     * @param accountingTime the time when the request come to accountcenter
     */
    public void handleBalanceAmtChange(Balance balance, Money changedAmount, String accountDate, Date accountingTime) {

        // balance last change date
        String lastChangeDate = balance.getBalanceLastChangeDate();

        // 1. compute
        // 1.1 account in current day
        if (StringUtils.equals(accountDate, lastChangeDate)) {

            // compute new balance amount
            balance.setBalance(balance.getBalance().add(changedAmount));
        }
        // 1.2 account in a new Day
        else if (accountDate.compareTo(lastChangeDate) > 0) {

            //preBalance = balance
            balance.setPrevBalance(balance.getBalance());
            //balance = balance + changedAmount
            balance.setBalance(balance.getBalance().add(changedAmount));
            balance.setBalanceLastChangeDate(accountDate);
        }
        // 1.3 account in yesterday
        else {
            //preBalance = preBalance + changedAmount
            balance.setPrevBalance(balance.getPrevBalance().add(changedAmount));
            //balance = balance + changedAmount
            balance.setBalance(balance.getBalance().add(changedAmount));
        }

        Date balanceLastChangeTimestamp = balance.getBalanceLastChangeTimestamp();

        if (balanceLastChangeTimestamp == null || accountingTime.after(balanceLastChangeTimestamp)) {
            balance.setBalanceLastChangeTimestamp(accountingTime);
        }

        // 2. save to DB
        balanceRepository.updateBalanceAmount(balance);

    }

    /**
     * add unreached amount of balance record
     *
     * @param balance balance record
     * @param toAdd   amount to add
     */
    public void addUnreachedAmount(Balance balance, Money toAdd) {

        // 1. compute new val
        balance.setUnreachedAmt(balance.getUnreachedAmt().add(toAdd));

        // 2. save to DB
        balanceRepository.updateUnreachedAmount(balance);

    }

    /**
     * add reserved amount of balance record
     *
     * @param balance balance record
     * @param toAdd   amount to add
     */
    public void addReservedAmount(Balance balance, Money toAdd) {

        // 1. compute new val
        balance.setReserveAmt(balance.getReserveAmt().add(toAdd));

        // 2. save to DB
        balanceRepository.updateReservedAmount(balance);

    }

    /**
     * subtract unreached amount of balance record
     *
     * @param balance    balance record
     * @param toSubtract amount to subtract
     */
    public void subtractUnreachedAmount(Balance balance, Money toSubtract) {

        // 1. compute new val
        balance.setUnreachedAmt(balance.getUnreachedAmt().subtract(toSubtract));

        // 2. save to DB
        balanceRepository.updateUnreachedAmount(balance);
    }

    /**
     * subtract from reserve amount
     *
     * @param balance    balance record
     * @param toSubtract the amount to subtract
     */
    public void subtractReserveAmount(final Balance balance, final Money toSubtract) {

        // 1. compute new val
        balance.setReserveAmt(balance.getReserveAmt().subtract(toSubtract));

        // 2. save to DB
        balanceRepository.updateReservedAmount(balance);
    }
}
