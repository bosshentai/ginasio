package sample.controllers;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import sample.Main;


import sample.models.Cliente;
import sample.models.Gym;


import java.io.IOException;

public class RegisterClienteController {

    Gym gym = new Gym();


    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField nBI;

    @FXML
    private TextField phone;


    ObservableList<String> options = FXCollections.observableArrayList(
            "Option 1",
            "Option 2",
            "Option 3",
            "Option 4"
    );
    @FXML
    ComboBox cbTypeTrainningPlan = new ComboBox(options);

    @FXML
    private void swichBack() throws IOException {
        Main.setRoot("listClient");
    }

    @FXML
    private void registerClient() throws IOException {
        if (firstName.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("O Primeiro nome  encontra vazio");
            alert.showAndWait();
        } else if (lastName.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("O ultimo nome  encontra vazio");
            alert.showAndWait();
        } else if (nBI.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("O bi do Personal Trainer encontra vazio");
            alert.showAndWait();
        } else if (phone.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("O numero de telefone encontra vazio");
            alert.showAndWait();

        } else {
            Cliente cliente = new Cliente(firstName.getText(), lastName.getText(), phone.getText(), Integer.parseInt(nBI.getText()));

            if (!gym.addClient(cliente)) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("O numero do Bi ja existe no sistema ");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Registrado com sucesso");
                alert.showAndWait();
            }


        }

    }


//    cbTypeTrainningPlan.


}
