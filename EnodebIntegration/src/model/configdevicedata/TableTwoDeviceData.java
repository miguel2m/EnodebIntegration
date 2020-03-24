/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.configdevicedata;

/**
 *
 * @author Miguelangel
 */
public class TableTwoDeviceData {
    private String parameterId;
    private String cn;
    private String srn;
    private String type;
    private String desc;

    public TableTwoDeviceData(String parameterId, String cn, String srn, String type, String desc) {
        this.parameterId = parameterId;
        this.cn = cn;
        this.srn = srn;
        this.type = type;
        this.desc = desc;
    }

    public String getParameterId() {
        return parameterId;
    }

    public void setParameterId(String parameterId) {
        this.parameterId = parameterId;
    }

    public String getCn() {
        return cn;
    }

    public void setCn(String cn) {
        this.cn = cn;
    }

    public String getSrn() {
        return srn;
    }

    public void setSrn(String srn) {
        this.srn = srn;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "TableTwoDeviceData{" + "parameterId=" + parameterId + ", cn=" + cn + ", srn=" + srn + ", type=" + type + ", desc=" + desc + '}';
    }
    
    
}
