package pers.hubery.accountcenter.infra.dal.sharding;

import org.apache.shardingsphere.api.sharding.hint.HintShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.hint.HintShardingValue;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 默认算法：根据 shardingIndex 路由
 *
 * @author LiPengfei
 * @version DefaultShardingAlgorithm.java v1.0 2022-03-16 17:07
 */
public class DefaultShardingAlgorithm implements HintShardingAlgorithm<String> {

    /**
     * Sharding.
     *
     * <p>sharding value injected by hint, not in SQL.</p>
     *
     * @param availableTargetNames available data sources or tables's names
     * @param shardingValue        sharding value
     * @return sharding result for data sources or tables's names
     */
    @Override
    public Collection<String> doSharding(final Collection<String> availableTargetNames, final HintShardingValue<String> shardingValue) {

        // 返回结果，根据shardingIndex指挥匹配一个
        Collection<String> results = new ArrayList<>(1);

        // 遍历查找
        for (String targetName : availableTargetNames) {

            for (String value : shardingValue.getValues()) {

                // 按照约定，表名、数据源名默认以 shardingIndex 结尾
                if (targetName.endsWith(value)) {

                    results.add(targetName);

                    // 按照shardingIndex必定是精确路由，所以找到一个即可返回
                    return results;
                }
            }
        }

        // 如果没找到，这里会返回空列表，shardingSphere 会抛出异常
        return results;
    }
}
