package org.sdrc.lrcasemanagement.asynctask;

import android.os.AsyncTask;
import android.util.Log;

import org.sdrc.lrcasemanagement.R;
import org.sdrc.lrcasemanagement.listener.SyncListener;
import org.sdrc.lrcasemanagement.model.AsyncTaskResultModel;
import org.sdrc.lrcasemanagement.model.LoginDataModel;
import org.sdrc.lrcasemanagement.model.webservice.PatientModel;
import org.sdrc.lrcasemanagement.model.realmmodel.Patient;
import org.sdrc.lrcasemanagement.model.webservice.MasterDataModel;
import org.sdrc.lrcasemanagement.model.webservice.PostSyncModel;
import org.sdrc.lrcasemanagement.model.webservice.SyncModel;
import org.sdrc.lrcasemanagement.service.LoginService;
import org.sdrc.lrcasemanagement.service.SyncService;
import org.sdrc.lrcasemanagement.service.SyncServiceImpl;
import org.sdrc.lrcasemanagement.util.Constant;
import org.sdrc.lrcasemanagement.util.LRCM;

import java.net.SocketTimeoutException;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.realm.Realm;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ratikanta Pradhan (ratikanta@sdrc.co.in) on 29-01-2017.
 */

public class SyncAsyncTask extends AsyncTask {

    private SyncListener syncListener;
    private SyncModel syncModel;

    public void setSyncListener(SyncListener syncListener) {
        this.syncListener = syncListener;
    }

    @Override
    protected Object doInBackground(Object[] objects) {

        AsyncTaskResultModel asyncTaskResultModel = new AsyncTaskResultModel();
        //internet check
        if((Boolean)objects[1]){
            syncModel = (SyncModel) objects[3];
            if(syncModel != null) {
                if(syncModel.getPatientModels() != null && syncModel.getPatientModels().size() > 0) {

                    asyncTaskResultModel.setResult(Constant.Result.SYNC_STARTED);

                    String url = (String) objects[0];
                    int sync_timeout_in_second = (Integer) objects[2];
                    //We are using OkHttpClient for setting the timeout only
                    final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                            .readTimeout(sync_timeout_in_second, TimeUnit.SECONDS)
                            .connectTimeout(sync_timeout_in_second, TimeUnit.SECONDS)
                            .build();

                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl(url)
                            .addConverterFactory(GsonConverterFactory.create())
                            .client(okHttpClient)
                            .build();

                    SyncService service = retrofit.create(SyncService.class);

                    Call<PostSyncModel> call = service.PostSyncModel(syncModel);

                    call.enqueue(new Callback<PostSyncModel>() {
                        @Override
                        public void onResponse(Call<PostSyncModel> call, retrofit2.Response<PostSyncModel> response) {

                            if (response.code() == 200) {
                                PostSyncModel postSyncModel = response.body();
                                if (postSyncModel != null) {
                                    if (postSyncModel.getIsError() != 0) {
                                        AsyncTaskResultModel asyncTaskResultModel1 = new AsyncTaskResultModel();
                                        asyncTaskResultModel1.setResult(Constant.Result.ERROR);
                                        asyncTaskResultModel1.setMessage(postSyncModel.getErrorMessage());
                                        onPostExecute(asyncTaskResultModel1);
                                    } else {
                                        postSyncWork(postSyncModel);
                                    }
                                } else {
                                    AsyncTaskResultModel asyncTaskResultModel1 = new AsyncTaskResultModel();
                                    asyncTaskResultModel1.setResult(Constant.Result.SERVER_ERROR);
                                    asyncTaskResultModel1.setMessage("Server returned null");
                                    onPostExecute(asyncTaskResultModel1);
                                }
                            } else {
                                AsyncTaskResultModel asyncTaskResultModel1 = new AsyncTaskResultModel();
                                switch (response.code()) {
                                    case 401:
                                        asyncTaskResultModel1.setResult(Constant.Result.ERROR);
                                        asyncTaskResultModel1.setMessage(LRCM.getInstance()
                                                .getApplicationContext().getString(R.string.invalid_credentials));
                                        break;
                                    case 404:
                                        asyncTaskResultModel1.setResult(Constant.Result.ERROR);
                                        asyncTaskResultModel1.setMessage(LRCM.getInstance()
                                                .getApplicationContext().getString(R.string.server_not_found));
                                        break;
                                    case 500:
                                        asyncTaskResultModel1.setMessage(LRCM.getInstance()
                                                .getApplicationContext().getString(R.string.server_error));
                                        asyncTaskResultModel1.setResult(Constant.Result.SERVER_ERROR);
                                        break;
                                    default:
                                        asyncTaskResultModel1.setResult(Constant.Result.ERROR);
                                        asyncTaskResultModel1.setMessage(response.code() + ": " + response.message());
                                        break;
                                }
                                onPostExecute(asyncTaskResultModel1);
                            }

                        }

                        @Override
                        public void onFailure(Call<PostSyncModel> call, Throwable t) {
                            AsyncTaskResultModel asyncTaskResultModel = new AsyncTaskResultModel();


                            if (t instanceof SocketTimeoutException) {
                                asyncTaskResultModel.setResult(Constant.Result.REQUEST_TIMEOUT);
                            } else {
                                asyncTaskResultModel.setResult(Constant.Result.SERVER_ERROR);
                                asyncTaskResultModel.setMessage(t.getMessage());
                            }
                            onPostExecute(asyncTaskResultModel);
                        }

                    });
                }else{
                    asyncTaskResultModel.setResult(Constant.Result.NO_DATA_TO_SYNC);
                }
            }else{
                asyncTaskResultModel.setResult(Constant.Result.ERROR);
                asyncTaskResultModel.setMessage("Bad database data");
            }

        }else{
            asyncTaskResultModel.setResult(Constant.Result.NO_INTERNET);
        }
        return asyncTaskResultModel;
    }

    private void postSyncWork(PostSyncModel postSyncModel) {
        Realm realm = null;
        try {
            AsyncTaskResultModel asyncTaskResultModel = new AsyncTaskResultModel();

            if (postSyncModel.getSuccessPatientIdMap() != null && postSyncModel.getSuccessPatientIdMap().size() > 0) {
                if (syncModel != null && syncModel.getPatientModels() != null && syncModel.getPatientModels().size() > 0) {

                    realm = LRCM.getInstance().getRealm();
                    realm.beginTransaction();

                    String message = "";
                    int count = 0;
                    for (PatientModel patientModel : syncModel.getPatientModels()) {
                        count++;
                        Patient patient = realm.where(Patient.class).equalTo("patientId", patientModel.getPatientId()).findFirst();
                        if(patient != null){
                            patient.setSynced(true);
                            if(postSyncModel.getSuccessPatientIdMap().get(patientModel.getPatientId()) == null){
                                //Sync success
                                message += ("Sync sl. no: " + count + ", Name: " + patient.getPatientName() + ", Status: synced\n");
                            }else{
                                message += ("Sync sl. no: " + count + ", Name: " + patient.getPatientName() + ", Error: "
                                        + postSyncModel.getSuccessPatientIdMap().get(patientModel.getPatientId()) + "\n");
                            }

                        }

                    }
                    asyncTaskResultModel.setResult(Constant.Result.SUCCESS);
                    asyncTaskResultModel.setMessage(message);

                    realm.commitTransaction();
                    LRCM.getInstance().closeRealm();
                }
            }else{
                asyncTaskResultModel.setResult(Constant.Result.SUCCESS);
            }
            onPostExecute(asyncTaskResultModel);
        }catch (Exception e){
            if(realm != null){
                realm.commitTransaction();
                realm.close();
            }
            AsyncTaskResultModel asyncTaskResultModel = new AsyncTaskResultModel();
            asyncTaskResultModel.setResult(Constant.Result.ERROR);
            asyncTaskResultModel.setMessage(e.getMessage());
            onPostExecute(asyncTaskResultModel);
        }
    }

    @Override
    protected void onPostExecute(Object o) {
        if(syncListener != null && o != null){
            syncListener.syncComplete((AsyncTaskResultModel)o);
        }
        super.onPostExecute(o);
    }
}
