package service.impl;

import rpc.UserCustomerEditProfileRequest;
import rpc.UserCustomerGetAccountsRequest;
import rpc.UserCustomerGetProfileRequest;
import rpc.UserProfileReply;
import rpc.client.UserCustomerRpc;
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
        UserProfileReply userProfileReply = UserCustomerRpc.getInstance().getUserProfile(
                UserCustomerGetProfileRequest.newBuilder().setUserPk(Id).build()
        );
        return userProfileReply;
    }

    @Override
    public void modifyUserProfile(Long user_pk, String address, String email, String contactNum) throws Exception {
        UserCustomerRpc.getInstance().editUserProfile(
                UserCustomerEditProfileRequest.newBuilder()
                .setUserPk(user_pk)
                .setEmail(email)
                .setAddress(address)
                .setPhone(contactNum).build()
        );
    }
}
