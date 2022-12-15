/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Doctor;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 *
 * @author Acer
 */
public class DoctorScheduleController implements Initializable{
    
    @FXML
    private DatePicker doctorScheduleDate;
    
    @FXML
    private RadioButton morning;
    
    @FXML
    private RadioButton afernoon;

    @FXML
    private RadioButton all;
    
    @FXML
    private TextField search;
    
    @FXML 
    private Button btnSearch;
    
    @FXML 
    private Button btnRefresh;
    
    @FXML 
    private Button btnReset;

    @FXML 
    private Button btnSave;
    
    @FXML 
    private TableView tableDoctorSchedule;
    
    @FXML
    private TableColumn scheduleID;
    
    @FXML
    private TableColumn scheduleDate;
    
    @FXML
    private TableColumn scheduleTime;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
