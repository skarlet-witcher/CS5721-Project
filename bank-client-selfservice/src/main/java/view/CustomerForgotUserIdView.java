/*
 * Created by JFormDesigner on Sun Oct 14 16:59:11 BST 2018
 */

package view;

import controller.CustomerForgotUserIdController;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

/**
 * @author xiangkai22
 */
public class CustomerForgotUserIdView extends JFrame {

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    public JLabel lbl_firstname;
    public JTextField tf_firstName;
    public JLabel lbl_lastName;
    public JTextField tf_lastName;
    public JLabel lbl_dob;
    public JTextField tf_day;
    public JLabel lbl_dob_mark1;
    public JTextField tf_month;
    public JLabel lbl_dob_mark2;
    public JTextField tf_year;
    public JLabel lbl_contactNum;
    public JTextField tf_contactNum;
    public JLabel lbl_email;
    public JTextField tf_email;
    public JButton btn_confirm;
    public JButton btn_back;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private CustomerForgotUserIdController customerForgotUserIdController;

    public CustomerForgotUserIdView() {
        customerForgotUserIdController = new CustomerForgotUserIdController(this);
        customerForgotUserIdController.initialize();
    }

    public void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        lbl_firstname = new JLabel();
        tf_firstName = new JTextField();
        lbl_lastName = new JLabel();
        tf_lastName = new JTextField();
        lbl_dob = new JLabel();
        tf_day = new JTextField();
        lbl_dob_mark1 = new JLabel();
        tf_month = new JTextField();
        lbl_dob_mark2 = new JLabel();
        tf_year = new JTextField();
        lbl_contactNum = new JLabel();
        tf_contactNum = new JTextField();
        lbl_email = new JLabel();
        tf_email = new JTextField();
        btn_confirm = new JButton();
        btn_back = new JButton();

        //======== this ========
        setTitle("Customer Forgot UserId View");
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[50:n,fill]" +
            "[fill]" +
            "[fill]" +
            "[50:n,fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //---- lbl_firstname ----
        lbl_firstname.setText("First Name");
        lbl_firstname.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        contentPane.add(lbl_firstname, "cell 1 1");
        contentPane.add(tf_firstName, "cell 2 1");

        //---- lbl_lastName ----
        lbl_lastName.setText("Last Name");
        lbl_lastName.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        contentPane.add(lbl_lastName, "cell 1 2");
        contentPane.add(tf_lastName, "cell 2 2");

        //---- lbl_dob ----
        lbl_dob.setText("Date of Birth");
        lbl_dob.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        contentPane.add(lbl_dob, "cell 1 3");

        //---- tf_day ----
        tf_day.setMinimumSize(new Dimension(50, 24));
        tf_day.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                customerForgotUserIdController.tf_dayFocusGained(e);
            }
        });
        contentPane.add(tf_day, "cell 2 3");

        //---- lbl_dob_mark1 ----
        lbl_dob_mark1.setText("/");
        contentPane.add(lbl_dob_mark1, "cell 2 3");

        //---- tf_month ----
        tf_month.setMinimumSize(new Dimension(50, 24));
        tf_month.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                customerForgotUserIdController.tf_monthFocusGained(e);
            }
        });
        contentPane.add(tf_month, "cell 2 3");

        //---- lbl_dob_mark2 ----
        lbl_dob_mark2.setText("/");
        contentPane.add(lbl_dob_mark2, "cell 2 3");

        //---- tf_year ----
        tf_year.setMinimumSize(new Dimension(50, 24));
        tf_year.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                customerForgotUserIdController.tf_yearFocusGained(e);
            }
        });
        contentPane.add(tf_year, "cell 2 3");

        //---- lbl_contactNum ----
        lbl_contactNum.setText("Contact Number");
        lbl_contactNum.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        contentPane.add(lbl_contactNum, "cell 1 4");
        contentPane.add(tf_contactNum, "cell 2 4");

        //---- lbl_email ----
        lbl_email.setText("Email");
        lbl_email.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        contentPane.add(lbl_email, "cell 1 5");
        contentPane.add(tf_email, "cell 2 5");

        //---- btn_confirm ----
        btn_confirm.setText("Confirm");
        btn_confirm.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        btn_confirm.addActionListener(e -> customerForgotUserIdController.btn_confirmActionPerformed(e));
        contentPane.add(btn_confirm, "cell 2 6");

        //---- btn_back ----
        btn_back.setText("Back");
        btn_back.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        btn_back.addActionListener(e -> customerForgotUserIdController.btn_backActionPerformed(e));
        contentPane.add(btn_back, "cell 2 7");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }



}
