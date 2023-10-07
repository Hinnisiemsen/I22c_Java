module com.example.javai22c {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.javai22c to javafx.fxml;
    exports com.example.javai22c;
}