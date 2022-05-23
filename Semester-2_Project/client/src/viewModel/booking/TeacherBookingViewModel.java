package viewModel.booking;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.booking.BookingModel;
import room_model.Room;
import java.rmi.RemoteException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class TeacherBookingViewModel {
    private BookingModel bookingModel;
    private StringProperty startTime;
    private StringProperty endTime;
    private ObservableList<Room> roomsList;
    private StringProperty error;
    private Timestamp startTimeStamp;
    private Timestamp endTimeStamp;
    private Date date;
    public TeacherBookingViewModel(BookingModel bookingModel){
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
            startTimeStamp = new Timestamp(d.getYear()-1900,d.getMonth()-1,d.getDate(),Integer.parseInt(startTime.get()),0,0,0);
            endTimeStamp = new Timestamp(d.getYear()-1900,d.getMonth()-1,d.getDate(),Integer.parseInt(endTime.get()),0,0,0);
            ArrayList<Room> rooms =  bookingModel.getAvailableRooms(startTimeStamp,endTimeStamp).getRooms();
            this.roomsList.clear();
            this.roomsList.addAll(rooms);
            return roomsList;
        } catch (RemoteException e) {
            error.set(e.getMessage());
            return null;
        }
    }
    public void bookRoom(String roomId){
        try {
            error.set("");
            bookingModel.createBooking(roomId,startTimeStamp,endTimeStamp);
            error.set("Success!!");
            startTime.set("");
            endTime.set("");
            roomsList.clear();
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
