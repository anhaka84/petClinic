package Controller.Doctor;

import Controller.SignController.SignOutController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class DoctorHomepageController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    public void signOutEvent() {
        SignOutController.signOutEvent();
    }

}