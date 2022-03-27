package pers.hubery.accountcenter.facade;

import pers.hubery.accountcenter.facade.req.AccountQueryRequest;
import pers.hubery.accountcenter.facade.rsp.AccountQueryResponse;

/**
 * 账户查询服务 Facade
 *
 * @author hubery
 * @version AccountQueryFacade.java v1.0 2022-03-27 21:21
 */
public interface AccountQueryFacade {

    /**
     * 获取账户信息
     *
     * @param request 查询请求
     * @return 查询响应
     */
    AccountQueryResponse getAccountInfo(AccountQueryRequest request);
}
