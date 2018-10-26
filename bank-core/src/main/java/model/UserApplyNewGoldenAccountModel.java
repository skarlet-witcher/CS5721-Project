package model;

import java.sql.Timestamp;

public class UserApplyNewGoldenAccountModel extends UserApplyNewRequestModel {
    private Integer cardType;

    public Integer getCardType() {
        return cardType;
    }

    public void setCardType(Integer cardType) {
        this.cardType = cardType;
    }
}