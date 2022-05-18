package view.booking.teacher.booking;

import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import view.ViewHandler;
import viewModel.booking.TeacherBookingViewModel;

public class TeacherBookingController {
    private TeacherBookingViewModel viewModel;
    private ViewHandler viewHandler;

    public ListView roomsList;
    public DatePicker bookingDate;
    public TextField startTime;
    public TextField endTime;
    private TextField date;


    public void init(ViewHandler viewHandler,TeacherBookingViewModel viewModel){
        this.viewModel=viewModel;
        this.viewHandler=viewHandler;
        bookingDate.valueProperty().addListener((observable ,oldValue,newValue)-> {
            date.textProperty().set(newValue.toString());
        });
        viewModel.bindDate(date.textProperty());
        viewModel.bindStartTime(startTime.textProperty());
        viewModel.bindEndTime(endTime.textProperty());

    }

    public void book(ActionEvent actionEvent) {
        System.out.println("book");
    }
    public void getAvailableRooms(ActionEvent actionEvent){
        roomsList.setItems(viewModel.getAvailableRooms());
    }
}
