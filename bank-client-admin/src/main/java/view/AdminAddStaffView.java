/*
 * Created by JFormDesigner on Sat Oct 20 16:04:03 BST 2018
 */

package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author xiangkai22
 */
public class AdminAddStaffView extends JFrame {
    public AdminAddStaffView() {
        initComponents();
    }

    private void btn_backActionPerformed(ActionEvent e) {
        this.dispose();
        new AdminMainView().run();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        lbl_firstName = new JLabel();
        tf_firstName = new JTextField();
        lbl_lastName = new JLabel();
        tf_lastName = new JTextField();
        lbl_email = new JLabel();
        tf_email = new JTextField();
        btn_add = new JButton();
        btn_back = new JButton();

        //======== this ========
        setTitle("Admin Add Staff View");
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
            "[]" +
            "[100:n]"));

        //---- lbl_firstName ----
        lbl_firstName.setText("First Name");
        lbl_firstName.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        contentPane.add(lbl_firstName, "cell 1 1");

        //---- tf_firstName ----
        tf_firstName.setMinimumSize(new Dimension(100, 24));
        contentPane.add(tf_firstName, "cell 2 1");

        //---- lbl_lastName ----
        lbl_lastName.setText("Last Name");
        lbl_lastName.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        contentPane.add(lbl_lastName, "cell 1 2");

        //---- tf_lastName ----
        tf_lastName.setMinimumSize(new Dimension(100, 24));
        contentPane.add(tf_lastName, "cell 2 2");

        //---- lbl_email ----
        lbl_email.setText("Email");
        lbl_email.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        contentPane.add(lbl_email, "cell 1 3");

        //---- tf_email ----
        tf_email.setMinimumSize(new Dimension(100, 24));
        contentPane.add(tf_email, "cell 2 3");

        //---- btn_add ----
        btn_add.setText("Add");
        btn_add.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        contentPane.add(btn_add, "cell 1 4 2 1");

        //---- btn_back ----
        btn_back.setText("Back");
        btn_back.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        btn_back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_backActionPerformed(e);
            }
        });
        contentPane.add(btn_back, "cell 1 5 2 1");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    public void run() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel lbl_firstName;
    private JTextField tf_firstName;
    private JLabel lbl_lastName;
    private JTextField tf_lastName;
    private JLabel lbl_email;
    private JTextField tf_email;
    private JButton btn_add;
    private JButton btn_back;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
