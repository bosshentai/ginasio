package sample.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import sample.Main;
import sample.models.PersonalTrainer;

import java.io.IOException;

public class ListPersonalTrainerController {


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

    }


//    static class GetAllPersonalTrainer extends Task {
//        @Override
//        protected ObservableList<PersonalTrainer> call() throws Exception {
//            return FXCollections.observableArrayList(
//                    //add queryPersonalTrainer
//            )
//        }
//
//    }
}
