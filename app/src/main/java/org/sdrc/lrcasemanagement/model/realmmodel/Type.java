package org.sdrc.lrcasemanagement.model.realmmodel;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Ratikanta Pradhan (ratikanta@sdrc.co.in) on 01-02-2017.
 */

public class Type extends RealmObject{

    @PrimaryKey
    private int id;
    private String name;
    private RealmList<TypeDetails> typeDetails;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RealmList<TypeDetails> getTypeDetails() {
        return typeDetails;
    }

    public void setTypeDetails(RealmList<TypeDetails> typeDetails) {
        this.typeDetails = typeDetails;
    }
}
