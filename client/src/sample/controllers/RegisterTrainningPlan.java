package sample.controllers;


import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sample.Main;


import sample.data.Datasource;
import sample.models.PlanoTreino;

import java.io.IOException;
import java.sql.SQLException;


public class RegisterTrainningPlan  {

    private PlanoTreino plano;
   // private Ginasio ginasio;

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
    private void registerTrainnig() throws IOException, SQLException {

//       plano = new PlanoTreino(name.getText(),descrition.getText(),Float.parseFloat(amount.getText()));
//        System.out.println("nome: " + plano.getName() + " descricao: "+ plano.getDescrition() + " amount:"  + plano.getAmount());


//        final PlanoTreino planoTreino = new PlanoTreino(name.getText(),descrition.getText(),Float.parseFloat(amount.getText()));
        final PlanoTreino planoTreino = new PlanoTreino(name.getText(),descrition.getText(),Integer.parseInt(amount.getText()));
        System.out.println("nome: " +  planoTreino.getName() + " descrition: " + planoTreino.getDescrition() + " float: " + planoTreino.getAmount());



        //PlanoTreinoSource.getInstance().registerPlanoTreino(planoTreino.getName(),planoTreino.getDescrition(),planoTreino.getAmount());
        //PlanoTreinoSource.getInstance().insertPlanoTreino("teste","teste",1231f);

        Datasource.getInstance().registerPlanoTreino(planoTreino.getName(),planoTreino.getDescrition(), planoTreino.getAmount());

        Main.setRoot("index");

    }

//
//class GetPlanoTreinoTask extends Task{
//
//        protected Observable<PlanoTreino> call() throws Exception{
//            return FXCollections.observableArrayList(
//                    PlanoTreinoSource.getInstance().insertPlanoTreino()
//            );
//        }
//}

    }


