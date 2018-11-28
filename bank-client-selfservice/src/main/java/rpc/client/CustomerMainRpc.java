package rpc.client;

import Const.ResponseStatusType;
import app.MainApp;
import rpc.*;

import javax.net.ssl.SSLException;
import java.util.List;
import java.util.logging.Logger;

public class CustomerMainRpc {
    private static final Logger logger = Logger.getLogger(CustomerMainRpc.class.getName());
    private static UserCustomerGrpc.UserCustomerBlockingStub blockingStub;
    private static CustomerMainRpc instance = null;

    public static CustomerMainRpc getInstance() throws SSLException {
        if (instance == null) {
            instance = new CustomerMainRpc();
            blockingStub = UserCustomerGrpc.newBlockingStub(MainApp.getChannel());
        }
        return instance;
    }

    public List<UserAccountsReply> getAccounts(UserCustomerGetAccountsRequest userCustomerGetAccountsRequest) throws Exception {
        logger.info(userCustomerGetAccountsRequest.getUserPk() + " is requesting to get accounts.");

        Response response = blockingStub.getAccounts(userCustomerGetAccountsRequest);

        if (response.getStatusCode() == ResponseStatusType.SUCCESS) {
            logger.info(userCustomerGetAccountsRequest.getUserPk() + " get accounts successful.");
            return response.getUserAccountsList();
        } else {
            logger.info(userCustomerGetAccountsRequest.getUserPk() + " fail to get accounts due to " + response.getDescription());
            throw new Exception(response.getDescription());
        }
    }

    public UserProfileReply getUserProfile(UserCustomerGetProfileRequest userCustomerGetProfileRequest) throws Exception {
        logger.info(userCustomerGetProfileRequest.getUserPk() + " is requesting to get accounts.");

        Response response = blockingStub.getProfile(userCustomerGetProfileRequest);

        if (response.getStatusCode() == ResponseStatusType.SUCCESS) {
            logger.info(userCustomerGetProfileRequest.getUserPk() + " get user profile successful.");
            return response.getUserProfile();
        } else {
            logger.info(userCustomerGetProfileRequest.getUserPk() + " fail to get user profile due to " + response.getDescription());
            throw new Exception(response.getDescription());
        }
    }

    public Response editUserProfile(UserCustomerEditProfileRequest userCustomerEditProfileRequest) throws Exception {
        logger.info(userCustomerEditProfileRequest.getUserPk() + " is requesting to edit profile.");

        Response response = blockingStub.editProfile(userCustomerEditProfileRequest);

        if (response.getStatusCode() == ResponseStatusType.SUCCESS) {
            logger.info(userCustomerEditProfileRequest.getUserPk() + " edit profile successful.");
            return response;
        } else {
            logger.info(userCustomerEditProfileRequest.getUserPk() + " fail to edit profile due to " + response.getDescription());
            throw new Exception(response.getDescription());
        }
    }

    public Response transfer(UserCustomerTransferRequest userCustomerTransferRequest) throws Exception {
        logger.info(userCustomerTransferRequest.getUserPk() + " is requesting to transfer.");

        Response response = blockingStub.transfer(userCustomerTransferRequest);

        if (response.getStatusCode() == ResponseStatusType.SUCCESS) {
            logger.info(userCustomerTransferRequest.getUserPk() + " transfer successful.");
            return response;
        } else {
            logger.info(userCustomerTransferRequest.getUserPk() + " fail to transfer due to " + response.getDescription());
            throw new Exception(response.getDescription());
        }
    }

    public List<UserTransactionsReply> getTransactions(UserCustomerGetTransactionsRequest userCustomerGetTransactionsRequest) throws Exception {
        logger.info(userCustomerGetTransactionsRequest.getUserPk() + " is requesting to get transaction list.");

        Response response = blockingStub.getTransactions(userCustomerGetTransactionsRequest);

        if (response.getStatusCode() == ResponseStatusType.SUCCESS) {
            logger.info(userCustomerGetTransactionsRequest.getUserPk() + " get transaction list successful.");
            return response.getUserTransactionsList();
        } else {
            logger.info(userCustomerGetTransactionsRequest.getUserPk() + " fail to get transaction list due to " + response.getDescription());
            throw new Exception(response.getDescription());
        }
    }
}
