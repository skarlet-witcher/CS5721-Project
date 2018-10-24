package service.impl;

import rpc.UserApplyNewAccountRequest;
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
                        .setBirthDate(TimestampConvertHelper.mysqlToRpc(birthDate))
                        .setPhone(phone).build());
    }

    public void applyStudentAccount(String firstName, String lastName, int gender, int identityType,
                                    String identityNum, int accountType, int cardType, Timestamp birthDate,
                                    String address, String email, String phone, Timestamp graduateDate, String studentId, String schoolName) throws Exception {
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
                                       String address, String email, String phone, long parentUserId, String parentFirstName, String parentLastName) throws Exception {
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
                        .build());
    }
}
