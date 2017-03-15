/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tables;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author seba
 */
public class Tables {

    public static LocalTime czas = LocalTime.now();

    public static String Always() {
        return "PRAGMA foreign_keys = ON;";
    }

    public static String trainers() {
        return "CREATE TABLE trainers("
                + "trainer_id INTEGER PRIMARY KEY NOT NULL,"
                + "trainer_name VARCHAR(255) NOT NULL,"
                + "trainer_surname VARCHAR(255) NOT NULL,"
                + "date DATE NOT NULL,"
                + "country VARCHAR(255) NOT NULL);";
    }

    public static String skiJumpers() {
        return "CREATE TABLE skijumpers("
                + "skijumper_id INTEGER PRIMARY KEY NOT NULL,"
                + "jumper_name VARCHAR(255) NOT NULL,"
                + "jumper_surname VARCHAR(255) NOT NULL,"
                + "date DATE NOT NULL,"
                + "country VARCHAR(255) NOT NULL);";
    }

    public static String insertSkiJumper(int skijumper_id, String imie, String nazwisko, String date, String country) {
        return "insert into skijumpers values (" + skijumper_id + ", '" + imie + "', '" + nazwisko + "', '" + date
                + "', '" + country + "');";
    }

    public static String insertHill(int hill_id, String name, float size, String city, String create_date, int k_point) {
        return "insert into hill values (" + hill_id + ", '" + name + "'," + size + ", '" + city
                + "', '" + create_date + "', " + k_point + ");";
    }

    public static String insertRecords(int id, int skijumper_id, String rodzaj_rekordu, float length, String data, int trainer_id, int hill_id) {
        return "insert into records values (" + id + ", " + skijumper_id + ", '" + rodzaj_rekordu + "', " + length + ", '" + data + "', " + trainer_id
                + ", " + hill_id + " );";
    }

    public static String insertTrainer(int trainer_id, String imie, String nazwisko, String date, String country) {
        return "insert into trainers values (" + trainer_id + ", '" + imie + "', '" + nazwisko + "', '" + date
                + "', '" + country + "');";
    }

    public static String hill() {
        return "CREATE TABLE hill ("
                + "hill_id INTEGER PRIMARY KEY, "
                + "hill_name VARCHAR(255) NOT NULL, "
                + "hill_length FLOAT NOT NULL,"
                + "place VARCHAR(255) NOT NULL,"
                + "create_date DATE NOT NULL,"
                + "k_point FLOAT NOT NULL);";
    }

    public static String rekords() {
        return "CREATE TABLE records ("
                + "id INTEGER NOT NULL, "
                + "skijumper_id INTEGER NOT NULL, "
                + "rodzaj_rekordu VARCHAR(255) NOT NULL,"
                + "record_length FLOAT NOT NULL, "
                + "record_date DATE NOT NULL,"
                + "trainer_id INTEGER NOT NULL, "
                + "hill_id INTEGER, "
                + "FOREIGN KEY (skijumper_id) REFERENCES skijumpers(skijumper_id) ON UPDATE CASCADE ON DELETE RESTRICT, "
                + "FOREIGN KEY (trainer_id) REFERENCES trainers(trainer_id) ON UPDATE CASCADE ON DELETE RESTRICT, "
                + "FOREIGN KEY (hill_id) REFERENCES hill(hill_id) ON UPDATE CASCADE ON DELETE RESTRICT);";
    }

}
