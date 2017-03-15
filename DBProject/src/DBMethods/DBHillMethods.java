/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBMethods;

import DB.DBSkiJumpers;
import Tables.Hill;
import Tables.Trainer;
import UI.FXMLDocumentController;
import java.util.ArrayList;

/**
 * Klasa posiadająca metody zarządzania baza danych oraz oknem
 *
 * @author seba
 */
public class DBHillMethods {

    /**
     * Metoda tworząca zapytanie do bazy danych
     *
     * @return zwraca zapytanie select w postaci tekstu
     */
    public static String selectHill() {
        StringBuilder polecenie = new StringBuilder("SELECT ");
        polecenie.append("* from hill;");
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
    public static String insertHill(FXMLDocumentController aThis) {
        StringBuilder polecenie = new StringBuilder("INSERT INTO hill values (");
        polecenie.append(aThis.Hill_ID.getText().toString() + ", ");
        polecenie.append("'" + aThis.Hill_NameField.getText().toString() + "', ");
        polecenie.append(aThis.Hill_LengthField.getText().toString() + ", ");
        polecenie.append("'" + aThis.Hill_CityField.getText().toString() + "', ");
        polecenie.append("'" + aThis.Hill_DatePicker.getValue().toString() + "', ");
        polecenie.append("'" + aThis.Hill_KPointField.getText().toString() + "');");
        return polecenie.toString();
    }

    /**
     * Metoda dokonuje pobrania zawartości z pól tekstowych okna oraz
     * wykorzystuje ich zawartosc to wygenerowania zapytania
     *
     * @param aThis pobiera zawartosc komponenta z okna w celu uzyskania ich
     * zawartości
     * @return zwraca gotowe zapytanie insert w postaci tekstu
     */
    public static String deleteHill(FXMLDocumentController aThis) {
        StringBuilder polecenie = new StringBuilder("DELETE FROM hill where (");
        polecenie.append(" hill_id = " + aThis.Hill_ID.getText().toString() + ");");
        return polecenie.toString();
    }

    /**
     * Metoda pobiera zawartość okna w danej zakladce po czym generuje dokladne
     * zapytanie do bazy danych
     *
     * @param id pobiera zawartość pola id
     * @return zwraca gotowe zapytanie insert w postaci tekstu
     */
    public static String deleteHill(String id) {
        StringBuilder polecenie = new StringBuilder("DELETE FROM hill where (");
        polecenie.append(" hill_id = " + id + ");");
        return polecenie.toString();
    }

    /**
     * Metoda pobierając zawartość odpowiednich okien w zakladkach generuje
     * dokladne zapytanie update
     *
     * @param aThis pobiera zawartości znajdujące sie w komponentach danego okna
     * @return zwraca gotowe zapytanie
     */
    public static String updateHill(FXMLDocumentController aThis) {

        StringBuilder polecenie = new StringBuilder("UPDATE hill set ");
        if (!aThis.Hill_IDUpdate.getText().isEmpty()) {
            polecenie.append("hill_id = " + aThis.Hill_IDUpdate.getText().toString() + ", ");
        }
        if (!aThis.Hill_NameUpdateField.getText().isEmpty()) {
            polecenie.append("hill_name = '" + aThis.Hill_NameUpdateField.getText().toString() + "', ");
        }
        if (!aThis.Hill_LengthUpdateField.getText().isEmpty()) {
            polecenie.append("hill_length = '" + aThis.Hill_LengthUpdateField.getText().toString() + "', ");
        }
        if (!aThis.Hill_CityUpdateLabel.getText().isEmpty()) {
            polecenie.append("place = '" + aThis.Hill_CityUpdateLabel.getText().toString() + "', ");
        }
        if (!(aThis.Hill_DatePickerUpdate.getValue() == null)) {
            polecenie.append("create_date = '" + aThis.Hill_DatePickerUpdate.getValue().toString() + "', ");
        }
        if (!aThis.Hill_KPointUpdateField.getText().toString().isEmpty()) {
            polecenie.append("k_point = '" + aThis.Hill_KPointUpdateField.getText().toString() + "', ");
        }

        polecenie.deleteCharAt(polecenie.length() - 2);
        polecenie.append("where hill_id = " + aThis.Hill_ID.getText().toString() + ";");
        return polecenie.toString();
    }
    /**
     * Metoda pobiera ciag znaków będących zawartościa zaznaczonego wiersza,
     * nastepnie pobrany tekst rozkłada na czynniki pierwsze po czym generuje z nich obiekt
     * @param text pobiera tekst bedący ciagiem zawartości zaznaczonego wiersza
     * @return zwraca obiekt hill ktory pozniej wypisywany jest w dane okna
     */
    public static Hill updateSetContentToField(StringBuilder text) {
        text.deleteCharAt(0);
        text.deleteCharAt(text.length() - 1);
        String toObject = text.toString();
        ArrayList<String> listaDoKonstruktora = new ArrayList<>();
        for (String object : toObject.split(",")) {
            listaDoKonstruktora.add(object);
        }
        Hill hill = new Hill(listaDoKonstruktora);
        return hill;
    }
}
