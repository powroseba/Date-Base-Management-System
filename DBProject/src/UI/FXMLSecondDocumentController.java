/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class klasa tworząca drugie okno
 *
 * @author seba
 */
public class FXMLSecondDocumentController implements Initializable {

    @FXML
    private Label SS_Label;
    protected static String text = "Project 'Programowanie Obiektowe 2'.\n"
            + "Skijumpers Records DataBase Managment\n"
            + "Author: Sebastian Powroźnik.\n"
            + "Type DataBase: SQLLite.\n"
            + "User Interface: FXML with support SceneBuilfer 2.0\n";

    @FXML
    private Button About_OK;

    public void setText(String text) {
        SS_Label.setText(text);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SS_Label.setText(text);
        About_OK.setOnAction(event -> {
            SebaUI.anotherStage.hide();
        });
    }

}
