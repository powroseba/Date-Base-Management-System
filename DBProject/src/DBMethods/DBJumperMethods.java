/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBMethods;

import DB.DBSkiJumpers;
import Tables.Skijumper;
import UI.FXMLDocumentController;
import java.util.ArrayList;
import java.util.InputMismatchException;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.sqlite.core.DB;

/**
 * Klasa posiadająca metody zarządzania baza danych oraz oknem
 *
 * @author seba
 */
public class DBJumperMethods {

    /**
     * Metoda tworząca zapytanie do bazy danych
     *
     * @return zwraca zapytanie select w postaci tekstu
     */
    public static String selectJumper() {
        StringBuilder polecenie = new StringBuilder("SELECT ");
        polecenie.append("* from skijumpers;");
        return polecenie.toString();
    }

    /**
     * Metoda dokonuje pobrania zawartości z pól tekstowych okna oraz
     * wykorzystuje ich zawartosc to wygenerowania zapytania
     *
     * @param aThis pobiera zawartość komponentów z okna w celu uzyskania ich
     * zawartości
     * @return zwraca gotowe zapytanie insert w postaci tekstu
     */
    public static String insertJumper(FXMLDocumentController aThis) {
        StringBuilder polecenie = new StringBuilder("INSERT INTO skijumpers values (");
        polecenie.append(aThis.Jumper_IdField.getText().toString() + ", ");
        polecenie.append("'" + aThis.Jumper_NameField.getText().toString() + "', ");
        polecenie.append("'" + aThis.Jumper_SurnameField.getText().toString() + "', ");
        polecenie.append("'" + aThis.Jumper_DatePicker.getValue().toString() + "', ");
        polecenie.append("'" + aThis.Jumper_NationalityField.getText().toString() + "');");
        return polecenie.toString();
    }

    /**
     * Metoda dokonuje pobrania zawartości z pól tekstowych okna oraz
     * wykorzystuje ich zawartosc to wygenerowania zapytania
     *
     * @param aThis pobiera zawartość komponenta z okna w celu uzyskania ich
     * zawartości
     * @return zwraca gotowe zapytanie insert w postaci tekstu
     */
    public static String deleteJumper(FXMLDocumentController aThis) {

        StringBuilder polecenie = new StringBuilder("DELETE FROM skijumpers where");
        polecenie.append(" skijumper_id = " + aThis.Jumper_IdField.getText().toString() + ";");
        return polecenie.toString();
    }

    /**
     * Metoda pobiera zawartość okna w danej zakladce po czym generuje dokladne
     * zapytanie do bazy danych
     *
     * @param id pobiera zawartość pola id
     * @return zwraca gotowe zapytanie insert w postaci tekstu
     */
    public static String deleteJumper(String id) {

        StringBuilder polecenie = new StringBuilder("DELETE FROM skijumpers where (");
        polecenie.append(" skijumper_id = " + id + ");");
        return polecenie.toString();
    }

    /**
     * Metoda pobierając zawartość odpowiednich okien w zakladkach generuje
     * dokladne zapytanie update
     *
     * @param aThis pobiera zawartości znajdujące sie w komponentach danego okna
     * @return zwraca gotowe zapytanie
     */
    public static String updateJumper(FXMLDocumentController aThis) {

        StringBuilder polecenie = new StringBuilder("UPDATE skijumpers set ");
        if (!aThis.Jumper_IdUpdateField.getText().isEmpty()) {
            polecenie.append("skijumper_id = " + aThis.Jumper_IdUpdateField.getText().toString() + ", ");
        }
        if (!aThis.Jumper_NameUpdateField.getText().isEmpty()) {
            polecenie.append("jumper_name = '" + aThis.Jumper_NameUpdateField.getText().toString() + "', ");
        }
        if (!aThis.Jumper_SurnameUpdateField.getText().isEmpty()) {
            polecenie.append("jumper_surname = '" + aThis.Jumper_SurnameUpdateField.getText().toString() + "', ");
        }
        if (!(aThis.Jumper_DateUpdatePicker.getValue() == null)) {
            polecenie.append("date = '" + aThis.Jumper_DateUpdatePicker.getValue().toString() + "', ");
        }
        if (!aThis.Jumper_NationalityUpdateField.getText().toString().isEmpty()) {
            polecenie.append("country = '" + aThis.Jumper_NationalityUpdateField.getText().toString() + "', ");
        }

        polecenie.deleteCharAt(polecenie.length() - 2);
        polecenie.append("where skijumper_id = " + aThis.Jumper_IdField.getText().toString() + ";");
        return polecenie.toString();
    }

    /**
     * Metoda pobiera ciag znaków będących zawartościa zaznaczonego wiersza,
     * nastepnie pobrany tekst rozkłada na czynniki pierwsze po czym generuje z
     * nich obiekt
     *
     * @param text pobiera tekst bedący ciagiem zawartości zaznaczonego wiersza
     * @return zwraca obiekt hill ktory pozniej wypisywany jest w dane okna
     */
    public static Skijumper updateSetContentToField(StringBuilder text) {
        text.deleteCharAt(0);
        text.deleteCharAt(text.length() - 1);
        String toObject = text.toString();
        ArrayList<String> listaDoKonstruktora = new ArrayList<>();
        for (String object : toObject.split(",")) {
            listaDoKonstruktora.add(object);
        }
        Skijumper jumper = new Skijumper(listaDoKonstruktora);
        return jumper;
    }

}
