package controller;

import Const.*;
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
import java.util.ArrayList;
import java.util.List;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class CustomerMainController implements BaseController {
    private CustomerMainView view;
    // reply from server
    private List<UserAccountsReply> accountsReplyList;
    private List<UserPayeesReply> userPayeesReplyList;
    private List<UserTransactionsReply> userTransactionsReplyList;
    private UserProfileReply userProfileReply;
    // model for data binding
    private UserModel userModel;
    private List<UserTransactionModel> userTransactionModelList;
    private UserTransferModel userTransferModel;

    public CustomerMainController(CustomerMainView view, UserModel userModel) {
        userTransferModel = new UserTransferModel();
        this.userModel = userModel;
        this.view = view;
    }


    public UserTransferModel getUserTransferModel() {
        return userTransferModel;
    }

    @Override
    public void initialize() {
        this.view.initComponents();
        initUserModel(this.userModel);
        this.run();
    }

    private void run() {
        this.view.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.view.setVisible(true);
        this.view.pack(); // resize
    }

    private void initUserModel(UserModel userModel) {
        this.userModel = userModel;
    }

    public void updateData() {
        transfer();
        initHomePage();
        initTransactionInfo();
        initTransactionModel();
        initTransactionTable();
        initBalance();
        initCurrency();
        initAmounts();
        initPostscript();
        initTransferPINField();
    }

    private void transfer() {
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
    }

    private void initAccountReply() {
        try {
            this.accountsReplyList = CustomerHomeService.getInstance().getAccounts(this.userModel.getId());
        } catch (Exception E) {
            JOptionPane.showMessageDialog(null,
                    E.getMessage(),
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            E.printStackTrace();
            return;
        }
    }

    private void initAccountModel() {
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
        this.userTransactionModelList = new ArrayList<>();
        for(UserTransactionsReply userTransactionsReply: this.userTransactionsReplyList) {
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

    private void initHomePage() {
        initTitle();
        initAccountReply();
        initAccountModel();
        initAccountTable();
    }

    private void initTitle() {
        String lastLoginTime = this.userModel.getLastLoginTime().toString();
        this.view.lbl_nameField.setText(this.userModel.getFirstName());
        this.view.lbl_lastLoginTime.setText(lastLoginTime.substring(0, lastLoginTime.indexOf(".")));
    }

    private void initProfilePage() {
        initProfileInfo();
        updateUserModel();
        initProfileFields(this.userModel);
    }

    private void updateUserModel() {
        this.userModel.setFirstName(userProfileReply.getFirstName());
        this.userModel.setLastName(userProfileReply.getLastName());
        this.userModel.setGender(userProfileReply.getGender());
        this.userModel.setAddress(userProfileReply.getAddress());
        this.userModel.setEmail(userProfileReply.getEmail());
        this.userModel.setContactNum(userProfileReply.getPhone());
    }

    private void initPayeePage() {
        initPayeeInfo();
        initPayeeModel();
        initPayeeTable();
    }

    private void initTransactionPage() {
        initAccountComboBox(this.view.cb_transaction_accountList);
        initTransactionInfo();
        initTransactionModel();
        initTransactionTable();
    }

    private void initTransferPage() {
        initPayeeComboBox();
        initAccountComboBox(this.view.cb_transfer_accountList);
        initCurrency();
        initBalance();
        initAmounts();
        initPostscriptTextFieldLimit();
        initTransferPINField();
    }

    private void initAmounts() {
        this.view.tf_transfer_amounts.setText("");
    }

    private void initTransferPINField() {
        this.view.pf_transfer_PIN.setText("");
    }

    private void initTransactionInfo() {
        try {
            this.userTransactionsReplyList = CustomerTransactionService.getInstance().getTransaction(this.userModel.getId(),
                    this.userModel.getUserAccountList().get(this.view.cb_transaction_accountList.getSelectedIndex()).getAccount_pk(),
                    this.view.cb_transaction_filter.getSelectedIndex() + 1);
        } catch (Exception E) {
            JOptionPane.showMessageDialog(null,
                    "Fail to get transaction list due to " + E.getMessage(),
                    "Error Message",JOptionPane.ERROR_MESSAGE);
        }
    }

    private void initTransactionTable() {
        DefaultTableModel transactionListModel = (DefaultTableModel)this.view.table_transaction.getModel();
        clearTable(transactionListModel);
        for(UserTransactionModel userTransactionModel: this.userTransactionModelList) {
            String date = userTransactionModel.getDate().toString();
            transactionListModel.addRow(new Object[]{
                    date.substring(0, date.indexOf(".")),
                    UserOperateType.getType(userTransactionModel.getOperation_type()),
                    userTransactionModel.getDetails(),
                    userTransactionModel.getAmounts(),
                    userTransactionModel.getBalance()
            });
        }
    }

    private void initCurrency() {
        this.view.tf_transfer_currency.setText(CardCurrencyType.getCurrencyType(this.userModel.getUserAccountList().get(this.view.cb_transfer_accountList.getSelectedIndex()).getCurrencyType()));
    }

    private void initBalance() {
        this.view.tf_transfer_balance.setText(String.valueOf(this.userModel.getUserAccountList().get(this.view.cb_transfer_accountList.getSelectedIndex()).getBalance()));
    }

    private void initAccountComboBox(JComboBox accountComboBox) {
        accountComboBox.removeAllItems();
        if(accountsReplyList.size() <= 0) {
            JOptionPane.showMessageDialog(null,
                    "No Account found.",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            return;
        }
        for(UserAccountModel userAccountModel : this.userModel.getUserAccountList()) {
            accountComboBox.addItem(String.valueOf(userAccountModel.getAccountNum()));
        }
        accountComboBox.setSelectedIndex(0);

    }

    private void initPayeeComboBox() {
        this.view.cb_transfer_payeeList.removeAllItems();
        if(this.userModel.getUserPayeeList().size() <= 0) {
            this.view.cb_transfer_payeeList.addItem("No payee found");
            return;
        }
        for(UserPayeeModel userPayeeModel: this.userModel.getUserPayeeList()) {
            this.view.cb_transfer_payeeList.addItem(userPayeeModel.getName());
        }
    }

    private void initAccountTable() {
        DefaultTableModel accountListModel = (DefaultTableModel)this.view.table_home_accountTable.getModel();
        clearTable(accountListModel);
        for(UserAccountModel Account: this.userModel.getUserAccountList()) {
            accountListModel.addRow(new Object[]{
                    Account.getAccountNum(),
                    UserAccountType.getTypeName(Account.getAccountType()),
                    CardCurrencyType.getCurrencyType(Account.getCurrencyType()),
                    Account.getBalance(),
                    UserStatusType.getStatusType(Account.getStatus())});
        }
    }

    private void initPostscriptTextFieldLimit() {
        this.view.tf_transfer_postScript.setDocument(new JTextFieldLimit(200));
    }

    private void initPostscript() {
        this.view.tf_transfer_postScript.setText("");
    }

    private void initProfileInfo() {
        try {
            userProfileReply = CustomerProfileService.getInstance().getUserProfile(this.userModel.getId());

        } catch (Exception E) {
            JOptionPane.showMessageDialog(null,
                    "Fail to acquire user profile, please contact admin",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
        }

    }

    private void initPayeeInfo() {
        // init payee info
        UserPayeeModel userPayeeModel = new UserPayeeModel();
        userPayeeModel.setUserId(this.userModel.getId());
        try {
            userPayeesReplyList = CustomerPayeeService.getInstance().getPayeeList(userPayeeModel);
        } catch (Exception E) {
            JOptionPane.showMessageDialog(null,
                    "Fail to acquire user payee, please contact admin",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
        }
    }

    private void initPayeeTable() {
        // init payee table
        DefaultTableModel payeeTableModel = (DefaultTableModel)this.view.table_payee_payeeList.getModel();
        clearTable(payeeTableModel);
        for(UserPayeeModel userPayeeModel: this.userModel.getUserPayeeList()) {
            payeeTableModel.addRow(new Object[]{
                    userPayeeModel.getIban(),
                    userPayeeModel.getName()
            });
        }
    }

    private void initTransferModel(Double balance, Double amounts, String postScript) {
        UserAccountModel userAccountModel = this.userModel.getUserAccountList().get(this.view.cb_transfer_accountList.getSelectedIndex());
        UserPayeeModel userPayeeModel = this.userModel.getUserPayeeList().get(this.view.cb_transfer_payeeList.getSelectedIndex());
        userAccountModel.setBalance(balance);
        userTransferModel.setTransferModel(userPayeeModel, userAccountModel, userAccountModel.getCurrencyType(), amounts, postScript);
        /*
        userTransferModel.setPayee(userPayeeModel);
        userTransferModel.setAccount(userAccountModel);
        userTransferModel.setCurrencyType(userAccountModel.getCurrencyType());
        userTransferModel.setPostScript(postScript);
        userTransferModel.setAmounts(amounts);
        */
    }

    private void clearTable(DefaultTableModel tableModel) {
        int rowCount = tableModel.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            tableModel.removeRow(i);
        }
    }

    private void initProfileFields(UserModel userModel) {
        this.view.tf_profile_userId.setText(String.valueOf(userModel.getUserId()));
        this.view.tf_profile_firstName.setText(userModel.getFirstName());
        this.view.tf_profile_lastName.setText(userModel.getLastName());
        this.view.tf_profile_address.setText(userModel.getAddress());
        this.view.tf_profile_contactNumber.setText(userModel.getContactNum());
        this.view.tf_profile_email.setText(userModel.getEmail());
        this.view.tf_profile_gender.setText(UserGenderType.getGenderType(userModel.getGender()));
    }

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
            initPayeePage();
            initPayeeComboBox();
            initCurrency();
            initBalance();
            initAmounts();
            initPostscriptTextFieldLimit();
            initTransferPINField();
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
    }

    public void cb_transaction_accountListActionPerformed(ActionEvent e) {
        initTransactionInfo();
        initTransactionModel();
        initTransactionTable();
    }

    public void cb_transaction_filterActionPerformed(ActionEvent e) {
        initTransactionInfo();
        initTransactionModel();
        initTransactionTable();
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
        initProfileFields(this.userModel);
    }

    public void cb_transfer_accountListActionPerformed(ActionEvent e) {
        System.out.println("selected INdex" + this.view.cb_transfer_accountList.getSelectedIndex());
        initCurrency();
        initBalance();
    }

    public void thisComponentShown(ComponentEvent e) {
        initHomePage();
        initProfilePage();
        initTransactionPage();
        initPayeePage();
        initTransferPage();
    }
}
