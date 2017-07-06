package org.sdrc.lrcasemanagement.service;

import org.sdrc.lrcasemanagement.model.ChildModel;
import org.sdrc.lrcasemanagement.model.PatientModel;
import org.sdrc.lrcasemanagement.model.realmmodel.Child;
import org.sdrc.lrcasemanagement.model.realmmodel.ChildStatus;
import org.sdrc.lrcasemanagement.model.realmmodel.Patient;
import org.sdrc.lrcasemanagement.model.ChildStatusModel;
import org.sdrc.lrcasemanagement.util.LRCM;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;

/**
 *
 * Created by Ratikanta Pradhan (ratikanta@sdrc.co.in) on 29-01-2017.
 */

public class LRCMServiceImpl implements LRCMServcie {
    @Override
    public List<PatientModel> getPatientModel() {

        try {

            List<PatientModel> patientModels = new ArrayList<>();
            Realm realm = LRCM.getInstance().getRealm();
            RealmResults<Patient> results = realm.where(Patient.class).findAllSorted("admissionDateAndTime", Sort.DESCENDING);
            for(Patient patient: results){

                PatientModel patientModel = new PatientModel();
                patientModel.setPatientId(patient.getPatientId());
                patientModel.setSerialNo(patient.getSerialNo());
                patientModel.setAdmissionDateAndTime(patient.getAdmissionDateAndTime());
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
                patientModel.setNoOfAntenatalCheckups(patient.getNoOfAntenatalCheckUps());
                patientModel.setAntenatalCheckupDoneBy(patient.getAntenatalCheckUpDoneBy());
                patientModel.setBpSystolic(patient.getBpSystolic());
                patientModel.setBpDiastolic(patient.getBpDiastolic());
                patientModel.setPulseRatePerMinute(patient.getPulseRatePerMinute());
                patientModel.setRespiratoryRatePerMinute(patient.getRespiratoryRatePerMinute());
                patientModel.setHeartRate(patient.getHeartRate());
                patientModel.setCervicalDilatationInCm(patient.getCervicalDilatationInCm());
                patientModel.setPatrographStarted(patient.getPatrographStarted());
                patientModel.setUrineAlbumine(patient.getUrineAlbumine());
                patientModel.setUrineSugar(patient.getUrineSugar());
                patientModel.setBloodSugarTestDone(patient.getBloodSugarTestDone());
                patientModel.setBloodSugarFasting(patient.getBloodSugarFasting());
                patientModel.setBloodSugarPostmeal(patient.getBloodSugarPostmeal());
                patientModel.setBloodSugarRandom(patient.getBloodSugarRandom());
                patientModel.setVdrlRPR(patient.getVdrlRPR());
                patientModel.setSickling(patient.getSickling());
                patientModel.setHivTest(patient.getHivTest());
                patientModel.setBloodGroup(patient.getBloodGroup());
                patientModel.setRhType(patient.getRhType());
                patientModel.setVehicleToFacility(patient.getVehicleToFacility());
                patientModel.setDeliveryDateAndTime(patient.getDeliveryDateAndTime());
                patientModel.setDeliveryBy(patient.getDeliveryBy());
                patientModel.setDeliveryTerm(patient.getDeliveryTerm());
                patientModel.setDexamethasoneGiven(patient.getDexamethasoneGiven());
                patientModel.setDeliveryType(patient.getDeliveryType());
                patientModel.setDrugGivenInThirdStageOfLabor(patient.getDrugGivenInThirdStageOfLabor());
                patientModel.setWasCordClampingDelayed(patient.getWasCordClampingDelayed());
                patientModel.setHasGestationalDM(patient.getHasGestationalDM());
                patientModel.setInsulinGiven(patient.getInsulinGiven());
                patientModel.setHasHypothyroidism(patient.getHasHypothyroidism());
                patientModel.setLeavothyroxineGiven(patient.getLeavothyroxineGiven());
                patientModel.setHasEclampsia(patient.getHasEclampsia());
                patientModel.setTreatedWithMagsulf(patient.getTreatedWithMagsulf());
                List<ChildModel> childModels = new ArrayList<>();
                for (Child child: patient.getChildren()){
                    ChildModel childModel = new ChildModel();
                    childModel.setIsStillBirth (child.getStillBirth());
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
                patientModel.setChildren(childModels);
                patientModel.setBloodTransfusionGiven(patient.getBloodTransfusionGiven());
                patientModel.setNoOfPints(patient.getNoOfPints());
                patientModel.setPpiucdInserted(patient.getPpiucdInserted());
                patientModel.setIFAGivenInPNC(patient.getIFAGivenInPNC());
                patientModel.setCalciumVitaminD3InPNC(patient.getCalciumVitaminD3InPNC());
                patientModel.setTypeOfJSY(patient.getTypeOfJSY());

                patientModel.setMotherStatus(patient.getMotherStatus());
                patientModel.setDischargeDateAndTime(patient.getDischargeDateAndTime());
                patientModel.setTransportToHome(patient.getTransportToHome());
                patientModel.setReferredDateAndTime(patient.getReferredDateAndTime());
                patientModel.setReferredBy(patient.getReferredBy());
                patientModel.setReferredCause(patient.getReferredCause());
                patientModel.setOtherReferredCause(patient.getOtherReferredCause());
                patientModel.setReferredTransport(patient.getReferredTransport());
                patientModel.setReferredAreaId(patient.getReferredAreaId());
                patientModel.setOtherReferredAreaId(patient.getOtherReferredAreaId());
                patientModel.setLamaDateAndTime(patient.getLamaDateAndTime());
                patientModel.setPatientDeathDateAndTime(patient.getPatientDeathDateAndTime());
                patientModel.setPatientDeathCause(patient.getPatientDeathCause());
                patientModel.setOtherPatientDeathCause(patient.getOtherPatientDeathCause());

                List<ChildStatusModel> childStatusModels = new ArrayList<>();
                for (ChildStatus childStatus: patient.getChildStatus()){
                    ChildStatusModel childStatusModel = new ChildStatusModel();
                    childStatusModel.setStatus(childStatus.getStatus());
                    childStatusModel.setDischargeDateAndTime(childStatus.getDischargeDateAndTime());
                    childStatusModel.setDischargeWeight(childStatus.getDischargeWeight());
                    childStatusModel.setTransportToHome(childStatus.getTransportToHome());
                    childStatusModel.setReferredDateAndTime(childStatus.getReferredDateAndTime());
                    childStatusModel.setReferredBy(childStatus.getReferredBy());
                    childStatusModel.setReferredCause(childStatus.getReferredCause());
                    childStatusModel.setOtherReferredCause(childStatus.getOtherReferredCause());
                    childStatusModel.setReferredTo(childStatus.getReferredTo());
                    childStatusModel.setOtherReferredTo(childStatus.getOtherReferredTo());
                    childStatusModel.setReferredTransport(childStatus.getReferredTransport());
                    childStatusModel.setLamaDateAndTime(childStatus.getLamaDateAndTime());
                    childStatusModel.setDeathDateAndTime(childStatus.getDeathDateAndTime());
                    childStatusModel.setDeathCause(childStatus.getDeathCause());
                    childStatusModels.add(childStatusModel);
                }
                patientModel.setChildren(childModels);
                patientModel.setClosed(patient.getClosed());
                patientModel.setChildrenStatus(childStatusModels);
                patientModels.add(patientModel);
            }
            LRCM.getInstance().closeRealm();
            return patientModels;

        }catch (Exception e){
            LRCM.getInstance().closeRealm();
            return null;
        }
    }

    @Override
    public List<PatientModel> getPatientModelByDate(Date startDate, Date endDate) {
        try {
            //increase day by one because its taking day from 00 am
            Calendar cal = Calendar.getInstance();
            cal.setTime(endDate);
            cal.add(Calendar.DATE, 1);
            endDate = cal.getTime();

            List<PatientModel> patientModels = new ArrayList<>();
            Realm realm = LRCM.getInstance().getRealm();
            RealmResults<Patient> results = realm.where(Patient.class).between("admissionDateAndTime", startDate, endDate).findAllSorted("admissionDateAndTime", Sort.DESCENDING);
            for(Patient patient: results){

                PatientModel patientModel = new PatientModel();
                patientModel.setPatientId(patient.getPatientId());
                patientModel.setSerialNo(patient.getSerialNo());
                patientModel.setAdmissionDateAndTime(patient.getAdmissionDateAndTime());
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
                patientModel.setNoOfAntenatalCheckups(patient.getNoOfAntenatalCheckUps());
                patientModel.setAntenatalCheckupDoneBy(patient.getAntenatalCheckUpDoneBy());
                patientModel.setBpSystolic(patient.getBpSystolic());
                patientModel.setBpDiastolic(patient.getBpDiastolic());
                patientModel.setPulseRatePerMinute(patient.getPulseRatePerMinute());
                patientModel.setRespiratoryRatePerMinute(patient.getRespiratoryRatePerMinute());
                patientModel.setHeartRate(patient.getHeartRate());
                patientModel.setCervicalDilatationInCm(patient.getCervicalDilatationInCm());
                patientModel.setPatrographStarted(patient.getPatrographStarted());
                patientModel.setUrineAlbumine(patient.getUrineAlbumine());
                patientModel.setUrineSugar(patient.getUrineSugar());
                patientModel.setBloodSugarTestDone(patient.getBloodSugarTestDone());
                patientModel.setBloodSugarFasting(patient.getBloodSugarFasting());
                patientModel.setBloodSugarPostmeal(patient.getBloodSugarPostmeal());
                patientModel.setBloodSugarRandom(patient.getBloodSugarRandom());
                patientModel.setVdrlRPR(patient.getVdrlRPR());
                patientModel.setSickling(patient.getSickling());
                patientModel.setHivTest(patient.getHivTest());
                patientModel.setBloodGroup(patient.getBloodGroup());
                patientModel.setRhType(patient.getRhType());
                patientModel.setVehicleToFacility(patient.getVehicleToFacility());
                patientModel.setDeliveryDateAndTime(patient.getDeliveryDateAndTime());
                patientModel.setDeliveryBy(patient.getDeliveryBy());
                patientModel.setDeliveryTerm(patient.getDeliveryTerm());
                patientModel.setDexamethasoneGiven(patient.getDexamethasoneGiven());
                patientModel.setDeliveryType(patient.getDeliveryType());
                patientModel.setDrugGivenInThirdStageOfLabor(patient.getDrugGivenInThirdStageOfLabor());
                patientModel.setWasCordClampingDelayed(patient.getWasCordClampingDelayed());
                patientModel.setHasGestationalDM(patient.getHasGestationalDM());
                patientModel.setInsulinGiven(patient.getInsulinGiven());
                patientModel.setHasHypothyroidism(patient.getHasHypothyroidism());
                patientModel.setLeavothyroxineGiven(patient.getLeavothyroxineGiven());
                patientModel.setHasEclampsia(patient.getHasEclampsia());
                patientModel.setTreatedWithMagsulf(patient.getTreatedWithMagsulf());
                List<ChildModel> childModels = new ArrayList<>();
                for (Child child: patient.getChildren()){
                    ChildModel childModel = new ChildModel();
                    childModel.setIsStillBirth (child.getStillBirth());
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
                patientModel.setChildren(childModels);
                patientModel.setBloodTransfusionGiven(patient.getBloodTransfusionGiven());
                patientModel.setNoOfPints(patient.getNoOfPints());
                patientModel.setPpiucdInserted(patient.getPpiucdInserted());
                patientModel.setIFAGivenInPNC(patient.getIFAGivenInPNC());
                patientModel.setCalciumVitaminD3InPNC(patient.getCalciumVitaminD3InPNC());
                patientModel.setTypeOfJSY(patient.getTypeOfJSY());

                patientModel.setMotherStatus(patient.getMotherStatus());
                patientModel.setDischargeDateAndTime(patient.getDischargeDateAndTime());
                patientModel.setTransportToHome(patient.getTransportToHome());
                patientModel.setReferredDateAndTime(patient.getReferredDateAndTime());
                patientModel.setReferredBy(patient.getReferredBy());
                patientModel.setReferredCause(patient.getReferredCause());
                patientModel.setOtherReferredCause(patient.getOtherReferredCause());
                patientModel.setReferredTransport(patient.getReferredTransport());
                patientModel.setReferredAreaId(patient.getReferredAreaId());
                patientModel.setOtherReferredAreaId(patient.getOtherReferredAreaId());
                patientModel.setLamaDateAndTime(patient.getLamaDateAndTime());
                patientModel.setPatientDeathDateAndTime(patient.getPatientDeathDateAndTime());
                patientModel.setPatientDeathCause(patient.getPatientDeathCause());
                patientModel.setOtherPatientDeathCause(patient.getOtherPatientDeathCause());

                List<ChildStatusModel> childStatusModels = new ArrayList<>();
                for (ChildStatus childStatus: patient.getChildStatus()){
                    ChildStatusModel childStatusModel = new ChildStatusModel();
                    childStatusModel.setStatus(childStatus.getStatus());
                    childStatusModel.setDischargeDateAndTime(childStatus.getDischargeDateAndTime());
                    childStatusModel.setDischargeWeight(childStatus.getDischargeWeight());
                    childStatusModel.setTransportToHome(childStatus.getTransportToHome());
                    childStatusModel.setReferredDateAndTime(childStatus.getReferredDateAndTime());
                    childStatusModel.setReferredBy(childStatus.getReferredBy());
                    childStatusModel.setReferredCause(childStatus.getReferredCause());
                    childStatusModel.setOtherReferredCause(childStatus.getOtherReferredCause());
                    childStatusModel.setReferredTo(childStatus.getReferredTo());
                    childStatusModel.setOtherReferredTo(childStatus.getOtherReferredTo());
                    childStatusModel.setReferredTransport(childStatus.getReferredTransport());
                    childStatusModel.setLamaDateAndTime(childStatus.getLamaDateAndTime());
                    childStatusModel.setDeathDateAndTime(childStatus.getDeathDateAndTime());
                    childStatusModel.setDeathCause(childStatus.getDeathCause());
                    childStatusModels.add(childStatusModel);
                }
                patientModel.setChildren(childModels);
                patientModel.setClosed(patient.getClosed());
                patientModel.setChildrenStatus(childStatusModels);
                patientModels.add(patientModel);
            }
            LRCM.getInstance().closeRealm();
            return patientModels;

        }catch (Exception e){
            LRCM.getInstance().closeRealm();
            return null;
        }
    }
}
