/*
 * Created by JFormDesigner on Sun Oct 14 14:56:29 BST 2018
 */

package view;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import net.miginfocom.swing.*;

/**
 * @author xiangkai22
 */
public class CustomerMainView extends JFrame {
    public CustomerMainView() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        rootPanel = new JFrame();
        customerTabPane = new JTabbedPane();
        homePanel = new JPanel();
        scrollPane1 = new JScrollPane();
        accounTable = new JTable();
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
        tf_contactNumber = new JTextField();
        btn_profile_modify = new JButton();
        btn_profile_reset = new JButton();
        button5 = new JButton();
        transactionPanel = new JPanel();
        cb_accountList = new JComboBox();
        scrollPane2 = new JScrollPane();
        table1 = new JTable();
        payeePanel = new JPanel();
        button2 = new JButton();
        button3 = new JButton();
        scrollPane3 = new JScrollPane();
        table2 = new JTable();
        transferPanel = new JPanel();
        label7 = new JLabel();
        comboBox1 = new JComboBox();
        label8 = new JLabel();
        comboBox2 = new JComboBox();
        label10 = new JLabel();
        textField8 = new JTextField();
        label9 = new JLabel();
        textField7 = new JTextField();
        button4 = new JButton();

        //======== rootPanel ========
        {
            rootPanel.setTitle("Customer Main View");
            Container rootPanelContentPane = rootPanel.getContentPane();
            rootPanelContentPane.setLayout(new MigLayout(
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
                        "[]"));

                    //======== scrollPane1 ========
                    {

                        //---- accounTable ----
                        accounTable.setModel(new DefaultTableModel(
                            new Object[][] {
                                {null, null, null, null, null},
                            },
                            new String[] {
                                "AccountNumber", "AccountType", "CurrencyType", "Balance", "Status"
                            }
                        ));
                        accounTable.setMinimumSize(new Dimension(75, 200));
                        accounTable.setMaximumSize(new Dimension(2147483647, 2147483647));
                        accounTable.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                        scrollPane1.setViewportView(accounTable);
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
                        "[]0" +
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
                    profilePanel.add(lbl_profile_firstName, "cell 2 2");

                    //---- tf_profile_firstName ----
                    tf_profile_firstName.setEnabled(false);
                    profilePanel.add(tf_profile_firstName, "cell 3 2");

                    //---- lbl_profile_lastName ----
                    lbl_profile_lastName.setText("LastName");
                    lbl_profile_lastName.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                    profilePanel.add(lbl_profile_lastName, "cell 2 4");

                    //---- tf_profile_lastName ----
                    tf_profile_lastName.setEnabled(false);
                    profilePanel.add(tf_profile_lastName, "cell 3 4");

                    //---- lbl_gender ----
                    lbl_gender.setText("Gender");
                    lbl_gender.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                    profilePanel.add(lbl_gender, "cell 2 6");

                    //---- tf_profileGender ----
                    tf_profileGender.setEnabled(false);
                    profilePanel.add(tf_profileGender, "cell 3 6");

                    //---- lbl_address ----
                    lbl_address.setText("Address");
                    lbl_address.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                    profilePanel.add(lbl_address, "cell 2 8");
                    profilePanel.add(tf_profile_address, "cell 3 8");

                    //---- lbl_email ----
                    lbl_email.setText("Email");
                    lbl_email.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                    profilePanel.add(lbl_email, "cell 2 11");
                    profilePanel.add(tf_profile_email, "cell 3 11");

                    //---- lbl_contactNum ----
                    lbl_contactNum.setText("Contact Number");
                    lbl_contactNum.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                    profilePanel.add(lbl_contactNum, "cell 2 13");
                    profilePanel.add(tf_contactNumber, "cell 3 13");

                    //---- btn_profile_modify ----
                    btn_profile_modify.setText("Modify");
                    btn_profile_modify.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                    profilePanel.add(btn_profile_modify, "cell 2 15");

                    //---- btn_profile_reset ----
                    btn_profile_reset.setText("Reset");
                    btn_profile_reset.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                    profilePanel.add(btn_profile_reset, "cell 3 15");

                    //---- button5 ----
                    button5.setText("Delete Account");
                    button5.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                    profilePanel.add(button5, "cell 1 17 3 1");
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

                    //======== scrollPane2 ========
                    {

                        //---- table1 ----
                        table1.setModel(new DefaultTableModel(
                            new Object[][] {
                                {null, null, null, null, null},
                                {null, null, null, null, null},
                            },
                            new String[] {
                                "Date", "Details", "Debit", "Credit", "Balance"
                            }
                        ));
                        table1.setMinimumSize(new Dimension(75, 200));
                        table1.setMaximumSize(new Dimension(2147483647, 2147483647));
                        table1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                        scrollPane2.setViewportView(table1);
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

                    //---- button2 ----
                    button2.setText("Add");
                    button2.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                    payeePanel.add(button2, "cell 0 0");

                    //---- button3 ----
                    button3.setText("Remove");
                    button3.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                    payeePanel.add(button3, "cell 0 0");

                    //======== scrollPane3 ========
                    {

                        //---- table2 ----
                        table2.setModel(new DefaultTableModel(
                            new Object[][] {
                                {"", null, null},
                                {null, null, null},
                            },
                            new String[] {
                                "IBAN", "firstName", "lastName"
                            }
                        ));
                        table2.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                        scrollPane3.setViewportView(table2);
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
                        "[]"));

                    //---- label7 ----
                    label7.setText("Payee:");
                    label7.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                    transferPanel.add(label7, "cell 1 0");

                    //---- comboBox1 ----
                    comboBox1.setModel(new DefaultComboBoxModel(new String[] {
                        "Choose Your Payee"
                    }));
                    transferPanel.add(comboBox1, "cell 2 0");

                    //---- label8 ----
                    label8.setText("Account Number: ");
                    label8.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                    transferPanel.add(label8, "cell 1 1");

                    //---- comboBox2 ----
                    comboBox2.setModel(new DefaultComboBoxModel(new String[] {
                        "Select Your Account"
                    }));
                    transferPanel.add(comboBox2, "cell 2 1");

                    //---- label10 ----
                    label10.setText("Balance");
                    label10.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                    transferPanel.add(label10, "cell 1 2");

                    //---- textField8 ----
                    textField8.setEditable(false);
                    transferPanel.add(textField8, "cell 2 2");

                    //---- label9 ----
                    label9.setText("Amounts");
                    label9.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                    transferPanel.add(label9, "cell 1 3");
                    transferPanel.add(textField7, "cell 2 3");

                    //---- button4 ----
                    button4.setText("Transfer");
                    button4.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                    transferPanel.add(button4, "cell 2 5");
                }
                customerTabPane.addTab("Transfer", transferPanel);
            }
            rootPanelContentPane.add(customerTabPane, "cell 2 1");
            rootPanel.pack();
            rootPanel.setLocationRelativeTo(rootPanel.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    public void run() {
        this.rootPanel.setVisible(true);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JFrame rootPanel;
    private JTabbedPane customerTabPane;
    private JPanel homePanel;
    private JScrollPane scrollPane1;
    private JTable accounTable;
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
    private JTextField tf_contactNumber;
    private JButton btn_profile_modify;
    private JButton btn_profile_reset;
    private JButton button5;
    private JPanel transactionPanel;
    private JComboBox cb_accountList;
    private JScrollPane scrollPane2;
    private JTable table1;
    private JPanel payeePanel;
    private JButton button2;
    private JButton button3;
    private JScrollPane scrollPane3;
    private JTable table2;
    private JPanel transferPanel;
    private JLabel label7;
    private JComboBox comboBox1;
    private JLabel label8;
    private JComboBox comboBox2;
    private JLabel label10;
    private JTextField textField8;
    private JLabel label9;
    private JTextField textField7;
    private JButton button4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
