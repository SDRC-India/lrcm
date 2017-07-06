package org.sdrc.lrcasemanagement.asynctask;

import android.os.AsyncTask;
import android.util.Log;

import org.sdrc.lrcasemanagement.R;
import org.sdrc.lrcasemanagement.listener.LoginListener;
import org.sdrc.lrcasemanagement.model.LoginDataModel;
import org.sdrc.lrcasemanagement.model.realmmodel.Area;
import org.sdrc.lrcasemanagement.model.realmmodel.Child;
import org.sdrc.lrcasemanagement.model.realmmodel.ChildStatus;
import org.sdrc.lrcasemanagement.model.realmmodel.Data;
import org.sdrc.lrcasemanagement.model.realmmodel.LatestSerialNoOfMonths;
import org.sdrc.lrcasemanagement.model.realmmodel.Patient;
import org.sdrc.lrcasemanagement.model.realmmodel.SysConfig;
import org.sdrc.lrcasemanagement.model.realmmodel.Type;
import org.sdrc.lrcasemanagement.model.realmmodel.TypeDetails;
import org.sdrc.lrcasemanagement.model.realmmodel.User;
import org.sdrc.lrcasemanagement.model.webservice.AreaModel;
import org.sdrc.lrcasemanagement.model.webservice.ChildModel;
import org.sdrc.lrcasemanagement.model.webservice.ChildStatusModel;
import org.sdrc.lrcasemanagement.model.webservice.LatestSerialNoOfMonthsModel;
import org.sdrc.lrcasemanagement.model.webservice.MasterDataModel;
import org.sdrc.lrcasemanagement.model.webservice.MobileUserModel;
import org.sdrc.lrcasemanagement.model.webservice.PatientModel;
import org.sdrc.lrcasemanagement.model.webservice.TypeDetailsModel;
import org.sdrc.lrcasemanagement.model.webservice.TypeModel;
import org.sdrc.lrcasemanagement.model.webservice.UserModel;
import org.sdrc.lrcasemanagement.service.LoginService;
import org.sdrc.lrcasemanagement.util.Constant;
import org.sdrc.lrcasemanagement.util.LRCM;

import java.lang.annotation.Annotation;
import java.net.SocketTimeoutException;
import java.util.Calendar;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.realm.Realm;
import io.realm.RealmList;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ratikanta Pradhan (ratikanta@sdrc.co.in) on 26-01-2017.
 */

public class LoginAsyncTask extends AsyncTask {

    private static final String TAG = LoginAsyncTask.class.getName();
    private LoginListener loginListener;

    public void setLoginListener(LoginListener loginListener) {
        this.loginListener = loginListener;
    }
    private MasterDataModel masterDataModel;

    @Override
    protected Object doInBackground(Object[] objects) {
        try {
            LoginDataModel loginDataModel = new LoginDataModel();
            String username = (String) objects[0];
            String password = (String) objects[1];
            if(!Constant.CLEAR_DATA_TAPPED) {
                if (username != null && !(username.equals("")) && password != null && !(password.equals(""))) {

                    Realm realm = LRCM.getInstance().getRealm();
                    User user = realm.where(User.class).findFirst();
                    if (user != null) {
                        if (user.getUsername().equals(username) && user.getPassword().equals(password)) {

                            //login success
                            loginDataModel.setResult(Constant.Result.SUCCESS);
                            return loginDataModel;
                        } else {
                            //invalid login
                            loginDataModel.setResult(Constant.Result.INVALID_CREDENTIALS);
                            return loginDataModel;
                        }
                    } else {
                        //There is no user in database, we have to hit the server
                        //checking internet connection
                        if ((Boolean) objects[4]) {
                            if ((String) objects[5] != null) {

                                String url = (String) objects[2];
                                int sync_timeout_in_second = (Integer) objects[3];
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

                                LoginService service = retrofit.create(LoginService.class);
                                MobileUserModel mobileUserModel = new MobileUserModel();
                                mobileUserModel.setUsername(username);
                                mobileUserModel.setPassword(password);
                                mobileUserModel.setImei((String) objects[5]);
                                Call<MasterDataModel> call = service.MasterDataModel(mobileUserModel);

                                call.enqueue(new Callback<MasterDataModel>() {
                                    @Override
                                    public void onResponse(Call<MasterDataModel> call, retrofit2.Response<MasterDataModel> response) {
                                        //handling the responce
                                        if (response.code() == 200) {
                                            masterDataModel = response.body();
                                            if (masterDataModel != null && masterDataModel.getErrorMessage() != null) {
                                                LoginDataModel loginDataModelErr = new LoginDataModel();
                                                loginDataModelErr.setResult(Constant.Result.ERROR);
                                                loginDataModelErr.setMessage(masterDataModel.getErrorMessage());
                                                onPostExecute(loginDataModelErr);
                                            } else {
                                                insertData();
                                            }
                                        } else {
                                            LoginDataModel loginDataModelErr = new LoginDataModel();
                                            switch (response.code()) {
                                                case 401:
                                                    loginDataModelErr.setResult(Constant.Result.ERROR);
                                                    loginDataModelErr.setMessage(LRCM.getInstance()
                                                            .getApplicationContext().getString(R.string.invalid_credentials));
                                                    break;
                                                case 404:
                                                    loginDataModelErr.setResult(Constant.Result.ERROR);
                                                    loginDataModelErr.setMessage(LRCM.getInstance()
                                                            .getApplicationContext().getString(R.string.server_not_found));
                                                    break;
                                                case 500:
                                                    loginDataModelErr.setMessage(LRCM.getInstance()
                                                            .getApplicationContext().getString(R.string.server_error));
                                                    loginDataModelErr.setResult(Constant.Result.SERVER_ERROR);
                                                    break;
                                                default:
                                                    loginDataModelErr.setResult(Constant.Result.ERROR);
                                                    loginDataModelErr.setMessage(response.code() + ": " + response.message());
                                                    break;
                                            }
                                            onPostExecute(loginDataModelErr);
                                        }
                                    }

                                    @Override
                                    public void onFailure(Call<MasterDataModel> call, Throwable t) {
                                        //handling the error
                                        LoginDataModel loginDataModelErr = new LoginDataModel();
                                        loginDataModelErr.setResult(Constant.Result.SERVER_ERROR);

                                        if (t instanceof SocketTimeoutException) {
                                            loginDataModelErr.setMessage("Request timeout");
                                        } else {
                                            loginDataModelErr.setMessage(t.getMessage());
                                        }
                                        onPostExecute(loginDataModelErr);
                                    }


                                });
                            } else {
                                loginDataModel.setResult(Constant.Result.NO_IMEI);
                            }
                        } else {
                            loginDataModel.setResult(Constant.Result.NO_INTERNET);
                            return loginDataModel;
                        }
                    }
                    LRCM.getInstance().closeRealm();
                } else {
                    loginDataModel.setResult(Constant.Result.ERROR);
                    loginDataModel.setMessage(LRCM.getInstance().getApplicationContext().getString(R.string.all_fields_mandatory));
                }
            }else{
                loginDataModel.setResult(Constant.Result.ERROR);
                loginDataModel.setMessage("Please restart the app to clear cached data of last logged in user.");
            }
            return loginDataModel;

        }catch (Exception e){
            LoginDataModel loginDataModel = new LoginDataModel();
            loginDataModel.setResult(Constant.Result.ERROR);
            loginDataModel.setMessage(e.getMessage());
            return loginDataModel;
        }
    }

    private void insertData() {
        try {
            //getting the realm object which we set from the activity
            Realm realm = LRCM.getInstance().getRealm();
            realm.executeTransactionAsync(new Realm.Transaction() {
                @Override
                public void execute(Realm bgRealm) {

                    Area area = null;
                    if (masterDataModel != null) {
                        //Inserting into area table
                        if (masterDataModel.getAreaModels() != null) {
                            for (AreaModel model : masterDataModel.getAreaModels()) {
                                Area object = bgRealm.createObject(Area.class, model.getAreaNId());
                                object.setId(model.getAreaId());
                                object.setName(model.getAreaName());
                                object.setParentAreaId(model.getParentAreaId());
                                object.setLevel(model.getAreaLevel());

                                if (masterDataModel.getUserModel().getAreaNId() == object.getNid()) {
                                    area = object;
                                }
                            }
                        }


                        //Inserting data into user table
                        if (masterDataModel.getUserModel() != null) {
                            UserModel model = masterDataModel.getUserModel();
                            User object = new User();
                            object.setId(model.getUserId());
                            object.setName(model.getName());
                            object.setUsername(model.getUsername());
                            object.setPassword(model.getPassword());
                            object.setArea(area);
                            bgRealm.copyToRealm(object);

                        }

                        //Inserting data in type and type details table
                        if (masterDataModel.getTypeModels() != null) {

                            for(TypeModel model : masterDataModel.getTypeModels()){

                                RealmList<TypeDetails> typeDetails = new RealmList<TypeDetails>();
                                for(TypeDetailsModel iModel : model.getTypeDetailsModels()){

                                    TypeDetails iObject = bgRealm.createObject(TypeDetails.class, iModel.getId());
                                    iObject.setName(iModel.getName());
                                    typeDetails.add(iObject);

                                }


                                Type object = bgRealm.createObject(Type.class, model.getId());
                                object.setName(model.getName());
                                object.setTypeDetails(typeDetails);
                            }

                        }

                        //Inserting data in LatestSerialNoOfMonths table
                        if (masterDataModel.getLatestSerialNoOfMonthsModel() != null) {

                            if(masterDataModel.getLatestSerialNoOfMonthsModel().getSerialNoMap() != null){
                                for (Map.Entry<String, Integer> entry : masterDataModel.getLatestSerialNoOfMonthsModel().getSerialNoMap().entrySet()){

                                    LatestSerialNoOfMonths latestSerialNoOfMonths = bgRealm.createObject(LatestSerialNoOfMonths.class);
                                    latestSerialNoOfMonths.setSerialNo(entry.getValue());
                                    latestSerialNoOfMonths.setRecordDate(LRCM.getInstance().getAndroidDateStringFromDate(entry.getKey()));
                                }
                            }
                        }

                        //Inserting data in patient table
                        if (masterDataModel.getPatientModels() != null) {

                            for(PatientModel model : masterDataModel.getPatientModels()){
                                RealmList<Child> children = new RealmList<>();
                                for(ChildModel iModel : model.getChildModels()){
                                    Child iObject = bgRealm.createObject(Child.class);
                                    iObject.setPatientId(model.getPatientId());
                                    iObject.setStillBirth(iModel.getIsStillBirth());
                                    iObject.setChildSex(iModel.getChildSex());
                                    iObject.setChildWeight(iModel.getChildWeight());
                                    iObject.setStillBirthType(iModel.getStillBirthType());
                                    iObject.setChildBreastFedInHour(iModel.getIsChildBreastFedInHour());
                                    iObject.setHasNeededRescusition(iModel.getHasNeededRescusition());
                                    iObject.setHasCongenitalAnomalies(iModel.getHasCongenitalAnomalies());
                                    iObject.setBCGGiven(iModel.getIsBCGGiven());
                                    iObject.setZeroOPVGiven(iModel.getIsZeroOPVGiven());
                                    iObject.setHepBZeroGiven(iModel.getIsHepBZeroGiven());
                                    iObject.setVitaminKGiven(iModel.getIsVitaminKGiven());
                                    children.add(iObject);
                                }

                                RealmList<ChildStatus> childStatuses = new RealmList<>();
                                for(ChildStatusModel iModel : model.getChildStatusModel()){
                                    ChildStatus iObject = bgRealm.createObject(ChildStatus.class);
                                    iObject.setPatientId(model.getPatientId());
                                    iObject.setStatus(iModel.getStatus());
                                    iObject.setDischargeDateAndTime(LRCM.getInstance().getAndroidDateStringFromDate(iModel.getDischargeDateAndTime()));
                                    iObject.setDischargeWeight(iModel.getDischargeWeight());
                                    iObject.setTransportToHome(iModel.getTransportToHome());
                                    iObject.setReferredDateAndTime(LRCM.getInstance().getAndroidDateStringFromDate(iModel.getReferredDateAndTime()));
                                    iObject.setReferredBy(iModel.getReferredBy());
                                    iObject.setReferredCause(iModel.getReferredCause());
                                    iObject.setOtherReferredCause(iModel.getOtherReferredCause());
                                    iObject.setReferredTo(iModel.getReferredAreaId());
                                    iObject.setOtherReferredTo(iModel.getOtherReferredAreaId());
                                    iObject.setReferredTransport(iModel.getReferredTransport());
                                    iObject.setLamaDateAndTime(LRCM.getInstance().getAndroidDateStringFromDate(iModel.getLamaDateAndTime()));
                                    iObject.setDeathDateAndTime(LRCM.getInstance().getAndroidDateStringFromDate(iModel.getDeathDateAndTime()));
                                    iObject.setDeathCause(iModel.getDeathCause());
                                    childStatuses.add(iObject);
                                }


                                Patient object = bgRealm.createObject(Patient.class, model.getPatientId());
                                object.setSerialNo(model.getSerialNo());
                                object.setAdmissionDateAndTime(LRCM.getInstance().getAndroidDateStringFromDate(model.getAdmissionDateAndTime()));
                                object.setTypeOfPatient(model.getTypeOfPatient());
                                object.setTypeOfFromReferredFacility(model.getTypeOfFromReferredFacility());
                                object.setNameOfFromReferredFacility(model.getNameOfFromReferredFacility());
                                object.setPatientName(model.getPatientName());
                                object.setPatientHusbandName(model.getPatientHusbandName());
                                object.setStateAreaId(model.getStateAreaId());
                                object.setDetailAddressIfOtherState(model.getDetailAddressIfOtherState());
                                object.setDistrictAreaId(model.getDistrictAreaId());
                                object.setBlockAreaId(model.getBlockAreaId());
                                object.setVillage(model.getVillage());
                                object.setMobileNo(model.getMobileNo());
                                object.setAge(model.getAge());
                                object.setCaste(model.getCaste());
                                object.setAplOrBpl(model.getAplOrBpl());
                                object.setNoOfNormalDeliveries(model.getNoOfNormalDeliveries());
                                object.setNoOfAssistedDeliveries(model.getNoOfAssistedDeliveries());
                                object.setNoOfCSectionDeliveries(model.getNoOfCSectionDeliveries());
                                object.setNoOfLiveChild(model.getNoOfLiveChild());
                                object.setNoOfStillBirth(model.getNoOfStillBirth());
                                object.setNoOfAbortion(model.getNoOfAbortion());
                                object.setNoOfAntenatalCheckUps(model.getNoOfAntenatalCheckUps());
                                object.setAntenatalCheckUpDoneBy(model.getAntenatalCheckUpDoneBy());
                                object.setBpSystolic(model.getBpSystolic());
                                object.setBpDiastolic(model.getBpDiastolic());
                                object.setPulseRatePerMinute(model.getPulseRatePerMinute());
                                object.setRespiratoryRatePerMinute(model.getRespiratoryRatePerMinute());
                                object.setHeartRate(model.getHeartRate());
                                object.setCervicalDilatationInCm(model.getCervicalDilatationInCm());
                                object.setPatrographStarted(model.getIsPatrographStarted());
                                object.setUrineAlbumine(model.getUrineAlbumine());
                                object.setUrineSugar(model.getUrineSugar());
                                object.setBloodSugarTestDone(model.getIsBloodSugarTestDone());
                                object.setBloodSugarFasting(model.getBloodSugarFasting());
                                object.setBloodSugarPostmeal(model.getBloodSugarPostmeal());
                                object.setBloodSugarRandom(model.getBloodSugarRandom());
                                object.setVdrlRPR(model.getVdrlRPR());
                                object.setSickling(model.getSickling());
                                object.setHivTest(model.getHivTest());
                                object.setBloodGroup(model.getBloodGroup());
                                object.setRhType(model.getRhType());
                                object.setVehicleToFacility(model.getVehicleToFacility());
                                object.setDeliveryDateAndTime(LRCM.getInstance().getAndroidDateStringFromDate(model.getDeliveryDateAndTime()));
                                object.setDeliveryBy(model.getDeliveryBy());
                                object.setDeliveryTerm(model.getDeliveryTerm());
                                object.setDexamethasoneGiven(model.getIsDexamethasoneGiven());
                                object.setDeliveryType(model.getDeliveryType());
                                object.setDrugGivenInThirdStageOfLabor(model.getDrugGivenInThirdStageOfLabor());
                                object.setWasCordClampingDelayed(model.getWasCordClampingDelayed());
                                object.setHasGestationalDM(model.getHasGestationalDM());
                                object.setInsulinGiven(model.getIsInsulinGiven());
                                object.setHasHypothyroidism(model.getHasHypothyroidism());
                                object.setLeavothyroxineGiven(model.getIsLeavothyroxineGiven());
                                object.setHasEclampsia(model.getHasEclampsia());
                                object.setTreatedWithMagsulf(model.getIsTreatedWithMagsulf());
                                object.setChildren(children);
                                object.setBloodTransfusionGiven(model.getIsBloodTransfusionGiven());
                                object.setNoOfPints(model.getNoOfPints());
                                object.setPpiucdInserted(model.getIsPpiucdInserted());
                                object.setIFAGivenInPNC(model.getIsIFAGivenInPNC());
                                object.setCalciumVitaminD3InPNC(model.getIsCalciumVitaminD3InPNC());
                                object.setTypeOfJSY(model.getTypeOfJSY());
                                object.setMotherStatus(model.getMotherStatus());
                                object.setDischargeDateAndTime(LRCM.getInstance().getAndroidDateStringFromDate(model.getDischargeDateAndTime()));
                                object.setTransportToHome(model.getTransportToHome());
                                object.setReferredDateAndTime(LRCM.getInstance().getAndroidDateStringFromDate(model.getReferredDateAndTime()));
                                object.setReferredBy(model.getReferredBy());
                                object.setReferredCause(model.getReferredCause());
                                object.setOtherReferredCause(model.getOtherReferredCause());
                                object.setReferredAreaId(model.getReferredAreaId());
                                object.setOtherReferredAreaId(model.getOtherReferredAreaId());
                                object.setReferredTransport(model.getReferredTransport());
                                object.setLamaDateAndTime(LRCM.getInstance().getAndroidDateStringFromDate(model.getLamaDateAndTime()));
                                object.setPatientDeathDateAndTime(LRCM.getInstance().getAndroidDateStringFromDate(model.getPatientDeathDateAndTime()));
                                object.setPatientDeathCause(model.getPatientDeathCause());
                                object.setOtherPatientDeathCause(model.getOtherPatientDeathCause());
                                object.setChildStatus(childStatuses);

                            }

                        }




                        //setting latest patient number
                        SysConfig sysConfig = bgRealm.where(SysConfig.class).equalTo("id", 1).findFirst();
                        if (sysConfig == null) {
                            SysConfig sysConfigNewRecord = bgRealm.createObject(SysConfig.class, 1);
                            sysConfigNewRecord.setPatientId(masterDataModel.getLatestPatientNumber()==0?1:masterDataModel.getLatestPatientNumber());

                        }
                    }

                }
            }, new Realm.Transaction.OnSuccess() {
                @Override
                public void onSuccess() {
                    LoginDataModel loginDataModel = new LoginDataModel();
                    loginDataModel.setResult(Constant.Result.SUCCESS);
                    LRCM.getInstance().closeRealm();
                    onPostExecute(loginDataModel);
                }
            }, new Realm.Transaction.OnError() {
                @Override
                public void onError(Throwable error) {
                    Log.e(TAG, error.getMessage());
                    LoginDataModel loginDataModel = new LoginDataModel();
                    loginDataModel.setResult(Constant.Result.ERROR);
                    loginDataModel.setMessage("Exception in inserting data in database " + error.getMessage());
                    LRCM.getInstance().closeRealm();
                    onPostExecute(loginDataModel);
                }
            });
        }catch (Exception e){
            LoginDataModel loginDataModel = new LoginDataModel();
            loginDataModel.setResult(Constant.Result.ERROR);
            loginDataModel.setMessage("Excletion in inserting data in database " + e.getMessage());
            onPostExecute(loginDataModel);
            LRCM.getInstance().closeRealm();
        }
    }



    @Override
    protected void onPostExecute(Object o) {
        if(this.loginListener != null){
            loginListener.loginComplete((LoginDataModel) o);
        }
        super.onPostExecute(o);
    }
}
