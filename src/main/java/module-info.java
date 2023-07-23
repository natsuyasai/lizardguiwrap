module com.natsuyasai.lizardguiwrap {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.natsuyasai.lizardguiwrap to javafx.fxml;
    exports com.natsuyasai.lizardguiwrap;
    exports com.natsuyasai.lizardguiwrap.controller;
}