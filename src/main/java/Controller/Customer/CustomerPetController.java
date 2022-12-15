/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Customer;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

/**
 *
 * @author Acer
 */
public class CustomerPetController implements Initializable {

 
    @FXML
    private TextField petName;

    @FXML
    private TextField petType;

    @FXML
    private TextField petWeight;

    @FXML
    private TextField petAge;
    
        @FXML
    private RadioButton male;

    @FXML
    private RadioButton female;

    @FXML
    private RadioButton dog;

    @FXML
    private RadioButton cat;

    @FXML
    private Button btnRefresh;

    @FXML
    private Button btnReset;

    @FXML
    private Button btnSave;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
