package com.aptech.mavenproject2.petclinic;

import Controller.Router;
import Controller.SignController.SignOutController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class MainAdminController implements Initializable {

    @FXML
    private BorderPane mainPage;

    @FXML
    private Label headerTitle;

    private static final String DASHBOARD_TITLE = "Welcome to Pet Clinic";
    private static final String BOOKING_TITLE = "Booking";
    private static final String BILL_TITLE = "Bill";
    private static final String SERVICES_TITLE = "Services";
    private static final String MEDICINES_TITLE = "Medicines";
    private static final String MANAGE_ACCOUNT_TITLE = "Account";
    private static final String YOUR_INFO_TITLE = "Your Info";

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        getDashboard();
    }

    @FXML
    private void setPageTitle(String title) {
        headerTitle.setText(title);
    }

    @FXML
    private void getDashboard() {
        try {
            Pane view = App.getPane(Router.getAdminHomepage());
            mainPage.setCenter(view);
            setPageTitle(DASHBOARD_TITLE);
        } catch (IOException ex) {
        }
    }

    @FXML
    private void getBooking() {
        try {
            Pane view = App.getPane(Router.getAdminBooking());
            mainPage.setCenter(view);
            setPageTitle(BOOKING_TITLE);
        } catch (IOException ex) {
        }
    }

    @FXML
    private void getBill() {
        try {
            Pane view = App.getPane(Router.getAdminBill());
            mainPage.setCenter(view);
            setPageTitle(BILL_TITLE);
        } catch (IOException ex) {
        }
    }

    @FXML
    private void getServices() {
        try {
            Pane view = App.getPane(Router.getAdminServices());
            mainPage.setCenter(view);
            setPageTitle(SERVICES_TITLE);
        } catch (IOException ex) {
        }
    }

    @FXML
    private void getMedicines() {
        try {
            Pane view = App.getPane(Router.getAdminMedicines());
            mainPage.setCenter(view);
            setPageTitle(MEDICINES_TITLE);
        } catch (IOException ex) {
        }
    }

    @FXML
    private void getManageAccount() {
        try {
            Pane view = App.getPane(Router.getAdminManageAccount());
            mainPage.setCenter(view);
            setPageTitle(MANAGE_ACCOUNT_TITLE);
        } catch (IOException ex) {
        }
    }

    @FXML
    private void getUserInfo() {
        try {
            Pane view = App.getPane(Router.getAdminYourInfo());
            mainPage.setCenter(view);
            setPageTitle(YOUR_INFO_TITLE);
        } catch (IOException ex) {
        }
    }

    @FXML
    private void SignOut() {
        SignOutController.signOutEvent();
    }
}
