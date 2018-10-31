package rpc.impl;

import io.grpc.stub.StreamObserver;
import rpc.*;
import service.IUserCustomerService;
import service.impl.UserCustomerService;
import util.ResponseBuilderFactory;

import java.util.List;
import java.util.logging.Logger;

public class UserCustomerImpl extends UserCustomerGrpc.UserCustomerImplBase {
    private static final Logger logger = Logger.getLogger(UserCustomerGrpc.class.getName());
    private IUserCustomerService customerService = UserCustomerService.getInstance();

    @Override
    public void getAccounts(UserCustomerGetAccountsRequest request, StreamObserver<Response> responseObserver) {
        Long id = request.getUserPk();

        try {
            logger.info("Server.rpc: Ready to getAccounts from customerService.");
            List<UserAccountsReply> userAccountsReply = customerService.getAccounts(id);
            logger.info("Server.rpc: How many result: " + userAccountsReply.size());
            logger.info("Server.rpc: Ready to add results into response");
            logger.info("Server.rpc: one of the value in the UserAccountReply: " + userAccountsReply.get(0).getBalance());

            responseObserver.onNext(ResponseBuilderFactory.ResponseSuccessBuilder()
                    .addAllUserAccounts(userAccountsReply)
                    .build());
            logger.info("UserCustomerService: pack response success.");

        } catch (Exception e) {
            responseObserver.onNext(ResponseBuilderFactory.ResponseFailBuilder(e.getMessage())
                    .build());
        }
        responseObserver.onCompleted();
    }

    @Override
    public void getProfile(UserCustomerGetProfileRequest request, StreamObserver<Response> responseObserver) {
        Long id = request.getUserPk();

        try {
            UserProfileReply userProfileReply = customerService.getUserProfile(id);

            responseObserver.onNext(ResponseBuilderFactory.ResponseSuccessBuilder()
                    .setUserProfile(userProfileReply)
                    .build());

        } catch (Exception E) {
            responseObserver.onNext(ResponseBuilderFactory.ResponseFailBuilder(E.getMessage())
                    .build());
        }
        responseObserver.onCompleted();
    }
}
