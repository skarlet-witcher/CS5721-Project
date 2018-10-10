package view;


import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminWindow {

    private JFrame frmStaffWindow;
    private JTextField tf_modify_accountNum;
    private JTextField textField_6;
    private JTextField textField_7;
    private JTextField textField_8;
    private JTextField textField_9;
    private JTextField textField_10;
    private JTextField textField_11;

    /**
     * Create the application.
     */
    public AdminWindow() {
        initialize();
    }

    public void run() {
        try {
            this.frmStaffWindow.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmStaffWindow = new JFrame();
        frmStaffWindow.setTitle("Admin Window");
        frmStaffWindow.setBounds(100, 100, 965, 686);
        frmStaffWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel lblWelcomeToStaff = new JLabel("Welcome to Admin Window");
        lblWelcomeToStaff.setFont(new Font("Tahoma", Font.PLAIN, 25));

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));

        JPanel panel_3 = new JPanel();
        panel_3.setLayout(null);
        panel_3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));

        textField_6 = new JTextField();
        textField_6.setColumns(10);
        textField_6.setBounds(113, 33, 150, 20);
        panel_3.add(textField_6);

        JLabel lblFirstName = new JLabel("First name: \r\n");
        lblFirstName.setBounds(10, 36, 96, 14);
        panel_3.add(lblFirstName);

        JButton btnAddAnAccount = new JButton("Add an account");
        btnAddAnAccount.setBounds(76, 230, 135, 38);
        panel_3.add(btnAddAnAccount);

        textField_7 = new JTextField();
        textField_7.setColumns(10);
        textField_7.setBounds(113, 64, 150, 20);
        panel_3.add(textField_7);

        JLabel lblLastName = new JLabel("Last name: \r\n");
        lblLastName.setBounds(10, 71, 96, 20);
        panel_3.add(lblLastName);

        JLabel lblContactNumber = new JLabel("Contact number:");
        lblContactNumber.setBounds(10, 102, 104, 20);
        panel_3.add(lblContactNumber);

        textField_8 = new JTextField();
        textField_8.setColumns(10);
        textField_8.setBounds(113, 102, 150, 20);
        panel_3.add(textField_8);

        JButton btnNewButton_2 = new JButton("Sign out");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmStaffWindow.dispose();
                new MainMenu().run();
            }
        });
        btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        GroupLayout groupLayout = new GroupLayout(frmStaffWindow.getContentPane());
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(Alignment.TRAILING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(352)
                                .addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(385, Short.MAX_VALUE))
                        .addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
                                .addGap(78)
                                .addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)
                                .addGap(122)
                                .addComponent(panel, GroupLayout.PREFERRED_SIZE, 296, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(169, Short.MAX_VALUE))
                        .addGroup(groupLayout.createSequentialGroup()
                                .addContainerGap(316, Short.MAX_VALUE)
                                .addComponent(lblWelcomeToStaff, GroupLayout.PREFERRED_SIZE, 343, GroupLayout.PREFERRED_SIZE)
                                .addGap(291))
        );
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(Alignment.TRAILING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(79)
                                .addComponent(lblWelcomeToStaff, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                                .addGap(32)
                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
                                        .addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE))
                                .addGap(60)
                                .addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addGap(33))
        );

        JButton btnReset = new JButton("Reset\r\n\r\n");
        btnReset.setBounds(76, 279, 135, 38);
        panel_3.add(btnReset);

        JLabel lblHomeAddress = new JLabel("<html>Home address <br/> Line 1: </html>");
        lblHomeAddress.setBounds(10, 134, 96, 28);
        panel_3.add(lblHomeAddress);

        textField_9 = new JTextField();
        textField_9.setColumns(10);
        textField_9.setBounds(113, 131, 150, 20);
        panel_3.add(textField_9);

        textField_10 = new JTextField();
        textField_10.setColumns(10);
        textField_10.setBounds(113, 165, 150, 20);
        panel_3.add(textField_10);

        textField_11 = new JTextField();
        textField_11.setColumns(10);
        textField_11.setBounds(113, 199, 150, 20);
        panel_3.add(textField_11);

        JLabel lblLine = new JLabel("Line 2:");
        lblLine.setBounds(10, 168, 96, 20);
        panel_3.add(lblLine);

        JLabel lblLine_1 = new JLabel("Line 3:");
        lblLine_1.setBounds(10, 199, 96, 20);
        panel_3.add(lblLine_1);

        JLabel lblAddAnAccount = new JLabel("Add an account");
        lblAddAnAccount.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblAddAnAccount.setBounds(80, 8, 145, 14);
        panel_3.add(lblAddAnAccount);
        panel.setLayout(null);

        tf_modify_accountNum = new JTextField();
        tf_modify_accountNum.setBounds(112, 80, 96, 20);
        panel.add(tf_modify_accountNum);
        tf_modify_accountNum.setColumns(10);

        JLabel lblNewLabel = new JLabel("Account Number: \r\n");
        lblNewLabel.setBounds(10, 83, 104, 14);
        panel.add(lblNewLabel);

        JButton btnNewButton = new JButton("Reset\r\n");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
        btnNewButton.setBounds(222, 79, 64, 23);
        panel.add(btnNewButton);

        JButton btnRemoveAnAccount = new JButton("Remove an account");
        btnRemoveAnAccount.setBounds(73, 200, 160, 38);
        panel.add(btnRemoveAnAccount);

        JLabel lblRemoveAnAccount = new JLabel("Remove an account");
        lblRemoveAnAccount.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblRemoveAnAccount.setBounds(88, 24, 145, 14);
        panel.add(lblRemoveAnAccount);
        frmStaffWindow.getContentPane().setLayout(groupLayout);
    }
}
