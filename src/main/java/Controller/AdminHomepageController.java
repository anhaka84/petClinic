package Controller;

import Entities.SignEntity;
import com.aptech.mavenproject2.petclinic.App;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class AdminHomepageController implements Initializable {

    SignEntity signEntity = new SignEntity();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    private void goToLogIn()
            throws IOException {
        App.setRoot("Login");
    }

    @FXML
    public void signOutEvent(ActionEvent event)
            throws IOException {
        if (signEntity.signOut()) {
            goToLogIn();
        }
    }

}
