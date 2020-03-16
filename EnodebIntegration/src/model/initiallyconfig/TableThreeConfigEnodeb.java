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

    public TableThreeConfigEnodeb(String cell, String txrxMode, String pci, String downlink) {
        this.cell = new SimpleStringProperty (cell);
        this.txrxMode =new SimpleStringProperty ( txrxMode);
        this.pci = new SimpleStringProperty (pci);
        this.downlink = new SimpleStringProperty (downlink);
    }

    public String getCell() {
        return cell.get();
    }

    public void setCell(String cell) {
        this.cell.set(cell);
    }

    public String getTxrxMode() {
        return txrxMode.get();
    }

    public void setTxrxMode(String txrxMode) {
        this.txrxMode.set(txrxMode);
    }

    public String getPci() {
        return pci.get();
    }

    public void setPci(String pci) {
        this.pci.set(pci);
    }

    public String getDownlink() {
        return downlink.get();
    }

    public void setDownlink(String downlink) {
        this.downlink.set(downlink);
    }

    @Override
    public String toString() {
        return "TableThreeConfigEnodeb{" + "cell=" + cell.getValue() + ", txrxMode=" + txrxMode.getValue() + ", pci=" + pci.getValue() + ", downlink=" + downlink.getValue() + '}';
    }

    

    
}
