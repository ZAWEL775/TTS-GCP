package GCP.Controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class SpeechController implements Initializable, EventHandler<ActionEvent> {

    @FXML private MenuItem Text;
    @FXML private MenuItem CloseApplication;

    private Scene textScene;





    public void setTextScene(Scene scene){
        textScene = scene;
    }

    public void changeToText(ActionEvent event){
        try {
            if (event.getSource().equals(Text)) {
                Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                primaryStage.setScene(textScene);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void closeApplication(ActionEvent event){
        if (event.getSource().equals(CloseApplication)) System.exit(1);
    }

    @Override
    public void handle(ActionEvent event){
    }
    @Override
    public void initialize (URL loction , ResourceBundle resources){
    }

}
