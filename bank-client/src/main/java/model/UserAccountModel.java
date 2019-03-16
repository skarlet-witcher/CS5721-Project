package model;

public class UserAccountModel {
    private Long account_pk;
    private Long accountNum;
    private Integer accountType;
    private Integer currencyType;
    private Double balance;
    private int status;
    private String bic;
    private String iban;
    private UserAccountCardModel userCard;

    public Long getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(Long accountNum) {
        this.accountNum = accountNum;
    }

    public Integer getAccountType() {
        return accountType;
    }

    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public UserAccountCardModel getUserCard() {
        return userCard;
    }

    public void setUserCard(UserAccountCardModel userCard) {
        this.userCard = userCard;
    }

    public Long getAccount_pk() {
        return account_pk;
    }

    public void setAccount_pk(Long account_pk) {
        this.account_pk = account_pk;
    }

    public Integer getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(Integer currencyType) {
        this.currencyType = currencyType;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
