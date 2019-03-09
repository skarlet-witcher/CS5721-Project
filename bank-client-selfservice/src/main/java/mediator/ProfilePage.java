package mediator;


import Const.UserGenderType;
import model.UserModel;
import view.CustomerMainView;

public class ProfilePage extends SubPage {

    private UserModel profileModel;

    public ProfilePage(MainMediator mediator, CustomerMainView view, UserModel profileModel) {
        super(mediator, view);
        this.profileModel = profileModel;
    }

    @Override
    public void updatePage() {
        this.view.tf_profile_userId.setText(String.valueOf(profileModel.getUserId()));
        this.view.tf_profile_firstName.setText(profileModel.getFirstName());
        this.view.tf_profile_lastName.setText(profileModel.getLastName());
        this.view.tf_profile_address.setText(profileModel.getAddress());
        this.view.tf_profile_contactNumber.setText(profileModel.getContactNum());
        this.view.tf_profile_email.setText(profileModel.getEmail());
        this.view.tf_profile_gender.setText(UserGenderType.getGenderType(profileModel.getGender()));
    }

}
