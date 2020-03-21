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
import model.configbasicdata.TableFiveBasicData;
import view.ViewFactory;

/**
 * FXML Controller class
 *
 * @author Miguelangel
 */
public class TableFiveConfigBasicDataController extends BaseController implements Initializable {

    private TableView tableFiveBasicData;

    private TextArea mmlPreviewTableFiveBasicData;

    private boolean isUpdate;

    @FXML
    private TextField mModeTableFiveConfigBasicData;

    @FXML
    private TextField stTableFiveConfigBasicData;

    @FXML
    private ComboBox parameterIdTableFiveConfigBasicData;

    @FXML
    private TextField etTableFiveConfigBasicData;

    @FXML
    private TextField mmSetMarkTableFiveConfigBasicData;

    public TableFiveConfigBasicDataController(ViewFactory viewFactory, String fxmlName,
            TableView tableFiveBasicData,
            TextArea mmlPreviewTableFiveBasicData,
            boolean isUpdate) {
        super(viewFactory, fxmlName);
        this.tableFiveBasicData = tableFiveBasicData;
        this.mmlPreviewTableFiveBasicData = mmlPreviewTableFiveBasicData;
        this.isUpdate = isUpdate;
    }

    @FXML
    void onCancelTableFiveConfigBasicData(ActionEvent event) {
        viewFactory.closeStage((Stage) mmSetMarkTableFiveConfigBasicData.getScene().getWindow());
    }

    @FXML
    void onTableFiveConfigBasicData(ActionEvent event) {
        if (!isUpdate) {
            tableFiveBasicData.getItems().add(
                    new TableFiveBasicData(
                            parameterIdTableFiveConfigBasicData.getValue().toString(),
                            mModeTableFiveConfigBasicData.getText().toUpperCase(),
                            stTableFiveConfigBasicData.getText().toUpperCase(),
                            etTableFiveConfigBasicData.getText().toUpperCase(),
                            mmSetMarkTableFiveConfigBasicData.getText().toUpperCase()
                    )
            );
        } else {
            TableFiveBasicData _tableFiveBasicData
                    = (TableFiveBasicData) tableFiveBasicData.getSelectionModel().getSelectedItem();
            _tableFiveBasicData.setParameterId(parameterIdTableFiveConfigBasicData.getValue().toString());
            _tableFiveBasicData.setmMode(mModeTableFiveConfigBasicData.getText().toUpperCase());
            _tableFiveBasicData.setSt(stTableFiveConfigBasicData.getText().toUpperCase());
            _tableFiveBasicData.setEt(etTableFiveConfigBasicData.getText().toUpperCase());
            _tableFiveBasicData.setMmSetRemark(mmSetMarkTableFiveConfigBasicData.getText().toUpperCase());
            tableFiveBasicData.refresh();
        }
        setTextAreaTableFive();
        viewFactory.closeStage((Stage) mmSetMarkTableFiveConfigBasicData.getScene().getWindow());
    }

    private void setTextAreaTableFive() {
        mmlPreviewTableFiveBasicData.clear();
        tableFiveBasicData.getItems().forEach((basicData) -> {
            TableFiveBasicData t = (TableFiveBasicData) basicData;
            if (t.getParameterId().equals("REFERENCE")) {
                mmlPreviewTableFiveBasicData.appendText("//\n");
            }
            if (t.getParameterId().equals("CREATE")) {
                mmlPreviewTableFiveBasicData.appendText(""
                        + "SET MNTMODE:MNTMODE=" + t.getmMode() + ","
                        + "ST=" + t.getSt() + ","
                        + "ET=" + t.getEt() + ","
                        + "MMSETREMARK=" + t.getMmSetRemark() + ";"
                );

            }

            /*if (t.getParameterId().equals("DELETE")) {
                mmlPreviewTableFiveBasicData.appendText(
                        "RMV ENODEBFUNCTION:ENODEBFUNCTIONNAME=\"" + t.geteNodeBFunctionName()+ "\";\n"
                );
            }*/
        });
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        parameterIdTableFiveConfigBasicData.getItems().addAll(
                "REFERENCE",
                "CREATE",
                "DELETE"
        );

        if (isUpdate) {
            TableFiveBasicData _tableFiveBasicData
                    = (TableFiveBasicData) tableFiveBasicData.getSelectionModel().getSelectedItem();
            parameterIdTableFiveConfigBasicData.setValue(_tableFiveBasicData.getParameterId().toString());
            mModeTableFiveConfigBasicData.setText(_tableFiveBasicData.getmMode());
            stTableFiveConfigBasicData.setText(_tableFiveBasicData.getSt());
            etTableFiveConfigBasicData.setText(_tableFiveBasicData.getEt());
            mmSetMarkTableFiveConfigBasicData.setText(_tableFiveBasicData.getMmSetRemark());

        } else {
            parameterIdTableFiveConfigBasicData.setValue("REFERENCE");
        }
    }

}
