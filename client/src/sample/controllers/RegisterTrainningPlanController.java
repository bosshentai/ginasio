package sample.controllers;



import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sample.Main;


import sample.data.Datasource;
import sample.models.PlanoTreino;

import java.io.IOException;

import javafx.scene.control.Alert.AlertType;

public class RegisterTrainningPlanController {



    @FXML
    private TextField name;

    @FXML
    private TextArea descrition;

    @FXML
    private TextField amount;

    @FXML
    private void swichBack() throws IOException {
        Main.setRoot("listTrainningPlan");
    }


    @FXML
    private void registerTrainnig() throws IOException {

        if (name.getText().isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("O nome do Plano de treino encontra vazio");
            alert.showAndWait();
        } else if (descrition.getText().isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("A descrição do Plano de treino enconttra vazio");
            alert.showAndWait();
        } else if (amount.getText().isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("O preço do Plano de treino nao foi inserido!");
            alert.showAndWait();
        }
        // System.out.println("nome: " +  name.getText() + " descrition: " + descrition.getText() + " float: " +amount.getText());

        if (!name.getText().isEmpty() && !descrition.getText().isEmpty() && !amount.getText().isEmpty()) {
    //        System.out.println("nome: " + name.getText() + " descrition: " + descrition.getText() + " float: " + amount.getText());
            final   PlanoTreino planoTreino = new PlanoTreino(name.getText(), descrition.getText(), Integer.parseInt(amount.getText()));
            Datasource.getInstance().registerPlanoTreino(planoTreino.getName(), planoTreino.getDescrition(), planoTreino.getAmount());
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setHeaderText("O registro foi feito com sucesso");
            alert.showAndWait();



            Main.setRoot("listTrainningPlan");
        }


    }


}


