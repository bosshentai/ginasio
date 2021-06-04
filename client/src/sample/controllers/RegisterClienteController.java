package sample.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import sample.Main;
import sample.data.Datasource;
import sample.models.Cliente;

import java.io.IOException;

public class RegisterClienteController {

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField nBI;

    @FXML
    private TextField phone;



    @FXML
    private void swichBack() throws IOException {
        Main.setRoot("listClient");
    }

    @FXML
    private void registerClient() throws IOException{
        if (firstName.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("O Primeiro nome  encontra vazio");
            alert.showAndWait();
        }else if (lastName.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("O ultimo nome  encontra vazio");
            alert.showAndWait();
        }else if (nBI.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("O bi do Personal Trainer encontra vazio");
            alert.showAndWait();
        }else if (phone.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("O numero de telefone encontra vazio");
            alert.showAndWait();

        }else {

//                System.out.println("FirstName: " + firstName.getText() + " LastName: " + lastName.getText() +
//                        " nBI: " + nBI.getText() + " phoneNumber: " + phone.getText() + " amount: " +
//                        amount.getText());
//                PersonalTrainer personalTrainer = new PersonalTrainer(firstName.getText(),lastName.getText(),
//                        phone.getText(),Integer.parseInt(nBI.getText()),Integer.parseInt(amount.getText()));
            Cliente client = new Cliente(firstName.getText(),lastName.getText(),phone.getText(),
                    Integer.parseInt(nBI.getText()));
//                System.out.println("FirstName: " + personalTrainer.getFirstName() +
//                        " LastName: " + personalTrainer.getLastName() +
//                        " nBI: " + personalTrainer.getNumberBI() +
//                        " phoneNumber: " + personalTrainer.getPhoneNumber() +
//                        " amount: " + amount.getText());

            Datasource.getInstance().registerClient(client.getFirstName(),client.getLastName(),client.getPhoneNumber(),
                    client.getNumberBI());


                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("O registro foi feito com sucesso");
                alert.showAndWait();




            }

    }
}
