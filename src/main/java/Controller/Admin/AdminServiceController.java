package Controller.Admin;

import Controller.Router;
import com.aptech.mavenproject2.petclinic.AdminMainController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class AdminServiceController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void switchToHome() {
        Router.switchToAdminPage();
    }

    @FXML
    private void switchToBooking() {
        Router.switchPage(Router.getAdminBooking());
    }

    @FXML
    private void switchToServices() {
        Router.switchPage(Router.getAdminServices());
    }

    @FXML
    private void switchToMedicine() {
        Router.switchPage(Router.getAdminMedicines());
    }

    @FXML
    private void switchToManageAccount() {
        Router.switchPage(Router.getAdminManageAccount());
    }

    @FXML
    private void switchToChangeInfo() {
        Router.switchPage(Router.getAdminInfo());
    }

    @FXML
    private void SignOut() {
        AdminMainController amc = new AdminMainController();
        amc.SignOut();
    }

}
