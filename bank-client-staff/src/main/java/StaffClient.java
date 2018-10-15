import view.StaffLoginView;

import javax.swing.*;

public class StaffClient {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            new StaffLoginView().run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
