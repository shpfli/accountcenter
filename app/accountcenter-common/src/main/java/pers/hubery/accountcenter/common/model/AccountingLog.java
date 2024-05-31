package pers.hubery.accountcenter.common.model;

import lombok.Builder;
import lombok.Data;
import pers.hubery.accountcenter.common.money.Money;

import java.util.Date;

/**
 * accounting record
 *
 * @author LiPengfei
 * @version AccountingLog.java v1.0 2022-04-10 22:49
 */
@Builder
@Data
public class AccountingLog {

    /**
     * record no used to identify the record all through the bank
     */
    private String recordNo;

    /**
     * 租户ID
     */
    private String tenantId;

    /**
     * account book, such as : deposit, loan, ……
     */
    private String accountBook;

    /**
     * account number
     */
    private String acctNo;

    /**
     * balance type
     */
    private String balanceType;

    /**
     * account date
     */
    private String accountDate;

    /**
     * the timestamp of the accounting
     */
    private Date accountingTimestamp;

    /**
     * the timestamp of the business happened
     */
    private Date businessTimestamp;

    /**
     * changed amount
     */
    private Money changedAmount;

    /**
     * balance after this transaction
     */
    private Money balance;

    /**
     * the instruction number, same as req_biz_no
     */
    private String instructionNo;

    /**
     * transaction reference number
     */
    private String referenceNo;

    /**
     * the memo
     */
    private String memo;

    /**
     * channel
     */
    private String channel;

    /**
     * src channel
     */
    private String srcChannel;

    /**
     * src channel biz no
     */
    private String srcChannelBizNo;

    /**
     * operator
     */
    private String operator;

    /**
     * authUserId
     */
    private String authUserId;

    /**
     * fromAppName
     */
    private String fromAppName;

    /**
     * create timestamp
     */
    private Date createTimestamp;

    /**
     * update timestamp
     */
    private Date updateTimestamp;
}
