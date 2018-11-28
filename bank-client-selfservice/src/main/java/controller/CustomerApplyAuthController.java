package controller;

import Const.UserType;
import model.UserModel;
import service.impl.CustomerApplyService;
import util.JTextFieldLimit;
import view.CustomerApplyAuthView;
import view.CustomerApplyView;
import view.CustomerLoginView;

import javax.swing.*;
import java.awt.event.ActionEvent;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class CustomerApplyAuthController implements BaseController {
    private CustomerApplyAuthView view;

    public CustomerApplyAuthController(CustomerApplyAuthView view) {
        this.view = view;
    }

    @Override
    public void initialize() {
        this.view.initComponents();
        initTextField();
        resetAllPanel();
        run();
    }

    public void run() {
        this.view.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.view.setVisible(true);
        this.view.pack(); // resize
    }

    private void resetAllPanel() {
        this.view.existingCustomerPanel.setVisible(false);
        this.view.noneCustomerPanel.setVisible(false);
    }

    private void initTextField() {
        this.view.tf_userId.setDocument(new JTextFieldLimit(10));
        this.view.tf_firstName.setDocument(new JTextFieldLimit(20));
        this.view.tf_lastName.setDocument(new JTextFieldLimit(20));
        this.view.tf_identityNum.setDocument(new JTextFieldLimit(15));
    }

    public void btn_backActionPerformed(ActionEvent e) {
        this.view.dispose();
        new CustomerLoginView();
    }

    public void cb_isExistingActionPerformed(ActionEvent e) {
        // choose the type of user
        if(this.view.cb_isExisting.getSelectedIndex() == 0) {
            resetAllPanel();
            this.view.pack();
        }
        if(this.view.cb_isExisting.getSelectedIndex() == 1) {
            resetAllPanel();
            this.view.existingCustomerPanel.setVisible(true);
            this.view.pack();
        }
        if(this.view.cb_isExisting.getSelectedIndex() == 2) {
            resetAllPanel();
            this.view.noneCustomerPanel.setVisible(true);
            this.view.pack();
        }
    }

    public void btn_none_nextActionPerformed(ActionEvent e) {
        // non-existing user
        this.view.dispose();
        new CustomerApplyView();
    }

    public void btn_customer_nextActionPerformed(ActionEvent e) {
        // existing user
        if(this.view.cb_isExisting.getSelectedIndex() == 1) {
            // UserId validator
            if(this.view.tf_userId.getText().trim().length() <= 0) {
                JOptionPane.showMessageDialog(null,
                        "Please input UserId",
                        "Error Message", JOptionPane.ERROR_MESSAGE);
                this.view.tf_userId.grabFocus();
                return;
            }
            if(this.view.tf_userId.getText().trim().length() != 10) {
                JOptionPane.showMessageDialog(null,
                        "User id must be 10 digits",
                        "Error Message", JOptionPane.ERROR_MESSAGE);
                this.view.tf_userId.grabFocus();
                return;
            }
            if(!this.view.tf_userId.getText().trim().matches("^[0-9]*$")) {
                JOptionPane.showMessageDialog(null,
                        "User id should be numeric",
                        "Error Message",JOptionPane.ERROR_MESSAGE);
                this.view.tf_userId.grabFocus();
                return;
            }

            // First Name validator
            if(this.view.tf_firstName.getText().trim().length() <= 0) {
                JOptionPane.showMessageDialog(null,
                        "Please input your first name",
                        "Error Message", JOptionPane.ERROR_MESSAGE);
                this.view.tf_firstName.grabFocus();
                return;
            } if(!this.view.tf_firstName.getText().trim().matches("^[a-zA-Z]+$")) {
                JOptionPane.showMessageDialog(null,
                        "First name should only contain characters",
                        "Error Message", JOptionPane.ERROR_MESSAGE);
                this.view.tf_firstName.grabFocus();
                return;
            }

            // Last name validator
            if(this.view.tf_lastName.getText().trim().length() <= 0) {
                JOptionPane.showMessageDialog(null,
                        "Please input your last name",
                        "Error Message", JOptionPane.ERROR_MESSAGE);
                this.view.tf_lastName.grabFocus();
                return;
            } if(!this.view.tf_lastName.getText().trim().matches("^[a-zA-Z]+$")) {
                JOptionPane.showMessageDialog(null,
                        "First name should only contain characters",
                        "Error Message", JOptionPane.ERROR_MESSAGE);
                this.view.tf_lastName.grabFocus();
                return;
            }

            // identity type validator
            if(this.view.cb_identityTypeList.getSelectedIndex() <= 0) {
                JOptionPane.showMessageDialog(null,
                        "Please select your identity type",
                        "Error Message",JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Identity number validator
            if(this.view.tf_identityNum.getText().trim().length() <= 0) {
                JOptionPane.showMessageDialog(null,
                        "Please input your identity number",
                        "Error Message",JOptionPane.ERROR_MESSAGE);
                this.view.tf_identityNum.grabFocus();
                return;
            }
            if(!this.view.tf_identityNum.getText().trim().matches("^[a-zA-Z0-9]*$")) {
                JOptionPane.showMessageDialog(null,
                        "Identity number should only contain numbers and letters",
                        "Error Message",JOptionPane.ERROR_MESSAGE);
                this.view.tf_identityNum.grabFocus();
                return;
            }
        }

        Long userId = Long.parseLong(this.view.tf_userId.getText().trim());
        String firstName = this.view.tf_firstName.getText().trim();
        String lastName = this.view.tf_lastName.getText().trim();
        int identityType = this.view.cb_identityTypeList.getSelectedIndex();
        String identityNum = this.view.tf_identityNum.getText().trim();

        UserModel userModel = new UserModel();
        userModel.setUserId(userId);
        userModel.setFirstName(firstName);
        userModel.setLastName(lastName);

        try {
            CustomerApplyService.getInstance().checkExistingUserBeforeApply(userModel);

        } catch (Exception E) {
            JOptionPane.showMessageDialog(null,
                    E.getMessage(),
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            E.printStackTrace();
            return;
        }
        this.view.dispose();
        new CustomerApplyView(userId, identityType, identityNum, UserType.EXISTING_USER);
    }
}
