module sample.hellofx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens sample.hellofx to javafx.fxml;
    exports sample.hellofx;
    exports sample.scenes;
    opens sample.scenes to javafx.fxml;
}