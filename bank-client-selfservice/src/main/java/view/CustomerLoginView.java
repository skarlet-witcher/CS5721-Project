/*
 * Created by JFormDesigner on Sun Oct 14 11:44:09 BST 2018
 */

package view;

import controller.CustomerLoginController;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

/**
 * @author xiangkai Tang
 */
public class CustomerLoginView extends JFrame {
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    public JLabel lbl_title;
    public JLabel lbl_userId;
    public JTextField tf_userId;
    public JPanel panel_contactNum;
    public JLabel lbl_contactNum;
    public JTextField tf_contactNum;
    public JPanel panel_dob;
    public JLabel lbl_dob;
    public JTextField tf_day;
    public JLabel lbl_dob_mark1;
    public JTextField tf_month;
    public JLabel lbl_dob_mark2;
    public JTextField tf_year;
    public JButton btn_login;
    public JButton btn_forgotUserId;
    public JButton btn_register;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private CustomerLoginController controller;

    public CustomerLoginView() {
        controller = new CustomerLoginController(this);
        controller.initialize();
    }

    public void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        lbl_title = new JLabel();
        lbl_userId = new JLabel();
        tf_userId = new JTextField();
        panel_contactNum = new JPanel();
        lbl_contactNum = new JLabel();
        tf_contactNum = new JTextField();
        panel_dob = new JPanel();
        lbl_dob = new JLabel();
        tf_day = new JTextField();
        lbl_dob_mark1 = new JLabel();
        tf_month = new JTextField();
        lbl_dob_mark2 = new JLabel();
        tf_year = new JTextField();
        btn_login = new JButton();
        btn_forgotUserId = new JButton();
        btn_register = new JButton();

        //======== this ========
        setTitle("Customer Secure Login");
        setMinimumSize(new Dimension(27, 35));
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[30:n,grow,fill]" +
                        "[28,fill]0" +
                        "[fill]" +
                        "[fill]" +
                        "[92,grow,fill]" +
                        "[30:n,grow,fill]",
                // rows
                "[50:n]" +
                        "[]" +
                        "[fill]" +
                        "[]" +
                        "[]" +
                        "[fill]" +
                        "[15:n,grow,fill]" +
                        "[]" +
                        "[]" +
                        "[30:n,grow]"));

        //---- lbl_title ----
        lbl_title.setText("Nuclear Bank System Login");
        lbl_title.setFont(new Font("Segoe UI", Font.PLAIN, 28));
        lbl_title.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lbl_title, "cell 2 0 3 1");

        //---- lbl_userId ----
        lbl_userId.setText("<html>Please enter your <strong>User ID</strong></html>");
        lbl_userId.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        contentPane.add(lbl_userId, "cell 2 2");

        //---- tf_userId ----
        tf_userId.setMinimumSize(new Dimension(90, 30));
        contentPane.add(tf_userId, "cell 4 2");

        //======== panel_contactNum ========
        {
            panel_contactNum.setLayout(new MigLayout(
                    "hidemode 3",
                    // columns
                    "[fill]" +
                            "[fill]" +
                            "[fill]" +
                            "[fill]" +
                            "[fill]" +
                            "[fill]" +
                            "[fill]" +
                            "[fill]" +
                            "[fill]" +
                            "[fill]" +
                            "[fill]" +
                            "[fill]",
                    // rows
                    "[]" +
                            "[]" +
                            "[]"));

            //---- lbl_contactNum ----
            lbl_contactNum.setText("<html><strong>Last four digits</strong> of Contact Number</html>");
            lbl_contactNum.setFont(new Font("Segoe UI", Font.PLAIN, 16));
            lbl_contactNum.setMinimumSize(new Dimension(102, 15));
            panel_contactNum.add(lbl_contactNum, "cell 0 2 3 1");

            //---- tf_contactNum ----
            tf_contactNum.setMinimumSize(new Dimension(90, 30));
            panel_contactNum.add(tf_contactNum, "cell 3 2 9 1");
        }
        contentPane.add(panel_contactNum, "cell 2 4 3 1");

        //======== panel_dob ========
        {
            panel_dob.setLayout(new MigLayout(
                    "hidemode 3",
                    // columns
                    "[fill]" +
                            "[fill]" +
                            "[fill]" +
                            "[fill]" +
                            "[fill]" +
                            "[fill]",
                    // rows
                    "[]" +
                            "[]" +
                            "[]"));

            //---- lbl_dob ----
            lbl_dob.setText("Date of Birth");
            lbl_dob.setFont(new Font("Segoe UI", Font.PLAIN, 20));
            panel_dob.add(lbl_dob, "cell 0 0");

            //---- tf_day ----
            tf_day.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    controller.tf_dayFocusGained(e);
                }
            });
            panel_dob.add(tf_day, "cell 1 0");

            //---- lbl_dob_mark1 ----
            lbl_dob_mark1.setText("/");
            panel_dob.add(lbl_dob_mark1, "cell 2 0");

            //---- tf_month ----
            tf_month.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    controller.tf_monthFocusGained(e);
                }
            });
            panel_dob.add(tf_month, "cell 3 0");

            //---- lbl_dob_mark2 ----
            lbl_dob_mark2.setText("/");
            panel_dob.add(lbl_dob_mark2, "cell 4 0");

            //---- tf_year ----
            tf_year.setMinimumSize(new Dimension(64, 30));
            tf_year.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    controller.tf_yearFocusGained(e);
                }
            });
            panel_dob.add(tf_year, "cell 5 0");
        }
        contentPane.add(panel_dob, "cell 2 6 3 1");

        //---- btn_login ----
        btn_login.setText("Continue");
        btn_login.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        btn_login.addActionListener(e -> controller.btn_loginActionPerformed(e));
        contentPane.add(btn_login, "cell 2 7 3 1");

        //---- btn_forgotUserId ----
        btn_forgotUserId.setText("Forgot User ID ?");
        btn_forgotUserId.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        btn_forgotUserId.setMinimumSize(null);
        btn_forgotUserId.setPreferredSize(null);
        btn_forgotUserId.setMaximumSize(null);
        btn_forgotUserId.addActionListener(e -> controller.btn_forgotUserIdActionPerformed(e));
        contentPane.add(btn_forgotUserId, "cell 2 8 3 1");

        //---- btn_register ----
        btn_register.setText("Apply now !");
        btn_register.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        btn_register.setPreferredSize(null);
        btn_register.setMinimumSize(null);
        btn_register.setMaximumSize(null);
        btn_register.addActionListener(e -> controller.btn_registerActionPerformed(e));
        contentPane.add(btn_register, "cell 2 8 3 1");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //  /// GEN-END:initComponents
    }
}

