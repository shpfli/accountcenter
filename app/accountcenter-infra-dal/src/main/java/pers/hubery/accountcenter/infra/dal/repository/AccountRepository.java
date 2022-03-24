package pers.hubery.accountcenter.infra.dal.repository;

import pers.hubery.accountcenter.common.model.Account;

/**
 * 账户仓库
 *
 * @author hubery
 * @version AccountRepository.java v1.0 2022-03-24 10:12
 */
public interface AccountRepository {

    /**
     * 根据账号获取账户
     *
     * @param accountNo 账号
     * @return Account
     */
    Account getAccount(String accountNo);
}
