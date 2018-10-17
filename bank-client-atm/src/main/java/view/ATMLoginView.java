/*
 * Created by JFormDesigner on Wed Oct 17 09:26:24 BST 2018
 */

package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author xiangkai22
 */
public class ATMLoginView extends JFrame {
    public ATMLoginView() {
        initComponents();
    }

    private void btn_continueActionPerformed(ActionEvent e) {
        // TODO add your code here
        this.dispose();
        new ATMMainView().run();
    }

    public void run() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        lbl_title = new JLabel();
        lbl_cardNum = new JLabel();
        tf_cardNum = new JTextField();
        btn_continue = new JButton();

        //======== this ========
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
            "[100:n]"));

        //---- lbl_title ----
        lbl_title.setText("Welcome to ATM");
        lbl_title.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_title.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        contentPane.add(lbl_title, "cell 1 0 2 1");

        //---- lbl_cardNum ----
        lbl_cardNum.setText("Card number");
        lbl_cardNum.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        contentPane.add(lbl_cardNum, "cell 1 1");

        //---- tf_cardNum ----
        tf_cardNum.setMinimumSize(new Dimension(100, 30));
        contentPane.add(tf_cardNum, "cell 2 1");

        //---- btn_continue ----
        btn_continue.setText("Continue");
        btn_continue.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        btn_continue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_continueActionPerformed(e);
            }
        });
        contentPane.add(btn_continue, "cell 2 2");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel lbl_title;
    private JLabel lbl_cardNum;
    private JTextField tf_cardNum;
    private JButton btn_continue;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
