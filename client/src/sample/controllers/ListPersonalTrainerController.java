package sample.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import sample.Main;
import sample.data.Datasource;
import sample.models.PersonalTrainer;

import java.io.IOException;

public class ListPersonalTrainerController {

    @FXML
    private TableView personalTrainerTable;


    @FXML
    private void switchRegistarPersonalTrainer() throws IOException {
        Main.setRoot("registerPersonalTrainer");
    }

    @FXML
    private void switchMain() throws IOException{
        Main.setRoot("index");
    }

    @FXML
    private void listPersonalTrainer(){
        Task<ObservableList<PersonalTrainer>>  task = new GetAllPersonalTrainer();
        personalTrainerTable.itemsProperty().bind(task.valueProperty());
        System.out.println(task.valueProperty());

        new Thread(task).start();
    }


    static class GetAllPersonalTrainer extends Task {
        @Override
        protected ObservableList<PersonalTrainer> call() throws Exception{
            return FXCollections.observableArrayList(
                    Datasource.getInstance().queryPersonalTrainer()
            );
        }

    }
}
