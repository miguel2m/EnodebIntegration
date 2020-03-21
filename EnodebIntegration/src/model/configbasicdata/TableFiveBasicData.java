/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.configbasicdata;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Miguelangel
 */
public class TableFiveBasicData {
    private SimpleStringProperty parameterId;
    private SimpleStringProperty mMode;
    private SimpleStringProperty st;
    private SimpleStringProperty et;
    private SimpleStringProperty mmSetRemark;

    public TableFiveBasicData(String parameterId, String mMode, String st, String et, String mmSetRemark) {
        this.parameterId = new SimpleStringProperty (parameterId);
        this.mMode = new SimpleStringProperty (mMode);
        this.st = new SimpleStringProperty (st);
        this.et = new SimpleStringProperty (et);
        this.mmSetRemark = new SimpleStringProperty (mmSetRemark);
    }

    public String getParameterId() {
        return parameterId.get();
    }

    public void setParameterId(String parameterId) {
        this.parameterId.set(parameterId);
    }

    public String getmMode() {
        return mMode.get();
    }

    public void setmMode(String mMode) {
        this.mMode.set(mMode);
    }

    public String getSt() {
        return st.get();
    }

    public void setSt(String st) {
        this.st.set(st);
    }

    public String getEt() {
        return et.get();
    }

    public void setEt(String et) {
        this.et.set(et);
    }

    public String getMmSetRemark() {
        return mmSetRemark.get();
    }

    public void setMmSetRemark(String mmSetRemark) {
        this.mmSetRemark.set(mmSetRemark);
    }

    @Override
    public String toString() {
        return "TableFiveBasicData{" + "parameterId=" + parameterId.getValue() + ", mMode=" + mMode.getValue() + ", st=" + st.getValue() + ", et=" + et.getValue() + ", mmSetRemark=" + mmSetRemark.getValue() + '}';
    }
    
    
    
}
