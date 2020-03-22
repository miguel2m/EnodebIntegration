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
import model.configbasicdata.TableSixBasicData;
import view.ViewFactory;

/**
 * FXML Controller class
 *
 * @author Miguelangel
 */
public class TableSixConfigBasicDataController extends BaseController implements Initializable {
    private TableView tableSixBasicData;

    private TextArea mmlPreviewTableSixBasicData;

    private boolean isUpdate;
    
    @FXML
    private TextField cnOperatorIdTableSixConfigBasicData;

    @FXML
    private TextField cnOperatorNameTableSixConfigBasicData;

    @FXML
    private ComboBox parameterIdTableSixConfigBasicData;

    @FXML
    private TextField cnOperatorTypeTableSixConfigBasicData;

    @FXML
    private TextField mccTableSixConfigBasicData;

    @FXML
    private TextField mncTableSixConfigBasicData;
    
    public TableSixConfigBasicDataController(ViewFactory viewFactory, String fxmlName,
            TableView tableSixBasicData,
            TextArea mmlPreviewTableSixBasicData,
            boolean isUpdate) {
        super(viewFactory, fxmlName);
        this.tableSixBasicData=tableSixBasicData;
        this.mmlPreviewTableSixBasicData=mmlPreviewTableSixBasicData;
        this.isUpdate=isUpdate;
    }
    
    @FXML
    void onCancelTableSixConfigBasicData(ActionEvent event) {
        viewFactory.closeStage((Stage) mncTableSixConfigBasicData.getScene().getWindow());
    }

    @FXML
    void onTableSixConfigBasicData(ActionEvent event) {
        if (!isUpdate) {
            tableSixBasicData.getItems().add(
                    new TableSixBasicData(
                            parameterIdTableSixConfigBasicData.getValue().toString(),
                            cnOperatorIdTableSixConfigBasicData.getText().toUpperCase(),
                            cnOperatorNameTableSixConfigBasicData.getText().toUpperCase(),
                            cnOperatorTypeTableSixConfigBasicData.getText().toUpperCase(),
                            mccTableSixConfigBasicData.getText().toUpperCase(),
                            mncTableSixConfigBasicData.getText().toUpperCase()
                    )
            );
        } else {
            TableSixBasicData _tableSixBasicData
                    = (TableSixBasicData) tableSixBasicData.getSelectionModel().getSelectedItem();
            _tableSixBasicData.setParameterId(parameterIdTableSixConfigBasicData.getValue().toString());
            _tableSixBasicData.setCnOperatorId(cnOperatorIdTableSixConfigBasicData.getText().toUpperCase());
            _tableSixBasicData.setCnOperatorName(cnOperatorNameTableSixConfigBasicData.getText().toUpperCase());
            _tableSixBasicData.setCnOperatorType(cnOperatorTypeTableSixConfigBasicData.getText().toUpperCase());
            _tableSixBasicData.setMcc(mccTableSixConfigBasicData.getText().toUpperCase());
            _tableSixBasicData.setMnc(mncTableSixConfigBasicData.getText().toUpperCase());
            tableSixBasicData.refresh();
        }
        setTextAreaTableSix();
        viewFactory.closeStage((Stage) mncTableSixConfigBasicData.getScene().getWindow());
    }
    
    private void setTextAreaTableSix() {
        mmlPreviewTableSixBasicData.clear();
        tableSixBasicData.getItems().forEach((basicData) -> {
            TableSixBasicData t = (TableSixBasicData) basicData;
            if (t.getParameterId().equals("REFERENCE")) {
                mmlPreviewTableSixBasicData.appendText("//\n");
            }
            if (t.getParameterId().equals("CREATE")) {
                mmlPreviewTableSixBasicData.appendText(""
                        + "ADD CNOPERATOR:CnOperatorId=" + t.getCnOperatorId() + ","
                        + "CnOperatorName=\"" + t.getCnOperatorName() + "\","
                        + "CnOperatorType=\"" + t.getCnOperatorType() + "\","
                        + "MCC=\"" + t.getMcc() + "\","
                        + "MNC=\"" + t.getMnc() + "\";"
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
        parameterIdTableSixConfigBasicData.getItems().addAll(
                "REFERENCE",
                "CREATE",
                "DELETE"
        );

        if (isUpdate) {
            TableSixBasicData _tableSixBasicData
                    = (TableSixBasicData) tableSixBasicData.getSelectionModel().getSelectedItem();
            parameterIdTableSixConfigBasicData.setValue(_tableSixBasicData.getParameterId().toString());
            cnOperatorIdTableSixConfigBasicData.setText(_tableSixBasicData.getCnOperatorId());
            cnOperatorNameTableSixConfigBasicData.setText(_tableSixBasicData.getCnOperatorName());
            cnOperatorTypeTableSixConfigBasicData.setText(_tableSixBasicData.getCnOperatorType());
            mccTableSixConfigBasicData.setText(_tableSixBasicData.getMcc());
            mncTableSixConfigBasicData.setText(_tableSixBasicData.getMnc());
        } else {
            parameterIdTableSixConfigBasicData.setValue("REFERENCE");
        }
    }    
    
}
