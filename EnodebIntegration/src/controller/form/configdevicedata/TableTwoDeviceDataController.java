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
import model.configdevicedata.TableTwoDeviceData;
import view.ViewFactory;

/**
 * FXML Controller class
 *
 * @author Miguelangel
 */
public class TableTwoDeviceDataController extends BaseController implements Initializable {

    private TableView tableTwoDeviceData;

    private TextArea mmlPreviewTableTwoDeviceData;

    private boolean isUpdate;

    @FXML
    private TextField cnTableTwoConfigDeviceData;

    @FXML
    private TextField srnTableTwoConfigDeviceData;

    @FXML
    private ComboBox parameterIdTableTwoConfigDeviceData;

    @FXML
    private TextField typeTableTwoConfigDeviceData;

    @FXML
    private TextField descTableTwoConfigDeviceData1;

    public TableTwoDeviceDataController(ViewFactory viewFactory, String fxmlName,
            TableView tableTwoDeviceData,
            TextArea mmlPreviewTableTwoDeviceData,
            boolean isUpdate) {
        super(viewFactory, fxmlName);
        this.tableTwoDeviceData = tableTwoDeviceData;
        this.mmlPreviewTableTwoDeviceData = mmlPreviewTableTwoDeviceData;
        this.isUpdate = isUpdate;
    }

    @FXML
    void onCancelTableTwoConfigDeviceData(ActionEvent event) {
        viewFactory.closeStage((Stage) descTableTwoConfigDeviceData1.getScene().getWindow());
    }

    @FXML
    void onTableTwoConfigDeviceData(ActionEvent event) {
        if (!isUpdate) {
            tableTwoDeviceData.getItems().add(
                    new TableTwoDeviceData(
                            parameterIdTableTwoConfigDeviceData.getValue().toString(),
                            cnTableTwoConfigDeviceData.getText().toUpperCase(),
                            srnTableTwoConfigDeviceData.getText().toUpperCase(),
                            typeTableTwoConfigDeviceData.getText().toUpperCase(),
                            descTableTwoConfigDeviceData1.getText().toUpperCase()
                    )
            );
        } else {
            TableTwoDeviceData _tableTwoDeviceData
                    = (TableTwoDeviceData) tableTwoDeviceData.getSelectionModel().getSelectedItem();
            _tableTwoDeviceData.setParameterId(parameterIdTableTwoConfigDeviceData.getValue().toString());
            _tableTwoDeviceData.setCn(cnTableTwoConfigDeviceData.getText().toUpperCase());
            _tableTwoDeviceData.setSrn(srnTableTwoConfigDeviceData.getText().toUpperCase());
            _tableTwoDeviceData.setType(typeTableTwoConfigDeviceData.getText().toUpperCase());
            _tableTwoDeviceData.setDesc(descTableTwoConfigDeviceData1.getText().toUpperCase());
            tableTwoDeviceData.refresh();
        }
        setTextAreaTableTwo();
        viewFactory.closeStage((Stage) descTableTwoConfigDeviceData1.getScene().getWindow());
    }

    private void setTextAreaTableTwo() {
        mmlPreviewTableTwoDeviceData.clear();
        tableTwoDeviceData.getItems().forEach((basicData) -> {
            TableTwoDeviceData t = (TableTwoDeviceData) basicData;
            if (t.getParameterId().equals("REFERENCE")) {
                mmlPreviewTableTwoDeviceData.appendText("//\n");
            }
            if (t.getParameterId().equals("CREATE")) {
                mmlPreviewTableTwoDeviceData.appendText(""
                        + "ADD SUBRACK:CN=" + t.getCn() + ","
                        + "SRN=" + t.getSrn() + ","
                        + "TYPE=" + t.getType() + ","
                        + "DESC=\"" + t.getDesc() + "\";"
                );

            }

            if (t.getParameterId().equals("DELETE")) {
                mmlPreviewTableTwoDeviceData.appendText(
                        "RMV SUBRACK:CN=" + t.getCn() + ";\n"
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
        parameterIdTableTwoConfigDeviceData.
        getItems().addAll(
                "REFERENCE",
                "CREATE",
                "DELETE"
        );

        if (isUpdate) {
            TableTwoDeviceData _tableTwoDeviceData
                    = (TableTwoDeviceData) tableTwoDeviceData.getSelectionModel().getSelectedItem();
            parameterIdTableTwoConfigDeviceData.setValue(_tableTwoDeviceData.getParameterId().toString());
            cnTableTwoConfigDeviceData.setText(_tableTwoDeviceData.getCn());
            srnTableTwoConfigDeviceData.setText(_tableTwoDeviceData.getSrn());
            typeTableTwoConfigDeviceData.setText(_tableTwoDeviceData.getType());
            descTableTwoConfigDeviceData1.setText(_tableTwoDeviceData.getDesc());

        } else {
            parameterIdTableTwoConfigDeviceData.setValue("REFERENCE");
        }
    }

}
