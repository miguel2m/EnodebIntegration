/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.initiallyconfig;

import javafx.beans.property.SimpleStringProperty;

/**
 * Clase para la tabla 1 del Initially Configuration
 * @author P05144
 * 
 */
public class TableOneConfigEnodeb {
    private SimpleStringProperty neEnodeb;
    private SimpleStringProperty ethernetPortNumberEnodeb;
    private SimpleStringProperty interfaceIpAddEnodeb;
    private SimpleStringProperty maskEnodeb;
    private SimpleStringProperty nexthopIpAddEnodeb;
    private SimpleStringProperty nexthopVlanAddEnodeb;

    public TableOneConfigEnodeb(String neEnodeb, String ethernetPortNumberEnodeb, String interfaceIpAddEnodeb, String maskEnodeb, String nexthopIpAddEnodeb, String nexthopVlanAddEnodeb) {
        this.neEnodeb = new SimpleStringProperty (neEnodeb);
        this.ethernetPortNumberEnodeb = new SimpleStringProperty (ethernetPortNumberEnodeb);
        this.interfaceIpAddEnodeb = new SimpleStringProperty (interfaceIpAddEnodeb);
        this.maskEnodeb = new SimpleStringProperty (maskEnodeb);
        this.nexthopIpAddEnodeb = new SimpleStringProperty (nexthopIpAddEnodeb);
        this.nexthopVlanAddEnodeb = new SimpleStringProperty (nexthopVlanAddEnodeb);
    }

    public String getNeEnodeb() {
        return neEnodeb.get();
    }

    public void setNeEnodeb(String neEnodeb) {
        this.neEnodeb.set(neEnodeb);
    }

    public String getEthernetPortNumberEnodeb() {
        return ethernetPortNumberEnodeb.get();
    }

    public void setEthernetPortNumberEnodeb(String ethernetPortNumberEnodeb) {
        this.ethernetPortNumberEnodeb.set(ethernetPortNumberEnodeb);
    }

    public String getInterfaceIpAddEnodeb() {
        return interfaceIpAddEnodeb.get();
    }

    public void setInterfaceIpAddEnodeb(String interfaceIpAddEnodeb) {
        this.interfaceIpAddEnodeb.set(interfaceIpAddEnodeb);
    }

    public String getMaskEnodeb() {
        return maskEnodeb.get();
    }

    public void setMaskEnodeb(String maskEnodeb) {
        this.maskEnodeb.set(maskEnodeb);
    }

    public String getNexthopIpAddEnodeb() {
        return nexthopIpAddEnodeb.get();
    }

    public void setNexthopIpAddEnodeb(String nexthopIpAddEnodeb) {
        this.nexthopIpAddEnodeb.set(nexthopIpAddEnodeb);
    }

    public String getNexthopVlanAddEnodeb() {
        return nexthopVlanAddEnodeb.get();
    }

    public void setNexthopVlanAddEnodeb(String nexthopVlanAddEnodeb) {
        this.nexthopVlanAddEnodeb.set(nexthopVlanAddEnodeb);
    }



    @Override
    public String toString() {
        return "TableOneConfigEnodeb{" + "neEnodeb=" + neEnodeb.getValue() + ", ethernetPortNumberEnodeb=" + ethernetPortNumberEnodeb.getValue() + ", interfaceIpAddEnodeb=" + interfaceIpAddEnodeb.getValue() + ", maskEnodeb=" + maskEnodeb.getValue() + ", nexthopIpAddEnodeb=" + nexthopIpAddEnodeb.getValue() + ", nexthopVlanAddEnodeb=" + nexthopVlanAddEnodeb.getValue() + '}';
    }
    
    
}
