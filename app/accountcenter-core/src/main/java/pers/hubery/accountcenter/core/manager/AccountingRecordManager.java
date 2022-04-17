package pers.hubery.accountcenter.core.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pers.hubery.accountcenter.common.model.AccountingCommand;
import pers.hubery.accountcenter.common.model.AccountingRecord;
import pers.hubery.accountcenter.common.money.Money;
import pers.hubery.accountcenter.core.generator.IdGenerator;
import pers.hubery.accountcenter.infra.dal.repository.AccountingRecordRepository;

import java.util.UUID;

/**
 * to manage accounting records
 *
 * @author LiPengfei
 * @version AccountingRecordManager.java v1.0 2022-04-10 23:03
 */
@Component
public class AccountingRecordManager {

    private static final String ID_TYPE = "RECORD_NO";

    /** id 生成器 */
    @Autowired
    private IdGenerator idGenerator;

    /** 账务流水仓库 */
    @Autowired
    private AccountingRecordRepository accountingRecordRepository;

    /**
     * record
     *
     * @param command         AccountingCommand
     * @param finalBalanceAmt the balance amount after accounting
     */
    public void record(AccountingCommand command, Money finalBalanceAmt) {

        Money changedAmount = null;

        //1. compute changed amount
        switch (command.getAction()) {
            case IN:
                changedAmount = command.getAmount().clone();
                break;
            case OUT:
                changedAmount = command.getAmount().multiply(-1);
                break;
            default:
                throw new UnsupportedOperationException();
        }

        //2. build record
        AccountingRecord record = AccountingRecord.builder()
                .recordNo(idGenerator.genAccountingLogId())
                .recordNo(UUID.randomUUID().toString())
                .accountBook(command.getAccountBook())
                .acctNo(command.getAccountNo())
                .balanceType(command.getBalanceType())
                .accountDate(command.getAccountDate())
                .businessTimestamp(command.getBusinessTimestamp())
                //changedAmount
                .changedAmount(changedAmount)
                .balance(finalBalanceAmt)
                // instructionNo = reqBizNo
                .instructionNo(command.getReqBizNo())
                .referenceNo(command.getReferenceNo())
                .memo(command.getMemo())
                .operator(command.getOperator())
                .authUserId(command.getAuthUserId())
                .channel(command.getChannel())
                .srcChannel(command.getSrcChannel())
                .srcChannelBizNo(command.getSrcChannelBizNo())
                .fromAppName(command.getFromAppName())
                .build();

        //3. save to DB
        accountingRecordRepository.insert(record);
    }
}
