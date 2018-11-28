package controller;

import bankStaff_rpc.AcceptedResponse;
import bankStaff_rpc.UserApplyArchiveEntitiesResponse;
import service.impl.StaffService;
import util.TimestampConvertHelper;
import view.StaffAddAccountInfoView;
import view.StaffMainView;

import javax.swing.*;
import java.awt.event.ActionEvent;

import static Const.CardType.CREDIT_CARD;
import static Const.CardType.DEBIT_CARD;
import static Const.UserAccountType.*;
import static Const.UserApplyType.DENY;
import static Const.UserApplyType.PASS;
import static Const.UserApplyType.PENDING_FOR_BEING_APPROVED;
import static Const.UserGenderType.FEMALE;
import static Const.UserGenderType.MALE;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class StaffAddAccountInfoController implements BaseController {
    private StaffAddAccountInfoView view;
    UserApplyArchiveEntitiesResponse userApplyArchiveEntitiesResponse = null;
    private Long staffId;

    public StaffAddAccountInfoController(StaffAddAccountInfoView view, Long staffId, UserApplyArchiveEntitiesResponse userApplyArchiveEntitiesResponse) {
        this.view = view;
        this.staffId = staffId;
        this.userApplyArchiveEntitiesResponse = userApplyArchiveEntitiesResponse;
    }

    @Override
    public void initialize() {
        this.view.initComponents();
        fetchValueIntoTextField(this.userApplyArchiveEntitiesResponse);
        run();
    }

    private void run() {
        this.view.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.view.setVisible(true);
        this.view.pack(); // resize
    }

    public void fetchValueIntoTextField(UserApplyArchiveEntitiesResponse userApplyArchiveEntitiesResponse) {
        UserApplyArchiveEntitiesResponse x = userApplyArchiveEntitiesResponse;
        this.view.tf_firstName.setText(x.getFirstName());
        this.view.tf_lastName.setText(x.getLastName());
        this.view.tf_gender.setText(String.valueOf(x.getGender()));
        this.view.tf_dob.setText(TimestampConvertHelper.rpcToMysql(x.getBirthDate()).toString());
        this.view.tf_email.setText(x.getEmail());
        this.view.tf_address.setText(x.getAddress());
        this.view.tf_contactNum.setText(x.getPhone());
        this.view.tf_applyTime.setText(TimestampConvertHelper.rpcToMysql(x.getApplyTime()).toString());
        this.view.tf_userId.setText(String.valueOf(x.getUserId()));
        this.view.tf_graduateDate.setText(TimestampConvertHelper.rpcToMysql(x.getGraduateDate()).toString());
        this.view.tf_studentId.setText(x.getStudentId());
        this.view.tf_schoolName.setText(x.getUniversity());
        this.view.tf_parentUserId.setText(String.valueOf(x.getParentUserId()));
        this.view.tf_parentFirstName.setText(x.getParentFirstName());
        this.view.tf_parentLastName.setText(x.getParentLastName());

        String accountStatus = "";
        if(x.getStatus() == PENDING_FOR_BEING_APPROVED) accountStatus = "PENDING";
        if(x.getStatus() == PASS) {
            accountStatus = "PASS";
            this.view.btn_accept.setEnabled(false);
        }
        if(x.getStatus() == DENY) accountStatus = "DENY";
        this.view.tf_status.setText(String.valueOf(accountStatus));

        String accountType = "";
        if(x.getAccountType() == PERSONAL_ACCOUNT) accountType = "PERSONAL_ACCOUNT";
        if(x.getAccountType() == STUDENT_ACCOUNT ) accountType = "STUDENT_ACCOUNT";
        if(x.getAccountType() == YOUNG_SAVER_ACCOUNT) accountType = "Deletion YOUNG_SAVER_ACCOUNT";
        if(x.getAccountType() == GOLDEN_ACCOUNT) accountType = "GOLDEN_ACCOUNT";
        this.view.tf_accountType.setText(String.valueOf(accountType));

        String cardType = "";
        if(x.getCardType() == DEBIT_CARD) cardType = "DEBIT_CARD";
        if(x.getCardType() == CREDIT_CARD) cardType = "CREDIT_CARD";
        this.view.tf_cardType.setText(String.valueOf(cardType));

        String gender = "";
        if(x.getGender() == MALE) gender = "MALE";
        if(x.getGender() == FEMALE) gender = "FEMALE";
        this.view.tf_gender.setText(String.valueOf(gender));
    }

    public void btn_backActionPerformed(ActionEvent e) {
        this.view.dispose();
        new StaffMainView(staffId).run();
    }

    public void btn_acceptActionPerformed(ActionEvent e) {
        // TODO add your code here
        try{
            AcceptedResponse response = StaffService.getInstance().acceptAplication(userApplyArchiveEntitiesResponse.getId());
            if(response.getIsAccepted()){
                JOptionPane.showMessageDialog(null,
                        "Accept an application successfully",
                        "Success Message", JOptionPane.PLAIN_MESSAGE);
                this.view.btn_accept.setEnabled(false);
            }
        } catch (Exception ee){
            JOptionPane.showMessageDialog(null,
                    "Fail to accept an application. Please contact an administrator",
                    "Error Message", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void btn_declineActionPerformed(ActionEvent e) {
        // TODO add your code here
    }
}
