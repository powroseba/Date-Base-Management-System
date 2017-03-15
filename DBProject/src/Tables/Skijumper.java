package Tables;

import java.util.ArrayList;
import java.util.Date;

/**
 * Klasa pozwalająca stworzyć obiekt Skijumper i zapewniająca mu niezbędne
 * funkcjonalności
 *
 * @see #Skijumper(java.util.ArrayList)
 * @author seba
 */
public class Skijumper {

    private int id;
    private String name;
    private String surname;
    private String dateOfBirth;
    private String country;

    /**
     * Konstruktor tworzacy obiekt z parametrow typu tekstowego
     *
     * @param lista przechowuje zaznaczony wiersz tabeli w postaci tekstu
     */
    public Skijumper(ArrayList<String> lista) {
        try {
            this.id = Integer.parseInt(lista.get(0));

            StringBuilder nameCut = new StringBuilder(lista.get(1));
            nameCut.deleteCharAt(0);
            nameCut.deleteCharAt(nameCut.length() - 1);
            this.name = nameCut.toString();

            StringBuilder surnameCut = new StringBuilder(lista.get(2));
            surnameCut.deleteCharAt(0);
            surnameCut.deleteCharAt(surnameCut.length() - 1);
            this.surname = surnameCut.toString();

            StringBuilder dateCut = new StringBuilder(lista.get(3));
            dateCut.deleteCharAt(0);
            dateCut.deleteCharAt(dateCut.length() - 1);
            this.dateOfBirth = dateCut.toString();

            StringBuilder countryCut = new StringBuilder(lista.get(4));
            countryCut.deleteCharAt(0);
            countryCut.deleteCharAt(countryCut.length() - 1);
            this.country = countryCut.toString();
        } catch (NumberFormatException a) {
            System.out.println("");
        }
    }

    /**
     * Konstruktor inicjalizujący
     *
     * @param id parametr przechowujący id
     * @param name parametr przechowujący imie
     * @param surname parametr przehcowujący nazwisko
     * @param dateOfBirth parametr przechowujący date urodzenia
     * @param country parametr przechowujący informację o mieście
     */
    public Skijumper(int id, String name, String surname, String dateOfBirth, String country) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.country = country;
    }

    /**
     * Konstruktor domyślny
     */
    public Skijumper() {
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

    public String getSurname() {
        return surname;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getCountry() {
        return country;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return id + ",'" + name + "','" + surname + "','" + dateOfBirth + "','" + country + "'";
    }
}
