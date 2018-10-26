package model;

public class UserApplyNewGoldenAccountBaseModel extends UserApplyNewRequestBaseModel {
    private Integer cardType;
    private Integer accountType;

    public Integer getCardType() {
        return cardType;
    }

    public void setCardType(Integer cardType) {
        this.cardType = cardType;
    }

    public Integer getAccountType() {
        return accountType;
    }

    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }
}