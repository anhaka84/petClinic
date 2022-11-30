/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.aptech.mavenproject2.petclinic;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ToggleGroup;
/**
 * FXML Controller class
 *
 * @author Hoang Anh
 */
public class Customer_PetController implements Initializable {


    @FXML
    private ToggleGroup gender;
    
    @FXML
    private ChoiceBox<String> petChoiceBox;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> petType = FXCollections.observableArrayList("Dog", "Cat");
        petChoiceBox.setItems(petType);
    }    
    
}
