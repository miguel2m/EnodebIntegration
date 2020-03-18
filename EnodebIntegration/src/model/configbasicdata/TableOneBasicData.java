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
public class TableOneBasicData {
    private SimpleStringProperty parameterId;
    private SimpleStringProperty neName;
    private SimpleStringProperty location;
    private SimpleStringProperty did;
    private SimpleStringProperty siteName;
    private SimpleStringProperty userLabel;

    public TableOneBasicData(String parameterId, String neName, String location, String did, String siteName, String userLabel) {
        this.parameterId = new SimpleStringProperty( parameterId);
        this.neName = new SimpleStringProperty( neName);
        this.location = new SimpleStringProperty( location);
        this.did = new SimpleStringProperty( did);
        this.siteName = new SimpleStringProperty( siteName);
        this.userLabel = new SimpleStringProperty( userLabel);
    }

    public String getParameterId() {
        return parameterId.get();
    }

    public void setParameterId(String parameterId) {
        this.parameterId.set( parameterId);
    }

    public String getNeName() {
        return neName.get();
    }

    public void setNeName(String neName) {
        this.neName.set(neName);
    }

    public String getLocation() {
        return location.get();
    }

    public void setLocation(String location) {
        this.location.set(location);
    }

    public String getDid() {
        return did.get();
    }

    public void setDid(String did) {
        this.did.set(did);
    }

    public String getSiteName() {
        return siteName.get();
    }

    public void setSiteName(String siteName) {
        this.siteName.set(siteName);
    }

    public String getUserLabel() {
        return userLabel.get();
    }

    public void setUserLabel(String userLabel) {
        this.userLabel.set(userLabel);
    }

    @Override
    public String toString() {
        return "TableOneBasicData{" + "parameterId=" + parameterId.getValue() + ", neName=" + neName.getValue() + ", location=" + location.getValue() + ", did=" + did.getValue() + ", siteName=" + siteName.getValue() + ", userLabel=" + userLabel.getValue() + '}';
    }
    
    
    
}
