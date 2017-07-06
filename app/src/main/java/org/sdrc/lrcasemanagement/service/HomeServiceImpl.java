package org.sdrc.lrcasemanagement.service;

import org.sdrc.lrcasemanagement.model.UserModel;
import org.sdrc.lrcasemanagement.model.realmmodel.User;
import org.sdrc.lrcasemanagement.util.LRCM;

import io.realm.Realm;

/**
 * Created by Ratikanta Pradhan (ratikanta@sdrc.co.in) on 03-02-2017.
 */

public class HomeServiceImpl implements HomeService{

    @Override
    public UserModel getUserModel() {
        try {
            Realm realm = LRCM.getInstance().getRealm();
            User user = realm.where(User.class).findFirst();
            UserModel userModel = new UserModel();
            if(user != null){
                userModel.setName(user.getName());
                userModel.setAreaName(user.getArea() != null?user.getArea().getName():"");
                userModel.setId(user.getId());
            }
            LRCM.getInstance().closeRealm();
            return userModel;
        }catch (Exception e){
            return null;
        }
    }
}
