/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.form.rmvdefaultconfig.TableOneRmDefaultConfigFormController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.initiallyconfig.TableOneConfigEnodeb;
import model.rmvdefaultconfig.TableOneRmvDefaultConfig;
import view.ViewFactory;

/**
 * FXML Controller class
 *
 * @author P05144
 */
public class RmvDefaultConfigController extends BaseController implements Initializable {
    private ObservableList<TableOneRmvDefaultConfig> _rmvConfigTableOne = FXCollections.observableArrayList();
    private BaseController _baseController;
    @FXML
    private TableView tableOneRmvDefault;

    @FXML
    private TextArea mmlComandRmvDefault;
    public RmvDefaultConfigController(ViewFactory viewFactory, String fxmlName,
            ObservableList<TableOneRmvDefaultConfig> _rmvConfigTableOne) {
        super(viewFactory, fxmlName);
        this._rmvConfigTableOne =_rmvConfigTableOne;
    }
    
    
    @FXML
    void onAddTableOneRmvDefault(ActionEvent event) {
        if(_rmvConfigTableOne.isEmpty()){
            _baseController = new TableOneRmDefaultConfigFormController(
                    viewFactory,
                    "form/rmvdefaultconfig/TableOneRmDefaultConfigForm.fxml",
                    tableOneRmvDefault,
                    mmlComandRmvDefault,
                    false);
            viewFactory.showModalStage(
                    (Stage) tableOneRmvDefault.getScene().getWindow(),
                    _baseController,
                    "Table 1: tableOneRmvDefault");
        }else{
            viewFactory.showAlertValidation((Stage) tableOneRmvDefault.getScene().getWindow(),
                    "Table 1: tableOneRmvDefault",
                    "Solo se permite agregar una fila ");
        }
    }

    @FXML
    void onDeleteTableOneRmvDefault(ActionEvent event) {
        if (!tableOneRmvDefault.getSelectionModel().isEmpty()) {
            tableOneRmvDefault.getItems().remove(
                    tableOneRmvDefault.getSelectionModel().getSelectedItem()
            );
        } else {
            viewFactory.showAlertValidation((Stage) tableOneRmvDefault.getScene().getWindow(),
                    "Table 1: tableOneRmvDefault",
                    "Seleccione una fila ");
        }
    }

    @FXML
    void onUpdateTableOneRmvDefault(ActionEvent event) {
        if (!tableOneRmvDefault.getSelectionModel().isEmpty()) {
            _baseController = new TableOneRmDefaultConfigFormController(
                    viewFactory,
                    "form/rmvdefaultconfig/TableOneRmDefaultConfigForm.fxml",
                    tableOneRmvDefault,
                    mmlComandRmvDefault,
                    true);
            viewFactory.showModalStage(
                    (Stage) tableOneRmvDefault.getScene().getWindow(),
                    _baseController,
                    "Table 1: tableOneRmvDefault");
        } else {
            viewFactory.showAlertValidation((Stage) tableOneRmvDefault.getScene().getWindow(),
                    "Table 1: tableOneRmvDefault",
                    "Seleccione una fila ");
        }
    }
    private void setTextArea(){
        mmlComandRmvDefault.clear();
        _rmvConfigTableOne.forEach((t) -> {
            if(t.getParameterIdRmv().equals("REFERENCE"))
                mmlComandRmvDefault.setText("//");
            if(t.getParameterIdRmv().equals("CREATE"))
                mmlComandRmvDefault.setText("SET DHCPSW:SWITCH="
                            + t.getSwitchRmv() + ","
                            + "VLANSCANSW="
                            + t.getVlanScanRmv() + ";");
            if(t.getParameterIdRmv().equals("DELETE"))
                mmlComandRmvDefault.setText("//RMV");
        });
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //Table One rmvDefault
        TableColumn parameterIdRmvCol = new TableColumn("Parameter ID");
        parameterIdRmvCol.setMinWidth(200);
        parameterIdRmvCol.setCellValueFactory(
                new PropertyValueFactory<TableOneRmvDefaultConfig, String>("parameterIdRmv"));
        parameterIdRmvCol.setSortType(TableColumn.SortType.DESCENDING);

        TableColumn switchRmvCol = new TableColumn("SWITCH");
        switchRmvCol.setMinWidth(200);
        switchRmvCol.setCellValueFactory(
                new PropertyValueFactory<TableOneRmvDefaultConfig, String>("switchRmv"));
        switchRmvCol.setSortType(TableColumn.SortType.DESCENDING);

        TableColumn vlanScanRmvCol = new TableColumn("VLANSCANSW");
        vlanScanRmvCol.setMinWidth(200);
        vlanScanRmvCol.setCellValueFactory(
                new PropertyValueFactory<TableOneRmvDefaultConfig, String>("vlanScanRmv"));
        vlanScanRmvCol.setSortType(TableColumn.SortType.DESCENDING);

        
        tableOneRmvDefault.setItems(_rmvConfigTableOne);
        tableOneRmvDefault.getColumns().addAll(
                parameterIdRmvCol,
                switchRmvCol,
                vlanScanRmvCol);
        setTextArea();

    }    
    
}
