package model;

public class UserApplyNewGoldenAccountBaseModel extends UserApplyNewRequestBaseModel {
    private Integer cardType;

    public Integer getCardType() {
        return cardType;
    }

    public void setCardType(Integer cardType) {
        this.cardType = cardType;
    }
}