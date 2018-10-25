package service.impl;

import rpc.UserApplyNewAccountRequest;
import rpc.UserValidateExistingUserRequest;
import rpc.client.CustomerApplyRpc;
import service.ICustomerApplyService;
import util.TimestampConvertHelper;

import java.sql.Timestamp;

public class CustomerApplyService implements ICustomerApplyService {
    private static CustomerApplyService customerApplyService = null;

    public static CustomerApplyService getInstance() {
        if(customerApplyService == null) {
            customerApplyService = new CustomerApplyService();
        }
        return customerApplyService;
    }

    public void applyPersonalAccount(String firstName, String lastName, int gender, int identityType,
                                     String identityNum, int accountType, int cardType, Timestamp birthDate,
                                     String address, String email, String phone, int isNewUser) throws Exception {
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
                        .setBirthDate(TimestampConvertHelper.mysqlToRpc(birthDate))
                        .setPhone(phone)
                        .setNewUserApply(isNewUser).build());
    }

    public void applyStudentAccount(String firstName, String lastName, int gender, int identityType,
                                    String identityNum, int accountType, int cardType, Timestamp birthDate,
                                    String address, String email, String phone, int isNewUser, Timestamp graduateDate, String studentId, String schoolName) throws Exception {
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
                .setBirthDate(TimestampConvertHelper.mysqlToRpc(birthDate))
                .setPhone(phone)
                .setGraduateDate(TimestampConvertHelper.mysqlToRpc(graduateDate))
                .setStudentId(studentId)
                .setUniversityName(schoolName).build());
    }

    public void applyYoungSaverAccount(String firstName, String lastName, int gender, int identityType,
                                       String identityNum, int accountType, int cardType, Timestamp birthDate,
                                       String address, String email, String phone, int isNewUser, long parentUserId, String parentFirstName, String parentLastName) throws Exception {
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
                        .setBirthDate(TimestampConvertHelper.mysqlToRpc(birthDate))
                        .setPhone(phone)
                        .setParentUserId(parentUserId)
                        .setParentFirstName(parentFirstName)
                        .setParentLastName(parentLastName)
                        .setNewUserApply(isNewUser)
                        .build());
    }

    public void applyGoldenAccount(String firstName, String lastName, int gender, int identityType,
                                   String identityNum, int accountType, int cardType, Timestamp birthDate,
                                   String address, String email, String phone, int isNewUser) throws Exception {
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
                        .setBirthDate(TimestampConvertHelper.mysqlToRpc(birthDate))
                        .setPhone(phone)
                        .setNewUserApply(isNewUser)
                        .build());
    }

    public void checkExistingUserBeforeApply(long userId, String firstName, String lastName) throws Exception {
        CustomerApplyRpc.getInstance().checkExistingUserBeforeApply(
                UserValidateExistingUserRequest.newBuilder().setUserId(userId)
                .setFirstName(firstName)
                .setLastName(lastName).build());
    }

    public void applyPersonalAccount(long userId, int accountType, int cardType, int isNewUser) throws Exception {
        CustomerApplyRpc.getInstance().applyReq(
                UserApplyNewAccountRequest.newBuilder().setUserId(userId)
                .setAccountType(accountType)
                .setCardType(cardType)
                .setNewUserApply(isNewUser)
                .build()
        );
    }

    public void applyStudentAccount(long userId, int accountType, int cardType, int isNewUser,
                                    Timestamp graduateDate, String studentId, String schoolName) throws Exception {
        CustomerApplyRpc.getInstance().applyReq(
                UserApplyNewAccountRequest.newBuilder().setUserId(userId)
                .setAccountType(accountType)
                .setCardType(cardType)
                .setGraduateDate(TimestampConvertHelper.mysqlToRpc(graduateDate))
                .setStudentId(studentId)
                .setUniversityName(schoolName)
                .setNewUserApply(isNewUser).build()
        );
    }

    public void applyYoungSaverAccount(long userId, int accountType, int cardType, int isNewUser,
                                       long parentUserId, String parentFirstName, String parentLastName) throws Exception {
        CustomerApplyRpc.getInstance().applyReq(
                UserApplyNewAccountRequest.newBuilder().setUserId(userId)
                .setAccountType(accountType)
                .setCardType(cardType)
                .setNewUserApply(isNewUser)
                .setParentUserId(parentUserId)
                .setParentFirstName(parentFirstName)
                .setParentLastName(parentLastName)
                .build()
        );
    }

    public void applyGoldenAccount(long userId, int accountType, int cardType, int isNewUser) throws Exception {
        CustomerApplyRpc.getInstance().applyReq(
                UserApplyNewAccountRequest.newBuilder().setUserId(userId)
                        .setAccountType(accountType)
                        .setCardType(cardType)
                        .setNewUserApply(isNewUser)
                        .build()
        );
    }

}
