package rpc.impl;

import io.grpc.stub.StreamObserver;
import rpc.*;
import service.IUserCustomerService;
import service.impl.UserCustomerService;
import util.ResponseBuilder;

import java.util.List;

public class UserCustomerImpl extends UserCustomerGrpc.UserCustomerImplBase {
    // private static final Logger logger = Logger.getLogger(UserCustomerGrpc.class.getName());
    private IUserCustomerService customerService = UserCustomerService.getInstance();

    @Override
    public void getAccounts(UserCustomerGetAccountsRequest request, StreamObserver<Response> responseObserver) {
        try {
            List<UserAccountsReply> userAccountsReply = customerService.getAccounts(request.getUserPk());
            responseObserver.onNext(ResponseBuilder.getSuccessBuilder()
                    .addAllUserAccounts(userAccountsReply)
                    .build());
        } catch (Exception e) {
            responseObserver.onNext(ResponseBuilder.getFailBuilder(e.getMessage())
                    .build());
        }
        responseObserver.onCompleted();
    }

    @Override
    public void getProfile(UserCustomerGetProfileRequest request, StreamObserver<Response> responseObserver) {

        try {
            UserProfileReply userProfileReply = customerService.getUserProfile(request.getUserPk());
            responseObserver.onNext(ResponseBuilder.getSuccessBuilder()
                    .setUserProfile(userProfileReply)
                    .build());
        } catch (Exception E) {
            responseObserver.onNext(ResponseBuilder.getFailBuilder(E.getMessage())
                    .build());
        }
        responseObserver.onCompleted();
    }

    @Override
    public void editProfile(UserCustomerEditProfileRequest request, StreamObserver<Response> responseObserver) {

        try {
            customerService.editUserProfile(
                    request.getUserPk(),
                    request.getAddress(),
                    request.getEmail(),
                    request.getPhone());
            responseObserver.onNext(ResponseBuilder.getSuccessBuilder()
                    .build());
        } catch (Exception E) {
            responseObserver.onNext(ResponseBuilder.getFailBuilder(E.getMessage())
                    .build());
        }
        responseObserver.onCompleted();
    }

    @Override
    public void getPayees(UserCustomerGetPayeesRequest request, StreamObserver<Response> responseObserver) {

        try {
            List<UserPayeesReply> userPayeesReplies = customerService.getPayeeList(request.getUserPk());
            responseObserver.onNext(ResponseBuilder.getSuccessBuilder()
                    .addAllUserPayees(userPayeesReplies)
                    .build());
        } catch (Exception E) {
            responseObserver.onNext(ResponseBuilder.getFailBuilder(E.getMessage())
                    .build());
        }
        responseObserver.onCompleted();
    }

    @Override
    public void addPayee(UserCustomerAddPayeeRequest request, StreamObserver<Response> responseObserver) {
       try {
           customerService.addPayee(
                    request.getUserPk(),
                    request.getName(),
                    request.getIban(),
                    request.getPin());
           responseObserver.onNext(ResponseBuilder.getSuccessBuilder()
                   .build());
       } catch (Exception E) {
           responseObserver.onNext(ResponseBuilder.getFailBuilder(E.getMessage())
                   .build());
       }
        responseObserver.onCompleted();
    }

    @Override
    public void removePayee(UserCustomerRemovePayeeRequest request, StreamObserver<Response> responseObserver) {
        try {
            customerService.removePayee(request.getPayeePk(), request.getUserPk());
            responseObserver.onNext(ResponseBuilder.getSuccessBuilder()
                    .build());
        } catch (Exception E) {
            responseObserver.onNext(ResponseBuilder.getFailBuilder(E.getMessage())
                    .build());
        }
        responseObserver.onCompleted();
    }

    @Override
    public void transfer(UserCustomerTransferRequest request, StreamObserver<Response> responseObserver) {
        try {
            customerService.transfer(
                    request.getPayeePk(),
                    request.getUserPk(),
                    request.getAccountPk(),
                    request.getAmount(),
                    String.valueOf(request.getPin()),
                    request.getPostScript(),
                    request.getCurrencyType());
            responseObserver.onNext(ResponseBuilder.getSuccessBuilder()
                    .build());

        } catch (Exception E) {
            responseObserver.onNext(ResponseBuilder.getFailBuilder(E.getMessage())
                    .build());
        }
        responseObserver.onCompleted();
    }

    @Override
    public void getTransactions(UserCustomerGetTransactionsRequest request,
                                StreamObserver<Response> responseObserver) {
        try {
            List<UserTransactionsReply> userTransactionsReplies = customerService.getTransaction(
                    request.getUserPk(),
                    request.getFilterByAccount(),
                    request.getFilterByDate());
            responseObserver.onNext(ResponseBuilder.getSuccessBuilder()
                    .addAllUserTransactions(userTransactionsReplies)
                    .build());
        } catch (Exception E) {
            responseObserver.onNext(ResponseBuilder.getFailBuilder(E.getMessage())
                    .build());
        }
        responseObserver.onCompleted();
    }
}
