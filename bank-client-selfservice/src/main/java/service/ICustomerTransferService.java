package service;

import model.UserTransferModel;

public interface ICustomerTransferService {
    void transfer(UserTransferModel userTransferModel, int pin) throws Exception;
}
