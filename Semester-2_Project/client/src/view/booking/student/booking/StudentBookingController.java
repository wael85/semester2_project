package view.booking.student.booking;

import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import room_model.Room;
import view.ViewHandler;
import viewModel.booking.StudentBookingViewModel;

import java.sql.Timestamp;

public class StudentBookingController {

    private ViewHandler viewHandler;

    private StudentBookingViewModel studentBookingViewModel;
    @FXML
    private ListView<Room> roomsList;
    @FXML
    private DatePicker bookingDate;
    @FXML
    private TextField startTime;
    @FXML
    private TextField endTime;
    private TextField date;

    public void init(ViewHandler viewHandler,StudentBookingViewModel studentBookingViewModel){
        this.viewHandler=viewHandler;
        this.studentBookingViewModel = studentBookingViewModel;
        bookingDate.valueProperty().addListener((observable ,oldValue,newValue)-> {
            date.textProperty().set(newValue.toString());
        });
        studentBookingViewModel.bindDate(date.textProperty());
        studentBookingViewModel.bindStartTime(startTime.textProperty());
        studentBookingViewModel.bindEndTime(endTime.textProperty());
    }
    public void book(ActionEvent actionEvent){
        //Timestamp startDateTime = new Timestamp(d.getYear()-1900,d.getMonth(),d.getDate(),Integer.parseInt(startTime.get()),0,0,0);
        System.out.println("booking");
    }
    public void getAvailableRooms(ActionEvent actionEvent){
        roomsList.setItems(studentBookingViewModel.getAvailableRooms());
    }
}
