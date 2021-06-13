package sample.controllers;

import javafx.fxml.FXML;



import sample.Main;



import java.io.IOException;


public class IndexController{

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
    private void pagamento()throws IOException{
        Main.setRoot("payment");
//        try{
//         FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("@../views/payment.fxml"));
//            Parent rootl =  fxmlLoader.load();
//            Stage stage = new Stage();
//
//            stage.setScene(new Scene(rootl));
//            stage.show();
//
//        }catch (Exception e){
//            System.out.println(" problem " + e.getMessage());
//        }
    }

//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        //todo
//    }
}
