package viewModel;

import javafx.beans.property.StringProperty;
import model.Model;

public class AddStudentViewModel {
    private Model model;
    private StringProperty firstname;
    private StringProperty lastname;
    private StringProperty studentNumber;
    private StringProperty phone;
    private StringProperty email;
    private StringProperty password;

    public AddStudentViewModel(Model model) {
        this.model = model;

    }

}
