package service;

import model.UserTransferModel;

public interface ICustomerTransferService {
    /*
        @pre userTransferModel.getPayee().getUserId() != null
        @pre userTransferModel.getAccount().getAccount_pk() != null
        @pre userTransferModel.getAmounts() != null
        @pre userTransferModel.getPayee().getPayee_pk() != null
        @pre userTransferModel.getPostScript() != null
        @pre userTransferModel.getAccount().getCurrencyType() != null
     */
    void transfer(UserTransferModel userTransferModel, int pin) throws Exception;
}
