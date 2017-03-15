/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBMethods;

import DB.DBSkiJumpers;
import Tables.Records;
import Tables.Skijumper;
import Tables.Trainer;
import UI.FXMLDocumentController;
import java.util.ArrayList;

/**
 * Klasa posiadająca metody zarządzania baza danych oraz oknem
 *
 * @author seba
 */
public class DBRecordMethods {

    /**
     * Metoda tworząca zapytanie do bazy danych
     *
     * @return zwraca zapytanie select w postaci tekstu
     */
    public static String selectRecords() {
        StringBuilder polecenie = new StringBuilder("SELECT ");
        polecenie.append("id, jumper_name, jumper_surname, record_length, record_date, rodzaj_rekordu, trainer_name,"
                + "trainer_surname, hill_name, hill_length, k_point from skijumpers inner join records "
                + "using(skijumper_id) inner join trainers using(trainer_id) inner join hill using(hill_id);");
        return polecenie.toString();
    }
    /**
     * Metoda tworząca zapytanie do bazy danych
     * @param id przechowuje dokladny indeks zaznaczonego obiektu
     * @return zwraca zapytanie select w postaci tekstu 
     */
    public static String selectRecords(int id) {
        StringBuilder polecenie = new StringBuilder("SELECT ");
        polecenie.append("* FROM records where id = " + id);
        return polecenie.toString();
    }
    /**
     * Metoda dokonuje pobrania zawartości z pól tekstowych okna oraz
     * wykorzystuje ich zawartosc to wygenerowania zapytania
     *
     * @param aThis pobiera komponenty z okna w celu uzyskania ich zawartości
     * @return zwraca gotowe zapytanie insert w postaci tekstu
     */
    public static String insertRecord(FXMLDocumentController aThis) {
        StringBuilder polecenie = new StringBuilder("INSERT INTO records values (");
        polecenie.append(aThis.Records_IdField.getText().toString() + ", ");
        polecenie.append(aThis.Records_SkiJumperIdField.getText().toString() + ", ");
        polecenie.append("'" + aThis.Records_TypeField.getText().toString() + "', ");
        polecenie.append(aThis.Records_LengthField.getText().toString() + ", ");
        polecenie.append("'" + aThis.Records_DatePicker.getValue().toString() + "',");
        polecenie.append(aThis.Records_TrainerIDField.getText().toString() + ",");
        polecenie.append(aThis.Records_HillIDField.getText().toString() + "); ");
        return polecenie.toString();
    }
    /**
     * Metoda dokonuje pobrania zawartości z pól tekstowych okna oraz
     * wykorzystuje ich zawartosc to wygenerowania zapytania
     * @param aThis pobiera zawartość komponentów z okna w celu uzyskania ich zawartości
     * @return zwraca gotowe zapytanie insert w postaci tekstu
     */
    public static String deleteRecord(FXMLDocumentController aThis) {
        StringBuilder polecenie = new StringBuilder("DELETE FROM records where");
        polecenie.append(" id = " + aThis.Records_IdField.getText().toString() + ";");
        return polecenie.toString();
    }
    /**
     * Metoda dokonuje generowania zapytania usuwającego rekord o danym id
     * @param id parametr przechowująca id
     * @return zwraca gotowe zapytanie insert w postaci tekstu
     */
    public static String deleteRecordWhereId(int id) {
        StringBuilder polecenie = new StringBuilder("DELETE FROM records where");
        polecenie.append(" id = "  + id + ";");
        return polecenie.toString();
    }
    /**
     * Metoda pobierając zawartość odpowiednich okien w zakladkach generuje
     * dokladne zapytanie update
     *
     * @param aThis pobiera zawartości znajdujące sie w komponentach danego okna
     * @return zwraca gotowe zapytanie
     */
    public static String updateRecord(FXMLDocumentController aThis) {

        StringBuilder polecenie = new StringBuilder("UPDATE records set ");
        if (!aThis.Records_IdUpdateField.getText().isEmpty()) {
            polecenie.append("id = " + aThis.Records_IdUpdateField.getText().toString() + ", ");
        }
        if (!aThis.Records_SkiJumperIdUpdateField.getText().isEmpty()) {
            polecenie.append("skijumper_id = '" + aThis.Records_SkiJumperIdUpdateField.getText().toString() + "', ");
        }
        if (!aThis.Records_TypeUpdateField.getText().isEmpty()) {
            polecenie.append("rodzaj_rekordu = '" + aThis.Records_TypeUpdateField.getText().toString() + "', ");
        }
        if (!aThis.Records_LengthUpdateField.getText().isEmpty()) {
            polecenie.append("record_length = " + aThis.Records_LengthUpdateField.getText().toString() + ", ");
        }
        if (!(aThis.Records_UpdateDatePicker.getValue() == null)) {
            polecenie.append("record_date = '" + aThis.Records_UpdateDatePicker.getValue().toString() + "', ");
        }
        if (!aThis.Records_TrainerIDUpdateField.getText().isEmpty()) {
            polecenie.append("trainer_id = '" + aThis.Records_TrainerIDUpdateField.getText().toString() + "', ");
        }
        if (!aThis.Records_HillIDUpdateField.getText().isEmpty()) {
            polecenie.append("hill_id = '" + aThis.Records_HillIDUpdateField.getText().toString() + "', ");
        }

        polecenie.deleteCharAt(polecenie.length() - 2);
        polecenie.append("where id = " + aThis.Records_IdField.getText().toString() + ";");
        return polecenie.toString();
    }

    public static int getSelectedID(String text) {
        int i = 16;
        int id = 0;
        String temp = "";
        while(!(text.substring(i,i+1).equals(","))){
            temp  = temp + text.substring(i,i + 1).toString();
            i++;
        }
        return id = Integer.parseInt(temp);
    }
}
