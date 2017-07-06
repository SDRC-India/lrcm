package org.sdrc.lrcasemanagement.service;

import org.sdrc.lrcasemanagement.model.webservice.MasterDataModel;
import org.sdrc.lrcasemanagement.model.webservice.MobileUserModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Ratikanta Pradhan (ratikanta@sdrc.co.in) on 29-01-2017.
 */

public interface LoginService {

    @POST("login")
    Call<MasterDataModel> MasterDataModel(@Body MobileUserModel mobileUserModel);
}
