package model;

import java.util.List;

public class UserTransferModel {
    private List<UserPayeeModel> payee;
    private List<UserAccountModel> account;
    private Integer currencyType;
    private Double amounts;
    private String postScript;

    public List<UserPayeeModel> getPayee() {
        return payee;
    }

    public void setPayee(List<UserPayeeModel> payee) {
        this.payee = payee;
    }

    public List<UserAccountModel> getAccount() {
        return account;
    }

    public void setAccount(List<UserAccountModel> account) {
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
