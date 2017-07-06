package org.sdrc.lrcasemanagement.asynctask;

import android.os.AsyncTask;

import org.sdrc.lrcasemanagement.listener.PatientSaveListener;
import org.sdrc.lrcasemanagement.model.AsyncTaskResultModel;
import org.sdrc.lrcasemanagement.model.ChildModel;
import org.sdrc.lrcasemanagement.model.ChildStatusModel;
import org.sdrc.lrcasemanagement.model.PatientModel;
import org.sdrc.lrcasemanagement.model.realmmodel.Child;
import org.sdrc.lrcasemanagement.model.realmmodel.ChildStatus;
import org.sdrc.lrcasemanagement.model.realmmodel.Patient;
import org.sdrc.lrcasemanagement.model.realmmodel.SysConfig;
import org.sdrc.lrcasemanagement.util.Constant;
import org.sdrc.lrcasemanagement.util.LRCM;
import org.sdrc.lrcasemanagement.util.Validation;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;

/**
 * Created by Ratikanta Pradhan (ratikanta@sdrc.co.in) on 26-01-2017.
 */

public class PatientSaveAsyncTask extends AsyncTask {
    private static final String TAG = PatientSaveAsyncTask.class.getName();

    private PatientSaveListener patientSaveListener;

    private PatientModel patientModel;

    public void setPatientSaveListener(PatientSaveListener patientSaveListener) {
        this.patientSaveListener = patientSaveListener;
    }

    @Override
    protected Object doInBackground(Object[] objects) {


        AsyncTaskResultModel asyncTaskResultModel = new AsyncTaskResultModel();
        Realm realm = LRCM.getInstance().getRealm();
        try {
            patientModel = (PatientModel) objects[0];
            if (patientModel != null) {


                realm.beginTransaction();
                Validation validation = new Validation();

                //if patientModel id null then it is a fresh record(we will consider it is a fresh record)
                //any violation is bug
                if (patientModel.getPatientId() == null) {
                    //check when edit the mcts number, duplicate may possible

                    String newPatientId = LRCM.getInstance().getNewPatientId();
                    if (newPatientId != null) {
                        boolean isError = false;
                        String errorMessage = null;
                        Patient patientToInsert = new Patient();

                        patientToInsert.setPatientId(newPatientId);

                        //serial no
                        String validateResult;
                        if (patientModel.getSerialNo() != null && patientModel.getAdmissionDateAndTime() != null) {
                            validateResult = validation.validateSerialNo(patientModel.getSerialNo(), patientModel.getAdmissionDateAndTime());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setSerialNo(patientModel.getSerialNo());
                            }
                        }else{
                            isError = true;
                            errorMessage = Constant.ValidationErrorMessage.ENTER_PROPER_SERIAL_NO_AND_ADMISSION_DATE;
                        }

                        //date of admission
                        if (!isError) {
                            if(patientModel.getAdmissionDateAndTime() != null){
                                validateResult = validation.validateDateOfAdmission(patientModel.getAdmissionDateAndTime());
                                if (validateResult != null) {
                                    isError = true;
                                    errorMessage = validateResult;
                                } else {
                                    patientToInsert.setAdmissionDateAndTime(patientModel.getAdmissionDateAndTime());
                                }
                            }else{
                                isError = true;
                                errorMessage = Constant.ValidationErrorMessage.ADMISSION_DATE_CAN_NOT_BE_BLANK;
                            }

                        }

                        //Type of patient
                        if (!isError) {
                            patientToInsert.setTypeOfPatient(patientModel.getTypeOfPatient());
                        }

                        //Type of from referred facility
                        if (!isError) {
                            patientToInsert.setTypeOfFromReferredFacility(patientModel.getTypeOfFromReferredFacility());
                        }

                        //Name of from referred facility
                        if (!isError) {
                            patientToInsert.setNameOfFromReferredFacility(
                                    patientModel.getNameOfFromReferredFacility() == null?null:
                                            patientModel.getNameOfFromReferredFacility().trim().equals("")?null:
                                                    patientModel.getNameOfFromReferredFacility().trim()
                            );
                        }

                        //patient full name
                        if (!isError) {
                            if(patientModel.getPatientName() != null &&
                                    !(patientModel.getPatientName().trim().equals(""))) {
                                patientToInsert.setPatientName(patientModel.getPatientName());
                            }else{
                                isError = true;
                                errorMessage = Constant.ValidationErrorMessage.PATIENT_NAME_CAN_NOT_BE_BLANK;
                            }
                        }

                        //patientHusbandName
                        if(!isError) {
                            patientToInsert.setPatientHusbandName(patientModel.getPatientHusbandName() != null
                                    && !(patientModel.getPatientHusbandName().trim().equals("")) ?
                                    patientModel.getPatientHusbandName().trim() : null);
                        }

                        //patient Address State
                        if (!isError) {
                            patientToInsert.setStateAreaId(patientModel.getStateAreaId());
                        }

                        //detailAddressIfOtherState
                        if (!isError) {
                            validateResult = validation.validateDetailAddressIfOtherState(patientModel.getDetailAddressIfOtherState(), patientModel.getStateAreaId());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setDetailAddressIfOtherState(
                                        patientModel.getDetailAddressIfOtherState() != null?
                                                patientModel.getDetailAddressIfOtherState().trim().equals("")?null:
                                                        patientModel.getDetailAddressIfOtherState()

                                                :null);
                            }
                        }

                        //patient Address District
                        if (!isError) {
                            validateResult = validation.validatePatientDistrict(patientModel.getDistrictAreaId(), patientModel.getStateAreaId());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setDistrictAreaId(patientModel.getDistrictAreaId());
                            }
                        }

                        //patient Address Block
                        if (!isError) {
                            validateResult = validation.validatePatientBlock(patientModel.getBlockAreaId(), patientModel.getStateAreaId());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setBlockAreaId(patientModel.getBlockAreaId());
                            }
                        }

                        //village
                        if (!isError) {
                            validateResult = validation.validatePatientVillage(patientModel.getVillage(), patientModel.getStateAreaId());
                            if (patientModel.getVillage() != null) {
                                patientToInsert.setVillage(patientModel.getVillage());
                            }
                        }

                        //patientMobileNo
                        if (!isError) {
                            validateResult = validation.validateMobileNo(patientModel.getMobileNo());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setMobileNo(patientModel.getMobileNo());
                            }
                        }

                        //patientAge
                        if (!isError) {
                            validateResult = validation.validatePatientAge(patientModel.getAge());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setAge(patientModel.getAge());
                            }
                        }

                        //cast
                        if (!isError) {
                            validateResult = validation.validateCaste(patientModel.getCaste());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setCaste(patientModel.getCaste());
                            }
                        }

                        //aplOrBpl
                        if (!isError) {
                            validateResult = validation.validateAplOrBpl(patientModel.getAplOrBpl());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setAplOrBpl(patientModel.getAplOrBpl());
                            }
                        }


                        //noOfNormalDeliveries
                        if (!isError) {
                            validateResult = validation.validateNoOfNormalDeliveries(patientModel.getNoOfNormalDeliveries());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setNoOfNormalDeliveries(patientModel.getNoOfNormalDeliveries());
                            }
                        }

                        //noOfAssistedDeliveries
                        if (!isError) {
                            validateResult = validation.validateNoOfAssistedDeliveries(patientModel.getNoOfAssistedDeliveries());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setNoOfAssistedDeliveries(patientModel.getNoOfAssistedDeliveries());
                            }
                        }

                        //noOfCSectionDeliveries
                        if (!isError) {
                            validateResult = validation.validateNoOfCSectionDeliveries(patientModel.getNoOfCSectionDeliveries());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setNoOfCSectionDeliveries(patientModel.getNoOfCSectionDeliveries());
                            }
                        }

                        //noOfLiveChild
                        if (!isError) {
                            validateResult = validation.validateNoOfLiveChild(patientModel.getNoOfLiveChild());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setNoOfLiveChild(patientModel.getNoOfLiveChild());
                            }
                        }

                        //noOfStillBirth
                        if (!isError) {
                            validateResult = validation.validateNoOfStillBirth(patientModel.getNoOfStillBirth());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setNoOfStillBirth(patientModel.getNoOfStillBirth());
                            }
                        }

                        //validate previous delivery details for children
                        if (!isError) {
                            validateResult = validation.validatePreviousDeliveryInfoForChildren(patientModel.getNoOfNormalDeliveries(), patientModel.getNoOfAssistedDeliveries(),
                                    patientModel.getNoOfCSectionDeliveries(), patientModel.getNoOfLiveChild(), patientModel.getNoOfStillBirth());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            }
                        }

                        //noOfAbortion
                        if (!isError) {
                            validateResult = validation.validateNoOfAbortion(patientModel.getNoOfAbortion());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setNoOfAbortion(patientModel.getNoOfAbortion());
                            }
                        }

                        //noOfAntenatalCheckUps
                        if (!isError) {
                            validateResult = validation.validateNoOfAntenatalCheckUps(patientModel.getNoOfAntenatalCheckups());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setNoOfAntenatalCheckUps(patientModel.getNoOfAntenatalCheckups());
                            }
                        }


                        //antenatalCheckUpDoneBy
                        if (!isError) {
                            validateResult = validation.validateAntenatalCheckUpDoneBy(patientModel.getNoOfAntenatalCheckups(), patientModel.getAntenatalCheckupDoneBy());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setAntenatalCheckUpDoneBy(patientModel.getAntenatalCheckupDoneBy());
                            }
                        }

                        //bpSystolic
                        if (!isError) {
                            validateResult = validation.validateBpSystolic(patientModel.getBpSystolic());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setBpSystolic(patientModel.getBpSystolic());
                            }
                        }

                        //bpDiastolic
                        if (!isError) {
                            validateResult = validation.validateBpDiastolic(patientModel.getBpDiastolic());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setBpDiastolic(patientModel.getBpDiastolic());
                            }
                        }


                        //pulseRatePerMinute
                        if (!isError) {
                            validateResult = validation.validatePulseRatePerMinute(patientModel.getPulseRatePerMinute());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setPulseRatePerMinute(patientModel.getPulseRatePerMinute());
                            }
                        }


                        //respiratoryRatePerMinute
                        if (!isError) {
                            validateResult = validation.validateRespiratoryRatePerMinute(patientModel.getRespiratoryRatePerMinute());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setRespiratoryRatePerMinute(patientModel.getRespiratoryRatePerMinute());
                            }
                        }

                        //hb
                        if (!isError) {
                            validateResult = validation.validateHeartRate(patientModel.getHeartRate());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setHeartRate(patientModel.getHeartRate());
                            }
                        }

                        //cervicalDilatationInCm
                        if (!isError) {
                            validateResult = validation.validateCervicalDilatationInCm(patientModel.getCervicalDilatationInCm());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setCervicalDilatationInCm(patientModel.getCervicalDilatationInCm());
                            }
                        }

                        //isPatrographStarted
                        if (!isError) {
                            validateResult = validation.validateIsPatrographStarted(patientModel.getPatrographStarted(), patientModel.getCervicalDilatationInCm());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setPatrographStarted(patientModel.getPatrographStarted());
                            }
                        }

                        //urineAlbumine
                        if (!isError) {
                            validateResult = validation.validateUrineAlbumine(patientModel.getUrineAlbumine());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            }else{
                                patientToInsert.setUrineAlbumine(patientModel.getUrineAlbumine());
                            }
                        }

                        //urineSugar
                        if (!isError) {
                            validateResult = validation.validateUrineSugar(patientModel.getUrineSugar());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            }else{
                                patientToInsert.setUrineSugar(patientModel.getUrineSugar());
                            }
                        }

                        //isBloodSugarTestDone
                        if (!isError) {
                            validateResult = validation.validateIsBloodSugarTestDone(patientModel.getBloodSugarTestDone());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            }else{
                                patientToInsert.setBloodSugarTestDone(patientModel.getBloodSugarTestDone());
                            }
                        }

                        //bloodSugarFasting
                        if (!isError) {
                            validateResult = validation.validateBloodSugarFasting(patientModel.getBloodSugarTestDone(), patientModel.getBloodSugarFasting());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            }else{
                                patientToInsert.setBloodSugarFasting(patientModel.getBloodSugarFasting());
                            }
                        }

                        //bloodSugarPostmeal
                        if (!isError) {
                            validateResult = validation.validateBloodSugarPostmeal(patientModel.getBloodSugarTestDone(), patientModel.getBloodSugarPostmeal());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            }else{
                                patientToInsert.setBloodSugarPostmeal(patientModel.getBloodSugarPostmeal());
                            }
                        }

                        //bloodSugarRandom
                        if (!isError) {
                            validateResult = validation.validateBloodSugarRandom(patientModel.getBloodSugarTestDone(), patientModel.getBloodSugarRandom());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            }else{
                                patientToInsert.setBloodSugarRandom(patientModel.getBloodSugarRandom());
                            }
                        }

                        //vdrlRPR
                        if (!isError) {
                            validateResult = validation.validateVdrlRPR(patientModel.getVdrlRPR());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else{
                                patientToInsert.setVdrlRPR(patientModel.getVdrlRPR());
                            }
                        }

                        //sickling
                        if (!isError) {
                            validateResult = validation.validateSickling(patientModel.getSickling());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setSickling(patientModel.getSickling());
                            }
                        }

                        //hivTest
                        if (!isError) {
                            validateResult = validation.validateHivTest(patientModel.getHivTest());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setHivTest(patientModel.getHivTest());
                            }
                        }

                        //bloodGroup
                        if (!isError) {
                            validateResult = validation.validateBloodGroup(patientModel.getBloodGroup());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setBloodGroup(patientModel.getBloodGroup());
                            }
                        }

                        //rhType
                        if (!isError) {
                            validateResult = validation.validateRHType(patientModel.getRhType());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setRhType(patientModel.getRhType());
                            }
                        }

                        //vehicleToFacility
                        if (!isError) {
                            validateResult = validation.validateVehicleToFacility(patientModel.getVehicleToFacility());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setVehicleToFacility(patientModel.getVehicleToFacility());
                            }
                        }

                        //deliveryDate
                        if (!isError) {
                            validateResult = validation.validateDeliveryDateAndTime(patientModel.getDeliveryDateAndTime(), patientModel.getAdmissionDateAndTime());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setDeliveryDateAndTime(patientModel.getDeliveryDateAndTime());
                            }
                        }

                        //deliveryBy
                        if (!isError) {
                            validateResult = validation.validateDeliveryBy(patientModel.getDeliveryBy());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                if (patientModel.getDeliveryBy() != null) {
                                    patientToInsert.setDeliveryBy(patientModel.getDeliveryBy().trim());
                                }else{
                                    patientToInsert.setDeliveryBy(patientModel.getDeliveryBy());
                                }
                            }
                        }

                        //deliveryTerm
                        if (!isError) {
                            validateResult = validation.validateDeliveryTerm(patientModel.getDeliveryTerm());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setDeliveryTerm(patientModel.getDeliveryTerm());
                            }
                        }

                        //dexamethasone
                        if (!isError) {
                            validateResult = validation.validateDexamethasone(patientModel.getDeliveryTerm(), patientModel.getDexamethasoneGiven());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setDexamethasoneGiven(patientModel.getDexamethasoneGiven());
                            }
                        }

                        //deliveryType
                        if (!isError) {
                            validateResult = validation.validateDeliveryType(patientModel.getDeliveryType());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setDeliveryType(patientModel.getDeliveryType());
                            }
                        }

                        //drugGivenInThirdStageOfLabor
                        if (!isError) {
                            validateResult = validation.validateDrugGivenInThirdStageOfLabor(patientModel.getDrugGivenInThirdStageOfLabor());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setDrugGivenInThirdStageOfLabor(patientModel.getDrugGivenInThirdStageOfLabor());
                            }
                        }

                        //wasCordClampingDelayed
                        if (!isError) {
                            validateResult = validation.validateWasCordClampingDelayed(patientModel.getWasCordClampingDelayed());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setWasCordClampingDelayed(patientModel.getWasCordClampingDelayed());
                            }
                        }


                        //hasGestationalDM
                        if (!isError) {
                            patientToInsert.setHasGestationalDM(patientModel.getHasGestationalDM());
                        }

                        //isInsulinGiven
                        if (!isError) {
                            validateResult = validation.validateIsInsulinGiven(patientModel.getHasGestationalDM(), patientModel.getInsulinGiven());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setInsulinGiven(patientModel.getInsulinGiven());
                            }
                        }

                        //hasHypothyroidism
                        if (!isError) {
                            patientToInsert.setHasHypothyroidism(patientModel.getHasHypothyroidism());
                        }

                        //isThyroxineGiven
                        if (!isError) {
                            validateResult = validation.validateIsThyroxineGiven(patientModel.getHasHypothyroidism(), patientModel.getLeavothyroxineGiven());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setLeavothyroxineGiven(patientModel.getLeavothyroxineGiven());
                            }
                        }

                        //isEdampsia
                        if (!isError) {
                            patientToInsert.setHasEclampsia(patientModel.getHasEclampsia());
                        }

                        //isMagsulfGiven
                        if (!isError) {
                            validateResult = validation.validatIsTreatedWithMagsulf(patientModel.getHasEclampsia(), patientModel.getTreatedWithMagsulf());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setTreatedWithMagsulf (patientModel.getTreatedWithMagsulf());
                            }
                        }

                        //children
                        if (!isError) {

                            if (patientModel.getChildren() != null && patientModel.getChildren().size() > 0) {

                                RealmList<Child> children = new RealmList<>();
                                validateResult = validation.validateChild(patientModel.getChildren());

                                if (validateResult == null) {
                                    for (ChildModel childModel : patientModel.getChildren()) {
                                        Child realmChild = realm.createObject(Child.class);

                                        if (childModel.getIsStillBirth() != null) {
                                            if (!childModel.getIsStillBirth()) {

                                                realmChild.setChildBreastFedInHour(childModel.getIsChildBreastFedInHour());
                                                realmChild.setHasNeededRescusition(childModel.getHasNeededRescusition());
                                                realmChild.setHasCongenitalAnomalies(childModel.getHasCongenitalAnomalies());
                                                realmChild.setBCGGiven(childModel.getIsBCGGiven());
                                                realmChild.setZeroOPVGiven(childModel.getIsZeroOPVGiven());
                                                realmChild.setHepBZeroGiven(childModel.getIsHepBZeroGiven());
                                                realmChild.setVitaminKGiven(childModel.getIsVitaminKGiven());

                                            } else {
                                                realmChild.setStillBirthType(childModel.getStillBirthType());
                                            }
                                            realmChild.setChildSex(childModel.getChildSex());
                                            realmChild.setStillBirth(childModel.getIsStillBirth());
                                            realmChild.setChildWeight(childModel.getChildWeight());
                                            realmChild.setPatientId(newPatientId);//should change accordingly
                                            children.add(realmChild);
                                        }
                                    }
                                    patientToInsert.setChildren(children);
                                } else {
                                    isError = true;
                                    errorMessage = validateResult;
                                }
                            }
                        }


                        //isBloodTransfusion
                        if (!isError) {
                            validateResult = validation.validateIsBloodTransfusion(patientModel.getBloodTransfusionGiven());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setBloodTransfusionGiven(patientModel.getBloodTransfusionGiven());
                            }
                        }

                        //noOfPints
                        if (!isError) {
                            validateResult = validation.validateNoOfPints(patientModel.getBloodTransfusionGiven(), patientModel.getNoOfPints());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setNoOfPints(patientModel.getNoOfPints());
                            }
                        }

                        //isPpiucdInserted
                        if (!isError) {
                            validateResult = validation.validateIsPpiucdInserted(patientModel.getPpiucdInserted());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setPpiucdInserted(patientModel.getPpiucdInserted());
                            }
                        }

                        //isIFAGivenInPNC
                        if (!isError) {
                            validateResult = validation.validateIsIFAStarted(patientModel.getIFAGivenInPNC());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setIFAGivenInPNC(patientModel.getIFAGivenInPNC());
                            }
                        }

                        //isCalciumVitaminD3InPNC
                        if (!isError) {
                            validateResult = validation.validateIsCalciumVitD3Started(patientModel.getCalciumVitaminD3InPNC());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setCalciumVitaminD3InPNC(patientModel.getCalciumVitaminD3InPNC());
                            }
                        }

                        //typeOfJSY
                        if (!isError) {
                            validateResult = validation.validateTypeOfJSY(patientModel.getTypeOfJSY());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setTypeOfJSY(patientModel.getTypeOfJSY());
                            }
                        }


                        //motherStatus
                        if (!isError) {
                            validateResult = validation.validateMotherStatus(patientModel.getMotherStatus());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setMotherStatus(patientModel.getMotherStatus());
                                if(patientModel.getMotherStatus() != null){
                                    patientToInsert.setClosed(true);
                                }
                            }
                        }


                        //dischargeDateAndTime
                        if (!isError) {
                            validateResult = validation.validateDischargeDate(patientModel.getMotherStatus(), patientModel.getDischargeDateAndTime(), patientModel.getAdmissionDateAndTime(), patientModel.getDeliveryDateAndTime());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setDischargeDateAndTime(patientModel.getDischargeDateAndTime());
                            }
                        }

                        //transportToHome
                        if (!isError) {
                            validateResult = validation.validateTransportToHome(patientModel.getMotherStatus(), patientModel.getTransportToHome());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setTransportToHome(patientModel.getTransportToHome());
                            }
                        }

                        //referredDateAndTime
                        if (!isError) {
                            validateResult = validation.validateReferredDateAndTime(patientModel.getMotherStatus(), patientModel.getReferredDateAndTime(), patientModel.getAdmissionDateAndTime(), patientModel.getDeliveryDateAndTime());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setReferredDateAndTime(patientModel.getReferredDateAndTime());
                            }
                        }


                        //referredBy
                        if (!isError) {
                            validateResult = validation.validateReferredBy(patientModel.getMotherStatus(), patientModel.getReferredBy());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setReferredBy(patientModel.getReferredBy() != null?patientModel.getReferredBy().trim():null);
                            }
                        }

                        //referredCause
                        if (!isError) {
                            validateResult = validation.validateReferredCause(patientModel.getMotherStatus(), patientModel.getReferredCause());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setReferredCause(patientModel.getReferredCause() != null?patientModel.getReferredCause():null);
                            }
                        }

                        //otherReferredCause
                        if (!isError) {
                            validateResult = validation.validateOtherReferredCause(patientModel.getMotherStatus(), patientModel.getOtherReferredCause());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setOtherReferredCause(patientModel.getOtherReferredCause());
                            }
                        }

                        //referredArea
                        if (!isError) {
                            validateResult = validation.validateReferredArea(patientModel.getMotherStatus(), patientModel.getReferredAreaId());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setReferredAreaId(patientModel.getReferredAreaId());
                            }
                        }

                        //otherReferredAreaId
                        if (!isError) {
                            validateResult = validation.validateOtherReferredArea(patientModel.getMotherStatus(), patientModel.getOtherReferredAreaId());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setOtherReferredAreaId(patientModel.getOtherReferredAreaId());
                            }
                        }

                        //referredTransport
                        if (!isError) {
                            validateResult = validation.validateReferredTransport(patientModel.getMotherStatus(), patientModel.getReferredTransport());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setReferredTransport(patientModel.getReferredTransport());
                            }
                        }

                        //lamaDateAndTime
                        if (!isError) {
                            validateResult = validation.validateLamaDateAndTime(patientModel.getMotherStatus(),
                                    patientModel.getLamaDateAndTime(),
                                    patientModel.getAdmissionDateAndTime());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setLamaDateAndTime(patientModel.getLamaDateAndTime());
                            }
                        }

                        //patientDeathDateAndTime
                        if (!isError) {
                            validateResult = validation.validatePatientDeathDateAndTime(patientModel.getMotherStatus(), patientModel.getPatientDeathDateAndTime(), patientModel.getAdmissionDateAndTime(), patientModel.getDeliveryDateAndTime());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setPatientDeathDateAndTime(patientModel.getPatientDeathDateAndTime());
                            }
                        }

                        //patientDeathCause
                        if (!isError) {
                            validateResult = validation.validatePatientDeathCause(patientModel.getMotherStatus(), patientModel.getPatientDeathCause());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setPatientDeathCause(patientModel.getPatientDeathCause());
                            }
                        }

                        //otherPatientDeathCause
                        if (!isError) {
                            validateResult = validation.validateOtherPatientDeathCause(patientModel.getMotherStatus(), patientModel.getOtherPatientDeathCause());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setOtherPatientDeathCause(patientModel.getOtherPatientDeathCause());
                            }
                        }



                        //vadidate mother status feilds
                        if (!isError) {
                            validateResult = validation.validateMotherStatusFeilds(patientModel.getMotherStatus(), patientModel);
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            }
                        }

                        //child status
                        if (!isError) {

                            if (patientModel.getChildrenStatus() != null && patientModel.getChildrenStatus().size() > 0) {
                                RealmList<ChildStatus> childStatuses = new RealmList<>();
                                validateResult = validation.validateChildStaus(patientModel.getChildrenStatus(),
                                        patientModel.getDeliveryDateAndTime(),
                                        patientModel.getAdmissionDateAndTime());

                                if (validateResult == null) {
                                    for (ChildStatusModel childStatusModel : patientModel.getChildrenStatus()) {
                                        ChildStatus realmChildStatus = realm.createObject(ChildStatus.class);

                                        realmChildStatus.setStatus(childStatusModel.getStatus());
                                        realmChildStatus.setDischargeDateAndTime(childStatusModel.getDischargeDateAndTime());
                                        realmChildStatus.setDischargeWeight(childStatusModel.getDischargeWeight());
                                        realmChildStatus.setTransportToHome(childStatusModel.getTransportToHome());
                                        realmChildStatus.setReferredDateAndTime(childStatusModel.getReferredDateAndTime());
                                        realmChildStatus.setReferredBy(childStatusModel.getReferredBy());
                                        realmChildStatus.setReferredCause(childStatusModel.getReferredCause());
                                        realmChildStatus.setOtherReferredCause(childStatusModel.getOtherReferredCause());
                                        realmChildStatus.setReferredTo(childStatusModel.getReferredTo());
                                        realmChildStatus.setOtherReferredTo(childStatusModel.getOtherReferredTo());
                                        realmChildStatus.setReferredTransport(childStatusModel.getReferredTransport());
                                        realmChildStatus.setLamaDateAndTime(childStatusModel.getLamaDateAndTime());
                                        realmChildStatus.setDeathDateAndTime(childStatusModel.getDeathDateAndTime());
                                        realmChildStatus.setDeathCause(childStatusModel.getDeathCause());
                                        realmChildStatus.setPatientId(patientToInsert.getPatientId());

                                        childStatuses.add(realmChildStatus);
                                    }
                                    patientToInsert.setChildStatus(childStatuses);
                                } else {
                                    isError = true;
                                    errorMessage = validateResult;
                                }
                            }
                        }

                        patientToInsert.setSynced(false);
                        if (!isError) {
                            realm.copyToRealm(patientToInsert);
                            SysConfig sysConfig = realm.where(SysConfig.class).equalTo("id", 1).findFirst();
                            if (sysConfig != null) {
                                //trying to increase value by one
                                int i = (int) sysConfig.getPatientId();
                                sysConfig.setPatientId(++i);
                                asyncTaskResultModel.setResult(Constant.Result.SUCCESS);
                            } else {
                                asyncTaskResultModel.setResult(Constant.Result.ERROR);
                                asyncTaskResultModel.setMessage("code 1: Data save error");
                            }

                        } else {
                            asyncTaskResultModel.setResult(Constant.Result.ERROR);
                            asyncTaskResultModel.setMessage(errorMessage);
                        }

                    } else {
                        asyncTaskResultModel.setResult(Constant.Result.ERROR);
                        asyncTaskResultModel.setMessage("Could not generate patient id");
                    }

                } else {

                    //Get the existing patientModel
                    Patient patientToInsert = realm.where(Patient.class).equalTo("patientId", patientModel.getPatientId()).findFirst();
                    if (patientToInsert != null) {

                        //Patient found
                        boolean isError = false;
                        String errorMessage = null;


                        //serial no
                        String validateResult;
                        if(patientToInsert.getSerialNo().intValue() != patientModel.getSerialNo().intValue()){
                            if (patientModel.getSerialNo() != null && patientModel.getAdmissionDateAndTime() != null) {
                                validateResult = validation.validateSerialNo(patientModel.getSerialNo(), patientModel.getAdmissionDateAndTime());
                                if (validateResult != null) {
                                    isError = true;
                                    errorMessage = validateResult;
                                } else {
                                    patientToInsert.setSerialNo(patientModel.getSerialNo());
                                }
                            }else{
                                isError = true;
                                errorMessage = "Please enter proper serial no. and admission date";
                            }

                        } else {
                            //Here 2 serial no.s are equal
                            //we have to check fort month and year
                            if (!validation.validateSameMonthAndYear(patientToInsert.getAdmissionDateAndTime(), patientModel.getAdmissionDateAndTime())){
                                if (patientModel.getSerialNo() != null && patientModel.getAdmissionDateAndTime() != null) {
                                    validateResult = validation.validateSerialNo(patientModel.getSerialNo(), patientModel.getAdmissionDateAndTime());
                                    if (validateResult != null) {
                                        isError = true;
                                        errorMessage = validateResult;
                                    } else {
                                        patientToInsert.setSerialNo(patientModel.getSerialNo());
                                    }
                                }else{
                                    isError = true;
                                    errorMessage = "Please enter proper serial no. and admission date";
                                }
                            }
                        }

                        //date of admission
                        if (!isError) {
                            if(patientModel.getAdmissionDateAndTime() != null){
                                validateResult = validation.validateDateOfAdmission(patientModel.getAdmissionDateAndTime());
                                if (validateResult != null) {
                                    isError = true;
                                    errorMessage = validateResult;
                                } else {
                                    patientToInsert.setAdmissionDateAndTime(patientModel.getAdmissionDateAndTime());
                                }
                            }else{
                                isError = true;
                                errorMessage = Constant.ValidationErrorMessage.ADMISSION_DATE_CAN_NOT_BE_BLANK;
                            }

                        }

                        //Type of patient
                        if (!isError) {
                            patientToInsert.setTypeOfPatient(patientModel.getTypeOfPatient());
                        }

                        //Type of from referred facility
                        if (!isError) {
                            patientToInsert.setTypeOfFromReferredFacility(patientModel.getTypeOfFromReferredFacility());
                        }

                        //Name of from referred facility
                        if (!isError) {
                            patientToInsert.setNameOfFromReferredFacility(
                                    patientModel.getNameOfFromReferredFacility() == null?null:
                                            patientModel.getNameOfFromReferredFacility().trim().equals("")?null:
                                                    patientModel.getNameOfFromReferredFacility().trim()
                            );
                        }

                        //patient full name
                        if (!isError) {
                            if(patientModel.getPatientName() != null &&
                                    !(patientModel.getPatientName().trim().equals(""))) {
                                patientToInsert.setPatientName(patientModel.getPatientName());
                            }else{
                                isError = true;
                                errorMessage = Constant.ValidationErrorMessage.PATIENT_NAME_CAN_NOT_BE_BLANK;
                            }
                        }

                        //patientHusbandName
                        if(!isError) {
                            patientToInsert.setPatientHusbandName(patientModel.getPatientHusbandName() != null
                                    && !(patientModel.getPatientHusbandName().trim().equals("")) ?
                                    patientModel.getPatientHusbandName().trim() : null);
                        }


                        //patient Address State
                        if (!isError) {
                            patientToInsert.setStateAreaId(patientModel.getStateAreaId());
                        }

                        //detailAddressIfOtherState
                        if (!isError) {
                            validateResult = validation.validateDetailAddressIfOtherState(patientModel.getDetailAddressIfOtherState(), patientModel.getStateAreaId());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setDetailAddressIfOtherState(
                                        patientModel.getDetailAddressIfOtherState() != null?
                                                patientModel.getDetailAddressIfOtherState().trim().equals("")?null:
                                                        patientModel.getDetailAddressIfOtherState()

                                :null);
                            }
                        }

                        //patient Address District
                        if (!isError) {
                            validateResult = validation.validatePatientDistrict(patientModel.getDistrictAreaId(), patientModel.getStateAreaId());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setDistrictAreaId(patientModel.getDistrictAreaId());
                            }
                        }

                        //patient Address Block
                        if (!isError) {
                            validateResult = validation.validatePatientBlock(patientModel.getBlockAreaId(), patientModel.getStateAreaId());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setBlockAreaId(patientModel.getBlockAreaId());
                            }
                        }


                        //village
                        if(!isError) {
                            patientToInsert.setVillage(patientModel.getVillage() != null
                                    && !(patientModel.getVillage().trim().equals("")) ?
                                    patientModel.getVillage().trim() : null);
                        }

                        //patientMobileNo
                        if (!isError) {
                            validateResult = validation.validateMobileNo(patientModel.getMobileNo());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setMobileNo(patientModel.getMobileNo());
                            }
                        }

                        //patientAge
                        if (!isError) {
                            validateResult = validation.validatePatientAge(patientModel.getAge());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setAge(patientModel.getAge());
                            }
                        }

                        //cast
                        if (!isError) {
                            validateResult = validation.validateCaste(patientModel.getCaste());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setCaste(patientModel.getCaste());
                            }
                        }

                        //aplOrBpl
                        if (!isError) {
                            validateResult = validation.validateAplOrBpl(patientModel.getAplOrBpl());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setAplOrBpl(patientModel.getAplOrBpl());
                            }
                        }


                        //noOfNormalDeliveries
                        if (!isError) {
                            validateResult = validation.validateNoOfNormalDeliveries(patientModel.getNoOfNormalDeliveries());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setNoOfNormalDeliveries(patientModel.getNoOfNormalDeliveries());
                            }
                        }

                        //noOfAssistedDeliveries
                        if (!isError) {
                            validateResult = validation.validateNoOfAssistedDeliveries(patientModel.getNoOfAssistedDeliveries());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setNoOfAssistedDeliveries(patientModel.getNoOfAssistedDeliveries());
                            }
                        }

                        //noOfCSectionDeliveries
                        if (!isError) {
                            validateResult = validation.validateNoOfCSectionDeliveries(patientModel.getNoOfCSectionDeliveries());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setNoOfCSectionDeliveries(patientModel.getNoOfCSectionDeliveries());
                            }
                        }

                        //noOfLiveChild
                        if (!isError) {
                            validateResult = validation.validateNoOfLiveChild(patientModel.getNoOfLiveChild());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setNoOfLiveChild(patientModel.getNoOfLiveChild());
                            }
                        }

                        //noOfStillBirth
                        if (!isError) {
                            validateResult = validation.validateNoOfStillBirth(patientModel.getNoOfStillBirth());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setNoOfStillBirth(patientModel.getNoOfStillBirth());
                            }
                        }

                        //validate previous delivery details for children
                        if (!isError) {
                            validateResult = validation.validatePreviousDeliveryInfoForChildren(patientModel.getNoOfNormalDeliveries(), patientModel.getNoOfAssistedDeliveries(),
                                    patientModel.getNoOfCSectionDeliveries(), patientModel.getNoOfLiveChild(), patientModel.getNoOfStillBirth());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            }
                        }

                        //noOfAbortion
                        if (!isError) {
                            validateResult = validation.validateNoOfAbortion(patientModel.getNoOfAbortion());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setNoOfAbortion(patientModel.getNoOfAbortion());
                            }
                        }

                        //noOfAntenatalCheckUps
                        if (!isError) {
                            validateResult = validation.validateNoOfAntenatalCheckUps(patientModel.getNoOfAntenatalCheckups());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setNoOfAntenatalCheckUps(patientModel.getNoOfAntenatalCheckups());
                            }
                        }


                        //antenatalCheckUpDoneBy
                        if (!isError) {
                            validateResult = validation.validateAntenatalCheckUpDoneBy(patientModel.getNoOfAntenatalCheckups(), patientModel.getAntenatalCheckupDoneBy());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setAntenatalCheckUpDoneBy(patientModel.getAntenatalCheckupDoneBy());
                            }
                        }

                        //bpSystolic
                        if (!isError) {
                            validateResult = validation.validateBpSystolic(patientModel.getBpSystolic());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setBpSystolic(patientModel.getBpSystolic());
                            }
                        }

                        //bpDiastolic
                        if (!isError) {
                            validateResult = validation.validateBpDiastolic(patientModel.getBpDiastolic());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setBpDiastolic(patientModel.getBpDiastolic());
                            }
                        }


                        //pulseRatePerMinute
                        if (!isError) {
                            validateResult = validation.validatePulseRatePerMinute(patientModel.getPulseRatePerMinute());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setPulseRatePerMinute(patientModel.getPulseRatePerMinute());
                            }
                        }


                        //respiratoryRatePerMinute
                        if (!isError) {
                            validateResult = validation.validateRespiratoryRatePerMinute(patientModel.getRespiratoryRatePerMinute());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setRespiratoryRatePerMinute(patientModel.getRespiratoryRatePerMinute());
                            }
                        }

                        //hb
                        if (!isError) {
                            validateResult = validation.validateHeartRate(patientModel.getHeartRate());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setHeartRate(patientModel.getHeartRate());
                            }
                        }

                        //cervicalDilatationInCm
                        if (!isError) {
                            validateResult = validation.validateCervicalDilatationInCm(patientModel.getCervicalDilatationInCm());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setCervicalDilatationInCm(patientModel.getCervicalDilatationInCm());
                            }
                        }

                        //isPatrographStarted
                        if (!isError) {
                            validateResult = validation.validateIsPatrographStarted(patientModel.getPatrographStarted(), patientModel.getCervicalDilatationInCm());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setPatrographStarted(patientModel.getPatrographStarted());
                            }
                        }

                        //urineAlbumine
                        if (!isError) {
                            validateResult = validation.validateUrineAlbumine(patientModel.getUrineAlbumine());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            }else{
                                patientToInsert.setUrineAlbumine(patientModel.getUrineAlbumine());
                            }
                        }

                        //urineSugar
                        if (!isError) {
                            validateResult = validation.validateUrineSugar(patientModel.getUrineSugar());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            }else{
                                patientToInsert.setUrineSugar(patientModel.getUrineSugar());
                            }
                        }

                        //isBloodSugarTestDone
                        if (!isError) {
                            validateResult = validation.validateIsBloodSugarTestDone(patientModel.getBloodSugarTestDone());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            }else{
                                patientToInsert.setBloodSugarTestDone(patientModel.getBloodSugarTestDone());
                            }
                        }


                        //bloodSugarFasting
                        if (!isError) {
                            validateResult = validation.validateBloodSugarFasting(patientModel.getBloodSugarTestDone(), patientModel.getBloodSugarFasting());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            }else{
                                patientToInsert.setBloodSugarFasting(patientModel.getBloodSugarFasting());
                            }
                        }

                        //bloodSugarPostmeal
                        if (!isError) {
                            validateResult = validation.validateBloodSugarPostmeal(patientModel.getBloodSugarTestDone(), patientModel.getBloodSugarPostmeal());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            }else{
                                patientToInsert.setBloodSugarPostmeal(patientModel.getBloodSugarPostmeal());
                            }
                        }

                        //bloodSugarRandom
                        if (!isError) {
                            validateResult = validation.validateBloodSugarRandom(patientModel.getBloodSugarTestDone(), patientModel.getBloodSugarRandom());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            }else{
                                patientToInsert.setBloodSugarRandom(patientModel.getBloodSugarRandom());
                            }
                        }

                        //vdrlRPR
                        if (!isError) {
                            validateResult = validation.validateVdrlRPR(patientModel.getVdrlRPR());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else{
                                patientToInsert.setVdrlRPR(patientModel.getVdrlRPR());
                            }
                        }

                        //sickling
                        if (!isError) {
                            validateResult = validation.validateSickling(patientModel.getSickling());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setSickling(patientModel.getSickling());
                            }
                        }

                        //hivTest
                        if (!isError) {
                            validateResult = validation.validateHivTest(patientModel.getHivTest());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setHivTest(patientModel.getHivTest());
                            }
                        }

                        //bloodGroup
                        if (!isError) {
                            validateResult = validation.validateBloodGroup(patientModel.getBloodGroup());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setBloodGroup(patientModel.getBloodGroup());
                            }
                        }

                        //rhType
                        if (!isError) {
                            validateResult = validation.validateRHType(patientModel.getRhType());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setRhType(patientModel.getRhType());
                            }
                        }

                        //vehicleToFacility
                        if (!isError) {
                            validateResult = validation.validateVehicleToFacility(patientModel.getVehicleToFacility());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setVehicleToFacility(patientModel.getVehicleToFacility());
                            }
                        }

                        //deliveryDate
                        if (!isError) {
                            validateResult = validation.validateDeliveryDateAndTime(patientModel.getDeliveryDateAndTime(), patientModel.getAdmissionDateAndTime());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setDeliveryDateAndTime(patientModel.getDeliveryDateAndTime());
                            }
                        }

                        //deliveryBy
                        if (!isError) {
                            validateResult = validation.validateDeliveryBy(patientModel.getDeliveryBy());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                if (patientModel.getDeliveryBy() != null) {
                                    patientToInsert.setDeliveryBy(patientModel.getDeliveryBy().trim());
                                }else{
                                    patientToInsert.setDeliveryBy(patientModel.getDeliveryBy());
                                }
                            }
                        }

                        //deliveryTerm
                        if (!isError) {
                            validateResult = validation.validateDeliveryTerm(patientModel.getDeliveryTerm());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setDeliveryTerm(patientModel.getDeliveryTerm());
                            }
                        }

                        //dexamethasone
                        if (!isError) {
                            validateResult = validation.validateDexamethasone(patientModel.getDeliveryTerm(), patientModel.getDexamethasoneGiven());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setDexamethasoneGiven(patientModel.getDexamethasoneGiven());
                            }
                        }

                        //deliveryType
                        if (!isError) {
                            validateResult = validation.validateDeliveryType(patientModel.getDeliveryType());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setDeliveryType(patientModel.getDeliveryType());
                            }
                        }

                        //drugGivenInThirdStageOfLabor
                        if (!isError) {
                            validateResult = validation.validateDrugGivenInThirdStageOfLabor(patientModel.getDrugGivenInThirdStageOfLabor());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setDrugGivenInThirdStageOfLabor(patientModel.getDrugGivenInThirdStageOfLabor());
                            }
                        }

                        //wasCordClampingDelayed
                        if (!isError) {
                            validateResult = validation.validateWasCordClampingDelayed(patientModel.getWasCordClampingDelayed());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setWasCordClampingDelayed(patientModel.getWasCordClampingDelayed());
                            }
                        }


                        //hasGestationalDM
                        if (!isError) {
                            patientToInsert.setHasGestationalDM(patientModel.getHasGestationalDM());
                        }

                        //isInsulinGiven
                        if (!isError) {
                            validateResult = validation.validateIsInsulinGiven(patientModel.getHasGestationalDM(), patientModel.getInsulinGiven());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setInsulinGiven(patientModel.getInsulinGiven());
                            }
                        }

                        //hasHypothyroidism
                        if (!isError) {
                            patientToInsert.setHasHypothyroidism(patientModel.getHasHypothyroidism());
                        }

                        //isThyroxineGiven
                        if (!isError) {
                            validateResult = validation.validateIsThyroxineGiven(patientModel.getHasHypothyroidism(), patientModel.getLeavothyroxineGiven());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setLeavothyroxineGiven(patientModel.getLeavothyroxineGiven());
                            }
                        }

                        //isEdampsia
                        if (!isError) {
                            patientToInsert.setHasEclampsia(patientModel.getHasEclampsia());
                        }

                        //isMagsulfGiven
                        if (!isError) {
                            validateResult = validation.validatIsTreatedWithMagsulf(patientModel.getHasEclampsia(), patientModel.getTreatedWithMagsulf());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setTreatedWithMagsulf (patientModel.getTreatedWithMagsulf());
                            }
                        }

                        //children
                        if (!isError) {

                            //delete all the children of respective patient
                            //add accordingly
                            RealmResults<Child> childrenResults = realm.where(Child.class).equalTo("patientId", patientToInsert.getPatientId()).findAll();
                            childrenResults.deleteAllFromRealm();
                            if (patientModel.getChildren() != null && patientModel.getChildren().size() > 0) {

                                RealmList<Child> children = new RealmList<>();

                                validateResult = validation.validateChild(patientModel.getChildren());

                                if (validateResult == null) {
                                    for (ChildModel childModel : patientModel.getChildren()) {
                                        Child realmChild = realm.createObject(Child.class);

                                        if (childModel.getIsStillBirth() != null) {
                                            if (!childModel.getIsStillBirth()) {

                                                realmChild.setChildBreastFedInHour(childModel.getIsChildBreastFedInHour());
                                                realmChild.setHasNeededRescusition(childModel.getHasNeededRescusition());
                                                realmChild.setHasCongenitalAnomalies(childModel.getHasCongenitalAnomalies());
                                                realmChild.setBCGGiven(childModel.getIsBCGGiven());
                                                realmChild.setZeroOPVGiven(childModel.getIsZeroOPVGiven());
                                                realmChild.setHepBZeroGiven(childModel.getIsHepBZeroGiven());
                                                realmChild.setVitaminKGiven(childModel.getIsVitaminKGiven());

                                            } else {
                                                realmChild.setStillBirthType(childModel.getStillBirthType());
                                            }
                                            realmChild.setChildSex(childModel.getChildSex());
                                            realmChild.setStillBirth(childModel.getIsStillBirth());
                                            realmChild.setChildWeight(childModel.getChildWeight());
                                            realmChild.setPatientId(patientToInsert.getPatientId());//should change accordingly
                                            children.add(realmChild);
                                        }
                                    }
                                    patientToInsert.setChildren(children);
                                } else {
                                    isError = true;
                                    errorMessage = validateResult;
                                }
                            }
                        }

                        //isBloodTransfusion
                        if (!isError) {
                            validateResult = validation.validateIsBloodTransfusion(patientModel.getBloodTransfusionGiven());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setBloodTransfusionGiven(patientModel.getBloodTransfusionGiven());
                            }
                        }

                        //noOfPints
                        if (!isError) {
                            validateResult = validation.validateNoOfPints(patientModel.getBloodTransfusionGiven(), patientModel.getNoOfPints());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setNoOfPints(patientModel.getNoOfPints());
                            }
                        }

                        //isPpiucdInserted
                        if (!isError) {
                            validateResult = validation.validateIsPpiucdInserted(patientModel.getPpiucdInserted());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setPpiucdInserted(patientModel.getPpiucdInserted());
                            }
                        }

                        //isIFAGivenInPNC
                        if (!isError) {
                            validateResult = validation.validateIsIFAStarted(patientModel.getIFAGivenInPNC());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setIFAGivenInPNC(patientModel.getIFAGivenInPNC());
                            }
                        }

                        //isCalciumVitaminD3InPNC
                        if (!isError) {
                            validateResult = validation.validateIsCalciumVitD3Started(patientModel.getCalciumVitaminD3InPNC());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setCalciumVitaminD3InPNC(patientModel.getCalciumVitaminD3InPNC());
                            }
                        }

                        //typeOfJSY
                        if (!isError) {
                            validateResult = validation.validateTypeOfJSY(patientModel.getTypeOfJSY());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setTypeOfJSY(patientModel.getTypeOfJSY());
                            }
                        }


                        //motherStatus
                        if (!isError) {
                            validateResult = validation.validateMotherStatus(patientModel.getMotherStatus());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setMotherStatus(patientModel.getMotherStatus());
                                if(patientModel.getMotherStatus() != null){
                                    patientToInsert.setClosed(true);
                                }
                            }
                        }


                        //dischargeDateAndTime
                        if (!isError) {
                            validateResult = validation.validateDischargeDate(patientModel.getMotherStatus(), patientModel.getDischargeDateAndTime(), patientModel.getAdmissionDateAndTime(), patientModel.getDeliveryDateAndTime());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setDischargeDateAndTime(patientModel.getDischargeDateAndTime());
                            }
                        }

                        //transportToHome
                        if (!isError) {
                            validateResult = validation.validateTransportToHome(patientModel.getMotherStatus(), patientModel.getTransportToHome());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setTransportToHome(patientModel.getTransportToHome());
                            }
                        }

                        //referredDateAndTime
                        if (!isError) {
                            validateResult = validation.validateReferredDateAndTime(patientModel.getMotherStatus(), patientModel.getReferredDateAndTime(), patientModel.getAdmissionDateAndTime(), patientModel.getDeliveryDateAndTime());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setReferredDateAndTime(patientModel.getReferredDateAndTime());
                            }
                        }

                        //referredBy
                        if (!isError) {
                            validateResult = validation.validateReferredBy(patientModel.getMotherStatus(), patientModel.getReferredBy());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setReferredBy(patientModel.getReferredBy() != null?patientModel.getReferredBy().trim():null);
                            }
                        }

                        //referredCause
                        if (!isError) {
                            validateResult = validation.validateReferredCause(patientModel.getMotherStatus(), patientModel.getReferredCause());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setReferredCause(patientModel.getReferredCause() != null?patientModel.getReferredCause():null);
                            }
                        }

                        //otherReferredCause
                        if (!isError) {
                            validateResult = validation.validateOtherReferredCause(patientModel.getMotherStatus(), patientModel.getOtherReferredCause());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setOtherReferredCause(patientModel.getOtherReferredCause());
                            }
                        }

                        //referredArea
                        if (!isError) {
                            validateResult = validation.validateReferredArea(patientModel.getMotherStatus(), patientModel.getReferredAreaId());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setReferredAreaId(patientModel.getReferredAreaId());
                            }
                        }

                        //otherReferredAreaId
                        if (!isError) {
                            validateResult = validation.validateOtherReferredArea(patientModel.getMotherStatus(), patientModel.getOtherReferredAreaId());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setOtherReferredAreaId(patientModel.getOtherReferredAreaId());
                            }
                        }

                        //referredTransport
                        if (!isError) {
                            validateResult = validation.validateReferredTransport(patientModel.getMotherStatus(), patientModel.getReferredTransport());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setReferredTransport(patientModel.getReferredTransport());
                            }
                        }

                        //lamaDateAndTime
                        if (!isError) {
                            validateResult = validation.validateLamaDateAndTime(patientModel.getMotherStatus(),
                                    patientModel.getLamaDateAndTime(),
                                    patientModel.getAdmissionDateAndTime());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setLamaDateAndTime(patientModel.getLamaDateAndTime());
                            }
                        }


                        //patientDeathDateAndTime
                        if (!isError) {
                            validateResult = validation.validatePatientDeathDateAndTime(patientModel.getMotherStatus(), patientModel.getPatientDeathDateAndTime(), patientModel.getAdmissionDateAndTime(), patientModel.getDeliveryDateAndTime());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setPatientDeathDateAndTime(patientModel.getPatientDeathDateAndTime());
                            }
                        }

                        //patientDeathCause
                        if (!isError) {
                            validateResult = validation.validatePatientDeathCause(patientModel.getMotherStatus(), patientModel.getPatientDeathCause());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setPatientDeathCause(patientModel.getPatientDeathCause());
                            }
                        }

                        //otherPatientDeathCause
                        if (!isError) {
                            validateResult = validation.validateOtherPatientDeathCause(patientModel.getMotherStatus(), patientModel.getOtherPatientDeathCause());
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            } else {
                                patientToInsert.setOtherPatientDeathCause(patientModel.getOtherPatientDeathCause());
                            }
                        }

                        //vadidate mother status feilds
                        if (!isError) {
                            validateResult = validation.validateMotherStatusFeilds(patientModel.getMotherStatus(), patientModel);
                            if (validateResult != null) {
                                isError = true;
                                errorMessage = validateResult;
                            }
                        }

                        //child status
                        if (!isError) {

                            RealmResults<ChildStatus> childrenStatusResults = realm.where(ChildStatus.class)
                                    .equalTo("patientId", patientToInsert.getPatientId())
                                    .findAll();
                            childrenStatusResults.deleteAllFromRealm();

                            if (patientModel.getChildrenStatus() != null && patientModel.getChildrenStatus().size() > 0) {
                                RealmList<ChildStatus> childStatuses = new RealmList<>();
                                validateResult = validation.validateChildStaus(patientModel.getChildrenStatus(),
                                        patientModel.getDeliveryDateAndTime(),
                                        patientModel.getAdmissionDateAndTime());

                                if (validateResult == null) {
                                    for (ChildStatusModel childStatusModel : patientModel.getChildrenStatus()) {
                                        ChildStatus realmChildStatus = realm.createObject(ChildStatus.class);

                                        realmChildStatus.setStatus(childStatusModel.getStatus());
                                        realmChildStatus.setDischargeDateAndTime(childStatusModel.getDischargeDateAndTime());
                                        realmChildStatus.setDischargeWeight(childStatusModel.getDischargeWeight());
                                        realmChildStatus.setTransportToHome(childStatusModel.getTransportToHome());
                                        realmChildStatus.setReferredDateAndTime(childStatusModel.getReferredDateAndTime());
                                        realmChildStatus.setReferredBy(childStatusModel.getReferredBy());
                                        realmChildStatus.setReferredCause(childStatusModel.getReferredCause());
                                        realmChildStatus.setOtherReferredCause(childStatusModel.getOtherReferredCause());
                                        realmChildStatus.setReferredTo(childStatusModel.getReferredTo());
                                        realmChildStatus.setOtherReferredTo(childStatusModel.getOtherReferredTo());
                                        realmChildStatus.setReferredTransport(childStatusModel.getReferredTransport());
                                        realmChildStatus.setLamaDateAndTime(childStatusModel.getLamaDateAndTime());
                                        realmChildStatus.setDeathDateAndTime(childStatusModel.getDeathDateAndTime());
                                        realmChildStatus.setDeathCause(childStatusModel.getDeathCause());
                                        realmChildStatus.setPatientId(patientToInsert.getPatientId());

                                        childStatuses.add(realmChildStatus);
                                    }
                                    patientToInsert.setChildStatus(childStatuses);
                                } else {
                                    isError = true;
                                    errorMessage = validateResult;
                                }
                            }
                        }


                        patientToInsert.setSynced(false);
                        if (!isError) {
                            asyncTaskResultModel.setResult(Constant.Result.SUCCESS);
                        } else {
                            asyncTaskResultModel.setResult(Constant.Result.ERROR);
                            asyncTaskResultModel.setMessage(errorMessage);
                        }


                    } else {
                        asyncTaskResultModel.setResult(Constant.Result.ERROR);
                        asyncTaskResultModel.setMessage("Patient record not found");
                    }
                }
                //check for existing patientModel and area

                realm.commitTransaction();
                realm.close();

            } else {
                asyncTaskResultModel.setResult(Constant.Result.ERROR);
                asyncTaskResultModel.setMessage("Patient model not found");
            }
            return asyncTaskResultModel;
        } catch (Exception e) {
            realm.commitTransaction();
            AsyncTaskResultModel asyncTaskResultModel1 = new AsyncTaskResultModel();
            asyncTaskResultModel1.setResult(Constant.Result.ERROR);
            asyncTaskResultModel1.setMessage(e.getMessage());
            LRCM.getInstance().closeRealm();
            return asyncTaskResultModel1;
        }
    }

    @Override
    protected void onPostExecute(Object o) {
        if (patientSaveListener != null && o != null) {
            patientSaveListener.patientSaveComplete((AsyncTaskResultModel) o);
        }
        super.onPostExecute(o);
    }
}
