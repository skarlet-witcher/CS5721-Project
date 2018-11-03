package service;

public interface IUserCustomerHistoryService {

    void addNewUserLoginReqHistory(Long userId, Integer status);

    void addNewUserLoginHistory(Long userId, Integer operateSource, Integer status);

    void refreshUserLoginStatus(Long userId);

    void addNewTransferHistory(Long user_pk, Long account_pk, Long payee_pk, String postScript, Double balance, Double amounts, int currencyType, int operationType, int operateSource, int operateStatus);
}
