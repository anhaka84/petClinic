package Controller.SignController;

import Controller.Router;
import Entities.SignEntity;
import Entities.UserEntity;
import com.aptech.mavenproject2.petclinic.App;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class SignUpController implements Initializable {

    @FXML
    private TextField inputTextFullName;

    @FXML
    private TextField inputTextUsername;

    @FXML
    private PasswordField inputTextPassword;

    @FXML
    private PasswordField inputTextConfirmPassword;

    @FXML
    private TextField inputTextEmail;

    @FXML
    private TextField inputTextAddress;

    @FXML
    private TextField inputTextPhoneNumber;

    @FXML
    private Label errorFullName;

    @FXML
    private Label errorUsername;

    @FXML
    private Label errorPassword;

    @FXML
    private Label errorConfirmPassword;

    @FXML
    private Label errorDob;

    @FXML
    private Label errorGender;

    @FXML
    private Label errorEmail;

    @FXML
    private Label errorAddress;

    @FXML
    private Label errorPhoneNumber;

    UserEntity userEntity = new UserEntity();
    SignEntity SignEntity = new SignEntity();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String phoneNumber = "";

        inputTextPhoneNumberValidate();
    }

    @FXML
    public void goToLogin() {
        Router.switchToSignInPage();
    }

    @FXML
    private void isCompleteForm() {
        if (inputTextFullName.getText().isEmpty()) {

            inputTextFullName.requestFocus();

        } else if (inputTextUsername.getText().isEmpty()) {

            inputTextUsername.requestFocus();

        } else if (inputTextPassword.getText().isEmpty()) {

            inputTextPassword.requestFocus();

        } else if (inputTextConfirmPassword.getText().isEmpty()) {

            inputTextConfirmPassword.requestFocus();

        } else if (inputTextEmail.getText().isEmpty()) {

            inputTextEmail.requestFocus();

        } else if (inputTextAddress.getText().isEmpty()) {

            inputTextAddress.requestFocus();

        } else if (inputTextPhoneNumber.getText().isEmpty()) {

            inputTextPhoneNumber.requestFocus();

        } else {
            try {
                signUpEvent();
            } catch (IOException ex) {
            }
        }
    }

    private void sceneAlertSuccess() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

        ButtonType loginNow = new ButtonType("Login Now", ButtonBar.ButtonData.OK_DONE);
        ButtonType noThanks = new ButtonType("No, Thanks", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.setTitle("Sign In Succes");
        alert.setHeaderText("Welcom to Pet Clinic");
        alert.setContentText("ban da dang ki thanh cong, ban muon dang nhap luon khong ?");

        alert.getButtonTypes().clear();
        alert.getButtonTypes().addAll(noThanks, loginNow);

        Button yesButton = (Button) alert.getDialogPane().lookupButton(loginNow);
        yesButton.setDefaultButton(true);

        Button noButton = (Button) alert.getDialogPane().lookupButton(noThanks);
        noButton.setDefaultButton(false);

        final Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == loginNow) {
            goToLogin();
        }
        if (result.get() == noThanks) {
            alert.close();
        }
    }

    @FXML
    public void signUpEvent()
            throws IOException {
        String fullName = inputTextFullName.getText();
        String username = inputTextUsername.getText();
        String password = inputTextPassword.getText();
        String confirmPassword = inputTextConfirmPassword.getText();
        String email = inputTextEmail.getText();
        String address = inputTextAddress.getText();
        String phoneNumber = inputTextPhoneNumber.getText();

        sceneAlertSuccess();
    }

    @FXML
    private void inputTextFullNameValidate()
            throws IOException {
        String fullName = inputTextFullName.getText();
        if (fullName.isEmpty()) {
            errorFullName.setText("Required");
        } else {
            errorFullName.setText(null);
        }
        isCompleteForm();
    }

    @FXML
    private void inputTextUsernameValidate()
            throws IOException {
        isCompleteForm();
    }

    @FXML
    private void inputTextPasswordValidate()
            throws IOException {
        isCompleteForm();
    }

    @FXML
    private void inputTextConfirmPasswordValidate()
            throws IOException {
        isCompleteForm();
    }

    @FXML
    private void inputTextEmailValidate()
            throws IOException {
        isCompleteForm();
    }

    @FXML
    private void inputTextAddressValidate()
            throws IOException {
        isCompleteForm();
    }

    @FXML
    private void inputTextPhoneNumberValidate() {
        inputTextPhoneNumber.textProperty()
                .addListener((ObservableValue<? extends String> ov, String t, String t1) -> {
                    IntegerProperty currentLength = new SimpleIntegerProperty();
                    currentLength.bind(Bindings.length(inputTextPhoneNumber.textProperty()));
                    //empty
                    inputTextPhoneNumber.setOnKeyPressed((KeyEvent t2) -> {
                        if (t2.getCode() == KeyCode.ENTER
                                && inputTextPhoneNumber.getText().isEmpty()) {
                            errorPhoneNumber.setTextFill(Color.RED);
                            errorPhoneNumber.setText("Required.");
                        }
                        if (t2.getCode() == KeyCode.ENTER && currentLength.getValue() == 10) {
                            isCompleteForm();
                        }
                    });
                    if (currentLength.getValue() == 0) {
                        errorPhoneNumber.setTextFill(Color.RED);
                        errorPhoneNumber.setText("Required.");
                    } //length
                    else if (currentLength.getValue() != 10) {
                        errorPhoneNumber.setTextFill(Color.RED);
                        errorPhoneNumber.setText("This entry can only contain " + currentLength.getValue() + "/10 numbers.");
                    } else {
                        errorPhoneNumber.setTextFill(Color.GREEN);
                        errorPhoneNumber.setText("This entry can only contain " + currentLength.getValue() + "/10 numbers.");
                        errorPhoneNumber.setOnMouseClicked((MouseEvent t2) -> {
                            errorPhoneNumber.setText(null);
                        });
                    }
                    //space
                    if (inputTextPhoneNumber.getText().contains(" ")) {
                        int spaceIndex = inputTextPhoneNumber.getText().indexOf(" ");
                        String str = inputTextPhoneNumber.getText().substring(0, spaceIndex);
                        inputTextPhoneNumber.setText(str);
                        errorPhoneNumber.setTextFill(Color.RED);
                        errorPhoneNumber.setText("Space Format");
                    }
                    //letter
                    if (currentLength.getValue() > 0) {
                        char lastLetter = inputTextPhoneNumber.getText().charAt((currentLength.getValue() - 1));
                        if (lastLetter < '0' || lastLetter > '9') {
                            String newInput = inputTextPhoneNumber.getText().substring(0, (currentLength.getValue() - 1));
                            inputTextPhoneNumber.setText(newInput);
                            errorPhoneNumber.setTextFill(Color.RED);
                            errorPhoneNumber.setText("This entry can only contain numbers.");
                        }
                    }
                });
    }

}
