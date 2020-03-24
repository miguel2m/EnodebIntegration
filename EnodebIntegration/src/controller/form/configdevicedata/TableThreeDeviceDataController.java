/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.form.configdevicedata;

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
import model.configdevicedata.TableThreeDeviceData;
import view.ViewFactory;

/**
 * FXML Controller class
 *
 * @author Miguelangel
 */
public class TableThreeDeviceDataController extends BaseController implements Initializable {

    private TableView tableThreeDeviceData;

    private TextArea mmlPreviewTableThreeDeviceData;

    private boolean isUpdate;

    @FXML
    private TextField cnTableThreeConfigDeviceData;

    @FXML
    private TextField srnTableThreeConfigDeviceData;

    @FXML
    private ComboBox parameterIdTableThreeConfigDeviceData;

    @FXML
    private TextField snTableThreeConfigDeviceData;

    @FXML
    private TextField btTableThreeConfigDeviceData;

    @FXML
    private TextField sbtTableThreeConfigDeviceData;

    @FXML
    private TextField bbwsTableThreeConfigDeviceData;

    @FXML
    private TextField hceTableThreeConfigDeviceData;

    @FXML
    private TextField cpriexTableThreeConfigDeviceData;

    @FXML
    private TextField brdspecTableThreeConfigDeviceData;

    @FXML
    private TextField ccneTableThreeConfigDeviceData;

    public TableThreeDeviceDataController(ViewFactory viewFactory, String fxmlName,
            TableView tableThreeDeviceData,
            TextArea mmlPreviewTableThreeDeviceData,
            boolean isUpdate) {
        super(viewFactory, fxmlName);
        this.tableThreeDeviceData = tableThreeDeviceData;
        this.mmlPreviewTableThreeDeviceData = mmlPreviewTableThreeDeviceData;
        this.isUpdate = isUpdate;
    }

    @FXML
    void onCancelTableThreeConfigDeviceData(ActionEvent event) {
        viewFactory.closeStage((Stage) ccneTableThreeConfigDeviceData.getScene().getWindow());
    }

    @FXML
    void onTableThreeConfigDeviceData(ActionEvent event) {
        if (!isUpdate) {
            tableThreeDeviceData.getItems().add(
                    new TableThreeDeviceData(
                            parameterIdTableThreeConfigDeviceData.getValue().toString(),
                            cnTableThreeConfigDeviceData.getText().toUpperCase(),
                            srnTableThreeConfigDeviceData.getText().toUpperCase(),
                            snTableThreeConfigDeviceData.getText().toUpperCase(),
                            btTableThreeConfigDeviceData.getText().toUpperCase(),
                            sbtTableThreeConfigDeviceData.getText().toUpperCase(),
                            bbwsTableThreeConfigDeviceData.getText().toUpperCase(),
                            hceTableThreeConfigDeviceData.getText().toUpperCase(),
                            cpriexTableThreeConfigDeviceData.getText().toUpperCase(),
                            brdspecTableThreeConfigDeviceData.getText().toUpperCase(),
                            ccneTableThreeConfigDeviceData.getText().toUpperCase()
                    )
            );
        } else {
            TableThreeDeviceData _tableThreeDeviceData
                    = (TableThreeDeviceData) tableThreeDeviceData.getSelectionModel().getSelectedItem();
            _tableThreeDeviceData.setParameterId(parameterIdTableThreeConfigDeviceData.getValue().toString());
            _tableThreeDeviceData.setCn(cnTableThreeConfigDeviceData.getText().toUpperCase());
            _tableThreeDeviceData.setSrn(srnTableThreeConfigDeviceData.getText().toUpperCase());
            _tableThreeDeviceData.setSn(snTableThreeConfigDeviceData.getText().toUpperCase());
            _tableThreeDeviceData.setBt(btTableThreeConfigDeviceData.getText().toUpperCase());
            _tableThreeDeviceData.setSbt(sbtTableThreeConfigDeviceData.getText().toUpperCase());
            _tableThreeDeviceData.setBbws(bbwsTableThreeConfigDeviceData.getText().toUpperCase());
            _tableThreeDeviceData.setHce(hceTableThreeConfigDeviceData.getText().toUpperCase());
            _tableThreeDeviceData.setCpriex(cpriexTableThreeConfigDeviceData.getText().toUpperCase());
            _tableThreeDeviceData.setBrdspec(brdspecTableThreeConfigDeviceData.getText().toUpperCase());
            _tableThreeDeviceData.setCcne(ccneTableThreeConfigDeviceData.getText().toUpperCase());
            
            tableThreeDeviceData.refresh();
        }
        setTextAreaTableThree();
        viewFactory.closeStage((Stage) ccneTableThreeConfigDeviceData.getScene().getWindow());
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
                        + "SN=" + t.getSn() + ","
                        + "BT=" + t.getBt() + ","
                        + "SBT=" + t.getSbt() + ","
                        + "BBWS=" + t.getBbws() + ","
                        + "HCE=" + t.getHce() + ","
                        + "CPRIEX=" + t.getCpriex() + ","
                        + "BRDSPEC=" + t.getBrdspec() + ","
                        + "CCNE=" + t.getCcne() + ";\n"
                );

            }

            if (t.getParameterId().equals("DELETE")) {
                mmlPreviewTableThreeDeviceData.appendText(""
                        + "RMV BRD:CN=" + t.getCn() + ","
                        + "SRN=" + t.getSrn() + ","
                        + "SN=" + t.getSn() + ";\n"
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
        parameterIdTableThreeConfigDeviceData.
                getItems().addAll(
                        "REFERENCE",
                        "CREATE",
                        "DELETE"
                );

        if (isUpdate) {
            TableThreeDeviceData _tableThreeDeviceData
                    = (TableThreeDeviceData) tableThreeDeviceData.getSelectionModel().getSelectedItem();
            parameterIdTableThreeConfigDeviceData.setValue(_tableThreeDeviceData.getParameterId().toString());
            cnTableThreeConfigDeviceData.setText(_tableThreeDeviceData.getCn());
            srnTableThreeConfigDeviceData.setText(_tableThreeDeviceData.getSrn());
            snTableThreeConfigDeviceData.setText(_tableThreeDeviceData.getSn());
            btTableThreeConfigDeviceData.setText(_tableThreeDeviceData.getBt());
            sbtTableThreeConfigDeviceData.setText(_tableThreeDeviceData.getSbt());
            bbwsTableThreeConfigDeviceData.setText(_tableThreeDeviceData.getBbws());
            hceTableThreeConfigDeviceData.setText(_tableThreeDeviceData.getHce());
            cpriexTableThreeConfigDeviceData.setText(_tableThreeDeviceData.getCpriex());
            brdspecTableThreeConfigDeviceData.setText(_tableThreeDeviceData.getBrdspec());
            ccneTableThreeConfigDeviceData.setText(_tableThreeDeviceData.getCcne());
        } else {
            parameterIdTableThreeConfigDeviceData.setValue("REFERENCE");
        }
    }

}
