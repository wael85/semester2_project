package viewModel;

import javafx.beans.property.StringProperty;
import users_model.UsersManagementModel;

public class AddGuestViewModel {
    private UsersManagementModel usersManagementModel;
    private StringProperty CompanyName;
    private StringProperty CVR;
    private StringProperty phone;
    private StringProperty email;
    private StringProperty password;

    public AddGuestViewModel(UsersManagementModel model) {
        this.usersManagementModel = model;

    }

}
