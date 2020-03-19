/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.form.initiallyconfig.TableOneInitiallyConfigFormController;
import controller.form.initiallyconfig.TableThreeInitiallyConfigFormController;
import controller.form.initiallyconfig.TableTwoInitiallyConfigFormController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.initiallyconfig.TableOneConfigEnodeb;
import model.initiallyconfig.TableThreeConfigEnodeb;
import model.initiallyconfig.TableTwoConfigEnodeb;
import view.ViewFactory;

/**
 * FXML Controller class
 *
 * @author P05144
 */
public class InitiallyConfigController extends BaseController implements Initializable {

    private BaseController _baseController;
    private ObservableList<TableOneConfigEnodeb> _initiallyConfigTableOne = FXCollections.observableArrayList();
    private ObservableList<TableTwoConfigEnodeb> _initiallyConfigTableTwo = FXCollections.observableArrayList();
    private ObservableList<TableThreeConfigEnodeb> _initiallyConfigTableThree = FXCollections.observableArrayList();
    @FXML
    private TableView tableInitConfigOne;

    @FXML
    private TableView tableInitConfigTwo;

    @FXML
    private TableView tableInitConfigThree;

    public InitiallyConfigController(ViewFactory viewFactory, String fxmlName,
            ObservableList<TableOneConfigEnodeb> _initiallyConfigTableOne,
            ObservableList<TableTwoConfigEnodeb> _initiallyConfigTableTwo,
            ObservableList<TableThreeConfigEnodeb> _initiallyConfigTableThree) {
        super(viewFactory, fxmlName);
        this._initiallyConfigTableOne = _initiallyConfigTableOne;
        this._initiallyConfigTableTwo = _initiallyConfigTableTwo;
        this._initiallyConfigTableThree = _initiallyConfigTableThree;
    }

    @FXML
    void onAddTableInitOne(ActionEvent event) {
        //System.out.println("onAddTableInitOne");
        if (_initiallyConfigTableOne.isEmpty()) {
            _baseController = new TableOneInitiallyConfigFormController(
                    viewFactory,
                    "form/initiallyconfig/TableOneInitiallyConfigForm.fxml",
                    tableInitConfigOne,
                    false);
            viewFactory.showModalStage(
                    (Stage) tableInitConfigOne.getScene().getWindow(),
                    _baseController,
                    "Table 1: eNodeB Configuration Data");
        } else {
            viewFactory.showAlertValidation((Stage) tableInitConfigOne.getScene().getWindow(),
                    "Table 1: eNodeB Configuration Data",
                    "Solo se permite agregar una fila ");
        }
    }

    @FXML
    void onAddTableInitThree(ActionEvent event) {
        System.out.println("onAddTableInitThree");
        if (_initiallyConfigTableThree.size() < 3) {
            _baseController = new TableThreeInitiallyConfigFormController(
                    viewFactory,
                    "form/initiallyconfig/TableThreeInitiallyConfigForm.fxml",
                    tableInitConfigThree,
                    false);
            viewFactory.showModalStage(
                    (Stage) tableInitConfigThree.getScene().getWindow(),
                    _baseController,
                    "Table 3: Radio parameters");
        } else {
            viewFactory.showAlertValidation((Stage) tableInitConfigThree.getScene().getWindow(),
                    "Table 3: Radio parameters",
                    "Solo se permite agregar 3 filas");
        }
    }

    @FXML
    void onAddTableInitTwo(ActionEvent event) {
        if (_initiallyConfigTableTwo.isEmpty()) {
            _baseController = new TableTwoInitiallyConfigFormController(
                    viewFactory,
                    "form/initiallyconfig/TableTwoInitiallyConfigForm.fxml",
                    tableInitConfigTwo,
                    false);
            viewFactory.showModalStage(
                    (Stage) tableInitConfigTwo.getScene().getWindow(),
                    _baseController,
                    "Table 2 IP addresses of eNodeB-related NEs");
        } else {
            viewFactory.showAlertValidation((Stage) tableInitConfigTwo.getScene().getWindow(),
                    "Table 2 IP addresses of eNodeB-related NEs",
                    "Solo se permite agregar una fila ");
        }
    }

    @FXML
    void onDeleteTableInitOne(ActionEvent event) {
        System.out.println("onDeleteTableInitOne");
        if (!tableInitConfigOne.getSelectionModel().isEmpty()) {
            tableInitConfigOne.getItems().remove(
                    tableInitConfigOne.getSelectionModel().getSelectedItem()
            );
        } else {
            viewFactory.showAlertValidation((Stage) tableInitConfigOne.getScene().getWindow(),
                    "Table 1: eNodeB Configuration Data",
                    "Seleccione una fila ");
        }
    }

    @FXML
    void onDeleteTableInitThree(ActionEvent event) {
        System.out.println("onDeleteTableInitThree");

        if (!tableInitConfigThree.getSelectionModel().isEmpty()) {
            tableInitConfigThree.getItems().remove(
                    tableInitConfigThree.getSelectionModel().getSelectedItem()
            );
        } else {
            viewFactory.showAlertValidation((Stage) tableInitConfigThree.getScene().getWindow(),
                    "Table 3: Radio parameters",
                    "Seleccione una fila ");
        }
    }

    @FXML
    void onDeleteTableInitTwo(ActionEvent event) {
        System.out.println("onDeleteTableInitTwo");
        if (!tableInitConfigTwo.getSelectionModel().isEmpty()) {
            tableInitConfigTwo.getItems().remove(
                    tableInitConfigTwo.getSelectionModel().getSelectedItem()
            );
        } else {
            viewFactory.showAlertValidation((Stage) tableInitConfigTwo.getScene().getWindow(),
                    "Table 2 IP addresses of eNodeB-related NEs",
                    "Seleccione una fila ");
        }
    }

    @FXML
    void onDuplicateTableInitThree(ActionEvent event) {
        System.out.println("onDuplicateTableInitThree");
        if (!tableInitConfigThree.getSelectionModel().isEmpty()) {
            if (_initiallyConfigTableThree.size() < 3) {
                TableThreeConfigEnodeb _tableThreeConfigEnodeb =
                     (TableThreeConfigEnodeb)tableInitConfigThree.
                                getSelectionModel().
                                getSelectedItem();   
                tableInitConfigThree.getItems().add(
                   new TableThreeConfigEnodeb(
                           _tableThreeConfigEnodeb.getCell(),
                           _tableThreeConfigEnodeb.getTxrxMode(),
                           _tableThreeConfigEnodeb.getPci(),
                           _tableThreeConfigEnodeb.getDownlink()
                   )     
                );
            } else {
                viewFactory.showAlertValidation((Stage) tableInitConfigThree.getScene().getWindow(),
                        "Table 3: Radio parameters",
                        "Solo se permite agregar 3 filas");
            }
        } else {
            viewFactory.showAlertValidation((Stage) tableInitConfigThree.getScene().getWindow(),
                    "Table 3: Radio parameters",
                    "Seleccione una fila ");
        }
    }

    @FXML
    void onUpdateTableInitOne(ActionEvent event) {
        System.out.println("onUpdateTableInitOne");
        if (!tableInitConfigOne.getSelectionModel().isEmpty()) {
            _baseController = new TableOneInitiallyConfigFormController(viewFactory, "form/initiallyconfig/TableOneInitiallyConfigForm.fxml",
                    tableInitConfigOne,
                    true);
            viewFactory.showModalStage(
                    (Stage) tableInitConfigOne.getScene().getWindow(),
                    _baseController,
                    "Table 1: eNodeB Configuration Data");
        } else {
            viewFactory.showAlertValidation((Stage) tableInitConfigOne.getScene().getWindow(),
                    "Table 1: eNodeB Configuration Data",
                    "Seleccione una fila ");
        }
    }

    @FXML
    void onUpdateTableInitThree(ActionEvent event) {
        System.out.println("onUpdateTableInitThree");
        if (!tableInitConfigThree.getSelectionModel().isEmpty()) {
            _baseController = new TableThreeInitiallyConfigFormController(
                    viewFactory,
                    "form/initiallyconfig/TableThreeInitiallyConfigForm.fxml",
                    tableInitConfigThree,
                    true);
            viewFactory.showModalStage(
                    (Stage) tableInitConfigThree.getScene().getWindow(),
                    _baseController,
                    "Table 3: Radio parameters");
        } else {
            viewFactory.showAlertValidation((Stage) tableInitConfigThree.getScene().getWindow(),
                    "Table 3: Radio parameters",
                    "Seleccione una fila ");
        }
    }

    @FXML
    void onUpdateTableInitTwo(ActionEvent event) {
        System.out.println("onUpdateTableInitTwo");
        if (!tableInitConfigTwo.getSelectionModel().isEmpty()) {
            _baseController = new TableTwoInitiallyConfigFormController(viewFactory, "form/initiallyconfig/TableTwoInitiallyConfigForm.fxml",
                    tableInitConfigTwo,
                    true);
            viewFactory.showModalStage(
                    (Stage) tableInitConfigOne.getScene().getWindow(),
                    _baseController,
                    "Table 2 IP addresses of eNodeB-related NEs");
        } else {
            viewFactory.showAlertValidation((Stage) tableInitConfigTwo.getScene().getWindow(),
                    "Table 2 IP addresses of eNodeB-related NEs",
                    "Seleccione una fila ");
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //StageInit
        //_stage=(Stage)tableInitConfigOne.getScene().getWindow();
        //Table One init
        TableColumn neCol = new TableColumn("NE");
        neCol.setMinWidth(100);
        neCol.setCellValueFactory(
                new PropertyValueFactory<TableOneConfigEnodeb, String>("neEnodeb"));
        neCol.setSortType(TableColumn.SortType.DESCENDING);

        TableColumn ethernetPortNumberEnodebCol = new TableColumn("Ethernet Port Number");
        ethernetPortNumberEnodebCol.setMinWidth(200);
        ethernetPortNumberEnodebCol.setCellValueFactory(
                new PropertyValueFactory<TableOneConfigEnodeb, String>("ethernetPortNumberEnodeb"));
        ethernetPortNumberEnodebCol.setSortType(TableColumn.SortType.DESCENDING);

        TableColumn interfaceIpAddEnodebCol = new TableColumn("Interface IP Address");
        interfaceIpAddEnodebCol.setMinWidth(150);
        interfaceIpAddEnodebCol.setCellValueFactory(
                new PropertyValueFactory<TableOneConfigEnodeb, String>("interfaceIpAddEnodeb"));
        interfaceIpAddEnodebCol.setSortType(TableColumn.SortType.DESCENDING);

        TableColumn maskEnodebCol = new TableColumn("MASK");
        maskEnodebCol.setMinWidth(150);
        maskEnodebCol.setCellValueFactory(
                new PropertyValueFactory<TableOneConfigEnodeb, String>("maskEnodeb"));
        maskEnodebCol.setSortType(TableColumn.SortType.DESCENDING);

        TableColumn nexthopIpAddEnodebCol = new TableColumn("Next-Hop IP Address (M2000 | S-GW | MME)");
        nexthopIpAddEnodebCol.setMinWidth(300);
        nexthopIpAddEnodebCol.setCellValueFactory(
                new PropertyValueFactory<TableOneConfigEnodeb, String>("nexthopIpAddEnodeb"));
        nexthopIpAddEnodebCol.setSortType(TableColumn.SortType.DESCENDING);

        TableColumn nexthopVlanAddEnodebCol = new TableColumn("Next-Hop VLAN (U2000 | S-GW | MME)");
        nexthopVlanAddEnodebCol.setMinWidth(300);
        nexthopVlanAddEnodebCol.setCellValueFactory(
                new PropertyValueFactory<TableOneConfigEnodeb, String>("nexthopVlanAddEnodeb"));
        nexthopVlanAddEnodebCol.setSortType(TableColumn.SortType.DESCENDING);
        tableInitConfigOne.setItems(_initiallyConfigTableOne);
        tableInitConfigOne.getColumns().addAll(
                neCol,
                ethernetPortNumberEnodebCol,
                interfaceIpAddEnodebCol,
                maskEnodebCol,
                nexthopIpAddEnodebCol,
                nexthopVlanAddEnodebCol);

        //Table TWO init
        TableColumn m200IpAddColl = new TableColumn("M2000 IP Address");
        m200IpAddColl.setMinWidth(150);
        m200IpAddColl.setCellValueFactory(
                new PropertyValueFactory<TableTwoConfigEnodeb, String>("m200IpAdd"));
        m200IpAddColl.setSortType(TableColumn.SortType.DESCENDING);

        TableColumn sgwNameIdCol = new TableColumn("S-GW Name_ID");
        sgwNameIdCol.setMinWidth(150);
        sgwNameIdCol.setCellValueFactory(
                new PropertyValueFactory<TableTwoConfigEnodeb, String>("sgwNameId"));
        sgwNameIdCol.setSortType(TableColumn.SortType.DESCENDING);

        TableColumn sgwIpAddOneCol = new TableColumn("S-GW IP Address 1");
        sgwIpAddOneCol.setMinWidth(150);
        sgwIpAddOneCol.setCellValueFactory(
                new PropertyValueFactory<TableTwoConfigEnodeb, String>("sgwIpAddOne"));
        sgwIpAddOneCol.setSortType(TableColumn.SortType.DESCENDING);

        TableColumn sgwIpAddTwoCol = new TableColumn("S-GW IP Address 2");
        sgwIpAddTwoCol.setMinWidth(150);
        sgwIpAddTwoCol.setCellValueFactory(
                new PropertyValueFactory<TableTwoConfigEnodeb, String>("sgwIpAddTwo"));
        sgwIpAddTwoCol.setSortType(TableColumn.SortType.DESCENDING);

        TableColumn sgwIpAddThreeCol = new TableColumn("S-GW IP Address 3");
        sgwIpAddThreeCol.setMinWidth(150);
        sgwIpAddThreeCol.setCellValueFactory(
                new PropertyValueFactory<TableTwoConfigEnodeb, String>("sgwIpAddThree"));
        sgwIpAddThreeCol.setSortType(TableColumn.SortType.DESCENDING);

        TableColumn sgwIpAddFourCol = new TableColumn("S-GW IP Address 4");
        sgwIpAddFourCol.setMinWidth(150);
        sgwIpAddFourCol.setCellValueFactory(
                new PropertyValueFactory<TableTwoConfigEnodeb, String>("sgwIpAddFour"));
        sgwIpAddFourCol.setSortType(TableColumn.SortType.DESCENDING);

        TableColumn mmeNameCol = new TableColumn("MME Name");
        mmeNameCol.setMinWidth(150);
        mmeNameCol.setCellValueFactory(
                new PropertyValueFactory<TableTwoConfigEnodeb, String>("mmeName"));
        mmeNameCol.setSortType(TableColumn.SortType.DESCENDING);

        TableColumn mmeIpAddFirstCol = new TableColumn("MME IP Address (First)");
        mmeIpAddFirstCol.setMinWidth(300);
        mmeIpAddFirstCol.setCellValueFactory(
                new PropertyValueFactory<TableTwoConfigEnodeb, String>("mmeIpAddFirst"));
        mmeIpAddFirstCol.setSortType(TableColumn.SortType.DESCENDING);

        TableColumn mmeIpAddSecondCol = new TableColumn("MME IP Address (Second)");
        mmeIpAddSecondCol.setMinWidth(300);
        mmeIpAddSecondCol.setCellValueFactory(
                new PropertyValueFactory<TableTwoConfigEnodeb, String>("mmeIpAddSecond"));
        mmeIpAddSecondCol.setSortType(TableColumn.SortType.DESCENDING);

        TableColumn ipv4AddClockServerCol = new TableColumn("IPv4 Address of the IP Clock Server");
        ipv4AddClockServerCol.setMinWidth(300);
        ipv4AddClockServerCol.setCellValueFactory(
                new PropertyValueFactory<TableTwoConfigEnodeb, String>("ipv4AddClockServer"));
        ipv4AddClockServerCol.setSortType(TableColumn.SortType.DESCENDING);

        TableColumn nexthopAddClockServerCol = new TableColumn("Next-Hop IP Address - IP Clock Server");
        nexthopAddClockServerCol.setMinWidth(300);
        nexthopAddClockServerCol.setCellValueFactory(
                new PropertyValueFactory<TableTwoConfigEnodeb, String>("nexthopAddClockServer"));
        nexthopAddClockServerCol.setSortType(TableColumn.SortType.DESCENDING);

        TableColumn vlanAddClockServerCol = new TableColumn("Next-Hop VLAN IP - Clock Server");
        vlanAddClockServerCol.setMinWidth(300);
        vlanAddClockServerCol.setCellValueFactory(
                new PropertyValueFactory<TableTwoConfigEnodeb, String>("vlanAddClockServer"));
        vlanAddClockServerCol.setSortType(TableColumn.SortType.DESCENDING);
        tableInitConfigTwo.setItems(_initiallyConfigTableTwo);
        tableInitConfigTwo.getColumns().addAll(
                m200IpAddColl,
                sgwNameIdCol,
                sgwIpAddOneCol,
                sgwIpAddTwoCol,
                sgwIpAddThreeCol,
                sgwIpAddFourCol,
                mmeNameCol,
                mmeIpAddFirstCol,
                mmeIpAddSecondCol,
                ipv4AddClockServerCol,
                nexthopAddClockServerCol,
                vlanAddClockServerCol);

        //Table Three init
        TableColumn cellCol = new TableColumn("CELL");
        cellCol.setMinWidth(300);
        cellCol.setCellValueFactory(
                new PropertyValueFactory<TableThreeConfigEnodeb, String>("cell"));
        cellCol.setSortType(TableColumn.SortType.DESCENDING);

        TableColumn txrxModeCol = new TableColumn("TX/RX Mode");
        txrxModeCol.setMinWidth(150);
        txrxModeCol.setCellValueFactory(
                new PropertyValueFactory<TableThreeConfigEnodeb, String>("txrxMode"));
        txrxModeCol.setSortType(TableColumn.SortType.DESCENDING);

        TableColumn pciCol = new TableColumn("PCI");
        pciCol.setMinWidth(150);
        pciCol.setCellValueFactory(
                new PropertyValueFactory<TableThreeConfigEnodeb, String>("pci"));
        pciCol.setSortType(TableColumn.SortType.DESCENDING);

        TableColumn downlinkCol = new TableColumn("Downlink EARFCN");
        downlinkCol.setMinWidth(300);
        downlinkCol.setCellValueFactory(
                new PropertyValueFactory<TableThreeConfigEnodeb, String>("downlink"));
        downlinkCol.setSortType(TableColumn.SortType.DESCENDING);
        tableInitConfigThree.setItems(_initiallyConfigTableThree);
        tableInitConfigThree.getColumns().addAll(
                cellCol,
                txrxModeCol,
                pciCol,
                downlinkCol);
    }

}
