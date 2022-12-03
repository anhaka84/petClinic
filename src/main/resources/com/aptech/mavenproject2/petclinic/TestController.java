package com.aptech.mavenproject2.petclinic;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class TestController implements Initializable {

    @FXML
    private BorderPane mainPage;

    @FXML
    private void page1Action() throws IOException {
        Pane view = App.loadFXMLPane("test_HomePage");
        mainPage.setCenter(view);
    }

    @FXML
    private void page2Action() throws IOException {
        Pane view = App.loadFXMLPane("test_Booking");
        mainPage.setCenter(view);
    }

    @FXML
    private void page3Action() throws IOException {
//        Pane view = App.loadFXMLPane("testFXML2");
//        mainPage.setCenter(view);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            page1Action();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
