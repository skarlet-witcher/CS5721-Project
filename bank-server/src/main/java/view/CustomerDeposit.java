package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerDeposit {

    private JFrame frame;
    private String accountNo;
    private JTextField textField;
    private JTextField textField_1;

    /**
     * Create the application.
     */
    public CustomerDeposit(String accountNo) {
        initialize();
        this.accountNo = accountNo;
    }

    /**
     * Launch the application.
     */
    public void run() {
        try {
            this.frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 508, 474);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel label = new JLabel("Account number: ");
        label.setFont(new Font("Tahoma", Font.PLAIN, 20));
        label.setBounds(41, 42, 178, 43);
        frame.getContentPane().add(label);

        textField = new JTextField();
        textField.setText(accountNo);
        textField.setEditable(false);
        textField.setColumns(10);
        textField.setBounds(207, 50, 178, 35);
        frame.getContentPane().add(textField);

        JLabel label_1 = new JLabel("Money Amounts: ");
        label_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        label_1.setBounds(41, 103, 156, 43);
        frame.getContentPane().add(label_1);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(207, 111, 178, 35);
        frame.getContentPane().add(textField_1);

        JButton btnDeposit = new JButton("Deposit");
        btnDeposit.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnDeposit.setBounds(157, 202, 170, 57);
        frame.getContentPane().add(btnDeposit);

        JButton button_1 = new JButton("Back");
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new CustomerWindow(accountNo).run();
            }
        });
        button_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        button_1.setBounds(157, 289, 170, 57);
        frame.getContentPane().add(button_1);
    }
}
