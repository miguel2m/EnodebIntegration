/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.configbasicdata.TableFourBasicData;
import model.configbasicdata.TableOneBasicData;
import model.configbasicdata.TableThreeBasicData;
import model.configbasicdata.TableTwoBasicData;
import model.initiallyconfig.TableOneConfigEnodeb;
import model.initiallyconfig.TableThreeConfigEnodeb;
import model.initiallyconfig.TableTwoConfigEnodeb;
import model.rmvdefaultconfig.TableOneRmvDefaultConfig;
import view.ViewFactory;

/**
 *
 * @author P05144
 */
public class MainViewController extends BaseController implements Initializable {

    //InitiallyConfig
    private ObservableList<TableOneConfigEnodeb> _initiallyConfigTableOne = FXCollections.observableArrayList();
    private ObservableList<TableTwoConfigEnodeb> _initiallyConfigTableTwo = FXCollections.observableArrayList();
    private ObservableList<TableThreeConfigEnodeb> _initiallyConfigTableThree = FXCollections.observableArrayList();
    //Remove Default Config
    private ObservableList<TableOneRmvDefaultConfig> _rmvConfigTableOne = FXCollections.observableArrayList();
    //Config Basic Data
    private ObservableList<TableOneBasicData> _tableOneBasicData = FXCollections.observableArrayList();
    private ObservableList<TableTwoBasicData> _tableTwoBasicData = FXCollections.observableArrayList();
    private ObservableList<TableThreeBasicData> _tableThreeBasicData = FXCollections.observableArrayList();
    private ObservableList<TableFourBasicData> _tableFourBasicData = FXCollections.observableArrayList();
    @FXML
    private BorderPane mainBorderPanel;

    public MainViewController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
    }

    @FXML
    void onMainConfigBasicData(ActionEvent event) {
        if (_tableOneBasicData.isEmpty()) {
            if (!_initiallyConfigTableOne.isEmpty()) {
                TableOneBasicData _basicData
                        = new TableOneBasicData(
                                "REFERENCE",
                                _initiallyConfigTableOne.get(0).getNeEnodeb(),
                                "-",
                                "-",
                                "-",
                                "-"
                        );
                _tableOneBasicData.add(_basicData);
            }
        }
        BaseController _baseController = new ConfigBasicDataController(
                viewFactory,
                "ConfigBasicData.fxml",
                _tableOneBasicData,
                _tableTwoBasicData,
                _tableThreeBasicData,
                _tableFourBasicData
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
                "InitiallyConfig.fxml",
                _initiallyConfigTableOne,
                _initiallyConfigTableTwo,
                _initiallyConfigTableThree
        );
        viewFactory.addStageCenterBorderPanel(mainBorderPanel, _baseController);
    }

    @FXML
    void onMainRmvDefaultConfig(ActionEvent event) {
        BaseController _baseController = new RmvDefaultConfigController(
                viewFactory,
                "RmvDefaultConfig.fxml",
                _rmvConfigTableOne
        );
        viewFactory.addStageCenterBorderPanel(mainBorderPanel, _baseController);
    }

    @FXML
    void onExportScript(ActionEvent event) {
        System.out.println("onExportScript");
    }

    @FXML
    void onCloseMainWindow(ActionEvent event) {
        viewFactory.closeStage((Stage) mainBorderPanel.getScene().getWindow());
    }

    @FXML
    void onHelpMainWindow(ActionEvent event) {
        viewFactory.showHelpMainWindow((Stage) mainBorderPanel.getScene().getWindow());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        BaseController _baseController = new InitiallyConfigController(
                viewFactory,
                "InitiallyConfig.fxml",
                _initiallyConfigTableOne,
                _initiallyConfigTableTwo,
                _initiallyConfigTableThree
        );
        viewFactory.addStageCenterBorderPanel(mainBorderPanel, _baseController);
    }

}
