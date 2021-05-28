package sample.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sample.Main;
import sample.models.Desconto;

import java.io.IOException;

public class RegisterDescontoController {

    @FXML
    private TextField name;

    @FXML
    private TextArea descrition;

    @FXML
    private TextField amount;

    @FXML
    private void swichMain() throws IOException{
        Main.setRoot("index");
    }

    @FXML
    private void registeDiscount() throws IOException{
        Desconto desconto = new Desconto(name.getText(), descrition.getAccessibleRoleDescription(),Float.parseFloat(amount.getText()));


    }

}
