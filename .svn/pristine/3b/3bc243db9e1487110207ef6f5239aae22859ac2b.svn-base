package org.sdrc.lrcasemanagement.service;

import org.sdrc.lrcasemanagement.model.realmmodel.ChildStatus;
import org.sdrc.lrcasemanagement.model.webservice.ChildModel;
import org.sdrc.lrcasemanagement.model.realmmodel.Child;
import org.sdrc.lrcasemanagement.model.webservice.ChildStatusModel;
import org.sdrc.lrcasemanagement.model.webservice.PatientModel;
import org.sdrc.lrcasemanagement.model.realmmodel.Patient;
import org.sdrc.lrcasemanagement.model.realmmodel.User;
import org.sdrc.lrcasemanagement.model.webservice.MobileUserModel;
import org.sdrc.lrcasemanagement.model.webservice.SyncModel;
import org.sdrc.lrcasemanagement.util.LRCM;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by Ratikanta Pradhan (ratikanta@sdrc.co.in) on 10-02-2017.
 */

public class SyncServiceImpl {

    public SyncModel getSyncmodel(){
        SyncModel syncModel = new SyncModel();
        MobileUserModel mobileUserModel = new MobileUserModel();
        Realm realm = LRCM.getInstance().getRealm();

        User user = realm.where(User.class).findFirst();
        if(user != null){
            mobileUserModel.setUsername(user.getUsername());
            mobileUserModel.setPassword(user.getPassword());
            mobileUserModel.setImei(LRCM.getInstance().getImei());
            syncModel.setMobileUserModel(mobileUserModel);
            RealmResults<Patient> results = realm.where(Patient.class).equalTo("isSynced", false).findAll();
            List<PatientModel> patientModels = new ArrayList<>();
            for(Patient patient: results){

                PatientModel patientModel = new PatientModel();

                patientModel.setPatientId(patient.getPatientId());
                patientModel.setSerialNo(patient.getSerialNo());
                patientModel.setAdmissionDateAndTime(LRCM.getInstance().getServerDateStringFromDate(patient.getAdmissionDateAndTime()));
                patientModel.setTypeOfPatient(patient.getTypeOfPatient());
                patientModel.setTypeOfFromReferredFacility(patient.getTypeOfFromReferredFacility());
                patientModel.setNameOfFromReferredFacility(patient.getNameOfFromReferredFacility());
                patientModel.setPatientName(patient.getPatientName());
                patientModel.setPatientHusbandName(patient.getPatientHusbandName());
                patientModel.setStateAreaId(patient.getStateAreaId());
                patientModel.setDetailAddressIfOtherState(patient.getDetailAddressIfOtherState());
                patientModel.setDistrictAreaId(patient.getDistrictAreaId());
                patientModel.setBlockAreaId(patient.getBlockAreaId());
                patientModel.setVillage(patient.getVillage());
                patientModel.setMobileNo(patient.getMobileNo());
                patientModel.setAge(patient.getAge());
                patientModel.setCaste(patient.getCaste());
                patientModel.setAplOrBpl(patient.getAplOrBpl());
                patientModel.setNoOfNormalDeliveries(patient.getNoOfNormalDeliveries());
                patientModel.setNoOfAssistedDeliveries(patient.getNoOfAssistedDeliveries());
                patientModel.setNoOfCSectionDeliveries(patient.getNoOfCSectionDeliveries());
                patientModel.setNoOfLiveChild(patient.getNoOfLiveChild());
                patientModel.setNoOfStillBirth(patient.getNoOfStillBirth());
                patientModel.setNoOfAbortion(patient.getNoOfAbortion());
                patientModel.setNoOfAntenatalCheckUps(patient.getNoOfAntenatalCheckUps());
                patientModel.setAntenatalCheckUpDoneBy(patient.getAntenatalCheckUpDoneBy());
                patientModel.setBpSystolic(patient.getBpSystolic());
                patientModel.setBpDiastolic(patient.getBpDiastolic());
                patientModel.setPulseRatePerMinute(patient.getPulseRatePerMinute());
                patientModel.setRespiratoryRatePerMinute(patient.getRespiratoryRatePerMinute());
                patientModel.setHeartRate(patient.getHeartRate());
                patientModel.setCervicalDilatationInCm(patient.getCervicalDilatationInCm());
                patientModel.setIsPatrographStarted(patient.getPatrographStarted());
                patientModel.setUrineAlbumine(patient.getUrineAlbumine());
                patientModel.setUrineSugar(patient.getUrineSugar());
                patientModel.setIsBloodSugarTestDone(patient.getBloodSugarTestDone());
                patientModel.setBloodSugarFasting(patient.getBloodSugarFasting());
                patientModel.setBloodSugarPostmeal(patient.getBloodSugarPostmeal());
                patientModel.setBloodSugarRandom(patient.getBloodSugarRandom());
                patientModel.setVdrlRPR(patient.getVdrlRPR());
                patientModel.setSickling(patient.getSickling());
                patientModel.setHivTest(patient.getHivTest());
                patientModel.setBloodGroup(patient.getBloodGroup());
                patientModel.setRhType(patient.getRhType());
                patientModel.setVehicleToFacility(patient.getVehicleToFacility());
                patientModel.setDeliveryDateAndTime(LRCM.getInstance().getServerDateStringFromDate(patient.getDeliveryDateAndTime()));
                patientModel.setDeliveryBy(patient.getDeliveryBy());
                patientModel.setDeliveryTerm(patient.getDeliveryTerm());
                patientModel.setIsDexamethasoneGiven(patient.getDexamethasoneGiven());
                patientModel.setDeliveryType(patient.getDeliveryType());
                patientModel.setDrugGivenInThirdStageOfLabor(patient.getDrugGivenInThirdStageOfLabor());
                patientModel.setWasCordClampingDelayed(patient.getWasCordClampingDelayed());
                patientModel.setHasGestationalDM(patient.getHasGestationalDM());
                patientModel.setIsInsulinGiven(patient.getInsulinGiven());
                patientModel.setHasHypothyroidism(patient.getHasHypothyroidism());
                patientModel.setIsLeavothyroxineGiven(patient.getLeavothyroxineGiven());
                patientModel.setHasEclampsia(patient.getHasEclampsia());
                patientModel.setIsTreatedWithMagsulf(patient.getTreatedWithMagsulf());


                List<ChildModel> childModels = new ArrayList<>();

                if(patient.getChildren() != null) {
                    for (Child child : patient.getChildren()){
                        ChildModel childModel = new ChildModel();
                        childModel.setIsStillBirth(child.getStillBirth());
                        childModel.setChildSex(child.getChildSex());
                        childModel.setChildWeight(child.getChildWeight());
                        childModel.setStillBirthType(child.getStillBirthType());
                        childModel.setIsChildBreastFedInHour(child.getChildBreastFedInHour());
                        childModel.setHasNeededRescusition(child.getHasNeededRescusition());
                        childModel.setHasCongenitalAnomalies(child.getHasCongenitalAnomalies());
                        childModel.setIsBCGGiven(child.getBCGGiven());
                        childModel.setIsZeroOPVGiven(child.getZeroOPVGiven());
                        childModel.setIsHepBZeroGiven(child.getHepBZeroGiven());
                        childModel.setIsVitaminKGiven(child.getVitaminKGiven());
                        childModels.add(childModel);
                    }
                }

                patientModel.setChildModels(childModels);
                patientModel.setIsBloodTransfusionGiven(patient.getBloodTransfusionGiven());
                patientModel.setNoOfPints(patient.getNoOfPints());
                patientModel.setIsPpiucdInserted(patient.getPpiucdInserted());
                patientModel.setIsIFAGivenInPNC(patient.getIFAGivenInPNC());
                patientModel.setIsCalciumVitaminD3InPNC(patient.getCalciumVitaminD3InPNC());
                patientModel.setTypeOfJSY(patient.getTypeOfJSY());
                patientModel.setMotherStatus(patient.getMotherStatus());
                patientModel.setDischargeDateAndTime(LRCM.getInstance().getServerDateStringFromDate(patient.getDischargeDateAndTime()));
                patientModel.setTransportToHome(patient.getTransportToHome());
                patientModel.setReferredDateAndTime(LRCM.getInstance().getServerDateStringFromDate(patient.getReferredDateAndTime()));
                patientModel.setReferredBy(patient.getReferredBy());
                patientModel.setReferredCause(patient.getReferredCause());
                patientModel.setOtherReferredCause(patient.getOtherReferredCause());
                patientModel.setReferredAreaId(patient.getReferredAreaId());
                patientModel.setOtherReferredAreaId(patient.getOtherReferredAreaId());
                patientModel.setReferredTransport(patient.getReferredTransport());
                patientModel.setLamaDateAndTime(LRCM.getInstance().getServerDateStringFromDate(patient.getLamaDateAndTime()));
                patientModel.setPatientDeathDateAndTime(LRCM.getInstance().getServerDateStringFromDate(patient.getPatientDeathDateAndTime()));
                patientModel.setPatientDeathCause(patient.getPatientDeathCause());
                patientModel.setOtherPatientDeathCause(patient.getOtherPatientDeathCause());

                List<ChildStatusModel> childStatusModels = new ArrayList<>();

                if(patient.getChildStatus() != null) {
                    for (ChildStatus childStatus : patient.getChildStatus()){
                        ChildStatusModel childStatusModel = new ChildStatusModel();

                        childStatusModel.setStatus(childStatus.getStatus());
                        childStatusModel.setDischargeDateAndTime(LRCM.getInstance().getServerDateStringFromDate(childStatus.getDischargeDateAndTime()));
                        childStatusModel.setDischargeWeight(childStatus.getDischargeWeight());
                        childStatusModel.setTransportToHome(childStatus.getTransportToHome());
                        childStatusModel.setReferredDateAndTime(LRCM.getInstance().getServerDateStringFromDate(childStatus.getReferredDateAndTime()));
                        childStatusModel.setReferredBy(childStatus.getReferredBy());
                        childStatusModel.setReferredCause(childStatus.getReferredCause());
                        childStatusModel.setOtherReferredCause(childStatus.getOtherReferredCause());
                        childStatusModel.setReferredAreaId(childStatus.getReferredTo());
                        childStatusModel.setOtherReferredAreaId(childStatus.getOtherReferredTo());
                        childStatusModel.setReferredTransport(childStatus.getReferredTransport());
                        childStatusModel.setLamaDateAndTime(LRCM.getInstance().getServerDateStringFromDate(childStatus.getLamaDateAndTime()));
                        childStatusModel.setDeathDateAndTime(LRCM.getInstance().getServerDateStringFromDate(childStatus.getDeathDateAndTime()));
                        childStatusModel.setDeathCause(childStatus.getDeathCause());
                        childStatusModels.add(childStatusModel);
                    }
                }
                patientModel.setChildStatusModel(childStatusModels);
                patientModel.setIsClosed(patient.getClosed());
                patientModels.add(patientModel);
            }
            syncModel.setPatientModels(patientModels);
        }else{
            return null;
        }
        LRCM.getInstance().closeRealm();
        return syncModel;
    }
}
