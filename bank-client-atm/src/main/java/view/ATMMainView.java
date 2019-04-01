/*
 * Created by JFormDesigner on Wed Oct 17 10:47:22 BST 2018
 */

package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author xiangkai22
 */
public class ATMMainView extends JFrame {
    public ATMMainView(long cardNum) {
        initComponents();
        setCardNum(cardNum);
    }

    private void btn_exitActionPerformed(ActionEvent e) {
        this.dispose();
        new ATMLoginView().run();
    }

    private void btn_withdrawActionPerformed(ActionEvent e) {
        this.dispose();
        new ATMPINView(cardNum).run();
//        new ATMWithdrawView(cardNum).run();
    }

    private void btn_depositActionPerformed(ActionEvent e) {
        this.dispose();
        new ATMDepositView(cardNum).run();
    }

    private void setCardNum(long cardNum) {
        this.cardNum = cardNum;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        llbl_title = new JLabel();
        btn_withdraw = new JButton();
        btn_deposit = new JButton();
        btn_exit = new JButton();

        //======== this ========
        setTitle("ATM Main View");
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[100:n,fill]" +
            "[fill]" +
            "[100:n,fill]",
            // rows
            "[50:n]" +
            "[]" +
            "[30:n]" +
            "[]" +
            "[30:n]0" +
            "[]" +
            "[50:n]"));

        //---- llbl_title ----
        llbl_title.setText("Welcome to ATM System");
        llbl_title.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        contentPane.add(llbl_title, "cell 1 0");

        //---- btn_withdraw ----
        btn_withdraw.setText("Withdraw");
        btn_withdraw.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        btn_withdraw.setMinimumSize(new Dimension(120, 40));
        btn_withdraw.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_withdrawActionPerformed(e);
            }
        });
        contentPane.add(btn_withdraw, "cell 1 1");

        //---- btn_deposit ----
        btn_deposit.setText("Deposit");
        btn_deposit.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        btn_deposit.setMinimumSize(new Dimension(200, 40));
        btn_deposit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_depositActionPerformed(e);
            }
        });
        contentPane.add(btn_deposit, "cell 1 3");

        //---- btn_exit ----
        btn_exit.setText("Exit");
        btn_exit.setMinimumSize(new Dimension(200, 40));
        btn_exit.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        btn_exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_exitActionPerformed(e);
            }
        });
        contentPane.add(btn_exit, "cell 1 5");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    public void run() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private long cardNum;
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel llbl_title;
    private JButton btn_withdraw;
    private JButton btn_deposit;
    private JButton btn_exit;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
