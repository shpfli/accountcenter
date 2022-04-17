package pers.hubery.accountcenter.infra.dal.repository;

import pers.hubery.accountcenter.common.model.AccountingRecord;

/**
 * the repository of accounting record
 *
 * @author LiPengfei
 * @version AccountingRecordRepository.java v1.0 2022-04-10 22:48
 */
public interface AccountingRecordRepository {

    /**
     * insert accountingRecord to repository
     *
     * @param record accountingRecord
     */
    void insert(AccountingRecord record);
}
