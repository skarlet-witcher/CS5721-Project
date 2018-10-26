package model;

public class UserTransferModel {
    private UserPayeeModel payee;
    private UserAccountModel account;
    private Integer currencyType;
    private Double amounts;
    private String postScript;

    public UserPayeeModel getPayee() {
        return payee;
    }

    public void setPayee(UserPayeeModel payee) {
        this.payee = payee;
    }

    public UserAccountModel getAccount() {
        return account;
    }

    public void setAccount(UserAccountModel account) {
        this.account = account;
    }

    public Integer getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(Integer currencyType) {
        this.currencyType = currencyType;
    }

    public Double getAmounts() {
        return amounts;
    }

    public void setAmounts(Double amounts) {
        this.amounts = amounts;
    }

    public String getPostScript() {
        return postScript;
    }

    public void setPostScript(String postScript) {
        this.postScript = postScript;
    }
}
