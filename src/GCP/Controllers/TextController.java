package GCP.Controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class TextController implements Initializable , EventHandler<ActionEvent>{

    @FXML private TextField input;
    @FXML private TextField output;
    @FXML private Button Translate;
    @FXML private MenuItem English;
    @FXML private MenuItem German;
    @FXML private MenuItem French;
    @FXML private MenuItem Spanish;
    @FXML private MenuItem speechMenuItem;
    @FXML private MenuItem CloseApplication;

    String chooseLanguage;

    GCP.Controllers.Translate translate = new Translate();

    public void doTranslation(ActionEvent event){
        if(event.getSource().equals(Translate)) {
            try {
                String inputView = input.getText();
                String translateOutput = translate.translateString("en", chooseLanguage, inputView);
                output.setText(translateOutput);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String changeLanguage(ActionEvent event){
        try{
            if(event.getSource().equals(English)) return chooseLanguage = "en";
            if(event.getSource().equals(German))  return chooseLanguage = "de";
            if(event.getSource().equals(French))  return chooseLanguage = "fr";
            if(event.getSource().equals(Spanish)) return chooseLanguage = "es";
        }catch (Exception e){
            e.printStackTrace();
        } return "en";
    }



    private Scene speechScene;

    public void setSpeechScene(Scene scene){
        speechScene = scene;
    }

    public void changeToSpeech(ActionEvent event){
        if(event.getSource().equals(speechMenuItem)){
            Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            primaryStage.setScene(speechScene);
        }
    }

    public void closeApplication(ActionEvent event){
        if(event.getSource().equals(CloseApplication)) System.exit(1);
    }

    @Override
    public void handle(ActionEvent event){
    }
    @Override
    public void initialize (URL loction , ResourceBundle resources){
    }
}
