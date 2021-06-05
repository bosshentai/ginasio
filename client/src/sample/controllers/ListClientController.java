package sample.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import sample.Main;
import sample.data.Datasource;
import sample.models.Cliente;

import java.io.IOException;

public class ListClientController {

    @FXML
    private TableView clientTable;

    @FXML
    private void switchMain() throws IOException {
        Main.setRoot("index");
    }

    @FXML
    private void switchRegistarClient() throws IOException{
    Main.setRoot("registerCliente");
    }

    @FXML
    private void listClient() throws  IOException{
        Task<ObservableList<Cliente>> task = new GetAllClientTask();
        clientTable.itemsProperty().bind(task.valueProperty());

    new Thread(task).start();
    }

    static class GetAllClientTask extends Task {
        @Override
        protected ObservableList<Cliente> call() throws Exception{
            return FXCollections.observableArrayList(
                    Datasource.getInstance().queryClient()
            );
        }
    }
}
