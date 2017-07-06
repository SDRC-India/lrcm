package org.sdrc.lrcasemanagement.util;

/**
 * Created by Ratikanta Pradhan (ratikanta@sdrc.co.in) on 31-01-2017.
 */

public class Constant {
    public static boolean CLEAR_DATA_TAPPED = false;

    public class Result {


        public static final int SUCCESS = 1;
        public static final int NO_INTERNET = 2;
        public static final int ERROR = 3;
        public static final int SERVER_ERROR = 4;
        public static final int INVALID_CREDENTIALS = 5;
        public static final int PATIENT_EXISTS = 6;
        public static final int REQUEST_TIMEOUT = 7;
        public static final int NO_DATA_TO_SYNC = 8;
        public static final int SYNC_STARTED = 9;
        public static final int NO_IMEI = 10;
    }
    public class Type{
        public static final int GENDER_TYPE_ID = 1;
        public static final int CAST_TYPE_ID = 2;
        public static final int APL_BPL_TYPE_ID = 3;
        public static final int URINE_ALBUMINE_TYPE_ID = 21;
        public static final int URINE_SUGAR_TYPE_ID = 22;
        public static final int DELIVERY_TYPE_TYPE_ID = 4;
        public static final int VDRL_TYPE_ID = 5;
        public static final int SICKLING_TYPE_ID = 6;
        public static final int HIV_TEST_TYPE_ID = 7;
        public static final int BLOOD_GROUP_TYPE_ID = 8;
        public static final int TRANSPORT_TYPE_ID = 9;
        public static final int DELIVERY_TERM_TYPE_ID = 10;
        public static final int JSY_FUND_TYPE_TYPE_ID = 11;
        public static final int RH_TYPE_ID = 12;
        public static final int STILL_BIRTH_TYPE_ID = 14;
        public static final int MOTHER_STATUS_TYPE_ID = 15;
        public static final int MOTHER_REFERRED_CAUSE_TYPE_ID = 25;
        public static final int MOTHER_REFERRED_FACILITY_TYPE_ID = 26;
        public static final int MOTHER_DEATH_CAUSE_TYPE_ID = 27;
        public static final int CHILD_STATUS_TYPE_ID = 16;
        public static final int CHILD_REFERRED_CAUSE_TYPE_ID = 28;
        public static final int CHILD_REFERRED_FACILITY_TYPE_ID = 29;
        public static final int THIRD_STAGE_DRUG_TYPE_TYPE_ID = 17;
        public static final int GESTATIONAL_TYPE_ID = 23;
        public static final int HYPOYHYROIDISM_TYPE_ID = 24;
        public static final int PATIENT_TYPE_ID = 18;
        public static final int REFERRED_TYPE_ID = 19;
        public static final int ANTENATAL_TYPE_ID = 20;
    }

    public class TypeDetails{
        public static final int DELIVERY_TYPE_CSECTION_TYPE_DETAIL_ID = 11;
        public static final int TERM_TYPE_DETAIL_ID = 34;
        public static final int PRE_TERM_TYPE_DETAIL_ID = 35;
        public static final int POST_TERM_TYPE_DETAIL_ID = 36;
        public static final int FRESH_STILL_BIRTH_TYPE_DETAILS_ID = 43;
        public static final int MACERATED_STILL_BIRTH_TYPE_DETAILS_ID = 44;
        public static final int MOTHER_STATUS_DISCHARGED_TYPE_DETAIL_ID = 47;
        public static final int MOTHER_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID = 48;
        public static final int MOTHER_STATUS_DEATH_TYPE_DETAIL_ID = 49;
        public static final int MOTHER_STATUS_LAMA_TYPE_DETAIL_ID = 56;
        public static final int CHILD_STATUS_DISCHARGED_TYPE_DETAIL_ID = 50;
        public static final int CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID = 51;
        public static final int CHILD_STATUS_DEATH_TYPE_DETAIL_ID = 52;
        public static final int CHILD_STATUS_LAMA_TYPE_DETAIL_ID = 57;
        public static final int SEX_MALE_TYPE_DETAIL_ID = 1;
        public static final int SEX_FEMALE_TYPE_DETAIL_ID = 2;
        //doubt
        public static final int SELF_PATIENT_TYPE_DETAIL_ID = 58;
        public static final int REFERRED_PATIENT_TYPE_DETAIL_ID = 59;
        public static final int GESTATIONAL_YES_TYPE_DETAIL_ID = 72;
        public static final int GESTATIONAL_NO_TYPE_DETAIL_ID = 73;
        public static final int GESTATIONAL_DONT_TYPE_DETAIL_ID = 74;
        public static final int HYPOTHYRODISM_YES_TYPE_DETAIL_ID = 75;
        public static final int HYPOTHYRODISM_NO_TYPE_DETAIL_ID = 76;
        public static final int HYPOTHYRODISM_DONT_TYPE_DETAIL_ID = 77;
        public static final int MOTHER_REFERRED_NON_AVAILABILITY_OF_BLOOD_TYPE_DETAIL_ID = 79;
        public static final int MOTHER_REFERRED_NON_AVAILABILITY_OF_CSECTION_TYPE_DETAIL_ID = 80;
        public static final int MOTHER_REFERRED_NON_AVAILABILITY_OF_DOCTOR_TYPE_DETAIL_ID = 81;
        public static final int MOTHER_REFERRED_NON_AVAILABILITY_OF_NURSHING_STAFF_TYPE_DETAIL_ID = 82;
        public static final int MOTHER_REFERRED_NON_AVAILABILITY_OF_DRUG_TYPE_DETAIL_ID = 83;
        public static final int MOTHER_REFERRED_NON_AVAILABILITY_OF_SKILLED_PERSONEL_TYPE_DETAIL_ID = 84;
        //
        public static final int MOTHER_REFERRED_FACILITY_MEDICAL_COLLEGE_TYPE_DETAIL_ID = 86;
        public static final int MOTHER_REFERRED_FACILITY_DH_TYPE_DETAIL_ID = 87;
        public static final int MOTHER_REFERRED_FACILITY_CH_FRU_TYPE_DETAIL_ID = 88;
        public static final int MOTHER_REFERRED_FACILITY_CH_NON_FRU_TYPE_DETAIL_ID = 89;
        public static final int MOTHER_REFERRED_FACILITY_CHC_FRU_TYPE_DETAIL_ID = 90;
        public static final int MOTHER_REFERRED_FACILITY_CHC_NON_FRU_TYPE_DETAIL_ID = 91;
        public static final int MOTHER_REFERRED_FACILITY_PHC_24X7_TYPE_DETAIL_ID = 92;
        public static final int MOTHER_REFERRED_FACILITY_PHC_NON_24X7_TYPE_DETAIL_ID = 93;
        public static final int MOTHER_REFERRED_FACILITY_OTHER_TYPE_DETAIL_ID = 94;

        public static final int MOTHER_DEATH_ANTEPARTUM_HEMORRHAGE_TYPE_DETAIL_ID = 95;
        public static final int MOTHER_DEATH_INTRAPARTUM_HEMORRHAGE_TYPE_DETAIL_ID = 96;
        public static final int MOTHER_DEATH_POSTPARTUM_HEMORRHAGE_TYPE_DETAIL_ID = 97;
        public static final int MOTHER_DEATH_PEURPEREAL_SEPSIS_TYPE_DETAIL_ID = 98;
        public static final int MOTHER_DEATH_ABORTION_TYPE_DETAIL_ID = 99;
        public static final int MOTHER_OBSTRUCTED_LABOUR_TYPE_DETAIL_ID = 100;
        public static final int MOTHER_PREGNENCY_INCLUDED_HYPERTENSION_TYPE_DETAIL_ID = 101;
        public static final int MOTHER_DEATH_SEVER_PREECLAMPSIA_TYPE_DETAIL_ID = 102;
        public static final int MOTHER_DEATH_ECLAMPSIA_TYPE_DETAIL_ID = 103;
        public static final int MOTHER_DEATH_HEART_DEASESES_TYPE_DETAIL_ID = 104;
        public static final int MOTHER_DEATH_CEREBRAL_MALERIA_TYPE_DETAIL_ID = 105;
        public static final int MOTHER_DEATH_INFECTIVE_HYPETITIS_TYPE_DETAIL_ID = 106;
        public static final int MOTHER_DEATH_SICKLE_CELL_DEASESE_TYPE_DETAIL_ID = 107;
        public static final int MOTHER_DEATH_TUBERCULOSIS_TYPE_DETAIL_ID = 108;
        public static final int MOTHER_DEATH_RESPIRATORY_DEASESE_TYPE_DETAIL_ID = 109;
        public static final int MOTHER_DEATH_DRUG_REACTION_TYPE_DETAIL_ID = 110;
        public static final int MOTHER_DEATH_KIDNY_DEASESE_TYPE_DETAIL_ID = 111;
        public static final int MOTHER_DEATH_EMBOLISM_TYPE_DETAIL_ID = 112;
        public static final int MOTHER_DEATH_SEVERE_ANEMIA_TYPE_DETAIL_ID = 113;
        public static final int MOTHER_DEATH_BLOOD_TRANSFUSION_REACTION_TYPE_DETAIL_ID = 114;
        public static final int MOTHER_DEATH_OTHER_TYPE_DETAIL_ID = 115;

        public static final int MOTHER_REFERRED_OTHER_TYPE_DETAIL_ID = 85;
        public static final int OTHER_DEATH_CAUSE_MOTHER_TYPE_DETAILS_ID = 115;
        public static final int OTHER_REFERRED_FACILITY_MOTHER_TYPE_DETAILS_ID = 94;

        public static final int OTHER_REFERRED_CAUSE_CHILD_TYPE_DETAILS_ID = 121;
        public static final int OTHER_REFERRED_TO_CHILD_TYPE_DETAILS_ID = 130;
        public static final int STILL_BIRTH_TYPE_DETAILS_ID = 131;

    }

    public class AreaLevel {
        public static final int COUNTRY = 1;
        public static final int STATE = 2;
        public static final int DISTRICT = 3;
        public static final int BLOCK = 4;
    }

    public class ValidationErrorMessage {
        public static final String ENTER_PROPER_SERIAL_NO_AND_ADMISSION_DATE = "Please enter proper serial no. and admission date";
        public static final String SERIAL_NO_CAN_NOT_BE_GREATER_THAN_THREE_DIGITS = "Serial no. can not be greater than three digits";
        public static final String SERIAL_NO_CAN_NOT_BE_LESS_THAN_ONE = "Serial no. can not be less than 1";
        public static final String SERIAL_NO_CAN_NOT_BE_DUPLICATE = "Serial no. can not be duplicate for a month";
        public static final String ADMISSION_DATE_CAN_NOT_BE_FUTURE_DATE = "Admission date can not be future date";
        public static final String ADMISSION_DATE_CAN_NOT_BE_BLANK = "Admission date can not be blank";
        public static final String TYPE_OF_REFERRED_FACILITY_CAN_NOT_BE_GIVEN = "Type of referred facility can not be given";
        public static final String NAME_OF_REFERRED_FACILITY_CAN_NOT_BE_GIVEN = "Type of referred facility can not be given";
        public static final String PATIENT_NAME_CAN_NOT_BE_BLANK = "Patient name can not be blank";
        public static final String CAN_NOT_GIVE_DETAIL_ADDRESS_WITHOUT_STATE = "Can not give detail address without giving state";
        public static final String CAN_NOT_GIVE_DETAIL_ADDRESS_FOR_CHHATTISGARH_STATE = "Can not give detail address for Chhattisgarh state";


        public static final String CAN_NOT_GIVE_STILL_BIRTH_TYPE = "Can not give still birth type if child is not still birth";
        public static final String CAN_NOT_BREAST_FEED = "It is a still birth so can not breast fed within 1 hour";
        public static final String CAN_NOT_GIVE_VALUE_OF_HAS_NEEDED_RESCUSITION = "It is a still birth so child can not Rescusited";
        public static final String CAN_NOT_GIVE_VALUE_OF_IS_BCG_GIVEN = "It is a still birth so child can not be given BCG";
        public static final String CAN_NOT_GIVE_VALUE_OF_IS_ZERO_OPV_GIVEN = "It is a still birth so child can not be given Zero OPV";
        public static final String CAN_NOT_GIVE_VALUE_OF_HEP_B_ZERO = "It is a still birth so child can not be given Hep B Zero";
        public static final String CAN_NOT_GIVE_VALUE_OF_VITAMIN_K = "It is a still birth so child can not be given Vitamin K";
        public static final String STATUS_DISCHARGED_REFERRED_DATE_CAN_NOT_BE_GIVEN = "Child status is discharged, referred date can not be given";
        public static final String STATUS_DISCHARGED_REFERRED_BY_CAN_NOT_BE_GIVEN = "Child status is discharged, referred by can not be given";
        public static final String STATUS_DISCHARGED_REFERRED_CAUSE_CAN_NOT_BE_GIVEN = "Child status is discharged, referred cause can not be given";
        public static final String STATUS_DISCHARGED_OTHER_REFERRED_CAUSE_CAN_NOT_BE_GIVEN = "Child status is discharged, other referred cause can not be given";
        public static final String STATUS_DISCHARGED_REFERRED_TO_CAN_NOT_BE_GIVEN = "Child status is discharged, referred to can not be given";
        public static final String STATUS_DISCHARGED_OTHER_REFERRED_TO_CAN_NOT_BE_GIVEN = "Child status is discharged, other referred to can not be given";
        public static final String STATUS_DISCHARGED_REFERRED_TRANSPORT_CAN_NOT_BE_GIVEN = "Child status is discharged, referred transport can not be given";
        public static final String STATUS_DISCHARGED_LAMA_DATE_CAN_NOT_BE_GIVEN = "Child status is discharged, lama date can not be given";
        public static final String STATUS_DISCHARGED_DEATH_DATE_CAN_NOT_BE_GIVEN = "Child status is discharged, death date can not be given";
        public static final String STATUS_DISCHARGED_DEATH_CAUSE_CAN_NOT_BE_GIVEN = "Child status is discharged, death cause can not be given";
        public static final String DISCHARGED_DATE_CAN_NOT_BE_BEFORE_DELIVERY_DATE = "Child discharge date can not be before delivery date";
        public static final String REFERRED_DATE_CAN_NOT_BE_BEFORE_DELIVERY_DATE = "Child referred date can not be before delivery date";
        public static final String REFERRED_DATE_CAN_NOT_BE_BEFORE_ADMISSION_DATE = "Child referred date can not be before delivery date";
        public static final String STATUS_REFERRED_DISCHARGE_DATE_CAN_NOT_BE_GIVEN = "Child status is referred, discharge date can not be given";
        public static final String STATUS_REFERRED_DISCHARGE_WEIGHT_CAN_NOT_BE_GIVEN = "Child status is referred, discharge weight can not be given";
        public static final String STATUS_REFERRED_LAMA_DATE_CAN_NOT_BE_GIVEN = "Child status is referred, lama date can not be given";
        public static final String STATUS_REFERRED_TRANSPORT_TO_HOME_CAN_NOT_BE_GIVEN = "Child status is referred, transport to home can not be given";
        public static final String STATUS_REFERRED_DEATH_DATE_CAN_NOT_BE_GIVEN = "Child status is referred, death date can not be given";
        public static final String STATUS_REFERRED_DEATH_CAUSE_CAN_NOT_BE_GIVEN = "Child status is referred, death cause can not be given";
        public static final String STATUS_DEATH_DISCHARGE_DATE_CAN_NOT_BE_GIVEN = "Child status is death, discharge date can not be given";
        public static final String STATUS_DEATH_DISCHARGE_WEIGHT_CAN_NOT_BE_GIVEN = "Child status is death, discharge weight can not be given";
        public static final String STATUS_DEATH_TRANSPORT_TO_HOME_CAN_NOT_BE_GIVEN = "Child status is death, transport to home can not be given";
        public static final String STATUS_DEATH_REFERRED_DATE_CAN_NOT_BE_GIVEN = "Child status is death, referred date can not be given";
        public static final String STATUS_DEATH_REFERRED_BY_CAN_NOT_BE_GIVEN = "Child status is death, referred by can not be given";
        public static final String STATUS_DEATH_REFERRED_CAUSE_CAN_NOT_BE_GIVEN = "Child status is death, referred cause can not be given";
        public static final String STATUS_DEATH_OTHER_REFERRED_CAUSE_CAN_NOT_BE_GIVEN = "Child status is death, other referred cause can not be given";
        public static final String STATUS_DEATH_REFERRED_TO_CAN_NOT_BE_GIVEN = "Child status is death, referred to can not be given";
        public static final String STATUS_DEATH_OTHER_REFERRED_TO_CAN_NOT_BE_GIVEN = "Child status is death, other referred to can not be given";
        public static final String STATUS_DEATH_REFERRED_TRANSPORT_CAN_NOT_BE_GIVEN = "Child status is death, referred transport can not be given";
        public static final String STATUS_DEATH_LAMA_DATE_CAN_NOT_BE_GIVEN = "Child status is death, lama date can not be given";
        public static final String DEATH_DATE_CAN_NOT_BE_BEFORE_DELIVERY_DATE = "Child death date can not be before delivery date";
        public static final String STATUS_LAMA_DISCHARGE_DATE_CAN_NOT_BE_GIVEN = "Child status is LAMA, discharge date can not be given";
        public static final String STATUS_LAMA_DISCHARGE_WEIGHT_CAN_NOT_BE_GIVEN = "Child status is LAMA, discharge weight can not be given";
        public static final String STATUS_LAMA_TRANSPORT_TO_HOME_CAN_NOT_BE_GIVEN = "Child status is LAMA, transport to home can not be given";
        public static final String STATUS_LAMA_REFERRED_DATE_CAN_NOT_BE_GIVEN = "Child status is LAMA, referred date can not be given";
        public static final String STATUS_LAMA_REFERRED_BY_CAN_NOT_BE_GIVEN = "Child status is LAMA, referred by can not be given";
        public static final String STATUS_LAMA_REFERRED_CAUSE_CAN_NOT_BE_GIVEN = "Child status is LAMA, referred cause can not be given";
        public static final String STATUS_LAMA_OTHER_REFERRED_CAUSE_CAN_NOT_BE_GIVEN = "Child status is LAMA, other referred cause can not be given";
        public static final String STATUS_LAMA_REFERRED_TO_CAN_NOT_BE_GIVEN = "Child status is LAMA, referred to can not be given";
        public static final String STATUS_LAMA_OTHER_REFERRED_TO_CAN_NOT_BE_GIVEN = "Child status is LAMA, other referred to can not be given";
        public static final String STATUS_LAMA_REFERRED_TRANSPORT_CAN_NOT_BE_GIVEN = "Child status is LAMA, referred transport can not be given";
        public static final String STATUS_LAMA_DEATH_DATE_CAN_NOT_BE_GIVEN = "Child status is LAMA, death date can not be given";
        public static final String STATUS_LAMA_DEATH_CAUSE_CAN_NOT_BE_GIVEN = "Child status is LAMA, death cause can not be given";
        public static final String LAMA_DATE_CAN_NOT_BE_BEFORE_DELIVERY_DATE = "Child LAMA date can not be before delivery date";
        public static final String DELIVERY_DATE_NOT_GIVEN = "Delivery date not given";
        public static final String CHILD_OTHER_REFERRED_CAUSE_CAN_NOT_BE_GIVEN = "Child other referred cause can not be given because the referred cause is not other";
        public static final String CHILD_OTHER_REFERRED_TO_CAN_NOT_BE_GIVEN = "Child other referred to can not be given because the referred to is not other";
        public static final String CAN_NOT_GIVE_DISTRICT_WITHOUT_STATE = "Can not give district without giving state";
        public static final String CAN_NOT_GIVE_BLOCK_WITHOUT_STATE = "Can not give block without giving state";
        public static final String CAN_NOT_GIVE_VILLAGE_WITHOUT_STATE = "Can not give village without giving state";
        public static final String INVALID_MOBILE_NO = "Invalid mobile no";
        public static final String AGE_CAN_NOT_BE_LESS_THAN = "Patient age should not less than 10";
        public static final String AGE_CAN_NOT_BE_MORE_THAN = "Patient age should not more than 49";
        public static final String NO_OF_NORMAL_DELIVERIES_CAN_NOT_BE_LESS_THAN = "Number of Normal deliveries should not less than 0";
        public static final String NO_OF_NORMAL_DELIVERIES_CAN_NOT_BE_MORE_THAN = "Number of Normal deliveries should not more than 10";
        public static final String NO_OF_ASSISTED_DELIVERIES_CAN_NOT_BE_LESS_THAN = "Number of Assisted deliveries should not less than 0";
        public static final String NO_OF_ASSISTED_DELIVERIES_CAN_NOT_BE_MORE_THAN = "Number of Assisted deliveries should not more than 10";
        public static final String NO_OF_CSECTION_DELIVERIES_CAN_NOT_BE_LESS_THAN = "Number of C Section deliveries should not less than 0";
        public static final String NO_OF_CSECTION_DELIVERIES_CAN_NOT_BE_MORE_THAN = "Number of C Section deliveries should not more than 4";
        public static final String NO_OF_LIVE_CHILD_CAN_NOT_BE_LESS_THAN = "Number of Live child should not less than 0";
        public static final String NO_OF_LIVE_CHILD_CAN_NOT_BE_MORE_THAN = "Number of Live child should not more than 10";
        public static final String NO_OF_STILL_BIRTH_CAN_NOT_BE_LESS_THAN = "Number of still birth should not less than 0";
        public static final String NO_OF_STILL_BIRTH_CAN_NOT_BE_MORE_THAN = "Number of still birth should not more than 10";
        public static final String INVALID_PREVIOUS_DELIVERY_INFORMATION_FOR_CHILDREN = "Invalid previous delivery information for children";
        public static final String NO_OF_ABORTION_CAN_NOT_BE_LESS_THAN = "Number of Abortion should not less than 0";
        public static final String NO_OF_ABORTION_BIRTH_CAN_NOT_BE_MORE_THAN = "Number of Abortion should not more than 10";
        public static final String NO_OF_ANTENATAL_CHECKUPS_CAN_NOT_BE_LESS_THAN = "Number of Antenatal Chuckups should not less than 0";
        public static final String NO_OF_ANTENATAL_CHECKUPS_CAN_NOT_BE_MORE_THAN = "Number of Antenatal Chuckups should not more than 20";
        public static final String ANTENATAL_CHECKUPS_DONE_BY_CAN_NOT_GIVEN = "Antenatal Chuckups done by can not given";
        public static final String BP_SYSTOLIC_CAN_NOT_BE_LESS_THAN = "Bp systolic can not less than 0";
        public static final String BP_SYSTOLIC_CAN_NOT_BE_MORE_THAN = "Bp systolic can not greater than 300";
        public static final String BP_DIASTOLIC_CAN_NOT_BE_LESS_THAN = "Bp Diastolic can not less than 0";
        public static final String BP_DIASTOLIC_CAN_NOT_BE_MORE_THAN = "Bp Diastolic can not greater than 200";
        public static final String PULSE_RATE_CAN_NOT_BE_LESS_THAN = "Pulse rate per minute should not less than 0";
        public static final String PULSE_RATE_CAN_NOT_BE_MORE_THAN = "Pulse rate per minute should not more than 120";
        public static final String REPIRATORY_RATE_CAN_NOT_BE_LESS_THAN = "Respiratory rate per minute should not less than 0";
        public static final String REPIRATORY_RATE_CAN_NOT_BE_MORE_THAN = "Respiratory rate per minute should not more than 50";
        public static final String HEART_RATE_CAN_NOT_BE_LESS_THAN = "Heart rate can not less than 0";
        public static final String HEART_RATE_CAN_NOT_BE_MORE_THAN = "Heart rate can not greater than 220";
        public static final String CERVICAL_DILATATION_CAN_NOT_BE_LESS_THAN = "Cervical dilatation in cm can not less than 0";
        public static final String CERVICAL_DILATATION_CAN_NOT_BE_MORE_THAN = "Cervical dilatation in cm can not greater than 10";
        public static final String PARTOGRAPH_CAN_NOT_BE_GIVEN = "Is partograph started can not given";
        public static final String BLOOD_SUGAR_FASTING_CAN_NOT_BE_GIVEN = "Blood sugar fasting can not given";
        public static final String BLOOD_SUGAR_FASTING_CAN_NOT_BE_LESS_THAN = "Boold sugar fasting can not be less than 1";
        public static final String BLOOD_SUGAR_FASTING_CAN_NOT_BE_MORE_THAN = "Boold sugar fasting can not be more than 700";
        public static final String BLOOD_SUGAR_POSTMEAL_CAN_NOT_BE_GIVEN = "Blood sugar postmeal can not given";
        public static final String BLOOD_SUGAR_POSTMEAL_CAN_NOT_BE_LESS_THAN = "Boold sugar postmeal can not be less than 1";
        public static final String BLOOD_SUGAR_POSTMEAL_CAN_NOT_BE_MORE_THAN = "Boold sugar postmeal can not be more than 700";
        public static final String BLOOD_SUGAR_RANDOM_CAN_NOT_BE_GIVEN = "Blood sugar random can not given";
        public static final String BLOOD_SUGAR_RANDOM_CAN_NOT_BE_LESS_THAN = "Boold sugar random can not be less than 1";
        public static final String BLOOD_SUGAR_RANDOM_CAN_NOT_BE_MORE_THAN = "Boold sugar random can not be more than 700";
        public static final String DELIVERY_DATE_CAN_NOT_BE_A_FUTURE_DATE = "Delivery date can not be a future date";
        public static final String DELIVERY_DATE_CAN_NOT_BE_BEFORE_ADDMISSION_DATE = "Delivery date should not before addmission date";
        public static final String DEXAMETHASON_CAN_NOT_BE_GIVEN = "It is not a preterm delivery so dexamethasone cant not be given";
        public static final String INSULINE_CAN_NOT_BE_GIVEN = "Insulin can not be given because patient did not have Gestational DM";
        public static final String THYROXINE_CAN_NOT_BE_GIVEN = "Thyroxine can not be given because patient did not have Hypothyroidism";
        public static final String MAGSULF_CAN_NOT_BE_GIVEN = "Magsulf can not be given because patient did not have Eclampsia";
        public static final String PINT_CAN_NOT_BE_GIVEN = "NO of pints can not be given because patient has not given ant blood transfusion";
        public static final String NO_OF_PINTS_CAN_NOT_LESS_THAN = "Number of pints should not less than 1";
        public static final String NO_OF_PINTS_CAN_NOT_MORE_THAN = "Number of pints should not more than 50";
        public static final String MOTHER_REFERRED_CAUSE_OTHER_CAN_NOT_BE_EMPTY = "Other referred cause can not be given";
        public static final String MOTHER_IS_NOT_DISCHARGED_DISCHARGEDATE_CAN_NOT_GIVEN = "Patient is not discharged so discharge date can not be given";
        public static final String DISCHARGEDATE_CAN_NOT_BE_A_FUTURE_DATE = "Discharge date can not be a future date";
        public static final String DISCHARGEDATE_CAN_NOT_BE_BEFORE_DELIVERY_DATE = "Discharge date can not be before delivery date";
        public static final String DISCHARGEDATE_CAN_NOT_BE_BEFORE_ADDMISSION_DATE = "Discharge date can not be before admission date";
        public static final String MOTHER_IS_NOT_DISCHARGED_TRNASPORT_TO_HOME_CAN_NOT_GIVEN = "Patient is not discharged so transport to home can not be applicable";
        public static final String MOTHER_IS_NOT_REFERRED_TRNASPORT_TO_HOME_CAN_NOT_GIVEN = "Patient is not discharged so transport to home can not be applicable";
        public static final String REFERRED_DATE_CAN_NOT_BE_A_FUTURE_DATE = "Referal date can not be a future date";
        public static final String MOTHER_REFERRED_DATE_CAN_NOT_BE_BEFORE_DELIVERY_DATE = "Referal date can not be before delivery date";
        public static final String REFERRED_DATE_CAN_NOT_BE_BEFORE_ADDMISSION_DATE = "Referal date can not be before admission date";
        public static final String MOTHER_IS_NOT_REFERRED_REFERRED_BY_CAN_NOT_GIVEN = "Patient is not referred so name of doctor doing referral can not be given";
        public static final String MOTHER_IS_NOT_REFERRED_VEHICLE_USED_FOR_TRANSPORT_CAN_NOT_GIVEN = "Patient is not referred so vehicle use for transport can not given";
        public static final String MOTHER_IS_NOT_REFERRED_FACILITY_TO_WHICH_REFERRED_CAN_NOT_GIVEN = "Patient is not referred so facility to which referred can not given";
        public static final String MOTHER_IS_NOT_DEAD_DEATHDATE_CAN_NOT_GIVEN = "Mother is not dead so death date can not be provided";
        public static final String DEATH_DATE_CAN_NOT_BE_A_FUTURE_DATE = "Death date can not be future date";
        //public static final String MOTHER_DEATH_DATE_CAN_NOT_BE_BEFORE_DELIVERY_DATE = "Death date can not be before delivery date";
        public static final String DEATH_DATE_CAN_NOT_BE_BEFORE_ADDMISSION_DATE = "Death date can not be before admission date";
        public static final String MOTHER_IS_NOT_DEAD_SO_DEATH_CAUSE_CAN_NOT_BE_PROVIDED = "Mother is not dead so death cause can not be given";
        public static final String MOTHER_IS_NOT_LAMA_SO_LAMA_DATE_CAN_NOT_BE_PROVIDED = "Mother status is not LAMA so LAMA date can not be given";
        public static final String LAMA_DATE_CAN_NOT_BE_A_FUTURE_DATE = "LAMA date can not be a future date";
        public static final String MOTHER_LAMA_DATE_CAN_NOT_BE_BEFORE_DELIVERY_DATE = "LAMA date can not be before delivery date";
        public static final String LAMA_DATE_CAN_NOT_BE_BEFORE_ADDMISSION_DATE = "LAMA date can not be before admission date";
        public static final String CHILD_STATUS_NOT_GIVEN_CAN_NOT_GIVE = "Child status is not given, can not give";

        // requared feild for closing a record
        public static final String GIVE_DISCHARGE_DATE_AND_TIME = "Please give discharge date and time";
        public static final String GIVE_VEHICLE_USED_FOR_TRANSPORT = "Please give vehicle used for transport";
        public static final String GIVE_REFERRED_DATE_AND_TIME = "Please give referred date and time";
        public static final String GIVE_NAME_OF_DOCTOR_DOING_REFERRAL = "Please give Name of the doctor doing referral";
        public static final String GIVE_REFERRED_CAUSE = "Please give referred cause";
        public static final String GIVE_OTHER_REFERRED_CAUSE = "Please mention other referred cause";
        public static final String GIVE_VEHICLE_USE_FOR_TRANSPORT = "Please give vehicle used for transport";
        public static final String GIVE_FACILITY_TO_WHICH_REFERRED = "Please give Facility to which referred";
        public static final String GIVE_OTHER_FACILITY_TO_WHICH_REFERRED = "Please mention other referred facility";
        public static final String GIVE_DEATH_CAUSE = "Please give death cause";
        public static final String GIVE_OTHER_DEATH_CAUSE = "Please mention other death cause";
        public static final String GIVE_DEATH_DATE_AND_TIME = "Please give patient death date and time";
        public static final String GIVE_LAMA_DATE_AND_TIME = "Please give lama date and time";


    }

    public static final int CHILDREN_COUNT = 3;
    public static final int CHILD_WEIGHT_MAX = 10;
    public static final int CHILD_WEIGHT_MIN = 0;
    public static final float CHILD_WEIGHT_FOR_LBW_LIVE_BIRTH = 2.5f;
    public static final float CHILD_WEIGHT_FOR_LBW_STILL_BIRTH = 1;
    public static final String STATE_NAME = "Chhattisgarh";
    //Check the following value database before exporting apk
    public static final int STATE_AREA_ID = 23;
}
