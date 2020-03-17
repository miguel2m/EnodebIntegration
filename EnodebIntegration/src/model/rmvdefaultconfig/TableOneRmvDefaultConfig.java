/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.rmvdefaultconfig;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Miguelangel
 */
public class TableOneRmvDefaultConfig {
    private SimpleStringProperty parameterIdRmv;
    private SimpleStringProperty switchRmv;
    private SimpleStringProperty vlanScanRmv;

    public TableOneRmvDefaultConfig(String parameterIdRmv, String switchRmv, String vlanScanRmv) {
        this.parameterIdRmv = new SimpleStringProperty(parameterIdRmv);
        this.switchRmv = new SimpleStringProperty( switchRmv);
        this.vlanScanRmv = new SimpleStringProperty (vlanScanRmv);
    }

    public String getParameterIdRmv() {
        return parameterIdRmv.get();
    }

    public void setParameterIdRmv(String parameterIdRmv) {
        this.parameterIdRmv.set(parameterIdRmv);
    }

    public String getSwitchRmv() {
        return switchRmv.get();
    }

    public void setSwitchRmv(String switchRmv) {
        this.switchRmv.set(switchRmv);
    }

    public String getVlanScanRmv() {
        return vlanScanRmv.get();
    }

    public void setVlanScanRmv(String vlanScanRmv) {
        this.vlanScanRmv.set(vlanScanRmv);
    }

    @Override
    public String toString() {
        return "TableOneRmvDefaultConfig{" + "parameterIdRmv=" + parameterIdRmv.getValue() + ", switchRmv=" + switchRmv.getValue() + ", vlanScanRmv=" + vlanScanRmv.getValue() + '}';
    }
    
    
    
}
