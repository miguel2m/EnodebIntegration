/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.form.configbasicdata.TableOneConfigBasicDataController;
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
import model.rmvdefaultconfig.TableOneRmvDefaultConfig;
import view.ViewFactory;

/**
 * FXML Controller class
 *
 * @author P05144
 */
public class ConfigBasicDataController extends BaseController implements Initializable {
    private ObservableList<TableOneBasicData> _tableOneBasicData = FXCollections.observableArrayList();
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
               ObservableList<TableOneBasicData> _tableOneBasicData ) {
        super(viewFactory, fxmlName);
        this._tableOneBasicData=_tableOneBasicData;
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
                    "Table 1: NE configuration attributes");
        }else{
            viewFactory.showAlertValidation((Stage) tableOneBasicData.getScene().getWindow(),
                    "Table 1: NE configuration attributes",
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
                    "Table 1: NE configuration attributes",
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
                    "Table 1: NE configuration attributes");
        } else {
            viewFactory.showAlertValidation((Stage) tableOneBasicData.getScene().getWindow(),
                    "Table 1: NE configuration attributes",
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

    }
    @FXML
    void onDeleteTableTwoBasicData(ActionEvent event) {

    }
    @FXML
    void onUpdateTableTwoBasicData(ActionEvent event) {

    }
    private void setTextAreaTableTwo(){
        mmlPreviewTableTwoBasicData.clear();
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
        
        
    }    
    
}
