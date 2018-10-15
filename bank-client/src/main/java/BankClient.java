import ATMView.ATMMainView;
import StaffView.StaffLoginView;
import view.CustomerLoginView;

import javax.swing.*;

public class BankClient {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(String.valueOf(UIManager.getSystemLookAndFeelClassName()));
            // new CustomerLoginView().run();
            // new ATMMainView().run();
            new StaffLoginView().run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
