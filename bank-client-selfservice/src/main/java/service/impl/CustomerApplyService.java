package service.impl;

import rpc.UserApplyNewAccountRequest;
import rpc.client.CustomerApplyRpc;
import service.ICustomerApplyService;

import java.sql.Timestamp;

public class CustomerApplyService implements ICustomerApplyService {
    private static CustomerApplyService customerApplyService = null;

    private CustomerApplyService() {

    }

    public static CustomerApplyService getInstance() {
        if(customerApplyService == null) {
            customerApplyService = new CustomerApplyService();
        }
        return customerApplyService;
    }

    public void applyPersonalAccount(String firstName, String lastName, int gender, int identityType,
                                     String identityNum, int accountType, int cardType, Timestamp birthDate,
                                     String address, String email, String phone) throws Exception {
        CustomerApplyRpc.getInstance().applyReq(
                UserApplyNewAccountRequest.newBuilder()
                        .setFirstName(firstName)
                        .setLastName(lastName)
                        .setGender(gender)
                        .setIdentityIdType(identityType)
                        .setIdentityId(identityNum)
                        .setAccountType(accountType)
                        .setCardType(cardType)
                        .setAddress(address)
                        .setEmail(email)
                        .setBirthDate(birthDate)
                        .setPhone(phone).build());
    }
}
