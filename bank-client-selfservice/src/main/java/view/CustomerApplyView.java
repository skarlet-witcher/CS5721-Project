/*
 * Created by JFormDesigner on Sun Oct 14 17:44:11 BST 2018
 */

package view;

import Const.UserAccountType;
import Const.UserType;
import controller.CustomerApplyController;
import model.*;
import net.miginfocom.swing.MigLayout;
import service.impl.CustomerApplyService;
import util.JTextFieldLimit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Timestamp;
import java.util.Calendar;

/**
 * @author xiangkai Tang
 */
public class CustomerApplyView extends JFrame {
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    public JLabel lbl_userId;
    public JTextField tf_userId;
    public JLabel lbl_firstName;
    public JTextField tf_firstName;
    public JLabel lbl_lastName;
    public JTextField tf_lastName;
    public JLabel lbl_gender;
    public JComboBox<String> cb_genderList;
    public JLabel lbl_identityType;
    public JComboBox<String> cb_identityTypeList;
    public JLabel lbl_identityNum;
    public JTextField tf_identityNum;
    public JLabel lbl_accountType;
    public JComboBox<String> cb_accountTypeList;
    public JPanel studentAccountPanel;
    public JLabel lbl_graduateDate;
    public JTextField tf_graduateMonth;
    public JLabel lbl_mark;
    public JTextField tf_graduateYear;
    public JLabel lbl_studentID;
    public JTextField tf_studentID;
    public JLabel lbl_schoolName;
    public JTextField tf_schoolName;
    public JPanel youngSaverAccountPanel;
    public JLabel lbl_parentUserID;
    public JTextField tf_parentUserID;
    public JLabel lbl_parentFirstName;
    public JTextField tf_parentFirstName;
    public JLabel lbl_parentLastName;
    public JTextField tf_parentLastName;
    public JLabel lbl_cardType;
    public JComboBox<String> cb_cardTypeList;
    public JLabel lbl_dob;
    public JTextField tf_dob_day;
    public JLabel lbl_dob_mark1;
    public JTextField tf_dob_month;
    public JLabel lbl_dob_mark2;
    public JTextField tf_dob_year;
    public JLabel lbl_address;
    public JTextField tf_address;
    public JLabel lbl_email;
    public JTextField tf_email;
    public JLabel lbl_contactNum;
    public JTextField tf_contactNum;
    public JButton btn_apply;
    public JButton btn_back;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private CustomerApplyController customerApplyController;

    public CustomerApplyView() {
        customerApplyController = new CustomerApplyController(this);
        customerApplyController.initialize();
    }

    public CustomerApplyView(Long userId, int identityType, String identityNum, int newUserApply) {
        customerApplyController = new CustomerApplyController(this, userId, identityType, identityNum, newUserApply);
        customerApplyController.initialize();
    }

    public void run() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        lbl_userId = new JLabel();
        tf_userId = new JTextField();
        lbl_firstName = new JLabel();
        tf_firstName = new JTextField();
        lbl_lastName = new JLabel();
        tf_lastName = new JTextField();
        lbl_gender = new JLabel();
        cb_genderList = new JComboBox<>();
        lbl_identityType = new JLabel();
        cb_identityTypeList = new JComboBox<>();
        lbl_identityNum = new JLabel();
        tf_identityNum = new JTextField();
        lbl_accountType = new JLabel();
        cb_accountTypeList = new JComboBox<>();
        studentAccountPanel = new JPanel();
        lbl_graduateDate = new JLabel();
        tf_graduateMonth = new JTextField();
        lbl_mark = new JLabel();
        tf_graduateYear = new JTextField();
        lbl_studentID = new JLabel();
        tf_studentID = new JTextField();
        lbl_schoolName = new JLabel();
        tf_schoolName = new JTextField();
        youngSaverAccountPanel = new JPanel();
        lbl_parentUserID = new JLabel();
        tf_parentUserID = new JTextField();
        lbl_parentFirstName = new JLabel();
        tf_parentFirstName = new JTextField();
        lbl_parentLastName = new JLabel();
        tf_parentLastName = new JTextField();
        lbl_cardType = new JLabel();
        cb_cardTypeList = new JComboBox<>();
        lbl_dob = new JLabel();
        tf_dob_day = new JTextField();
        lbl_dob_mark1 = new JLabel();
        tf_dob_month = new JTextField();
        lbl_dob_mark2 = new JLabel();
        tf_dob_year = new JTextField();
        lbl_address = new JLabel();
        tf_address = new JTextField();
        lbl_email = new JLabel();
        tf_email = new JTextField();
        lbl_contactNum = new JLabel();
        tf_contactNum = new JTextField();
        btn_apply = new JButton();
        btn_back = new JButton();

        //======== this ========
        setTitle("Customer Apply View");
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
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
            "[]0" +
            "[]0" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //---- lbl_userId ----
        lbl_userId.setText("UserId");
        contentPane.add(lbl_userId, "cell 1 0");

        //---- tf_userId ----
        tf_userId.setEditable(false);
        contentPane.add(tf_userId, "cell 2 0");

        //---- lbl_firstName ----
        lbl_firstName.setText("First Name");
        contentPane.add(lbl_firstName, "cell 1 1");
        contentPane.add(tf_firstName, "cell 2 1");

        //---- lbl_lastName ----
        lbl_lastName.setText("Last Name");
        contentPane.add(lbl_lastName, "cell 1 2");
        contentPane.add(tf_lastName, "cell 2 2");

        //---- lbl_gender ----
        lbl_gender.setText("Gender");
        contentPane.add(lbl_gender, "cell 1 3");

        //---- cb_genderList ----
        cb_genderList.setModel(new DefaultComboBoxModel<>(new String[] {
            "Select Your Gender",
            "Male",
            "Female"
        }));
        contentPane.add(cb_genderList, "cell 2 3");

        //---- lbl_identityType ----
        lbl_identityType.setText("Identity Type");
        contentPane.add(lbl_identityType, "cell 1 4");

        //---- cb_identityTypeList ----
        cb_identityTypeList.setModel(new DefaultComboBoxModel<>(new String[] {
            "Select Your Identity Type",
            "Driving License",
            "Passport"
        }));
        contentPane.add(cb_identityTypeList, "cell 2 4");

        //---- lbl_identityNum ----
        lbl_identityNum.setText("Identity Number");
        contentPane.add(lbl_identityNum, "cell 1 5");
        contentPane.add(tf_identityNum, "cell 2 5");

        //---- lbl_accountType ----
        lbl_accountType.setText("Account Type");
        contentPane.add(lbl_accountType, "cell 1 6");

        //---- cb_accountTypeList ----
        cb_accountTypeList.setModel(new DefaultComboBoxModel<>(new String[] {
            "Personal Current Account",
            "Student Current Account",
            "Young Saver Account",
            "Golden Account"
        }));
        cb_accountTypeList.addActionListener(e -> {
			customerApplyController.cb_accountTypeListActionPerformed(e);
            customerApplyController.cb_accountTypeListActionPerformed(e);
		});
        contentPane.add(cb_accountTypeList, "cell 2 6");

        //======== studentAccountPanel ========
        {
            studentAccountPanel.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[fill]" +
                "[sizegroup 1,fill]" +
                "[sizegroup 1,fill]",
                // rows
                "[]" +
                "[]" +
                "[]" +
                "[]"));

            //---- lbl_graduateDate ----
            lbl_graduateDate.setText("Graduate Date: ");
            studentAccountPanel.add(lbl_graduateDate, "cell 0 0");

            //---- tf_graduateMonth ----
            tf_graduateMonth.setMinimumSize(new Dimension(60, 24));
            tf_graduateMonth.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    customerApplyController.tf_graduateMonthFocusGained(e);
                }
                @Override
                public void focusLost(FocusEvent e) {
                    customerApplyController.tf_graduateMonthFocusLost(e);
                }
            });
            studentAccountPanel.add(tf_graduateMonth, "cell 1 0");

            //---- lbl_mark ----
            lbl_mark.setText("/");
            studentAccountPanel.add(lbl_mark, "cell 1 0");

            //---- tf_graduateYear ----
            tf_graduateYear.setMinimumSize(new Dimension(60, 24));
            tf_graduateYear.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    customerApplyController.tf_graduateYearFocusGained(e);
                }
            });
            studentAccountPanel.add(tf_graduateYear, "cell 2 0");

            //---- lbl_studentID ----
            lbl_studentID.setText("Stuent ID: ");
            studentAccountPanel.add(lbl_studentID, "cell 0 1");

            //---- tf_studentID ----
            tf_studentID.setMinimumSize(new Dimension(172, 24));
            studentAccountPanel.add(tf_studentID, "cell 1 1 2 1");

            //---- lbl_schoolName ----
            lbl_schoolName.setText("School Name");
            studentAccountPanel.add(lbl_schoolName, "cell 0 2");
            studentAccountPanel.add(tf_schoolName, "cell 1 2 2 1");
        }
        contentPane.add(studentAccountPanel, "cell 1 7 2 1");

        //======== youngSaverAccountPanel ========
        {
            youngSaverAccountPanel.setLayout(new MigLayout(
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

            //---- lbl_parentUserID ----
            lbl_parentUserID.setText("Parent's user ID");
            youngSaverAccountPanel.add(lbl_parentUserID, "cell 1 1");

            //---- tf_parentUserID ----
            tf_parentUserID.setMinimumSize(new Dimension(172, 24));
            youngSaverAccountPanel.add(tf_parentUserID, "cell 2 1");

            //---- lbl_parentFirstName ----
            lbl_parentFirstName.setText("Parent's First name");
            youngSaverAccountPanel.add(lbl_parentFirstName, "cell 1 2");
            youngSaverAccountPanel.add(tf_parentFirstName, "cell 2 2");

            //---- lbl_parentLastName ----
            lbl_parentLastName.setText("Parent's Last name");
            youngSaverAccountPanel.add(lbl_parentLastName, "cell 1 3");
            youngSaverAccountPanel.add(tf_parentLastName, "cell 2 3");
        }
        contentPane.add(youngSaverAccountPanel, "cell 1 8 2 1");

        //---- lbl_cardType ----
        lbl_cardType.setText("Card Type");
        contentPane.add(lbl_cardType, "cell 1 9");

        //---- cb_cardTypeList ----
        cb_cardTypeList.setModel(new DefaultComboBoxModel<>(new String[] {
            "Debit Card"
        }));
        cb_cardTypeList.setSelectedIndex(0);
        contentPane.add(cb_cardTypeList, "cell 2 9");

        //---- lbl_dob ----
        lbl_dob.setText("Date of Birth");
        contentPane.add(lbl_dob, "cell 1 10");

        //---- tf_dob_day ----
        tf_dob_day.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                customerApplyController.tf_dob_dayFocusGained(e);
            }
        });
        contentPane.add(tf_dob_day, "cell 2 10");

        //---- lbl_dob_mark1 ----
        lbl_dob_mark1.setText("/");
        contentPane.add(lbl_dob_mark1, "cell 2 10");

        //---- tf_dob_month ----
        tf_dob_month.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                customerApplyController.tf_dob_monthFocusGained(e);
            }
            @Override
            public void focusLost(FocusEvent e) {
                customerApplyController.tf_dob_monthFocusLost(e);
            }
        });
        contentPane.add(tf_dob_month, "cell 2 10");

        //---- lbl_dob_mark2 ----
        lbl_dob_mark2.setText("/");
        contentPane.add(lbl_dob_mark2, "cell 2 10");

        //---- tf_dob_year ----
        tf_dob_year.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                customerApplyController.tf_dob_yearFocusGained(e);
            }
        });
        contentPane.add(tf_dob_year, "cell 2 10");

        //---- lbl_address ----
        lbl_address.setText("Address");
        contentPane.add(lbl_address, "cell 1 11");
        contentPane.add(tf_address, "cell 2 11");

        //---- lbl_email ----
        lbl_email.setText("Email");
        contentPane.add(lbl_email, "cell 1 12");
        contentPane.add(tf_email, "cell 2 12");

        //---- lbl_contactNum ----
        lbl_contactNum.setText("Contact Number");
        contentPane.add(lbl_contactNum, "cell 1 13");
        contentPane.add(tf_contactNum, "cell 2 13");

        //---- btn_apply ----
        btn_apply.setText("Apply");
        btn_apply.addActionListener(e -> customerApplyController.btn_applyActionPerformed(e));
        contentPane.add(btn_apply, "cell 2 14");

        //---- btn_back ----
        btn_back.setText("Back");
        btn_back.addActionListener(e -> customerApplyController.btn_backActionPerformed(e));
        contentPane.add(btn_back, "cell 2 15");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
}
