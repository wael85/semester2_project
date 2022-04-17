package viewModel;

import javafx.beans.property.StringProperty;
import users_model.UsersManagementModel;


public class AddTeacherViewModel {
    private UsersManagementModel usersManagementModel;
    private StringProperty firstname;
    private StringProperty lastname;
    private StringProperty staffId;
    private StringProperty phone;
    private StringProperty email;
    private StringProperty password;

    public AddTeacherViewModel(UsersManagementModel model) {
        this.usersManagementModel = model;

    }

}
