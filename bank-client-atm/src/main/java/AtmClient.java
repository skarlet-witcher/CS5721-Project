import view.ATMLoginView;

import javax.swing.*;

public class AtmClient {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            new ATMLoginView().run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
