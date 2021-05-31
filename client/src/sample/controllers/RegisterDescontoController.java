package sample.controllers;


import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sample.Main;
import sample.data.Datasource;
import sample.models.Desconto;

import java.io.IOException;

import javafx.scene.control.Alert.AlertType;

public class RegisterDescontoController {


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
    private void registeDiscount() throws IOException{


        if(name.getText().isEmpty()){
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("O nome do desconto  enconta vazio ");
            alert.showAndWait();
        }else if (descrition.getText().isEmpty()){
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("A descriçao do desconto encontra vazio");
            alert.showAndWait();
        }else if(amount.getText().isEmpty()){
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("O valor do desconto encontra vazio");
            alert.showAndWait();
        }


        if(!name.getText().isEmpty() && !descrition.getText().isEmpty() && !amount.getText().isEmpty()){
//            System.out.println("nome " + name.getText() + " descrition " + descrition.getText() +  " int: "
//                    + amount.getText());

           final Desconto desconto = new Desconto(name.getText(),descrition.getText(),Integer.parseInt(amount.getText()));

            Datasource.getInstance().registerDesconto(desconto.getName(),desconto.getDescrition(),desconto.getAmount());

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setHeaderText("O registro foi feito com sucesso");
            alert.showAndWait();

            Main.setRoot("listDesconto");
        }

    }


}
