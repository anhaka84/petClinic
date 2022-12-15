/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Doctor;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import Entities.ServiceEntity;
import Models.ServiceModel;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Acer
 */
public class DoctorChangeInfoController implements Initializable {

    @FXML
    private Button btnRefresh;

    @FXML
    private Button btnReset;

    @FXML
    private Button btnSave;

    @FXML
    private TextField fullName;

    @FXML
    private TextField title;

    @FXML
    private TextField username;

    @FXML
    private TextField password;

    @FXML
    private TextField email;

    @FXML
    private TextField address;

    @FXML
    private TextField phoneNumber;

    @FXML
    private DatePicker dob;

    @FXML
    private RadioButton male;

    @FXML
    private RadioButton female;
    
    @FXML
    private RadioButton other;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
