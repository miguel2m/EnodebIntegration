/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.initiallyconfig;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author P05144
 */
public class TableTwoConfigEnodeb {
    private SimpleStringProperty m200IpAdd;
    private SimpleStringProperty sgwNameId;
    private SimpleStringProperty sgwIpAddOne;
    private SimpleStringProperty sgwIpAddTwo;
    private SimpleStringProperty sgwIpAddThree;
    private SimpleStringProperty sgwIpAddFour;
    private SimpleStringProperty mmeName;
    private SimpleStringProperty mmeIpAddFirst;
    private SimpleStringProperty mmeIpAddSecond;
    private SimpleStringProperty ipv4AddClockServer;
    private SimpleStringProperty nexthopAddClockServer;
    private SimpleStringProperty vlanAddClockServer;

    public TableTwoConfigEnodeb(String m200IpAdd, String sgwNameId, String sgwIpAddOne, String sgwIpAddTwo, String sgwIpAddThree, String sgwIpAddFour, String mmeName, String mmeIpAddFirst, String mmeIpAddSecond, String ipv4AddClockServer, String nexthopAddClockServer, String vlanAddClockServer) {
        this.m200IpAdd = new SimpleStringProperty( m200IpAdd);
        this.sgwNameId = new SimpleStringProperty( sgwNameId);
        this.sgwIpAddOne = new SimpleStringProperty( sgwIpAddOne);
        this.sgwIpAddTwo = new SimpleStringProperty( sgwIpAddTwo);
        this.sgwIpAddThree = new SimpleStringProperty( sgwIpAddThree);
        this.sgwIpAddFour = new SimpleStringProperty( sgwIpAddFour);
        this.mmeName = new SimpleStringProperty( mmeName);
        this.mmeIpAddFirst = new SimpleStringProperty(  mmeIpAddFirst);
        this.mmeIpAddSecond = new SimpleStringProperty( mmeIpAddSecond);
        this.ipv4AddClockServer = new SimpleStringProperty( ipv4AddClockServer);
        this.nexthopAddClockServer = new SimpleStringProperty( nexthopAddClockServer);
        this.vlanAddClockServer = new SimpleStringProperty( vlanAddClockServer);
    }

    public String getM200IpAdd() {
        return m200IpAdd.get();
    }

    public void setM200IpAdd(String m200IpAdd) {
        this.m200IpAdd.set(m200IpAdd);
    }

    public String getSgwNameId() {
        return sgwNameId.get();
    }

    public void setSgwNameId(String sgwNameId) {
        this.sgwNameId.set(sgwNameId);
    }

    public String getSgwIpAddOne() {
        return sgwIpAddOne.get();
    }

    public void setSgwIpAddOne(String sgwIpAddOne) {
        this.sgwIpAddOne.set(sgwIpAddOne);
    }

    public String getSgwIpAddTwo() {
        return sgwIpAddTwo.get();
    }

    public void setSgwIpAddTwo(String sgwIpAddTwo) {
        this.sgwIpAddTwo.set(sgwIpAddTwo);
    }

    public String getSgwIpAddThree() {
        return sgwIpAddThree.get();
    }

    public void setSgwIpAddThree(String sgwIpAddThree) {
        this.sgwIpAddThree.set(sgwIpAddThree);
    }

    public String getSgwIpAddFour() {
        return sgwIpAddFour.get();
    }

    public void setSgwIpAddFour(String sgwIpAddFour) {
        this.sgwIpAddFour.set(sgwIpAddFour);
    }

    public String getMmeName() {
        return mmeName.get();
    }

    public void setMmeName(String mmeName) {
        this.mmeName.set(mmeName);
    }

    public String getMmeIpAddFirst() {
        return mmeIpAddFirst.get();
    }

    public void setMmeIpAddFirst(String mmeIpAddFirst) {
        this.mmeIpAddFirst.set(mmeIpAddFirst);
    }

    public String getMmeIpAddSecond() {
        return mmeIpAddSecond.get();
    }

    public void setMmeIpAddSecond(String mmeIpAddSecond) {
        this.mmeIpAddSecond.set(mmeIpAddSecond);
    }

    public String getIpv4AddClockServer() {
        return ipv4AddClockServer.get();
    }

    public void setIpv4AddClockServer(String ipv4AddClockServer) {
        this.ipv4AddClockServer.set(ipv4AddClockServer);
    }

    public String getNexthopAddClockServer() {
        return nexthopAddClockServer.get();
    }

    public void setNexthopAddClockServer(String nexthopAddClockServer) {
        this.nexthopAddClockServer.set(nexthopAddClockServer);
    }

    public String getVlanAddClockServer() {
        return vlanAddClockServer.get();
    }

    public void setVlanAddClockServer(String vlanAddClockServer) {
        this.vlanAddClockServer.set(vlanAddClockServer);
    }
    
    @Override
    public String toString() {
        return "TableTwoConfigEnodeb{" + "m200IpAdd=" + m200IpAdd.getValue() + ", sgwNameId=" + sgwNameId.getValue() + ", sgwIpAddOne=" + sgwIpAddOne.getValue() + ", sgwIpAddTwo=" + sgwIpAddTwo.getValue() + ", sgwIpAddThree=" + sgwIpAddThree.getValue() + ", sgwIpAddFour=" + sgwIpAddFour.getValue() + ", mmeName=" + mmeName.getValue() + ", mmeIpAddFirst=" + mmeIpAddFirst.getValue() + ", mmeIpAddSecond=" + mmeIpAddSecond.getValue() + ", ipv4AddClockServer=" + ipv4AddClockServer.getValue() + ", nexthopAddClockServer=" + nexthopAddClockServer.getValue() + ", vlanAddClockServer=" + vlanAddClockServer.getValue() + '}';
    }
    
    
    
    
}
