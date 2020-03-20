/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.form.configbasicdata.TableFourConfigBasicDataController;
import controller.form.configbasicdata.TableOneConfigBasicDataController;
import controller.form.configbasicdata.TableThreeConfigBasicDataController;
import controller.form.configbasicdata.TableTwoConfigBasicDataController;
import controller.form.rmvdefaultconfig.TableOneRmDefaultConfigFormController;
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
import model.configbasicdata.TableFourBasicData;
import model.configbasicdata.TableOneBasicData;
import model.configbasicdata.TableThreeBasicData;
import model.configbasicdata.TableTwoBasicData;
import model.rmvdefaultconfig.TableOneRmvDefaultConfig;
import view.ViewFactory;

/**
 * FXML Controller class
 *
 * @author P05144
 */
public class ConfigBasicDataController extends BaseController implements Initializable {

    private ObservableList<TableOneBasicData> _tableOneBasicData = FXCollections.observableArrayList();
    private ObservableList<TableTwoBasicData> _tableTwoBasicData = FXCollections.observableArrayList();
    private ObservableList<TableThreeBasicData> _tableThreeBasicData = FXCollections.observableArrayList();
    private ObservableList<TableFourBasicData> _tableFourBasicData = FXCollections.observableArrayList();
    private BaseController _baseController;
    @FXML
    private TableView tableOneBasicData;

    @FXML
    private TextArea mmlPreviewTableOneBasicData;

    @FXML
    private TableView tableTwoBasicData;

    @FXML
    private TextArea mmlPreviewTableTwoBasicData;
    @FXML
    private TableView tableThreeBasicData;

    @FXML
    private TextArea mmlPreviewTableThreeBasicData;
    
    @FXML
    private TableView tableFourBasicData;

    @FXML
    private TextArea mmlPreviewTableFourBasicData;

    public ConfigBasicDataController(ViewFactory viewFactory, String fxmlName,
            ObservableList<TableOneBasicData> _tableOneBasicData,
            ObservableList<TableTwoBasicData> _tableTwoBasicData,
            ObservableList<TableThreeBasicData> _tableThreeBasicData,
            ObservableList<TableFourBasicData> _tableFourBasicData) {
        super(viewFactory, fxmlName);
        this._tableOneBasicData = _tableOneBasicData;
        this._tableTwoBasicData = _tableTwoBasicData;
        this._tableThreeBasicData = _tableThreeBasicData;
        this._tableFourBasicData = _tableFourBasicData;
    }

    @FXML
    void onAddTableOneBasicData(ActionEvent event) {
        if (_tableOneBasicData.isEmpty()) {
            _baseController = new TableOneConfigBasicDataController(
                    viewFactory,
                    "form/configbasicdata/TableOneConfigBasicData.fxml",
                    tableOneBasicData,
                    mmlPreviewTableOneBasicData,
                    false);
            viewFactory.showModalStage(
                    (Stage) tableOneBasicData.getScene().getWindow(),
                    _baseController,
                    "TABLE 1: //Set Network Element Configuration (SET NE)");
        } else {
            viewFactory.showAlertValidation((Stage) tableOneBasicData.getScene().getWindow(),
                    "TABLE 1: //Set Network Element Configuration (SET NE)",
                    "Solo se permite agregar una fila ");
        }
    }

    @FXML
    void onDeleteTableOneBasicData(ActionEvent event) {
        if (!tableOneBasicData.getSelectionModel().isEmpty()) {
            tableOneBasicData.getItems().remove(
                    tableOneBasicData.getSelectionModel().getSelectedItem()
            );
        } else {
            viewFactory.showAlertValidation((Stage) tableOneBasicData.getScene().getWindow(),
                    "TABLE 1: //Set Network Element Configuration (SET NE)",
                    "Seleccione una fila ");
        }
    }

    @FXML
    void onUpdateTableOneBasicData(ActionEvent event) {
        if (!tableOneBasicData.getSelectionModel().isEmpty()) {
            _baseController = new TableOneConfigBasicDataController(
                    viewFactory,
                    "form/configbasicdata/TableOneConfigBasicData.fxml",
                    tableOneBasicData,
                    mmlPreviewTableOneBasicData,
                    true);
            viewFactory.showModalStage(
                    (Stage) tableOneBasicData.getScene().getWindow(),
                    _baseController,
                    "TABLE 1: //Set Network Element Configuration (SET NE)");
        } else {
            viewFactory.showAlertValidation((Stage) tableOneBasicData.getScene().getWindow(),
                    "TABLE 1: //Set Network Element Configuration (SET NE)",
                    "Seleccione una fila ");
        }
    }

    private void setTextAreaTableOne() {
        mmlPreviewTableOneBasicData.clear();
        _tableOneBasicData.forEach((t) -> {
            if (t.getParameterId().equals("REFERENCE")) {
                mmlPreviewTableOneBasicData.appendText("//");
            }
            if (t.getParameterId().equals("CREATE")
                    || t.getParameterId().equals("DELETE")) {
                mmlPreviewTableOneBasicData.appendText(""
                        + "SET NE:NENAME=\"" + t.getNeName() + "\","
                        + "LOCATION=\"" + t.getLocation() + "\","
                        + "SITENAME=\"" + t.getSiteName() + "\","
                        + "USERLABEL=\"" + t.getUserLabel() + "\";");
            }

        });
    }

    @FXML
    void onAddTableTwoBasicData(ActionEvent event) {
        if (_tableTwoBasicData.isEmpty()) {
            _baseController = new TableTwoConfigBasicDataController(
                    viewFactory,
                    "form/configbasicdata/TableTwoConfigBasicData.fxml",
                    tableTwoBasicData,
                    mmlPreviewTableTwoBasicData,
                    false);
            viewFactory.showModalStage(
                    (Stage) tableTwoBasicData.getScene().getWindow(),
                    _baseController,
                    "TABLE 2: //Set Node Configuration (SET NODE)");
        } else {
            viewFactory.showAlertValidation((Stage) tableOneBasicData.getScene().getWindow(),
                    "TABLE 2: //Set Node Configuration (SET NODE)",
                    "Solo se permite agregar una fila ");
        }
    }

    @FXML
    void onDeleteTableTwoBasicData(ActionEvent event) {
        if (!tableTwoBasicData.getSelectionModel().isEmpty()) {
            tableTwoBasicData.getItems().remove(
                    tableTwoBasicData.getSelectionModel().getSelectedItem()
            );
        } else {
            viewFactory.showAlertValidation((Stage) tableTwoBasicData.getScene().getWindow(),
                    "TABLE 2: //Set Node Configuration (SET NODE)",
                    "Seleccione una fila ");
        }
    }

    @FXML
    void onUpdateTableTwoBasicData(ActionEvent event) {
        if (!tableTwoBasicData.getSelectionModel().isEmpty()) {
            _baseController = new TableTwoConfigBasicDataController(
                    viewFactory,
                    "form/configbasicdata/TableTwoConfigBasicData.fxml",
                    tableTwoBasicData,
                    mmlPreviewTableTwoBasicData,
                    true);
            viewFactory.showModalStage(
                    (Stage) tableTwoBasicData.getScene().getWindow(),
                    _baseController,
                    "TABLE 2: //Set Node Configuration (SET NODE)");
        } else {
            viewFactory.showAlertValidation((Stage) tableTwoBasicData.getScene().getWindow(),
                    "TABLE 2: //Set Node Configuration (SET NODE)",
                    "Seleccione una fila ");
        }
    }

    private void setTextAreaTableTwo() {
        mmlPreviewTableTwoBasicData.clear();
        tableTwoBasicData.getItems().forEach((basicData) -> {
            TableTwoBasicData t = (TableTwoBasicData) basicData;
            if (t.getParameterId().equals("REFERENCE")) {
                mmlPreviewTableTwoBasicData.appendText("//");
            }
            if (t.getParameterId().equals("CREATE")
                    || t.getParameterId().equals("DELETE")) {
                mmlPreviewTableTwoBasicData.appendText(""
                        + "SET NODE:=\"" + t.getProductType() + "\","
                        + "=\"" + t.getUserLabel() + "\","
                        + "=\"" + t.getNeRmVersion() + "\","
                        + "=\"" + t.getNodeId() + "\","
                        + "=\"" + t.getNodeName() + "\","
                        + "=\"" + t.getWorkingMode() + "\";");
            }

        });
    }

    @FXML
    void onAddTableThreeBasicData(ActionEvent event) {
        if (tableThreeBasicData.getItems().size() <8) {
            _baseController = new TableThreeConfigBasicDataController(
                    viewFactory,
                    "form/configbasicdata/TableThreeConfigBasicData.fxml",
                    tableThreeBasicData,
                    mmlPreviewTableThreeBasicData,
                    false);
            viewFactory.showModalStage(
                    (Stage) tableThreeBasicData.getScene().getWindow(),
                    _baseController,
                    "TABLE 3: //Location Information");
        } else {
            viewFactory.showAlertValidation((Stage) tableThreeBasicData.getScene().getWindow(),
                        "TABLE 3: //Location Information",
                        "Solo se permite agregar 8 filas");
        }
    }

    @FXML
    void onDeleteTableThreeBasicData(ActionEvent event) {
        if (!tableThreeBasicData.getSelectionModel().isEmpty()) {
            tableThreeBasicData.getItems().remove(
                    tableThreeBasicData.getSelectionModel().getSelectedItem()
            );
        } else {
            viewFactory.showAlertValidation((Stage) tableThreeBasicData.getScene().getWindow(),
                    "TABLE 3: //Location Information",
                    "Seleccione una fila ");
        }
    }

    @FXML
    void onDuplicarTableThreeBasicData(ActionEvent event) {
        if (!tableThreeBasicData.getSelectionModel().isEmpty()) {
            if (_tableThreeBasicData.size() < 8) {

                TableThreeBasicData _tableThreeBasicData
                        = (TableThreeBasicData) tableThreeBasicData.getSelectionModel().getSelectedItem();
                tableThreeBasicData.getItems().addAll(
                        new TableThreeBasicData(
                                _tableThreeBasicData.getParameterId(),
                                _tableThreeBasicData.getLocationName(),
                                _tableThreeBasicData.getGcdf(),
                                _tableThreeBasicData.getLatitudeDegFormat(),
                                _tableThreeBasicData.getLongitudeDegFormat(),
                                _tableThreeBasicData.getLatitudeSecFormat(),
                                _tableThreeBasicData.getLongitudeSecFormat(),
                                _tableThreeBasicData.getLocationId(),
                                _tableThreeBasicData.getAltitude(),
                                _tableThreeBasicData.getRange(),
                                _tableThreeBasicData.getCity(),
                                _tableThreeBasicData.getRegion(),
                                _tableThreeBasicData.getAddress(),
                                _tableThreeBasicData.getOffice(),
                                _tableThreeBasicData.getContact(),
                                _tableThreeBasicData.getTelephone(),
                                _tableThreeBasicData.getUserLabel(),
                                _tableThreeBasicData.getPrecise()
                        )
                );
                setTextAreaTableThree();
            } else {
                viewFactory.showAlertValidation((Stage) tableThreeBasicData.getScene().getWindow(),
                        "TABLE 3: //Location Information",
                        "Solo se permite agregar 8 filas");
            }
        } else {
            viewFactory.showAlertValidation((Stage) tableThreeBasicData.getScene().getWindow(),
                    "TABLE 3: //Location Information",
                    "Seleccione una fila ");
        }
    }

    @FXML
    void onUpdateTableThreeBasicData(ActionEvent event) {
        if (!tableThreeBasicData.getSelectionModel().isEmpty()) {
            _baseController = new TableThreeConfigBasicDataController(
                    viewFactory,
                    "form/configbasicdata/TableThreeConfigBasicData.fxml",
                    tableThreeBasicData,
                    mmlPreviewTableThreeBasicData,
                    true);
            viewFactory.showModalStage(
                    (Stage) tableThreeBasicData.getScene().getWindow(),
                    _baseController,
                    "TABLE 3: //Location Information");
        } else {
            viewFactory.showAlertValidation((Stage) tableThreeBasicData.getScene().getWindow(),
                    "TABLE 3: //Location Information",
                    "Seleccione una fila ");
        }
    }

    private void setTextAreaTableThree() {
        mmlPreviewTableThreeBasicData.clear();
        tableThreeBasicData.getItems().forEach((basicData) -> {
            TableThreeBasicData t = (TableThreeBasicData) basicData;
            if (t.getParameterId().equals("REFERENCE")) {
                mmlPreviewTableThreeBasicData.appendText("//");
            }
            if (t.getParameterId().equals("CREATE")) {
                mmlPreviewTableThreeBasicData.appendText(""
                        + "ADD LOCATION:LOCATIONNAME=\"" + t.getLocationName() + "\","
                        + "GCDF=" + t.getGcdf() + ","
                        + "LATITUDEDEGFORMAT=" + t.getLatitudeDegFormat() + ","
                        + "LONGITUDEDEGFORMAT=" + t.getLongitudeDegFormat() + ","
                );
                if (!t.getLatitudeSecFormat().isEmpty()) {
                    mmlPreviewTableThreeBasicData.appendText(
                            "LATITUDESECFORMAT=" + t.getLatitudeSecFormat() + ",");
                }
                if (!t.getLongitudeSecFormat().isEmpty()) {
                    mmlPreviewTableThreeBasicData.appendText(
                            "LONGITUDESECFORMAT=" + t.getLatitudeSecFormat() + ",");
                }
                mmlPreviewTableThreeBasicData.appendText(
                        "LOCATIONID=" + t.getLocationId() + ","
                        + "ALTITUDE=" + t.getAltitude() + ","
                        + "RANGE=" + t.getRange() + ","
                        + "CITY=" + t.getCity() + ","
                        + "ADDRESS=" + t.getAddress() + ","
                        + "OFFICE=" + t.getOffice() + ","
                        + "CONTACT=" + t.getContact() + ","
                        + "TELEPHONE=" + t.getTelephone() + ","
                        + "USERLABEL=" + t.getUserLabel() + ","
                        + "PRECISE=" + t.getPrecise() + ";\n"
                );
            }

            if (t.getParameterId().equals("DELETE")) {
                mmlPreviewTableThreeBasicData.appendText(
                        "RMV LOCATION:LOCATIONNAME=\"" + t.getLocationName() + "\";\n"
                );
            }

        });
    }
    
    @FXML
    void onAddTableFourBasicData(ActionEvent event) {
        if (tableFourBasicData.getItems().size() <8) {
            _baseController = new TableFourConfigBasicDataController(
                    viewFactory,
                    "form/configbasicdata/TableFourConfigBasicData.fxml",
                    tableFourBasicData,
                    mmlPreviewTableFourBasicData,
                    false);
            viewFactory.showModalStage(
                    (Stage) tableFourBasicData.getScene().getWindow(),
                    _baseController,
                    "TABLE 4: //eNodeB function");
        } else {
            viewFactory.showAlertValidation((Stage) tableFourBasicData.getScene().getWindow(),
                        "TABLE 4: //eNodeB function",
                        "Solo se permite agregar 8 filas");
        }
    }
    @FXML
    void onDeleteTableFourBasicData(ActionEvent event) {
        if (!tableFourBasicData.getSelectionModel().isEmpty()) {
            tableFourBasicData.getItems().remove(
                    tableFourBasicData.getSelectionModel().getSelectedItem()
            );
        } else {
            viewFactory.showAlertValidation((Stage) tableFourBasicData.getScene().getWindow(),
                    "TABLE 4: //eNodeB function",
                    "Seleccione una fila ");
        }
    }
    @FXML
    void onUpdateTableFourBasicData(ActionEvent event) {
        if (!tableFourBasicData.getSelectionModel().isEmpty()) {
            _baseController = new TableFourConfigBasicDataController(
                    viewFactory,
                    "form/configbasicdata/TableFourConfigBasicData.fxml",
                    tableFourBasicData,
                    mmlPreviewTableFourBasicData,
                    true);
            viewFactory.showModalStage(
                    (Stage) tableFourBasicData.getScene().getWindow(),
                    _baseController,
                    "TABLE 4: //eNodeB function");
        } else {
            viewFactory.showAlertValidation((Stage) tableFourBasicData.getScene().getWindow(),
                    "TABLE 4: //eNodeB function",
                    "Seleccione una fila ");
        }
    }
    
    private void setTextAreaTableFour() {
        mmlPreviewTableFourBasicData.clear();
        tableFourBasicData.getItems().forEach((basicData) -> {
            TableFourBasicData t = (TableFourBasicData) basicData;
            if (t.getParameterId().equals("REFERENCE")) {
                mmlPreviewTableFourBasicData.appendText("//\n");
            }
            if (t.getParameterId().equals("CREATE")) {
                mmlPreviewTableFourBasicData.appendText(""
                        + "ADD ENODEBFUNCTION:eNodeBFunctionName=\"" + t.geteNodeBFunctionName() + "\","
                        + "ApplicationRef=" + t.getAppRef() + ","
                        + "eNodeBId=" + t.getEnodebId() + ";"
                );
               
            }

            if (t.getParameterId().equals("DELETE")) {
                mmlPreviewTableFourBasicData.appendText(
                        "RMV ENODEBFUNCTION:ENODEBFUNCTIONNAME=\"" + t.geteNodeBFunctionName()+ "\";\n"
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
        TableColumn parameterIdCol = new TableColumn("Parameter Name");
        parameterIdCol.setMinWidth(200);
        parameterIdCol.setCellValueFactory(
                new PropertyValueFactory<TableOneBasicData, String>("parameterId"));
        parameterIdCol.setSortType(TableColumn.SortType.DESCENDING);

        TableColumn neNameCol = new TableColumn("Network Element Name");
        neNameCol.setMinWidth(200);
        neNameCol.setCellValueFactory(
                new PropertyValueFactory<TableOneBasicData, String>("neName"));
        neNameCol.setSortType(TableColumn.SortType.DESCENDING);

        TableColumn siteLocationCol = new TableColumn("Site Location");
        siteLocationCol.setMinWidth(200);
        siteLocationCol.setCellValueFactory(
                new PropertyValueFactory<TableOneBasicData, String>("location"));
        siteLocationCol.setSortType(TableColumn.SortType.DESCENDING);

        TableColumn didCol = new TableColumn("Deployment Identifier");
        didCol.setMinWidth(200);
        didCol.setCellValueFactory(
                new PropertyValueFactory<TableOneBasicData, String>("did"));
        didCol.setSortType(TableColumn.SortType.DESCENDING);

        TableColumn siteNameCol = new TableColumn("Site Name");
        siteNameCol.setMinWidth(200);
        siteNameCol.setCellValueFactory(
                new PropertyValueFactory<TableOneBasicData, String>("siteName"));
        siteNameCol.setSortType(TableColumn.SortType.DESCENDING);

        TableColumn userLabelCol = new TableColumn("User Label");
        userLabelCol.setMinWidth(200);
        userLabelCol.setCellValueFactory(
                new PropertyValueFactory<TableOneBasicData, String>("userLabel"));
        userLabelCol.setSortType(TableColumn.SortType.DESCENDING);

        tableOneBasicData.setItems(_tableOneBasicData);
        tableOneBasicData.getColumns().addAll(parameterIdCol,
                neNameCol,
                siteLocationCol,
                didCol,
                siteNameCol,
                userLabelCol);
        setTextAreaTableOne();

        //Table TWO Basic Data
        TableColumn parameterIdCol2 = new TableColumn("Parameter Name");
        parameterIdCol2.setMinWidth(200);
        parameterIdCol2.setCellValueFactory(
                new PropertyValueFactory<TableTwoBasicData, String>("parameterId"));
        parameterIdCol2.setSortType(TableColumn.SortType.DESCENDING);

        TableColumn productTypeCol = new TableColumn("Product Type");
        productTypeCol.setMinWidth(200);
        productTypeCol.setCellValueFactory(
                new PropertyValueFactory<TableTwoBasicData, String>("productType"));
        productTypeCol.setSortType(TableColumn.SortType.DESCENDING);

        TableColumn userLabelCol2 = new TableColumn("User Label");
        userLabelCol2.setMinWidth(200);
        userLabelCol2.setCellValueFactory(
                new PropertyValueFactory<TableTwoBasicData, String>("userLabel"));
        userLabelCol2.setSortType(TableColumn.SortType.DESCENDING);

        TableColumn neRmVersionCol = new TableColumn("NeRM Version");
        neRmVersionCol.setMinWidth(200);
        neRmVersionCol.setCellValueFactory(
                new PropertyValueFactory<TableTwoBasicData, String>("neRmVersion"));
        neRmVersionCol.setSortType(TableColumn.SortType.DESCENDING);

        TableColumn nodeIdCol = new TableColumn("Node Identifier");
        nodeIdCol.setMinWidth(200);
        nodeIdCol.setCellValueFactory(
                new PropertyValueFactory<TableTwoBasicData, String>("nodeId"));
        nodeIdCol.setSortType(TableColumn.SortType.DESCENDING);

        TableColumn nodeNameCol = new TableColumn("Node Name");
        nodeNameCol.setMinWidth(200);
        nodeNameCol.setCellValueFactory(
                new PropertyValueFactory<TableTwoBasicData, String>("nodeName"));
        nodeNameCol.setSortType(TableColumn.SortType.DESCENDING);

        TableColumn workingModeCol = new TableColumn("Working Mode");
        workingModeCol.setMinWidth(200);
        workingModeCol.setCellValueFactory(
                new PropertyValueFactory<TableTwoBasicData, String>("workingMode"));
        workingModeCol.setSortType(TableColumn.SortType.DESCENDING);

        tableTwoBasicData.setItems(_tableTwoBasicData);
        tableTwoBasicData.getColumns().addAll(parameterIdCol2,
                productTypeCol,
                userLabelCol2,
                neRmVersionCol,
                nodeIdCol,
                nodeNameCol,
                workingModeCol);
        setTextAreaTableTwo();

        //Table Three Config Basic Data
        TableColumn parameterIdCol3 = new TableColumn("Parameter Name");
        parameterIdCol3.setMinWidth(200);
        parameterIdCol3.setCellValueFactory(
                new PropertyValueFactory<TableThreeBasicData, String>("parameterId"));
        parameterIdCol3.setSortType(TableColumn.SortType.DESCENDING);

        TableColumn locationNameCol3 = new TableColumn("Location Name");
        locationNameCol3.setMinWidth(200);
        locationNameCol3.setCellValueFactory(
                new PropertyValueFactory<TableThreeBasicData, String>("locationName"));
        locationNameCol3.setSortType(TableColumn.SortType.DESCENDING);

        TableColumn gcdfCol3 = new TableColumn("Geo-coordinate Data Format");
        gcdfCol3.setMinWidth(200);
        gcdfCol3.setCellValueFactory(
                new PropertyValueFactory<TableThreeBasicData, String>("gcdf"));
        gcdfCol3.setSortType(TableColumn.SortType.DESCENDING);

        TableColumn latitudeDegFormatCol3 = new TableColumn("Latitude With Degree Format");
        latitudeDegFormatCol3.setMinWidth(200);
        latitudeDegFormatCol3.setCellValueFactory(
                new PropertyValueFactory<TableThreeBasicData, String>("latitudeDegFormat"));
        latitudeDegFormatCol3.setSortType(TableColumn.SortType.DESCENDING);

        TableColumn longitudeDegFormatCol3 = new TableColumn("Longitude With Degree Format");
        longitudeDegFormatCol3.setMinWidth(200);
        longitudeDegFormatCol3.setCellValueFactory(
                new PropertyValueFactory<TableThreeBasicData, String>("longitudeDegFormat"));
        longitudeDegFormatCol3.setSortType(TableColumn.SortType.DESCENDING);

        TableColumn latitudeSecFormatCol3 = new TableColumn("Latitude With Second Format");
        latitudeSecFormatCol3.setMinWidth(200);
        latitudeSecFormatCol3.setCellValueFactory(
                new PropertyValueFactory<TableThreeBasicData, String>("latitudeSecFormat"));
        latitudeSecFormatCol3.setSortType(TableColumn.SortType.DESCENDING);

        TableColumn longitudeSecFormatCol3 = new TableColumn("Longitude With Second Format");
        longitudeSecFormatCol3.setMinWidth(200);
        longitudeSecFormatCol3.setCellValueFactory(
                new PropertyValueFactory<TableThreeBasicData, String>("longitudeSecFormat"));
        longitudeSecFormatCol3.setSortType(TableColumn.SortType.DESCENDING);

        TableColumn locationIdCol3 = new TableColumn("Location ID");
        locationIdCol3.setMinWidth(200);
        locationIdCol3.setCellValueFactory(
                new PropertyValueFactory<TableThreeBasicData, String>("locationId"));
        locationIdCol3.setSortType(TableColumn.SortType.DESCENDING);

        TableColumn altitudeCol3 = new TableColumn("Altitude");
        altitudeCol3.setMinWidth(200);
        altitudeCol3.setCellValueFactory(
                new PropertyValueFactory<TableThreeBasicData, String>("altitude"));
        altitudeCol3.setSortType(TableColumn.SortType.DESCENDING);

        TableColumn rangeCol3 = new TableColumn("Range");
        rangeCol3.setMinWidth(200);
        rangeCol3.setCellValueFactory(
                new PropertyValueFactory<TableThreeBasicData, String>("range"));
        rangeCol3.setSortType(TableColumn.SortType.DESCENDING);

        TableColumn cityCol3 = new TableColumn("City");
        cityCol3.setMinWidth(200);
        cityCol3.setCellValueFactory(
                new PropertyValueFactory<TableThreeBasicData, String>("City"));
        cityCol3.setSortType(TableColumn.SortType.DESCENDING);

        TableColumn regionCol3 = new TableColumn("Region");
        regionCol3.setMinWidth(200);
        regionCol3.setCellValueFactory(
                new PropertyValueFactory<TableThreeBasicData, String>("region"));
        regionCol3.setSortType(TableColumn.SortType.DESCENDING);

        TableColumn addressCol3 = new TableColumn("Address");
        addressCol3.setMinWidth(200);
        addressCol3.setCellValueFactory(
                new PropertyValueFactory<TableThreeBasicData, String>("address"));
        addressCol3.setSortType(TableColumn.SortType.DESCENDING);

        TableColumn officeCol3 = new TableColumn("Office");
        officeCol3.setMinWidth(200);
        officeCol3.setCellValueFactory(
                new PropertyValueFactory<TableThreeBasicData, String>("office"));
        officeCol3.setSortType(TableColumn.SortType.DESCENDING);

        TableColumn contactCol3 = new TableColumn("Contact");
        contactCol3.setMinWidth(200);
        contactCol3.setCellValueFactory(
                new PropertyValueFactory<TableThreeBasicData, String>("contact"));
        contactCol3.setSortType(TableColumn.SortType.DESCENDING);

        TableColumn telephoneCol3 = new TableColumn("Telephone");
        telephoneCol3.setMinWidth(200);
        telephoneCol3.setCellValueFactory(
                new PropertyValueFactory<TableThreeBasicData, String>("telephone"));
        telephoneCol3.setSortType(TableColumn.SortType.DESCENDING);

        TableColumn userLabelCol3 = new TableColumn("User Label");
        userLabelCol3.setMinWidth(200);
        userLabelCol3.setCellValueFactory(
                new PropertyValueFactory<TableThreeBasicData, String>("userLabel"));
        userLabelCol3.setSortType(TableColumn.SortType.DESCENDING);

        TableColumn preciseCol3 = new TableColumn("Precise");
        preciseCol3.setMinWidth(200);
        preciseCol3.setCellValueFactory(
                new PropertyValueFactory<TableThreeBasicData, String>("precise"));
        preciseCol3.setSortType(TableColumn.SortType.DESCENDING);
        tableThreeBasicData.setItems(_tableThreeBasicData);
        tableThreeBasicData.getColumns().addAll(
                parameterIdCol3,
                locationNameCol3,
                gcdfCol3,
                latitudeDegFormatCol3,
                longitudeDegFormatCol3,
                latitudeSecFormatCol3,
                longitudeSecFormatCol3,
                locationIdCol3,
                altitudeCol3,
                rangeCol3,
                cityCol3,
                regionCol3,
                addressCol3,
                officeCol3,
                contactCol3,
                telephoneCol3,
                userLabelCol3,
                preciseCol3
        );
        setTextAreaTableThree();
        
        //Table FOUR Basic Data
        TableColumn parameterIdCol4 = new TableColumn("Parameter Name");
        parameterIdCol4.setMinWidth(200);
        parameterIdCol4.setCellValueFactory(
                new PropertyValueFactory<TableFourBasicData, String>("parameterId"));
        parameterIdCol4.setSortType(TableColumn.SortType.DESCENDING);

        TableColumn eNodeBFunctionNameCol = new TableColumn("eNodeB Function Name");
        eNodeBFunctionNameCol.setMinWidth(200);
        eNodeBFunctionNameCol.setCellValueFactory(
                new PropertyValueFactory<TableTwoBasicData, String>("eNodeBFunctionName"));
        eNodeBFunctionNameCol.setSortType(TableColumn.SortType.DESCENDING);

        TableColumn appRefCol = new TableColumn("Application Reference");
        appRefCol.setMinWidth(200);
        appRefCol.setCellValueFactory(
                new PropertyValueFactory<TableTwoBasicData, String>("appRef"));
        appRefCol.setSortType(TableColumn.SortType.DESCENDING);

        TableColumn enodebIdCol = new TableColumn("EnodeB ID");
        enodebIdCol.setMinWidth(200);
        enodebIdCol.setCellValueFactory(
                new PropertyValueFactory<TableTwoBasicData, String>("enodebId"));
        enodebIdCol.setSortType(TableColumn.SortType.DESCENDING);

        TableColumn userLabelCol4 = new TableColumn("User Label");
        userLabelCol4.setMinWidth(200);
        userLabelCol4.setCellValueFactory(
                new PropertyValueFactory<TableTwoBasicData, String>("userLabel"));
        userLabelCol4.setSortType(TableColumn.SortType.DESCENDING);

        tableFourBasicData.setItems(_tableFourBasicData);
        tableFourBasicData.getColumns().addAll(parameterIdCol4,
                eNodeBFunctionNameCol,
                appRefCol,
                enodebIdCol,
                nodeIdCol,
                userLabelCol4);
        setTextAreaTableFour();
    }

}
