package viewModel;

import javafx.beans.property.StringProperty;
import users_model.UsersManagementModel;

public class AddStudentViewModel {
    private UsersManagementModel usersManagementModel;
    private StringProperty firstname;
    private StringProperty lastname;
    private StringProperty studentNumber;
    private StringProperty phone;
    private StringProperty email;
    private StringProperty password;

    public AddStudentViewModel(UsersManagementModel model) {
        this.usersManagementModel = model;

    }

}
