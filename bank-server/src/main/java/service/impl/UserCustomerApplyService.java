package service.impl;

import dao.impl.UserApplyDao;
import entity.UserApplyArchiveEntity;
import service.IUserCustomerApplyService;

import java.sql.Timestamp;
import java.util.Date;

public class UserCustomerApplyService implements IUserCustomerApplyService {
    private static UserCustomerApplyService userCustomerApplyService = null;
    private UserApplyDao userApplyDao = UserApplyDao.getInstance();

    public static UserCustomerApplyService getInstance() {
        if(userCustomerApplyService == null) {
            return new UserCustomerApplyService();
        }
        return userCustomerApplyService;
    }

    public void requestPersonalAccountApply(String firstName, String lastName, String identityNum, int identityType, int accountType, int cardType,
                                            Timestamp birthDate, int gender, String address, String email, String phone) throws Exception {
        try {
            // basic info
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
            userApplyDao.requestAccountApply(UserApplyArchiveEntity);
        } catch (Exception e) {
            throw new Exception("Fail to apply a personal current account");
        }
    }

    @Override
    public void requestStudentAccountApply(String firstName, String lastName, String identityNum, int identityType, int accountType, int cardType, Timestamp birthDate, int gender,
                                           String address, String email, String phone,
                                           Timestamp graduateDate, String studentId, String university) throws Exception {
        try{
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
            // student info
            UserApplyArchiveEntity.setGraduateDate(graduateDate);
            UserApplyArchiveEntity.setStudentId(studentId);
            UserApplyArchiveEntity.setUniversity(university);
            userApplyDao.requestAccountApply(UserApplyArchiveEntity);

        } catch (Exception e) {
            throw new Exception("Fail to apply a student current account");
        }
    }
}
