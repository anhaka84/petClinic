package Controller.Admin;

import Controller.SignController.SignOutController;
import Entities.BookingEntity;
import Models.BookingModel;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class AdminBookingController implements Initializable {

    @FXML
    private Button btnSearch;

    @FXML
    private TextField inputSearch;

    @FXML
    private TableView tableBooking;

    @FXML
    private TableColumn<BookingModel, Integer> bookingId;

    @FXML
    private TableColumn<BookingModel, Integer> userId;

    @FXML
    private TableColumn<BookingModel, Integer> petId;

    @FXML
    private TableColumn<BookingModel, Integer> serviceId;

    @FXML
    private TableColumn<BookingModel, Float> price;

    @FXML
    private TableColumn<BookingModel, Date> bookingDate;

    @FXML
    private TableColumn<BookingModel, String> bookingTime;

    @FXML
    private TableColumn<BookingModel, Date> updateDate;

    private ObservableList<BookingModel> bookingList;

    private final BookingEntity bookingEntity = new BookingEntity();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        bookingList = FXCollections.observableArrayList(bookingEntity.getAllBooking());

        bookingId.setCellValueFactory(new PropertyValueFactory<>("bookingId"));
        userId.setCellValueFactory(new PropertyValueFactory<>("userId"));
        petId.setCellValueFactory(new PropertyValueFactory<>("petId"));
        serviceId.setCellValueFactory(new PropertyValueFactory<>("serviceId"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        bookingDate.setCellValueFactory(new PropertyValueFactory<>("bookingDate"));
        bookingTime.setCellValueFactory(new PropertyValueFactory<>("bookingTime"));
        updateDate.setCellValueFactory(new PropertyValueFactory<>("updateDate"));

        tableBooking.setId("tableBooking");

        tableBooking.setItems(bookingList);
    }

    public void signOutEvent() {
        SignOutController.signOutEvent();
    }

}
