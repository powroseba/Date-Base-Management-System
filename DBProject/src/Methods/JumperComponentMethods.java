/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Methods;

import UI.FXMLDocumentController;

/**
 * Klasa posiadająca metody do zarządzania różnymi komponentami widocznymi w
 * oknie Jumper
 *
 * @author seba
 */
public class JumperComponentMethods {

    /**
     * Metoda czyszcząca zawartość pól
     *
     * @param aThis pobiera komponenty znajdujące sie w oknie Jumper
     */
    public static void ClearJumperFields(FXMLDocumentController aThis) {
        aThis.Jumper_IdField.clear();
        aThis.Jumper_DatePicker.setPromptText(null);
        aThis.Jumper_NameField.clear();
        aThis.Jumper_NationalityField.clear();
        aThis.Jumper_SurnameField.clear();
        if (aThis.Jumper_Update.isSelected()) {
            aThis.Jumper_IdUpdateField.clear();
            aThis.Jumper_NameUpdateField.clear();
            aThis.Jumper_SurnameUpdateField.clear();
            aThis.Jumper_NationalityUpdateField.clear();
        }
    }

    /**
     * Metoda ukazująca dodatkowe okna niezbędne do wykonania operacji na bazie
     * danych
     *
     * @param aThis pobiera komponenty znajdujące sie w oknie Jumper
     */
    public static void ShowUpdatePaneJumper(FXMLDocumentController aThis) {
        aThis.Jumper_UpdateLabel.setVisible(true);
        aThis.Jumper_Table.setMaxHeight(249);
        aThis.Jumper_Table.setLayoutY(70);
        aThis.Jumper_UpdatePane.setVisible(true);
        aThis.Jumper_IdUpdateField.setVisible(true);
        aThis.Jumper_NameUpdateField.setVisible(true);
        aThis.Jumper_SurnameUpdateField.setVisible(true);
        aThis.Jumper_DateUpdatePicker.setVisible(true);
        aThis.Jumper_NationalityUpdateField.setVisible(true);
        aThis.Jumper_NationalityUpdateLabel.setVisible(true);
        aThis.Jumper_IdUpdateLabel.setVisible(true);
        aThis.Jumper_NameUpdateLabel.setVisible(true);
        aThis.Jumper_SurnameUpdateLabel.setVisible(true);
        aThis.Jumper_DateUpdateLabel.setVisible(true);
    }

    /**
     * Metoda chowająca niepotrzebne okna w scenie Hill
     *
     * @param aThis pobiera komponenty znajdujące sie w oknie Jumper
     */
    public static void HideUpdatePaneJumper(FXMLDocumentController aThis) {
        aThis.Jumper_UpdateLabel.setVisible(false);
        aThis.Jumper_Table.setMaxHeight(319);
        aThis.Jumper_Table.setLayoutY(0);
        aThis.Jumper_IdUpdateField.setVisible(false);
        aThis.Jumper_NameUpdateField.setVisible(false);
        aThis.Jumper_SurnameUpdateField.setVisible(false);
        aThis.Jumper_DateUpdatePicker.setVisible(false);
        aThis.Jumper_NationalityUpdateField.setVisible(false);
        aThis.Jumper_NationalityUpdateLabel.setVisible(false);
        aThis.Jumper_IdUpdateLabel.setVisible(false);
        aThis.Jumper_NameUpdateLabel.setVisible(false);
        aThis.Jumper_SurnameUpdateLabel.setVisible(false);
        aThis.Jumper_DateUpdateLabel.setVisible(false);
    }

    /**
     * Metoda blokująca okna
     *
     * @param aThis pobiera komponenty znajdujące sie w oknie Jumper
     */
    public static void DisableComponentsToDelete(FXMLDocumentController aThis) {
        aThis.Jumper_DatePicker.setDisable(true);
        aThis.Jumper_NameField.setDisable(true);
        aThis.Jumper_SurnameField.setDisable(true);
        aThis.Jumper_NationalityField.setDisable(true);
    }

    /**
     * Metoda odblokowująca okna
     *
     * @param aThis pobiera komponenty znajdujące sie w oknie Jumper
     */
    public static void EnableComponentsToDelete(FXMLDocumentController aThis) {
        aThis.Jumper_DatePicker.setDisable(false);
        aThis.Jumper_NameField.setDisable(false);
        aThis.Jumper_SurnameField.setDisable(false);
        aThis.Jumper_NationalityField.setDisable(false);
    }
}
