package pers.hubery.accountcenter.infra.dal.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import pers.hubery.accountcenter.infra.dal.dataobject.MainTransactionDO;

/**
 * @author lipengfei
 * @description 针对表【tcc_main_transaction(TCC 主事务表)】的数据库操作Mapper
 * @createDate 2022-04-17 23:50:47
 * @Entity pers.hubery.accountcenter.infra.dal.dataobject.MainTransactionDO
 */
@Mapper
public interface MainTransactionMapper {

    /**
     * insert
     *
     * @param data the data to insert
     * @return insert count
     */
    @Insert("insert into tcc_main_transaction(tenant_id, xid, account_book, status, created_time, modified_time) VALUE ("
            + "#{data.tenantId}, "
            + "#{data.xid}, "
            + "#{data.accountBook}, "
            + "#{data.status}, "
            + "unix_timestamp(current_timestamp(3)) * 1000, "
            + "unix_timestamp(current_timestamp(3)) * 1000)")
    int insert(@Param("data") MainTransactionDO data);

    /**
     * select AccountDO by accountBook and accountNo
     *
     * @param tenantId    tenant id
     * @param xid         tcc main transaction id
     * @param accountBook account book
     * @return AccountDO
     */
    @Select("select tenant_id, xid, account_book, status, created_time, modified_time "
            + "from tcc_main_transaction where tenant_id = #{tenantId} and xid = #{xid} and account_book = #{accountBook} for update")
    MainTransactionDO selectForUpdate(@Param("tenantId") String tenantId,
                                      @Param("xid") String xid,
                                      @Param("accountBook") String accountBook);

    /**
     * update main transaction status
     *
     * @param tenantId     tenant id
     * @param xid          tcc main transaction id
     * @param accountBook  account book
     * @param targetStatus target status
     * @return update count
     */
    @Update("update tcc_main_transaction set status = #{targetStatus} "
            + "where tenant_id = #{tenantId} and xid = #{xid} and account_book = #{accountBook}")
    int updateStatus(@Param("tenantId") String tenantId,
                     @Param("xid") String xid,
                     @Param("accountBook") String accountBook,
                     @Param("targetStatus") String targetStatus);
}




