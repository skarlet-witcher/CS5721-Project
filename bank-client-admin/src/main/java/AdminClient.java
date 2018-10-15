
import view.AdminLoginView;

import javax.swing.*;

public class AdminClient {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            new AdminLoginView().run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
