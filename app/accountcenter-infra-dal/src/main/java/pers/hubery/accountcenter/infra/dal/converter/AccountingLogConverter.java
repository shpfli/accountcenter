package pers.hubery.accountcenter.infra.dal.converter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import pers.hubery.accountcenter.common.model.AccountingLog;
import pers.hubery.accountcenter.infra.dal.dataobject.AccountingLogDO;


@Mapper
public interface AccountingLogConverter {

    AccountingLogConverter INSTANCE = Mappers.getMapper(AccountingLogConverter.class);

    /**
     * 转化 AccountingLogDO 到 AccountingLog
     *
     * @param accountingLogDO AccountingLogDO 对象
     * @return AccountingLog 对象
     */
    @Mappings(value = {
            @Mapping(target = "recordNo", source = "accountingLogId"),
            @Mapping(target = "acctNo", source = "accountNo"),
            @Mapping(target = "accountDate", source = "accountingDate"),
            @Mapping(target = "changedAmount",
                    expression = "java(new pers.hubery.accountcenter.common.money.Money(accountingLogDO.getChangedAmount(), accountingLogDO.getCurrency())) "),
            @Mapping(target = "balance",
                    expression = "java(new pers.hubery.accountcenter.common.money.Money(accountingLogDO.getBalance(), accountingLogDO.getCurrency())) "),
            @Mapping(target = "accountingTimestamp", expression = "java(new java.util.Date(accountingLogDO.getAccountingTimestamp()))"),
            @Mapping(target = "businessTimestamp", expression = "java(new java.util.Date(accountingLogDO.getBusinessTimestamp()))"),
            @Mapping(target = "instructionNo", source = "requestUniqueId"),
            @Mapping(target = "referenceNo", source = "transSeqNo")
    })
    AccountingLog convert(AccountingLogDO accountingLogDO);


    /**
     * 转化 AccountingLog 到 AccountingLogDO
     *
     * @param accountingLog AccountingLog 对象
     * @return AccountingLogDO 对象
     */
    @Mappings({
            @Mapping(target = "accountingLogId", source = "recordNo"),
            @Mapping(target = "accountNo", source = "acctNo"),
            @Mapping(target = "accountingDate", source = "accountDate"),
            @Mapping(target = "changedAmount", source = "changedAmount.cent"),
            @Mapping(target = "balance", source = "balance.cent"),
            @Mapping(target = "currency", source = "changedAmount.currencyCode"),
            @Mapping(target = "accountingTimestamp", expression = "java(accountingLog.getAccountingTimestamp().getTime())"),
            @Mapping(target = "businessTimestamp", expression = "java(accountingLog.getBusinessTimestamp().getTime())"),
            @Mapping(target = "requestUniqueId", source = "instructionNo"),
            @Mapping(target = "transSeqNo", source = "referenceNo")
    })
    AccountingLogDO convert(AccountingLog accountingLog);

}
