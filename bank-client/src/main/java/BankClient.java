import util.KeyPadGenerator;
import view.CustomerApplyView;
import view.CustomerLoginView;

import java.security.Key;

public class BankClient {

    public static void main(String[] args) {

        try {
            // new CustomerApplyView().run();
            // new CustomerForgotPINView().run();
            // new CustomerForgotUserIdView().run();
            // new CustomerMainView().run();
             new CustomerLoginView().run();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
