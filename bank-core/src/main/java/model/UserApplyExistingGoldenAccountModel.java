package model;

public class UserApplyExistingGoldenAccountModel extends UserApplyExistingRequestModel {
    private Integer cardType;

    public Integer getCardType() {
        return cardType;
    }

    public void setCardType(Integer cardType) {
        this.cardType = cardType;
    }
}
