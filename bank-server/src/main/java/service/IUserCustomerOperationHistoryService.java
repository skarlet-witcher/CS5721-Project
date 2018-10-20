package service;

public interface IUserCustomerOperationHistoryService {

    void addNewUserLoginReqHistory(Long userId, Integer status);

    void addNewUserLoginHistory(Long userId, Integer operateSource, Integer status);

    void refreshUserLoginStatus(Long userId);
}
