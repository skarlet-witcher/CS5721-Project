package service;

import model.UserModel;
import rpc.UserProfileReply;

public interface ICustomerProfileService {
    UserProfileReply getUserProfile(Long userId) throws Exception;

    void modifyUserProfile(UserModel userModel) throws Exception;
}
