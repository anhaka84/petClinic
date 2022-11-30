package Controller;

import Entities.*;
import Session.SessionWriter;
import com.aptech.mavenproject2.petclinic.App;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DialogEvent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class LoginController implements Initializable {

    @FXML
    private TextField inputTextUsername;

    @FXML
    private PasswordField inputTextPassword;

    @FXML
    private CheckBox inputCBoxRemember;

    @FXML
    private Label errorUsername;

    @FXML
    private Label errorPassword;

    AccountEntity accM = new AccountEntity();
    UserEntity userEntity = new UserEntity();
    SignEntity signM = new SignEntity();
    SessionWriter sessionWriter = new SessionWriter();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String sessionUsername = "";
        String sessionPassword = "";
        if (sessionWriter.isLineOfSession("remember=true")) {
            sessionUsername = sessionWriter.getLineStartWith("username=").split("=")[1];
            sessionPassword = sessionWriter.getLineStartWith("password=").split("=")[1];
            inputCBoxRemember.setSelected(true);
        }

        inputTextUsernameValidate();
        inputTextPasswordValidate();

        inputTextUsername.setText(sessionUsername);
        inputTextPassword.setText(sessionPassword);

    }

    @FXML
    public void goToSignUp()
            throws IOException {
        App.setRoot("SignUp");
    }

    @FXML
    public void goToHomePage()
            throws IOException {
//        String username = inputTextUsername.getText();
//        int id = accM.getAccountId(username);
//        int role = userEntity.getSessionUser().getRole();
//        if (role == 1) {
            App.setRoot("secondary");
//        }
//        if (role == 2) {
//            App.setRoot("SignUp");
//        }
//        if (role == 3) {
//            App.setRoot("Login");
//        }
    }

    @FXML
    private void inputTextUsernameValidate() {
        inputTextUsername.setOnKeyPressed((KeyEvent t) -> {
            if (t.getCode() == KeyCode.ENTER
                    && inputTextUsername.getText().isEmpty()) {
                errorUsername.setText("Required");
            }
            if (t.getCode() == KeyCode.SPACE
                    || inputTextUsername.getText().split(" ").length > 1) {
                errorUsername.setText("Format");
            }
            if (t.getCode() != KeyCode.SPACE
                    && t.getCode() != KeyCode.ENTER
                    && inputTextUsername.getText().split(" ").length == 1) {
                errorUsername.setText(null);
            }
            if (t.getCode() == KeyCode.ENTER
                    && !inputTextUsername.getText().isEmpty()) {
                if (inputTextPassword.getText() == null
                        || inputTextPassword.getText().isEmpty()) {
                    inputTextPassword.requestFocus();
                } else {
                    try {
                        SignInEvent(new ActionEvent());
                    } catch (IOException ex) {
                    }
                }
            }
        });
    }

    @FXML
    private void inputTextPasswordValidate() {
        inputTextPassword.setOnKeyPressed((KeyEvent t) -> {
            if (t.getCode() == KeyCode.ENTER
                    && inputTextPassword.getText().isEmpty()) {
                errorPassword.setText("Required");
            }
            if (t.getCode() != KeyCode.ENTER) {
                errorPassword.setText(null);
            }
            if (t.getCode() == KeyCode.ENTER
                    && !inputTextPassword.getText().isEmpty()) {
                if (inputTextUsername.getText() == null
                        || inputTextUsername.getText().isEmpty()) {
                    inputTextUsername.requestFocus();
                    errorUsername.setText("Required");
                } else {
                    try {
                        SignInEvent(new ActionEvent());
                    } catch (IOException ex) {
                    }
                }
            }
        });
    }

    @FXML
    public void SignInEvent(ActionEvent event)
            throws IOException {
        String inputUsername = inputTextUsername.getText();
        String inputPassword = inputTextPassword.getText();
        boolean remember = false;
        if (accM.checkInputAccount(inputUsername, inputPassword)) {
            if (inputCBoxRemember.isSelected()) {
                remember = true;
            }
            if (!signM.signIn(inputUsername, inputPassword, remember)) {
                errorInput();
            } else {
                goToHomePage();
            }
        } else {
            errorUsername.setText("Error username !!!");
            errorPassword.setText("Error password !!!");
            errorExitApp();
        }
    }

    @FXML
    private void errorInput() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setResizable(false);
        alert.setTitle("Login Fail !!");
        alert.setHeaderText("Username or password incorrect !!");
        alert.setContentText("Please re-enter username or password");
        alert.show();
    }

    @FXML
    private void errorExitApp() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setResizable(false);
        alert.setTitle("ERROR");
        alert.setHeaderText("SQL Injection detection !!!!");
        alert.setOnCloseRequest((DialogEvent t) -> {
            Platform.exit();
        });
        ButtonType exitApp = new ButtonType("Exit");
        alert.getButtonTypes().clear();
        alert.getButtonTypes().add(exitApp);
        if (alert.showAndWait().get() == exitApp) {
            Platform.exit();
        }
    }
}
