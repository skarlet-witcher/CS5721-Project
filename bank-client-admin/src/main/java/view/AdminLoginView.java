/*
 * Created by JFormDesigner on Mon Oct 15 22:27:37 BST 2018
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
public class AdminLoginView extends JFrame {
    public AdminLoginView() {
        initComponents();
    }

    private void btn_loginActionPerformed(ActionEvent e) {
        this.dispose();
        new AdminMainView().run();
    }

    public void run() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        lbl_adminId = new JLabel();
        tf_adminId = new JTextField();
        lbl_pwd = new JLabel();
        pf_pwd = new JPasswordField();
        btn_login = new JButton();

        //======== this ========
        setTitle("Admin Login View");
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
                "[50:n,fill]" +
            "[fill]" +
            "[fill]" +
                        "[50:n,fill]",
            // rows
            "[50:n]" +
            "[]" +
            "[]" +
            "[]" +
            "[100:n]"));

        //---- lbl_adminId ----
        lbl_adminId.setText("Username");
        lbl_adminId.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        contentPane.add(lbl_adminId, "cell 1 1");

        //---- tf_adminId ----
        tf_adminId.setMinimumSize(new Dimension(100, 30));
        contentPane.add(tf_adminId, "cell 2 1");

        //---- lbl_pwd ----
        lbl_pwd.setText("Password");
        lbl_pwd.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        contentPane.add(lbl_pwd, "cell 1 2");

        //---- pf_pwd ----
        pf_pwd.setMinimumSize(new Dimension(100, 30));
        contentPane.add(pf_pwd, "cell 2 2");

        //---- btn_login ----
        btn_login.setText("Login");
        btn_login.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        btn_login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_loginActionPerformed(e);
            }
        });
        contentPane.add(btn_login, "cell 2 3");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel lbl_adminId;
    private JTextField tf_adminId;
    private JLabel lbl_pwd;
    private JPasswordField pf_pwd;
    private JButton btn_login;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
