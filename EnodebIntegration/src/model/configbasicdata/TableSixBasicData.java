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
public class TableSixBasicData {
    private SimpleStringProperty parameterId;
    private SimpleStringProperty cnOperatorId;
    private SimpleStringProperty cnOperatorName;
    private SimpleStringProperty cnOperatorType;
    private SimpleStringProperty mcc;
    private SimpleStringProperty mnc;

    public TableSixBasicData(String parameterId, String cnOperatorId, String cnOperatorName, String cnOperatorType, String mcc, String mnc) {
        this.parameterId = new SimpleStringProperty(parameterId);
        this.cnOperatorId = new SimpleStringProperty(cnOperatorId);
        this.cnOperatorName = new SimpleStringProperty(cnOperatorName);
        this.cnOperatorType = new SimpleStringProperty(cnOperatorType);
        this.mcc = new SimpleStringProperty(mcc);
        this.mnc = new SimpleStringProperty(mnc);
    }

    public String getParameterId() {
        return parameterId.get();
    }

    public void setParameterId(String parameterId) {
        this.parameterId.set(parameterId);
    }

    public String getCnOperatorId() {
        return cnOperatorId.get();
    }

    public void setCnOperatorId(String cnOperatorId) {
        this.cnOperatorId.set(cnOperatorId);
    }

    public String getCnOperatorName() {
        return cnOperatorName.get();
    }

    public void setCnOperatorName(String cnOperatorName) {
        this.cnOperatorName.set(cnOperatorName);
    }

    public String getCnOperatorType() {
        return cnOperatorType.get();
    }

    public void setCnOperatorType(String cnOperatorType) {
        this.cnOperatorType.set(cnOperatorType);
    }

    public String getMcc() {
        return mcc.get();
    }

    public void setMcc(String mcc) {
        this.mcc.set(mcc);
    }

    public String getMnc() {
        return mnc.get();
    }

    public void setMnc(String mnc) {
        this.mnc.set(mnc);
    }

    @Override
    public String toString() {
        return "TableSixBasicData{" + "parameterId=" + parameterId.getValue() + ", cnOperatorId=" + cnOperatorId.getValue() + ", cnOperatorName=" + cnOperatorName.getValue() + ", cnOperatorType=" + cnOperatorType.getValue() + ", mcc=" + mcc.getValue() + ", mnc=" + mnc.getValue() + '}';
    }
    
    
    
    
}
