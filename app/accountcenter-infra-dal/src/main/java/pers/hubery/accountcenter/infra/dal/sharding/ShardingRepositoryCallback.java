package pers.hubery.accountcenter.infra.dal.sharding;

/**
 * 回调
 *
 * @author LiPengfei
 * @version ShardingRepositoryCallback.java v1.0 2022-03-16 18:14
 */
public interface ShardingRepositoryCallback<T> {

    /**
     * 执行sql
     *
     * @return 执行结果
     */
    T execute();
}
