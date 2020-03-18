/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.form.initiallyconfig;

import controller.BaseController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Validation;
import model.initiallyconfig.TableOneConfigEnodeb;
import view.ViewFactory;

/**
 * FXML Controller class
 *
 * @author Miguelangel
 */
public class TableOneInitiallyConfigFormController extends BaseController implements Initializable {
    private TableView tableInitConfigOne;
    private boolean isUpdate;
    @FXML
    private TextField neEnodebTableOne;
    
    @FXML
    private TextField ethernetPortNumberEnodebTableOne;
    
    @FXML
    private TextField interfaceIpAddEnodebTableOne;
    
    @FXML
    private TextField maskEnodebTableOne;
    
    @FXML
    private TextField nexthopIpAddEnodebTableOne;
    
    @FXML
    private TextField nexthopVlanAddEnodebTableOne;
    
    public TableOneInitiallyConfigFormController(ViewFactory viewFactory, String fxmlName,
            TableView tableInitConfigOne,
            boolean isUpdate) {
        super(viewFactory, fxmlName);
        this.tableInitConfigOne =tableInitConfigOne;
        this.isUpdate=isUpdate;
    }
    
    @FXML
    void onFormTableOneInitConfig(ActionEvent event) {
        if (!neEnodebTableOne.getText().isEmpty()) {
            if (!ethernetPortNumberEnodebTableOne.getText().isEmpty()) {
                if (!interfaceIpAddEnodebTableOne.getText().isEmpty()) {
                    if (Validation.isValidIp(interfaceIpAddEnodebTableOne.getText())) {
                        if (!maskEnodebTableOne.getText().isEmpty()) {
                            if (Validation.isValidIp(maskEnodebTableOne.getText())) {
                                if (!nexthopIpAddEnodebTableOne.getText().isEmpty()) {
                                    if (Validation.isValidIp(nexthopIpAddEnodebTableOne.getText())) {
                                        if (!nexthopVlanAddEnodebTableOne.getText().isEmpty()) {
                                            
                                            if(!isUpdate){
                                                System.out.println("Add");
                                                
                                                tableInitConfigOne.getItems().add(
                                                        new TableOneConfigEnodeb(
                                                                neEnodebTableOne.getText().toUpperCase(), 
                                                                ethernetPortNumberEnodebTableOne.getText().toUpperCase(),
                                                                interfaceIpAddEnodebTableOne.getText().toUpperCase(),
                                                                maskEnodebTableOne.getText().toUpperCase(),
                                                                nexthopIpAddEnodebTableOne.getText().toUpperCase(),
                                                                nexthopVlanAddEnodebTableOne.getText().toUpperCase()));
                                            }else{
                                                TableOneConfigEnodeb _tableOneConfigEnodeb=
                                                        (TableOneConfigEnodeb) tableInitConfigOne.getSelectionModel().getSelectedItem();
                                                _tableOneConfigEnodeb.setNeEnodeb(neEnodebTableOne.getText().toUpperCase());
                                                _tableOneConfigEnodeb.setEthernetPortNumberEnodeb(ethernetPortNumberEnodebTableOne.getText().toUpperCase());
                                                _tableOneConfigEnodeb.setInterfaceIpAddEnodeb(interfaceIpAddEnodebTableOne.getText().toUpperCase());
                                                _tableOneConfigEnodeb.setMaskEnodeb(maskEnodebTableOne.getText().toUpperCase());
                                                _tableOneConfigEnodeb.setNexthopIpAddEnodeb(nexthopIpAddEnodebTableOne.getText().toUpperCase());
                                                _tableOneConfigEnodeb.setNexthopVlanAddEnodeb(nexthopVlanAddEnodebTableOne.getText().toUpperCase());
                                                tableInitConfigOne.refresh();
                                                System.out.println("Update");
                                            }
                                            
                                            viewFactory.closeStage((Stage) neEnodebTableOne.getScene().getWindow());
                                        } else {
                                            viewFactory.showAlertValidation((Stage) neEnodebTableOne.getScene().getWindow(),
                                                    "Nexthop VLAN vacío",
                                                    "Nexthop VLAN  no puede estar vacío");
                                        }
                                    } else {
                                        viewFactory.showAlertValidation((Stage) neEnodebTableOne.getScene().getWindow(),
                                                "Nexthop IP Address no IP Address",
                                                "La Nexthop IP Address no corresponde con una IP válida");
                                    }
                                } else {
                                    viewFactory.showAlertValidation((Stage) neEnodebTableOne.getScene().getWindow(),
                                            "Nexthop IP Address vacío",
                                            "Nexthop IP Address  no puede estar vacío");
                                }
                            } else {
                                viewFactory.showAlertValidation((Stage) neEnodebTableOne.getScene().getWindow(),
                                        "Mask IP Address no IP Address",
                                        "La Mask IP Address no corresponde con una IP válida");
                            }
                        } else {
                            viewFactory.showAlertValidation((Stage) neEnodebTableOne.getScene().getWindow(),
                                    "Mask IP Address vacío",
                                    "Mask IP Address  no puede estar vacío");
                        }
                    } else {
                        viewFactory.showAlertValidation((Stage) neEnodebTableOne.getScene().getWindow(),
                                "Interface IP Address no IP Address",
                                "La Interface IP Address no corresponde con una IP válida");
                    }
                } else {
                    viewFactory.showAlertValidation((Stage) neEnodebTableOne.getScene().getWindow(),
                            "Interface IP Address vacío",
                            "Interface IP Address  no puede estar vacío");
                }
            } else {
                viewFactory.showAlertValidation((Stage) neEnodebTableOne.getScene().getWindow(),
                        "Ethernet Port Number vacío",
                        "Ethernet Port Number  no puede estar vacío");
            }
        } else {
            viewFactory.showAlertValidation((Stage) neEnodebTableOne.getScene().getWindow(),
                    "NE vacío",
                    "NE no puede estar vacío");
        }
    }
    
    @FXML
    void onCancelTableOneInitiallyConfig(ActionEvent event) {
        viewFactory.closeStage((Stage) neEnodebTableOne.getScene().getWindow());
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        if(isUpdate){
            TableOneConfigEnodeb _tableOneConfigEnodeb=
            (TableOneConfigEnodeb) tableInitConfigOne.getSelectionModel().getSelectedItem();
            neEnodebTableOne.setText(_tableOneConfigEnodeb.getNeEnodeb());
            ethernetPortNumberEnodebTableOne.setText(_tableOneConfigEnodeb.getEthernetPortNumberEnodeb());
            interfaceIpAddEnodebTableOne.setText(_tableOneConfigEnodeb.getInterfaceIpAddEnodeb());
            maskEnodebTableOne.setText(_tableOneConfigEnodeb.getMaskEnodeb());
            nexthopIpAddEnodebTableOne.setText(_tableOneConfigEnodeb.getNexthopIpAddEnodeb());
            nexthopVlanAddEnodebTableOne.setText(_tableOneConfigEnodeb.getNexthopVlanAddEnodeb());
        }
    }
    
}
