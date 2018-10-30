package service.impl;

import dao.IUserAccountDao;
import dao.impl.UserAccountDao;
import dao.impl.UserCardDao;
import entity.UserAccountEntity;
import entity.UserCardEntity;
import rpc.UserAccountsReply;
import rpc.UserCustomerGrpc;
import service.IUserCustomerService;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class UserCustomerService implements IUserCustomerService {
    private static UserCustomerService instance = null;
    private static IUserAccountDao userAccountDao = UserAccountDao.getInstance();
    private static final Logger logger = Logger.getLogger(UserCustomerGrpc.class.getName());

    public static UserCustomerService getInstance() {
        if (instance == null) {
            return new UserCustomerService();
        }
        return instance;
    }

    @Override
    public List<UserAccountsReply> getAccounts(Long id) {
        List<UserAccountsReply> userAccountsReplies = new ArrayList<>();
        logger.info("UserCustomerService: Ready to get user account list");
        List<UserAccountEntity> userAccountList = userAccountDao.getUserAccountByUserId(id);
        logger.info("UserCustomerService: How many result: " + userAccountList.size());


        for(int i = 0; i < userAccountList.size(); i++) {
            UserAccountEntity userAccount = userAccountList.get(i);

            UserCardEntity userCardEntity = UserCardDao.getInstance().getCardByAccountId(
                    userAccount.getId()
            );
            logger.info("UserCustomerService: Card Number is:" + userCardEntity.getCardNumber());
            UserAccountsReply userAccountsReply = UserAccountsReply.newBuilder()
                    .setAccountPk(userAccount.getId())
                    .setAccountNumber(userAccount.getAccountNumber())
                    .setAccountType(userAccount.getAccountType().intValue())
                    .setCurrencyType(userCardEntity.getCurrencyType())
                    .setBalance(userCardEntity.getBalance().intValue())
                    .setStatus(userAccount.getStatus()).build();

            userAccountsReplies.add(userAccountsReply);
        }
        logger.info("UserCustomerService: How many result: " + userAccountsReplies.size());
        return userAccountsReplies;
    }
}
