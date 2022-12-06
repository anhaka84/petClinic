package Validation;

import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Validate {

    private static final String CHARACTER_SPACE = " ";

    @FXML
    public static boolean isEmptyTextField(KeyEvent key, TextField textField) {
        if (key.getCode() == KeyCode.ENTER
                && textField.getText().isEmpty()) {
            return true;
        }
        return false;
    }

    @FXML
    public static boolean isEmptyTextField(TextField textField) {
        IntegerProperty currentLength = new SimpleIntegerProperty();
        currentLength.bind(Bindings.length(textField.textProperty()));
        if (currentLength.getValue() == 0) {
            return true;
        }
        return false;
    }

    @FXML
    public static boolean findWhiteSpace(TextField textField) {
        if (textField.getText().contains(CHARACTER_SPACE)) {
            return true;
        }
        return false;
    }

    @FXML
    public static int getIndexOfWhiteSpace(TextField textField) {
        if (findWhiteSpace(textField)) {
            int indexOfSpace = textField.getText().indexOf(CHARACTER_SPACE);
            return indexOfSpace;
        }
        return -1;
    }

    @FXML
    public static void removeWhiteSpace(TextField textField) {
        int index = getIndexOfWhiteSpace(textField);
        String newText = textField.getText().substring(0, index);
        textField.setText(newText);
    }
}
