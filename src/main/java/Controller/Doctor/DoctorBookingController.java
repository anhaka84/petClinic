package Controller.Doctor;

import Controller.Router;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Acer
 */
public class DoctorBookingController implements Initializable {
    Router router = new Router();

    @FXML
    private TextField inputSearch;

    @FXML
    private Button btnSearch;

    @FXML
    private TextField petName;

    @FXML
    private TextField petType;

    @FXML
    private TextField petWeight;

    @FXML
    private TextField petAge;

    @FXML
    private TableView doctorBooking;

    @FXML
    private TableColumn bookingId;

    @FXML
    private TableColumn fullName;

    @FXML
    private TableColumn serviceName;

    @FXML
    private TableColumn bookingDate;

    @FXML
    private TableColumn bookingTime;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
