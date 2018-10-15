/*
 * Created by JFormDesigner on Mon Oct 15 20:37:12 BST 2018
 */

package view;

import net.miginfocom.swing.MigLayout;
import util.JTextFieldLimit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author xiangkai22
 */
public class ATMDepositView extends JFrame {
    public ATMDepositView() {
        initComponents();
        initTextField();
    }

    private void btn_backActionPerformed(ActionEvent e) {
        this.dispose();
        new ATMMainView().run();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        lbl_cardNum = new JLabel();
        tf_cardNum = new JTextField();
        lbl_amounts = new JLabel();
        tf_amounts = new JTextField();
        btn_confirm = new JButton();
        btn_back = new JButton();

        //======== this ========
        setTitle("ATM Deposit View");
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
            "[]0" +
            "[]0" +
            "[]" +
            "[]" +
            "[]" +
            "[50:n]"));

        //---- lbl_cardNum ----
        lbl_cardNum.setText("Card Number");
        lbl_cardNum.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        contentPane.add(lbl_cardNum, "cell 1 1");

        //---- tf_cardNum ----
        tf_cardNum.setMinimumSize(new Dimension(110, 30));
        contentPane.add(tf_cardNum, "cell 2 1");

        //---- lbl_amounts ----
        lbl_amounts.setText("Amounts");
        lbl_amounts.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        contentPane.add(lbl_amounts, "cell 1 2");

        //---- tf_amounts ----
        tf_amounts.setMinimumSize(new Dimension(110, 30));
        contentPane.add(tf_amounts, "cell 2 2");

        //---- btn_confirm ----
        btn_confirm.setText("Confirm");
        btn_confirm.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        contentPane.add(btn_confirm, "cell 2 5");

        //---- btn_back ----
        btn_back.setText("Back");
        btn_back.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        btn_back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_backActionPerformed(e);
                btn_backActionPerformed(e);
            }
        });
        contentPane.add(btn_back, "cell 2 6");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    private void initTextField() {
        tf_cardNum.setDocument(new JTextFieldLimit(16));

    }

    public void run() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel lbl_cardNum;
    private JTextField tf_cardNum;
    private JLabel lbl_amounts;
    private JTextField tf_amounts;
    private JButton btn_confirm;
    private JButton btn_back;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
