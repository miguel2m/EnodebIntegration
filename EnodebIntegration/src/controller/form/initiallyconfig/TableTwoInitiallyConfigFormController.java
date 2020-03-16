/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.form.initiallyconfig;

import controller.BaseController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Validation;
import model.initiallyconfig.TableTwoConfigEnodeb;
import view.ViewFactory;

/**
 * FXML Controller class
 *
 * @author Miguelangel
 */
public class TableTwoInitiallyConfigFormController extends BaseController implements Initializable {

    private TableView tableInitConfigTwo;
    private boolean isUpdate;

    @FXML
    private TextField m2000IpAddTableTwo;

    @FXML
    private TextField sgwNameIdTableTwo;

    @FXML
    private TextField sgwIp1TableTwo;

    @FXML
    private TextField sgwIp2TableTwo;

    @FXML
    private TextField sgwIp3TableTwo;

    @FXML
    private TextField sgwIp4TableTwo;

    @FXML
    private TextField mmeNameTableTwo;

    @FXML
    private TextField mmeIp1TableTwo;

    @FXML
    private TextField mmeIp2TableTwo;

    @FXML
    private TextField ipAddIpClockServerTableTwo;

    @FXML
    private TextField nexthopIpAddIpClockServerTableTwo;

    @FXML
    private TextField vlanIpAddIpClockServerTableTwo;

    public TableTwoInitiallyConfigFormController(ViewFactory viewFactory, String fxmlName,
            TableView tableInitConfigTwo,
            boolean isUpdate) {
        super(viewFactory, fxmlName);
        this.tableInitConfigTwo = tableInitConfigTwo;
        this.isUpdate = isUpdate;
    }

    @FXML
    void onAceptarTableTwo(ActionEvent event) {
        if (!m2000IpAddTableTwo.getText().isEmpty()) {
            if (Validation.isValidIp(m2000IpAddTableTwo.getText())) {
                if (!sgwNameIdTableTwo.getText().isEmpty()) {
                    if (!sgwIp1TableTwo.getText().isEmpty()) {
                        if (Validation.isValidIp(sgwIp1TableTwo.getText())) {
                            if (!sgwIp2TableTwo.getText().isEmpty()) {
                                if (Validation.isValidIp(sgwIp2TableTwo.getText())) {
                                    if (!sgwIp3TableTwo.getText().isEmpty()) {
                                        if (Validation.isValidIp(sgwIp3TableTwo.getText())) {
                                            //if (Validation.isValidIp(sgwIp4TableTwo.getText())) {
                                                if (!mmeNameTableTwo.getText().isEmpty()) {
                                                    if (!mmeIp1TableTwo.getText().isEmpty()) {
                                                        if (Validation.isValidIp(mmeIp1TableTwo.getText())) {
                                                            if (!mmeIp2TableTwo.getText().isEmpty()) {
                                                                if (Validation.isValidIp(mmeIp2TableTwo.getText())) {
                                                                    if (!ipAddIpClockServerTableTwo.getText().isEmpty()) {
                                                                        if (Validation.isValidIp(ipAddIpClockServerTableTwo.getText())) {
                                                                            if (!nexthopIpAddIpClockServerTableTwo.getText().isEmpty()) {
                                                                                if (Validation.isValidIp(nexthopIpAddIpClockServerTableTwo.getText())) {
                                                                                    if (!vlanIpAddIpClockServerTableTwo.getText().isEmpty()) {
                                                                                        if (!isUpdate) {
                                                                                            tableInitConfigTwo.getItems().add(
                                                                                                    new TableTwoConfigEnodeb(
                                                                                                            m2000IpAddTableTwo.getText(),
                                                                                                            sgwNameIdTableTwo.getText(),
                                                                                                            sgwIp1TableTwo.getText(),
                                                                                                            sgwIp2TableTwo.getText(),
                                                                                                            sgwIp3TableTwo.getText(),
                                                                                                            sgwIp4TableTwo.getText(),
                                                                                                            mmeNameTableTwo.getText(),
                                                                                                            mmeIp1TableTwo.getText(),
                                                                                                            mmeIp2TableTwo.getText(),
                                                                                                            ipAddIpClockServerTableTwo.getText(),
                                                                                                            nexthopIpAddIpClockServerTableTwo.getText(),
                                                                                                            vlanIpAddIpClockServerTableTwo.getText()
                                                                                                    )
                                                                                            );
                                                                                            //System.out.println(""+tableInitConfigTwo.getItems().get(0).toString());
                                                                                        } else {
                                                                                            TableTwoConfigEnodeb _tableTwoConfigEnodeb
                                                                                                    = (TableTwoConfigEnodeb) tableInitConfigTwo.getSelectionModel().getSelectedItem();
                                                                                            _tableTwoConfigEnodeb.setM200IpAdd(m2000IpAddTableTwo.getText());
                                                                                            _tableTwoConfigEnodeb.setSgwNameId(sgwNameIdTableTwo.getText());
                                                                                            _tableTwoConfigEnodeb.setSgwIpAddOne(sgwIp1TableTwo.getText());
                                                                                            _tableTwoConfigEnodeb.setSgwIpAddTwo(sgwIp2TableTwo.getText());
                                                                                            _tableTwoConfigEnodeb.setSgwIpAddThree(sgwIp3TableTwo.getText());
                                                                                            _tableTwoConfigEnodeb.setSgwIpAddFour(sgwIp4TableTwo.getText());
                                                                                            _tableTwoConfigEnodeb.setMmeName(mmeNameTableTwo.getText());
                                                                                            _tableTwoConfigEnodeb.setMmeIpAddFirst(mmeIp1TableTwo.getText());
                                                                                            _tableTwoConfigEnodeb.setMmeIpAddSecond(mmeIp2TableTwo.getText());
                                                                                            _tableTwoConfigEnodeb.setIpv4AddClockServer(ipAddIpClockServerTableTwo.getText());
                                                                                            _tableTwoConfigEnodeb.setNexthopAddClockServer(nexthopIpAddIpClockServerTableTwo.getText());
                                                                                            _tableTwoConfigEnodeb.setVlanAddClockServer(vlanIpAddIpClockServerTableTwo.getText());
                                                                                            tableInitConfigTwo.refresh();
                                                                                        }
                                                                                        viewFactory.closeStage((Stage) vlanIpAddIpClockServerTableTwo.getScene().getWindow());
                                                                                    } else {
                                                                                        viewFactory.showAlertValidation(
                                                                                                (Stage) m2000IpAddTableTwo.getScene().getWindow(),
                                                                                                "Next-Hop VLAN IP - Clock Server Vacío",
                                                                                                "Next-Hop VLAN IP - Clock Server no puede estar vacío");
                                                                                    }

                                                                                } else {
                                                                                    viewFactory.showAlertValidation(
                                                                                            (Stage) m2000IpAddTableTwo.getScene().getWindow(),
                                                                                            "Next-Hop IP Address - IP Clock Server IP Address inválido",
                                                                                            "Next-Hop IP Address - IP Clock Server IP no corresponde con una IP address");
                                                                                }
                                                                            } else {
                                                                                viewFactory.showAlertValidation(
                                                                                        (Stage) m2000IpAddTableTwo.getScene().getWindow(),
                                                                                        "Next-Hop IP Address - IP Clock Server Vacío",
                                                                                        "Next-Hop IP Address - IP Clock Server no puede estar vacío");
                                                                            }

                                                                        } else {
                                                                            viewFactory.showAlertValidation(
                                                                                    (Stage) m2000IpAddTableTwo.getScene().getWindow(),
                                                                                    "IPv4 Address of the IP Clock Server IP Address inválido",
                                                                                    "IPv4 Address of the IP Clock Server IP no corresponde con una IP address");
                                                                        }
                                                                    } else {
                                                                        viewFactory.showAlertValidation(
                                                                                (Stage) m2000IpAddTableTwo.getScene().getWindow(),
                                                                                "IPv4 Address of the IP Clock Server Vacío",
                                                                                "IPv4 Address of the IP Clock Server no puede estar vacío");
                                                                    }

                                                                } else {
                                                                    viewFactory.showAlertValidation(
                                                                            (Stage) m2000IpAddTableTwo.getScene().getWindow(),
                                                                            "MME IP Address 2 inválido",
                                                                            "MME IP Address 2 no corresponde con una IP address");
                                                                }
                                                            } else {
                                                                viewFactory.showAlertValidation(
                                                                        (Stage) m2000IpAddTableTwo.getScene().getWindow(),
                                                                        "MME IP 2 Vacío",
                                                                        "MME IP 2 no puede estar vacío");
                                                            }
                                                        } else {
                                                            viewFactory.showAlertValidation(
                                                                    (Stage) m2000IpAddTableTwo.getScene().getWindow(),
                                                                    "MME IP Address 1 inválido",
                                                                    "MME IP Address 1 no corresponde con una IP address");
                                                        }
                                                    } else {
                                                        viewFactory.showAlertValidation(
                                                                (Stage) m2000IpAddTableTwo.getScene().getWindow(),
                                                                "MME IP 1 Vacío",
                                                                "MME IP 1 no puede estar vacío");
                                                    }
                                                } else {///
                                                    viewFactory.showAlertValidation(
                                                            (Stage) m2000IpAddTableTwo.getScene().getWindow(),
                                                            "MME NAME Vacío",
                                                            "MME NAME no puede estar vacío");
                                                }
                                            /*} else {
                                                viewFactory.showAlertValidation(
                                                        (Stage) m2000IpAddTableTwo.getScene().getWindow(),
                                                        "S-GW IP Address 4 inválido",
                                                        "S-GW IP Address 4 no corresponde con una IP address");
                                            }*/

                                        } else {
                                            viewFactory.showAlertValidation(
                                                    (Stage) m2000IpAddTableTwo.getScene().getWindow(),
                                                    "S-GW IP Address 3 inválido",
                                                    "S-GW IP Address 3 no corresponde con una IP address");
                                        }
                                    } else {
                                        viewFactory.showAlertValidation(
                                                (Stage) m2000IpAddTableTwo.getScene().getWindow(),
                                                "S-GW IP Address 3 Vacío",
                                                "S-GW IP Address 3 no puede estar vacío");
                                    }
                                } else {
                                    viewFactory.showAlertValidation(
                                            (Stage) m2000IpAddTableTwo.getScene().getWindow(),
                                            "S-GW IP Address 2 inválido",
                                            "S-GW IP Address 2 no corresponde con una IP address");
                                }
                            } else {
                                viewFactory.showAlertValidation(
                                        (Stage) m2000IpAddTableTwo.getScene().getWindow(),
                                        "S-GW IP Address 2 Vacío",
                                        "S-GW IP Address 2 no puede estar vacío");
                            }
                        } else {
                            viewFactory.showAlertValidation(
                                    (Stage) m2000IpAddTableTwo.getScene().getWindow(),
                                    "S-GW IP Address 1 inválido",
                                    "S-GW IP Address 1 no corresponde con una IP address");
                        }
                    } else {
                        viewFactory.showAlertValidation(
                                (Stage) m2000IpAddTableTwo.getScene().getWindow(),
                                "S-GW IP Address 1 Vacío",
                                "S-GW IP Address 1 no puede estar vacío");
                    }
                } else {
                    viewFactory.showAlertValidation(
                            (Stage) m2000IpAddTableTwo.getScene().getWindow(),
                            "S-GW Name_ID Vacío",
                            "S-GW Name_ID no puede estar vacío");
                }
            } else {
                viewFactory.showAlertValidation(
                        (Stage) m2000IpAddTableTwo.getScene().getWindow(),
                        "M2000 IP Address inválido",
                        "M2000 IP Address no corresponde con una IP address");
            }
        } else {
            viewFactory.showAlertValidation(
                    (Stage) m2000IpAddTableTwo.getScene().getWindow(),
                    "M2000 IP Address Vacío",
                    "M2000 IP Address no puede estar vacío");
        }
    }

    @FXML
    void onCancelarTableTwo(ActionEvent event
    ) {
        viewFactory.closeStage((Stage) vlanIpAddIpClockServerTableTwo.getScene().getWindow());
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb
    ) {
        // TODO
        if(isUpdate){
            TableTwoConfigEnodeb _tableTwoConfigEnodeb
                    = (TableTwoConfigEnodeb) tableInitConfigTwo.getSelectionModel().getSelectedItem();
            m2000IpAddTableTwo.setText(_tableTwoConfigEnodeb.getM200IpAdd());
            sgwNameIdTableTwo.setText(_tableTwoConfigEnodeb.getSgwNameId());
            sgwIp1TableTwo.setText(_tableTwoConfigEnodeb.getSgwIpAddOne());
            sgwIp2TableTwo.setText(_tableTwoConfigEnodeb.getSgwIpAddTwo());
            sgwIp3TableTwo.setText(_tableTwoConfigEnodeb.getSgwIpAddThree());
            sgwIp4TableTwo.setText(_tableTwoConfigEnodeb.getSgwIpAddFour());
            mmeNameTableTwo.setText(_tableTwoConfigEnodeb.getMmeName());
            mmeIp1TableTwo.setText(_tableTwoConfigEnodeb.getMmeIpAddFirst());
            mmeIp2TableTwo.setText(_tableTwoConfigEnodeb.getMmeIpAddSecond());
            ipAddIpClockServerTableTwo.setText(_tableTwoConfigEnodeb.getIpv4AddClockServer());
            nexthopIpAddIpClockServerTableTwo.setText(_tableTwoConfigEnodeb.getNexthopAddClockServer());
            vlanIpAddIpClockServerTableTwo.setText(_tableTwoConfigEnodeb.getVlanAddClockServer());
        }
    }

}
