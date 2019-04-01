package service;

import ATM_rpc.ATMLoginRequest;
import ATM_rpc.ATMResponse;

public interface IATMService {
    ATMResponse getBalance(ATMLoginRequest atmLoginRequest) throws Exception;
    ATMResponse withdraw(ATMLoginRequest atmLoginRequest) throws Exception;

}
