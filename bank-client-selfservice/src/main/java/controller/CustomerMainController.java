package controller;

import Const.*;
import mediator.*;
import model.*;
import rpc.UserAccountsReply;
import rpc.UserPayeesReply;
import rpc.UserProfileReply;
import rpc.UserTransactionsReply;
import service.impl.*;
import util.JTextFieldLimit;
import util.TimestampConvertHelper;
import view.CustomerAddPayeeView;
import view.CustomerLoginView;
import view.CustomerMainView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class CustomerMainController implements BaseController {

    private CustomerMainView view;

    // data binding from server
    private List<UserAccountsReply> accountsReplyList;
    private List<UserPayeesReply> userPayeesReplyList;
    private List<UserTransactionsReply> userTransactionsReplyList;
    private UserProfileReply userProfileReply;

    // data binding for updating GUI
    private UserModel userModel;
    private List<UserTransactionModel> userTransactionModelList = new ArrayList<>();
    private UserTransferModel userTransferModel;

    // mediator fields
    private MainMediator mainMediator;
    private SubPage homePage;
    private SubPage profilePage;
    private SubPage transactionPage;
    private SubPage payeePage;
    private SubPage transferPage;

    public CustomerMainController(CustomerMainView view, UserModel userModel) {
        userTransferModel = new UserTransferModel();
        this.userModel = userModel;
        this.view = view;

        // mediator
        this.mainMediator = new MainMediatorImpl();

        this.homePage = new HomePage(mainMediator, view, userModel);
        this.profilePage = new ProfilePage(this.mainMediator, this.view, userModel);
        this.transactionPage = new TransactionPage(mainMediator, view, this.userTransactionModelList, userModel);
        this.payeePage = new PayeePage(mainMediator, view, userModel);
        this.transferPage = new TransferPage(mainMediator, view, userModel);

        this.mainMediator.addSubPage(homePage);
        this.mainMediator.addSubPage(profilePage);
        this.mainMediator.addSubPage(transactionPage);
        this.mainMediator.addSubPage(payeePage);
        this.mainMediator.addSubPage(transferPage);

    }

    @Override
    public void initialize() {
        this.view.initComponents();
        this.run();
    }

    private void run() {
        this.view.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.view.setVisible(true);
        this.view.pack(); // resize
    }

    // page Initializations
    private void initHomePage() {
        initAccountModel();
        this.mainMediator.initPages(homePage);

    }

    private void initProfilePage() {
        initProfileModel();
        this.mainMediator.initPages(profilePage);
    }

    private void initPayeePage() {
        initPayeeModel();
        this.mainMediator.initPages(payeePage);
    }

    private void initTransactionPage() {
        // initAccountComboBox(this.view.cb_transaction_accountList);
        initTransactionModel();
        this.mainMediator.initPages(transactionPage);
    }

    private void initTransferPage() {
        this.mainMediator.initPages(transferPage);

    }


    // model initializations
    private void initAccountModel() {
        try {
            this.accountsReplyList = CustomerHomeService.getInstance().getAccounts(this.userModel.getId());
        } catch (Exception E) {
            JOptionPane.showMessageDialog(null,
                    E.getMessage(),
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            E.printStackTrace();
            return;
        }

        this.userModel.getUserAccountList().clear();
        for(UserAccountsReply userAccountsReply : this.accountsReplyList) {
            UserAccountModel userAccountModel = new UserAccountModel();
            userAccountModel.setAccount_pk(userAccountsReply.getAccountPk());
            userAccountModel.setAccountNum(userAccountsReply.getAccountNumber());
            userAccountModel.setAccountType(userAccountsReply.getAccountType());
            userAccountModel.setCurrencyType(userAccountsReply.getCurrencyType());
            userAccountModel.setBalance(Double.valueOf(userAccountsReply.getBalance()));
            userAccountModel.setStatus(userAccountsReply.getStatus());

            this.userModel.getUserAccountList().add(userAccountModel);
        }
    }

    private void initUserModel() {
        this.userModel.setFirstName(userProfileReply.getFirstName());
        this.userModel.setLastName(userProfileReply.getLastName());
        this.userModel.setGender(userProfileReply.getGender());
        this.userModel.setBirthDate(TimestampConvertHelper.rpcToMysql(userProfileReply.getBirthDate()));
        this.userModel.setAddress(userProfileReply.getAddress());
        this.userModel.setEmail(userProfileReply.getEmail());
        this.userModel.setContactNum(userProfileReply.getPhone());
    }

    private void initTransactionModel() {
        try {
            this.userTransactionsReplyList = CustomerTransactionService.getInstance().getTransaction(this.userModel.getId(),
                    this.userModel.getUserAccountList().get(0).getAccount_pk(),
                    this.view.cb_transaction_filter.getSelectedIndex() + 1);
        } catch (Exception E) {
            JOptionPane.showMessageDialog(null,
                    "Fail to get transaction list due to " + E.getMessage(),
                    "Error Message",JOptionPane.ERROR_MESSAGE);
        }

        getTransactionModelFromServer(this.userTransactionsReplyList);

    }

    private void updateTransactionModel() {
        try {
            this.userTransactionsReplyList = CustomerTransactionService.getInstance().getTransaction(this.userModel.getId(),
                    this.userModel.getUserAccountList().get(this.view.cb_transaction_accountList.getSelectedIndex()).getAccount_pk(),
                    this.view.cb_transaction_filter.getSelectedIndex() + 1);
        } catch (Exception E) {
            JOptionPane.showMessageDialog(null,
                    "Fail to get transaction list due to " + E.getMessage(),
                    "Error Message",JOptionPane.ERROR_MESSAGE);
        }

        getTransactionModelFromServer(this.userTransactionsReplyList);

    }

    private void getTransactionModelFromServer(List<UserTransactionsReply> userTransactionsReplyList) {
        this.userTransactionModelList.clear();

        for(UserTransactionsReply userTransactionsReply: userTransactionsReplyList) {

            UserTransactionModel userTransactionModel = new UserTransactionModel();
            userTransactionModel.setDate(TimestampConvertHelper.rpcToMysql(userTransactionsReply.getDate()));
            userTransactionModel.setDetails(userTransactionsReply.getDescription());
            userTransactionModel.setAmounts(userTransactionsReply.getAmount());
            userTransactionModel.setBalance(userTransactionsReply.getBalance());
            userTransactionModel.setTransactionNum(userTransactionsReply.getTransactionNo());
            userTransactionModel.setOperation_type(userTransactionsReply.getOperateType());

            this.userTransactionModelList.add(userTransactionModel);
        }
    }

    private void initPayeeModel() {
        // init payee info
        UserPayeeModel userPayeeModelWithUserId = new UserPayeeModel();
        userPayeeModelWithUserId.setUserId(this.userModel.getId());
        try {
            userPayeesReplyList = CustomerPayeeService.getInstance().getPayeeList(userPayeeModelWithUserId);
        } catch (Exception E) {
            JOptionPane.showMessageDialog(null,
                    "Fail to acquire user payee, please contact admin",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
        }

        this.userModel.getUserPayeeList().clear();
        for(UserPayeesReply userPayeesReply: userPayeesReplyList) {
            UserPayeeModel userPayeeModel = new UserPayeeModel();
            userPayeeModel.setPayee_pk(userPayeesReply.getPayeePk());
            userPayeeModel.setIban(userPayeesReply.getIban());
            userPayeeModel.setName(userPayeesReply.getName());
            userPayeeModel.setUserId(userModel.getId());

            this.userModel.getUserPayeeList().add(userPayeeModel);
        }
    }

    private void initProfileModel() {
        try {
            userProfileReply = CustomerProfileService.getInstance().getUserProfile(this.userModel.getId());

        } catch (Exception E) {
            JOptionPane.showMessageDialog(null,
                    "Fail to acquire user profile, please contact admin",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
        }

        this.userModel.setFirstName(userProfileReply.getFirstName());
        this.userModel.setLastName(userProfileReply.getLastName());
        this.userModel.setGender(userProfileReply.getGender());
        this.userModel.setAddress(userProfileReply.getAddress());
        this.userModel.setEmail(userProfileReply.getEmail());
        this.userModel.setContactNum(userProfileReply.getPhone());

    }

    private void initTransferModel(Double balance, Double amounts, String postScript) {
        UserAccountModel userAccountModel = this.userModel.getUserAccountList().get(this.view.cb_transfer_accountList.getSelectedIndex());
        UserPayeeModel userPayeeModel = this.userModel.getUserPayeeList().get(this.view.cb_transfer_payeeList.getSelectedIndex());
        userAccountModel.setBalance(balance);
        userTransferModel.setTransferModel(userPayeeModel, userAccountModel, userAccountModel.getCurrencyType(), amounts, postScript);
    }


    // fields validation
    private Boolean validateAddress() {
        // address validator
        if(this.view.tf_profile_address.getText().trim().length() <= 0) {
            JOptionPane.showMessageDialog(null,
                    "Please input your address",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            this.view.tf_profile_address.grabFocus();
            return false;
        }
        return true;
    }

    private Boolean validateEmail() {
        // email field validator
        if(this.view.tf_profile_email.getText().trim().length() <= 0) {
            JOptionPane.showMessageDialog(null,
                    "Please input your email address",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            this.view.tf_profile_email.grabFocus();
            return false;
        }
        if(!this.view.tf_profile_email.getText().trim().matches("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b")) {
            JOptionPane.showMessageDialog(null,
                    "Please input valid email address",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            this.view.tf_profile_email.grabFocus();
            return false;
        }
        return true;
    }

    private Boolean validateContactNum() {
        // contact number validator
        if(this.view.tf_profile_contactNumber.getText().trim().length() <= 0) {
            JOptionPane.showMessageDialog(null,
                    "Please input your contact number",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            this.view.tf_profile_contactNumber.grabFocus();
            return false;
        }
        if(!this.view.tf_profile_contactNumber.getText().trim().matches("^[0-9]*$")) {
            JOptionPane.showMessageDialog(null,
                    "The contact number must be numeric.",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            this.view.tf_profile_contactNumber.grabFocus();
            return false;
        }
        return true;
    }

    private Boolean validatePayeeTableBeforeRemove() {
        if(this.view.table_payee_payeeList.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null,
                    "Please click a payee on the table to remove",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private Boolean validatePayeeComboBox() {
        if(this.view.cb_transfer_payeeList.getSelectedItem().toString()== "No payee found") {
            JOptionPane.showMessageDialog(null,
                    "No payee in your account. Please add a payee.",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private Boolean validateAmount() {
        if(this.view.tf_transfer_amounts.getText().trim().length() <= 0) {
            JOptionPane.showMessageDialog(null,
                    "The amount should not be blank. Please input amount before transfer",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(!this.view.tf_transfer_amounts.getText().matches("^[0-9]*$")) {
            JOptionPane.showMessageDialog(null,
                    "The amount should be numeric. Please input valid amount before transfer",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(Double.parseDouble(this.view.tf_transfer_amounts.getText().trim()) <= 0) {
            JOptionPane.showMessageDialog(null,
                    "The amount should be more than 0. Please input correct amount before transfer",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(Double.parseDouble(this.view.tf_transfer_balance.getText().trim()) < Double.parseDouble(this.view.tf_transfer_amounts.getText().trim())) {
            JOptionPane.showMessageDialog(null,
                    "The amounts should be less or equal to the balance",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private Boolean validatePostScript() {
        if(this.view.tf_transfer_postScript.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null,
                    "The postscript should not be blank. Please input your postscript.",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private Boolean validatePINBeforeTransfer() {
        if(this.view.pf_transfer_PIN.getPassword().length <= 0) {
            JOptionPane.showMessageDialog(null,
                    "The PIN should not be blank. Please input your PIN.",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private Boolean validateBeforeTransfer() {
        return validatePayeeComboBox() && validateAmount() && validatePostScript() && validatePINBeforeTransfer();
    }


    // GUI Events
    public void btn_profile_modifyActionPerformed(ActionEvent e) {

        if(validateAddress() && validateContactNum() && validateContactNum() && validateEmail()) {
            this.userModel.setAddress(this.view.tf_profile_address.getText().trim());
            this.userModel.setEmail(this.view.tf_profile_email.getText().trim());
            this.userModel.setContactNum(this.view.tf_profile_contactNumber.getText().trim());
            try {
                CustomerProfileService.getInstance().modifyUserProfile(this.userModel);
                JOptionPane.showMessageDialog(null,
                        "Modify User profile complete",
                        "Info Message",JOptionPane.INFORMATION_MESSAGE);
                initUserModel();
                initProfilePage();
            } catch (Exception E) {
                JOptionPane.showMessageDialog(null,
                        "Fail to acquire user profile, please contact admin",
                        "Error Message",JOptionPane.ERROR_MESSAGE);
                initUserModel(); // recover
                return;
            }
        } else {
            return;
        }
    }

    public void btn_payee_removeActionPerformed(ActionEvent e) {
        if(!validatePayeeTableBeforeRemove()) {
            return;
        }

        UserPayeeModel userPayeeModel = this.userModel.getUserPayeeList().get(this.view.table_payee_payeeList.getSelectedRow());

        int selection = JOptionPane.showConfirmDialog(
                new JFrame(),"Are you sure to delete " + userPayeeModel.getName() + " from your payee list?",
                "Deletion Confirmation",
                JOptionPane.YES_NO_OPTION);
        if(selection == JOptionPane.YES_OPTION) {
            try {
                CustomerPayeeService.getInstance().removePayee(userPayeeModel);
                JOptionPane.showMessageDialog(null,
                        "Payee deletion complete",
                        "Info Message",JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception E) {
                JOptionPane.showMessageDialog(null,
                        "Fail to delete payee," + E.getMessage() + " please contact admin",
                        "Error Message",JOptionPane.ERROR_MESSAGE);
                return;
            }
            initPayeeModel();
            this.mainMediator.updatePages(Arrays.asList(payeePage, transferPage));
        }
    }

    public void btn_transfer_transferActionPerformed(ActionEvent e) {
        if(!validateBeforeTransfer())
        {
            return;
        }
        initTransferModel(Double.parseDouble(this.view.tf_transfer_balance.getText().trim()),
                Double.parseDouble(this.view.tf_transfer_amounts.getText().trim()),
                this.view.tf_transfer_postScript.getText());
        if(JOptionPane.showConfirmDialog(
                new JFrame(),"Are you sure to transfer " + userTransferModel.getAmounts() +" "+ CardCurrencyType.getCurrencyType(userTransferModel.getCurrencyType())+ " to " + userTransferModel.getPayee().getName() + " ?",
                "Transfer Confirmation",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            try {
                CustomerTransferService.getInstance().transfer(userTransferModel,
                        Integer.parseInt(new String(this.view.pf_transfer_PIN.getPassword())));
                JOptionPane.showMessageDialog(null,
                        "Transfer Successful",
                        "Info Message",JOptionPane.INFORMATION_MESSAGE);
            } catch( Exception E) {
                JOptionPane.showMessageDialog(null,
                        "Fail to transfer due to " + E.getMessage(),
                        "Error Message",JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        initAccountModel();
        this.mainMediator.updatePages(Arrays.asList(homePage, profilePage, transactionPage, payeePage, transferPage));
    }

    public void cb_transaction_accountListActionPerformed(ActionEvent e) {
        updateTransactionModel();
        this.mainMediator.updatePages(Arrays.asList(transactionPage));
    }

    public void cb_transaction_filterActionPerformed(ActionEvent e) {
        updateTransactionModel();
        this.mainMediator.updatePages(Arrays.asList(transactionPage));
    }

    public void btn_signoutActionPerformed(ActionEvent e) {
        this.view.dispose();
        new CustomerLoginView();
    }

    public void btn_payee_addActionPerformed(ActionEvent e) {
        this.view.dispose();
        new CustomerAddPayeeView(userModel, this.view);
    }

    public void btn_profile_revertActionPerformed(ActionEvent e) {
        this.mainMediator.updatePages(Arrays.asList(profilePage));
    }

    public void cb_transfer_accountListActionPerformed(ActionEvent e) {
        this.mainMediator.updatePages(Arrays.asList(transferPage));
    }

    public void thisComponentShown(ComponentEvent e) {
        initHomePage();
        initProfilePage();
        initTransactionPage();
        initPayeePage();
        initTransferPage();
    }
}
