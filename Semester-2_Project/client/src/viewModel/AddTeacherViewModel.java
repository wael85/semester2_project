package viewModel;

import javafx.beans.property.StringProperty;
import model.Model;


public class AddTeacherViewModel {
    private Model model;
    private StringProperty firstname;
    private StringProperty lastname;
    private StringProperty staffId;
    private StringProperty phone;
    private StringProperty email;
    private StringProperty password;

    public AddTeacherViewModel(Model model) {
        this.model = model;

    }

}
