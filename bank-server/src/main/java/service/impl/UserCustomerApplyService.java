package service.impl;

import java.sql.Timestamp;
import java.util.Date;

import dao.impl.UserApplyDao;
import entity.BankApplyEntity;
import rpc.UserApplyNewAccountRequestOrBuilder;
import service.IUserCustomerApplyService;

public class UserCustomerApplyService implements IUserCustomerApplyService {
    private static UserCustomerApplyService userCustomerApplyService = null;

    private UserCustomerApplyService() {

    }

    public static UserCustomerApplyService getInstance() {
        if(userCustomerApplyService == null) {
            userCustomerApplyService = new UserCustomerApplyService();
        }
        return userCustomerApplyService;
    }

    public void requestPersonalAccountApply(String firstName, String lastName, String identityNum, int identityType, int accountType, int cardType,
                                           Timestamp birthDate, int gender, String address, String email, String phone) throws Exception {
        try {
            BankApplyEntity bankApplyEntity = new BankApplyEntity();
            bankApplyEntity.setFirstName(firstName);
            bankApplyEntity.setLastName(lastName);
            bankApplyEntity.setIdentityId(identityNum);
            bankApplyEntity.setIdentityIdType(identityType);
            bankApplyEntity.setAccountType(accountType);
            bankApplyEntity.setCardType(cardType);
            bankApplyEntity.setBirthDate(birthDate);
            bankApplyEntity.setGender(gender);
            bankApplyEntity.setAddress(address);
            bankApplyEntity.setEmail(email);
            bankApplyEntity.setPhone(phone);
            bankApplyEntity.setApplyTime(new Timestamp(new Date().getTime()));
            int result = UserApplyDao.getInstance().requestPersonalAccountApply(bankApplyEntity);
            if(result >= 1) {
                // apply complete
            } else {
                throw new Exception("Fail to apply an account");
            }
        } catch (Exception e) {
            throw new Exception("Fail to apply an account");
        }
    }
}
