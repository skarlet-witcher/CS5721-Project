/*
 * Created by JFormDesigner on Sun Oct 14 16:59:11 BST 2018
 */

package view;

import net.miginfocom.swing.MigLayout;
import util.JTextFieldLimit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.Calendar;

/**
 * @author xiangkai22
 */
public class CustomerForgotUserIdView extends JFrame {
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
        // IBAN validator
        if(tf_IBAN.getText().trim().length() <= 0) {
            JOptionPane.showMessageDialog(null,
                    "Please input the IBAN",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            tf_IBAN.grabFocus();
            return;
        }
        if(tf_IBAN.getText().trim().length() < 22) {
            JOptionPane.showMessageDialog(null,
                    "the length of IBAN should be 22",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            tf_IBAN.grabFocus();
            return;
        }
        if(!tf_IBAN.getText().trim().matches("^[0-9A-Z]+$")) {
            JOptionPane.showMessageDialog(null,
                    "The IBAN should only contain numbers and capital letters",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            tf_IBAN.grabFocus();
            return;
        }

        // date of birth validator

        // day of dob validator
        if(tf_day.getText().trim().length() <= 0) {
            JOptionPane.showMessageDialog(null,
                    "Please input your day of your date of birth",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            tf_day.grabFocus();
            return;
        }
        if(!tf_day.getText().trim().matches("^[1-9]*$")) {
            JOptionPane.showMessageDialog(null,
                    "The day of the date of birth should be numeric",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            tf_day.grabFocus();
            return;
        }
        if(Integer.parseInt(tf_day.getText().trim()) > 31 || Integer.parseInt(tf_day.getText().trim()) < 1) {
            JOptionPane.showMessageDialog(null,
                    "The ranage of day of the date of birth should be 1 to 31",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            tf_day.grabFocus();
            return;
        }
        if(tf_day.getText().trim().length() == 1) {
            tf_day.setText("0" + tf_day.getText());
        }

        // month of dob validator
        if(tf_month.getText().trim().length() <= 0) {
            JOptionPane.showMessageDialog(null,
                    "Please input your month of your date of birth",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            tf_month.grabFocus();
            return;
        }
        if(!tf_month.getText().trim().matches("^[0-9]*$")) {
            JOptionPane.showMessageDialog(null,
                    "The month of your date of birth should be numeric",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            tf_month.grabFocus();
            return;
        }
        if(Integer.parseInt(tf_month.getText().trim()) > 12 || Integer.parseInt(tf_month.getText().trim()) < 1) {
            JOptionPane.showMessageDialog(null,
                    "The ranage of month of the date of birth should be 1 to 12",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            tf_month.grabFocus();
            return;
        }
        if(tf_month.getText().trim().length() == 1) {
            tf_month.setText("0" + tf_month.getText());
        }

        //  year of the date or birth validator
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        if(tf_year.getText().trim().length() <= 0) {
            JOptionPane.showMessageDialog(null,
                    "Please input your year of the date of birth",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            tf_year.grabFocus();
            return;
        } if(!tf_year.getText().trim().matches("^[0-9]*$")) {
            JOptionPane.showMessageDialog(null,
                    "year of the date of brith should only contain numbers",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            tf_year.grabFocus();
            return;
        }
        if(tf_year.getText().length() < 4) {
            JOptionPane.showMessageDialog(null,
                    "The year of date of birth should be four digits",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            tf_year.grabFocus();
            return;
        }
        if(Integer.parseInt(tf_year.getText().trim()) > currentYear) {
            JOptionPane.showMessageDialog(null,
                    "The year of date of birth should be less or equal to current year",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            tf_year.grabFocus();
            return;
        }

        // email field validator
        if(tf_email.getText().trim().length() <= 0) {
            JOptionPane.showMessageDialog(null,
                    "Please input your email address",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            tf_email.grabFocus();
            return;
        }
        if(!tf_email.getText().trim().matches("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b")) {
            JOptionPane.showMessageDialog(null,
                    "Please input valid email address",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            tf_email.grabFocus();
            return;
        }

        // contact number validator
        if(tf_contactNum.getText().trim().length() <= 0) {
            JOptionPane.showMessageDialog(null,
                    "Please input your contact number",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            tf_contactNum.grabFocus();
            return;
        }
        if(!tf_contactNum.getText().trim().matches("^[0-9]*$")) {
            JOptionPane.showMessageDialog(null,
                    "The contact number must be numeric.",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            tf_contactNum.grabFocus();
            return;

            // TO-DO forgot userId using model and service
        }
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
        tf_contactNum.setDocument(new JTextFieldLimit(12));
        tf_day.setDocument(new JTextFieldLimit(2));
        tf_month.setDocument(new JTextFieldLimit(2));
        tf_year.setDocument(new JTextFieldLimit(4));
        tf_IBAN.setDocument(new JTextFieldLimit(22));

        tf_year.setText("YYYY");
        tf_month.setText("MM");
        tf_day.setText("DD");
    }

    public void run() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}
