package Controller.Customer;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;

public class CustomerBookingController implements Initializable {

    @FXML
    private ComboBox chooseDoctor;

    @FXML
    private ComboBox chooseStype;

    @FXML
    private DatePicker bookingDate;

    @FXML
    private RadioButton morning;

    @FXML
    private RadioButton afernoon;

    @FXML
    private Button btnRefresh;

    @FXML
    private Button btnReset;

    @FXML
    private Button btnSave;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

}
