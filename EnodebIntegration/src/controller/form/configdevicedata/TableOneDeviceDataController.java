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
import model.configdevicedata.TableOneDeviceData;
import view.ViewFactory;

/**
 * FXML Controller class
 *
 * @author Miguelangel
 */
public class TableOneDeviceDataController extends BaseController implements Initializable {

    private TableView tableOneDeviceData;

    private TextArea mmlPreviewTableOneDeviceData;

    private boolean isUpdate;

    @FXML
    private TextField cnTableOneConfigDeviceData;

    @FXML
    private TextField typeTableOneConfigDeviceData;

    @FXML
    private ComboBox parameterIdTableOneConfigDeviceData;

    @FXML
    private TextField descTableOneConfigDeviceData;

    public TableOneDeviceDataController(ViewFactory viewFactory, String fxmlName,
            TableView tableOneDeviceData,
            TextArea mmlPreviewTableOneDeviceData,
            boolean isUpdate) {
        super(viewFactory, fxmlName);
        this.tableOneDeviceData = tableOneDeviceData;
        this.mmlPreviewTableOneDeviceData = mmlPreviewTableOneDeviceData;
        this.isUpdate = isUpdate;
    }

    @FXML
    void onCancelTableOneConfigDeviceData(ActionEvent event) {
        viewFactory.closeStage((Stage) descTableOneConfigDeviceData.getScene().getWindow());
    }

    @FXML
    void onTableOneConfigDeviceData(ActionEvent event) {
        if (!isUpdate) {
            tableOneDeviceData.getItems().add(
                    new TableOneDeviceData(
                            parameterIdTableOneConfigDeviceData.getValue().toString(),
                            cnTableOneConfigDeviceData.getText().toUpperCase(),
                            typeTableOneConfigDeviceData.getText().toUpperCase(),
                            descTableOneConfigDeviceData.getText().toUpperCase()
                    )
            );
        } else {
            TableOneDeviceData _tableOneDeviceData
                    = (TableOneDeviceData) tableOneDeviceData.getSelectionModel().getSelectedItem();
            _tableOneDeviceData.setParameterId(parameterIdTableOneConfigDeviceData.getValue().toString());
            _tableOneDeviceData.setCn(cnTableOneConfigDeviceData.getText().toUpperCase());
            _tableOneDeviceData.setType(typeTableOneConfigDeviceData.getText().toUpperCase());
            _tableOneDeviceData.setDesc(descTableOneConfigDeviceData.getText().toUpperCase());
            tableOneDeviceData.refresh();
        }
        setTextAreaTableOne();
        viewFactory.closeStage((Stage) descTableOneConfigDeviceData.getScene().getWindow());
    }
    
    private void setTextAreaTableOne() {
        mmlPreviewTableOneDeviceData.clear();
        tableOneDeviceData.getItems().forEach((basicData) -> {
            TableOneDeviceData t = (TableOneDeviceData) basicData;
            if (t.getParameterId().equals("REFERENCE")) {
                mmlPreviewTableOneDeviceData.appendText("//\n");
            }
            if (t.getParameterId().equals("CREATE")) {
                mmlPreviewTableOneDeviceData.appendText(""
                        + "ADD CABINET:CN=" + t.getCn() + ","
                        + "TYPE=" + t.getType() + ","
                        + "DESC=\"" + t.getDesc()+ "\";"
                );

            }

            if (t.getParameterId().equals("DELETE")) {
                mmlPreviewTableOneDeviceData.appendText(
                        "RMV CABINET:CN=" + t.getCn()+ ";\n"
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

        parameterIdTableOneConfigDeviceData.
        getItems().addAll(
                "REFERENCE",
                "CREATE",
                "DELETE"
        );

        if (isUpdate) {
            TableOneDeviceData _tableOneDeviceData
                    = (TableOneDeviceData) tableOneDeviceData.getSelectionModel().getSelectedItem();
            parameterIdTableOneConfigDeviceData.setValue(_tableOneDeviceData.getParameterId().toString());
            cnTableOneConfigDeviceData.setText(_tableOneDeviceData.getCn());
            typeTableOneConfigDeviceData.setText(_tableOneDeviceData.getType());
            descTableOneConfigDeviceData.setText(_tableOneDeviceData.getDesc());
            

        } else {
            parameterIdTableOneConfigDeviceData.setValue("REFERENCE");
        }
    }

}
