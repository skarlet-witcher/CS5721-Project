package mediator;

import Const.UserGenderType;
import model.UserModel;
import org.junit.jupiter.api.Test;
import view.CustomerMainView;


import static org.junit.jupiter.api.Assertions.*;

class ProfilePageTest {

    @Test
    void updatePage() {
        // test data for User model
        UserModel userModel = new UserModel();
        userModel.setId(13L);
        userModel.setFirstName("xiangkai");
        userModel.setLastName("Tang");
        userModel.setAddress("dromroe village");
        userModel.setContactNum("083222333");
        userModel.setEmail("empathytxxx@gmail.com");
        userModel.setGender(UserGenderType.MALE);

        CustomerMainView view = new CustomerMainView(userModel);

        MainMediator mainMediator = new MainMediatorImpl();

        SubPage profile = new ProfilePage(mainMediator, view, userModel);
        mainMediator.addSubPage(profile);

        assertDoesNotThrow( () -> {
            mainMediator.initPages(profile);
        });

    }

}