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
public class TableTwoBasicData {
    private SimpleStringProperty parameterId;
    private SimpleStringProperty productType;
    private SimpleStringProperty userLabel;
    private SimpleStringProperty neRmVersion;
    private SimpleStringProperty nodeId;
    private SimpleStringProperty nodeName;
    private SimpleStringProperty workingMode;

    public TableTwoBasicData(String parameterId, String productType, String userLabel, String neRmVersion, String nodeId, String nodeName, String workingMode) {
        this.parameterId = new SimpleStringProperty(parameterId);
        this.productType = new SimpleStringProperty(productType);
        this.userLabel = new SimpleStringProperty(userLabel);
        this.neRmVersion = new SimpleStringProperty(neRmVersion);
        this.nodeId = new SimpleStringProperty(nodeId);
        this.nodeName = new SimpleStringProperty(nodeName);
        this.workingMode = new SimpleStringProperty(workingMode);
    }

    public String getParameterId() {
        return parameterId.get();
    }

    public void setParameterId(String parameterId) {
        this.parameterId.set(parameterId);
    }

    public String getProductType() {
        return productType.get();
    }

    public void setProductType(String productType) {
        this.productType.set(productType);
    }

    public String getUserLabel() {
        return userLabel.get();
    }

    public void setUserLabel(String userLabel) {
        this.userLabel.set(userLabel);
    }

    public String getNeRmVersion() {
        return neRmVersion.get();
    }

    public void setNeRmVersion(String neRmVersion) {
        this.neRmVersion.set(neRmVersion);
    }

    public String getNodeId() {
        return nodeId.get();
    }

    public void setNodeId(String nodeId) {
        this.nodeId.set(nodeId);
    }

    public String getNodeName() {
        return nodeName.get();
    }

    public void setNodeName(String nodeName) {
        this.nodeName.set(nodeName);
    }

    public String getWorkingMode() {
        return workingMode.get();
    }

    public void setWorkingMode(String workingMode) {
        this.workingMode.set(workingMode);
    }

    @Override
    public String toString() {
        return "TableTwoBasicData{" + "parameterId=" + parameterId.getValue() + ", productType=" + productType.getValue()  + ", userLabel=" + userLabel.getValue()  + ", neRmVersion=" + neRmVersion.getValue()  + ", nodeId=" + nodeId.getValue()  + ", nodeName=" + nodeName.getValue()  + ", workingMode=" + workingMode.getValue()  + '}';
    }
    
    
}
