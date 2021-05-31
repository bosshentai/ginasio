package sample.controllers;

import java.util.*;
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


//   @FXML
//   private AlertType alertType;

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
    private void registerTrainnig()  throws IOException{
        //PlanoTreino planoTreino = new PlanoTreino(name.getText(), descrition.getText(), Integer.parseInt(amount.getText()));

        //Datasource.getInstance().registerPlanoTreino(planoTreino.getName(), planoTreino.getDescrition(), planoTreino.getAmount());

        // Main.setRoot("listTrainningPlan");



        if(name.getText().isEmpty()){
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("O nome do Plano de treino encontra vazio");
            alert.showAndWait();
        }else if (descrition.getText().isEmpty()){
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("A descrição do Plano de treino enconttra vazio");
            alert.showAndWait();
        }else if (amount.getText().isEmpty()){
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("");
            alert.showAndWait();
        }
        // System.out.println("nome: " +  name.getText() + " descrition: " + descrition.getText() + " float: " +amount.getText());

        if (!name.getText().isEmpty()  && !descrition.getText().isEmpty() && !amount.getText().isEmpty()) {
            System.out.println("nome: " +  name.getText() + " descrition: " + descrition.getText() + " float: " +amount.getText());
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setHeaderText("O registro foi feito com sucesso");
            alert.showAndWait();

            PlanoTreino planoTreino = new PlanoTreino(name.getText(), descrition.getText(), Integer.parseInt(amount.getText()));

            System.out.println("Object planoTreino nome: "+ planoTreino.getName());
        }
//        } else {
//            Alert alert = new Alert(AlertType.ERROR);
//            alert.setHeaderText("O registro nao foi feito com sucesso");
//            alert.showAndWait();
//        }


    }



}


