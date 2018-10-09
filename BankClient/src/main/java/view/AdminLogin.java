package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminLogin {

    private JFrame frmStaffLogin;
    private JTextField tf_staffId;
    private JTextField textField_1;

    /**
     * Create the application.
     */
    public AdminLogin() {
        initialize();
    }

    /**
     * Launch the application.
     */
    public void run() {
        try {
            this.frmStaffLogin.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmStaffLogin = new JFrame();
        frmStaffLogin.setTitle("Staff Login");
        frmStaffLogin.setBounds(100, 100, 565, 582);
        frmStaffLogin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frmStaffLogin.getContentPane().setLayout(null);

        JLabel lblStaffId = new JLabel("Admin Id:");
        lblStaffId.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblStaffId.setBounds(81, 99, 163, 32);
        frmStaffLogin.getContentPane().add(lblStaffId);

        tf_staffId = new JTextField();
        tf_staffId.setColumns(10);
        tf_staffId.setBounds(254, 108, 192, 22);
        frmStaffLogin.getContentPane().add(tf_staffId);

        JLabel label_1 = new JLabel("Password:\r\n");
        label_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        label_1.setBounds(81, 183, 163, 32);
        frmStaffLogin.getContentPane().add(label_1);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(254, 193, 192, 22);
        frmStaffLogin.getContentPane().add(textField_1);

        JButton button = new JButton("Login");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmStaffLogin.dispose();
                new AdminWindow().run();
            }
        });
        button.setFont(new Font("Tahoma", Font.PLAIN, 20));
        button.setBounds(199, 288, 225, 57);
        frmStaffLogin.getContentPane().add(button);

        JButton button_1 = new JButton("Back to Main menu");
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmStaffLogin.dispose();
                new MainMenu().run();
            }
        });
        button_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        button_1.setBounds(199, 383, 225, 57);
        frmStaffLogin.getContentPane().add(button_1);
    }

}
