/*
 * Created by JFormDesigner on Sat Oct 20 15:45:41 BST 2018
 */

package view;

import Const.UserGenderType;
import Const.UserStatusType;
import bankStaff_rpc.AcceptedResponse;
import bankStaff_rpc.UserApplyArchiveEntitiesResponse;
import controller.StaffAddAccountInfoController;
import net.miginfocom.swing.MigLayout;
import service.impl.StaffService;
import util.TimestampConvertHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import static Const.CardType.*;
import static Const.UserAccountType.*;
import static Const.UserApplyType.DENY;
import static Const.UserApplyType.PASS;
import static Const.UserApplyType.PENDING_FOR_BEING_APPROVED;
import static Const.UserGenderType.*;
import static Const.UserStatusType.*;

/**
 * @author Long
 */
public class StaffAddAccountInfoView extends JFrame {

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    public JLabel lbl_firstName;
    public JTextField tf_firstName;
    public JPanel panel_studentAccount;
    public JLabel lbl_graduateDate;
    public JTextField tf_graduateDate;
    public JLabel lbl_studentId;
    public JTextField tf_studentId;
    public JLabel lbl_schoolName;
    public JTextField tf_schoolName;
    public JLabel lbl_lastName;
    public JTextField tf_lastName;
    public JLabel lbl_gender;
    public JTextField tf_gender;
    public JLabel lbl_accountType;
    public JTextField tf_accountType;
    public JPanel panel_youngSaverAccount;
    public JLabel lbl_parentUserId;
    public JTextField tf_parentUserId;
    public JLabel lbl_parentFirstName;
    public JTextField tf_parentFirstName;
    public JLabel lbl_parentLastName;
    public JTextField tf_parentLastName;
    public JLabel lbl_cardType;
    public JTextField tf_cardType;
    public JLabel lbl_dob;
    public JTextField tf_dob;
    public JLabel lbl_email;
    public JTextField tf_email;
    public JLabel lbl_address;
    public JTextField tf_address;
    public JLabel lbl_contactNum;
    public JTextField tf_contactNum;
    public JLabel lbl_applyTime;
    public JTextField tf_applyTime;
    public JLabel lbl_userId;
    public JTextField tf_userId;
    public JLabel lbl_accountStatus;
    public JTextField tf_status;
    public JButton btn_accept;
    public JButton btn_decline;
    public JButton btn_back;

    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private StaffAddAccountInfoController staffAddAccountInfoController;

    public StaffAddAccountInfoView(long staffId, UserApplyArchiveEntitiesResponse userApplyArchiveEntitiesResponse) {
        staffAddAccountInfoController = new StaffAddAccountInfoController(this, staffId, userApplyArchiveEntitiesResponse);
        staffAddAccountInfoController.initialize();
    }

    public void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        lbl_firstName = new JLabel();
        tf_firstName = new JTextField(20);
        panel_studentAccount = new JPanel();
        lbl_graduateDate = new JLabel();
        tf_graduateDate = new JTextField(20);
        lbl_studentId = new JLabel();
        tf_studentId = new JTextField();
        lbl_schoolName = new JLabel();
        tf_schoolName = new JTextField();
        lbl_lastName = new JLabel();
        tf_lastName = new JTextField();
        lbl_gender = new JLabel();
        tf_gender = new JTextField();
        lbl_accountType = new JLabel();
        tf_accountType = new JTextField();
        panel_youngSaverAccount = new JPanel();
        lbl_parentUserId = new JLabel();
        tf_parentUserId = new JTextField();
        lbl_parentFirstName = new JLabel();
        tf_parentFirstName = new JTextField(20);
        lbl_parentLastName = new JLabel();
        tf_parentLastName = new JTextField();
        lbl_cardType = new JLabel();
        tf_cardType = new JTextField();
        lbl_dob = new JLabel();
        tf_dob = new JTextField();
        lbl_email = new JLabel();
        tf_email = new JTextField();
        lbl_address = new JLabel();
        tf_address = new JTextField();
        lbl_contactNum = new JLabel();
        tf_contactNum = new JTextField();
        lbl_applyTime = new JLabel();
        tf_applyTime = new JTextField();
        lbl_userId = new JLabel();
        tf_userId = new JTextField();
        lbl_accountStatus = new JLabel();
        tf_status = new JTextField();
        btn_accept = new JButton();
        btn_decline = new JButton();
        btn_back = new JButton();

        //======== this ========
        setTitle("Add Account Request Info");
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[100:n,fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[100:n,fill]" +
                        "[fill]",
                // rows
                "[50:n]" +
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
                        "[]" +
                        "[]" +
                        "[100:n]"));

        //---- lbl_firstName ----
        lbl_firstName.setText("First name");
        contentPane.add(lbl_firstName, "cell 1 1");
        contentPane.add(tf_firstName, "cell 2 1");

        //======== panel_studentAccount ========
        {
            panel_studentAccount.setLayout(new MigLayout(
                    "hidemode 3",
                    // columns
                    "[fill]" +
                            "[fill]",
                    // rows
                    "[]" +
                            "[]" +
                            "[]" +
                            "[]" +
                            "[]"));

            //---- lbl_graduateDate ----
            lbl_graduateDate.setText("Graduate Date");
            panel_studentAccount.add(lbl_graduateDate, "cell 0 1");
            panel_studentAccount.add(tf_graduateDate, "cell 1 1");

            //---- lbl_studentId ----
            lbl_studentId.setText("Student ID");
            panel_studentAccount.add(lbl_studentId, "cell 0 2");
            panel_studentAccount.add(tf_studentId, "cell 1 2");

            //---- lbl_schoolName ----
            lbl_schoolName.setText("School name");
            panel_studentAccount.add(lbl_schoolName, "cell 0 3");
            panel_studentAccount.add(tf_schoolName, "cell 1 3");
        }
        contentPane.add(panel_studentAccount, "cell 3 1 1 3");

        //---- lbl_lastName ----
        lbl_lastName.setText("Last name");
        contentPane.add(lbl_lastName, "cell 1 2");
        contentPane.add(tf_lastName, "cell 2 2");

        //---- lbl_gender ----
        lbl_gender.setText("Gender");
        contentPane.add(lbl_gender, "cell 1 3");
        contentPane.add(tf_gender, "cell 2 3");

        //---- lbl_accountType ----
        lbl_accountType.setText("Account type");
        contentPane.add(lbl_accountType, "cell 1 4");
        contentPane.add(tf_accountType, "cell 2 4");

        //======== panel_youngSaverAccount ========
        {
            panel_youngSaverAccount.setLayout(new MigLayout(
                    "hidemode 3",
                    // columns
                    "[fill]" +
                            "[fill]",
                    // rows
                    "[]" +
                            "[]" +
                            "[]" +
                            "[]" +
                            "[]" +
                            "[]"));

            //---- lbl_parentUserId ----
            lbl_parentUserId.setText("Parent User ID");
            panel_youngSaverAccount.add(lbl_parentUserId, "cell 0 1");
            panel_youngSaverAccount.add(tf_parentUserId, "cell 1 1");

            //---- lbl_parentFirstName ----
            lbl_parentFirstName.setText("Parent First name");
            panel_youngSaverAccount.add(lbl_parentFirstName, "cell 0 2");
            panel_youngSaverAccount.add(tf_parentFirstName, "cell 1 2");

            //---- lbl_parentLastName ----
            lbl_parentLastName.setText("Parent Last name");
            panel_youngSaverAccount.add(lbl_parentLastName, "cell 0 3");
            panel_youngSaverAccount.add(tf_parentLastName, "cell 1 3");
        }
        contentPane.add(panel_youngSaverAccount, "cell 3 4 1 3");

        //---- lbl_cardType ----
        lbl_cardType.setText("Card Type");
        contentPane.add(lbl_cardType, "cell 1 5");
        contentPane.add(tf_cardType, "cell 2 5");

        //---- lbl_dob ----
        lbl_dob.setText("Date of birth");
        contentPane.add(lbl_dob, "cell 1 6");
        contentPane.add(tf_dob, "cell 2 6");

        //---- lbl_email ----
        lbl_email.setText("Email");
        contentPane.add(lbl_email, "cell 1 7");
        contentPane.add(tf_email, "cell 2 7");

        //---- lbl_address ----
        lbl_address.setText("Address");
        contentPane.add(lbl_address, "cell 1 8");
        contentPane.add(tf_address, "cell 2 8");

        //---- lbl_contactNum ----
        lbl_contactNum.setText("Contact number");
        contentPane.add(lbl_contactNum, "cell 1 9");
        contentPane.add(tf_contactNum, "cell 2 9");

        //---- lbl_applyTime ----
        lbl_applyTime.setText("Apply time");
        contentPane.add(lbl_applyTime, "cell 1 10");
        contentPane.add(tf_applyTime, "cell 2 10");

        //---- lbl_userId ----
        lbl_userId.setText("User ID");
        contentPane.add(lbl_userId, "cell 1 11");
        contentPane.add(tf_userId, "cell 2 11");

        //---- lbl_accountStatus ----
        lbl_accountStatus.setText("Account status");
        contentPane.add(lbl_accountStatus, "cell 1 12");
        contentPane.add(tf_status, "cell 2 12");

        //---- btn_accept ----
        btn_accept.setText("Accept");
        btn_accept.addActionListener(e -> staffAddAccountInfoController.btn_acceptActionPerformed(e));
        contentPane.add(btn_accept, "cell 1 13 2 1");

        //---- btn_decline ----
        btn_decline.setText("Decline");
        btn_decline.addActionListener(e -> staffAddAccountInfoController.btn_declineActionPerformed(e));
        contentPane.add(btn_decline, "cell 1 14 2 1");

        //---- btn_back ----
        btn_back.setText("Back");
        btn_back.addActionListener(e -> staffAddAccountInfoController.btn_backActionPerformed(e));
        contentPane.add(btn_back, "cell 1 15 2 1");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

}
