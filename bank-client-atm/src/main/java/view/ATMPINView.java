package view;

import controller.PINController;

import javax.swing.*;
import java.awt.*;

public class ATMPINView extends JFrame {
    private long cardNumber;
    public JButton btn_Login;
    public JButton btn_Back;
    public JTextArea textArea;
    public JLabel lbl_PIN;
    private PINController PINController;


    public ATMPINView(long cardNumber) {
        this.cardNumber = cardNumber;
        PINController = new PINController(this, cardNumber);
        PINController.initialize();
    }

    public void initComponents() {
        lbl_PIN = new JLabel();
        btn_Back = new JButton();
        textArea = new JTextArea();
        btn_Login = new JButton();
        setTitle("ATM PIN View");
        Container contentPane = getContentPane();
        GridBagLayout gridBagLayout = new GridBagLayout();
        contentPane.setLayout(gridBagLayout);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        contentPane.add(lbl_PIN, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        contentPane.add(textArea, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        contentPane.add(btn_Login, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        contentPane.add(btn_Back, gbc);

        lbl_PIN.setText("PIN: ");
        btn_Back.setText("Back");
        btn_Login.setText("Login");
        pack();
        setLocationRelativeTo(getOwner());

        //----------Login btn---
        btn_Login.addActionListener(e -> PINController.loginBtnPerformed(e));
        btn_Back.addActionListener(e -> PINController.backBtnPerformed(e));
    }

    public void run() {
        initComponents();
        this.setSize(300,200);
        this.setPreferredSize(getSize());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
