package entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "user_operation_history", schema = "bank_manage", catalog = "")
public class UserOperationHistoryEntity {
    private long id;
    private String operateNo;
    private Integer operateType;
    private Timestamp operateTime;
    private Integer operateSource;
    private Double amount;
    private Integer currencyType;
    private Double balance;
    private String description;
    private int status;
    private Long userId;
    private Long toPayeeId;
    private Long accountId;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "operate_no", nullable = false)
    public String getOperateNo() {
        return operateNo;
    }

    public void setOperateNo(String operateNo) {
        this.operateNo = operateNo;
    }

    @Basic
    @Column(name = "operate_type", nullable = true)
    public Integer getOperateType() {
        return operateType;
    }

    public void setOperateType(Integer operateType) {
        this.operateType = operateType;
    }

    @Basic
    @Column(name = "operate_time", nullable = false)
    public Timestamp getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Timestamp operateTime) {
        this.operateTime = operateTime;
    }

    @Basic
    @Column(name = "operate_source", nullable = true)
    public Integer getOperateSource() {
        return operateSource;
    }

    public void setOperateSource(Integer operateSource) {
        this.operateSource = operateSource;
    }

    @Basic
    @Column(name = "amount", nullable = true, precision = 0)
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "currency_type", nullable = true)
    public Integer getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(Integer currencyType) {
        this.currencyType = currencyType;
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
    @Column(name = "description", nullable = true, length = 500)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "status", nullable = false)
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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
    @Column(name = "to_payee_id", nullable = true)
    public Long getToPayeeId() {
        return toPayeeId;
    }

    public void setToPayeeId(Long toPayeeId) {
        this.toPayeeId = toPayeeId;
    }

    @Basic
    @Column(name = "account_id", nullable = true)
    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserOperationHistoryEntity that = (UserOperationHistoryEntity) o;

        if (id != that.id) return false;
        if (operateNo != that.operateNo) return false;
        if (status != that.status) return false;
        if (operateType != null ? !operateType.equals(that.operateType) : that.operateType != null) return false;
        if (operateTime != null ? !operateTime.equals(that.operateTime) : that.operateTime != null) return false;
        if (operateSource != null ? !operateSource.equals(that.operateSource) : that.operateSource != null)
            return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        if (currencyType != null ? !currencyType.equals(that.currencyType) : that.currencyType != null) return false;
        if (balance != null ? !balance.equals(that.balance) : that.balance != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (toPayeeId != null ? !toPayeeId.equals(that.toPayeeId) : that.toPayeeId != null) return false;
        return accountId != null ? accountId.equals(that.accountId) : that.accountId == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (operateNo != null ? operateNo.hashCode() : 0);
        result = 31 * result + (operateType != null ? operateType.hashCode() : 0);
        result = 31 * result + (operateTime != null ? operateTime.hashCode() : 0);
        result = 31 * result + (operateSource != null ? operateSource.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (currencyType != null ? currencyType.hashCode() : 0);
        result = 31 * result + (balance != null ? balance.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + status;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (toPayeeId != null ? toPayeeId.hashCode() : 0);
        result = 31 * result + (accountId != null ? accountId.hashCode() : 0);
        return result;
    }
}
