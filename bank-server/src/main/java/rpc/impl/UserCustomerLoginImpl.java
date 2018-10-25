package rpc.impl;

import io.grpc.stub.StreamObserver;
import rpc.*;
import service.IUserCustomerApplyService;
import service.IUserCustomerLoginService;
import service.impl.UserCustomerApplyService;
import service.impl.UserCustomerLoginService;
import util.ResponseBuilder;
import util.TimestampConvertHelper;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class UserCustomerLoginImpl extends UserCustomerLoginGrpc.UserCustomerLoginImplBase {
    private static final Logger logger = Logger.getLogger(UserCustomerLoginGrpc.class.getName());
    private IUserCustomerLoginService customerLoginService = UserCustomerLoginService.getInstance();
    private IUserCustomerApplyService customerApplyService = UserCustomerApplyService.getInstance();

    @Override
    public void loginReq(UserLoginReqRequest request, StreamObserver<Response> responseObserver) {
        long userId = request.getUserId();
        int phoneLast4 = request.getPhoneLast4();
        int birthDay = request.getBirthDay();
        int birthMon = request.getBirthMon();
        int birthYear = request.getBirthYear();

        try {
            UserLoginReqReply userLoginReqReply = customerLoginService.LoginReq(userId, phoneLast4, birthDay, birthMon, birthYear);

            responseObserver.onNext(ResponseBuilder.ResponseSuccessBuilder()
                    .setUserLoginReqReply(userLoginReqReply)
                    .build());
        } catch (Exception e) {
            responseObserver.onNext(ResponseBuilder.ResponseFailBuilder(e.getMessage())
                    .build());
        }
        responseObserver.onCompleted();
    }

    @Override
    public void login(UserLoginRequest request, StreamObserver<Response> responseObserver) {
        Map<Integer, Integer> pin = new HashMap<>();
        pin.put(1, request.getPin1());
        pin.put(2, request.getPin2());
        pin.put(3, request.getPin3());
        pin.put(4, request.getPin4());
        pin.put(5, request.getPin5());
        pin.put(6, request.getPin6());

        try {
            UserLoginReply loginReply = customerLoginService.LoginByUserIdAndPin(request.getUserId(), pin);

            responseObserver.onNext(ResponseBuilder.ResponseSuccessBuilder()
                    .setUserLoginReply(loginReply)
                    .build());
        } catch (Exception e) {
            responseObserver.onNext(ResponseBuilder.ResponseFailBuilder(e.getMessage())
                    .build());
        }
        responseObserver.onCompleted();
    }

    @Override
    public void applyNewAccount(UserApplyNewAccountRequest request, StreamObserver<Response> responseObserver) {
        String firstName = request.getFirstName();
        String lastName = request.getLastName();
        String identityNum = request.getIdentityId();
        int identityType = request.getIdentityIdType();
        int accountType = request.getAccountType();
        int cardType = request.getCardType();
        Timestamp birthDate = TimestampConvertHelper.rpcToMysql(request.getBirthDate());
        int gender = request.getGender();
        String address = request.getAddress();
        String email = request.getEmail();
        String phone = request.getPhone();
        Timestamp graduateDate = TimestampConvertHelper.rpcToMysql(request.getGraduateDate());
        String studentId = request.getStudentId();
        String university = request.getUniversityName();
        long parentUserId = request.getParentUserId();
        String parentFirstName = request.getParentFirstName();
        String parentLastName = request.getParentLastName();

        Long userId = request.getUserId();

        logger.info("User Id is: " + userId);



        try {
            if(accountType == 1) {
                logger.info("ready to apply personal account (ready to invoke customerApplySerivce)");
                customerApplyService.requestPersonalAccountApply(
                        firstName, lastName, identityNum, identityType, accountType, cardType,
                        birthDate, gender, address, email, phone);
            }
            if(accountType == 2) {
                logger.info("ready to apply student account");
                customerApplyService.requestStudentAccountApply(
                        firstName, lastName, identityNum, identityType, accountType, cardType,
                        birthDate, gender, address, email, phone,
                        graduateDate,studentId,university);
            }
            if(accountType == 3) {
                logger.info("ready to apply young saver account");
                customerApplyService.requestYoungSaverAccountApply(firstName, lastName, identityNum, identityType, accountType, cardType,
                        birthDate, gender, address, email, phone, parentUserId, parentFirstName, parentLastName);
            }
            if(accountType == 4) {
                logger.info("ready to apply golden account");
                customerApplyService.requestGoldenAccountApply(firstName, lastName, identityNum, identityType, accountType, cardType,
                        birthDate, gender, address, email, phone);
            }
            // check existing user before apply
            if(userId.toString().length() == 10) {
                logger.info("ready to checkExistingUserBeforeApply");
                customerApplyService.checkExistingUserBeforeApply(userId, firstName, lastName);
            }
            responseObserver.onNext(ResponseBuilder.ResponseSuccessBuilder()
                    .build());


        } catch (Exception E) {
            responseObserver.onNext(ResponseBuilder.ResponseFailBuilder(E.getMessage())
                    .build());
        }
        responseObserver.onCompleted();
    }

    @Override
    public void forgetUserId(UserForgetUserIdRequest request, StreamObserver<Response> responseObserver) {
        super.forgetUserId(request, responseObserver);
    }

    @Override
    public void forgetPin(UserForgetPinRequest request, StreamObserver<Response> responseObserver) {
        super.forgetPin(request, responseObserver);
    }
}
