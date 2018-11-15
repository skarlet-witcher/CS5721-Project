package rpc.impl;

import io.grpc.stub.StreamObserver;
import rpc.*;
import service.IUserCustomerService;
import service.impl.UserCustomerService;
import util.ResponseBuilderFactory;

import java.util.List;
import java.util.logging.Logger;

import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/*
    @author Xiangkai Tang
 */

public class UserCustomerImpl extends UserCustomerGrpc.UserCustomerImplBase {
    private static final Logger logger = Logger.getLogger(UserCustomerGrpc.class.getName());
    private IUserCustomerService customerService = UserCustomerService.getInstance();

    @Override
    public void getAccounts(UserCustomerGetAccountsRequest request, StreamObserver<Response> responseObserver) {

        try {
            List<UserAccountsReply> userAccountsReply = customerService.getAccounts(request.getUserPk());
            responseObserver.onNext(ResponseBuilderFactory.ResponseSuccessBuilder()
                    .addAllUserAccounts(userAccountsReply)
                    .build());
        } catch (Exception e) {
            responseObserver.onNext(ResponseBuilderFactory.ResponseFailBuilder(e.getMessage())
                    .build());
        }
        responseObserver.onCompleted();
    }

    @Override
    public void getProfile(UserCustomerGetProfileRequest request, StreamObserver<Response> responseObserver) {

        try {
            UserProfileReply userProfileReply = customerService.getUserProfile(request.getUserPk());
            responseObserver.onNext(ResponseBuilderFactory.ResponseSuccessBuilder()
                    .setUserProfile(userProfileReply)
                    .build());
        } catch (Exception E) {
            responseObserver.onNext(ResponseBuilderFactory.ResponseFailBuilder(E.getMessage())
                    .build());
        }
        responseObserver.onCompleted();
    }

    @Override
    public void editProfile(UserCustomerEditProfileRequest request, StreamObserver<Response> responseObserver) {

        try {
            UserCustomerService.getInstance().editUserProfile(
                    request.getUserPk(),
                    request.getAddress(),
                    request.getEmail(),
                    request.getPhone());
            responseObserver.onNext(ResponseBuilderFactory.ResponseSuccessBuilder()
                    .build());
        } catch (Exception E) {
            responseObserver.onNext(ResponseBuilderFactory.ResponseFailBuilder(E.getMessage())
                    .build());
        }
        responseObserver.onCompleted();
    }

    @Override
    public void getPayees(UserCustomerGetPayeesRequest request, StreamObserver<Response> responseObserver) {

        try {
            List<UserPayeesReply> userPayeesReplies = UserCustomerService.getInstance().getPayeeList(request.getUserPk());
            responseObserver.onNext(ResponseBuilderFactory.ResponseSuccessBuilder()
                    .addAllUserPayees(userPayeesReplies)
                    .build());
        } catch (Exception E) {
            responseObserver.onNext(ResponseBuilderFactory.ResponseFailBuilder(E.getMessage())
                    .build());
        }
        responseObserver.onCompleted();
    }

    @Override
    public void addPayee(UserCustomerAddPayeeRequest request, StreamObserver<Response> responseObserver) {
       try {
            UserCustomerService.getInstance().addPayee(
                    request.getUserPk(),
                    request.getName(),
                    request.getIban(),
                    request.getPin());
           responseObserver.onNext(ResponseBuilderFactory.ResponseSuccessBuilder()
                   .build());
       } catch (Exception E) {
           responseObserver.onNext(ResponseBuilderFactory.ResponseFailBuilder(E.getMessage())
                   .build());
       }
        responseObserver.onCompleted();
    }

    @Override
    public void removePayee(UserCustomerRemovePayeeRequest request, StreamObserver<Response> responseObserver) {
        try {
            UserCustomerService.getInstance().removePayee(request.getPayeePk(), request.getUserPk());
            responseObserver.onNext(ResponseBuilderFactory.ResponseSuccessBuilder()
                    .build());
        } catch (Exception E) {
            responseObserver.onNext(ResponseBuilderFactory.ResponseFailBuilder(E.getMessage())
                    .build());
        }
        responseObserver.onCompleted();
    }

    @Override
    public void transfer(UserCustomerTransferRequest request, StreamObserver<Response> responseObserver) {
        try {
            UserCustomerService.getInstance().transfer(
                    request.getPayeePk(),
                    request.getUserPk(),
                    request.getAccountPk(),
                    request.getAmount(),
                    String.valueOf(request.getPin()),
                    request.getPostScript(),
                    request.getCurrencyType());
            responseObserver.onNext(ResponseBuilderFactory.ResponseSuccessBuilder()
                    .build());

        } catch (Exception E) {
            responseObserver.onNext(ResponseBuilderFactory.ResponseFailBuilder(E.getMessage())
                    .build());
        }
        responseObserver.onCompleted();
    }

    @Override
    public void getTransactions(UserCustomerGetTransactionsRequest request,
                                StreamObserver<Response> responseObserver) {
        try {
            List<UserTransactionsReply> userTransactionsReplies = UserCustomerService.getInstance().getTransaction(
                    request.getUserPk(),
                    request.getFilterByAccount(),
                    request.getFilterByDate());
            responseObserver.onNext(ResponseBuilderFactory.ResponseSuccessBuilder()
                    .addAllUserTransactions(userTransactionsReplies)
                    .build());
        } catch (Exception E) {
            responseObserver.onNext(ResponseBuilderFactory.ResponseFailBuilder(E.getMessage())
                    .build());
        }
        responseObserver.onCompleted();
    }




}
