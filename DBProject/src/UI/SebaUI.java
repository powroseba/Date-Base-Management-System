/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import DB.DBSkiJumpers;
import static DB.DBSkiJumpers.connectionStatus;
import static DB.DBSkiJumpers.czas;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Klasa stanowiąca interfejs użytkownika. Tworzone są w niej okna z przejętych plików fxml
 * @author seba
 * @version Records 1.1
 */
public class SebaUI extends Application {
    /**
     * Pole another stager slużące do wygenerowania nowego okna
     */
    public static Stage anotherStage = new Stage();
    /**
     * 
     * @param stage pobiera parametr stage będący obiekten tworzący okno
     * @throws Exception informuje o błędzie braku sceny
     */
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setWidth(700.0);
        stage.setResizable(false);
        stage.setTitle("SkiJumpers Rekords DB");
        stage.show();
        stage.setOnCloseRequest(e -> {
            FXMLDocumentController.dateBase.closeConnection();
            connectionStatus = false;
            System.out.println("Rozlaczono z baza danych!");

            System.exit(0);
        });
        Parent anotherRoot = FXMLLoader.load(getClass().getResource("FXMLSecondDocument.fxml"));
        Scene anotherScene = new Scene(anotherRoot);
        anotherStage.setScene(anotherScene);
        anotherStage.setResizable(false);
        anotherStage.setTitle("ABOUT");


    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
