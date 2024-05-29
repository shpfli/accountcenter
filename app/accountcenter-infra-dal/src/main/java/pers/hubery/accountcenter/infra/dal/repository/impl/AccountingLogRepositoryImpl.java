package pers.hubery.accountcenter.infra.dal.repository.impl;

import org.springframework.stereotype.Component;
import pers.hubery.accountcenter.common.model.AccountingLog;
import pers.hubery.accountcenter.infra.dal.repository.AccountingLogRepository;

@Component
public class AccountingLogRepositoryImpl implements AccountingLogRepository {

    /**
     * insert accountingRecord to repository
     *
     * @param record accountingRecord
     */
    @Override
    public void insert(AccountingLog record) {
        //TODO
    }
}
