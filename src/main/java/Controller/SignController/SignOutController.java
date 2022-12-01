package Controller.SignController;

import Controller.Router;
import Entities.SignEntity;
import javafx.fxml.FXML;

public class SignOutController {

    SignEntity signEntity = new SignEntity();

    public SignOutController() {
    }

    @FXML
    public void signOutEvent() {
        if (signEntity.signOut()) {
            Router.switchToSignInPage();
        }
    }
}
