package controller;

import model.StaffLoginModel;
import service.impl.StaffLoginService;
import view.StaffLoginView;
import view.StaffMainView;

import javax.swing.*;
import java.awt.event.ActionEvent;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class StaffLoginController implements BaseController {
    private StaffLoginView view;

    public StaffLoginController(StaffLoginView view) {
        this.view = view;
    }

    @Override
    public void initialize() {
        this.view.initComponents();
        run();
    }

    private void run() {
        this.view.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.view.setVisible(true);
        this.view.pack(); // resize
    }

    public void btn_loginActionPerformed(ActionEvent event) {
        try {
            long staffId = Long.parseLong(this.view.tf_staffId.getText().trim());
            String password = String.valueOf(this.view.pf_pwd.getPassword());
            StaffLoginModel staffLoginModel = new StaffLoginModel(staffId, password);
            boolean isValidStaff = StaffLoginService.getInstance().staffLogin(staffLoginModel);
            if (isValidStaff) {
                new StaffMainView(staffId).run();
                this.view.dispose();
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Please input a valid combination of Staff ID and password.",
                    "Error Message", JOptionPane.ERROR_MESSAGE);
        }
    }
}


