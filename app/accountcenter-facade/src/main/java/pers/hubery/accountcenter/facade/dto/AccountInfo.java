package pers.hubery.accountcenter.facade.dto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 账户VO
 *
 * @author hubery
 */
public class AccountInfo {

    /** 租户ID */
    private String tenantId;

    /** 账本 */
    private String accountBook;

    /** 账号 */
    private String accountNo;

    /** 账户状态：A-ACTIVE, I-INACTIVE, C-CANCEL */
    private String accountStatus;

    /** 限制状态：00-无限制，10-只进不出，01-只出不进，11-不进不出 */
    private String limitedStatus;

    /** 客户号 */
    private String clientNo;

    /**
     * Getter method for property <tt>tenantId</tt>.
     *
     * @return property value of tenantId
     */
    public String getTenantId() {
        return tenantId;
    }

    /**
     * Setter method for property <tt>tenantId</tt>.
     *
     * @param tenantId value to be assigned to property tenantId
     */
    public void setTenantId(final String tenantId) {
        this.tenantId = tenantId;
    }

    /**
     * Getter method for property <tt>accountBook</tt>.
     *
     * @return property value of accountBook
     */
    public String getAccountBook() {
        return accountBook;
    }

    /**
     * Setter method for property <tt>accountBook</tt>.
     *
     * @param accountBook value to be assigned to property accountBook
     */
    public void setAccountBook(final String accountBook) {
        this.accountBook = accountBook;
    }

    /**
     * Getter method for property <tt>accountNo</tt>.
     *
     * @return property value of accountNo
     */
    public String getAccountNo() {
        return accountNo;
    }

    /**
     * Setter method for property <tt>accountNo</tt>.
     *
     * @param accountNo value to be assigned to property accountNo
     */
    public void setAccountNo(final String accountNo) {
        this.accountNo = accountNo;
    }

    /**
     * Getter method for property <tt>accountStatus</tt>.
     *
     * @return property value of accountStatus
     */
    public String getAccountStatus() {
        return accountStatus;
    }

    /**
     * Setter method for property <tt>accountStatus</tt>.
     *
     * @param accountStatus value to be assigned to property accountStatus
     */
    public void setAccountStatus(final String accountStatus) {
        this.accountStatus = accountStatus;
    }

    /**
     * Getter method for property <tt>limitedStatus</tt>.
     *
     * @return property value of limitedStatus
     */
    public String getLimitedStatus() {
        return limitedStatus;
    }

    /**
     * Setter method for property <tt>limitedStatus</tt>.
     *
     * @param limitedStatus value to be assigned to property limitedStatus
     */
    public void setLimitedStatus(final String limitedStatus) {
        this.limitedStatus = limitedStatus;
    }

    /**
     * Getter method for property <tt>clientNo</tt>.
     *
     * @return property value of clientNo
     */
    public String getClientNo() {
        return clientNo;
    }

    /**
     * Setter method for property <tt>clientNo</tt>.
     *
     * @param clientNo value to be assigned to property clientNo
     */
    public void setClientNo(final String clientNo) {
        this.clientNo = clientNo;
    }

    /**
     * returns a string representation of the object.
     *
     * @return a string representation of the object.
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SIMPLE_STYLE);
    }
}