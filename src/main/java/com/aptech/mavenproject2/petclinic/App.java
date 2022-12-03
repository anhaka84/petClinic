package com.aptech.mavenproject2.petclinic;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
//        scene = new Scene(loadFXML("SignIn"));
        scene = new Scene(loadFXML("test_MainPage"));
        stage.setScene(scene);
        stage.setWidth(1080);
        stage.setHeight(800);
        scene.setOnKeyPressed((KeyEvent t) -> {
            if (t.getCode() == (KeyCode.F)) {
                stage.setFullScreen(true);
            }
            if (t.getCode() == (KeyCode.ESCAPE)) {
                stage.setFullScreen(false);
            }
        });
        stage.setResizable(false);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static Pane loadFXMLPane(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}
