package org.sdrc.lrcasemanagement.model.realmmodel;

import java.sql.Timestamp;
import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Ratikanta Pradhan (ratikanta@sdrc.co.in) on 26-01-2017.
 */

public class Data extends RealmObject{

    @PrimaryKey
    private int id;
    private Patient patient;
    private Area area;
    private boolean patientHadPreDeliveryInjection;
    private boolean patientHadPostDeliveryInjection;
    private double weightOfChildInKG;
    private Date mrdDateAndTime;
    private Date dischargeDateAndTime;
    private Date refferedDateAndTime;
    private Area refferedArea;
    private Date syncDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public boolean isPatientHadPreDeliveryInjection() {
        return patientHadPreDeliveryInjection;
    }

    public void setPatientHadPreDeliveryInjection(boolean patientHadPreDeliveryInjection) {
        this.patientHadPreDeliveryInjection = patientHadPreDeliveryInjection;
    }

    public boolean isPatientHadPostDeliveryInjection() {
        return patientHadPostDeliveryInjection;
    }

    public void setPatientHadPostDeliveryInjection(boolean patientHadPostDeliveryInjection) {
        this.patientHadPostDeliveryInjection = patientHadPostDeliveryInjection;
    }

    public double getWeightOfChildInKG() {
        return weightOfChildInKG;
    }

    public void setWeightOfChildInKG(double weightOfChildInKG) {
        this.weightOfChildInKG = weightOfChildInKG;
    }

    public Date getMrdDateAndTime() {
        return mrdDateAndTime;
    }

    public void setMrdDateAndTime(Date mrdDateAndTime) {
        this.mrdDateAndTime = mrdDateAndTime;
    }

    public Date getDischargeDateAndTime() {
        return dischargeDateAndTime;
    }

    public void setDischargeDateAndTime(Date dischargeDateAndTime) {
        this.dischargeDateAndTime = dischargeDateAndTime;
    }

    public Date getRefferedDateAndTime() {
        return refferedDateAndTime;
    }

    public void setRefferedDateAndTime(Date refferedDateAndTime) {
        this.refferedDateAndTime = refferedDateAndTime;
    }

    public Area getRefferedArea() {
        return refferedArea;
    }

    public void setRefferedArea(Area refferedArea) {
        this.refferedArea = refferedArea;
    }

    public Date getSyncDate() {
        return syncDate;
    }

    public void setSyncDate(Date syncDate) {
        this.syncDate = syncDate;
    }
}
