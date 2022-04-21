package pers.hubery.accountcenter.infra.dal.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import pers.hubery.accountcenter.infra.dal.dataobject.BranchTransactionDO;

import java.util.List;

/**
 * @author lipengfei
 * @description 针对表【tcc_branch_transaction(TCC 分支事务表)】的数据库操作Mapper
 * @createDate 2022-04-17 23:50:47
 * @Entity pers.hubery.accountcenter.infra.dal.dataobject.BranchTransactionDO
 */
@Mapper
public interface BranchTransactionMapper {

    /**
     * insert
     *
     * @param data to insert
     * @return count
     */
    @Insert("insert into tcc_branch_transaction("
            + "tenant_id, "
            + "req_biz_no, "
            + "xid, "
            + "branch_id, "
            + "account_book, "
            + "account_no, "
            + "balance_type, "
            + "account_date, "
            + "business_timestamp, "
            + "currency, "
            + "action, "
            + "amount, "
            + "reference_no, "
            + "memo, "
            + "channel, "
            + "src_channel, "
            + "src_channel_biz_no, "
            + "operator, "
            + "auth_user_id, "
            + "from_app_name, "
            + "created_time, "
            + "modified_time) "
            + "VALUE ("
            + "#{data.tenantId}, "
            + "#{data.reqBizNo}, "
            + "#{data.xid}, "
            + "#{data.branchId}, "
            + "#{data.accountBook}, "
            + "#{data.acctNo}, "
            + "#{data.balanceType}, "
            + "#{data.accountDate}, "
            + "#{data.businessTimestamp}, "
            + "#{data.currency}, "
            + "#{data.action}, "
            + "#{data.amount}, "
            + "#{data.referenceNo}, "
            + "#{data.memo}, "
            + "#{data.channel}, "
            + "#{data.srcChannel}, "
            + "#{data.srcChannelBizNo}, "
            + "#{data.operator}, "
            + "#{data.authUserId}, "
            + "#{data.fromAppName}, "
            + "unix_timestamp(current_timestamp(3)) * 1000, "
            + "unix_timestamp(current_timestamp(3)) * 1000)")
    int insert(@Param("data") BranchTransactionDO data);

    /**
     * delete by xid and accountBook
     *
     * @param tenantId    tenant id
     * @param xid         TCC main transaction ID
     * @param accountBook account book
     * @return delete count
     */
    @Delete("delete from tcc_branch_transaction where tenant_id = #{tenantId} and xid = #{xid} and account_book = #{accountBook}")
    int deleteByXidAndAccountBook(@Param("tenantId") String tenantId, @Param("xid") String xid, @Param("accountBook") String accountBook);

    /**
     * select records by xid and account book
     *
     * @param tenantId    tenant id
     * @param xid         TCC main transaction ID
     * @param accountBook account book
     * @return BranchTransactionDO List
     */
    @Select("select id, "
            + "tenant_id, "
            + "req_biz_no, "
            + "xid, "
            + "branch_id, "
            + "account_book, "
            + "account_no, "
            + "balance_type, "
            + "account_date, "
            + "business_timestamp, "
            + "currency, "
            + "action, "
            + "amount, "
            + "reference_no, "
            + "memo, "
            + "channel, "
            + "src_channel, "
            + "src_channel_biz_no, "
            + "operator, "
            + "auth_user_id, "
            + "from_app_name, "
            + "created_time, "
            + "modified_time "
            + "from tcc_branch_transaction "
            + "where tenant_id = #{tenantId} and xid = #{xid} and account_book = #{accountBook}")
    List<BranchTransactionDO> selectByXidAndAccountBook(@Param("tenantId") String tenantId,
                                                        @Param("xid") String xid,
                                                        @Param("accountBook") String accountBook);

    /**
     * select record by req_biz_no
     *
     * @param tenantId tenant id
     * @param reqBizNo req_biz_no
     * @return BranchTransactionDO
     */
    @Select("select id, "
            + "tenant_id, "
            + "req_biz_no, "
            + "xid, "
            + "branch_id, "
            + "account_book, "
            + "account_no, "
            + "balance_type, "
            + "account_date, "
            + "business_timestamp, "
            + "currency, "
            + "action, "
            + "amount, "
            + "reference_no, "
            + "memo, "
            + "channel, "
            + "src_channel, "
            + "src_channel_biz_no, "
            + "operator, "
            + "auth_user_id, "
            + "from_app_name, "
            + "created_time, "
            + "modified_time "
            + "from tcc_branch_transaction "
            + "where tenant_id = #{tenantId} and req_biz_no = #{reqBizNo}")
    BranchTransactionDO selectByReqBizNo(@Param("tenantId") String tenantId, @Param("reqBizNo") String reqBizNo);
}




