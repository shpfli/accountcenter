package pers.hubery.accountcenter.infra.dal.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import pers.hubery.accountcenter.infra.dal.domain.TransactionAmountDO;

import java.util.List;

/**
 * @author lipengfei
 * @description 针对表【tcc_transaction_amount(account amount prepare record)】的数据库操作Mapper
 * @createDate 2022-04-22 01:32:53
 * @Entity pers.hubery.accountcenter.infra.dal.domain.TransactionAmountDO
 */
@Mapper
public interface TransactionAmountMapper {

    /**
     * insert System Amount record
     *
     * @param data system amount record
     * @return count
     */
    @Insert("insert into tcc_transaction_amount("
            + "tenant_id, "
            + "xid, "
            + "account_book, "
            + "account_no, "
            + "balance_type, "
            + "amount_type, "
            + "currency, "
            + "amount, "
            + "created_time, "
            + "modified_time)"
            + "VALUE ("
            + "#{data.tenantId}, "
            + "#{data.xid}, "
            + "#{data.accountBook}, "
            + "#{data.acctNo}, "
            + "#{data.balanceType}, "
            + "#{data.amountType},"
            + "#{data.currency},"
            + "#{data.amount}, "
            + "unix_timestamp(current_timestamp(3)) * 1000, "
            + "unix_timestamp(current_timestamp(3)) * 1000)"
    )
    int insert(@Param("data") TransactionAmountDO data);

    /**
     * select TransactionAmountDO by xid and accountBook
     *
     * @param xid         xid
     * @param accountBook accountBook
     * @return TransactionAmountDO
     */
    @Select("select xid, account_book, account_no, balance_type, amount_type, currency, amount, created_time, modified_time "
            + "from tcc_transaction_amount "
            + "where tenant_id = #{tenantId} and xid = #{xid} and account_book = #{accountBook}")
    List<TransactionAmountDO> selectByXidAndAccountBook(@Param("tenantId") String tenantId,
                                                        @Param("xid") String xid,
                                                        @Param("accountBook") String accountBook);

    /**
     * select TransactionAmountDO by xid and accountBook
     *
     * @param xid         xid
     * @param accountBook accountBook
     * @return TransactionAmountDO
     */
    @Select("select xid, account_book, account_no, balance_type, amount_type, currency, amount, created_time, modified_time "
            + "from tcc_transaction_amount "
            + "where tenant_id = #{tenantId}"
            + " and xid = #{xid}"
            + " and account_book = #{accountBook}"
            + " and account_no = #{accountNo}"
            + " and balance_type = #{balanceType}")
    List<TransactionAmountDO> select(@Param("tenantId") String tenantId,
                                     @Param("xid") String xid,
                                     @Param("accountBook") String accountBook,
                                     @Param("accountNo") String accountNo,
                                     @Param("balanceType") String balanceType);

    /**
     * delete SystemAmount records by xid and accountBook
     *
     * @param xid         xid
     * @param accountBook accountBook
     * @return TransactionAmountDO
     */
    @Delete("delete from tcc_transaction_amount where tenant_id = #{tenantId} and xid = #{xid} and account_book = #{accountBook}")
    int deleteByXidAndAccountBook(@Param("tenantId") String tenantId, @Param("xid") String xid, @Param("accountBook") String accountBook);

    /**
     * delete the specified record
     *
     * @param data the record to delete
     * @return count
     */
    @Delete("delete from tcc_transaction_amount "
            + "where tenant_id = #{data.tenantId} "
            + "and xid = #{data.xid} "
            + "and account_book = #{data.accountBook} "
            + "and account_no = #{data.acctNo} "
            + "and balance_type = #{data.balanceType} "
            + "and amount_type = #{data.amountType} ")
    int delete(@Param("data") TransactionAmountDO data);

    /**
     * update SystemAmount to set Amount
     *
     * @param data systemAmount
     * @return count
     */
    @Update("update tcc_transaction_amount"
            + " set amount = #{data.amount}, modified_time = unix_timestamp(current_timestamp(3)) * 1000 "
            + "where tenant_id = #{data.tenantId} "
            + "and xid = #{data.xid} "
            + "and account_book = #{data.accountBook} "
            + "and account_no = #{data.acctNo} "
            + "and balance_type = #{data.balanceType} "
            + "and amount_type = #{data.amountType} ")
    int updateAmount(@Param("data") TransactionAmountDO data);
}




