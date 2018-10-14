import view.CustomerApplyView;

public class BankClient {

    public static void main(String[] args) {

        try {
            new CustomerApplyView().run();
            // new CustomerForgotPINView().run();
            // new CustomerForgotUserIdView().run();
            // new CustomerLoginView().run();
            // new CustomerMainView().run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
