/*
 * Created by JFormDesigner on Sun Oct 14 17:44:11 BST 2018
 */

package view;

import java.awt.*;
import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author xiangkai22
 */
public class CustomerApplyView extends JFrame {
    public CustomerApplyView() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        textField2 = new JTextField();
        label3 = new JLabel();
        comboBox1 = new JComboBox();
        label4 = new JLabel();
        comboBox2 = new JComboBox();
        label5 = new JLabel();
        textField3 = new JTextField();
        label6 = new JLabel();
        comboBox3 = new JComboBox();
        label15 = new JLabel();
        comboBox4 = new JComboBox();
        label7 = new JLabel();
        textField4 = new JTextField();
        label8 = new JLabel();
        textField5 = new JTextField();
        label9 = new JLabel();
        textField6 = new JTextField();
        label10 = new JLabel();
        textField7 = new JTextField();
        label11 = new JLabel();
        textField8 = new JTextField();
        label12 = new JLabel();
        textField9 = new JTextField();
        label13 = new JLabel();
        textField10 = new JTextField();
        label14 = new JLabel();
        textField11 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        setTitle("Customer Apply View");
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[30:n,fill]" +
            "[fill]" +
            "[fill]" +
            "[30:n,fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //---- label1 ----
        label1.setText("First Name");
        contentPane.add(label1, "cell 1 0");
        contentPane.add(textField1, "cell 2 0");

        //---- label2 ----
        label2.setText("Last Name");
        contentPane.add(label2, "cell 1 1");
        contentPane.add(textField2, "cell 2 1");

        //---- label3 ----
        label3.setText("Gender");
        contentPane.add(label3, "cell 1 2");

        //---- comboBox1 ----
        comboBox1.setModel(new DefaultComboBoxModel(new String[] {
            "Select Your Gender",
            "Male",
            "Female"
        }));
        contentPane.add(comboBox1, "cell 2 2");

        //---- label4 ----
        label4.setText("Identity Type");
        contentPane.add(label4, "cell 1 3");

        //---- comboBox2 ----
        comboBox2.setModel(new DefaultComboBoxModel(new String[] {
            "Select Yout Identity Type",
            "Driving License",
            "Passport"
        }));
        contentPane.add(comboBox2, "cell 2 3");

        //---- label5 ----
        label5.setText("Identity Number");
        contentPane.add(label5, "cell 1 4");
        contentPane.add(textField3, "cell 2 4");

        //---- label6 ----
        label6.setText("Account Type");
        contentPane.add(label6, "cell 1 5");

        //---- comboBox3 ----
        comboBox3.setModel(new DefaultComboBoxModel(new String[] {
            "Select Your Account Type",
            "Current Account",
            "Student Current Account"
        }));
        contentPane.add(comboBox3, "cell 2 5");

        //---- label15 ----
        label15.setText("Card Type");
        contentPane.add(label15, "cell 1 6");

        //---- comboBox4 ----
        comboBox4.setModel(new DefaultComboBoxModel(new String[] {
            "Select Your Card Type",
            "Debit Card",
            "Credit Card"
        }));
        contentPane.add(comboBox4, "cell 2 6");

        //---- label7 ----
        label7.setText("Graduate Date");
        contentPane.add(label7, "cell 1 7");
        contentPane.add(textField4, "cell 2 7");

        //---- label8 ----
        label8.setText("/");
        label8.setPreferredSize(new Dimension(2, 10));
        label8.setHorizontalTextPosition(SwingConstants.CENTER);
        label8.setMinimumSize(new Dimension(1, 16));
        contentPane.add(label8, "cell 2 7");
        contentPane.add(textField5, "cell 2 7");

        //---- label9 ----
        label9.setText("Date of Birth");
        contentPane.add(label9, "cell 1 8");
        contentPane.add(textField6, "cell 2 8");

        //---- label10 ----
        label10.setText("/");
        contentPane.add(label10, "cell 2 8");
        contentPane.add(textField7, "cell 2 8");

        //---- label11 ----
        label11.setText("/");
        contentPane.add(label11, "cell 2 8");
        contentPane.add(textField8, "cell 2 8");

        //---- label12 ----
        label12.setText("Address");
        contentPane.add(label12, "cell 1 9");
        contentPane.add(textField9, "cell 2 9");

        //---- label13 ----
        label13.setText("Email");
        contentPane.add(label13, "cell 1 10");
        contentPane.add(textField10, "cell 2 10");

        //---- label14 ----
        label14.setText("Contact Number");
        contentPane.add(label14, "cell 1 11");
        contentPane.add(textField11, "cell 2 11");

        //---- button1 ----
        button1.setText("Apply");
        contentPane.add(button1, "cell 2 12");

        //---- button2 ----
        button2.setText("Back");
        contentPane.add(button2, "cell 2 13");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    public void run() {
        this.setVisible(true);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JTextField textField2;
    private JLabel label3;
    private JComboBox comboBox1;
    private JLabel label4;
    private JComboBox comboBox2;
    private JLabel label5;
    private JTextField textField3;
    private JLabel label6;
    private JComboBox comboBox3;
    private JLabel label15;
    private JComboBox comboBox4;
    private JLabel label7;
    private JTextField textField4;
    private JLabel label8;
    private JTextField textField5;
    private JLabel label9;
    private JTextField textField6;
    private JLabel label10;
    private JTextField textField7;
    private JLabel label11;
    private JTextField textField8;
    private JLabel label12;
    private JTextField textField9;
    private JLabel label13;
    private JTextField textField10;
    private JLabel label14;
    private JTextField textField11;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
