package service.impl;

import ATM_rpc.ATMLoginRequest;
import ATM_rpc.ATMResponse;
import dao.IUserAccountDao;
import dao.IUserCardDao;
import dao.impl.UserAccountDao;
import dao.impl.UserCardDao;
import entity.UserAccountEntity;
import entity.UserCardEntity;
import service.IATMService;

public class ATMService implements IATMService {
    private static ATMService atmService;
    private IUserCardDao cardDB = UserCardDao.getInstance();
    private IUserAccountDao accountDB = UserAccountDao.getInstance();

    private ATMService() {

    }

    public static IATMService getInstance() {
        if (atmService == null)
            return new ATMService();
        else return atmService;
    }

    @Override
    public ATMResponse getBalance(ATMLoginRequest atmLoginRequest) throws Exception {
        UserCardEntity card = cardDB.getCardByCardNumber(atmLoginRequest.getCardNumber());
        System.out.println(io.grpc.Grpc.TRANSPORT_ATTR_REMOTE_ADDR);
        if (card.getPin().equals(atmLoginRequest.getPIN())) {
            UserAccountEntity account = accountDB.getUserAccountByPK(card.getAccountId());
            if (account != null) {
                ATMResponse atmResponse = ATMResponse.newBuilder().setBalance(account.getBalance()).setStatusCode(200).build();
                return atmResponse;
            }
        }
        throw new Exception("Incorrect Pin");
    }

    @Override
    public ATMResponse withdraw(ATMLoginRequest atmLoginRequest) throws Exception {
        UserCardEntity card = cardDB.getCardByCardNumber(atmLoginRequest.getCardNumber());
        UserAccountEntity account = accountDB.getUserAccountByPK(card.getAccountId());
        if (account != null) {
            double currentBalance = account.getBalance();
            if(currentBalance > atmLoginRequest.getAmount()){

                account.setBalance(currentBalance - atmLoginRequest.getAmount());
                accountDB.updateBalanceByUserAccountEntity(account);
                ATMResponse atmResponse = ATMResponse.newBuilder().setBalance(account.getBalance()).setStatusCode(200).build();
                return atmResponse;
            }
            else throw new Exception("Insufficent amount");
        }
        throw new Exception("Incorrect Pin");
    }
}
