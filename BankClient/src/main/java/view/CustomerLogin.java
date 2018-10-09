package view;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerLogin {

    private JFrame frmCustomerLogin;
    private JTextField tf_accountNum;
    private JTextField textField_1;

    /**
     * Create the application.
     */
    public CustomerLogin() {
        initialize();
    }

    /**
     * Launch the application.
     */

    public void run() {
        try {
            new CustomerLogin().frmCustomerLogin.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmCustomerLogin = new JFrame();
        frmCustomerLogin.setTitle("Customer Login");
        frmCustomerLogin.setBounds(100, 100, 595, 503);
        frmCustomerLogin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frmCustomerLogin.getContentPane().setLayout(null);

        JLabel lblAccountNumber = new JLabel("Account number:");
        lblAccountNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblAccountNumber.setBounds(58, 97, 163, 32);
        frmCustomerLogin.getContentPane().add(lblAccountNumber);

        tf_accountNum = new JTextField();
        tf_accountNum.setBounds(231, 106, 192, 22);
        frmCustomerLogin.getContentPane().add(tf_accountNum);
        tf_accountNum.setColumns(10);

        JLabel lblPassword = new JLabel("Password:\r\n");
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblPassword.setBounds(58, 181, 163, 32);
        frmCustomerLogin.getContentPane().add(lblPassword);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(231, 191, 192, 22);
        frmCustomerLogin.getContentPane().add(textField_1);

        JButton btnNewButton = new JButton("Login");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmCustomerLogin.dispose();
                new CustomerWindow(tf_accountNum.getText().trim()).run();
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnNewButton.setBounds(176, 286, 225, 57);
        frmCustomerLogin.getContentPane().add(btnNewButton);

        JButton btnBackToMain = new JButton("Back to Main menu");
        btnBackToMain.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmCustomerLogin.dispose();
                new MainMenu().run();
            }
        });
        btnBackToMain.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnBackToMain.setBounds(176, 381, 225, 57);
        frmCustomerLogin.getContentPane().add(btnBackToMain);
    }

}
