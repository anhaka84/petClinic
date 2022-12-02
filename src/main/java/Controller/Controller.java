package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class Controller {

    public static void nextTextField(TextField textField) {

    }

//    @FXML
//    public 
    @FXML
    public static void setAlertError(
            String title, String headerText, String contentText
    ) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setResizable(false);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        alert.show();
    }
//    private static final Branch instance = new Branch();
//    
//    public static Branch getInstance() {
//        return instance;
//    }
//    private final UserEntity userEntity = new UserEntity();
//    User user = User.getInstance();
}
