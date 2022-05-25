package viewModel.booking;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.cell.PropertyValueFactory;
import model.booking.BookingModel;
import model.inputValidation.ValidatorBooking;
import room_model.Room;
import room_model.RoomTypes;
import room_model.Rooms;

import javax.swing.*;
import java.rmi.RemoteException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class StudentBookingViewModel {
    private BookingModel bookingModel;
    private StringProperty startTime;
    private StringProperty endTime;
    private ObservableList<Room> roomsList;
    private StringProperty error;
    private Timestamp startTimeStamp;
    private Timestamp endTimeStamp;
    private Date date;
    public  StudentBookingViewModel(BookingModel bookingModel){
        this.bookingModel = bookingModel;
        this.date=null;
        this.startTime = new SimpleStringProperty("");
        this.endTime = new SimpleStringProperty("");
        this.roomsList = FXCollections.observableArrayList();
        this.error = new SimpleStringProperty("");
        bookingModel.addPropertyChangeListener("getAvailableRooms",evt -> {
            if (date != null) {
                updateRoomsList();
            }
        });

    }
    public void bindEndTime(StringProperty property){
        property.bindBidirectional(endTime);
    }
    public void bindStartTime(StringProperty property){
        property.bindBidirectional(startTime);
    }
    public void bindError(StringProperty property){
        property.bind(error);
    }

    public ObservableList<Room> getAvailableRooms(Date d){
        try {
            this.date=d;
            ArrayList<Room> rooms;
            if (!(startTime.get().equals("")||endTime.get().equals(""))){
                if (ValidatorBooking.validatorTime(date,startTime.get(), endTime.get())) {
                    int start = Integer.parseInt(startTime.get());
                    int end = Integer.parseInt(endTime.get());
                    startTimeStamp = new Timestamp(d.getYear() - 1900, d.getMonth() - 1, d.getDate(), start, 0, 0, 0);
                    endTimeStamp = new Timestamp(d.getYear() - 1900, d.getMonth() - 1, d.getDate(), end, 0, 0, 0);
                    rooms = bookingModel.getAvailableRooms(startTimeStamp, endTimeStamp).getRoomsByType(RoomTypes.STUDY_ROOM.type);
                    this.roomsList.clear();
                    this.roomsList.addAll(rooms);
                    return roomsList;
                }
            }
            return null;
        } catch (RemoteException e) {
            error.set(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    public void bookRoom(String roomId){
        try {
            error.set("");
            if(bookingModel.getUserBooking().getSize() >0){
                JOptionPane.showMessageDialog(null,"You already have an Active Booking!!!");
            }else {
                bookingModel.createBooking(roomId,startTimeStamp,endTimeStamp);
                error.set("Success!!");
                startTime.set("");
                endTime.set("");
                roomsList.clear();
            }
        } catch (RemoteException e) {
            error.set("");
            error.set(e.getMessage());
            System.out.println(e.getMessage());
        }
    }
    public void updateRoomsList(){
        Platform.runLater(()->{
            getAvailableRooms(date);
        });
    }

}
