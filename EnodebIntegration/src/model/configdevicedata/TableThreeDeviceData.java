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
public class TableThreeDeviceData {
    private String parameterId;
    private String cn;
    private String srn;
    private String sn;
    private String bt;
    private String sbt;
    private String bbws;
    private String hce;
    private String cpriex;
    private String brdspec;
    private String ccne;

    public TableThreeDeviceData(String parameterId, String cn, String srn, String sn, String bt, String sbt, String bbws, String hce, String cpriex, String brdspec, String ccne) {
        this.parameterId = parameterId;
        this.cn = cn;
        this.srn = srn;
        this.sn = sn;
        this.bt = bt;
        this.sbt = sbt;
        this.bbws = bbws;
        this.hce = hce;
        this.cpriex = cpriex;
        this.brdspec = brdspec;
        this.ccne = ccne;
    }

    public String getCn() {
        return cn;
    }

    public void setCn(String cn) {
        this.cn = cn;
    }   

    public String getParameterId() {
        return parameterId;
    }

    public void setParameterId(String parameterId) {
        this.parameterId = parameterId;
    }

    public String getSrn() {
        return srn;
    }

    public void setSrn(String srn) {
        this.srn = srn;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getBt() {
        return bt;
    }

    public void setBt(String bt) {
        this.bt = bt;
    }

    public String getSbt() {
        return sbt;
    }

    public void setSbt(String sbt) {
        this.sbt = sbt;
    }

    public String getBbws() {
        return bbws;
    }

    public void setBbws(String bbws) {
        this.bbws = bbws;
    }

    public String getHce() {
        return hce;
    }

    public void setHce(String hce) {
        this.hce = hce;
    }

    public String getCpriex() {
        return cpriex;
    }

    public void setCpriex(String cpriex) {
        this.cpriex = cpriex;
    }

    public String getBrdspec() {
        return brdspec;
    }

    public void setBrdspec(String brdspec) {
        this.brdspec = brdspec;
    }

    public String getCcne() {
        return ccne;
    }

    public void setCcne(String ccne) {
        this.ccne = ccne;
    }

    @Override
    public String toString() {
        return "TableThreeDeviceData{" + "parameterId=" + parameterId + ", srn=" + srn + ", sn=" + sn + ", bt=" + bt + ", sbt=" + sbt + ", bbws=" + bbws + ", hce=" + hce + ", cpriex=" + cpriex + ", brdspec=" + brdspec + ", ccne=" + ccne + '}';
    }
    
    
}
