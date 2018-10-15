
import view.ATMMainView;

import javax.swing.*;

public class AtmClient {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            new ATMMainView().run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
