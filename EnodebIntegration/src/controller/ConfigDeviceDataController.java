/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.form.configdevicedata.TableFiveDeviceDataController;
import model.configdevicedata.TableFiveDeviceData;
import controller.form.configdevicedata.TableFourDeviceDataController;
import controller.form.configdevicedata.TableOneDeviceDataController;
import controller.form.configdevicedata.TableThreeDeviceDataController;
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
import model.configdevicedata.TableFourDeviceData;
import model.configdevicedata.TableOneDeviceData;
import model.configdevicedata.TableThreeDeviceData;
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
    private ObservableList<TableThreeDeviceData> _tableThreeDeviceData = FXCollections.observableArrayList();
    private ObservableList<TableFourDeviceData> _tableFourDeviceData = FXCollections.observableArrayList();
    private ObservableList<TableFiveDeviceData> _tableFiveDeviceData = FXCollections.observableArrayList();
    
    @FXML
    private TableView tableOneDeviceData;

    @FXML
    private TextArea mmlPreviewTableOneDeviceData;

    @FXML
    private TableView tableTwoDeviceData;

    @FXML
    private TextArea mmlPreviewTableTwoDeviceData;
    
    @FXML
    private TableView tableThreeDeviceData;

    @FXML
    private TextArea mmlPreviewTableThreeDeviceData;
    
    @FXML
    private TableView tableFourDeviceData;

    @FXML
    private TextArea mmlPreviewTableFourDeviceData;
    
    @FXML
    private TableView tableFiveDeviceData;

    @FXML
    private TextArea mmlPreviewTableFiveDeviceData;
    
    public ConfigDeviceDataController(ViewFactory viewFactory, String fxmlName,
            ObservableList<TableOneDeviceData> _tableOneDeviceData,
            ObservableList<TableTwoDeviceData> _tableTwoDeviceData,
            ObservableList<TableThreeDeviceData> _tableThreeDeviceData,
            ObservableList<TableFourDeviceData> _tableFourDeviceData,
            ObservableList<TableFiveDeviceData> _tableFiveDeviceData) {
        super(viewFactory, fxmlName);
        this._tableOneDeviceData=_tableOneDeviceData;
        this._tableTwoDeviceData=_tableTwoDeviceData;
        this._tableThreeDeviceData=_tableThreeDeviceData;
        this._tableFourDeviceData=_tableFourDeviceData;
        this._tableFiveDeviceData=_tableFiveDeviceData;
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
    
    @FXML
    void onAddTableThreeDeviceData(ActionEvent event) {
        if (_tableThreeDeviceData.size() <8) {
            _baseController = new TableThreeDeviceDataController(
                    viewFactory,
                    "form/configdevicedata/TableThreeDeviceData.fxml",
                    tableThreeDeviceData,
                    mmlPreviewTableThreeDeviceData,
                    false);
            viewFactory.showModalStage(
                    (Stage) tableThreeDeviceData.getScene().getWindow(),
                    _baseController,
                    "TABLE 3: //Boards in the BBU3900 subrack");
        } else {
            viewFactory.showAlertValidation((Stage) tableTwoDeviceData.getScene().getWindow(),
                    "TABLE 3: //Boards in the BBU3900 subrack",
                    "Solo se permite agregar una fila ");
        }
    }
    
    @FXML
    void onDeleteTableThreeDeviceData(ActionEvent event) {
        if (!tableThreeDeviceData.getSelectionModel().isEmpty()) {
            tableThreeDeviceData.getItems().remove(
                    tableThreeDeviceData.getSelectionModel().getSelectedItem()
            );
        } else {
            viewFactory.showAlertValidation((Stage) tableThreeDeviceData.getScene().getWindow(),
                    "TABLE 3: //Boards in the BBU3900 subrack",
                    "Seleccione una fila ");
        }
    }
    
    @FXML
    void onDuplicarTableThreeDeviceData(ActionEvent event) {
        if (!tableThreeDeviceData.getSelectionModel().isEmpty()) {
            if (_tableThreeDeviceData.size() < 8) {

                TableThreeDeviceData t
                        = (TableThreeDeviceData) tableThreeDeviceData.getSelectionModel().getSelectedItem();
                tableThreeDeviceData.getItems().addAll(
                        new TableThreeDeviceData(
                                t.getParameterId(),
                                t.getCn(),
                                t.getSrn(),
                                t.getSn(),
                                t.getBt(),
                                t.getSbt(),
                                t.getBbws(),
                                t.getHce(),
                                t.getCpriex(),
                                t.getBrdspec(),
                                t.getCcne()
                        )
                );
                setTextAreaTableThree();
            } else {
                viewFactory.showAlertValidation((Stage) tableThreeDeviceData.getScene().getWindow(),
                         "TABLE 3: //Boards in the BBU3900 subrack",
                        "Solo se permite agregar 8 filas");
            }
        } else {
            viewFactory.showAlertValidation((Stage) tableThreeDeviceData.getScene().getWindow(),
                     "TABLE 3: //Boards in the BBU3900 subrack",
                    "Seleccione una fila ");
        }
    }
    
    @FXML
    void onUpdateTableThreeDeviceData(ActionEvent event) {
        if (!tableThreeDeviceData.getSelectionModel().isEmpty()) {
            _baseController = new TableThreeDeviceDataController(
                    viewFactory,
                    "form/configdevicedata/TableThreeDeviceData.fxml",
                    tableThreeDeviceData,
                    mmlPreviewTableThreeDeviceData,
                    true);
            viewFactory.showModalStage(
                    (Stage) tableThreeDeviceData.getScene().getWindow(),
                    _baseController,
                   "TABLE 3: //Boards in the BBU3900 subrack");
        } else {
            viewFactory.showAlertValidation((Stage) tableTwoDeviceData.getScene().getWindow(),
                    "TABLE 3: //Boards in the BBU3900 subrack",
                    "Seleccione una fila ");
        }
    }
    
    private void setTextAreaTableThree() {
        mmlPreviewTableThreeDeviceData.clear();
        tableThreeDeviceData.getItems().forEach((basicData) -> {
            TableThreeDeviceData t = (TableThreeDeviceData) basicData;
            if (t.getParameterId().equals("REFERENCE")) {
                mmlPreviewTableThreeDeviceData.appendText("//\n");
            }
            if (t.getParameterId().equals("CREATE")) {
                mmlPreviewTableThreeDeviceData.appendText(""
                        + "ADD BRD:CN=" + t.getCn() + ","
                        + "SRN=" + t.getSrn() + ","
                        + "SN=" + t.getSn()+ ","
                        + "BT=" + t.getBt()+ ","      
                        + "SBT=" + t.getSbt()+ ","
                        + "BBWS=" + t.getBbws()+ ","
                        + "HCE=" + t.getHce()+ ","
                        + "CPRIEX=" + t.getCpriex()+ ","
                        + "BRDSPEC=" + t.getBrdspec()+ ","
                        + "CCNE=" + t.getCcne()+ ";\n"
                );

            }

            if (t.getParameterId().equals("DELETE")) {
                mmlPreviewTableThreeDeviceData.appendText(""
                        +"RMV BRD:CN=" + t.getCn()+ ","
                        +"SRN=" + t.getSrn()+ ","
                        +"SN=" + t.getSn()+ ";\n"
                );
            }
        });
        
    }
    
    @FXML
    void onAddTableFourDeviceData(ActionEvent event) {
        if (_tableFourDeviceData.size() <8) {
            _baseController = new TableFourDeviceDataController(
                    viewFactory,
                    "form/configdevicedata/TableFourDeviceData.fxml",
                    tableFourDeviceData,
                    mmlPreviewTableFourDeviceData,
                    false);
            viewFactory.showModalStage(
                    (Stage) tableFourDeviceData.getScene().getWindow(),
                    _baseController,
                    "TABLE 4: //Add RRU Chain/Ring (ADD RRUCHAIN)");
        } else {
            viewFactory.showAlertValidation((Stage) tableFourDeviceData.getScene().getWindow(),
                    "TABLE 4: //Add RRU Chain/Ring (ADD RRUCHAIN)",
                    "Solo se permite agregar una fila ");
        }
    }
    
    @FXML
    void onDeleteTableFourDeviceData(ActionEvent event) {
        if (!tableFourDeviceData.getSelectionModel().isEmpty()) {
            tableFourDeviceData.getItems().remove(
                    tableFourDeviceData.getSelectionModel().getSelectedItem()
            );
            setTextAreaTableFour();
        } else {
            viewFactory.showAlertValidation((Stage) tableFourDeviceData.getScene().getWindow(),
                    "TABLE 4: //Add RRU Chain/Ring (ADD RRUCHAIN)",
                    "Seleccione una fila ");
        }
    }
    
    @FXML
    void onDuplicarTableFourDeviceData(ActionEvent event) {
        if (!tableFourDeviceData.getSelectionModel().isEmpty()) {
            if (_tableFourDeviceData.size() < 8) {

                TableFourDeviceData t
                        = (TableFourDeviceData) tableFourDeviceData.getSelectionModel().getSelectedItem();
                tableFourDeviceData.getItems().addAll(
                        new TableFourDeviceData(
                                t.getParameterId(),
                                t.getRnc(),
                                t.getTt(),
                                t.getBm(),
                                t.getAt(),
                                t.getHcn(),
                                t.getHsrn(),
                                t.getHsn(),
                                t.getHpn(),
                                t.getTcn(),
                                t.getTsrn(),
                                t.getTsn(),
                                t.getTpn(),
                                t.getCr()
                        )
                );
                setTextAreaTableFour();
            } else {
                viewFactory.showAlertValidation((Stage) tableFourDeviceData.getScene().getWindow(),
                        "TABLE 4: //Add RRU Chain/Ring (ADD RRUCHAIN)",
                        "Solo se permite agregar 8 filas");
            }
        } else {
            viewFactory.showAlertValidation((Stage) tableFourDeviceData.getScene().getWindow(),
                    "TABLE 4: //Add RRU Chain/Ring (ADD RRUCHAIN)",
                    "Seleccione una fila ");
        }
    }
    
    @FXML
    void onUpdateTableFourDeviceData(ActionEvent event) {
        if (!tableFourDeviceData.getSelectionModel().isEmpty()) {
            _baseController = new TableFourDeviceDataController(
                    viewFactory,
                    "form/configdevicedata/TableFourDeviceData.fxml",
                    tableFourDeviceData,
                    mmlPreviewTableFourDeviceData,
                    true);
            viewFactory.showModalStage(
                    (Stage) tableFourDeviceData.getScene().getWindow(),
                    _baseController,
                   "TABLE 4: //Add RRU Chain/Ring (ADD RRUCHAIN)");
        } else {
            viewFactory.showAlertValidation((Stage) tableFourDeviceData.getScene().getWindow(),
                   "TABLE 4: //Add RRU Chain/Ring (ADD RRUCHAIN)",
                    "Seleccione una fila ");
        }
    }
    
    private void setTextAreaTableFour() {
        mmlPreviewTableFourDeviceData.clear();
        tableFourDeviceData.getItems().forEach((basicData) -> {
            TableFourDeviceData t = (TableFourDeviceData) basicData;
            if (t.getParameterId().equals("REFERENCE")) {
                mmlPreviewTableFourDeviceData.appendText("//\n");
            }
            if (t.getParameterId().equals("CREATE")) {
                mmlPreviewTableFourDeviceData.appendText(""
                        + "ADD RRUCHAIN:RCN=" + t.getRnc() + ","
                        + "TT=" + t.getTt() + ","
                        + "BM=" + t.getBm()+ ","
                        + "AT=" + t.getAt()+ ","      
                        + "HCN=" + t.getHcn()+ ","
                        + "HSRN=" + t.getHsrn()+ ","
                        + "HSN=" + t.getHsn()+ ","
                        + "HPN=" + t.getHpn()+ ","
                        + "TCN=" + t.getTcn()+ ","
                        + "TSRN=" + t.getTsrn()+ ","
                        + "TSN=" + t.getTsn()+ ","
                        + "TPN=" + t.getTpn()+ ","
                        + "CR=" + t.getCr()+ ";\n"
                );

            }

            if (t.getParameterId().equals("DELETE")) {
                mmlPreviewTableFourDeviceData.appendText(""
                        +"RMV RRUCHAIN:RCN=" + t.getRnc()+ ";\n"
                );
            }
        });
        
    }
    
    @FXML
    void onAddTableFiveDeviceData(ActionEvent event) {
        if (_tableFiveDeviceData.size() <8) {
            _baseController = new TableFiveDeviceDataController(
                    viewFactory,
                    "form/configdevicedata/TableFiveDeviceData.fxml",
                    tableFiveDeviceData,
                    mmlPreviewTableFiveDeviceData,
                    false);
            viewFactory.showModalStage(
                    (Stage) tableFiveDeviceData.getScene().getWindow(),
                    _baseController,
                    "TABLE 5: //Add RRU/RFU (ADD RRU)");
        } else {
            viewFactory.showAlertValidation((Stage) tableFiveDeviceData.getScene().getWindow(),
                    "TABLE 5: //Add RRU/RFU (ADD RRU)",
                    "Solo se permite agregar una fila ");
        }
    }
    
    @FXML
    void onDeleteTableFiveDeviceData(ActionEvent event) {
        if (!tableFiveDeviceData.getSelectionModel().isEmpty()) {
            tableFiveDeviceData.getItems().remove(
                    tableFiveDeviceData.getSelectionModel().getSelectedItem()
            );
            setTextAreaTableFour();
        } else {
            viewFactory.showAlertValidation((Stage) tableFiveDeviceData.getScene().getWindow(),
                    "TABLE 5: //Add RRU/RFU (ADD RRU)",
                    "Seleccione una fila ");
        }
    }
    
    @FXML
    void onDuplicarTableFiveDeviceData(ActionEvent event) {
        if (!tableFiveDeviceData.getSelectionModel().isEmpty()) {
            if (_tableFiveDeviceData.size() < 8) {

                TableFiveDeviceData t
                        = (TableFiveDeviceData) tableFiveDeviceData.getSelectionModel().getSelectedItem();
                tableFiveDeviceData.getItems().addAll(
                        new TableFiveDeviceData(
                                t.getParameterId(),
                                t.getCn(),
                                t.getSrn(),
                                t.getSn(),
                                t.getTp(),
                                t.getRnc(),
                                t.getPs(),
                                t.getRt(),
                                t.getRs(),
                                t.getRn(),
                                t.getRxnum(),
                                t.getTxnum(),
                                t.getAlmprocsw(),
                                t.getAlmprocthrhld(),
                                t.getAlmthrhld(),
                                t.getIfoffset(),
                                t.getRfds(),
                                t.getLcpsw(),
                                t.getFlag(),
                                t.getRuspec(),
                                t.getPaeffswitch()
                        )
                );
                setTextAreaTableFive();
            } else {
                viewFactory.showAlertValidation((Stage) tableFiveDeviceData.getScene().getWindow(),
                        "TABLE 5: //Add RRU/RFU (ADD RRU)",
                        "Solo se permite agregar 8 filas");
            }
        } else {
            viewFactory.showAlertValidation((Stage) tableFiveDeviceData.getScene().getWindow(),
                    "TABLE 5: //Add RRU/RFU (ADD RRU)",
                    "Seleccione una fila ");
        }
    }
    
    @FXML
    void onUpdateTableFiveDeviceData(ActionEvent event) {
        if (!tableFiveDeviceData.getSelectionModel().isEmpty()) {
            _baseController = new TableFiveDeviceDataController(
                    viewFactory,
                    "form/configdevicedata/TableFiveDeviceData.fxml",
                    tableFiveDeviceData,
                    mmlPreviewTableFiveDeviceData,
                    true);
            viewFactory.showModalStage(
                    (Stage) tableFiveDeviceData.getScene().getWindow(),
                    _baseController,
                   "TABLE 5: //Add RRU/RFU (ADD RRU)");
        } else {
            viewFactory.showAlertValidation((Stage) tableFiveDeviceData.getScene().getWindow(),
                   "TABLE 5: //Add RRU/RFU (ADD RRU)",
                    "Seleccione una fila ");
        }
    }
    
    private void setTextAreaTableFive() {
        mmlPreviewTableFiveDeviceData.clear();
        tableFiveDeviceData.getItems().forEach((basicData) -> {
            TableFiveDeviceData t = (TableFiveDeviceData) basicData;
            if (t.getParameterId().equals("REFERENCE")) {
                mmlPreviewTableFiveDeviceData.appendText("//\n");
            }
            if (t.getParameterId().equals("CREATE")) {
                mmlPreviewTableFiveDeviceData.appendText(""
                        + "ADD RRU:CN=" + t.getCn() + ","
                        + "SRN=" + t.getSrn() + ","
                        + "SN=" + t.getSn()+ ","
                        + "TP=" + t.getTp()+ ","      
                        + "RNC=" + t.getRnc()+ ","
                        + "PS=" + t.getPs()+ ","
                        + "RT=" + t.getRt()+ ","
                        + "RS=" + t.getRs()+ ","
                        + "RN=" + t.getRn()+ ","
                        + "RXNUM=" + t.getRxnum()+ ","
                        + "TXNUM=" + t.getTxnum()+ ","
                        + "ALMPROCSW=" + t.getAlmprocsw()+ ","
                        + "ALMPROCTHRHLD=" + t.getAlmprocthrhld()+ ","
                        + "ALMTHRHLD=" + t.getAlmthrhld()+ ","
                        + "IFOFFSET=" + t.getIfoffset()+ ","
                        + "RFDS=" + t.getRfds()+ ","
                        + "LCPSW=" + t.getLcpsw()+ ","
                        + "FLAG=" + t.getFlag()+ ","
                        + "RUSPEC=" + t.getRuspec()+ ","        
                        + "PAEFFSWITCH=" + t.getPaeffswitch()+ ";\n"
                );

            }

            if (t.getParameterId().equals("DELETE")) {
                mmlPreviewTableFiveDeviceData.appendText(""
                        +"RMV RRU:CN=" + t.getCn()+ ","
                        +"SRN=" + t.getSrn()+ ","
                        +"SN=" + t.getSn()+ ";\n"
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
        
                //Table Three Basic Data
        TableColumn parameterIdCol03 = new TableColumn("Parameter Name");
        parameterIdCol03.setMinWidth(200);
        parameterIdCol03.setCellValueFactory(
                new PropertyValueFactory<TableThreeDeviceData, String>("parameterId"));
        parameterIdCol03.setSortType(TableColumn.SortType.DESCENDING);
        
        TableColumn cnCol03 = new TableColumn("Cabinet No.");
        cnCol03.setMinWidth(200);
        cnCol03.setCellValueFactory(
                new PropertyValueFactory<TableThreeDeviceData, String>("cn"));
        cnCol03.setSortType(TableColumn.SortType.DESCENDING);
        
        TableColumn srnCol03 = new TableColumn("Subrack No.");
        srnCol03.setMinWidth(200);
        srnCol03.setCellValueFactory(
                new PropertyValueFactory<TableThreeDeviceData, String>("srn"));
        srnCol03.setSortType(TableColumn.SortType.DESCENDING);
        
        TableColumn snCol03 = new TableColumn("Slot No.");
        snCol03.setMinWidth(200);
        snCol03.setCellValueFactory(
                new PropertyValueFactory<TableThreeDeviceData, String>("sn"));
        snCol03.setSortType(TableColumn.SortType.DESCENDING);
        
        TableColumn btCol03 = new TableColumn("Board Type");
        btCol03.setMinWidth(200);
        btCol03.setCellValueFactory(
                new PropertyValueFactory<TableThreeDeviceData, String>("bt"));
        btCol03.setSortType(TableColumn.SortType.DESCENDING);
        
        TableColumn sbtCol03 = new TableColumn("SubBoard Type");
        sbtCol03.setMinWidth(200);
        sbtCol03.setCellValueFactory(
                new PropertyValueFactory<TableThreeDeviceData, String>("sbt"));
        sbtCol03.setSortType(TableColumn.SortType.DESCENDING);
        
        TableColumn bbwsCol03 = new TableColumn("Base Band Work Standard");
        bbwsCol03.setMinWidth(200);
        bbwsCol03.setCellValueFactory(
                new PropertyValueFactory<TableThreeDeviceData, String>("bbws"));
        bbwsCol03.setSortType(TableColumn.SortType.DESCENDING);
        
        TableColumn hceCol03 = new TableColumn("Hardware Capacity Enhance");
        hceCol03.setMinWidth(200);
        hceCol03.setCellValueFactory(
                new PropertyValueFactory<TableThreeDeviceData, String>("hce"));
        hceCol03.setSortType(TableColumn.SortType.DESCENDING);
        
        TableColumn cpriexCol03 = new TableColumn("CPRI Extension");
        cpriexCol03.setMinWidth(200);
        cpriexCol03.setCellValueFactory(
                new PropertyValueFactory<TableThreeDeviceData, String>("cpriex"));
        cpriexCol03.setSortType(TableColumn.SortType.DESCENDING);
        
        TableColumn brdspecCol03 = new TableColumn("Board Specification");
        brdspecCol03.setMinWidth(200);
        brdspecCol03.setCellValueFactory(
                new PropertyValueFactory<TableThreeDeviceData, String>("brdspec"));
        brdspecCol03.setSortType(TableColumn.SortType.DESCENDING);
        
        TableColumn ccneCol03 = new TableColumn("Cell Channel Number Extension");
        ccneCol03.setMinWidth(200);
        ccneCol03.setCellValueFactory(
                new PropertyValueFactory<TableThreeDeviceData, String>("ccne"));
        ccneCol03.setSortType(TableColumn.SortType.DESCENDING);
        
        tableThreeDeviceData.setItems(_tableThreeDeviceData);
        tableThreeDeviceData.getColumns().addAll(parameterIdCol03,
                cnCol03,
                srnCol03,
                snCol03,
                btCol03,
                sbtCol03,
                bbwsCol03,
                hceCol03,
                cpriexCol03,
                brdspecCol03,
                ccneCol03);
        setTextAreaTableThree();
        
        
                //Table Three Basic Data
        TableColumn parameterIdCol04 = new TableColumn("Parameter Name");
        parameterIdCol04.setMinWidth(200);
        parameterIdCol04.setCellValueFactory(
                new PropertyValueFactory<TableFourDeviceData, String>("parameterId"));
        parameterIdCol04.setSortType(TableColumn.SortType.DESCENDING);
        
        TableColumn rncCol04 = new TableColumn("Chain No.");
        rncCol04.setMinWidth(200);
        rncCol04.setCellValueFactory(
                new PropertyValueFactory<TableFourDeviceData, String>("rnc"));
        rncCol04.setSortType(TableColumn.SortType.DESCENDING);
        
        TableColumn ttCol04 = new TableColumn("Topo Type");
        ttCol04.setMinWidth(200);
        ttCol04.setCellValueFactory(
                new PropertyValueFactory<TableFourDeviceData, String>("tt"));
        ttCol04.setSortType(TableColumn.SortType.DESCENDING);
        
        TableColumn bmCol04 = new TableColumn("Backup Mode");
        bmCol04.setMinWidth(200);
        bmCol04.setCellValueFactory(
                new PropertyValueFactory<TableFourDeviceData, String>("bm"));
        bmCol04.setSortType(TableColumn.SortType.DESCENDING);
        
        TableColumn atCol04 = new TableColumn("Access Type");
        atCol04.setMinWidth(200);
        atCol04.setCellValueFactory(
                new PropertyValueFactory<TableFourDeviceData, String>("at"));
        atCol04.setSortType(TableColumn.SortType.DESCENDING);
        
        TableColumn hcnCol04 = new TableColumn("Head Cabinet No.");
        hcnCol04.setMinWidth(200);
        hcnCol04.setCellValueFactory(
                new PropertyValueFactory<TableFourDeviceData, String>("hcn"));
        hcnCol04.setSortType(TableColumn.SortType.DESCENDING);
        
        TableColumn hsrnCol04 = new TableColumn("Head Subrack No.");
        hsrnCol04.setMinWidth(200);
        hsrnCol04.setCellValueFactory(
                new PropertyValueFactory<TableFourDeviceData, String>("hsrn"));
        hsrnCol04.setSortType(TableColumn.SortType.DESCENDING);
        
        TableColumn hsnCol04 = new TableColumn("Head Slot No.");
        hsnCol04.setMinWidth(200);
        hsnCol04.setCellValueFactory(
                new PropertyValueFactory<TableFourDeviceData, String>("hsn"));
        hsnCol04.setSortType(TableColumn.SortType.DESCENDING);
        
        TableColumn hpnCol04 = new TableColumn("Head Port No.");
        hpnCol04.setMinWidth(200);
        hpnCol04.setCellValueFactory(
                new PropertyValueFactory<TableFourDeviceData, String>("hpn"));
        hpnCol04.setSortType(TableColumn.SortType.DESCENDING);
        
        TableColumn tcnCol04 = new TableColumn("Tail Cabinet No.");
        tcnCol04.setMinWidth(200);
        tcnCol04.setCellValueFactory(
                new PropertyValueFactory<TableFourDeviceData, String>("tcn"));
        tcnCol04.setSortType(TableColumn.SortType.DESCENDING);
        
        TableColumn tsrnCol04 = new TableColumn("Tail Subrack No.");
        tsrnCol04.setMinWidth(200);
        tsrnCol04.setCellValueFactory(
                new PropertyValueFactory<TableFourDeviceData, String>("tsrn"));
        tsrnCol04.setSortType(TableColumn.SortType.DESCENDING);
        
        TableColumn tsnCol04 = new TableColumn("Tail Slot No.");
        tsnCol04.setMinWidth(200);
        tsnCol04.setCellValueFactory(
                new PropertyValueFactory<TableFourDeviceData, String>("tsn"));
        tsnCol04.setSortType(TableColumn.SortType.DESCENDING);
        
        TableColumn tpnCol04 = new TableColumn("Tail Port No.");
        tpnCol04.setMinWidth(200);
        tpnCol04.setCellValueFactory(
                new PropertyValueFactory<TableFourDeviceData, String>("tpn"));
        tpnCol04.setSortType(TableColumn.SortType.DESCENDING);
        
        TableColumn crCol04 = new TableColumn("CPRI Line Rate");
        crCol04.setMinWidth(200);
        crCol04.setCellValueFactory(
                new PropertyValueFactory<TableFourDeviceData, String>("cr"));
        crCol04.setSortType(TableColumn.SortType.DESCENDING);
        
        tableFourDeviceData.setItems(_tableFourDeviceData);
        tableFourDeviceData.getColumns().addAll(parameterIdCol04,
                rncCol04,
                ttCol04,
                bmCol04,
                atCol04,
                hcnCol04,
                hsrnCol04,
                hsnCol04,
                hpnCol04,
                tcnCol04,
                tsrnCol04,
                tsnCol04,
                tpnCol04,
                crCol04);
        setTextAreaTableFour();
        
                //Table Three Basic Data
        TableColumn parameterIdCol05 = new TableColumn("Parameter Name");
        parameterIdCol05.setMinWidth(200);
        parameterIdCol05.setCellValueFactory(
                new PropertyValueFactory<TableFiveDeviceData, String>("parameterId"));
        parameterIdCol05.setSortType(TableColumn.SortType.DESCENDING);
        
        TableColumn cnCol05 = new TableColumn("Cabinet No.");
        cnCol05.setMinWidth(200);
        cnCol05.setCellValueFactory(
                new PropertyValueFactory<TableFiveDeviceData, String>("cn"));
        cnCol05.setSortType(TableColumn.SortType.DESCENDING);
        
        TableColumn srnCol05 = new TableColumn("Subrack No.");
        srnCol05.setMinWidth(200);
        srnCol05.setCellValueFactory(
                new PropertyValueFactory<TableFiveDeviceData, String>("srn"));
        srnCol05.setSortType(TableColumn.SortType.DESCENDING);
        
        TableColumn snCol05 = new TableColumn("Slot No.");
        snCol05.setMinWidth(200);
        snCol05.setCellValueFactory(
                new PropertyValueFactory<TableFiveDeviceData, String>("sn"));
        snCol05.setSortType(TableColumn.SortType.DESCENDING);
        
        TableColumn tpCol05 = new TableColumn("RRU Topo Position");
        tpCol05.setMinWidth(200);
        tpCol05.setCellValueFactory(
                new PropertyValueFactory<TableFiveDeviceData, String>("tp"));
        tpCol05.setSortType(TableColumn.SortType.DESCENDING);
        
        TableColumn rncCol05 = new TableColumn("RRU Chain No.");
        rncCol05.setMinWidth(200);
        rncCol05.setCellValueFactory(
                new PropertyValueFactory<TableFiveDeviceData, String>("rnc"));
        rncCol05.setSortType(TableColumn.SortType.DESCENDING);
        
        TableColumn psCol05 = new TableColumn("RRU Position");
        psCol05.setMinWidth(200);
        psCol05.setCellValueFactory(
                new PropertyValueFactory<TableFiveDeviceData, String>("ps"));
        psCol05.setSortType(TableColumn.SortType.DESCENDING);
        
        TableColumn rtCol05 = new TableColumn("RRU Type");
        rtCol05.setMinWidth(200);
        rtCol05.setCellValueFactory(
                new PropertyValueFactory<TableFiveDeviceData, String>("rt"));
        rtCol05.setSortType(TableColumn.SortType.DESCENDING);
        
        TableColumn rsCol05 = new TableColumn("RF Unit Working Mode");
        rsCol05.setMinWidth(200);
        rsCol05.setCellValueFactory(
                new PropertyValueFactory<TableFiveDeviceData, String>("rs"));
        rsCol05.setSortType(TableColumn.SortType.DESCENDING);
        
        TableColumn rnCol05 = new TableColumn("RRU Name");
        rnCol05.setMinWidth(200);
        rnCol05.setCellValueFactory(
                new PropertyValueFactory<TableFiveDeviceData, String>("rn"));
        rnCol05.setSortType(TableColumn.SortType.DESCENDING);
        
        TableColumn rxnumCol05 = new TableColumn("Number of Rx channel");
        rxnumCol05.setMinWidth(200);
        rxnumCol05.setCellValueFactory(
                new PropertyValueFactory<TableFiveDeviceData, String>("rxnum"));
        rxnumCol05.setSortType(TableColumn.SortType.DESCENDING);
        
        TableColumn txnumCol05 = new TableColumn("Number of Tx channel");
        txnumCol05.setMinWidth(200);
        txnumCol05.setCellValueFactory(
                new PropertyValueFactory<TableFiveDeviceData, String>("txnum"));
        txnumCol05.setSortType(TableColumn.SortType.DESCENDING);
        
        TableColumn almprocswCol05 = new TableColumn("VSWR alarm post-processing switch");
        almprocswCol05.setMinWidth(200);
        almprocswCol05.setCellValueFactory(
                new PropertyValueFactory<TableFiveDeviceData, String>("almprocsw"));
        almprocswCol05.setSortType(TableColumn.SortType.DESCENDING);
        
        TableColumn almprocthrhldCol05 = new TableColumn("VSWR alarm post-processing threshold");
        almprocthrhldCol05.setMinWidth(200);
        almprocthrhldCol05.setCellValueFactory(
                new PropertyValueFactory<TableFiveDeviceData, String>("almprocthrhld"));
        almprocthrhldCol05.setSortType(TableColumn.SortType.DESCENDING);
        
        TableColumn almthrhldCol05 = new TableColumn("VSWR alarm threshold");
        almthrhldCol05.setMinWidth(200);
        almthrhldCol05.setCellValueFactory(
                new PropertyValueFactory<TableFiveDeviceData, String>("almthrhld"));
        almthrhldCol05.setSortType(TableColumn.SortType.DESCENDING);
        
        TableColumn ifoffsetCol05 = new TableColumn("IfOffset");
        ifoffsetCol05.setMinWidth(200);
        ifoffsetCol05.setCellValueFactory(
                new PropertyValueFactory<TableFiveDeviceData, String>("ifoffset"));
        ifoffsetCol05.setSortType(TableColumn.SortType.DESCENDING);
        
        TableColumn rfdsCol05 = new TableColumn("RF Desensitivity");
        rfdsCol05.setMinWidth(200);
        rfdsCol05.setCellValueFactory(
                new PropertyValueFactory<TableFiveDeviceData, String>("rfds"));
        rfdsCol05.setSortType(TableColumn.SortType.DESCENDING);
        
        TableColumn lcpswCol05 = new TableColumn("Low Current Protect Switch");
        lcpswCol05.setMinWidth(200);
        lcpswCol05.setCellValueFactory(
                new PropertyValueFactory<TableFiveDeviceData, String>("lcpsw"));
        lcpswCol05.setSortType(TableColumn.SortType.DESCENDING);
        
        TableColumn flagCol05 = new TableColumn("ALD Reuse Flag");
        flagCol05.setMinWidth(200);
        flagCol05.setCellValueFactory(
                new PropertyValueFactory<TableFiveDeviceData, String>("flag"));
        flagCol05.setSortType(TableColumn.SortType.DESCENDING);
        
        TableColumn ruspecCol05 = new TableColumn("RU Specification");
        ruspecCol05.setMinWidth(200);
        ruspecCol05.setCellValueFactory(
                new PropertyValueFactory<TableFiveDeviceData, String>("ruspec"));
        ruspecCol05.setSortType(TableColumn.SortType.DESCENDING);
        
        TableColumn paeffswitchCol05 = new TableColumn("PA Efficiency Improvement Switch");
        paeffswitchCol05.setMinWidth(200);
        paeffswitchCol05.setCellValueFactory(
                new PropertyValueFactory<TableFiveDeviceData, String>("paeffswitch"));
        paeffswitchCol05.setSortType(TableColumn.SortType.DESCENDING);
        
        tableFiveDeviceData.setItems(_tableFiveDeviceData);
        tableFiveDeviceData.getColumns().addAll(parameterIdCol05,
                cnCol05,
                srnCol05,
                snCol05,
                tpCol05,
                rncCol05,
                psCol05,
                rtCol05,
                rsCol05,
                rnCol05,
                rxnumCol05,
                txnumCol05,
                almprocswCol05,
                almprocthrhldCol05,
                almthrhldCol05,
                ifoffsetCol05,
                rfdsCol05,
                lcpswCol05,
                flagCol05,
                ruspecCol05,
                paeffswitchCol05);
        setTextAreaTableFive();
        
    }    
    
}
