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
    private final SimpleStringProperty neEnodeb;
    private final SimpleStringProperty ethernetPortNumberEnodeb;
    private final SimpleStringProperty interfaceIpAddEnodeb;
    private final SimpleStringProperty maskEnodeb;
    private final SimpleStringProperty nexthopIpAddEnodeb;
    private final SimpleStringProperty nexthopVlanAddEnodeb;

    public TableOneConfigEnodeb(SimpleStringProperty neEnodeb, SimpleStringProperty ethernetPortNumberEnodeb, SimpleStringProperty interfaceIpAddEnodeb, SimpleStringProperty maskEnodeb, SimpleStringProperty nexthopIpAddEnodeb, SimpleStringProperty nexthopVlanAddEnodeb) {
        this.neEnodeb = neEnodeb;
        this.ethernetPortNumberEnodeb = ethernetPortNumberEnodeb;
        this.interfaceIpAddEnodeb = interfaceIpAddEnodeb;
        this.maskEnodeb = maskEnodeb;
        this.nexthopIpAddEnodeb = nexthopIpAddEnodeb;
        this.nexthopVlanAddEnodeb = nexthopVlanAddEnodeb;
    }

    public SimpleStringProperty getNeEnodeb() {
        return neEnodeb;
    }

    public SimpleStringProperty getEthernetPortNumberEnodeb() {
        return ethernetPortNumberEnodeb;
    }

    public SimpleStringProperty getInterfaceIpAddEnodeb() {
        return interfaceIpAddEnodeb;
    }

    public SimpleStringProperty getMaskEnodeb() {
        return maskEnodeb;
    }

    public SimpleStringProperty getNexthopIpAddEnodeb() {
        return nexthopIpAddEnodeb;
    }

    public SimpleStringProperty getNexthopVlanAddEnodeb() {
        return nexthopVlanAddEnodeb;
    }

    @Override
    public String toString() {
        return "TableOneConfigEnodeb{" + "neEnodeb=" + neEnodeb.getValue() + ", ethernetPortNumberEnodeb=" + ethernetPortNumberEnodeb.getValue() + ", interfaceIpAddEnodeb=" + interfaceIpAddEnodeb.getValue() + ", maskEnodeb=" + maskEnodeb.getValue() + ", nexthopIpAddEnodeb=" + nexthopIpAddEnodeb.getValue() + ", nexthopVlanAddEnodeb=" + nexthopVlanAddEnodeb.getValue() + '}';
    }
    
    
}
