package org.sdrc.lrcasemanagement.service;

import org.sdrc.lrcasemanagement.model.webservice.PostSyncModel;
import org.sdrc.lrcasemanagement.model.webservice.SyncModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Ratikanta Pradhan (ratikanta@sdrc.co.in) on 29-01-2017.
 */

public interface SyncService {

    @POST("sync")
    Call<PostSyncModel> PostSyncModel(@Body SyncModel syncModel);
}
