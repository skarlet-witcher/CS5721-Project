package service.impl;

import dao.impl.UserApplyDao;
import entity.UserApplyArchiveEntity;
import service.IUserCustomerApplyService;

import java.sql.Timestamp;
import java.util.Date;

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
            UserApplyArchiveEntity UserApplyArchiveEntity = new UserApplyArchiveEntity();
            UserApplyArchiveEntity.setFirstName(firstName);
            UserApplyArchiveEntity.setLastName(lastName);
            UserApplyArchiveEntity.setIdentityId(identityNum);
            UserApplyArchiveEntity.setIdentityIdType(identityType);
            UserApplyArchiveEntity.setAccountType(accountType);
            UserApplyArchiveEntity.setCardType(cardType);
            UserApplyArchiveEntity.setBirthDate(birthDate);
            UserApplyArchiveEntity.setGender(gender);
            UserApplyArchiveEntity.setAddress(address);
            UserApplyArchiveEntity.setEmail(email);
            UserApplyArchiveEntity.setPhone(phone);
            UserApplyArchiveEntity.setApplyTime(new Timestamp(new Date().getTime()));
            UserApplyArchiveEntity.setRemark("pending"); // change the attributes of this in the db
            UserApplyDao.getInstance().requestPersonalAccountApply(UserApplyArchiveEntity);
        } catch (Exception e) {
            throw new Exception("Fail to apply an account");
        }
    }
}
