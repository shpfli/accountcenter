package pers.hubery.accountcenter.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pers.hubery.accountcenter.biz.tpl.AccountCenterServiceCallback;
import pers.hubery.accountcenter.biz.tpl.AccountCenterServiceTemplate;
import pers.hubery.accountcenter.common.model.Account;
import pers.hubery.accountcenter.common.enums.ErrorCodeEnum;
import pers.hubery.accountcenter.common.err.BizException;
import pers.hubery.accountcenter.common.util.Asserter;
import pers.hubery.accountcenter.facade.AccountQueryFacade;
import pers.hubery.accountcenter.facade.dto.AccountInfo;
import pers.hubery.accountcenter.facade.req.AccountQueryRequest;
import pers.hubery.accountcenter.facade.rsp.AccountQueryResponse;
import pers.hubery.accountcenter.infra.dal.repository.AccountRepository;

/**
 * 账户查询服务实现
 *
 * @author hubery
 * @version AccountQueryFacadeImpl.java v1.0 2022-03-27 22:07
 */
@Service("accountQueryFacade")
public class AccountQueryFacadeImpl implements AccountQueryFacade {

    /** 账户仓库 */
    @Autowired
    @Qualifier("accountRepository")
    private AccountRepository accountRepository;

    /**
     * 获取账户信息
     *
     * @param request 查询请求
     * @return 查询响应
     */
    @Override
    public AccountQueryResponse getAccountInfo(final AccountQueryRequest request) {

        AccountQueryResponse response = new AccountQueryResponse();

        AccountCenterServiceTemplate.process(request, response, new AccountCenterServiceCallback() {
            @Override
            public void validateRequest() {
                Asserter.assertNotBlank(request.getAccountNo(), ErrorCodeEnum.ACCOUNT_NO_CANNOT_BE_NULL);
            }

            @Override
            public void doBizCheck() {

            }

            @Override
            public void doService() {
                AccountInfo accountInfo = convert(accountRepository.getAccount(request.getAccountNo()));

                if (accountInfo == null) {
                    throw new BizException(ErrorCodeEnum.ACCOUNT_NOT_EXISTS, "账户不存在！accountNo: " + request.getAccountNo());
                }

                response.setResult(accountInfo);
            }
        });

        return response;
    }

    /**
     * 转化内部的 Account 对象为 AccountInfo 对象
     *
     * @param account Account 对象
     * @return AccountInfo 对象
     */
    private static AccountInfo convert(Account account) {

        if (account == null) {
            return null;
        }

        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setTenantId(account.getTenantId());
        accountInfo.setAccountBook(account.getAccountBook());
        accountInfo.setAccountNo(account.getAccountNo());
        accountInfo.setClientNo(account.getClientNo());
        accountInfo.setAccountStatus(account.getAccountStatus().getCode());
        accountInfo.setLimitedStatus(account.getLimitedStatus().getCode());

        return accountInfo;
    }
}
