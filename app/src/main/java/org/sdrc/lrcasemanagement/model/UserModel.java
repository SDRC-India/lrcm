package org.sdrc.lrcasemanagement.model;

/**
 * Created by Ratikanta Pradhan (ratikanta@sdrc.co.in) on 03-02-2017.
 */

public class UserModel {
    private Integer id;
    private String name;
    private String areaName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }
}
