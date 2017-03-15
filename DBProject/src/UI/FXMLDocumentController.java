/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import DB.DBSkiJumpers;
import static DB.DBSkiJumpers.stat;
import DBMethods.DBHillMethods;
import DBMethods.DBJumperMethods;
import DBMethods.DBTrainerMethods;
import DBMethods.DBRecordMethods;
import Tables.Hill;
import Tables.Records;
import Tables.RecordsView;
import Tables.Skijumper;
import Tables.Trainer;
import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

/**
 * Klasa będąca centrum generowania i zarządzania komponentami znajdującymi sie
 * w oknie
 *
 * @version Records 1.1
 * @author seba
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label PD_DateLabel;
    @FXML
    private ToggleGroup grupa1;
    @FXML
    private Label Records_IdLabel;
    @FXML
    private Label Records_SkiJumperIdLabel;
    @FXML
    private Label Records_LengthLabel;
    @FXML
    private Label Records_TrainerIDLabel;
    @FXML
    private Label Records_HillIDLabel;
    @FXML
    private Label Records_TypeLabel;
    @FXML
    private ToggleGroup grupa2;
    @FXML
    private Label Hill_IdLabel;
    @FXML
    private Label Hill_NameLabel;
    @FXML
    private Label Hill_KPointLabel;
    @FXML
    private Label PD_DateLabel1;
    @FXML
    private Label Hill_LengthLabel;
    @FXML
    private Label Hill_DateLabel;
    @FXML
    private ToggleGroup grupa3;
    @FXML
    private Label Jumper_IdLabel;
    @FXML
    private Label Jumper_NameLabel;
    @FXML
    private Label Jumper_SurnameLabel;
    @FXML
    private Label Jumper_NationalityLabel;
    @FXML
    private Label Jumper_DateLabel;
    @FXML
    private Label Trainer_IdLabel;
    @FXML
    private Label Trainer_NameLabel;
    @FXML
    private Label Trainer_SurnameLabel;
    @FXML
    private Label Trainer_NationalityLabel;
    @FXML
    private Label Trainer_DateLabel;
    @FXML
    private ToggleGroup grupa4;
    @FXML
    private Label Records_DateLabel;


    /**
     * Konstruktor domyślny
     */
    public FXMLDocumentController() {
    }
    /**
     * Obiekt klasy tworzącej połączenie z baza danych w celu
     */
    public static DBSkiJumpers dateBase = new DBSkiJumpers();
//Wszystkie komponenty w oknach
    //Konsole
    @FXML
    public TextArea SystemMessages;
    @FXML
    private Label DBDiodeOn;
    @FXML
    private Label DBDiodeOff;

    //Tab
    @FXML
    public Tab Jumper_Data;
    @FXML
    public Tab Trainer_Data;
    @FXML
    public Tab Records;
    @FXML
    public Tab Hill;
    //Menu -> File
    @FXML
    private MenuItem MenuConnect;
    @FXML
    private MenuItem MenuXML;
    @FXML
    private MenuItem MenuDisconnect;
    @FXML
    private MenuItem MenuClose;
    //Menu -> Edit
    @FXML
    private MenuItem MenuClear;
    //Menu -> About
    @FXML
    private MenuItem MenuDoc;
    @FXML
    private MenuItem Menu_Guide;
    @FXML
    private MenuItem MenuAbout;
    @FXML
    private ContextMenu JumperContext_Menu;
    @FXML
    private MenuItem JumperContext_Delete;
    @FXML
    private MenuItem JumperContext_Clear;
    @FXML
    private ContextMenu TrainerContext_Menu;
    @FXML
    private MenuItem TrainerContext_Delete;
    @FXML
    private MenuItem TrainerContext_Clear;
    @FXML
    private ContextMenu RecordsContext_Menu;
    @FXML
    private MenuItem RecordsContext_Delete;
    @FXML
    private MenuItem RecordsContext_Clear;
    @FXML
    private Label Hill_CityLabel;
    @FXML
    private ContextMenu HillContext_Menu;
    @FXML
    private MenuItem HillContext_Delete;
    @FXML
    private MenuItem HillContext_Clear;

    //Jumper Window
    //Fields
    @FXML
    public TextField Jumper_IdField;
    @FXML
    public TextField Jumper_NameField;
    @FXML
    public TextField Jumper_SurnameField;
    @FXML
    public DatePicker Jumper_DatePicker;
    @FXML
    public TextField Jumper_NationalityField;
    //RadioButtons
    @FXML
    private RadioButton Jumper_Insert;
    @FXML
    private RadioButton Jumper_Remove;
    @FXML
    public RadioButton Jumper_Update;
    @FXML
    public Pane Jumper_UpdatePane;
    //Update Fields
    @FXML
    public TextField Jumper_IdUpdateField;
    @FXML
    public TextField Jumper_NameUpdateField;
    @FXML
    public TextField Jumper_SurnameUpdateField;
    @FXML
    public DatePicker Jumper_DateUpdatePicker;
    @FXML
    public TextField Jumper_NationalityUpdateField;
    @FXML
    public Label Jumper_NationalityUpdateLabel;
    @FXML
    public Label Jumper_IdUpdateLabel;
    @FXML
    public Label Jumper_NameUpdateLabel;
    @FXML
    public Label Jumper_SurnameUpdateLabel;
    @FXML
    public Label Jumper_DateUpdateLabel;
    @FXML
    public Label Jumper_UpdateLabel;
    @FXML
    public RadioButton Jumper_Show;
    //Buttons
    @FXML
    private Button Jumper_Submit;
    @FXML
    private Button Jumper_Clear;

    //Table
    @FXML
    public TableView<Skijumper> Jumper_Table;

    //Trainer Window
    //Fields
    @FXML
    public TextField Trainer_IdField;
    @FXML
    public TextField Trainer_NameField;
    @FXML
    public TextField Trainer_SurnameField;
    @FXML
    public DatePicker Trainer_DatePicker;
    @FXML
    public TextField Trainer_NationalityField;
    //RadioButtons
    @FXML
    private RadioButton Trainer_Insert;
    @FXML
    private RadioButton Trainer_Remove;
    @FXML
    public RadioButton Trainer_Update;
    @FXML
    public Pane Trainer_UpdatePane;
    //Update Fields
    @FXML
    public TextField Trainer_IdUpdateField;
    @FXML
    public TextField Trainer_NameUpdateField;
    @FXML
    public TextField Trainer_SurnameUpdateField;
    @FXML
    public DatePicker Trainer_DateUpdatePicker;
    @FXML
    public TextField Trainer_NationalityUpdateField;
    @FXML
    public Label Trainer_NationalityUpdateLabel;
    @FXML
    public Label Trainer_IdUpdateLabel;
    @FXML
    public Label Trainer_NameUpdateLabel;
    @FXML
    public Label Trainer_SurnameUpdateLabel;
    @FXML
    public Label Trainer_DateUpdateLabel;
    @FXML
    public Label Trainer_UpdateLabel;
    @FXML
    public RadioButton Trainer_Show;
    //Buttons
    @FXML
    private Button Trainer_Submit;
    @FXML
    private Button Trainer_Clear;

    //Table
    @FXML
    public TableView Trainer_Table;

    //Records Window
    //Fields
    @FXML
    public TextField Records_IdField;
    @FXML
    public TextField Records_SkiJumperIdField;
    @FXML
    public TextField Records_LengthField;
    @FXML
    public TextField Records_TrainerIDField;
    @FXML
    public TextField Records_HillIDField;
    @FXML
    public TextField Records_TypeField;
    @FXML
    public DatePicker Records_DatePicker;
    //RadioButtons
    @FXML
    private RadioButton Records_Insert;
    @FXML
    private RadioButton Records_Remove;
    @FXML
    public RadioButton Records_Update;
    @FXML
    public Pane Records_UpdatePane;
    //Update Fields
    @FXML
    public TextField Records_IdUpdateField;
    @FXML
    public TextField Records_SkiJumperIdUpdateField;
    @FXML
    public TextField Records_LengthUpdateField;
    @FXML
    public TextField Records_TrainerIDUpdateField;
    @FXML
    public TextField Records_HillIDUpdateField;
    @FXML
    public TextField Records_TypeUpdateField;
    @FXML
    public DatePicker Records_UpdateDatePicker;
    @FXML
    public Label Records_IdUpdateLabel;
    @FXML
    public Label Records_SkiJumperIdLabel1;
    @FXML
    public Label Records_LengthUpdateLabel;
    @FXML
    public Label Records_TrainerIDUpdateLabel;
    @FXML
    public Label Records_HillIDUpdateLabel;
    @FXML
    public Label Records_TypeUpdateLabel;
    @FXML
    public Label Records_UpdateLabel;
    @FXML
    public Label Records_UpdateDateLabel;
    @FXML
    public RadioButton Records_ShowData;
    //Buttons
    @FXML
    private Button Records_Submit;
    @FXML
    private Button Records_Clear;

    //Table
    @FXML
    public TableView Records_Table;

    //Hill Window
    //Fields
    @FXML
    public TextField Hill_ID;
    @FXML
    public TextField Hill_NameField;
    @FXML
    public TextField Hill_KPointField;
    @FXML
    public TextField Hill_CityField;
    @FXML
    public TextField Hill_LengthField;
    @FXML
    public DatePicker Hill_DatePicker;
    //RadioButtons
    @FXML
    private RadioButton Hill_Insert;
    @FXML
    private RadioButton Hill_Remove;
    @FXML
    public RadioButton Hill_Update;
    @FXML
    public Pane Hill_UpdatePane;
    //Update Fields
    @FXML
    public TextField Hill_IDUpdate;
    @FXML
    public TextField Hill_NameUpdateField;
    @FXML
    public TextField Hill_KPointUpdateField;
    @FXML
    public TextField Hill_UpdateCityField;
    @FXML
    public TextField Hill_LengthUpdateField;
    @FXML
    public DatePicker Hill_DatePickerUpdate;
    @FXML
    public Label Hill_IdUpdateLabel;
    @FXML
    public Label Hill_NameUpdateLabel;
    @FXML
    public Label Hill_KPointUpdateLabel;
    @FXML
    public Label Hill_CityUpdateLabel;
    @FXML
    public Label Hill_LengthUpdateLabel;
    @FXML
    public Label Hill_DateUpdateLabel;
    @FXML
    public Label Hill_UpdateLabel;
    @FXML
    public RadioButton Hill_ShowData;
    //Buttons
    @FXML
    private Button Hill_Submit;
    @FXML
    private Button Hill_Clear;

    //Table
    @FXML
    public TableView Hill_Table;

    
    @FXML
    /**
     * Metoda wykonująca usuwanie z bazy obiektow zaznaczonych w tabelce
     */
    public void deleteFromContext() {
        JumperContext_Delete.setOnAction(event -> {
            if (!Jumper_Table.getSelectionModel().isEmpty()) {
                dateBase.wykonajZapytanie(this, DBJumperMethods.deleteJumper(new StringBuilder(Jumper_Table.getSelectionModel().getSelectedItems().toString().split(",")[0]).deleteCharAt(0).toString()));
                Jumper_Show.setSelected(true);
                dateBase.wykonajZapytanie(this, DBJumperMethods.selectJumper());
            }
        });
        TrainerContext_Delete.setOnAction(event -> {
            if (!Trainer_Table.getSelectionModel().isEmpty()) {
                dateBase.wykonajZapytanie(this, DBTrainerMethods.deleteTrainer(new StringBuilder(Trainer_Table.getSelectionModel().getSelectedItems().toString().split(",")[0]).deleteCharAt(0).toString()));
                Trainer_Show.setSelected(true);
                dateBase.wykonajZapytanie(this, DBTrainerMethods.selectTrainer());
            }
        });
        RecordsContext_Delete.setOnAction(event -> {
            if (!Records_Table.getSelectionModel().isEmpty()) {
                int id = DBRecordMethods.getSelectedID(Records_Table.getSelectionModel().getSelectedItems().toString());
                dateBase.wykonajZapytanie(this, DBRecordMethods.deleteRecordWhereId(id));
                Records_ShowData.setSelected(true);
                dateBase.wykonajZapytanie(this, DBRecordMethods.selectRecords());
            }});
        HillContext_Delete.setOnAction(event -> {
            if (!Hill_Table.getSelectionModel().isEmpty()) {
                dateBase.wykonajZapytanie(this, DBHillMethods.deleteHill(new StringBuilder(Hill_Table.getSelectionModel().getSelectedItems().toString().split(",")[0]).deleteCharAt(0).toString()));
                Hill_ShowData.setSelected(true);
                dateBase.wykonajZapytanie(this, DBHillMethods.selectHill());
            }
        });
    }

    @FXML
    /**
     * Metoda czyszczaca okno tabel
     */
    public void clearTables() {
        JumperContext_Clear.setOnAction(event -> {
            if (!Jumper_Table.getSelectionModel().isEmpty()) {
                Jumper_Table.getColumns().clear();
                dateBase.SList.clear();
                Jumper_Table.setItems(dateBase.SList);
                Jumper_Table.getColumns().addAll();
            }
        });
        TrainerContext_Clear.setOnAction(event -> {
            if (!Trainer_Table.getSelectionModel().isEmpty()) {
                Trainer_Table.getColumns().clear();
                dateBase.TList.clear();
                Trainer_Table.setItems(dateBase.TList);
                Trainer_Table.getColumns().addAll();
            }
        });
        HillContext_Clear.setOnAction(event -> {
            if (!Hill_Table.getSelectionModel().isEmpty()) {
                Hill_Table.getColumns().clear();
                dateBase.HList.clear();
                Hill_Table.setItems(dateBase.HList);
                Hill_Table.getColumns().addAll();
            }
        });
        RecordsContext_Clear.setOnAction(event -> {
            if (!Records_Table.getSelectionModel().isEmpty()) {
                Records_Table.getColumns().clear();
                dateBase.RVList.clear();
                Records_Table.setItems(dateBase.RVList);
                Records_Table.getColumns().addAll();
            }
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SystemMessages.setEditable(false);
        MenuDisconnect.setDisable(true);
        MenuConnect.setOnAction(event -> {
            if (dateBase.connectDataBase(this) == true) {
                MenuConnect.setDisable(true);
            }
            MenuDisconnect.setDisable(false);
            DBDiodeOn.setVisible(true);
            DBDiodeOff.setVisible(false);
            MenuXML.setDisable(false);
        });
        MenuDisconnect.setOnAction(event -> {
            if (dateBase.closeConnection(this)) {
                MenuConnect.setDisable(false);
            }
            MenuDisconnect.setDisable(true);
            DBDiodeOn.setVisible(false);
            DBDiodeOff.setVisible(true);
            MenuXML.setDisable(true);
        });
        MenuClose.setOnAction(event -> {
            if (DBSkiJumpers.connectionStatus == true) {
                dateBase.closeConnection(this);
            }
            System.exit(0);
        });
        MenuAbout.setOnAction(event -> {
            SebaUI.anotherStage.show();
        });

        MenuDoc.setOnAction(event -> {
            File file = new File(".\\dist\\javadoc\\index.html");
            Desktop desktop = Desktop.getDesktop();
            if (file.exists()) {
                try {
                    desktop.open(file);
                } catch (IOException ex) {
                    SystemMessages.appendText("");
                }
            }
        });
    Menu_Guide.setOnAction (event  
        -> {
            File myFile = new File(".\\UserGuide.pdf");
        try {
            System.out.println(myFile.getCanonicalPath());
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Desktop.getDesktop().open(myFile);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    );
    MenuClear.setOnAction (event  
        -> {
            if (Jumper_Data.isSelected()) {
            Methods.JumperComponentMethods.ClearJumperFields(this);
        }
        if (Trainer_Data.isSelected()) {
            Methods.TrainerComponentMethods.ClearTrainerFields(this);
        }
        if (Records.isSelected()) {
            Methods.RecordComponentMethods.ClearRecordsFields(this);
        }
        if (Hill.isSelected()) {
            Methods.HillComponentMethods.ClearHillFields(this);
        }

    }

    );
    MenuXML.setOnAction (event  
        -> {

            FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("XML(*.xml)", "*.xml"));
        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            Import.ParserXML.loadDataFromXML(selectedFile);
            if(Import.ParserXML.powodzenie)
                SystemMessages.appendText(DBSkiJumpers.czas + "Parsowanie przebieglo pomyslnie\n");
            else{
                SystemMessages.appendText(DBSkiJumpers.czas + "ERROR: Parsowanie nie powiodlo sie!\n");
            }
        }

    }

    );
        //Jumper DATA

    Jumper_Table.setOnMouseClicked (event  
        -> {
            StringBuilder toObject = new StringBuilder(Jumper_Table.getSelectionModel().getSelectedItems().toString());
        Skijumper jumper = DBJumperMethods.updateSetContentToField(toObject);
        Jumper_IdField.setText(jumper.getStringId());
        Jumper_NameField.setText(jumper.getName());
        Jumper_SurnameField.setText(jumper.getSurname());
        LocalDate myDate = LocalDate.of(Integer.parseInt(jumper.getDateOfBirth().substring(0, 4)),
                Integer.parseInt(jumper.getDateOfBirth().substring(5, 7)),
                Integer.parseInt(jumper.getDateOfBirth().substring(8, 10)));
        Jumper_DatePicker.setValue(myDate);

        Jumper_NationalityField.setText(jumper.getCountry());
    }

    );
    Jumper_Clear.setOnAction (event 

    -> Methods.JumperComponentMethods.ClearJumperFields(this));

    Jumper_Update.setOnAction (event  -> {;
        Methods.JumperComponentMethods.ShowUpdatePaneJumper(this);
        Methods.JumperComponentMethods.DisableComponentsToDelete(this);

    }

    );

    Jumper_Insert.setOnAction (event  
        -> {
            Methods.JumperComponentMethods.HideUpdatePaneJumper(this);
        Methods.JumperComponentMethods.EnableComponentsToDelete(this);
    }

    );

    Jumper_Remove.setOnAction (event  
        -> {
            Methods.JumperComponentMethods.HideUpdatePaneJumper(this);
        Methods.JumperComponentMethods.DisableComponentsToDelete(this);
    }

    );

    Jumper_Show.setOnAction (event  
        -> {
            Methods.JumperComponentMethods.HideUpdatePaneJumper(this);
        Methods.JumperComponentMethods.EnableComponentsToDelete(this);
    }

    );

    Jumper_Submit.setOnAction (event  
        -> {
            if (Jumper_Show.isSelected() && DBSkiJumpers.connectionStatus == true) {
            dateBase.wykonajZapytanie(this, DBJumperMethods.selectJumper());

            TableColumn<Skijumper, Integer> idColumn = new TableColumn<>("ID");
            idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

            TableColumn<Skijumper, String> nameColumn = new TableColumn<>("Name");
            nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

            TableColumn<Skijumper, String> surnameColumn = new TableColumn<>("Surname");
            surnameColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));

            TableColumn<Skijumper, String> dateColumn = new TableColumn<>("Date of Birth");
            dateColumn.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));

            TableColumn<Skijumper, String> countryColumn = new TableColumn<>("Nationality");
            countryColumn.setCellValueFactory(new PropertyValueFactory<>("country"));

            Jumper_Table.getColumns().clear();
            Jumper_Table.setItems(dateBase.SList);
            Jumper_Table.getColumns().addAll(idColumn, nameColumn, surnameColumn, dateColumn, countryColumn);
        } else if (Jumper_Insert.isSelected()) {
            if (!(Jumper_IdField.getText().isEmpty() || Jumper_NameField.getText().isEmpty() || Jumper_SurnameField.getText().isEmpty()
                    || Jumper_DatePicker.getValue() == null || Jumper_NationalityField.getText().isEmpty())) {
                dateBase.wykonajZapytanie(this, DBJumperMethods.insertJumper(this));
                Jumper_Show.setSelected(true);
                Jumper_Submit.fireEvent(event);
                Jumper_Insert.setSelected(true);
            } else {
                SystemMessages.appendText(DBSkiJumpers.czas + "ERROR: Wypelnij wszystkie pola!\n");
            }
        } else if (Jumper_Update.isSelected()) {
            if (!Jumper_IdField.getText().isEmpty()) {
                dateBase.wykonajZapytanie(this, DBJumperMethods.updateJumper(this));
                Jumper_Show.setSelected(true);
                Jumper_Submit.fireEvent(event);
                Jumper_Update.setSelected(true);
            } else {
                SystemMessages.appendText(DBSkiJumpers.czas + "ERROR: Nie podałes ID!\n");
            }
        } else if (Jumper_Remove.isSelected()) {
            if (!Jumper_IdField.getText().isEmpty()) {
                dateBase.wykonajZapytanie(this, DBJumperMethods.deleteJumper(this));
                Jumper_Show.setSelected(true);
                Jumper_Submit.fireEvent(event);
                Jumper_Remove.setSelected(true);
            } else {
                SystemMessages.appendText(DBSkiJumpers.czas + "ERROR: Nie podałes ID!\n");
            }
        } else {
            SystemMessages.appendText(DBSkiJumpers.czas + "ERROR: Nie jestes połączony z Baza!\n");
        }
    }

    );

        //Trainer DATA
    Trainer_Table.setOnMouseClicked (event  
        -> {
            StringBuilder toObject = new StringBuilder(Trainer_Table.getSelectionModel().getSelectedItems().toString());
        Trainer trainer = DBTrainerMethods.updateSetContentToField(toObject);
        Trainer_IdField.setText(trainer.getStringId());
        Trainer_NameField.setText(trainer.getName());
        Trainer_SurnameField.setText(trainer.getSurname());
        LocalDate myDate = LocalDate.of(Integer.parseInt(trainer.getDateOfBirth().substring(0, 4)),
                Integer.parseInt(trainer.getDateOfBirth().substring(5, 7)),
                Integer.parseInt(trainer.getDateOfBirth().substring(8, 10)));
        Trainer_DatePicker.setValue(myDate);
        Trainer_NationalityField.setText(trainer.getCountry());
    }

    );
    Trainer_Clear.setOnAction (event 

    -> Methods.TrainerComponentMethods.ClearTrainerFields(this));

    Trainer_Update.setOnAction (event  -> {;
        Methods.TrainerComponentMethods.ShowUpdatePaneTrainer(this);
        Methods.TrainerComponentMethods.DisableComponentsToDelete(this);
    }

    );

    Trainer_Insert.setOnAction (event  
        -> {
            Methods.TrainerComponentMethods.HideUpdatePaneTrainer(this);
        Methods.TrainerComponentMethods.EnableComponentsToDelete(this);
    }

    );

    Trainer_Remove.setOnAction (event  
        -> {
            Methods.TrainerComponentMethods.HideUpdatePaneTrainer(this);
        Methods.TrainerComponentMethods.DisableComponentsToDelete(this);
    }

    );

    Trainer_Show.setOnAction (event  
        -> {
            Methods.TrainerComponentMethods.HideUpdatePaneTrainer(this);
        Methods.TrainerComponentMethods.EnableComponentsToDelete(this);
    }

    );

    Trainer_Submit.setOnAction (event  
        -> {
            if (Trainer_Show.isSelected() && DBSkiJumpers.connectionStatus == true) {
            dateBase.wykonajZapytanie(this, DBTrainerMethods.selectTrainer());

            TableColumn<Skijumper, Integer> idColumn = new TableColumn<>("ID");
            idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

            TableColumn<Skijumper, String> nameColumn = new TableColumn<>("Name");
            nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

            TableColumn<Skijumper, String> surnameColumn = new TableColumn<>("Surname");
            surnameColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));

            TableColumn<Skijumper, String> dateColumn = new TableColumn<>("Date of Birth");
            dateColumn.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));

            TableColumn<Skijumper, String> countryColumn = new TableColumn<>("Nationality");
            countryColumn.setCellValueFactory(new PropertyValueFactory<>("country"));

            Trainer_Table.getColumns().clear();
            Trainer_Table.setItems(dateBase.TList);
            Trainer_Table.getColumns().addAll(idColumn, nameColumn, surnameColumn, dateColumn, countryColumn);

        } else if (Trainer_Insert.isSelected()) {
            if (!(Trainer_IdField.getText().isEmpty() || Trainer_NameField.getText().isEmpty() || Trainer_SurnameField.getText().isEmpty()
                    || Trainer_NationalityLabel.getText().isEmpty() || Trainer_DatePicker.getValue() == null)) {
                dateBase.wykonajZapytanie(this, DBTrainerMethods.insertTrainer(this));
                Trainer_Show.setSelected(true);
                Trainer_Submit.fireEvent(event);
                Trainer_Insert.setSelected(true);
            } else {
                SystemMessages.appendText(DBSkiJumpers.czas + "ERROR: Wypelnij wszystkie pola!\n");
            }
        } else if (Trainer_Update.isSelected()) {
            if (!Trainer_IdField.getText().isEmpty()) {
                dateBase.wykonajZapytanie(this, DBTrainerMethods.updateTrainer(this));
                Trainer_Show.setSelected(true);
                Trainer_Submit.fireEvent(event);
                Trainer_Update.setSelected(true);
            } else {
                SystemMessages.appendText(DBSkiJumpers.czas + "ERROR: Nie podałes ID!\n");
            }
        } else if (Trainer_Remove.isSelected()) {
            if (!Trainer_IdField.getText().isEmpty()) {
                dateBase.wykonajZapytanie(this, DBTrainerMethods.deleteTrainer(this));
                Trainer_Show.setSelected(true);
                Trainer_Submit.fireEvent(event);
                Trainer_Remove.setSelected(true);

            } else {
                SystemMessages.appendText(DBSkiJumpers.czas + "ERROR: Nie podałes ID!\n");
            }
        } else {
            SystemMessages.appendText(DBSkiJumpers.czas + "ERROR: Nie jestes połączony z Baza!\n");
        }
    }

    );

        //RECORDS
    Records_Table.setOnMouseClicked (event  
        -> {
        if(!(Records_Table.getSelectionModel().isEmpty())){
        int id = DBRecordMethods.getSelectedID(Records_Table.getSelectionModel().getSelectedItems().toString());
        dateBase.wykonajSelectForRecords(this, DBRecordMethods.selectRecords(id));
        Records_IdField.setText(dateBase.RList.get(0).getStringId());
        Records_SkiJumperIdField.setText(dateBase.RList.get(0).getStringSkijumperId());
        Records_LengthField.setText(dateBase.RList.get(0).getStringLength());
        LocalDate myDate = LocalDate.of(Integer.parseInt(dateBase.RList.get(0).getDate().substring(0, 4)),
                Integer.parseInt(dateBase.RList.get(0).getDate().substring(5, 7)),
                Integer.parseInt(dateBase.RList.get(0).getDate().substring(8, 10)));
        Records_DatePicker.setValue(myDate);
        Records_TrainerIDField.setText(dateBase.RList.get(0).getStringTrainerId());
        Records_HillIDField.setText(dateBase.RList.get(0).getStringHillId());
        Records_TypeField.setText(dateBase.RList.get(0).getRodzajRekordu());
        }
    });
    Records_Clear.setOnAction (event 

    -> Methods.RecordComponentMethods.ClearRecordsFields(this));

    Records_Update.setOnAction (event  
        -> {
            Methods.RecordComponentMethods.ShowUpdatePaneRecords(this);
        Methods.RecordComponentMethods.DisableComponentsToDelete(this);
    }

    );

    Records_Insert.setOnAction (event  
        -> {
            Methods.RecordComponentMethods.HideUpdatePaneRecords(this);
        Methods.RecordComponentMethods.EnableComponentsToDelete(this);
    }

    );

    Records_Remove.setOnAction (event  
        -> {
            Methods.RecordComponentMethods.HideUpdatePaneRecords(this);
        Methods.RecordComponentMethods.DisableComponentsToDelete(this);
    }

    );

    Records_ShowData.setOnAction (event  
        -> {
            Methods.RecordComponentMethods.HideUpdatePaneRecords(this);
        Methods.RecordComponentMethods.EnableComponentsToDelete(this);
    }

    );

    Records_Submit.setOnAction (event  
        -> {
            if (Records_ShowData.isSelected() && DBSkiJumpers.connectionStatus == true) {
            dateBase.wykonajZapytanie(this, DBMethods.DBRecordMethods.selectRecords());

            TableColumn<RecordsView, Integer> idColumn = new TableColumn<>("ID");
            idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

            TableColumn<Skijumper, String> SkiNameColumn = new TableColumn<>("Skijumper name");
            SkiNameColumn.setCellValueFactory(new PropertyValueFactory<>("SkiName"));

            TableColumn<Skijumper, String> SkiSurnameColumn = new TableColumn<>("Skijumper surname");
            SkiSurnameColumn.setCellValueFactory(new PropertyValueFactory<>("SkiSurname"));

            TableColumn<Records, Float> recordLengthColumn = new TableColumn<>("Score");
            recordLengthColumn.setCellValueFactory(new PropertyValueFactory<>("recordLength"));

            TableColumn<Records, String> recordDateColumn = new TableColumn<>("Date");
            recordDateColumn.setCellValueFactory(new PropertyValueFactory<>("recordDate"));

            TableColumn<Records, String> recordTypeColumn = new TableColumn<>("Type");
            recordTypeColumn.setCellValueFactory(new PropertyValueFactory<>("recordType"));

            TableColumn<Trainer, String> trainerNameColumn = new TableColumn<>("Trainer name");
            trainerNameColumn.setCellValueFactory(new PropertyValueFactory<>("trainerName"));

            TableColumn<Trainer, String> trainerSurnameColumn = new TableColumn<>("Trainer surname");
            trainerSurnameColumn.setCellValueFactory(new PropertyValueFactory<>("trainerSurname"));

            TableColumn<Hill, String> hillNameColumn = new TableColumn<>("Hill name");
            hillNameColumn.setCellValueFactory(new PropertyValueFactory<>("hillName"));

            TableColumn<Hill, Float> hillLengthColumn = new TableColumn<>("Hill length");
            hillLengthColumn.setCellValueFactory(new PropertyValueFactory<>("hillLength"));

            TableColumn<Hill, Float> hillKPointColumn = new TableColumn<>("K Point");
            hillKPointColumn.setCellValueFactory(new PropertyValueFactory<>("hillKPoint"));

            Records_Table.getColumns().clear();
            Records_Table.setItems(dateBase.RVList);
            Records_Table.getColumns().addAll(idColumn, SkiNameColumn, SkiSurnameColumn, recordLengthColumn, recordDateColumn,
                    recordTypeColumn, trainerNameColumn, trainerSurnameColumn, hillNameColumn, hillLengthColumn, hillKPointColumn);
        } else if (Records_Insert.isSelected()) {
            if (!(Records_IdField.getText().isEmpty() || Records_SkiJumperIdField.getText().isEmpty()
                    || Records_DatePicker.getValue() == null || Records_HillIDField.getText().isEmpty() || Records_LengthField.getText().isEmpty()
                    || Records_TrainerIDField.getText().isEmpty() || Records_TypeField.getText().isEmpty())) {
                dateBase.wykonajZapytanie(this, DBRecordMethods.insertRecord(this));
                Records_ShowData.setSelected(true);
                Records_Submit.fireEvent(event);
                Records_Insert.setSelected(true);

            } else {
                SystemMessages.appendText(DBSkiJumpers.czas + "ERROR: Wypelnij wszystkie pola!\n");
            }

        } else if (Records_Update.isSelected()) {
            if (!Records_IdField.getText().isEmpty()) {
                dateBase.wykonajZapytanie(this, DBRecordMethods.updateRecord(this));
                Records_ShowData.setSelected(true);
                Records_Submit.fireEvent(event);
                Records_Update.setSelected(true);
            } else {
                SystemMessages.appendText(DBSkiJumpers.czas + "ERROR: Nie podałes ID!\n");
            }
        } else if (Records_Remove.isSelected()) {
            if (!Records_IdField.getText().isEmpty()) {
                dateBase.wykonajZapytanie(this, DBRecordMethods.deleteRecord(this));
                Records_ShowData.setSelected(true);
                Records_Submit.fireEvent(event);
                Records_Remove.setSelected(true);
            } else {
                SystemMessages.appendText(DBSkiJumpers.czas + "ERROR: Nie podałes ID!\n");
            }
        } else {
            SystemMessages.appendText(DBSkiJumpers.czas + "ERROR: Nie jestes połączony z Baza!\n");
        }
    }

    );

        //Hill
    Hill_Table.setOnMouseClicked (event  
        -> {
            StringBuilder toObject = new StringBuilder(Hill_Table.getSelectionModel().getSelectedItems().toString());
        Hill hill = DBHillMethods.updateSetContentToField(toObject);
        Hill_ID.setText(hill.getStringId());
        Hill_NameField.setText(hill.getName());
        Hill_LengthField.setText(hill.getStringLength());
        Hill_CityField.setText(hill.getCity());
        LocalDate myDate = LocalDate.of(Integer.parseInt(hill.getCreateDate().substring(0, 4)),
                Integer.parseInt(hill.getCreateDate().substring(5, 7)),
                Integer.parseInt(hill.getCreateDate().substring(8, 10)));
        Hill_DatePicker.setValue(myDate);
        Hill_KPointField.setText(hill.getStringKPoint());

    }

    );
    Hill_Clear.setOnAction (event 

    -> Methods.HillComponentMethods.ClearHillFields(this));

    Hill_Update.setOnAction (event  
        -> {
            Methods.HillComponentMethods.ShowUpdatePaneHill(this);
        Methods.HillComponentMethods.DisableComponentsToDelete(this);
    }

    );

    Hill_Insert.setOnAction (event  
        -> {
            Methods.HillComponentMethods.HideUpdatePaneHill(this);
        Methods.HillComponentMethods.EnableComponentsToDelete(this);
    }

    );

    Hill_Remove.setOnAction (event  
        -> {
            Methods.HillComponentMethods.HideUpdatePaneHill(this);
        Methods.HillComponentMethods.DisableComponentsToDelete(this);
    }

    );

    Hill_ShowData.setOnAction (event  
        -> {
            Methods.HillComponentMethods.HideUpdatePaneHill(this);
        Methods.HillComponentMethods.EnableComponentsToDelete(this);
    }

    );

    Hill_Submit.setOnAction (event  
        -> {
            if (Hill_ShowData.isSelected() && DBSkiJumpers.connectionStatus == true) {
            dateBase.wykonajZapytanie(this, DBHillMethods.selectHill());

            TableColumn<Skijumper, Integer> idColumn = new TableColumn<>("ID");
            idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

            TableColumn<Skijumper, String> nameColumn = new TableColumn<>("Hill");
            nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

            TableColumn<Skijumper, Float> lengthColumn = new TableColumn<>("Length");
            lengthColumn.setCellValueFactory(new PropertyValueFactory<>("length"));

            TableColumn<Skijumper, String> cityColumn = new TableColumn<>("City");
            cityColumn.setCellValueFactory(new PropertyValueFactory<>("city"));

            TableColumn<Skijumper, String> createDateColumn = new TableColumn<>("Date of create");
            createDateColumn.setCellValueFactory(new PropertyValueFactory<>("createDate"));

            TableColumn<Skijumper, Float> kPointColumn = new TableColumn<>("K Point");
            kPointColumn.setCellValueFactory(new PropertyValueFactory<>("kPoint"));

            Hill_Table.getColumns().clear();
            Hill_Table.setItems(dateBase.HList);
            Hill_Table.getColumns().addAll(idColumn, nameColumn, lengthColumn, cityColumn, createDateColumn, kPointColumn);
        } else if (Hill_Insert.isSelected()) {
            if (!(Hill_ID.getText().isEmpty() || Hill_NameField.getText().isEmpty() || Hill_CityField.getText().isEmpty()
                    || Hill_DatePicker.getValue() == null || Hill_KPointField.getText().isEmpty() || Hill_LengthField.getText().isEmpty())) {
                dateBase.wykonajZapytanie(this, DBHillMethods.insertHill(this));
                Hill_ShowData.setSelected(true);
                Hill_Submit.fireEvent(event);
                Hill_Insert.setSelected(true);
            } else {
                SystemMessages.appendText(DBSkiJumpers.czas + "ERROR: Wypelnij wszystkie pola!\n");
            }
        } else if (Hill_Update.isSelected()) {
            if (!Hill_ID.getText().isEmpty()) {
                dateBase.wykonajZapytanie(this, DBHillMethods.updateHill(this));
                Hill_ShowData.setSelected(true);
                Hill_Submit.fireEvent(event);
                Hill_Update.setSelected(true);
            } else {
                SystemMessages.appendText(DBSkiJumpers.czas + "ERROR: Nie podałes ID!\n");
            }

        } else if (Hill_Remove.isSelected()) {
            if (!Hill_ID.getText().isEmpty()) {
                dateBase.wykonajZapytanie(this, DBHillMethods.deleteHill(this));
                Hill_ShowData.setSelected(true);
                Hill_Submit.fireEvent(event);
                Hill_Remove.setSelected(true);
            } else {
                SystemMessages.appendText(DBSkiJumpers.czas + "ERROR: Nie podałes ID!\n");
            }
        } else {
            SystemMessages.appendText(DBSkiJumpers.czas + "ERROR: Nie jestes połączony z Baza!\n");
        }
    }

);
    }
}
