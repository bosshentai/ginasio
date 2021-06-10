package sample.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import sample.data.Datasource;

import java.util.ArrayList;
import java.util.List;

public class PaymentController {

    @FXML
    private TextField numberBI;

    @FXML
    private void pagar() {
        if (numberBI.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("O campo de BI encontra vazio");
            alert.showAndWait();
        } else {

            if (Datasource.getInstance().queryClientNumberBI().contains(Integer.parseInt(numberBI.getText()))) {
                System.out.println("here");


            } else {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("O numero nao existe ");
                alert.showAndWait();
            }
        }
    }

}
