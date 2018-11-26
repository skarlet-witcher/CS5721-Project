package service;

import model.UserModel;
import rpc.UserProfileReply;

public interface ICustomerProfileService {
    /*
        @pre useId != null
        @post @result != null
     */
    UserProfileReply getUserProfile(Long userId) throws Exception;
    /*
        @pre userModel.getId() != null
        @pre userModel.getEmail() != null
        @pre userModel.getAddress() != null
        @pre userModel.getContactNum() != null
     */
    void modifyUserProfile(UserModel userModel) throws Exception;
}
