package Controller;

import Entities.*;
import Session.SessionWriter;
import com.aptech.mavenproject2.petclinic.App;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController implements Initializable {

    AccountEntity accM = new AccountEntity();
    SignEntity signM = new SignEntity();
    SessionWriter sessionWriter = new SessionWriter();

    @FXML
    private TextField inputTextUsername;

    @FXML
    private PasswordField inputTextPassword;

    @FXML
    private CheckBox inputCBoxRemember;
    
    @FXML
    private Hyperlink linkSignUp;

    @FXML
    public void goToHomePage()
            throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    public void sceneAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Login Fail !!");
        alert.setHeaderText("Username or password incorrect !!");
        alert.setContentText("Please re-enter username or password");
        alert.show();
    }

    @FXML
    public boolean SignInEvent(ActionEvent event)
            throws IOException {
        String inputUsername = inputTextUsername.getText();
        String inputPassword = inputTextPassword.getText();
        boolean remember = false;
        if (accM.checkInputAccount(inputUsername, inputPassword)) {
            if (inputCBoxRemember.isSelected()) {
                remember = true;
            }
        }
        if (!signM.signIn(inputUsername, inputPassword, remember)) {
            sceneAlert();
        } else {
            goToHomePage();
            return true;
        }
        return false;
    }

    @FXML
    public void inputAction(ActionEvent event)
            throws IOException {
        if (inputTextPassword.getText() == null
                || inputTextPassword.getText().isEmpty()) {
            inputTextPassword.requestFocus();
        } else {
            SignInEvent(event);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String sessionUsername = "";
        String sessionPassword = "";

        if (sessionWriter.isLineOfSession("remember=true")) {
            sessionUsername = sessionWriter.getLineStartWith("username=").split("=")[1];
            sessionPassword = sessionWriter.getLineStartWith("password=").split("=")[1];
            inputCBoxRemember.setSelected(true);
        }
        inputTextUsername.setText(sessionUsername);
        inputTextPassword.setText(sessionPassword);
    }
}
