/*
 * Created by JFormDesigner on Thu Oct 25 17:21:29 BST 2018
 */

package view;

import model.*;
import net.miginfocom.swing.MigLayout;
import service.impl.CustomerApplyService;
import util.JTextFieldLimit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Timestamp;
import java.util.Calendar;

/**
 * @author xiangkai22
 */
public class CustomerExistingApply extends JFrame {
    public CustomerExistingApply(Long userId, int identityType, String identityNum) {
        initComponents();
        initTextField(userId, identityType, identityNum);
        resetAccountField();
    }

    private void cb_accountTypeListActionPerformed(ActionEvent e) {
        if(cb_accountTypeList.getSelectedIndex() == 0 ||
                cb_accountTypeList.getSelectedIndex() == 3) {
            resetAccountField();
            pack();
        }
        if (cb_accountTypeList.getSelectedIndex() == 1) {
            resetAccountField();
            initStudentAccountField();
            pack();
        }
        if (cb_accountTypeList.getSelectedIndex() == 2) {
            resetAccountField();
            initYoungSaverAccountField();
            pack();
        }
    }

    private void tf_graduateMonthFocusLost(FocusEvent e) {
        // if input one digit of a month, add 0 before that
        if(tf_graduateMonth.getText().trim().length() == 1) {
            tf_graduateMonth.setText("0" + tf_graduateMonth.getText());
        }
    }

    private void tf_graduateMonthFocusGained(FocusEvent e) {
        tf_graduateMonth.selectAll();
    }

    private void tf_graduateYearFocusGained(FocusEvent e) {
        tf_graduateYear.selectAll();
    }

    public void run() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void initTextField(Long userId, int identityType, String identityNum) {
        this.userId = userId;
        this.identityType = identityType;
        this.identityNum = identityNum;

        tf_userId.setText(this.userId.toString());

        tf_graduateMonth.setDocument(new JTextFieldLimit(2));
        tf_graduateYear.setDocument(new JTextFieldLimit(4));
        tf_studentID.setDocument(new JTextFieldLimit(8));
        tf_schoolName.setDocument(new JTextFieldLimit(50));
        tf_parentUserID.setDocument(new JTextFieldLimit(13));
        tf_parentFirstName.setDocument(new JTextFieldLimit(20));
        tf_parentLastName.setDocument(new JTextFieldLimit(20));

    }

    private void resetAccountField() {
        studentAccountPanel.setVisible(false);
        youngSaverAccountPanel.setVisible(false);
    }

    private void initStudentAccountField() {
        studentAccountPanel.setVisible(true);
    }

    private void initYoungSaverAccountField() {
        youngSaverAccountPanel.setVisible(true);
    }

    private void btn_backActionPerformed(ActionEvent e) {
        this.dispose();
        new CustomerLoginView().run();
    }

    private void btn_applyActionPerformed(ActionEvent e) {
        // account type validator
        if(cb_accountTypeList.getSelectedIndex() == 1){
            // student account validator

            // graduate month validator
            if(tf_graduateMonth.getText().trim().length() <= 0) {
                JOptionPane.showMessageDialog(null,
                        "Please input your graduate month",
                        "Error Message",JOptionPane.ERROR_MESSAGE);
                tf_graduateMonth.grabFocus();
                return;
            }
            if(!tf_graduateMonth.getText().trim().matches("^[0-9]*$")) {
                JOptionPane.showMessageDialog(null,
                        "The graduate month should be numeric",
                        "Error Message",JOptionPane.ERROR_MESSAGE);
                tf_graduateMonth.grabFocus();
                return;
            }
            if(Integer.parseInt(tf_graduateMonth.getText().trim()) > 12 || Integer.parseInt(tf_graduateMonth.getText().trim()) < 1) {
                JOptionPane.showMessageDialog(null,
                        "The ranage of graduate month should be 1 to 12",
                        "Error Message",JOptionPane.ERROR_MESSAGE);
                tf_graduateMonth.grabFocus();
                return;
            }

            // graduate year validator
            int currentYear = Calendar.getInstance().get(Calendar.YEAR);
            if(tf_graduateYear.getText().trim().length() <= 0) {
                JOptionPane.showMessageDialog(null,
                        "Please input your graduate month",
                        "Error Message",JOptionPane.ERROR_MESSAGE);
                tf_graduateYear.grabFocus();
                return;
            } if(!tf_graduateYear.getText().trim().matches("^[0-9]*$")) {
                JOptionPane.showMessageDialog(null,
                        "Graduate year should only contain numbers",
                        "Error Message",JOptionPane.ERROR_MESSAGE);
                tf_graduateYear.grabFocus();
                return;
            }
            if(tf_graduateYear.getText().length() < 4) {
                JOptionPane.showMessageDialog(null,
                        "Graduate year should be four digits",
                        "Error Message",JOptionPane.ERROR_MESSAGE);
                tf_graduateYear.grabFocus();
                return;
            }
            if(Integer.parseInt(tf_graduateYear.getText().trim()) < currentYear) {
                JOptionPane.showMessageDialog(null,
                        "Graduate year should longer or equal to current year",
                        "Error Message",JOptionPane.ERROR_MESSAGE);
                tf_graduateYear.grabFocus();
                return;
            }

            // student Id validator
            if(tf_studentID.getText().trim().length() <= 0) {
                JOptionPane.showMessageDialog(null,
                        "Please input your student Id",
                        "Error Message",JOptionPane.ERROR_MESSAGE);
                tf_studentID.grabFocus();
                return;
            }
            if(!tf_studentID.getText().trim().matches("^[0-9]*$")) {
                JOptionPane.showMessageDialog(null,
                        "The student Id should only contain number",
                        "Error Message",JOptionPane.ERROR_MESSAGE);
                tf_studentID.grabFocus();
                return;
            }

            // school name validator
            if(tf_schoolName.getText().trim().length() <= 0) {
                JOptionPane.showMessageDialog(null,
                        "Please input your school name.",
                        "Error Message",JOptionPane.ERROR_MESSAGE);
                tf_schoolName.grabFocus();
                return;
            }

        }
        if(cb_accountTypeList.getSelectedIndex() == 2) {
            // Young Saver account validator

            // parent UserId validator
            if(tf_parentUserID.getText().length() <= 0) {
                JOptionPane.showMessageDialog(null,
                        "Please input your school name.",
                        "Error Message",JOptionPane.ERROR_MESSAGE);
                tf_parentUserID.grabFocus();
                return;
            }
            if(!tf_parentUserID.getText().trim().matches("^[0-9]*$")) {
                JOptionPane.showMessageDialog(null,
                        "Parent UserId should only contain numbers",
                        "Error Message",JOptionPane.ERROR_MESSAGE);
                tf_parentUserID.grabFocus();
                return;
            }

            // parent first name validator
            if(tf_parentFirstName.getText().trim().length() <= 0) {
                JOptionPane.showMessageDialog(null,
                        "Please input first name of one of your parents.",
                        "Error Message",JOptionPane.ERROR_MESSAGE);
                tf_parentFirstName.grabFocus();
                return;
            }
            if(!tf_parentFirstName.getText().trim().matches("^[a-zA-Z]+$")) {
                JOptionPane.showMessageDialog(null,
                        "The parent's first name should only contain characters",
                        "Error Message",JOptionPane.ERROR_MESSAGE);
                tf_parentFirstName.grabFocus();
                return;
            }

            // parent last name validator
            if(tf_parentLastName.getText().trim().length() <= 0) {
                JOptionPane.showMessageDialog(null,
                        "Please input last name of one of your parents.",
                        "Error Message",JOptionPane.ERROR_MESSAGE);
                tf_parentLastName.grabFocus();
                return;
            }
            if(!tf_parentLastName.getText().trim().matches("^[a-zA-Z]+$")) {
                JOptionPane.showMessageDialog(null,
                        "The parent's last name should only contain characters",
                        "Error Message",JOptionPane.ERROR_MESSAGE);
                tf_parentLastName.grabFocus();
                return;
            }
        }

        try {
            if(cb_accountTypeList.getSelectedIndex() == 0) {
                System.out.println("Front-end: ready to apply personal account");
                applyPersonalAccount();
            }
            if(cb_accountTypeList.getSelectedIndex() == 1) {
                System.out.println("Front-end: ready to apply student account");
                applyStudentAccount();
            }
            if(cb_accountTypeList.getSelectedIndex() == 2) {
                System.out.println("Front-end: ready to apply young saver account");
                applyYoungSaverAccount();
            }
            if(cb_accountTypeList.getSelectedIndex() == 3) {
                System.out.println("Front-end: ready to apply golden account");
                applyGoldenAccount();
            }
        } catch (Exception E) {
            E.printStackTrace();
        }
    }

    private void applyPersonalAccount() {
        long userId = Long.parseLong(tf_userId.getText().trim());
        int accountType = cb_accountTypeList.getSelectedIndex() + 1;
        int cardType = cb_cardTypeList.getSelectedIndex() + 1;
        int newUserApply = 0;
        try {
            UserApplyNewPersonalAccountBaseModel userApplyNewPersonalAccountBaseModel = (UserApplyNewPersonalAccountBaseModel) UserApplyNewAccountFactory.applyAccount(cb_accountTypeList.getSelectedItem().toString());
            userApplyNewPersonalAccountBaseModel.setUserId(userId);
            userApplyNewPersonalAccountBaseModel.setAccountType(accountType);
            userApplyNewPersonalAccountBaseModel.setCardType(cardType);
            userApplyNewPersonalAccountBaseModel.setNewUserApply(newUserApply);

            CustomerApplyService.getInstance().applyPersonalAccountForExistingUser(userApplyNewPersonalAccountBaseModel);
            JOptionPane.showMessageDialog(null,
                    "Personal Account apply requested successful",
                    "Success Message",JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception E) {
            JOptionPane.showMessageDialog(null,
                    E.getMessage(),
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            return;
        }

    }

    private void applyStudentAccount() {
        // basic info
        long userId = Long.parseLong(tf_userId.getText().trim());
        int accountType = cb_accountTypeList.getSelectedIndex() + 1;
        int cardType = cb_cardTypeList.getSelectedIndex() + 1;
        int newUserApply = 0;

        // student account info
        String graduateDateText = tf_graduateYear.getText().trim() + "-" + tf_graduateMonth.getText().trim() +"-01 " +"00:00:00";
        Timestamp graduateDate = Timestamp.valueOf(graduateDateText);
        String studentId = tf_studentID.getText().trim();
        String schoolName = tf_schoolName.getText().trim();

        try {
            UserApplyNewStudentAccountBaseModel userApplyNewStudentAccountBaseModel = (UserApplyNewStudentAccountBaseModel) UserApplyNewAccountFactory.applyAccount(cb_accountTypeList.getSelectedItem().toString());
            userApplyNewStudentAccountBaseModel.setUserId(userId);
            userApplyNewStudentAccountBaseModel.setAccountType(accountType);
            userApplyNewStudentAccountBaseModel.setCardType(cardType);
            userApplyNewStudentAccountBaseModel.setNewUserApply(newUserApply);
            userApplyNewStudentAccountBaseModel.setGraduateDate(graduateDate);
            userApplyNewStudentAccountBaseModel.setStudentId(studentId);
            userApplyNewStudentAccountBaseModel.setSchoolName(schoolName);

            CustomerApplyService.getInstance().applyStudentAccountForExistingUser(userApplyNewStudentAccountBaseModel);
            JOptionPane.showMessageDialog(null,
                    "Student Account apply requested successful",
                    "Success Message",JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception E) {
            JOptionPane.showMessageDialog(null,
                    E.getMessage(),
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            return;
        }
    }

    private void applyYoungSaverAccount() {
        // basic info
        long userId = Long.parseLong(tf_userId.getText().trim());
        int accountType = cb_accountTypeList.getSelectedIndex() + 1;
        int cardType = cb_cardTypeList.getSelectedIndex() + 1;
        int newUserApply = 0;

        // young saver info
        long parentUserId = Long.parseLong(tf_parentUserID.getText().trim());
        String parentFirstName = tf_parentFirstName.getText().trim();
        String parentLastName = tf_parentLastName.getText().trim();

        try {
            UserApplyNewYoungSaverAccountBaseModel userApplyNewYoungSaverAccountBaseModel = (UserApplyNewYoungSaverAccountBaseModel) UserApplyNewAccountFactory.applyAccount(cb_accountTypeList.getSelectedItem().toString());
            userApplyNewYoungSaverAccountBaseModel.setUserId(userId);
            userApplyNewYoungSaverAccountBaseModel.setAccountType(accountType);
            userApplyNewYoungSaverAccountBaseModel.setCardType(cardType);
            userApplyNewYoungSaverAccountBaseModel.setNewUserApply(newUserApply);
            userApplyNewYoungSaverAccountBaseModel.setParentUserId(parentUserId);
            userApplyNewYoungSaverAccountBaseModel.setParentFirstName(parentFirstName);
            userApplyNewYoungSaverAccountBaseModel.setParentLastName(parentLastName);

            CustomerApplyService.getInstance().applyYoungSaverAccountForExistingUser(userApplyNewYoungSaverAccountBaseModel);
            JOptionPane.showMessageDialog(null,
                    "Young saver Account apply requested successful",
                    "Success Message",JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception E) {
            JOptionPane.showMessageDialog(null,
                    E.getMessage(),
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            return;
        }
    }

    private void applyGoldenAccount() {
        // basic info
        long userId = Long.parseLong(tf_userId.getText().trim());
        int accountType = cb_accountTypeList.getSelectedIndex() + 1;
        int cardType = cb_cardTypeList.getSelectedIndex() + 1;
        int newUserApply = 0;

        try {
            UserApplyNewGoldenAccountBaseModel userApplyNewGoldenAccountBaseModel = (UserApplyNewGoldenAccountBaseModel) UserApplyNewAccountFactory.applyAccount(cb_accountTypeList.getSelectedItem().toString());
            userApplyNewGoldenAccountBaseModel.setUserId(userId);
            userApplyNewGoldenAccountBaseModel.setAccountType(accountType);
            userApplyNewGoldenAccountBaseModel.setCardType(cardType);
            userApplyNewGoldenAccountBaseModel.setNewUserApply(newUserApply);

            CustomerApplyService.getInstance().applyGoldenAccountForExistingUser(userApplyNewGoldenAccountBaseModel);
            JOptionPane.showMessageDialog(null,
                    "Golden Account apply requested successful",
                    "Success Message",JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception E) {
            JOptionPane.showMessageDialog(null,
                    E.getMessage(),
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            return;
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        lbl_userId = new JLabel();
        tf_userId = new JTextField();
        lbl_accountType = new JLabel();
        cb_accountTypeList = new JComboBox<>();
        studentAccountPanel = new JPanel();
        lbl_graduateDate = new JLabel();
        tf_graduateMonth = new JTextField();
        lbl_mark = new JLabel();
        tf_graduateYear = new JTextField();
        lbl_studentID = new JLabel();
        tf_studentID = new JTextField();
        lbl_schoolName = new JLabel();
        tf_schoolName = new JTextField();
        youngSaverAccountPanel = new JPanel();
        lbl_parentUserID = new JLabel();
        tf_parentUserID = new JTextField();
        lbl_parentFirstName = new JLabel();
        tf_parentFirstName = new JTextField();
        lbl_parentLastName = new JLabel();
        tf_parentLastName = new JTextField();
        lbl_cardType = new JLabel();
        cb_cardTypeList = new JComboBox<>();
        btn_apply = new JButton();
        btn_back = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[fill]" +
            "[fill]" +
            "[fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //---- lbl_userId ----
        lbl_userId.setText("User ID");
        contentPane.add(lbl_userId, "cell 1 0");

        //---- tf_userId ----
        tf_userId.setEditable(false);
        contentPane.add(tf_userId, "cell 2 0");

        //---- lbl_accountType ----
        lbl_accountType.setText("Account Type");
        contentPane.add(lbl_accountType, "cell 1 1");

        //---- cb_accountTypeList ----
        cb_accountTypeList.setModel(new DefaultComboBoxModel<>(new String[] {
            "Personal Current Account",
            "Student Current Account",
            "Young Saver Account",
            "Golden Account"
        }));
        cb_accountTypeList.addActionListener(e -> {
			cb_accountTypeListActionPerformed(e);
			cb_accountTypeListActionPerformed(e);
		});
        contentPane.add(cb_accountTypeList, "cell 2 1");

        //======== studentAccountPanel ========
        {
            studentAccountPanel.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[fill]" +
                "[sizegroup 1,fill]" +
                "[sizegroup 1,fill]",
                // rows
                "[]" +
                "[]" +
                "[]" +
                "[]"));

            //---- lbl_graduateDate ----
            lbl_graduateDate.setText("Graduate Date: ");
            studentAccountPanel.add(lbl_graduateDate, "cell 0 0");

            //---- tf_graduateMonth ----
            tf_graduateMonth.setMinimumSize(new Dimension(60, 24));
            tf_graduateMonth.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    tf_graduateMonthFocusGained(e);
                }
                @Override
                public void focusLost(FocusEvent e) {
                    tf_graduateMonthFocusLost(e);
                }
            });
            studentAccountPanel.add(tf_graduateMonth, "cell 1 0");

            //---- lbl_mark ----
            lbl_mark.setText("/");
            studentAccountPanel.add(lbl_mark, "cell 1 0");

            //---- tf_graduateYear ----
            tf_graduateYear.setMinimumSize(new Dimension(60, 24));
            tf_graduateYear.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    tf_graduateYearFocusGained(e);
                }
            });
            studentAccountPanel.add(tf_graduateYear, "cell 2 0");

            //---- lbl_studentID ----
            lbl_studentID.setText("Stuent ID: ");
            studentAccountPanel.add(lbl_studentID, "cell 0 1");

            //---- tf_studentID ----
            tf_studentID.setMinimumSize(new Dimension(172, 24));
            studentAccountPanel.add(tf_studentID, "cell 1 1 2 1");

            //---- lbl_schoolName ----
            lbl_schoolName.setText("School Name");
            studentAccountPanel.add(lbl_schoolName, "cell 0 2");
            studentAccountPanel.add(tf_schoolName, "cell 1 2 2 1");
        }
        contentPane.add(studentAccountPanel, "cell 2 2");

        //======== youngSaverAccountPanel ========
        {
            youngSaverAccountPanel.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[fill]" +
                "[fill]" +
                "[fill]",
                // rows
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]"));

            //---- lbl_parentUserID ----
            lbl_parentUserID.setText("Parent's UserId");
            youngSaverAccountPanel.add(lbl_parentUserID, "cell 1 1");

            //---- tf_parentUserID ----
            tf_parentUserID.setMinimumSize(new Dimension(172, 24));
            youngSaverAccountPanel.add(tf_parentUserID, "cell 2 1");

            //---- lbl_parentFirstName ----
            lbl_parentFirstName.setText("Parent's First name");
            youngSaverAccountPanel.add(lbl_parentFirstName, "cell 1 2");
            youngSaverAccountPanel.add(tf_parentFirstName, "cell 2 2");

            //---- lbl_parentLastName ----
            lbl_parentLastName.setText("Parent's Last name");
            youngSaverAccountPanel.add(lbl_parentLastName, "cell 1 3");
            youngSaverAccountPanel.add(tf_parentLastName, "cell 2 3");
        }
        contentPane.add(youngSaverAccountPanel, "cell 2 3");

        //---- lbl_cardType ----
        lbl_cardType.setText("Card Type");
        contentPane.add(lbl_cardType, "cell 1 4");

        //---- cb_cardTypeList ----
        cb_cardTypeList.setModel(new DefaultComboBoxModel<>(new String[] {
            "Debit Card",
            "Credit Card"
        }));
        cb_cardTypeList.setSelectedIndex(0);
        contentPane.add(cb_cardTypeList, "cell 2 4");

        //---- btn_apply ----
        btn_apply.setText("Apply");
        btn_apply.addActionListener(e -> btn_applyActionPerformed(e));
        contentPane.add(btn_apply, "cell 2 5");

        //---- btn_back ----
        btn_back.setText("Back");
        btn_back.addActionListener(e -> btn_backActionPerformed(e));
        contentPane.add(btn_back, "cell 2 6");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel lbl_userId;
    private JTextField tf_userId;
    private JLabel lbl_accountType;
    private JComboBox<String> cb_accountTypeList;
    private JPanel studentAccountPanel;
    private JLabel lbl_graduateDate;
    private JTextField tf_graduateMonth;
    private JLabel lbl_mark;
    private JTextField tf_graduateYear;
    private JLabel lbl_studentID;
    private JTextField tf_studentID;
    private JLabel lbl_schoolName;
    private JTextField tf_schoolName;
    private JPanel youngSaverAccountPanel;
    private JLabel lbl_parentUserID;
    private JTextField tf_parentUserID;
    private JLabel lbl_parentFirstName;
    private JTextField tf_parentFirstName;
    private JLabel lbl_parentLastName;
    private JTextField tf_parentLastName;
    private JLabel lbl_cardType;
    private JComboBox<String> cb_cardTypeList;
    private JButton btn_apply;
    private JButton btn_back;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    private Long userId;
    private int identityType;
    private String identityNum;
}
