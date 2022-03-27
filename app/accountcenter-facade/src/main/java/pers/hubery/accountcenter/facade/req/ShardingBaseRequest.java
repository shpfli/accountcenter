package pers.hubery.accountcenter.facade.req;

/**
 * 分片请求基类
 *
 * @author hubery
 * @version ShardingRequest.java v1.0 2022-03-27 21:27
 */
public abstract class ShardingBaseRequest extends BaseRequest {

    /** serialVersionUID */
    private static final long serialVersionUID = 4938952937847392668L;

    /** 数据分片索引 */
    private String shardingIndex;

    /**
     * Getter method for property <tt>shardingIndex</tt>.
     *
     * @return property value of shardingIndex
     */
    public String getShardingIndex() {
        return shardingIndex;
    }

    /**
     * Setter method for property <tt>shardingIndex</tt>.
     *
     * @param shardingIndex value to be assigned to property shardingIndex
     */
    public void setShardingIndex(final String shardingIndex) {
        this.shardingIndex = shardingIndex;
    }
}
