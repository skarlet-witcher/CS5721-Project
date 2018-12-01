package service.impl;

import Const.AccountCurrencyType;
import Const.UserAccountType;
import model.UserAccountModel;
import model.UserPayeeModel;
import model.UserTransferModel;
import org.junit.jupiter.api.Test;
import service.ICustomerTransferService;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class CustomerTransferServiceTest {
    private static ICustomerTransferService customerTransferService = CustomerTransferService.getInstance();

    @Test
    void transfer() {
        // init UserModel
        UserAccountModel userAccountModel = new UserAccountModel();
        userAccountModel.setAccount_pk(13L);
        userAccountModel.setAccountNum(1000000001L);
        userAccountModel.setAccountType(UserAccountType.PERSONAL_ACCOUNT);
        userAccountModel.setIban("IE82BOFI23341000000001");
        userAccountModel.setCurrencyType(AccountCurrencyType.EURO);
        // init payee model
        UserPayeeModel userPayeeModel = new UserPayeeModel();
        userPayeeModel.setUserId(15L);
        userPayeeModel.setName("xiangkai");
        userPayeeModel.setIban("DE89370400440532013000");
        userPayeeModel.setPayee_pk(2L);
        // init transfer model
        UserTransferModel userTransferModel = new UserTransferModel(userPayeeModel, userAccountModel, AccountCurrencyType.EURO, 50.0, "transfer test");
        assertDoesNotThrow(() -> {
            customerTransferService.transfer(userTransferModel, 869501);
        });
    }
}