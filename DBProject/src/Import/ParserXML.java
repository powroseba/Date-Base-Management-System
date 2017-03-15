/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Import;

import DB.DBSkiJumpers;
import Tables.Hill;
import Tables.Records;
import Tables.Skijumper;
import Tables.Tables;
import Tables.Trainer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Calendar;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

/**
 * Parser XML odpowiada za przetwarzanie informacji zawartych w pliku XML oraz
 * dodanie ich do bazy
 *
 * @author seba
 */
public class ParserXML {

    /**
     * Obiekt klasy {@link DBSkiJumpers}tworzący w celu działania na połączeniu
     * z baza danych
     */
    private static DBSkiJumpers dateBase = new DBSkiJumpers();
    /**
     * Zmienna pozwalająca określic stan parsowania
     */
    public static boolean powodzenie = false;
    /**
     * Metoda przetwarzająca dane z pliku XML
     * @return zwraca true jesli parser zostanie wykonany pomyslnie
     * @param filePath pobiera plik XML
     */
    public static boolean loadDataFromXML(File filePath) {
        Hill modelHill = new Hill();
        Skijumper modelSkijumper = new Skijumper();
        Trainer modelTrainer = new Trainer();
        Records modelRecords = new Records();
        try {
            XMLInputFactory iFactory = XMLInputFactory.newInstance();
            InputStream xmlFile = new FileInputStream(filePath);
            XMLStreamReader parser = iFactory.createXMLStreamReader(xmlFile);
            while (parser.hasNext()) {
                switch (parser.next()) {
                    case XMLStreamConstants.START_ELEMENT:
                        if (parser.getLocalName().equals("hill")) {
                            modelHill = new Hill();
                        }
                        if (parser.getLocalName().equals("skijumper")) {
                            modelSkijumper = new Skijumper();
                        }
                        if (parser.getLocalName().equals("trainer")) {
                            modelTrainer = new Trainer();
                        }
                        if (parser.getLocalName().equals("records")) {
                            modelRecords = new Records();
                        }

                        if (parser.getLocalName().equals("Hid")) {
                            modelHill.setId(Integer.parseInt(parser.getElementText()));
                        }
                        if (parser.getLocalName().equals("Hname")) {
                            modelHill.setName("" + parser.getElementText() + "");
                        }
                        if (parser.getLocalName().equals("Hlength")) {
                            modelHill.setLength(Float.parseFloat(parser.getElementText()));
                        }
                        if (parser.getLocalName().equals("Hcity")) {
                            modelHill.setCity("" + parser.getElementText() + "");
                        }
                        if (parser.getLocalName().equals("HcreateDate")) {
                            modelHill.setCreateDate("" + parser.getElementText() + "");
                        }
                        if (parser.getLocalName().equals("HkPoint")) {
                            modelHill.setKPoint(Float.parseFloat(parser.getElementText()));
                        }

                        if (parser.getLocalName().equals("Sid")) {
                            modelSkijumper.setId(Integer.parseInt(parser.getElementText()));
                        }
                        if (parser.getLocalName().equals("Sname")) {
                            modelSkijumper.setName("" + parser.getElementText() + "");
                        }
                        if (parser.getLocalName().equals("Ssurname")) {
                            modelSkijumper.setSurname("" + parser.getElementText() + "");
                        }
                        if (parser.getLocalName().equals("Sdate")) {
                            modelSkijumper.setDateOfBirth("" + parser.getElementText() + "");
                        }
                        if (parser.getLocalName().equals("Scountry")) {
                            modelSkijumper.setCountry("" + parser.getElementText() + "");
                        }

                        if (parser.getLocalName().equals("Tid")) {
                            modelTrainer.setId(Integer.parseInt(parser.getElementText()));
                        }
                        if (parser.getLocalName().equals("Tname")) {
                            modelTrainer.setName("" + parser.getElementText() + "");
                        }
                        if (parser.getLocalName().equals("Tsurname")) {
                            modelTrainer.setSurname("" + parser.getElementText() + "");
                        }
                        if (parser.getLocalName().equals("Tdate")) {
                            modelTrainer.setDateOfBirth("" + parser.getElementText() + "");
                        }
                        if (parser.getLocalName().equals("Tcountry")) {
                            modelTrainer.setCountry("" + parser.getElementText() + "");
                        }

                        if (parser.getLocalName().equals("Rid")) {
                            modelRecords.setId(Integer.parseInt(parser.getElementText()));
                        }
                        if (parser.getLocalName().equals("RskijumperId")) {
                            modelRecords.setSkijumperId(Integer.parseInt(parser.getElementText()));
                        }
                        if (parser.getLocalName().equals("RrodzajRekordu")) {
                            modelRecords.setRodzajRekordu("" + parser.getElementText() + "");
                        }
                        if (parser.getLocalName().equals("Rlength")) {
                            modelRecords.setLenght(Float.parseFloat(parser.getElementText()));
                        }
                        if (parser.getLocalName().equals("Rdate")) {
                            modelRecords.setDate("" + parser.getElementText() + "");
                        }
                        if (parser.getLocalName().equals("RtrainerId")) {
                            modelRecords.setTrainerId(Integer.parseInt(parser.getElementText()));
                        }
                        if (parser.getLocalName().equals("RhillId")) {
                            modelRecords.setHillId(Integer.parseInt(parser.getElementText()));
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        if (parser.getLocalName().equals("hill")) {
                            if(dateBase.wykonajInsert(dateBase.genereteInsertObject(modelHill))) 
                            powodzenie = true;
                        }
                        if (parser.getLocalName().equals("skijumper")) {
                            if(dateBase.wykonajInsert(dateBase.genereteInsertObject(modelSkijumper)))
                                powodzenie = true;
                        }
                        if (parser.getLocalName().equals("trainer")) {
                            if(dateBase.wykonajInsert(dateBase.genereteInsertObject(modelTrainer)))
                                powodzenie = true;
                        }
                        if (parser.getLocalName().equals("records")) {
                            if(dateBase.wykonajInsert(dateBase.genereteInsertObject(modelRecords)))
                                powodzenie = true;
                        }
                        break;

                }
            }
        } catch (FileNotFoundException e1) {
            System.out.println("Plik nie znaleziony");
            powodzenie = true;
        } catch (XMLStreamException e2) {
            System.out.println("Bład pliku XML");
            powodzenie = true;
        } catch (NumberFormatException e3) {
            System.out.println("Bledny format liczby");
            powodzenie = true;

        }
        return powodzenie;
    }
}
