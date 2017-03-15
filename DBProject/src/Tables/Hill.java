package Tables;

import java.util.ArrayList;
import java.util.Date;

/**
 * Klasa tworząca obiekt Hill i zapewniająca mu niezbędne funkcjonalności
 *
 * @author seba
 */
public class Hill {

    private int id;
    private String name;
    private float length;
    private String city;
    private String createDate;
    private float kPoint;

    /**
     * Konstruktor tworzący obiekt z parametrow typu tekstowego
     *
     * @param lista lista przechowująca wyglad zaznaczonego wiersza tabeli w
     * zakladce hill w postaci tekstu
     */
    public Hill(ArrayList<String> lista) {
        try {
            this.id = Integer.parseInt(lista.get(0));

            StringBuilder nameCut = new StringBuilder(lista.get(1));
            nameCut.deleteCharAt(0);
            nameCut.deleteCharAt(nameCut.length() - 1);
            this.name = nameCut.toString();

            this.length = Float.parseFloat(lista.get(2));

            StringBuilder cityCut = new StringBuilder(lista.get(3));
            cityCut.deleteCharAt(0);
            cityCut.deleteCharAt(cityCut.length() - 1);
            this.city = cityCut.toString();

            StringBuilder dateCut = new StringBuilder(lista.get(4));
            dateCut.deleteCharAt(0);
            dateCut.deleteCharAt(dateCut.length() - 1);
            this.createDate = dateCut.toString();

            this.kPoint = Float.parseFloat(lista.get(5));
        } catch (NumberFormatException a) {
            System.out.println("");
        }
    }

    public Hill() {
    }

    public Hill(int id, String name, float length, String city, String createDate, float kPoint) {
        this.id = id;
        this.name = name;
        this.length = length;
        this.city = city;
        this.createDate = createDate;
        this.kPoint = kPoint;
    }

    public int getId() {
        return id;
    }

    public String getStringId() {
        return Integer.toString(id);
    }

    public String getName() {
        return name;
    }

    public float getLength() {
        return length;
    }

    public String getStringLength() {
        return Float.toString(length);
    }

    public String getCity() {
        return city;
    }

    public String getCreateDate() {
        return createDate;
    }

    public float getKPoint() {
        return kPoint;
    }

    public String getStringKPoint() {
        return Float.toString(length);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public void setKPoint(float kPoint) {
        this.kPoint = kPoint;
    }

    @Override
    public String toString() {
        return id + ",'" + name + "'," + length + ",'" + city + "','" + createDate + "'," + kPoint;
    }
}
