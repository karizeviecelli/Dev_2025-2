module com.example.cadastromed {
    requires javafx.controls;
    requires javafx.fxml;
    requires jdk.compiler;


    opens com.example.cadastromed to javafx.fxml;
    exports com.example.cadastromed;
    exports com.example.cadastromed.Controller;
    opens com.example.cadastromed.Controller to javafx.fxml;
    exports com.example.cadastromed.Models;
    opens com.example.cadastromed.Models to javafx.fxml;
}