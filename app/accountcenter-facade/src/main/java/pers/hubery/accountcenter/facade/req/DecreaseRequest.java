package pers.hubery.accountcenter.facade.req;

import org.apache.commons.lang3.StringUtils;

/**
 * 余额减少请求
 *
 * @author hubery
 * @version DecreaseRequest.java v1.0 2022-03-09 08:39 PM
 */
public class DecreaseRequest extends AccountingRequest {

    /**
     * 默认构造器
     */
    public DecreaseRequest() {
        //定义转账方向为转出
        this.action = ACTION_OUT;
    }

    /**
     * 注意：不要调用该方法
     *
     * @param action 记账动作
     */
    @Override
    public void setAction(final String action) {
        if (!StringUtils.equals(action, ACTION_OUT)) {
            throw new UnsupportedOperationException("the action of DecreaseRequest cannot only be 'OUT'");
        }
    }
}
