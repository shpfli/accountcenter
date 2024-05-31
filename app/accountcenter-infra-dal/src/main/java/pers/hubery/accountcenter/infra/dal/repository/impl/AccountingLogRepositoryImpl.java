package pers.hubery.accountcenter.infra.dal.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pers.hubery.accountcenter.common.model.AccountingLog;
import pers.hubery.accountcenter.infra.dal.converter.AccountingLogConverter;
import pers.hubery.accountcenter.infra.dal.mapper.AccountingLogMapper;
import pers.hubery.accountcenter.infra.dal.repository.AccountingLogRepository;

@Component
public class AccountingLogRepositoryImpl implements AccountingLogRepository {

    @Autowired
    private AccountingLogMapper accountingLogMapper;

    /**
     * insert accountingRecord to repository
     *
     * @param record accountingRecord
     */
    @Override
    public void insert(AccountingLog record) {
        accountingLogMapper.insert(AccountingLogConverter.INSTANCE.convert(record));
    }
}
