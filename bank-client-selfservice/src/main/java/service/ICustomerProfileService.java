package service;

import rpc.UserProfileReply;

public interface ICustomerProfileService {
    UserProfileReply getUserProfile(Long userId) throws Exception;

    void modifyUserProfile(Long user_pk, String address, String email, String contactNum) throws Exception;
}
