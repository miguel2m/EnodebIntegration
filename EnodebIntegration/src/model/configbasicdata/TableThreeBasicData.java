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
public class TableThreeBasicData {
    private SimpleStringProperty parameterId;
    private SimpleStringProperty locationName;
    private SimpleStringProperty gcdf;
    private SimpleStringProperty latitudeDegFormat;
    private SimpleStringProperty longitudeDegFormat;
    private SimpleStringProperty latitudeSecFormat;
    private SimpleStringProperty longitudeSecFormat;
    private SimpleStringProperty locationId;
    private SimpleStringProperty altitude;
    private SimpleStringProperty range;
    private SimpleStringProperty city;
    private SimpleStringProperty region;
    private SimpleStringProperty address;
    private SimpleStringProperty office;
    private SimpleStringProperty contact;
    private SimpleStringProperty telephone;
    private SimpleStringProperty userLabel;
    private SimpleStringProperty precise;

    public TableThreeBasicData(String parameterId, 
            String locationName,
            String gcdf,
            String latitudeDegFormat,
            String longitudeDegFormat,
            String latitudeSecFormat,
            String longitudeSecFormat,
            String locationId,
            String altitude,
            String range,
            String city,
            String region,
            String address,
            String office,
            String contact,
            String telephone,
            String userLabel,
            String precise) {
        this.parameterId = new SimpleStringProperty(parameterId);
        this.locationName = new SimpleStringProperty(locationName);
        this.gcdf = new SimpleStringProperty(gcdf);
        this.latitudeDegFormat = new SimpleStringProperty(latitudeDegFormat);
        this.longitudeDegFormat = new SimpleStringProperty(longitudeDegFormat);
        this.latitudeSecFormat = new SimpleStringProperty(latitudeSecFormat);
        this.longitudeSecFormat = new SimpleStringProperty(longitudeSecFormat);
        this.locationId = new SimpleStringProperty(locationId);
        this.altitude = new SimpleStringProperty(altitude);
        this.range = new SimpleStringProperty(range);
        this.city = new SimpleStringProperty(city);
        this.region = new SimpleStringProperty(region);
        this.address = new SimpleStringProperty(address);
        this.office = new SimpleStringProperty(office);
        this.contact = new SimpleStringProperty(contact);
        this.telephone = new SimpleStringProperty(telephone);
        this.userLabel = new SimpleStringProperty(userLabel);
        this.precise = new SimpleStringProperty(precise);
    }

    public String getParameterId() {
        return parameterId.get();
    }

    public void setParameterId(String parameterId) {
        this.parameterId.set(parameterId);
    }

    public String getLocationName() {
        return locationName.get();
    }

    public void setLocationName(String locationName) {
        this.locationName.set(locationName);
    }

    public String getGcdf() {
        return gcdf.get();
    }

    public void setGcdf(String gcdf) {
        this.gcdf.set(gcdf);
    }

    public String getLatitudeDegFormat() {
        return latitudeDegFormat.get();
    }

    public void setLatitudeDegFormat(String latitudeDegFormat) {
        this.latitudeDegFormat.set(latitudeDegFormat);
    }

    public String getLongitudeDegFormat() {
        return longitudeDegFormat.get();
    }

    public void setLongitudeDegFormat(String longitudeDegFormat) {
        this.longitudeDegFormat.set(longitudeDegFormat);
    }

    public String getLatitudeSecFormat() {
        return latitudeSecFormat.get();
    }

    public void setLatitudeSecFormat(String latitudeSecFormat) {
        this.latitudeSecFormat.set(latitudeSecFormat);
    }

    public String getLongitudeSecFormat() {
        return longitudeSecFormat.get();
    }

    public void setLongitudeSecFormat(String longitudeSecFormat) {
        this.longitudeSecFormat.set(longitudeSecFormat);
    }

    public String getLocationId() {
        return locationId.get();
    }

    public void setLocationId(String locationId) {
        this.locationId.set(locationId);
    }

    public String getAltitude() {
        return altitude.get();
    }

    public void setAltitude(String altitude) {
        this.altitude.set(altitude);
    }

    public String getRange() {
        return range.get();
    }

    public void setRange(String range) {
        this.range.set(range);
    }

    public String getCity() {
        return city.get();
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public String getRegion() {
        return region.get();
    }

    public void setRegion(String region) {
        this.region.set(region);
    }

    public String getAddress() {
        return address.get();
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public String getOffice() {
        return office.get();
    }

    public void setOffice(String office) {
        this.office.set(office);
    }

    public String getContact() {
        return contact.get();
    }

    public void setContact(String contact) {
        this.contact.set(contact);
    }

    public String getTelephone() {
        return telephone.get();
    }

    public void setTelephone(String telephone) {
        this.telephone.set(telephone);
    }

    public String getUserLabel() {
        return userLabel.get();
    }

    public void setUserLabel(String userLabel) {
        this.userLabel.set(userLabel);
    }

    public String getPrecise() {
        return precise.get();
    }

    public void setPrecise(String precise) {
        this.precise.set(precise);
    }

    @Override
    public String toString() {
        return "TableThreeBasicData{" + "parameterId=" + parameterId.getValue() + ", locationName=" + locationName.getValue() + ", gcdf=" + gcdf.getValue() + ", latitudeDegFormat=" + latitudeDegFormat.getValue() + ", longitudeDegFormat=" + longitudeDegFormat.getValue() + ", latitudeSecFormat=" + latitudeSecFormat.getValue() + ", longitudeSecFormat=" + longitudeSecFormat.getValue() + ", locationId=" + locationId.getValue() + ", altitude=" + altitude.getValue() + ", range=" + range.getValue() + ", city=" + city.getValue() + ", region=" + region.getValue() + ", address=" + address.getValue() + ", office=" + office.getValue() + ", contact=" + contact.getValue() + ", telephone=" + telephone.getValue() + ", userLabel=" + userLabel.getValue() + ", precise=" + precise.getValue() + '}';
    }
    
    
}
