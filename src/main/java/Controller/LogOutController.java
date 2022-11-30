package Controller;

import Entities.SignEntity;
import com.aptech.mavenproject2.petclinic.App;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class LogOutController {

    SignEntity signEntity = new SignEntity();

    @FXML
    private void goToLogIn() throws IOException {
        App.setRoot("Login");
    }

    public void signOutEvent(ActionEvent event) throws IOException {
        if (signEntity.signOut()) {
            goToLogIn();
        }
    }
}
