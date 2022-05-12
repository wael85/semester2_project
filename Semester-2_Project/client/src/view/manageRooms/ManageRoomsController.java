package view.manageRooms;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import room_model.Room;
import room_model.Rooms;
import view.ViewHandler;
import viewModel.ViewModelFactory;
import viewModel.manageRooms.ManageRoomsViewModel;

public class ManageRoomsController {

    @FXML
    public TextField building;
    @FXML
    public TextField floor;
    @FXML
    public TextField roomNumber;
    @FXML
    public TextField capacity;
    @FXML
    public ToggleGroup RoomType;
    @FXML
    public RadioButton ClassRoom;
    @FXML
    public RadioButton AuditoryRoom;
    @FXML
    public RadioButton StudyRoom;
    @FXML
    public ListView<Room> list;
    private ViewHandler viewHandler;
    private ManageRoomsViewModel manageRoomsViewModel;

    public void init(ManageRoomsViewModel manageRoomsViewModel,ViewHandler viewHandler){
        this.manageRoomsViewModel = manageRoomsViewModel;
        this.viewHandler=viewHandler;
        manageRoomsViewModel.bindBuilding(building.textProperty());
        manageRoomsViewModel.bindFloor(floor.textProperty());
        manageRoomsViewModel.bindCapacity(capacity.textProperty());
        manageRoomsViewModel.bindNumber(roomNumber.textProperty());
        manageRoomsViewModel.bindCapacity(capacity.textProperty());
        manageRoomsViewModel.setType(ClassRoom.getUserData().toString());
        RoomType.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle oldToggle, Toggle newToggle) {
               manageRoomsViewModel.setType(RoomType.selectedToggleProperty().getValue().getUserData().toString());
            }
        });
        list.setItems(manageRoomsViewModel.getRoomsList());
    }

    public void createRoom() {
       manageRoomsViewModel.createRoom();
    }

    public void deleteRoom() {
        manageRoomsViewModel.deleteRoom(list.getSelectionModel().getSelectedItem().getRoomId());
    }

    public void backToMain(ActionEvent actionEvent) {
        viewHandler.openMainMenu();
    }
}
