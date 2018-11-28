/*
 * Created by JFormDesigner on Wed Oct 17 08:55:51 BST 2018
 */

package view;

import controller.CustomerAddPayeeController;
import model.UserModel;
import model.UserPayeeModel;
import net.miginfocom.swing.MigLayout;
import service.impl.CustomerPayeeService;
import util.JTextFieldLimit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author xiangkai22
 */
public class CustomerAddPayeeView extends JFrame {
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    public JLabel lbl_payeeName;
    public JTextField tf_payeeName;
    public JLabel lbl_IBAN;
    public JTextField tf_IBAN;
    public JLabel lbl_pin;
    public JPasswordField pf_pin;
    public JButton btn_add;
    public JButton btn_back;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private CustomerAddPayeeController customerAddPayeeController;
    public CustomerAddPayeeView(UserModel userModel, CustomerMainView customerMainView) {
        customerAddPayeeController = new CustomerAddPayeeController(this, customerMainView, userModel);
        customerAddPayeeController.initialize();
    }

    public void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        lbl_payeeName = new JLabel();
        tf_payeeName = new JTextField();
        lbl_IBAN = new JLabel();
        tf_IBAN = new JTextField();
        lbl_pin = new JLabel();
        pf_pin = new JPasswordField();
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
            "[]0" +
            "[]0" +
            "[]0" +
            "[]0" +
            "[]0" +
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

        //---- lbl_pin ----
        lbl_pin.setText("PIN");
        contentPane.add(lbl_pin, "cell 1 3");
        contentPane.add(pf_pin, "cell 2 3");

        //---- btn_add ----
        btn_add.setText("Add");
        btn_add.addActionListener(e -> customerAddPayeeController.btn_addActionPerformed(e));
        contentPane.add(btn_add, "cell 2 8");

        //---- btn_back ----
        btn_back.setText("Back");
        btn_back.addActionListener(e -> customerAddPayeeController.btn_backActionPerformed(e));
        contentPane.add(btn_back, "cell 2 9");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    public void run() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}
