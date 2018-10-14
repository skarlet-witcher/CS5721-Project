/*
 * Created by JFormDesigner on Sun Oct 14 17:44:11 BST 2018
 */

package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.miginfocom.swing.*;
import util.JTextFieldLimit;

/**
 * @author xiangkai22
 */
public class CustomerApplyView extends JFrame {
    public CustomerApplyView() {
        initComponents();
        initTextFields();
    }

    private void tf_graduate_monthFocusGained(FocusEvent e) {
        tf_graduate_month.selectAll();
    }

    private void tf_graduate_yearFocusGained(FocusEvent e) {
        tf_graduate_year.selectAll();
    }

    private void tf_dob_dayFocusGained(FocusEvent e) {
        tf_dob_day.selectAll();
    }

    private void tf_dob_monthFocusGained(FocusEvent e) {
        tf_dob_month.selectAll();
    }

    private void tf_dob_yearFocusGained(FocusEvent e) {
        tf_dob_year.selectAll();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        rootPanel = new JFrame();
        lbl_firstname = new JLabel();
        tf_firstName = new JTextField();
        lbl_lastName = new JLabel();
        tf_lastName = new JTextField();
        lbl_gender = new JLabel();
        cb_genderList = new JComboBox();
        lbl_identityType = new JLabel();
        cb_identityTypeList = new JComboBox();
        lbl_identityNum = new JLabel();
        tf_identityNum = new JTextField();
        lbl_accountType = new JLabel();
        cb_accountTypeList = new JComboBox();
        lbl_cardType = new JLabel();
        cb_cardTypeList = new JComboBox();
        lbl_graduateDate = new JLabel();
        tf_graduate_month = new JTextField();
        label8 = new JLabel();
        tf_graduate_year = new JTextField();
        lbl_dob = new JLabel();
        tf_dob_day = new JTextField();
        label10 = new JLabel();
        tf_dob_month = new JTextField();
        label11 = new JLabel();
        tf_dob_year = new JTextField();
        lbl_address = new JLabel();
        tf_address = new JTextField();
        lbl_email = new JLabel();
        tf_email = new JTextField();
        lbl_contactNum = new JLabel();
        tf_contactNum = new JTextField();
        btn_apply = new JButton();
        btn_back = new JButton();

        //======== rootPanel ========
        {
            rootPanel.setTitle("Customer Apply View");
            Container rootPanelContentPane = rootPanel.getContentPane();
            rootPanelContentPane.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[30:n,fill]" +
                "[fill]" +
                "[fill]" +
                "[30:n,fill]",
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
                "[]" +
                "[]" +
                "[]"));

            //---- lbl_firstname ----
            lbl_firstname.setText("First Name");
            rootPanelContentPane.add(lbl_firstname, "cell 1 0");
            rootPanelContentPane.add(tf_firstName, "cell 2 0");

            //---- lbl_lastName ----
            lbl_lastName.setText("Last Name");
            rootPanelContentPane.add(lbl_lastName, "cell 1 1");
            rootPanelContentPane.add(tf_lastName, "cell 2 1");

            //---- lbl_gender ----
            lbl_gender.setText("Gender");
            rootPanelContentPane.add(lbl_gender, "cell 1 2");

            //---- cb_genderList ----
            cb_genderList.setModel(new DefaultComboBoxModel(new String[] {
                "Select Your Gender",
                "Male",
                "Female"
            }));
            rootPanelContentPane.add(cb_genderList, "cell 2 2");

            //---- lbl_identityType ----
            lbl_identityType.setText("Identity Type");
            rootPanelContentPane.add(lbl_identityType, "cell 1 3");

            //---- cb_identityTypeList ----
            cb_identityTypeList.setModel(new DefaultComboBoxModel(new String[] {
                "Select Yout Identity Type",
                "Driving License",
                "Passport"
            }));
            rootPanelContentPane.add(cb_identityTypeList, "cell 2 3");

            //---- lbl_identityNum ----
            lbl_identityNum.setText("Identity Number");
            rootPanelContentPane.add(lbl_identityNum, "cell 1 4");
            rootPanelContentPane.add(tf_identityNum, "cell 2 4");

            //---- lbl_accountType ----
            lbl_accountType.setText("Account Type");
            rootPanelContentPane.add(lbl_accountType, "cell 1 5");

            //---- cb_accountTypeList ----
            cb_accountTypeList.setModel(new DefaultComboBoxModel(new String[] {
                "Select Your Account Type",
                "Current Account",
                "Student Current Account"
            }));
            rootPanelContentPane.add(cb_accountTypeList, "cell 2 5");

            //---- lbl_cardType ----
            lbl_cardType.setText("Card Type");
            rootPanelContentPane.add(lbl_cardType, "cell 1 6");

            //---- cb_cardTypeList ----
            cb_cardTypeList.setModel(new DefaultComboBoxModel(new String[] {
                "Select Your Card Type",
                "Debit Card",
                "Credit Card"
            }));
            rootPanelContentPane.add(cb_cardTypeList, "cell 2 6");

            //---- lbl_graduateDate ----
            lbl_graduateDate.setText("Graduate Date");
            rootPanelContentPane.add(lbl_graduateDate, "cell 1 7");

            //---- tf_graduate_month ----
            tf_graduate_month.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    tf_graduate_monthFocusGained(e);
                }
            });
            rootPanelContentPane.add(tf_graduate_month, "cell 2 7");

            //---- label8 ----
            label8.setText("/");
            label8.setPreferredSize(new Dimension(2, 10));
            label8.setHorizontalTextPosition(SwingConstants.CENTER);
            label8.setMinimumSize(new Dimension(1, 16));
            rootPanelContentPane.add(label8, "cell 2 7");

            //---- tf_graduate_year ----
            tf_graduate_year.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    tf_graduate_yearFocusGained(e);
                }
            });
            rootPanelContentPane.add(tf_graduate_year, "cell 2 7");

            //---- lbl_dob ----
            lbl_dob.setText("Date of Birth");
            rootPanelContentPane.add(lbl_dob, "cell 1 8");

            //---- tf_dob_day ----
            tf_dob_day.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    tf_dob_dayFocusGained(e);
                }
            });
            rootPanelContentPane.add(tf_dob_day, "cell 2 8");

            //---- label10 ----
            label10.setText("/");
            rootPanelContentPane.add(label10, "cell 2 8");

            //---- tf_dob_month ----
            tf_dob_month.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    tf_dob_monthFocusGained(e);
                }
            });
            rootPanelContentPane.add(tf_dob_month, "cell 2 8");

            //---- label11 ----
            label11.setText("/");
            rootPanelContentPane.add(label11, "cell 2 8");

            //---- tf_dob_year ----
            tf_dob_year.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    tf_dob_yearFocusGained(e);
                }
            });
            rootPanelContentPane.add(tf_dob_year, "cell 2 8");

            //---- lbl_address ----
            lbl_address.setText("Address");
            rootPanelContentPane.add(lbl_address, "cell 1 9");
            rootPanelContentPane.add(tf_address, "cell 2 9");

            //---- lbl_email ----
            lbl_email.setText("Email");
            rootPanelContentPane.add(lbl_email, "cell 1 10");
            rootPanelContentPane.add(tf_email, "cell 2 10");

            //---- lbl_contactNum ----
            lbl_contactNum.setText("Contact Number");
            rootPanelContentPane.add(lbl_contactNum, "cell 1 11");
            rootPanelContentPane.add(tf_contactNum, "cell 2 11");

            //---- btn_apply ----
            btn_apply.setText("Apply");
            rootPanelContentPane.add(btn_apply, "cell 2 12");

            //---- btn_back ----
            btn_back.setText("Back");
            rootPanelContentPane.add(btn_back, "cell 2 13");
            rootPanel.pack();
            rootPanel.setLocationRelativeTo(rootPanel.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    private void initTextFields() {
        tf_dob_day.setDocument(new JTextFieldLimit(2));
        tf_dob_month.setDocument(new JTextFieldLimit(2));
        tf_dob_year.setDocument(new JTextFieldLimit(4));
        tf_graduate_month.setDocument(new JTextFieldLimit(2));
        tf_graduate_year.setDocument(new JTextFieldLimit(4));

        tf_dob_year.setText("YYYY");
        tf_dob_month.setText("MM");
        tf_dob_day.setText("DD");
        tf_graduate_month.setText("MM");
        tf_graduate_year.setText("YYYY");
    }

    public void run() {
        this.rootPanel.setVisible(true);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JFrame rootPanel;
    private JLabel lbl_firstname;
    private JTextField tf_firstName;
    private JLabel lbl_lastName;
    private JTextField tf_lastName;
    private JLabel lbl_gender;
    private JComboBox cb_genderList;
    private JLabel lbl_identityType;
    private JComboBox cb_identityTypeList;
    private JLabel lbl_identityNum;
    private JTextField tf_identityNum;
    private JLabel lbl_accountType;
    private JComboBox cb_accountTypeList;
    private JLabel lbl_cardType;
    private JComboBox cb_cardTypeList;
    private JLabel lbl_graduateDate;
    private JTextField tf_graduate_month;
    private JLabel label8;
    private JTextField tf_graduate_year;
    private JLabel lbl_dob;
    private JTextField tf_dob_day;
    private JLabel label10;
    private JTextField tf_dob_month;
    private JLabel label11;
    private JTextField tf_dob_year;
    private JLabel lbl_address;
    private JTextField tf_address;
    private JLabel lbl_email;
    private JTextField tf_email;
    private JLabel lbl_contactNum;
    private JTextField tf_contactNum;
    private JButton btn_apply;
    private JButton btn_back;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
