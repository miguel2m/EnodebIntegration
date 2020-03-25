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
import model.configdevicedata.TableFiveDeviceData;
import view.ViewFactory;

/**
 * FXML Controller class
 *
 * @author Miguelangel
 */
public class TableFiveDeviceDataController extends BaseController implements Initializable {
    private TableView tableFiveDeviceData;

    private TextArea mmlPreviewTableFiveDeviceData;

    private boolean isUpdate;
    
    @FXML
    private TextField crTableFiveConfigDeviceData;

    @FXML
    private TextField srnTableFiveConfigDeviceData;

    @FXML
    private ComboBox parameterIdTableFiveConfigDeviceData;

    @FXML
    private TextField snTableFiveConfigDeviceData;

    @FXML
    private TextField tpTableFiveConfigDeviceData;

    @FXML
    private TextField rncTableFiveConfigDeviceData;

    @FXML
    private TextField psTableFiveConfigDeviceData;

    @FXML
    private TextField rtTableFiveConfigDeviceData;

    @FXML
    private TextField rsTableFiveConfigDeviceData;

    @FXML
    private TextField rnTableFiveConfigDeviceData;

    @FXML
    private TextField rxnumTableFiveConfigDeviceData;

    @FXML
    private TextField txnumTableFiveConfigDeviceData;

    @FXML
    private TextField almprocswTableFiveConfigDeviceData;

    @FXML
    private TextField almprocthrhldTableFiveConfigDeviceData;
    
    @FXML
    private TextField almthrhldTableFiveConfigDeviceData;

    @FXML
    private TextField ifoffsetTableFiveConfigDeviceData;

    @FXML
    private TextField rfdsTableFiveConfigDeviceData;

    @FXML
    private TextField lcpswTableFiveConfigDeviceData;

    @FXML
    private TextField flagTableFiveConfigDeviceData;

    @FXML
    private TextField ruspecTableFiveConfigDeviceData;

    @FXML
    private TextField paeffswitchTableFiveConfigDeviceData;

    
    public TableFiveDeviceDataController(ViewFactory viewFactory, String fxmlName,
            TableView tableFiveDeviceData,
            TextArea mmlPreviewTableFiveDeviceData,
            boolean isUpdate) {
        super(viewFactory, fxmlName);
        this.tableFiveDeviceData=tableFiveDeviceData;
        this.mmlPreviewTableFiveDeviceData=mmlPreviewTableFiveDeviceData;
        this.isUpdate=isUpdate;
    }
    
    @FXML
    void onCancelTableFiveConfigDeviceData(ActionEvent event) {
        viewFactory.closeStage((Stage) paeffswitchTableFiveConfigDeviceData.getScene().getWindow());
    }

    @FXML
    void onTableFiveConfigDeviceData(ActionEvent event) {
        if (!isUpdate) {
            tableFiveDeviceData.getItems().add(
                    new TableFiveDeviceData(
                            parameterIdTableFiveConfigDeviceData.getValue().toString(),
                            crTableFiveConfigDeviceData.getText().toUpperCase(),
                            srnTableFiveConfigDeviceData.getText().toUpperCase(),
                            snTableFiveConfigDeviceData.getText().toUpperCase(),
                            tpTableFiveConfigDeviceData.getText().toUpperCase(),
                            rncTableFiveConfigDeviceData.getText().toUpperCase(),
                            psTableFiveConfigDeviceData.getText().toUpperCase(),
                            rtTableFiveConfigDeviceData.getText().toUpperCase(),
                            rsTableFiveConfigDeviceData.getText().toUpperCase(),
                            rnTableFiveConfigDeviceData.getText().toUpperCase(),
                            rxnumTableFiveConfigDeviceData.getText().toUpperCase(),
                            txnumTableFiveConfigDeviceData.getText().toUpperCase(),
                            almprocswTableFiveConfigDeviceData.getText().toUpperCase(),
                            almprocthrhldTableFiveConfigDeviceData.getText().toUpperCase(),
                            almthrhldTableFiveConfigDeviceData.getText().toUpperCase(),
                            ifoffsetTableFiveConfigDeviceData.getText().toUpperCase(),
                            rfdsTableFiveConfigDeviceData.getText().toUpperCase(),
                            lcpswTableFiveConfigDeviceData.getText().toUpperCase(),
                            flagTableFiveConfigDeviceData.getText().toUpperCase(),
                            ruspecTableFiveConfigDeviceData.getText().toUpperCase(),
                            paeffswitchTableFiveConfigDeviceData.getText().toUpperCase()
                            
                            
                    )
            );
        } else {
            TableFiveDeviceData _tableFiveDeviceData
                    = (TableFiveDeviceData) tableFiveDeviceData.getSelectionModel().getSelectedItem();
            _tableFiveDeviceData.setParameterId(parameterIdTableFiveConfigDeviceData.getValue().toString());
            _tableFiveDeviceData.setCn(crTableFiveConfigDeviceData.getText().toUpperCase());
            _tableFiveDeviceData.setSrn(srnTableFiveConfigDeviceData.getText().toUpperCase());
            _tableFiveDeviceData.setSn(snTableFiveConfigDeviceData.getText().toUpperCase());
            _tableFiveDeviceData.setTp(tpTableFiveConfigDeviceData.getText().toUpperCase());
            _tableFiveDeviceData.setRnc(rncTableFiveConfigDeviceData.getText().toUpperCase());
            _tableFiveDeviceData.setPs(psTableFiveConfigDeviceData.getText().toUpperCase());
            _tableFiveDeviceData.setRt(rtTableFiveConfigDeviceData.getText().toUpperCase());
            _tableFiveDeviceData.setRs(rsTableFiveConfigDeviceData.getText().toUpperCase());
            _tableFiveDeviceData.setRn(rnTableFiveConfigDeviceData.getText().toUpperCase());
            _tableFiveDeviceData.setRxnum(rxnumTableFiveConfigDeviceData.getText().toUpperCase());
            _tableFiveDeviceData.setTxnum(txnumTableFiveConfigDeviceData.getText().toUpperCase());
            _tableFiveDeviceData.setAlmprocsw(almprocswTableFiveConfigDeviceData.getText().toUpperCase());
            _tableFiveDeviceData.setAlmprocthrhld(almprocthrhldTableFiveConfigDeviceData.getText().toUpperCase());
            _tableFiveDeviceData.setAlmthrhld(almthrhldTableFiveConfigDeviceData.getText().toUpperCase());
            _tableFiveDeviceData.setIfoffset(ifoffsetTableFiveConfigDeviceData.getText().toUpperCase());
            _tableFiveDeviceData.setRfds(rfdsTableFiveConfigDeviceData.getText().toUpperCase());
            _tableFiveDeviceData.setLcpsw(lcpswTableFiveConfigDeviceData.getText().toUpperCase());
            _tableFiveDeviceData.setFlag(flagTableFiveConfigDeviceData.getText().toUpperCase());
            _tableFiveDeviceData.setRuspec(ruspecTableFiveConfigDeviceData.getText().toUpperCase());
            _tableFiveDeviceData.setPaeffswitch(paeffswitchTableFiveConfigDeviceData.getText().toUpperCase());
            
            tableFiveDeviceData.refresh();
        }
        setTextAreaTableFive();
        viewFactory.closeStage((Stage) paeffswitchTableFiveConfigDeviceData.getScene().getWindow());
    }
    
    private void setTextAreaTableFive() {
        mmlPreviewTableFiveDeviceData.clear();
        tableFiveDeviceData.getItems().forEach((basicData) -> {
            TableFiveDeviceData t = (TableFiveDeviceData) basicData;
            if (t.getParameterId().equals("REFERENCE")) {
                mmlPreviewTableFiveDeviceData.appendText("//\n");
            }
            if (t.getParameterId().equals("CREATE")) {
                mmlPreviewTableFiveDeviceData.appendText(""
                        + "ADD RRU:CN=" + t.getCn() + ","
                        + "SRN=" + t.getSrn() + ","
                        + "SN=" + t.getSn()+ ","
                        + "TP=" + t.getTp()+ ","      
                        + "RNC=" + t.getRnc()+ ","
                        + "PS=" + t.getPs()+ ","
                        + "RT=" + t.getRt()+ ","
                        + "RS=" + t.getRs()+ ","
                        + "RN=" + t.getRn()+ ","
                        + "RXNUM=" + t.getRxnum()+ ","
                        + "TXNUM=" + t.getTxnum()+ ","
                        + "ALMPROCSW=" + t.getAlmprocsw()+ ","
                        + "ALMPROCTHRHLD=" + t.getAlmprocthrhld()+ ","
                        + "ALMTHRHLD=" + t.getAlmthrhld()+ ","
                        + "IFOFFSET=" + t.getIfoffset()+ ","
                        + "RFDS=" + t.getRfds()+ ","
                        + "LCPSW=" + t.getLcpsw()+ ","
                        + "FLAG=" + t.getFlag()+ ","
                        + "RUSPEC=" + t.getRuspec()+ ","        
                        + "PAEFFSWITCH=" + t.getPaeffswitch()+ ";\n"
                );

            }

            if (t.getParameterId().equals("DELETE")) {
                mmlPreviewTableFiveDeviceData.appendText(""
                        +"RMV RRU:CN=" + t.getCn()+ ","
                        +"SRN=" + t.getSrn()+ ","
                        +"SN=" + t.getSn()+ ";\n"
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
        parameterIdTableFiveConfigDeviceData.
                getItems().addAll(
                        "REFERENCE",
                        "CREATE",
                        "DELETE"
                );

        if (isUpdate) {
            TableFiveDeviceData _tableFiveDeviceData
                    = (TableFiveDeviceData) tableFiveDeviceData.getSelectionModel().getSelectedItem();
            parameterIdTableFiveConfigDeviceData.setValue(_tableFiveDeviceData.getParameterId().toString());
            crTableFiveConfigDeviceData.setText(_tableFiveDeviceData.getRnc());
            srnTableFiveConfigDeviceData.setText(_tableFiveDeviceData.getSrn());
            snTableFiveConfigDeviceData.setText(_tableFiveDeviceData.getSn());
            tpTableFiveConfigDeviceData.setText(_tableFiveDeviceData.getTp());
            rncTableFiveConfigDeviceData.setText(_tableFiveDeviceData.getRnc());
            psTableFiveConfigDeviceData.setText(_tableFiveDeviceData.getPs());
            rtTableFiveConfigDeviceData.setText(_tableFiveDeviceData.getRt());
            rsTableFiveConfigDeviceData.setText(_tableFiveDeviceData.getRs());
            rnTableFiveConfigDeviceData.setText(_tableFiveDeviceData.getRn());
            rxnumTableFiveConfigDeviceData.setText(_tableFiveDeviceData.getRxnum());
            txnumTableFiveConfigDeviceData.setText(_tableFiveDeviceData.getTxnum());
            almprocswTableFiveConfigDeviceData.setText(_tableFiveDeviceData.getAlmprocsw());
            almprocthrhldTableFiveConfigDeviceData.setText(_tableFiveDeviceData.getAlmprocthrhld());
            almthrhldTableFiveConfigDeviceData.setText(_tableFiveDeviceData.getAlmthrhld());
            ifoffsetTableFiveConfigDeviceData.setText(_tableFiveDeviceData.getIfoffset());
            rfdsTableFiveConfigDeviceData.setText(_tableFiveDeviceData.getRfds());
            lcpswTableFiveConfigDeviceData.setText(_tableFiveDeviceData.getLcpsw());
            flagTableFiveConfigDeviceData.setText(_tableFiveDeviceData.getFlag());
            ruspecTableFiveConfigDeviceData.setText(_tableFiveDeviceData.getRuspec());
            paeffswitchTableFiveConfigDeviceData.setText(_tableFiveDeviceData.getPaeffswitch());
            
            
        } else {
            parameterIdTableFiveConfigDeviceData.setValue("REFERENCE");
        }
    }    
    
}
