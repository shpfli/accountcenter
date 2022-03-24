package pers.hubery.accountcenter.infra.dal.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import pers.hubery.accountcenter.common.context.BizContextHolder;
import pers.hubery.accountcenter.common.entity.Account;
import pers.hubery.accountcenter.infra.dal.converter.AccountConverter;
import pers.hubery.accountcenter.infra.dal.mapper.AccountMapper;
import pers.hubery.accountcenter.infra.dal.repository.AccountRepository;

/**
 * 账户仓库实现
 *
 * @author hubery
 * @version AccountRepositoryImpl.java v1.0 2022-03-24 10:16
 */
public class AccountRepositoryImpl implements AccountRepository {

    /** accountMapper */
    @Autowired
    private AccountMapper accountMapper;

    /**
     * 根据账号获取账户
     *
     * @param accountNo 账号
     * @return Account
     */
    @Override
    public Account getAccount(final String accountNo) {

        return AccountConverter.convert(
                accountMapper.selectByUK(
                        BizContextHolder.getTenantId(),
                        BizContextHolder.getAccountBook(),
                        accountNo));
    }
}
