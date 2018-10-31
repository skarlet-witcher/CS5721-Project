/*
 * Created by JFormDesigner on Sun Oct 14 17:44:11 BST 2018
 */

package view;

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
 * @author xiangkai22
 */
public class CustomerApplyView extends JFrame {
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel lbl_firstname;
    private JTextField tf_firstName;
    private JLabel lbl_lastName;
    private JTextField tf_lastName;
    private JLabel lbl_gender;
    private JComboBox<String> cb_genderList;
    private JLabel lbl_identityType;
    private JComboBox<String> cb_identityTypeList;
    private JLabel lbl_identityNum;
    private JTextField tf_identityNum;
    private JLabel lbl_accountType;
    private JComboBox<String> cb_accountTypeList;
    private JPanel studentAccountPanel;
    private JLabel lbl_graduateDate;
    private JTextField tf_graduateMonth;
    private JLabel lbl_mark;
    private JTextField tf_graduateYear;
    private JLabel lbl_studentID;
    private JTextField tf_studentID;
    private JLabel lbl_schoolName;
    private JTextField tf_schoolName;
    private JPanel youngSaverAccountPanel;
    private JLabel lbl_parentUserID;
    private JTextField tf_parentUserID;
    private JLabel lbl_parentFirstName;
    private JTextField tf_parentFirstName;
    private JLabel lbl_parentLastName;
    private JTextField tf_parentLastName;
    private JLabel lbl_cardType;
    private JComboBox<String> cb_cardTypeList;
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
        // First Name validator
        if(tf_firstName.getText().trim().length() <= 0) {
            JOptionPane.showMessageDialog(null,
                    "Please input your first name",
                    "Error Message", JOptionPane.ERROR_MESSAGE);
            tf_firstName.grabFocus();
            return;
        } if(!tf_firstName.getText().trim().matches("^[a-zA-Z]+$")) {
            JOptionPane.showMessageDialog(null,
                    "First name should only contain letters",
                    "Error Message", JOptionPane.ERROR_MESSAGE);
            tf_firstName.grabFocus();
            return;
        }

        // Last name validator
        if(tf_lastName.getText().trim().length() <= 0) {
            JOptionPane.showMessageDialog(null,
                    "Please input your last name",
                    "Error Message", JOptionPane.ERROR_MESSAGE);
            tf_lastName.grabFocus();
            return;
        } if(!tf_lastName.getText().trim().matches("^[a-zA-Z]+$")) {
            JOptionPane.showMessageDialog(null,
                    "First name should only contain letters",
                    "Error Message", JOptionPane.ERROR_MESSAGE);
            tf_lastName.grabFocus();
            return;
        }

        // gender field validator
        if(cb_genderList.getSelectedIndex() <= 0) {
            JOptionPane.showMessageDialog(null,
                    "Please input your gender",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            return;
        }

        // identity type validator
        if(cb_identityTypeList.getSelectedIndex() <= 0) {
            JOptionPane.showMessageDialog(null,
                    "Please select your identity type",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Identity number validator
        if(tf_identityNum.getText().trim().length() <= 0) {
            JOptionPane.showMessageDialog(null,
                    "Please input your identity number",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            tf_identityNum.grabFocus();
            return;
        }
        if(!tf_identityNum.getText().trim().matches("^[a-zA-Z0-9]*$")) {
            JOptionPane.showMessageDialog(null,
                    "Identity number should only contain numbers and letters",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            tf_identityNum.grabFocus();
            return;
        }

        // account type validator
        if(cb_accountTypeList.getSelectedIndex() == 1){
            // student account validator

            // graduate month validator
            if(tf_graduateMonth.getText().trim().length() <= 0) {
                JOptionPane.showMessageDialog(null,
                        "Please input your graduate month",
                        "Error Message",JOptionPane.ERROR_MESSAGE);
                tf_graduateMonth.grabFocus();
                return;
            }
            if(!tf_graduateMonth.getText().trim().matches("^[0-9]*$")) {
                JOptionPane.showMessageDialog(null,
                        "The graduate month should be numeric",
                        "Error Message",JOptionPane.ERROR_MESSAGE);
                tf_graduateMonth.grabFocus();
                return;
            }
            if(Integer.parseInt(tf_graduateMonth.getText().trim()) > 12 || Integer.parseInt(tf_graduateMonth.getText().trim()) < 1) {
                JOptionPane.showMessageDialog(null,
                        "The ranage of graduate month should be 1 to 12",
                        "Error Message",JOptionPane.ERROR_MESSAGE);
                tf_graduateMonth.grabFocus();
                return;
            }

            // graduate year validator
            int currentYear = Calendar.getInstance().get(Calendar.YEAR);
            if(tf_graduateYear.getText().trim().length() <= 0) {
                JOptionPane.showMessageDialog(null,
                        "Please input your graduate month",
                        "Error Message",JOptionPane.ERROR_MESSAGE);
                tf_graduateYear.grabFocus();
                return;
            } if(!tf_graduateYear.getText().trim().matches("^[0-9]*$")) {
                JOptionPane.showMessageDialog(null,
                        "Graduate year should only contain numbers",
                        "Error Message",JOptionPane.ERROR_MESSAGE);
                tf_graduateYear.grabFocus();
                return;
            }
            if(tf_graduateYear.getText().length() < 4) {
                JOptionPane.showMessageDialog(null,
                        "Graduate year should be four digits",
                        "Error Message",JOptionPane.ERROR_MESSAGE);
                tf_graduateYear.grabFocus();
                return;
            }
            if(Integer.parseInt(tf_graduateYear.getText().trim()) < currentYear) {
                JOptionPane.showMessageDialog(null,
                        "Graduate year should longer or equal to current year",
                        "Error Message",JOptionPane.ERROR_MESSAGE);
                tf_graduateYear.grabFocus();
                return;
            }

            // student Id validator
            if(tf_studentID.getText().trim().length() <= 0) {
                JOptionPane.showMessageDialog(null,
                        "Please input your student Id",
                        "Error Message",JOptionPane.ERROR_MESSAGE);
                tf_studentID.grabFocus();
                return;
            }
            if(!tf_studentID.getText().trim().matches("^[0-9]*$")) {
                JOptionPane.showMessageDialog(null,
                        "The student Id should only contain number",
                        "Error Message",JOptionPane.ERROR_MESSAGE);
                tf_studentID.grabFocus();
                return;
            }

            // school name validator
            if(tf_schoolName.getText().trim().length() <= 0) {
                JOptionPane.showMessageDialog(null,
                        "Please input your school name.",
                        "Error Message",JOptionPane.ERROR_MESSAGE);
                tf_schoolName.grabFocus();
                return;
            }

        }
        if(cb_accountTypeList.getSelectedIndex() == 2) {
            // Young Saver account validator

            // parent UserId validator
            if(tf_parentUserID.getText().length() <= 0) {
                JOptionPane.showMessageDialog(null,
                        "Please input your school name.",
                        "Error Message",JOptionPane.ERROR_MESSAGE);
                tf_parentUserID.grabFocus();
                return;
            }
            if(!tf_parentUserID.getText().trim().matches("^[0-9]*$")) {
                JOptionPane.showMessageDialog(null,
                        "Parent UserId should only contain numbers",
                        "Error Message",JOptionPane.ERROR_MESSAGE);
                tf_parentUserID.grabFocus();
                return;
            }

            // parent first name validator
            if(tf_parentFirstName.getText().trim().length() <= 0) {
                JOptionPane.showMessageDialog(null,
                        "Please input first name of one of your parents.",
                        "Error Message",JOptionPane.ERROR_MESSAGE);
                tf_parentFirstName.grabFocus();
                return;
            }
            if(!tf_parentFirstName.getText().trim().matches("^[a-zA-Z]+$")) {
                JOptionPane.showMessageDialog(null,
                        "The parent's first name should only contain characters",
                        "Error Message",JOptionPane.ERROR_MESSAGE);
                tf_parentFirstName.grabFocus();
                return;
            }

            // parent last name validator
            if(tf_parentLastName.getText().trim().length() <= 0) {
                JOptionPane.showMessageDialog(null,
                        "Please input last name of one of your parents.",
                        "Error Message",JOptionPane.ERROR_MESSAGE);
                tf_parentLastName.grabFocus();
                return;
            }
            if(!tf_parentLastName.getText().trim().matches("^[a-zA-Z]+$")) {
                JOptionPane.showMessageDialog(null,
                        "The parent's last name should only contain characters",
                        "Error Message",JOptionPane.ERROR_MESSAGE);
                tf_parentLastName.grabFocus();
                return;
            }
        }

        // date of birth validator

        // day of dob validator
        if(tf_dob_day.getText().trim().length() <= 0) {
            JOptionPane.showMessageDialog(null,
                    "Please input your day of your date of birth",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            tf_dob_day.grabFocus();
            return;
        }
        if(!tf_dob_day.getText().trim().matches("^[1-9]*$")) {
            JOptionPane.showMessageDialog(null,
                    "The day of the date of birth should be numeric",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            tf_dob_day.grabFocus();
            return;
        }
        if(Integer.parseInt(tf_dob_day.getText().trim()) > 31 || Integer.parseInt(tf_dob_day.getText().trim()) < 1) {
            JOptionPane.showMessageDialog(null,
                    "The ranage of day of the date of birth should be 1 to 31",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            tf_dob_day.grabFocus();
            return;
        }
        if(tf_dob_day.getText().trim().length() == 1) {
            tf_dob_day.setText("0" + tf_dob_day.getText());
        }

        // month of dob validator
        if(tf_dob_month.getText().trim().length() <= 0) {
            JOptionPane.showMessageDialog(null,
                    "Please input your month of your date of birth",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            tf_dob_month.grabFocus();
            return;
        }
        if(!tf_dob_month.getText().trim().matches("^[0-9]*$")) {
            JOptionPane.showMessageDialog(null,
                    "The month of your date of birth should be numeric",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            tf_dob_month.grabFocus();
            return;
        }
        if(Integer.parseInt(tf_dob_month.getText().trim()) > 12 || Integer.parseInt(tf_dob_month.getText().trim()) < 1) {
            JOptionPane.showMessageDialog(null,
                    "The ranage of month of the date of birth should be 1 to 12",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            tf_dob_month.grabFocus();
            return;
        }
        if(tf_dob_month.getText().trim().length() == 1) {
            tf_dob_month.setText("0" + tf_dob_month.getText());
        }

        //  year of the date or birth validator
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        if(tf_dob_year.getText().trim().length() <= 0) {
            JOptionPane.showMessageDialog(null,
                    "Please input your year of the date of birth",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            tf_dob_year.grabFocus();
            return;
        } if(!tf_dob_year.getText().trim().matches("^[0-9]*$")) {
            JOptionPane.showMessageDialog(null,
                    "year of the date of brith should only contain numbers",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            tf_dob_year.grabFocus();
            return;
        }
        if(tf_dob_year.getText().length() < 4) {
            JOptionPane.showMessageDialog(null,
                    "The year of date of birth should be four digits",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            tf_dob_year.grabFocus();
            return;
        }
        if(Integer.parseInt(tf_dob_year.getText().trim()) > currentYear) {
            JOptionPane.showMessageDialog(null,
                    "The year of date of birth should be less or equal to current year",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            tf_dob_year.grabFocus();
            return;
        }

        // address validator
        if(tf_address.getText().trim().length() <= 0) {
            JOptionPane.showMessageDialog(null,
                    "Please input your address",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            tf_address.grabFocus();
            return;
        }


        // email field validator
        if(tf_email.getText().trim().length() <= 0) {
            JOptionPane.showMessageDialog(null,
                    "Please input your email address",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            tf_email.grabFocus();
            return;
        }
        if(!tf_email.getText().trim().matches("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b")) {
            JOptionPane.showMessageDialog(null,
                    "Please input valid email address",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            tf_email.grabFocus();
            return;
        }

        // contact number validator
        if(tf_contactNum.getText().trim().length() <= 0) {
            JOptionPane.showMessageDialog(null,
                    "Please input your contact number",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            tf_contactNum.grabFocus();
            return;
        }
        if(!tf_contactNum.getText().trim().matches("^[0-9]*$")) {
            JOptionPane.showMessageDialog(null,
                    "The contact number must be numeric.",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            tf_contactNum.grabFocus();
            return;
        }

        // ready to apply an account
        try {
            if(cb_accountTypeList.getSelectedIndex() == 0){
                System.out.println("ready to apply personal account");
                applyPersonalAccount();
            }
            if(cb_accountTypeList.getSelectedIndex() == 1) {
                System.out.println("ready to apply student account");
                applyStudentAccount();
            }
            if(cb_accountTypeList.getSelectedIndex() == 2) {
                System.out.println("ready to apply young saver account");
                applyYoungSaverAccount();
            }
            if(cb_accountTypeList.getSelectedIndex() == 3) {
                System.out.println("ready to apply golden account");
                applyGoldenAccount();
            }
        } catch (Exception E) {
            E.printStackTrace();
        }
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

    private void tf_graduateMonthFocusLost(FocusEvent e) {
        // if input one digit of a month, add 0 before that
        if(tf_graduateMonth.getText().trim().length() == 1) {
            tf_graduateMonth.setText("0" + tf_graduateMonth.getText());
        }
    }

    private void tf_graduateMonthFocusGained(FocusEvent e) {
        tf_graduateMonth.selectAll();
    }

    private void tf_graduateYearFocusGained(FocusEvent e) {
        tf_graduateYear.selectAll();
    }

    private void tf_dob_monthFocusLost(FocusEvent e) {
        // if input one digit of a month, add 0 before that
        if(tf_dob_month.getText().trim().length() == 1) {
            tf_dob_month.setText("0" + tf_dob_month.getText());
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        lbl_firstname = new JLabel();
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
        cb_genderList.setModel(new DefaultComboBoxModel<>(new String[] {
            "Select Your Gender",
            "Male",
            "Female"
        }));
        contentPane.add(cb_genderList, "cell 2 2");

        //---- lbl_identityType ----
        lbl_identityType.setText("Identity Type");
        contentPane.add(lbl_identityType, "cell 1 3");

        //---- cb_identityTypeList ----
        cb_identityTypeList.setModel(new DefaultComboBoxModel<>(new String[] {
            "Select Your Identity Type",
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
        cb_accountTypeList.setModel(new DefaultComboBoxModel<>(new String[] {
            "Personal Current Account",
            "Student Current Account",
            "Young Saver Account",
            "Golden Account"
        }));
        cb_accountTypeList.addActionListener(e -> {
			cb_accountTypeListActionPerformed(e);
			cb_accountTypeListActionPerformed(e);
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
            tf_graduateMonth.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    tf_graduateMonthFocusGained(e);
                }
                @Override
                public void focusLost(FocusEvent e) {
                    tf_graduateMonthFocusLost(e);
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
                    tf_graduateYearFocusGained(e);
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
            lbl_parentUserID.setText("Parent's UserId");
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
        contentPane.add(youngSaverAccountPanel, "cell 1 7 2 1");

        //---- lbl_cardType ----
        lbl_cardType.setText("Card Type");
        contentPane.add(lbl_cardType, "cell 1 8");

        //---- cb_cardTypeList ----
        cb_cardTypeList.setModel(new DefaultComboBoxModel<>(new String[] {
            "Debit Card",
            "Credit Card"
        }));
        cb_cardTypeList.setSelectedIndex(0);
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
            @Override
            public void focusLost(FocusEvent e) {
                tf_dob_monthFocusLost(e);
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
        btn_apply.addActionListener(e -> btn_applyActionPerformed(e));
        contentPane.add(btn_apply, "cell 2 13");

        //---- btn_back ----
        btn_back.setText("Back");
        btn_back.addActionListener(e -> btn_backActionPerformed(e));
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
        tf_parentUserID.setDocument(new JTextFieldLimit(10));
        tf_firstName.setDocument(new JTextFieldLimit(20));
        tf_lastName.setDocument(new JTextFieldLimit(20));
        tf_identityNum.setDocument(new JTextFieldLimit(25));
        tf_schoolName.setDocument(new JTextFieldLimit(50));


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

    private void applyPersonalAccount() {
        // basic info
        String firstName = tf_firstName.getText().trim();
        String lastName = tf_lastName.getText().trim();
        String identityNum = tf_identityNum.getText().trim();
        int identityType = cb_identityTypeList.getSelectedIndex();
        int accountType = cb_accountTypeList.getSelectedIndex() + 1;
        int cardType = cb_cardTypeList.getSelectedIndex() + 1;
        String birthDateText = tf_dob_year.getText().trim()+"-"+
                tf_dob_month.getText().trim()+"-"+tf_dob_day.getText().trim()+" 00:00:00";
        //month and day with one digit
        Timestamp birthDate = Timestamp.valueOf(birthDateText);
        int gender = cb_genderList.getSelectedIndex();
        String address = tf_address.getText().trim();
        String email = tf_email.getText().trim();
        String contactNum = tf_contactNum.getText().trim();
        int newUserApply = 1;

        try {
            UserApplyNewPersonalAccountBaseModel userApplyNewPersonalAccountBaseModel = (UserApplyNewPersonalAccountBaseModel) UserApplyNewAccountFactory.applyAccount(cb_accountTypeList.getSelectedItem().toString());
            userApplyNewPersonalAccountBaseModel.setFirstName(firstName);
            userApplyNewPersonalAccountBaseModel.setLastName(lastName);
            userApplyNewPersonalAccountBaseModel.setIdentityNum(identityNum);
            userApplyNewPersonalAccountBaseModel.setIdentityType(identityType);
            userApplyNewPersonalAccountBaseModel.setCardType(cardType);
            userApplyNewPersonalAccountBaseModel.setBirthDate(birthDate);
            userApplyNewPersonalAccountBaseModel.setAccountType(accountType);
            userApplyNewPersonalAccountBaseModel.setGender(gender);
            userApplyNewPersonalAccountBaseModel.setAddress(address);
            userApplyNewPersonalAccountBaseModel.setEmail(email);
            userApplyNewPersonalAccountBaseModel.setContactNum(contactNum);
            userApplyNewPersonalAccountBaseModel.setNewUserApply(newUserApply);

            CustomerApplyService.getInstance().applyPersonalAccountForNewUser(userApplyNewPersonalAccountBaseModel);
            JOptionPane.showMessageDialog(null,
                    "Personal Account apply requested successful",
                    "Success Message",JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception E) {
            JOptionPane.showMessageDialog(null,
                    E.getMessage(),
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            return;
        }

    }

    private void applyGoldenAccount() {
        // basic info
        String firstName = tf_firstName.getText().trim();
        String lastName = tf_lastName.getText().trim();
        String identityNum = tf_identityNum.getText().trim();
        int identityType = cb_identityTypeList.getSelectedIndex();
        int accountType = cb_accountTypeList.getSelectedIndex() + 1;
        int cardType = cb_cardTypeList.getSelectedIndex() + 1;
        String birthDateText = tf_dob_year.getText().trim()+"-"+
                tf_dob_month.getText().trim()+"-"+tf_dob_day.getText().trim()+" 00:00:00";
        //month and day with one digit
        Timestamp birthDate = Timestamp.valueOf(birthDateText);
        int gender = cb_genderList.getSelectedIndex();
        String address = tf_address.getText().trim();
        String email = tf_email.getText().trim();
        String contactNum = tf_contactNum.getText().trim();
        int newUserApply = 1;

        try {
            UserApplyNewGoldenAccountBaseModel userApplyNewGoldenAccountBaseModel = (UserApplyNewGoldenAccountBaseModel) UserApplyNewAccountFactory.applyAccount(cb_accountTypeList.getSelectedItem().toString());
            userApplyNewGoldenAccountBaseModel.setFirstName(firstName);
            userApplyNewGoldenAccountBaseModel.setLastName(lastName);
            userApplyNewGoldenAccountBaseModel.setIdentityNum(identityNum);
            userApplyNewGoldenAccountBaseModel.setIdentityType(identityType);
            userApplyNewGoldenAccountBaseModel.setAccountType(accountType);
            userApplyNewGoldenAccountBaseModel.setCardType(cardType);
            userApplyNewGoldenAccountBaseModel.setBirthDate(birthDate);
            userApplyNewGoldenAccountBaseModel.setGender(gender);
            userApplyNewGoldenAccountBaseModel.setAddress(address);
            userApplyNewGoldenAccountBaseModel.setEmail(email);
            userApplyNewGoldenAccountBaseModel.setContactNum(contactNum);
            userApplyNewGoldenAccountBaseModel.setNewUserApply(newUserApply);


            CustomerApplyService.getInstance().applyGoldenAccountForNewUser(userApplyNewGoldenAccountBaseModel);
            JOptionPane.showMessageDialog(null,
                    "Golden Account apply requested successful",
                    "Success Message",JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception E) {
            JOptionPane.showMessageDialog(null,
                    E.getMessage(),
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            return;
        }

    }

    private void applyStudentAccount() {
        // basic info
        String firstName = tf_firstName.getText().trim();
        String lastName = tf_lastName.getText().trim();
        String identityNum = tf_identityNum.getText().trim();
        int identityType = cb_identityTypeList.getSelectedIndex();
        int accountType = cb_accountTypeList.getSelectedIndex() + 1;
        int cardType = cb_cardTypeList.getSelectedIndex() + 1;
        String birthDateText = tf_dob_year.getText().trim()+"-"+
                tf_dob_month.getText().trim()+"-"+tf_dob_day.getText().trim()+" 00:00:00";
        // TO-DO month and day with one digit ????
        Timestamp birthDate = Timestamp.valueOf(birthDateText);
        int gender = cb_genderList.getSelectedIndex();
        String address = tf_address.getText().trim();
        String email = tf_email.getText().trim();
        String contactNum = tf_contactNum.getText().trim();
        int newUserApply = 1;

        // student account Info
        // TO-DO month and day with one digit ????
        String graduateDateText = tf_graduateYear.getText().trim() + "-" + tf_graduateMonth.getText().trim() +"-01 " +"00:00:00";
        Timestamp graduateDate = Timestamp.valueOf(graduateDateText);
        String studentId = tf_studentID.getText().trim();
        String schoolName = tf_schoolName.getText().trim();

        try {
            UserApplyNewStudentAccountBaseModel userApplyNewStudentAccountBaseModel = (UserApplyNewStudentAccountBaseModel) UserApplyNewAccountFactory.applyAccount(cb_accountTypeList.getSelectedItem().toString());
            userApplyNewStudentAccountBaseModel.setFirstName(firstName);
            userApplyNewStudentAccountBaseModel.setLastName(lastName);
            userApplyNewStudentAccountBaseModel.setIdentityNum(identityNum);
            userApplyNewStudentAccountBaseModel.setIdentityType(identityType);
            userApplyNewStudentAccountBaseModel.setAccountType(accountType);
            userApplyNewStudentAccountBaseModel.setCardType(cardType);
            userApplyNewStudentAccountBaseModel.setBirthDate(birthDate);
            userApplyNewStudentAccountBaseModel.setGender(gender);
            userApplyNewStudentAccountBaseModel.setAddress(address);
            userApplyNewStudentAccountBaseModel.setEmail(email);
            userApplyNewStudentAccountBaseModel.setContactNum(contactNum);
            userApplyNewStudentAccountBaseModel.setNewUserApply(newUserApply);
            userApplyNewStudentAccountBaseModel.setGraduateDate(graduateDate);
            userApplyNewStudentAccountBaseModel.setStudentId(studentId);
            userApplyNewStudentAccountBaseModel.setSchoolName(schoolName);


            CustomerApplyService.getInstance().applyStudentAccountForNewUser(userApplyNewStudentAccountBaseModel);
            JOptionPane.showMessageDialog(null,
                    "Student Account apply requested successful",
                    "Success Message",JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception E) {
            JOptionPane.showMessageDialog(null,
                    E.getMessage(),
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            return;
        }


    }

    private void applyYoungSaverAccount() {
        // basic info
        String firstName = tf_firstName.getText().trim();
        String lastName = tf_lastName.getText().trim();
        String identityNum = tf_identityNum.getText().trim();
        int identityType = cb_identityTypeList.getSelectedIndex();
        int accountType = cb_accountTypeList.getSelectedIndex() + 1;
        int cardType = cb_cardTypeList.getSelectedIndex() + 1;
        String birthDateText = tf_dob_year.getText().trim()+"-"+
                tf_dob_month.getText().trim()+"-"+tf_dob_day.getText().trim()+" 00:00:00";
        // TO-DO month and day with one digit ????
        Timestamp birthDate = Timestamp.valueOf(birthDateText);
        int gender = cb_genderList.getSelectedIndex();
        String address = tf_address.getText().trim();
        String email = tf_email.getText().trim();
        String contactNum = tf_contactNum.getText().trim();
        int newUserApply = 1;

        // young saver info
        long parentUserId = Long.parseLong(tf_parentUserID.getText().trim());
        String parentFirstName = tf_parentFirstName.getText().trim();
        String parentLastName = tf_parentLastName.getText().trim();

        try {
            UserApplyNewYoungSaverAccountBaseModel userApplyNewYoungSaverAccountBaseModel = (UserApplyNewYoungSaverAccountBaseModel) UserApplyNewAccountFactory.applyAccount(cb_accountTypeList.getSelectedItem().toString());
            userApplyNewYoungSaverAccountBaseModel.setFirstName(firstName);
            userApplyNewYoungSaverAccountBaseModel.setLastName(lastName);
            userApplyNewYoungSaverAccountBaseModel.setIdentityNum(identityNum);
            userApplyNewYoungSaverAccountBaseModel.setIdentityType(identityType);
            userApplyNewYoungSaverAccountBaseModel.setAccountType(accountType);
            userApplyNewYoungSaverAccountBaseModel.setCardType(cardType);
            userApplyNewYoungSaverAccountBaseModel.setBirthDate(birthDate);
            userApplyNewYoungSaverAccountBaseModel.setGender(gender);
            userApplyNewYoungSaverAccountBaseModel.setAddress(address);
            userApplyNewYoungSaverAccountBaseModel.setEmail(email);
            userApplyNewYoungSaverAccountBaseModel.setContactNum(contactNum);
            userApplyNewYoungSaverAccountBaseModel.setNewUserApply(newUserApply);
            userApplyNewYoungSaverAccountBaseModel.setParentUserId(parentUserId);
            userApplyNewYoungSaverAccountBaseModel.setParentFirstName(parentFirstName);
            userApplyNewYoungSaverAccountBaseModel.setParentLastName(parentLastName);

            CustomerApplyService.getInstance().applyYoungSaverAccountForNewUser(userApplyNewYoungSaverAccountBaseModel);
            JOptionPane.showMessageDialog(null,
                    "Young saver Account apply requested successful",
                    "Success Message",JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception E) {
            JOptionPane.showMessageDialog(null,
                    E.getMessage(),
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            return;
        }


    }

    public void run() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }


}
