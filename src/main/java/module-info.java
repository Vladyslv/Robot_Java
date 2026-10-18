module com.example.du04_1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.du04_1 to javafx.fxml;
    exports com.example.du04_1;
}