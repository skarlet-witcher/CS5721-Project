package controller;

import model.UserModel;
import model.UserPayeeModel;
import service.impl.CustomerPayeeService;
import util.JTextFieldLimit;
import view.CustomerAddPayeeView;
import view.CustomerMainView;

import javax.swing.*;
import java.awt.event.ActionEvent;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class CustomerAddPayeeController implements BaseController {
    private CustomerAddPayeeView view;
    private CustomerMainView customerMainView;
    private UserModel userModel;

    public CustomerAddPayeeController(CustomerAddPayeeView view, CustomerMainView customerMainView, UserModel userModel) {
        this.view = view;
        this.customerMainView = customerMainView;
        this.userModel = userModel;

    }

    @Override
    public void initialize() {
        this.view.initComponents();
        initFields();
        run();
    }

    public void run() {
        this.view.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.view.setVisible(true);
        this.view.pack(); // resize
    }

    private void initFields() {
        this.view.tf_IBAN.setDocument(new JTextFieldLimit(34));
        this.view. pf_pin.setDocument(new JTextFieldLimit(6));
    }

    public void btn_backActionPerformed(ActionEvent e) {
        this.view.dispose();
        new CustomerMainView(userModel);
    }

    public void btn_addActionPerformed(ActionEvent e) {
        // payee name validator
        if(this.view.tf_payeeName.getText().trim().length() <= 0) {
            JOptionPane.showMessageDialog(null,
                    "Please input your payee name",
                    "Error Message", JOptionPane.ERROR_MESSAGE);
            this.view.tf_payeeName.grabFocus();
            return;
        } if(!this.view.tf_payeeName.getText().trim().matches("^[a-zA-Z]+$")) {
            JOptionPane.showMessageDialog(null,
                    "Payee name should only contain letters",
                    "Error Message", JOptionPane.ERROR_MESSAGE);
            this.view.tf_payeeName.grabFocus();
            return;
        }
        // IBAN validator
        if(this.view.tf_IBAN.getText().trim().length() <= 0) {
            JOptionPane.showMessageDialog(null,
                    "Please input your payee's IBAN",
                    "Error Message", JOptionPane.ERROR_MESSAGE);
            this.view.tf_IBAN.grabFocus();
            return;
        } if(!this.view.tf_IBAN.getText().trim().matches("^[0-9A-Z]+$")) {
            JOptionPane.showMessageDialog(null,
                    "IBAN should only contain capital letters and digits",
                    "Error Message", JOptionPane.ERROR_MESSAGE);
            this.view.tf_IBAN.grabFocus();
            return;
        }
        // pin validator
        if(this.view.pf_pin.getPassword().length <=0) {
            JOptionPane.showMessageDialog(null,
                    "Please input your PIN",
                    "Error Message", JOptionPane.ERROR_MESSAGE);
            this.view.pf_pin.grabFocus();
            return;
        }
        // add payee service
        UserPayeeModel userPayeeModel = new UserPayeeModel();
        userPayeeModel.setUserId(this.userModel.getId());
        userPayeeModel.setIban(this.view.tf_IBAN.getText().trim());
        userPayeeModel.setName(this.view.tf_payeeName.getText().trim());
        String pin = new String(this.view.pf_pin.getPassword());
        try {
            CustomerPayeeService.getInstance().addPayee(userPayeeModel, pin);
            JOptionPane.showMessageDialog(null,
                    "add payee successful",
                    "Info Message", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception E) {
            JOptionPane.showMessageDialog(null,
                    "Fail to add payee, due to " + E.getMessage() + "please contact with admin",
                    "Error Message", JOptionPane.ERROR_MESSAGE);
            return;
        }
        this.view.dispose();
        new CustomerMainView(userModel);
    }
}
