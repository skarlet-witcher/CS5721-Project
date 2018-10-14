import view.MainMenu;

public class BankClient {

    public static void main(String[] args) {

        try {
            new MainMenu().run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
