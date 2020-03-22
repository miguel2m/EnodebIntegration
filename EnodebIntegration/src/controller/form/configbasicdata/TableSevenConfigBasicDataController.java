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
import model.configbasicdata.TableSevenBasicData;
import view.ViewFactory;

/**
 * FXML Controller class
 *
 * @author Miguelangel
 */
public class TableSevenConfigBasicDataController extends BaseController implements Initializable {
    private TableView tableSevenBasicData;

    private TextArea mmlPreviewTableSevenBasicData;

    private boolean isUpdate;
    
    
    @FXML
    private TextField trackingAreaIdTableSevenConfigBasicData;

    @FXML
    private TextField cnOperatorIdTableSevenConfigBasicData;

    @FXML
    private ComboBox parameterIdTableSevenConfigBasicData;

    @FXML
    private TextField tacTableSevenConfigBasicData;
    
    public TableSevenConfigBasicDataController(ViewFactory viewFactory, String fxmlName,
            TableView tableSevenBasicData,
            TextArea mmlPreviewTableSevenBasicData,
            boolean isUpdate) {
        super(viewFactory, fxmlName);
        this.tableSevenBasicData=tableSevenBasicData;
        this.mmlPreviewTableSevenBasicData=mmlPreviewTableSevenBasicData;
        this.isUpdate=isUpdate;
    }
    @FXML
    void onCancelTableSevenConfigBasicData(ActionEvent event) {
        viewFactory.closeStage((Stage) tacTableSevenConfigBasicData.getScene().getWindow());
    }

    @FXML
    void onTableSevenConfigBasicData(ActionEvent event) {
                if (!isUpdate) {
            tableSevenBasicData.getItems().add(
                    new TableSevenBasicData(
                            parameterIdTableSevenConfigBasicData.getValue().toString(),
                            trackingAreaIdTableSevenConfigBasicData.getText().toUpperCase(),
                            cnOperatorIdTableSevenConfigBasicData.getText().toUpperCase(),
                            tacTableSevenConfigBasicData.getText().toUpperCase()
                    )
            );
        } else {
            TableSevenBasicData _tableSevenBasicData
                    = (TableSevenBasicData) tableSevenBasicData.getSelectionModel().getSelectedItem();
            _tableSevenBasicData.setParameterId(parameterIdTableSevenConfigBasicData.getValue().toString());
            _tableSevenBasicData.setTrackingAreaId(trackingAreaIdTableSevenConfigBasicData.getText().toUpperCase());
            _tableSevenBasicData.setCnOperatorId(cnOperatorIdTableSevenConfigBasicData.getText().toUpperCase());
            _tableSevenBasicData.setTac(tacTableSevenConfigBasicData.getText().toUpperCase());
            tableSevenBasicData.refresh();
        }
        setTextAreaTableSeven();
        viewFactory.closeStage((Stage) tacTableSevenConfigBasicData.getScene().getWindow());
    }    
    private void setTextAreaTableSeven() {
        mmlPreviewTableSevenBasicData.clear();
        tableSevenBasicData.getItems().forEach((basicData) -> {
            TableSevenBasicData t = (TableSevenBasicData) basicData;
            if (t.getParameterId().equals("REFERENCE")) {
                mmlPreviewTableSevenBasicData.appendText("//\n");
            }
            if (t.getParameterId().equals("CREATE")) {
                mmlPreviewTableSevenBasicData.appendText(""
                        + "ADD CNOPERATORTA:TrackingAreaId=" + t.getTrackingAreaId() + ","
                        + "CnOperatorId=" + t.getCnOperatorId() + ","
                        + "Tac=" + t.getTac() + ";"
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
        parameterIdTableSevenConfigBasicData.getItems().addAll(
                "REFERENCE",
                "CREATE",
                "DELETE"
        );

        if (isUpdate) {
            TableSevenBasicData _tableSevenBasicData
                    = (TableSevenBasicData) tableSevenBasicData.getSelectionModel().getSelectedItem();
            parameterIdTableSevenConfigBasicData.setValue(_tableSevenBasicData.getParameterId().toString());
            trackingAreaIdTableSevenConfigBasicData.setText(_tableSevenBasicData.getTrackingAreaId());
            cnOperatorIdTableSevenConfigBasicData.setText(_tableSevenBasicData.getCnOperatorId());
            tacTableSevenConfigBasicData.setText(_tableSevenBasicData.getTac());
        } else {
            parameterIdTableSevenConfigBasicData.setValue("REFERENCE");
        }
    }    
    
}
