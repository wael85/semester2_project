package viewModel.manageRooms;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import room_model.RoomManagementModel;
import room_model.Rooms;
import users_model.User;

import java.rmi.RemoteException;

public class ManageRoomsViewModel {
    private RoomManagementModel model;
    private StringProperty building;
    private StringProperty floor;
    private StringProperty number;
    private StringProperty type;
    private StringProperty capacity;
    private ObservableList<User> list;


    public ManageRoomsViewModel(RoomManagementModel model) {
        this.model = model;
        this.building = new SimpleStringProperty("");
        this.floor= new SimpleStringProperty("");
        this.number = new SimpleStringProperty("");
        this.type = new SimpleStringProperty("");
        this.capacity = new SimpleStringProperty("");
        this.list= FXCollections.observableArrayList();

    }

    public void createRoom(){
        try {

            model.createRoom(building.get(), floor.get(), number.get(), type.get(), capacity.get());

        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
    public void deleteRoom(String roomId){
        try {
            model.deleteRoom(roomId);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }


    public void clearFields(){
        building.set("");
        floor.set("");
        number.set("");
        capacity.set("");

    }

}
