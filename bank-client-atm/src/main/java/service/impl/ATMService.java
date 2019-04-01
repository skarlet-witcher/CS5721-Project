package service.impl;

import ATM_rpc.ATMLoginRequest;
import ATM_rpc.ATMResponse;
import rpc.client.ATM_RPC;
import service.IATMService;

import javax.net.ssl.SSLException;

public class ATMService implements IATMService {
    private static IATMService instance = null;

    private ATMService() {
    }

    public static IATMService getInstance() {
        if (instance == null) {
            instance = new ATMService();
        }
        return instance;
    }
    @Override
    public double getBalance(long cardNumber, String PIN) throws Exception {
        ATMLoginRequest atmLoginRequest = ATMLoginRequest.newBuilder().setCardNumber(cardNumber).setPIN(PIN).build();
        ATMResponse atmResponse = ATM_RPC.getInstance().getBalance(atmLoginRequest);
        return atmResponse.getBalance();
    }

    @Override
    public double withdraw(long cardNumber, double amount) throws Exception {
        ATMLoginRequest atmLoginRequest = ATMLoginRequest.newBuilder().setCardNumber(cardNumber).setAmount(amount).build();
        ATMResponse atmResponse = ATM_RPC.getInstance().withdraw(atmLoginRequest);
        return atmResponse.getBalance();
    }

}
