package pers.hubery.accountcenter.core.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;
import pers.hubery.accountcenter.common.enums.ErrorCodeEnum;
import pers.hubery.accountcenter.common.err.IdempotentException;
import pers.hubery.accountcenter.common.err.SystemException;
import pers.hubery.accountcenter.common.model.BranchTransaction;
import pers.hubery.accountcenter.infra.dal.repository.BranchTransactionRepository;

import java.util.List;
import java.util.Objects;

/**
 * TCC branch transaction manager
 *
 * @author LiPengfei
 * @version BranchTransactionManager.java v1.0 2022-03-30 20:31
 */
@Component("branchTransactionManager")
public class BranchTransactionManager {

    /** TCC branch transaction repository */
    @Autowired
    private BranchTransactionRepository branchTransactionRepository;

    /**
     * record branch transaction record
     *
     * @param branchTransaction TCC branch transaction
     */
    public void recordBranchTransaction(BranchTransaction branchTransaction) {

        try {
            branchTransactionRepository.insert(branchTransaction);
        } catch (DuplicateKeyException e) {
            // 1. query
            BranchTransaction exist = branchTransactionRepository.selectByReqBizNo(branchTransaction.getReqBizNo());
            if (Objects.equals(exist, branchTransaction)) {

                throw new IdempotentException("duplicate branch transaction : " + branchTransaction.getReqBizNo());
            }

            throw new SystemException(ErrorCodeEnum.DB_EXCEPTION);
        }
    }

    /**
     * get branch transaction records by xid and accountBook
     *
     * @param xid TCC main transaction ID
     * @return branch transaction List
     */
    public List<BranchTransaction> get(String xid) {

        return branchTransactionRepository.findByXid(xid);
    }

    /**
     * remove branch transaction records
     *
     * @param xid TCC main transaction ID
     */
    public void remove(String xid) {

        // then delete them
        branchTransactionRepository.delete(xid);
    }
}
