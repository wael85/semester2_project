package viewModel.booking;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import model.booking.BookingModel;
import room_model.Room;
import room_model.Rooms;

import java.rmi.RemoteException;
import java.sql.Timestamp;
import java.util.Date;

public class StudentBookingViewModel {
    private BookingModel bookingModel;
    private StringProperty startTime;
    private StringProperty endTime;
    private ObservableList<Room> roomsList;
    private StringProperty error;
    private Timestamp startTimeStamp;
    private Timestamp endTimeStamp;

    public  StudentBookingViewModel(BookingModel bookingModel){
        this.bookingModel = bookingModel;
        this.startTime = new SimpleStringProperty("");
        this.endTime = new SimpleStringProperty("");
        this.roomsList = FXCollections.observableArrayList();
        this.error = new SimpleStringProperty("");
       // bookingModel.addPropertyChangeListener("getAvailableRooms",evt -> getAvailableRooms());
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
            startTimeStamp = new Timestamp(d.getYear()-1900,d.getMonth()-1,d.getDate(),Integer.parseInt(startTime.get()),0,0,0);
            endTimeStamp = new Timestamp(d.getYear()-1900,d.getMonth()-1,d.getDate(),Integer.parseInt(endTime.get()),0,0,0);
          Rooms rooms =  bookingModel.getAvailableRooms(startTimeStamp,endTimeStamp);
          this.roomsList.clear();
          this.roomsList.addAll(rooms.getRooms());
          return roomsList;
        } catch (RemoteException e) {
            error.set(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    public void bookRoom(String roomId){
        try {
            error.set("");
            bookingModel.createBooking(roomId,startTimeStamp,endTimeStamp);
            error.set("Success!!");
        } catch (RemoteException e) {
            error.set("");
            error.set(e.getMessage());
        }
    }

}
