/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.form.configdevicedata.TableOneDeviceDataController;
import controller.form.configdevicedata.TableTwoDeviceDataController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.configdevicedata.TableOneDeviceData;
import model.configdevicedata.TableTwoDeviceData;
import view.ViewFactory;

/**
 * FXML Controller class
 *
 * @author P05144
 */
public class ConfigDeviceDataController extends BaseController implements Initializable {
    private BaseController _baseController;
    //TableOne
    private ObservableList<TableOneDeviceData> _tableOneDeviceData = FXCollections.observableArrayList();
    private ObservableList<TableTwoDeviceData> _tableTwoDeviceData = FXCollections.observableArrayList();
    @FXML
    private TableView tableOneDeviceData;

    @FXML
    private TextArea mmlPreviewTableOneDeviceData;

    @FXML
    private TableView tableTwoDeviceData;

    @FXML
    private TextArea mmlPreviewTableTwoDeviceData;
    
    public ConfigDeviceDataController(ViewFactory viewFactory, String fxmlName,
            ObservableList<TableOneDeviceData> _tableOneDeviceData,
            ObservableList<TableTwoDeviceData> _tableTwoDeviceData) {
        super(viewFactory, fxmlName);
        this._tableOneDeviceData=_tableOneDeviceData;
        this._tableTwoDeviceData=_tableTwoDeviceData;
    }
    
    @FXML
    void onAddTableOneDeviceData(ActionEvent event) {
        if (_tableOneDeviceData.isEmpty()) {
            _baseController = new TableOneDeviceDataController(
                    viewFactory,
                    "form/configdevicedata/TableOneDeviceData.fxml",
                    tableOneDeviceData,
                    mmlPreviewTableOneDeviceData,
                    false);
            viewFactory.showModalStage(
                    (Stage) tableOneDeviceData.getScene().getWindow(),
                    _baseController,
                    "TABLE 1: //Add Cabinet (ADD CABINET)");
        } else {
            viewFactory.showAlertValidation((Stage) tableOneDeviceData.getScene().getWindow(),
                    "TABLE 1: //Add Cabinet (ADD CABINET)",
                    "Solo se permite agregar una fila ");
        }
    }    

    @FXML
    void onDeleteTableOneDeviceData(ActionEvent event) {
        if (!tableOneDeviceData.getSelectionModel().isEmpty()) {
            tableOneDeviceData.getItems().remove(
                    tableOneDeviceData.getSelectionModel().getSelectedItem()
            );
        } else {
            viewFactory.showAlertValidation((Stage) tableOneDeviceData.getScene().getWindow(),
                    "TABLE 1: //Add Cabinet (ADD CABINET)",
                    "Seleccione una fila ");
        }
    }    

    @FXML
    void onUpdateTableOneDeviceData(ActionEvent event) {
        if (!tableOneDeviceData.getSelectionModel().isEmpty()) {
            _baseController = new TableOneDeviceDataController(
                    viewFactory,
                    "form/configdevicedata/TableOneDeviceData.fxml",
                    tableOneDeviceData,
                    mmlPreviewTableOneDeviceData,
                    true);
            viewFactory.showModalStage(
                    (Stage) tableOneDeviceData.getScene().getWindow(),
                    _baseController,
                   "TABLE 1: //Add Cabinet (ADD CABINET)");
        } else {
            viewFactory.showAlertValidation((Stage) tableOneDeviceData.getScene().getWindow(),
                    "TABLE 1: //Set Network Element Configuration (SET NE)",
                    "Seleccione una fila ");
        }
    }

    private void setTextAreaTableOne() {
        mmlPreviewTableOneDeviceData.clear();
        tableOneDeviceData.getItems().forEach((basicData) -> {
            TableOneDeviceData t = (TableOneDeviceData) basicData;
            if (t.getParameterId().equals("REFERENCE")) {
                mmlPreviewTableOneDeviceData.appendText("//\n");
            }
            if (t.getParameterId().equals("CREATE")) {
                mmlPreviewTableOneDeviceData.appendText(""
                        + "ADD CABINET:CN=" + t.getCn() + ","
                        + "TYPE=" + t.getType() + ","
                        + "DESC=\"" + t.getDesc()+ "\";"
                );

            }

            if (t.getParameterId().equals("DELETE")) {
                mmlPreviewTableOneDeviceData.appendText(
                        "RMV CABINET:CN=" + t.getCn()+ ";\n"
                );
            }
        });
        
    }    
    
    @FXML
    void onAddTableTwoDeviceData(ActionEvent event) {
        if (_tableTwoDeviceData.isEmpty()) {
            _baseController = new TableTwoDeviceDataController(
                    viewFactory,
                    "form/configdevicedata/TableTwoDeviceData.fxml",
                    tableTwoDeviceData,
                    mmlPreviewTableTwoDeviceData,
                    false);
            viewFactory.showModalStage(
                    (Stage) tableTwoDeviceData.getScene().getWindow(),
                    _baseController,
                    "TABLE 2: //Add Subrack (ADD SUBRACK)");
        } else {
            viewFactory.showAlertValidation((Stage) tableTwoDeviceData.getScene().getWindow(),
                    "TABLE 2: //Add Subrack (ADD SUBRACK)",
                    "Solo se permite agregar una fila ");
        }
    }
    
    @FXML
    void onDeleteTableTwoDeviceData(ActionEvent event) {
        if (!tableTwoDeviceData.getSelectionModel().isEmpty()) {
            tableTwoDeviceData.getItems().remove(
                    tableTwoDeviceData.getSelectionModel().getSelectedItem()
            );
        } else {
            viewFactory.showAlertValidation((Stage) tableTwoDeviceData.getScene().getWindow(),
                    "TABLE 2: //Add Subrack (ADD SUBRACK)",
                    "Seleccione una fila ");
        }
    }
    
    @FXML
    void onUpdateTableTwoDeviceData(ActionEvent event) {
        if (!tableTwoDeviceData.getSelectionModel().isEmpty()) {
            _baseController = new TableTwoDeviceDataController(
                    viewFactory,
                    "form/configdevicedata/TableTwoDeviceData.fxml",
                    tableTwoDeviceData,
                    mmlPreviewTableTwoDeviceData,
                    true);
            viewFactory.showModalStage(
                    (Stage) tableTwoDeviceData.getScene().getWindow(),
                    _baseController,
                   "TABLE 2: //Add Subrack (ADD SUBRACK)");
        } else {
            viewFactory.showAlertValidation((Stage) tableTwoDeviceData.getScene().getWindow(),
                    "TABLE 2: //Add Subrack (ADD SUBRACK)",
                    "Seleccione una fila ");
        }
    }
    
    private void setTextAreaTableTwo() {
        mmlPreviewTableTwoDeviceData.clear();
        tableTwoDeviceData.getItems().forEach((basicData) -> {
            TableTwoDeviceData t = (TableTwoDeviceData) basicData;
            if (t.getParameterId().equals("REFERENCE")) {
                mmlPreviewTableTwoDeviceData.appendText("//\n");
            }
            if (t.getParameterId().equals("CREATE")) {
                mmlPreviewTableTwoDeviceData.appendText(""
                        + "ADD SUBRACK:CN=" + t.getCn() + ","
                        + "SRN=" + t.getSrn() + ","
                        + "TYPE=" + t.getType()+ ","
                        + "DESC=\"" + t.getDesc()+ "\";"
                );

            }

            if (t.getParameterId().equals("DELETE")) {
                mmlPreviewTableTwoDeviceData.appendText(
                        "RMV SUBRACK:CN=" + t.getCn()+ ";\n"
                );
            }
        });
        
    } 
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
                //Table One Basic Data
        TableColumn parameterIdCol01 = new TableColumn("Parameter Name");
        parameterIdCol01.setMinWidth(200);
        parameterIdCol01.setCellValueFactory(
                new PropertyValueFactory<TableOneDeviceData, String>("parameterId"));
        parameterIdCol01.setSortType(TableColumn.SortType.DESCENDING);
        
        TableColumn cnCol01 = new TableColumn("Cabinet No.");
        cnCol01.setMinWidth(200);
        cnCol01.setCellValueFactory(
                new PropertyValueFactory<TableOneDeviceData, String>("cn"));
        cnCol01.setSortType(TableColumn.SortType.DESCENDING);
        
        TableColumn typeCol01 = new TableColumn("Cabinet Type");
        typeCol01.setMinWidth(200);
        typeCol01.setCellValueFactory(
                new PropertyValueFactory<TableOneDeviceData, String>("type"));
        typeCol01.setSortType(TableColumn.SortType.DESCENDING);
        
        TableColumn descCol01 = new TableColumn("Cabinet Description");
        descCol01.setMinWidth(200);
        descCol01.setCellValueFactory(
                new PropertyValueFactory<TableOneDeviceData, String>("desc"));
        descCol01.setSortType(TableColumn.SortType.DESCENDING);
        
        tableOneDeviceData.setItems(_tableOneDeviceData);
        tableOneDeviceData.getColumns().addAll(parameterIdCol01,
                cnCol01,
                typeCol01,
                descCol01);
        setTextAreaTableOne();
                //Table Two Basic Data
        TableColumn parameterIdCol02 = new TableColumn("Parameter Name");
        parameterIdCol02.setMinWidth(200);
        parameterIdCol02.setCellValueFactory(
                new PropertyValueFactory<TableTwoDeviceData, String>("parameterId"));
        parameterIdCol02.setSortType(TableColumn.SortType.DESCENDING);
        
        TableColumn cnCol02 = new TableColumn("Cabinet No.");
        cnCol02.setMinWidth(200);
        cnCol02.setCellValueFactory(
                new PropertyValueFactory<TableTwoDeviceData, String>("cn"));
        cnCol02.setSortType(TableColumn.SortType.DESCENDING);
        
        TableColumn srnCol02 = new TableColumn("Subrack No.");
        srnCol02.setMinWidth(200);
        srnCol02.setCellValueFactory(
                new PropertyValueFactory<TableTwoDeviceData, String>("srn"));
        srnCol02.setSortType(TableColumn.SortType.DESCENDING);
        
        TableColumn typeCol02 = new TableColumn("Subrack Type");
        typeCol02.setMinWidth(200);
        typeCol02.setCellValueFactory(
                new PropertyValueFactory<TableTwoDeviceData, String>("type"));
        typeCol02.setSortType(TableColumn.SortType.DESCENDING);
        
        TableColumn descCol02 = new TableColumn("Subrack Description");
        descCol02.setMinWidth(200);
        descCol02.setCellValueFactory(
                new PropertyValueFactory<TableTwoDeviceData, String>("desc"));
        descCol02.setSortType(TableColumn.SortType.DESCENDING);
        
        tableTwoDeviceData.setItems(_tableTwoDeviceData);
        tableTwoDeviceData.getColumns().addAll(parameterIdCol02,
                cnCol02,
                srnCol02,
                typeCol02,
                descCol02);
        setTextAreaTableTwo();
    }    
    
}
