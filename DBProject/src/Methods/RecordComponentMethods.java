/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Methods;

import UI.FXMLDocumentController;

/**
 * Klasa posiadająca metody do zarządzania różnymi komponentami widocznymi w
 * oknie Record
 *
 * @author seba
 */
public class RecordComponentMethods {

    /**
     * Metoda czyszcząca zawartość pól
     *
     * @param aThis pobiera komponenty znajdujące sie w oknie Record
     */
    public static void ClearRecordsFields(FXMLDocumentController aThis) {
        aThis.Records_HillIDField.clear();
        aThis.Records_LengthField.clear();
        aThis.Records_IdField.clear();
        aThis.Records_TrainerIDField.clear();
        aThis.Records_TypeField.clear();
        aThis.Records_SkiJumperIdField.clear();
        if (aThis.Records_Update.isSelected()) {
            aThis.Records_IdUpdateField.clear();
            aThis.Records_SkiJumperIdUpdateField.clear();
            aThis.Records_LengthUpdateField.clear();
            aThis.Records_TrainerIDUpdateField.clear();
            aThis.Records_HillIDUpdateField.clear();
            aThis.Records_TypeUpdateField.clear();
        }
    }

    /**
     * Metoda ukazująca dodatkowe okna niezbędne do wykonania operacji na bazie
     * danych
     *
     * @param aThis pobiera komponenty znajdujące sie w oknie Record
     */
    public static void ShowUpdatePaneRecords(FXMLDocumentController aThis) {
        aThis.Records_UpdateLabel.setVisible(true);
        aThis.Records_Table.setMaxHeight(249);
        aThis.Records_Table.setLayoutY(70);
        aThis.Records_UpdatePane.setVisible(true);
        aThis.Records_IdUpdateField.setVisible(true);
        aThis.Records_SkiJumperIdUpdateField.setVisible(true);
        aThis.Records_LengthUpdateField.setVisible(true);
        aThis.Records_TrainerIDUpdateField.setVisible(true);
        aThis.Records_HillIDUpdateField.setVisible(true);
        aThis.Records_TypeUpdateField.setVisible(true);
        aThis.Records_IdUpdateLabel.setVisible(true);
        aThis.Records_SkiJumperIdLabel1.setVisible(true);
        aThis.Records_LengthUpdateLabel.setVisible(true);
        aThis.Records_TrainerIDUpdateLabel.setVisible(true);
        aThis.Records_HillIDUpdateLabel.setVisible(true);
        aThis.Records_TypeUpdateLabel.setVisible(true);
        aThis.Records_UpdateLabel.setVisible(true);
        aThis.Records_UpdateDateLabel.setVisible(true);
        aThis.Records_UpdateDatePicker.setVisible(true);
    }

    /**
     * Metoda chowająca niepotrzebne okna w scenie Hill
     *
     * @param aThis pobiera komponenty znajdujące sie w oknie Record
     */
    public static void HideUpdatePaneRecords(FXMLDocumentController aThis) {
        aThis.Records_UpdateLabel.setVisible(false);
        aThis.Records_Table.setMaxHeight(319);
        aThis.Records_Table.setLayoutY(0);
        aThis.Records_UpdatePane.setVisible(false);
        aThis.Records_IdUpdateField.setVisible(false);
        aThis.Records_SkiJumperIdUpdateField.setVisible(false);
        aThis.Records_LengthUpdateField.setVisible(false);
        aThis.Records_TrainerIDUpdateField.setVisible(false);
        aThis.Records_HillIDUpdateField.setVisible(false);
        aThis.Records_TypeUpdateField.setVisible(false);
        aThis.Records_IdUpdateLabel.setVisible(false);
        aThis.Records_SkiJumperIdLabel1.setVisible(false);
        aThis.Records_LengthUpdateLabel.setVisible(false);
        aThis.Records_TrainerIDUpdateLabel.setVisible(false);
        aThis.Records_HillIDUpdateLabel.setVisible(false);
        aThis.Records_TypeUpdateLabel.setVisible(false);
        aThis.Records_UpdateLabel.setVisible(false);
        aThis.Records_UpdateDateLabel.setVisible(false);
        aThis.Records_UpdateDatePicker.setVisible(false);
    }

    /**
     * Metoda blokująca okna
     *
     * @param aThis pobiera komponenty znajdujące sie w oknie Record
     */
    public static void DisableComponentsToDelete(FXMLDocumentController aThis) {
        aThis.Records_SkiJumperIdField.setDisable(true);
        aThis.Records_LengthField.setDisable(true);
        aThis.Records_DatePicker.setDisable(true);
        aThis.Records_TrainerIDField.setDisable(true);
        aThis.Records_HillIDField.setDisable(true);
        aThis.Records_TypeField.setDisable(true);
    }

    /**
     * Metoda odblokowująca okna
     *
     * @param aThis pobiera komponenty znajdujące sie w oknie Record
     */
    public static void EnableComponentsToDelete(FXMLDocumentController aThis) {
        aThis.Records_SkiJumperIdField.setDisable(false);
        aThis.Records_LengthField.setDisable(false);
        aThis.Records_DatePicker.setDisable(false);
        aThis.Records_TrainerIDField.setDisable(false);
        aThis.Records_HillIDField.setDisable(false);
        aThis.Records_TypeField.setDisable(false);
    }
}
