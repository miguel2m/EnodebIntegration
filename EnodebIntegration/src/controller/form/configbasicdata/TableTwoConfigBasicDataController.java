/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.form.configbasicdata;

import controller.BaseController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.configbasicdata.TableTwoBasicData;
import view.ViewFactory;

/**
 * FXML Controller class
 *
 * @author Miguelangel
 */
public class TableTwoConfigBasicDataController extends BaseController implements Initializable {

    private TableView tableTwoBasicData;
    private TextArea mmlPreviewTableTwoBasicData;
    private boolean isUpdate;

    @FXML
    private TextField productTypeTableTwoConfigBasicData;

    @FXML
    private TextField userLabelTableTwoConfigBasicData;

    @FXML
    private ComboBox parameterIdTableTwoConfigBasicData;

    @FXML
    private TextField nermVersionTableTwoConfigBasicData;

    @FXML
    private TextField nodeIdTableTwoConfigBasicData;

    @FXML
    private TextField nodeNameTableTwoConfigBasicData;

    @FXML
    private TextField workingModeTableTwoConfigBasicData;

    public TableTwoConfigBasicDataController(ViewFactory viewFactory, String fxmlName,
            TableView tableTwoBasicData,
            TextArea mmlPreviewTableTwoBasicData,
            boolean isUpdate) {
        super(viewFactory, fxmlName);
        this.tableTwoBasicData = tableTwoBasicData;
        this.mmlPreviewTableTwoBasicData = mmlPreviewTableTwoBasicData;
        this.isUpdate = isUpdate;
    }

    @FXML
    void onCancelTableTwoConfigBasicData(ActionEvent event) {
        viewFactory.closeStage((Stage) workingModeTableTwoConfigBasicData.getScene().getWindow());
    }

    @FXML
    void onTableTwoConfigBasicData(ActionEvent event) {
        if (!productTypeTableTwoConfigBasicData.getText().isEmpty()) {
            if (!userLabelTableTwoConfigBasicData.getText().isEmpty()) {
                if (!userLabelTableTwoConfigBasicData.getText().isEmpty()) {
                    if (!nermVersionTableTwoConfigBasicData.getText().isEmpty()) {
                        if (!nodeIdTableTwoConfigBasicData.getText().isEmpty()) {
                            if (!nodeNameTableTwoConfigBasicData.getText().isEmpty()) {
                                if (!workingModeTableTwoConfigBasicData.getText().isEmpty()) {
                                    if (!isUpdate) {
                                        tableTwoBasicData.getItems().add(
                                                new TableTwoBasicData(
                                                        parameterIdTableTwoConfigBasicData.getValue().toString(),
                                                        productTypeTableTwoConfigBasicData.getText().toUpperCase(),
                                                        userLabelTableTwoConfigBasicData.getText().toUpperCase(),
                                                        nermVersionTableTwoConfigBasicData.getText().toUpperCase(),
                                                        nodeIdTableTwoConfigBasicData.getText().toUpperCase(),
                                                        nodeNameTableTwoConfigBasicData.getText().toUpperCase(),
                                                        workingModeTableTwoConfigBasicData.getText().toUpperCase()
                                                )
                                        );
                                    } else {
                                        TableTwoBasicData basicData
                                                = (TableTwoBasicData) tableTwoBasicData.getSelectionModel().getSelectedItem();
                                        basicData.setParameterId(parameterIdTableTwoConfigBasicData.getValue().toString());
                                        basicData.setProductType(productTypeTableTwoConfigBasicData.getText().toUpperCase());
                                        basicData.setUserLabel(userLabelTableTwoConfigBasicData.getText().toUpperCase());
                                        basicData.setNeRmVersion(nermVersionTableTwoConfigBasicData.getText().toUpperCase());
                                        basicData.setNodeId(nodeIdTableTwoConfigBasicData.getText().toUpperCase());
                                        basicData.setNodeName(nodeNameTableTwoConfigBasicData.getText().toUpperCase());
                                        basicData.setWorkingMode(workingModeTableTwoConfigBasicData.getText().toUpperCase());
                                        tableTwoBasicData.refresh();
                                    }
                                    setTextAreaTableTwo();
                                    viewFactory.closeStage((Stage) parameterIdTableTwoConfigBasicData.getScene().getWindow());
                                } else {
                                    viewFactory.showAlertValidation(
                                            (Stage) nodeIdTableTwoConfigBasicData.getScene().getWindow(),
                                            "WORKING MODE Vacío",
                                            "WORKING MODE  no puede estar vacío");
                                }
                            } else {
                                viewFactory.showAlertValidation(
                                        (Stage) nodeIdTableTwoConfigBasicData.getScene().getWindow(),
                                        "NODE NAME Vacío",
                                        "NODE NAME  no puede estar vacío");
                            }
                        } else {
                            viewFactory.showAlertValidation(
                                    (Stage) nodeIdTableTwoConfigBasicData.getScene().getWindow(),
                                    "NODE ID Vacío",
                                    "NODE ID  no puede estar vacío");
                        }
                    } else {
                        viewFactory.showAlertValidation(
                                (Stage) parameterIdTableTwoConfigBasicData.getScene().getWindow(),
                                "SITE NAME Vacío",
                                "SITE NAME  no puede estar vacío");
                    }
                } else {
                    viewFactory.showAlertValidation(
                            (Stage) productTypeTableTwoConfigBasicData.getScene().getWindow(),
                            "NeRM Version Vacío",
                            "NeRM Version no puede estar vacío");
                }
            } else {
                userLabelTableTwoConfigBasicData.setText("-");

            }
        } else {
            viewFactory.showAlertValidation(
                    (Stage) productTypeTableTwoConfigBasicData.getScene().getWindow(),
                    "Product Type Vacío",
                    "Product Type no puede estar vacío");
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        parameterIdTableTwoConfigBasicData.getItems().addAll(
                "REFERENCE",
                "CREATE",
                "DELETE"
        );

        if (isUpdate) {
            TableTwoBasicData basicData
                    = (TableTwoBasicData) tableTwoBasicData.getSelectionModel().getSelectedItem();
            parameterIdTableTwoConfigBasicData.setValue(basicData.getParameterId());
            productTypeTableTwoConfigBasicData.setText(basicData.getProductType());
            userLabelTableTwoConfigBasicData.setText(basicData.getUserLabel());
            nermVersionTableTwoConfigBasicData.setText(basicData.getNeRmVersion());
            nodeIdTableTwoConfigBasicData.setText(basicData.getNodeId());
            nodeNameTableTwoConfigBasicData.setText(basicData.getNodeName());
            workingModeTableTwoConfigBasicData.setText(basicData.getWorkingMode());
        } else {
            parameterIdTableTwoConfigBasicData.setValue("REFERENCE");
        }
    }

}
