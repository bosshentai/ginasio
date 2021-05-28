package sample.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sample.Main;
import sample.models.Ginasio;
import sample.models.PlanoTreino;

import java.io.IOException;
import java.util.List;

public class RegisterTrainningPlan {

    private PlanoTreino plano;
    private Ginasio ginasio;

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


//    private void addTrainnig() throws IOException{
//        ginasio.addPlanoTreino(plano);
//    }

    @FXML
    private void registerTrainnig() throws IOException{
       plano = new PlanoTreino(name.getText(),descrition.getText(),Float.parseFloat(amount.getText()));
        System.out.println("nome: " + plano.getName() + " descricao: "+ plano.getDescrition() + " amount:"  + plano.getAmount());
        ginasio.addPlanoTreino(plano);
        Main.setRoot("index");
    }

//    public PlanoTreino getPlano(){
//        return this.plano;
//    }
}
