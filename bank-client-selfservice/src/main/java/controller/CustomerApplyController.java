package controller;

import Const.UserAccountType;
import Const.UserType;
import com.sun.xml.bind.v2.runtime.reflect.Lister;
import model.*;
import service.impl.CustomerApplyService;
import util.JTextFieldLimit;
import view.CustomerApplyView;
import view.CustomerLoginView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.sql.Timestamp;
import java.util.Calendar;

public class CustomerApplyController implements BaseController {
    private CustomerApplyView view;
    private int identityType;
    private String identityNum;
    private int newUserApply;
    private Long userId;

    public CustomerApplyController(CustomerApplyView view) {
        this.view = view;
        this.newUserApply = UserType.NEW_USER;
    }

    public CustomerApplyController(CustomerApplyView view, Long userId, int identityType, String identityNum, int newUserApply) {
        this.view = view;
        this.userId = userId;
        this.identityType = identityType;
        this.identityNum = identityNum;
        this.newUserApply = newUserApply;

    }

    @Override
    public void initialize() {
        this.view.initComponents();
        initTextFields();
        resetAccountPanel();
        this.view.pack();
        if(this.newUserApply == UserType.EXISTING_USER) {
            initFieldsForExistingUser();
        }
    }

    private void initTextFields() {
        this.view.tf_dob_day.setDocument(new JTextFieldLimit(2));
        this.view.tf_dob_month.setDocument(new JTextFieldLimit(2));
        this.view.tf_dob_year.setDocument(new JTextFieldLimit(4));
        this.view.tf_graduateMonth.setDocument(new JTextFieldLimit(2));
        this.view.tf_graduateYear.setDocument(new JTextFieldLimit(4));
        this.view.tf_studentID.setDocument(new JTextFieldLimit(8));
        this.view.tf_parentUserID.setDocument(new JTextFieldLimit(10));
        this.view.tf_firstName.setDocument(new JTextFieldLimit(20));
        this.view.tf_lastName.setDocument(new JTextFieldLimit(20));
        this.view.tf_identityNum.setDocument(new JTextFieldLimit(25));
        this.view.tf_schoolName.setDocument(new JTextFieldLimit(50));


        this.view.tf_dob_year.setText("YYYY");
        this.view.tf_dob_month.setText("MM");
        this.view.tf_dob_day.setText("DD");
        this.view.tf_graduateYear.setText("YYYY");
        this.view.tf_graduateMonth.setText("MM");
    }

    private void initFieldsForExistingUser() {
        this.view.tf_userId.setText(this.userId.toString());

        // remove name field
        this.view.lbl_firstName.setVisible(false);
        this.view.tf_firstName.setVisible(false);
        this.view.lbl_lastName.setVisible(false);
        this.view.tf_lastName.setVisible(false);

        // remove gender
        this.view.lbl_gender.setVisible(false);
        this.view.cb_genderList.setVisible(false);

        // remove identity
        this.view.lbl_identityType.setVisible(false);
        this.view.cb_identityTypeList.setVisible(false);
        this.view.lbl_identityNum.setVisible(false);
        this.view.tf_identityNum.setVisible(false);

        // remove date of birth
        this.view.lbl_dob.setVisible(false);
        this.view.tf_dob_day.setVisible(false);
        this.view.tf_dob_month.setVisible(false);
        this.view.tf_dob_year.setVisible(false);
        this.view.lbl_dob_mark1.setVisible(false);
        this.view.lbl_dob_mark2.setVisible(false);

        // remove address
        this.view.lbl_address.setVisible(false);
        this.view.tf_address.setVisible(false);

        // remove email
        this.view.lbl_email.setVisible(false);
        this.view.tf_email.setVisible(false);

        // remove contact num
        this.view.lbl_contactNum.setVisible(false);
        this.view.tf_contactNum.setVisible(false);
    }

    private void resetAccountPanel() {
        this.view.studentAccountPanel.setVisible(false);
        this.view.youngSaverAccountPanel.setVisible(false);
    }

    private void initStudentAccountField() {
        resetAccountPanel();
        this.view.studentAccountPanel.setVisible(true);
    }

    private void initYoungSaverAccountField() {
        resetAccountPanel();
        this.view.youngSaverAccountPanel.setVisible(true);
    }

    private void applyPersonalAccountForNewUser() {
        // basic info
        String firstName = this.view.tf_firstName.getText().trim();
        String lastName = this.view.tf_lastName.getText().trim();
        String identityNum = this.view.tf_identityNum.getText().trim();
        int identityType = this.view.cb_identityTypeList.getSelectedIndex();
        int accountType = this.view.cb_accountTypeList.getSelectedIndex() + 1;
        int cardType = this.view.cb_cardTypeList.getSelectedIndex() + 1;
        String birthDateText = this.view.tf_dob_year.getText().trim()+"-"+
                this.view.tf_dob_month.getText().trim()+"-"+this.view.tf_dob_day.getText().trim()+" 00:00:00";
        //month and day with one digit
        Timestamp birthDate = Timestamp.valueOf(birthDateText);
        int gender = this.view.cb_genderList.getSelectedIndex();
        String address = this.view.tf_address.getText().trim();
        String email = this.view.tf_email.getText().trim();
        String contactNum = this.view.tf_contactNum.getText().trim();
        int newUserApply = 1;

        try {
            UserApplyNewPersonalAccountBaseModel userApplyNewPersonalAccountBaseModel = (UserApplyNewPersonalAccountBaseModel) UserApplyNewAccountFactory.applyAccount(this.view.cb_accountTypeList.getSelectedItem().toString());
            userApplyNewPersonalAccountBaseModel.setFirstName(firstName);
            userApplyNewPersonalAccountBaseModel.setLastName(lastName);
            userApplyNewPersonalAccountBaseModel.setIdentityNum(identityNum);
            userApplyNewPersonalAccountBaseModel.setIdentityType(identityType);
            userApplyNewPersonalAccountBaseModel.setCardType(cardType);
            userApplyNewPersonalAccountBaseModel.setBirthDate(birthDate);
            userApplyNewPersonalAccountBaseModel.setAccountType(accountType);
            userApplyNewPersonalAccountBaseModel.setGender(gender);
            userApplyNewPersonalAccountBaseModel.setAddress(address);
            userApplyNewPersonalAccountBaseModel.setEmail(email);
            userApplyNewPersonalAccountBaseModel.setContactNum(contactNum);
            userApplyNewPersonalAccountBaseModel.setNewUserApply(newUserApply);

            CustomerApplyService.getInstance().applyPersonalAccountForNewUser(userApplyNewPersonalAccountBaseModel);
            JOptionPane.showMessageDialog(null,
                    "Request Personal Account apply successfully",
                    "Success Message",JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception E) {
            JOptionPane.showMessageDialog(null,
                    "Fail to request personal account apply due to " + E.getMessage(),
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            return;
        }

    }

    private void applyGoldenAccountForNewUser() {
        // basic info
        String firstName = this.view.tf_firstName.getText().trim();
        String lastName = this.view.tf_lastName.getText().trim();
        String identityNum = this.view.tf_identityNum.getText().trim();
        int identityType = this.view.cb_identityTypeList.getSelectedIndex();
        int accountType = this.view.cb_accountTypeList.getSelectedIndex() + 1;
        int cardType = this.view.cb_cardTypeList.getSelectedIndex() + 1;
        String birthDateText = this.view.tf_dob_year.getText().trim()+"-"+
                this.view.tf_dob_month.getText().trim()+"-"+this.view.tf_dob_day.getText().trim()+" 00:00:00";
        //month and day with one digit
        Timestamp birthDate = Timestamp.valueOf(birthDateText);
        int gender = this.view.cb_genderList.getSelectedIndex();
        String address = this.view.tf_address.getText().trim();
        String email = this.view.tf_email.getText().trim();
        String contactNum = this.view.tf_contactNum.getText().trim();
        int newUserApply = 1;

        try {
            UserApplyNewGoldenAccountBaseModel userApplyNewGoldenAccountBaseModel = (UserApplyNewGoldenAccountBaseModel) UserApplyNewAccountFactory.applyAccount(this.view.cb_accountTypeList.getSelectedItem().toString());
            userApplyNewGoldenAccountBaseModel.setFirstName(firstName);
            userApplyNewGoldenAccountBaseModel.setLastName(lastName);
            userApplyNewGoldenAccountBaseModel.setIdentityNum(identityNum);
            userApplyNewGoldenAccountBaseModel.setIdentityType(identityType);
            userApplyNewGoldenAccountBaseModel.setAccountType(accountType);
            userApplyNewGoldenAccountBaseModel.setCardType(cardType);
            userApplyNewGoldenAccountBaseModel.setBirthDate(birthDate);
            userApplyNewGoldenAccountBaseModel.setGender(gender);
            userApplyNewGoldenAccountBaseModel.setAddress(address);
            userApplyNewGoldenAccountBaseModel.setEmail(email);
            userApplyNewGoldenAccountBaseModel.setContactNum(contactNum);
            userApplyNewGoldenAccountBaseModel.setNewUserApply(newUserApply);


            CustomerApplyService.getInstance().applyGoldenAccountForNewUser(userApplyNewGoldenAccountBaseModel);
            JOptionPane.showMessageDialog(null,
                    "Request Golden Account apply successfully",
                    "Success Message",JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception E) {
            JOptionPane.showMessageDialog(null,
                    "Fail to request golden account due to " + E.getMessage(),
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            return;
        }

    }

    private void applyStudentAccountForNewUser() {
        // basic info
        String firstName = this.view.tf_firstName.getText().trim();
        String lastName = this.view.tf_lastName.getText().trim();
        String identityNum = this.view.tf_identityNum.getText().trim();
        int identityType = this.view.cb_identityTypeList.getSelectedIndex();
        int accountType = this.view.cb_accountTypeList.getSelectedIndex() + 1;
        int cardType = this.view.cb_cardTypeList.getSelectedIndex() + 1;
        String birthDateText = this.view.tf_dob_year.getText().trim()+"-"+
                this.view.tf_dob_month.getText().trim()+"-"+this.view.tf_dob_day.getText().trim()+" 00:00:00";
        Timestamp birthDate = Timestamp.valueOf(birthDateText);
        int gender = this.view.cb_genderList.getSelectedIndex();
        String address = this.view.tf_address.getText().trim();
        String email = this.view.tf_email.getText().trim();
        String contactNum = this.view.tf_contactNum.getText().trim();
        int newUserApply = 1;

        // student account Info
        String graduateDateText = this.view.tf_graduateYear.getText().trim() + "-" + this.view.tf_graduateMonth.getText().trim() +"-01 " +"00:00:00";
        Timestamp graduateDate = Timestamp.valueOf(graduateDateText);
        String studentId = this.view.tf_studentID.getText().trim();
        String schoolName = this.view.tf_schoolName.getText().trim();

        try {
            UserApplyNewStudentAccountBaseModel userApplyNewStudentAccountBaseModel = (UserApplyNewStudentAccountBaseModel) UserApplyNewAccountFactory.applyAccount(this.view.cb_accountTypeList.getSelectedItem().toString());
            userApplyNewStudentAccountBaseModel.setFirstName(firstName);
            userApplyNewStudentAccountBaseModel.setLastName(lastName);
            userApplyNewStudentAccountBaseModel.setIdentityNum(identityNum);
            userApplyNewStudentAccountBaseModel.setIdentityType(identityType);
            userApplyNewStudentAccountBaseModel.setAccountType(accountType);
            userApplyNewStudentAccountBaseModel.setCardType(cardType);
            userApplyNewStudentAccountBaseModel.setBirthDate(birthDate);
            userApplyNewStudentAccountBaseModel.setGender(gender);
            userApplyNewStudentAccountBaseModel.setAddress(address);
            userApplyNewStudentAccountBaseModel.setEmail(email);
            userApplyNewStudentAccountBaseModel.setContactNum(contactNum);
            userApplyNewStudentAccountBaseModel.setNewUserApply(newUserApply);
            userApplyNewStudentAccountBaseModel.setGraduateDate(graduateDate);
            userApplyNewStudentAccountBaseModel.setStudentId(studentId);
            userApplyNewStudentAccountBaseModel.setSchoolName(schoolName);


            CustomerApplyService.getInstance().applyStudentAccountForNewUser(userApplyNewStudentAccountBaseModel);
            JOptionPane.showMessageDialog(null,
                    "Request Student Account apply successfully",
                    "Success Message",JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception E) {
            JOptionPane.showMessageDialog(null,
                    "Fail to request student account due to " + E.getMessage(),
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            return;
        }


    }

    private void applyYoungSaverAccountForNewUser() {
        // basic info
        String firstName = this.view.tf_firstName.getText().trim();
        String lastName = this.view.tf_lastName.getText().trim();
        String identityNum = this.view.tf_identityNum.getText().trim();
        int identityType = this.view.cb_identityTypeList.getSelectedIndex();
        int accountType = this.view.cb_accountTypeList.getSelectedIndex() + 1;
        int cardType = this.view.cb_cardTypeList.getSelectedIndex() + 1;
        String birthDateText = this.view.tf_dob_year.getText().trim()+"-"+
                this.view.tf_dob_month.getText().trim()+"-"+this.view.tf_dob_day.getText().trim()+" 00:00:00";
        Timestamp birthDate = Timestamp.valueOf(birthDateText);
        int gender = this.view.cb_genderList.getSelectedIndex();
        String address = this.view.tf_address.getText().trim();
        String email = this.view.tf_email.getText().trim();
        String contactNum = this.view.tf_contactNum.getText().trim();
        int newUserApply = 1;

        // young saver info
        long parentUserId = Long.parseLong(this.view.tf_parentUserID.getText().trim());
        String parentFirstName = this.view.tf_parentFirstName.getText().trim();
        String parentLastName = this.view.tf_parentLastName.getText().trim();

        try {
            UserApplyNewYoungSaverAccountBaseModel userApplyNewYoungSaverAccountBaseModel = (UserApplyNewYoungSaverAccountBaseModel) UserApplyNewAccountFactory.applyAccount(this.view.cb_accountTypeList.getSelectedItem().toString());
            userApplyNewYoungSaverAccountBaseModel.setFirstName(firstName);
            userApplyNewYoungSaverAccountBaseModel.setLastName(lastName);
            userApplyNewYoungSaverAccountBaseModel.setIdentityNum(identityNum);
            userApplyNewYoungSaverAccountBaseModel.setIdentityType(identityType);
            userApplyNewYoungSaverAccountBaseModel.setAccountType(accountType);
            userApplyNewYoungSaverAccountBaseModel.setCardType(cardType);
            userApplyNewYoungSaverAccountBaseModel.setBirthDate(birthDate);
            userApplyNewYoungSaverAccountBaseModel.setGender(gender);
            userApplyNewYoungSaverAccountBaseModel.setAddress(address);
            userApplyNewYoungSaverAccountBaseModel.setEmail(email);
            userApplyNewYoungSaverAccountBaseModel.setContactNum(contactNum);
            userApplyNewYoungSaverAccountBaseModel.setNewUserApply(newUserApply);
            userApplyNewYoungSaverAccountBaseModel.setParentUserId(parentUserId);
            userApplyNewYoungSaverAccountBaseModel.setParentFirstName(parentFirstName);
            userApplyNewYoungSaverAccountBaseModel.setParentLastName(parentLastName);

            CustomerApplyService.getInstance().applyYoungSaverAccountForNewUser(userApplyNewYoungSaverAccountBaseModel);
            JOptionPane.showMessageDialog(null,
                    "Request Young saver Account apply successfully",
                    "Success Message",JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception E) {
            JOptionPane.showMessageDialog(null,
                    "Fail to request young saver account due to " + E.getMessage(),
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            return;
        }


    }

    private void applyPersonalAccountForExistingUser() {
        long userId = Long.parseLong(this.view.tf_userId.getText().trim());
        int accountType = this.view.cb_accountTypeList.getSelectedIndex() + 1;
        int cardType = this.view.cb_cardTypeList.getSelectedIndex() + 1;
        String accountTypeName = this.view.cb_accountTypeList.getSelectedItem().toString();
        try {
            UserApplyNewPersonalAccountBaseModel userApplyNewPersonalAccountBaseModel =
                    (UserApplyNewPersonalAccountBaseModel) UserApplyNewAccountFactory.applyAccount(accountTypeName);
            userApplyNewPersonalAccountBaseModel.setUserId(userId);
            userApplyNewPersonalAccountBaseModel.setAccountType(accountType);
            userApplyNewPersonalAccountBaseModel.setCardType(cardType);
            userApplyNewPersonalAccountBaseModel.setNewUserApply(this.newUserApply);
            userApplyNewPersonalAccountBaseModel.setIdentityType(this.identityType);
            userApplyNewPersonalAccountBaseModel.setIdentityNum(this.identityNum);

            CustomerApplyService.getInstance().applyPersonalAccountForExistingUser(userApplyNewPersonalAccountBaseModel);

            JOptionPane.showMessageDialog(null,
                    "Request Personal Account apply successfully",
                    "Success Message",JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception E) {
            JOptionPane.showMessageDialog(null,
                    "Fail to request personal account apply due to " + E.getMessage(),
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            return;
        }

    }

    private void applyStudentAccountForExistingUser() {
        // basic info
        long userId = Long.parseLong(this.view.tf_userId.getText().trim());
        int accountType = this.view.cb_accountTypeList.getSelectedIndex() + 1;
        int cardType = this.view.cb_cardTypeList.getSelectedIndex() + 1;
        String accountTypeName = this.view.cb_accountTypeList.getSelectedItem().toString();

        // student account info
        String graduateDateText = this.view.tf_graduateYear.getText().trim() + "-" + this.view.tf_graduateMonth.getText().trim() +"-01 " +"00:00:00";
        Timestamp graduateDate = Timestamp.valueOf(graduateDateText);
        String studentId = this.view.tf_studentID.getText().trim();
        String schoolName = this.view.tf_schoolName.getText().trim();

        try {
            UserApplyNewStudentAccountBaseModel userApplyNewStudentAccountBaseModel = (UserApplyNewStudentAccountBaseModel) UserApplyNewAccountFactory.applyAccount(accountTypeName);
            userApplyNewStudentAccountBaseModel.setUserId(userId);
            userApplyNewStudentAccountBaseModel.setAccountType(accountType);
            userApplyNewStudentAccountBaseModel.setCardType(cardType);
            userApplyNewStudentAccountBaseModel.setNewUserApply(this.newUserApply);
            userApplyNewStudentAccountBaseModel.setGraduateDate(graduateDate);
            userApplyNewStudentAccountBaseModel.setStudentId(studentId);
            userApplyNewStudentAccountBaseModel.setSchoolName(schoolName);
            userApplyNewStudentAccountBaseModel.setIdentityType(identityType);
            userApplyNewStudentAccountBaseModel.setIdentityNum(identityNum);

            CustomerApplyService.getInstance().applyStudentAccountForExistingUser(userApplyNewStudentAccountBaseModel);
            JOptionPane.showMessageDialog(null,
                    "Request Student Account apply successfully",
                    "Success Message",JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception E) {
            JOptionPane.showMessageDialog(null,
                    "Fail to request student account apply due to " + E.getMessage(),
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            return;
        }
    }

    private void applyYoungSaverAccountForExistingUser() {
        // basic info
        long userId = Long.parseLong(this.view.tf_userId.getText().trim());
        int accountType = this.view.cb_accountTypeList.getSelectedIndex() + 1;
        int cardType = this.view.cb_cardTypeList.getSelectedIndex() + 1;
        String accountTypeName = this.view.cb_accountTypeList.getSelectedItem().toString();

        // young saver info
        long parentUserId = Long.parseLong(this.view.tf_parentUserID.getText().trim());
        String parentFirstName = this.view.tf_parentFirstName.getText().trim();
        String parentLastName = this.view.tf_parentLastName.getText().trim();

        try {
            UserApplyNewYoungSaverAccountBaseModel userApplyNewYoungSaverAccountBaseModel = (UserApplyNewYoungSaverAccountBaseModel) UserApplyNewAccountFactory.applyAccount(accountTypeName);
            userApplyNewYoungSaverAccountBaseModel.setUserId(userId);
            userApplyNewYoungSaverAccountBaseModel.setAccountType(accountType);
            userApplyNewYoungSaverAccountBaseModel.setCardType(cardType);
            userApplyNewYoungSaverAccountBaseModel.setNewUserApply(this.newUserApply);
            userApplyNewYoungSaverAccountBaseModel.setIdentityType(this.identityType);
            userApplyNewYoungSaverAccountBaseModel.setIdentityNum(this.identityNum);
            userApplyNewYoungSaverAccountBaseModel.setParentUserId(parentUserId);
            userApplyNewYoungSaverAccountBaseModel.setParentFirstName(parentFirstName);
            userApplyNewYoungSaverAccountBaseModel.setParentLastName(parentLastName);

            CustomerApplyService.getInstance().applyYoungSaverAccountForExistingUser(userApplyNewYoungSaverAccountBaseModel);
            JOptionPane.showMessageDialog(null,
                    "Request Young saver Account apply successfully",
                    "Success Message",JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception E) {
            JOptionPane.showMessageDialog(null,
                    "Fail to request young saver account apply due to " + E.getMessage(),
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            return;
        }
    }

    private void applyGoldenAccountForExistingUser() {
        // basic info
        long userId = Long.parseLong(this.view.tf_userId.getText().trim());
        int accountType = this.view.cb_accountTypeList.getSelectedIndex() + 1;
        int cardType = this.view.cb_cardTypeList.getSelectedIndex() + 1;
        String accountTypeName = this.view.cb_accountTypeList.getSelectedItem().toString();

        try {
            UserApplyNewGoldenAccountBaseModel userApplyNewGoldenAccountBaseModel = (UserApplyNewGoldenAccountBaseModel) UserApplyNewAccountFactory.applyAccount(accountTypeName);
            userApplyNewGoldenAccountBaseModel.setUserId(userId);
            userApplyNewGoldenAccountBaseModel.setAccountType(accountType);
            userApplyNewGoldenAccountBaseModel.setCardType(cardType);
            userApplyNewGoldenAccountBaseModel.setNewUserApply(this.newUserApply);
            userApplyNewGoldenAccountBaseModel.setIdentityType(this.identityType);
            userApplyNewGoldenAccountBaseModel.setIdentityNum(this.identityNum);

            CustomerApplyService.getInstance().applyGoldenAccountForExistingUser(userApplyNewGoldenAccountBaseModel);
            JOptionPane.showMessageDialog(null,
                    "Request Golden Account apply successfully",
                    "Success Message",JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception E) {
            JOptionPane.showMessageDialog(null,
                    "Fail to request golden account due to " + E.getMessage(),
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            return;
        }
    }

    private Boolean validateAllFieldsForNewUser() {
        return validateNameFields() && validateGenderField() &&
                validateIdentityFields() && validateDOBFields() &&
                validateAddressField() && validateEmailField() &&
                validateContactNumField() && validateAccountType();
    }

    private Boolean validateAllFieldsForExistingUser() {
        return validateAccountType();
    }

    private Boolean validateNameFields() {
        // First Name validator
        if(this.view.tf_firstName.getText().trim().length() <= 0) {
            JOptionPane.showMessageDialog(null,
                    "Please input your first name",
                    "Error Message", JOptionPane.ERROR_MESSAGE);
            this.view.tf_firstName.grabFocus();
            return false;
        } if(!this.view.tf_firstName.getText().trim().matches("^[a-zA-Z]+$")) {
            JOptionPane.showMessageDialog(null,
                    "First name should only contain letters",
                    "Error Message", JOptionPane.ERROR_MESSAGE);
            this.view.tf_firstName.grabFocus();
            return false;
        }

        // Last name validator
        if(this.view.tf_lastName.getText().trim().length() <= 0) {
            JOptionPane.showMessageDialog(null,
                    "Please input your last name",
                    "Error Message", JOptionPane.ERROR_MESSAGE);
            this.view.tf_lastName.grabFocus();
            return false;
        } if(!this.view.tf_lastName.getText().trim().matches("^[a-zA-Z]+$")) {
            JOptionPane.showMessageDialog(null,
                    "First name should only contain letters",
                    "Error Message", JOptionPane.ERROR_MESSAGE);
            this.view.tf_lastName.grabFocus();
            return false;
        }
        return true;
    }

    private Boolean validateGenderField() {
        // gender field validator
        if(this.view.cb_genderList.getSelectedIndex() <= 0) {
            JOptionPane.showMessageDialog(null,
                    "Please input your gender",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private Boolean validateIdentityFields() {
        // identity type validator
        if(this.view.cb_identityTypeList.getSelectedIndex() <= 0) {
            JOptionPane.showMessageDialog(null,
                    "Please select your identity type",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Identity number validator
        if(this.view.tf_identityNum.getText().trim().length() <= 0) {
            JOptionPane.showMessageDialog(null,
                    "Please input your identity number",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            this.view.tf_identityNum.grabFocus();
            return false;
        }
        if(!this.view.tf_identityNum.getText().trim().matches("^[a-zA-Z0-9]*$")) {
            JOptionPane.showMessageDialog(null,
                    "Identity number should only contain numbers and letters",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            this.view.tf_identityNum.grabFocus();
            return false;
        }
        return true;
    }

    private Boolean validateDOBFields() {
        // date of birth validator

        // day of dob validator
        if(this.view.tf_dob_day.getText().trim().length() <= 0) {
            JOptionPane.showMessageDialog(null,
                    "Please input your day of your date of birth",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            this.view.tf_dob_day.grabFocus();
            return false;
        }
        if(!this.view.tf_dob_day.getText().trim().matches("^[0-9]*$")) {
            JOptionPane.showMessageDialog(null,
                    "The day of the date of birth should be numeric",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            this.view.tf_dob_day.grabFocus();
            return false;
        }
        if(Integer.parseInt(this.view.tf_dob_day.getText().trim()) > 31 || Integer.parseInt(this.view.tf_dob_day.getText().trim()) < 1) {
            JOptionPane.showMessageDialog(null,
                    "The ranage of day of the date of birth should be 1 to 31",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            this.view.tf_dob_day.grabFocus();
            return false;
        }
        if(this.view.tf_dob_day.getText().trim().length() == 1) {
            this.view.tf_dob_day.setText("0" + this.view.tf_dob_day.getText());
        }

        // month of dob validator
        if(this.view.tf_dob_month.getText().trim().length() <= 0) {
            JOptionPane.showMessageDialog(null,
                    "Please input your month of your date of birth",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            this.view.tf_dob_month.grabFocus();
            return false;
        }
        if(!this.view.tf_dob_month.getText().trim().matches("^[0-9]*$")) {
            JOptionPane.showMessageDialog(null,
                    "The month of your date of birth should be numeric",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            this.view.tf_dob_month.grabFocus();
            return false;
        }
        if(Integer.parseInt(this.view.tf_dob_month.getText().trim()) > 12 || Integer.parseInt(this.view.tf_dob_month.getText().trim()) < 1) {
            JOptionPane.showMessageDialog(null,
                    "The ranage of month of the date of birth should be 1 to 12",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            this.view.tf_dob_month.grabFocus();
            return false;
        }
        if(this.view.tf_dob_month.getText().trim().length() == 1) {
            this.view.tf_dob_month.setText("0" + this.view.tf_dob_month.getText());
        }

        //  year of the date or birth validator
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        if(this.view.tf_dob_year.getText().trim().length() <= 0) {
            JOptionPane.showMessageDialog(null,
                    "Please input your year of the date of birth",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            this.view.tf_dob_year.grabFocus();
            return false;
        } if(!this.view.tf_dob_year.getText().trim().matches("^[0-9]*$")) {
            JOptionPane.showMessageDialog(null,
                    "year of the date of brith should only contain numbers",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            this.view.tf_dob_year.grabFocus();
            return false;
        }
        if(this.view.tf_dob_year.getText().length() < 4) {
            JOptionPane.showMessageDialog(null,
                    "The year of date of birth should be four digits",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            this.view.tf_dob_year.grabFocus();
            return false;
        }
        if(Integer.parseInt(this.view.tf_dob_year.getText().trim()) > currentYear) {
            JOptionPane.showMessageDialog(null,
                    "The year of date of birth should be less or equal to current year",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            this.view.tf_dob_year.grabFocus();
            return false;
        }
        return true;
    }

    private Boolean validateAddressField() {
        // address validator
        if(this.view.tf_address.getText().trim().length() <= 0) {
            JOptionPane.showMessageDialog(null,
                    "Please input your address",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            this.view.tf_address.grabFocus();
            return false;
        }
        return true;
    }

    private Boolean validateEmailField() {
        // email field validator
        if(this.view.tf_email.getText().trim().length() <= 0) {
            JOptionPane.showMessageDialog(null,
                    "Please input your email address",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            this.view.tf_email.grabFocus();
            return false;
        }
        if(!this.view.tf_email.getText().trim().matches("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b")) {
            JOptionPane.showMessageDialog(null,
                    "Please input valid email address",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            this.view.tf_email.grabFocus();
            return false;
        }
        return true;
    }

    private Boolean validateContactNumField() {
        // contact number validator
        if(this.view.tf_contactNum.getText().trim().length() <= 0) {
            JOptionPane.showMessageDialog(null,
                    "Please input your contact number",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            this.view.tf_contactNum.grabFocus();
            return false;
        }
        if(!this.view.tf_contactNum.getText().trim().matches("^[0-9]*$")) {
            JOptionPane.showMessageDialog(null,
                    "The contact number must be numeric.",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            this.view.tf_contactNum.grabFocus();
            return false;
        }
        return true;
    }

    private Boolean validateAccountType() {
        boolean checker = false;
        // account type validator
        if(this.view.cb_accountTypeList.getSelectedIndex() + 1 == UserAccountType.STUDENT_ACCOUNT){
            checker = validateStudentAccountFields();
        }
        if(this.view.cb_accountTypeList.getSelectedIndex() + 1 == UserAccountType.YOUNG_SAVER_ACCOUNT) {
            checker = validateYoungSaverAccountFields();
        }
        if(this.view.cb_accountTypeList.getSelectedIndex() + 1 == UserAccountType.PERSONAL_ACCOUNT) {
            checker = true;
        }
        if(this.view.cb_accountTypeList.getSelectedIndex() + 1 == UserAccountType.GOLDEN_ACCOUNT) {
            checker = true;
        }
        return checker;
    }

    private Boolean validateStudentAccountFields() {
        // student account validator

        // graduate month validator
        if(this.view.tf_graduateMonth.getText().trim().length() <= 0) {
            JOptionPane.showMessageDialog(null,
                    "Please input your graduate month",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            this.view.tf_graduateMonth.grabFocus();
            return false;
        }
        if(!this.view.tf_graduateMonth.getText().trim().matches("^[0-9]*$")) {
            JOptionPane.showMessageDialog(null,
                    "The graduate month should be numeric",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            this.view.tf_graduateMonth.grabFocus();
            return false;
        }
        if(Integer.parseInt(this.view.tf_graduateMonth.getText().trim()) > 12 || Integer.parseInt(this.view.tf_graduateMonth.getText().trim()) < 1) {
            JOptionPane.showMessageDialog(null,
                    "The ranage of graduate month should be 1 to 12",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            this.view.tf_graduateMonth.grabFocus();
            return false;
        }

        // graduate year validator
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        if(this.view.tf_graduateYear.getText().trim().length() <= 0) {
            JOptionPane.showMessageDialog(null,
                    "Please input your graduate month",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            this.view.tf_graduateYear.grabFocus();
            return false;
        } if(!this.view.tf_graduateYear.getText().trim().matches("^[0-9]*$")) {
            JOptionPane.showMessageDialog(null,
                    "Graduate year should only contain numbers",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            this.view.tf_graduateYear.grabFocus();
            return false;
        }
        if(this.view.tf_graduateYear.getText().length() < 4) {
            JOptionPane.showMessageDialog(null,
                    "Graduate year should be four digits",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            this.view.tf_graduateYear.grabFocus();
            return false;
        }
        if(Integer.parseInt(this.view.tf_graduateYear.getText().trim()) < currentYear) {
            JOptionPane.showMessageDialog(null,
                    "Graduate year should longer or equal to current year",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            this.view.tf_graduateYear.grabFocus();
            return false;
        }

        // student Id validator
        if(this.view.tf_studentID.getText().trim().length() <= 0) {
            JOptionPane.showMessageDialog(null,
                    "Please input your student Id",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            this.view.tf_studentID.grabFocus();
            return false;
        }
        if(!this.view.tf_studentID.getText().trim().matches("^[0-9]*$")) {
            JOptionPane.showMessageDialog(null,
                    "The student Id should only contain number",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            this.view.tf_studentID.grabFocus();
            return false;
        }

        // school name validator
        if(this.view.tf_schoolName.getText().trim().length() <= 0) {
            JOptionPane.showMessageDialog(null,
                    "Please input your school name.",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            this.view.tf_schoolName.grabFocus();
            return false;
        }
        return true;
    }

    private Boolean validateYoungSaverAccountFields() {
        // Young Saver account validator

        // parent UserId validator
        if(this.view.tf_parentUserID.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null,
                    "Please input your school name.",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            this.view.tf_parentUserID.grabFocus();
            return false;
        }
        if(!this.view.tf_parentUserID.getText().trim().matches("^[0-9]*$")) {
            JOptionPane.showMessageDialog(null,
                    "Parent UserId should only contain numbers",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            this.view.tf_parentUserID.grabFocus();
            return false;
        }

        // parent first name validator
        if(this.view.tf_parentFirstName.getText().trim().length() <= 0) {
            JOptionPane.showMessageDialog(null,
                    "Please input first name of one of your parents.",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            this.view.tf_parentFirstName.grabFocus();
            return false;
        }
        if(!this.view.tf_parentFirstName.getText().trim().matches("^[a-zA-Z]+$")) {
            JOptionPane.showMessageDialog(null,
                    "The parent's first name should only contain characters",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            this.view.tf_parentFirstName.grabFocus();
            return false;
        }

        // parent last name validator
        if(this.view.tf_parentLastName.getText().trim().length() <= 0) {
            JOptionPane.showMessageDialog(null,
                    "Please input last name of one of your parents.",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            this.view.tf_parentLastName.grabFocus();
            return false;
        }
        if(!this.view.tf_parentLastName.getText().trim().matches("^[a-zA-Z]+$")) {
            JOptionPane.showMessageDialog(null,
                    "The parent's last name should only contain characters",
                    "Error Message",JOptionPane.ERROR_MESSAGE);
            this.view.tf_parentLastName.grabFocus();
            return false;
        }
        return true;
    }

    public void tf_dob_dayFocusGained(FocusEvent e) {
        this.view.tf_dob_day.selectAll();
    }

    public void tf_dob_monthFocusGained(FocusEvent e) {
        this.view.tf_dob_month.selectAll();
    }

    public void tf_dob_yearFocusGained(FocusEvent e) {
        this.view.tf_dob_year.selectAll();
    }

    public void btn_applyActionPerformed(ActionEvent e) {

        if(this.newUserApply == UserType.NEW_USER) {
            if (!validateAllFieldsForNewUser()) {
                return;
            }
            // ready to apply an account
            try {
                int selectedAccountType = this.view.cb_accountTypeList.getSelectedIndex() + 1;

                switch (selectedAccountType) {
                    case UserAccountType.PERSONAL_ACCOUNT:
                        applyPersonalAccountForNewUser();
                        break;
                    case UserAccountType.STUDENT_ACCOUNT:
                        applyStudentAccountForNewUser();
                        break;
                    case UserAccountType.YOUNG_SAVER_ACCOUNT:
                        applyYoungSaverAccountForNewUser();
                        break;
                    case UserAccountType.GOLDEN_ACCOUNT:
                        applyGoldenAccountForNewUser();
                        break;
                }
            } catch (Exception E) {
                E.printStackTrace();
            }
            return;
        }
        if(this.newUserApply == UserType.EXISTING_USER) {
            if(!validateAllFieldsForExistingUser()) {
                return;
            }
            // ready to apply an account
            try {
                int selectedAccountType = this.view.cb_accountTypeList.getSelectedIndex() + 1;

                switch(selectedAccountType) {
                    case UserAccountType.PERSONAL_ACCOUNT:
                        applyPersonalAccountForExistingUser();
                        break;
                    case UserAccountType.STUDENT_ACCOUNT:
                        applyStudentAccountForExistingUser();
                        break;
                    case UserAccountType.YOUNG_SAVER_ACCOUNT:
                        applyYoungSaverAccountForExistingUser();
                        break;
                    case UserAccountType.GOLDEN_ACCOUNT:
                        applyGoldenAccountForExistingUser();
                        break;
                }
            } catch (Exception E) {
                E.printStackTrace();
            }
            return;
        }
    }

    public void btn_backActionPerformed(ActionEvent e) {
        this.view.dispose();
        new CustomerLoginView();
    }

    public void cb_accountTypeListActionPerformed(ActionEvent e) {
        if(this.view.cb_accountTypeList.getSelectedIndex() == 0 ||
                this.view.cb_accountTypeList.getSelectedIndex() == 3) {
            resetAccountPanel();
            this.view.pack();
        }
        if (this.view.cb_accountTypeList.getSelectedIndex() == 1) {
            resetAccountPanel();
            initStudentAccountField();
            this.view.pack();
        }
        if (this.view.cb_accountTypeList.getSelectedIndex() == 2) {
            resetAccountPanel();
            initYoungSaverAccountField();
            this.view.pack();
        }

    }

    public void tf_graduateMonthFocusLost(FocusEvent e) {
        // if input one digit of a month, add 0 before that
        if(this.view.tf_graduateMonth.getText().trim().length() == 1) {
            this.view.tf_graduateMonth.setText("0" + this.view.tf_graduateMonth.getText());
        }
    }

    public void tf_graduateMonthFocusGained(FocusEvent e) {
        this.view.tf_graduateMonth.selectAll();
    }

    public void tf_graduateYearFocusGained(FocusEvent e) {
        this.view.tf_graduateYear.selectAll();
    }

    public void tf_dob_monthFocusLost(FocusEvent e) {
        // if input one digit of a month, add 0 before that
        if(this.view.tf_dob_month.getText().trim().length() == 1) {
            this.view.tf_dob_month.setText("0" + this.view.tf_dob_month.getText());
        }
    }
}
