package pers.hubery.accountcenter.infra.dal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import pers.hubery.accountcenter.infra.dal.dataobject.AccountingLogDO;

/**
 * @author hubery
 * @description 针对表【acc_accounting_log(账务流水表)】的数据库操作Mapper
 * @createDate 2022-03-24 01:20:20
 * @Entity pers.hubery.accountcenter.infra.dal.dataobject.AccountingLogDO
 */
@Mapper
public interface AccountingLogMapper extends BaseMapper<AccountingLogDO> {

}




