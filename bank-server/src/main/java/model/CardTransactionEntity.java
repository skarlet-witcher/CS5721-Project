package model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "card_transaction", schema = "bank_manage", catalog = "")
public class CardTransactionEntity {
    private long id;
    private long transactionNo;
    private String fromCardNo;
    private String toCardNo;
    private BigDecimal amount;
    private Integer transactionStatus;
    private String currencyType;
    private String description;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "transaction_no", nullable = false)
    public long getTransactionNo() {
        return transactionNo;
    }

    public void setTransactionNo(long transactionNo) {
        this.transactionNo = transactionNo;
    }

    @Basic
    @Column(name = "from_card_no", nullable = true, length = 16)
    public String getFromCardNo() {
        return fromCardNo;
    }

    public void setFromCardNo(String fromCardNo) {
        this.fromCardNo = fromCardNo;
    }

    @Basic
    @Column(name = "to_card_no", nullable = true, length = 16)
    public String getToCardNo() {
        return toCardNo;
    }

    public void setToCardNo(String toCardNo) {
        this.toCardNo = toCardNo;
    }

    @Basic
    @Column(name = "amount", nullable = true, precision = 2)
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "transaction_status", nullable = true)
    public Integer getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(Integer transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    @Basic
    @Column(name = "currency_type", nullable = true, length = 15)
    public String getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 500)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CardTransactionEntity that = (CardTransactionEntity) o;

        if (id != that.id) return false;
        if (transactionNo != that.transactionNo) return false;
        if (fromCardNo != null ? !fromCardNo.equals(that.fromCardNo) : that.fromCardNo != null) return false;
        if (toCardNo != null ? !toCardNo.equals(that.toCardNo) : that.toCardNo != null) return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        if (transactionStatus != null ? !transactionStatus.equals(that.transactionStatus) : that.transactionStatus != null)
            return false;
        if (currencyType != null ? !currencyType.equals(that.currencyType) : that.currencyType != null) return false;
        return description != null ? description.equals(that.description) : that.description == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (transactionNo ^ (transactionNo >>> 32));
        result = 31 * result + (fromCardNo != null ? fromCardNo.hashCode() : 0);
        result = 31 * result + (toCardNo != null ? toCardNo.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (transactionStatus != null ? transactionStatus.hashCode() : 0);
        result = 31 * result + (currencyType != null ? currencyType.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
