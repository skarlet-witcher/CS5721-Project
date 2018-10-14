import view.CustomerLoginView;
import view.MainMenu;

public class BankClient {

    public static void main(String[] args) {

        try {
            new CustomerLoginView().run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
