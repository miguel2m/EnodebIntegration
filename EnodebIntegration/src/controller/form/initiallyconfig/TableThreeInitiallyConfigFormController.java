/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.form.initiallyconfig;

import controller.BaseController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.initiallyconfig.TableThreeConfigEnodeb;
import view.ViewFactory;

/**
 * FXML Controller class
 *
 * @author Miguelangel
 */
public class TableThreeInitiallyConfigFormController extends BaseController implements Initializable {

    private TableView tableInitConfigThree;
    private boolean isUpdate;

    @FXML
    private TextField cellTableThreeInitConfig;

    @FXML
    private TextField trxModeTableThreeInitConfig;

    @FXML
    private TextField pciTableThreeInitConfig;

    @FXML
    private TextField downlinkTableThreeInitConfig;

    public TableThreeInitiallyConfigFormController(ViewFactory viewFactory, String fxmlName,
            TableView tableInitConfigThree,
            boolean isUpdate) {
        super(viewFactory, fxmlName);
        this.tableInitConfigThree = tableInitConfigThree;
        this.isUpdate = isUpdate;
    }

    @FXML
    void onCancelTableThreeInitConfig(ActionEvent event) {
        viewFactory.closeStage((Stage) cellTableThreeInitConfig.getScene().getWindow());
    }

    @FXML
    void onTableThreeInitConfig(ActionEvent event) {
        if (!cellTableThreeInitConfig.getText().isEmpty()) {
            if (!trxModeTableThreeInitConfig.getText().isEmpty()) {
                if (!pciTableThreeInitConfig.getText().isEmpty()) {
                    if (!downlinkTableThreeInitConfig.getText().isEmpty()) {
                        if (!isUpdate) {
                            tableInitConfigThree.getItems().add(
                                    new TableThreeConfigEnodeb(
                                            cellTableThreeInitConfig.getText().toUpperCase(),
                                            trxModeTableThreeInitConfig.getText().toUpperCase(),
                                            pciTableThreeInitConfig.getText().toUpperCase(),
                                            downlinkTableThreeInitConfig.getText().toUpperCase()
                                    )
                            );
                        } else {
                            TableThreeConfigEnodeb _tableThreeConfigEnodeb
                                    = (TableThreeConfigEnodeb) tableInitConfigThree.getSelectionModel().getSelectedItem();
                            _tableThreeConfigEnodeb.setCell(cellTableThreeInitConfig.getText().toUpperCase());
                            _tableThreeConfigEnodeb.setTxrxMode(trxModeTableThreeInitConfig.getText().toUpperCase());
                            _tableThreeConfigEnodeb.setPci(pciTableThreeInitConfig.getText().toUpperCase());
                            _tableThreeConfigEnodeb.setDownlink(downlinkTableThreeInitConfig.getText().toUpperCase());
                            tableInitConfigThree.refresh();
                        }
                        viewFactory.closeStage((Stage) cellTableThreeInitConfig.getScene().getWindow());
                    } else {
                        viewFactory.showAlertValidation(
                                (Stage) cellTableThreeInitConfig.getScene().getWindow(),
                                "Downlink EARFCN Vacío",
                                "Downlink EARFCN no puede estar vacío");
                    }
                } else {
                    viewFactory.showAlertValidation(
                            (Stage) cellTableThreeInitConfig.getScene().getWindow(),
                            "PCI Vacío",
                            "PCI no puede estar vacío");
                }
            } else {
                viewFactory.showAlertValidation(
                        (Stage) cellTableThreeInitConfig.getScene().getWindow(),
                        "TX/RX MODE Vacío",
                        "TX/RX MODE no puede estar vacío");
            }
        } else {
            viewFactory.showAlertValidation(
                    (Stage) cellTableThreeInitConfig.getScene().getWindow(),
                    "CELL Vacío",
                    "CELL no puede estar vacío");
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        if (isUpdate) {
            TableThreeConfigEnodeb _tableThreeConfigEnodeb
                    = (TableThreeConfigEnodeb) tableInitConfigThree.getSelectionModel().getSelectedItem();
            cellTableThreeInitConfig.setText(_tableThreeConfigEnodeb.getCell());
            trxModeTableThreeInitConfig.setText(_tableThreeConfigEnodeb.getTxrxMode());
            pciTableThreeInitConfig.setText(_tableThreeConfigEnodeb.getPci());
            downlinkTableThreeInitConfig.setText(_tableThreeConfigEnodeb.getDownlink());
        }
    }

}
