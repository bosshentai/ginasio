module JavaFxApplication {
    requires javafx.fxml;
    requires  javafx.controls;

    requires java.sql;


    opens sample to javafx.fxml;
    opens sample.models to javafx.fxml;

    exports  sample;
    exports sample.models;
    exports sample.controllers;
    opens sample.controllers to javafx.fxml;

}