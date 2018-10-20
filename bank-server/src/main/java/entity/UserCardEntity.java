package entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "user_card", schema = "bank_manage", catalog = "")
public class UserCardEntity {
    private long id;
    private long cardNumber;
    private int cardType;
    private String pin;
    private Double balance;
    private int currencyType;
    private Timestamp expiredDate;
    private long accountId;
    private int status;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "card_number", nullable = false)
    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Basic
    @Column(name = "card_type", nullable = false)
    public int getCardType() {
        return cardType;
    }

    public void setCardType(int cardType) {
        this.cardType = cardType;
    }

    @Basic
    @Column(name = "pin", nullable = false, length = 6)
    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    @Basic
    @Column(name = "balance", nullable = true, precision = 0)
    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Basic
    @Column(name = "currency_type", nullable = false)
    public int getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(int currencyType) {
        this.currencyType = currencyType;
    }

    @Basic
    @Column(name = "expired_date", nullable = false)
    public Timestamp getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Timestamp expiredDate) {
        this.expiredDate = expiredDate;
    }

    @Basic
    @Column(name = "account_id", nullable = false)
    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    @Basic
    @Column(name = "status", nullable = false)
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserCardEntity that = (UserCardEntity) o;

        if (id != that.id) return false;
        if (cardNumber != that.cardNumber) return false;
        if (cardType != that.cardType) return false;
        if (currencyType != that.currencyType) return false;
        if (accountId != that.accountId) return false;
        if (status != that.status) return false;
        if (pin != null ? !pin.equals(that.pin) : that.pin != null) return false;
        if (balance != null ? !balance.equals(that.balance) : that.balance != null) return false;
        return expiredDate != null ? expiredDate.equals(that.expiredDate) : that.expiredDate == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (cardNumber ^ (cardNumber >>> 32));
        result = 31 * result + cardType;
        result = 31 * result + (pin != null ? pin.hashCode() : 0);
        result = 31 * result + (balance != null ? balance.hashCode() : 0);
        result = 31 * result + currencyType;
        result = 31 * result + (expiredDate != null ? expiredDate.hashCode() : 0);
        result = 31 * result + (int) (accountId ^ (accountId >>> 32));
        result = 31 * result + status;
        return result;
    }
}
