/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBMethods;

import DB.DBSkiJumpers;
import Tables.Skijumper;
import Tables.Trainer;
import UI.FXMLDocumentController;
import java.util.ArrayList;

/**
 * Klasa posiadająca metody zarządzania baza danych oraz oknem
 *
 * @author seba
 */
public class DBTrainerMethods {

    /**
     * Metoda tworząca zapytanie do bazy danych
     *
     * @return zwraca zapytanie select w postaci tekstu
     */
    public static String selectTrainer() {
        StringBuilder polecenie = new StringBuilder("SELECT ");
        polecenie.append("* from trainers;");
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
    public static String insertTrainer(FXMLDocumentController aThis) {
        StringBuilder polecenie = new StringBuilder("INSERT INTO trainers values (");
        polecenie.append(aThis.Trainer_IdField.getText().toString() + ", ");
        polecenie.append("'" + aThis.Trainer_NameField.getText().toString() + "', ");
        polecenie.append("'" + aThis.Trainer_SurnameField.getText().toString() + "', ");
        polecenie.append("'" + aThis.Trainer_DatePicker.getValue().toString() + "', ");
        polecenie.append("'" + aThis.Trainer_NationalityField.getText().toString() + "');");
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
    public static String deleteTrainer(FXMLDocumentController aThis) {
        StringBuilder polecenie = new StringBuilder("DELETE FROM trainers where");
        polecenie.append(" trainer_id = " + aThis.Trainer_IdField.getText().toString() + ";");
        return polecenie.toString();
    }

    /**
     * Metoda pobiera zawartość okna w danej zakladce po czym generuje dokladne
     * zapytanie do bazy danych
     *
     * @param id pobiera zawartość pola id
     * @return zwraca gotowe zapytanie insert w postaci tekstu
     */
    public static String deleteTrainer(String id) {
        StringBuilder polecenie = new StringBuilder("DELETE FROM trainers where (");
        polecenie.append(" trainer_id = " + id + ");");
        return polecenie.toString();
    }

    /**
     * Metoda pobierając zawartość odpowiednich okien w zakladkach generuje
     * dokladne zapytanie update
     *
     * @param aThis pobiera zawartości znajdujące sie w komponentach danego okna
     * @return zwraca gotowe zapytanie
     */
    public static String updateTrainer(FXMLDocumentController aThis) {

        StringBuilder polecenie = new StringBuilder("UPDATE trainers set ");
        if (!aThis.Trainer_IdUpdateField.getText().isEmpty()) {
            polecenie.append("trainer_id = " + aThis.Trainer_IdUpdateField.getText().toString() + ", ");
        }
        if (!aThis.Trainer_NameUpdateField.getText().isEmpty()) {
            polecenie.append("trainer_name = '" + aThis.Trainer_NameUpdateField.getText().toString() + "', ");
        }
        if (!aThis.Trainer_SurnameUpdateField.getText().isEmpty()) {
            polecenie.append("trainer_surname = '" + aThis.Trainer_SurnameUpdateField.getText().toString() + "', ");
        }
        if (!(aThis.Trainer_DateUpdatePicker.getValue() == null)) {
            polecenie.append("date = '" + aThis.Trainer_DateUpdatePicker.getValue().toString() + "', ");
        }
        if (!aThis.Trainer_NationalityUpdateField.getText().toString().isEmpty()) {
            polecenie.append("country = '" + aThis.Trainer_NationalityUpdateField.getText().toString() + "', ");
        }

        polecenie.deleteCharAt(polecenie.length() - 2);
        polecenie.append("where trainer_id = " + aThis.Trainer_IdField.getText().toString() + ";");
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
    public static Trainer updateSetContentToField(StringBuilder text) {
        text.deleteCharAt(0);
        text.deleteCharAt(text.length() - 1);
        String toObject = text.toString();
        ArrayList<String> listaDoKonstruktora = new ArrayList<>();
        for (String object : toObject.split(",")) {
            listaDoKonstruktora.add(object);
        }
        Trainer trainer = new Trainer(listaDoKonstruktora);
        return trainer;
    }
}
