package sample.controllers;

import javafx.fxml.FXML;
import sample.Main;

import java.io.IOException;

public class ListClientController {

    @FXML
    private void switchMain() throws IOException {
        Main.setRoot("index");
    }

    @FXML
    private void switchRegistarClient() throws IOException{
    Main.setRoot("registerClient");
    }

    @FXML
    private void listClient() throws  IOException{

    }
}
