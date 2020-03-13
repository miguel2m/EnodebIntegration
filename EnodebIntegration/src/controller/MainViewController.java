/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import view.ViewFactory;

/**
 *
 * @author P05144
 */
public class MainViewController extends BaseController implements Initializable {
    @FXML
    private BorderPane mainBorderPanel;

    public MainViewController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
    }
      

    @FXML
    void onMainConfigBasicData(ActionEvent event) {
        BaseController _baseController = new ConfigBasicDataController(
                viewFactory,
                "ConfigBasicData.fxml"
        );
        viewFactory.addStageCenterBorderPanel(mainBorderPanel, _baseController);
    }

    @FXML
    void onMainConfigDeviceData(ActionEvent event) {
        BaseController _baseController = new ConfigDeviceDataController(
                viewFactory,
                "ConfigDeviceData.fxml"
        );
        viewFactory.addStageCenterBorderPanel(mainBorderPanel, _baseController);
        
    }

    @FXML
    void onMainConfigRadioData(ActionEvent event) {
        BaseController _baseController = new ConfigRadioDataController(
                viewFactory,
                "ConfigRadioData.fxml"
        );
        viewFactory.addStageCenterBorderPanel(mainBorderPanel, _baseController);
    }

    @FXML
    void onMainConfigTransmissionData(ActionEvent event) {
        BaseController _baseController = new ConfigTransmissionDataController(
                viewFactory,
                "ConfigTransmissionData.fxml"
        );
        viewFactory.addStageCenterBorderPanel(mainBorderPanel, _baseController);
    }

    @FXML
    void onMainInitiallyConfig(ActionEvent event) {
        BaseController _baseController = new InitiallyConfigController(
                viewFactory,
                "InitiallyConfig.fxml"
        );
        viewFactory.addStageCenterBorderPanel(mainBorderPanel, _baseController);
    }

    @FXML
    void onMainRmvDefaultConfig(ActionEvent event) {
        BaseController _baseController = new RmvDefaultConfigController(
                viewFactory,
                "RmvDefaultConfig.fxml"
        );
        viewFactory.addStageCenterBorderPanel(mainBorderPanel, _baseController);
    }
    
    @FXML
    void onExportScript(ActionEvent event) {
        System.out.println("onExportScript");
    }
    
    @FXML
    void onCloseMainWindow(ActionEvent event) {
        viewFactory.closeStage((Stage)mainBorderPanel.getScene().getWindow());
    }
    @FXML
    void onHelpMainWindow(ActionEvent event) {
        viewFactory.showHelpMainWindow((Stage)mainBorderPanel.getScene().getWindow());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {     
        BaseController _baseController = new InitiallyConfigController(
                viewFactory,
                "InitiallyConfig.fxml"
        );
        viewFactory.addStageCenterBorderPanel(mainBorderPanel, _baseController);
    }    
    
}
