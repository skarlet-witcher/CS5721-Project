/*
 * Created by JFormDesigner on Mon Oct 15 20:01:50 BST 2018
 */

package ATMView;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author xiangkai22
 */
public class ATMMainView extends JFrame {
    public ATMMainView() {
        initComponents();
    }

    private void button2ActionPerformed(ActionEvent e) {

    }

    private void btn_withdrawActionPerformed(ActionEvent e) {
        this.dispose();
        new ATMWithdrawView().run();
    }

    private void btn_depositActionPerformed(ActionEvent e) {
        this.dispose();
        new ATMDepositView().run();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        btn_withdraw = new JButton();
        btn_deposit = new JButton();

        //======== this ========
        setTitle("ATM Main View");
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[100:n,fill]" +
            "[200:n,fill]" +
            "[100:n,fill]",
            // rows
            "[100:n]" +
            "[]" +
            "[30:n]" +
            "[]" +
            "[100:n]"));

        //---- btn_withdraw ----
        btn_withdraw.setText("Withdraw");
        btn_withdraw.setMinimumSize(new Dimension(85, 50));
        btn_withdraw.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        btn_withdraw.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_withdrawActionPerformed(e);
                btn_withdrawActionPerformed(e);
            }
        });
        contentPane.add(btn_withdraw, "cell 1 1");

        //---- btn_deposit ----
        btn_deposit.setText("Deposit");
        btn_deposit.setMinimumSize(new Dimension(78, 50));
        btn_deposit.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        btn_deposit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                button2ActionPerformed(e);
                btn_depositActionPerformed(e);
            }
        });
        contentPane.add(btn_deposit, "cell 1 3");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }


    public void run(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JButton btn_withdraw;
    private JButton btn_deposit;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
