package org.sdrc.lrcasemanagement.model.realmmodel;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Ratikanta Pradhan (ratikanta@sdrc.co.in) on 31-01-2017.
 */

public class SysConfig extends RealmObject{

    @PrimaryKey
    private int id;
    private long patientId;
    private Date lastSyncDate;
    private String seralNoString;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getPatientId() {
        return patientId;
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

    public Date getLastSyncDate() {
        return lastSyncDate;
    }

    public void setLastSyncDate(Date lastSyncDate) {
        this.lastSyncDate = lastSyncDate;
    }

    public String getSeralNoString() {
        return seralNoString;
    }

    public void setSeralNoString(String seralNoString) {
        this.seralNoString = seralNoString;
    }
}
