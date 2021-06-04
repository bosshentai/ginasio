package sample.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import sample.Main;
import sample.data.Datasource;
import sample.models.PlanoTreino;

import java.io.IOException;
public class ListTrainnigPlanController {


    @FXML
    private TableView trainningPlanTable;

    @FXML
    private void switchRegistarPlanoTreino() throws IOException{
        Main.setRoot("registerTrainningPlan");
    }

    @FXML
    private void switchMain() throws  IOException{
        Main.setRoot("index");
    }

    @FXML
    private void listTranningPlan(){
        Task<ObservableList<PlanoTreino>> task = new GetAllTrainningPlanTask();
        trainningPlanTable.itemsProperty().bind(task.valueProperty());
      //  System.out.println(task.valueProperty());


        new Thread(task).start();
    }


   static class GetAllTrainningPlanTask extends Task {
        @Override
        protected ObservableList<PlanoTreino> call() throws Exception{
            return FXCollections.observableArrayList(
                    Datasource.getInstance().queryPlanoTreino()
            );
        }
    }

}
