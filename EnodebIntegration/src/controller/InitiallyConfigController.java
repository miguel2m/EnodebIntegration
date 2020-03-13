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
    }    
    
}
