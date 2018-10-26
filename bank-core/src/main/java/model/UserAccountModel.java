package model;

public class UserAccountModel {
    private Long accountNum;
    private Integer accountType;
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
}
