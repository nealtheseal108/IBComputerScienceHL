module com.example.ibcomputersciencehl {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ibcomputersciencehl to javafx.fxml;
    exports com.example.ibcomputersciencehl;
}