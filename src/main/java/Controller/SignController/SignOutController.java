package Controller.SignController;

import Controller.Router;
import Entities.SignEntity;
import javafx.fxml.FXML;

public class SignOutController {

    private static final SignEntity signEntity = new SignEntity();

    @FXML
    public static void signOutEvent() {
        if (signEntity.signOut()) {
            Router.switchToSignInPage();
        }
    }
}
