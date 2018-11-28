/*
 * Created by JFormDesigner on Wed Oct 24 21:45:10 BST 2018
 */

package view;

import Const.UserType;
import model.UserModel;
import net.miginfocom.swing.MigLayout;
import service.impl.CustomerApplyService;
import util.JTextFieldLimit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author xiangkai Tang
 */
public class CustomerApplyAuthView extends JFrame {
    public CustomerApplyAuthView() {
        initComponents();
        resetAllPanel();
        initTextField();
    }

    private void btn_backActionPerformed(ActionEvent e) {
        this.dispose();
        new CustomerLoginView();
    }

    private void cb_isExistingActionPerformed(ActionEvent e) {
        // choose the type of user
        if(cb_isExisting.getSelectedIndex() == 0) {
            resetAllPanel();
            pack();
        }
        if(cb_isExisting.getSelectedIndex() == 1) {
            resetAllPanel();
            this.existingCustomerPanel.setVisible(true);
            pack();
        }
        if(cb_isExisting.getSelectedIndex() == 2) {
            resetAllPanel();
            this.noneCustomerPanel.setVisible(true);
            pack();
        }
    }

    private void resetAllPanel() {
        this.existingCustomerPanel.setVisible(false);
        this.noneCustomerPanel.setVisible(false);
    }


    private void initTextField() {
        tf_userId.setDocument(new JTextFieldLimit(10));
        tf_firstName.setDocument(new JTextFieldLimit(20));
        tf_lastName.setDocument(new JTextFieldLimit(20));
        tf_identityNum.setDocument(new JTextFieldLimit(15));
    }

    private void btn_none_nextActionPerformed(ActionEvent e) {
        // non-existing user
        this.dispose();
        new CustomerApplyView().run();
    }


    private void btn_customer_nextActionPerformed(ActionEvent e) {
        // existing user
        if(cb_isExisting.getSelectedIndex() == 1) {
            // UserId validator
            if(tf_userId.getText().trim().length() <= 0) {
                JOptionPane.showMessageDialog(null,
                        "Please input UserId",
                        "Error Message", JOptionPane.ERROR_MESSAGE);
                tf_userId.grabFocus();
                return;
            }
            if(tf_userId.getText().trim().length() != 10) {
                JOptionPane.showMessageDialog(null,
                        "User id must be 10 digits",
                        "Error Message", JOptionPane.ERROR_MESSAGE);
                tf_userId.grabFocus();
                return;
            }
            if(!tf_userId.getText().trim().matches("^[0-9]*$")) {
                JOptionPane.showMessageDialog(null,
                        "User id should be numeric",
                        "Error Message",JOptionPane.ERROR_MESSAGE);
                tf_userId.grabFocus();
                return;
            }

            // First Name validator
            if(tf_firstName.getText().trim().length() <= 0) {
                JOptionPane.showMessageDialog(null,
                        "Please input your first name",
                        "Error Message", JOptionPane.ERROR_MESSAGE);
                tf_firstName.grabFocus();
                return;
            } if(!tf_firstName.getText().trim().matches("^[a-zA-Z]+$")) {
                JOptionPane.showMessageDialog(null,
                        "First name should only contain characters",
                        "Error Message", JOptionPane.ERROR_MESSAGE);
                tf_firstName.grabFocus();
                return;
            }

            // Last name validator
            if(tf_lastName.getText().trim().length() <= 0) {
                JOptionPane.showMessageDialog(null,
                        "Please input your last name",
                        "Error Message", JOptionPane.ERROR_MESSAGE);
                tf_lastName.grabFocus();
                return;
            } if(!tf_lastName.getText().trim().matches("^[a-zA-Z]+$")) {
                JOptionPane.showMessageDialog(null,
                        "First name should only contain characters",
                        "Error Message", JOptionPane.ERROR_MESSAGE);
                tf_lastName.grabFocus();
                return;
            }

            // identity type validator
            if(cb_identityTypeList.getSelectedIndex() <= 0) {
                JOptionPane.showMessageDialog(null,
                        "Please select your identity type",
                        "Error Message",JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Identity number validator
            if(tf_identityNum.getText().trim().length() <= 0) {
                JOptionPane.showMessageDialog(null,
                        "Please input your identity number",
                        "Error Message",JOptionPane.ERROR_MESSAGE);
                tf_identityNum.grabFocus();
                return;
            }
            if(!tf_identityNum.getText().trim().matches("^[a-zA-Z0-9]*$")) {
                JOptionPane.showMessageDialog(null,
                        "Identity number should only contain numbers and letters",
                        "Error Message",JOptionPane.ERROR_MESSAGE);
                tf_identityNum.grabFocus();
                return;
            }
        }

        Long userId = Long.parseLong(tf_userId.getText().trim());
        String firstName = tf_firstName.getText().trim();
        String lastName = tf_lastName.getText().trim();
        int identityType = cb_identityTypeList.getSelectedIndex();
        String identityNum = tf_identityNum.getText().trim();

        UserModel userModel = new UserModel();
        userModel.setUserId(userId);
        userModel.setFirstName(firstName);
        userModel.setLastName(lastName);

        try {
            CustomerApplyService.getInstance().checkExistingUserBeforeApply(userModel);

        } catch (Exception E) {
            JOptionPane.showMessageDialog(null,
                    E.getMessage(),
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            E.printStackTrace();
            return;
        }
        this.dispose();
        new CustomerApplyView(userId, identityType, identityNum, UserType.EXISTING_USER).run();
    }

    public void run() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void initComponents() {
        setTitle("Apply view");

        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        lbl_isExist = new JLabel();
        cb_isExisting = new JComboBox<>();
        existingCustomerPanel = new JPanel();
        lbl_userId = new JLabel();
        tf_userId = new JTextField();
        tf_firstName = new JTextField();
        lbl_firstName = new JLabel();
        lbl_lastName = new JLabel();
        tf_lastName = new JTextField();
        lbl_identityType = new JLabel();
        cb_identityTypeList = new JComboBox<>();
        lbl_identityNum = new JLabel();
        tf_identityNum = new JTextField();
        btn_customer_next = new JButton();
        noneCustomerPanel = new JPanel();
        btn_none_next = new JButton();
        btn_back = new JButton();

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
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //---- lbl_isExist ----
        lbl_isExist.setText("Existing Customer ?");
        lbl_isExist.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        contentPane.add(lbl_isExist, "cell 1 1");

        //---- cb_isExisting ----
        cb_isExisting.setModel(new DefaultComboBoxModel<>(new String[] {
            "Please Select",
            "Yes",
            "No"
        }));
        cb_isExisting.addActionListener(e -> cb_isExistingActionPerformed(e));
        contentPane.add(cb_isExisting, "cell 2 1");

        //======== existingCustomerPanel ========
        {
            existingCustomerPanel.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[fill]" +
                "[fill]" +
                "[fill]",
                // rows
                "[]" +
                "[]" +
                "[]0" +
                "[]0" +
                "[]" +
                "[]" +
                "[]"));

            //---- lbl_userId ----
            lbl_userId.setText("User Id");
            lbl_userId.setFont(new Font("Segoe UI", Font.PLAIN, 16));
            existingCustomerPanel.add(lbl_userId, "cell 0 0");

            //---- tf_userId ----
            tf_userId.setMinimumSize(new Dimension(100, 24));
            existingCustomerPanel.add(tf_userId, "cell 1 0");

            //---- tf_firstName ----
            tf_firstName.setMinimumSize(new Dimension(100, 24));
            existingCustomerPanel.add(tf_firstName, "cell 1 1");

            //---- lbl_firstName ----
            lbl_firstName.setText("First name");
            lbl_firstName.setFont(new Font("Segoe UI", Font.PLAIN, 16));
            existingCustomerPanel.add(lbl_firstName, "cell 0 1");

            //---- lbl_lastName ----
            lbl_lastName.setText("Last name");
            lbl_lastName.setFont(new Font("Segoe UI", Font.PLAIN, 16));
            existingCustomerPanel.add(lbl_lastName, "cell 0 2");

            //---- tf_lastName ----
            tf_lastName.setMinimumSize(new Dimension(100, 24));
            existingCustomerPanel.add(tf_lastName, "cell 1 2");

            //---- lbl_identityType ----
            lbl_identityType.setText("Identity Type");
            lbl_identityType.setFont(new Font("Segoe UI", Font.PLAIN, 16));
            existingCustomerPanel.add(lbl_identityType, "cell 0 4");

            //---- cb_identityTypeList ----
            cb_identityTypeList.setModel(new DefaultComboBoxModel<>(new String[] {
                "Select Your Identity Type",
                "Driving License",
                "Passport"
            }));
            existingCustomerPanel.add(cb_identityTypeList, "cell 1 4");

            //---- lbl_identityNum ----
            lbl_identityNum.setText("Identity Number");
            lbl_identityNum.setFont(new Font("Segoe UI", Font.PLAIN, 16));
            existingCustomerPanel.add(lbl_identityNum, "cell 0 5");
            existingCustomerPanel.add(tf_identityNum, "cell 1 5");

            //---- btn_customer_next ----
            btn_customer_next.setText("Next");
            btn_customer_next.setFont(new Font("Segoe UI", Font.PLAIN, 16));
            btn_customer_next.addActionListener(e -> btn_customer_nextActionPerformed(e));
            existingCustomerPanel.add(btn_customer_next, "cell 1 6 2 1");
        }
        contentPane.add(existingCustomerPanel, "cell 1 4 2 1");

        //======== noneCustomerPanel ========
        {
            noneCustomerPanel.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[center]",
                // rows
                "[]" +
                "[]" +
                "[]" +
                "[]"));

            //---- btn_none_next ----
            btn_none_next.setText("Next");
            btn_none_next.setFont(new Font("Segoe UI", Font.PLAIN, 16));
            btn_none_next.setMinimumSize(new Dimension(150, 24));
            btn_none_next.addActionListener(e -> btn_none_nextActionPerformed(e));
            noneCustomerPanel.add(btn_none_next, "cell 0 1 1 2");
        }
        contentPane.add(noneCustomerPanel, "cell 1 3 2 1");

        //---- btn_back ----
        btn_back.setText("Back");
        btn_back.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        btn_back.addActionListener(e -> btn_backActionPerformed(e));
        contentPane.add(btn_back, "cell 1 6 2 1");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel lbl_isExist;
    private JComboBox<String> cb_isExisting;
    private JPanel existingCustomerPanel;
    private JLabel lbl_userId;
    private JTextField tf_userId;
    private JTextField tf_firstName;
    private JLabel lbl_firstName;
    private JLabel lbl_lastName;
    private JTextField tf_lastName;
    private JLabel lbl_identityType;
    private JComboBox<String> cb_identityTypeList;
    private JLabel lbl_identityNum;
    private JTextField tf_identityNum;
    private JButton btn_customer_next;
    private JPanel noneCustomerPanel;
    private JButton btn_none_next;
    private JButton btn_back;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
