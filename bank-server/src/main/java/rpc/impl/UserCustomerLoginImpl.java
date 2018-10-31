package rpc.impl;

import Const.UserAccountType;
import io.grpc.stub.StreamObserver;
import rpc.*;
import service.IUserCustomerApplyService;
import service.IUserCustomerLoginService;
import service.impl.UserCustomerApplyService;
import service.impl.UserCustomerLoginService;
import util.ResponseBuilderFactory;
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
        Long userId = request.getUserId();
        int phoneLast4 = request.getPhoneLast4();
        int birthDay = request.getBirthDay();
        int birthMon = request.getBirthMon();
        int birthYear = request.getBirthYear();

        try {
            //1 create result of service, which contains pin and some other attr
            UserLoginReqReply userLoginReqReply = customerLoginService.LoginReq(userId, phoneLast4, birthDay, birthMon, birthYear);
            logger.info("Input those digits of PIN:" + userLoginReqReply.getAllFields());
            //2 set the above result to responseObserver
            responseObserver.onNext(ResponseBuilderFactory.ResponseSuccessBuilder()
                    .setUserLoginReqReply(userLoginReqReply)
                    .build());
        } catch (Exception e) {
            responseObserver.onNext(ResponseBuilderFactory.ResponseFailBuilder(e.getMessage())
                    .build());
        }
            //3 Send all above to client
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
        logger.info("User " + request.getUserId() + " ready to match with the PIN");
        try {
            UserLoginReply loginReply = customerLoginService.LoginByUserIdAndPin(request.getUserId(), pin);

            responseObserver.onNext(ResponseBuilderFactory.ResponseSuccessBuilder()
                    .setUserLoginReply(loginReply)
                    .build());
        } catch (Exception e) {
            responseObserver.onNext(ResponseBuilderFactory.ResponseFailBuilder(e.getLocalizedMessage())
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
        int isNewUser = request.getNewUserApply();

        Long userId = request.getUserId();

        logger.info("User Id is: " + userId);


        try {
            if (userId.toString().length() == 10) {
                logger.info("check whether the existing model have duplicated apply");
                customerApplyService.checkDuplicateApply(userId, accountType, cardType);
            }

            if (accountType == UserAccountType.PERSONAL_ACCOUNT) {
                logger.info("ready to apply personal account (ready to invoke customerApplySerivce)");
                customerApplyService.requestPersonalAccountApply(
                        firstName, lastName, identityNum, identityType, accountType, cardType,
                        birthDate, gender, address, email, phone, isNewUser, userId);
            }
            if (accountType == UserAccountType.STUDENT_ACCOUNT) {
                logger.info("ready to apply student account");
                customerApplyService.requestStudentAccountApply(
                        firstName, lastName, identityNum, identityType, accountType, cardType,
                        birthDate, gender, address, email, phone, isNewUser,
                        graduateDate, studentId, university, userId);
            }
            if (accountType == UserAccountType.YOUNG_SAVER_ACCOUNT) {
                logger.info("ready to apply young saver account");
                customerApplyService.requestYoungSaverAccountApply(firstName, lastName, identityNum, identityType, accountType, cardType,
                        birthDate, gender, address, email, phone, isNewUser, parentUserId, parentFirstName, parentLastName, userId);
            }
            if (accountType == UserAccountType.GOLDEN_ACCOUNT) {
                logger.info("ready to apply golden account");
                customerApplyService.requestGoldenAccountApply(firstName, lastName, identityNum, identityType, accountType, cardType,
                        birthDate, gender, address, email, phone, isNewUser, userId);
            }

            responseObserver.onNext(ResponseBuilderFactory.ResponseSuccessBuilder()
                    .build());


        } catch (Exception e) {
            responseObserver.onNext(ResponseBuilderFactory.ResponseFailBuilder(e.getLocalizedMessage())
                    .build());
        }
        responseObserver.onCompleted();
    }

    @Override
    public void validateExistingUser(UserValidateExistingUserRequest request,
                                     StreamObserver<Response> responseObserver) {
        long userId = request.getUserId();
        String firstName = request.getFirstName();
        String lastName = request.getLastName();

        try {
            logger.info("ready to checkExistingUserBeforeApply");
            customerApplyService.checkExistingUserBeforeApply(userId, firstName, lastName);
            responseObserver.onNext(ResponseBuilderFactory.ResponseSuccessBuilder()
                    .build());
        } catch (Exception e) {
            responseObserver.onNext(ResponseBuilderFactory.ResponseFailBuilder(e.getLocalizedMessage())
                    .build());
        }
        responseObserver.onCompleted();
    }

    @Override
    public void forgetUserId(UserForgetUserIdRequest request, StreamObserver<Response> responseObserver) {
        super.forgetUserId(request, responseObserver);
    }

    /**
     * The method is called by RPC in server-side when receiving a request of forgetting PIN
     * @param request A request of forgeting PIN which contains information of requester
     * @param responseObserver Response observer to dispatch the response to client-side
     */
    @Override
    public void forgetPin(UserForgetPinRequest request, StreamObserver<Response> responseObserver) {
        Timestamp birthdate = Timestamp.valueOf(request.getBirthDate());
        String email = request.getEmail();
        long userId = request.getUserId();
        try {
            logger.info("ready to check user's supplied information to get PIN");
            customerLoginService.forgotPIN(userId,email,birthdate);
            responseObserver.onNext(ResponseBuilderFactory.ResponseSuccessBuilder()
                    .build());
        } catch (Exception e) {
            responseObserver.onNext(ResponseBuilderFactory.ResponseFailBuilder(e.getLocalizedMessage())
                    .build());
        }
        responseObserver.onCompleted();
    }
}
