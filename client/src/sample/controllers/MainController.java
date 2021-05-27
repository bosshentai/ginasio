package sample.controllers;

import javafx.fxml.FXML;
import sample.Main;


import java.io.IOException;

public class MainController {

    @FXML
    private void switchTrainingPlan() throws IOException{
        Main.setRoot("registerTrainningPlan");
    }
}
