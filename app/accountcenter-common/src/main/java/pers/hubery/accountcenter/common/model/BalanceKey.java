package pers.hubery.accountcenter.common.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * the key to identify a balance
 *
 * @author LiPengfei
 * @version BalanceKey.java v1.0 2022-03-30 20:49
 */
public class BalanceKey {

    /**
     * account book, such as : deposit, loan, ……
     */
    public final String accountBook;

    /**
     * account number
     */
    public final String acctNo;

    /**
     * balance type
     */
    public final String balanceType;

    /**
     * constructor
     *
     * @param accountBook account book
     * @param acctNo      account no
     * @param balanceType balance type
     */
    public BalanceKey(final String accountBook, final String acctNo, final String balanceType) {
        this.accountBook = accountBook;
        this.acctNo = acctNo;
        this.balanceType = balanceType;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {return true;}

        if (o == null || getClass() != o.getClass()) {return false;}

        final BalanceKey that = (BalanceKey) o;

        return new EqualsBuilder().append(accountBook, that.accountBook).append(acctNo, that.acctNo).append(
                balanceType, that.balanceType).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(accountBook).append(acctNo).append(balanceType).toHashCode();
    }
}
