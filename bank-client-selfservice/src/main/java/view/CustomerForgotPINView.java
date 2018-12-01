/*
 * Created by JFormDesigner on Sun Oct 14 17:16:51 BST 2018
 */

package view;

import controller.CustomerForgotPINController;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

/**
 * @author xiangkai22
 */
public class CustomerForgotPINView extends JFrame {
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    public JLabel lbl_userId;
    public JTextField tf_userId;
    public JLabel lbl_email;
    public JTextField tf_email;
    public JLabel lbl_dob;
    public JTextField tf_day;
    public JLabel lbl_dob_mark1;
    public JTextField tf_month;
    public JLabel lbl_dob_mark2;
    public JTextField tf_year;
    public JButton btn_confirm;
    public JButton btn_back;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private CustomerForgotPINController customerForgotPINController;

    public CustomerForgotPINView(Long userId) {
        customerForgotPINController = new CustomerForgotPINController(this, userId);
        customerForgotPINController.initialize();
    }

    public void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        lbl_userId = new JLabel();
        tf_userId = new JTextField();
        lbl_email = new JLabel();
        tf_email = new JTextField();
        lbl_dob = new JLabel();
        tf_day = new JTextField();
        lbl_dob_mark1 = new JLabel();
        tf_month = new JTextField();
        lbl_dob_mark2 = new JLabel();
        tf_year = new JTextField();
        btn_confirm = new JButton();
        btn_back = new JButton();

        //======== this ========
        setTitle("Customer Forgot PIN View");
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

        //---- lbl_userId ----
        lbl_userId.setText("UserId");
        lbl_userId.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        contentPane.add(lbl_userId, "cell 0 0");
        contentPane.add(tf_userId, "cell 1 0");

        //---- lbl_email ----
        lbl_email.setText("Email");
        lbl_email.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        contentPane.add(lbl_email, "cell 0 1");
        contentPane.add(tf_email, "cell 1 1");

        //---- lbl_dob ----
        lbl_dob.setText("Date of Birth");
        lbl_dob.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        contentPane.add(lbl_dob, "cell 0 2");

        //---- tf_day ----
        tf_day.setMinimumSize(new Dimension(80, 24));
        tf_day.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                customerForgotPINController.tf_dayFocusGained(e);
            }
        });
        contentPane.add(tf_day, "cell 1 2");

        //---- lbl_dob_mark1 ----
        lbl_dob_mark1.setText("/");
        contentPane.add(lbl_dob_mark1, "cell 1 2");

        //---- tf_month ----
        tf_month.setMinimumSize(new Dimension(80, 24));
        tf_month.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                customerForgotPINController.tf_monthFocusGained(e);
            }
        });
        contentPane.add(tf_month, "cell 1 2");

        //---- lbl_dob_mark2 ----
        lbl_dob_mark2.setText("/");
        contentPane.add(lbl_dob_mark2, "cell 1 2");

        //---- tf_year ----
        tf_year.setMinimumSize(new Dimension(80, 24));
        tf_year.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                customerForgotPINController.tf_yearFocusGained(e);
            }
        });
        contentPane.add(tf_year, "cell 1 2");

        //---- btn_confirm ----
        btn_confirm.setText("Confirm");
        btn_confirm.addActionListener(e -> customerForgotPINController.btn_confirmActionPerformed(e));
        contentPane.add(btn_confirm, "cell 1 3");

        //---- btn_back ----
        btn_back.setText("Back");
        btn_back.addActionListener(e -> customerForgotPINController.btn_backActionPerformed(e));
        contentPane.add(btn_back, "cell 1 4");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

}
