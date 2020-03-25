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
public class TableFiveDeviceData {
    private String parameterId;
    private String cn;
    private String srn;
    private String sn;
    private String tp;
    private String rnc;
    private String ps;
    private String rt;
    private String rs;
    private String rn;
    private String rxnum;
    private String txnum;
    private String almprocsw;
    private String almprocthrhld;
    private String almthrhld;
    private String ifoffset;
    private String rfds;
    private String lcpsw;
    private String flag;
    private String ruspec;
    private String paeffswitch;

    public TableFiveDeviceData(String parameterId, String cn, String srn, String sn, String tp, String rnc, String ps, String rt, String rs, String rn, String rxnum, String txnum, String almprocsw, String almprocthrhld, String almthrhld, String ifoffset, String rfds, String lcpsw, String flag, String ruspec, String paeffswitch) {
        this.parameterId = parameterId;
        this.cn = cn;
        this.srn = srn;
        this.sn = sn;
        this.tp = tp;
        this.rnc = rnc;
        this.ps = ps;
        this.rt = rt;
        this.rs = rs;
        this.rn = rn;
        this.rxnum = rxnum;
        this.txnum = txnum;
        this.almprocsw = almprocsw;
        this.almprocthrhld = almprocthrhld;
        this.almthrhld = almthrhld;
        this.ifoffset = ifoffset;
        this.rfds = rfds;
        this.lcpsw = lcpsw;
        this.flag = flag;
        this.ruspec = ruspec;
        this.paeffswitch = paeffswitch;
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

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getTp() {
        return tp;
    }

    public void setTp(String tp) {
        this.tp = tp;
    }

    public String getRnc() {
        return rnc;
    }

    public void setRnc(String rnc) {
        this.rnc = rnc;
    }

    public String getPs() {
        return ps;
    }

    public void setPs(String ps) {
        this.ps = ps;
    }

    public String getRt() {
        return rt;
    }

    public void setRt(String rt) {
        this.rt = rt;
    }

    public String getRs() {
        return rs;
    }

    public void setRs(String rs) {
        this.rs = rs;
    }

    public String getRn() {
        return rn;
    }

    public void setRn(String rn) {
        this.rn = rn;
    }

    public String getRxnum() {
        return rxnum;
    }

    public void setRxnum(String rxnum) {
        this.rxnum = rxnum;
    }

    public String getTxnum() {
        return txnum;
    }

    public void setTxnum(String txnum) {
        this.txnum = txnum;
    }

    public String getAlmprocsw() {
        return almprocsw;
    }

    public void setAlmprocsw(String almprocsw) {
        this.almprocsw = almprocsw;
    }

    public String getAlmprocthrhld() {
        return almprocthrhld;
    }

    public void setAlmprocthrhld(String almprocthrhld) {
        this.almprocthrhld = almprocthrhld;
    }

    public String getAlmthrhld() {
        return almthrhld;
    }

    public void setAlmthrhld(String almthrhld) {
        this.almthrhld = almthrhld;
    }

    public String getIfoffset() {
        return ifoffset;
    }

    public void setIfoffset(String ifoffset) {
        this.ifoffset = ifoffset;
    }

    public String getRfds() {
        return rfds;
    }

    public void setRfds(String rfds) {
        this.rfds = rfds;
    }

    public String getLcpsw() {
        return lcpsw;
    }

    public void setLcpsw(String lcpsw) {
        this.lcpsw = lcpsw;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getRuspec() {
        return ruspec;
    }

    public void setRuspec(String ruspec) {
        this.ruspec = ruspec;
    }

    public String getPaeffswitch() {
        return paeffswitch;
    }

    public void setPaeffswitch(String paeffswitch) {
        this.paeffswitch = paeffswitch;
    }

    @Override
    public String toString() {
        return "TableFiveDeviceData{" + "parameterId=" + parameterId + ", cn=" + cn + ", srn=" + srn + ", sn=" + sn + ", tp=" + tp + ", rnc=" + rnc + ", ps=" + ps + ", rt=" + rt + ", rs=" + rs + ", rn=" + rn + ", rxnum=" + rxnum + ", txnum=" + txnum + ", almprocsw=" + almprocsw + ", almprocthrhld=" + almprocthrhld + ", almthrhld=" + almthrhld + ", ifoffset=" + ifoffset + ", rfds=" + rfds + ", lcpsw=" + lcpsw + ", flag=" + flag + ", ruspec=" + ruspec + ", paeffswitch=" + paeffswitch + '}';
    }
    
    
}
