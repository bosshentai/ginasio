package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.data.Datasource;
import sample.models.Ginasio;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;


public class Main extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws Exception {



    scene = new Scene(loadFXML("index"),800,600);
    stage.setScene(scene);
    stage.show();
    }

    public static void setRoot(String fxml) throws IOException{
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("views/"+fxml+ ".fxml"));
    return fxmlLoader.load();
    }

    public static void main(String[] args) {

        Datasource datasource = new Datasource();
        if(!datasource.open()){
            System.out.println("Cant open datasource");
            return;
        }
//        Path path = FileSystems.getDefault().getPath("").toAbsolutePath();
//        System.out.println(path);

        launch();
    }

   // Ginasio ginasio = new Ginasio();






}