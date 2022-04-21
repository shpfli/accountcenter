package pers.hubery.accountcenter.infra.dal.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import pers.hubery.accountcenter.infra.dal.dataobject.BalanceDO;

/**
 * @author hubery
 * @description 针对表【acc_balance(账户余额表)】的数据库操作Mapper
 * @createDate 2022-03-24 01:20:20
 * @Entity pers.hubery.accountcenter.infra.dal.dataobject.BalanceDO
 */
@Mapper
public interface BalanceMapper {
    /**
     * select
     *
     * @param tenantId    tenant id
     * @param accountBook account book
     * @param accountNo   account no
     * @param balanceType balance type
     * @return BalanceDO
     */
    @Select("select id, "
            + " tenant_id, "
            + " account_book, "
            + " account_no, "
            + " balance_type, "
            + " currency, "
            + " balance, "
            + " unreached_amount, "
            + " reserved_amount, "
            + " frozen_amount, "
            + " overdraft_limit, "
            + " has_upper_limit, "
            + " balance_direction, "
            + " last_accounting_time, "
            + " created_time, "
            + " modified_time "
            + "from acc_balance "
            + "where tenant_id = #{tenantId}"
            + "  and account_book = #{accountBook} "
            + "  and account_no = #{accountNo} "
            + "  and balance_type = #{balanceType} ")
    BalanceDO select(@Param("tenantId") String tenantId,
                     @Param("accountBook") String accountBook,
                     @Param("accountNo") String accountNo,
                     @Param("balanceType") String balanceType);

    /**
     * select for update
     *
     * @param tenantId    tenant id
     * @param accountBook account book
     * @param accountNo   account no
     * @param balanceType balance type
     * @return BalanceDO
     */
    @Select("select id, "
            + " tenant_id, "
            + " account_book, "
            + " account_no, "
            + " balance_type, "
            + " currency, "
            + " balance, "
            + " unreached_amount, "
            + " reserved_amount, "
            + " frozen_amount, "
            + " overdraft_limit, "
            + " has_upper_limit, "
            + " balance_direction, "
            + " last_accounting_time, "
            + " created_time, "
            + " modified_time "
            + "from acc_balance "
            + "where tenant_id = #{tenantId} "
            + "  and account_book = #{accountBook} "
            + "  and account_no = #{accountNo} "
            + "  and balance_type = #{balanceType} "
            + "    for update")
    BalanceDO selectForUpdate(@Param("tenantId") String tenantId,
                              @Param("accountBook") String accountBook,
                              @Param("accountNo") String accountNo,
                              @Param("balanceType") String balanceType);

    /**
     * update balance record to set unreached_amount
     *
     * @param data balance record
     * @return count
     */
    @Update("update acc_balance "
            + "set unreached_amount    = #{data.unreachedAmt},"
            + "    modified_time = unix_timestamp(current_timestamp(3)) * 1000 "
            + "where tenant_id = #{data.tenantId} "
            + "  and account_book = #{data.accountBook} "
            + "  and account_no = #{data.acctNo}"
            + "  and balance_type = #{data.balanceType}")
    int updateUnreachedAmount(@Param("data") BalanceDO data);

    /**
     * update balance record to set reserved_amount
     *
     * @param data balance record
     * @return count
     */
    @Update("update acc_balance "
            + "set reserved_amount    = #{data.reserveAmt},"
            + "    modified_time = unix_timestamp(current_timestamp(3)) * 1000 "
            + "where tenant_id = #{data.tenantId} "
            + "  and account_book = #{data.accountBook} "
            + "  and account_no = #{data.acctNo}"
            + "  and balance_type = #{data.balanceType}")
    int updateReservedAmount(@Param("data") BalanceDO data);

    /**
     * update balance amount
     *
     * @param data balance record
     * @return count
     */
    @Update("update acc_balance "
            + "set balance    = #{data.balance},"
            + "    last_accounting_time = #{data.balanceLastChangeTimestamp},"
            + "    modified_time = unix_timestamp(current_timestamp(3)) * 1000 "
            + "where tenant_id = #{data.tenantId} "
            + "  and account_book = #{data.accountBook} "
            + "  and account_no = #{data.acctNo}"
            + "  and balance_type = #{data.balanceType}")
    int updateBalanceAmount(@Param("data") BalanceDO data);
}




