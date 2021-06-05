package sample.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import sample.Main;
import sample.data.Datasource;
import sample.models.Desconto;

import java.io.IOException;

public class ListDescontoController {

    @FXML
    private TableView descontoTable;

    @FXML
    private void switchRegistarDescont() throws IOException{
        Main.setRoot("registerDesconto");
    }

    @FXML
    private void switchMain() throws IOException{
        Main.setRoot("index");
    }


    @FXML
    private void listDesconto(){
        Task<ObservableList<Desconto>> task = new GetAllDescontoTask();
        descontoTable.itemsProperty().bind(task.valueProperty());

        new Thread(task).start();
    }



    static class GetAllDescontoTask extends Task {
        @Override
        protected ObservableList<Desconto> call() throws Exception{
            return FXCollections.observableArrayList(
                    Datasource.getInstance().queryDesconto()
            );
        }
    }

}
