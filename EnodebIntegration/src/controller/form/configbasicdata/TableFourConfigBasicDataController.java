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
import model.configbasicdata.TableFourBasicData;
import view.ViewFactory;

/**
 * FXML Controller class
 *
 * @author Miguelangel
 */
public class TableFourConfigBasicDataController extends BaseController implements Initializable {
    private TableView tableFourBasicData;

    private TextArea mmlPreviewTableFourBasicData;

    private boolean isUpdate;
    @FXML
    private TextField eNodeBFunctionNameTableFourConfigBasicData;

    @FXML
    private TextField applicationReferenceTableFourConfigBasicData;

    @FXML
    private ComboBox parameterIdTableFourConfigBasicData;

    @FXML
    private TextField eNodeBIdTableFourConfigBasicData;

    @FXML
    private TextField userLabelTableFourConfigBasicData;
    public TableFourConfigBasicDataController(ViewFactory viewFactory, String fxmlName,
            TableView tableFourBasicData,
            TextArea mmlPreviewTableFourBasicData,
            boolean isUpdate) {
        super(viewFactory, fxmlName);
        this.tableFourBasicData=tableFourBasicData;
        this.mmlPreviewTableFourBasicData=mmlPreviewTableFourBasicData;
        this.isUpdate=isUpdate;
    }

    @FXML
    void onCancelTableFourConfigBasicData(ActionEvent event) {
        viewFactory.closeStage((Stage) userLabelTableFourConfigBasicData.getScene().getWindow());
    }

    @FXML
    void onTableFourConfigBasicData(ActionEvent event) {
        if(!isUpdate){
            tableFourBasicData.getItems().add(
                    new TableFourBasicData(
                            parameterIdTableFourConfigBasicData.getValue().toString(),
                            eNodeBFunctionNameTableFourConfigBasicData.getText().toUpperCase(),
                            applicationReferenceTableFourConfigBasicData.getText().toUpperCase(),
                            eNodeBIdTableFourConfigBasicData.getText().toUpperCase(),
                            userLabelTableFourConfigBasicData.getText().toUpperCase())
            );
        }else{
            TableFourBasicData _basicData = 
                 (TableFourBasicData) tableFourBasicData.getSelectionModel().getSelectedItem();
            _basicData.setParameterId(parameterIdTableFourConfigBasicData.getValue().toString());
            _basicData.seteNodeBFunctionName(eNodeBFunctionNameTableFourConfigBasicData.getText().toUpperCase());
            _basicData.setAppRef(applicationReferenceTableFourConfigBasicData.getText().toUpperCase());
            _basicData.setEnodebId(eNodeBIdTableFourConfigBasicData.getText().toUpperCase());
            _basicData.setUserLabel(userLabelTableFourConfigBasicData.getText().toUpperCase());
            tableFourBasicData.refresh();
        }
        setTextAreaTableFour();
        viewFactory.closeStage((Stage) userLabelTableFourConfigBasicData.getScene().getWindow());
    }
    
    private void setTextAreaTableFour() {
        mmlPreviewTableFourBasicData.clear();
        tableFourBasicData.getItems().forEach((basicData) -> {
            TableFourBasicData t = (TableFourBasicData) basicData;
            if (t.getParameterId().equals("REFERENCE")) {
                mmlPreviewTableFourBasicData.appendText("//\n");
            }
            if (t.getParameterId().equals("CREATE")) {
                mmlPreviewTableFourBasicData.appendText(""
                        + "ADD ENODEBFUNCTION:eNodeBFunctionName=\"" + t.geteNodeBFunctionName() + "\","
                        + "ApplicationRef=" + t.getAppRef() + ","
                        + "eNodeBId=" + t.getEnodebId() + ";"
                );
               
            }

            if (t.getParameterId().equals("DELETE")) {
                mmlPreviewTableFourBasicData.appendText(
                        "RMV ENODEBFUNCTION:ENODEBFUNCTIONNAME=\"" + t.geteNodeBFunctionName()+ "\";\n"
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
        parameterIdTableFourConfigBasicData.getItems().addAll(
                "REFERENCE",
                "CREATE",
                "DELETE"
        );

        if (isUpdate) {
            TableFourBasicData _tableFourBasicData
                    = (TableFourBasicData) tableFourBasicData.getSelectionModel().getSelectedItem();
            parameterIdTableFourConfigBasicData.setValue(_tableFourBasicData.getParameterId());
            eNodeBFunctionNameTableFourConfigBasicData.setText(_tableFourBasicData.geteNodeBFunctionName());
            applicationReferenceTableFourConfigBasicData.setText(_tableFourBasicData.getAppRef());
            eNodeBIdTableFourConfigBasicData.setText(_tableFourBasicData.getEnodebId());
            userLabelTableFourConfigBasicData.setText(_tableFourBasicData.getUserLabel());
            
        } else {
            parameterIdTableFourConfigBasicData.setValue("REFERENCE");
        }
    }    
    
}
