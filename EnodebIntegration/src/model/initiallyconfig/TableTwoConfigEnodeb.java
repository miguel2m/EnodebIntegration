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

    public TableTwoConfigEnodeb(SimpleStringProperty m200IpAdd, SimpleStringProperty sgwNameId, SimpleStringProperty sgwIpAddOne, SimpleStringProperty sgwIpAddTwo, SimpleStringProperty sgwIpAddThree, SimpleStringProperty sgwIpAddFour, SimpleStringProperty mmeName, SimpleStringProperty mmeIpAddFirst, SimpleStringProperty mmeIpAddSecond, SimpleStringProperty ipv4AddClockServer, SimpleStringProperty nexthopAddClockServer, SimpleStringProperty vlanAddClockServer) {
        this.m200IpAdd = m200IpAdd;
        this.sgwNameId = sgwNameId;
        this.sgwIpAddOne = sgwIpAddOne;
        this.sgwIpAddTwo = sgwIpAddTwo;
        this.sgwIpAddThree = sgwIpAddThree;
        this.sgwIpAddFour = sgwIpAddFour;
        this.mmeName = mmeName;
        this.mmeIpAddFirst = mmeIpAddFirst;
        this.mmeIpAddSecond = mmeIpAddSecond;
        this.ipv4AddClockServer = ipv4AddClockServer;
        this.nexthopAddClockServer = nexthopAddClockServer;
        this.vlanAddClockServer = vlanAddClockServer;
    }

    public SimpleStringProperty getM200IpAdd() {
        return m200IpAdd;
    }

    public void setM200IpAdd(SimpleStringProperty m200IpAdd) {
        this.m200IpAdd = m200IpAdd;
    }

    public SimpleStringProperty getSgwNameId() {
        return sgwNameId;
    }

    public void setSgwNameId(SimpleStringProperty sgwNameId) {
        this.sgwNameId = sgwNameId;
    }

    public SimpleStringProperty getSgwIpAddOne() {
        return sgwIpAddOne;
    }

    public void setSgwIpAddOne(SimpleStringProperty sgwIpAddOne) {
        this.sgwIpAddOne = sgwIpAddOne;
    }

    public SimpleStringProperty getSgwIpAddTwo() {
        return sgwIpAddTwo;
    }

    public void setSgwIpAddTwo(SimpleStringProperty sgwIpAddTwo) {
        this.sgwIpAddTwo = sgwIpAddTwo;
    }

    public SimpleStringProperty getSgwIpAddThree() {
        return sgwIpAddThree;
    }

    public void setSgwIpAddThree(SimpleStringProperty sgwIpAddThree) {
        this.sgwIpAddThree = sgwIpAddThree;
    }

    public SimpleStringProperty getSgwIpAddFour() {
        return sgwIpAddFour;
    }

    public void setSgwIpAddFour(SimpleStringProperty sgwIpAddFour) {
        this.sgwIpAddFour = sgwIpAddFour;
    }

    public SimpleStringProperty getMmeName() {
        return mmeName;
    }

    public void setMmeName(SimpleStringProperty mmeName) {
        this.mmeName = mmeName;
    }

    public SimpleStringProperty getMmeIpAddFirst() {
        return mmeIpAddFirst;
    }

    public void setMmeIpAddFirst(SimpleStringProperty mmeIpAddFirst) {
        this.mmeIpAddFirst = mmeIpAddFirst;
    }

    public SimpleStringProperty getMmeIpAddSecond() {
        return mmeIpAddSecond;
    }

    public void setMmeIpAddSecond(SimpleStringProperty mmeIpAddSecond) {
        this.mmeIpAddSecond = mmeIpAddSecond;
    }

    public SimpleStringProperty getIpv4AddClockServer() {
        return ipv4AddClockServer;
    }

    public void setIpv4AddClockServer(SimpleStringProperty ipv4AddClockServer) {
        this.ipv4AddClockServer = ipv4AddClockServer;
    }

    public SimpleStringProperty getNexthopAddClockServer() {
        return nexthopAddClockServer;
    }

    public void setNexthopAddClockServer(SimpleStringProperty nexthopAddClockServer) {
        this.nexthopAddClockServer = nexthopAddClockServer;
    }

    public SimpleStringProperty getVlanAddClockServer() {
        return vlanAddClockServer;
    }

    public void setVlanAddClockServer(SimpleStringProperty vlanAddClockServer) {
        this.vlanAddClockServer = vlanAddClockServer;
    }

    

    
    
    @Override
    public String toString() {
        return "TableTwoConfigEnodeb{" + "m200IpAdd=" + m200IpAdd.getValue() + ", sgwNameId=" + sgwNameId.getValue() + ", sgwIpAddOne=" + sgwIpAddOne.getValue() + ", sgwIpAddTwo=" + sgwIpAddTwo.getValue() + ", sgwIpAddThree=" + sgwIpAddThree.getValue() + ", sgwIpAddFour=" + sgwIpAddFour.getValue() + ", mmeName=" + mmeName.getValue() + ", mmeIpAddFirst=" + mmeIpAddFirst.getValue() + ", mmeIpAddSecond=" + mmeIpAddSecond.getValue() + ", ipv4AddClockServer=" + ipv4AddClockServer.getValue() + ", nexthopAddClockServer=" + nexthopAddClockServer.getValue() + ", vlanAddClockServer=" + vlanAddClockServer.getValue() + '}';
    }
    
    
    
    
}
