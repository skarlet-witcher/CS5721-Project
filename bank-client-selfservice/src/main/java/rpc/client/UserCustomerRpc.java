package rpc.client;

import Const.ResponseStatusType;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import rpc.*;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import static Const.Server.SERVER_HOST;
import static Const.Server.SERVER_PORT;

public class UserCustomerRpc {
    private static final Logger logger = Logger.getLogger(UserCustomerRpc.class.getName());

    private static UserCustomerRpc instance = null;

    public static UserCustomerRpc getInstance() {
        if (instance == null) {
            return new UserCustomerRpc();
        }
        return instance;
    }

    public List<UserAccountsReply> getAccounts(UserCustomerGetAccountsRequest userCustomerGetAccountsRequest) throws Exception {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(SERVER_HOST, SERVER_PORT)
                .usePlaintext().build();
        UserCustomerGrpc.UserCustomerBlockingStub blockingStub = UserCustomerGrpc.newBlockingStub(channel);

        logger.info(userCustomerGetAccountsRequest.getUserPk() + " is requesting to get accounts.");

        Response response = blockingStub.getAccounts(userCustomerGetAccountsRequest);

        logger.info("check the response: " + response.getUserAccountsList().size());

        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);

        if (response.getStatusCode() == ResponseStatusType.SUCCESS) {
            logger.info(userCustomerGetAccountsRequest.getUserPk() + " get accounts successful.");
            return response.getUserAccountsList();
        } else {
            logger.info(userCustomerGetAccountsRequest.getUserPk() + " fail to get accounts due to " + response.getDescription());
            throw new Exception(response.getDescription());
        }
    }
    public UserProfileReply getUserProfile(UserCustomerGetProfileRequest userCustomerGetProfileRequest) throws Exception {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(SERVER_HOST, SERVER_PORT)
                .usePlaintext().build();
        UserCustomerGrpc.UserCustomerBlockingStub blockingStub = UserCustomerGrpc.newBlockingStub(channel);

        logger.info(userCustomerGetProfileRequest.getUserPk() + " is requesting to get accounts.");

        Response response = blockingStub.getProfile(userCustomerGetProfileRequest);

        logger.info("check the response: " + response.getUserAccountsList().size());

        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);

        if (response.getStatusCode() == ResponseStatusType.SUCCESS) {
            logger.info(userCustomerGetProfileRequest.getUserPk() + " get user profile successful.");
            return response.getUserProfile();
        } else {
            logger.info(userCustomerGetProfileRequest.getUserPk() + " fail to get user profile due to " + response.getDescription());
            throw new Exception(response.getDescription());
        }
    }
    public Response editUserProfile(UserCustomerEditProfileRequest userCustomerEditProfileRequest) throws Exception {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(SERVER_HOST, SERVER_PORT)
                .usePlaintext().build();
        UserCustomerGrpc.UserCustomerBlockingStub blockingStub = UserCustomerGrpc.newBlockingStub(channel);

        logger.info(userCustomerEditProfileRequest.getUserPk() + " is requesting to get accounts.");

        Response response = blockingStub.editProfile(userCustomerEditProfileRequest);

        logger.info("check the response: " + response.getUserAccountsList().size());

        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);

        if (response.getStatusCode() == ResponseStatusType.SUCCESS) {
            logger.info(userCustomerEditProfileRequest.getUserPk() + " edit profile successful.");
            return response;
        } else {
            logger.info(userCustomerEditProfileRequest.getUserPk() + " fail to edit profile due to " + response.getDescription());
            throw new Exception(response.getDescription());
        }
    }

    public Response transfer(UserCustomerTransferRequest userCustomerTransferRequest) throws Exception {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(SERVER_HOST, SERVER_PORT)
                .usePlaintext().build();
        UserCustomerGrpc.UserCustomerBlockingStub blockingStub = UserCustomerGrpc.newBlockingStub(channel);

        logger.info(userCustomerTransferRequest.getUserPk() + " is requesting to transfer.");

        Response response = blockingStub.transfer(userCustomerTransferRequest);

        logger.info("check the response: " + response.getUserAccountsList().size());

        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);

        if (response.getStatusCode() == ResponseStatusType.SUCCESS) {
            logger.info(userCustomerTransferRequest.getUserPk() + " transfer successful.");
            return response;
        } else {
            logger.info(userCustomerTransferRequest.getUserPk() + " fail to transfer due to " + response.getDescription());
            throw new Exception(response.getDescription());
        }
    }
}
