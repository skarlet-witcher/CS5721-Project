package service.impl;

import dao.IUserAccountDao;
import dao.IUserCardDao;
import dao.IUserDao;
import dao.impl.UserAccountDao;
import dao.impl.UserCardDao;
import dao.impl.UserDao;
import entity.UserAccountEntity;
import entity.UserCardEntity;
import entity.UserEntity;
import rpc.UserAccountsReply;
import rpc.UserCustomerGrpc;
import rpc.UserProfileReply;
import service.IUserCustomerService;
import util.FaultFactory;
import util.TimestampConvertHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class UserCustomerService implements IUserCustomerService {
    private static UserCustomerService instance = null;
    private IUserAccountDao userAccountDao = UserAccountDao.getInstance();
    private IUserDao userdao = UserDao.getInstance();
    private static final Logger logger = Logger.getLogger(UserCustomerGrpc.class.getName());

    public static UserCustomerService getInstance() {
        if (instance == null) {
            return new UserCustomerService();
        }
        return instance;
    }

    @Override
    public List<UserAccountsReply> getAccounts(Long id) throws Exception {
        try {
            List<UserAccountsReply> userAccountsReplies = new ArrayList<>();
            logger.info("UserCustomerService: Ready to get user account list");
            List<UserAccountEntity> userAccountList = userAccountDao.getUserAccountByUserId(id);
            logger.info("UserCustomerService: How many result: " + userAccountList.size());

            logger.info("UserCustomerService: ready to set up user accounts reply");
            for (UserAccountEntity userAccount : userAccountList) {


                UserAccountsReply userAccountsReply = UserAccountsReply.newBuilder()
                        .setAccountPk(userAccount.getId())
                        .setAccountNumber(userAccount.getAccountNumber())
                        .setAccountType(userAccount.getAccountType().intValue())
                        .setCurrencyType(userAccount.getCurrencyType())
                        .setBalance(userAccount.getBalance().intValue())
                        .setStatus(userAccount.getStatus()).build();

                userAccountsReplies.add(userAccountsReply);
            }
            logger.info("UserCustomerService: How many result: " + userAccountsReplies.size());
            return userAccountsReplies;
        } catch (Exception E) {
            throw FaultFactory.throwFaultException(E.getMessage());
        }
    }

    @Override
    public UserProfileReply getUserProfile(Long Id) throws Exception {
        try {
            UserEntity userEntity = userdao.selectUserById(Id);
            UserProfileReply userProfileReply =UserProfileReply.newBuilder()
                    .setUserPk(userEntity.getId())
                    .setUserId(userEntity.getUserId())
                    .setFirstName(userEntity.getFirstName())
                    .setLastName(userEntity.getLastName())
                    .setGender(userEntity.getGender())
                    .setBirthDate(TimestampConvertHelper.mysqlToRpc(userEntity.getBirthDate()))
                    .setAddress(userEntity.getAddress())
                    .setEmail(userEntity.getEmail())
                    .setPhone(userEntity.getPhone()).build();
            return userProfileReply;

        } catch (Exception E) {
            throw FaultFactory.throwFaultException(E.getMessage());
        }


    }

    @Override
    public void editUserProfile(Long id, String address, String email, String contactNum) throws Exception {
        try {
            int updateRows = userdao.updateUserProfileById(id, address, email, contactNum);
            if(updateRows <= 0) {
                throw FaultFactory.throwFaultException("fail to update user profile");
            }
        } catch (Exception E) {
            throw FaultFactory.throwFaultException(E.getMessage());
        }
    }
}
