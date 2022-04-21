package pers.hubery.accountcenter.infra.dal.sharding;

import org.apache.shardingsphere.api.hint.HintManager;
import org.springframework.util.StringUtils;
import pers.hubery.accountcenter.common.context.BizContextHolder;
import pers.hubery.accountcenter.common.enums.ErrorCodeEnum;
import pers.hubery.accountcenter.common.err.SystemException;

/**
 * 分片仓库模板
 *
 * @author LiPengfei
 * @version BaseRepository.java v1.0 2022-03-16 18:10
 */
public class ShardingRepositoryTemplate {

    /**
     * 在指定分片执行sql
     *
     * @param <T>           返回结果泛型
     * @param logicTable    逻辑表名
     * @param shardingIndex 分片
     * @param callback      回调
     * @return 执行结果
     */
    public static <T> T executeWithShardingIndex(final String logicTable, final String shardingIndex,
                                                 ShardingRepositoryCallback<T> callback) {

        HintManager.clear();
        try {
            HintManager hintManager = HintManager.getInstance();
            // 设置分库所需参数
            hintManager.addDatabaseShardingValue(logicTable, shardingIndex);
            // 设置分表所需参数
            hintManager.addTableShardingValue(logicTable, shardingIndex);
            // 执行sql
            return callback.execute();
        } finally {
            HintManager.clear();
        }
    }

    /**
     * 在指定分片执行sql
     *
     * @param <T>        返回结果泛型
     * @param logicTable 逻辑表名
     * @param callback   回调
     * @return 执行结果
     */
    public static <T> T executeWithShardingIndex(final String logicTable, ShardingRepositoryCallback<T> callback) {

        HintManager.clear();
        try {
            //从上下文中获取 shardingIndex
            String shardingIndex = BizContextHolder.getShardingIndex();

            if (StringUtils.isEmpty(shardingIndex)) {
                //sharingIndex 不能为空
                throw new SystemException((ErrorCodeEnum.SHARDING_ROUTE_ERROR));
            }

            HintManager hintManager = HintManager.getInstance();
            // 设置分库所需参数
            hintManager.addDatabaseShardingValue(logicTable, shardingIndex);
            // 设置分表所需参数
            hintManager.addTableShardingValue(logicTable, shardingIndex);
            // 执行sql
            return callback.execute();
        } finally {
            HintManager.clear();
        }
    }

    /**
     * 在指定表分片执行sql 单库分表
     *
     * @param <T>           返回结果泛型
     * @param logicTable    逻辑表名
     * @param shardingIndex 分片
     * @param callback      回调
     * @return 执行结果
     */
    public static <T> T executeWithTableShardingIndex(final String logicTable, final String shardingIndex,
                                                      ShardingRepositoryCallback<T> callback) {

        HintManager.clear();
        try {
            HintManager hintManager = HintManager.getInstance();
            // 设置分表所需参数
            hintManager.addTableShardingValue(logicTable, shardingIndex);
            // 执行sql
            return callback.execute();
        } finally {
            HintManager.clear();
        }
    }
}
