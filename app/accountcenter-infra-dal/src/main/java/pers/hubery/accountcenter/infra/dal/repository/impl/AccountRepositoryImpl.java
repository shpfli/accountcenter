package pers.hubery.accountcenter.infra.dal.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import pers.hubery.accountcenter.common.model.Account;
import pers.hubery.accountcenter.infra.dal.dataobject.AccountDO;
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

    @Override
    public Account getAccount(final String accountNo) {

        //AccountDO accountDO = accountMapper.selectByUK();

        return null;
    }
}
