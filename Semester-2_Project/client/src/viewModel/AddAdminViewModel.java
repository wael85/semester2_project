package viewModel;

import javafx.beans.property.StringProperty;
import model.Model;

public class AddAdminViewModel {
    private Model model;
    private StringProperty firstname;
    private StringProperty lastname;
    private StringProperty AdminId;
    private StringProperty phone;
    private StringProperty email;
    private StringProperty password;


    public AddAdminViewModel(Model model) {
        this.model = model;
    }


}
