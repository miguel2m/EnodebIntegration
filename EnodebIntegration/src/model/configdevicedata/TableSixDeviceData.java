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
public class TableSixDeviceData {
    private String parameterId;
    private String zonet;
    private String timediff;
    private String dst;
    private String sm;
    private String smoth;
    private String sday;
    private String swseq;
    private String sweek;
    private String st;
    private String em;
    private String emoth;
    private String eday;
    private String ewseq;
    private String eweek;
    private String et;
    private String to;

    public TableSixDeviceData(String parameterId, String zonet, String timediff, String dst, String sm, String smoth, String sday, String swseq, String sweek, String st, String em, String emoth, String eday, String ewseq, String eweek, String et, String to) {
        this.parameterId = parameterId;
        this.zonet = zonet;
        this.timediff = timediff;
        this.dst = dst;
        this.sm = sm;
        this.smoth = smoth;
        this.sday = sday;
        this.swseq = swseq;
        this.sweek = sweek;
        this.st = st;
        this.em = em;
        this.emoth = emoth;
        this.eday = eday;
        this.ewseq = ewseq;
        this.eweek = eweek;
        this.et = et;
        this.to = to;
    }

    public String getParameterId() {
        return parameterId;
    }

    public void setParameterId(String parameterId) {
        this.parameterId = parameterId;
    }

    public String getZonet() {
        return zonet;
    }

    public void setZonet(String zonet) {
        this.zonet = zonet;
    }

    public String getTimediff() {
        return timediff;
    }

    public void setTimediff(String timediff) {
        this.timediff = timediff;
    }

    public String getDst() {
        return dst;
    }

    public void setDst(String dst) {
        this.dst = dst;
    }

    public String getSm() {
        return sm;
    }

    public void setSm(String sm) {
        this.sm = sm;
    }

    public String getSmoth() {
        return smoth;
    }

    public void setSmoth(String smoth) {
        this.smoth = smoth;
    }

    public String getSday() {
        return sday;
    }

    public void setSday(String sday) {
        this.sday = sday;
    }

    public String getSwseq() {
        return swseq;
    }

    public void setSwseq(String swseq) {
        this.swseq = swseq;
    }

    public String getSweek() {
        return sweek;
    }

    public void setSweek(String sweek) {
        this.sweek = sweek;
    }

    public String getSt() {
        return st;
    }

    public void setSt(String st) {
        this.st = st;
    }

    public String getEm() {
        return em;
    }

    public void setEm(String em) {
        this.em = em;
    }

    public String getEmoth() {
        return emoth;
    }

    public void setEmoth(String emoth) {
        this.emoth = emoth;
    }

    public String getEday() {
        return eday;
    }

    public void setEday(String eday) {
        this.eday = eday;
    }

    public String getEwseq() {
        return ewseq;
    }

    public void setEwseq(String ewseq) {
        this.ewseq = ewseq;
    }

    public String getEweek() {
        return eweek;
    }

    public void setEweek(String eweek) {
        this.eweek = eweek;
    }

    public String getEt() {
        return et;
    }

    public void setEt(String et) {
        this.et = et;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "TableSixDeviceData{" + "parameterId=" + parameterId + ", zonet=" + zonet + ", timediff=" + timediff + ", dst=" + dst + ", sm=" + sm + ", smoth=" + smoth + ", sday=" + sday + ", swseq=" + swseq + ", sweek=" + sweek + ", st=" + st + ", em=" + em + ", emoth=" + emoth + ", eday=" + eday + ", ewseq=" + ewseq + ", eweek=" + eweek + ", et=" + et + ", to=" + to + '}';
    }
    
    
}
