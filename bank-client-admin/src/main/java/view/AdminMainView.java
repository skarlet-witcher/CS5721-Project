/*
 * Created by JFormDesigner on Mon Oct 15 22:30:55 BST 2018
 */

package view;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author xiangkai22
 */
public class AdminMainView extends JFrame {
    public AdminMainView() {
        initComponents();
    }

    private void btn_signoutActionPerformed(ActionEvent e) {
        this.dispose();
        new AdminLoginView().run();
    }

    public void run() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        tabbedPane1 = new JTabbedPane();
        addStaffPanel = new JPanel();
        lbl_pwd = new JLabel();
        pf_pwd = new JPasswordField();
        lbl_confirmPwd = new JLabel();
        pf_confirmpwd = new JPasswordField();
        lbl_firstName = new JLabel();
        tf_firstName = new JTextField();
        lbl_lastName = new JLabel();
        tf_lastName = new JTextField();
        btn_confirm = new JButton();
        btn_reset = new JButton();
        removeStaffPanel = new JPanel();
        lbl_staffId = new JLabel();
        tf_staffId = new JTextField();
        btn_remove = new JButton();
        modifyEmailPanel = new JPanel();
        lbl_emailHost = new JLabel();
        tf_emailHost = new JTextField();
        lbl_emailPort = new JLabel();
        tf_emailPort = new JTextField();
        lbl_email = new JLabel();
        tf_email = new JTextField();
        lbl_emailPwd = new JLabel();
        pf_emailPwd = new JPasswordField();
        lbl_emailConfirmPwd = new JLabel();
        pf_emailConfirmPwd = new JPasswordField();
        button4 = new JButton();
        btn_signout = new JButton();

        //======== this ========
        setTitle("Admin Main View");
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[fill]" +
            "[fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //======== tabbedPane1 ========
        {
            tabbedPane1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
            tabbedPane1.setMinimumSize(new Dimension(500, 411));

            //======== addStaffPanel ========
            {
                addStaffPanel.setLayout(new MigLayout(
                    "hidemode 3",
                    // columns
                    "[100:n,fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[100:n,fill]",
                    // rows
                    "[50:n]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[50:n]"));

                //---- lbl_pwd ----
                lbl_pwd.setText("Password");
                lbl_pwd.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                addStaffPanel.add(lbl_pwd, "cell 1 1");

                //---- pf_pwd ----
                pf_pwd.setMinimumSize(new Dimension(100, 30));
                addStaffPanel.add(pf_pwd, "cell 2 1");

                //---- lbl_confirmPwd ----
                lbl_confirmPwd.setText("Confirm Password");
                lbl_confirmPwd.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                addStaffPanel.add(lbl_confirmPwd, "cell 1 2");

                //---- pf_confirmpwd ----
                pf_confirmpwd.setMinimumSize(new Dimension(100, 30));
                addStaffPanel.add(pf_confirmpwd, "cell 2 2");

                //---- lbl_firstName ----
                lbl_firstName.setText("First name");
                lbl_firstName.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                addStaffPanel.add(lbl_firstName, "cell 1 3");

                //---- tf_firstName ----
                tf_firstName.setMinimumSize(new Dimension(100, 30));
                addStaffPanel.add(tf_firstName, "cell 2 3");

                //---- lbl_lastName ----
                lbl_lastName.setText("Last name");
                lbl_lastName.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                addStaffPanel.add(lbl_lastName, "cell 1 4");

                //---- tf_lastName ----
                tf_lastName.setMinimumSize(new Dimension(100, 30));
                addStaffPanel.add(tf_lastName, "cell 2 4");

                //---- btn_confirm ----
                btn_confirm.setText("Confirm");
                btn_confirm.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                addStaffPanel.add(btn_confirm, "cell 1 5 2 1");

                //---- btn_reset ----
                btn_reset.setText("Reset");
                btn_reset.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                addStaffPanel.add(btn_reset, "cell 1 7 2 1");
            }
            tabbedPane1.addTab("Add a bank staff", addStaffPanel);

            //======== removeStaffPanel ========
            {
                removeStaffPanel.setLayout(new MigLayout(
                    "hidemode 3",
                    // columns
                    "[100:n,fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[100:n,fill]",
                    // rows
                    "[100:n]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[100:n]"));

                //---- lbl_staffId ----
                lbl_staffId.setText("Staff ID");
                lbl_staffId.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                removeStaffPanel.add(lbl_staffId, "cell 1 1");

                //---- tf_staffId ----
                tf_staffId.setMinimumSize(new Dimension(110, 30));
                removeStaffPanel.add(tf_staffId, "cell 2 1 2 1");

                //---- btn_remove ----
                btn_remove.setText("Remove");
                btn_remove.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                removeStaffPanel.add(btn_remove, "cell 1 3 3 1");
            }
            tabbedPane1.addTab("Remove a Bank Staff", removeStaffPanel);

            //======== modifyEmailPanel ========
            {
                modifyEmailPanel.setLayout(new MigLayout(
                    "hidemode 3",
                    // columns
                    "[100:n,fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[100:n,fill]",
                    // rows
                    "[50:n]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]" +
                    "[100:n]"));

                //---- lbl_emailHost ----
                lbl_emailHost.setText("Email host");
                lbl_emailHost.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                modifyEmailPanel.add(lbl_emailHost, "cell 1 1");

                //---- tf_emailHost ----
                tf_emailHost.setMinimumSize(new Dimension(100, 30));
                modifyEmailPanel.add(tf_emailHost, "cell 2 1");

                //---- lbl_emailPort ----
                lbl_emailPort.setText("Email port");
                lbl_emailPort.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                modifyEmailPanel.add(lbl_emailPort, "cell 1 2");

                //---- tf_emailPort ----
                tf_emailPort.setMinimumSize(new Dimension(100, 30));
                modifyEmailPanel.add(tf_emailPort, "cell 2 2");

                //---- lbl_email ----
                lbl_email.setText("Email ");
                lbl_email.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                modifyEmailPanel.add(lbl_email, "cell 1 3");

                //---- tf_email ----
                tf_email.setMinimumSize(new Dimension(100, 30));
                modifyEmailPanel.add(tf_email, "cell 2 3");

                //---- lbl_emailPwd ----
                lbl_emailPwd.setText("Password");
                lbl_emailPwd.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                modifyEmailPanel.add(lbl_emailPwd, "cell 1 4");

                //---- pf_emailPwd ----
                pf_emailPwd.setMinimumSize(new Dimension(100, 30));
                modifyEmailPanel.add(pf_emailPwd, "cell 2 4");

                //---- lbl_emailConfirmPwd ----
                lbl_emailConfirmPwd.setText("Confirm password");
                lbl_emailConfirmPwd.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                modifyEmailPanel.add(lbl_emailConfirmPwd, "cell 1 5");

                //---- pf_emailConfirmPwd ----
                pf_emailConfirmPwd.setMinimumSize(new Dimension(100, 30));
                modifyEmailPanel.add(pf_emailConfirmPwd, "cell 2 5");

                //---- button4 ----
                button4.setText("Modify");
                button4.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                modifyEmailPanel.add(button4, "cell 1 6 2 1");
            }
            tabbedPane1.addTab("Modify System Email", modifyEmailPanel);
        }
        contentPane.add(tabbedPane1, "cell 0 0 2 3");

        //---- btn_signout ----
        btn_signout.setText("Sign out");
        btn_signout.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        btn_signout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_signoutActionPerformed(e);
            }
        });
        contentPane.add(btn_signout, "cell 1 3");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JTabbedPane tabbedPane1;
    private JPanel addStaffPanel;
    private JLabel lbl_pwd;
    private JPasswordField pf_pwd;
    private JLabel lbl_confirmPwd;
    private JPasswordField pf_confirmpwd;
    private JLabel lbl_firstName;
    private JTextField tf_firstName;
    private JLabel lbl_lastName;
    private JTextField tf_lastName;
    private JButton btn_confirm;
    private JButton btn_reset;
    private JPanel removeStaffPanel;
    private JLabel lbl_staffId;
    private JTextField tf_staffId;
    private JButton btn_remove;
    private JPanel modifyEmailPanel;
    private JLabel lbl_emailHost;
    private JTextField tf_emailHost;
    private JLabel lbl_emailPort;
    private JTextField tf_emailPort;
    private JLabel lbl_email;
    private JTextField tf_email;
    private JLabel lbl_emailPwd;
    private JPasswordField pf_emailPwd;
    private JLabel lbl_emailConfirmPwd;
    private JPasswordField pf_emailConfirmPwd;
    private JButton button4;
    private JButton btn_signout;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
