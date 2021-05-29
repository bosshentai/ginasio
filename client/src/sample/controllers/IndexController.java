package sample.controllers;

import javafx.fxml.FXML;
import sample.Main;


import java.io.IOException;

public class IndexController {

    @FXML
    private void switchTrainingPlan() throws IOException{
        Main.setRoot("listTrainningPlan");
    }

    @FXML
    private void switchDiscount() throws  IOException{
        Main.setRoot("registerDesconto");
    }
}
