package service.impl;

import model.UserModel;
import rpc.UserCustomerEditProfileRequest;
import rpc.UserCustomerGetProfileRequest;
import rpc.UserProfileReply;
import rpc.client.CustomerMainRpc;
import service.ICustomerProfileService;

public class CustomerProfileService implements ICustomerProfileService {
    private static ICustomerProfileService customerProfileService = null;

    public static ICustomerProfileService getInstance() {
        if(customerProfileService == null) {
            customerProfileService = new CustomerProfileService();
        }
        return customerProfileService;
    }

    @Override
    public UserProfileReply getUserProfile(Long Id) throws Exception {
        UserProfileReply userProfileReply = CustomerMainRpc.getInstance().getUserProfile(
                UserCustomerGetProfileRequest.newBuilder().setUserPk(Id).build()
        );
        return userProfileReply;
    }

    @Override
    public void modifyUserProfile(UserModel userModel) throws Exception {
        CustomerMainRpc.getInstance().editUserProfile(
                UserCustomerEditProfileRequest.newBuilder()
                .setUserPk(userModel.getId())
                .setEmail(userModel.getEmail())
                .setAddress(userModel.getAddress())
                .setPhone(userModel.getContactNum()).build()
        );
    }
}
