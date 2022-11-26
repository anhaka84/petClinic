package Controller;

import Models.AccountModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class LoginController {

    AccountModel accM = new AccountModel();

    @FXML
    private TextField inputTextUsername;

    @FXML
    private TextField inputTextPassword;

    @FXML
    public void SignInEvent(ActionEvent event) {
        String inputUsername = inputTextUsername.getText();
        String inputPassword = inputTextPassword.getText();
//        System.out.println(inputUsername + inputPassword);
//        System.out.println(accM.checkInputAccount(inputUsername, inputPassword));
        if (inputUsername.matches("''")) {
            System.out.println("login ok");
        }
    }
    
    @FXML
    public void inputAction(ActionEvent event){
        String inputUsername = inputTextUsername.getText();
        System.out.println(inputUsername);
    }
}
