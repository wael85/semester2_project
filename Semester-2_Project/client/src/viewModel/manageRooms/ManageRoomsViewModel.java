package viewModel.manageRooms;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import room_model.Room;
import model.rooms.RoomManagementModel;
import room_model.Rooms;
import model.inputValidation.ValidatorManageRooms;

import java.beans.PropertyChangeEvent;
import java.rmi.RemoteException;

public class ManageRoomsViewModel {
    private RoomManagementModel model;
    private StringProperty building;
    private StringProperty floor;
    private StringProperty number;
    private StringProperty type;
    private StringProperty capacity;
    private ObservableList<Room> roomsList;


    public ManageRoomsViewModel(RoomManagementModel model) {
        this.model = model;
        model.addPropertyChangeListener("rooms", event -> {
            updateRoomsList(event);
        });
        this.building = new SimpleStringProperty("");
        this.floor = new SimpleStringProperty("");
        this.number = new SimpleStringProperty("");
        this.type = new SimpleStringProperty("");
        this.capacity = new SimpleStringProperty("");
        this.roomsList = FXCollections.observableArrayList();

    }

    public void bindBuilding(StringProperty property) {
        property.bindBidirectional(building);
    }

    public void bindFloor(StringProperty property) {
        property.bindBidirectional(floor);
    }

    public void bindNumber(StringProperty property) {
        property.bindBidirectional(number);
    }

    public void setType(String type) {
        this.type.set(type);
    }

    public void bindCapacity(StringProperty property) {
        property.bindBidirectional(capacity);
    }

    public void createRoom() {
        try {

            ValidatorManageRooms.validateBuilding(building.get());
            ValidatorManageRooms.validateFloor(floor.get());
            ValidatorManageRooms.validateNumber(number.get());
            ValidatorManageRooms.validateCapacity(capacity.get(), type.get());

            model.createRoom(building.get(), floor.get(), number.get(), type.get(), capacity.get());
            clearFields();

        } catch (Exception e) {
            if (e.getMessage().contains("duplicate key value")) {
                notification("User already existed");
            } else
                notification(e.getMessage());
        }
    }

    public void notification(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setContentText(msg);
        alert.showAndWait();
    }

    public void deleteRoom(String roomId) {
        try {
            model.deleteRoom(roomId);
        } catch (RemoteException e) {
            notification(e.getMessage());
        }
    }

    public ObservableList<Room> getRoomsList() {
        try {
            this.roomsList.clear();
            this.roomsList.addAll(model.getAllRooms().getRooms());
        } catch (RemoteException e) {
            notification(e.getMessage());
        }
        return this.roomsList;
    }

    public void updateRoomsList(PropertyChangeEvent event) {
        Platform.runLater(() -> {
            roomsList.clear();
            roomsList.addAll(((Rooms) event.getNewValue()).getRooms());
        });

    }

    public void clearFields() {
        building.set("");
        floor.set("");
        number.set("");
        capacity.set("");

    }

}
