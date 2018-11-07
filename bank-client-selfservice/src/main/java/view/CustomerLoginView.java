/*
 * Created by JFormDesigner on Sun Oct 14 11:44:09 BST 2018
 */

package view;

import model.UserLoginRequestModel;
import net.miginfocom.swing.MigLayout;
import service.impl.CustomerLoginService;
import util.JTextFieldLimit;
import util.RandomUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @author xiangkai Tang
 */
public class CustomerLoginView extends JFrame {

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel lbl_title;
    private JLabel lbl_userId;
    private JTextField tf_userId;
    private JPanel panel_contactNum;
    private JLabel lbl_contactNum;
    private JTextField tf_contactNum;
    private JPanel panel_dob;
    private JLabel lbl_dob;
    private JTextField tf_day;
    private JLabel lbl_dob_mark1;
    private JTextField tf_month;
    private JLabel lbl_dob_mark2;
    private JTextField tf_year;
    private JButton btn_login;
    private JButton btn_forgotUserId;
    private JButton btn_register;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public CustomerLoginView() {
        initComponents();
        initTextFields();
        securityVerification(randomCheck());
        pack(); // resize
    }

    private int randomCheck() {
        // randomly generate one of the ways to login
        return RandomUtil.generateOneNum(1, 2);
    }

    private void securityVerification(int switcher) {

        if (switcher == 1) {
            // login using contactNum
            this.panel_contactNum.setVisible(true);
            this.panel_dob.setVisible(false);
        } else {
            // login using Date of birth
            this.panel_contactNum.setVisible(false);
            this.panel_dob.setVisible(true);
        }

    }

    private void initTextFields() {
        tf_userId.setDocument(new JTextFieldLimit(10));
        tf_contactNum.setDocument(new JTextFieldLimit(4));
        tf_day.setDocument(new JTextFieldLimit(2));
        tf_month.setDocument(new JTextFieldLimit(2));
        tf_year.setDocument(new JTextFieldLimit(4));

        tf_year.setText("YYYY");
        tf_month.setText("MM");
        tf_day.setText("DD");
    }

    private void tf_dayFocusGained(FocusEvent e) {
        tf_day.selectAll();
    }

    private void tf_monthFocusGained(FocusEvent e) {
        tf_month.selectAll();
    }

    private void tf_yearFocusGained(FocusEvent e) {
        tf_year.selectAll();
    }

    private void btn_loginActionPerformed(ActionEvent e) {
        // useId validator
        if(tf_userId.getText().length() <= 0) {
                JOptionPane.showMessageDialog(null,
                        "Please input your User ID",
                        "Error Message",JOptionPane.ERROR_MESSAGE);
                return;

        }
        if(!tf_userId.getText().trim().matches("^[0-9]*$")) {
            JOptionPane.showMessageDialog(null,
                    "The user id should be numeric",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            tf_userId.grabFocus();
            return;
        }

        if(panel_dob.isVisible()) {
            // date of birth validator

            // day of dob validator
            if(tf_day.getText().trim().length() <= 0) {
                JOptionPane.showMessageDialog(null,
                        "Please input the day of your date of birth",
                        "Error Message",JOptionPane.ERROR_MESSAGE);
                tf_day.grabFocus();
                return;
            }
            if(!tf_day.getText().trim().matches("^[0-9]*$")) {
                JOptionPane.showMessageDialog(null,
                        "The day of the date of birth should be numeric",
                        "Error Message",JOptionPane.ERROR_MESSAGE);
                tf_day.grabFocus();
                return;
            }
            if(Integer.parseInt(tf_day.getText().trim()) > 31 || Integer.parseInt(tf_day.getText().trim()) < 1) {
                JOptionPane.showMessageDialog(null,
                        "The range of day of the date of birth should be 1 to 31",
                        "Error Message",JOptionPane.ERROR_MESSAGE);
                tf_day.grabFocus();
                return;
            }
            if(tf_day.getText().trim().length() == 1) {
                tf_day.setText("0" + tf_day.getText());
            }

            // month of dob validator
            if(tf_month.getText().trim().length() <= 0) {
                JOptionPane.showMessageDialog(null,
                        "Please input your month of your date of birth",
                        "Error Message",JOptionPane.ERROR_MESSAGE);
                tf_month.grabFocus();
                return;
            }
            if(!tf_month.getText().trim().matches("^[0-9]*$")) {
                JOptionPane.showMessageDialog(null,
                        "The month of your date of birth should be numeric",
                        "Error Message",JOptionPane.ERROR_MESSAGE);
                tf_month.grabFocus();
                return;
            }
            if(Integer.parseInt(tf_month.getText().trim()) > 12 || Integer.parseInt(tf_month.getText().trim()) < 1) {
                JOptionPane.showMessageDialog(null,
                        "The ranage of month of the date of birth should be 1 to 12",
                        "Error Message",JOptionPane.ERROR_MESSAGE);
                tf_month.grabFocus();
                return;
            }
            if(tf_month.getText().trim().length() == 1) {
                tf_month.setText("0" + tf_month.getText());
            }

            //  year of the date or birth validator
            int currentYear = Calendar.getInstance().get(Calendar.YEAR);
            if(tf_year.getText().trim().length() <= 0) {
                JOptionPane.showMessageDialog(null,
                        "Please input your year of the date of birth",
                        "Error Message",JOptionPane.ERROR_MESSAGE);
                tf_year.grabFocus();
                return;
            } if(!tf_year.getText().trim().matches("^[0-9]*$")) {
                JOptionPane.showMessageDialog(null,
                        "year of the date of brith should only contain numbers",
                        "Error Message",JOptionPane.ERROR_MESSAGE);
                tf_year.grabFocus();
                return;
            }
            if(tf_year.getText().length() < 4) {
                JOptionPane.showMessageDialog(null,
                        "The year of date of birth should be four digits",
                        "Error Message",JOptionPane.ERROR_MESSAGE);
                tf_year.grabFocus();
                return;
            }
            if(Integer.parseInt(tf_year.getText().trim()) > currentYear) {
                JOptionPane.showMessageDialog(null,
                        "The year of date of birth should be less or equal to current year",
                        "Error Message",JOptionPane.ERROR_MESSAGE);
                tf_year.grabFocus();
                return;
            }

            Long userId = Long.parseLong(tf_userId.getText().trim());
            int day = Integer.parseInt(tf_day.getText());
            int month = Integer.parseInt(tf_month.getText());
            int year = Integer.parseInt(tf_year.getText());
            int pin1;
            int pin2;
            int pin3;
            List<Integer> PinDigits;
            try {
                // login in with date of birth
                UserLoginRequestModel userLoginRequestModel = new UserLoginRequestModel(userId, day, month, year);
                PinDigits = CustomerLoginService.getInstance().requestLoginUsingDOB(userLoginRequestModel);
                pin1 = PinDigits.get(0);
                pin2 = PinDigits.get(1);
                pin3 = PinDigits.get(2);
            } catch (Exception E) {
                JOptionPane.showMessageDialog(null,
                        "Please input valid date of birth or UserId",
                        "Error Message",JOptionPane.ERROR_MESSAGE);
                return;
            }
            this.dispose();
            new CustomerPINView(userId, pin1, pin2, pin3).run();
        }
        if(panel_contactNum.isVisible()) {
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

            Long userId = Long.parseLong(tf_userId.getText().trim());
            String phoneNumLast4 = tf_contactNum.getText().trim();
            int pin1;
            int pin2;
            int pin3;
            List<Integer> PinDigits;
            try {
                // login in with contactNum
                UserLoginRequestModel userLoginRequestModel = new UserLoginRequestModel(userId, phoneNumLast4);
                PinDigits = CustomerLoginService.getInstance().requestLoginUsingPhoneNum(userLoginRequestModel);
                pin1 = PinDigits.get(0);
                pin2 = PinDigits.get(1);
                pin3 = PinDigits.get(2);
            } catch (Exception E) {
                JOptionPane.showMessageDialog(null,
                        "Please input valid contact number or User ID due to " + E.getMessage(),
                        "Error Message",JOptionPane.ERROR_MESSAGE);
                return;
            }
            this.dispose();
            new CustomerPINView(userId, pin1, pin2, pin3).run();
        }


    }

    private void btn_forgotUserIdActionPerformed(ActionEvent e) {
        this.dispose();
        new CustomerForgotUserIdView().run();
    }

    private void btn_registerActionPerformed(ActionEvent e) {
        this.dispose();
        new CustomerApplyAuthView().run();
    }

    public void run() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void initComponents() {

        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        lbl_title = new JLabel();
        lbl_userId = new JLabel();
        tf_userId = new JTextField();
        panel_contactNum = new JPanel();
        lbl_contactNum = new JLabel();
        tf_contactNum = new JTextField();
        panel_dob = new JPanel();
        lbl_dob = new JLabel();
        tf_day = new JTextField();
        lbl_dob_mark1 = new JLabel();
        tf_month = new JTextField();
        lbl_dob_mark2 = new JLabel();
        tf_year = new JTextField();
        btn_login = new JButton();
        btn_forgotUserId = new JButton();
        btn_register = new JButton();

        //======== this ========
        setTitle("Cusotmer Secure Login");
        setMinimumSize(new Dimension(27, 35));
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[30:n,grow,fill]" +
            "[28,fill]0" +
            "[fill]" +
            "[fill]" +
            "[92,grow,fill]" +
            "[30:n,grow,fill]",
            // rows
            "[50:n]" +
            "[]" +
            "[fill]" +
            "[]" +
            "[]" +
            "[fill]" +
            "[15:n,grow,fill]" +
            "[]" +
            "[]" +
            "[30:n,grow]"));

        //---- lbl_title ----
        lbl_title.setText("Customer Bank System Login");
        lbl_title.setFont(new Font("Segoe UI", Font.PLAIN, 28));
        lbl_title.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lbl_title, "cell 2 0 3 1");

        //---- lbl_userId ----
        lbl_userId.setText("<html>Please enter your <strong>User ID</strong></html>");
        lbl_userId.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        contentPane.add(lbl_userId, "cell 2 2");

        //---- tf_userId ----
        tf_userId.setMinimumSize(new Dimension(90, 30));
        contentPane.add(tf_userId, "cell 4 2");

        //======== panel_contactNum ========
        {
            panel_contactNum.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]",
                // rows
                "[]" +
                "[]" +
                "[]"));

            //---- lbl_contactNum ----
            lbl_contactNum.setText("<html><strong>Last four digits</strong> of Contact Number</html>");
            lbl_contactNum.setFont(new Font("Segoe UI", Font.PLAIN, 16));
            lbl_contactNum.setMinimumSize(new Dimension(102, 15));
            panel_contactNum.add(lbl_contactNum, "cell 0 2 3 1");

            //---- tf_contactNum ----
            tf_contactNum.setMinimumSize(new Dimension(90, 30));
            panel_contactNum.add(tf_contactNum, "cell 3 2 9 1");
        }
        contentPane.add(panel_contactNum, "cell 2 4 3 1");

        //======== panel_dob ========
        {
            panel_dob.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]",
                // rows
                "[]" +
                "[]" +
                "[]"));

            //---- lbl_dob ----
            lbl_dob.setText("Date of Birth");
            lbl_dob.setFont(new Font("Segoe UI", Font.PLAIN, 20));
            panel_dob.add(lbl_dob, "cell 0 0");

            //---- tf_day ----
            tf_day.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    tf_dayFocusGained(e);
                }
            });
            panel_dob.add(tf_day, "cell 1 0");

            //---- lbl_dob_mark1 ----
            lbl_dob_mark1.setText("/");
            panel_dob.add(lbl_dob_mark1, "cell 2 0");

            //---- tf_month ----
            tf_month.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    tf_monthFocusGained(e);
                }
            });
            panel_dob.add(tf_month, "cell 3 0");

            //---- lbl_dob_mark2 ----
            lbl_dob_mark2.setText("/");
            panel_dob.add(lbl_dob_mark2, "cell 4 0");

            //---- tf_year ----
            tf_year.setMinimumSize(new Dimension(64, 30));
            tf_year.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    tf_yearFocusGained(e);
                }
            });
            panel_dob.add(tf_year, "cell 5 0");
        }
        contentPane.add(panel_dob, "cell 2 6 3 1");

        //---- btn_login ----
        btn_login.setText("Continue");
        btn_login.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        btn_login.addActionListener(e -> btn_loginActionPerformed(e));
        contentPane.add(btn_login, "cell 2 7 3 1");

        //---- btn_forgotUserId ----
        btn_forgotUserId.setText("Forgot User ID ?");
        btn_forgotUserId.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        btn_forgotUserId.setMinimumSize(null);
        btn_forgotUserId.setPreferredSize(null);
        btn_forgotUserId.setMaximumSize(null);
        btn_forgotUserId.addActionListener(e -> btn_forgotUserIdActionPerformed(e));
        contentPane.add(btn_forgotUserId, "cell 2 8 3 1");

        //---- btn_register ----
        btn_register.setText("Apply now !");
        btn_register.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        btn_register.setPreferredSize(null);
        btn_register.setMinimumSize(null);
        btn_register.setMaximumSize(null);
        btn_register.addActionListener(e -> btn_registerActionPerformed(e));
        contentPane.add(btn_register, "cell 2 8 3 1");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //  /// GEN-END:initComponents

    }
}

