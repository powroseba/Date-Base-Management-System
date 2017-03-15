/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Methods;

import UI.FXMLDocumentController;

/**
 * Klasa posiadająca metody do zarządzania różnymi komponentami widocznymi w
 * oknie Hill
 *
 * @author seba
 */
public class HillComponentMethods {

    /**
     * Metoda czyszcząca zawartość pól
     *
     * @param aThis pobiera komponenty znajdujące sie w oknie Hill
     */
    public static void ClearHillFields(FXMLDocumentController aThis) {
        aThis.Hill_LengthField.clear();
        aThis.Hill_ID.clear();
        aThis.Hill_KPointField.clear();
        aThis.Hill_CityField.clear();
        aThis.Hill_NameField.clear();
        if (aThis.Hill_Update.isSelected()) {
            aThis.Hill_LengthUpdateField.clear();
            aThis.Hill_IDUpdate.clear();
            aThis.Hill_UpdateCityField.clear();
            aThis.Hill_KPointUpdateField.clear();
            aThis.Hill_NameUpdateField.clear();
        }
    }

    /**
     * Metoda ukazująca dodatkowe okna niezbędne do wykonania operacji na bazie
     * danych
     *
     * @param aThis pobiera komponenty znajdujące sie w oknie Hill
     */
    public static void ShowUpdatePaneHill(FXMLDocumentController aThis) {
        aThis.Hill_UpdateLabel.setVisible(true);
        aThis.Hill_Table.setMaxHeight(249);
        aThis.Hill_Table.setLayoutY(70);
        aThis.Hill_UpdatePane.setVisible(true);
        aThis.Hill_LengthUpdateField.setVisible(true);
        aThis.Hill_DatePickerUpdate.setVisible(true);
        aThis.Hill_UpdateCityField.setVisible(true);
        aThis.Hill_CityUpdateLabel.setVisible(true);
        aThis.Hill_IDUpdate.setVisible(true);
        aThis.Hill_KPointUpdateField.setVisible(true);
        aThis.Hill_NameUpdateField.setVisible(true);
        aThis.Hill_NameUpdateLabel.setVisible(true);
        aThis.Hill_KPointUpdateLabel.setVisible(true);
        aThis.Hill_IdUpdateLabel.setVisible(true);
        aThis.Hill_DateUpdateLabel.setVisible(true);
        aThis.Hill_LengthUpdateLabel.setVisible(true);
        aThis.Hill_UpdateLabel.setVisible(true);
    }

    /**
     * Metoda chowająca niepotrzebne okna w scenie Hill
     *
     * @param aThis pobiera komponenty znajdujące sie w oknie Hill
     */
    public static void HideUpdatePaneHill(FXMLDocumentController aThis) {
        aThis.Hill_UpdateLabel.setVisible(false);
        aThis.Hill_Table.setMaxHeight(319);
        aThis.Hill_Table.setLayoutY(0);
        aThis.Hill_UpdatePane.setVisible(false);
        aThis.Hill_LengthUpdateField.setVisible(false);
        aThis.Hill_DatePickerUpdate.setVisible(false);
        aThis.Hill_IDUpdate.setVisible(false);
        aThis.Hill_KPointUpdateField.setVisible(false);
        aThis.Hill_NameUpdateField.setVisible(false);
        aThis.Hill_UpdateCityField.setVisible(false);
        aThis.Hill_CityUpdateLabel.setVisible(false);
        aThis.Hill_NameUpdateLabel.setVisible(false);
        aThis.Hill_KPointUpdateLabel.setVisible(false);
        aThis.Hill_IdUpdateLabel.setVisible(false);
        aThis.Hill_DateUpdateLabel.setVisible(false);
        aThis.Hill_LengthUpdateLabel.setVisible(false);
        aThis.Hill_UpdateLabel.setVisible(false);
    }

    /**
     * Metoda blokująca okna
     *
     * @param aThis pobiera komponenty znajdujące sie w oknie Hill
     */
    public static void DisableComponentsToDelete(FXMLDocumentController aThis) {;
        aThis.Hill_NameField.setDisable(true);
        aThis.Hill_KPointField.setDisable(true);
        aThis.Hill_LengthField.setDisable(true);
        aThis.Hill_DatePicker.setDisable(true);
        aThis.Hill_CityField.setDisable(true);
    }

    /**
     * Metoda odblokowująca okna
     *
     * @param aThis pobiera komponenty znajdujące sie w oknie Hill
     */
    public static void EnableComponentsToDelete(FXMLDocumentController aThis) {
        aThis.Hill_NameField.setDisable(false);
        aThis.Hill_KPointField.setDisable(false);
        aThis.Hill_LengthField.setDisable(false);
        aThis.Hill_DatePicker.setDisable(false);
        aThis.Hill_CityField.setDisable(false);
    }
}
