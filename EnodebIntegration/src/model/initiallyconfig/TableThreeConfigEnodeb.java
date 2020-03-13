/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.initiallyconfig;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author P05144
 */
public class TableThreeConfigEnodeb {
    private SimpleStringProperty cell;
    private SimpleStringProperty txrxMode;
    private SimpleStringProperty pci;
    private SimpleStringProperty downlink;

    public TableThreeConfigEnodeb(SimpleStringProperty cell, SimpleStringProperty txrxMode, SimpleStringProperty pci, SimpleStringProperty downlink) {
        this.cell = cell;
        this.txrxMode = txrxMode;
        this.pci = pci;
        this.downlink = downlink;
    }

    public SimpleStringProperty getCell() {
        return cell;
    }

    public void setCell(SimpleStringProperty cell) {
        this.cell = cell;
    }

    public SimpleStringProperty getTxrxMode() {
        return txrxMode;
    }

    public void setTxrxMode(SimpleStringProperty txrxMode) {
        this.txrxMode = txrxMode;
    }

    public SimpleStringProperty getPci() {
        return pci;
    }

    public void setPci(SimpleStringProperty pci) {
        this.pci = pci;
    }

    public SimpleStringProperty getDownlink() {
        return downlink;
    }

    public void setDownlink(SimpleStringProperty downlink) {
        this.downlink = downlink;
    }

    @Override
    public String toString() {
        return "TableThreeConfigEnodeb{" + "cell=" + cell.getValue() + ", txrxMode=" + txrxMode.getValue() + ", pci=" + pci.getValue() + ", downlink=" + downlink.getValue() + '}';
    }

    

    
}
