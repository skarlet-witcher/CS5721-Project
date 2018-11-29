package controller;

import Const.UserLoginType;
import model.UserLoginRequestModel;
import service.impl.CustomerLoginService;
import util.JTextFieldLimit;
import util.RandomUtil;
import view.CustomerApplyAuthView;
import view.CustomerForgotUserIdView;
import view.CustomerLoginView;
import view.CustomerPINView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.util.Calendar;
import java.util.List;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class CustomerLoginController implements BaseController {
    private CustomerLoginView view;
    private UserLoginRequestModel userLoginRequestModel;
    private List<Integer> pinList;

    public CustomerLoginController(CustomerLoginView view) {
        this.view = view;
    }

    @Override
    public void initialize() {
        view.initComponents();
        initTextFieldsLimit();
        generateLoginField(generateRandomLoginType());
        this.run();
    }

    private void run() {
        view.setDefaultCloseOperation(EXIT_ON_CLOSE);
        view.setVisible(true);
        view.pack(); // resize
    }

    private int generateRandomLoginType() {
        // randomly generate one of the ways to login
        return RandomUtil.generateOneNum(1, 2);
    }

    private void generateLoginField(int loginType) {
        if (loginType == UserLoginType.CONTACT_NUMBER) {
            view.panel_contactNum.setVisible(true);
            view.panel_dob.setVisible(false);
            return;
        }
        if (loginType == UserLoginType.DATE_OF_BIRTH) {
            view.panel_contactNum.setVisible(false);
            view.panel_dob.setVisible(true);
        }

    }

    private void initTextFieldsLimit() {
        view.tf_userId.setDocument(new JTextFieldLimit(10));
        view.tf_contactNum.setDocument(new JTextFieldLimit(4));
        view.tf_day.setDocument(new JTextFieldLimit(2));
        view.tf_month.setDocument(new JTextFieldLimit(2));
        view.tf_year.setDocument(new JTextFieldLimit(4));

        view.tf_year.setText("YYYY");
        view.tf_month.setText("MM");
        view.tf_day.setText("DD");
    }

    public void tf_dayFocusGained(FocusEvent e) {
        view.tf_day.selectAll();
    }

    public void tf_monthFocusGained(FocusEvent e) {
        view.tf_month.selectAll();
    }

    public void tf_yearFocusGained(FocusEvent e) {
        view.tf_year.selectAll();
    }

    private Boolean validateUserIdField() {
        // useId validator
        if (view.tf_userId.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null,
                    "Please input your User ID",
                    "Error Message", JOptionPane.ERROR_MESSAGE);
            return false;

        }
        if (!view.tf_userId.getText().trim().matches("^[0-9]*$")) {
            JOptionPane.showMessageDialog(null,
                    "The user id should be numeric",
                    "Error Message", JOptionPane.ERROR_MESSAGE);
            view.tf_userId.grabFocus();
            return false;
        }
        return true;
    }

    private Boolean validateDateOfBirth() {
        return validateMonthField() && validateDayField() && validateYearField();
    }

    private Boolean validateYearField() {
        //  year of the date or birth validator
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        if (view.tf_year.getText().trim().length() <= 0) {
            JOptionPane.showMessageDialog(null,
                    "Please input your year of the date of birth",
                    "Error Message", JOptionPane.ERROR_MESSAGE);
            view.tf_year.grabFocus();
            return false;
        }
        if (!view.tf_year.getText().trim().matches("^[0-9]*$")) {
            JOptionPane.showMessageDialog(null,
                    "year of the date of brith should only contain numbers",
                    "Error Message", JOptionPane.ERROR_MESSAGE);
            view.tf_year.grabFocus();
            return false;
        }
        if (view.tf_year.getText().length() < 4) {
            JOptionPane.showMessageDialog(null,
                    "The year of date of birth should be four digits",
                    "Error Message", JOptionPane.ERROR_MESSAGE);
            view.tf_year.grabFocus();
            return false;
        }
        if (Integer.parseInt(view.tf_year.getText().trim()) > currentYear) {
            JOptionPane.showMessageDialog(null,
                    "The year of date of birth should be less or equal to current year",
                    "Error Message", JOptionPane.ERROR_MESSAGE);
            view.tf_year.grabFocus();
            return false;
        }
        return true;
    }

    private Boolean validateDayField() {
        // day of dob validator
        if (view.tf_day.getText().trim().length() <= 0) {
            JOptionPane.showMessageDialog(null,
                    "Please input the day of your date of birth",
                    "Error Message", JOptionPane.ERROR_MESSAGE);
            view.tf_day.grabFocus();
            return false;
        }
        if (!view.tf_day.getText().trim().matches("^[0-9]*$")) {
            JOptionPane.showMessageDialog(null,
                    "The day of the date of birth should be numeric",
                    "Error Message", JOptionPane.ERROR_MESSAGE);
            view.tf_day.grabFocus();
            return false;
        }
        if (Integer.parseInt(view.tf_day.getText().trim()) > 31 || Integer.parseInt(view.tf_day.getText().trim()) < 1) {
            JOptionPane.showMessageDialog(null,
                    "The range of day of the date of birth should be 1 to 31",
                    "Error Message", JOptionPane.ERROR_MESSAGE);
            view.tf_day.grabFocus();
            return false;
        }
        if (view.tf_day.getText().trim().length() == 1) {
            view.tf_day.setText("0" + view.tf_day.getText());
            return true;
        }
        return true;
    }

    private Boolean validateMonthField() {
        // month of dob validator
        if (view.tf_month.getText().trim().length() <= 0) {
            JOptionPane.showMessageDialog(null,
                    "Please input your month of your date of birth",
                    "Error Message", JOptionPane.ERROR_MESSAGE);
            view.tf_month.grabFocus();
            return false;
        }
        if (!view.tf_month.getText().trim().matches("^[0-9]*$")) {
            JOptionPane.showMessageDialog(null,
                    "The month of your date of birth should be numeric",
                    "Error Message", JOptionPane.ERROR_MESSAGE);
            view.tf_month.grabFocus();
            return false;
        }
        if (Integer.parseInt(view.tf_month.getText().trim()) > 12 || Integer.parseInt(view.tf_month.getText().trim()) < 1) {
            JOptionPane.showMessageDialog(null,
                    "The ranage of month of the date of birth should be 1 to 12",
                    "Error Message", JOptionPane.ERROR_MESSAGE);
            view.tf_month.grabFocus();
            return false;
        }
        if (view.tf_month.getText().trim().length() == 1) {
            view.tf_month.setText("0" + view.tf_month.getText());
            return true;
        }
        return true;
    }

    private Boolean validateContactNum() {
        // contact number validator
        if (view.tf_contactNum.getText().trim().length() <= 0) {
            JOptionPane.showMessageDialog(null,
                    "Please input your contact number",
                    "Error Message", JOptionPane.ERROR_MESSAGE);
            view.tf_contactNum.grabFocus();
            return false;
        }
        if (!view.tf_contactNum.getText().trim().matches("^[0-9]*$")) {
            JOptionPane.showMessageDialog(null,
                    "The contact number must be numeric.",
                    "Error Message", JOptionPane.ERROR_MESSAGE);
            view.tf_contactNum.grabFocus();
            return false;
        }
        return true;
    }

    public void btn_loginActionPerformed(ActionEvent event) {

        if (!validateUserIdField()) {
            return;
        }
        if (view.panel_dob.isVisible()) {
            if (!validateDateOfBirth()) {
                return;
            } else {
                try {
                    // login in with date of birth
                    this.userLoginRequestModel = new UserLoginRequestModel(Long.parseLong(view.tf_userId.getText().trim()),
                            Integer.parseInt(view.tf_day.getText()),
                            Integer.parseInt(view.tf_month.getText()),
                            Integer.parseInt(view.tf_year.getText()));
                    this.pinList = CustomerLoginService.getInstance().requestLoginUsingDOB(userLoginRequestModel);
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null,
                            "Please input valid date of birth or UserId due to " + e.getMessage(),
                            "Error Message", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
        }
        if (view.panel_contactNum.isVisible()) {
            if (!validateContactNum()) {
                return;
            }
            try {
                // login in with contactNum
                this.userLoginRequestModel = new UserLoginRequestModel(Long.parseLong(view.tf_userId.getText().trim()),
                        view.tf_contactNum.getText().trim());
                this.pinList = CustomerLoginService.getInstance().requestLoginUsingPhoneNum(userLoginRequestModel);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null,
                        "Please input valid contact number or User ID due to " + e.getMessage(),
                        "Error Message", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        view.dispose();
        new CustomerPINView(Long.parseLong(view.tf_userId.getText().trim()), this.pinList);
    }

    public void btn_forgotUserIdActionPerformed(ActionEvent e) {
        view.dispose();
        new CustomerForgotUserIdView();
    }

    public void btn_registerActionPerformed(ActionEvent e) {
        this.view.dispose();
        new CustomerApplyAuthView();
    }
}
