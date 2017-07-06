package org.sdrc.lrcasemanagement.util;

import android.util.Log;

import org.sdrc.lrcasemanagement.model.ChildModel;
import org.sdrc.lrcasemanagement.model.ChildStatusModel;
import org.sdrc.lrcasemanagement.model.PatientModel;
import org.sdrc.lrcasemanagement.model.realmmodel.LatestSerialNoOfMonths;
import org.sdrc.lrcasemanagement.model.realmmodel.Patient;
import org.sdrc.lrcasemanagement.model.realmmodel.SysConfig;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.GregorianCalendar;

import io.realm.RealmResults;

import static org.sdrc.lrcasemanagement.util.Constant.CHILDREN_COUNT;
import static org.sdrc.lrcasemanagement.util.Constant.CHILD_WEIGHT_MAX;
import static org.sdrc.lrcasemanagement.util.Constant.CHILD_WEIGHT_MIN;
import static org.sdrc.lrcasemanagement.util.Constant.TypeDetails.CHILD_STATUS_DEATH_TYPE_DETAIL_ID;
import static org.sdrc.lrcasemanagement.util.Constant.TypeDetails.CHILD_STATUS_DISCHARGED_TYPE_DETAIL_ID;
import static org.sdrc.lrcasemanagement.util.Constant.TypeDetails.CHILD_STATUS_LAMA_TYPE_DETAIL_ID;
import static org.sdrc.lrcasemanagement.util.Constant.TypeDetails.CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID;
import static org.sdrc.lrcasemanagement.util.Constant.TypeDetails.MOTHER_STATUS_DEATH_TYPE_DETAIL_ID;
import static org.sdrc.lrcasemanagement.util.Constant.TypeDetails.MOTHER_STATUS_DISCHARGED_TYPE_DETAIL_ID;
import static org.sdrc.lrcasemanagement.util.Constant.TypeDetails.MOTHER_STATUS_LAMA_TYPE_DETAIL_ID;
import static org.sdrc.lrcasemanagement.util.Constant.TypeDetails.MOTHER_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID;
import static org.sdrc.lrcasemanagement.util.Constant.TypeDetails.OTHER_REFERRED_CAUSE_CHILD_TYPE_DETAILS_ID;
import static org.sdrc.lrcasemanagement.util.Constant.TypeDetails.OTHER_REFERRED_TO_CHILD_TYPE_DETAILS_ID;
import static org.sdrc.lrcasemanagement.util.Constant.ValidationErrorMessage.CHILD_OTHER_REFERRED_CAUSE_CAN_NOT_BE_GIVEN;
import static org.sdrc.lrcasemanagement.util.Constant.ValidationErrorMessage.CHILD_OTHER_REFERRED_TO_CAN_NOT_BE_GIVEN;


/**
 * This class is responsible for validate the user inputs before it get saved/updated in the database.
 * Created by Ratikanta Pradhan (ratikanta@sdrc.co.in) on 31-01-2017.
 * Edited by Amit Sahoo (amit@sdrc.co.in)
 */

public class Validation {

    /**
     * This method will validate serial no.
     * Serial no, should no be less than 1.
     * Serial no, should no be more than 999(should not be 4 - digit).
     * Serial no, should no be duplicate for a month
     * Serial no, should no be less than serial no which has come from server in master data
     *
     * @param serialNo        The serial number user entered.
     * @param dateOfAdmission Admission date entered by user
     * @return error message if any otherwise null
     */
    public String validateSerialNo(Integer serialNo, Date dateOfAdmission) {

        //checking for less than 1
        if (serialNo < 1) {
            return Constant.ValidationErrorMessage.SERIAL_NO_CAN_NOT_BE_LESS_THAN_ONE;
        }


        //checking for greater than 999/4-digit
        if (serialNo > 999) {
            return Constant.ValidationErrorMessage.SERIAL_NO_CAN_NOT_BE_GREATER_THAN_THREE_DIGITS;
        }


        //checking for duplicate for a month
        /*

            We have to find record which serial no. is given serial no
            and admission date MONTH is same with given admission date MONTH.
            If found, we have to show error message to user that, the serial no.
            you have entered is already present for particular month(We have to get it from
            strings.xml may be manually).


         */


        //Setting first day
        Calendar dateOfAdmissionCalendar = GregorianCalendar.getInstance();
        dateOfAdmissionCalendar.setTime(dateOfAdmission);
        dateOfAdmissionCalendar.set(Calendar.DAY_OF_MONTH, 1);
        dateOfAdmissionCalendar.set(Calendar.HOUR_OF_DAY, 0);
        dateOfAdmissionCalendar.set(Calendar.MINUTE, 0);
        dateOfAdmissionCalendar.set(Calendar.SECOND, 0);
        dateOfAdmissionCalendar.set(Calendar.MILLISECOND, 0);


        Date firstDateOfMonth = dateOfAdmissionCalendar.getTime();

        //Setting last day
        dateOfAdmissionCalendar.setTime(dateOfAdmission);
        dateOfAdmissionCalendar.set(Calendar.DAY_OF_MONTH,
                dateOfAdmissionCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        dateOfAdmissionCalendar.set(Calendar.HOUR_OF_DAY, 23);
        dateOfAdmissionCalendar.set(Calendar.MINUTE, 59);
        dateOfAdmissionCalendar.set(Calendar.SECOND, 59);
        dateOfAdmissionCalendar.set(Calendar.MILLISECOND, 0);

        Date lastDateOfMonth = dateOfAdmissionCalendar.getTime();


        Patient patient = LRCM.getInstance().getRealm()
                .where(Patient.class)
                .equalTo("serialNo", serialNo)
                .between("admissionDateAndTime", firstDateOfMonth, lastDateOfMonth)
                .findFirst();

        if (patient != null) {
            return Constant.ValidationErrorMessage.SERIAL_NO_CAN_NOT_BE_DUPLICATE;
        }

        RealmResults<LatestSerialNoOfMonths> r = LRCM.getInstance().getRealm().where(LatestSerialNoOfMonths.class).findAll();

        Log.i("hello", r.size() + "");

        //checking for server serial no
        LatestSerialNoOfMonths latestSerialNoOfMonths = LRCM.getInstance().getRealm()
                .where(LatestSerialNoOfMonths.class)
                .between("recordDate", firstDateOfMonth, lastDateOfMonth)
                .findFirst();

        if(latestSerialNoOfMonths != null) {
            if (latestSerialNoOfMonths.getSerialNo() >= serialNo.intValue()) {
                return Constant.ValidationErrorMessage.SERIAL_NO_CAN_NOT_BE_DUPLICATE + " : latest serial no. is " + latestSerialNoOfMonths.getSerialNo();
            }
        }

        return null;
    }

    /**
     * This following methode is going to validate wheither
     * the first date and the secondDate belong to same month and same year or not
     * If they belong to same month and same year the following methode is going to return true otherwise false
     * @param firstDate given by user
     * @param secondDate given by user
     * @return If they belong to same month and same year the following methode is going to return true otherwise false
     */
    public boolean validateSameMonthAndYear(Date firstDate, Date secondDate){

        if (firstDate != null && secondDate != null) {
            int firstMonth, firstYear, secondMonth, secondYear;
            //get calender for 1st date
            Calendar firstDateCalender = Calendar.getInstance();
            firstDateCalender.setTime(firstDate);
            //get calender for 2nd date
            Calendar secondDateCalender = Calendar.getInstance();
            secondDateCalender.setTime(secondDate);

            firstMonth = firstDateCalender.get(Calendar.MONTH);
            firstYear = firstDateCalender.get(Calendar.YEAR);
            secondMonth = secondDateCalender.get(Calendar.MONTH);
            secondYear = secondDateCalender.get(Calendar.YEAR);

            if (firstYear == secondYear && firstMonth == secondMonth) {
                return true;
            }
            return false;
        }
        return false;
    }

    /**
     * The following method will validate admission date
     *
     * @param dateOfAdmission java.util.Date given input by user
     * @return String error message if any otherwise null
     */
    public String validateDateOfAdmission(Date dateOfAdmission) {

        Calendar c = GregorianCalendar.getInstance();
        Date current_date = c.getTime();

        if (dateOfAdmission.after(current_date))
            return Constant.ValidationErrorMessage.ADMISSION_DATE_CAN_NOT_BE_FUTURE_DATE;
        return null;
    }

    /**
     * This methode validates type of referred facility is null or not according to type of patient
     *
     * @param typeOfPAtient
     * @param typeOfFacility
     * @return error message
     */
    public String validateTypeOfReferredFacilityType(Integer typeOfPAtient, Integer typeOfFacility) {

        //If type of patient will be null, this value should be null
        if (typeOfPAtient == null) {
            //type of patient not given
            if (typeOfFacility != null) {
                return Constant.ValidationErrorMessage.TYPE_OF_REFERRED_FACILITY_CAN_NOT_BE_GIVEN;
            }
        } else {
            //Check if patient type is referred or not
            if (typeOfPAtient != Constant.TypeDetails.REFERRED_PATIENT_TYPE_DETAIL_ID) {
                if (typeOfFacility != null) {
                    return Constant.ValidationErrorMessage.TYPE_OF_REFERRED_FACILITY_CAN_NOT_BE_GIVEN;
                }
            }

        }
        return null;
    }

    /**
     * This methode validates type of referred facility is null or not according to type of patient
     *
     * @param typeOfPAtient
     * @param nameOfFacility
     * @return error message
     */
    public String validateNameOfReferredFacility(Integer typeOfPAtient, String nameOfFacility) {

        //If type of patient will be null, this value should be null
        if (typeOfPAtient == null) {
            //type of patient not given
            if (nameOfFacility != null) {
                return Constant.ValidationErrorMessage.NAME_OF_REFERRED_FACILITY_CAN_NOT_BE_GIVEN;
            }
        } else {
            //Check if patient type is referred or not
            if (typeOfPAtient != Constant.TypeDetails.REFERRED_PATIENT_TYPE_DETAIL_ID) {
                if (nameOfFacility != null) {
                    return Constant.ValidationErrorMessage.NAME_OF_REFERRED_FACILITY_CAN_NOT_BE_GIVEN;
                }
            }

        }
        return null;
    }

    /**
     * The following method will validate detail address if patient belong to other state rather
     * than Chhattisgarh.
     * <p>
     * If state will be Chhattisgarh, this value should be null, if state is not Chhattisgarh,
     * it can or can not be null
     *
     * @param detailAddressIfOtherState The address text give n by the user
     * @param detailAddressIfOtherState The address text give n by the user
     * @return
     */
    public String validateDetailAddressIfOtherState(String detailAddressIfOtherState, Integer stateAreaId) {


        //If state will be null, this value should be null
        if (stateAreaId == null) {
            //state not given
            if (detailAddressIfOtherState != null) {
                return Constant.ValidationErrorMessage.CAN_NOT_GIVE_DETAIL_ADDRESS_WITHOUT_STATE;
            }
        } else {
            //Check if state Chhattisgarh or not
            if (stateAreaId == Constant.STATE_AREA_ID) {
                if (detailAddressIfOtherState != null) {
                    return Constant.ValidationErrorMessage.CAN_NOT_GIVE_DETAIL_ADDRESS_FOR_CHHATTISGARH_STATE;
                }
            }

        }

        return null;
    }

    /**
     * this method will validate district shoud be given if state is chhattisgarh
     * or not null
     *
     * @param districtId
     * @param stateAreaId
     * @return error message
     */
    public String validatePatientDistrict(Integer districtId, Integer stateAreaId) {
        //If state will be null, this value should be null
        if (stateAreaId == null) {
            //state not given
            if (districtId != null) {
                return Constant.ValidationErrorMessage.CAN_NOT_GIVE_DISTRICT_WITHOUT_STATE;
            }
        } else {
            //Check if state Chhattisgarh or not
            if (stateAreaId != Constant.STATE_AREA_ID) {
                if (districtId != null) {
                    return Constant.ValidationErrorMessage.CAN_NOT_GIVE_DISTRICT_WITHOUT_STATE;
                }
            }

        }
        return null;
    }

    /**
     * this method will validate district shoud be given if state is chhattisgarh
     * or not null
     *
     * @param blockId
     * @param stateAreaId
     * @return error message
     */
    public String validatePatientBlock(Integer blockId, Integer stateAreaId) {
        //If state will be null, this value should be null
        if (stateAreaId == null) {
            //state not given
            if (blockId != null) {
                return Constant.ValidationErrorMessage.CAN_NOT_GIVE_BLOCK_WITHOUT_STATE;
            }
        } else {
            //Check if state Chhattisgarh or not
            if (stateAreaId != Constant.STATE_AREA_ID) {
                if (blockId != null) {
                    return Constant.ValidationErrorMessage.CAN_NOT_GIVE_BLOCK_WITHOUT_STATE;
                }
            }

        }
        return null;
    }

    /**
     * this method will validate village shoud be given if state is chhattisgarh
     * or not null
     *
     * @param villageName
     * @param stateAreaId
     * @return error message
     */

    public String validatePatientVillage(String villageName, Integer stateAreaId) {
        //If state will be null, this value should be null
        if (stateAreaId == null) {
            //state not given
            if (villageName != null) {
                return Constant.ValidationErrorMessage.CAN_NOT_GIVE_VILLAGE_WITHOUT_STATE;
            }
        } else {
            //Check if state Chhattisgarh or not
            if (stateAreaId != Constant.STATE_AREA_ID) {
                if (villageName != null) {
                    return Constant.ValidationErrorMessage.CAN_NOT_GIVE_VILLAGE_WITHOUT_STATE;
                }
            }

        }
        return null;
    }


    /**
     * this method validates mobile no is valid or not
     * means it should be a 10 digit no.
     *
     * @param patientMobileNo
     * @return error message
     */
    public String validateMobileNo(Long patientMobileNo) {

        if (patientMobileNo != null) {
            if (patientMobileNo < 1000000000L || patientMobileNo > 9999999999L)
                return Constant.ValidationErrorMessage.INVALID_MOBILE_NO;
        }
        return null;
    }

    /**
     * this method will verify, wheither patient age is valid or not
     *
     * @param patientAge
     * @return error message
     */
    public String validatePatientAge(Integer patientAge) {

        if (patientAge != null) {
            if (patientAge < 10)
                return Constant.ValidationErrorMessage.AGE_CAN_NOT_BE_LESS_THAN;
            if (patientAge > 49)
                return Constant.ValidationErrorMessage.AGE_CAN_NOT_BE_MORE_THAN;
        }

        return null;
    }

    public String validateCaste(Integer caste) {
        return null;
    }

    public String validateAplOrBpl(Integer aplOrBpl) {
        return null;
    }

    /**
     * this method will verify, wheither no of normal deliveries is valid or not
     *
     * @param noOfNormalDeliveries
     * @return error message
     */
    public String validateNoOfNormalDeliveries(Integer noOfNormalDeliveries) {

        if (noOfNormalDeliveries != null) {

            if (noOfNormalDeliveries < 0) {
                return Constant.ValidationErrorMessage.NO_OF_NORMAL_DELIVERIES_CAN_NOT_BE_LESS_THAN;
            } else if (noOfNormalDeliveries > 10) {
                return Constant.ValidationErrorMessage.NO_OF_NORMAL_DELIVERIES_CAN_NOT_BE_MORE_THAN;
            }
        }
        return null;
    }

    /**
     * this method will verify, wheither no of normal deliveries is valid or not
     *
     * @param noOfAssistedDeliveries
     * @return error message
     */
    public String validateNoOfAssistedDeliveries(Integer noOfAssistedDeliveries) {

        if (noOfAssistedDeliveries != null) {
            if (noOfAssistedDeliveries < 0) {
                return Constant.ValidationErrorMessage.NO_OF_ASSISTED_DELIVERIES_CAN_NOT_BE_LESS_THAN;
            } else if (noOfAssistedDeliveries > 10) {
                return Constant.ValidationErrorMessage.NO_OF_ASSISTED_DELIVERIES_CAN_NOT_BE_MORE_THAN;
            }
        }
        return null;
    }

    public String validateNoOfCSectionDeliveries(Integer noOfCSectionDeliveries) {

        if (noOfCSectionDeliveries != null) {
            if (noOfCSectionDeliveries < 0) {
                return Constant.ValidationErrorMessage.NO_OF_CSECTION_DELIVERIES_CAN_NOT_BE_LESS_THAN;
            } else if (noOfCSectionDeliveries > 4) {
                return Constant.ValidationErrorMessage.NO_OF_CSECTION_DELIVERIES_CAN_NOT_BE_MORE_THAN;
            }
        }
        return null;
    }

    public String validateNoOfLiveChild(Integer noOfLiveChild) {

        if (noOfLiveChild != null) {
            if (noOfLiveChild < 0) {
                return Constant.ValidationErrorMessage.NO_OF_LIVE_CHILD_CAN_NOT_BE_LESS_THAN;
            }
            if (noOfLiveChild > 10) {
                return Constant.ValidationErrorMessage.NO_OF_LIVE_CHILD_CAN_NOT_BE_MORE_THAN;
            }
        }
        return null;
    }

    public String validateNoOfStillBirth(Integer noOfStillBirth) {

        if (noOfStillBirth != null) {
            if (noOfStillBirth < 0) {
                return Constant.ValidationErrorMessage.NO_OF_STILL_BIRTH_CAN_NOT_BE_LESS_THAN;
            }
            if (noOfStillBirth > 10) {
                return Constant.ValidationErrorMessage.NO_OF_STILL_BIRTH_CAN_NOT_BE_MORE_THAN;
            }
        }
        return null;
    }

    public String validatePreviousDeliveryInfoForChildren(Integer noOfNormalDeliveries, Integer noOfAssistedDeliveries,
                                                          Integer noOfCSectionDeliveries, Integer noOfLiveChild, Integer noOfStillBirth){

        int normalDeliveries = (noOfNormalDeliveries == null) ? 0 : noOfNormalDeliveries;
        int assistedDeliveries = (noOfAssistedDeliveries == null) ? 0 : noOfAssistedDeliveries;
        int csectionDeliveries = (noOfCSectionDeliveries == null) ? 0 : noOfCSectionDeliveries;
        int liveChidren = (noOfLiveChild == null) ? 0 : noOfLiveChild;
        int stillBirths = (noOfStillBirth == null) ? 0 : noOfStillBirth;

        int totalDeliveries = normalDeliveries + assistedDeliveries + csectionDeliveries;
        int maximumNoOfChildren = totalDeliveries * 10;
        int totalChildren = liveChidren + stillBirths ;

        if (totalChildren > maximumNoOfChildren) {
            return Constant.ValidationErrorMessage.INVALID_PREVIOUS_DELIVERY_INFORMATION_FOR_CHILDREN;
        } else if (totalChildren < totalDeliveries){
            return Constant.ValidationErrorMessage.INVALID_PREVIOUS_DELIVERY_INFORMATION_FOR_CHILDREN;
        }

        return null;
    }

    public String validateNoOfAbortion(Integer noOfAbortion) {

        if (noOfAbortion != null) {

            if (noOfAbortion < 0) {
                return Constant.ValidationErrorMessage.NO_OF_ABORTION_CAN_NOT_BE_LESS_THAN;
            } else if (noOfAbortion > 10) {
                return Constant.ValidationErrorMessage.NO_OF_ABORTION_BIRTH_CAN_NOT_BE_MORE_THAN;
            }
        }
        return null;
    }

    public String validateNoOfAntenatalCheckUps(Integer noOfAntenatalCheckups) {

        if (noOfAntenatalCheckups != null) {

            if (noOfAntenatalCheckups < 0) {
                return Constant.ValidationErrorMessage.NO_OF_ANTENATAL_CHECKUPS_CAN_NOT_BE_LESS_THAN;
            } else if (noOfAntenatalCheckups > 20) {
                return Constant.ValidationErrorMessage.NO_OF_ANTENATAL_CHECKUPS_CAN_NOT_BE_MORE_THAN;
            }
        }
        return null;
    }

    public String validateAntenatalCheckUpDoneBy(Integer noOfAntenatalCheckups, Integer antenatalCheckupDoneBy) {

        if (noOfAntenatalCheckups == null) {
            if (antenatalCheckupDoneBy != null) {
                return Constant.ValidationErrorMessage.ANTENATAL_CHECKUPS_DONE_BY_CAN_NOT_GIVEN;
            }
        } else {
            if (noOfAntenatalCheckups < 1) {
                if (antenatalCheckupDoneBy != null) {
                    return Constant.ValidationErrorMessage.ANTENATAL_CHECKUPS_DONE_BY_CAN_NOT_GIVEN;
                }
            }
        }
        return null;
    }

    public String validateBpSystolic(Integer bpSystolic) {
        if (bpSystolic != null) {
            if (bpSystolic < 0) {
                return Constant.ValidationErrorMessage.BP_SYSTOLIC_CAN_NOT_BE_LESS_THAN;
            }
            if (bpSystolic > 300) {
                return Constant.ValidationErrorMessage.BP_SYSTOLIC_CAN_NOT_BE_MORE_THAN;
            }
        }
        return null;
    }

    public String validateBpDiastolic(Integer bpDiastolic) {
        String errorMessage = null;
        if (bpDiastolic != null) {
            if (bpDiastolic < 0)
                return Constant.ValidationErrorMessage.BP_DIASTOLIC_CAN_NOT_BE_LESS_THAN;
            if (bpDiastolic > 200)
                return Constant.ValidationErrorMessage.BP_DIASTOLIC_CAN_NOT_BE_MORE_THAN;
        }
        return errorMessage;
    }

    public String validatePulseRatePerMinute(Integer pulseRatePerMinute) {

        if (pulseRatePerMinute != null) {

            if (pulseRatePerMinute < 0) {
                return Constant.ValidationErrorMessage.PULSE_RATE_CAN_NOT_BE_LESS_THAN;
            } else if (pulseRatePerMinute > 120) {
                return Constant.ValidationErrorMessage.PULSE_RATE_CAN_NOT_BE_MORE_THAN;
            }
        }
        return null;
    }

    public String validateRespiratoryRatePerMinute(Integer respiratoryRatePerMinute) {

        if (respiratoryRatePerMinute != null) {

            if (respiratoryRatePerMinute < 0) {
                return Constant.ValidationErrorMessage.REPIRATORY_RATE_CAN_NOT_BE_LESS_THAN;
            } else if (respiratoryRatePerMinute > 50) {
                return Constant.ValidationErrorMessage.REPIRATORY_RATE_CAN_NOT_BE_MORE_THAN;
            }
        }
        return null;
    }

    public String validateHeartRate(Integer hr) {

        if (hr != null) {
            if (hr < 0) {
                return Constant.ValidationErrorMessage.HEART_RATE_CAN_NOT_BE_LESS_THAN;
            }
            if (hr > 220) {
                return Constant.ValidationErrorMessage.HEART_RATE_CAN_NOT_BE_MORE_THAN;
            }
        }
        return null;
    }

    public String validateCervicalDilatationInCm(Integer cervicalDilatationInCm) {

        if (cervicalDilatationInCm != null) {
            if (cervicalDilatationInCm < 0) {
                return Constant.ValidationErrorMessage.CERVICAL_DILATATION_CAN_NOT_BE_LESS_THAN;
            }
            if (cervicalDilatationInCm > 10) {
                return Constant.ValidationErrorMessage.CERVICAL_DILATATION_CAN_NOT_BE_MORE_THAN;
            }
        }
        return null;
    }

    public String validateIsPatrographStarted(Boolean patrographStarted, Integer cervicalDilatationInCm) {
        //If Cervical dilatation will be null, this value should be null
        if (cervicalDilatationInCm == null) {
            //If Cervical dilatation not given
            if (patrographStarted != null && patrographStarted) {
                return Constant.ValidationErrorMessage.PARTOGRAPH_CAN_NOT_BE_GIVEN;
            }
        } else {
            if (cervicalDilatationInCm < 4) {
                if (patrographStarted != null && patrographStarted) {
                    return Constant.ValidationErrorMessage.PARTOGRAPH_CAN_NOT_BE_GIVEN;
                }
            }

        }
        return null;
    }

    public String validateUrineAlbumine(Integer urineAlbumine) {
        return null;
    }

    public String validateUrineSugar(Integer urineSugar) {
        return null;
    }

    public String validateIsBloodSugarTestDone(Boolean bloodSugarTestDone) {
        return null;
    }

    public String validateBloodSugarFasting(Boolean bloodSugarTestDone, Integer bloodSugarFasting) {

        if (bloodSugarTestDone == null) {
            if (bloodSugarFasting != null) {
                //error message
                return Constant.ValidationErrorMessage.BLOOD_SUGAR_FASTING_CAN_NOT_BE_GIVEN;
            }
        } else {
            if (!bloodSugarTestDone) {
                if (bloodSugarFasting != null) {
                    //error message
                    return Constant.ValidationErrorMessage.BLOOD_SUGAR_FASTING_CAN_NOT_BE_GIVEN;
                }
            } else {
                if (bloodSugarFasting != null) {
                    if (bloodSugarFasting < 1) {
                        //can not less than error msg
                        return Constant.ValidationErrorMessage.BLOOD_SUGAR_FASTING_CAN_NOT_BE_LESS_THAN;
                    }
                    if (bloodSugarFasting > 700) {
                        //can not more than error msg
                        return Constant.ValidationErrorMessage.BLOOD_SUGAR_FASTING_CAN_NOT_BE_MORE_THAN;
                    }
                }
            }
        }
        return null;
    }

    public String validateBloodSugarPostmeal(Boolean bloodSugarTestDone, Integer bloodSugarPostmeal) {
        if (bloodSugarTestDone == null) {
            if (bloodSugarPostmeal != null) {
                //error message
                return Constant.ValidationErrorMessage.BLOOD_SUGAR_POSTMEAL_CAN_NOT_BE_GIVEN;
            }
        } else {
            if (!bloodSugarTestDone) {
                if (bloodSugarPostmeal != null) {
                    //error message
                    return Constant.ValidationErrorMessage.BLOOD_SUGAR_POSTMEAL_CAN_NOT_BE_GIVEN;
                }
            } else {
                if (bloodSugarPostmeal != null) {
                    if (bloodSugarPostmeal < 1) {
                        //can not less than error msg
                        return Constant.ValidationErrorMessage.BLOOD_SUGAR_POSTMEAL_CAN_NOT_BE_LESS_THAN;
                    }
                    if (bloodSugarPostmeal > 700) {
                        //can not more than error msg
                        return Constant.ValidationErrorMessage.BLOOD_SUGAR_POSTMEAL_CAN_NOT_BE_MORE_THAN;
                    }
                }
            }
        }
        return null;
    }

    public String validateBloodSugarRandom(Boolean bloodSugarTestDone, Integer bloodSugarRandom) {
        if (bloodSugarTestDone == null) {
            if (bloodSugarRandom != null) {
                //error message
                return Constant.ValidationErrorMessage.BLOOD_SUGAR_RANDOM_CAN_NOT_BE_GIVEN;
            }
        } else {
            if (!bloodSugarTestDone) {
                if (bloodSugarRandom != null) {
                    //error message
                    return Constant.ValidationErrorMessage.BLOOD_SUGAR_RANDOM_CAN_NOT_BE_GIVEN;
                }
            } else {
                if (bloodSugarRandom != null) {
                    if (bloodSugarRandom < 1) {
                        //can not less than error msg
                        return Constant.ValidationErrorMessage.BLOOD_SUGAR_RANDOM_CAN_NOT_BE_LESS_THAN;
                    }
                    if (bloodSugarRandom > 700) {
                        //can not more than error msg
                        return Constant.ValidationErrorMessage.BLOOD_SUGAR_RANDOM_CAN_NOT_BE_MORE_THAN;
                    }
                }
            }
        }
        return null;
    }

    public String validateVdrlRPR(Integer vdrlRPR) {
        return null;
    }

    public String validateSickling(Integer sickling) {
        return null;
    }

    public String validateHivTest(Integer hivTest) {
        return null;
    }

    public String validateBloodGroup(Integer bloodGroup) {
        return null;
    }

    public String validateRHType(Integer rhType) {
        return null;
    }

    public String validateVehicleToFacility(Integer vehicleToFacility) {
        return null;
    }

    public String validateDeliveryDateAndTime(Date deliveryDate, Date admissionDate) {
        String errorMessage = null;
        if (deliveryDate != null) {
            Calendar c = Calendar.getInstance();
            Date current_date = c.getTime();

            if (deliveryDate.after(current_date)) {
                return Constant.ValidationErrorMessage.DELIVERY_DATE_CAN_NOT_BE_A_FUTURE_DATE;
            }

            //Later client told that delivery date can be before admission date
            if (deliveryDate.before(admissionDate)) {
                return Constant.ValidationErrorMessage.DELIVERY_DATE_CAN_NOT_BE_BEFORE_ADDMISSION_DATE;
            }
        }
        return errorMessage;
    }

    public String validateDeliveryBy(String deliveryBy) {
        return null;
    }

    public String validateDeliveryTerm(Integer deliveryTerm) {
        return null;
    }

    public String validateDeliveryType(Integer deliveryType) {
        return null;
    }

    public String validateDexamethasone(Integer deliveryTerm, Boolean dexamethasone) {

        if (deliveryTerm == null) {
            if (dexamethasone != null && dexamethasone) {
                //error message
                return Constant.ValidationErrorMessage.DEXAMETHASON_CAN_NOT_BE_GIVEN;
            }
        } else {
            if (deliveryTerm != Constant.TypeDetails.PRE_TERM_TYPE_DETAIL_ID) {
                if (dexamethasone != null && dexamethasone) {
                    //error message
                    return Constant.ValidationErrorMessage.DEXAMETHASON_CAN_NOT_BE_GIVEN;
                }
            }
        }
        return null;
    }

    public String validateWasCordClampingDelayed(Boolean wasCordClampingDelayed) {
        return null;
    }

    public String validateDrugGivenInThirdStageOfLabor(Integer drugGivenInThirdStageOfLabor) {
        return null;
    }

    public String validateHasGestationalDiabetes(Integer hasGestationalDiabetes) {
        return null;
    }

    public String validateIsInsulinGiven(Integer hasGestationalDM, Boolean isInsulinGiven) {

        if (hasGestationalDM == null) {
            if (isInsulinGiven != null && isInsulinGiven) {
                //error message
                return Constant.ValidationErrorMessage.INSULINE_CAN_NOT_BE_GIVEN;
            }
        } else {
            if (hasGestationalDM != Constant.TypeDetails.GESTATIONAL_YES_TYPE_DETAIL_ID) {
                if (isInsulinGiven != null && isInsulinGiven) {
                    //error message
                    return Constant.ValidationErrorMessage.INSULINE_CAN_NOT_BE_GIVEN;
                }
            }
        }
        return null;
    }

    public String validateHasHypothyroidism(Boolean hasHypothyroidism) {
        return null;
    }

    public String validateIsThyroxineGiven(Integer hasHypothyroidism, Boolean isThyroxineGiven) {

        if (hasHypothyroidism == null) {
            if (isThyroxineGiven != null && isThyroxineGiven) {
                //error message
                return Constant.ValidationErrorMessage.THYROXINE_CAN_NOT_BE_GIVEN;
            }
        } else {
            if (hasHypothyroidism != Constant.TypeDetails.HYPOTHYRODISM_YES_TYPE_DETAIL_ID) {
                if (isThyroxineGiven != null && isThyroxineGiven) {
                    //error message
                    return Constant.ValidationErrorMessage.THYROXINE_CAN_NOT_BE_GIVEN;
                }
            }
        }
        return null;
    }

    public String validatehasEclampsia(Boolean hasEclampsia) {
        return null;
    }

    public String validatIsTreatedWithMagsulf(Boolean hasEclampsia, Boolean isTreatedWithMagsulf) {

        if ((hasEclampsia != null && !hasEclampsia && isTreatedWithMagsulf != null && isTreatedWithMagsulf) ||
                (hasEclampsia == null && isTreatedWithMagsulf != null && isTreatedWithMagsulf)) {
            return Constant.ValidationErrorMessage.MAGSULF_CAN_NOT_BE_GIVEN;
        }
        return null;
    }

    /**
     * The following method will validate all the children given by the user
     *
     * @param children List of children given by user
     * @return String Error message if any, otherwise null
     */
    public String validateChild(List<ChildModel> children) {

        int i = 1;
        for (ChildModel child : children) {


            //No validation for sex

            //Weight validation
            String result = validateChildrenWeightMaxMin(child.getChildWeight());
            if (result != null) {
                return result + " (child " + i + ")";
            }


            if (child.getIsStillBirth() != null) {


                //Can be still birth
                //Can be live birth
                if (child.getIsStillBirth()) {

                    //Still birth

                    //still birth type validation
                    //It doesn't matter here, if the user gives the value, not gives the value,
                    //Gives true value, false value

                    //IsChildBreastFedInHour validation
                    if (child.getIsChildBreastFedInHour() != null &&
                            child.getIsChildBreastFedInHour()) {
                        //This condition is for user has given value of breast feed and the value is true
                        //Which is not possible in case of still birth
                        return Constant.ValidationErrorMessage.CAN_NOT_BREAST_FEED
                                + " (child " + i + ")";
                    }


                    //HasNeededRescusition validation
                    if (child.getHasNeededRescusition() != null &&
                            child.getHasNeededRescusition()) {
                        //This condition is for user has given value of HasNeededRescusition and the value is true
                        //Which is not possible in case of still birth
                        return Constant.ValidationErrorMessage.CAN_NOT_GIVE_VALUE_OF_HAS_NEEDED_RESCUSITION
                                + " (child " + i + ")";
                    }

                    //HasBCGGiven validation
                    if (child.getIsBCGGiven() != null &&
                            child.getIsBCGGiven()) {
                        //This condition is for user has given value of IsBCGGiven and the value is true
                        //Which is not possible in case of still birth
                        return Constant.ValidationErrorMessage.CAN_NOT_GIVE_VALUE_OF_IS_BCG_GIVEN
                                + " (child " + i + ")";
                    }

                    //IsZeroOPVGiven validation
                    if (child.getIsZeroOPVGiven() != null &&
                            child.getIsZeroOPVGiven()) {
                        //This condition is for user has given value of IsZeroOPVGiven and the value is true
                        //Which is not possible in case of still birth
                        return Constant.ValidationErrorMessage.CAN_NOT_GIVE_VALUE_OF_IS_ZERO_OPV_GIVEN
                                + " (child " + i + ")";
                    }

                    //IsHepBZeroGiven validation
                    if (child.getIsHepBZeroGiven() != null &&
                            child.getIsHepBZeroGiven()) {
                        //This condition is for user has given value of IsHepBZeroGiven and the value is true
                        //Which is not possible in case of still birth
                        return Constant.ValidationErrorMessage.CAN_NOT_GIVE_VALUE_OF_HEP_B_ZERO
                                + " (child " + i + ")";
                    }

                    //IsVitaminKGiven validation
                    if (child.getIsVitaminKGiven() != null &&
                            child.getIsVitaminKGiven()) {
                        //This condition is for user has given value of IsVitaminKGiven and the value is true
                        //Which is not possible in case of still birth
                        return Constant.ValidationErrorMessage.CAN_NOT_GIVE_VALUE_OF_VITAMIN_K
                                + " (child " + i + ")";
                    }

                } else {
                    //live birth

                    //still birth type validation
                    //If live birth, we can not give still birth type
                    if (child.getStillBirthType() != null) {
                        return Constant.ValidationErrorMessage.CAN_NOT_GIVE_STILL_BIRTH_TYPE
                                + " (child " + i + ")";
                    }


                    //HasNeededRescusition validation
                    //It doesn't matter here, if the user gives the value, not gives the value,
                    //Gives true value, false value

                    //IsChildBreastFedInHour validation
                    //It doesn't matter here, if the user gives the value, not gives the value,
                    //Gives true value, false value

                    //HasNeededRescusition validation
                    //It doesn't matter here, if the user gives the value, not gives the value,
                    //Gives true value, false value

                    //HasBCGGiven validation
                    //It doesn't matter here, if the user gives the value, not gives the value,
                    //Gives true value, false value

                    //IsZeroOPVGiven validation
                    //It doesn't matter here, if the user gives the value, not gives the value,
                    //Gives true value, false value


                    //IsHepBZeroGiven validation
                    //It doesn't matter here, if the user gives the value, not gives the value,
                    //Gives true value, false value


                    //IsVitaminKGiven validation
                    //It doesn't matter here, if the user gives the value, not gives the value,
                    //Gives true value, false value
                }
            } else {

                //If the control is coming to this block child still birth must be null
                //Here it can not be still birth and can not be live birth too
                if (child.getStillBirthType() != null) {
                    return Constant.ValidationErrorMessage.CAN_NOT_GIVE_STILL_BIRTH_TYPE
                            + " (child " + i + ")";
                }
            }
            i++;
        }
        return null;
    }

    public String validateChildrenCount(Integer childrenCount) {
        if (childrenCount != null) {
            if (childrenCount > CHILDREN_COUNT || childrenCount < 0) {
                return "Number of children can not be more than 3 or less than 0";
            }
        }
        return null;
    }

    public String validateChildrenWeightMaxMin(Float childWeight) {
        if (childWeight != null) {
            if (childWeight > CHILD_WEIGHT_MAX || childWeight < CHILD_WEIGHT_MIN) {
                return "Child weight can not be more than " + CHILD_WEIGHT_MAX + " or less than " + CHILD_WEIGHT_MIN;
            }
        }
        return null;

    }

    public String validateIsBloodTransfusion(Boolean bloodTransfusion) {
        return null;
    }

    public String validateNoOfPints(Boolean bloodTransfusion, Integer noOfPints) {

        if (bloodTransfusion == null) {
            if (noOfPints != null) {
                //error message
                return Constant.ValidationErrorMessage.PINT_CAN_NOT_BE_GIVEN;
            }
        } else {
            if (!bloodTransfusion) {
                if (noOfPints != null) {
                    //error message
                    return Constant.ValidationErrorMessage.PINT_CAN_NOT_BE_GIVEN;
                }
            } else {
                if (noOfPints != null) {
                    if (noOfPints < 1) {
                        //can not less than error msg
                        return Constant.ValidationErrorMessage.NO_OF_PINTS_CAN_NOT_LESS_THAN;
                    }
                    if (noOfPints > 50) {
                        //can not more than error msg
                        return Constant.ValidationErrorMessage.NO_OF_PINTS_CAN_NOT_MORE_THAN;
                    }
                }
            }
        }
        return null;
    }

    public String validateIsPpiucdInserted(Boolean ppiucdInserted) {
        return null;
    }

    public String validateIsIFAStarted(Boolean ifaStarted) {
        return null;
    }

    public String validateIsCalciumVitD3Started(Boolean isCalciumVitaminD3Started) {
        return null;
    }

    public String validateTypeOfJSY(Integer typeOfJSY) {
        return null;
    }


    //Mother status check

    public String validateMotherStatus(Integer motherStatus) {
        return null;
    }

    public String validateDischargeDate(Integer motherStatus, Date dischargeDate, Date admissionDate, Date deliveryDate) {
        if (motherStatus != null && motherStatus != Constant.TypeDetails.MOTHER_STATUS_DISCHARGED_TYPE_DETAIL_ID && dischargeDate != null
                || motherStatus == null && dischargeDate != null) {
            return Constant.ValidationErrorMessage.MOTHER_IS_NOT_DISCHARGED_DISCHARGEDATE_CAN_NOT_GIVEN;
        } else if (motherStatus != null && motherStatus == Constant.TypeDetails.MOTHER_STATUS_DISCHARGED_TYPE_DETAIL_ID && dischargeDate != null) {

            Calendar c = Calendar.getInstance();
            Date current_date = c.getTime();

            if (dischargeDate.after(current_date)) {
                return Constant.ValidationErrorMessage.DISCHARGEDATE_CAN_NOT_BE_A_FUTURE_DATE;
            }
            if (deliveryDate != null) {
                if (dischargeDate.before(deliveryDate)) {
                    return Constant.ValidationErrorMessage.DISCHARGEDATE_CAN_NOT_BE_BEFORE_DELIVERY_DATE;
                }
            } else {
                if (dischargeDate.before(admissionDate)) {
                    return Constant.ValidationErrorMessage.DISCHARGEDATE_CAN_NOT_BE_BEFORE_ADDMISSION_DATE;
                }
            }
        }
        return null;
    }

    public String validateTransportToHome(Integer motherStatus, Integer transportToHome) {
        if (motherStatus != null && motherStatus != MOTHER_STATUS_DISCHARGED_TYPE_DETAIL_ID && transportToHome != null
                || motherStatus == null && transportToHome != null) {
            return Constant.ValidationErrorMessage.MOTHER_IS_NOT_DISCHARGED_TRNASPORT_TO_HOME_CAN_NOT_GIVEN;
        }
        return null;
    }

    public String validateReferredDateAndTime(Integer motherStatus, Date referredDateAndTime, Date admissionDate, Date deliveryDate) {
        if (motherStatus != null && motherStatus != MOTHER_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID && referredDateAndTime != null
                || motherStatus == null && referredDateAndTime != null) {
            return Constant.ValidationErrorMessage.MOTHER_IS_NOT_REFERRED_TRNASPORT_TO_HOME_CAN_NOT_GIVEN;
        } else if (motherStatus != null && motherStatus == MOTHER_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID && referredDateAndTime != null) {
            Calendar c = Calendar.getInstance();
            Date current_date = c.getTime();

            if (referredDateAndTime.after(current_date)) {
                return Constant.ValidationErrorMessage.REFERRED_DATE_CAN_NOT_BE_A_FUTURE_DATE;
            }
            if (deliveryDate != null) {
                if (referredDateAndTime.before(deliveryDate)) {
                    return Constant.ValidationErrorMessage.MOTHER_REFERRED_DATE_CAN_NOT_BE_BEFORE_DELIVERY_DATE;
                }
            } else {
                if (referredDateAndTime.before(admissionDate)) {
                    return Constant.ValidationErrorMessage.REFERRED_DATE_CAN_NOT_BE_BEFORE_ADDMISSION_DATE;
                }
            }
        }
        return null;
    }

    public String validateReferredBy(Integer motherStatus, String referredBy) {

        if (motherStatus != null && motherStatus != MOTHER_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID && referredBy != null ||
                motherStatus == null && referredBy != null) {
            if (!referredBy.trim().equals("")) {
                return Constant.ValidationErrorMessage.MOTHER_IS_NOT_REFERRED_REFERRED_BY_CAN_NOT_GIVEN;
            }
        }
        return null;
    }

    public String validateReferredCause(Integer motherStatus, Integer referredCause) {

        if (motherStatus != null && motherStatus != MOTHER_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID && referredCause != null
                || motherStatus == null && referredCause != null) {
            if (referredCause != null) {
                return "Patient is not referred so referred cause can not be given";
            }
        }
        return null;

    }

    public String validateReferredCauseOther(Integer motherStatus, Integer referredCause, String otherReferredCause) {

        if (motherStatus != null && motherStatus != MOTHER_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID && referredCause != null
                || motherStatus == null && referredCause != null) {
            if (referredCause != null) {
                if (referredCause != Constant.TypeDetails.MOTHER_REFERRED_OTHER_TYPE_DETAIL_ID && otherReferredCause.trim().equals("")) {
                    return Constant.ValidationErrorMessage.MOTHER_REFERRED_CAUSE_OTHER_CAN_NOT_BE_EMPTY;
                }
            }
        }
        return null;

    }

    public String validateReferredTransport(Integer motherStatus, Integer referredTransport) {
        if (motherStatus != null && motherStatus != MOTHER_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID && referredTransport != null
                || motherStatus == null && referredTransport != null) {
            return Constant.ValidationErrorMessage.MOTHER_IS_NOT_REFERRED_VEHICLE_USED_FOR_TRANSPORT_CAN_NOT_GIVEN;
        }
        return null;
    }

    public String validateReferredArea(Integer motherStatus, Integer referredArea) {

        if (motherStatus != null && motherStatus != MOTHER_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID && referredArea != null
                || motherStatus == null && referredArea != null) {
            return Constant.ValidationErrorMessage.MOTHER_IS_NOT_REFERRED_FACILITY_TO_WHICH_REFERRED_CAN_NOT_GIVEN;
        }
        return null;
    }

    public String validatePatientDeathDateAndTime(Integer motherStatus, Date deathDate, Date admissionDate, Date deliveryDate) {


        //death date can not be less that admission date and greater than today
        if (motherStatus != null) {
            if (motherStatus == MOTHER_STATUS_DEATH_TYPE_DETAIL_ID) {
                if (deathDate != null) {
                    if (deathDate.compareTo(new Date()) > 0) {
                        return Constant.ValidationErrorMessage.DEATH_DATE_CAN_NOT_BE_A_FUTURE_DATE;
                    }
                    if (deathDate.before(admissionDate)){
                        return Constant.ValidationErrorMessage.DEATH_DATE_CAN_NOT_BE_BEFORE_ADDMISSION_DATE;
                    }
                }
            } else {
                if (deathDate != null) {
                    return Constant.ValidationErrorMessage.MOTHER_IS_NOT_DEAD_DEATHDATE_CAN_NOT_GIVEN;
                }
            }

        } else {
            if (deathDate != null) {
                return Constant.ValidationErrorMessage.MOTHER_IS_NOT_DEAD_DEATHDATE_CAN_NOT_GIVEN;
            }
        }
        return null;

    }

    public String validatePatientDeathCause(Integer motherStatus, Integer patientDeathCause) {

        if (motherStatus != null && motherStatus != MOTHER_STATUS_DEATH_TYPE_DETAIL_ID && patientDeathCause != null
                || motherStatus == null && patientDeathCause != null) {
            if (patientDeathCause != null) {
                return Constant.ValidationErrorMessage.MOTHER_IS_NOT_DEAD_SO_DEATH_CAUSE_CAN_NOT_BE_PROVIDED;
            }
        }
        return null;
    }

    public String validatePatientLamaDate(Integer motherStatus, Date lamaDate, Date admissionDate, Date deliveryDate) {
        if (motherStatus != null && motherStatus != MOTHER_STATUS_LAMA_TYPE_DETAIL_ID && lamaDate != null
                || motherStatus == null && lamaDate != null) {
            return Constant.ValidationErrorMessage.MOTHER_IS_NOT_LAMA_SO_LAMA_DATE_CAN_NOT_BE_PROVIDED;
        } else if (motherStatus != null && motherStatus == MOTHER_STATUS_LAMA_TYPE_DETAIL_ID && lamaDate != null) {
            Calendar c = Calendar.getInstance();
            Date current_date = c.getTime();

            if (lamaDate.after(current_date)) {
                return Constant.ValidationErrorMessage.LAMA_DATE_CAN_NOT_BE_A_FUTURE_DATE;
            }
            if (deliveryDate != null) {
                if (lamaDate.before(deliveryDate)) {
                    return Constant.ValidationErrorMessage.MOTHER_LAMA_DATE_CAN_NOT_BE_BEFORE_DELIVERY_DATE;
                }
            } else {
                if (lamaDate.before(admissionDate)) {
                    return Constant.ValidationErrorMessage.LAMA_DATE_CAN_NOT_BE_BEFORE_ADDMISSION_DATE;
                }
            }
        }
        return null;
    }

    //Child status check

    public String validateChildStatus(Integer childStatus) {
        return null;
    }

    public String validateChildDischargeDate(Integer childStatus, Date dischargeDate, Date admissionDate, Date deliveryDate) {
        if (childStatus != null && childStatus != CHILD_STATUS_DISCHARGED_TYPE_DETAIL_ID && dischargeDate != null
                || childStatus == null && dischargeDate != null) {
            return "Child is not discharged so discharge date can not be given";
        } else if (childStatus != null && childStatus == CHILD_STATUS_DISCHARGED_TYPE_DETAIL_ID && dischargeDate != null) {

            Calendar c = Calendar.getInstance();
            Date current_date = c.getTime();

            if (dischargeDate.after(current_date)) {
                return "Discharge date can not be a future date";
            }
            if (deliveryDate != null) {
                if (dischargeDate.before(deliveryDate)) {
                    return "Discharge date can not be before delivery date";
                }
            } else {
                return "Delivery date should be given before giving child discharge date";
            }
        }
        return null;
    }

    public String validateChildTransportToHome(Integer childStatus, Integer transportToHome) {
        if (childStatus != null && childStatus != CHILD_STATUS_DISCHARGED_TYPE_DETAIL_ID && transportToHome != null
                || childStatus == null && transportToHome != null) {
            return "Child is not discharged so transport to home can not be applicable";
        }
        return null;
    }

    public String validateChildReferredDateAndTime(Integer childStatus, Date referredDateAndTime, Date deliveryDate) {
        if (childStatus != null && childStatus != CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID && referredDateAndTime != null
                || childStatus == null && referredDateAndTime != null) {
            return "Child is not referred so referred date not be given";
        } else if (childStatus != null && childStatus == CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID && referredDateAndTime != null) {
            Calendar c = Calendar.getInstance();
            Date current_date = c.getTime();

            if (referredDateAndTime.after(current_date)) {
                return "Referal date can not be a future date";
            }
            if (deliveryDate != null) {
                if (referredDateAndTime.before(deliveryDate)) {
                    return "Referal date can not be before delivery date";
                }
            } else {
                return "Delivery date should be given before giving child Referal date";
            }
        }
        return null;
    }

    public String validateChildReferredBy(Integer childStatus, String referredBy) {

        if (childStatus != null && childStatus != CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID && referredBy != null
                || childStatus == null && referredBy != null) {
            if (!referredBy.trim().equals("")) {
                return "Child is not referred so referred by can not be given";
            }
        }
        return null;
    }

    public String validateChildReferredCause(Integer childStatus, Integer referredCause) {

        if (childStatus != null && childStatus != CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID && referredCause != null
                || childStatus == null && referredCause != null) {
            if (referredCause != null) {
                return "Child is not referred so referred cause can not be given";
            }
        }
        return null;

    }

    public String validateChildReferredTransport(Integer childStatus, Integer referredTransport) {
        if (childStatus != null && childStatus != CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID && referredTransport != null
                || childStatus == null && referredTransport != null) {
            return "Child is not referred so referred transport vehicle can not be given";
        }
        return null;
    }

    public String validateChildReferredArea(Integer childStatus, Integer referredArea) {

        if (childStatus != null && childStatus != CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID && referredArea != null
                || childStatus == null && referredArea != null) {
            return "Child is not referred so referred area can not be given";
        }
        return null;
    }

    public String validateChildDeathDateAndTime(Integer childStatus, Date deathDate, Date deliveryDate) {

        //death date can not be less that admission date and greater than today
        if (childStatus != null) {
            if (childStatus == CHILD_STATUS_DEATH_TYPE_DETAIL_ID) {
                if (deathDate != null) {
                    if (deathDate.compareTo(new Date()) > 0) {
                        return "Death date can not be future date";
                    }
                    if (deliveryDate != null) {
                        if (deathDate.before(deliveryDate)) {
                            return "Death date can not be before delivery date";
                        }
                    } else {
                        return "Delivery date should be given before giving child Death date";
                    }
                }
            } else {
                if (deathDate != null) {
                    return "Child is not dead so death date can not be provided";
                }
            }

        } else {
            if (deathDate != null) {
                return "Child is not dead so death date can not be provided";
            }
        }
        return null;

    }

    public String validateChildDeathCause(Integer childStatus, Integer childDeathCause) {

        if (childStatus != null && childStatus != CHILD_STATUS_DEATH_TYPE_DETAIL_ID && childDeathCause != null
                || childStatus == null && childDeathCause != null) {
            if (childDeathCause != null) {
                return "Child is not dead so death cause can not be given";
            }
        }
        return null;
    }

    public String validateChildLamaDate(Integer childStatus, Date lamaDate, Date deliveryDate) {
        if (childStatus != null && childStatus != CHILD_STATUS_LAMA_TYPE_DETAIL_ID && lamaDate != null
                || childStatus == null && lamaDate != null) {
            return "Child status is not LAMA so lamaDate can not be given";
        } else if (childStatus != null && childStatus == CHILD_STATUS_LAMA_TYPE_DETAIL_ID && lamaDate != null) {
            Calendar c = Calendar.getInstance();
            Date current_date = c.getTime();

            if (lamaDate.after(current_date)) {
                return "LAMA date can not be a future date";
            }
            if (deliveryDate != null) {
                if (lamaDate.before(deliveryDate)) {
                    return "LAMA date can not be before delivery date";
                }
            } else {
                return "LAMA date should be given before giving child Death date";
            }
        }
        return null;
    }

    public Float validateFloat(Float aFloat) {
        if (aFloat != null) {
            return (int) (aFloat * 10) / 10f;
        }
        return null;
    }


    /**
     * Validate for required feilds for closing a record
     * @param status
     * @param patient
     * @return error message
     */
    public String validateMotherStatusFeilds(Integer status, PatientModel patient) {
        if (status != null) {
            switch (status) {
                case MOTHER_STATUS_DISCHARGED_TYPE_DETAIL_ID:
                    if (patient.getDischargeDateAndTime() == null) {
                        return Constant.ValidationErrorMessage.GIVE_DISCHARGE_DATE_AND_TIME;
                    } else if (patient.getTransportToHome() == null) {
                        return Constant.ValidationErrorMessage.GIVE_VEHICLE_USED_FOR_TRANSPORT;
                    } else {
                        return null;
                    }
                case MOTHER_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID:
                    if (patient.getReferredDateAndTime() == null) {
                        return Constant.ValidationErrorMessage.GIVE_REFERRED_DATE_AND_TIME;
                    } else if (patient.getReferredBy() == null) {
                        return Constant.ValidationErrorMessage.GIVE_NAME_OF_DOCTOR_DOING_REFERRAL;
                    } else if (patient.getReferredBy() != null && patient.getReferredBy().trim().equals("")) {
                        return Constant.ValidationErrorMessage.GIVE_NAME_OF_DOCTOR_DOING_REFERRAL;
                    } else if (patient.getReferredCause() == null) {
                        return Constant.ValidationErrorMessage.GIVE_REFERRED_CAUSE;
                    } else if (patient.getReferredCause() != null && patient.getReferredCause() == Constant.TypeDetails.MOTHER_REFERRED_OTHER_TYPE_DETAIL_ID && patient.getOtherReferredCause() == null) {
                        return Constant.ValidationErrorMessage.GIVE_OTHER_REFERRED_CAUSE;
                    } else if (patient.getReferredCause() != null && patient.getReferredCause() == Constant.TypeDetails.MOTHER_REFERRED_OTHER_TYPE_DETAIL_ID && patient.getOtherReferredCause() != null && patient.getOtherReferredCause().trim().equals("")) {
                        return Constant.ValidationErrorMessage.GIVE_OTHER_REFERRED_CAUSE;
                    } else if (patient.getReferredTransport() == null) {
                        return Constant.ValidationErrorMessage.GIVE_VEHICLE_USE_FOR_TRANSPORT;
                    } else if (patient.getReferredAreaId() == null) {
                        return Constant.ValidationErrorMessage.GIVE_FACILITY_TO_WHICH_REFERRED;
                    } else if (patient.getReferredAreaId() != null && patient.getReferredAreaId() == Constant.TypeDetails.OTHER_REFERRED_FACILITY_MOTHER_TYPE_DETAILS_ID && patient.getOtherReferredAreaId() == null) {
                        return Constant.ValidationErrorMessage.GIVE_OTHER_FACILITY_TO_WHICH_REFERRED;
                    } else if (patient.getReferredAreaId() != null && patient.getReferredAreaId() == Constant.TypeDetails.OTHER_REFERRED_FACILITY_MOTHER_TYPE_DETAILS_ID && patient.getOtherReferredAreaId() != null && patient.getOtherReferredAreaId().trim().equals("")) {
                        return Constant.ValidationErrorMessage.GIVE_OTHER_FACILITY_TO_WHICH_REFERRED;
                    } else {
                        return null;
                    }
                case MOTHER_STATUS_DEATH_TYPE_DETAIL_ID:
                    if (patient.getPatientDeathCause() == null) {
                        return Constant.ValidationErrorMessage.GIVE_DEATH_CAUSE;
                    } else if (patient.getPatientDeathCause() != null && patient.getPatientDeathCause() == Constant.TypeDetails.OTHER_DEATH_CAUSE_MOTHER_TYPE_DETAILS_ID && patient.getOtherPatientDeathCause() == null) {
                        return Constant.ValidationErrorMessage.GIVE_OTHER_DEATH_CAUSE;
                    } else if (patient.getPatientDeathCause() != null && patient.getPatientDeathCause() == Constant.TypeDetails.OTHER_DEATH_CAUSE_MOTHER_TYPE_DETAILS_ID && patient.getOtherPatientDeathCause() != null && patient.getOtherPatientDeathCause().trim().equals("")) {
                        return Constant.ValidationErrorMessage.GIVE_OTHER_DEATH_CAUSE;
                    } else if (patient.getPatientDeathDateAndTime() == null) {
                        return Constant.ValidationErrorMessage.GIVE_DEATH_DATE_AND_TIME;
                    } else {
                        return null;
                    }
                case MOTHER_STATUS_LAMA_TYPE_DETAIL_ID:
                    if (patient.getLamaDateAndTime() == null) {
                        return Constant.ValidationErrorMessage.GIVE_LAMA_DATE_AND_TIME;
                    } else {
                        return null;
                    }
                default:
                    return null;
            }
        } else {
            return null;
        }
    }

    public String validateOtherReferredCause(Integer motherStatus, String otherReferredCause) {
        return null;
    }

    public String validateOtherReferredArea(Integer motherStatus, String otherReferredAreaId) {
        return null;
    }

    public String validateOtherPatientDeathCause(Integer motherStatus, String otherPatientDeathCause) {
        return null;
    }

    public String validateLamaDateAndTime(Integer motherStatus, Date lamaDateAndTime, Date admissionDateAndTime) {
        return null;
    }


    /**
     * The following method will validate all the children status given by the user
     *
     * @param childrenStatus List of children status given by user
     * @param deliveryDate   Date of delivery
     * @param admissionDate  Date of admission
     * @return String Error message if any, otherwise null
     */
    public String validateChildStaus(List<ChildStatusModel> childrenStatus,
                                     Date deliveryDate, Date admissionDate) {

        int i = 1;
        for (ChildStatusModel childStatusModel : childrenStatus) {

            //making case for statuses
            if (childStatusModel.getStatus() != null) {

                switch (childStatusModel.getStatus()) {

                    //Discharged
                    case CHILD_STATUS_DISCHARGED_TYPE_DETAIL_ID:
                        //discharge date can not be less than delivery date
                        if (deliveryDate != null) {
                            if (childStatusModel.getDischargeDateAndTime() != null) {
                                if (childStatusModel.getDischargeDateAndTime().before(deliveryDate)) {
                                    return Constant.ValidationErrorMessage.DISCHARGED_DATE_CAN_NOT_BE_BEFORE_DELIVERY_DATE +
                                            " (child " + i + ")";
                                }
                            }
                        } else {
                            return Constant.ValidationErrorMessage.DELIVERY_DATE_NOT_GIVEN;
                        }


                        String result = validateChildrenWeightMaxMin(childStatusModel.getDischargeWeight());
                        if (result != null) {
                            return result + " (child " + i + ")";
                        }

                        //Other status values should be null
                        if (childStatusModel.getReferredDateAndTime() != null) {
                            return Constant.ValidationErrorMessage.STATUS_DISCHARGED_REFERRED_DATE_CAN_NOT_BE_GIVEN +
                                    " (child " + i + ")";
                        }
                        if (childStatusModel.getReferredBy() != null) {
                            return Constant.ValidationErrorMessage.STATUS_DISCHARGED_REFERRED_BY_CAN_NOT_BE_GIVEN +
                                    " (child " + i + ")";
                        }
                        if (childStatusModel.getReferredCause() != null) {
                            return Constant.ValidationErrorMessage.STATUS_DISCHARGED_REFERRED_CAUSE_CAN_NOT_BE_GIVEN +
                                    " (child " + i + ")";
                        }
                        if (childStatusModel.getOtherReferredCause() != null) {
                            return Constant.ValidationErrorMessage.STATUS_DISCHARGED_OTHER_REFERRED_CAUSE_CAN_NOT_BE_GIVEN +
                                    " (child " + i + ")";
                        }
                        if (childStatusModel.getReferredTo() != null) {
                            return Constant.ValidationErrorMessage.STATUS_DISCHARGED_REFERRED_TO_CAN_NOT_BE_GIVEN +
                                    " (child " + i + ")";
                        }
                        if (childStatusModel.getOtherReferredTo() != null) {
                            return Constant.ValidationErrorMessage.STATUS_DISCHARGED_OTHER_REFERRED_TO_CAN_NOT_BE_GIVEN +
                                    " (child " + i + ")";
                        }

                        if (childStatusModel.getReferredTransport() != null) {
                            return Constant.ValidationErrorMessage.STATUS_DISCHARGED_REFERRED_TRANSPORT_CAN_NOT_BE_GIVEN +
                                    " (child " + i + ")";
                        }

                        if (childStatusModel.getLamaDateAndTime() != null) {
                            return Constant.ValidationErrorMessage.STATUS_DISCHARGED_LAMA_DATE_CAN_NOT_BE_GIVEN +
                                    " (child " + i + ")";
                        }

                        if (childStatusModel.getDeathDateAndTime() != null) {
                            return Constant.ValidationErrorMessage.STATUS_DISCHARGED_DEATH_DATE_CAN_NOT_BE_GIVEN +
                                    " (child " + i + ")";
                        }

                        if (childStatusModel.getDeathCause() != null) {
                            return Constant.ValidationErrorMessage.STATUS_DISCHARGED_DEATH_CAUSE_CAN_NOT_BE_GIVEN +
                                    " (child " + i + ")";
                        }
                        break;

                    //Referred
                    case CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID:
                        //Referred date can not be less than delivery date
                        if (deliveryDate != null) {
                            if (childStatusModel.getReferredDateAndTime() != null) {
                                if (childStatusModel.getReferredDateAndTime().before(deliveryDate)) {
                                    return Constant.ValidationErrorMessage.REFERRED_DATE_CAN_NOT_BE_BEFORE_DELIVERY_DATE +
                                            " (child " + i + ")";
                                }
                            }
                        } else {
                            return Constant.ValidationErrorMessage.DELIVERY_DATE_NOT_GIVEN;
                        }

                        //Validation other referred cause
                        // If referred cause is not "other", otherReferredCause value should be null.
                        if (childStatusModel.getReferredCause() != null &&
                                childStatusModel.getReferredCause() != OTHER_REFERRED_CAUSE_CHILD_TYPE_DETAILS_ID) {
                            if (childStatusModel.getOtherReferredCause() != null) {
                                return CHILD_OTHER_REFERRED_CAUSE_CAN_NOT_BE_GIVEN
                                        + " (child " + i + ")";
                            }
                        }

                        //Similar for referred to
                        if (childStatusModel.getReferredTo() != null &&
                                childStatusModel.getReferredTo() != OTHER_REFERRED_TO_CHILD_TYPE_DETAILS_ID) {
                            if (childStatusModel.getOtherReferredTo() != null) {
                                return CHILD_OTHER_REFERRED_TO_CAN_NOT_BE_GIVEN
                                        + " (child " + i + ")";
                            }
                        }


                        //Other status values should be null
                        if (childStatusModel.getDischargeDateAndTime() != null) {
                            return Constant.ValidationErrorMessage.STATUS_REFERRED_DISCHARGE_DATE_CAN_NOT_BE_GIVEN +
                                    " (child " + i + ")";
                        }

                        if (childStatusModel.getDischargeWeight() != null) {
                            return Constant.ValidationErrorMessage.STATUS_REFERRED_DISCHARGE_WEIGHT_CAN_NOT_BE_GIVEN +
                                    " (child " + i + ")";
                        }

                        if (childStatusModel.getTransportToHome() != null) {
                            return Constant.ValidationErrorMessage.STATUS_REFERRED_TRANSPORT_TO_HOME_CAN_NOT_BE_GIVEN +
                                    " (child " + i + ")";
                        }

                        if (childStatusModel.getLamaDateAndTime() != null) {
                            return Constant.ValidationErrorMessage.STATUS_REFERRED_LAMA_DATE_CAN_NOT_BE_GIVEN +
                                    " (child " + i + ")";
                        }

                        if (childStatusModel.getDeathDateAndTime() != null) {
                            return Constant.ValidationErrorMessage.STATUS_REFERRED_DEATH_DATE_CAN_NOT_BE_GIVEN +
                                    " (child " + i + ")";
                        }

                        if (childStatusModel.getDeathCause() != null) {
                            return Constant.ValidationErrorMessage.STATUS_REFERRED_DEATH_CAUSE_CAN_NOT_BE_GIVEN +
                                    " (child " + i + ")";
                        }
                        break;

                    //Dead
                    case CHILD_STATUS_DEATH_TYPE_DETAIL_ID:
                        //Death date can not be less than delivery date
                        if (deliveryDate != null) {
                            if (childStatusModel.getDeathDateAndTime() != null) {
                                if (childStatusModel.getDeathDateAndTime().before(deliveryDate)) {
                                    return Constant.ValidationErrorMessage.DEATH_DATE_CAN_NOT_BE_BEFORE_DELIVERY_DATE +
                                            " (child " + i + ")";
                                }
                            }
                        } else {
                            return Constant.ValidationErrorMessage.DELIVERY_DATE_NOT_GIVEN;
                        }

                        //Other status values should be null
                        if (childStatusModel.getDischargeDateAndTime() != null) {
                            return Constant.ValidationErrorMessage.STATUS_DEATH_DISCHARGE_DATE_CAN_NOT_BE_GIVEN +
                                    " (child " + i + ")";
                        }

                        if (childStatusModel.getDischargeWeight() != null) {
                            return Constant.ValidationErrorMessage.STATUS_DEATH_DISCHARGE_WEIGHT_CAN_NOT_BE_GIVEN +
                                    " (child " + i + ")";
                        }
                        if (childStatusModel.getTransportToHome() != null) {
                            return Constant.ValidationErrorMessage.STATUS_DEATH_TRANSPORT_TO_HOME_CAN_NOT_BE_GIVEN +
                                    " (child " + i + ")";
                        }
                        if (childStatusModel.getReferredDateAndTime() != null) {
                            return Constant.ValidationErrorMessage.STATUS_DEATH_REFERRED_DATE_CAN_NOT_BE_GIVEN +
                                    " (child " + i + ")";
                        }
                        if (childStatusModel.getReferredBy() != null) {
                            return Constant.ValidationErrorMessage.STATUS_DEATH_REFERRED_BY_CAN_NOT_BE_GIVEN +
                                    " (child " + i + ")";
                        }
                        if (childStatusModel.getReferredCause() != null) {
                            return Constant.ValidationErrorMessage.STATUS_DEATH_REFERRED_CAUSE_CAN_NOT_BE_GIVEN +
                                    " (child " + i + ")";
                        }
                        if (childStatusModel.getOtherReferredCause() != null) {
                            return Constant.ValidationErrorMessage.STATUS_DEATH_OTHER_REFERRED_CAUSE_CAN_NOT_BE_GIVEN +
                                    " (child " + i + ")";
                        }
                        if (childStatusModel.getReferredTo() != null) {
                            return Constant.ValidationErrorMessage.STATUS_DEATH_REFERRED_TO_CAN_NOT_BE_GIVEN +
                                    " (child " + i + ")";
                        }
                        if (childStatusModel.getOtherReferredTo() != null) {
                            return Constant.ValidationErrorMessage.STATUS_DEATH_OTHER_REFERRED_TO_CAN_NOT_BE_GIVEN +
                                    " (child " + i + ")";
                        }

                        if (childStatusModel.getReferredTransport() != null) {
                            return Constant.ValidationErrorMessage.STATUS_DEATH_REFERRED_TRANSPORT_CAN_NOT_BE_GIVEN +
                                    " (child " + i + ")";
                        }

                        if (childStatusModel.getLamaDateAndTime() != null) {
                            return Constant.ValidationErrorMessage.STATUS_DEATH_LAMA_DATE_CAN_NOT_BE_GIVEN +
                                    " (child " + i + ")";
                        }
                        break;

                    //LAMA
                    case CHILD_STATUS_LAMA_TYPE_DETAIL_ID:
                        //LAMA date can not be less than delivery date
                        if (deliveryDate != null) {
                            if (childStatusModel.getLamaDateAndTime() != null) {
                                if (childStatusModel.getLamaDateAndTime().before(deliveryDate)) {
                                    return Constant.ValidationErrorMessage.LAMA_DATE_CAN_NOT_BE_BEFORE_DELIVERY_DATE +
                                            " (child " + i + ")";
                                }
                            }
                        } else {
                            return Constant.ValidationErrorMessage.DELIVERY_DATE_NOT_GIVEN;
                        }
                        //Other status values should be null
                        if (childStatusModel.getDischargeDateAndTime() != null) {
                            return Constant.ValidationErrorMessage.STATUS_LAMA_DISCHARGE_DATE_CAN_NOT_BE_GIVEN +
                                    " (child " + i + ")";
                        }

                        if (childStatusModel.getDischargeWeight() != null) {
                            return Constant.ValidationErrorMessage.STATUS_LAMA_DISCHARGE_WEIGHT_CAN_NOT_BE_GIVEN +
                                    " (child " + i + ")";
                        }
                        if (childStatusModel.getTransportToHome() != null) {
                            return Constant.ValidationErrorMessage.STATUS_LAMA_TRANSPORT_TO_HOME_CAN_NOT_BE_GIVEN +
                                    " (child " + i + ")";
                        }
                        if (childStatusModel.getReferredDateAndTime() != null) {
                            return Constant.ValidationErrorMessage.STATUS_LAMA_REFERRED_DATE_CAN_NOT_BE_GIVEN +
                                    " (child " + i + ")";
                        }
                        if (childStatusModel.getReferredBy() != null) {
                            return Constant.ValidationErrorMessage.STATUS_LAMA_REFERRED_BY_CAN_NOT_BE_GIVEN +
                                    " (child " + i + ")";
                        }
                        if (childStatusModel.getReferredCause() != null) {
                            return Constant.ValidationErrorMessage.STATUS_LAMA_REFERRED_CAUSE_CAN_NOT_BE_GIVEN +
                                    " (child " + i + ")";
                        }
                        if (childStatusModel.getOtherReferredCause() != null) {
                            return Constant.ValidationErrorMessage.STATUS_LAMA_OTHER_REFERRED_CAUSE_CAN_NOT_BE_GIVEN +
                                    " (child " + i + ")";
                        }
                        if (childStatusModel.getReferredTo() != null) {
                            return Constant.ValidationErrorMessage.STATUS_LAMA_REFERRED_TO_CAN_NOT_BE_GIVEN +
                                    " (child " + i + ")";
                        }
                        if (childStatusModel.getOtherReferredTo() != null) {
                            return Constant.ValidationErrorMessage.STATUS_LAMA_OTHER_REFERRED_TO_CAN_NOT_BE_GIVEN +
                                    " (child " + i + ")";
                        }

                        if (childStatusModel.getReferredTransport() != null) {
                            return Constant.ValidationErrorMessage.STATUS_LAMA_REFERRED_TRANSPORT_CAN_NOT_BE_GIVEN +
                                    " (child " + i + ")";
                        }
                        if (childStatusModel.getDeathDateAndTime() != null) {
                            return Constant.ValidationErrorMessage.STATUS_LAMA_DEATH_DATE_CAN_NOT_BE_GIVEN +
                                    " (child " + i + ")";
                        }

                        if (childStatusModel.getDeathCause() != null) {
                            return Constant.ValidationErrorMessage.STATUS_LAMA_DEATH_CAUSE_CAN_NOT_BE_GIVEN +
                                    " (child " + i + ")";
                        }
                        break;
                    default:
                        break;
                }


            } else {
                //nothing can be given, everything should be null
                if (childStatusModel.getDischargeDateAndTime() != null) {
                    return Constant.ValidationErrorMessage.CHILD_STATUS_NOT_GIVEN_CAN_NOT_GIVE + " discharge date" +
                            " (child " + i + ")";
                }

                if (childStatusModel.getDischargeWeight() != null) {
                    return Constant.ValidationErrorMessage.CHILD_STATUS_NOT_GIVEN_CAN_NOT_GIVE + " discharge weight" +
                            " (child " + i + ")";
                }
                if (childStatusModel.getTransportToHome() != null) {
                    return Constant.ValidationErrorMessage.CHILD_STATUS_NOT_GIVEN_CAN_NOT_GIVE + " vehicle to home by " +
                            " (child " + i + ")";
                }
                if (childStatusModel.getReferredDateAndTime() != null) {
                    return Constant.ValidationErrorMessage.CHILD_STATUS_NOT_GIVEN_CAN_NOT_GIVE + " referred date" +
                            " (child " + i + ")";
                }
                if (childStatusModel.getReferredBy() != null) {
                    return Constant.ValidationErrorMessage.CHILD_STATUS_NOT_GIVEN_CAN_NOT_GIVE + " referred by" +
                            " (child " + i + ")";
                }
                if (childStatusModel.getReferredCause() != null) {
                    return Constant.ValidationErrorMessage.CHILD_STATUS_NOT_GIVEN_CAN_NOT_GIVE + " referred cause" +
                            " (child " + i + ")";
                }
                if (childStatusModel.getOtherReferredCause() != null) {
                    return Constant.ValidationErrorMessage.CHILD_STATUS_NOT_GIVEN_CAN_NOT_GIVE + " other referred cause" +
                            " (child " + i + ")";
                }
                if (childStatusModel.getReferredTo() != null) {
                    return Constant.ValidationErrorMessage.CHILD_STATUS_NOT_GIVEN_CAN_NOT_GIVE + " referred to" +
                            " (child " + i + ")";
                }
                if (childStatusModel.getOtherReferredTo() != null) {
                    return Constant.ValidationErrorMessage.CHILD_STATUS_NOT_GIVEN_CAN_NOT_GIVE + " other referred to" +
                            " (child " + i + ")";
                }

                if (childStatusModel.getReferredTransport() != null) {
                    return Constant.ValidationErrorMessage.CHILD_STATUS_NOT_GIVEN_CAN_NOT_GIVE + " referred vehicle" +
                            " (child " + i + ")";
                }

                if (childStatusModel.getLamaDateAndTime() != null) {
                    return Constant.ValidationErrorMessage.CHILD_STATUS_NOT_GIVEN_CAN_NOT_GIVE + " LAMA date" +
                            " (child " + i + ")";
                }

                if (childStatusModel.getDeathDateAndTime() != null) {
                    return Constant.ValidationErrorMessage.CHILD_STATUS_NOT_GIVEN_CAN_NOT_GIVE + " death date" +
                            " (child " + i + ")";
                }

                if (childStatusModel.getDeathCause() != null) {
                    return Constant.ValidationErrorMessage.CHILD_STATUS_NOT_GIVEN_CAN_NOT_GIVE + " death cause" +
                            " (child " + i + ")";
                }
            }
            i++;
        }
        return null;
    }
}
