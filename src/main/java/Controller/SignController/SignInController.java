package Controller.SignController;

import Controller.Router;
import Entities.*;
import Session.SessionWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
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

public class SignInController implements Initializable {

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
        //remember
        String sessionUsername = "";
        String sessionPassword = "";
        if (sessionWriter.isLineOfSession("remember=true")) {
            sessionUsername = sessionWriter.getLineStartWith("username=").substring("username=".length());
            sessionPassword = sessionWriter.getLineStartWith("password=").substring("password=".length());
            inputCBoxRemember.setSelected(true);
        }
        inputTextUsername.setText(sessionUsername);
        inputTextPassword.setText(sessionPassword);

        inputTextUsernameValidate();
        inputTextPasswordValidate();

    }
//link
    @FXML
    public void goToSignUp() {
        Router.switchToSignUpPage();
    }

    @FXML
    private void goToHomePage() {
        int role = userEntity.getSessionUser().getRole();
        if (role == 1) {
            Router.switchToAdminHomePage();
        }
        if (role == 2) {
            Router.switchToDoctorHomePage();
        }
        if (role == 3) {
            Router.switchToClientHomePage();
        }
    }
//sign in

    @FXML
    public void isCompleteForm() {
        if (inputTextPassword.getText() == null
                || inputTextPassword.getText().isEmpty()) {

            inputTextPassword.requestFocus();

        } else if (inputTextUsername.getText() == null
                || inputTextUsername.getText().isEmpty()) {

            inputTextUsername.requestFocus();
            errorUsername.setText("Required");

        } else {
            SignInEvent();
        }
    }

    @FXML
    private void SignInEvent() {
        String inputUsername = inputTextUsername.getText();
        String inputPassword = inputTextPassword.getText();
        boolean remember = false;
        if (accM.checkInputAccount(inputUsername, inputPassword)) {
            if (inputCBoxRemember.isSelected()) {
                remember = true;
            }
            if (signM.signIn(inputUsername, inputPassword, remember)) {
                goToHomePage();
            } else {
                errorInput();
            }
        } else {
            errorUsername.setText("Error username !!!");
            errorPassword.setText("Error password !!!");
            errorExitApp();
        }
    }
//validation

    private void inputTextUsernameValidate() {
        inputTextUsername.setOnKeyPressed((KeyEvent t) -> {
            //empty
            if (t.getCode() == KeyCode.ENTER
                    && inputTextUsername.getText().isEmpty()) {
                errorUsername.setText("Required");
            }
            if (t.getCode() == KeyCode.ENTER
                    && !inputTextUsername.getText().isEmpty()) {
                isCompleteForm();
            }
        });
        inputTextUsername.textProperty().addListener((ov, t, t1) -> {
            IntegerProperty currentLength = new SimpleIntegerProperty();
            currentLength.bind(Bindings.length(inputTextUsername.textProperty()));
            //empty
            if (currentLength.getValue() == 0) {
                errorUsername.setText("Required.");
            } else {
                errorUsername.setText(null);
            }
            //space
            if (inputTextUsername.getText().contains(" ")) {
                int spaceIndex = inputTextUsername.getText().indexOf(" ");
                String str = inputTextUsername.getText().substring(0, spaceIndex);
                inputTextUsername.setText(str);
                errorUsername.setText("Space Format");
            }
        });
    }

    private void inputTextPasswordValidate() {
        //empty
        inputTextPassword.setOnKeyPressed((KeyEvent t) -> {
            if (t.getCode() == KeyCode.ENTER
                    && inputTextPassword.getText().isEmpty()) {
                errorPassword.setText("Required");
            }
            if (!inputTextPassword.getText().isEmpty()) {
                errorPassword.setText(null);
            }
            if (t.getCode() == KeyCode.ENTER
                    && !inputTextPassword.getText().isEmpty()) {
                isCompleteForm();
            }
        });
        inputTextPassword.textProperty().addListener((ov, t, t1) -> {
            IntegerProperty currentLength = new SimpleIntegerProperty();
            currentLength.bind(Bindings.length(inputTextPassword.textProperty()));
            //empty
            if (currentLength.getValue() == 0) {
                errorPassword.setText("Required.");
            } else {
                errorPassword.setText(null);
            }
            //space
            if (inputTextPassword.getText().contains(" ")) {
                int spaceIndex = inputTextPassword.getText().indexOf(" ");
                String str = inputTextPassword.getText().substring(0, spaceIndex);
                inputTextPassword.setText(str);
                errorPassword.setText("Space Format");
            }
        });
    }
//error

    private void errorInput() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setResizable(false);
        alert.setTitle("Login Fail !!");
        alert.setHeaderText("Username or password incorrect !!");
        alert.setContentText("Please re-enter username or password");
        alert.show();
    }

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
