package view.manageRooms;

import javafx.event.ActionEvent;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import view.ViewHandler;
import viewModel.ViewModelFactory;

public class ManageRoomsController {
    public TextField room_Id;
    public TextField building;
    public TextField floor;
    public TextField capacity;
    public ToggleGroup RoomType;
    public RadioButton ClassRoom;
    public RadioButton AuditoryRoom;
    private ViewHandler viewHandler;
    public void init(ViewModelFactory viewModelFactory,ViewHandler viewHandler){
        this.viewHandler=viewHandler;
    }

    public void createRoom(ActionEvent actionEvent) {

    }

    public void deleteRoom(ActionEvent actionEvent) {
    }

    public void backToMain(ActionEvent actionEvent) {
        viewHandler.openMainMenu();
    }
}
