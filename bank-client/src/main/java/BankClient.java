import ATMView.ATMMainView;
import AdminView.AdminLoginView;
import AdminView.AdminMainView;
import StaffView.StaffLoginView;
import view.CustomerLoginView;

import javax.swing.*;

public class BankClient {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(String.valueOf(UIManager.getSystemLookAndFeelClassName()));
            // new CustomerLoginView().run();
            // new ATMMainView().run();
            // new StaffLoginView().run();
            new AdminLoginView().run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
