package mediator;

import controller.CustomerMainController;
import model.UserModel;
import org.junit.jupiter.api.Test;
import view.CustomerMainView;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

class HomePageTest {



    @Test
    void updatePage() {
        // test data for User model
        UserModel userModel = new UserModel();
        userModel.setId(13L);
        userModel.setFirstName("xiangkai");
        userModel.setLastLoginTime(Timestamp.valueOf("2018-02-02 19:40:33"));

        CustomerMainView view = new CustomerMainView(userModel);
        MainMediator mainMediator = new MainMediatorImpl();

        SubPage homePage = new HomePage(mainMediator, view, userModel);
        mainMediator.addSubPage(homePage);

        assertDoesNotThrow( () -> {
            mainMediator.initPages(homePage);
        });

    }


}