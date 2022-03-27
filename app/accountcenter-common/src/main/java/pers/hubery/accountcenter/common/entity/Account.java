package pers.hubery.accountcenter.common.entity;

import lombok.Builder;
import lombok.Data;
import pers.hubery.accountcenter.common.enums.AccountLimitedStatusEnum;
import pers.hubery.accountcenter.common.enums.AccountStatusEnum;

import java.util.Date;

/**
 * 账户VO
 *
 * @author hubery
 */
@Data
@Builder
public class Account {

    /**
     * 租户ID
     */
    private String tenantId;

    /**
     * 账本
     */
    private String accountBook;

    /**
     * 账号
     */
    private String accountNo;

    /**
     * 账户状态：A-ACTIVE, I-INACTIVE, C-CANCEL
     */
    private AccountStatusEnum accountStatus;

    /**
     * 限制状态：00-无限制，10-只进不出，01-只出不进，11-不进不出
     */
    private AccountLimitedStatusEnum limitedStatus;

    /**
     * 客户号
     */
    private String clientNo;

    /**
     * 创建时间（毫秒数）
     */
    private Date createdTime;

    /**
     * 修改时间（毫秒数）
     */
    private Date modifiedTime;

}