module morgana.ide {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires org.fxmisc.richtext;
    requires com.fasterxml.jackson.databind;
    requires java.desktop;
    requires java.logging;

    // Exports for FXML reflection
    exports com.morgana.ide;
    exports com.morgana.ide.controller;

    // Opens packages for FXML reflection
    opens com.morgana.ide to javafx.fxml;
    opens com.morgana.ide.controller to javafx.fxml;
}