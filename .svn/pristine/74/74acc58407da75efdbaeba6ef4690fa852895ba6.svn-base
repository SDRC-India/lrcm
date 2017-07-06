package org.sdrc.lrcasemanagement.util;

import android.content.Context;
import android.util.Log;

import org.sdrc.lrcasemanagement.model.realmmodel.SysConfig;
import org.sdrc.lrcasemanagement.model.realmmodel.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.exceptions.RealmMigrationNeededException;

/**
 * Created by Ratikanta Pradhan (ratikanta@sdrc.co.in) on 26-01-2017.
 */

public class LRCM {


    private static final String TAG = LRCM.class.getName();

    private static LRCM lrcm;
    private Context applicationContext;
    private String imei;

    //We will get and set realm object from here
    private Realm realm;

    public Context getApplicationContext() {
        return applicationContext;
    }

    public void setApplicationContext(Context applicationContext) {
        this.applicationContext = applicationContext;
    }
    private LRCM(){

    }

    public static LRCM getInstance(){
        if(lrcm == null){
            lrcm = new LRCM();
        }
        return lrcm;
    }

    /**
     * This method will give the realm object, it is not checking for null
     * @return The realm object
     */
    public Realm getRealm() {
        /*try {
            Realm.init(getApplicationContext());
            realm = Realm.getDefaultInstance();
        }catch(Exception e){
            Log.e(TAG, e.getMessage());
            e.printStackTrace();
        }*/
        Realm.init(getApplicationContext());
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder().build();
        try {
            realm = Realm.getInstance(realmConfiguration);
        } catch (RealmMigrationNeededException e) {
            try {
                Realm.deleteRealm(realmConfiguration);
//Realm file has been deleted.
                realm = Realm.getInstance(realmConfiguration);
            } catch (Exception ex) {
                throw ex;
//No Realm file to remove.
            }
        }
        return realm;
    }

    /**
     * This method will close the realm object
     */
    public void closeRealm(){
        try {
            if (realm != null) {
                realm.close();
            }
        }catch (Exception e){
            Log.e(TAG, e.getMessage());
            e.printStackTrace();
        }
    }

    public String getNewPatientId(){
        try {
            String newPatientId;
            int newPatientNumber = 1;
            String areaId;
            Realm realm = getRealm();

            //getting latest integer
            SysConfig sysConfig = realm.where(SysConfig.class).equalTo("id", 1).findFirst();
            if (sysConfig != null) {
                //got it
                newPatientNumber = (int)sysConfig.getPatientId();
            } else {
                //no sysconfig record set yet

                Calendar calendar = Calendar.getInstance();
                int current_month = calendar.get(Calendar.MONTH);
                int current_year = calendar.get(Calendar.YEAR);
                SysConfig sysConfigNewRecord = realm.createObject(SysConfig.class, 1);
                sysConfigNewRecord.setPatientId(newPatientNumber);
                sysConfigNewRecord.setSeralNoString(current_month + "-" + current_year + "-" + 1);


            }
            //fetching area id
            User user = realm.where(User.class).findFirst();
            if (user != null) {
                areaId = user.getArea().getId();
                if(areaId == null){
                    return null;
                }

            }else{
                return null;
            }

            newPatientId = "P"+ areaId + "-" + newPatientNumber;
            return newPatientId;
        }catch (Exception e){
            closeRealm();
            return null;
        }

    }

    public Integer getLatestSeiralNo(){
        try {
            int latestSerialNo = 1;
            Realm realm = getRealm();
            realm.beginTransaction();
            Calendar calendar = Calendar.getInstance();
            int current_month = calendar.get(Calendar.MONTH);
            int current_year = calendar.get(Calendar.YEAR);
            //getting latest integer
            SysConfig sysConfig = realm.where(SysConfig.class).equalTo("id", 1).findFirst();
            if (sysConfig != null) {
                //got it
                String serialNoString = sysConfig.getSeralNoString();
                if(serialNoString != null){
                    String[] array = serialNoString.split("-");
                    int dbMonth = Integer.parseInt(array[0]);
                    int dbYear = Integer.parseInt(array[1]);
                    if(current_month == dbMonth && current_year == dbYear){
                        latestSerialNo = Integer.parseInt(array[2]) + 1;
                        //updating serial no.
                        sysConfig.setSeralNoString(current_month + "-" + current_year + "-" + latestSerialNo);
                    }
                }else{
                    sysConfig.setSeralNoString(current_month + "-" + current_year + "-" + latestSerialNo);
                }


            } else {
                //no sysconfig record set yet
                SysConfig sysConfigNewRecord = realm.createObject(SysConfig.class, 1);
                sysConfigNewRecord.setPatientId(0);
                sysConfigNewRecord.setSeralNoString(current_month + "-" + current_year + "-" + latestSerialNo);


            }
            realm.commitTransaction();
            closeRealm();
            return latestSerialNo;
        }catch (Exception e){
            closeRealm();
            return null;
        }
    }

    /**
     * This following method will convert util date type to formatted string date
     * @param date The input date
     * @return desired formatted date
     */
    public String getServerDateStringFromDate(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy h:mm a");
        return date != null?sdf.format(date):null;
    }


    /**
     * This following method will convert String date to formatted util date
     * @param date
     * @return
     */
    public Date getAndroidDateStringFromDate(String date){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy h:mm a");
        try {
            return date != null?sdf.parse(date):null;
        }catch (ParseException e){
            return null;
        }

    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

}
