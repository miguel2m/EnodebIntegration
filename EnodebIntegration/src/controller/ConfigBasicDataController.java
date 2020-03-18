/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.form.configbasicdata.TableOneConfigBasicDataController;
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
import model.configbasicdata.TableOneBasicData;
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
    private BaseController _baseController;
    @FXML
    private TableView tableOneBasicData;

    @FXML
    private TextArea mmlPreviewTableOneBasicData;
    
    @FXML
    private TableView tableTwoBasicData;

    @FXML
    private TextArea mmlPreviewTableTwoBasicData;
    
    public ConfigBasicDataController(ViewFactory viewFactory, String fxmlName,
               ObservableList<TableOneBasicData> _tableOneBasicData,
               ObservableList<TableTwoBasicData> _tableTwoBasicData) {
        super(viewFactory, fxmlName);
        this._tableOneBasicData=_tableOneBasicData;
        this._tableTwoBasicData=_tableTwoBasicData;
    }
    
    
    @FXML
    void onAddTableOneBasicData(ActionEvent event) {
        if(_tableOneBasicData.isEmpty()){
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
        }else{
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
    
    private void setTextAreaTableOne(){
        mmlPreviewTableOneBasicData.clear();
        _tableOneBasicData.forEach((t) -> {
            if(t.getParameterId().equals("REFERENCE"))
                mmlPreviewTableOneBasicData.appendText("//");
            if(t.getParameterId().equals("CREATE")||
                    t.getParameterId().equals("DELETE"))
                mmlPreviewTableOneBasicData.appendText(""+
                        "SET NE:NENAME=\""+t.getNeName()+"\","+
                        "LOCATION=\""+t.getLocation()+"\","+
                        "SITENAME=\""+t.getSiteName()+"\","+
                        "USERLABEL=\""+t.getUserLabel()+"\";");
            
        });
    }
    
    @FXML
    void onAddTableTwoBasicData(ActionEvent event) {
        if(_tableOneBasicData.isEmpty()){
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
        }else{
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
            if (t.getParameterId().equals("CREATE")|| 
                    t.getParameterId().equals("DELETE")) {
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
        
        
    }    
    
}
