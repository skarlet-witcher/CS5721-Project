package model;

public class UserWithdrawModel extends UserDepositWithdrawBaseModel {
   private Double withdrawAmounts;

    public Double getWithdrawAmounts() {
        return withdrawAmounts;
    }

    public void setWithdrawAmounts(Double withdrawAmounts) {
        this.withdrawAmounts = withdrawAmounts;
    }
}
