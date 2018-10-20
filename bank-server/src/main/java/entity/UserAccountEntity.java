package entity;

import javax.persistence.*;

@Entity
@Table(name = "user_account", schema = "bank_manage", catalog = "")
public class UserAccountEntity {
    private long id;
    private long accountNumber;
    private int accountType;
    private String bic;
    private String iban;
    private Long userId;
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
    @Column(name = "account_number", nullable = false)
    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Basic
    @Column(name = "account_type", nullable = false)
    public int getAccountType() {
        return accountType;
    }

    public void setAccountType(int accountType) {
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
    @Column(name = "user_id", nullable = true)
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

        UserAccountEntity that = (UserAccountEntity) o;

        if (id != that.id) return false;
        if (accountNumber != that.accountNumber) return false;
        if (accountType != that.accountType) return false;
        if (status != that.status) return false;
        if (bic != null ? !bic.equals(that.bic) : that.bic != null) return false;
        if (iban != null ? !iban.equals(that.iban) : that.iban != null) return false;
        return userId != null ? userId.equals(that.userId) : that.userId == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (accountNumber ^ (accountNumber >>> 32));
        result = 31 * result + accountType;
        result = 31 * result + (bic != null ? bic.hashCode() : 0);
        result = 31 * result + (iban != null ? iban.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + status;
        return result;
    }
}
