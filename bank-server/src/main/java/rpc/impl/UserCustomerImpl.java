package rpc.impl;

import io.grpc.stub.StreamObserver;
import rpc.*;
import service.IUserCustomerService;
import service.impl.UserCustomerService;
import util.ResponseBuilderFactory;

import java.util.List;
import java.util.logging.Logger;

import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

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

    @Override
    public void editProfile(UserCustomerEditProfileRequest request, StreamObserver<Response> responseObserver) {
        Long id = request.getUserPk();
        String address = request.getAddress();
        String contactNum = request.getPhone();
        String email = request.getEmail();

        try {
            UserCustomerService.getInstance().editUserProfile(id, address, email, contactNum);

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
        Long id = request.getUserPk();

        try {
            List<UserPayeesReply> userPayeesReplies = UserCustomerService.getInstance().getPayeeList(id);
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
       Long user_pk = request.getUserPk();
       String name = request.getName();
       String iban = request.getIban();
       String pin = request.getPin();

       try {
            UserCustomerService.getInstance().addPayee(user_pk, name, iban, pin);
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
        Long payee_pk = request.getPayeePk();
        Long user_id = request.getUserPk();
        logger.info("arrive at customer rpc");
        try {
            UserCustomerService.getInstance().removePayee(payee_pk, user_id);
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
        Long payee_pk = request.getPayeePk();
        Long user_pk = request.getUserPk();
        Long account_pk = request.getAccountPk();
        Double amount = request.getAmount();
        String pin = String.valueOf(request.getPin());
        String postScript = request.getPostScript();
        int currencyType = request.getCurrencyType();

        try {
            UserCustomerService.getInstance().transfer(payee_pk, user_pk, account_pk, amount, pin, postScript, currencyType);
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
        Long user_pk = request.getUserPk();
        Long accountPk = request.getFilterByAccount();
        int date = request.getFilterByDate();
        logger.info("date = " + date);
        try {
            List<UserTransactionsReply> userTransactionsReplies = UserCustomerService.getInstance().getTransaction(user_pk, accountPk, date);
            logger.info("transaction reply: " + userTransactionsReplies.size());
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
