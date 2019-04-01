package service;

import javax.net.ssl.SSLException;

public interface IATMService {
    double getBalance(long cardNumber, String PIN) throws Exception;
    double withdraw(long cardNumber, double amount) throws Exception;
}
