package viewModel.booking;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.booking.BookingModel;
import room_model.Room;
import room_model.Rooms;

import java.rmi.RemoteException;
import java.sql.Timestamp;
import java.util.Date;

public class GuestBookingViewModel {
    private BookingModel bookingModel;
    private StringProperty date;
    private StringProperty startTime;
    private StringProperty endTime;
    private ObservableList<Room> roomsList;
    private StringProperty error;

    public GuestBookingViewModel(BookingModel bookingModel){
        this.bookingModel = bookingModel;
        this.date = new SimpleStringProperty("");
        this.startTime = new SimpleStringProperty("");
        this.endTime = new SimpleStringProperty("");
        this.roomsList = FXCollections.observableArrayList();
        this.error = new SimpleStringProperty("");
    }

    public void bindDate(StringProperty textProperty) {
        textProperty.bindBidirectional(date);
    }

    public void bindStartTime(StringProperty textProperty) {
        textProperty.bindBidirectional(startTime);
    }

    public void bindEndTime(StringProperty textProperty) {
        textProperty.bindBidirectional(endTime);
    }

    public ObservableList getAvailableRooms() {
        try {
            Date d = new Date(date.get());
            Timestamp startDateTime = new Timestamp(d.getYear()-1900,d.getMonth(),d.getDate(),Integer.parseInt(startTime.get()),0,0,0);
            Rooms rooms =  bookingModel.getAvailableRooms(startDateTime,startDateTime);
            this.roomsList.clear();
            this.roomsList.addAll(rooms.getRooms());
            return roomsList;
        } catch (RemoteException e) {
            error.set(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
