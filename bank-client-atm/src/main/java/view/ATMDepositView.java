/*
 * Created by JFormDesigner on Sat Oct 20 15:14:16 BST 2018
 */

package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author xiangkai22
 */
public class ATMDepositView extends JFrame {
    public ATMDepositView(long cardNum) {
        initComponents();
        setCardNum(cardNum);
    }

    private void btn_backActionPerformed(ActionEvent e) {
        this.dispose();
        new ATMMainView(cardNum).run();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        textField2 = new JTextField();
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
            "[]" +
            "[]" +
            "[]" +
            "[100:n]"));

        //---- label1 ----
        label1.setText("Balance");
        label1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        contentPane.add(label1, "cell 1 1");

        //---- textField1 ----
        textField1.setMinimumSize(new Dimension(100, 24));
        textField1.setEditable(false);
        contentPane.add(textField1, "cell 2 1");

        //---- label2 ----
        label2.setText("Amounts");
        label2.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        contentPane.add(label2, "cell 1 2");

        //---- textField2 ----
        textField2.setMinimumSize(new Dimension(100, 24));
        contentPane.add(textField2, "cell 2 2");

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

    private void setCardNum(long cardNum) {
        this.cardNum = cardNum;
    }


    public void run() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    private long cardNum;
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JTextField textField2;
    private JButton btn_confirm;
    private JButton btn_back;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
