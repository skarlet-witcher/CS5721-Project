import view.CustomerLoginView;

import javax.swing.*;

public class BankClient {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            new CustomerLoginView().run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
