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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
    @FXML
    private TableView tableInitConfigOne;

    @FXML
    private TableView tableInitConfigTwo;

    @FXML
    private TableView tableInitConfigThree;
    
    public InitiallyConfigController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
    }

    @FXML
    void onAddTableInitOne(ActionEvent event) {
        System.out.println("onAddTableInitOne");
    }

    @FXML
    void onAddTableInitThree(ActionEvent event) {
        System.out.println("onAddTableInitThree");
    }

    @FXML
    void onAddTableInitTwo(ActionEvent event) {
        System.out.println("onAddTableInitTwo");
    }

    @FXML
    void onDeleteTableInitOne(ActionEvent event) {
        System.out.println("onDeleteTableInitOne");
    }

    @FXML
    void onDeleteTableInitThree(ActionEvent event) {
        System.out.println("onDeleteTableInitThree");
    }

    @FXML
    void onDeleteTableInitTwo(ActionEvent event) {
        System.out.println("onDeleteTableInitTwo");
    }

    @FXML
    void onDuplicateTableInitOne(ActionEvent event) {
        System.out.println("onDuplicateTableInitOne");
    }

    @FXML
    void onDuplicateTableInitThree(ActionEvent event) {
        System.out.println("onDuplicateTableInitThree");
    }

    @FXML
    void onDuplicateTableInitTwo(ActionEvent event) {
        System.out.println("onDuplicateTableInitTwo");
    }

    @FXML
    void onUpdateTableInitOne(ActionEvent event) {
        System.out.println("onUpdateTableInitOne");
    }

    @FXML
    void onUpdateTableInitThree(ActionEvent event) {
        System.out.println("onUpdateTableInitThree");
    }

    @FXML
    void onUpdateTableInitTwo(ActionEvent event) {
        System.out.println("onUpdateTableInitTwo");
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //Table One init
        TableColumn neCol = new TableColumn("NE");
        neCol.setMinWidth(100);
        neCol.setCellValueFactory(
                new PropertyValueFactory<TableOneConfigEnodeb, String>("NE"));
        neCol.setSortType(TableColumn.SortType.DESCENDING);
        
        TableColumn ethernetPortNumberEnodebCol = new TableColumn("Ethernet Port Number");
        ethernetPortNumberEnodebCol.setMinWidth(200);
        ethernetPortNumberEnodebCol.setCellValueFactory(
                new PropertyValueFactory<TableOneConfigEnodeb, String>("Ethernet Port Number"));
        ethernetPortNumberEnodebCol.setSortType(TableColumn.SortType.DESCENDING);
        
        TableColumn interfaceIpAddEnodebCol = new TableColumn("Interface IP Address");
        interfaceIpAddEnodebCol.setMinWidth(150);
        interfaceIpAddEnodebCol.setCellValueFactory(
                new PropertyValueFactory<TableOneConfigEnodeb, String>("Interface IP Address"));
        interfaceIpAddEnodebCol.setSortType(TableColumn.SortType.DESCENDING);
        
        TableColumn maskEnodebCol = new TableColumn("MASK");
        maskEnodebCol.setMinWidth(150);
        maskEnodebCol.setCellValueFactory(
                new PropertyValueFactory<TableOneConfigEnodeb, String>("MASK"));
        maskEnodebCol.setSortType(TableColumn.SortType.DESCENDING);
        
        TableColumn nexthopIpAddEnodebCol = new TableColumn("Next-Hop IP Address (M2000 | S-GW | MME)");
        nexthopIpAddEnodebCol.setMinWidth(300);
        nexthopIpAddEnodebCol.setCellValueFactory(
                new PropertyValueFactory<TableOneConfigEnodeb, String>("Next-Hop IP Address (M2000 | S-GW | MME)"));
        nexthopIpAddEnodebCol.setSortType(TableColumn.SortType.DESCENDING);
        
        TableColumn nexthopVlanAddEnodebCol = new TableColumn("Next-Hop VLAN (U2000 | S-GW | MME)");
        nexthopVlanAddEnodebCol.setMinWidth(300);
        nexthopVlanAddEnodebCol.setCellValueFactory(
                new PropertyValueFactory<TableOneConfigEnodeb, String>("Next-Hop VLAN (U2000 | S-GW | MME)"));
        nexthopVlanAddEnodebCol.setSortType(TableColumn.SortType.DESCENDING);
        //tableInitConfigOne.setItems(data);
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
                new PropertyValueFactory<TableTwoConfigEnodeb, String>("M2000 IP Address"));
        m200IpAddColl.setSortType(TableColumn.SortType.DESCENDING);
        
        TableColumn sgwNameIdCol = new TableColumn("S-GW Name_ID");
        sgwNameIdCol.setMinWidth(150);
        sgwNameIdCol.setCellValueFactory(
                new PropertyValueFactory<TableTwoConfigEnodeb, String>("S-GW Name_ID"));
        sgwNameIdCol.setSortType(TableColumn.SortType.DESCENDING);
        
        TableColumn sgwIpAddOneCol = new TableColumn("S-GW IP Address 1");
        sgwIpAddOneCol.setMinWidth(150);
        sgwIpAddOneCol.setCellValueFactory(
                new PropertyValueFactory<TableTwoConfigEnodeb, String>("S-GW IP Address 1"));
        sgwIpAddOneCol.setSortType(TableColumn.SortType.DESCENDING);
        
        TableColumn sgwIpAddTwoCol = new TableColumn("S-GW IP Address 2");
        sgwIpAddTwoCol.setMinWidth(150);
        sgwIpAddTwoCol.setCellValueFactory(
                new PropertyValueFactory<TableTwoConfigEnodeb, String>("S-GW IP Address 2"));
        sgwIpAddTwoCol.setSortType(TableColumn.SortType.DESCENDING);
        
        TableColumn sgwIpAddThreeCol = new TableColumn("S-GW IP Address 3");
        sgwIpAddThreeCol.setMinWidth(150);
        sgwIpAddThreeCol.setCellValueFactory(
                new PropertyValueFactory<TableTwoConfigEnodeb, String>("S-GW IP Address 3"));
        sgwIpAddThreeCol.setSortType(TableColumn.SortType.DESCENDING);
        
        TableColumn sgwIpAddFourCol = new TableColumn("S-GW IP Address 4");
        sgwIpAddFourCol.setMinWidth(150);
        sgwIpAddFourCol.setCellValueFactory(
                new PropertyValueFactory<TableTwoConfigEnodeb, String>("S-GW IP Address 4"));
        sgwIpAddFourCol.setSortType(TableColumn.SortType.DESCENDING);
        
        TableColumn mmeNameCol = new TableColumn("MME Name");
        sgwIpAddFourCol.setMinWidth(150);
        sgwIpAddFourCol.setCellValueFactory(
                new PropertyValueFactory<TableTwoConfigEnodeb, String>("MME Name"));
        sgwIpAddFourCol.setSortType(TableColumn.SortType.DESCENDING);
        
        TableColumn mmeIpAddFirstCol = new TableColumn("MME IP Address (First)");
        mmeIpAddFirstCol.setMinWidth(300);
        mmeIpAddFirstCol.setCellValueFactory(
                new PropertyValueFactory<TableTwoConfigEnodeb, String>("MME IP Address (First)"));
        mmeIpAddFirstCol.setSortType(TableColumn.SortType.DESCENDING);
        
        TableColumn mmeIpAddSecondCol = new TableColumn("MME IP Address (Second)");
        mmeIpAddSecondCol.setMinWidth(300);
        mmeIpAddSecondCol.setCellValueFactory(
                new PropertyValueFactory<TableTwoConfigEnodeb, String>("MME IP Address (Second)"));
        mmeIpAddSecondCol.setSortType(TableColumn.SortType.DESCENDING);
        
        TableColumn ipv4AddClockServerCol = new TableColumn("IPv4 Address of the IP Clock Server");
        ipv4AddClockServerCol.setMinWidth(300);
        ipv4AddClockServerCol.setCellValueFactory(
                new PropertyValueFactory<TableTwoConfigEnodeb, String>("IPv4 Address of the IP Clock Server"));
        ipv4AddClockServerCol.setSortType(TableColumn.SortType.DESCENDING);
        
        TableColumn nexthopAddClockServerCol = new TableColumn("Next-Hop IP Address - IP Clock Server");
        nexthopAddClockServerCol.setMinWidth(300);
        nexthopAddClockServerCol.setCellValueFactory(
                new PropertyValueFactory<TableTwoConfigEnodeb, String>("Next-Hop IP Address - IP Clock Server"));
        nexthopAddClockServerCol.setSortType(TableColumn.SortType.DESCENDING);
        
        TableColumn vlanAddClockServerCol = new TableColumn("Next-Hop VLAN IP - Clock Server");
        vlanAddClockServerCol.setMinWidth(300);
        vlanAddClockServerCol.setCellValueFactory(
                new PropertyValueFactory<TableTwoConfigEnodeb, String>("Next-Hop VLAN IP - Clock Server"));
        vlanAddClockServerCol.setSortType(TableColumn.SortType.DESCENDING);
        //tableInitConfigOne.setItems(data);
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
                new PropertyValueFactory<TableThreeConfigEnodeb, String>("CELL"));
        cellCol.setSortType(TableColumn.SortType.DESCENDING);
        
        TableColumn txrxModeCol = new TableColumn("TX/RX Mode");
        txrxModeCol.setMinWidth(150);
        txrxModeCol.setCellValueFactory(
                new PropertyValueFactory<TableThreeConfigEnodeb, String>("TX/RX Mode"));
        txrxModeCol.setSortType(TableColumn.SortType.DESCENDING);
        
        TableColumn pciCol = new TableColumn("PCI");
        pciCol.setMinWidth(150);
        pciCol.setCellValueFactory(
                new PropertyValueFactory<TableThreeConfigEnodeb, String>("PCI"));
        pciCol.setSortType(TableColumn.SortType.DESCENDING);
        
        TableColumn downlinkCol = new TableColumn("Downlink EARFCN");
        downlinkCol.setMinWidth(300);
        downlinkCol.setCellValueFactory(
                new PropertyValueFactory<TableThreeConfigEnodeb, String>("Downlink EARFCN"));
        downlinkCol.setSortType(TableColumn.SortType.DESCENDING);
        //tableInitConfigOne.setItems(data);
        tableInitConfigThree.getColumns().addAll(
                cellCol,
                txrxModeCol,
                pciCol,
                downlinkCol);
    }    
    
}
