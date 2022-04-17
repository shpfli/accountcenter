package pers.hubery.accountcenter.core.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import pers.hubery.accountcenter.common.model.SystemAmount;
import pers.hubery.accountcenter.common.money.Money;
import pers.hubery.accountcenter.infra.dal.repository.SystemAmountRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * the manager of SystemAmount
 *
 * @author LiPengfei
 * @version SystemAmountManager.java v1.0 2022-03-31 17:07
 */
@Component
public class SystemAmountManager {

    /** systemAmountRepository */
    @Autowired
    private SystemAmountRepository systemAmountRepository;

    /**
     * 查询指定的分布式事务下所有的系统金额，并删除
     *
     * @param xid 分布式事务ID
     * @return systemAmountList
     */
    public List<SystemAmount> getAndRemove(String xid) {

        List<SystemAmount> results = systemAmountRepository.findByXid(xid);

        if (!CollectionUtils.isEmpty(results)) {
            systemAmountRepository.deleteByXid(xid);
        }

        return results;
    }

    /**
     * 获取指定余额的事务金额Map
     *
     * @param xid         xid
     * @param accountNo   account no
     * @param balanceType balance type
     * @return systemAmountMap
     */
    public Map<String, SystemAmount> getSystemAmountMap(String xid, String accountNo, String balanceType) {

        //1. 查询指定余额的在该事务下的所有事务金额记录
        List<SystemAmount> results = systemAmountRepository.find(xid, accountNo, balanceType);

        if (CollectionUtils.isEmpty(results)) {
            return new HashMap<>(0);
        }

        //2. build result map
        Map<String, SystemAmount> resultMap = new HashMap<>();

        results.forEach(item -> resultMap.put(item.getAmountType(), item));

        return resultMap;
    }

    /**
     * 增加事务金额
     *
     * @param systemAmount SystemAmount record
     * @param toAdd        amount to add
     */
    public void addAmount(SystemAmount systemAmount, Money toAdd) {

        // 1. compute new val
        systemAmount.setAmount(systemAmount.getAmount().add(toAdd));

        // 2. save to db
        systemAmountRepository.updateAmount(systemAmount);
    }

    /**
     * 扣减事务金额
     *
     * @param systemAmount SystemAmount record
     * @param toSubtract   amount to subtract
     */
    public void subtractAmount(SystemAmount systemAmount, Money toSubtract) {

        // 1. compute new val
        systemAmount.setAmount(systemAmount.getAmount().subtract(toSubtract));

        // 2. save to db
        systemAmountRepository.updateAmount(systemAmount);
    }

    /**
     * 删除事务金额记录
     *
     * @param systemAmount toDelete
     */
    public void remove(SystemAmount systemAmount) {
        systemAmountRepository.delete(systemAmount);
    }

    /**
     * 插入事务金额记录
     *
     * @param systemAmount the record to insert
     */
    public void insert(final SystemAmount systemAmount) {

        systemAmountRepository.insert(systemAmount);
    }
}
