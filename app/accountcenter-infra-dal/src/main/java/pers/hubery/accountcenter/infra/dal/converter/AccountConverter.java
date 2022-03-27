package pers.hubery.accountcenter.infra.dal.converter;

import pers.hubery.accountcenter.common.entity.Account;
import pers.hubery.accountcenter.common.enums.AccountLimitedStatusEnum;
import pers.hubery.accountcenter.common.enums.AccountStatusEnum;
import pers.hubery.accountcenter.infra.dal.dataobject.AccountDO;

import java.util.Date;

/**
 * Account 数据转化
 *
 * @author hubery
 * @version AccountConverter.java v1.0 2022-03-24 10:46
 */
public class AccountConverter {

    /**
     * 转化 DO 对象为业务实体
     *
     * @param accountDO AccountDO 对象
     * @return Account对象
     */
    public static Account convert(AccountDO accountDO) {

        if (accountDO == null) {
            return null;
        }

        return Account.builder()
                .tenantId(accountDO.getTenantId())
                .accountBook(accountDO.getAccountBook())
                .accountNo(accountDO.getAccountNo())
                .accountStatus(AccountStatusEnum.getByCode(accountDO.getAccountStatus()))
                .clientNo(accountDO.getClientNo())
                .limitedStatus(AccountLimitedStatusEnum.getByCode(accountDO.getLimitedStatus()))
                .createdTime(new Date(accountDO.getCreatedTime()))
                .modifiedTime(new Date(accountDO.getModifiedTime()))
                .build();
    }
}
