package com.aptech.mavenproject2.petclinic;

import Entities.SignEntity;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class SecondaryController {

    SignEntity signEntity = new SignEntity();

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("Login");
    }

    public void signOutEvent(ActionEvent event) throws IOException {
        if (signEntity.signOut()) {
            switchToPrimary();
        }
    }
}
