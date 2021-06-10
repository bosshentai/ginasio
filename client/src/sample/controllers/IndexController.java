package sample.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;
import sample.Main;



import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class IndexController implements Initializable{

    @FXML
    private void switchTrainingPlan() throws IOException{
        Main.setRoot("listTrainningPlan");
    }

    @FXML
    private void switchDiscount() throws  IOException{
        Main.setRoot("listDesconto");
    }

    @FXML
    private void switchPersonalTrainer() throws IOException{
        Main.setRoot("listPersonalTrainer");
    }

    @FXML
    private void switchClient() throws IOException{
        Main.setRoot("listClient");
    }

    @FXML
    private void openAction()throws IOException{
        try{
         FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("@../views/payment.fxml"));
            Parent rootl =  fxmlLoader.load();
            Stage stage = new Stage();

            stage.setScene(new Scene(rootl));
            stage.show();

        }catch (Exception e){
            System.out.println(" problem " + e.getMessage());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //todo
    }
}
