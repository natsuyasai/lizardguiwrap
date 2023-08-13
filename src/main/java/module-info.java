module com.natsuyasai.lizardguiwrap {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;

    requires org.controlsfx.controls;
    //requires org.kordamp.bootstrapfx.core;
    requires tornadofx;
    requires kotlinx.coroutines.core;

    opens com.natsuyasai.lizardguiwrap to javafx.fxml;
    exports com.natsuyasai.lizardguiwrap;
    exports com.natsuyasai.lizardguiwrap.view;
    exports com.natsuyasai.lizardguiwrap.viewmodel;
    exports com.natsuyasai.lizardguiwrap.style;
    exports com.natsuyasai.lizardguiwrap.model;
}
