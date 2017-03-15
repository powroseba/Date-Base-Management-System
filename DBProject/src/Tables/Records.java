/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tables;

import java.util.ArrayList;

/**
 * Klasa tworząca obiekt Record i zapewniająca mu niezbędne funkcjonalności
 *
 * @author seba
 */
public class Records {

    private int id;
    private int skijumperId;
    private String rodzajRekordu;
    private float length;
    private String date;
    private int trainerId;
    private int hillId;

    /**
     * Konstruktor domyślny
     */
    public Records() {
    }

    /**
     * Konstruktor inicjalizujący
     *
     * @param id parametr przechowujący id rekordu
     * @param skijumperId parametr będący id skoczka
     * @param rodzajRekordu parametr odpowiadający za rodzaj rekordu
     * @param length parametr odpowiadający za wielkość rekordu
     * @param date parametr przechowujący date rekordu
     * @param trainerId parametr będący identyfikatorem trenera
     * @param hillId parametr będący identyfikatorem skoczni
     */
    public Records(int id, int skijumperId, String rodzajRekordu, float length, String date, int trainerId, int hillId) {
        this.id = id;
        this.skijumperId = skijumperId;
        this.rodzajRekordu = rodzajRekordu;
        this.length = length;
        this.date = date;
        this.trainerId = trainerId;
        this.hillId = hillId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }
    
    public String getStringId() {
        return Integer.toString(id);
    }

    /**
     * Medota konwertująca id na typ tekstowy
     *
     * @return zwraca id w postaci tekstu
     */

    public float getLength() {
        return length;
    }

    /**
     * Metoda konwertująca length na typ tekstowy
     *
     * @return zwraca length w postaci tekstu
     */
    public String getStringLength() {
        return Float.toString(length);
    }

    public int getSkijumperId() {
        return skijumperId;
    }

    /**
     * Metoda konwertująca id skoczka na typ tekstowy
     *
     * @return zwraca skijumper id w postaci tekstu
     */
    public String getStringSkijumperId() {
        return Integer.toString(skijumperId);
    }

    public int getTrainerId() {
        return trainerId;
    }

    /**
     * Metoda konwertująca id trenera na typ tekstowy
     *
     * @return zwraca trainer id w postaci tekstu
     */
    public String getStringTrainerId() {
        return Integer.toString(trainerId);
    }

    public int getHillId() {
        return hillId;
    }

    /**
     * Metoda konwertująca id skoczni na typ tekstowy
     *
     * @return zwraca hill id w postaci tekstu
     */
    public String getStringHillId() {
        return Integer.toString(hillId);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLenght(float length) {
        this.length = length;
    }

    public void setSkijumperId(int skijumperId) {
        this.skijumperId = skijumperId;
    }

    public void setTrainerId(int trainerId) {
        this.trainerId = trainerId;
    }

    public void setHillId(int hillId) {
        this.hillId = hillId;
    }

    public String getRodzajRekordu() {
        return rodzajRekordu;
    }

    public void setRodzajRekordu(String rodzajRekordu) {
        this.rodzajRekordu = rodzajRekordu;
    }

    @Override
    public String toString() {
        return id + "," + skijumperId + ",'" + rodzajRekordu + "'," + length + ",'" + date + "'," + trainerId + "," + hillId;
    }
}
