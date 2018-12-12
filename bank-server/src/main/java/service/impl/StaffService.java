package service.impl;

import Const.CardStatus;
import Const.SysMailTemplateType;
import Const.UserStatusType;
import bankStaff_rpc.AcceptedRequest;
import bankStaff_rpc.AcceptedResponse;
import bankStaff_rpc.ListUserApplyArchiveEntitiesResponse;
import bankStaff_rpc.StaffLoginResponse;
import dao.IBankStaffDao;
import dao.IUserAccountDao;
import dao.IUserCardDao;
import dao.IUserDao;
import dao.impl.BankStaffDao;
import dao.impl.UserAccountDao;
import dao.impl.UserCardDao;
import dao.impl.UserDao;
import entity.*;
import service.IStaffService;
import service.impl.command_pattern.*;
import util.*;

import java.sql.Timestamp;
import java.text.MessageFormat;

import static Const.CardCurrencyType.EURO;
import static Const.UserAccountType.*;
import static Const.UserType.EXISTING_USER;
import static Const.UserType.NEW_USER;

public class StaffService implements IStaffService {

    public static StaffService instance = null;
    private IBankStaffDao bankStaffDao = BankStaffDao.getInstance();
    private IUserDao userDao = UserDao.getInstance();
    private IUserAccountDao userAccountDao = UserAccountDao.getInstance();
    private IUserCardDao userCardDao = UserCardDao.getInstance();

    public static StaffService getInstance() {
        if (instance == null) {
            instance = new StaffService();
        }
        return instance;
    }

    @Override
    public StaffLoginResponse login(long staffId, String password) throws Exception {
        BankStaffEntity bankStaffEntity = bankStaffDao.selectStaffByIdAndPassword(staffId, password);
        if (bankStaffEntity == null) {
            throw FaultFactory.throwFaultException("The credential you typed is not existed.");
        }
        StaffLoginResponse staffLoginResponse = StaffLoginResponse.newBuilder()
                .setIsValid(true)
                .setStatusCode(200).build();
        return staffLoginResponse;
    }


    @Override
    public ListUserApplyArchiveEntitiesResponse getUserApplyArchiveEntities() {
        ListUserApplyArchiveEntitiesResponse userApplyArchiveEntityList = bankStaffDao.selectUserApplyArchiveEntity();
        return userApplyArchiveEntityList;
    }

    /**
     * This method is for accepting an application request
     * First, it applies the application by changing status of record in DB from PENDING to PASS
     * Second, it will create the records of user, user_account, and user_card in DB
     * Third, an email is sent to user for confirmation
     *
     * @param request An application request from client, which contains Application ID for searching in DB
     * @return
     */
    @Override
    public AcceptedResponse acceptApplication(AcceptedRequest request) {
        //Accept: create user, user account, user card
        //send email after accepted
        //state design pattern

        //Apply an application request
        UserApplyArchiveEntity userApplyArchiveEntity = bankStaffDao.selectOneApplication(request.getApplicationId());
        AcceptedResponse response = null;
        if (userApplyArchiveEntity.getNewUserApply() == EXISTING_USER) {
            response = applyForExistingUser(request, userApplyArchiveEntity);
        }
        if (userApplyArchiveEntity.getNewUserApply() == NEW_USER) {
            response = applyForNewUser(request, userApplyArchiveEntity);
        }

        return response;

    }

    public AcceptedResponse applyForExistingUser(AcceptedRequest request, UserApplyArchiveEntity userApplyArchiveEntity) {
        UserEntity userEntity = userDao.selectUserByUserId(userApplyArchiveEntity.getUserId());
        bankStaffDao.applyAnApplication(request.getApplicationId());

        //Create an user_account and save it to DB
        UserAccountEntity userAccountEntity = createUserAccount(userEntity, userApplyArchiveEntity);

        //Create an user card
        UserCardEntity userCardEntity = createUserCard(userAccountEntity, userApplyArchiveEntity);

        //Return accepted response
        AcceptedResponse response = AcceptedResponse.newBuilder().setIsAccepted(true).setStatusCode(200).build();

        // send email
        UserApplyArchiveEntity apply = bankStaffDao.selectOneApplication(request.getApplicationId());
        String mailTemplate = SysEmailService.getInstance().getMailTemplate(SysMailTemplateType.NEW_ACCOUNT);
        String formatEmail = MessageFormat.format(mailTemplate, apply.getFirstName() + " " + apply.getLastName());
        SysEmailService.getInstance().send(apply.getEmail(), "Nuclear Bank - Your apply has been accepted!", formatEmail);

        return response;
    }

    public AcceptedResponse applyForNewUser(AcceptedRequest request, UserApplyArchiveEntity userApplyArchiveEntity) {
        //1. Create  new UserEntity and save it to DB
        UserEntity userEntity = new UserEntity();
        userEntity.setAddress(userApplyArchiveEntity.getAddress());
        userEntity.setBirthDate(userApplyArchiveEntity.getBirthDate());
        userEntity.setEmail(userApplyArchiveEntity.getEmail());
        userEntity.setFirstName(userApplyArchiveEntity.getFirstName());
        userEntity.setLastName(userApplyArchiveEntity.getLastName());
        userEntity.setGender(userApplyArchiveEntity.getGender());
//        userEntity.setLoginPinDigit(String.valueOf(PINFieldSetter.getInstance().setPINField()));
        String pin = String.valueOf(PINGenerator.getInstance().generatePIN());
        userEntity.setPin(pin);
        userEntity.setPhone(userApplyArchiveEntity.getPhone());
        userEntity.setStatus(UserStatusType.NORMAL);
        long id = AccountNumberGenerator.getInstance().generateAccountNumber();
        userEntity.setUserId(id);
        userDao.createUser(userEntity);
        bankStaffDao.applyAnApplication(request.getApplicationId());

        //2. Create an user_account and save it to DB
        UserAccountEntity userAccountEntity = createUserAccount(userEntity, userApplyArchiveEntity);

        //3. Create an user card
        UserCardEntity userCardEntity = createUserCard(userAccountEntity, userApplyArchiveEntity);

        //4. Return acceptedResponse
        AcceptedResponse response = AcceptedResponse.newBuilder().setIsAccepted(true).setStatusCode(200).build();

        // send email
        UserApplyArchiveEntity apply = bankStaffDao.selectOneApplication(request.getApplicationId());
        String mailTemplate = SysEmailService.getInstance().getMailTemplate(SysMailTemplateType.NEW_USER);
        String formatEmail = MessageFormat.format(mailTemplate,
                apply.getFirstName() + " " + apply.getLastName(),
                String.valueOf(id), pin, userAccountEntity.getAccountNumber().toString(), userCardEntity.getCardNumber().toString());
        SysEmailService.getInstance().send(apply.getEmail(), "Nuclear Bank - Your apply has been accepted!", formatEmail);

        return response;
    }

    public UserCardEntity createUserCard(UserAccountEntity userAccountEntity, UserApplyArchiveEntity userApplyArchiveEntity) {
        UserCardEntity userCardEntity = new UserCardEntity();
        userCardEntity.setCardNumber(CardNumberGenerator.getInstance().getCardNumber());
        userCardEntity.setAccountId(userAccountEntity.getId());
        userCardEntity.setCardType(userApplyArchiveEntity.getCardType());
        userCardEntity.setExpiredDate(userAccountEntity.getExpiredDate());
        userCardEntity.setPin(String.valueOf(PINGenerator.getInstance().generatePIN()));
        userCardEntity.setStatus(CardStatus.AVAILABLE);
        userCardDao.createUserCard(userCardEntity);
        return userCardEntity;
    }

    public UserAccountEntity createUserAccount(UserEntity userEntity, UserApplyArchiveEntity userApplyArchiveEntity) {
        UserAccountEntity userAccountEntity = new UserAccountEntity();
        userAccountEntity.setAccountNumber(AccountNumberGenerator.getInstance().generateAccountNumber());
        userAccountEntity.setAccountType(Long.valueOf(userApplyArchiveEntity.getAccountType()));
        userAccountEntity.setBalance(0.0);
        userAccountEntity.setAccountNumber(AccountNumberGenerator.getInstance().generateAccountNumber());
        userAccountEntity.setBic("BOFIIE2D");
        userAccountEntity.setIban(IBANGenerator.getInstance().generateIBAN(AccountNumberGenerator.getInstance().generateAccountNumber()));
        userAccountEntity.setStatus(UserStatusType.NORMAL);
        userAccountEntity.setUserId(userEntity.getId());
        userAccountEntity.setCurrencyType(EURO);
        //Goal of command pattern: to calculate the expiry date for every account type
        Timestamp expireDate = null;
        Invoker invoker = new Invoker();
        Receiver receiver = new Receiver(userApplyArchiveEntity);
        if (userApplyArchiveEntity.getAccountType() == STUDENT_ACCOUNT) {
            //the expiry date is calculated by the Receiver
            //Inovker is just the one who wants something to be done not by himself
            expireDate = invoker.executeCommand(new StudentAccCalculateExpiry(receiver));
        }
        if (userApplyArchiveEntity.getAccountType() == YOUNG_SAVER_ACCOUNT) {
            expireDate = invoker.executeCommand(new YoungSaverAccCalculateExpiry(receiver));
        }

        if (userApplyArchiveEntity.getAccountType() == PERSONAL_ACCOUNT) {
            expireDate = invoker.executeCommand(new PersonalAccCalculateExpiry(receiver));
        }
        if (userApplyArchiveEntity.getAccountType() == GOLDEN_ACCOUNT) {
            expireDate = invoker.executeCommand(new GoldenAccCalculateExpiry(receiver));
        }
        userAccountEntity.setExpiredDate(expireDate);

        userAccountDao.createUserAccount(userAccountEntity);
        return userAccountEntity;
    }
}



