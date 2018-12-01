package model;

public class UserDepositModel extends UserDepositWithdrawBaseModel {
    private Double depositAmounts;

    public Double getDepositAmounts() {
        return depositAmounts;
    }

    public void setDepositAmounts(Double depositAmounts) {
        this.depositAmounts = depositAmounts;
    }
}
