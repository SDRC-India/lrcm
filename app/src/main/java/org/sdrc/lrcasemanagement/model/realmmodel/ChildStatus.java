package org.sdrc.lrcasemanagement.model.realmmodel;

import java.util.Date;

import io.realm.RealmObject;

/**
 * Created by Ratikanta Pradhan (ratikanta@sdrc.co.in) on 18-03-2017.
 */

public class ChildStatus extends RealmObject{

    private Integer status;
    private Date dischargeDateAndTime;
    private Float dischargeWeight;
    private Integer transportToHome;
    private Date referredDateAndTime;
    private String referredBy;
    private Integer referredCause;
    private String otherReferredCause;
    private Integer referredTo;
    private String otherReferredTo;
    private Integer referredTransport;
    private Date lamaDateAndTime;
    private Date deathDateAndTime;
    private String deathCause;
    private String patientId;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getDischargeDateAndTime() {
        return dischargeDateAndTime;
    }

    public void setDischargeDateAndTime(Date dischargeDateAndTime) {
        this.dischargeDateAndTime = dischargeDateAndTime;
    }

    public Float getDischargeWeight() {
        return dischargeWeight;
    }

    public void setDischargeWeight(Float dischargeWeight) {
        this.dischargeWeight = dischargeWeight;
    }

    public Integer getTransportToHome() {
        return transportToHome;
    }

    public void setTransportToHome(Integer transportToHome) {
        this.transportToHome = transportToHome;
    }

    public Date getReferredDateAndTime() {
        return referredDateAndTime;
    }

    public void setReferredDateAndTime(Date referredDateAndTime) {
        this.referredDateAndTime = referredDateAndTime;
    }

    public String getReferredBy() {
        return referredBy;
    }

    public void setReferredBy(String referredBy) {
        this.referredBy = referredBy;
    }

    public Integer getReferredCause() {
        return referredCause;
    }

    public void setReferredCause(Integer referredCause) {
        this.referredCause = referredCause;
    }

    public String getOtherReferredCause() {
        return otherReferredCause;
    }

    public void setOtherReferredCause(String otherReferredCause) {
        this.otherReferredCause = otherReferredCause;
    }

    public Integer getReferredTo() {
        return referredTo;
    }

    public void setReferredTo(Integer referredTo) {
        this.referredTo = referredTo;
    }

    public String getOtherReferredTo() {
        return otherReferredTo;
    }

    public void setOtherReferredTo(String otherReferredTo) {
        this.otherReferredTo = otherReferredTo;
    }

    public Integer getReferredTransport() {
        return referredTransport;
    }

    public void setReferredTransport(Integer referredTransport) {
        this.referredTransport = referredTransport;
    }

    public Date getLamaDateAndTime() {
        return lamaDateAndTime;
    }

    public void setLamaDateAndTime(Date lamaDateAndTime) {
        this.lamaDateAndTime = lamaDateAndTime;
    }

    public Date getDeathDateAndTime() {
        return deathDateAndTime;
    }

    public void setDeathDateAndTime(Date deathDateAndTime) {
        this.deathDateAndTime = deathDateAndTime;
    }

    public String getDeathCause() {
        return deathCause;
    }

    public void setDeathCause(String deathCause) {
        this.deathCause = deathCause;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }
}
