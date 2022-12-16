package Controller.Customer;

import Models.UserModel;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class CustomerDoctorController implements Initializable {

    @FXML
    private TableView tblDoctor;

    @FXML
    private TableColumn<UserModel, Integer> ColNo;

    @FXML
    private TableColumn<UserModel, String> ColName;

    @FXML
    private TableColumn<UserModel, String> ColEmail;

    @FXML
    private TableColumn<UserModel, String> ColPhone;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

}
