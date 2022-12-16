package Controller.Doctor;

import Controller.Router;
import Controller.SignController.SignOutController;
import com.aptech.mavenproject2.petclinic.App;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.*;
import javafx.scene.control.*;

public class DoctorHomepageController implements Initializable {

    Router router = new Router();

    @FXML
    private Button btnHome, btnBooking, btnSchedule, btnInfo;

    @FXMl
    private HBox hboxBooking, hboxSchedule, hboxInfo;

    @FXML
    private void switchToHome() {
        App.setRoot("Doctor_Homepage");
    }

    @FXML
    private void switchToBooking() {
        App.setRoot("Doctor_Homepage");
    }

    @FXML
    private void switchToSchedule() {
        App.setRoot("Doctor_Schedule");
    }

    @FXML
    private void switchToInfo() {
        App.setRoot("Doctor_Homepage");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
//    @FXML
//    public void signOutEvent() {
//        SignOutController.signOutEvent();
//    }

}
