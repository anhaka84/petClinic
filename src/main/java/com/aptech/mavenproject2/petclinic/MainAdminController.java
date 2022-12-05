package com.aptech.mavenproject2.petclinic;

import Controller.Router;
import Controller.SignController.SignOutController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class MainAdminController implements Initializable {

    @FXML
    private BorderPane mainPage;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        getDashboard();
    }

    @FXML
    private void getDashboard() {
        try {
            Pane view = App.getPane(Router.getAdminHomepage());
            mainPage.setCenter(view);
        } catch (IOException ex) {
        }
    }

    @FXML
    private void getBooking() {
        try {
            Pane view = App.getPane(Router.getAdminBooking());
            mainPage.setCenter(view);
        } catch (IOException ex) {
        }
    }

    @FXML
    private void getBill() {
//        Pane view = App.getPane();
//        mainPage.setCenter(view);
    }

    @FXML
    private void getServices() {
//        Pane view = App.getPane();
//        mainPage.setCenter(view);
    }

    @FXML
    private void getMedicines() {
//        Pane view = App.getPane();
//        mainPage.setCenter(view);
    }

    @FXML
    private void getManageAccount() {
//        Pane view = App.getPane();
//        mainPage.setCenter(view);
    }

    @FXML
    private void getUserInfo() {
//        Pane view = App.getPane();
//        mainPage.setCenter(view);
    }

    @FXML
    private void SignOut() {
        SignOutController.signOutEvent();
    }

}
