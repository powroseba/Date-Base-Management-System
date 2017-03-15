/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Methods;

import UI.FXMLDocumentController;

/**
 * Klasa posiadająca metody do zarządzania różnymi komponentami widocznymi w
 * oknie Trainer
 *
 * @author seba
 */
public class TrainerComponentMethods {

    /**
     * Metoda czyszcząca zawartość pól
     *
     * @param aThis pobiera komponenty znajdujące sie w oknie Trainer
     */
    public static void ClearTrainerFields(FXMLDocumentController aThis) {
        aThis.Trainer_IdField.clear();
        aThis.Trainer_DatePicker.setPromptText(null);
        aThis.Trainer_NameField.clear();
        aThis.Trainer_NationalityField.clear();
        aThis.Trainer_SurnameField.clear();
        if (aThis.Trainer_Update.isSelected()) {
            aThis.Trainer_IdUpdateField.clear();
            aThis.Trainer_NameUpdateField.clear();
            aThis.Trainer_SurnameUpdateField.clear();
            //PD_DateUpdatePicker.clear();
            aThis.Trainer_NationalityUpdateField.clear();
        }
    }

    /**
     * Metoda ukazująca dodatkowe okna niezbędne do wykonania operacji na bazie
     * danych
     *
     * @param aThis pobiera komponenty znajdujące sie w oknie Trainer
     */
    public static void ShowUpdatePaneTrainer(FXMLDocumentController aThis) {
        aThis.Trainer_UpdateLabel.setVisible(true);
        aThis.Trainer_Table.setMaxHeight(249);
        aThis.Trainer_Table.setLayoutY(70);
        aThis.Trainer_UpdatePane.setVisible(true);
        aThis.Trainer_IdUpdateField.setVisible(true);
        aThis.Trainer_NameUpdateField.setVisible(true);
        aThis.Trainer_SurnameUpdateField.setVisible(true);
        aThis.Trainer_DateUpdatePicker.setVisible(true);
        aThis.Trainer_NationalityUpdateField.setVisible(true);
        aThis.Trainer_NationalityUpdateLabel.setVisible(true);
        aThis.Trainer_IdUpdateLabel.setVisible(true);
        aThis.Trainer_NameUpdateLabel.setVisible(true);
        aThis.Trainer_SurnameUpdateLabel.setVisible(true);
        aThis.Trainer_DateUpdateLabel.setVisible(true);
    }

    /**
     * Metoda chowająca niepotrzebne okna w scenie Hill
     *
     * @param aThis pobiera komponenty znajdujące sie w oknie Trainer
     */
    public static void HideUpdatePaneTrainer(FXMLDocumentController aThis) {
        aThis.Trainer_UpdateLabel.setVisible(false);
        aThis.Trainer_Table.setMaxHeight(319);
        aThis.Trainer_Table.setLayoutY(0);
        aThis.Trainer_IdUpdateField.setVisible(false);
        aThis.Trainer_NameUpdateField.setVisible(false);
        aThis.Trainer_SurnameUpdateField.setVisible(false);
        aThis.Trainer_DateUpdatePicker.setVisible(false);
        aThis.Trainer_NationalityUpdateField.setVisible(false);
        aThis.Trainer_NationalityUpdateLabel.setVisible(false);
        aThis.Trainer_IdUpdateLabel.setVisible(false);
        aThis.Trainer_NameUpdateLabel.setVisible(false);
        aThis.Trainer_SurnameUpdateLabel.setVisible(false);
        aThis.Trainer_DateUpdateLabel.setVisible(false);
    }

    /**
     * Metoda blokująca okna
     *
     * @param aThis pobiera komponenty znajdujące sie w oknie Trainer
     */
    public static void DisableComponentsToDelete(FXMLDocumentController aThis) {
        aThis.Trainer_NameField.setDisable(true);
        aThis.Trainer_SurnameField.setDisable(true);
        aThis.Trainer_NationalityField.setDisable(true);
        aThis.Trainer_DatePicker.setDisable(true);
    }

    /**
     * Metoda odblokowująca okna
     *
     * @param aThis pobiera komponenty znajdujące sie w oknie Trainer
     */
    public static void EnableComponentsToDelete(FXMLDocumentController aThis) {
        aThis.Trainer_NameField.setDisable(false);
        aThis.Trainer_SurnameField.setDisable(false);
        aThis.Trainer_NationalityField.setDisable(false);
        aThis.Trainer_DatePicker.setDisable(false);
    }
}
