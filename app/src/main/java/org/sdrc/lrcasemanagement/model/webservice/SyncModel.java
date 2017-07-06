package org.sdrc.lrcasemanagement.model.webservice;

import java.util.List;

/**
 * Created by Ratikanta Pradhan (ratikanta@sdrc.co.in) on 29-01-2017.
 */

public class SyncModel {


    private MobileUserModel mobileUserModel;
    private List<PatientModel> patientModels;

    public MobileUserModel getMobileUserModel() {
        return mobileUserModel;
    }

    public void setMobileUserModel(MobileUserModel mobileUserModel) {
        this.mobileUserModel = mobileUserModel;
    }

    public List<PatientModel> getPatientModels() {
        return patientModels;
    }

    public void setPatientModels(List<PatientModel> patientModels) {
        this.patientModels = patientModels;
    }
}
