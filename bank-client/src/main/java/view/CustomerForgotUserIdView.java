/*
 * Created by JFormDesigner on Sun Oct 14 16:59:11 BST 2018
 */

package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.miginfocom.swing.*;
import util.JTextFieldLimit;

/**
 * @author xiangkai22
 */
public class CustomerForgotUserIdView extends JFrame {
    public CustomerForgotUserIdView() {
        initComponents();
        initTextFields();
        pack();
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

    private void btn_confirmActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void btn_backActionPerformed(ActionEvent e) {
        this.dispose();
        new CustomerLoginView().run();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        lbl_IBAN = new JLabel();
        tf_IBAN = new JTextField();
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
            "[]"));

        //---- lbl_IBAN ----
        lbl_IBAN.setText("IBAN");
        lbl_IBAN.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        contentPane.add(lbl_IBAN, "cell 1 0");
        contentPane.add(tf_IBAN, "cell 2 0");

        //---- lbl_dob ----
        lbl_dob.setText("Date of Birth");
        lbl_dob.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        contentPane.add(lbl_dob, "cell 1 1");

        //---- tf_day ----
        tf_day.setMinimumSize(new Dimension(50, 24));
        tf_day.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                tf_dayFocusGained(e);
            }
        });
        contentPane.add(tf_day, "cell 2 1");

        //---- lbl_dob_mark1 ----
        lbl_dob_mark1.setText("/");
        contentPane.add(lbl_dob_mark1, "cell 2 1");

        //---- tf_month ----
        tf_month.setMinimumSize(new Dimension(50, 24));
        tf_month.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                tf_monthFocusGained(e);
            }
        });
        contentPane.add(tf_month, "cell 2 1");

        //---- lbl_dob_mark2 ----
        lbl_dob_mark2.setText("/");
        contentPane.add(lbl_dob_mark2, "cell 2 1");

        //---- tf_year ----
        tf_year.setMinimumSize(new Dimension(50, 24));
        tf_year.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                tf_yearFocusGained(e);
            }
        });
        contentPane.add(tf_year, "cell 2 1");

        //---- lbl_contactNum ----
        lbl_contactNum.setText("Contact Number");
        lbl_contactNum.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        contentPane.add(lbl_contactNum, "cell 1 2");
        contentPane.add(tf_contactNum, "cell 2 2");

        //---- lbl_email ----
        lbl_email.setText("Email");
        lbl_email.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        contentPane.add(lbl_email, "cell 1 3");
        contentPane.add(tf_email, "cell 2 3");

        //---- btn_confirm ----
        btn_confirm.setText("Confirm");
        btn_confirm.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        btn_confirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_confirmActionPerformed(e);
            }
        });
        contentPane.add(btn_confirm, "cell 2 4");

        //---- btn_back ----
        btn_back.setText("Back");
        btn_back.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        btn_back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_backActionPerformed(e);
            }
        });
        contentPane.add(btn_back, "cell 2 5");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    private void initTextFields() {
        tf_contactNum.setDocument(new JTextFieldLimit(4));
        tf_day.setDocument(new JTextFieldLimit(2));
        tf_month.setDocument(new JTextFieldLimit(2));
        tf_year.setDocument(new JTextFieldLimit(4));

        tf_year.setText("YYYY");
        tf_month.setText("MM");
        tf_day.setText("DD");
    }

    public void run() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel lbl_IBAN;
    private JTextField tf_IBAN;
    private JLabel lbl_dob;
    private JTextField tf_day;
    private JLabel lbl_dob_mark1;
    private JTextField tf_month;
    private JLabel lbl_dob_mark2;
    private JTextField tf_year;
    private JLabel lbl_contactNum;
    private JTextField tf_contactNum;
    private JLabel lbl_email;
    private JTextField tf_email;
    private JButton btn_confirm;
    private JButton btn_back;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
