/*
 * Created by JFormDesigner on Sun Oct 14 14:56:29 BST 2018
 */

package view;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author xiangkai22
 */
public class CustomerMainView extends JFrame {
    public CustomerMainView() {
        initComponents();
    }

    private void button1ActionPerformed(ActionEvent e) {
        this.dispose();
        new CustomerLoginView().run();
    }

    private JButton btn_profile_revert;

    public void run() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
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
    private JLabel label11;
    private JButton btn_profile_deleteAccount;
    private JPanel transactionPanel;
    private JComboBox cb_accountList;
    private JComboBox cb_transaction_filter;
    private JScrollPane scrollPane2;
    private JTable table_transaction_accountTable;
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
    private JTextField btn_transfer_balance2;

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
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
            "[]"));

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
                        new Object[][] {
                            {null, null, null, null, null},
                        },
                        new String[] {
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
                    "[]" +
                    "[]"));

                //---- cb_accountList ----
                cb_accountList.setModel(new DefaultComboBoxModel(new String[] {
                    "Select Your Account"
                }));
                cb_accountList.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                transactionPanel.add(cb_accountList, "cell 0 0");

                //---- cb_transaction_filter ----
                cb_transaction_filter.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                cb_transaction_filter.setModel(new DefaultComboBoxModel(new String[] {
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
                        new Object[][] {
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                        },
                        new String[] {
                            "Date", "Details", "Debit", "Credit", "Balance"
                        }
                    ));
                    table_transaction_accountTable.setMinimumSize(new Dimension(75, 200));
                    table_transaction_accountTable.setMaximumSize(new Dimension(2147483647, 2147483647));
                    table_transaction_accountTable.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                    scrollPane2.setViewportView(table_transaction_accountTable);
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
                payeePanel.add(btn_payee_add, "cell 0 0");

                //---- btn_payee_remove ----
                btn_payee_remove.setText("Remove");
                btn_payee_remove.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                payeePanel.add(btn_payee_remove, "cell 0 0");

                //======== scrollPane3 ========
                {

                    //---- table_payee_payeeList ----
                    table_payee_payeeList.setModel(new DefaultTableModel(
                        new Object[][] {
                            {"", null, null},
                            {null, null, null},
                        },
                        new String[] {
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
                    "[]"));

                //---- label7 ----
                label7.setText("Payee:");
                label7.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                transferPanel.add(label7, "cell 1 0");

                //---- cb_payee_payeeList ----
                cb_payee_payeeList.setModel(new DefaultComboBoxModel(new String[] {
                    "Choose Your Payee"
                }));
                transferPanel.add(cb_payee_payeeList, "cell 2 0");

                //---- label8 ----
                label8.setText("Account Number: ");
                label8.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                transferPanel.add(label8, "cell 1 1");

                //---- cb_transfer_accountList ----
                cb_transfer_accountList.setModel(new DefaultComboBoxModel(new String[] {
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

                //---- btn_transfer_transfer ----
                btn_transfer_transfer.setText("Transfer");
                btn_transfer_transfer.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                transferPanel.add(btn_transfer_transfer, "cell 2 6");
            }
            customerTabPane.addTab("Transfer", transferPanel);
        }
        contentPane.add(customerTabPane, "cell 2 1");

        //---- btn_signout ----
        btn_signout.setText("Sign out");
        btn_signout.setMaximumSize(new Dimension(600, 30));
        btn_signout.setMinimumSize(new Dimension(450, 30));
        btn_signout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                button1ActionPerformed(e);
            }
        });
        contentPane.add(btn_signout, "cell 2 3");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    private JLabel label10;
    private JTextField btn_transfer_balance;
    private JLabel label9;
    private JTextField tf_transfer_amounts;
    private JButton btn_transfer_transfer;
    private JButton btn_signout;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


}
