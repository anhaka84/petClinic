package Controller.Customer;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class CustomerChangeInfoController implements Initializable {
        @FXML
    private Button btnRefresh;

    @FXML
    private Button btnReset;

    @FXML
    private Button btnSave;

    @FXML
    private TextField fullName;

    @FXML
    private TextField username;

    @FXML
    private TextField password;

    @FXML
    private TextField email;

    @FXML
    private TextField address;

    @FXML
    private TextField phoneNumber;

    @FXML
    private DatePicker dob;

    @FXML
    private RadioButton male;

    @FXML
    private RadioButton female;
    
    @FXML
    private RadioButton other;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
}
