/*
 * Created by JFormDesigner on Mon Oct 15 20:52:09 BST 2018
 */

package ATMView;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.miginfocom.swing.*;
import util.JTextFieldLimit;

/**
 * @author xiangkai22
 */
public class ATMWithdrawView extends JFrame {
    public ATMWithdrawView() {
        initComponents();
        initTextField();
    }

    private void btn_backActionPerformed(ActionEvent e) {
        this.dispose();
        new ATMMainView().run();
    }

    private void btn_Withdraw_ConfirmActionPerformed(ActionEvent e) {
        this.dispose();
        // new ATMPINView().run();
    }

    private void btn_confirmActionPerformed(ActionEvent e) {
        this.dispose();
        // new ATMPINView().run();
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
        btn_confirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_Withdraw_ConfirmActionPerformed(e);
                btn_confirmActionPerformed(e);
            }
        });
        contentPane.add(btn_confirm, "cell 2 3");

        //---- btn_back ----
        btn_back.setText("Back");
        btn_back.setFont(new Font("Segoe UI", Font.PLAIN, 16));
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

    private void initTextField() {
        tf_cardNum.setDocument(new JTextFieldLimit(16));
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
