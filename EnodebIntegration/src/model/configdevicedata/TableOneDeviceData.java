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
public class TableOneDeviceData {
    private String parameterId;
    private String cn;
    private String type;
    private String desc;

    public TableOneDeviceData(String parameterId, String cn, String type, String desc) {
        this.parameterId = parameterId;
        this.cn = cn;
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
        return "TableOneDeviceData{" + "parameterId=" + parameterId + ", cn=" + cn + ", type=" + type + ", desc=" + desc + '}';
    }
    
    
}
