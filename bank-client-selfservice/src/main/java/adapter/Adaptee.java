package adapter;

import model.UserTransactionModel;

import java.util.List;

public class Adaptee {
    private List<UserTransactionModel> userTransactionModelList;

    public Adaptee(List<UserTransactionModel> userTransactionModelList) {
        this.userTransactionModelList = userTransactionModelList;
    }

    public List<UserTransactionModel> getList() {
        return this.userTransactionModelList;
    }
}
