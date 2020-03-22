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
public class TableSevenBasicData {
    private SimpleStringProperty parameterId;
    private SimpleStringProperty trackingAreaId;
    private SimpleStringProperty cnOperatorId;
    private SimpleStringProperty tac;

    public TableSevenBasicData(String parameterId, String trackingAreaId, String cnOperatorId, String tac) {
        this.parameterId = new SimpleStringProperty( parameterId);
        this.trackingAreaId = new SimpleStringProperty( trackingAreaId);
        this.cnOperatorId = new SimpleStringProperty( cnOperatorId);
        this.tac = new SimpleStringProperty( tac);
    }

    public String getParameterId() {
        return parameterId.get();
    }

    public void setParameterId(String parameterId) {
        this.parameterId.set(parameterId);
    }

    public String getTrackingAreaId() {
        return trackingAreaId.get();
    }

    public void setTrackingAreaId(String trackingAreaId) {
        this.trackingAreaId.set(trackingAreaId);
    }

    public String getCnOperatorId() {
        return cnOperatorId.get();
    }

    public void setCnOperatorId(String cnOperatorId) {
        this.cnOperatorId.set(cnOperatorId);
    }

    public String getTac() {
        return tac.get();
    }

    public void setTac(String tac) {
        this.tac.set(tac);
    }

    @Override
    public String toString() {
        return "TableSevenBasicData{" + "parameterId=" + parameterId.getValue() + ", trackingAreaId=" + trackingAreaId.getValue() + ", cnOperatorId=" + cnOperatorId.getValue() + ", tac=" + tac.getValue() + '}';
    }
    
    
}
