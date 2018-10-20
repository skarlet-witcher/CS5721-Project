/*
 * Created by JFormDesigner on Sun Oct 14 17:44:11 BST 2018
 */

package view;

import net.miginfocom.swing.MigLayout;
import util.JTextFieldLimit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

/**
 * @author xiangkai22
 */
public class CustomerApplyView extends JFrame {
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
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
    private JPanel studentAccountPanel;
    private JLabel lbl_graduateDate;
    private JTextField tf_graduateMonth;
    private JLabel lbl_mark;
    private JTextField tf_graduateYear;
    private JLabel lbl_studentID;
    private JTextField tf_studentID;
    private JLabel label5;
    private JTextField textField5;
    private JPanel youngSaverAccountPanel;
    private JLabel lbl_parentUserID;
    private JTextField tf_parentUserID;
    private JLabel lbl_parentUserName;
    private JTextField tf_parentUserName;
    private JLabel lbl_cardType;
    private JComboBox cb_cardTypeList;
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

    public CustomerApplyView() {
        initComponents();
        initTextFields();
        initAccountPanel();
    }

    private void tf_graduate_monthFocusGained(FocusEvent e) {

    }

    private void tf_graduate_yearFocusGained(FocusEvent e) {

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

    private void btn_applyActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void btn_backActionPerformed(ActionEvent e) {
        this.dispose();
        new CustomerLoginView().run();
    }

    private void cb_accountTypeListActionPerformed(ActionEvent e) {
        if(cb_accountTypeList.getSelectedIndex() == 0 ||
                cb_accountTypeList.getSelectedIndex() == 3) {
            resetAccountField();
            pack();
        }
        if (cb_accountTypeList.getSelectedIndex() == 1) {
            resetAccountField();
            initStudentAccountField();
            pack();
        }
        if (cb_accountTypeList.getSelectedIndex() == 2) {
            resetAccountField();
            initYoungSaverAccountField();
            pack();
        }

    }
    private void initAccountPanel() {
        studentAccountPanel.setVisible(false);
        youngSaverAccountPanel.setVisible(false);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
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
        studentAccountPanel = new JPanel();
        lbl_graduateDate = new JLabel();
        tf_graduateMonth = new JTextField();
        lbl_mark = new JLabel();
        tf_graduateYear = new JTextField();
        lbl_studentID = new JLabel();
        tf_studentID = new JTextField();
        label5 = new JLabel();
        textField5 = new JTextField();
        youngSaverAccountPanel = new JPanel();
        lbl_parentUserID = new JLabel();
        tf_parentUserID = new JTextField();
        lbl_parentUserName = new JLabel();
        tf_parentUserName = new JTextField();
        lbl_cardType = new JLabel();
        cb_cardTypeList = new JComboBox();
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
            "[]0" +
            "[]0" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //---- lbl_firstname ----
        lbl_firstname.setText("First Name");
        contentPane.add(lbl_firstname, "cell 1 0");
        contentPane.add(tf_firstName, "cell 2 0");

        //---- lbl_lastName ----
        lbl_lastName.setText("Last Name");
        contentPane.add(lbl_lastName, "cell 1 1");
        contentPane.add(tf_lastName, "cell 2 1");

        //---- lbl_gender ----
        lbl_gender.setText("Gender");
        contentPane.add(lbl_gender, "cell 1 2");

        //---- cb_genderList ----
        cb_genderList.setModel(new DefaultComboBoxModel(new String[] {
            "Select Your Gender",
            "Male",
            "Female"
        }));
        contentPane.add(cb_genderList, "cell 2 2");

        //---- lbl_identityType ----
        lbl_identityType.setText("Identity Type");
        contentPane.add(lbl_identityType, "cell 1 3");

        //---- cb_identityTypeList ----
        cb_identityTypeList.setModel(new DefaultComboBoxModel(new String[] {
            "Select Yout Identity Type",
            "Driving License",
            "Passport"
        }));
        contentPane.add(cb_identityTypeList, "cell 2 3");

        //---- lbl_identityNum ----
        lbl_identityNum.setText("Identity Number");
        contentPane.add(lbl_identityNum, "cell 1 4");
        contentPane.add(tf_identityNum, "cell 2 4");

        //---- lbl_accountType ----
        lbl_accountType.setText("Account Type");
        contentPane.add(lbl_accountType, "cell 1 5");

        //---- cb_accountTypeList ----
        cb_accountTypeList.setModel(new DefaultComboBoxModel(new String[] {
            "Personal Current Account",
            "Student Current Account",
            "Young Saver Account",
            "Golden Account"
        }));
        cb_accountTypeList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cb_accountTypeListActionPerformed(e);
                cb_accountTypeListActionPerformed(e);
            }
        });
        contentPane.add(cb_accountTypeList, "cell 2 5");

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
            studentAccountPanel.add(tf_graduateMonth, "cell 1 0");

            //---- lbl_mark ----
            lbl_mark.setText("/");
            studentAccountPanel.add(lbl_mark, "cell 1 0");

            //---- tf_graduateYear ----
            tf_graduateYear.setMinimumSize(new Dimension(60, 24));
            studentAccountPanel.add(tf_graduateYear, "cell 2 0");

            //---- lbl_studentID ----
            lbl_studentID.setText("Stuent ID: ");
            studentAccountPanel.add(lbl_studentID, "cell 0 1");

            //---- tf_studentID ----
            tf_studentID.setMinimumSize(new Dimension(172, 24));
            studentAccountPanel.add(tf_studentID, "cell 1 1 2 1");

            //---- label5 ----
            label5.setText("School Name");
            studentAccountPanel.add(label5, "cell 0 2");
            studentAccountPanel.add(textField5, "cell 1 2 2 1");
        }
        contentPane.add(studentAccountPanel, "cell 1 6 2 1");

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

            //---- lbl_parentUserName ----
            lbl_parentUserName.setText("Parent's user name");
            youngSaverAccountPanel.add(lbl_parentUserName, "cell 1 2");

            //---- tf_parentUserName ----
            tf_parentUserName.setMinimumSize(new Dimension(172, 24));
            youngSaverAccountPanel.add(tf_parentUserName, "cell 2 2");
        }
        contentPane.add(youngSaverAccountPanel, "cell 1 7 2 1");

        //---- lbl_cardType ----
        lbl_cardType.setText("Card Type");
        contentPane.add(lbl_cardType, "cell 1 8");

        //---- cb_cardTypeList ----
        cb_cardTypeList.setModel(new DefaultComboBoxModel(new String[] {
            "Select Your Card Type",
            "Debit Card",
            "Credit Card"
        }));
        contentPane.add(cb_cardTypeList, "cell 2 8");

        //---- lbl_dob ----
        lbl_dob.setText("Date of Birth");
        contentPane.add(lbl_dob, "cell 1 9");

        //---- tf_dob_day ----
        tf_dob_day.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                tf_dob_dayFocusGained(e);
            }
        });
        contentPane.add(tf_dob_day, "cell 2 9");

        //---- label10 ----
        label10.setText("/");
        contentPane.add(label10, "cell 2 9");

        //---- tf_dob_month ----
        tf_dob_month.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                tf_dob_monthFocusGained(e);
            }
        });
        contentPane.add(tf_dob_month, "cell 2 9");

        //---- label11 ----
        label11.setText("/");
        contentPane.add(label11, "cell 2 9");

        //---- tf_dob_year ----
        tf_dob_year.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                tf_dob_yearFocusGained(e);
            }
        });
        contentPane.add(tf_dob_year, "cell 2 9");

        //---- lbl_address ----
        lbl_address.setText("Address");
        contentPane.add(lbl_address, "cell 1 10");
        contentPane.add(tf_address, "cell 2 10");

        //---- lbl_email ----
        lbl_email.setText("Email");
        contentPane.add(lbl_email, "cell 1 11");
        contentPane.add(tf_email, "cell 2 11");

        //---- lbl_contactNum ----
        lbl_contactNum.setText("Contact Number");
        contentPane.add(lbl_contactNum, "cell 1 12");
        contentPane.add(tf_contactNum, "cell 2 12");

        //---- btn_apply ----
        btn_apply.setText("Apply");
        btn_apply.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_applyActionPerformed(e);
            }
        });
        contentPane.add(btn_apply, "cell 2 13");

        //---- btn_back ----
        btn_back.setText("Back");
        btn_back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_backActionPerformed(e);
            }
        });
        contentPane.add(btn_back, "cell 2 14");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    private void initTextFields() {
        tf_dob_day.setDocument(new JTextFieldLimit(2));
        tf_dob_month.setDocument(new JTextFieldLimit(2));
        tf_dob_year.setDocument(new JTextFieldLimit(4));
        tf_graduateMonth.setDocument(new JTextFieldLimit(2));
        tf_graduateYear.setDocument(new JTextFieldLimit(4));
        tf_studentID.setDocument(new JTextFieldLimit(8));
        tf_parentUserID.setDocument(new JTextFieldLimit(13));

        tf_dob_year.setText("YYYY");
        tf_dob_month.setText("MM");
        tf_dob_day.setText("DD");
        tf_graduateYear.setText("YYYY");
        tf_graduateMonth.setText("MM");
    }
    private void initStudentAccountField() {
        studentAccountPanel.setVisible(true);
    }
    private void initYoungSaverAccountField() {
        youngSaverAccountPanel.setVisible(true);
    }
    private void resetAccountField() {
        studentAccountPanel.setVisible(false);
        youngSaverAccountPanel.setVisible(false);
    }

    public void run() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }


}
