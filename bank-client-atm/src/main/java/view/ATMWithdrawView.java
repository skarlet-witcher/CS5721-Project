/*
 * Created by JFormDesigner on Sat Oct 20 15:08:10 BST 2018
 */

package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author xiangkai22
 */
public class ATMWithdrawView extends JFrame {
    public ATMWithdrawView() {
        initComponents();
    }

    private void btn_backActionPerformed(ActionEvent e) {
        this.dispose();
        new ATMMainView().run();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        lbl_balance = new JLabel();
        tf_balance = new JTextField();
        lbl_amounts = new JLabel();
        tf_amounts = new JTextField();
        btn_confirm = new JButton();
        btn_back = new JButton();

        //======== this ========
        setTitle("ATM Withdraw View");
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

        //---- lbl_balance ----
        lbl_balance.setText("Balance");
        lbl_balance.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        contentPane.add(lbl_balance, "cell 1 1");

        //---- tf_balance ----
        tf_balance.setEditable(false);
        tf_balance.setMinimumSize(new Dimension(100, 24));
        contentPane.add(tf_balance, "cell 2 1");

        //---- lbl_amounts ----
        lbl_amounts.setText("Amounts");
        lbl_amounts.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        contentPane.add(lbl_amounts, "cell 1 2");

        //---- tf_amounts ----
        tf_amounts.setMinimumSize(new Dimension(100, 24));
        contentPane.add(tf_amounts, "cell 2 2");

        //---- btn_confirm ----
        btn_confirm.setText("Confirm");
        btn_confirm.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        contentPane.add(btn_confirm, "cell 1 3 2 1");

        //---- btn_back ----
        btn_back.setText("Back");
        btn_back.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        btn_back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_backActionPerformed(e);
            }
        });
        contentPane.add(btn_back, "cell 1 4 2 1");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    public void run() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel lbl_balance;
    private JTextField tf_balance;
    private JLabel lbl_amounts;
    private JTextField tf_amounts;
    private JButton btn_confirm;
    private JButton btn_back;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
