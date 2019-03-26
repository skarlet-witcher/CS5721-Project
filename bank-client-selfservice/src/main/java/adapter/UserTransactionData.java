package adapter;

import model.UserTransactionModel;

import java.util.List;

public class UserTransactionData {   // A list of UserTransactionModel // Adaptee
    private List<UserTransactionModel> userTransactionModelList;

    public UserTransactionData(List<UserTransactionModel> userTransactionModelList) {
        this.userTransactionModelList = userTransactionModelList;
    }

    public List<UserTransactionModel> getList() {
        return this.userTransactionModelList;
    }  // specific request
}
