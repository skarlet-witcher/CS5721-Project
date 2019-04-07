package controller;

import service.impl.ATMService;
import view.*;

import javax.swing.*;
import java.awt.event.ActionEvent;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class PINController implements BaseController {
    private ATMPINView view;
    private long cardNumber;


    public PINController(ATMPINView atmpinView, long cardNumber) {
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

    public void loginBtnPerformed(ActionEvent e1) {
        double balance;
        try {
            balance = ATMService.getInstance().getBalance(cardNumber,view.textArea.getText());
            this.view.dispose();
            new ATMWithdrawView(cardNumber,balance).run();
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
