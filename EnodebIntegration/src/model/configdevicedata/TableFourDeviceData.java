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
public class TableFourDeviceData {
    private String parameterId;
    private String rnc;
    private String tt;
    private String bm;
    private String at;
    private String hcn;
    private String hsrn;
    private String hsn;
    private String hpn;
    private String tcn;
    private String tsrn;
    private String tsn;
    private String tpn;
    private String cr;

    public TableFourDeviceData(String parameterId, String rnc, String tt, String bm, String at, String hcn, String hsrn, String hsn, String hpn, String tcn, String tsrn, String tsn, String tpn, String cr) {
        this.parameterId = parameterId;
        this.rnc = rnc;
        this.tt = tt;
        this.bm = bm;
        this.at = at;
        this.hcn = hcn;
        this.hsrn = hsrn;
        this.hsn = hsn;
        this.hpn = hpn;
        this.tcn = tcn;
        this.tsrn = tsrn;
        this.tsn = tsn;
        this.tpn = tpn;
        this.cr = cr;
    }

    public String getParameterId() {
        return parameterId;
    }

    public void setParameterId(String parameterId) {
        this.parameterId = parameterId;
    }

    public String getRnc() {
        return rnc;
    }

    public void setRnc(String rnc) {
        this.rnc = rnc;
    }

    public String getTt() {
        return tt;
    }

    public void setTt(String tt) {
        this.tt = tt;
    }

    public String getBm() {
        return bm;
    }

    public void setBm(String bm) {
        this.bm = bm;
    }

    public String getAt() {
        return at;
    }

    public void setAt(String at) {
        this.at = at;
    }

    public String getHcn() {
        return hcn;
    }

    public void setHcn(String hcn) {
        this.hcn = hcn;
    }

    public String getHsrn() {
        return hsrn;
    }

    public void setHsrn(String hsrn) {
        this.hsrn = hsrn;
    }

    public String getHsn() {
        return hsn;
    }

    public void setHsn(String hsn) {
        this.hsn = hsn;
    }

    public String getHpn() {
        return hpn;
    }

    public void setHpn(String hpn) {
        this.hpn = hpn;
    }

    public String getTcn() {
        return tcn;
    }

    public void setTcn(String tcn) {
        this.tcn = tcn;
    }

    public String getTsrn() {
        return tsrn;
    }

    public void setTsrn(String tsrn) {
        this.tsrn = tsrn;
    }

    public String getTsn() {
        return tsn;
    }

    public void setTsn(String tsn) {
        this.tsn = tsn;
    }

    public String getTpn() {
        return tpn;
    }

    public void setTpn(String tpn) {
        this.tpn = tpn;
    }

    public String getCr() {
        return cr;
    }

    public void setCr(String cr) {
        this.cr = cr;
    }

    @Override
    public String toString() {
        return "TableFourDeviceData{" + "parameterId=" + parameterId + ", rnc=" + rnc + ", tt=" + tt + ", bm=" + bm + ", at=" + at + ", hcn=" + hcn + ", hsrn=" + hsrn + ", hsn=" + hsn + ", hpn=" + hpn + ", tcn=" + tcn + ", tsrn=" + tsrn + ", tsn=" + tsn + ", tpn=" + tpn + ", cr=" + cr + '}';
    }
    
    
}
