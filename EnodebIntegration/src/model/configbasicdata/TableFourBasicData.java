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
public class TableFourBasicData {
    private SimpleStringProperty parameterId;
    private SimpleStringProperty eNodeBFunctionName;
    private SimpleStringProperty appRef;
    private SimpleStringProperty enodebId;
    private SimpleStringProperty userLabel;

    public TableFourBasicData(String parameterId, String eNodeBFunctionName, String appRef, String enodebId, String userLabel) {
        this.parameterId = new SimpleStringProperty(  parameterId);
        this.eNodeBFunctionName = new SimpleStringProperty(eNodeBFunctionName);
        this.appRef = new SimpleStringProperty(appRef);
        this.enodebId = new SimpleStringProperty(enodebId);
        this.userLabel = new SimpleStringProperty(userLabel);
    }

    public String getParameterId() {
        return parameterId.get();
    }

    public void setParameterId(String parameterId) {
        this.parameterId.set(parameterId);
    }

    public String geteNodeBFunctionName() {
        return eNodeBFunctionName.get();
    }

    public void seteNodeBFunctionName(String eNodeBFunctionName) {
        this.eNodeBFunctionName.set(eNodeBFunctionName);
    }

    public String getAppRef() {
        return appRef.get();
    }

    public void setAppRef(String appRef) {
        this.appRef.set(appRef);
    }

    public String getEnodebId() {
        return enodebId.get();
    }

    public void setEnodebId(String enodebId) {
        this.enodebId.set(enodebId);
    }

    public String getUserLabel() {
        return userLabel.get();
    }

    public void setUserLabel(String UserLabel) {
        this.userLabel.set(UserLabel);
    }

    @Override
    public String toString() {
        return "TableFourBasicData{" + "parameterId=" + parameterId.getValue() + ", eNodeBFunctionName=" + eNodeBFunctionName.getValue() + ", appRef=" + appRef.getValue() + ", enodebId=" + enodebId.getValue() + ", UserLabel=" + userLabel.getValue() + '}';
    }
    
    
}
