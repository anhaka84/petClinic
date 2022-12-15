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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 *
 * @author Acer
 */
public class CustomerServicesController implements Initializable{
    
        @FXML
    private TextField inputSearch;
    
    @FXML 
    private Button btnSearch;
    
     @FXML
    private TableView servicesTable;

    @FXML
    private TableColumn serviceId;

    @FXML
    private TableColumn serviceType;

    @FXML
    private TableColumn serviceName;

    @FXML
    private TableColumn servicePrice;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
