import model.Module;
import service.Services;
import view.MainMenu;
public class Server {
    public static void main(String[] args) {

        try {
            new MainMenu().run();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // test
        for (Module module : Services.getInstance().getAllModule("get_all_modules")) {
            System.out.println(" Module Code: " + module.getModule_no());
            System.out.println(" Module Name: " + module.getModule_name());
            System.out.println(" Lecturer Name: " + module.getLecturer_name());
            System.out.println(" Credit: " + module.getCredit());
            System.out.println("");
        }
    }
}
