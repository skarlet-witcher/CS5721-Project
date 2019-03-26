/*
 * Created by JFormDesigner on Sun Oct 14 14:56:29 BST 2018
 */

package view;

import controller.CustomerMainController;
import model.Observer;
import model.UserModel;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

/**
 * @author Xiangkai Tang
 */
public class CustomerMainView extends JFrame implements Observer {

    private CustomerMainController customerMainController;

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    public JLabel lbl_welcome;
    public JLabel lbl_nameField;
    public JLabel lbl_lastLogin;
    public JLabel lbl_lastLoginTime;
    public JTabbedPane customerTabPane;
    public JPanel homePanel;
    public JScrollPane scrollPane1;
    public JTable table_home_accountTable;
    public JPanel profilePanel;
    public JLabel lbl_profile_userId;
    public JTextField tf_profile_userId;
    public JLabel lbl_profile_firstName;
    public JTextField tf_profile_firstName;
    public JLabel lbl_profile_lastName;
    public JTextField tf_profile_lastName;
    public JLabel lbl_gender;
    public JTextField tf_profile_gender;
    public JLabel lbl_address;
    public JTextField tf_profile_address;
    public JLabel lbl_email;
    public JTextField tf_profile_email;
    public JLabel lbl_contactNum;
    public JTextField tf_profile_contactNumber;
    public JButton btn_profile_modify;
    public JButton btn_profile_revert;
    public JPanel transactionPanel;
    public JComboBox cb_transaction_accountList;
    public JComboBox<String> cb_transaction_filter;
    public JScrollPane scrollPane2;
    public JTable table_transaction;
    public JPanel payeePanel;
    public JButton btn_payee_add;
    public JButton btn_payee_remove;
    public JScrollPane scrollPane3;
    public JTable table_payee_payeeList;
    public JPanel transferPanel;
    public JLabel lbl_transfer_payeeList;
    public JComboBox cb_transfer_payeeList;
    public JLabel lbl_transfer_accountNum;
    public JComboBox cb_transfer_accountList;
    public JLabel lbl_transfer_currency;
    public JTextField tf_transfer_currency;
    public JLabel lbl_transfer_balance;
    public JTextField tf_transfer_balance;
    public JLabel lbl_transfer_amount;
    public JTextField tf_transfer_amounts;
    public JLabel lbl_transfer_postScript;
    public JTextField tf_transfer_postScript;
    public JLabel lbl_transfer_PIN;
    public JPasswordField pf_transfer_PIN;
    public JButton btn_transfer_transfer;
    public JButton btn_signout;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


    public CustomerMainView(UserModel userModel) {
        customerMainController = new CustomerMainController(this, userModel);
        customerMainController.initialize();
        registerObserver();
    }

    private void registerObserver() {
        this.customerMainController.getUserTransferModel().registerObserver(this);
    }

    @Override
    public void updateData() {
        customerMainController.updateData();
    }

    public void initComponents() {
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
        payeePanel = new JPanel();
        btn_payee_add = new JButton();
        btn_payee_remove = new JButton();
        scrollPane3 = new JScrollPane();
        table_payee_payeeList = new JTable();
        transferPanel = new JPanel();
        lbl_transfer_payeeList = new JLabel();
        cb_transfer_payeeList = new JComboBox();
        lbl_transfer_accountNum = new JLabel();
        cb_transfer_accountList = new JComboBox();
        lbl_transfer_currency = new JLabel();
        tf_transfer_currency = new JTextField();
        lbl_transfer_balance = new JLabel();
        tf_transfer_balance = new JTextField();
        lbl_transfer_amount = new JLabel();
        tf_transfer_amounts = new JTextField();
        lbl_transfer_postScript = new JLabel();
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
                customerMainController.thisComponentShown(e);
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
                btn_profile_modify.addActionListener(e -> customerMainController.btn_profile_modifyActionPerformed(e));
                profilePanel.add(btn_profile_modify, "cell 2 8");

                //---- btn_profile_revert ----
                btn_profile_revert.setText("Revert");
                btn_profile_revert.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                btn_profile_revert.addActionListener(e -> customerMainController.btn_profile_revertActionPerformed(e));
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
                cb_transaction_accountList.addActionListener(e -> customerMainController.cb_transaction_accountListActionPerformed(e));
                transactionPanel.add(cb_transaction_accountList, "cell 0 0");

                //---- cb_transaction_filter ----
                cb_transaction_filter.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                cb_transaction_filter.setModel(new DefaultComboBoxModel<>(new String[] {
                    "Recent 7 days",
                    "Recent 1 month",
                    "Recent 6 months",
                    "Recent 1 year"
                }));
                cb_transaction_filter.addActionListener(e -> customerMainController.cb_transaction_filterActionPerformed(e));
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
                btn_payee_add.addActionListener(e -> customerMainController.btn_payee_addActionPerformed(e));
                payeePanel.add(btn_payee_add, "cell 0 0");

                //---- btn_payee_remove ----
                btn_payee_remove.setText("Remove");
                btn_payee_remove.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                btn_payee_remove.addActionListener(e -> customerMainController.btn_payee_removeActionPerformed(e));
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

                //---- lbl_transfer_payeeList ----
                lbl_transfer_payeeList.setText("Payee:");
                lbl_transfer_payeeList.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                transferPanel.add(lbl_transfer_payeeList, "cell 1 0");
                transferPanel.add(cb_transfer_payeeList, "cell 2 0");

                //---- lbl_transfer_accountNum ----
                lbl_transfer_accountNum.setText("Account Number: ");
                lbl_transfer_accountNum.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                transferPanel.add(lbl_transfer_accountNum, "cell 1 1");

                //---- cb_transfer_accountList ----
                cb_transfer_accountList.addActionListener(e -> customerMainController.cb_transfer_accountListActionPerformed(e));
                transferPanel.add(cb_transfer_accountList, "cell 2 1");

                //---- lbl_transfer_currency ----
                lbl_transfer_currency.setText("Currency");
                lbl_transfer_currency.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                transferPanel.add(lbl_transfer_currency, "cell 1 2");

                //---- tf_transfer_currency ----
                tf_transfer_currency.setEditable(false);
                transferPanel.add(tf_transfer_currency, "cell 2 2");

                //---- lbl_transfer_balance ----
                lbl_transfer_balance.setText("Balance");
                lbl_transfer_balance.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                transferPanel.add(lbl_transfer_balance, "cell 1 3");

                //---- tf_transfer_balance ----
                tf_transfer_balance.setEditable(false);
                transferPanel.add(tf_transfer_balance, "cell 2 3");

                //---- lbl_transfer_amount ----
                lbl_transfer_amount.setText("Amounts");
                lbl_transfer_amount.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                transferPanel.add(lbl_transfer_amount, "cell 1 4");
                transferPanel.add(tf_transfer_amounts, "cell 2 4");

                //---- lbl_transfer_postScript ----
                lbl_transfer_postScript.setText("Postscript");
                lbl_transfer_postScript.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                transferPanel.add(lbl_transfer_postScript, "cell 1 5");
                transferPanel.add(tf_transfer_postScript, "cell 2 5");

                //---- lbl_transfer_PIN ----
                lbl_transfer_PIN.setText("PIN");
                lbl_transfer_PIN.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                transferPanel.add(lbl_transfer_PIN, "cell 1 6");
                transferPanel.add(pf_transfer_PIN, "cell 2 6");

                //---- btn_transfer_transfer ----
                btn_transfer_transfer.setText("Transfer");
                btn_transfer_transfer.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                btn_transfer_transfer.addActionListener(e -> customerMainController.btn_transfer_transferActionPerformed(e));
                transferPanel.add(btn_transfer_transfer, "cell 2 7");
            }
            customerTabPane.addTab("Transfer", transferPanel);
        }
        contentPane.add(customerTabPane, "cell 2 3");

        //---- btn_signout ----
        btn_signout.setText("Sign out");
        btn_signout.setMaximumSize(new Dimension(600, 30));
        btn_signout.setMinimumSize(new Dimension(450, 30));
        btn_signout.addActionListener(e -> customerMainController.btn_signoutActionPerformed(e));
        contentPane.add(btn_signout, "cell 2 4");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }


}
