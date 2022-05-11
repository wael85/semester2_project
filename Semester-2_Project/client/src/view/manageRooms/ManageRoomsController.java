package view.manageRooms;

import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import room_model.Rooms;
import view.ViewHandler;
import viewModel.ViewModelFactory;

public class ManageRoomsController {

    public TextField building;
    public TextField floor;
    public TextField capacity;
    public ToggleGroup RoomType;
    public RadioButton ClassRoom;
    public RadioButton AuditoryRoom;
    public RadioButton StudyRoom;
    public ListView<Rooms> list;
    private ViewHandler viewHandler;
    public void init(ViewModelFactory viewModelFactory,ViewHandler viewHandler){
        this.viewHandler=viewHandler;
    }

    public void createRoom() {

    }

    public void deleteRoom() {
    }

    public void backToMain(ActionEvent actionEvent) {
        viewHandler.openMainMenu();
    }
}
