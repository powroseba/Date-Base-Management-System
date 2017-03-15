package DB;

import DBMethods.DBJumperMethods;
import Tables.Hill;
import Tables.Records;
import Tables.RecordsView;
import Tables.Skijumper;
import Tables.Tables;
import Tables.Trainer;
import UI.FXMLDocumentController;
import UI.SebaUI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;

/**
 * Klasa stanowiąca połączenie z bazą danych, posiada wszystkie metody
 * pozwalające dokonywać zapytania do bazy danaych
 *
 * @author seba
 */
public class DBSkiJumpers {

    /**
     * {@value #DB_URL} adres do sterownika sqlite {@value  #DRIVER} adres do
     * bazy danych
     */
    private static final String DRIVER = "org.sqlite.JDBC"; // Sterownik
    private static final String DB_URL = "jdbc:sqlite:Records.db"; //Sciezka do bazy danych
    /**
     * Pole {@link #conn} obiekt tworzący połączenie z bazą danych
     */
    public static Connection conn;
    /**
     * Pole {@link #stat} obiekt pozwalający tworzyć nowe wyrażenia SQL
     */
    public static Statement stat;
    /**
     * Pole {@link #connectionStatus}
     */
    public static boolean connectionStatus = false;
    /**
     * Pole {@link  #SList} lista przechowująca obiekty {@link  Skijumper}
     * pobierane z bazy danych za pomocą metody {@link  #wykonajZapytanie(UI.FXMLDocumentController, java.lang.String)
     * }
     */
    public ObservableList<Skijumper> SList = FXCollections.observableArrayList();
    /**
     * Pole {@link  #TList} lista przechowująca obiekty {@link Trainer} pobierane
     * z bazy danych za pomocą metody {@link #wykonajZapytanie(UI.FXMLDocumentController, java.lang.String)
     * }
     */
    public ObservableList<Trainer> TList = FXCollections.observableArrayList();
    /**
     * Pole {@link  #HList} lista przechowująca obiekty {@link Hill} pobierane z
     * bazy danych za pomocą metody {@link #wykonajZapytanie(UI.FXMLDocumentController, java.lang.String)
     * }
     */
    public ObservableList<Hill> HList = FXCollections.observableArrayList();
    /**
     * Pole {@link  #RVList} lista przechowująca obiekty {@link RecordsView}
     * pobierane z bazy danych za pomocą metody {@link #wykonajZapytanie(UI.FXMLDocumentController, java.lang.String)}
     *
     */
    public ObservableList<RecordsView> RVList = FXCollections.observableArrayList();
    /**
     * Pole {@link  #RList} lista przechowująca obiekty {@link Records}
     * pobierane z bazy danych za pomocą metody {@link #wykonajZapytanie(UI.FXMLDocumentController, java.lang.String)}
     */
    public static ArrayList<Records> RList = new ArrayList<>();
    /**
     * Pole {@link #time} pobierająca lokalną godzine
     */
    static LocalTime time = LocalTime.now();
    /**
     * Pole {@link #czas} pole wyświetlające aktualną godzine za pomocą tekstu
     * do obiektu {@link UI.FXMLDocumentController#SystemMessages}
     */
    public static String czas = time.getHour() + ":" + time.getMinute() + ":" + time.getSecond() + " : ";

    /*
    Konstruktor domyślny
     */
    public DBSkiJumpers() {
    }

    /**
     * Metoda odpowiadająca za połączenie z baza Metoda {@link #necesseryInstuction()
     * } wykonuje operacje na bazie mające za zadanie włączyć obsługe klucza
     * obcego
     *
     * @param aThis referencja do obiektu
     * {@link  UI.FXMLDocumentController#SystemMessages} stanowiącego okno
     * konsoli
     * @return true jeżeli polączenie z bazą przebiegło poprawnie
     */
    public boolean connectDataBase(FXMLDocumentController aThis) {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            aThis.SystemMessages.appendText(czas + "ERROR: Not found SQL controller!\n");
            aThis.SystemMessages.appendText(czas + "SQLController Exception : " + e.getMessage() + "\n");
            e.printStackTrace();
        }
        try {
            conn = DriverManager.getConnection(DB_URL);
            stat = (Statement) conn.createStatement();
            necesseryInstuction();
            aThis.SystemMessages.appendText(czas + "Connected to the database!\n");
            connectionStatus = true;
            return true;
        } catch (SQLException e) {
            aThis.SystemMessages.appendText(czas + "ERROR: Open connection problem!\n");
            aThis.SystemMessages.appendText(czas + "SQL Connect Exception" + e.getMessage() + "\n");
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Metoda zamykająca połączenie z bazą danych
     *
     * @param aThis referencja do obiektu
     * {@link  UI.FXMLDocumentController#SystemMessages} stanowiącego okno
     * konsoli
     * @return true jeżeli rozłączenie z bazą przebiegnie poprawnie
     */
    public boolean closeConnection(FXMLDocumentController aThis) {
        try {
            conn.close();
            aThis.SystemMessages.appendText(czas + "Connection closed!\n");
            connectionStatus = false;
            return true;
        } catch (SQLException e) {
            aThis.SystemMessages.appendText(czas + "ERROR: Problem with closing the connection\n");
            aThis.SystemMessages.appendText(czas + "SQL Dissconnect Excepton: " + e.getMessage() + "\n");
            e.printStackTrace();
            connectionStatus = true;
            return false;
        }
    }

    /**
     * Metoda zamykająca połączenie z bazą danych
     *
     * @return true jeżeli połączcenie zostanie zamknięte
     */
    public boolean closeConnection() {
        try {
            if (connectionStatus) {
                conn.close();
            }
            connectionStatus = false;
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            connectionStatus = true;
            return false;
        }
    }

    /**
     *
     */
    public void necesseryInstuction() {
        try {
            String polecenie = Tables.Always();
            stat.execute(polecenie);
        } catch (SQLException ex) {
            System.out.println("ERROR: Not successful database configuration!!!\n" + ex.getMessage());
        }
    }

    /**
     * Metoda generująca gotowe zapytanie insert pobierając dane przejęte z
     * pliku XML Przejmowanie danych odbywa sie w klasie
     * {@link Import.ParserXML} za pomocą metody {@link Import.ParserXML#loadDataFromXML(java.io.File)
     * }
     *
     * @param object przejmuje obiekt skonstruowany przez parser
     * @return zwraca gotowe zapytanie dla parsera XML
     */
    public String genereteInsertObject(Object object) {
        String querry1 = "INSERT into ";
        String querry2 = "";
        String querry3 = " values (";
        String querry4 = ");";
        querry2 = "";
        if (object.getClass().getSimpleName().equals("Hill")) {
            querry2 = "hill";
        }
        if (object.getClass().getSimpleName().equals("Skijumper")) {
            querry2 = "skijumpers";
        }
        if (object.getClass().getSimpleName().equals("Trainer")) {
            querry2 = "trainers";
        }
        if (object.getClass().getSimpleName().equals("Records")) {
            querry2 = "records";
        }
        return querry1 + querry2 + querry3 + object.toString() + querry4;
    }

    /**
     *
     * @param aThis referencja do obiektu
     * {@link  UI.FXMLDocumentController#SystemMessages} stanowiącego okno
     * konsoli
     * @param polecenie przejmuje polecenie generowane w klasach z pakietu
     * {@link DBMethods} Metody generujące zapytanie w klasie
     * {@link DBMethods.DBHillMethods}: Zapytanie select: {@link DBMethods.DBHillMethods#selectHill()
     * }
     * Zapytanie insert: {@link DBMethods.DBHillMethods#insertHill(UI.FXMLDocumentController) ()
     * }
     * Zapytanie delete: {@link DBMethods.DBHillMethods#deleteHill(UI.FXMLDocumentController) ()
     * }
     * Zapytanie update: {@link DBMethods.DBHillMethods#updateHill(UI.FXMLDocumentController) ()
     * }
     * Metody generujące zapytanie w klasie {@link DBMethods.DBJumperMethods}:
     * Zapytanie select: {@link DBMethods.DBJumperMethods#selectJumper() () }
     * Zapytanie insert: {@link DBMethods.DBJumperMethods#insertJumper(UI.FXMLDocumentController) ()
     * }
     * Zapytanie delete: {@link DBMethods.DBJumperMethods#deleteJumper(UI.FXMLDocumentController) ()
     * }
     * Zapytanie update: {@link DBMethods.DBJumperMethods#updateJumper(UI.FXMLDocumentController) ()
     * }
     * Metody generujące zapytanie w klasie {@link DBMethods.DBTrainerMethods}:
     * Zapytanie select: {@link DBMethods.DBTrainerMethods#selectTrainer() () }
     * Zapytanie insert: {@link DBMethods.DBTrainerMethods#insertTrainer(UI.FXMLDocumentController) ()
     * }
     * Zapytanie delete: {@link DBMethods.DBTrainerMethods#deleteTrainer(UI.FXMLDocumentController) ()
     * }
     * Zapytanie update: {@link DBMethods.DBTrainerMethods#updateTrainer(UI.FXMLDocumentController) ()
     * }
     * Metody generujące zapytanie w klasie {@link DBMethods.DBRecordMethods}:
     * Zapytanie select: {@link DBMethods.DBRecordMethods#selectRecords() () ()
     * }
     * Zapytanie insert: {@link DBMethods.DBRecordMethods#insertRecord(UI.FXMLDocumentController) ()
     * }
     * Zapytanie delete: {@link DBMethods.DBRecordMethods#deleteRecord(UI.FXMLDocumentController) ()
     * }
     * Zapytanie update: {@link DBMethods.DBRecordMethods#updateRecord(UI.FXMLDocumentController) ()
     * }
     */
    public void wykonajZapytanie(FXMLDocumentController aThis, String polecenie) {
        StringTokenizer st = new StringTokenizer(polecenie, " ");

        String firstWord = st.nextToken().toUpperCase();
        if (firstWord.equals("SELECT")) {
            try {
                //SList = FXCollections.observableArrayList();
                ResultSet resultSet = stat.executeQuery(polecenie);
                SList.clear();
                TList.clear();
                HList.clear();
                RVList.clear();
                RList.clear();
                while (resultSet.next()) {
                    if (aThis.Jumper_Show.isSelected() && aThis.Jumper_Data.isSelected()) {
                        Skijumper jumper = new Skijumper(resultSet.getInt("skijumper_id"), resultSet.getString("jumper_name"),
                                resultSet.getString("jumper_surname"), resultSet.getString("date"), resultSet.getString("country"));
                        SList.add(jumper);
                    }
                    if (aThis.Trainer_Show.isSelected() && aThis.Trainer_Data.isSelected()) {
                        Trainer trainer = new Trainer(resultSet.getInt("trainer_id"), resultSet.getString("trainer_name"),
                                resultSet.getString("trainer_surname"), resultSet.getString("date"), resultSet.getString("country"));
                        TList.add(trainer);
                    }
                    if (aThis.Hill.isSelected() && aThis.Hill_ShowData.isSelected()) {
                        Hill hill = new Hill(resultSet.getInt("hill_id"), resultSet.getString("hill_name"),
                                resultSet.getFloat("hill_length"), resultSet.getString("place"), resultSet.getString("create_date"), resultSet.getFloat("k_point"));
                        HList.add(hill);
                    }
                    if (aThis.Records.isSelected() && aThis.Records_ShowData.isSelected()) {
                        RecordsView recordView = new RecordsView(resultSet.getInt("id"), resultSet.getString("jumper_name"),
                                resultSet.getString("jumper_surname"), resultSet.getFloat("record_length"), resultSet.getString("record_date"),
                                resultSet.getString("rodzaj_rekordu"), resultSet.getString("trainer_name"), resultSet.getString("trainer_surname"),
                                resultSet.getString("hill_name"), resultSet.getFloat("hill_length"), resultSet.getFloat("k_point"));
                        RVList.add(recordView);
                    }
                    if(!(aThis.Records_Table.getSelectionModel().isEmpty())){
                        Records record = new Records(resultSet.getInt("id"), resultSet.getInt("skijumper_id"), resultSet.getString("rodzaj_rekordu"),
                                resultSet.getFloat("record_length"), resultSet.getString("record_date"), resultSet.getInt("trainer_id"), resultSet.getInt("hill_id"));
                        RList.add(record);
                    }
                }
            } catch (SQLException e) {
                aThis.SystemMessages.appendText(czas + "ERROR: Wystapil blad podczas proby wykonania zapytania do bazy danych!!!\n");
                aThis.SystemMessages.appendText(czas + "SQLException!: " + e.getMessage() + "\n");
            }

        } else if (firstWord.equals("INSERT") || firstWord.equals("DELETE") || firstWord.equals("UPDATE")) {
            try {
                int wynikUpdate = stat.executeUpdate(polecenie);
                if (wynikUpdate > 0) {
                    aThis.SystemMessages.appendText(czas + "Liczba zmodyfikowanych rekordow: " + wynikUpdate + "\n");
                } else {
                    aThis.SystemMessages.appendText(czas + "ERROR: Nie zmodyfikowano zadnego rekordu\n");
                }
            } catch (SQLException ex) {
                aThis.SystemMessages.appendText(czas + "ERROR: Wystapil blad podczas proby aktualizacji bazy danych!!!\n" + ex.getMessage());
            }

        }
    }
    /**
     * Metoda wykonuje zapytanie do bazy danych i zwraca obiekt typu {@link Records}
     * @param aThis pobiera referencje do komponentow okna
     * @param polecenie pobiera zapytanie do bazy
     */
    public void wykonajSelectForRecords(FXMLDocumentController aThis, String polecenie) {
        StringTokenizer st = new StringTokenizer(polecenie, " ");

        String firstWord = st.nextToken().toUpperCase();
        if (firstWord.equals("SELECT")) {
            try {
                ResultSet resultSet = stat.executeQuery(polecenie);
                RList.clear();
                while (resultSet.next()) {
                    if(!(aThis.Records_Table.getSelectionModel().isEmpty())){
                        Records record = new Records(resultSet.getInt("id"), resultSet.getInt("skijumper_id"), resultSet.getString("rodzaj_rekordu"),
                                resultSet.getFloat("record_length"), resultSet.getString("record_date"), resultSet.getInt("trainer_id"), resultSet.getInt("hill_id"));
                        RList.add(record);
                    }
                }
            } catch (SQLException e) {
                aThis.SystemMessages.appendText(czas + "ERROR: Wystapil blad podczas proby wykonania zapytania do bazy danych!!!\n");
                aThis.SystemMessages.appendText(czas + "SQLException!: " + e.getMessage() + "\n");
            }

        }
    }
                
    /**
     * Metoda wykonuje dodanie informacji do bazy danych przejętych z klasy
     * {@link Import.ParserXML}
     *
     * @param polecenie referencja do obiektu stanowiącego dokladne zapytanie do
     * bazy danych
     * @return zwraca true jest zapytanie z {@link Import.ParserXML zostanie pomyslnie wykonane}
     */
    public boolean wykonajInsert(String polecenie) {
        StringTokenizer st = new StringTokenizer(polecenie, " ");
        boolean powodzenie = false;
        String firstWord = st.nextToken().toUpperCase();
        if (firstWord.equals("INSERT") || firstWord.equals("DELETE") || firstWord.equals("UPDATE")) {
            try {
                int wynikUpdate = stat.executeUpdate(polecenie);
                if (wynikUpdate > 0) {
                    System.out.println(czas + "Liczba zmodyfikowanych rekordow: " + wynikUpdate + "\n");
                    powodzenie = true;
                } else {
                    System.out.println(czas + "ERROR: Nie zmodyfikowano zadnego rekordu\n");
                    powodzenie = false;
                }
            } catch (SQLException ex) {
                System.out.println(czas + "ERROR: Wystapil blad podczas proby aktualizacji bazy danych!!!\n" + ex.getMessage());
                powodzenie = false;
            }

        }
        return powodzenie;
    }

}
