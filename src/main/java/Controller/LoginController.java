package Controller;

import Entities.*;
import com.aptech.mavenproject2.petclinic.App;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    AccountEntity accM = new AccountEntity();
    SignEntity signM = new SignEntity();

    @FXML
    private TextField inputTextUsername;

    @FXML
    private PasswordField inputTextPassword;

    @FXML
    private CheckBox inputCBoxRemember;

    @FXML
    public void SignInEvent(ActionEvent event) throws IOException {
        String inputUsername = inputTextUsername.getText();
        String inputPassword = inputTextPassword.getText();
        boolean remember = false;
        if (accM.checkInputAccount(inputUsername, inputPassword)) {
            if (inputCBoxRemember.isSelected()) {
                remember = true;
            }
        }
        if (signM.signIn(inputUsername, inputPassword, remember)) {
            goToHomePage();
        }
    }

    @FXML
    public void goToHomePage()
            throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    public void inputAction(ActionEvent event) {
        String inputUsername = inputTextUsername.getText();
        System.out.println(inputUsername);
    }
}
