package org.sdrc.lrcasemanagement.model.realmmodel;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Ratikanta Pradhan (ratikanta@sdrc.co.in) on 01-02-2017.
 */

public class Child extends RealmObject{

    private Boolean isStillBirth;
    private Integer childSex;
    private Float childWeight;
    private Integer stillBirthType;
    private Boolean isChildBreastFedInHour;
    private Boolean hasNeededRescusition;
    private Boolean hasCongenitalAnomalies;
    private Boolean isBCGGiven;
    private Boolean isZeroOPVGiven;
    private Boolean isHepBZeroGiven;
    private Boolean isVitaminKGiven;
    private String patientId;

    public Boolean getStillBirth() {
        return isStillBirth;
    }

    public void setStillBirth(Boolean stillBirth) {
        isStillBirth = stillBirth;
    }

    public Integer getChildSex() {
        return childSex;
    }

    public void setChildSex(Integer childSex) {
        this.childSex = childSex;
    }

    public Float getChildWeight() {
        return childWeight;
    }

    public void setChildWeight(Float childWeight) {
        this.childWeight = childWeight;
    }

    public Integer getStillBirthType() {
        return stillBirthType;
    }

    public void setStillBirthType(Integer stillBirthType) {
        this.stillBirthType = stillBirthType;
    }

    public Boolean getChildBreastFedInHour() {
        return isChildBreastFedInHour;
    }

    public void setChildBreastFedInHour(Boolean childBreastFedInHour) {
        isChildBreastFedInHour = childBreastFedInHour;
    }

    public Boolean getHasNeededRescusition() {
        return hasNeededRescusition;
    }

    public void setHasNeededRescusition(Boolean hasNeededRescusition) {
        this.hasNeededRescusition = hasNeededRescusition;
    }

    public Boolean getHasCongenitalAnomalies() {
        return hasCongenitalAnomalies;
    }

    public void setHasCongenitalAnomalies(Boolean hasCongenitalAnomalies) {
        this.hasCongenitalAnomalies = hasCongenitalAnomalies;
    }

    public Boolean getBCGGiven() {
        return isBCGGiven;
    }

    public void setBCGGiven(Boolean BCGGiven) {
        isBCGGiven = BCGGiven;
    }

    public Boolean getZeroOPVGiven() {
        return isZeroOPVGiven;
    }

    public void setZeroOPVGiven(Boolean zeroOPVGiven) {
        isZeroOPVGiven = zeroOPVGiven;
    }

    public Boolean getHepBZeroGiven() {
        return isHepBZeroGiven;
    }

    public void setHepBZeroGiven(Boolean hepBZeroGiven) {
        isHepBZeroGiven = hepBZeroGiven;
    }

    public Boolean getVitaminKGiven() {
        return isVitaminKGiven;
    }

    public void setVitaminKGiven(Boolean vitaminKGiven) {
        isVitaminKGiven = vitaminKGiven;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }
}
