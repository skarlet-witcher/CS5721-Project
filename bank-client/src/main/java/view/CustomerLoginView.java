/*
 * Created by JFormDesigner on Sun Oct 14 11:44:09 BST 2018
 */

package view;

import net.miginfocom.swing.MigLayout;
import util.JTextFieldLimit;
import util.RandomUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

/**
 * @author xiangkai22
 */
public class CustomerLoginView extends JFrame {

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel lbl_userId;
    private JTextField tf_userId;
    private JLabel lbl_dob;
    private JLabel lbl_contactNum;
    private JTextField tf_day;
    private JLabel lbl_dob_mark1;
    private JTextField tf_month;
    private JLabel lbl_dob_mark2;
    private JTextField tf_year;
    private JTextField tf_contactNum;
    private JButton btn_login;
    private JButton btn_forgotUserId;
    private JButton btn_register;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public CustomerLoginView() {
        initComponents();
        initTextFields();
        securityVerification(randomCheck());
        pack(); // resize
    }

    private int randomCheck() {
        return RandomUtil.RandomNum(1, 2);
    }
    private void securityVerification(int switcher) {

        if(switcher == 1) {
            lbl_dob.setVisible(false);
            tf_year.setVisible(false);
            tf_month.setVisible(false);
            tf_day.setVisible(false);
            lbl_dob_mark1.setVisible(false);
            lbl_dob_mark2.setVisible(false);

            lbl_contactNum.setVisible(true);
            tf_contactNum.setVisible(true);
        } else {
            lbl_contactNum.setVisible(false);
            tf_contactNum.setVisible(false);

            lbl_dob.setVisible(true);
            tf_year.setVisible(true);
            tf_month.setVisible(true);
            tf_day.setVisible(true);
            lbl_dob_mark1.setVisible(true);
            lbl_dob_mark2.setVisible(true);
        }

    }

    public void run() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void tf_dayFocusGained(FocusEvent e) {
        tf_day.selectAll();
    }

    private void tf_monthFocusGained(FocusEvent e) {
        tf_month.selectAll();
    }

    private void tf_yearFocusGained(FocusEvent e) {
        tf_year.selectAll();
    }

    private void btn_loginActionPerformed(ActionEvent e) {
        this.dispose();
        new CustomerPINView().run();
    }

    private void btn_forgotUserIdActionPerformed(ActionEvent e) {
        this.dispose();
        new CustomerForgotUserIdView().run();
    }

    private void btn_registerActionPerformed(ActionEvent e) {
        this.dispose();
        new CustomerApplyView().run();
    }

    private void initTextFields() {
        tf_userId.setDocument(new JTextFieldLimit(10));
        tf_contactNum.setDocument(new JTextFieldLimit(4));
        tf_day.setDocument(new JTextFieldLimit(2));
        tf_month.setDocument(new JTextFieldLimit(2));
        tf_year.setDocument(new JTextFieldLimit(4));

        tf_year.setText("YYYY");
        tf_month.setText("MM");
        tf_day.setText("DD");
    }

    private void initComponents() {

        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        lbl_userId = new JLabel();
        tf_userId = new JTextField();
        lbl_dob = new JLabel();
        lbl_contactNum = new JLabel();
        tf_day = new JTextField();
        lbl_dob_mark1 = new JLabel();
        tf_month = new JTextField();
        lbl_dob_mark2 = new JLabel();
        tf_year = new JTextField();
        tf_contactNum = new JTextField();
        btn_login = new JButton();
        btn_forgotUserId = new JButton();
        btn_register = new JButton();

        //======== this ========
        setTitle("Cusotmer Secure Login");
        setMinimumSize(new Dimension(27, 35));
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
                "[30:n,grow,fill]" +
                        "[28,fill]0" +
            "[fill]" +
            "[92,grow,fill]" +
                        "[30:n,grow,fill]",
            // rows
                "[50:n]" +
                        "[fill]" +
            "[]" +
                        "[fill]" +
                        "[15:n,grow,fill]" +
            "[]" +
            "[]" +
                        "[30:n,grow]"));

        //---- lbl_userId ----
        lbl_userId.setText("<html>Please enter your <strong>User ID</strong></html>");
        lbl_userId.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        contentPane.add(lbl_userId, "cell 2 1");

        //---- tf_userId ----
        tf_userId.setMinimumSize(new Dimension(90, 30));
        contentPane.add(tf_userId, "cell 3 1");

        //---- lbl_dob ----
        lbl_dob.setText("Date of Birth");
        lbl_dob.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        contentPane.add(lbl_dob, "cell 2 3");

        //---- lbl_contactNum ----
        lbl_contactNum.setText("<html><strong>Last four digits</strong> of Contact Number</html>");
        lbl_contactNum.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lbl_contactNum.setMinimumSize(new Dimension(102, 15));
        contentPane.add(lbl_contactNum, "cell 2 3");

        //---- tf_day ----
        tf_day.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                tf_dayFocusGained(e);
            }
        });
        contentPane.add(tf_day, "cell 3 3");

        //---- lbl_dob_mark1 ----
        lbl_dob_mark1.setText("/");
        contentPane.add(lbl_dob_mark1, "cell 3 3");

        //---- tf_month ----
        tf_month.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                tf_monthFocusGained(e);
            }
        });
        contentPane.add(tf_month, "cell 3 3");

        //---- lbl_dob_mark2 ----
        lbl_dob_mark2.setText("/");
        contentPane.add(lbl_dob_mark2, "cell 3 3");

        //---- tf_year ----
        tf_year.setMinimumSize(new Dimension(64, 30));
        tf_year.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                tf_yearFocusGained(e);
            }
        });
        contentPane.add(tf_year, "cell 3 3");

        //---- tf_contactNum ----
        tf_contactNum.setMinimumSize(new Dimension(90, 30));
        contentPane.add(tf_contactNum, "cell 3 3");

        //---- btn_login ----
        btn_login.setText("Continue");
        btn_login.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        btn_login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_loginActionPerformed(e);
            }
        });
        contentPane.add(btn_login, "cell 2 5 2 1");

        //---- btn_forgotUserId ----
        btn_forgotUserId.setText("Forgot User ID ?");
        btn_forgotUserId.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        btn_forgotUserId.setMinimumSize(null);
        btn_forgotUserId.setPreferredSize(null);
        btn_forgotUserId.setMaximumSize(null);
        btn_forgotUserId.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_forgotUserIdActionPerformed(e);
            }
        });
        contentPane.add(btn_forgotUserId, "cell 2 6 2 1");

        //---- btn_register ----
        btn_register.setText("Apply now !");
        btn_register.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        btn_register.setPreferredSize(null);
        btn_register.setMinimumSize(null);
        btn_register.setMaximumSize(null);
        btn_register.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_registerActionPerformed(e);
            }
        });
        contentPane.add(btn_register, "cell 2 6 2 1");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //  /// GEN-END:initComponents

    }
}

