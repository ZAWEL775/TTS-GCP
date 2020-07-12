package GCP.Controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ResourceBundle;

public class Translate {

    public static String translateString(String languageFrom, String languageTo, String input) throws IOException {

        String urlString = "https://script.google.com/macros/s/AKfycbw7hk075cBVA0mm-O9w7PZcCFVEyAGWIizTijgRPyleNTw3mAU/exec" +
                "?q=" + URLEncoder.encode(input, "UTF-8") +
                "&target=" + languageTo +
                "&source=" + languageFrom;

        URL url = new URL(urlString);
        StringBuilder response = new StringBuilder();
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        String inputLine;
        while((inputLine = in.readLine()) != null){
            response.append(inputLine);
        } in.close(); return response.toString();
    }
}
