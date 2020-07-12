package GCP;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{


        FXMLLoader firstPaneLoader = new FXMLLoader(getClass().getResource("Views/Speech.fxml"));
        Parent firstPane = firstPaneLoader.load();
        Scene textScene = new Scene(firstPane, 700, 700);

        FXMLLoader secondPageLoader = new FXMLLoader(getClass().getResource("Views/Translate.fxml"));
        Parent secondPane = secondPageLoader.load();
        Scene speechScene = new Scene(secondPane, 700, 700);


        primaryStage.setTitle("Switching scenes");
        primaryStage.setScene(textScene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
