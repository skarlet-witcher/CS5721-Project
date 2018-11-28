/*
 * Created by JFormDesigner on Sun Oct 14 19:47:04 BST 2018
 */

package view;


import controller.CustomerPINController;
import model.UserLoginPINModel;
import model.UserModel;
import net.miginfocom.swing.MigLayout;
import rpc.UserLoginReply;
import service.impl.CustomerLoginService;
import util.JTextFieldLimit;
import util.KeyPadGenerator;
import util.TimestampConvertHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Xiangkai Tang
 */
public class CustomerPINView extends JFrame {
    private CustomerPINController customerPINController;
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    public JLabel lbl_PIN;
    public JButton btn_1;
    public JButton btn_2;
    public JButton btn_3;
    public JButton btn_4;
    public JButton btn_5;
    public JButton btn_6;
    public JButton btn_7;
    public JButton btn_8;
    public JButton btn_9;
    public JButton btn_10;
    public JButton btn_backSpace;
    public JButton btn_confirm;
    public JButton btn_back;
    public JButton btn_forgotPIN;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public CustomerPINView(long userId,List<Integer> pinList) {
        customerPINController = new CustomerPINController(this, userId, pinList);
        customerPINController.initialize();
    }

    public void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        lbl_PIN = new JLabel();
        btn_1 = new JButton();
        btn_2 = new JButton();
        btn_3 = new JButton();
        btn_4 = new JButton();
        btn_5 = new JButton();
        btn_6 = new JButton();
        btn_7 = new JButton();
        btn_8 = new JButton();
        btn_9 = new JButton();
        btn_10 = new JButton();
        btn_backSpace = new JButton();
        btn_confirm = new JButton();
        btn_back = new JButton();
        btn_forgotPIN = new JButton();

        //======== this ========
        setTitle("Customer PIN View");
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[5:n,grow,fill]" +
            "[fill]" +
            "[40:n,fill]" +
            "[40:n,fill]" +
            "[40:n,fill]" +
            "[5:n,grow,fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[5:n,grow,fill]"));

        //---- lbl_PIN ----
        lbl_PIN.setText("PIN: ");
        contentPane.add(lbl_PIN, "cell 1 0");

        //---- btn_1 ----
        btn_1.setText("text");
        btn_1.addActionListener(e -> customerPINController.btn_1ActionPerformed(e));
        contentPane.add(btn_1, "cell 2 1");

        //---- btn_2 ----
        btn_2.setText("text");
        btn_2.addActionListener(e -> customerPINController.btn_2ActionPerformed(e));
        contentPane.add(btn_2, "cell 3 1");

        //---- btn_3 ----
        btn_3.setText("text");
        btn_3.addActionListener(e -> customerPINController.btn_3ActionPerformed(e));
        contentPane.add(btn_3, "cell 4 1");

        //---- btn_4 ----
        btn_4.setText("text");
        btn_4.addActionListener(e -> customerPINController.btn_4ActionPerformed(e));
        contentPane.add(btn_4, "cell 2 2");

        //---- btn_5 ----
        btn_5.setText("text");
        btn_5.addActionListener(e -> customerPINController.btn_5ActionPerformed(e));
        contentPane.add(btn_5, "cell 3 2");

        //---- btn_6 ----
        btn_6.setText("text");
        btn_6.addActionListener(e -> customerPINController.btn_6ActionPerformed(e));
        contentPane.add(btn_6, "cell 4 2");

        //---- btn_7 ----
        btn_7.setText("text");
        btn_7.addActionListener(e -> customerPINController.btn_7ActionPerformed(e));
        contentPane.add(btn_7, "cell 2 3");

        //---- btn_8 ----
        btn_8.setText("text");
        btn_8.addActionListener(e -> customerPINController.btn_8ActionPerformed(e));
        contentPane.add(btn_8, "cell 3 3");

        //---- btn_9 ----
        btn_9.setText("text");
        btn_9.addActionListener(e -> customerPINController.btn_9ActionPerformed(e));
        contentPane.add(btn_9, "cell 4 3");

        //---- btn_10 ----
        btn_10.setText("text");
        btn_10.addActionListener(e -> customerPINController.btn_10ActionPerformed(e));
        contentPane.add(btn_10, "cell 2 4 2 1");

        //---- btn_backSpace ----
        btn_backSpace.setText("Backspace");
        btn_backSpace.addActionListener(e -> customerPINController.btn_backSpaceActionPerformed(e));
        contentPane.add(btn_backSpace, "cell 4 4");

        //---- btn_confirm ----
        btn_confirm.setText("Confirm");
        btn_confirm.addActionListener(e -> customerPINController.btn_confirmActionPerformed(e));
        contentPane.add(btn_confirm, "cell 2 6 3 1");

        //---- btn_back ----
        btn_back.setText("Back");
        btn_back.addActionListener(e -> customerPINController.btn_backActionPerformed(e));
        contentPane.add(btn_back, "cell 2 6 3 1");

        //---- btn_forgotPIN ----
        btn_forgotPIN.setText("Forgot PIN ?");
        btn_forgotPIN.addActionListener(e -> customerPINController.btn_forgotPINActionPerformed(e));
        contentPane.add(btn_forgotPIN, "cell 2 7 3 1");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
}
