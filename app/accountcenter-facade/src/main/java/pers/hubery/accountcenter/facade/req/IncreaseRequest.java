package pers.hubery.accountcenter.facade.req;

import org.apache.commons.lang3.StringUtils;

/**
 * 入账具体信息
 *
 * @author hubery
 * @version IncreaseRequest.java v1.0 2022-03-09 08:39 PM
 */
public class IncreaseRequest extends AccountingRequest {

    /**
     * 默认构造器
     */
    public IncreaseRequest() {
        //定义转账方向为转入
        this.action = "IN";
    }

    /**
     * 注意：不要调用该方法
     *
     * @param action 记账动作
     */
    @Override
    public void setAction(final String action) {
        if (!StringUtils.equals(action, ACTION_IN)) {
            throw new UnsupportedOperationException("the action of DecreaseRequest cannot only be 'OUT'");
        }
    }
}
