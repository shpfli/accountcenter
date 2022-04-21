package pers.hubery.accountcenter.infra.dal.repository;

import pers.hubery.accountcenter.common.model.AccountingLog;

/**
 * the repository of accounting record
 *
 * @author LiPengfei
 * @version AccountingLogRepository.java v1.0 2022-04-10 22:48
 */
public interface AccountingLogRepository {

    /**
     * insert accountingRecord to repository
     *
     * @param record accountingRecord
     */
    void insert(AccountingLog record);
}
