package com.aptech.mavenproject2.petclinic;

import Controller.Router;
import Controller.SignController.SignOutController;
import Entities.UserEntity;
import Session.SessionWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class DoctorMainController implements Initializable {

    @FXML
    private BorderPane mainPage;

    @FXML
    private Label labelTitlePage;

    private static final String HOME_TITLE = "Welcome to Pet Clinic";
    private static final String BOOKING_TITLE = "Booking";
    private static final String SCHEDULE_TITLE = "Schedule";
    private static final String YOUR_INFO_TITLE = "Your Info";

    private final UserEntity userEntity = new UserEntity();
    private final SessionWriter session = new SessionWriter();
    private final int id = userEntity.getSessionUser().getUserId();
    private final String bool = session.getLineStartWith("remember=").substring("remember=".length());
    private final boolean remember = Boolean.parseBoolean(bool);

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        getHome();
    }

    private void setPageTitle(String title) {
        labelTitlePage.setText(title);
    }

    @FXML
    private void getHome() {
        try {
            Pane view = App.getPane(Router.getDoctorHomepage());
            mainPage.setCenter(view);
            setPageTitle(HOME_TITLE);
        } catch (IOException ex) {
        }
    }

    @FXML
    private void getBooking() {
        try {
            Pane view = App.getPane(Router.getDoctorBooking());
            mainPage.setCenter(view);
            setPageTitle(BOOKING_TITLE);
        } catch (IOException ex) {
        }
    }

    @FXML
    private void getSchedule() {
        try {
            Pane view = App.getPane(Router.getDoctorSchedule());
            mainPage.setCenter(view);
            setPageTitle(SCHEDULE_TITLE);
        } catch (IOException ex) {
        }
    }

    @FXML
    private void getUserInfo() {
        try {
            Pane view = App.getPane(Router.getDoctorInfo());
            mainPage.setCenter(view);
            setPageTitle(YOUR_INFO_TITLE);
        } catch (IOException ex) {
        }
    }

    @FXML
    private void SignOut() {
        SignOutController.signOutEvent(id, remember);
    }
}
