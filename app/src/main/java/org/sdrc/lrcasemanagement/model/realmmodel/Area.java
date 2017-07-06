package org.sdrc.lrcasemanagement.model.realmmodel;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Ratikanta Pradhan (ratikanta@sdrc.co.in) on 26-01-2017.
 */

public class Area extends RealmObject{

    @PrimaryKey
    private int nid;
    private String id;
    private String name;
    private int parentAreaId;
    private int level;

    public int getNid() {
        return nid;
    }

    public void setNid(int nid) {
        this.nid = nid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getParentAreaId() {
        return parentAreaId;
    }

    public void setParentAreaId(int parentAreaId) {
        this.parentAreaId = parentAreaId;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
