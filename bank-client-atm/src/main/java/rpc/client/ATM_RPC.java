package rpc.client;

import ATM_rpc.ATMLoginRequest;
import ATM_rpc.ATMResponse;
import ATM_rpc.ATMWithdrawGrpc;
import Const.ResponseStatusType;
import rpc.Response;
import rpc.UserCustomerLoginGrpc;
import rpc.UserForgetPinRequest;

import javax.net.ssl.SSLException;
import java.util.logging.Logger;

public class ATM_RPC extends ClientRpc {
    private static final Logger logger = Logger.getLogger(ATM_RPC.class.getName());
    private static ATMWithdrawGrpc.ATMWithdrawBlockingStub blockingStub;
    private static ATM_RPC instance = null;

    public static ATM_RPC getInstance() throws SSLException {
        if (instance == null) {
            instance = new ATM_RPC();
            blockingStub = ATMWithdrawGrpc.newBlockingStub(getChannel());
        }
        return instance;
    }

    /**
     * Open a RPC connection to withdraw money
     */
    public ATMResponse withdraw(ATMLoginRequest atmLoginRequest) throws Exception {
        logger.info(atmLoginRequest.getCardNumber() + " is requesting to withdraw.");

        ATMResponse response = blockingStub.aTMWithDraw(atmLoginRequest);

        if (response.getStatusCode() == ResponseStatusType.SUCCESS) {
            logger.info(atmLoginRequest.getCardNumber() + " requesting to withdraw is successful");
            return response;
        } else {
            logger.info(atmLoginRequest.getCardNumber() + " requesting to withdraw is failed" );
            throw new Exception("Unable to proceed");
        }
    }
    public ATMResponse getBalance(ATMLoginRequest atmLoginRequest) throws Exception {
        logger.info(atmLoginRequest.getCardNumber() + " is requesting to get balance.");

        ATMResponse response = blockingStub.aTMGetBalance(atmLoginRequest);

        if (response.getStatusCode() == ResponseStatusType.SUCCESS) {
            logger.info(atmLoginRequest.getCardNumber() + " requesting to get balance is successful");
            return response;
        } else {
            logger.info(atmLoginRequest.getCardNumber() + " requesting to get balance is failed" );
            throw new Exception("Unable to proceed");
        }
    }

}
