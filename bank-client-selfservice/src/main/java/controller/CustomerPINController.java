package controller;

import model.UserLoginPINModel;
import model.UserModel;
import rpc.UserLoginReply;
import service.impl.CustomerLoginService;
import util.JTextFieldLimit;
import util.KeyPadGenerator;
import util.TimestampConvertHelper;
import view.CustomerForgotPINView;
import view.CustomerLoginView;
import view.CustomerMainView;
import view.CustomerPINView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class CustomerPINController implements BaseController {
    private CustomerPINView view;
    List<JPasswordField> passwordFieldsList;
    List<Integer> pinDigitList;
    List<Integer> pinList;
    private UserModel userModel;

    public CustomerPINController(CustomerPINView view, Long userId, List<Integer> pinList) {
        this.view = view;
        this.userModel = new UserModel(userId);
        this.pinList = pinList;
        this.passwordFieldsList = new ArrayList<>();
        this.pinDigitList = new ArrayList<>();
    }

    @Override
    public void initialize() {
        this.view.initComponents();
        generateKeyPad();
        generatePINFields(this.pinList.get(0), this.pinList.get(1), this.pinList.get(2));
        this.run();
    }

    private void run() {
        this.view.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.view.setVisible(true);
        this.view.pack(); // resize
    }
    private JPasswordField checkEmptyPasswordField() {
        JPasswordField result = null;
        for (int i = 0; i < 3; i++) {
            if (passwordFieldsList.get(i).getPassword().length <= 0) {
                result = passwordFieldsList.get(i);
                break;
            }
        }
        return result;
    }

    private JPasswordField checkInputtedPasswordField() {
        JPasswordField result = null;
        for(int i = 2; i >= 0; i--) {
            if(passwordFieldsList.get(i).getPassword().length >0) {
                result = passwordFieldsList.get(i);
                break;
            }
        }
        return result;
    }

    private void inputPIN(String str) {
        if(checkEmptyPasswordField()== null) {
            return;
        } else {
            checkEmptyPasswordField().setText(str);
        }

    }

    private void backSpacePIN() {
        if(checkInputtedPasswordField()== null) return;
        checkInputtedPasswordField().setText("");
    }

    private void generatePasswordField() {
        JPasswordField pf = new JPasswordField();
        pf.setMinimumSize(new Dimension(20,20));
        pf.setDocument(new JTextFieldLimit(1));
        pf.setEditable(false);
        this.view.getContentPane().add(pf, "cell 2 0");
        passwordFieldsList.add(pf);
    }

    private void generateAsterisk() {
        JLabel lbl = new JLabel("*");
        this.view.getContentPane().add(lbl, "cell 2 0");
    }

    private void generatePINFields(int digit_1, int digit_2, int digit_3) {
        for(int i = 1; i <= 6; i++) {
            if( i == digit_1 || i == digit_2 || i == digit_3) {
                generatePasswordField();
            } else {
                generateAsterisk();
            }
        }
        pinDigitList.add(digit_1);
        pinDigitList.add(digit_2);
        pinDigitList.add(digit_3);
        this.view.pack();
    }

    private void generateKeyPad() {
        List<Integer> keyPadList = KeyPadGenerator.getInstance().getKeyPadArr();

        this.view.btn_1.setText(keyPadList.get(0).toString());
        this.view.btn_2.setText(keyPadList.get(1).toString());
        this.view.btn_3.setText(keyPadList.get(2).toString());
        this.view.btn_4.setText(keyPadList.get(3).toString());
        this.view.btn_5.setText(keyPadList.get(4).toString());
        this.view.btn_6.setText(keyPadList.get(5).toString());
        this.view.btn_7.setText(keyPadList.get(6).toString());
        this.view.btn_8.setText(keyPadList.get(7).toString());
        this.view.btn_9.setText(keyPadList.get(8).toString());
        this.view.btn_10.setText(keyPadList.get(9).toString());
    }

    private Boolean validateBeforeLogin() {
        for(JPasswordField pwdField: passwordFieldsList) {
            if(pwdField.getPassword().length <= 0) {
                JOptionPane.showMessageDialog(null,
                        "Please input your PIN",
                        "Error Message", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }

    private void initCustomerMainView(UserLoginReply userLoginReply) {
        String lastLoginTime = TimestampConvertHelper.rpcToMysql(userLoginReply.getLastLoginTime()).toString();
        lastLoginTime = lastLoginTime.substring(0, TimestampConvertHelper.rpcToMysql(userLoginReply.getLastLoginTime()).toString().indexOf('.'));

        userModel.setLastLoginTime(Timestamp.valueOf(lastLoginTime));
        userModel.setId(userLoginReply.getUserPk());
        userModel.setFirstName(userLoginReply.getFirstName().trim());

        this.view.dispose();
        new CustomerMainView(userModel);
    }

    private UserLoginPINModel initUserLoginPINModel(List<Integer> digitList) {
        UserLoginPINModel userLoginPINModel = new UserLoginPINModel();
        int i = 0;
        for(int digit : digitList) {

            JPasswordField temp = passwordFieldsList.get(i);
            int pwd = Integer.parseInt(new String(temp.getPassword()));
            switch (digit) {
                case 1: userLoginPINModel.setPin1(pwd); break;
                case 2: userLoginPINModel.setPin2(pwd); break;
                case 3: userLoginPINModel.setPin3(pwd); break;
                case 4: userLoginPINModel.setPin4(pwd); break;
                case 5: userLoginPINModel.setPin5(pwd); break;
                case 6: userLoginPINModel.setPin6(pwd); break;
            }
            i++;
        }
        userLoginPINModel.setUserId(this.userModel.getUserId());
        return userLoginPINModel;
    }

    public void btn_1ActionPerformed(ActionEvent e) {
        inputPIN(this.view.btn_1.getText());
    }

    public void btn_2ActionPerformed(ActionEvent e) {
        inputPIN(this.view.btn_2.getText());
    }

    public void btn_3ActionPerformed(ActionEvent e) {
        inputPIN(this.view.btn_3.getText());
    }

    public void btn_4ActionPerformed(ActionEvent e) {
        inputPIN(this.view.btn_4.getText());
    }

    public void btn_5ActionPerformed(ActionEvent e) {
        inputPIN(this.view.btn_5.getText());
    }

    public void btn_6ActionPerformed(ActionEvent e) {
        inputPIN(this.view.btn_6.getText());
    }

    public void btn_7ActionPerformed(ActionEvent e) {
        inputPIN(this.view.btn_7.getText());
    }

    public void btn_8ActionPerformed(ActionEvent e) {
        inputPIN(this.view.btn_8.getText());
    }

    public void btn_9ActionPerformed(ActionEvent e) {
        inputPIN(this.view.btn_9.getText());
    }

    public void btn_10ActionPerformed(ActionEvent e) {
        inputPIN(this.view.btn_10.getText());
    }

    public void btn_backSpaceActionPerformed(ActionEvent e) {
        backSpacePIN();
    }

    public void btn_confirmActionPerformed(ActionEvent e1) {
        UserLoginReply userLoginReply;
        if(!validateBeforeLogin()) return;
        try {
            userLoginReply = CustomerLoginService.getInstance().requestLoginUsingPIN(initUserLoginPINModel(pinDigitList));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Fail to login due to " + e.getMessage(),
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return;
        }
        initCustomerMainView(userLoginReply);
    }

    public void btn_backActionPerformed(ActionEvent e) {
        this.view.dispose();
        new CustomerLoginView();
    }

    public void btn_forgotPINActionPerformed(ActionEvent e) {
        this.view.dispose();
        new CustomerForgotPINView(this.userModel.getUserId());
    }
}
