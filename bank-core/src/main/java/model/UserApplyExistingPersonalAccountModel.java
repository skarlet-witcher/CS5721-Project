package model;

public class UserApplyExistingPersonalAccountModel extends UserApplyExistingRequestModel {
    private Integer cardType;

    public Integer getCardType() {
        return cardType;
    }

    public void setCardType(Integer cardType) {
        this.cardType = cardType;
    }
}
