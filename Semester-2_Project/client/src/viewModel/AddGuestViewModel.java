package viewModel;

import javafx.beans.property.StringProperty;
import model.Model;

public class AddGuestViewModel {
    private Model model;
    private StringProperty CompanyName;
    private StringProperty CVR;
    private StringProperty phone;
    private StringProperty email;
    private StringProperty password;

    public AddGuestViewModel(Model model) {
        this.model = model;

    }

}
