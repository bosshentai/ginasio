package sample.controllers;

import javafx.fxml.FXML;
import sample.Main;

import java.io.IOException;

public class RegisterTrainningPlan {

    @FXML
    private void swichMain() throws IOException{
        Main.setRoot("index");
    }
}
