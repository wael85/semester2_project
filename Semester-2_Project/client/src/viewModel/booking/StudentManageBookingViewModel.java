package viewModel.booking;

import booking.Booking;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import model.booking.BookingModel;

import java.rmi.RemoteException;

public class StudentManageBookingViewModel {

    private BookingModel bookingModel;
    private ObservableList<Booking> userObservableList;

    public StudentManageBookingViewModel(BookingModel bookingModel){
        this.bookingModel = bookingModel;
        userObservableList = FXCollections.observableArrayList();
    }

    public ObservableList<Booking> getListOfBookings() {
        try {

            userObservableList.addAll(bookingModel.getUserBooking().getBookingList());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return userObservableList;

    }
    public void cancelBooking(Booking booking){
        try {
            bookingModel.cancelBooking(booking);
            userObservableList.remove(booking);
            notification(booking.getId()+", deleted successfully");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }



    public void notification(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setContentText(msg);
        alert.showAndWait();
    }

}
