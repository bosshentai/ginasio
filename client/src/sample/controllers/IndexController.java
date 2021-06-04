package sample.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sample.Main;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class IndexController {

    @FXML
    private void switchTrainingPlan() throws IOException{
        Main.setRoot("listTrainningPlan");
    }

    @FXML
    private void switchDiscount() throws  IOException{
        Main.setRoot("listDesconto");
    }

    @FXML
    private void switchPersonalTrainer() throws IOException{
        Main.setRoot("listPersonalTrainer");
    }
}
