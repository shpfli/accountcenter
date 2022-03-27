package pers.hubery.accountcenter.infra.dal.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import pers.hubery.accountcenter.infra.dal.dataobject.AccountDO;

/**
 * @author hubery
 * @description 针对表【acc_account(账户表)】的数据库操作Mapper
 * @createDate 2022-03-24 01:20:20
 * @Entity pers.hubery.accountcenter.infra.dal.dataobject.AccountDO
 */
@Mapper
public interface AccountMapper {

    /**
     * 根据唯一键查询
     *
     * @param tenantId    租户ID
     * @param accountBook 账本
     * @param accountNo   账号
     * @return 账户DO
     */
    @Select("select id, tenant_id, account_book, account_no, account_status, limited_status, client_no, created_time, modified_time"
            + " from acc_account "
            + "where tenant_id = #{tenantId} and account_book = #{accountBook} and account_no = #{accountNo}")
    AccountDO selectByUK(@Param("tenantId") String tenantId,
                         @Param("accountBook") String accountBook,
                         @Param("accountNo") String accountNo);
}




