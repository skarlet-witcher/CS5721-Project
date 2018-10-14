/*
 * Created by JFormDesigner on Sun Oct 14 17:16:51 BST 2018
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
public class CustomerForgotPINView extends JFrame  {
    public CustomerForgotPINView() {
        initComponents();
        initTextFields();
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


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        rootPanel = new JFrame();
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

        //======== rootPanel ========
        {
            rootPanel.setTitle("Customer Forgot PIN View");
            Container rootPanelContentPane = rootPanel.getContentPane();
            rootPanelContentPane.setLayout(new MigLayout(
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
            rootPanelContentPane.add(lbl_userId, "cell 0 0");
            rootPanelContentPane.add(tf_userId, "cell 1 0");

            //---- lbl_email ----
            lbl_email.setText("Email");
            lbl_email.setFont(new Font("Segoe UI", Font.PLAIN, 16));
            rootPanelContentPane.add(lbl_email, "cell 0 1");
            rootPanelContentPane.add(tf_email, "cell 1 1");

            //---- lbl_dob ----
            lbl_dob.setText("Date of Birth");
            lbl_dob.setFont(new Font("Segoe UI", Font.PLAIN, 16));
            rootPanelContentPane.add(lbl_dob, "cell 0 2");

            //---- tf_day ----
            tf_day.setMinimumSize(new Dimension(80, 24));
            tf_day.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    tf_dayFocusGained(e);
                }
            });
            rootPanelContentPane.add(tf_day, "cell 1 2");

            //---- lbl_dob_mark1 ----
            lbl_dob_mark1.setText("/");
            rootPanelContentPane.add(lbl_dob_mark1, "cell 1 2");

            //---- tf_month ----
            tf_month.setMinimumSize(new Dimension(80, 24));
            tf_month.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    tf_monthFocusGained(e);
                }
            });
            rootPanelContentPane.add(tf_month, "cell 1 2");

            //---- lbl_dob_mark2 ----
            lbl_dob_mark2.setText("/");
            rootPanelContentPane.add(lbl_dob_mark2, "cell 1 2");

            //---- tf_year ----
            tf_year.setMinimumSize(new Dimension(80, 24));
            rootPanelContentPane.add(tf_year, "cell 1 2");

            //---- btn_confirm ----
            btn_confirm.setText("Confirm");
            rootPanelContentPane.add(btn_confirm, "cell 1 3");

            //---- btn_back ----
            btn_back.setText("Back");
            rootPanelContentPane.add(btn_back, "cell 1 4");
            rootPanel.pack();
            rootPanel.setLocationRelativeTo(rootPanel.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    private void initTextFields() {
        tf_userId.setDocument(new JTextFieldLimit(10));
        tf_day.setDocument(new JTextFieldLimit(2));
        tf_month.setDocument(new JTextFieldLimit(2));
        tf_year.setDocument(new JTextFieldLimit(4));

        tf_year.setText("YYYY");
        tf_month.setText("MM");
        tf_day.setText("DD");
    }

    public void run() {
        this.setVisible(true);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JFrame rootPanel;
    private JLabel lbl_userId;
    private JTextField tf_userId;
    private JLabel lbl_email;
    private JTextField tf_email;
    private JLabel lbl_dob;
    private JTextField tf_day;
    private JLabel lbl_dob_mark1;
    private JTextField tf_month;
    private JLabel lbl_dob_mark2;
    private JTextField tf_year;
    private JButton btn_confirm;
    private JButton btn_back;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
