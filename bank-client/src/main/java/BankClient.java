import view.CustomerLoginView;
import view.CustomerMainView;
import view.MainMenu;

public class BankClient {

    public static void main(String[] args) {

        try {
            // new CustomerLoginView().run();
            new CustomerMainView().run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
