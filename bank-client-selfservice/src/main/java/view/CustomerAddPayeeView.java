/*
 * Created by JFormDesigner on Wed Oct 17 08:55:51 BST 2018
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
public class CustomerAddPayeeView extends JFrame {
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel lbl_payeeName;
    private JTextField tf_payeeName;
    private JLabel lbl_IBAN;
    private JTextField tf_IBAN;
    private JButton btn_add;
    private JButton btn_back;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private long userId;
    private CustomerMainView customerMainView;

    public CustomerAddPayeeView(long userId, CustomerMainView customerMainView) {
        initComponents();
        setFields(userId, customerMainView);
    }

    private void setFields(long userId, CustomerMainView customerMainView) {
        this.userId = userId;
        this.customerMainView = customerMainView;
    }


    private void btn_backActionPerformed(ActionEvent e) {
        this.dispose();
        customerMainView.setVisible(true);
    }

    private void btn_addActionPerformed(ActionEvent e) {
        // payee name validator
        if(tf_payeeName.getText().trim().length() <= 0) {
            JOptionPane.showMessageDialog(null,
                    "Please input your payee name",
                    "Error Message", JOptionPane.ERROR_MESSAGE);
            tf_payeeName.grabFocus();
            return;
        } if(!tf_payeeName.getText().trim().matches("^[a-zA-Z]+$")) {
            JOptionPane.showMessageDialog(null,
                    "Payee name should only contain letters",
                    "Error Message", JOptionPane.ERROR_MESSAGE);
            tf_payeeName.grabFocus();
            return;
        }
        // IBAN validator
        if(tf_payeeName.getText().trim().length() <= 0) {
            JOptionPane.showMessageDialog(null,
                    "Please input your payee's IBAN",
                    "Error Message", JOptionPane.ERROR_MESSAGE);
            tf_payeeName.grabFocus();
            return;
        } if(!tf_payeeName.getText().trim().matches("^[0-9A-Z]+$")) {
            JOptionPane.showMessageDialog(null,
                    "IBAN should only contain capital letters and digits",
                    "Error Message", JOptionPane.ERROR_MESSAGE);
            tf_payeeName.grabFocus();
            return;
        }
        // add payee service

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        lbl_payeeName = new JLabel();
        tf_payeeName = new JTextField();
        lbl_IBAN = new JLabel();
        tf_IBAN = new JTextField();
        btn_add = new JButton();
        btn_back = new JButton();

        //======== this ========
        setTitle("Customer Add Payee View");
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
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
                        "[100:n]"));

        //---- lbl_payeeName ----
        lbl_payeeName.setText("Payee name");
        contentPane.add(lbl_payeeName, "cell 1 1");

        //---- tf_payeeName ----
        tf_payeeName.setMinimumSize(new Dimension(100, 30));
        contentPane.add(tf_payeeName, "cell 2 1");

        //---- lbl_IBAN ----
        lbl_IBAN.setText("IBAN");
        contentPane.add(lbl_IBAN, "cell 1 2");

        //---- tf_IBAN ----
        tf_IBAN.setMinimumSize(new Dimension(100, 30));
        contentPane.add(tf_IBAN, "cell 2 2");

        //---- btn_add ----
        btn_add.setText("Add");
        btn_add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_addActionPerformed(e);
            }
        });
        contentPane.add(btn_add, "cell 2 3");

        //---- btn_back ----
        btn_back.setText("Back");
        btn_back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_backActionPerformed(e);
            }
        });
        contentPane.add(btn_back, "cell 2 4");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    public void run() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}
