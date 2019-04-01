package controller;

import service.impl.ATMService;
import view.ATMLoginView;
import view.ATMPINView;
import view.ATMWithdrawView;

import javax.swing.*;
import java.awt.event.ActionEvent;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class ATMController implements BaseController {
    private ATMWithdrawView view;
    private long cardNumber;


    public ATMController(ATMWithdrawView atmpinView, long cardNumber) {
        this.view = atmpinView;
        this.cardNumber = cardNumber;

    }

    @Override
    public void initialize() {
        this.run();
    }

    private void run() {
        this.view.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.view.setVisible(true);
        this.view.pack(); // resize
    }

    public void withdraw(ActionEvent e1) {
        double balance;
        try {
            balance = ATMService.getInstance().withdraw(cardNumber, Double.parseDouble(view.tf_amounts.getText()));
            view.tf_balance.setText(String.valueOf(balance));
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Fail to login due to " + e.getMessage(),
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return;
        }
    }

    public void backBtnPerformed(ActionEvent e) {
        this.view.dispose();
        new ATMLoginView().run();
    }
}
