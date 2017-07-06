package org.sdrc.lrcasemanagement.model;

import java.io.Serializable;

/**
 * Created by SDRC_DEV on 2/8/2017.
 */
public class ChildModel implements Serializable{

    private Long id;
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
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Boolean getIsStillBirth() {
        return isStillBirth;
    }
    public void setIsStillBirth(Boolean isStillBirth) {
        this.isStillBirth = isStillBirth;
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
    public Boolean getIsChildBreastFedInHour() {
        return isChildBreastFedInHour;
    }
    public void setIsChildBreastFedInHour(Boolean isChildBreastFedInHour) {
        this.isChildBreastFedInHour = isChildBreastFedInHour;
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
    public Boolean getIsBCGGiven() {
        return isBCGGiven;
    }
    public void setIsBCGGiven(Boolean isBCGGiven) {
        this.isBCGGiven = isBCGGiven;
    }
    public Boolean getIsZeroOPVGiven() {
        return isZeroOPVGiven;
    }
    public void setIsZeroOPVGiven(Boolean isZeroOPVGiven) {
        this.isZeroOPVGiven = isZeroOPVGiven;
    }
    public Boolean getIsHepBZeroGiven() {
        return isHepBZeroGiven;
    }
    public void setIsHepBZeroGiven(Boolean isHepBZeroGiven) {
        this.isHepBZeroGiven = isHepBZeroGiven;
    }
    public Boolean getIsVitaminKGiven() {
        return isVitaminKGiven;
    }
    public void setIsVitaminKGiven(Boolean isVitaminKGiven) {
        this.isVitaminKGiven = isVitaminKGiven;
    }
}
