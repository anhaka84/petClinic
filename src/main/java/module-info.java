module com.aptech.mavenproject2.petclinic {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.base;
    requires java.desktop;
//    requires pdfbox;
    requires java.base;
    
    opens com.aptech.mavenproject2.petclinic to javafx.fxml;
    exports com.aptech.mavenproject2.petclinic;
    
    opens Models to javafx.fxml;
    exports Models;
    
    opens Controller to javafx.fxml;
    exports Controller;
    
    opens Controller.SignController to javafx.fxml;
    exports Controller.SignController;
    
    opens Validation to javafx.fxml;
    exports Validation;
}
