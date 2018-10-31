package entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "user_account", schema = "bank_manage", catalog = "")
public class UserAccountEntity {
    private Long id;
    private Long accountNumber;
    private Long accountType;
    private String bic;
    private String iban;
    private Double balance;
    private Integer currencyType;
    private Timestamp expiredDate;
    private Long userId;
    private Integer status;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "account_number", nullable = false)
    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Basic
    @Column(name = "account_type", nullable = false)
    public Long getAccountType() {
        return accountType;
    }

    public void setAccountType(Long accountType) {
        this.accountType = accountType;
    }

    @Basic
    @Column(name = "bic", nullable = false, length = 255)
    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    @Basic
    @Column(name = "iban", nullable = false, length = 255)
    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    @Basic
    @Column(name = "balance", nullable = false, precision = 0)
    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Basic
    @Column(name = "currency_type", nullable = false)
    public Integer getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(Integer currencyType) {
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
    @Column(name = "user_id", nullable = true)
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "status", nullable = false)
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserAccountEntity that = (UserAccountEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (accountNumber != null ? !accountNumber.equals(that.accountNumber) : that.accountNumber != null)
            return false;
        if (accountType != null ? !accountType.equals(that.accountType) : that.accountType != null) return false;
        if (bic != null ? !bic.equals(that.bic) : that.bic != null) return false;
        if (iban != null ? !iban.equals(that.iban) : that.iban != null) return false;
        if (balance != null ? !balance.equals(that.balance) : that.balance != null) return false;
        if (currencyType != null ? !currencyType.equals(that.currencyType) : that.currencyType != null) return false;
        if (expiredDate != null ? !expiredDate.equals(that.expiredDate) : that.expiredDate != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        return status != null ? status.equals(that.status) : that.status == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (accountNumber != null ? accountNumber.hashCode() : 0);
        result = 31 * result + (accountType != null ? accountType.hashCode() : 0);
        result = 31 * result + (bic != null ? bic.hashCode() : 0);
        result = 31 * result + (iban != null ? iban.hashCode() : 0);
        result = 31 * result + (balance != null ? balance.hashCode() : 0);
        result = 31 * result + (currencyType != null ? currencyType.hashCode() : 0);
        result = 31 * result + (expiredDate != null ? expiredDate.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
