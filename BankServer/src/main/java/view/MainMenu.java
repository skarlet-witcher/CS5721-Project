package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu {

    private JFrame frame;


    /**
     * Create the application.
     */
    public MainMenu() {
        initialize();
    }

    public void run() {
        try {
            this.frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public JFrame getFrame() {
        return frame;
    }


    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 800, 642);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JButton btnNewButton = new JButton("Customer Portal");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new CustomerLogin().run();
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnNewButton.setBounds(85, 274, 229, 69);
        frame.getContentPane().add(btnNewButton);

        JButton btnImAStaff = new JButton("Admin Portal\r\n\r\n");
        btnImAStaff.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new AdminLogin().run();
            }
        });
        btnImAStaff.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnImAStaff.setBounds(478, 274, 229, 69);
        frame.getContentPane().add(btnImAStaff);

        JLabel lblFinancialBankAccount = new JLabel("Welcome Financial Bank Account System!");
        lblFinancialBankAccount.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblFinancialBankAccount.setBounds(137, 110, 516, 51);
        frame.getContentPane().add(lblFinancialBankAccount);
    }
}
