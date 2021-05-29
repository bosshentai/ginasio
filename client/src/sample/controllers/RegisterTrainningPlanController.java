package sample.controllers;


import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sample.Main;


import sample.data.Datasource;
import sample.models.PlanoTreino;

import java.io.IOException;


public class RegisterTrainningPlanController {



    @FXML
    private TextField name;

    @FXML
    private TextArea descrition;

    @FXML
    private TextField amount;

    @FXML
    private void swichMain() throws IOException {
        Main.setRoot("index");
    }


    @FXML
    private void registerTrainnig() throws IOException{


        final PlanoTreino planoTreino = new PlanoTreino(name.getText(), descrition.getText(), Integer.parseInt(amount.getText()));
        //System.out.println("nome: " +  planoTreino.getName() + " descrition: " + planoTreino.getDescrition() + " float: " + planoTreino.getAmount());


        Datasource.getInstance().registerPlanoTreino(planoTreino.getName(), planoTreino.getDescrition(), planoTreino.getAmount());

        Main.setRoot("listTrainningPlan");

    }


}


