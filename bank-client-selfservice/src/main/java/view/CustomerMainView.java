/*
 * Created by JFormDesigner on Sun Oct 14 14:56:29 BST 2018
 */

package view;

import net.miginfocom.swing.MigLayout;
import util.JTextFieldLimit;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author xiangkai22
 */
public class CustomerMainView extends JFrame {
    private JButton btn_profile_revert;
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
    private JTextField tf_profileGender;
    private JLabel lbl_address;
    private JTextField tf_profile_address;
    private JLabel lbl_email;
    private JTextField tf_profile_email;
    private JLabel lbl_contactNum;
    private JTextField tf_profile_contactNumber;
    private JButton btn_profile_modify;
    private JButton btn_profile_deleteAccount;
    private JPanel transactionPanel;
    private JComboBox cb_accountList;
    private JComboBox cb_transaction_filter;
    private JScrollPane scrollPane2;
    private JTable table_transaction_accountTable;
    private JButton btn_printStatement;
    private JPanel payeePanel;
    private JButton btn_payee_add;
    private JButton btn_payee_remove;
    private JScrollPane scrollPane3;
    private JTable table_payee_payeeList;
    private JPanel transferPanel;
    private JLabel label7;
    private JComboBox cb_payee_payeeList;
    private JLabel label8;
    private JComboBox cb_transfer_accountList;
    private JLabel label11;
    private JTextField btn_transfer_balance2;
    private JLabel label10;
    private JTextField btn_transfer_balance;
    private JLabel label9;
    private JTextField tf_transfer_amounts;
    private JLabel lbl_postScript;
    private JScrollPane scrollPane4;
    private JTextArea ta_postScript;
    private JButton btn_transfer_transfer;
    private JButton btn_signout;

    public CustomerMainView() {
        initComponents();
        initTextArea();
    }

    private void button1ActionPerformed(ActionEvent e) {
        this.dispose();
        new CustomerLoginView().run();
    }

    public void run() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void btn_payee_addActionPerformed(ActionEvent e) {
        this.dispose();
        new CustomerAddPayeeView().run();
    }

    private void initTextArea() {
        ta_postScript.setDocument(new JTextFieldLimit(200));
    }
    // JFormDesigner - End of variables declaration  //GEN-END:variables

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
        tf_profileGender = new JTextField();
        lbl_address = new JLabel();
        tf_profile_address = new JTextField();
        lbl_email = new JLabel();
        tf_profile_email = new JTextField();
        lbl_contactNum = new JLabel();
        tf_profile_contactNumber = new JTextField();
        btn_profile_modify = new JButton();
        btn_profile_revert = new JButton();
        btn_profile_deleteAccount = new JButton();
        transactionPanel = new JPanel();
        cb_accountList = new JComboBox();
        cb_transaction_filter = new JComboBox();
        scrollPane2 = new JScrollPane();
        table_transaction_accountTable = new JTable();
        btn_printStatement = new JButton();
        payeePanel = new JPanel();
        btn_payee_add = new JButton();
        btn_payee_remove = new JButton();
        scrollPane3 = new JScrollPane();
        table_payee_payeeList = new JTable();
        transferPanel = new JPanel();
        label7 = new JLabel();
        cb_payee_payeeList = new JComboBox();
        label8 = new JLabel();
        cb_transfer_accountList = new JComboBox();
        label11 = new JLabel();
        btn_transfer_balance2 = new JTextField();
        label10 = new JLabel();
        btn_transfer_balance = new JTextField();
        label9 = new JLabel();
        tf_transfer_amounts = new JTextField();
        lbl_postScript = new JLabel();
        scrollPane4 = new JScrollPane();
        ta_postScript = new JTextArea();
        btn_transfer_transfer = new JButton();
        btn_signout = new JButton();

        //======== this ========
        setTitle("Customer Main View");
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
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]"));

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
                            new Object[][]{
                                    {null, null, null, null, null},
                            },
                            new String[]{
                                    "AccountNumber", "AccountType", "CurrencyType", "Balance", "Status"
                            }
                    ));
                    table_home_accountTable.setMinimumSize(new Dimension(75, 200));
                    table_home_accountTable.setMaximumSize(new Dimension(2147483647, 2147483647));
                    table_home_accountTable.setFont(new Font("Segoe UI", Font.PLAIN, 18));
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

                //---- tf_profileGender ----
                tf_profileGender.setEnabled(false);
                profilePanel.add(tf_profileGender, "cell 3 3");

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
                profilePanel.add(btn_profile_modify, "cell 2 8");

                //---- btn_profile_revert ----
                btn_profile_revert.setText("Revert");
                btn_profile_revert.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                profilePanel.add(btn_profile_revert, "cell 3 8");

                //---- btn_profile_deleteAccount ----
                btn_profile_deleteAccount.setText("Delete Account Apply");
                btn_profile_deleteAccount.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                profilePanel.add(btn_profile_deleteAccount, "cell 2 10 2 1");
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

                //---- cb_accountList ----
                cb_accountList.setModel(new DefaultComboBoxModel(new String[]{
                        "Select Your Account"
                }));
                cb_accountList.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                transactionPanel.add(cb_accountList, "cell 0 0");

                //---- cb_transaction_filter ----
                cb_transaction_filter.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                cb_transaction_filter.setModel(new DefaultComboBoxModel(new String[]{
                        "Select the time",
                        "Recent 7 days",
                        "Recent 1 month",
                        "Recent 6 months",
                        "Recent 1 year"
                }));
                transactionPanel.add(cb_transaction_filter, "cell 0 0");

                //======== scrollPane2 ========
                {

                    //---- table_transaction_accountTable ----
                    table_transaction_accountTable.setModel(new DefaultTableModel(
                            new Object[][]{
                                    {null, null, null, null, null},
                                    {null, null, null, null, null},
                            },
                            new String[]{
                                    "Date", "Details", "Debit", "Credit", "Balance"
                            }
                    ));
                    table_transaction_accountTable.setMinimumSize(new Dimension(75, 200));
                    table_transaction_accountTable.setMaximumSize(new Dimension(2147483647, 2147483647));
                    table_transaction_accountTable.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                    scrollPane2.setViewportView(table_transaction_accountTable);
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
                btn_payee_add.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        btn_payee_addActionPerformed(e);
                    }
                });
                payeePanel.add(btn_payee_add, "cell 0 0");

                //---- btn_payee_remove ----
                btn_payee_remove.setText("Remove");
                btn_payee_remove.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                payeePanel.add(btn_payee_remove, "cell 0 0");

                //======== scrollPane3 ========
                {

                    //---- table_payee_payeeList ----
                    table_payee_payeeList.setModel(new DefaultTableModel(
                            new Object[][]{
                                    {"", null, null},
                                    {null, null, null},
                            },
                            new String[]{
                                    "IBAN", "firstName", "lastName"
                            }
                    ));
                    table_payee_payeeList.setFont(new Font("Segoe UI", Font.PLAIN, 18));
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

                //---- cb_payee_payeeList ----
                cb_payee_payeeList.setModel(new DefaultComboBoxModel(new String[]{
                        "Choose Your Payee"
                }));
                transferPanel.add(cb_payee_payeeList, "cell 2 0");

                //---- label8 ----
                label8.setText("Account Number: ");
                label8.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                transferPanel.add(label8, "cell 1 1");

                //---- cb_transfer_accountList ----
                cb_transfer_accountList.setModel(new DefaultComboBoxModel(new String[]{
                        "Select Your Account"
                }));
                transferPanel.add(cb_transfer_accountList, "cell 2 1");

                //---- label11 ----
                label11.setText("Currency");
                label11.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                transferPanel.add(label11, "cell 1 2");

                //---- btn_transfer_balance2 ----
                btn_transfer_balance2.setEditable(false);
                transferPanel.add(btn_transfer_balance2, "cell 2 2");

                //---- label10 ----
                label10.setText("Balance");
                label10.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                transferPanel.add(label10, "cell 1 3");

                //---- btn_transfer_balance ----
                btn_transfer_balance.setEditable(false);
                transferPanel.add(btn_transfer_balance, "cell 2 3");

                //---- label9 ----
                label9.setText("Amounts");
                label9.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                transferPanel.add(label9, "cell 1 4");
                transferPanel.add(tf_transfer_amounts, "cell 2 4");

                //---- lbl_postScript ----
                lbl_postScript.setText("Postscript");
                lbl_postScript.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                transferPanel.add(lbl_postScript, "cell 1 5");

                //======== scrollPane4 ========
                {
                    scrollPane4.setMinimumSize(new Dimension(16, 80));

                    //---- ta_postScript ----
                    ta_postScript.setMinimumSize(new Dimension(0, 30));
                    scrollPane4.setViewportView(ta_postScript);
                }
                transferPanel.add(scrollPane4, "cell 2 5");

                //---- btn_transfer_transfer ----
                btn_transfer_transfer.setText("Transfer");
                btn_transfer_transfer.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                transferPanel.add(btn_transfer_transfer, "cell 2 7");
            }
            customerTabPane.addTab("Transfer", transferPanel);
        }
        contentPane.add(customerTabPane, "cell 2 3");

        //---- btn_signout ----
        btn_signout.setText("Sign out");
        btn_signout.setMaximumSize(new Dimension(600, 30));
        btn_signout.setMinimumSize(new Dimension(450, 30));
        btn_signout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                button1ActionPerformed(e);
            }
        });
        contentPane.add(btn_signout, "cell 2 5");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }


}
