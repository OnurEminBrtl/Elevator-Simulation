module com.example.elevatorgame {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.elevatorgame to javafx.fxml;
    exports com.example.elevatorgame;
}