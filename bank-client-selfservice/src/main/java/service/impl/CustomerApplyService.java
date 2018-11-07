package service.impl;

import model.*;
import rpc.UserApplyNewAccountRequest;
import rpc.UserValidateExistingUserRequest;
import rpc.client.CustomerApplyRpc;
import service.ICustomerApplyService;
import util.TimestampConvertHelper;

/*
    @author Xiangkai Tang
 */


public class CustomerApplyService implements ICustomerApplyService {
    private static ICustomerApplyService customerApplyService = null;

    public static ICustomerApplyService getInstance() {
        if(customerApplyService == null) {
            customerApplyService = new CustomerApplyService();
        }
        return customerApplyService;
    }
    @Override
    public void applyPersonalAccountForNewUser(UserApplyNewPersonalAccountBaseModel userApplyNewPersonalAccountBaseModel) throws Exception {
        CustomerApplyRpc.getInstance().applyReq(
                UserApplyNewAccountRequest.newBuilder()
                        .setFirstName(userApplyNewPersonalAccountBaseModel.getFirstName())
                        .setLastName(userApplyNewPersonalAccountBaseModel.getLastName())
                        .setGender(userApplyNewPersonalAccountBaseModel.getGender())
                        .setIdentityIdType(userApplyNewPersonalAccountBaseModel.getIdentityType())
                        .setIdentityId(userApplyNewPersonalAccountBaseModel.getIdentityNum())
                        .setAccountType(userApplyNewPersonalAccountBaseModel.getAccountType())
                        .setCardType(userApplyNewPersonalAccountBaseModel.getCardType())
                        .setAddress(userApplyNewPersonalAccountBaseModel.getAddress())
                        .setEmail(userApplyNewPersonalAccountBaseModel.getEmail())
                        .setBirthDate(TimestampConvertHelper.mysqlToRpc(userApplyNewPersonalAccountBaseModel.getBirthDate()))
                        .setPhone(userApplyNewPersonalAccountBaseModel.getContactNum())
                        .setNewUserApply(userApplyNewPersonalAccountBaseModel.getNewUserApply()).build());

    }
    @Override
    public void applyStudentAccountForNewUser(UserApplyNewStudentAccountBaseModel userApplyNewStudentAccountBaseModel) throws Exception {
        CustomerApplyRpc.getInstance().applyReq(
                UserApplyNewAccountRequest.newBuilder()
                .setFirstName(userApplyNewStudentAccountBaseModel.getFirstName())
                .setLastName(userApplyNewStudentAccountBaseModel.getLastName())
                .setGender(userApplyNewStudentAccountBaseModel.getGender())
                .setIdentityIdType(userApplyNewStudentAccountBaseModel.getIdentityType())
                .setIdentityId(userApplyNewStudentAccountBaseModel.getIdentityNum())
                .setAccountType(userApplyNewStudentAccountBaseModel.getAccountType())
                .setCardType(userApplyNewStudentAccountBaseModel.getCardType())
                .setAddress(userApplyNewStudentAccountBaseModel.getAddress())
                .setEmail(userApplyNewStudentAccountBaseModel.getEmail())
                .setBirthDate(TimestampConvertHelper.mysqlToRpc(userApplyNewStudentAccountBaseModel.getBirthDate()))
                .setPhone(userApplyNewStudentAccountBaseModel.getContactNum())
                .setGraduateDate(TimestampConvertHelper.mysqlToRpc(userApplyNewStudentAccountBaseModel.getGraduateDate()))
                .setStudentId(userApplyNewStudentAccountBaseModel.getStudentId())
                .setUniversityName(userApplyNewStudentAccountBaseModel.getSchoolName()).build());

    }

    @Override
    public void applyYoungSaverAccountForNewUser(UserApplyNewYoungSaverAccountBaseModel userApplyNewYoungSaverAccountBaseModel) throws Exception {
        CustomerApplyRpc.getInstance().applyReq(
                UserApplyNewAccountRequest.newBuilder()
                        .setFirstName(userApplyNewYoungSaverAccountBaseModel.getFirstName())
                        .setLastName(userApplyNewYoungSaverAccountBaseModel.getLastName())
                        .setGender(userApplyNewYoungSaverAccountBaseModel.getGender())
                        .setIdentityIdType(userApplyNewYoungSaverAccountBaseModel.getIdentityType())
                        .setIdentityId(userApplyNewYoungSaverAccountBaseModel.getIdentityNum())
                        .setAccountType(userApplyNewYoungSaverAccountBaseModel.getAccountType())
                        .setCardType(userApplyNewYoungSaverAccountBaseModel.getCardType())
                        .setAddress(userApplyNewYoungSaverAccountBaseModel.getAddress())
                        .setEmail(userApplyNewYoungSaverAccountBaseModel.getEmail())
                        .setBirthDate(TimestampConvertHelper.mysqlToRpc(userApplyNewYoungSaverAccountBaseModel.getBirthDate()))
                        .setPhone(userApplyNewYoungSaverAccountBaseModel.getContactNum())
                        .setParentUserId(userApplyNewYoungSaverAccountBaseModel.getParentUserId())
                        .setParentFirstName(userApplyNewYoungSaverAccountBaseModel.getParentFirstName())
                        .setParentLastName(userApplyNewYoungSaverAccountBaseModel.getParentLastName())
                        .setNewUserApply(userApplyNewYoungSaverAccountBaseModel.getNewUserApply())
                        .build());

    }
    @Override
    public void applyGoldenAccountForNewUser(UserApplyNewGoldenAccountBaseModel userApplyNewGoldenAccountBaseModel) throws Exception {
        CustomerApplyRpc.getInstance().applyReq(
                UserApplyNewAccountRequest.newBuilder()
                        .setFirstName(userApplyNewGoldenAccountBaseModel.getFirstName())
                        .setLastName(userApplyNewGoldenAccountBaseModel.getLastName())
                        .setGender(userApplyNewGoldenAccountBaseModel.getGender())
                        .setIdentityIdType(userApplyNewGoldenAccountBaseModel.getIdentityType())
                        .setIdentityId(userApplyNewGoldenAccountBaseModel.getIdentityNum())
                        .setAccountType(userApplyNewGoldenAccountBaseModel.getAccountType())
                        .setCardType(userApplyNewGoldenAccountBaseModel.getCardType())
                        .setAddress(userApplyNewGoldenAccountBaseModel.getAddress())
                        .setEmail(userApplyNewGoldenAccountBaseModel.getEmail())
                        .setBirthDate(TimestampConvertHelper.mysqlToRpc(userApplyNewGoldenAccountBaseModel.getBirthDate()))
                        .setPhone(userApplyNewGoldenAccountBaseModel.getContactNum())
                        .setNewUserApply(userApplyNewGoldenAccountBaseModel.getNewUserApply())
                        .build());
    }

    @Override
    public void checkExistingUserBeforeApply(UserModel userModel) throws Exception {
        CustomerApplyRpc.getInstance().checkExistingUserBeforeApply(
                UserValidateExistingUserRequest.newBuilder().setUserId(userModel.getUserId())
                .setFirstName(userModel.getFirstName())
                .setLastName(userModel.getLastName()).build());
    }
    @Override
    public void applyPersonalAccountForExistingUser(UserApplyNewPersonalAccountBaseModel userApplyNewPersonalAccountBaseModel) throws Exception {
        CustomerApplyRpc.getInstance().applyReq(
                UserApplyNewAccountRequest.newBuilder().setUserId(userApplyNewPersonalAccountBaseModel.getUserId())
                .setAccountType(userApplyNewPersonalAccountBaseModel.getAccountType())
                .setCardType(userApplyNewPersonalAccountBaseModel.getCardType())
                .setNewUserApply(userApplyNewPersonalAccountBaseModel.getNewUserApply())
                .build()
        );
    }

    @Override
    public void applyStudentAccountForExistingUser(UserApplyNewStudentAccountBaseModel userApplyNewStudentAccountBaseModel) throws Exception {
      CustomerApplyRpc.getInstance().applyReq(
                UserApplyNewAccountRequest.newBuilder().setUserId(userApplyNewStudentAccountBaseModel.getUserId())
                .setAccountType(userApplyNewStudentAccountBaseModel.getAccountType())
                .setCardType(userApplyNewStudentAccountBaseModel.getAccountType())
                .setGraduateDate(TimestampConvertHelper.mysqlToRpc(userApplyNewStudentAccountBaseModel.getGraduateDate()))
                .setStudentId(userApplyNewStudentAccountBaseModel.getStudentId())
                .setUniversityName(userApplyNewStudentAccountBaseModel.getSchoolName())
                .setNewUserApply(userApplyNewStudentAccountBaseModel.getNewUserApply()).build()
        );
    }

    @Override
    public void applyYoungSaverAccountForExistingUser(UserApplyNewYoungSaverAccountBaseModel userApplyNewYoungSaverAccountBaseModel) throws Exception {
        CustomerApplyRpc.getInstance().applyReq(
                UserApplyNewAccountRequest.newBuilder().setUserId(userApplyNewYoungSaverAccountBaseModel.getUserId())
                .setAccountType(userApplyNewYoungSaverAccountBaseModel.getAccountType())
                .setCardType(userApplyNewYoungSaverAccountBaseModel.getCardType())
                .setNewUserApply(userApplyNewYoungSaverAccountBaseModel.getNewUserApply())
                .setParentUserId(userApplyNewYoungSaverAccountBaseModel.getParentUserId())
                .setParentFirstName(userApplyNewYoungSaverAccountBaseModel.getParentFirstName())
                .setParentLastName(userApplyNewYoungSaverAccountBaseModel.getParentLastName())
                .build()
        );

    }
    @Override
    public void applyGoldenAccountForExistingUser(UserApplyNewGoldenAccountBaseModel userApplyNewGoldenAccountBaseModel) throws Exception {
        CustomerApplyRpc.getInstance().applyReq(
                UserApplyNewAccountRequest.newBuilder().setUserId(userApplyNewGoldenAccountBaseModel.getUserId())
                        .setAccountType(userApplyNewGoldenAccountBaseModel.getAccountType())
                        .setCardType(userApplyNewGoldenAccountBaseModel.getCardType())
                        .setNewUserApply(userApplyNewGoldenAccountBaseModel.getNewUserApply())
                        .build()
        );
    }


}
