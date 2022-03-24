package pers.hubery.accountcenter.common.context;

import lombok.Data;

/**
 * 业务上下文
 *
 * @author hubery
 * @version BizContext.java v1.0 2022-03-24 10:18
 */
@Data
public class BizContext {

    /** 租户ID */
    private String tenantId;

    /** 账本 */
    private String accountBook;

}
