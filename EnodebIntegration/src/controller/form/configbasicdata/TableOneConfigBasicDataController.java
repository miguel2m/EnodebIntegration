/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.form.configbasicdata;

import controller.BaseController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.configbasicdata.TableOneBasicData;
import view.ViewFactory;

/**
 * FXML Controller class
 *
 * @author Miguelangel
 */
public class TableOneConfigBasicDataController extends BaseController implements Initializable {

    private TableView tableOneBasicData;
    private TextArea mmlPreviewTableOneBasicData;
    private boolean isUpdate;

    @FXML
    private TextField neNameTableOneConfigBasicData;

    @FXML
    private TextField locationTableOneConfigBasicData;

    @FXML
    private ComboBox parameterIdTableOneConfigBasicData;

    @FXML
    private TextField didTableOneConfigBasicData;

    @FXML
    private TextField siteNameTableOneConfigBasicData;

    @FXML
    private TextField userLabelTableOneConfigBasicData;

    public TableOneConfigBasicDataController(ViewFactory viewFactory, String fxmlName,
            TableView tableOneBasicData,
            TextArea mmlPreviewTableOneBasicData,
            boolean isUpdate) {
        super(viewFactory, fxmlName);
        this.tableOneBasicData = tableOneBasicData;
        this.mmlPreviewTableOneBasicData = mmlPreviewTableOneBasicData;
        this.isUpdate = isUpdate;
    }

    @FXML
    void onCancelTableOneConfigBasicData(ActionEvent event) {
        viewFactory.closeStage((Stage) userLabelTableOneConfigBasicData.getScene().getWindow());
    }

    @FXML
    void onTableOneConfigBasicData(ActionEvent event) {
        if (!neNameTableOneConfigBasicData.getText().isEmpty()) {
            if (!locationTableOneConfigBasicData.getText().isEmpty()) {
                if (!didTableOneConfigBasicData.getText().isEmpty()) {
                    if (!siteNameTableOneConfigBasicData.getText().isEmpty()) {
                        if (!userLabelTableOneConfigBasicData.getText().isEmpty()) {
                            if (!isUpdate) {
                                tableOneBasicData.getItems().add(
                                        new TableOneBasicData(
                                                parameterIdTableOneConfigBasicData.getValue().toString(),
                                                neNameTableOneConfigBasicData.getText().toUpperCase(),
                                                locationTableOneConfigBasicData.getText().toUpperCase(),
                                                didTableOneConfigBasicData.getText().toUpperCase(),
                                                siteNameTableOneConfigBasicData.getText().toUpperCase(),
                                                userLabelTableOneConfigBasicData.getText().toUpperCase()
                                        )
                                );
                            } else {
                                TableOneBasicData basicData
                                        = (TableOneBasicData) tableOneBasicData.getSelectionModel().getSelectedItem();
                                basicData.setParameterId( parameterIdTableOneConfigBasicData.getValue().toString());
                                basicData.setNeName(neNameTableOneConfigBasicData.getText().toUpperCase());
                                basicData.setLocation(locationTableOneConfigBasicData.getText().toUpperCase());
                                basicData.setDid(didTableOneConfigBasicData.getText().toUpperCase());
                                basicData.setSiteName(siteNameTableOneConfigBasicData.getText().toUpperCase());
                                basicData.setUserLabel(userLabelTableOneConfigBasicData.getText().toUpperCase());
                                tableOneBasicData.refresh();
                            }
                            setTextAreaTableOne();
                            viewFactory.closeStage((Stage) userLabelTableOneConfigBasicData.getScene().getWindow());
                        } else {
                            viewFactory.showAlertValidation(
                                    (Stage) neNameTableOneConfigBasicData.getScene().getWindow(),
                                    "USER LABEL Vacío",
                                    "USER LABEL  no puede estar vacío");
                        }
                    } else {
                        viewFactory.showAlertValidation(
                                (Stage) neNameTableOneConfigBasicData.getScene().getWindow(),
                                "SITE NAME Vacío",
                                "SITE NAME  no puede estar vacío");
                    }
                } else {
                    didTableOneConfigBasicData.setText("-");
                }
            } else {
                viewFactory.showAlertValidation(
                        (Stage) neNameTableOneConfigBasicData.getScene().getWindow(),
                        "LOCATION Vacío",
                        "LOCATION no puede estar vacío");
            }
        } else {
            viewFactory.showAlertValidation(
                    (Stage) neNameTableOneConfigBasicData.getScene().getWindow(),
                    "NE NAME Vacío",
                    "NE NAME no puede estar vacío");
        }
    }

    private void setTextAreaTableOne() {
        mmlPreviewTableOneBasicData.clear();
        tableOneBasicData.getItems().forEach((basicData) -> {
            TableOneBasicData t = (TableOneBasicData) basicData;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        parameterIdTableOneConfigBasicData.getItems().addAll(
                "REFERENCE",
                "CREATE",
                "DELETE"
        );
        
        if (isUpdate) {
            TableOneBasicData basicData
                    = (TableOneBasicData) tableOneBasicData.getSelectionModel().getSelectedItem();
            parameterIdTableOneConfigBasicData.setValue(basicData.getParameterId());
            neNameTableOneConfigBasicData.setText(basicData.getNeName());
            locationTableOneConfigBasicData.setText(basicData.getLocation());
            didTableOneConfigBasicData.setText(basicData.getDid());
            siteNameTableOneConfigBasicData.setText(basicData.getSiteName());
            userLabelTableOneConfigBasicData.setText(basicData.getUserLabel());

        } else {
            parameterIdTableOneConfigBasicData.setValue("REFERENCE");
        }
    }

}
