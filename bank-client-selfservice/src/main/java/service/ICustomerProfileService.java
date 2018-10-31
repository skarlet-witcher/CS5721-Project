package service;

import rpc.UserProfileReply;

public interface ICustomerProfileService {
    UserProfileReply getUserProfile(Long userId) throws Exception;
}
