/*
 * Created by JFormDesigner on Sun Oct 14 14:56:29 BST 2018
 */

package view;

import java.awt.event.*;

import Const.*;
import model.*;
import net.miginfocom.swing.MigLayout;
import rpc.UserAccountsReply;
import rpc.UserPayeesReply;
import rpc.UserProfileReply;
import rpc.UserTransactionsReply;
import service.impl.*;
import util.JTextFieldLimit;
import util.RandomUtil;
import util.TimestampConvertHelper;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Xiangkai Tang
 */
public class CustomerMainView extends JFrame implements Observer {

    // reply from server
    private List<UserAccountsReply> accountsReplyList;
    private List<UserPayeesReply> userPayeesReplyList;
    private List<UserTransactionsReply> userTransactionsReplyList;
    private UserProfileReply userProfileReply;

    // model for data binding
    private UserModel userModel;
    private List<UserTransactionModel> userTransactionModelList;
    private UserTransferModel userTransferModel = new UserTransferModel();

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel lbl_welcome;
    private JLabel lbl_nameField;
    private JLabel lbl_lastLogin;
    private JLabel lbl_lastLoginTime;
    private JTabbedPane customerTabPane;
    private JPanel homePanel;
    private JScrollPane scrollPane1;
    private JTable table_home_accountTable;
    private JPanel profilePanel;
    private JLabel lbl_profile_userId;
    private JTextField tf_profile_userId;
    private JLabel lbl_profile_firstName;
    private JTextField tf_profile_firstName;
    private JLabel lbl_profile_lastName;
    private JTextField tf_profile_lastName;
    private JLabel lbl_gender;
    private JTextField tf_profile_gender;
    private JLabel lbl_address;
    private JTextField tf_profile_address;
    private JLabel lbl_email;
    private JTextField tf_profile_email;
    private JLabel lbl_contactNum;
    private JTextField tf_profile_contactNumber;
    private JButton btn_profile_modify;
    private JButton btn_profile_revert;
    private JPanel transactionPanel;
    private JComboBox cb_transaction_accountList;
    private JComboBox<String> cb_transaction_filter;
    private JScrollPane scrollPane2;
    private JTable table_transaction;
    private JButton btn_printStatement;
    private JPanel payeePanel;
    private JButton btn_payee_add;
    private JButton btn_payee_remove;
    private JScrollPane scrollPane3;
    private JTable table_payee_payeeList;
    private JPanel transferPanel;
    private JLabel label7;
    private JComboBox cb_transfer_payeeList;
    private JLabel label8;
    private JComboBox cb_transfer_accountList;
    private JLabel label11;
    private JTextField tf_transfer_currency;
    private JLabel label10;
    private JTextField tf_transfer_balance;
    private JLabel label9;
    private JTextField tf_transfer_amounts;
    private JLabel lbl_postScript;
    private JTextField tf_transfer_postScript;
    private JLabel lbl_transfer_PIN;
    private JPasswordField pf_transfer_PIN;
    private JButton btn_transfer_transfer;
    private JButton btn_signout;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


    public CustomerMainView(long userId, Long user_pk, String firstName, String lastLoginTime) {
        initComponents();
        initUserModel(userId, user_pk, firstName, lastLoginTime);
        initHomePage();
        initProfilePage();
        initTransactionPage();
        initPayeePage();
        initTransferPage();
        registerObserver();

    }

    private void registerObserver() {
        this.userTransferModel.registerObserver(this);
    }

    @Override
    public void updateTransferPage(UserTransferModel userTransferModel) {
        try {
            CustomerTransferService.getInstance().transfer(userTransferModel,
                    Integer.parseInt(new String(pf_transfer_PIN.getPassword())));
            JOptionPane.showMessageDialog(null,
                    "Transfer Successful",
                    "Info Message",JOptionPane.INFORMATION_MESSAGE);
        } catch( Exception E) {
            JOptionPane.showMessageDialog(null,
                    "Fail to transfer due to " + E.getMessage(),
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            return;
        }
        initHomePage();
        initProfilePage();
        initTransactionPage();
        initPayeePage();
        initTransferPage();
    }

    private void initUserModel(long userId, long user_pk, String firstName, String lastLoginTime) {
        this.userModel = new UserModel();
        this.userModel.setUserId(userId);
        this.userModel.setId(user_pk);
        this.userModel.setFirstName(firstName);
        this.userModel.setLastLoginTime(Timestamp.valueOf(lastLoginTime));
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
        this.lbl_nameField.setText(this.userModel.getFirstName());
        this.lbl_lastLoginTime.setText(lastLoginTime.substring(0, lastLoginTime.indexOf(".")));
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
        initAccountComboBox(cb_transaction_accountList);
        initTransactionInfo();
        initTransactionModel();
        initTransactionTable();
    }

    private void initTransferPage() {
        initPayeeComboBox();
        initAccountComboBox(cb_transfer_accountList);
        initCurrency();
        initBalance();
        initPostscriptTextFieldLimit();
    }

    private void initTransactionInfo() {
        try {
            this.userTransactionsReplyList = CustomerTransactionService.getInstance().getTransaction(this.userModel.getId(),
                    this.userModel.getUserAccountList().get(0).getAccount_pk(),
                    cb_transaction_filter.getSelectedIndex() + 1);
        } catch (Exception E) {
            JOptionPane.showMessageDialog(null,
                    "Fail to get transaction list due to " + E.getMessage(),
                    "Error Message",JOptionPane.ERROR_MESSAGE);
        }
    }

    private void initTransactionTable() {
        DefaultTableModel transactionListModel = (DefaultTableModel)table_transaction.getModel();
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
        tf_transfer_currency.setText(CardCurrencyType.getCurrencyType(this.userModel.getUserAccountList().get(0).getCurrencyType()));
    }

    private void initBalance() {
        System.out.println("your balance = " + this.userModel.getUserAccountList().get(0).getBalance());
        tf_transfer_balance.setText(String.valueOf(this.userModel.getUserAccountList().get(0).getBalance()));
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
    }

    private void initPayeeComboBox() {
        cb_transfer_payeeList.removeAllItems();
        if(this.userModel.getUserPayeeList().size() <= 0) {
            cb_transfer_payeeList.addItem("No payee found");
            return;
        }
        for(UserPayeeModel userPayeeModel: this.userModel.getUserPayeeList()) {
            cb_transfer_payeeList.addItem(userPayeeModel.getName());
        }
    }

    private void initAccountTable() {
        DefaultTableModel accountListModel = (DefaultTableModel)table_home_accountTable.getModel();
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
        tf_transfer_postScript.setDocument(new JTextFieldLimit(200));
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
        DefaultTableModel payeeTableModel = (DefaultTableModel)table_payee_payeeList.getModel();
        clearTable(payeeTableModel);
        for(UserPayeeModel userPayeeModel: this.userModel.getUserPayeeList()) {
            payeeTableModel.addRow(new Object[]{
                    userPayeeModel.getIban(),
                    userPayeeModel.getName()
            });
        }
    }

    private void initTransferModel(Double balance, Double amounts, String postScript) {
        UserAccountModel userAccountModel = this.userModel.getUserAccountList().get(cb_transfer_accountList.getSelectedIndex());
        UserPayeeModel userPayeeModel = this.userModel.getUserPayeeList().get(cb_transfer_payeeList.getSelectedIndex());
        userAccountModel.setBalance(balance);
        userTransferModel.setPayee(userPayeeModel);
        userTransferModel.setAccount(userAccountModel);
        userTransferModel.setCurrencyType(userAccountModel.getCurrencyType());
        userTransferModel.setPostScript(postScript);
        userTransferModel.setAmounts(amounts);
    }

    private void clearTable(DefaultTableModel payeeTableModel) {
        int rowCount = payeeTableModel.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            payeeTableModel.removeRow(i);
        }
    }

    private void initProfileFields(UserModel userModel) {
        tf_profile_userId.setText(String.valueOf(userModel.getUserId()));
        tf_profile_firstName.setText(userModel.getFirstName());
        tf_profile_lastName.setText(userModel.getLastName());
        tf_profile_address.setText(userModel.getAddress());
        tf_profile_contactNumber.setText(userModel.getContactNum());
        tf_profile_email.setText(userModel.getEmail());
        tf_profile_gender.setText(UserGenderType.getGenderType(userModel.getGender()));
    }

    private void btn_signoutActionPerformed(ActionEvent e) {
        this.dispose();
        new CustomerLoginView().run();
    }

    private void btn_payee_addActionPerformed(ActionEvent e) {
        this.setVisible(false);
        new CustomerAddPayeeView(this.userModel.getId(), this).run();
    }

    private void btn_profile_revertActionPerformed(ActionEvent e) {
        initProfileFields(this.userModel);
    }

    private Boolean validateAddress() {
        // address validator
        if(tf_profile_address.getText().trim().length() <= 0) {
            JOptionPane.showMessageDialog(null,
                    "Please input your address",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            tf_profile_address.grabFocus();
            return false;
        }
        return true;
    }


    private Boolean validateEmail() {
        // email field validator
        if(tf_profile_email.getText().trim().length() <= 0) {
            JOptionPane.showMessageDialog(null,
                    "Please input your email address",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            tf_profile_email.grabFocus();
            return false;
        }
        if(!tf_profile_email.getText().trim().matches("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b")) {
            JOptionPane.showMessageDialog(null,
                    "Please input valid email address",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            tf_profile_email.grabFocus();
            return false;
        }
        return true;
    }

    private Boolean validateContactNum() {
        // contact number validator
        if(tf_profile_contactNumber.getText().trim().length() <= 0) {
            JOptionPane.showMessageDialog(null,
                    "Please input your contact number",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            tf_profile_contactNumber.grabFocus();
            return false;
        }
        if(!tf_profile_contactNumber.getText().trim().matches("^[0-9]*$")) {
            JOptionPane.showMessageDialog(null,
                    "The contact number must be numeric.",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            tf_profile_contactNumber.grabFocus();
            return false;
        }
        return true;
    }

    private void btn_profile_modifyActionPerformed(ActionEvent e) {

        if(validateAddress() && validateContactNum() && validateContactNum()) {
            this.userModel.setAddress(tf_profile_address.getText().trim());
            this.userModel.setEmail(tf_profile_email.getText().trim());
            this.userModel.setContactNum(tf_profile_contactNumber.getText().trim());
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

    private Boolean validatePayeeTableBeforeRemove() {
        if(table_payee_payeeList.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null,
                    "Please click a payee on the table to remove",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private void btn_payee_removeActionPerformed(ActionEvent e) {
        if(!validatePayeeTableBeforeRemove()) {
            return;
        }

        UserPayeeModel userPayeeModel = this.userModel.getUserPayeeList().get(table_payee_payeeList.getSelectedRow());

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
        }
    }

    private void cb_transfer_accountListActionPerformed(ActionEvent e) {
        initCurrency();
        initBalance();
    }

    private Boolean transferValidator(Double balance, Double amounts) {
        if(balance <= 0) {
            JOptionPane.showMessageDialog(null,
                    "Not enough balance to be transferred.",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(amounts > balance) {
            JOptionPane.showMessageDialog(null,
                    "The amounts should be less or equal to the balance",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private void btn_transfer_transferActionPerformed(ActionEvent e) {
        if(!transferValidator(Double.parseDouble(tf_transfer_balance.getText().trim()),
                Double.parseDouble(tf_transfer_amounts.getText().trim())))
        {
            return;
        }
        initTransferModel(Double.parseDouble(tf_transfer_balance.getText().trim()),
                Double.parseDouble(tf_transfer_amounts.getText().trim()),
                tf_transfer_postScript.getText());
    }

    private void cb_transaction_accountListActionPerformed(ActionEvent e) {
        initTransactionInfo();
    }

    private void cb_transaction_filterActionPerformed(ActionEvent e) {
        initTransactionInfo();
    }

    private void thisComponentShown(ComponentEvent e) {
        initAccountTable();
        initPayeePage();
    }

    public void run() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        lbl_welcome = new JLabel();
        lbl_nameField = new JLabel();
        lbl_lastLogin = new JLabel();
        lbl_lastLoginTime = new JLabel();
        customerTabPane = new JTabbedPane();
        homePanel = new JPanel();
        scrollPane1 = new JScrollPane();
        table_home_accountTable = new JTable();
        profilePanel = new JPanel();
        lbl_profile_userId = new JLabel();
        tf_profile_userId = new JTextField();
        lbl_profile_firstName = new JLabel();
        tf_profile_firstName = new JTextField();
        lbl_profile_lastName = new JLabel();
        tf_profile_lastName = new JTextField();
        lbl_gender = new JLabel();
        tf_profile_gender = new JTextField();
        lbl_address = new JLabel();
        tf_profile_address = new JTextField();
        lbl_email = new JLabel();
        tf_profile_email = new JTextField();
        lbl_contactNum = new JLabel();
        tf_profile_contactNumber = new JTextField();
        btn_profile_modify = new JButton();
        btn_profile_revert = new JButton();
        transactionPanel = new JPanel();
        cb_transaction_accountList = new JComboBox();
        cb_transaction_filter = new JComboBox<>();
        scrollPane2 = new JScrollPane();
        table_transaction = new JTable();
        btn_printStatement = new JButton();
        payeePanel = new JPanel();
        btn_payee_add = new JButton();
        btn_payee_remove = new JButton();
        scrollPane3 = new JScrollPane();
        table_payee_payeeList = new JTable();
        transferPanel = new JPanel();
        label7 = new JLabel();
        cb_transfer_payeeList = new JComboBox();
        label8 = new JLabel();
        cb_transfer_accountList = new JComboBox();
        label11 = new JLabel();
        tf_transfer_currency = new JTextField();
        label10 = new JLabel();
        tf_transfer_balance = new JTextField();
        label9 = new JLabel();
        tf_transfer_amounts = new JTextField();
        lbl_postScript = new JLabel();
        tf_transfer_postScript = new JTextField();
        lbl_transfer_PIN = new JLabel();
        pf_transfer_PIN = new JPasswordField();
        btn_transfer_transfer = new JButton();
        btn_signout = new JButton();

        //======== this ========
        setTitle("Customer Main View");
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                thisComponentShown(e);
            }
        });
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[fill]0" +
            "[fill]0" +
            "[200:n,center]0" +
            "[fill]0" +
            "[fill]0" +
            "[fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]0" +
            "[30:n]"));

        //---- lbl_welcome ----
        lbl_welcome.setText("Welcome");
        lbl_welcome.setFont(new Font("Segoe UI", Font.PLAIN, 26));
        contentPane.add(lbl_welcome, "cell 2 1");

        //---- lbl_nameField ----
        lbl_nameField.setText("*FirstName*");
        lbl_nameField.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        contentPane.add(lbl_nameField, "cell 2 1");

        //---- lbl_lastLogin ----
        lbl_lastLogin.setText("Last login: ");
        lbl_lastLogin.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        contentPane.add(lbl_lastLogin, "cell 2 2");

        //---- lbl_lastLoginTime ----
        lbl_lastLoginTime.setText("****");
        lbl_lastLoginTime.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        contentPane.add(lbl_lastLoginTime, "cell 2 2");

        //======== customerTabPane ========
        {
            customerTabPane.setFont(new Font("Segoe UI", Font.PLAIN, 20));
            customerTabPane.setPreferredSize(new Dimension(527, 400));

            //======== homePanel ========
            {
                homePanel.setLayout(new MigLayout(
                    "hidemode 3",
                    // columns
                    "[fill]" +
                    "[fill]" +
                    "[fill]",
                    // rows
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]"));

                //======== scrollPane1 ========
                {

                    //---- table_home_accountTable ----
                    table_home_accountTable.setModel(new DefaultTableModel(
                        new Object[][] {
                        },
                        new String[] {
                            "AccountNumber", "AccountType", "CurrencyType", "Balance", "Status"
                        }
                    ));
                    table_home_accountTable.setMinimumSize(new Dimension(75, 100));
                    table_home_accountTable.setMaximumSize(new Dimension(2147483647, 2147483647));
                    table_home_accountTable.setFont(new Font("Segoe UI", Font.PLAIN, 12));
                    scrollPane1.setViewportView(table_home_accountTable);
                }
                homePanel.add(scrollPane1, "cell 1 1");
            }
            customerTabPane.addTab("Home", homePanel);

            //======== profilePanel ========
            {
                profilePanel.setLayout(new MigLayout(
                    "hidemode 3",
                    // columns
                    "[56:n,fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[110:n,fill]",
                    // rows
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]"));

                //---- lbl_profile_userId ----
                lbl_profile_userId.setText("User Id");
                lbl_profile_userId.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                profilePanel.add(lbl_profile_userId, "cell 2 0");

                //---- tf_profile_userId ----
                tf_profile_userId.setEnabled(false);
                profilePanel.add(tf_profile_userId, "cell 3 0");

                //---- lbl_profile_firstName ----
                lbl_profile_firstName.setText("FirstName");
                lbl_profile_firstName.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                profilePanel.add(lbl_profile_firstName, "cell 2 1");

                //---- tf_profile_firstName ----
                tf_profile_firstName.setEnabled(false);
                profilePanel.add(tf_profile_firstName, "cell 3 1");

                //---- lbl_profile_lastName ----
                lbl_profile_lastName.setText("LastName");
                lbl_profile_lastName.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                profilePanel.add(lbl_profile_lastName, "cell 2 2");

                //---- tf_profile_lastName ----
                tf_profile_lastName.setEnabled(false);
                profilePanel.add(tf_profile_lastName, "cell 3 2");

                //---- lbl_gender ----
                lbl_gender.setText("Gender");
                lbl_gender.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                profilePanel.add(lbl_gender, "cell 2 3");

                //---- tf_profile_gender ----
                tf_profile_gender.setEnabled(false);
                profilePanel.add(tf_profile_gender, "cell 3 3");

                //---- lbl_address ----
                lbl_address.setText("Address");
                lbl_address.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                profilePanel.add(lbl_address, "cell 2 4");
                profilePanel.add(tf_profile_address, "cell 3 4");

                //---- lbl_email ----
                lbl_email.setText("Email");
                lbl_email.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                profilePanel.add(lbl_email, "cell 2 5");
                profilePanel.add(tf_profile_email, "cell 3 5");

                //---- lbl_contactNum ----
                lbl_contactNum.setText("Contact Number");
                lbl_contactNum.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                profilePanel.add(lbl_contactNum, "cell 2 6");
                profilePanel.add(tf_profile_contactNumber, "cell 3 6");

                //---- btn_profile_modify ----
                btn_profile_modify.setText("Modify");
                btn_profile_modify.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                btn_profile_modify.addActionListener(e -> btn_profile_modifyActionPerformed(e));
                profilePanel.add(btn_profile_modify, "cell 2 8");

                //---- btn_profile_revert ----
                btn_profile_revert.setText("Revert");
                btn_profile_revert.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                btn_profile_revert.addActionListener(e -> btn_profile_revertActionPerformed(e));
                profilePanel.add(btn_profile_revert, "cell 3 8");
            }
            customerTabPane.addTab("Profile", profilePanel);

            //======== transactionPanel ========
            {
                transactionPanel.setLayout(new MigLayout(
                    "hidemode 3",
                    // columns
                    "[fill]" +
                    "[fill]",
                    // rows
                    "[]" +
                    "[]0" +
                    "[]0" +
                    "[]0" +
                    "[]0" +
                    "[]0" +
                    "[]0" +
                    "[]0" +
                    "[20:n]0" +
                    "[]" +
                    "[]"));

                //---- cb_transaction_accountList ----
                cb_transaction_accountList.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                cb_transaction_accountList.addActionListener(e -> cb_transaction_accountListActionPerformed(e));
                transactionPanel.add(cb_transaction_accountList, "cell 0 0");

                //---- cb_transaction_filter ----
                cb_transaction_filter.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                cb_transaction_filter.setModel(new DefaultComboBoxModel<>(new String[] {
                    "Recent 7 days",
                    "Recent 1 month",
                    "Recent 6 months",
                    "Recent 1 year"
                }));
                cb_transaction_filter.addActionListener(e -> cb_transaction_filterActionPerformed(e));
                transactionPanel.add(cb_transaction_filter, "cell 0 0");

                //======== scrollPane2 ========
                {

                    //---- table_transaction ----
                    table_transaction.setModel(new DefaultTableModel(
                        new Object[][] {
                            {null, null, null, null, null},
                        },
                        new String[] {
                            "Date", "Operation Type", "Details", "Amount", "Balance"
                        }
                    ));
                    table_transaction.setMinimumSize(new Dimension(75, 200));
                    table_transaction.setMaximumSize(new Dimension(2147483647, 2147483647));
                    table_transaction.setFont(new Font("Segoe UI", Font.PLAIN, 12));
                    scrollPane2.setViewportView(table_transaction);
                }
                transactionPanel.add(scrollPane2, "cell 0 1");

                //---- btn_printStatement ----
                btn_printStatement.setText("Print Statement");
                btn_printStatement.setFont(new Font("Segoe UI", Font.PLAIN, 12));
                transactionPanel.add(btn_printStatement, "cell 0 9");
            }
            customerTabPane.addTab("Transaction", transactionPanel);

            //======== payeePanel ========
            {
                payeePanel.setLayout(new MigLayout(
                    "hidemode 3",
                    // columns
                    "[fill]0" +
                    "[fill]0" +
                    "[fill]0" +
                    "[fill]",
                    // rows
                    "[]" +
                    "[]" +
                    "[]"));

                //---- btn_payee_add ----
                btn_payee_add.setText("Add");
                btn_payee_add.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                btn_payee_add.addActionListener(e -> btn_payee_addActionPerformed(e));
                payeePanel.add(btn_payee_add, "cell 0 0");

                //---- btn_payee_remove ----
                btn_payee_remove.setText("Remove");
                btn_payee_remove.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                btn_payee_remove.addActionListener(e -> btn_payee_removeActionPerformed(e));
                payeePanel.add(btn_payee_remove, "cell 0 0");

                //======== scrollPane3 ========
                {

                    //---- table_payee_payeeList ----
                    table_payee_payeeList.setModel(new DefaultTableModel(
                        new Object[][] {
                        },
                        new String[] {
                            "IBAN", "Payee name"
                        }
                    ));
                    table_payee_payeeList.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                    scrollPane3.setViewportView(table_payee_payeeList);
                }
                payeePanel.add(scrollPane3, "cell 0 1");
            }
            customerTabPane.addTab("Payee", payeePanel);

            //======== transferPanel ========
            {
                transferPanel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                transferPanel.setLayout(new MigLayout(
                    "hidemode 3",
                    // columns
                    "[50:n,center]" +
                    "[fill]" +
                    "[fill]",
                    // rows
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]"));

                //---- label7 ----
                label7.setText("Payee:");
                label7.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                transferPanel.add(label7, "cell 1 0");
                transferPanel.add(cb_transfer_payeeList, "cell 2 0");

                //---- label8 ----
                label8.setText("Account Number: ");
                label8.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                transferPanel.add(label8, "cell 1 1");

                //---- cb_transfer_accountList ----
                cb_transfer_accountList.addActionListener(e -> cb_transfer_accountListActionPerformed(e));
                transferPanel.add(cb_transfer_accountList, "cell 2 1");

                //---- label11 ----
                label11.setText("Currency");
                label11.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                transferPanel.add(label11, "cell 1 2");

                //---- tf_transfer_currency ----
                tf_transfer_currency.setEditable(false);
                transferPanel.add(tf_transfer_currency, "cell 2 2");

                //---- label10 ----
                label10.setText("Balance");
                label10.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                transferPanel.add(label10, "cell 1 3");

                //---- tf_transfer_balance ----
                tf_transfer_balance.setEditable(false);
                transferPanel.add(tf_transfer_balance, "cell 2 3");

                //---- label9 ----
                label9.setText("Amounts");
                label9.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                transferPanel.add(label9, "cell 1 4");
                transferPanel.add(tf_transfer_amounts, "cell 2 4");

                //---- lbl_postScript ----
                lbl_postScript.setText("Postscript");
                lbl_postScript.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                transferPanel.add(lbl_postScript, "cell 1 5");
                transferPanel.add(tf_transfer_postScript, "cell 2 5");

                //---- lbl_transfer_PIN ----
                lbl_transfer_PIN.setText("PIN");
                lbl_transfer_PIN.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                transferPanel.add(lbl_transfer_PIN, "cell 1 6");
                transferPanel.add(pf_transfer_PIN, "cell 2 6");

                //---- btn_transfer_transfer ----
                btn_transfer_transfer.setText("Transfer");
                btn_transfer_transfer.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                btn_transfer_transfer.addActionListener(e -> btn_transfer_transferActionPerformed(e));
                transferPanel.add(btn_transfer_transfer, "cell 2 7");
            }
            customerTabPane.addTab("Transfer", transferPanel);
        }
        contentPane.add(customerTabPane, "cell 2 3");

        //---- btn_signout ----
        btn_signout.setText("Sign out");
        btn_signout.setMaximumSize(new Dimension(600, 30));
        btn_signout.setMinimumSize(new Dimension(450, 30));
        btn_signout.addActionListener(e -> btn_signoutActionPerformed(e));
        contentPane.add(btn_signout, "cell 2 4");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

}
