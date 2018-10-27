package service;

public interface IUserCustomerHistoryService {

    void addNewUserLoginReqHistory(Long userId, Integer status);

    void addNewUserLoginHistory(Long userId, Integer operateSource, Integer status);

    void refreshUserLoginStatus(Long userId);
}
