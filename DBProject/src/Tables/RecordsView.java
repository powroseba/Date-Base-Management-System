/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tables;

/**
 * Klasa tworząca obiekt RecordView używany do generowania tabeli w obknie
 * Records znajdującym sie w aplikacji
 *
 * @author seba
 */
public class RecordsView {

    private int id;
    private String SkiName;
    private String SkiSurname;
    private float recordLength;
    private String recordDate;
    private String recordType;
    private String trainerName;
    private String trainerSurname;
    private String hillName;
    private float hillLength;
    private float hillKPoint;

    /**
     * Konstruktor domyślny
     */
    public RecordsView() {
    }

    /**
     * Konstruktor inicjalizujący
     *
     * @param id parametr stanowiący id rekordu
     * @param SkiName parametr odpowiadający za imie skoczka
     * @param SkiSurname parametr przechowujący informacje o nazwisku skoczna
     * @param recordLength parametr odpowiadający za wielkość rekordu
     * @param recordDate parametr przechowujący date rekordu
     * @param recordType parametr przechwujący typ rekordu
     * @param trainerName parametr odpowiadający za imie trenera
     * @param trainerSurname parametr odpowiadający za nazwisko trenera
     * @param hillName parametr przechowujący nazwe skoczni
     * @param hillLength parametr przechowujący wielkość skoczni
     * @param hillKPoint parametr przechowujący punkt K skoczni
     */
    public RecordsView(int id, String SkiName, String SkiSurname, float recordLength, String recordDate, String recordType, String trainerName, String trainerSurname, String hillName, float hillLength, float hillKPoint) {
        this.id = id;
        this.SkiName = SkiName;
        this.SkiSurname = SkiSurname;
        this.recordLength = recordLength;
        this.recordDate = recordDate;
        this.recordType = recordType;
        this.trainerName = trainerName;
        this.trainerSurname = trainerSurname;
        this.hillName = hillName;
        this.hillLength = hillLength;
        this.hillKPoint = hillKPoint;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSkiName(String SkiName) {
        this.SkiName = SkiName;
    }

    public void setSkiSurname(String SkiSurname) {
        this.SkiSurname = SkiSurname;
    }

    public void setRecordLength(float recordLength) {
        this.recordLength = recordLength;
    }

    public void setRecordDate(String recordDate) {
        this.recordDate = recordDate;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public void setTrainerSurname(String trainerSurname) {
        this.trainerSurname = trainerSurname;
    }

    public void setHillName(String hillName) {
        this.hillName = hillName;
    }

    public void setHillLength(float hillLength) {
        this.hillLength = hillLength;
    }

    public void setHillKPoint(float hillKPoint) {
        this.hillKPoint = hillKPoint;
    }

    public int getId() {
        return id;
    }

    public String getSkiName() {
        return SkiName;
    }

    public String getSkiSurname() {
        return SkiSurname;
    }

    public float getRecordLength() {
        return recordLength;
    }

    public String getRecordDate() {
        return recordDate;
    }

    public String getRecordType() {
        return recordType;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public String getTrainerSurname() {
        return trainerSurname;
    }

    public String getHillName() {
        return hillName;
    }

    public float getHillLength() {
        return hillLength;
    }

    public float getHillKPoint() {
        return hillKPoint;
    }

    @Override
    public String toString() {
        return "RecordsView{" + "id=" + id + ", SkiName=" + SkiName + ", SkiSurname=" + SkiSurname + ", recordLength=" + recordLength + ", recordDate=" + recordDate + ", recordType=" + recordType + ", trainerName=" + trainerName + ", trainerSurname=" + trainerSurname + ", hillName=" + hillName + ", hillLength=" + hillLength + ", hillKPoint=" + hillKPoint + '}';
    }

}
