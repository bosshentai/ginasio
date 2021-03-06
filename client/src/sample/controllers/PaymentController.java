package sample.controllers;


import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import sample.Main;
import sample.data.Datasource;

import java.io.IOException;


public class PaymentController {

    @FXML
    private TextField numberBI;


    @FXML
    private void switchPayment() throws IOException{
        Main.setRoot("index");
    }

    @FXML
    private void pagar() {
        if (numberBI.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("O campo de BI encontra vazio");
            alert.showAndWait();
        } else {

            if (Datasource.getInstance().queryClientNumberBI().contains(Integer.parseInt(numberBI.getText()))) {
//                System.out.println("here");
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("Pagamento com sucesso");
                    alert.showAndWait();


            } else {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("O numero nao existe ");
                alert.showAndWait();
            }
        }
    }

}
