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
import model.configdevicedata.TableFourDeviceData;
import view.ViewFactory;

/**
 * FXML Controller class
 *
 * @author Miguelangel
 */
public class TableFourDeviceDataController extends BaseController implements Initializable {
    private TableView tableFourDeviceData;

    private TextArea mmlPreviewTableFourDeviceData;

    private boolean isUpdate;
    
     @FXML
    private TextField rncTableFourConfigDeviceData;

    @FXML
    private TextField ttTableFourConfigDeviceData;

    @FXML
    private ComboBox parameterIdTableFourConfigDeviceData;

    @FXML
    private TextField bmTableFourConfigDeviceData;

    @FXML
    private TextField atTableFourConfigDeviceData;

    @FXML
    private TextField hcnTableFourConfigDeviceData;

    @FXML
    private TextField hsrnTableFourConfigDeviceData;

    @FXML
    private TextField hsnTableFourConfigDeviceData;

    @FXML
    private TextField hpnTableFourConfigDeviceData;

    @FXML
    private TextField tcnTableFourConfigDeviceData;

    @FXML
    private TextField tsrnTableFourConfigDeviceData;

    @FXML
    private TextField tsnTableFourConfigDeviceData;

    @FXML
    private TextField tpnTableFourConfigDeviceData;

    @FXML
    private TextField crTableFourConfigDeviceData;
    
    
    
    public TableFourDeviceDataController(ViewFactory viewFactory, String fxmlName,
            TableView tableFourDeviceData,
            TextArea mmlPreviewTableFourDeviceData,
            boolean isUpdate) {
        super(viewFactory, fxmlName);
        this.tableFourDeviceData=tableFourDeviceData;
        this.mmlPreviewTableFourDeviceData=mmlPreviewTableFourDeviceData;
        this.isUpdate=isUpdate;
    }
    
    @FXML
    void onCancelTableFourConfigDeviceData(ActionEvent event) {
        viewFactory.closeStage((Stage) crTableFourConfigDeviceData.getScene().getWindow());
    }

    @FXML
    void onTableFourConfigDeviceData(ActionEvent event) {
        if (!isUpdate) {
            tableFourDeviceData.getItems().add(
                    new TableFourDeviceData(
                            parameterIdTableFourConfigDeviceData.getValue().toString(),
                            rncTableFourConfigDeviceData.getText().toUpperCase(),
                            ttTableFourConfigDeviceData.getText().toUpperCase(),
                            bmTableFourConfigDeviceData.getText().toUpperCase(),
                            atTableFourConfigDeviceData.getText().toUpperCase(),
                            hcnTableFourConfigDeviceData.getText().toUpperCase(),
                            hsrnTableFourConfigDeviceData.getText().toUpperCase(),
                            hsnTableFourConfigDeviceData.getText().toUpperCase(),
                            hpnTableFourConfigDeviceData.getText().toUpperCase(),
                            tcnTableFourConfigDeviceData.getText().toUpperCase(),
                            tsrnTableFourConfigDeviceData.getText().toUpperCase(),
                            tsnTableFourConfigDeviceData.getText().toUpperCase(),
                            tpnTableFourConfigDeviceData.getText().toUpperCase(),
                            crTableFourConfigDeviceData.getText().toUpperCase()
                            
                    )
            );
        } else {
            TableFourDeviceData _tableFourDeviceData
                    = (TableFourDeviceData) tableFourDeviceData.getSelectionModel().getSelectedItem();
            _tableFourDeviceData.setParameterId(parameterIdTableFourConfigDeviceData.getValue().toString());
            _tableFourDeviceData.setRnc(rncTableFourConfigDeviceData.getText().toUpperCase());
            _tableFourDeviceData.setTt(ttTableFourConfigDeviceData.getText().toUpperCase());
            _tableFourDeviceData.setBm(bmTableFourConfigDeviceData.getText().toUpperCase());
            _tableFourDeviceData.setAt(atTableFourConfigDeviceData.getText().toUpperCase());
            _tableFourDeviceData.setHcn(hcnTableFourConfigDeviceData.getText().toUpperCase());
            _tableFourDeviceData.setHsrn(hsrnTableFourConfigDeviceData.getText().toUpperCase());
            _tableFourDeviceData.setHsn(hsnTableFourConfigDeviceData.getText().toUpperCase());
            _tableFourDeviceData.setHpn(hpnTableFourConfigDeviceData.getText().toUpperCase());
            _tableFourDeviceData.setTcn(tcnTableFourConfigDeviceData.getText().toUpperCase());
            _tableFourDeviceData.setTsrn(tsrnTableFourConfigDeviceData.getText().toUpperCase());
            _tableFourDeviceData.setTsn(tsnTableFourConfigDeviceData.getText().toUpperCase());
            _tableFourDeviceData.setTpn(tpnTableFourConfigDeviceData.getText().toUpperCase());
            _tableFourDeviceData.setCr(crTableFourConfigDeviceData.getText().toUpperCase());
            
            tableFourDeviceData.refresh();
        }
        setTextAreaTableFour();
        viewFactory.closeStage((Stage) crTableFourConfigDeviceData.getScene().getWindow());
    }
    
    private void setTextAreaTableFour() {
        mmlPreviewTableFourDeviceData.clear();
        tableFourDeviceData.getItems().forEach((basicData) -> {
            TableFourDeviceData t = (TableFourDeviceData) basicData;
            if (t.getParameterId().equals("REFERENCE")) {
                mmlPreviewTableFourDeviceData.appendText("//\n");
            }
            if (t.getParameterId().equals("CREATE")) {
                mmlPreviewTableFourDeviceData.appendText(""
                        + "ADD RRUCHAIN:RCN=" + t.getRnc() + ","
                        + "TT=" + t.getTt() + ","
                        + "BM=" + t.getBm()+ ","
                        + "AT=" + t.getAt()+ ","      
                        + "HCN=" + t.getHcn()+ ","
                        + "HSRN=" + t.getHsrn()+ ","
                        + "HSN=" + t.getHsn()+ ","
                        + "HPN=" + t.getHpn()+ ","
                        + "TCN=" + t.getTcn()+ ","
                        + "TSRN=" + t.getTsrn()+ ","
                        + "TSN=" + t.getTsn()+ ","
                        + "TPN=" + t.getTpn()+ ","
                        + "CR=" + t.getCr()+ ";\n"
                );

            }

            if (t.getParameterId().equals("DELETE")) {
                mmlPreviewTableFourDeviceData.appendText(""
                        +"RMV RRUCHAIN:RCN=" + t.getRnc()+ ";\n"
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
        parameterIdTableFourConfigDeviceData.
                getItems().addAll(
                        "REFERENCE",
                        "CREATE",
                        "DELETE"
                );

        if (isUpdate) {
            TableFourDeviceData _tableFourDeviceData
                    = (TableFourDeviceData) tableFourDeviceData.getSelectionModel().getSelectedItem();
            parameterIdTableFourConfigDeviceData.setValue(_tableFourDeviceData.getParameterId().toString());
            rncTableFourConfigDeviceData.setText(_tableFourDeviceData.getRnc());
            ttTableFourConfigDeviceData.setText(_tableFourDeviceData.getTt());
            bmTableFourConfigDeviceData.setText(_tableFourDeviceData.getBm());
            atTableFourConfigDeviceData.setText(_tableFourDeviceData.getAt());
            hcnTableFourConfigDeviceData.setText(_tableFourDeviceData.getHcn());
            hsrnTableFourConfigDeviceData.setText(_tableFourDeviceData.getHsrn());
            hsnTableFourConfigDeviceData.setText(_tableFourDeviceData.getHsn());
            hpnTableFourConfigDeviceData.setText(_tableFourDeviceData.getHpn());
            tcnTableFourConfigDeviceData.setText(_tableFourDeviceData.getTcn());
            tsrnTableFourConfigDeviceData.setText(_tableFourDeviceData.getTsrn());
            tsnTableFourConfigDeviceData.setText(_tableFourDeviceData.getTsn());
            tpnTableFourConfigDeviceData.setText(_tableFourDeviceData.getTpn());
            crTableFourConfigDeviceData.setText(_tableFourDeviceData.getCr());
        } else {
            parameterIdTableFourConfigDeviceData.setValue("REFERENCE");
        }
    }    
    
}
