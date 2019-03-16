package model;

import java.sql.Timestamp;

public class UserTransactionModel {
    private Timestamp date;
    private String details;
    private Double amounts;
    private Double balance;
    private String transactionNum;
    private Integer operation_type;


    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getTransactionNum() {
        return transactionNum;
    }

    public void setTransactionNum(String transactionNum) {
        this.transactionNum = transactionNum;
    }

    public Double getAmounts() {
        return amounts;
    }

    public void setAmounts(Double amounts) {
        this.amounts = amounts;
    }

    public Integer getOperation_type() {
        return operation_type;
    }

    public void setOperation_type(Integer operation_type) {
        this.operation_type = operation_type;
    }
}
