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
import model.configdevicedata.TableSixDeviceData;
import view.ViewFactory;

/**
 * FXML Controller class
 *
 * @author Miguelangel
 */
public class TableSixDeviceDataController extends BaseController implements Initializable {
    private TableView tableSixDeviceData;

    private TextArea mmlPreviewTableSixDeviceData;

    private boolean isUpdate;
    
    @FXML
    private TextField crTableFiveConfigDeviceData;

    @FXML
    private TextField srnTableFiveConfigDeviceData;

    @FXML
    private ComboBox parameterIdTableFiveConfigDeviceData;
    
    public TableSixDeviceDataController(ViewFactory viewFactory, String fxmlName,
            TableView tableSixDeviceData,
            TextArea mmlPreviewTableSixDeviceDatam,
            boolean isUpdate) {
        super(viewFactory, fxmlName);
        this.tableSixDeviceData=tableSixDeviceData;
        this.mmlPreviewTableSixDeviceData=mmlPreviewTableSixDeviceData;
        this.isUpdate=isUpdate;
    }
    
    @FXML
    void onCancelTableSixConfigDeviceData(ActionEvent event) {
        viewFactory.closeStage((Stage) parameterIdTableFiveConfigDeviceData.getScene().getWindow());
    }

    @FXML
    void onTableSixConfigDeviceData(ActionEvent event) {

    }
    
    private void setTextAreaTableSix() {
        mmlPreviewTableSixDeviceData.clear();
        tableSixDeviceData.getItems().forEach((basicData) -> {
            TableSixDeviceData t = (TableSixDeviceData) basicData;
            if (t.getParameterId().equals("REFERENCE")) {
                mmlPreviewTableSixDeviceData.appendText("//\n");
            }
            if (t.getParameterId().equals("CREATE")) {
                mmlPreviewTableSixDeviceData.appendText(""
                        + "SET TZ:ZONET=" + t.getZonet() + ","
                        + "DST=" + t.getDst()+ ";\n"
                        
                );

            }

            if (t.getParameterId().equals("DELETE")) {
                mmlPreviewTableSixDeviceData.appendText(""
                        +"RMV "
                        
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
    }    
    
}
