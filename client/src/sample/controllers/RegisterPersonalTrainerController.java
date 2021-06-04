package sample.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import sample.Main;
import sample.data.Datasource;
import sample.models.PersonalTrainer;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class RegisterPersonalTrainerController {

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField nBI;

    @FXML
    private TextField phone;

    @FXML
    private TextField amount;


    @FXML
    private void swichBack() throws IOException {
        Main.setRoot("listPersonalTrainer");
    }

    @FXML
    private void registerPersonalTrainer() throws IOException {
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
        }else if (amount.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("O preço encontra vazio");
            alert.showAndWait();
        }else {
            if(onlyDigits(amount.getText())){
//                System.out.println("FirstName: " + firstName.getText() + " LastName: " + lastName.getText() +
//                        " nBI: " + nBI.getText() + " phoneNumber: " + phone.getText() + " amount: " +
//                        amount.getText());
                PersonalTrainer personalTrainer = new PersonalTrainer(firstName.getText(),lastName.getText(),
                        phone.getText(),Integer.parseInt(nBI.getText()),Integer.parseInt(amount.getText()));

                System.out.println("FirstName: " + personalTrainer.getFirstName() +
                        " LastName: " + personalTrainer.getLastName() +
                        " nBI: " + personalTrainer.getNumberBI() +
                        " phoneNumber: " + personalTrainer.getPhoneNumber() +
                        " amount: " + amount.getText());

                Datasource.getInstance().registerPersonalTrainer(personalTrainer.getFirstName(),personalTrainer.getLastName(),
                        personalTrainer.getPhoneNumber(),personalTrainer.getNumberBI(),personalTrainer.getAmount());

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("O registro foi feito com sucesso");
                alert.showAndWait();


            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Insiro o montante incorretamente");
                alert.showAndWait();
            }
        }
    }

    private static boolean onlyDigits(String str){
        String regex = "[0-9]+";
        Pattern p = Pattern.compile(regex);

        if (str == null){
            return false;
        }

        Matcher m = p.matcher(str);
        return m.matches();
    };
}
