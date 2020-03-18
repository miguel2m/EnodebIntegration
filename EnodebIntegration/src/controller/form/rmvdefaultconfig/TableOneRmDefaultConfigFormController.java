/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.form.rmvdefaultconfig;

import controller.BaseController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.rmvdefaultconfig.TableOneRmvDefaultConfig;
import view.ViewFactory;

/**
 * FXML Controller class
 *
 * @author Miguelangel
 */
public class TableOneRmDefaultConfigFormController extends BaseController implements Initializable {

    private TableView tableOneRmvDefaultConfig;
    private boolean isUpdate;
    private TextArea mmlComandRmvDefault;
    @FXML
    private TextField switchTableOneFormRmv;

    @FXML
    private TextField vlanswTableOneFormRmv;

    @FXML
    private ComboBox parameterIdTableOneFormRmv;

    public TableOneRmDefaultConfigFormController(ViewFactory viewFactory, String fxmlName,
            TableView tableOneRmvDefaultConfig,
            TextArea mmlComandRmvDefault,
            boolean isUpdate) {
        super(viewFactory, fxmlName);
        this.tableOneRmvDefaultConfig = tableOneRmvDefaultConfig;
        this.mmlComandRmvDefault = mmlComandRmvDefault;
        this.isUpdate = isUpdate;
    }

    @FXML
    void onCancelTableOneFormRmv(ActionEvent event) {
        viewFactory.closeStage((Stage) vlanswTableOneFormRmv.getScene().getWindow());
    }

    @FXML
    void onTableOneFormRmv(ActionEvent event) {
        if (!switchTableOneFormRmv.getText().isEmpty()) {
            if (!vlanswTableOneFormRmv.getText().isEmpty()) {
                if (!isUpdate) {
                    tableOneRmvDefaultConfig.getItems().add(
                            new TableOneRmvDefaultConfig(
                                    parameterIdTableOneFormRmv.getValue().toString(),
                                    switchTableOneFormRmv.getText().toUpperCase(),
                                    vlanswTableOneFormRmv.getText().toUpperCase())
                    );
                } else {
                    TableOneRmvDefaultConfig _tableOneRmvDefaultConfig
                            = (TableOneRmvDefaultConfig) tableOneRmvDefaultConfig.getSelectionModel().getSelectedItem();

                    _tableOneRmvDefaultConfig.setParameterIdRmv(parameterIdTableOneFormRmv.getValue().toString());
                    _tableOneRmvDefaultConfig.setSwitchRmv(vlanswTableOneFormRmv.getText().toUpperCase());
                    _tableOneRmvDefaultConfig.setVlanScanRmv(vlanswTableOneFormRmv.getText().toUpperCase());
                    tableOneRmvDefaultConfig.refresh();
                }
                /*if (parameterIdTableOneFormRmv.getValue().equals("REFERENCE")) {
                    mmlComandRmvDefault.setText("//mml Command");
                }
                if (parameterIdTableOneFormRmv.getValue().equals("CREATE")) {
                    mmlComandRmvDefault.setText("SET DHCPSW:SWITCH="
                            + switchTableOneFormRmv.getText().toUpperCase() + ","
                            + "VLANSCANSW="
                            + vlanswTableOneFormRmv.getText().toUpperCase() + ";");
                }
                if (parameterIdTableOneFormRmv.getValue().equals("DELETE")) {
                    mmlComandRmvDefault.setText("//RMV");
                }*/
                setTextArea();
                viewFactory.closeStage((Stage) vlanswTableOneFormRmv.getScene().getWindow());
            } else {
                viewFactory.showAlertValidation(
                        (Stage) switchTableOneFormRmv.getScene().getWindow(),
                        "VLANSCANSW Vacío",
                        "VLANSCANSW no puede estar vacío");
            }
        } else {
            viewFactory.showAlertValidation(
                    (Stage) switchTableOneFormRmv.getScene().getWindow(),
                    "SWITCH Vacío",
                    "SWITCH no puede estar vacío");
        }
    }
    private void setTextArea(){
        mmlComandRmvDefault.clear();
        tableOneRmvDefaultConfig.getItems().forEach((temp) -> {
            TableOneRmvDefaultConfig t = 
                    (TableOneRmvDefaultConfig)temp;
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
        
        parameterIdTableOneFormRmv.getItems().addAll(
                "REFERENCE",
                "CREATE",
                "DELETE"
        );

        if (isUpdate) {
            TableOneRmvDefaultConfig _tableOneRmvDefaultConfig
                    = (TableOneRmvDefaultConfig) tableOneRmvDefaultConfig.getSelectionModel().getSelectedItem();
            parameterIdTableOneFormRmv.setValue(_tableOneRmvDefaultConfig.getParameterIdRmv());
            switchTableOneFormRmv.setText(_tableOneRmvDefaultConfig.getSwitchRmv());
            vlanswTableOneFormRmv.setText(_tableOneRmvDefaultConfig.getVlanScanRmv());
        }else{
            parameterIdTableOneFormRmv.setValue("REFERENCE");
        }

    }

}
