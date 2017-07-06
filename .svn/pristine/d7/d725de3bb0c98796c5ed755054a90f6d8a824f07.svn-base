package org.sdrc.lrcasemanagement.activity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import org.sdrc.lrcasemanagement.asynctask.PatientSaveAsyncTask;
import org.sdrc.lrcasemanagement.customclass.CustomChildInfoLayout;
import org.sdrc.lrcasemanagement.customclass.CustomChildStatusLayout;
import org.sdrc.lrcasemanagement.customclass.CustomEditText;
import org.sdrc.lrcasemanagement.R;
import org.sdrc.lrcasemanagement.listener.PatientSaveListener;
import org.sdrc.lrcasemanagement.model.AsyncTaskResultModel;
import org.sdrc.lrcasemanagement.model.ChildModel;
import org.sdrc.lrcasemanagement.model.ChildStatusModel;
import org.sdrc.lrcasemanagement.model.PatientModel;
import org.sdrc.lrcasemanagement.model.realmmodel.Area;
import org.sdrc.lrcasemanagement.model.realmmodel.Patient;
import org.sdrc.lrcasemanagement.model.realmmodel.Type;
import org.sdrc.lrcasemanagement.model.realmmodel.TypeDetails;
import org.sdrc.lrcasemanagement.util.Constant;
import org.sdrc.lrcasemanagement.util.LRCM;
import org.sdrc.lrcasemanagement.util.Validation;

import io.realm.Realm;
import io.realm.RealmResults;

import static org.sdrc.lrcasemanagement.util.Constant.TypeDetails.CHILD_STATUS_DEATH_TYPE_DETAIL_ID;
import static org.sdrc.lrcasemanagement.util.Constant.TypeDetails.CHILD_STATUS_DISCHARGED_TYPE_DETAIL_ID;
import static org.sdrc.lrcasemanagement.util.Constant.TypeDetails.CHILD_STATUS_LAMA_TYPE_DETAIL_ID;
import static org.sdrc.lrcasemanagement.util.Constant.TypeDetails.CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID;
import static org.sdrc.lrcasemanagement.util.Constant.TypeDetails.GESTATIONAL_DONT_TYPE_DETAIL_ID;
import static org.sdrc.lrcasemanagement.util.Constant.TypeDetails.GESTATIONAL_NO_TYPE_DETAIL_ID;
import static org.sdrc.lrcasemanagement.util.Constant.TypeDetails.GESTATIONAL_YES_TYPE_DETAIL_ID;
import static org.sdrc.lrcasemanagement.util.Constant.TypeDetails.HYPOTHYRODISM_DONT_TYPE_DETAIL_ID;
import static org.sdrc.lrcasemanagement.util.Constant.TypeDetails.HYPOTHYRODISM_NO_TYPE_DETAIL_ID;
import static org.sdrc.lrcasemanagement.util.Constant.TypeDetails.HYPOTHYRODISM_YES_TYPE_DETAIL_ID;
import static org.sdrc.lrcasemanagement.util.Constant.TypeDetails.MOTHER_DEATH_ABORTION_TYPE_DETAIL_ID;
import static org.sdrc.lrcasemanagement.util.Constant.TypeDetails.MOTHER_DEATH_ANTEPARTUM_HEMORRHAGE_TYPE_DETAIL_ID;
import static org.sdrc.lrcasemanagement.util.Constant.TypeDetails.MOTHER_DEATH_BLOOD_TRANSFUSION_REACTION_TYPE_DETAIL_ID;
import static org.sdrc.lrcasemanagement.util.Constant.TypeDetails.MOTHER_DEATH_CEREBRAL_MALERIA_TYPE_DETAIL_ID;
import static org.sdrc.lrcasemanagement.util.Constant.TypeDetails.MOTHER_DEATH_DRUG_REACTION_TYPE_DETAIL_ID;
import static org.sdrc.lrcasemanagement.util.Constant.TypeDetails.MOTHER_DEATH_ECLAMPSIA_TYPE_DETAIL_ID;
import static org.sdrc.lrcasemanagement.util.Constant.TypeDetails.MOTHER_DEATH_EMBOLISM_TYPE_DETAIL_ID;
import static org.sdrc.lrcasemanagement.util.Constant.TypeDetails.MOTHER_DEATH_HEART_DEASESES_TYPE_DETAIL_ID;
import static org.sdrc.lrcasemanagement.util.Constant.TypeDetails.MOTHER_DEATH_INFECTIVE_HYPETITIS_TYPE_DETAIL_ID;
import static org.sdrc.lrcasemanagement.util.Constant.TypeDetails.MOTHER_DEATH_INTRAPARTUM_HEMORRHAGE_TYPE_DETAIL_ID;
import static org.sdrc.lrcasemanagement.util.Constant.TypeDetails.MOTHER_DEATH_KIDNY_DEASESE_TYPE_DETAIL_ID;
import static org.sdrc.lrcasemanagement.util.Constant.TypeDetails.MOTHER_DEATH_OTHER_TYPE_DETAIL_ID;
import static org.sdrc.lrcasemanagement.util.Constant.TypeDetails.MOTHER_DEATH_PEURPEREAL_SEPSIS_TYPE_DETAIL_ID;
import static org.sdrc.lrcasemanagement.util.Constant.TypeDetails.MOTHER_DEATH_POSTPARTUM_HEMORRHAGE_TYPE_DETAIL_ID;
import static org.sdrc.lrcasemanagement.util.Constant.TypeDetails.MOTHER_DEATH_RESPIRATORY_DEASESE_TYPE_DETAIL_ID;
import static org.sdrc.lrcasemanagement.util.Constant.TypeDetails.MOTHER_DEATH_SEVERE_ANEMIA_TYPE_DETAIL_ID;
import static org.sdrc.lrcasemanagement.util.Constant.TypeDetails.MOTHER_DEATH_SEVER_PREECLAMPSIA_TYPE_DETAIL_ID;
import static org.sdrc.lrcasemanagement.util.Constant.TypeDetails.MOTHER_DEATH_SICKLE_CELL_DEASESE_TYPE_DETAIL_ID;
import static org.sdrc.lrcasemanagement.util.Constant.TypeDetails.MOTHER_DEATH_TUBERCULOSIS_TYPE_DETAIL_ID;
import static org.sdrc.lrcasemanagement.util.Constant.TypeDetails.MOTHER_OBSTRUCTED_LABOUR_TYPE_DETAIL_ID;
import static org.sdrc.lrcasemanagement.util.Constant.TypeDetails.MOTHER_PREGNENCY_INCLUDED_HYPERTENSION_TYPE_DETAIL_ID;
import static org.sdrc.lrcasemanagement.util.Constant.TypeDetails.MOTHER_REFERRED_FACILITY_CHC_FRU_TYPE_DETAIL_ID;
import static org.sdrc.lrcasemanagement.util.Constant.TypeDetails.MOTHER_REFERRED_FACILITY_CHC_NON_FRU_TYPE_DETAIL_ID;
import static org.sdrc.lrcasemanagement.util.Constant.TypeDetails.MOTHER_REFERRED_FACILITY_CH_FRU_TYPE_DETAIL_ID;
import static org.sdrc.lrcasemanagement.util.Constant.TypeDetails.MOTHER_REFERRED_FACILITY_CH_NON_FRU_TYPE_DETAIL_ID;
import static org.sdrc.lrcasemanagement.util.Constant.TypeDetails.MOTHER_REFERRED_FACILITY_DH_TYPE_DETAIL_ID;
import static org.sdrc.lrcasemanagement.util.Constant.TypeDetails.MOTHER_REFERRED_FACILITY_MEDICAL_COLLEGE_TYPE_DETAIL_ID;
import static org.sdrc.lrcasemanagement.util.Constant.TypeDetails.MOTHER_REFERRED_FACILITY_OTHER_TYPE_DETAIL_ID;
import static org.sdrc.lrcasemanagement.util.Constant.TypeDetails.MOTHER_REFERRED_FACILITY_PHC_24X7_TYPE_DETAIL_ID;
import static org.sdrc.lrcasemanagement.util.Constant.TypeDetails.MOTHER_REFERRED_FACILITY_PHC_NON_24X7_TYPE_DETAIL_ID;
import static org.sdrc.lrcasemanagement.util.Constant.TypeDetails.MOTHER_REFERRED_NON_AVAILABILITY_OF_BLOOD_TYPE_DETAIL_ID;
import static org.sdrc.lrcasemanagement.util.Constant.TypeDetails.MOTHER_REFERRED_NON_AVAILABILITY_OF_CSECTION_TYPE_DETAIL_ID;
import static org.sdrc.lrcasemanagement.util.Constant.TypeDetails.MOTHER_REFERRED_NON_AVAILABILITY_OF_DOCTOR_TYPE_DETAIL_ID;
import static org.sdrc.lrcasemanagement.util.Constant.TypeDetails.MOTHER_REFERRED_NON_AVAILABILITY_OF_DRUG_TYPE_DETAIL_ID;
import static org.sdrc.lrcasemanagement.util.Constant.TypeDetails.MOTHER_REFERRED_NON_AVAILABILITY_OF_NURSHING_STAFF_TYPE_DETAIL_ID;
import static org.sdrc.lrcasemanagement.util.Constant.TypeDetails.MOTHER_REFERRED_NON_AVAILABILITY_OF_SKILLED_PERSONEL_TYPE_DETAIL_ID;
import static org.sdrc.lrcasemanagement.util.Constant.TypeDetails.MOTHER_REFERRED_OTHER_TYPE_DETAIL_ID;
import static org.sdrc.lrcasemanagement.util.Constant.TypeDetails.MOTHER_STATUS_DEATH_TYPE_DETAIL_ID;
import static org.sdrc.lrcasemanagement.util.Constant.TypeDetails.MOTHER_STATUS_DISCHARGED_TYPE_DETAIL_ID;
import static org.sdrc.lrcasemanagement.util.Constant.TypeDetails.MOTHER_STATUS_LAMA_TYPE_DETAIL_ID;
import static org.sdrc.lrcasemanagement.util.Constant.TypeDetails.MOTHER_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID;
import static org.sdrc.lrcasemanagement.util.Constant.TypeDetails.OTHER_DEATH_CAUSE_MOTHER_TYPE_DETAILS_ID;
import static org.sdrc.lrcasemanagement.util.Constant.TypeDetails.OTHER_REFERRED_CAUSE_CHILD_TYPE_DETAILS_ID;
import static org.sdrc.lrcasemanagement.util.Constant.TypeDetails.OTHER_REFERRED_FACILITY_MOTHER_TYPE_DETAILS_ID;
import static org.sdrc.lrcasemanagement.util.Constant.TypeDetails.OTHER_REFERRED_TO_CHILD_TYPE_DETAILS_ID;
import static org.sdrc.lrcasemanagement.util.Constant.TypeDetails.POST_TERM_TYPE_DETAIL_ID;
import static org.sdrc.lrcasemanagement.util.Constant.TypeDetails.PRE_TERM_TYPE_DETAIL_ID;
import static org.sdrc.lrcasemanagement.util.Constant.TypeDetails.REFERRED_PATIENT_TYPE_DETAIL_ID;
import static org.sdrc.lrcasemanagement.util.Constant.TypeDetails.SELF_PATIENT_TYPE_DETAIL_ID;
import static org.sdrc.lrcasemanagement.util.Constant.TypeDetails.TERM_TYPE_DETAIL_ID;

/**
 * Created by Jagat Bandhu Sahoo(jagat@sdrc.co.in) on 1/20/2017.
 * Edit by Ratikanta pradhan(ratikanta@sdrc.co.in) on 04/01/2017.
 * Ratikanta has done validation before closing the record
 */

public class PatientActivity extends AppCompatActivity implements PatientSaveListener, View.OnClickListener,
        CompoundButton.OnCheckedChangeListener, View.OnFocusChangeListener, View.OnTouchListener {

    CoordinatorLayout coordinatorLayout;

    CustomEditText facilityName, patientName, patientHusbandName, detailAddress, otherReferredCauseMother, otherDeathCauseMother, otherReferredFacilityMother;

    EditText serialNo, dateTimeAdmission, patientType, referredFacilityType, state, district, block, village, mobileNo, age, cast,
            noOfNormalDelivery, noOfAssistedDelivery, noOfCSectionDelivery, noOfLiveChild, noOfDeathChild, noOfAbortion, noOfAntenatalCheckups,
            antenatalCheckupDoneBy, systolic, diastolic, pulseRate, respiratoryRate, heartBeat, cervicalDilatation, urinAlbumine, urinSugar, fasting, postmeal, random, vdrl, sickling, hivTest, bloodGroup,
            rhType, transportToHospital, deliveryDateTime, deliveryBy, deliveryTerm, deliveryType, drugType, hasGestational, hasHypoyhyroidism, noOfPints, typeOfJsy, statusOfMother,
            dischargeTransportOfMother, referredDateTimeOfMother, referredByOfMother, referredCauseOfMother, referredTransportOfMother, referredAreaOfMother,
            deathCauseOfMother;

    RadioGroup aplBplLayout;
    RadioButton rdBtnApl, rdBtnBpl;

    LinearLayout allquestion, otherState, noOfChildrenLayout, bloodSugarTestsLayout, childListHolder, noOfPintsLayout, childStatusListHolder,
            motherStatusLayout, motherDischargeLayout, motherReferredLayout, motherLamaLayout, motherDeadLayout;

    RelativeLayout anotherChildStatusLayout, patientTypeLayout, detailAddressLayout, antenatalCheckupBoneByLayout, isPartographStartedLayout, anotherChildLayout, dexamethasoneLayout, insulinLayout, thyroxineLayout, magsulfLayout, otherReferredCauseMotherLayout, otherDeathCauseMotherLayout, otherReferredFacilityMotherLayout;

    ToggleButton isPartographStarted, isBloodSugarTestDone, isDexamethansoneGiven, wasCordClampingDelayed, isInsulin, isThyroxine, hasEclampsia, isMagsulf,
            bloodTransfusion, ppiucdInsertion, ifa, calciumVitD3;

    ImageView addChildOne, addChild, deleteChild, addChildStatusOne, addChildStatus, deleteChildStatus;

    ImageView showAdmissionDateAndTime, showDeliveryDateAndTime, showDischargeDateTimeOfMother,
            showReferredDateTimeOfMother, showDeathDateTimeOfMother, showLamaDateTimeOfMother;

    EditText setAddmisionDateAndTime, setDeliveryDateAndTime, dischargeDateTimeOfMother,
            deathDateTimeOfMother, lamaDateTimeOfMother;

    private CustomChildInfoLayout customChildInfoLayoutOne, customChildInfoLayoutTwo, customChildInfoLayoutThree, customChildInfoLayoutFour,
            customChildInfoLayoutFive, customChildInfoLayoutSix, customChildInfoLayoutSeven, customChildInfoLayoutEight,
            customChildInfoLayoutNine, customChildInfoLayoutTen;

    private CustomChildStatusLayout customChildStatusLayoutOne, customChildStatusLayoutTwo, customChildStatusLayoutThree,
            customChildStatusLayoutFour, customChildStatusLayoutFive, customChildStatusLayoutSix, customChildStatusLayoutSeven,
            customChildStatusLayoutEight, customChildStatusLayoutNine, customChildStatusLayoutTen;

    String status, serialNoStr, dateTimeOfAdminStr, patientNameStr;
    private boolean isNoOfChildrenLayoutVisible = false;
    int childCount = 0;
    int childStatusCount = 0;
    boolean deliveryStatusFlag = false;
    boolean motherStatus = false;

    // Variable for storing current date
    private int mYear, mMonth, mDay, mHour, mMinute;

    private FloatingActionButton saveBtn;
    private Boolean saveFlag = true;
    private Boolean childOneFlag = false;
    private Boolean childTwoFlag = false;
    private Boolean childThreeFlag = false;
    private Boolean childFourFlag = false;
    private Boolean childFiveFlag = false;
    private Boolean childSixFlag = false;
    private Boolean childSevenFlag = false;
    private Boolean childEightFlag = false;
    private Boolean childNineFlag = false;
    private Boolean childTenFlag = false;

    private Boolean childStatusOneFlag = false;
    private Boolean childStatusTwoFlag = false;
    private Boolean childStatusThreeFlag = false;
    private Boolean childStatusFourFlag = false;
    private Boolean childStatusFiveFlag = false;
    private Boolean childStatusSixFlag = false;
    private Boolean childStatusSevenFlag = false;
    private Boolean childStatusEightFlag = false;
    private Boolean childStatusNineFlag = false;
    private Boolean childStatusTenFlag = false;

    private PatientModel patientModel;
    private ProgressDialog progressDialog;
    private AlertDialog alertDialog;
    private Validation validation;

    private Map<String, Integer> patientTypeMap;
    private Map<String, Integer> referredTypeMap;
    private Map<String, Integer> genderTypeMap;
    private Map<String, Integer> casteTypeMap;
    private Map<String, Integer> antenatalTypeMap;
    private Map<String, Integer> urineAlbumineTypeMap;
    private Map<String, Integer> urineSugarTypeMap;
    private Map<String, Integer> aPLBPLTypeMap;
    private Map<String, Integer> deliveryTypeTypeMap;
    private Map<String, Integer> vdrlTypeMap;
    private Map<String, Integer> sicklingTypeMap;
    private Map<String, Integer> hivTestTypeMap;
    private Map<String, Integer> bloodGroupTypeMap;
    private Map<String, Integer> rhTypeTypeMap;
    private Map<String, Integer> transportTypeMap;
    private Map<String, Integer> deliveryTermTypeMap;
    private Map<String, Integer> jsyTypeTypeMap;
    private Map<String, Integer> stateMap;
    private Map<String, Integer> referredFacilityMap;
    private Map<String, Integer> referredAreaMap;
    private Map<String, Integer> districtMap;
    private Map<String, Integer> blockMap;
    private Map<String, Integer> motherStatusTypeMap;
    private Map<String, Integer> motherReferredCauseTypeMap;
    private Map<String, Integer> motherDeathCauseTypeMap;
    private Map<String, Integer> childStatusTypeMap;
    private Map<String, Integer> childReferredCauseTypeMap;
    private Map<String, Integer> childReferredFacilityTypeMap;
    private Map<String, Integer> thirdStageDrugTypeMap;
    private Map<String, Integer> gestationalTypeMap;
    private Map<String, Integer> hypoyhyroidismTypeMap;
    private Map<String, Integer> stillBirthTypeMap;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy h:mm a");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(getString(R.string.activity_title_patient));
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );

        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinator_layout);

        saveBtn = (FloatingActionButton) findViewById(R.id.save_btn);
        saveBtn.bringToFront();
        saveBtn.setOnClickListener(this);

        String serialNoTxt = "<font color=#000000>1. Serial no</font><font color=#ff0000>*</font>";
        if (Build.VERSION.SDK_INT >= 24) {
            ((TextView) findViewById(R.id.serial_no_txt)).setText(Html.fromHtml(serialNoTxt, Html.FROM_HTML_MODE_LEGACY));
        } else {
            ((TextView) findViewById(R.id.serial_no_txt)).setText(Html.fromHtml(serialNoTxt));
        }

        String admissionDateTimeTxt = "<font color=#000000>2. Date &amp; time of admission</font><font color=#ff0000>*</font>";
        if (Build.VERSION.SDK_INT >= 24) {
            ((TextView) findViewById(R.id.date_time_of_addmission_txt)).setText(Html.fromHtml(admissionDateTimeTxt, Html.FROM_HTML_MODE_LEGACY));
        } else {
            ((TextView) findViewById(R.id.date_time_of_addmission_txt)).setText(Html.fromHtml(admissionDateTimeTxt));
        }

        String patientNameTxt = "<font color=#000000>4. Patient name(Full name)</font><font color=#ff0000>*</font>";
        if (Build.VERSION.SDK_INT >= 24) {
            ((TextView) findViewById(R.id.patient_name_txt)).setText(Html.fromHtml(patientNameTxt, Html.FROM_HTML_MODE_LEGACY));
        } else {
            ((TextView) findViewById(R.id.patient_name_txt)).setText(Html.fromHtml(patientNameTxt));
        }

        String motherStatusNoteTxt = "<font color=#000000>*Selecting <b>\"Status of mother\"</b> will close this case. </font>";
        if (Build.VERSION.SDK_INT >= 24) {
            ((TextView) findViewById(R.id.mother_status_note)).setText(Html.fromHtml(motherStatusNoteTxt, Html.FROM_HTML_MODE_LEGACY));
        } else {
            ((TextView) findViewById(R.id.mother_status_note)).setText(Html.fromHtml(motherStatusNoteTxt));
        }

        allquestion = (LinearLayout) findViewById(R.id.activity_question);

        serialNo = (EditText) findViewById(R.id.serial_no);
        dateTimeAdmission = (EditText) findViewById(R.id.date_time_of_addmission);
        patientTypeMap = new LinkedHashMap<>();
        referredTypeMap = new LinkedHashMap<>();
        genderTypeMap = new LinkedHashMap<>();
        casteTypeMap = new LinkedHashMap<>();
        antenatalTypeMap = new LinkedHashMap<>();
        urineAlbumineTypeMap = new LinkedHashMap<>();
        urineSugarTypeMap = new LinkedHashMap<>();
        aPLBPLTypeMap = new LinkedHashMap<>();
        deliveryTypeTypeMap = new LinkedHashMap<>();
        vdrlTypeMap = new LinkedHashMap<>();
        sicklingTypeMap = new LinkedHashMap<>();
        hivTestTypeMap = new LinkedHashMap<>();
        bloodGroupTypeMap = new LinkedHashMap<>();
        rhTypeTypeMap = new LinkedHashMap<>();
        transportTypeMap = new LinkedHashMap<>();
        deliveryTermTypeMap = new LinkedHashMap<>();
        jsyTypeTypeMap = new LinkedHashMap<>();
        stateMap = new TreeMap<>();
        referredFacilityMap = new LinkedHashMap<>();
        referredAreaMap = new TreeMap<>();
        districtMap = new TreeMap<>();
        blockMap = new TreeMap<>();
        motherStatusTypeMap = new LinkedHashMap<>();
        motherReferredCauseTypeMap = new LinkedHashMap<>();
        motherDeathCauseTypeMap = new LinkedHashMap<>();
        childStatusTypeMap = new LinkedHashMap<>();
        childReferredCauseTypeMap = new LinkedHashMap<>();
        childReferredFacilityTypeMap = new LinkedHashMap<>();
        thirdStageDrugTypeMap = new LinkedHashMap<>();
        gestationalTypeMap = new LinkedHashMap<>();
        hypoyhyroidismTypeMap = new LinkedHashMap<>();
        stillBirthTypeMap = new LinkedHashMap<>();

        setAddmisionDateAndTime = (EditText) findViewById(R.id.date_time_of_addmission);
        showAdmissionDateAndTime = (ImageView) findViewById(R.id.show_admission_date_time);
        setAddmisionDateAndTime.setOnClickListener(this);
        showAdmissionDateAndTime.setOnClickListener(this);

        patientType = (EditText) findViewById(R.id.patien_type);
        patientType.setOnTouchListener(this);
        patientType.setInputType(0);
        patientType.setOnFocusChangeListener(this);
        patientTypeLayout = (RelativeLayout) findViewById(R.id.patient_type_layout);
        referredFacilityType = (EditText) findViewById(R.id.referred_facility_type);
        referredFacilityType.setOnTouchListener(this);
        referredFacilityType.setInputType(0);
        referredFacilityType.setOnFocusChangeListener(this);
        facilityName = (CustomEditText) findViewById(R.id.facility_name);

        patientName = (CustomEditText) findViewById(R.id.patient_name);
        patientHusbandName = (CustomEditText) findViewById(R.id.patient_husband_name);

        detailAddressLayout = (RelativeLayout) findViewById(R.id.detail_address_layout);

        state = (EditText) findViewById(R.id.state);

        detailAddress = (CustomEditText) findViewById(R.id.detail_address);

        otherState = (LinearLayout) findViewById(R.id.other_state);
        district = (EditText) findViewById(R.id.district);
        block = (EditText) findViewById(R.id.block);
        village = (EditText) findViewById(R.id.village);
        state.setOnTouchListener(this);
        district.setOnTouchListener(this);
        block.setOnTouchListener(this);
        state.setInputType(0);
        district.setInputType(0);
        block.setInputType(0);
        state.setOnFocusChangeListener(this);

        mobileNo = (EditText) findViewById(R.id.mobile_number);
        mobileNo.setOnFocusChangeListener(this);
        age = (EditText) findViewById(R.id.age);
        age.setOnFocusChangeListener(this);
        cast = (EditText) findViewById(R.id.cast);
        cast.setOnTouchListener(this);
        cast.setInputType(0);
        cast.setOnFocusChangeListener(this);
        aplBplLayout = (RadioGroup) findViewById(R.id.apl_bpl_layout);
        rdBtnApl = (RadioButton) findViewById(R.id.radio_btn_apl);
        rdBtnBpl = (RadioButton) findViewById(R.id.radio_btn_bpl);

        noOfNormalDelivery = (EditText) findViewById(R.id.no_of_normal_deliveries);
        noOfAssistedDelivery = (EditText) findViewById(R.id.no_of_assisted_deliveries);
        noOfCSectionDelivery = (EditText) findViewById(R.id.no_of_c_section_deliveries);
        noOfChildrenLayout = (LinearLayout) findViewById(R.id.no_of_children_layout);
        noOfLiveChild = (EditText) findViewById(R.id.no_of_live_child);
        noOfDeathChild = (EditText) findViewById(R.id.no_of_death_child);

        noOfNormalDelivery.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                checkForChildrenLayout();
            }
        });

        noOfAssistedDelivery.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                checkForChildrenLayout();
            }
        });

        noOfCSectionDelivery.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                checkForChildrenLayout();
            }
        });

        noOfAbortion = (EditText) findViewById(R.id.no_of_abortion);
        noOfAntenatalCheckups = (EditText) findViewById(R.id.no_of_antenatal_checkups);
        antenatalCheckupBoneByLayout = (RelativeLayout) findViewById(R.id.antenatal_checkup_done_by_layout);

        antenatalCheckupDoneBy = (EditText) findViewById(R.id.antenatal_checkup_done_by);
        antenatalCheckupDoneBy.setOnTouchListener(this);
        antenatalCheckupDoneBy.setInputType(0);
        antenatalCheckupDoneBy.setOnFocusChangeListener(this);

        noOfAntenatalCheckups.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                int value;
                try {
                    value = Integer.parseInt(s.toString());
                } catch (NumberFormatException e) {
                    value = 0;
                }
                if (value > 0) {
                    antenatalCheckupBoneByLayout.setVisibility(View.VISIBLE);
                } else {
                    antenatalCheckupDoneBy.setText("");
                    antenatalCheckupBoneByLayout.setVisibility(View.GONE);
                }
            }
        });

        systolic = (EditText) findViewById(R.id.systolic);
        diastolic = (EditText) findViewById(R.id.diastolic);
        pulseRate = (EditText) findViewById(R.id.pulse_rate);
        respiratoryRate = (EditText) findViewById(R.id.respiratory_rate);
        heartBeat = (EditText) findViewById(R.id.heart_beat);
        cervicalDilatation = (EditText) findViewById(R.id.cervical_dilatation);
        isPartographStarted = (ToggleButton) findViewById(R.id.is_partograph_started);
        isPartographStarted.setOnCheckedChangeListener(this);
        isPartographStartedLayout = (RelativeLayout) findViewById(R.id.is_partograph_started_layout);
        cervicalDilatation.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                int value;
                try {
                    value = Integer.parseInt(s.toString());
                } catch (NumberFormatException e) {
                    value = 0;
                }
                if (value >= 4) {
                    isPartographStartedLayout.setVisibility(View.VISIBLE);
                } else {
                    isPartographStarted.setChecked(false);
                    isPartographStartedLayout.setVisibility(View.GONE);
                }
            }
        });

        urinAlbumine = (EditText) findViewById(R.id.urin_albumine);
        urinAlbumine.setOnTouchListener(this);
        urinAlbumine.setInputType(0);
        urinAlbumine.setOnFocusChangeListener(this);
        urinSugar = (EditText) findViewById(R.id.urin_sugar);
        urinSugar.setOnTouchListener(this);
        urinSugar.setInputType(0);

        bloodSugarTestsLayout = (LinearLayout) findViewById(R.id.blood_sugar_tests_layout);
        isBloodSugarTestDone = (ToggleButton) findViewById(R.id.is_blood_sugar_test_done);
        isBloodSugarTestDone.setOnCheckedChangeListener(this);

        fasting = (EditText) findViewById(R.id.fasting);
        postmeal = (EditText) findViewById(R.id.postmeal);
        random = (EditText) findViewById(R.id.random);

        vdrl = (EditText) findViewById(R.id.vdrl);
        sickling = (EditText) findViewById(R.id.sickling);
        hivTest = (EditText) findViewById(R.id.hiv_test);
        bloodGroup = (EditText) findViewById(R.id.blood_group);
        rhType = (EditText) findViewById(R.id.rh_type);
        vdrl.setOnTouchListener(this);
        sickling.setOnTouchListener(this);
        hivTest.setOnTouchListener(this);
        bloodGroup.setOnTouchListener(this);
        rhType.setOnTouchListener(this);
        vdrl.setInputType(0);
        sickling.setInputType(0);
        hivTest.setInputType(0);
        bloodGroup.setInputType(0);
        rhType.setInputType(0);
        vdrl.setOnFocusChangeListener(this);

        transportToHospital = (EditText) findViewById(R.id.transport_to_hospital);
        transportToHospital.setOnTouchListener(this);
        transportToHospital.setInputType(0);

        deliveryDateTime = (EditText) findViewById(R.id.delivery_date_time);

        setDeliveryDateAndTime = (EditText) findViewById(R.id.delivery_date_time);
        setDeliveryDateAndTime.setInputType(0);
        showDeliveryDateAndTime = (ImageView) findViewById(R.id.show_delivery_date_time);
        showDeliveryDateAndTime.setOnClickListener(this);

        deliveryBy = (EditText) findViewById(R.id.delivery_by);
        deliveryTerm = (EditText) findViewById(R.id.delivery_term);
        deliveryType = (EditText) findViewById(R.id.delivery_type);
        drugType = (EditText) findViewById(R.id.drug_given);
        deliveryTerm.setOnTouchListener(this);
        deliveryType.setOnTouchListener(this);
        drugType.setOnTouchListener(this);
        deliveryTerm.setInputType(0);
        deliveryType.setInputType(0);
        drugType.setInputType(0);
        deliveryTerm.setOnFocusChangeListener(this);

        dexamethasoneLayout = (RelativeLayout) findViewById(R.id.dexamethasone_layout);
        isDexamethansoneGiven = (ToggleButton) findViewById(R.id.dexamethasone);
        isDexamethansoneGiven.setOnCheckedChangeListener(this);

        wasCordClampingDelayed = (ToggleButton) findViewById(R.id.was_cord_clamping_delayed);
        wasCordClampingDelayed.setOnCheckedChangeListener(this);

        hasGestational = (EditText) findViewById(R.id.gestational);
        hasGestational.setOnTouchListener(this);
        hasGestational.setInputType(0);
        hasGestational.setOnFocusChangeListener(this);
        insulinLayout = (RelativeLayout) findViewById(R.id.insulin_layout);
        isInsulin = (ToggleButton) findViewById(R.id.insulin);
        isInsulin.setOnCheckedChangeListener(this);

        hasHypoyhyroidism = (EditText) findViewById(R.id.hypothyroidism);
        hasHypoyhyroidism.setOnTouchListener(this);
        hasHypoyhyroidism.setInputType(0);
        hasHypoyhyroidism.setOnFocusChangeListener(this);
        thyroxineLayout = (RelativeLayout) findViewById(R.id.thyroxine_layout);
        isThyroxine = (ToggleButton) findViewById(R.id.thyroxine);
        isThyroxine.setOnCheckedChangeListener(this);

        hasEclampsia = (ToggleButton) findViewById(R.id.eclampsia);
        hasEclampsia.setOnCheckedChangeListener(this);
        magsulfLayout = (RelativeLayout) findViewById(R.id.magsulf_layout);
        isMagsulf = (ToggleButton) findViewById(R.id.magsulf);
        isMagsulf.setOnCheckedChangeListener(this);

        addChildOne = (ImageView) findViewById(R.id.add_first_child);
        addChildOne.setOnClickListener(this);
        anotherChildLayout = (RelativeLayout) findViewById(R.id.another_child_layout);

        childListHolder = (LinearLayout) findViewById(R.id.child_list_holder);

        addChild = (ImageView) findViewById(R.id.add_child);
        addChild.setOnClickListener(this);
        deleteChild = (ImageView) findViewById(R.id.delete_child);
        deleteChild.setOnClickListener(this);

        addChildStatusOne = (ImageView) findViewById(R.id.add_first_child_status);
        addChildStatusOne.setOnClickListener(this);
        anotherChildStatusLayout = (RelativeLayout) findViewById(R.id.another_child_status_layout);

        childStatusListHolder = (LinearLayout) findViewById(R.id.child_status_list_holder);

        addChildStatus = (ImageView) findViewById(R.id.add_child_status);
        addChildStatus.setOnClickListener(this);
        deleteChildStatus = (ImageView) findViewById(R.id.delete_child_status);
        deleteChildStatus.setOnClickListener(this);

        bloodTransfusion = (ToggleButton) findViewById(R.id.blood_transfusion);
        bloodTransfusion.setOnCheckedChangeListener(this);
        noOfPintsLayout = (LinearLayout) findViewById(R.id.no_of_pints_layout);
        noOfPints = (EditText) findViewById(R.id.no_of_pints);
        ppiucdInsertion = (ToggleButton) findViewById(R.id.ppiucd_insertion);
        ifa = (ToggleButton) findViewById(R.id.ifa);
        calciumVitD3 = (ToggleButton) findViewById(R.id.calcium_vit_d3);
        ppiucdInsertion.setOnCheckedChangeListener(this);
        ifa.setOnCheckedChangeListener(this);
        calciumVitD3.setOnCheckedChangeListener(this);

        typeOfJsy = (EditText) findViewById(R.id.type_of_jsy);
        typeOfJsy.setOnTouchListener(this);
        typeOfJsy.setInputType(0);
        typeOfJsy.setOnFocusChangeListener(this);

        statusOfMother = (EditText) findViewById(R.id.status_of_mother);
        statusOfMother.setOnClickListener(this);
        motherStatusLayout = (LinearLayout) findViewById(R.id.mother_status_layout);
        motherStatusLayout.setVisibility(View.GONE);
        motherDischargeLayout = (LinearLayout) findViewById(R.id.mother_discharge_layout);
        motherDischargeLayout.setVisibility(View.GONE);
        dischargeDateTimeOfMother = (EditText) findViewById(R.id.discharge_date_time_mother);
        showDischargeDateTimeOfMother = (ImageView) findViewById(R.id.show_discharge_date_time_mother);
        showDischargeDateTimeOfMother.setOnClickListener(this);
        dischargeTransportOfMother = (EditText) findViewById(R.id.transport_to_home_mother);
        dischargeTransportOfMother.setOnClickListener(this);
        motherReferredLayout = (LinearLayout) findViewById(R.id.mother_referred_layout);
        motherReferredLayout.setVisibility(View.GONE);
        referredDateTimeOfMother = (EditText) findViewById(R.id.referred_date_time_mother);
        showReferredDateTimeOfMother = (ImageView) findViewById(R.id.show_referred_date_time_mother);
        showReferredDateTimeOfMother.setOnClickListener(this);
        referredByOfMother = (EditText) findViewById(R.id.referred_by_mother);
        referredCauseOfMother = (EditText) findViewById(R.id.referred_cause_mother);
        referredCauseOfMother.setOnTouchListener(this);
        referredCauseOfMother.setInputType(0);
        referredCauseOfMother.setOnFocusChangeListener(this);
        otherReferredCauseMotherLayout = (RelativeLayout) findViewById(R.id.other_referred_cause_mother_layout);
        otherReferredCauseMother = (CustomEditText) findViewById(R.id.other_referred_cause_mother);

        referredTransportOfMother = (EditText) findViewById(R.id.referred_transport_mother);
        referredTransportOfMother.setOnClickListener(this);
        referredAreaOfMother = (EditText) findViewById(R.id.referred_area_mother);
        referredAreaOfMother.setOnClickListener(this);
        otherReferredFacilityMotherLayout = (RelativeLayout) findViewById(R.id.other_referred_facility_mother_layout);
        otherReferredFacilityMother = (CustomEditText) findViewById(R.id.other_referred_facility_mother);

        motherLamaLayout = (LinearLayout) findViewById(R.id.mother_lama_date_time_layout);
        motherLamaLayout.setVisibility(View.GONE);
        lamaDateTimeOfMother = (EditText) findViewById(R.id.lama_date_time_mother);
        showLamaDateTimeOfMother = (ImageView) findViewById(R.id.show_lama_date_time_mother);
        showLamaDateTimeOfMother.setOnClickListener(this);
        motherDeadLayout = (LinearLayout) findViewById(R.id.mother_dead_layout);
        motherDeadLayout.setVisibility(View.GONE);
        deathCauseOfMother = (EditText) findViewById(R.id.patient_death_cause_mother);
        deathCauseOfMother.setOnTouchListener(this);
        deathCauseOfMother.setInputType(0);
        deathCauseOfMother.setOnFocusChangeListener(this);

        otherDeathCauseMotherLayout = (RelativeLayout) findViewById(R.id.other_death_cause_mother_layout);
        otherDeathCauseMother = (CustomEditText) findViewById(R.id.other_death_cause_mother);

        deathDateTimeOfMother = (EditText) findViewById(R.id.patient_death_date_time_mother);
        showDeathDateTimeOfMother = (ImageView) findViewById(R.id.show_patient_death_date_time_mother);
        showDeathDateTimeOfMother.setOnClickListener(this);


        try {
            patientModel = (PatientModel) getIntent().getSerializableExtra("patientModel");
            //progress dialog code
            progressDialog = new ProgressDialog(PatientActivity.this);
            progressDialog.setTitle(getString(R.string.saving_data));
            progressDialog.setMessage(getString(R.string.please_wait));
            progressDialog.setCancelable(false);

            //alert dialog code
            alertDialog = new AlertDialog.Builder(PatientActivity.this).create();
            alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, getString(R.string.ok), new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    alertDialog.dismiss();
                }
            });

            LRCM.getInstance().setApplicationContext(PatientActivity.this);
            Realm realm = LRCM.getInstance().getRealm();

            RealmResults<Type> results = realm.where(Type.class).findAll();
            for (Type type : results) {
                switch (type.getId()) {
                    case Constant.Type.PATIENT_TYPE_ID:
                        for (TypeDetails detail : type.getTypeDetails()) {
                            patientTypeMap.put(detail.getName(), detail.getId());
                        }
                        break;
                    case Constant.Type.REFERRED_TYPE_ID:
                        for (TypeDetails detail : type.getTypeDetails()) {
                            referredTypeMap.put(detail.getName(), detail.getId());
                        }
                        break;
                    case Constant.Type.GENDER_TYPE_ID:
                        for (TypeDetails detail : type.getTypeDetails()) {
                            genderTypeMap.put(detail.getName(), detail.getId());
                        }
                        break;
                    case Constant.Type.CAST_TYPE_ID:
                        for (TypeDetails detail : type.getTypeDetails()) {
                            casteTypeMap.put(detail.getName(), detail.getId());
                        }
                        break;
                    case Constant.Type.ANTENATAL_TYPE_ID:
                        for (TypeDetails detail : type.getTypeDetails()) {
                            antenatalTypeMap.put(detail.getName(), detail.getId());
                        }
                        break;
                    case Constant.Type.URINE_ALBUMINE_TYPE_ID:
                        for (TypeDetails detail : type.getTypeDetails()) {
                            urineAlbumineTypeMap.put(detail.getName(), detail.getId());
                        }
                        break;
                    case Constant.Type.URINE_SUGAR_TYPE_ID:
                        for (TypeDetails detail : type.getTypeDetails()) {
                            urineSugarTypeMap.put(detail.getName(), detail.getId());
                        }
                        break;
                    case Constant.Type.APL_BPL_TYPE_ID:
                        for (TypeDetails detail : type.getTypeDetails()) {
                            aPLBPLTypeMap.put(detail.getName(), detail.getId());
                        }
                        break;
                    case Constant.Type.DELIVERY_TYPE_TYPE_ID:
                        for (TypeDetails detail : type.getTypeDetails()) {
                            deliveryTypeTypeMap.put(detail.getName(), detail.getId());
                        }
                        break;
                    case Constant.Type.VDRL_TYPE_ID:
                        for (TypeDetails detail : type.getTypeDetails()) {
                            vdrlTypeMap.put(detail.getName(), detail.getId());
                        }
                        break;
                    case Constant.Type.SICKLING_TYPE_ID:
                        for (TypeDetails detail : type.getTypeDetails()) {
                            sicklingTypeMap.put(detail.getName(), detail.getId());
                        }
                        break;
                    case Constant.Type.HIV_TEST_TYPE_ID:
                        for (TypeDetails detail : type.getTypeDetails()) {
                            hivTestTypeMap.put(detail.getName(), detail.getId());
                        }
                        break;
                    case Constant.Type.BLOOD_GROUP_TYPE_ID:
                        for (TypeDetails detail : type.getTypeDetails()) {
                            bloodGroupTypeMap.put(detail.getName(), detail.getId());
                        }
                        break;
                    case Constant.Type.RH_TYPE_ID:
                        for (TypeDetails detail : type.getTypeDetails()) {
                            rhTypeTypeMap.put(detail.getName(), detail.getId());
                        }
                        break;
                    case Constant.Type.TRANSPORT_TYPE_ID:
                        for (TypeDetails detail : type.getTypeDetails()) {
                            transportTypeMap.put(detail.getName(), detail.getId());
                        }
                        break;
                    case Constant.Type.DELIVERY_TERM_TYPE_ID:
                        for (TypeDetails detail : type.getTypeDetails()) {
                            deliveryTermTypeMap.put(detail.getName(), detail.getId());
                        }
                        break;
                    case Constant.Type.JSY_FUND_TYPE_TYPE_ID:
                        for (TypeDetails detail : type.getTypeDetails()) {
                            jsyTypeTypeMap.put(detail.getName(), detail.getId());
                        }
                        break;
                    case Constant.Type.MOTHER_STATUS_TYPE_ID:
                        for (TypeDetails detail : type.getTypeDetails()) {
                            motherStatusTypeMap.put(detail.getName(), detail.getId());
                        }
                        break;
                    case Constant.Type.MOTHER_REFERRED_CAUSE_TYPE_ID:
                        for (TypeDetails detail : type.getTypeDetails()) {
                            motherReferredCauseTypeMap.put(detail.getName(), detail.getId());
                        }
                        break;
                    case Constant.Type.MOTHER_DEATH_CAUSE_TYPE_ID:
                        for (TypeDetails detail : type.getTypeDetails()) {
                            motherDeathCauseTypeMap.put(detail.getName(), detail.getId());
                        }
                        break;
                    case Constant.Type.CHILD_STATUS_TYPE_ID:
                        for (TypeDetails detail : type.getTypeDetails()) {
                            childStatusTypeMap.put(detail.getName(), detail.getId());
                        }
                        break;
                    case Constant.Type.CHILD_REFERRED_CAUSE_TYPE_ID:
                        for (TypeDetails detail : type.getTypeDetails()) {
                            childReferredCauseTypeMap.put(detail.getName(), detail.getId());
                        }
                        break;
                    case Constant.Type.CHILD_REFERRED_FACILITY_TYPE_ID:
                        for (TypeDetails detail : type.getTypeDetails()) {
                            childReferredFacilityTypeMap.put(detail.getName(), detail.getId());
                        }
                        break;
                    case Constant.Type.THIRD_STAGE_DRUG_TYPE_TYPE_ID:
                        for (TypeDetails detail : type.getTypeDetails()) {
                            thirdStageDrugTypeMap.put(detail.getName(), detail.getId());
                        }
                        break;
                    case Constant.Type.GESTATIONAL_TYPE_ID:
                        for (TypeDetails detail : type.getTypeDetails()) {
                            gestationalTypeMap.put(detail.getName(), detail.getId());
                        }
                        break;
                    case Constant.Type.HYPOYHYROIDISM_TYPE_ID:
                        for (TypeDetails detail : type.getTypeDetails()) {
                            hypoyhyroidismTypeMap.put(detail.getName(), detail.getId());
                        }
                        break;
                    case Constant.Type.MOTHER_REFERRED_FACILITY_TYPE_ID:
                        for (TypeDetails detail : type.getTypeDetails()) {
                            referredFacilityMap.put(detail.getName(), detail.getId());
                        }
                        break;
                    case Constant.Type.STILL_BIRTH_TYPE_ID:
                        for (TypeDetails detail : type.getTypeDetails()) {
                            stillBirthTypeMap.put(detail.getName(), detail.getId());
                        }
                        break;
                    default:
                        break;
                }
            }

            //Area work
            RealmResults<Area> areaResults = realm.where(Area.class).equalTo("level", Constant.AreaLevel.STATE).findAll();
            for (Area area : areaResults) {
                stateMap.put(area.getName(), area.getNid());
            }

            //referred area
            areaResults = realm.where(Area.class).findAll();

            for (Area area : areaResults) {
                referredAreaMap.put(area.getName(), area.getNid());
            }

            LRCM.getInstance().closeRealm();


            if (patientModel.getClosed() != null && patientModel.getClosed()) {
                disableAllViews();
                saveBtn.setVisibility(View.GONE);
            }
        } catch (Exception e) {
            Toast.makeText(this, getString(R.string.error), Toast.LENGTH_SHORT).show();
        }

        if (genderTypeMap != null) {
            ArrayList<String> gender = new ArrayList<>();
            for (Map.Entry entry : genderTypeMap.entrySet()) {
                gender.add((String) entry.getKey());
            }
            /*sexFemaleOne.setText(gender.get(1));
            sexMaleOne.setText(gender.get(0));
            sexFemaleTwo.setText(gender.get(1));
            sexMaleTwo.setText(gender.get(0));
            sexFemaleThree.setText(gender.get(1));
            sexMaleThree.setText(gender.get(0));*/
        }

        validation = new Validation();

        Intent intent = getIntent();
        status = intent.getStringExtra("fab_status");
        if (status.equals("edit")) {
            setDataToFields();
            disableAllViews();
            disableMotherStatus();
            saveBtn.setImageResource(android.R.drawable.ic_menu_edit);
            saveBtn.setColorFilter(ContextCompat.getColor(this, R.color.white));
            saveFlag = false;

        } else if (status.equals("save")) {
            Calendar calander = Calendar.getInstance();
            SimpleDateFormat simpledateformat = new SimpleDateFormat("dd-MM-yyyy h:mm a");
            String date_time = simpledateformat.format(calander.getTime());
            setAddmisionDateAndTime.setText(date_time);
            saveBtn.setImageResource(android.R.drawable.ic_menu_save);
            saveBtn.setColorFilter(ContextCompat.getColor(this, R.color.white));
            saveFlag = true;
        }
    }

    private void checkForChildrenLayout() {

        String normalDeliveryString = noOfNormalDelivery.getText().toString();
        int normalDeliveries;
        String assistedDeliveryString = noOfAssistedDelivery.getText().toString();
        int assistedDeliveries;
        String csectionDeliveryString = noOfCSectionDelivery.getText().toString();
        int csectionDeliveries;
        try {
            normalDeliveries = Integer.parseInt(normalDeliveryString.trim());
        } catch (NumberFormatException e) {
            normalDeliveries = 0;
        }
        try {
            assistedDeliveries = Integer.parseInt(assistedDeliveryString.trim());
        } catch (NumberFormatException e) {
            assistedDeliveries = 0;
        }
        try {
            csectionDeliveries = Integer.parseInt(csectionDeliveryString.trim());
        } catch (NumberFormatException e) {
            csectionDeliveries = 0;
        }

        int totalDeliveries = normalDeliveries + assistedDeliveries + csectionDeliveries;
        if (totalDeliveries > 0) {
            noOfChildrenLayout.setVisibility(View.VISIBLE);
            isNoOfChildrenLayoutVisible = true;
        } else {
            noOfLiveChild.setText("");
            noOfDeathChild.setText("");
            noOfChildrenLayout.setVisibility(View.GONE);
            isNoOfChildrenLayoutVisible = false;
        }
    }

    // Choose
    public void chooseField(final CharSequence[] items, final EditText editText, final String str) {
        if (getWindow().getCurrentFocus() != null) {
            getWindow().getCurrentFocus().clearFocus();
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose");

        String selectedText = editText.getText().toString().trim();
        int slectedIndex = 0;
        if (!selectedText.equals("")) {
            for (CharSequence item : items) {
                if (item.toString().trim().equals(selectedText)) {
                    break;
                }
                slectedIndex++;
            }
        }

        builder.setSingleChoiceItems(items, slectedIndex,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int item) {
                    }
                })
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                int selectedPosition = ((AlertDialog) dialog)
                                        .getListView().getCheckedItemPosition();
                                String value = items[selectedPosition].toString();
                                switch (str) {
                                    case "motherStatus":
                                        if (checkRequiredFields()) {
                                            if (checkChildStatusMandatoryFields()) {

                                                String validationErrorMessage = validateBeforeClose();

                                                //If value will be null then there is no error, if value will be blank string by mistake also there is no error
                                                if (validationErrorMessage == null || (validationErrorMessage != null && validationErrorMessage.equals(""))) {
                                                    if (motherStatus) {
                                                        editText.setText(value);
                                                        disableAllViews();
                                                        if (value != null) {
                                                            switch (motherStatusTypeMap.get(value)) {
                                                                case MOTHER_STATUS_DISCHARGED_TYPE_DETAIL_ID:
                                                                    motherStatusLayout.setVisibility(View.VISIBLE);
                                                                    motherDischargeLayout.setVisibility(View.VISIBLE);
                                                                    motherReferredLayout.setVisibility(View.GONE);
                                                                    motherLamaLayout.setVisibility(View.GONE);
                                                                    motherDeadLayout.setVisibility(View.GONE);
                                                                    clearMotherReferredFields();
                                                                    clearMotherLamaFields();
                                                                    clearMotherDeadFields();
                                                                    break;
                                                                case MOTHER_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID:
                                                                    motherStatusLayout.setVisibility(View.VISIBLE);
                                                                    motherDischargeLayout.setVisibility(View.GONE);
                                                                    motherReferredLayout.setVisibility(View.VISIBLE);
                                                                    motherLamaLayout.setVisibility(View.GONE);
                                                                    motherDeadLayout.setVisibility(View.GONE);
                                                                    clearMotherDischargedFields();
                                                                    clearMotherLamaFields();
                                                                    clearMotherDeadFields();
                                                                    break;
                                                                case MOTHER_STATUS_DEATH_TYPE_DETAIL_ID:
                                                                    motherStatusLayout.setVisibility(View.VISIBLE);
                                                                    motherDischargeLayout.setVisibility(View.GONE);
                                                                    motherReferredLayout.setVisibility(View.GONE);
                                                                    motherLamaLayout.setVisibility(View.GONE);
                                                                    motherDeadLayout.setVisibility(View.VISIBLE);
                                                                    clearMotherDischargedFields();
                                                                    clearMotherReferredFields();
                                                                    clearMotherLamaFields();
                                                                    break;
                                                                case MOTHER_STATUS_LAMA_TYPE_DETAIL_ID:
                                                                    motherStatusLayout.setVisibility(View.VISIBLE);
                                                                    motherDischargeLayout.setVisibility(View.GONE);
                                                                    motherReferredLayout.setVisibility(View.GONE);
                                                                    motherLamaLayout.setVisibility(View.VISIBLE);
                                                                    motherDeadLayout.setVisibility(View.GONE);
                                                                    clearMotherDischargedFields();
                                                                    clearMotherReferredFields();
                                                                    clearMotherDeadFields();
                                                                    break;
                                                            }
                                                        }
                                                    } else {
                                                        callConfirmMotherStatusDialog(editText, value);
                                                    }
                                                } else {
                                                    showErrorMessage(validationErrorMessage);
                                                }
                                            }
                                        }
                                        break;
                                    default:
                                        editText.setText(value);
                                        break;
                                }
                                Realm realm = LRCM.getInstance().getRealm();
                                switch (str) {
                                    case "state":

                                        if (value.equals(Constant.STATE_NAME)) {
                                            RealmResults<Area> districts = realm.where(Area.class).equalTo("parentAreaId", stateMap.get(value)).findAll();
                                            districtMap = new TreeMap<String, Integer>();
                                            for (Area district : districts) {
                                                districtMap.put(district.getName(), district.getNid());
                                            }
                                            detailAddressLayout.setVisibility(View.GONE);
                                            detailAddress.setText("");
                                            otherState.setVisibility(View.VISIBLE);
                                        } else {
                                            otherState.setVisibility(View.GONE);
                                            detailAddressLayout.setVisibility(View.VISIBLE);
                                            district.setText("");
                                            block.setText("");
                                            village.setText("");
                                        }
                                        break;
                                    case "district":
                                        RealmResults<Area> blocks = realm.where(Area.class).equalTo("parentAreaId", districtMap.get(value)).findAll();
                                        blockMap = new TreeMap<String, Integer>();
                                        for (Area block : blocks) {
                                            blockMap.put(block.getName(), block.getNid());
                                        }
                                        block.setText("");
                                        village.setText("");
                                        break;
                                    case "deliveryTerm":
                                        if (deliveryTermTypeMap.get(value) == PRE_TERM_TYPE_DETAIL_ID) {
                                            dexamethasoneLayout.setVisibility(View.VISIBLE);
                                        } else {
                                            dexamethasoneLayout.setVisibility(View.GONE);
                                            isDexamethansoneGiven.setChecked(false);
                                        }
                                        break;
                                    case "patientType":
                                        if (patientTypeMap.get(value) == REFERRED_PATIENT_TYPE_DETAIL_ID) {
                                            patientTypeLayout.setVisibility(View.VISIBLE);
                                        } else {
                                            patientTypeLayout.setVisibility(View.GONE);
                                            referredFacilityType.setText("");
                                            facilityName.setText("");
                                        }
                                        break;
                                    case "gestational":
                                        if (gestationalTypeMap.get(value) == GESTATIONAL_YES_TYPE_DETAIL_ID) {
                                            insulinLayout.setVisibility(View.VISIBLE);
                                        } else {
                                            insulinLayout.setVisibility(View.GONE);
                                            isInsulin.setChecked(false);
                                        }
                                        break;
                                    case "hypothyroidism":
                                        if (hypoyhyroidismTypeMap.get(value) == HYPOTHYRODISM_YES_TYPE_DETAIL_ID) {
                                            thyroxineLayout.setVisibility(View.VISIBLE);
                                        } else {
                                            thyroxineLayout.setVisibility(View.GONE);
                                            isThyroxine.setChecked(false);
                                        }
                                        break;
                                    case "referredCauseOfMother":
                                        if (motherReferredCauseTypeMap.get(value) == MOTHER_REFERRED_OTHER_TYPE_DETAIL_ID) {
                                            otherReferredCauseMotherLayout.setVisibility(View.VISIBLE);
                                        } else {
                                            otherReferredCauseMotherLayout.setVisibility(View.GONE);
                                            otherReferredCauseMother.setText("");
                                        }
                                        break;
                                    case "deathCauseOfMother":
                                        if (motherDeathCauseTypeMap.get(value) == OTHER_DEATH_CAUSE_MOTHER_TYPE_DETAILS_ID) {
                                            otherDeathCauseMotherLayout.setVisibility(View.VISIBLE);
                                        } else {
                                            otherDeathCauseMotherLayout.setVisibility(View.GONE);
                                            otherDeathCauseMother.setText("");
                                        }
                                        break;
                                    case "block":
                                        village.setText("");
                                        break;
                                    case "referredAreaOfMother":
                                        if (referredFacilityMap.get(value) == OTHER_REFERRED_FACILITY_MOTHER_TYPE_DETAILS_ID) {
                                            otherReferredFacilityMotherLayout.setVisibility(View.VISIBLE);
                                        } else {
                                            otherReferredFacilityMotherLayout.setVisibility(View.GONE);
                                            otherReferredFacilityMother.setText("");
                                        }
                                        break;
                                    default:
                                        break;
                                }
                                LRCM.getInstance().closeRealm();
                                dialog.dismiss();
                            }
                        })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.dismiss();
                            }
                        });

        AlertDialog alert = builder.create();
        alert.show();
    }

    /**
     * This method will help to validate all fields when we close a case
     * This will not validate mother status details because when we select mother status case is closing.
     *
     * @return This method will return null if there is no error, and a string, whcih is an error if there is any error
     */
    private String validateBeforeClose() {
        setModelWithoutMotherStatus();

        //Exception may come, we need to handle that
        try {
            if (patientModel != null) {


                Validation validation = new Validation();

                //serial no
                String validateResult;

                //If it is a fresh record then there we will not have any patientId
                //Because only from pre-fetch record we will get patient id.


                //So we need to validate the serial no. accordingly
                if (patientModel.getPatientId() != null) {
                    //It is not a fresh record
                    Realm realm = LRCM.getInstance().getRealm();
                    Patient patient = realm.where(Patient.class).equalTo("patientId", patientModel.getPatientId()).findFirst();
                    if (patient != null) {
                        if (patient.getSerialNo().intValue() != patientModel.getSerialNo().intValue()) {
                            if (patientModel.getSerialNo() != null && patientModel.getAdmissionDateAndTime() != null) {
                                validateResult = validation.validateSerialNo(patientModel.getSerialNo(), patientModel.getAdmissionDateAndTime());
                                if (validateResult != null) {
                                    LRCM.getInstance().closeRealm();
                                    return validateResult;
                                }
                            } else {
                                LRCM.getInstance().closeRealm();
                                return "Please enter proper serial no. and admission date";
                            }

                        } else {                          //Here 2 serial no.s are equal
                            //we have to check fort month and year
                            if (!validation.validateSameMonthAndYear(patient.getAdmissionDateAndTime(), patientModel.getAdmissionDateAndTime())) {
                                if (patientModel.getSerialNo() != null && patientModel.getAdmissionDateAndTime() != null) {
                                    validateResult = validation.validateSerialNo(patientModel.getSerialNo(), patientModel.getAdmissionDateAndTime());
                                    if (validateResult != null) {
                                        LRCM.getInstance().closeRealm();
                                        return validateResult;
                                    }
                                } else {
                                    LRCM.getInstance().closeRealm();
                                    return "Please enter proper serial no. and admission date";
                                }
                            }
                        }

                    } else {
                        LRCM.getInstance().closeRealm();
                        return getString(R.string.patient_record_not_found);
                    }
                    LRCM.getInstance().closeRealm();

                } else {
                    //It is a fresh record

                    if (patientModel.getSerialNo() != null && patientModel.getAdmissionDateAndTime() != null) {
                        validateResult = validation.validateSerialNo(patientModel.getSerialNo(), patientModel.getAdmissionDateAndTime());
                        if (validateResult != null) {
                            return validateResult;
                        }
                    } else {
                        return "Please enter proper serial no. and admission date";
                    }
                }

                //date of admission
                validateResult = validation.validateDateOfAdmission(patientModel.getAdmissionDateAndTime());
                if (validateResult != null) {
                    return validateResult;
                }

                //detailAddressIfOtherState

                validateResult = validation.validateDetailAddressIfOtherState(patientModel.getDetailAddressIfOtherState(), patientModel.getStateAreaId());
                if (validateResult != null) {
                    return validateResult;
                }

                //patient Address District
                validateResult = validation.validatePatientDistrict(patientModel.getDistrictAreaId(), patientModel.getStateAreaId());
                if (validateResult != null) {
                    return validateResult;
                }


                //patient Address Block
                validateResult = validation.validatePatientBlock(patientModel.getBlockAreaId(), patientModel.getStateAreaId());
                if (validateResult != null) {
                    return validateResult;
                }


                //mobile no.
                validateResult = validation.validateMobileNo(patientModel.getMobileNo());
                if (validateResult != null) {
                    return validateResult;
                }

                //patientAge
                validateResult = validation.validatePatientAge(patientModel.getAge());
                if (validateResult != null) {
                    return validateResult;
                }

                //cast
                validateResult = validation.validateCaste(patientModel.getCaste());
                if (validateResult != null) {
                    return validateResult;
                }

                //aplOrBpl
                validateResult = validation.validateAplOrBpl(patientModel.getAplOrBpl());
                if (validateResult != null) {
                    return validateResult;
                }


                //noOfNormalDeliveries
                validateResult = validation.validateNoOfNormalDeliveries(patientModel.getNoOfNormalDeliveries());
                if (validateResult != null) {
                    return validateResult;
                }

                //noOfAssistedDeliveries
                validateResult = validation.validateNoOfAssistedDeliveries(patientModel.getNoOfAssistedDeliveries());
                if (validateResult != null) {
                    return validateResult;
                }

                //noOfCSectionDeliveries
                validateResult = validation.validateNoOfCSectionDeliveries(patientModel.getNoOfCSectionDeliveries());
                if (validateResult != null) {
                    return validateResult;
                }

                //noOfLiveChild
                validateResult = validation.validateNoOfLiveChild(patientModel.getNoOfLiveChild());
                if (validateResult != null) {
                    return validateResult;
                }

                //noOfStillBirth
                validateResult = validation.validateNoOfStillBirth(patientModel.getNoOfStillBirth());
                if (validateResult != null) {
                    return validateResult;
                }

                //validate previous delivery details for children
                validateResult = validation.validatePreviousDeliveryInfoForChildren(patientModel.getNoOfNormalDeliveries(), patientModel.getNoOfAssistedDeliveries(),
                        patientModel.getNoOfCSectionDeliveries(), patientModel.getNoOfLiveChild(), patientModel.getNoOfStillBirth());
                if (validateResult != null) {
                    return validateResult;
                }

                //noOfAbortion
                validateResult = validation.validateNoOfAbortion(patientModel.getNoOfAbortion());
                if (validateResult != null) {
                    return validateResult;
                }

                //noOfAntenatalCheckUps
                validateResult = validation.validateNoOfAntenatalCheckUps(patientModel.getNoOfAntenatalCheckups());
                if (validateResult != null) {
                    return validateResult;
                }

                //antenatalCheckUpDoneBy
                validateResult = validation.validateAntenatalCheckUpDoneBy(patientModel.getNoOfAntenatalCheckups(), patientModel.getAntenatalCheckupDoneBy());
                if (validateResult != null) {
                    return validateResult;
                }

                //bpSystolic
                validateResult = validation.validateBpSystolic(patientModel.getBpSystolic());
                if (validateResult != null) {
                    return validateResult;
                }

                //bpDiastolic
                validateResult = validation.validateBpDiastolic(patientModel.getBpDiastolic());
                if (validateResult != null) {
                    return validateResult;
                }


                //pulseRatePerMinute
                validateResult = validation.validatePulseRatePerMinute(patientModel.getPulseRatePerMinute());
                if (validateResult != null) {
                    return validateResult;
                }


                //respiratoryRatePerMinute
                validateResult = validation.validateRespiratoryRatePerMinute(patientModel.getRespiratoryRatePerMinute());
                if (validateResult != null) {
                    return validateResult;
                }

                //hb
                validateResult = validation.validateHeartRate(patientModel.getHeartRate());
                if (validateResult != null) {
                    return validateResult;
                }

                //cervicalDilatationInCm
                validateResult = validation.validateCervicalDilatationInCm(patientModel.getCervicalDilatationInCm());
                if (validateResult != null) {
                    return validateResult;
                }

                //isPatrographStarted
                validateResult = validation.validateIsPatrographStarted(patientModel.getPatrographStarted(), patientModel.getCervicalDilatationInCm());
                if (validateResult != null) {
                    return validateResult;
                }

                //urineAlbumine
                validateResult = validation.validateUrineAlbumine(patientModel.getUrineAlbumine());
                if (validateResult != null) {
                    return validateResult;
                }

                //urineSugar
                validateResult = validation.validateUrineSugar(patientModel.getUrineSugar());
                if (validateResult != null) {
                    return validateResult;
                }

                //isBloodSugarTestDone
                validateResult = validation.validateIsBloodSugarTestDone(patientModel.getBloodSugarTestDone());
                if (validateResult != null) {
                    return validateResult;
                }

                //bloodSugarFasting
                validateResult = validation.validateBloodSugarFasting(patientModel.getBloodSugarTestDone(), patientModel.getBloodSugarFasting());
                if (validateResult != null) {
                    return validateResult;
                }

                //bloodSugarPostmeal
                validateResult = validation.validateBloodSugarPostmeal(patientModel.getBloodSugarTestDone(), patientModel.getBloodSugarPostmeal());
                if (validateResult != null) {
                    return validateResult;
                }

                //bloodSugarRandom
                validateResult = validation.validateBloodSugarRandom(patientModel.getBloodSugarTestDone(), patientModel.getBloodSugarRandom());
                if (validateResult != null) {
                    return validateResult;
                }

                //vdrlRPR
                validateResult = validation.validateVdrlRPR(patientModel.getVdrlRPR());
                if (validateResult != null) {
                    return validateResult;
                }

                //sickling
                validateResult = validation.validateSickling(patientModel.getSickling());
                if (validateResult != null) {
                    return validateResult;
                }

                //hivTest
                validateResult = validation.validateHivTest(patientModel.getHivTest());
                if (validateResult != null) {
                    return validateResult;
                }

                //bloodGroup
                validateResult = validation.validateBloodGroup(patientModel.getBloodGroup());
                if (validateResult != null) {
                    return validateResult;
                }

                //rhType
                validateResult = validation.validateRHType(patientModel.getRhType());
                if (validateResult != null) {
                    return validateResult;
                }

                //vehicleToFacility
                validateResult = validation.validateVehicleToFacility(patientModel.getVehicleToFacility());
                if (validateResult != null) {
                    return validateResult;
                }

                //deliveryDate
                validateResult = validation.validateDeliveryDateAndTime(patientModel.getDeliveryDateAndTime(), patientModel.getAdmissionDateAndTime());
                if (validateResult != null) {
                    return validateResult;
                }

                //deliveryBy
                validateResult = validation.validateDeliveryBy(patientModel.getDeliveryBy());
                if (validateResult != null) {
                    return validateResult;
                }

                //deliveryTerm
                validateResult = validation.validateDeliveryTerm(patientModel.getDeliveryTerm());
                if (validateResult != null) {
                    return validateResult;
                }

                //dexamethasone
                validateResult = validation.validateDexamethasone(patientModel.getDeliveryTerm(), patientModel.getDexamethasoneGiven());
                if (validateResult != null) {
                    return validateResult;
                }

                //deliveryType
                validateResult = validation.validateDeliveryType(patientModel.getDeliveryType());
                if (validateResult != null) {
                    return validateResult;
                }

                //drugGivenInThirdStageOfLabor
                validateResult = validation.validateDrugGivenInThirdStageOfLabor(patientModel.getDrugGivenInThirdStageOfLabor());
                if (validateResult != null) {
                    return validateResult;
                }

                //wasCordClampingDelayed
                validateResult = validation.validateWasCordClampingDelayed(patientModel.getWasCordClampingDelayed());
                if (validateResult != null) {
                    return validateResult;
                }

                //isInsulinGiven
                validateResult = validation.validateIsInsulinGiven(patientModel.getHasGestationalDM(), patientModel.getInsulinGiven());
                if (validateResult != null) {
                    return validateResult;
                }

                //isThyroxineGiven
                validateResult = validation.validateIsThyroxineGiven(patientModel.getHasHypothyroidism(), patientModel.getLeavothyroxineGiven());
                if (validateResult != null) {
                    return validateResult;
                }

                //isMagsulfGiven
                validateResult = validation.validatIsTreatedWithMagsulf(patientModel.getHasEclampsia(), patientModel.getTreatedWithMagsulf());
                if (validateResult != null) {
                    return validateResult;
                }

                //children
                if (patientModel.getChildren() != null && patientModel.getChildren().size() > 0) {
                    validateResult = validation.validateChild(patientModel.getChildren());

                    if (validateResult != null) {
                        return validateResult;
                    }
                } else {
                    return getString(R.string.child_can_not_less_than_one);
                }

                //isBloodTransfusion
                validateResult = validation.validateIsBloodTransfusion(patientModel.getBloodTransfusionGiven());
                if (validateResult != null) {
                    return validateResult;
                }

                //noOfPints
                validateResult = validation.validateNoOfPints(patientModel.getBloodTransfusionGiven(), patientModel.getNoOfPints());
                if (validateResult != null) {
                    return validateResult;
                }

                //isPpiucdInserted
                validateResult = validation.validateIsPpiucdInserted(patientModel.getPpiucdInserted());
                if (validateResult != null) {
                    return validateResult;
                }

                //isIFAGivenInPNC
                validateResult = validation.validateIsIFAStarted(patientModel.getIFAGivenInPNC());
                if (validateResult != null) {
                    return validateResult;
                }

                //isCalciumVitaminD3InPNC
                validateResult = validation.validateIsCalciumVitD3Started(patientModel.getCalciumVitaminD3InPNC());
                if (validateResult != null) {
                    return validateResult;
                }

                //typeOfJSY
                validateResult = validation.validateTypeOfJSY(patientModel.getTypeOfJSY());
                if (validateResult != null) {
                    return validateResult;
                }

                //child status
                if (patientModel.getChildrenStatus() != null && patientModel.getChildrenStatus().size() > 0) {

                    validateResult = validation.validateChildStaus(patientModel.getChildrenStatus(),
                            patientModel.getDeliveryDateAndTime(),
                            patientModel.getAdmissionDateAndTime());

                    if (validateResult != null) {
                        return validateResult;
                    }
                }


            } else {
                return getString(R.string.invalid_data);
            }

        } catch (Exception e) {
            return getString(R.string.error) + " : " + e.getMessage();
        }
        return null;
    }

    /**
     * @param editText
     * @param value
     */
    public void callConfirmMotherStatusDialog(final EditText editText, final String value) {
        if (getWindow().getCurrentFocus() != null) {
            getWindow().getCurrentFocus().clearFocus();
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getResources().getString(R.string.confirmation_mother_status_dialog))
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        motherStatus = true;
                        editText.setText(value);
                        disableAllViews();
                        if (value != null) {
                            switch (motherStatusTypeMap.get(value)) {
                                case MOTHER_STATUS_DISCHARGED_TYPE_DETAIL_ID:
                                    motherStatusLayout.setVisibility(View.VISIBLE);
                                    motherDischargeLayout.setVisibility(View.VISIBLE);
                                    motherReferredLayout.setVisibility(View.GONE);
                                    motherLamaLayout.setVisibility(View.GONE);
                                    motherDeadLayout.setVisibility(View.GONE);
                                    clearMotherReferredFields();
                                    clearMotherLamaFields();
                                    clearMotherDeadFields();
                                    break;
                                case MOTHER_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID:
                                    motherStatusLayout.setVisibility(View.VISIBLE);
                                    motherDischargeLayout.setVisibility(View.GONE);
                                    motherReferredLayout.setVisibility(View.VISIBLE);
                                    motherLamaLayout.setVisibility(View.GONE);
                                    motherDeadLayout.setVisibility(View.GONE);
                                    clearMotherDischargedFields();
                                    clearMotherLamaFields();
                                    clearMotherDeadFields();
                                    break;
                                case MOTHER_STATUS_DEATH_TYPE_DETAIL_ID:
                                    motherStatusLayout.setVisibility(View.VISIBLE);
                                    motherDischargeLayout.setVisibility(View.GONE);
                                    motherReferredLayout.setVisibility(View.GONE);
                                    motherLamaLayout.setVisibility(View.GONE);
                                    motherDeadLayout.setVisibility(View.VISIBLE);
                                    clearMotherDischargedFields();
                                    clearMotherReferredFields();
                                    clearMotherLamaFields();
                                    break;
                                case MOTHER_STATUS_LAMA_TYPE_DETAIL_ID:
                                    motherStatusLayout.setVisibility(View.VISIBLE);
                                    motherDischargeLayout.setVisibility(View.GONE);
                                    motherReferredLayout.setVisibility(View.GONE);
                                    motherLamaLayout.setVisibility(View.VISIBLE);
                                    motherDeadLayout.setVisibility(View.GONE);
                                    clearMotherDischargedFields();
                                    clearMotherReferredFields();
                                    clearMotherDeadFields();
                                    break;
                            }
                        }
                        dialog.cancel();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //  Action for 'NO' Button
                        dialog.cancel();
                    }
                });
        //Creating dialog box
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void hideSoftKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.show_admission_date_time:
                hideSoftKeyboard();
                showDateTime(setAddmisionDateAndTime, "");
                break;
            case R.id.show_delivery_date_time:
                hideSoftKeyboard();
                showDateTime(setDeliveryDateAndTime, "delivery");
                break;
            case R.id.add_first_child:
                hideSoftKeyboard();
                setDeliveryDateAndTime.clearFocus();
                if (deliveryStatusFlag) {
                    if (childCount == 0) {
                        addChildOne.setVisibility(View.GONE);
                        anotherChildLayout.setVisibility(View.VISIBLE);
                        getChildOne();
                        childOneFlag = true;
                        childCount++;
                    }
                } else {
                    setDeliveryDateAndTime.requestFocus();
                    showErrorMessage(getResources().getString(R.string.give_delivery_date_before_adding_child_status));
                }
                break;
            case R.id.add_child:
                if (childCount < 10) {
                    switch (childCount) {
                        case 1:
                            getChildTwo();
                            childTwoFlag = true;
                            childCount++;
                            break;
                        case 2:
                            getChildThree();
                            childThreeFlag = true;
                            childCount++;
                            break;
                        case 3:
                            getChildFour();
                            childFourFlag = true;
                            childCount++;
                            break;
                        case 4:
                            getChildFive();
                            childFiveFlag = true;
                            childCount++;
                            break;
                        case 5:
                            getChildSix();
                            childSixFlag = true;
                            childCount++;
                            break;
                        case 6:
                            getChildSeven();
                            childSevenFlag = true;
                            childCount++;
                            break;
                        case 7:
                            getChildEight();
                            childEightFlag = true;
                            childCount++;
                            break;
                        case 8:
                            getChildNine();
                            childNineFlag = true;
                            childCount++;
                            break;
                        case 9:
                            getChildTen();
                            childTenFlag = true;
                            childCount++;
                            break;
                        default:
                            break;
                    }
                } else {
                    showErrorMessage(getResources().getString(R.string.restriction_on_adding_more_child_info));
                }
                break;
            case R.id.delete_child:
                if (childCount > childStatusCount) {
                    if (childCount > 0) {
                        switch (childCount) {
                            case 1:
                                hideSoftKeyboard();
                                showDeleteLayoutDialog(getResources().getString(R.string.delete_child_one_info), "Child Info");
                                break;
                            case 2:
                                hideSoftKeyboard();
                                showDeleteLayoutDialog(getResources().getString(R.string.delete_child_two_info), "Child Info");
                                break;
                            case 3:
                                hideSoftKeyboard();
                                showDeleteLayoutDialog(getResources().getString(R.string.delete_child_three_info), "Child Info");
                                break;
                            case 4:
                                hideSoftKeyboard();
                                showDeleteLayoutDialog(getResources().getString(R.string.delete_child_four_info), "Child Info");
                                break;
                            case 5:
                                hideSoftKeyboard();
                                showDeleteLayoutDialog(getResources().getString(R.string.delete_child_five_info), "Child Info");
                                break;
                            case 6:
                                hideSoftKeyboard();
                                showDeleteLayoutDialog(getResources().getString(R.string.delete_child_six_info), "Child Info");
                                break;
                            case 7:
                                hideSoftKeyboard();
                                showDeleteLayoutDialog(getResources().getString(R.string.delete_child_seven_info), "Child Info");
                                break;
                            case 8:
                                hideSoftKeyboard();
                                showDeleteLayoutDialog(getResources().getString(R.string.delete_child_eight_info), "Child Info");
                                break;
                            case 9:
                                hideSoftKeyboard();
                                showDeleteLayoutDialog(getResources().getString(R.string.delete_child_nine_info), "Child Info");
                                break;
                            case 10:
                                hideSoftKeyboard();
                                showDeleteLayoutDialog(getResources().getString(R.string.delete_child_ten_info), "Child Info");
                                break;
                            default:
                                break;
                        }
                    }
                } else {
                    showErrorMessage(getResources().getString(R.string.please_delete_respective_child_status_first));
                }
                break;
            case R.id.status_of_mother:
                hideSoftKeyboard();
                if (motherStatusTypeMap != null) {
                    Set<String> motherStatusSet = motherStatusTypeMap.keySet();
                    final CharSequence[] motherStatusItems = motherStatusSet.toArray(new CharSequence[motherStatusSet.size()]);
                    if (motherStatusItems.length > 0) {
                        chooseField(motherStatusItems, statusOfMother, "motherStatus");
                    }
                }
                break;
            case R.id.show_discharge_date_time_mother:
                hideSoftKeyboard();
                showDateTime(dischargeDateTimeOfMother, "");
                break;
            case R.id.transport_to_home_mother:
                hideSoftKeyboard();
                if (transportTypeMap != null) {
                    Set<String> transportMotherToHomeSet = transportTypeMap.keySet();
                    final CharSequence[] transportMotherToHomeItems = transportMotherToHomeSet.toArray(new CharSequence[transportMotherToHomeSet.size()]);
                    if (transportMotherToHomeItems.length > 0) {
                        chooseField(transportMotherToHomeItems, dischargeTransportOfMother, "");
                    }
                }
                break;
            case R.id.show_referred_date_time_mother:
                hideSoftKeyboard();
                showDateTime(referredDateTimeOfMother, "");
                break;
            case R.id.referred_transport_mother:
                hideSoftKeyboard();
                if (transportTypeMap != null) {
                    Set<String> referredTransportOfMotherSet = transportTypeMap.keySet();
                    final CharSequence[] referredTransportOfMotherItems = referredTransportOfMotherSet.toArray(new CharSequence[referredTransportOfMotherSet.size()]);
                    if (referredTransportOfMotherItems.length > 0) {
                        chooseField(referredTransportOfMotherItems, referredTransportOfMother, "");
                    }
                }
                break;
            case R.id.referred_area_mother:
                hideSoftKeyboard();
                Set<String> referredFacilityOfMotherSet = referredFacilityMap.keySet();
                CharSequence[] referredFacilityOfMotherItems = referredFacilityOfMotherSet.toArray(new CharSequence[referredFacilityOfMotherSet.size()]);
                if (referredFacilityOfMotherItems.length > 0) {
                    chooseField(referredFacilityOfMotherItems, referredAreaOfMother, "referredAreaOfMother");
                }
                break;
            case R.id.show_lama_date_time_mother:
                hideSoftKeyboard();
                showDateTime(lamaDateTimeOfMother, "");
                break;
            case R.id.show_patient_death_date_time_mother:
                hideSoftKeyboard();
                showDateTime(deathDateTimeOfMother, "");
                break;
            case R.id.add_first_child_status:
                hideSoftKeyboard();
                if (childStatusCount < childCount) {
                    if (childStatusCount == 0) {
                        addChildStatusOne.setVisibility(View.GONE);
                        anotherChildStatusLayout.setVisibility(View.VISIBLE);
                        getChildStatusOne();
                        childStatusOneFlag = true;
                        childStatusCount++;
                    }
                } else {
                    showErrorMessage(getResources().getString(R.string.restriction_on_adding_child_status_as_child_info_not_added));
                }
                break;
            case R.id.add_child_status:
                if (childStatusCount < childCount) {
                    if (childStatusCount < 10) {
                        switch (childStatusCount) {
                            case 1:
                                getChildStatusTwo();
                                childStatusTwoFlag = true;
                                childStatusCount++;
                                break;
                            case 2:
                                getChildStatusThree();
                                childStatusThreeFlag = true;
                                childStatusCount++;
                                break;
                            case 3:
                                getChildStatusFour();
                                childStatusFourFlag = true;
                                childStatusCount++;
                                break;
                            case 4:
                                getChildStatusFive();
                                childStatusFiveFlag = true;
                                childStatusCount++;
                                break;
                            case 5:
                                getChildStatusSix();
                                childStatusSixFlag = true;
                                childStatusCount++;
                                break;
                            case 6:
                                getChildStatusSeven();
                                childStatusSevenFlag = true;
                                childStatusCount++;
                                break;
                            case 7:
                                getChildStatusEight();
                                childStatusEightFlag = true;
                                childStatusCount++;
                                break;
                            case 8:
                                getChildStatusNine();
                                childStatusNineFlag = true;
                                childStatusCount++;
                                break;
                            case 9:
                                getChildStatusTen();
                                childStatusTenFlag = true;
                                childStatusCount++;
                                break;
                            default:
                                break;
                        }
                    } else {
                        showErrorMessage(getResources().getString(R.string.restriction_on_adding_more_child_status));
                    }
                } else {
                    showErrorMessage(getResources().getString(R.string.restriction_on_adding_child_status_then_child_info));
                }
                break;
            case R.id.delete_child_status:
                if (childStatusCount > 0) {
                    switch (childStatusCount) {
                        case 1:
                            hideSoftKeyboard();
                            showDeleteLayoutDialog(getResources().getString(R.string.delete_child_one_status), "Child Status");
                            break;
                        case 2:
                            hideSoftKeyboard();
                            showDeleteLayoutDialog(getResources().getString(R.string.delete_child_two_status), "Child Status");
                            break;
                        case 3:
                            hideSoftKeyboard();
                            showDeleteLayoutDialog(getResources().getString(R.string.delete_child_three_status), "Child Status");
                            break;
                        case 4:
                            hideSoftKeyboard();
                            showDeleteLayoutDialog(getResources().getString(R.string.delete_child_four_status), "Child Status");
                            break;
                        case 5:
                            hideSoftKeyboard();
                            showDeleteLayoutDialog(getResources().getString(R.string.delete_child_five_status), "Child Status");
                            break;
                        case 6:
                            hideSoftKeyboard();
                            showDeleteLayoutDialog(getResources().getString(R.string.delete_child_six_status), "Child Status");
                            break;
                        case 7:
                            hideSoftKeyboard();
                            showDeleteLayoutDialog(getResources().getString(R.string.delete_child_seven_status), "Child Status");
                            break;
                        case 8:
                            hideSoftKeyboard();
                            showDeleteLayoutDialog(getResources().getString(R.string.delete_child_eight_status), "Child Status");
                            break;
                        case 9:
                            hideSoftKeyboard();
                            showDeleteLayoutDialog(getResources().getString(R.string.delete_child_nine_status), "Child Status");
                            break;
                        case 10:
                            hideSoftKeyboard();
                            showDeleteLayoutDialog(getResources().getString(R.string.delete_child_ten_status), "Child Status");
                            break;
                        default:
                            break;
                    }
                }
                break;
            case R.id.save_btn:
                hideSoftKeyboard();
                if (!saveFlag) {
                    Toast.makeText(getApplication(), "Editable Mode", Toast.LENGTH_SHORT).show();
                    enableAllViews();
                    saveBtn.setImageResource(android.R.drawable.ic_menu_save);
                    saveBtn.setColorFilter(ContextCompat.getColor(this, R.color.white));
                    saveFlag = true;
                } else {
                    saveTheData();
                }
                break;
            default:
                break;
        }
    }

    public void showDateTime(final EditText dateTime, final String type) {
        // Get Current Date
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    int callCount = 0;   //To track number of calls to onTimeSet()

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                        monthOfYear = monthOfYear + 1;
                        String formattedDay = (String.valueOf(dayOfMonth));
                        String formattedMonth = (String.valueOf(monthOfYear));

                        if (dayOfMonth < 10) {
                            formattedDay = "0" + dayOfMonth;
                        }

                        if (monthOfYear < 10) {
                            formattedMonth = "0" + monthOfYear;
                        }

                        String date = formattedDay + "-" + formattedMonth + "-" + year;
                        //*************Call Time Picker Here ********************
                        if (callCount == 0)    // On second call
                        {
                            timePicker(dateTime, date, type);
                        }
                        callCount++;    // Incrementing call count.
                    }
                }, mYear, mMonth, mDay);
        Calendar maxDate = Calendar.getInstance();
        maxDate.set(Calendar.HOUR_OF_DAY, 23);
        maxDate.set(Calendar.MINUTE, 59);
        maxDate.set(Calendar.SECOND, 59);
        datePickerDialog.getDatePicker().setMaxDate(maxDate.getTimeInMillis());
        datePickerDialog.show();
    }

    private void timePicker(final EditText dateTime, final String date, final String type) {
        // Get Current Time
        final Calendar c = Calendar.getInstance();
        mHour = c.get(Calendar.HOUR_OF_DAY);
        mMinute = c.get(Calendar.MINUTE);

        // Launch Time Picker Dialog
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {


                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                        mHour = hourOfDay;
                        mMinute = minute;

                        String AM_PM = " AM";
                        String mm_precede = "";
                        if (hourOfDay >= 12) {
                            AM_PM = " PM";
                            if (hourOfDay >= 13 && hourOfDay < 24) {
                                hourOfDay -= 12;
                            } else {
                                hourOfDay = 12;
                            }
                        } else if (hourOfDay == 0) {
                            hourOfDay = 12;
                        }
                        if (minute < 10) {
                            mm_precede = "0";
                        }

                        String selectedTime = date + " " + hourOfDay + ":" + mm_precede + minute + AM_PM;
                        Date selectedDateAndTime = new Date();
                        Date currentDateAndTime = new Date();
                        currentDateAndTime = c.getTime();
                        try {
                            selectedDateAndTime = simpleDateFormat.parse(selectedTime.trim());
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        if (!selectedDateAndTime.after(currentDateAndTime)) {

                            dateTime.setText(date + " " + hourOfDay + ":" + mm_precede + minute + AM_PM);
                            if (type.equals("delivery")) {
                                deliveryStatusFlag = true;
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "Future time not acceptable", Toast.LENGTH_SHORT).show();
                        }
                    }
                }, mHour, mMinute, false);
        timePickerDialog.show();
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        switch (compoundButton.getId()) {
            case R.id.is_blood_sugar_test_done:
                if (isBloodSugarTestDone.isChecked()) {
                    bloodSugarTestsLayout.setVisibility(View.VISIBLE);
                } else {
                    bloodSugarTestsLayout.setVisibility(View.GONE);
                    fasting.setText("");
                    postmeal.setText("");
                    random.setText("");
                }
                break;
            case R.id.dexamethasone:
                break;
            case R.id.gestational:
                if (b) {
                    insulinLayout.setVisibility(View.VISIBLE);
                } else {
                    insulinLayout.setVisibility(View.GONE);
                    isInsulin.setChecked(false);
                }
                break;
            case R.id.insulin:
                break;
            case R.id.hypothyroidism:
                if (b) {
                    thyroxineLayout.setVisibility(View.VISIBLE);
                } else {
                    thyroxineLayout.setVisibility(View.GONE);
                    isThyroxine.setChecked(false);
                }
                break;
            case R.id.thyroxine:
                break;
            case R.id.eclampsia:
                if (b) {
                    magsulfLayout.setVisibility(View.VISIBLE);
                } else {
                    magsulfLayout.setVisibility(View.GONE);
                    isMagsulf.setChecked(false);
                }
                break;
            case R.id.magsulf:
                break;
            case R.id.blood_transfusion:
                if (b) {
                    noOfPintsLayout.setVisibility(View.VISIBLE);
                } else {
                    noOfPintsLayout.setVisibility(View.GONE);
                    noOfPints.setText("");
                }
                break;
            default:
                break;
        }
    }

    public boolean checkMandatoryFields() {
        if (serialNo.getText().toString().equals("")) {
            serialNo.clearFocus();
            serialNo.requestFocus();
            showErrorMessage(getResources().getString(R.string.serial_number_warning));
            return false;
        } else if (setAddmisionDateAndTime.getText().toString().equals("")) {
            setAddmisionDateAndTime.clearFocus();
            setAddmisionDateAndTime.requestFocus();
            showErrorMessage(getResources().getString(R.string.admission_date_time_warning));
            return false;
        } else if (patientName.getText().toString().equals("")) {
            patientName.clearFocus();
            patientName.requestFocus();
            showErrorMessage(getResources().getString(R.string.patient_name_warning));
            return false;
        } else {
            return true;
        }
    }

    public boolean checkRequiredFields() {
        if (!checkMandatoryFields()) {
            return false;
        }
        if (patientType.getText().toString().equals("")) {
            patientType.clearFocus();
            patientType.requestFocus();
            showErrorMessage(getResources().getString(R.string.patient_type_warning));
            return false;
        } else if (patientType.getText().toString().equals("Referred") && referredFacilityType.getText().toString().equals("")) {
            referredFacilityType.clearFocus();
            referredFacilityType.requestFocus();
            showErrorMessage(getResources().getString(R.string.referred_facility_warning));
            return false;
        } else if (patientType.getText().toString().equals("Referred") && facilityName.getText().toString().equals("")) {
            facilityName.clearFocus();
            facilityName.requestFocus();
            showErrorMessage(getResources().getString(R.string.facility_name_warning));
            return false;
        } else if (state.getText().toString().equals("")) {
            state.clearFocus();
            state.requestFocus();
            showErrorMessage(getResources().getString(R.string.state_warning));
            return false;
        } else if (!(state.getText().toString().equals("Chhattisgarh")) && detailAddress.getText().toString().equals("")) {
            detailAddress.clearFocus();
            detailAddress.requestFocus();
            showErrorMessage(getResources().getString(R.string.details_address_warning));
            return false;
        } else if (state.getText().toString().equals("Chhattisgarh") && district.getText().toString().equals("")) {
            district.clearFocus();
            district.requestFocus();
            showErrorMessage(getResources().getString(R.string.district_warning));
            return false;
        } else if (state.getText().toString().equals("Chhattisgarh") && block.getText().toString().equals("")) {
            block.clearFocus();
            block.requestFocus();
            showErrorMessage(getResources().getString(R.string.block_warning));
            return false;
        } else if (state.getText().toString().equals("Chhattisgarh") && village.getText().toString().equals("")) {
            village.clearFocus();
            village.requestFocus();
            showErrorMessage(getResources().getString(R.string.village_warning));
            return false;
        } else if (age.getText().toString().equals("")) {
            age.clearFocus();
            age.requestFocus();
            showErrorMessage(getResources().getString(R.string.age_warning));
            return false;
        } else if (cast.getText().toString().equals("")) {
            cast.clearFocus();
            cast.requestFocus();
            showErrorMessage(getResources().getString(R.string.cast_warning));
            return false;
        } else if (!rdBtnBpl.isChecked() && !rdBtnApl.isChecked()) {
            aplBplLayout.clearFocus();
            aplBplLayout.getParent().requestChildFocus(aplBplLayout, aplBplLayout);
            showErrorMessage(getResources().getString(R.string.apl_bpl_warning));
            return false;
        } else if (noOfNormalDelivery.getText().toString().equals("")) {
            noOfNormalDelivery.clearFocus();
            noOfNormalDelivery.requestFocus();
            showErrorMessage(getResources().getString(R.string.normal_delivery_warning));
            return false;
        } else if (noOfAssistedDelivery.getText().toString().equals("")) {
            noOfAssistedDelivery.clearFocus();
            noOfAssistedDelivery.requestFocus();
            showErrorMessage(getResources().getString(R.string.assisted_delivery_warning));
            return false;
        } else if (noOfCSectionDelivery.getText().toString().equals("")) {
            noOfCSectionDelivery.clearFocus();
            noOfCSectionDelivery.requestFocus();
            showErrorMessage(getResources().getString(R.string.c_section_delivery_warning));
            return false;
        } else if (isNoOfChildrenLayoutVisible && noOfLiveChild.getText().toString().equals("")) {
            noOfLiveChild.clearFocus();
            noOfLiveChild.requestFocus();
            showErrorMessage(getResources().getString(R.string.live_birth_warning));
            return false;
        } else if (isNoOfChildrenLayoutVisible && noOfDeathChild.getText().toString().equals("")) {
            noOfDeathChild.clearFocus();
            noOfDeathChild.requestFocus();
            showErrorMessage(getResources().getString(R.string.still_birth_warning));
            return false;
        } else if (noOfAbortion.getText().toString().equals("")) {
            noOfAbortion.clearFocus();
            noOfAbortion.requestFocus();
            showErrorMessage(getResources().getString(R.string.abortions_warning));
            return false;
        } else if (noOfAntenatalCheckups.getText().toString().trim().equals("")) {
            noOfAntenatalCheckups.clearFocus();
            noOfAntenatalCheckups.requestFocus();
            showErrorMessage(getResources().getString(R.string.no_of_antenatal_check_ups_warning));
            return false;
        } else if (!noOfAntenatalCheckups.getText().toString().trim().equals("") && Integer.parseInt(noOfAntenatalCheckups.getText().toString().trim()) > 0 && antenatalCheckupDoneBy.getText().toString().equals("")) {
            antenatalCheckupDoneBy.clearFocus();
            antenatalCheckupDoneBy.requestFocus();
            showErrorMessage(getResources().getString(R.string.antenatal_check_ups_warning));
            return false;
        } else if (systolic.getText().toString().equals("")) {
            systolic.clearFocus();
            systolic.requestFocus();
            showErrorMessage(getResources().getString(R.string.systolic_warning));
            return false;
        } else if (diastolic.getText().toString().equals("")) {
            diastolic.clearFocus();
            diastolic.requestFocus();
            showErrorMessage(getResources().getString(R.string.diastolic_warning));
            return false;
        } else if (pulseRate.getText().toString().equals("")) {
            pulseRate.clearFocus();
            pulseRate.requestFocus();
            showErrorMessage(getResources().getString(R.string.pulse_rate_warning));
            return false;
        } else if (respiratoryRate.getText().toString().equals("")) {
            respiratoryRate.clearFocus();
            respiratoryRate.requestFocus();
            showErrorMessage(getResources().getString(R.string.respiratory_rate_warning));
            return false;
        } else if (heartBeat.getText().toString().equals("")) {
            heartBeat.clearFocus();
            heartBeat.requestFocus();
            showErrorMessage(getResources().getString(R.string.heart_beat_warning));
            return false;
        } else if (cervicalDilatation.getText().toString().equals("")) {
            cervicalDilatation.clearFocus();
            cervicalDilatation.requestFocus();
            showErrorMessage(getResources().getString(R.string.cervical_dilatation_warning));
            return false;
        } else if (urinAlbumine.getText().toString().equals("")) {
            urinAlbumine.clearFocus();
            urinAlbumine.requestFocus();
            showErrorMessage(getResources().getString(R.string.urine_albumine_warning));
            return false;
        } else if (urinSugar.getText().toString().equals("")) {
            urinSugar.clearFocus();
            urinSugar.requestFocus();
            showErrorMessage(getResources().getString(R.string.urine_sugar_warning));
            return false;
        } else if (isBloodSugarTestDone.isChecked() && fasting.getText().toString().trim().equals("") &&
                postmeal.getText().toString().equals("") && random.getText().toString().equals("")) {
            fasting.clearFocus();
            postmeal.clearFocus();
            random.clearFocus();
            isBloodSugarTestDone.getParent().requestChildFocus(isBloodSugarTestDone, isBloodSugarTestDone);
            showErrorMessage(getResources().getString(R.string.test_value_mandatory));
            return false;
        } else if (vdrl.getText().toString().equals("")) {
            vdrl.clearFocus();
            vdrl.requestFocus();
            showErrorMessage(getResources().getString(R.string.vdrl_rpr_warning));
            return false;
        } else if (sickling.getText().toString().equals("")) {
            sickling.clearFocus();
            sickling.requestFocus();
            showErrorMessage(getResources().getString(R.string.sickling_warning));
            return false;
        } else if (hivTest.getText().toString().equals("")) {
            hivTest.clearFocus();
            hivTest.requestFocus();
            showErrorMessage(getResources().getString(R.string.hiv_test_warning));
            return false;
        } else if (bloodGroup.getText().toString().equals("")) {
            bloodGroup.clearFocus();
            bloodGroup.requestFocus();
            showErrorMessage(getResources().getString(R.string.blood_group_warning));
            return false;
        } else if (rhType.getText().toString().equals("")) {
            rhType.clearFocus();
            rhType.requestFocus();
            showErrorMessage(getResources().getString(R.string.rh_type_warning));
            return false;
        } else if (transportToHospital.getText().toString().equals("")) {
            transportToHospital.clearFocus();
            transportToHospital.requestFocus();
            showErrorMessage(getResources().getString(R.string.vehicle_used_for_transport_warning));
            return false;
        } else if (setDeliveryDateAndTime.getText().toString().equals("")) {
            setDeliveryDateAndTime.clearFocus();
            setDeliveryDateAndTime.requestFocus();
            showErrorMessage(getResources().getString(R.string.delivery_date_warning));
            return false;
        } else if (deliveryBy.getText().toString().equals("")) {
            deliveryBy.clearFocus();
            deliveryBy.requestFocus();
            showErrorMessage(getResources().getString(R.string.delivery_by_warning));
            return false;
        } else if (deliveryTerm.getText().toString().equals("")) {
            deliveryTerm.clearFocus();
            deliveryTerm.requestFocus();
            showErrorMessage(getResources().getString(R.string.delivery_term_warning));
            return false;
        } else if (deliveryType.getText().toString().equals("")) {
            deliveryType.clearFocus();
            deliveryType.requestFocus();
            showErrorMessage(getResources().getString(R.string.delivery_type_warning));
            return false;
        } else if (drugType.getText().toString().equals("")) {
            drugType.clearFocus();
            drugType.requestFocus();
            showErrorMessage(getResources().getString(R.string.drug_given_warning));
            return false;
        } else if (hasGestational.getText().toString().equals("")) {
            hasGestational.clearFocus();
            hasGestational.requestFocus();
            showErrorMessage(getResources().getString(R.string.gestational_diabetes_warning));
            return false;
        } else if (hasHypoyhyroidism.getText().toString().equals("")) {
            hasHypoyhyroidism.clearFocus();
            hasHypoyhyroidism.requestFocus();
            showErrorMessage(getResources().getString(R.string.hypothyrodism_warning));
            return false;
        } else if (childOneFlag && !customChildInfoLayoutOne.sexMale.isChecked() && !customChildInfoLayoutOne.sexFemale.isChecked()) {
            checkVisibilityOfChildInfo(customChildInfoLayoutOne);
            customChildInfoLayoutOne.childSexTxt.getParent().clearChildFocus(customChildInfoLayoutOne.childSexTxt);
            requestFocusOnChildGender(customChildInfoLayoutOne, getResources().getString(R.string.child_one_gender_warning));
            return false;
        } else if (childOneFlag && customChildInfoLayoutOne.weightEditBox.getText().toString().equals("")) {
            checkVisibilityOfChildInfo(customChildInfoLayoutOne);
            customChildInfoLayoutOne.weightEditBox.clearFocus();
            requestFocusOnChildWeight(customChildInfoLayoutOne, getResources().getString(R.string.child_one_weight_warning));
            return false;
        } else if (childOneFlag && customChildInfoLayoutOne.stillBirthTB.isChecked() && customChildInfoLayoutOne.stillBirthTypeEditBox.getText().toString().equals("")) {
            checkVisibilityOfChildInfo(customChildInfoLayoutOne);
            customChildInfoLayoutOne.stillBirthTypeEditBox.clearFocus();
            requestFocusOnStillBirthType(customChildInfoLayoutOne, getResources().getString(R.string.child_one_still_birth_type_warning));
            return false;
        } else if (childTwoFlag && !customChildInfoLayoutTwo.sexMale.isChecked() && !customChildInfoLayoutTwo.sexFemale.isChecked()) {
            checkVisibilityOfChildInfo(customChildInfoLayoutTwo);
            customChildInfoLayoutTwo.childSexTxt.getParent().clearChildFocus(customChildInfoLayoutOne.childSexTxt);
            requestFocusOnChildGender(customChildInfoLayoutTwo, getResources().getString(R.string.child_two_gender_warning));
            return false;
        } else if (childTwoFlag && customChildInfoLayoutTwo.weightEditBox.getText().toString().equals("")) {
            checkVisibilityOfChildInfo(customChildInfoLayoutTwo);
            customChildInfoLayoutTwo.weightEditBox.clearFocus();
            requestFocusOnChildWeight(customChildInfoLayoutTwo, getResources().getString(R.string.child_two_weight_warning));
            return false;
        } else if (childTwoFlag && customChildInfoLayoutTwo.stillBirthTB.isChecked() && customChildInfoLayoutTwo.stillBirthType.getText().toString().equals("")) {
            checkVisibilityOfChildInfo(customChildInfoLayoutTwo);
            customChildInfoLayoutTwo.stillBirthTypeEditBox.clearFocus();
            requestFocusOnStillBirthType(customChildInfoLayoutTwo, getResources().getString(R.string.child_two_still_birth_type_warning));
            return false;
        } else if (childThreeFlag && !customChildInfoLayoutThree.sexMale.isChecked() && !customChildInfoLayoutThree.sexFemale.isChecked()) {
            checkVisibilityOfChildInfo(customChildInfoLayoutThree);
            customChildInfoLayoutThree.childSexTxt.getParent().clearChildFocus(customChildInfoLayoutOne.childSexTxt);
            requestFocusOnChildGender(customChildInfoLayoutThree, getResources().getString(R.string.child_three_gender_warning));
            return false;
        } else if (childThreeFlag && customChildInfoLayoutThree.weightEditBox.getText().toString().equals("")) {
            checkVisibilityOfChildInfo(customChildInfoLayoutThree);
            customChildInfoLayoutThree.weightEditBox.clearFocus();
            requestFocusOnChildWeight(customChildInfoLayoutThree, getResources().getString(R.string.child_three_weight_warning));
            return false;
        } else if (childThreeFlag && customChildInfoLayoutThree.stillBirthTB.isChecked() && customChildInfoLayoutThree.stillBirthType.getText().toString().equals("")) {
            checkVisibilityOfChildInfo(customChildInfoLayoutThree);
            customChildInfoLayoutThree.stillBirthTypeEditBox.clearFocus();
            requestFocusOnStillBirthType(customChildInfoLayoutThree, getResources().getString(R.string.child_three_still_birth_type_warning));
            return false;
        } else if (childFourFlag && !customChildInfoLayoutFour.sexMale.isChecked() && !customChildInfoLayoutFour.sexFemale.isChecked()) {
            checkVisibilityOfChildInfo(customChildInfoLayoutFour);
            customChildInfoLayoutFour.childSexTxt.getParent().clearChildFocus(customChildInfoLayoutOne.childSexTxt);
            requestFocusOnChildGender(customChildInfoLayoutFour, getResources().getString(R.string.child_four_gender_warning));
            return false;
        } else if (childFourFlag && customChildInfoLayoutFour.weightEditBox.getText().toString().equals("")) {
            checkVisibilityOfChildInfo(customChildInfoLayoutFour);
            customChildInfoLayoutFour.weightEditBox.clearFocus();
            requestFocusOnChildWeight(customChildInfoLayoutFour, getResources().getString(R.string.child_four_weight_warning));
            return false;
        } else if (childFourFlag && customChildInfoLayoutFour.stillBirthTB.isChecked() && customChildInfoLayoutFour.stillBirthType.getText().toString().equals("")) {
            checkVisibilityOfChildInfo(customChildInfoLayoutFour);
            customChildInfoLayoutFour.stillBirthTypeEditBox.clearFocus();
            requestFocusOnStillBirthType(customChildInfoLayoutFour, getResources().getString(R.string.child_four_still_birth_type_warning));
            return false;
        } else if (childFiveFlag && !customChildInfoLayoutFive.sexMale.isChecked() && !customChildInfoLayoutFive.sexFemale.isChecked()) {
            checkVisibilityOfChildInfo(customChildInfoLayoutFive);
            customChildInfoLayoutFive.childSexTxt.getParent().clearChildFocus(customChildInfoLayoutOne.childSexTxt);
            requestFocusOnChildGender(customChildInfoLayoutFive, getResources().getString(R.string.child_five_gender_warning));
            return false;
        } else if (childFiveFlag && customChildInfoLayoutFive.weightEditBox.getText().toString().equals("")) {
            checkVisibilityOfChildInfo(customChildInfoLayoutFive);
            customChildInfoLayoutFive.weightEditBox.clearFocus();
            requestFocusOnChildWeight(customChildInfoLayoutFive, getResources().getString(R.string.child_five_weight_warning));
            return false;
        } else if (childFiveFlag && customChildInfoLayoutFive.stillBirthTB.isChecked() && customChildInfoLayoutFive.stillBirthType.getText().toString().equals("")) {
            checkVisibilityOfChildInfo(customChildInfoLayoutFive);
            customChildInfoLayoutFive.stillBirthTypeEditBox.clearFocus();
            requestFocusOnStillBirthType(customChildInfoLayoutFive, getResources().getString(R.string.child_five_still_birth_type_warning));
            return false;
        } else if (childSixFlag && !customChildInfoLayoutSix.sexMale.isChecked() && !customChildInfoLayoutSix.sexFemale.isChecked()) {
            checkVisibilityOfChildInfo(customChildInfoLayoutSix);
            customChildInfoLayoutSix.childSexTxt.getParent().clearChildFocus(customChildInfoLayoutOne.childSexTxt);
            requestFocusOnChildGender(customChildInfoLayoutSix, getResources().getString(R.string.child_six_gender_warning));
            return false;
        } else if (childSixFlag && customChildInfoLayoutSix.weightEditBox.getText().toString().equals("")) {
            checkVisibilityOfChildInfo(customChildInfoLayoutSix);
            customChildInfoLayoutSix.weightEditBox.clearFocus();
            requestFocusOnChildWeight(customChildInfoLayoutSix, getResources().getString(R.string.child_six_weight_warning));
            return false;
        } else if (childSixFlag && customChildInfoLayoutSix.stillBirthTB.isChecked() && customChildInfoLayoutSix.stillBirthType.getText().toString().equals("")) {
            checkVisibilityOfChildInfo(customChildInfoLayoutSix);
            customChildInfoLayoutSix.stillBirthTypeEditBox.clearFocus();
            requestFocusOnStillBirthType(customChildInfoLayoutSix, getResources().getString(R.string.child_six_still_birth_type_warning));
            return false;
        } else if (childSevenFlag && !customChildInfoLayoutSeven.sexMale.isChecked() && !customChildInfoLayoutSeven.sexFemale.isChecked()) {
            checkVisibilityOfChildInfo(customChildInfoLayoutSeven);
            customChildInfoLayoutSeven.childSexTxt.getParent().clearChildFocus(customChildInfoLayoutOne.childSexTxt);
            requestFocusOnChildGender(customChildInfoLayoutSeven, getResources().getString(R.string.child_seven_gender_warning));
            return false;
        } else if (childSevenFlag && customChildInfoLayoutSeven.weightEditBox.getText().toString().equals("")) {
            checkVisibilityOfChildInfo(customChildInfoLayoutSeven);
            customChildInfoLayoutSeven.weightEditBox.clearFocus();
            requestFocusOnChildWeight(customChildInfoLayoutSeven, getResources().getString(R.string.child_seven_weight_warning));
            return false;
        } else if (childSevenFlag && customChildInfoLayoutSeven.stillBirthTB.isChecked() && customChildInfoLayoutSeven.stillBirthType.getText().toString().equals("")) {
            checkVisibilityOfChildInfo(customChildInfoLayoutSeven);
            customChildInfoLayoutSeven.stillBirthTypeEditBox.clearFocus();
            requestFocusOnStillBirthType(customChildInfoLayoutSeven, getResources().getString(R.string.child_seven_still_birth_type_warning));
            return false;
        } else if (childEightFlag && !customChildInfoLayoutEight.sexMale.isChecked() && !customChildInfoLayoutEight.sexFemale.isChecked()) {
            checkVisibilityOfChildInfo(customChildInfoLayoutEight);
            customChildInfoLayoutEight.childSexTxt.getParent().clearChildFocus(customChildInfoLayoutOne.childSexTxt);
            requestFocusOnChildGender(customChildInfoLayoutEight, getResources().getString(R.string.child_eight_gender_warning));
            return false;
        } else if (childEightFlag && customChildInfoLayoutEight.weightEditBox.getText().toString().equals("")) {
            checkVisibilityOfChildInfo(customChildInfoLayoutEight);
            customChildInfoLayoutEight.weightEditBox.clearFocus();
            requestFocusOnChildWeight(customChildInfoLayoutEight, getResources().getString(R.string.child_eight_weight_warning));
            return false;
        } else if (childEightFlag && customChildInfoLayoutEight.stillBirthTB.isChecked() && customChildInfoLayoutEight.stillBirthType.getText().toString().equals("")) {
            checkVisibilityOfChildInfo(customChildInfoLayoutEight);
            customChildInfoLayoutEight.stillBirthTypeEditBox.clearFocus();
            requestFocusOnStillBirthType(customChildInfoLayoutEight, getResources().getString(R.string.child_eight_still_birth_type_warning));
            return false;
        } else if (childNineFlag && !customChildInfoLayoutNine.sexMale.isChecked() && !customChildInfoLayoutNine.sexFemale.isChecked()) {
            checkVisibilityOfChildInfo(customChildInfoLayoutNine);
            customChildInfoLayoutNine.childSexTxt.getParent().clearChildFocus(customChildInfoLayoutOne.childSexTxt);
            requestFocusOnChildGender(customChildInfoLayoutNine, getResources().getString(R.string.child_nine_gender_warning));
            return false;
        } else if (childNineFlag && customChildInfoLayoutNine.weightEditBox.getText().toString().equals("")) {
            checkVisibilityOfChildInfo(customChildInfoLayoutNine);
            customChildInfoLayoutNine.weightEditBox.clearFocus();
            requestFocusOnChildWeight(customChildInfoLayoutNine, getResources().getString(R.string.child_nine_weight_warning));
            return false;
        } else if (childNineFlag && customChildInfoLayoutNine.stillBirthTB.isChecked() && customChildInfoLayoutNine.stillBirthType.getText().toString().equals("")) {
            checkVisibilityOfChildInfo(customChildInfoLayoutNine);
            customChildInfoLayoutNine.stillBirthTypeEditBox.clearFocus();
            requestFocusOnStillBirthType(customChildInfoLayoutNine, getResources().getString(R.string.child_nine_still_birth_type_warning));
            return false;
        } else if (childTenFlag && !customChildInfoLayoutTen.sexMale.isChecked() && !customChildInfoLayoutTen.sexFemale.isChecked()) {
            checkVisibilityOfChildInfo(customChildInfoLayoutTen);
            customChildInfoLayoutTen.childSexTxt.getParent().clearChildFocus(customChildInfoLayoutOne.childSexTxt);
            requestFocusOnChildGender(customChildInfoLayoutTen, getResources().getString(R.string.child_ten_gender_warning));
            return false;
        } else if (childTenFlag && customChildInfoLayoutTen.weightEditBox.getText().toString().equals("")) {
            checkVisibilityOfChildInfo(customChildInfoLayoutTen);
            customChildInfoLayoutTen.weightEditBox.clearFocus();
            requestFocusOnChildWeight(customChildInfoLayoutTen, getResources().getString(R.string.child_ten_weight_warning));
            return false;
        } else if (childTenFlag && customChildInfoLayoutTen.stillBirthTB.isChecked() && customChildInfoLayoutTen.stillBirthType.getText().toString().equals("")) {
            checkVisibilityOfChildInfo(customChildInfoLayoutTen);
            customChildInfoLayoutTen.stillBirthTypeEditBox.clearFocus();
            requestFocusOnStillBirthType(customChildInfoLayoutTen, getResources().getString(R.string.child_ten_still_birth_type_warning));
            return false;
        } else if (bloodTransfusion.isChecked() && noOfPints.getText().toString().equals("")) {
            noOfPints.clearFocus();
            noOfPints.requestFocus();
            showErrorMessage(getResources().getString(R.string.no_of_pints_warning));
            return false;
        } else if (typeOfJsy.getText().toString().equals("")) {
            typeOfJsy.clearFocus();
            typeOfJsy.requestFocus();
            showErrorMessage(getResources().getString(R.string.jsy_type_warning));
            return false;
        } else {
            return true;
        }
    }

    public void checkVisibilityOfChildInfo(CustomChildInfoLayout customChildInfoLayout) {
        if (customChildInfoLayout.collapseView.getVisibility() == View.GONE) {
            customChildInfoLayout.collapseViewFlag = true;
            customChildInfoLayout.collapseView.setVisibility(View.VISIBLE);
            customChildInfoLayout.expandCollapseImgBtn.setBackgroundResource(R.drawable.collapse_arrow);
        }
    }

    public void checkVisibilityOfChildStatus(CustomChildStatusLayout customChildStatusLayout) {
        if (customChildStatusLayout.collapseView.getVisibility() == View.GONE) {
            customChildStatusLayout.childStatusFlag = true;
            customChildStatusLayout.collapseView.setVisibility(View.VISIBLE);
            customChildStatusLayout.expandCollapseImgBtn.setBackgroundResource(R.drawable.collapse_arrow);
        }
    }

    public boolean checkChildStatusMandatoryFields() {

        if (childStatusOneFlag && customChildStatusLayoutOne != null && !customChildStatusLayoutOne.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutOne.childStatusET.getText().toString()) == CHILD_STATUS_DISCHARGED_TYPE_DETAIL_ID)
                && customChildStatusLayoutOne.dischargeDateTimeChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutOne);
            customChildStatusLayoutOne.dischargeDateTimeChildET.clearFocus();
            customChildStatusLayoutOne.dischargeDateTimeChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_child_discharge_date_time_one_child));
            return false;
        } else if (childStatusOneFlag && customChildStatusLayoutOne != null && !customChildStatusLayoutOne.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutOne.childStatusET.getText().toString()) == CHILD_STATUS_DISCHARGED_TYPE_DETAIL_ID)
                && customChildStatusLayoutOne.dischargeWeightChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutOne);
            customChildStatusLayoutOne.dischargeWeightChildET.clearFocus();
            customChildStatusLayoutOne.dischargeWeightChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_child_discharge_weight_one_child));
            return false;
        } else if (childStatusOneFlag && childStatusOneFlag && customChildStatusLayoutOne != null && !customChildStatusLayoutOne.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutOne.childStatusET.getText().toString()) == CHILD_STATUS_DISCHARGED_TYPE_DETAIL_ID)
                && customChildStatusLayoutOne.transportToHomeChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutOne);
            customChildStatusLayoutOne.transportToHomeChildET.clearFocus();
            customChildStatusLayoutOne.transportToHomeChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_transport_to_home_one_child));
            return false;
        } else if (childStatusOneFlag && customChildStatusLayoutOne != null && !customChildStatusLayoutOne.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutOne.childStatusET.getText().toString()) == CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID)
                && customChildStatusLayoutOne.referredDateTimeChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutOne);
            customChildStatusLayoutOne.referredDateTimeChildET.clearFocus();
            customChildStatusLayoutOne.referredDateTimeChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_refered_date_time_one_child));
            return false;
        } else if (childStatusOneFlag && customChildStatusLayoutOne != null && !customChildStatusLayoutOne.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutOne.childStatusET.getText().toString()) == CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID)
                && customChildStatusLayoutOne.referredByChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutOne);
            customChildStatusLayoutOne.referredByChildET.clearFocus();
            customChildStatusLayoutOne.referredByChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_refered_by_child_one_child));
            return false;
        } else if (childStatusOneFlag && customChildStatusLayoutOne != null && !customChildStatusLayoutOne.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutOne.childStatusET.getText().toString()) == CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID)
                && customChildStatusLayoutOne.referredCauseChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutOne);
            customChildStatusLayoutOne.referredCauseChildET.clearFocus();
            customChildStatusLayoutOne.referredCauseChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_refered_cause_one_child));
            return false;
        } else if (childStatusOneFlag && customChildStatusLayoutOne != null && !customChildStatusLayoutOne.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutOne.childStatusET.getText().toString()) == CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID)
                && customChildStatusLayoutOne.childReferredOtherCauseET.getVisibility() == View.VISIBLE
                && customChildStatusLayoutOne.childReferredOtherCauseET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutOne);
            customChildStatusLayoutOne.childReferredOtherCauseET.clearFocus();
            customChildStatusLayoutOne.childReferredOtherCauseET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_other_refered_cause_one_child));
            return false;
        } else if (customChildStatusLayoutOne != null && !customChildStatusLayoutOne.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutOne.childStatusET.getText().toString()) == CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID)
                && customChildStatusLayoutOne.referredTransportChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutOne);
            customChildStatusLayoutOne.referredTransportChildET.clearFocus();
            customChildStatusLayoutOne.referredTransportChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_refered_transport_one_child));
            return false;
        } else if (childStatusOneFlag && customChildStatusLayoutOne != null && !customChildStatusLayoutOne.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutOne.childStatusET.getText().toString()) == CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID)
                && customChildStatusLayoutOne.referredAreaChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutOne);
            customChildStatusLayoutOne.referredAreaChildET.clearFocus();
            customChildStatusLayoutOne.referredAreaChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_refered_to_facility_one_child));
            return false;
        } else if (childStatusOneFlag && customChildStatusLayoutOne != null && !customChildStatusLayoutOne.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutOne.childStatusET.getText().toString()) == CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID)
                && customChildStatusLayoutOne.referredOtherAreaChildET.getVisibility() == View.VISIBLE
                && customChildStatusLayoutOne.referredOtherAreaChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutOne);
            customChildStatusLayoutOne.referredOtherAreaChildET.clearFocus();
            customChildStatusLayoutOne.referredOtherAreaChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_other_refered_facility_one_child));
            return false;
        } else if (customChildStatusLayoutOne != null && !customChildStatusLayoutOne.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutOne.childStatusET.getText().toString()) == CHILD_STATUS_DEATH_TYPE_DETAIL_ID)
                && customChildStatusLayoutOne.childDeathCauseET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutOne);
            customChildStatusLayoutOne.childDeathCauseET.clearFocus();
            customChildStatusLayoutOne.childDeathCauseET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_death_cause_one_child));
            return false;
        } else if (childStatusOneFlag && customChildStatusLayoutOne != null && !customChildStatusLayoutOne.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutOne.childStatusET.getText().toString()) == CHILD_STATUS_DEATH_TYPE_DETAIL_ID)
                && customChildStatusLayoutOne.childDeathDateTimeET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutOne);
            customChildStatusLayoutOne.childDeathDateTimeET.clearFocus();
            customChildStatusLayoutOne.childDeathDateTimeET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_death_and_time_one_child));
            return false;
        } else if (childStatusOneFlag && customChildStatusLayoutOne != null && !customChildStatusLayoutOne.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutOne.childStatusET.getText().toString()) == CHILD_STATUS_LAMA_TYPE_DETAIL_ID)
                && customChildStatusLayoutOne.lamaDateTimeChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutOne);
            customChildStatusLayoutOne.lamaDateTimeChildET.clearFocus();
            customChildStatusLayoutOne.lamaDateTimeChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_lama_date__and_time_one_child));
            return false;
        } else if (childStatusTwoFlag && customChildStatusLayoutTwo != null && !customChildStatusLayoutTwo.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutTwo.childStatusET.getText().toString()) == CHILD_STATUS_DISCHARGED_TYPE_DETAIL_ID)
                && customChildStatusLayoutTwo.dischargeDateTimeChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutTwo);
            customChildStatusLayoutTwo.dischargeDateTimeChildET.clearFocus();
            customChildStatusLayoutTwo.dischargeDateTimeChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_child_discharge_date_time_two_child));
            return false;
        } else if (childStatusTwoFlag && customChildStatusLayoutTwo != null && !customChildStatusLayoutTwo.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutTwo.childStatusET.getText().toString()) == CHILD_STATUS_DISCHARGED_TYPE_DETAIL_ID)
                && customChildStatusLayoutTwo.dischargeWeightChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutTwo);
            customChildStatusLayoutTwo.dischargeWeightChildET.clearFocus();
            customChildStatusLayoutTwo.dischargeWeightChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_child_discharge_weight_two_child));
            return false;
        } else if (childStatusTwoFlag && customChildStatusLayoutTwo != null && !customChildStatusLayoutTwo.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutTwo.childStatusET.getText().toString()) == CHILD_STATUS_DISCHARGED_TYPE_DETAIL_ID)
                && customChildStatusLayoutTwo.transportToHomeChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutTwo);
            customChildStatusLayoutTwo.transportToHomeChildET.clearFocus();
            customChildStatusLayoutTwo.transportToHomeChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_transport_to_home_two_child));
            return false;
        } else if (childStatusTwoFlag && customChildStatusLayoutTwo != null && !customChildStatusLayoutTwo.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutTwo.childStatusET.getText().toString()) == CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID)
                && customChildStatusLayoutTwo.referredDateTimeChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutTwo);
            customChildStatusLayoutTwo.referredDateTimeChildET.clearFocus();
            customChildStatusLayoutTwo.referredDateTimeChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_refered_date_time_two_child));
            return false;
        } else if (childStatusTwoFlag && customChildStatusLayoutTwo != null && !customChildStatusLayoutTwo.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutTwo.childStatusET.getText().toString()) == CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID)
                && customChildStatusLayoutTwo.referredByChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutTwo);
            customChildStatusLayoutTwo.referredByChildET.clearFocus();
            customChildStatusLayoutTwo.referredByChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_refered_by_child_two_child));
            return false;
        } else if (childStatusTwoFlag && customChildStatusLayoutTwo != null && !customChildStatusLayoutTwo.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutTwo.childStatusET.getText().toString()) == CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID)
                && customChildStatusLayoutTwo.referredCauseChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutTwo);
            customChildStatusLayoutTwo.referredCauseChildET.clearFocus();
            customChildStatusLayoutTwo.referredCauseChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_refered_cause_two_child));
            return false;
        } else if (childStatusTwoFlag && customChildStatusLayoutTwo != null && !customChildStatusLayoutTwo.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutTwo.childStatusET.getText().toString()) == CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID)
                && customChildStatusLayoutTwo.childReferredOtherCauseET.getVisibility() == View.VISIBLE
                && customChildStatusLayoutTwo.childReferredOtherCauseET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutTwo);
            customChildStatusLayoutTwo.childReferredOtherCauseET.clearFocus();
            customChildStatusLayoutTwo.childReferredOtherCauseET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_other_refered_cause_two_child));
            return false;
        } else if (childStatusTwoFlag && customChildStatusLayoutTwo != null && !customChildStatusLayoutTwo.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutTwo.childStatusET.getText().toString()) == CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID)
                && customChildStatusLayoutTwo.referredTransportChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutTwo);
            customChildStatusLayoutTwo.referredTransportChildET.clearFocus();
            customChildStatusLayoutTwo.referredTransportChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_refered_transport_two_child));
            return false;
        } else if (childStatusTwoFlag && customChildStatusLayoutTwo != null && !customChildStatusLayoutTwo.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutTwo.childStatusET.getText().toString()) == CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID)
                && customChildStatusLayoutTwo.referredAreaChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutTwo);
            customChildStatusLayoutTwo.referredAreaChildET.clearFocus();
            customChildStatusLayoutTwo.referredAreaChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_refered_to_facility_two_child));
            return false;
        } else if (childStatusTwoFlag && customChildStatusLayoutTwo != null && !customChildStatusLayoutTwo.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutTwo.childStatusET.getText().toString()) == CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID)
                && customChildStatusLayoutTwo.referredOtherAreaChildET.getVisibility() == View.VISIBLE
                && customChildStatusLayoutTwo.referredOtherAreaChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutTwo);
            customChildStatusLayoutTwo.referredOtherAreaChildET.clearFocus();
            customChildStatusLayoutTwo.referredOtherAreaChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_other_refered_facility_two_child));
            return false;
        } else if (childStatusTwoFlag && customChildStatusLayoutTwo != null && !customChildStatusLayoutTwo.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutTwo.childStatusET.getText().toString()) == CHILD_STATUS_DEATH_TYPE_DETAIL_ID)
                && customChildStatusLayoutTwo.childDeathCauseET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutTwo);
            customChildStatusLayoutTwo.childDeathCauseET.clearFocus();
            customChildStatusLayoutTwo.childDeathCauseET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_death_cause_two_child));
            return false;
        } else if (childStatusTwoFlag && customChildStatusLayoutTwo != null && !customChildStatusLayoutTwo.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutTwo.childStatusET.getText().toString()) == CHILD_STATUS_DEATH_TYPE_DETAIL_ID)
                && customChildStatusLayoutTwo.childDeathDateTimeET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutTwo);
            customChildStatusLayoutTwo.childDeathDateTimeET.clearFocus();
            customChildStatusLayoutTwo.childDeathDateTimeET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_death_and_time_two_child));
            return false;
        } else if (childStatusTwoFlag && customChildStatusLayoutTwo != null && !customChildStatusLayoutTwo.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutTwo.childStatusET.getText().toString()) == CHILD_STATUS_LAMA_TYPE_DETAIL_ID)
                && customChildStatusLayoutTwo.lamaDateTimeChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutTwo);
            customChildStatusLayoutTwo.lamaDateTimeChildET.clearFocus();
            customChildStatusLayoutTwo.lamaDateTimeChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_lama_date__and_time_two_child));
            return false;
        } else if (childStatusThreeFlag && customChildStatusLayoutThree != null && !customChildStatusLayoutThree.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutThree.childStatusET.getText().toString()) == CHILD_STATUS_DISCHARGED_TYPE_DETAIL_ID)
                && customChildStatusLayoutThree.dischargeDateTimeChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutThree);
            customChildStatusLayoutThree.dischargeDateTimeChildET.clearFocus();
            customChildStatusLayoutThree.dischargeDateTimeChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_child_discharge_date_time_three_child));
            return false;
        } else if (childStatusThreeFlag && customChildStatusLayoutThree != null && !customChildStatusLayoutThree.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutThree.childStatusET.getText().toString()) == CHILD_STATUS_DISCHARGED_TYPE_DETAIL_ID)
                && customChildStatusLayoutThree.dischargeWeightChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutThree);
            customChildStatusLayoutThree.dischargeWeightChildET.clearFocus();
            customChildStatusLayoutThree.dischargeWeightChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_child_discharge_weight_three_child));
            return false;
        } else if (childStatusThreeFlag && customChildStatusLayoutThree != null && !customChildStatusLayoutThree.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutThree.childStatusET.getText().toString()) == CHILD_STATUS_DISCHARGED_TYPE_DETAIL_ID)
                && customChildStatusLayoutThree.transportToHomeChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutThree);
            customChildStatusLayoutThree.transportToHomeChildET.clearFocus();
            customChildStatusLayoutThree.transportToHomeChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_transport_to_home_three_child));
            return false;
        } else if (childStatusThreeFlag && customChildStatusLayoutThree != null && !customChildStatusLayoutThree.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutThree.childStatusET.getText().toString()) == CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID)
                && customChildStatusLayoutThree.referredDateTimeChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutThree);
            customChildStatusLayoutThree.referredDateTimeChildET.clearFocus();
            customChildStatusLayoutThree.referredDateTimeChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_refered_date_time_three_child));
            return false;
        } else if (childStatusThreeFlag && customChildStatusLayoutThree != null && !customChildStatusLayoutThree.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutThree.childStatusET.getText().toString()) == CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID)
                && customChildStatusLayoutThree.referredByChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutThree);
            customChildStatusLayoutThree.referredByChildET.clearFocus();
            customChildStatusLayoutThree.referredByChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_refered_by_child_three_child));
            return false;
        } else if (childStatusThreeFlag && customChildStatusLayoutThree != null && !customChildStatusLayoutThree.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutThree.childStatusET.getText().toString()) == CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID)
                && customChildStatusLayoutThree.referredCauseChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutThree);
            customChildStatusLayoutThree.referredCauseChildET.clearFocus();
            customChildStatusLayoutThree.referredCauseChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_refered_cause_three_child));
            return false;
        } else if (childStatusThreeFlag && customChildStatusLayoutThree != null && !customChildStatusLayoutThree.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutThree.childStatusET.getText().toString()) == CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID)
                && customChildStatusLayoutThree.childReferredOtherCauseET.getVisibility() == View.VISIBLE
                && customChildStatusLayoutThree.childReferredOtherCauseET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutThree);
            customChildStatusLayoutThree.childReferredOtherCauseET.clearFocus();
            customChildStatusLayoutThree.childReferredOtherCauseET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_other_refered_cause_three_child));
            return false;
        } else if (childStatusThreeFlag && customChildStatusLayoutThree != null && !customChildStatusLayoutThree.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutThree.childStatusET.getText().toString()) == CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID)
                && customChildStatusLayoutThree.referredTransportChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutThree);
            customChildStatusLayoutThree.referredTransportChildET.clearFocus();
            customChildStatusLayoutThree.referredTransportChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_refered_transport_three_child));
            return false;
        } else if (childStatusThreeFlag && customChildStatusLayoutThree != null && !customChildStatusLayoutThree.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutThree.childStatusET.getText().toString()) == CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID)
                && customChildStatusLayoutThree.referredAreaChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutThree);
            customChildStatusLayoutThree.referredAreaChildET.clearFocus();
            customChildStatusLayoutThree.referredAreaChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_refered_to_facility_three_child));
            return false;
        } else if (childStatusThreeFlag && customChildStatusLayoutThree != null && !customChildStatusLayoutThree.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutThree.childStatusET.getText().toString()) == CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID)
                && customChildStatusLayoutThree.referredOtherAreaChildET.getVisibility() == View.VISIBLE
                && customChildStatusLayoutThree.referredOtherAreaChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutThree);
            customChildStatusLayoutThree.referredOtherAreaChildET.clearFocus();
            customChildStatusLayoutThree.referredOtherAreaChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_other_refered_facility_three_child));
            return false;
        } else if (childStatusThreeFlag && customChildStatusLayoutThree != null && !customChildStatusLayoutThree.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutThree.childStatusET.getText().toString()) == CHILD_STATUS_DEATH_TYPE_DETAIL_ID)
                && customChildStatusLayoutThree.childDeathCauseET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutThree);
            customChildStatusLayoutThree.childDeathCauseET.clearFocus();
            customChildStatusLayoutThree.childDeathCauseET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_death_cause_three_child));
            return false;
        } else if (childStatusThreeFlag && customChildStatusLayoutThree != null && !customChildStatusLayoutThree.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutThree.childStatusET.getText().toString()) == CHILD_STATUS_DEATH_TYPE_DETAIL_ID)
                && customChildStatusLayoutThree.childDeathDateTimeET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutThree);
            customChildStatusLayoutThree.childDeathDateTimeET.clearFocus();
            customChildStatusLayoutThree.childDeathDateTimeET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_death_and_time_three_child));
            return false;
        } else if (childStatusThreeFlag && customChildStatusLayoutThree != null && !customChildStatusLayoutThree.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutThree.childStatusET.getText().toString()) == CHILD_STATUS_LAMA_TYPE_DETAIL_ID)
                && customChildStatusLayoutThree.lamaDateTimeChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutThree);
            customChildStatusLayoutThree.lamaDateTimeChildET.clearFocus();
            customChildStatusLayoutThree.lamaDateTimeChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_lama_date__and_time_three_child));
            return false;
        } else if (childStatusFourFlag && customChildStatusLayoutFour != null && !customChildStatusLayoutFour.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutFour.childStatusET.getText().toString()) == CHILD_STATUS_DISCHARGED_TYPE_DETAIL_ID)
                && customChildStatusLayoutFour.dischargeDateTimeChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutFour);
            customChildStatusLayoutFour.dischargeDateTimeChildET.clearFocus();
            customChildStatusLayoutFour.dischargeDateTimeChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_child_discharge_date_time_four_child));
            return false;
        } else if (childStatusFourFlag && customChildStatusLayoutFour != null && !customChildStatusLayoutFour.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutFour.childStatusET.getText().toString()) == CHILD_STATUS_DISCHARGED_TYPE_DETAIL_ID)
                && customChildStatusLayoutFour.dischargeWeightChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutFour);
            customChildStatusLayoutFour.dischargeWeightChildET.clearFocus();
            customChildStatusLayoutFour.dischargeWeightChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_child_discharge_weight_four_child));
            return false;
        } else if (childStatusFourFlag && customChildStatusLayoutFour != null && !customChildStatusLayoutFour.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutFour.childStatusET.getText().toString()) == CHILD_STATUS_DISCHARGED_TYPE_DETAIL_ID)
                && customChildStatusLayoutFour.transportToHomeChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutFour);
            customChildStatusLayoutFour.transportToHomeChildET.clearFocus();
            customChildStatusLayoutFour.transportToHomeChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_transport_to_home_four_child));
            return false;
        } else if (childStatusFourFlag && customChildStatusLayoutFour != null && !customChildStatusLayoutFour.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutFour.childStatusET.getText().toString()) == CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID)
                && customChildStatusLayoutFour.referredDateTimeChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutFour);
            customChildStatusLayoutFour.referredDateTimeChildET.clearFocus();
            customChildStatusLayoutFour.referredDateTimeChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_refered_date_time_four_child));
            return false;
        } else if (childStatusFourFlag && customChildStatusLayoutFour != null && !customChildStatusLayoutFour.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutFour.childStatusET.getText().toString()) == CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID)
                && customChildStatusLayoutFour.referredByChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutFour);
            customChildStatusLayoutFour.referredByChildET.clearFocus();
            customChildStatusLayoutFour.referredByChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_refered_by_child_four_child));
            return false;
        } else if (childStatusFourFlag && customChildStatusLayoutFour != null && !customChildStatusLayoutFour.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutFour.childStatusET.getText().toString()) == CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID)
                && customChildStatusLayoutFour.referredCauseChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutFour);
            customChildStatusLayoutFour.referredCauseChildET.clearFocus();
            customChildStatusLayoutFour.referredCauseChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_refered_cause_four_child));
            return false;
        } else if (childStatusFourFlag && customChildStatusLayoutFour != null && !customChildStatusLayoutFour.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutFour.childStatusET.getText().toString()) == CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID)
                && customChildStatusLayoutFour.childReferredOtherCauseET.getVisibility() == View.VISIBLE
                && customChildStatusLayoutFour.childReferredOtherCauseET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutFour);
            customChildStatusLayoutFour.childReferredOtherCauseET.clearFocus();
            customChildStatusLayoutFour.childReferredOtherCauseET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_other_refered_cause_four_child));
            return false;
        } else if (childStatusFourFlag && customChildStatusLayoutFour != null && !customChildStatusLayoutFour.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutFour.childStatusET.getText().toString()) == CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID)
                && customChildStatusLayoutFour.referredTransportChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutFour);
            customChildStatusLayoutFour.referredTransportChildET.clearFocus();
            customChildStatusLayoutFour.referredTransportChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_refered_transport_four_child));
            return false;
        } else if (childStatusFourFlag && customChildStatusLayoutFour != null && !customChildStatusLayoutFour.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutFour.childStatusET.getText().toString()) == CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID)
                && customChildStatusLayoutFour.referredAreaChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutFour);
            customChildStatusLayoutFour.referredAreaChildET.clearFocus();
            customChildStatusLayoutFour.referredAreaChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_refered_to_facility_four_child));
            return false;
        } else if (childStatusFourFlag && customChildStatusLayoutFour != null && !customChildStatusLayoutFour.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutFour.childStatusET.getText().toString()) == CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID)
                && customChildStatusLayoutFour.referredOtherAreaChildET.getVisibility() == View.VISIBLE
                && customChildStatusLayoutFour.referredOtherAreaChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutFour);
            customChildStatusLayoutFour.referredOtherAreaChildET.clearFocus();
            customChildStatusLayoutFour.referredOtherAreaChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_other_refered_facility_four_child));
            return false;
        } else if (childStatusFourFlag && customChildStatusLayoutFour != null && !customChildStatusLayoutFour.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutFour.childStatusET.getText().toString()) == CHILD_STATUS_DEATH_TYPE_DETAIL_ID)
                && customChildStatusLayoutFour.childDeathCauseET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutFour);
            customChildStatusLayoutFour.childDeathCauseET.clearFocus();
            customChildStatusLayoutFour.childDeathCauseET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_death_cause_four_child));
            return false;
        } else if (childStatusFourFlag && customChildStatusLayoutFour != null && !customChildStatusLayoutFour.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutFour.childStatusET.getText().toString()) == CHILD_STATUS_DEATH_TYPE_DETAIL_ID)
                && customChildStatusLayoutFour.childDeathDateTimeET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutFour);
            customChildStatusLayoutFour.childDeathDateTimeET.clearFocus();
            customChildStatusLayoutFour.childDeathDateTimeET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_death_and_time_four_child));
            return false;
        } else if (childStatusFourFlag && customChildStatusLayoutFour != null && !customChildStatusLayoutFour.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutFour.childStatusET.getText().toString()) == CHILD_STATUS_LAMA_TYPE_DETAIL_ID)
                && customChildStatusLayoutFour.lamaDateTimeChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutFour);
            customChildStatusLayoutFour.lamaDateTimeChildET.clearFocus();
            customChildStatusLayoutFour.lamaDateTimeChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_lama_date__and_time_four_child));
            return false;
        } else if (childStatusFiveFlag && customChildStatusLayoutFive != null && !customChildStatusLayoutFive.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutFive.childStatusET.getText().toString()) == CHILD_STATUS_DISCHARGED_TYPE_DETAIL_ID)
                && customChildStatusLayoutFive.dischargeDateTimeChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutFive);
            customChildStatusLayoutFive.dischargeDateTimeChildET.clearFocus();
            customChildStatusLayoutFive.dischargeDateTimeChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_child_discharge_date_time_five_child));
            return false;
        } else if (childStatusFiveFlag && customChildStatusLayoutFive != null && !customChildStatusLayoutFive.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutFive.childStatusET.getText().toString()) == CHILD_STATUS_DISCHARGED_TYPE_DETAIL_ID)
                && customChildStatusLayoutFive.dischargeWeightChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutFive);
            customChildStatusLayoutFive.dischargeWeightChildET.clearFocus();
            customChildStatusLayoutFive.dischargeWeightChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_child_discharge_weight_five_child));
            return false;
        } else if (childStatusFiveFlag && customChildStatusLayoutFive != null && !customChildStatusLayoutFive.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutFive.childStatusET.getText().toString()) == CHILD_STATUS_DISCHARGED_TYPE_DETAIL_ID)
                && customChildStatusLayoutFive.transportToHomeChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutFive);
            customChildStatusLayoutFive.transportToHomeChildET.clearFocus();
            customChildStatusLayoutFive.transportToHomeChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_transport_to_home_five_child));
            return false;
        } else if (childStatusFiveFlag && customChildStatusLayoutFive != null && !customChildStatusLayoutFive.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutFive.childStatusET.getText().toString()) == CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID)
                && customChildStatusLayoutFive.referredDateTimeChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutFive);
            customChildStatusLayoutFive.referredDateTimeChildET.clearFocus();
            customChildStatusLayoutFive.referredDateTimeChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_refered_date_time_five_child));
            return false;
        } else if (childStatusFiveFlag && customChildStatusLayoutFive != null && !customChildStatusLayoutFive.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutFive.childStatusET.getText().toString()) == CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID)
                && customChildStatusLayoutFive.referredByChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutFive);
            customChildStatusLayoutFive.referredByChildET.clearFocus();
            customChildStatusLayoutFive.referredByChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_refered_by_child_five_child));
            return false;
        } else if (childStatusFiveFlag && customChildStatusLayoutFive != null && !customChildStatusLayoutFive.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutFive.childStatusET.getText().toString()) == CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID)
                && customChildStatusLayoutFive.referredCauseChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutFive);
            customChildStatusLayoutFive.referredCauseChildET.clearFocus();
            customChildStatusLayoutFive.referredCauseChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_refered_cause_five_child));
            return false;
        } else if (childStatusFiveFlag && customChildStatusLayoutFive != null && !customChildStatusLayoutFive.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutFive.childStatusET.getText().toString()) == CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID)
                && customChildStatusLayoutFive.childReferredOtherCauseET.getVisibility() == View.VISIBLE
                && customChildStatusLayoutFive.childReferredOtherCauseET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutFive);
            customChildStatusLayoutFive.childReferredOtherCauseET.clearFocus();
            customChildStatusLayoutFive.childReferredOtherCauseET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_other_refered_cause_five_child));
            return false;
        } else if (childStatusFiveFlag && customChildStatusLayoutFive != null && !customChildStatusLayoutFive.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutFive.childStatusET.getText().toString()) == CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID)
                && customChildStatusLayoutFive.referredTransportChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutFive);
            customChildStatusLayoutFive.referredTransportChildET.clearFocus();
            customChildStatusLayoutFive.referredTransportChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_refered_transport_five_child));
            return false;
        } else if (childStatusFiveFlag && customChildStatusLayoutFive != null && !customChildStatusLayoutFive.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutFive.childStatusET.getText().toString()) == CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID)
                && customChildStatusLayoutFive.referredAreaChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutFive);
            customChildStatusLayoutFive.referredAreaChildET.clearFocus();
            customChildStatusLayoutFive.referredAreaChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_refered_to_facility_five_child));
            return false;
        } else if (childStatusFiveFlag && customChildStatusLayoutFive != null && !customChildStatusLayoutFive.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutFive.childStatusET.getText().toString()) == CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID)
                && customChildStatusLayoutFive.referredOtherAreaChildET.getVisibility() == View.VISIBLE
                && customChildStatusLayoutFive.referredOtherAreaChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutFive);
            customChildStatusLayoutFive.referredOtherAreaChildET.clearFocus();
            customChildStatusLayoutFive.referredOtherAreaChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_other_refered_facility_five_child));
            return false;
        } else if (childStatusFiveFlag && customChildStatusLayoutFive != null && !customChildStatusLayoutFive.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutFive.childStatusET.getText().toString()) == CHILD_STATUS_DEATH_TYPE_DETAIL_ID)
                && customChildStatusLayoutFive.childDeathCauseET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutFive);
            customChildStatusLayoutFive.childDeathCauseET.clearFocus();
            customChildStatusLayoutFive.childDeathCauseET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_death_cause_five_child));
            return false;
        } else if (childStatusFiveFlag && customChildStatusLayoutFive != null && !customChildStatusLayoutFive.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutFive.childStatusET.getText().toString()) == CHILD_STATUS_DEATH_TYPE_DETAIL_ID)
                && customChildStatusLayoutFive.childDeathDateTimeET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutFive);
            customChildStatusLayoutFive.childDeathDateTimeET.clearFocus();
            customChildStatusLayoutFive.childDeathDateTimeET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_death_and_time_five_child));
            return false;
        } else if (childStatusFiveFlag && customChildStatusLayoutFive != null && !customChildStatusLayoutFive.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutFive.childStatusET.getText().toString()) == CHILD_STATUS_LAMA_TYPE_DETAIL_ID)
                && customChildStatusLayoutFive.lamaDateTimeChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutFive);
            customChildStatusLayoutFive.lamaDateTimeChildET.clearFocus();
            customChildStatusLayoutFive.lamaDateTimeChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_lama_date__and_time_five_child));
            return false;
        } else if (childStatusSixFlag && customChildStatusLayoutSix != null && !customChildStatusLayoutSix.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutSix.childStatusET.getText().toString()) == CHILD_STATUS_DISCHARGED_TYPE_DETAIL_ID)
                && customChildStatusLayoutSix.dischargeDateTimeChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutSix);
            customChildStatusLayoutSix.dischargeDateTimeChildET.clearFocus();
            customChildStatusLayoutSix.dischargeDateTimeChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_child_discharge_date_time_six_child));
            return false;
        } else if (childStatusSixFlag && customChildStatusLayoutSix != null && !customChildStatusLayoutSix.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutSix.childStatusET.getText().toString()) == CHILD_STATUS_DISCHARGED_TYPE_DETAIL_ID)
                && customChildStatusLayoutSix.dischargeWeightChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutSix);
            customChildStatusLayoutSix.dischargeWeightChildET.clearFocus();
            customChildStatusLayoutSix.dischargeWeightChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_child_discharge_weight_six_child));
            return false;
        } else if (childStatusSixFlag && customChildStatusLayoutSix != null && !customChildStatusLayoutSix.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutSix.childStatusET.getText().toString()) == CHILD_STATUS_DISCHARGED_TYPE_DETAIL_ID)
                && customChildStatusLayoutSix.transportToHomeChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutSix);
            customChildStatusLayoutSix.transportToHomeChildET.clearFocus();
            customChildStatusLayoutSix.transportToHomeChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_transport_to_home_six_child));
            return false;
        } else if (childStatusSixFlag && customChildStatusLayoutSix != null && !customChildStatusLayoutSix.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutSix.childStatusET.getText().toString()) == CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID)
                && customChildStatusLayoutSix.referredDateTimeChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutSix);
            customChildStatusLayoutSix.referredDateTimeChildET.clearFocus();
            customChildStatusLayoutSix.referredDateTimeChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_refered_date_time_six_child));
            return false;
        } else if (childStatusSixFlag && customChildStatusLayoutSix != null && !customChildStatusLayoutSix.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutSix.childStatusET.getText().toString()) == CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID)
                && customChildStatusLayoutSix.referredByChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutSix);
            customChildStatusLayoutSix.referredByChildET.clearFocus();
            customChildStatusLayoutSix.referredByChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_refered_by_child_six_child));
            return false;
        } else if (childStatusSixFlag && customChildStatusLayoutSix != null && !customChildStatusLayoutSix.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutSix.childStatusET.getText().toString()) == CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID)
                && customChildStatusLayoutSix.referredCauseChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutSix);
            customChildStatusLayoutSix.referredCauseChildET.clearFocus();
            customChildStatusLayoutSix.referredCauseChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_refered_cause_six_child));
            return false;
        } else if (childStatusSixFlag && customChildStatusLayoutSix != null && !customChildStatusLayoutSix.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutSix.childStatusET.getText().toString()) == CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID)
                && customChildStatusLayoutSix.childReferredOtherCauseET.getVisibility() == View.VISIBLE
                && customChildStatusLayoutSix.childReferredOtherCauseET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutSix);
            customChildStatusLayoutSix.childReferredOtherCauseET.clearFocus();
            customChildStatusLayoutSix.childReferredOtherCauseET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_other_refered_cause_six_child));
            return false;
        } else if (childStatusSixFlag && customChildStatusLayoutSix != null && !customChildStatusLayoutSix.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutSix.childStatusET.getText().toString()) == CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID)
                && customChildStatusLayoutSix.referredTransportChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutSix);
            customChildStatusLayoutSix.referredTransportChildET.clearFocus();
            customChildStatusLayoutSix.referredTransportChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_refered_transport_six_child));
            return false;
        } else if (childStatusSixFlag && customChildStatusLayoutSix != null && !customChildStatusLayoutSix.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutSix.childStatusET.getText().toString()) == CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID)
                && customChildStatusLayoutSix.referredAreaChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutSix);
            customChildStatusLayoutSix.referredAreaChildET.clearFocus();
            customChildStatusLayoutSix.referredAreaChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_refered_to_facility_six_child));
            return false;
        } else if (childStatusSixFlag && customChildStatusLayoutSix != null && !customChildStatusLayoutSix.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutSix.childStatusET.getText().toString()) == CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID)
                && customChildStatusLayoutSix.referredOtherAreaChildET.getVisibility() == View.VISIBLE
                && customChildStatusLayoutSix.referredOtherAreaChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutSix);
            customChildStatusLayoutSix.referredOtherAreaChildET.clearFocus();
            customChildStatusLayoutSix.referredOtherAreaChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_other_refered_facility_six_child));
            return false;
        } else if (childStatusSixFlag && customChildStatusLayoutSix != null && !customChildStatusLayoutSix.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutSix.childStatusET.getText().toString()) == CHILD_STATUS_DEATH_TYPE_DETAIL_ID)
                && customChildStatusLayoutSix.childDeathCauseET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutSix);
            customChildStatusLayoutSix.childDeathCauseET.clearFocus();
            customChildStatusLayoutSix.childDeathCauseET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_death_cause_six_child));
            return false;
        } else if (childStatusSixFlag && customChildStatusLayoutSix != null && !customChildStatusLayoutSix.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutSix.childStatusET.getText().toString()) == CHILD_STATUS_DEATH_TYPE_DETAIL_ID)
                && customChildStatusLayoutSix.childDeathDateTimeET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutSix);
            customChildStatusLayoutSix.childDeathDateTimeET.clearFocus();
            customChildStatusLayoutSix.childDeathDateTimeET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_death_and_time_six_child));
            return false;
        } else if (childStatusSixFlag && customChildStatusLayoutSix != null && !customChildStatusLayoutSix.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutSix.childStatusET.getText().toString()) == CHILD_STATUS_LAMA_TYPE_DETAIL_ID)
                && customChildStatusLayoutSix.lamaDateTimeChildET.getText().toString().equals("")) {
            customChildStatusLayoutSix.lamaDateTimeChildET.clearFocus();
            customChildStatusLayoutSix.lamaDateTimeChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_lama_date__and_time_six_child));
            return false;
        } else if (childStatusSevenFlag && customChildStatusLayoutSeven != null && !customChildStatusLayoutSeven.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutSeven.childStatusET.getText().toString()) == CHILD_STATUS_DISCHARGED_TYPE_DETAIL_ID)
                && customChildStatusLayoutSeven.dischargeDateTimeChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutSeven);
            customChildStatusLayoutSeven.dischargeDateTimeChildET.clearFocus();
            customChildStatusLayoutSeven.dischargeDateTimeChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_child_discharge_date_time_seven_child));
            return false;
        } else if (childStatusSevenFlag && customChildStatusLayoutSeven != null && !customChildStatusLayoutSeven.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutSeven.childStatusET.getText().toString()) == CHILD_STATUS_DISCHARGED_TYPE_DETAIL_ID)
                && customChildStatusLayoutSeven.dischargeWeightChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutSeven);
            customChildStatusLayoutSeven.dischargeWeightChildET.clearFocus();
            customChildStatusLayoutSeven.dischargeWeightChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_child_discharge_weight_seven_child));
            return false;
        } else if (childStatusSevenFlag && customChildStatusLayoutSeven != null && !customChildStatusLayoutSeven.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutSeven.childStatusET.getText().toString()) == CHILD_STATUS_DISCHARGED_TYPE_DETAIL_ID)
                && customChildStatusLayoutSeven.transportToHomeChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutSeven);
            customChildStatusLayoutSeven.transportToHomeChildET.clearFocus();
            customChildStatusLayoutSeven.transportToHomeChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_transport_to_home_seven_child));
            return false;
        } else if (childStatusSevenFlag && customChildStatusLayoutSeven != null && !customChildStatusLayoutSeven.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutSeven.childStatusET.getText().toString()) == CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID)
                && customChildStatusLayoutSeven.referredDateTimeChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutSeven);
            customChildStatusLayoutSeven.referredDateTimeChildET.clearFocus();
            customChildStatusLayoutSeven.referredDateTimeChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_refered_date_time_seven_child));
            return false;
        } else if (childStatusSevenFlag && customChildStatusLayoutSeven != null && !customChildStatusLayoutSeven.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutSeven.childStatusET.getText().toString()) == CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID)
                && customChildStatusLayoutSeven.referredByChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutSeven);
            customChildStatusLayoutSeven.referredByChildET.clearFocus();
            customChildStatusLayoutSeven.referredByChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_refered_by_child_seven_child));
            return false;
        } else if (childStatusSevenFlag && customChildStatusLayoutSeven != null && !customChildStatusLayoutSeven.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutSeven.childStatusET.getText().toString()) == CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID)
                && customChildStatusLayoutSeven.referredCauseChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutSeven);
            customChildStatusLayoutSeven.referredCauseChildET.clearFocus();
            customChildStatusLayoutSeven.referredCauseChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_refered_cause_seven_child));
            return false;
        } else if (childStatusSevenFlag && customChildStatusLayoutSeven != null && !customChildStatusLayoutSeven.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutSeven.childStatusET.getText().toString()) == CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID)
                && customChildStatusLayoutSeven.childReferredOtherCauseET.getVisibility() == View.VISIBLE
                && customChildStatusLayoutSeven.childReferredOtherCauseET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutSeven);
            customChildStatusLayoutSeven.childReferredOtherCauseET.clearFocus();
            customChildStatusLayoutSeven.childReferredOtherCauseET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_other_refered_cause_seven_child));
            return false;
        } else if (childStatusSevenFlag && customChildStatusLayoutSeven != null && !customChildStatusLayoutSeven.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutSeven.childStatusET.getText().toString()) == CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID)
                && customChildStatusLayoutSeven.referredTransportChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutSeven);
            customChildStatusLayoutSeven.referredTransportChildET.clearFocus();
            customChildStatusLayoutSeven.referredTransportChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_refered_transport_seven_child));
            return false;
        } else if (childStatusSevenFlag && customChildStatusLayoutSeven != null && !customChildStatusLayoutSeven.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutSeven.childStatusET.getText().toString()) == CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID)
                && customChildStatusLayoutSeven.referredAreaChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutSeven);
            customChildStatusLayoutSeven.referredAreaChildET.clearFocus();
            customChildStatusLayoutSeven.referredAreaChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_refered_to_facility_seven_child));
            return false;
        } else if (childStatusSevenFlag && customChildStatusLayoutSeven != null && !customChildStatusLayoutSeven.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutSeven.childStatusET.getText().toString()) == CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID)
                && customChildStatusLayoutSeven.referredOtherAreaChildET.getVisibility() == View.VISIBLE
                && customChildStatusLayoutSeven.referredOtherAreaChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutSeven);
            customChildStatusLayoutSeven.referredOtherAreaChildET.clearFocus();
            customChildStatusLayoutSeven.referredOtherAreaChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_other_refered_facility_seven_child));
            return false;
        } else if (childStatusSevenFlag && customChildStatusLayoutSeven != null && !customChildStatusLayoutSeven.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutSeven.childStatusET.getText().toString()) == CHILD_STATUS_DEATH_TYPE_DETAIL_ID)
                && customChildStatusLayoutSeven.childDeathCauseET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutSeven);
            customChildStatusLayoutSeven.childDeathCauseET.clearFocus();
            customChildStatusLayoutSeven.childDeathCauseET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_death_cause_seven_child));
            return false;
        } else if (childStatusSevenFlag && customChildStatusLayoutSeven != null && !customChildStatusLayoutSeven.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutSeven.childStatusET.getText().toString()) == CHILD_STATUS_DEATH_TYPE_DETAIL_ID)
                && customChildStatusLayoutSeven.childDeathDateTimeET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutSeven);
            customChildStatusLayoutSeven.childDeathDateTimeET.clearFocus();
            customChildStatusLayoutSeven.childDeathDateTimeET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_death_and_time_seven_child));
            return false;
        } else if (childStatusSevenFlag && customChildStatusLayoutSeven != null && !customChildStatusLayoutSeven.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutSeven.childStatusET.getText().toString()) == CHILD_STATUS_LAMA_TYPE_DETAIL_ID)
                && customChildStatusLayoutSeven.lamaDateTimeChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutSeven);
            customChildStatusLayoutSeven.lamaDateTimeChildET.clearFocus();
            customChildStatusLayoutSeven.lamaDateTimeChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_lama_date__and_time_seven_child));
            return false;
        } else if (childStatusEightFlag && customChildStatusLayoutEight != null && !customChildStatusLayoutEight.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutEight.childStatusET.getText().toString()) == CHILD_STATUS_DISCHARGED_TYPE_DETAIL_ID)
                && customChildStatusLayoutEight.dischargeDateTimeChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutSeven);
            customChildStatusLayoutEight.dischargeDateTimeChildET.clearFocus();
            customChildStatusLayoutEight.dischargeDateTimeChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_child_discharge_date_time_eight_child));
            return false;
        } else if (childStatusEightFlag && customChildStatusLayoutEight != null && !customChildStatusLayoutEight.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutEight.childStatusET.getText().toString()) == CHILD_STATUS_DISCHARGED_TYPE_DETAIL_ID)
                && customChildStatusLayoutEight.dischargeWeightChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutEight);
            customChildStatusLayoutEight.dischargeWeightChildET.clearFocus();
            customChildStatusLayoutEight.dischargeWeightChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_child_discharge_weight_eight_child));
            return false;
        } else if (childStatusEightFlag && customChildStatusLayoutEight != null && !customChildStatusLayoutEight.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutEight.childStatusET.getText().toString()) == CHILD_STATUS_DISCHARGED_TYPE_DETAIL_ID)
                && customChildStatusLayoutEight.transportToHomeChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutEight);
            customChildStatusLayoutEight.transportToHomeChildET.clearFocus();
            customChildStatusLayoutEight.transportToHomeChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_transport_to_home_eight_child));
            return false;
        } else if (childStatusEightFlag && customChildStatusLayoutEight != null && !customChildStatusLayoutEight.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutEight.childStatusET.getText().toString()) == CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID)
                && customChildStatusLayoutEight.referredDateTimeChildET.getText().toString().equals("")) {
            customChildStatusLayoutEight.referredDateTimeChildET.clearFocus();
            customChildStatusLayoutEight.referredDateTimeChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_refered_date_time_eight_child));
            return false;
        } else if (childStatusEightFlag && customChildStatusLayoutEight != null && !customChildStatusLayoutEight.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutEight.childStatusET.getText().toString()) == CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID)
                && customChildStatusLayoutEight.referredByChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutEight);
            customChildStatusLayoutEight.referredByChildET.clearFocus();
            customChildStatusLayoutEight.referredByChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_refered_by_child_eight_child));
            return false;
        } else if (childStatusEightFlag && customChildStatusLayoutEight != null && !customChildStatusLayoutEight.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutEight.childStatusET.getText().toString()) == CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID)
                && customChildStatusLayoutEight.referredCauseChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutEight);
            customChildStatusLayoutEight.referredCauseChildET.clearFocus();
            customChildStatusLayoutEight.referredCauseChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_refered_cause_eight_child));
            return false;
        } else if (childStatusEightFlag && customChildStatusLayoutEight != null && !customChildStatusLayoutEight.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutEight.childStatusET.getText().toString()) == CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID)
                && customChildStatusLayoutEight.childReferredOtherCauseET.getVisibility() == View.VISIBLE
                && customChildStatusLayoutEight.childReferredOtherCauseET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutEight);
            customChildStatusLayoutEight.childReferredOtherCauseET.clearFocus();
            customChildStatusLayoutEight.childReferredOtherCauseET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_other_refered_cause_eight_child));
            return false;
        } else if (childStatusEightFlag && customChildStatusLayoutEight != null && !customChildStatusLayoutEight.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutEight.childStatusET.getText().toString()) == CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID)
                && customChildStatusLayoutEight.referredTransportChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutEight);
            customChildStatusLayoutEight.referredTransportChildET.clearFocus();
            customChildStatusLayoutEight.referredTransportChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_refered_transport_eight_child));
            return false;
        } else if (childStatusEightFlag && customChildStatusLayoutEight != null && !customChildStatusLayoutEight.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutEight.childStatusET.getText().toString()) == CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID)
                && customChildStatusLayoutEight.referredAreaChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutEight);
            customChildStatusLayoutEight.referredAreaChildET.clearFocus();
            customChildStatusLayoutEight.referredAreaChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_refered_to_facility_eight_child));
            return false;
        } else if (childStatusEightFlag && customChildStatusLayoutEight != null && !customChildStatusLayoutEight.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutEight.childStatusET.getText().toString()) == CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID)
                && customChildStatusLayoutEight.referredOtherAreaChildET.getVisibility() == View.VISIBLE
                && customChildStatusLayoutEight.referredOtherAreaChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutEight);
            customChildStatusLayoutEight.referredOtherAreaChildET.clearFocus();
            customChildStatusLayoutEight.referredOtherAreaChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_other_refered_facility_eight_child));
            return false;
        } else if (childStatusEightFlag && customChildStatusLayoutEight != null && !customChildStatusLayoutEight.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutEight.childStatusET.getText().toString()) == CHILD_STATUS_DEATH_TYPE_DETAIL_ID)
                && customChildStatusLayoutEight.childDeathCauseET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutEight);
            customChildStatusLayoutEight.childDeathCauseET.clearFocus();
            customChildStatusLayoutEight.childDeathCauseET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_death_cause_eight_child));
            return false;
        } else if (childStatusEightFlag && customChildStatusLayoutEight != null && !customChildStatusLayoutEight.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutEight.childStatusET.getText().toString()) == CHILD_STATUS_DEATH_TYPE_DETAIL_ID)
                && customChildStatusLayoutEight.childDeathDateTimeET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutEight);
            customChildStatusLayoutEight.childDeathDateTimeET.clearFocus();
            customChildStatusLayoutEight.childDeathDateTimeET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_death_and_time_eight_child));
            return false;
        } else if (childStatusEightFlag && customChildStatusLayoutEight != null && !customChildStatusLayoutEight.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutEight.childStatusET.getText().toString()) == CHILD_STATUS_LAMA_TYPE_DETAIL_ID)
                && customChildStatusLayoutEight.lamaDateTimeChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutEight);
            customChildStatusLayoutEight.lamaDateTimeChildET.clearFocus();
            customChildStatusLayoutEight.lamaDateTimeChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_lama_date__and_time_eight_child));
            return false;
        } else if (childStatusNineFlag && customChildStatusLayoutNine != null && !customChildStatusLayoutNine.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutNine.childStatusET.getText().toString()) == CHILD_STATUS_DISCHARGED_TYPE_DETAIL_ID)
                && customChildStatusLayoutNine.dischargeDateTimeChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutNine);
            customChildStatusLayoutNine.dischargeDateTimeChildET.clearFocus();
            customChildStatusLayoutNine.dischargeDateTimeChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_child_discharge_date_time_nine_child));
            return false;
        } else if (childStatusNineFlag && customChildStatusLayoutNine != null && !customChildStatusLayoutNine.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutNine.childStatusET.getText().toString()) == CHILD_STATUS_DISCHARGED_TYPE_DETAIL_ID)
                && customChildStatusLayoutNine.dischargeWeightChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutNine);
            customChildStatusLayoutNine.dischargeWeightChildET.clearFocus();
            customChildStatusLayoutNine.dischargeWeightChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_child_discharge_wnine_nine_child));
            return false;
        } else if (childStatusNineFlag && customChildStatusLayoutNine != null && !customChildStatusLayoutNine.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutNine.childStatusET.getText().toString()) == CHILD_STATUS_DISCHARGED_TYPE_DETAIL_ID)
                && customChildStatusLayoutNine.transportToHomeChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutNine);
            customChildStatusLayoutNine.transportToHomeChildET.clearFocus();
            customChildStatusLayoutNine.transportToHomeChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_transport_to_home_nine_child));
            return false;
        } else if (childStatusNineFlag && customChildStatusLayoutNine != null && !customChildStatusLayoutNine.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutNine.childStatusET.getText().toString()) == CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID)
                && customChildStatusLayoutNine.referredDateTimeChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutNine);
            customChildStatusLayoutNine.referredDateTimeChildET.clearFocus();
            customChildStatusLayoutNine.referredDateTimeChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_refered_date_time_nine_child));
            return false;
        } else if (childStatusNineFlag && customChildStatusLayoutNine != null && !customChildStatusLayoutNine.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutNine.childStatusET.getText().toString()) == CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID)
                && customChildStatusLayoutNine.referredByChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutNine);
            customChildStatusLayoutNine.referredByChildET.clearFocus();
            customChildStatusLayoutNine.referredByChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_refered_by_child_nine_child));
            return false;
        } else if (childStatusNineFlag && customChildStatusLayoutNine != null && !customChildStatusLayoutNine.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutNine.childStatusET.getText().toString()) == CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID)
                && customChildStatusLayoutNine.referredCauseChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutNine);
            customChildStatusLayoutNine.referredCauseChildET.clearFocus();
            customChildStatusLayoutNine.referredCauseChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_refered_cause_nine_child));
            return false;
        } else if (childStatusNineFlag && customChildStatusLayoutNine != null && !customChildStatusLayoutNine.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutNine.childStatusET.getText().toString()) == CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID)
                && customChildStatusLayoutNine.childReferredOtherCauseET.getVisibility() == View.VISIBLE
                && customChildStatusLayoutNine.childReferredOtherCauseET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutNine);
            customChildStatusLayoutNine.childReferredOtherCauseET.clearFocus();
            customChildStatusLayoutNine.childReferredOtherCauseET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_other_refered_cause_nine_child));
            return false;
        } else if (childStatusNineFlag && customChildStatusLayoutNine != null && !customChildStatusLayoutNine.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutNine.childStatusET.getText().toString()) == CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID)
                && customChildStatusLayoutNine.referredTransportChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutNine);
            customChildStatusLayoutNine.referredTransportChildET.clearFocus();
            customChildStatusLayoutNine.referredTransportChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_refered_transport_nine_child));
            return false;
        } else if (childStatusNineFlag && customChildStatusLayoutNine != null && !customChildStatusLayoutNine.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutNine.childStatusET.getText().toString()) == CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID)
                && customChildStatusLayoutNine.referredAreaChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutNine);
            customChildStatusLayoutNine.referredAreaChildET.clearFocus();
            customChildStatusLayoutNine.referredAreaChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_refered_to_facility_nine_child));
            return false;
        } else if (childStatusNineFlag && customChildStatusLayoutNine != null && !customChildStatusLayoutNine.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutNine.childStatusET.getText().toString()) == CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID)
                && customChildStatusLayoutNine.referredOtherAreaChildET.getVisibility() == View.VISIBLE
                && customChildStatusLayoutNine.referredOtherAreaChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutNine);
            customChildStatusLayoutNine.referredOtherAreaChildET.clearFocus();
            customChildStatusLayoutNine.referredOtherAreaChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_other_refered_facility_nine_child));
            return false;
        } else if (childStatusNineFlag && customChildStatusLayoutNine != null && !customChildStatusLayoutNine.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutNine.childStatusET.getText().toString()) == CHILD_STATUS_DEATH_TYPE_DETAIL_ID)
                && customChildStatusLayoutNine.childDeathCauseET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutNine);
            customChildStatusLayoutNine.childDeathCauseET.clearFocus();
            customChildStatusLayoutNine.childDeathCauseET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_death_cause_nine_child));
            return false;
        } else if (childStatusNineFlag && customChildStatusLayoutNine != null && !customChildStatusLayoutNine.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutNine.childStatusET.getText().toString()) == CHILD_STATUS_DEATH_TYPE_DETAIL_ID)
                && customChildStatusLayoutNine.childDeathDateTimeET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutNine);
            customChildStatusLayoutNine.childDeathDateTimeET.clearFocus();
            customChildStatusLayoutNine.childDeathDateTimeET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_death_and_time_nine_child));
            return false;
        } else if (childStatusNineFlag && customChildStatusLayoutNine != null && !customChildStatusLayoutNine.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutNine.childStatusET.getText().toString()) == CHILD_STATUS_LAMA_TYPE_DETAIL_ID)
                && customChildStatusLayoutNine.lamaDateTimeChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutNine);
            customChildStatusLayoutNine.lamaDateTimeChildET.clearFocus();
            customChildStatusLayoutNine.lamaDateTimeChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_lama_date__and_time_nine_child));
            return false;
        } else if (childStatusTenFlag && customChildStatusLayoutTen != null && !customChildStatusLayoutTen.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutTen.childStatusET.getText().toString()) == CHILD_STATUS_DISCHARGED_TYPE_DETAIL_ID)
                && customChildStatusLayoutTen.dischargeDateTimeChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutTen);
            customChildStatusLayoutTen.dischargeDateTimeChildET.clearFocus();
            customChildStatusLayoutTen.dischargeDateTimeChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_child_discharge_date_time_ten_child));
            return false;
        } else if (childStatusTenFlag && customChildStatusLayoutTen != null && !customChildStatusLayoutTen.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutTen.childStatusET.getText().toString()) == CHILD_STATUS_DISCHARGED_TYPE_DETAIL_ID)
                && customChildStatusLayoutTen.dischargeWeightChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutTen);
            customChildStatusLayoutTen.dischargeWeightChildET.clearFocus();
            customChildStatusLayoutTen.dischargeWeightChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_child_discharge_wten_ten_child));
            return false;
        } else if (childStatusTenFlag && customChildStatusLayoutTen != null && !customChildStatusLayoutTen.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutTen.childStatusET.getText().toString()) == CHILD_STATUS_DISCHARGED_TYPE_DETAIL_ID)
                && customChildStatusLayoutTen.transportToHomeChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutTen);
            customChildStatusLayoutTen.transportToHomeChildET.clearFocus();
            customChildStatusLayoutTen.transportToHomeChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_transport_to_home_ten_child));
            return false;
        } else if (childStatusTenFlag && customChildStatusLayoutTen != null && !customChildStatusLayoutTen.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutTen.childStatusET.getText().toString()) == CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID)
                && customChildStatusLayoutTen.referredDateTimeChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutTen);
            customChildStatusLayoutTen.referredDateTimeChildET.clearFocus();
            customChildStatusLayoutTen.referredDateTimeChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_refered_date_time_ten_child));
            return false;
        } else if (childStatusTenFlag && customChildStatusLayoutTen != null && !customChildStatusLayoutTen.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutTen.childStatusET.getText().toString()) == CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID)
                && customChildStatusLayoutTen.referredByChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutTen);
            customChildStatusLayoutTen.referredByChildET.clearFocus();
            customChildStatusLayoutTen.referredByChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_refered_by_child_ten_child));
            return false;
        } else if (childStatusTenFlag && customChildStatusLayoutTen != null && !customChildStatusLayoutTen.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutTen.childStatusET.getText().toString()) == CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID)
                && customChildStatusLayoutTen.referredCauseChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutTen);
            customChildStatusLayoutTen.referredCauseChildET.clearFocus();
            customChildStatusLayoutTen.referredCauseChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_refered_cause_ten_child));
            return false;
        } else if (childStatusTenFlag && customChildStatusLayoutTen != null && !customChildStatusLayoutTen.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutTen.childStatusET.getText().toString()) == CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID)
                && customChildStatusLayoutTen.childReferredOtherCauseET.getVisibility() == View.VISIBLE
                && customChildStatusLayoutTen.childReferredOtherCauseET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutTen);
            customChildStatusLayoutTen.childReferredOtherCauseET.clearFocus();
            customChildStatusLayoutTen.childReferredOtherCauseET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_other_refered_cause_ten_child));
            return false;
        } else if (childStatusTenFlag && customChildStatusLayoutTen != null && !customChildStatusLayoutTen.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutTen.childStatusET.getText().toString()) == CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID)
                && customChildStatusLayoutTen.referredTransportChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutTen);
            customChildStatusLayoutTen.referredTransportChildET.clearFocus();
            customChildStatusLayoutTen.referredTransportChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_refered_transport_ten_child));
            return false;
        } else if (childStatusTenFlag && customChildStatusLayoutTen != null && !customChildStatusLayoutTen.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutTen.childStatusET.getText().toString()) == CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID)
                && customChildStatusLayoutTen.referredAreaChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutTen);
            customChildStatusLayoutTen.referredAreaChildET.clearFocus();
            customChildStatusLayoutTen.referredAreaChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_refered_to_facility_ten_child));
            return false;
        } else if (childStatusTenFlag && customChildStatusLayoutTen != null && !customChildStatusLayoutTen.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutTen.childStatusET.getText().toString()) == CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID)
                && customChildStatusLayoutTen.referredOtherAreaChildET.getVisibility() == View.VISIBLE
                && customChildStatusLayoutTen.referredOtherAreaChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutTen);
            customChildStatusLayoutTen.referredOtherAreaChildET.clearFocus();
            customChildStatusLayoutTen.referredOtherAreaChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_other_refered_facility_ten_child));
            return false;
        } else if (childStatusTenFlag && customChildStatusLayoutTen != null && !customChildStatusLayoutTen.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutTen.childStatusET.getText().toString()) == CHILD_STATUS_DEATH_TYPE_DETAIL_ID)
                && customChildStatusLayoutTen.childDeathCauseET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutTen);
            customChildStatusLayoutTen.childDeathCauseET.clearFocus();
            customChildStatusLayoutTen.childDeathCauseET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_death_cause_ten_child));
            return false;
        } else if (childStatusTenFlag && customChildStatusLayoutTen != null && !customChildStatusLayoutTen.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutTen.childStatusET.getText().toString()) == CHILD_STATUS_DEATH_TYPE_DETAIL_ID)
                && customChildStatusLayoutTen.childDeathDateTimeET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutTen);
            customChildStatusLayoutTen.childDeathDateTimeET.clearFocus();
            customChildStatusLayoutTen.childDeathDateTimeET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_death_and_time_ten_child));
            return false;
        } else if (childStatusTenFlag && customChildStatusLayoutTen != null && !customChildStatusLayoutTen.childStatusET.getText().toString().trim().equals("") &&
                (childStatusTypeMap.get(customChildStatusLayoutTen.childStatusET.getText().toString()) == CHILD_STATUS_LAMA_TYPE_DETAIL_ID)
                && customChildStatusLayoutTen.lamaDateTimeChildET.getText().toString().equals("")) {
            checkVisibilityOfChildStatus(customChildStatusLayoutTen);
            customChildStatusLayoutTen.lamaDateTimeChildET.clearFocus();
            customChildStatusLayoutTen.lamaDateTimeChildET.requestFocus();
            showErrorMessage(getResources().getString(R.string.warning_lama_date__and_time_ten_child));
            return false;
        } else {
            return true;
        }
    }


    public void requestFocusOnChildGender(CustomChildInfoLayout customChildInfoLayout, String alertMsg) {
        if (customChildInfoLayout.collapseView.getVisibility() == View.GONE) {
            customChildInfoLayout.collapseView.setVisibility(View.VISIBLE);
            customChildInfoLayout.childSexTxt.getParent().requestChildFocus(customChildInfoLayout.childSexTxt, customChildInfoLayout.childSexTxt);
            showErrorMessage(alertMsg);
        } else {
            customChildInfoLayout.childSexTxt.getParent().requestChildFocus(customChildInfoLayout.childSexTxt, customChildInfoLayout.childSexTxt);
            showErrorMessage(alertMsg);
        }
    }

    public void requestFocusOnChildWeight(CustomChildInfoLayout customChildInfoLayout, String alertMsg) {
        if (customChildInfoLayout.collapseView.getVisibility() == View.GONE) {
            customChildInfoLayout.collapseView.setVisibility(View.VISIBLE);
            customChildInfoLayout.weightEditBox.requestFocus();
            showErrorMessage(alertMsg);
        } else {
            customChildInfoLayout.weightEditBox.requestFocus();
            showErrorMessage(alertMsg);
        }
    }

    public void requestFocusOnStillBirthType(CustomChildInfoLayout customChildInfoLayout, String alertMsg) {
        if (customChildInfoLayout.collapseView.getVisibility() == View.GONE) {
            customChildInfoLayout.collapseView.setVisibility(View.VISIBLE);
            customChildInfoLayout.stillBirthType.getParent().requestChildFocus(customChildInfoLayout.stillBirthType, customChildInfoLayoutOne.stillBirthType);
            showErrorMessage(alertMsg);
        } else {
            customChildInfoLayoutOne.stillBirthType.getParent().requestChildFocus(customChildInfoLayout.stillBirthType, customChildInfoLayoutOne.stillBirthType);
            showErrorMessage(alertMsg);
        }
    }

    // for saving the data
    public void saveTheData() {
        try {
            if (checkMandatoryFields()) {
                if (checkChildStatusMandatoryFields()) {
                    //setting data in the patient model
                    if (patientModel != null) {

                        //We have check whether mother status has been given or not.
                        //If mother status is given we do not have to call setModelWithoutMotherStatus() method
                        if (patientModel.getMotherStatus() != null) {
                            //Mother status has been given

                            setModelWithMotherStatus();
                        } else {

                            //Mother status has not been given
                            setModelWithoutMotherStatus();
                            setModelWithMotherStatus();
                        }

                        PatientSaveAsyncTask patientSaveAsyncTask = new PatientSaveAsyncTask();
                        patientSaveAsyncTask.setPatientSaveListener(PatientActivity.this);
                        patientSaveAsyncTask.execute(patientModel);
                    } else {
                        Toast.makeText(getApplicationContext(), getString(R.string.error) + " code 2: Data save error", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), getString(R.string.error) + ": " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Method comment
     */
    public void setModelWithoutMotherStatus() {
        //serialNo
        String serialNoString = serialNo.getText().toString();
        if (serialNoString != null && !(serialNoString.trim().equals(""))) {
            try {
                patientModel.setSerialNo(Integer.parseInt(serialNoString.trim()));
            } catch (NumberFormatException e) {
                patientModel.setSerialNo(null);
            }
        } else {
            patientModel.setSerialNo(null);
        }

        //admissionDateAndTime
        String dateString = setAddmisionDateAndTime.getText().toString();
        if (dateString != null && !(dateString.trim().equals(""))) {

            try {
                Date admissionDate = simpleDateFormat.parse(dateString.trim());
                patientModel.setAdmissionDateAndTime(admissionDate);
            } catch (ParseException e) {
                patientModel.setAdmissionDateAndTime(null);
            }
        } else {
            patientModel.setAdmissionDateAndTime(null);
        }

        //patient type
        String patientTypeString = patientType.getText().toString();
        if (patientTypeString != null && !(patientTypeString.trim().equals(""))) {
            try {
                Integer id = patientTypeMap.get(patientTypeString);
                patientModel.setTypeOfPatient(id);
            } catch (NumberFormatException e) {
                patientModel.setTypeOfPatient(null);
            }
        } else {
            patientModel.setTypeOfPatient(null);
        }
        //referred type
        String referredTypeString = referredFacilityType.getText().toString();
        if (referredTypeString != null && !(referredTypeString.trim().equals(""))) {
            try {
                Integer id = referredTypeMap.get(referredTypeString);
                patientModel.setTypeOfFromReferredFacility(id);
            } catch (NumberFormatException e) {
                patientModel.setTypeOfFromReferredFacility(null);
            }
        } else {
            patientModel.setTypeOfFromReferredFacility(null);
        }

        //referred facility name
        String referredFacilityString = facilityName.getText().toString();
        if (referredFacilityString != null && !(referredFacilityString.trim().equals(""))) {
            patientModel.setNameOfFromReferredFacility(referredFacilityString.trim());
        } else {
            patientModel.setNameOfFromReferredFacility(null);
        }

        //patientName
        String patientNameString = patientName.getText().toString();
        if (patientNameString != null && !(patientNameString.trim().equals(""))) {
            patientModel.setPatientName(patientNameString.trim());
        } else {
            patientModel.setPatientName(null);
        }

        //patientHusbandName
        String patientHubandNameString = patientHusbandName.getText().toString();
        if (patientHubandNameString != null && !(patientHubandNameString.trim().equals(""))) {
            patientModel.setPatientHusbandName(patientHubandNameString.trim());
        } else {
            patientModel.setPatientHusbandName(null);
        }

        //stateAreaId
        String stateString = state.getText().toString();
        if (stateString != null && !(stateString.trim().equals(""))) {
            try {
                Integer id = stateMap.get(stateString);
                patientModel.setStateAreaId(id);
            } catch (NumberFormatException e) {
                patientModel.setStateAreaId(null);
            }
        } else {
            patientModel.setStateAreaId(null);
        }

        //detail address
        String detailAddressString = detailAddress.getText().toString();
        if (detailAddressString != null && !(detailAddressString.trim().equals(""))) {
            patientModel.setDetailAddressIfOtherState(detailAddressString.trim());
        } else {
            patientModel.setDetailAddressIfOtherState(null);
        }

        //districtAreaId
        String districtString = district.getText().toString();
        if (districtString != null && !(districtString.trim().equals(""))) {
            try {
                Integer id = districtMap.get(districtString);
                patientModel.setDistrictAreaId(id);
            } catch (NumberFormatException e) {
                patientModel.setDistrictAreaId(null);
            }
        } else {
            patientModel.setDistrictAreaId(null);
        }

        //blockAreaId
        String blockString = block.getText().toString();
        if (blockString != null && !(blockString.trim().equals(""))) {
            try {
                Integer id = blockMap.get(blockString);
                patientModel.setBlockAreaId(id);
            } catch (NumberFormatException e) {
                patientModel.setBlockAreaId(null);
            }
        } else {
            patientModel.setBlockAreaId(null);
        }

        //village
        String villageString = village.getText().toString();
        if (villageString != null && !(villageString.trim().equals(""))) {
            patientModel.setVillage(villageString.trim());
        } else {
            patientModel.setVillage(null);
        }

        //mobileNo;
        String patientMobileNoString = mobileNo.getText().toString();
        if (patientMobileNoString != null && !patientMobileNoString.trim().equals("")) {
            try {
                patientModel.setMobileNo(Long.parseLong(patientMobileNoString.trim()));
            } catch (NumberFormatException e) {
                patientModel.setMobileNo(null);
            }
        } else {
            patientModel.setMobileNo(null);
        }

        //age
        String patientAgeString = age.getText().toString();
        if (patientAgeString != null && !(patientAgeString.trim().equals(""))) {
            try {
                patientModel.setAge(Integer.parseInt(patientAgeString.trim()));
            } catch (NumberFormatException e) {
                patientModel.setAge(null);
            }
        } else {
            patientModel.setAge(null);
        }
        //caste;
        String patientCasteString = cast.getText().toString();
        if (patientCasteString != null && !(patientCasteString.trim().equals(""))) {
            try {
                Integer id = casteTypeMap.get(patientCasteString);
                patientModel.setCaste(id);
            } catch (NumberFormatException e) {
                patientModel.setCaste(null);
            }
        } else {
            patientModel.setCaste(null);
        }


        //aplOrBpl;
        boolean valueSelected = false;
        String aplRadioButtonString = rdBtnApl.getText().toString();
        if (aplRadioButtonString != null && !(aplRadioButtonString.trim().equals(""))) {
            if (aPLBPLTypeMap != null) {
                for (String gender : aPLBPLTypeMap.keySet()) {
                    if (aplRadioButtonString.equals(gender)) {
                        if (rdBtnApl.isChecked()) {
                            Integer id = aPLBPLTypeMap.get(gender);
                            if (id != null) {
                                patientModel.setAplOrBpl(id);
                                valueSelected = true;
                            }
                            break;
                        }
                    }
                }
            }

        }
        String bplRadioButtonString = rdBtnBpl.getText().toString();
        if (bplRadioButtonString != null && !(bplRadioButtonString.trim().equals(""))) {
            if (aPLBPLTypeMap != null) {
                for (String gender : aPLBPLTypeMap.keySet()) {
                    if (bplRadioButtonString.equals(gender)) {
                        if (rdBtnBpl.isChecked()) {
                            Integer id = aPLBPLTypeMap.get(gender);
                            if (id != null) {
                                patientModel.setAplOrBpl(id);
                                valueSelected = true;
                            }
                            break;
                        }
                    }
                }
            }

        }
        if (!valueSelected) {
            patientModel.setAplOrBpl(null);
        }

        //noOfNormalDeliveries;
        String noOfNormalDeliveriesString = noOfNormalDelivery.getText().toString();
        if (noOfNormalDeliveriesString != null && !(noOfNormalDeliveriesString.trim().equals(""))) {
            try {
                patientModel.setNoOfNormalDeliveries(Integer.parseInt(noOfNormalDeliveriesString.trim()));
            } catch (NumberFormatException e) {
                patientModel.setNoOfNormalDeliveries(null);
            }
        } else {
            patientModel.setNoOfNormalDeliveries(null);
        }
        //noOfAssistedDeliveries;
        String noOfAssistedDeliveriesString = noOfAssistedDelivery.getText().toString();
        if (noOfAssistedDeliveriesString != null && !(noOfAssistedDeliveriesString.trim().equals(""))) {
            try {
                patientModel.setNoOfAssistedDeliveries(Integer.parseInt(noOfAssistedDeliveriesString.trim()));
            } catch (NumberFormatException e) {
                patientModel.setNoOfAssistedDeliveries(null);
            }
        } else {
            patientModel.setNoOfAssistedDeliveries(null);
        }
        //noOfCSectionDeliveries;
        String noOfCSectionDeliveriesString = noOfCSectionDelivery.getText().toString();
        if (noOfCSectionDeliveriesString != null && !(noOfCSectionDeliveriesString.trim().equals(""))) {
            try {
                patientModel.setNoOfCSectionDeliveries(Integer.parseInt(noOfCSectionDeliveriesString.trim()));
            } catch (NumberFormatException e) {
                patientModel.setNoOfCSectionDeliveries(null);
            }
        } else {
            patientModel.setNoOfCSectionDeliveries(null);
        }
        //noOfLiveChild;
        String noOfLiveChildString = noOfLiveChild.getText().toString();
        if (noOfLiveChildString != null && !(noOfLiveChildString.trim().equals(""))) {
            try {
                patientModel.setNoOfLiveChild(Integer.parseInt(noOfLiveChildString.trim()));
            } catch (NumberFormatException e) {
                patientModel.setNoOfLiveChild(null);
            }
        } else {
            patientModel.setNoOfLiveChild(null);
        }
        //noOfDeathChild;
        String noOfDeathChildString = noOfDeathChild.getText().toString();
        if (noOfDeathChildString != null && !(noOfDeathChildString.trim().equals(""))) {
            try {
                patientModel.setNoOfStillBirth(Integer.parseInt(noOfDeathChildString.trim()));
            } catch (NumberFormatException e) {
                patientModel.setNoOfStillBirth(null);
            }
        } else {
            patientModel.setNoOfStillBirth(null);
        }
        //noOfAbortion
        String noOfAbortionString = noOfAbortion.getText().toString();
        if (noOfAbortionString != null && !(noOfAbortionString.trim().equals(""))) {
            try {
                patientModel.setNoOfAbortion(Integer.parseInt(noOfAbortionString.trim()));
            } catch (NumberFormatException e) {
                patientModel.setNoOfAbortion(null);
            }
        } else {
            patientModel.setNoOfAbortion(null);
        }
        //no Of Antenatal check-ups
        String noOfAntenatalCheckupsString = noOfAntenatalCheckups.getText().toString();
        if (noOfAntenatalCheckupsString != null && !(noOfAntenatalCheckupsString.trim().equals(""))) {
            try {
                patientModel.setNoOfAntenatalCheckups(Integer.parseInt(noOfAntenatalCheckupsString.trim()));
            } catch (NumberFormatException e) {
                patientModel.setNoOfAntenatalCheckups(null);
            }
        } else {
            patientModel.setNoOfAntenatalCheckups(null);
        }
        //Antenatal
        String antenatalCheckupDoneByString = antenatalCheckupDoneBy.getText().toString();
        if (antenatalCheckupDoneByString != null && !(antenatalCheckupDoneByString.trim().equals(""))) {
            try {
                Integer id = antenatalTypeMap.get(antenatalCheckupDoneByString);
                patientModel.setAntenatalCheckupDoneBy(id);
            } catch (NumberFormatException e) {
                patientModel.setAntenatalCheckupDoneBy(null);
            }
        } else {
            patientModel.setAntenatalCheckupDoneBy(null);
        }
        //bpSystolic;
        String bpSystolicString = systolic.getText().toString();
        if (bpSystolicString != null && !(bpSystolicString.trim().equals(""))) {
            try {
                patientModel.setBpSystolic(Integer.parseInt(bpSystolicString.trim()));
            } catch (NumberFormatException e) {
                patientModel.setBpSystolic(null);
            }
        } else {
            patientModel.setBpSystolic(null);
        }
        //bpDiastolic;
        String bpDiastolicString = diastolic.getText().toString();
        if (bpDiastolicString != null && !(bpDiastolicString.trim().equals(""))) {
            try {
                patientModel.setBpDiastolic(Integer.parseInt(bpDiastolicString.trim()));
            } catch (NumberFormatException e) {
                patientModel.setBpDiastolic(null);
            }
        } else {
            patientModel.setBpDiastolic(null);
        }
        //pulse rate
        String pulseRateString = pulseRate.getText().toString();
        if (pulseRateString != null && !(pulseRateString.trim().equals(""))) {
            try {
                patientModel.setPulseRatePerMinute(Integer.parseInt(pulseRateString.trim()));
            } catch (NumberFormatException e) {
                patientModel.setPulseRatePerMinute(null);
            }
        } else {
            patientModel.setPulseRatePerMinute(null);
        }

        //Respiratory rate per minute
        String respiratoryRateString = respiratoryRate.getText().toString();
        if (respiratoryRateString != null && !(respiratoryRateString.trim().equals(""))) {
            try {
                patientModel.setRespiratoryRatePerMinute(Integer.parseInt(respiratoryRateString.trim()));
            } catch (NumberFormatException e) {
                patientModel.setRespiratoryRatePerMinute(null);
            }
        } else {
            patientModel.setRespiratoryRatePerMinute(null);
        }

        //heartRate;
        String hbString = heartBeat.getText().toString();
        if (hbString != null && !(hbString.trim().equals(""))) {
            try {
                patientModel.setHeartRate(Integer.parseInt(hbString.trim()));
            } catch (NumberFormatException e) {
                patientModel.setHeartRate(null);
            }
        } else {
            patientModel.setHeartRate(null);
        }

        //Cervical dilatation;
        String cervicalDilatationString = cervicalDilatation.getText().toString();
        if (cervicalDilatationString != null && !(cervicalDilatationString.trim().equals(""))) {
            try {
                patientModel.setCervicalDilatationInCm(Integer.parseInt(cervicalDilatationString.trim()));
            } catch (NumberFormatException e) {
                patientModel.setCervicalDilatationInCm(null);
            }
        } else {
            patientModel.setCervicalDilatationInCm(null);
        }

        //Is partograph started?
        patientModel.setPatrographStarted(isPartographStarted.isChecked());

        //urineAlbumine;
        String urineAlbumineString = urinAlbumine.getText().toString();
        if (urineAlbumineString != null && !(urineAlbumineString.trim().equals(""))) {
            try {
                Integer id = urineAlbumineTypeMap.get(urineAlbumineString);
                patientModel.setUrineAlbumine(id);
            } catch (NumberFormatException e) {
                patientModel.setUrineAlbumine(null);
            }
        } else {
            patientModel.setUrineAlbumine(null);
        }

        //urineSugar;
        String urineSugarString = urinSugar.getText().toString();
        if (urineSugarString != null && !(urineSugarString.trim().equals(""))) {
            try {
                Integer id = urineSugarTypeMap.get(urineSugarString);
                patientModel.setUrineSugar(id);
            } catch (NumberFormatException e) {
                patientModel.setUrineSugar(null);
            }
        } else {
            patientModel.setUrineSugar(null);
        }

        //Is blood sugar test done?
        patientModel.setBloodSugarTestDone(isBloodSugarTestDone.isChecked());

        //bloodSugarFasting;
        String bloodSugarFastingString = fasting.getText().toString();
        if (bloodSugarFastingString != null && !(bloodSugarFastingString.trim().equals(""))) {
            try {
                Integer id = Integer.parseInt(bloodSugarFastingString);
                patientModel.setBloodSugarFasting(id);
            } catch (NumberFormatException e) {
                patientModel.setBloodSugarFasting(null);
            }
        } else {
            patientModel.setBloodSugarFasting(null);
        }


        //bloodSugarPostmeal;
        String bloodSugarPostmealString = postmeal.getText().toString();
        if (bloodSugarPostmealString != null && !(bloodSugarPostmealString.trim().equals(""))) {
            try {
                Integer id = Integer.parseInt(bloodSugarPostmealString);
                patientModel.setBloodSugarPostmeal(id);
            } catch (NumberFormatException e) {
                patientModel.setBloodSugarPostmeal(null);
            }
        } else {
            patientModel.setBloodSugarPostmeal(null);
        }

        //bloodSugarRandom;
        String bloodSugarRandomString = random.getText().toString();
        if (bloodSugarRandomString != null && !(bloodSugarRandomString.trim().equals(""))) {
            try {
                Integer id = Integer.parseInt(bloodSugarRandomString);
                patientModel.setBloodSugarRandom(id);
            } catch (NumberFormatException e) {
                patientModel.setBloodSugarRandom(null);
            }
        } else {
            patientModel.setBloodSugarRandom(null);
        }

        //vdrlRPR;
        String vdrlString = vdrl.getText().toString();
        if (vdrlString != null && !(vdrlString.trim().equals(""))) {
            try {
                Integer id = vdrlTypeMap.get(vdrlString);
                patientModel.setVdrlRPR(id);
            } catch (NumberFormatException e) {
                patientModel.setVdrlRPR(null);
            }
        } else {
            patientModel.setVdrlRPR(null);
        }


        //sickling;
        String sicklingString = sickling.getText().toString();
        if (sicklingString != null && !(sicklingString.trim().equals(""))) {
            try {
                Integer id = sicklingTypeMap.get(sicklingString);
                patientModel.setSickling(id);
            } catch (NumberFormatException e) {
                patientModel.setSickling(null);
            }
        } else {
            patientModel.setSickling(null);
        }


        //hivTest;
        String hivTestString = hivTest.getText().toString();
        if (hivTestString != null && !(hivTestString.trim().equals(""))) {
            try {
                Integer id = hivTestTypeMap.get(hivTestString);
                patientModel.setHivTest(id);
            } catch (NumberFormatException e) {
                patientModel.setHivTest(null);
            }
        } else {
            patientModel.setHivTest(null);
        }


        //bloodGroup;
        String bloodGroupString = bloodGroup.getText().toString();
        if (bloodGroupString != null && !(bloodGroupString.trim().equals(""))) {
            try {
                Integer id = bloodGroupTypeMap.get(bloodGroupString);
                patientModel.setBloodGroup(id);
            } catch (NumberFormatException e) {
                patientModel.setBloodGroup(null);
            }
        } else {
            patientModel.setBloodGroup(null);
        }


        //rhType;
        String rhTypeString = rhType.getText().toString();
        if (rhTypeString != null && !(rhTypeString.trim().equals(""))) {
            try {
                Integer id = rhTypeTypeMap.get(rhTypeString);
                patientModel.setRhType(id);
            } catch (NumberFormatException e) {
                patientModel.setRhType(null);
            }
        } else {
            patientModel.setRhType(null);
        }

        //vehicleToFacility;
        String vehicleToFacilityString = transportToHospital.getText().toString();
        if (vehicleToFacilityString != null && !(vehicleToFacilityString.trim().equals(""))) {
            try {
                Integer id = transportTypeMap.get(vehicleToFacilityString);
                if (id != null) {
                    patientModel.setVehicleToFacility(id);
                }
            } catch (NumberFormatException e) {
                patientModel.setVehicleToFacility(null);
            }
        } else {
            patientModel.setVehicleToFacility(null);
        }

        //deliveryDateAndTime;
        String deliveryDateAndTimeString = setDeliveryDateAndTime.getText().toString();
        if (deliveryDateAndTimeString != null && !(deliveryDateAndTimeString.trim().equals(""))) {
            try {
                Date deliveryDate = simpleDateFormat.parse(deliveryDateAndTimeString.trim());
                patientModel.setDeliveryDateAndTime(deliveryDate);
            } catch (ParseException e) {
                patientModel.setDeliveryDateAndTime(null);
            }
        } else {
            patientModel.setDeliveryDateAndTime(null);
        }

        //deliveryBy;
        String deliveryByString = deliveryBy.getText().toString();
        if (deliveryByString != null && !(deliveryByString.trim().equals(""))) {
            patientModel.setDeliveryBy(deliveryByString.trim());
        } else {
            patientModel.setDeliveryBy(null);
        }

        //deliveryTerm;
        String deliveryTermString = deliveryTerm.getText().toString();
        if (deliveryTermString != null && !(deliveryTermString.trim().equals(""))) {
            try {
                Integer id = deliveryTermTypeMap.get(deliveryTermString);
                patientModel.setDeliveryTerm(id);
            } catch (NumberFormatException e) {
                patientModel.setDeliveryTerm(null);
            }
        } else {
            patientModel.setDeliveryTerm(null);
        }

        patientModel.setDexamethasoneGiven(isDexamethansoneGiven.isChecked());

        //deliveryType;
        String deliveryTypeString = deliveryType.getText().toString();
        if (deliveryTypeString != null && !(deliveryTypeString.trim().equals(""))) {
            try {
                Integer id = deliveryTypeTypeMap.get(deliveryTypeString);
                patientModel.setDeliveryType(id);
            } catch (NumberFormatException e) {
                patientModel.setDeliveryType(null);
            }
        } else {
            patientModel.setDeliveryType(null);
        }


        //drugType;
        String drugTypeString = drugType.getText().toString();
        if (drugTypeString != null && !(drugTypeString.trim().equals(""))) {
            try {
                Integer id = thirdStageDrugTypeMap.get(drugTypeString);
                patientModel.setDrugGivenInThirdStageOfLabor(id);
            } catch (NumberFormatException e) {
                patientModel.setDrugGivenInThirdStageOfLabor(null);
            }
        } else {
            patientModel.setDrugGivenInThirdStageOfLabor(null);
        }

        //Was cord clamping delayed?
        patientModel.setWasCordClampingDelayed(wasCordClampingDelayed.isChecked());

        //has gestational
        String gestationalTypeString = hasGestational.getText().toString();
        if (gestationalTypeString != null && !(gestationalTypeString.trim().equals(""))) {
            try {
                Integer id = gestationalTypeMap.get(gestationalTypeString);
                patientModel.setHasGestationalDM(id);
            } catch (NumberFormatException e) {
                patientModel.setHasGestationalDM(null);
            }
        } else {
            patientModel.setHasGestationalDM(null);
        }

        //is insulin
        patientModel.setInsulinGiven(isInsulin.isChecked());

        //has hypothyroidism
        String hypothyroidismTypeString = hasHypoyhyroidism.getText().toString();
        if (hypothyroidismTypeString != null && !(hypothyroidismTypeString.trim().equals(""))) {
            try {
                Integer id = hypoyhyroidismTypeMap.get(hypothyroidismTypeString);
                patientModel.setHasHypothyroidism(id);
            } catch (NumberFormatException e) {
                patientModel.setHasHypothyroidism(null);
            }
        } else {
            patientModel.setHasHypothyroidism(null);
        }

        //is thyroxine
        patientModel.setLeavothyroxineGiven(isThyroxine.isChecked());

        //has eclampsia
        patientModel.setHasEclampsia(hasEclampsia.isChecked());

        //is magsulf
        patientModel.setTreatedWithMagsulf(isMagsulf.isChecked());

        //brief desc of child
        List<ChildModel> childList = new ArrayList<>();

        //if child one is still birth
        if (childOneFlag) {
            ChildModel childOne = new ChildModel();

            if (customChildInfoLayoutOne.stillBirthTB.isChecked()) {
                childOne.setIsStillBirth(true);

                //still birth type
                String stillBirthTypeString = customChildInfoLayoutOne.stillBirthTypeEditBox.getText().toString();
                if (stillBirthTypeString != null && !(stillBirthTypeString.trim().equals(""))) {
                    try {
                        Integer id = stillBirthTypeMap.get(stillBirthTypeString);
                        childOne.setStillBirthType(id);
                    } catch (NumberFormatException e) {
                        childOne.setStillBirthType(null);
                    }
                } else {
                    childOne.setStillBirthType(null);
                }

            } else {
                //live child
                childOne.setIsStillBirth(false);
                childOne.setIsChildBreastFedInHour(customChildInfoLayoutOne.babyBreastFeed.isChecked());
                childOne.setHasNeededRescusition(customChildInfoLayoutOne.rescusitation.isChecked());
                childOne.setHasCongenitalAnomalies(customChildInfoLayoutOne.congenitalAnomalies.isChecked());
                childOne.setIsBCGGiven(customChildInfoLayoutOne.bcgGiven.isChecked());
                childOne.setIsZeroOPVGiven(customChildInfoLayoutOne.zeroOpvGiven.isChecked());
                childOne.setIsHepBZeroGiven(customChildInfoLayoutOne.hepBZero.isChecked());
                childOne.setIsVitaminKGiven(customChildInfoLayoutOne.injVitK.isChecked());
            }
            boolean sexSelected = false;
            String sexMaleRadioButtonString = customChildInfoLayoutOne.sexMale.getText().toString();
            if (sexMaleRadioButtonString != null && !(sexMaleRadioButtonString.trim().equals(""))) {
                for (String gender : genderTypeMap.keySet()) {
                    if (sexMaleRadioButtonString.equals(gender)) {
                        if (customChildInfoLayoutOne.sexMale.isChecked()) {
                            Integer id = genderTypeMap.get(gender);
                            if (id != null) {
                                childOne.setChildSex(id);
                                sexSelected = true;
                            }
                            break;
                        }
                    }
                }

            }
            String sexFemaleRadioButtonString = customChildInfoLayoutOne.sexFemale.getText().toString();
            if (sexFemaleRadioButtonString != null && !(sexFemaleRadioButtonString.trim().equals(""))) {
                for (String gender : genderTypeMap.keySet()) {
                    if (sexFemaleRadioButtonString.equals(gender)) {
                        if (customChildInfoLayoutOne.sexFemale.isChecked()) {
                            Integer id = genderTypeMap.get(gender);
                            if (id != null) {
                                childOne.setChildSex(id);
                                sexSelected = true;
                            }
                            break;
                        }
                    }
                }

            }
            if (!sexSelected) {
                childOne.setChildSex(null);
            }

            //child Weight
            String childWeight = customChildInfoLayoutOne.weightEditBox.getText().toString();
            if (childWeight != null && !(childWeight.trim().equals(""))) {
                try {
                    childOne.setChildWeight(Float.parseFloat(childWeight.trim()));
                } catch (NumberFormatException e) {
                    childOne.setChildWeight(null);
                }
            } else {
                childOne.setChildWeight(null);
            }

            childList.add(childOne);
        }

        if (childTwoFlag) {
            ChildModel childTwo = new ChildModel();

            if (customChildInfoLayoutTwo.stillBirthTB.isChecked()) {
                childTwo.setIsStillBirth(true);

                //still birth type
                String stillBirthTypeString = customChildInfoLayoutTwo.stillBirthTypeEditBox.getText().toString();
                if (stillBirthTypeString != null && !(stillBirthTypeString.trim().equals(""))) {
                    try {
                        Integer id = stillBirthTypeMap.get(stillBirthTypeString);
                        childTwo.setStillBirthType(id);
                    } catch (NumberFormatException e) {
                        childTwo.setStillBirthType(null);
                    }
                } else {
                    childTwo.setStillBirthType(null);
                }

            } else {
                //live child
                childTwo.setIsStillBirth(false);
                childTwo.setIsChildBreastFedInHour(customChildInfoLayoutTwo.babyBreastFeed.isChecked());
                childTwo.setHasNeededRescusition(customChildInfoLayoutTwo.rescusitation.isChecked());
                childTwo.setHasCongenitalAnomalies(customChildInfoLayoutTwo.congenitalAnomalies.isChecked());
                childTwo.setIsBCGGiven(customChildInfoLayoutTwo.bcgGiven.isChecked());
                childTwo.setIsZeroOPVGiven(customChildInfoLayoutTwo.zeroOpvGiven.isChecked());
                childTwo.setIsHepBZeroGiven(customChildInfoLayoutTwo.hepBZero.isChecked());
                childTwo.setIsVitaminKGiven(customChildInfoLayoutTwo.injVitK.isChecked());
            }
            boolean sexSelected = false;
            String sexMaleRadioButtonString = customChildInfoLayoutTwo.sexMale.getText().toString();
            if (sexMaleRadioButtonString != null && !(sexMaleRadioButtonString.trim().equals(""))) {
                for (String gender : genderTypeMap.keySet()) {
                    if (sexMaleRadioButtonString.equals(gender)) {
                        if (customChildInfoLayoutTwo.sexMale.isChecked()) {
                            Integer id = genderTypeMap.get(gender);
                            if (id != null) {
                                childTwo.setChildSex(id);
                                sexSelected = true;
                            }
                            break;
                        }
                    }
                }

            }
            String sexFemaleRadioButtonString = customChildInfoLayoutTwo.sexFemale.getText().toString();
            if (sexFemaleRadioButtonString != null && !(sexFemaleRadioButtonString.trim().equals(""))) {
                for (String gender : genderTypeMap.keySet()) {
                    if (sexFemaleRadioButtonString.equals(gender)) {
                        if (customChildInfoLayoutTwo.sexFemale.isChecked()) {
                            Integer id = genderTypeMap.get(gender);
                            if (id != null) {
                                childTwo.setChildSex(id);
                                sexSelected = true;
                            }
                            break;
                        }
                    }
                }

            }
            if (!sexSelected) {
                childTwo.setChildSex(null);
            }

            //child Weight
            String childWeight = customChildInfoLayoutTwo.weightEditBox.getText().toString();
            if (childWeight != null && !(childWeight.trim().equals(""))) {
                try {
                    childTwo.setChildWeight(Float.parseFloat(childWeight.trim()));
                } catch (NumberFormatException e) {
                    childTwo.setChildWeight(null);
                }
            } else {
                childTwo.setChildWeight(null);
            }

            childList.add(childTwo);
        }

        if (childThreeFlag) {
            ChildModel childThree = new ChildModel();

            if (customChildInfoLayoutThree.stillBirthTB.isChecked()) {
                childThree.setIsStillBirth(true);

                //still birth type
                String stillBirthTypeString = customChildInfoLayoutThree.stillBirthTypeEditBox.getText().toString();
                if (stillBirthTypeString != null && !(stillBirthTypeString.trim().equals(""))) {
                    try {
                        Integer id = stillBirthTypeMap.get(stillBirthTypeString);
                        childThree.setStillBirthType(id);
                    } catch (NumberFormatException e) {
                        childThree.setStillBirthType(null);
                    }
                } else {
                    childThree.setStillBirthType(null);
                }

            } else {
                //live child
                childThree.setIsStillBirth(false);
                childThree.setIsChildBreastFedInHour(customChildInfoLayoutThree.babyBreastFeed.isChecked());
                childThree.setHasNeededRescusition(customChildInfoLayoutThree.rescusitation.isChecked());
                childThree.setHasCongenitalAnomalies(customChildInfoLayoutThree.congenitalAnomalies.isChecked());
                childThree.setIsBCGGiven(customChildInfoLayoutThree.bcgGiven.isChecked());
                childThree.setIsZeroOPVGiven(customChildInfoLayoutThree.zeroOpvGiven.isChecked());
                childThree.setIsHepBZeroGiven(customChildInfoLayoutThree.hepBZero.isChecked());
                childThree.setIsVitaminKGiven(customChildInfoLayoutThree.injVitK.isChecked());
            }
            boolean sexSelected = false;
            String sexMaleRadioButtonString = customChildInfoLayoutThree.sexMale.getText().toString();
            if (sexMaleRadioButtonString != null && !(sexMaleRadioButtonString.trim().equals(""))) {
                for (String gender : genderTypeMap.keySet()) {
                    if (sexMaleRadioButtonString.equals(gender)) {
                        if (customChildInfoLayoutThree.sexMale.isChecked()) {
                            Integer id = genderTypeMap.get(gender);
                            if (id != null) {
                                childThree.setChildSex(id);
                                sexSelected = true;
                            }
                            break;
                        }
                    }
                }

            }
            String sexFemaleRadioButtonString = customChildInfoLayoutOne.sexFemale.getText().toString();
            if (sexFemaleRadioButtonString != null && !(sexFemaleRadioButtonString.trim().equals(""))) {
                for (String gender : genderTypeMap.keySet()) {
                    if (sexFemaleRadioButtonString.equals(gender)) {
                        if (customChildInfoLayoutThree.sexFemale.isChecked()) {
                            Integer id = genderTypeMap.get(gender);
                            if (id != null) {
                                childThree.setChildSex(id);
                                sexSelected = true;
                            }
                            break;
                        }
                    }
                }

            }
            if (!sexSelected) {
                childThree.setChildSex(null);
            }

            //child Weight
            String childWeight = customChildInfoLayoutThree.weightEditBox.getText().toString();
            if (childWeight != null && !(childWeight.trim().equals(""))) {
                try {
                    childThree.setChildWeight(Float.parseFloat(childWeight.trim()));
                } catch (NumberFormatException e) {
                    childThree.setChildWeight(null);
                }
            } else {
                childThree.setChildWeight(null);
            }

            childList.add(childThree);
        }

        //Child Four
        if (childFourFlag) {
            ChildModel childFour = new ChildModel();

            if (customChildInfoLayoutFour.stillBirthTB.isChecked()) {
                childFour.setIsStillBirth(true);

                //still birth type
                String stillBirthTypeString = customChildInfoLayoutFour.stillBirthTypeEditBox.getText().toString();
                if (stillBirthTypeString != null && !(stillBirthTypeString.trim().equals(""))) {
                    try {
                        Integer id = stillBirthTypeMap.get(stillBirthTypeString);
                        childFour.setStillBirthType(id);
                    } catch (NumberFormatException e) {
                        childFour.setStillBirthType(null);
                    }
                } else {
                    childFour.setStillBirthType(null);
                }

            } else {
                //live child
                childFour.setIsStillBirth(false);
                childFour.setIsChildBreastFedInHour(customChildInfoLayoutFour.babyBreastFeed.isChecked());
                childFour.setHasNeededRescusition(customChildInfoLayoutFour.rescusitation.isChecked());
                childFour.setHasCongenitalAnomalies(customChildInfoLayoutFour.congenitalAnomalies.isChecked());
                childFour.setIsBCGGiven(customChildInfoLayoutFour.bcgGiven.isChecked());
                childFour.setIsZeroOPVGiven(customChildInfoLayoutFour.zeroOpvGiven.isChecked());
                childFour.setIsHepBZeroGiven(customChildInfoLayoutFour.hepBZero.isChecked());
                childFour.setIsVitaminKGiven(customChildInfoLayoutFour.injVitK.isChecked());
            }
            boolean sexSelected = false;
            String sexMaleRadioButtonString = customChildInfoLayoutFour.sexMale.getText().toString();
            if (sexMaleRadioButtonString != null && !(sexMaleRadioButtonString.trim().equals(""))) {
                for (String gender : genderTypeMap.keySet()) {
                    if (sexMaleRadioButtonString.equals(gender)) {
                        if (customChildInfoLayoutFour.sexMale.isChecked()) {
                            Integer id = genderTypeMap.get(gender);
                            if (id != null) {
                                childFour.setChildSex(id);
                                sexSelected = true;
                            }
                            break;
                        }
                    }
                }

            }
            String sexFemaleRadioButtonString = customChildInfoLayoutFour.sexFemale.getText().toString();
            if (sexFemaleRadioButtonString != null && !(sexFemaleRadioButtonString.trim().equals(""))) {
                for (String gender : genderTypeMap.keySet()) {
                    if (sexFemaleRadioButtonString.equals(gender)) {
                        if (customChildInfoLayoutFour.sexFemale.isChecked()) {
                            Integer id = genderTypeMap.get(gender);
                            if (id != null) {
                                childFour.setChildSex(id);
                                sexSelected = true;
                            }
                            break;
                        }
                    }
                }

            }
            if (!sexSelected) {
                childFour.setChildSex(null);
            }

            //child Weight
            String childWeight = customChildInfoLayoutFour.weightEditBox.getText().toString();
            if (childWeight != null && !(childWeight.trim().equals(""))) {
                try {
                    childFour.setChildWeight(Float.parseFloat(childWeight.trim()));
                } catch (NumberFormatException e) {
                    childFour.setChildWeight(null);
                }
            } else {
                childFour.setChildWeight(null);
            }

            childList.add(childFour);
        }


        //Child Five
        if (childFiveFlag) {
            ChildModel childFive = new ChildModel();

            if (customChildInfoLayoutFive.stillBirthTB.isChecked()) {
                childFive.setIsStillBirth(true);

                //still birth type
                String stillBirthTypeString = customChildInfoLayoutFive.stillBirthTypeEditBox.getText().toString();
                if (stillBirthTypeString != null && !(stillBirthTypeString.trim().equals(""))) {
                    try {
                        Integer id = stillBirthTypeMap.get(stillBirthTypeString);
                        childFive.setStillBirthType(id);
                    } catch (NumberFormatException e) {
                        childFive.setStillBirthType(null);
                    }
                } else {
                    childFive.setStillBirthType(null);
                }

            } else {
                //live child
                childFive.setIsStillBirth(false);
                childFive.setIsChildBreastFedInHour(customChildInfoLayoutFive.babyBreastFeed.isChecked());
                childFive.setHasNeededRescusition(customChildInfoLayoutFive.rescusitation.isChecked());
                childFive.setHasCongenitalAnomalies(customChildInfoLayoutFive.congenitalAnomalies.isChecked());
                childFive.setIsBCGGiven(customChildInfoLayoutFive.bcgGiven.isChecked());
                childFive.setIsZeroOPVGiven(customChildInfoLayoutFive.zeroOpvGiven.isChecked());
                childFive.setIsHepBZeroGiven(customChildInfoLayoutFive.hepBZero.isChecked());
                childFive.setIsVitaminKGiven(customChildInfoLayoutFive.injVitK.isChecked());
            }
            boolean sexSelected = false;
            String sexMaleRadioButtonString = customChildInfoLayoutFive.sexMale.getText().toString();
            if (sexMaleRadioButtonString != null && !(sexMaleRadioButtonString.trim().equals(""))) {
                for (String gender : genderTypeMap.keySet()) {
                    if (sexMaleRadioButtonString.equals(gender)) {
                        if (customChildInfoLayoutFive.sexMale.isChecked()) {
                            Integer id = genderTypeMap.get(gender);
                            if (id != null) {
                                childFive.setChildSex(id);
                                sexSelected = true;
                            }
                            break;
                        }
                    }
                }

            }
            String sexFemaleRadioButtonString = customChildInfoLayoutFive.sexFemale.getText().toString();
            if (sexFemaleRadioButtonString != null && !(sexFemaleRadioButtonString.trim().equals(""))) {
                for (String gender : genderTypeMap.keySet()) {
                    if (sexFemaleRadioButtonString.equals(gender)) {
                        if (customChildInfoLayoutFive.sexFemale.isChecked()) {
                            Integer id = genderTypeMap.get(gender);
                            if (id != null) {
                                childFive.setChildSex(id);
                                sexSelected = true;
                            }
                            break;
                        }
                    }
                }

            }
            if (!sexSelected) {
                childFive.setChildSex(null);
            }

            //child Weight
            String childWeight = customChildInfoLayoutFive.weightEditBox.getText().toString();
            if (childWeight != null && !(childWeight.trim().equals(""))) {
                try {
                    childFive.setChildWeight(Float.parseFloat(childWeight.trim()));
                } catch (NumberFormatException e) {
                    childFive.setChildWeight(null);
                }
            } else {
                childFive.setChildWeight(null);
            }

            childList.add(childFive);
        }

        //Child Six
        if (childSixFlag) {
            ChildModel childSix = new ChildModel();

            if (customChildInfoLayoutSix.stillBirthTB.isChecked()) {
                childSix.setIsStillBirth(true);

                //still birth type
                String stillBirthTypeString = customChildInfoLayoutSix.stillBirthTypeEditBox.getText().toString();
                if (stillBirthTypeString != null && !(stillBirthTypeString.trim().equals(""))) {
                    try {
                        Integer id = stillBirthTypeMap.get(stillBirthTypeString);
                        childSix.setStillBirthType(id);
                    } catch (NumberFormatException e) {
                        childSix.setStillBirthType(null);
                    }
                } else {
                    childSix.setStillBirthType(null);
                }

            } else {
                //live child
                childSix.setIsStillBirth(false);
                childSix.setIsChildBreastFedInHour(customChildInfoLayoutSix.babyBreastFeed.isChecked());
                childSix.setHasNeededRescusition(customChildInfoLayoutSix.rescusitation.isChecked());
                childSix.setHasCongenitalAnomalies(customChildInfoLayoutSix.congenitalAnomalies.isChecked());
                childSix.setIsBCGGiven(customChildInfoLayoutSix.bcgGiven.isChecked());
                childSix.setIsZeroOPVGiven(customChildInfoLayoutSix.zeroOpvGiven.isChecked());
                childSix.setIsHepBZeroGiven(customChildInfoLayoutSix.hepBZero.isChecked());
                childSix.setIsVitaminKGiven(customChildInfoLayoutSix.injVitK.isChecked());
            }
            boolean sexSelected = false;
            String sexMaleRadioButtonString = customChildInfoLayoutSix.sexMale.getText().toString();
            if (sexMaleRadioButtonString != null && !(sexMaleRadioButtonString.trim().equals(""))) {
                for (String gender : genderTypeMap.keySet()) {
                    if (sexMaleRadioButtonString.equals(gender)) {
                        if (customChildInfoLayoutSix.sexMale.isChecked()) {
                            Integer id = genderTypeMap.get(gender);
                            if (id != null) {
                                childSix.setChildSex(id);
                                sexSelected = true;
                            }
                            break;
                        }
                    }
                }

            }
            String sexFemaleRadioButtonString = customChildInfoLayoutSix.sexFemale.getText().toString();
            if (sexFemaleRadioButtonString != null && !(sexFemaleRadioButtonString.trim().equals(""))) {
                for (String gender : genderTypeMap.keySet()) {
                    if (sexFemaleRadioButtonString.equals(gender)) {
                        if (customChildInfoLayoutSix.sexFemale.isChecked()) {
                            Integer id = genderTypeMap.get(gender);
                            if (id != null) {
                                childSix.setChildSex(id);
                                sexSelected = true;
                            }
                            break;
                        }
                    }
                }

            }
            if (!sexSelected) {
                childSix.setChildSex(null);
            }

            //child Weight
            String childWeight = customChildInfoLayoutSix.weightEditBox.getText().toString();
            if (childWeight != null && !(childWeight.trim().equals(""))) {
                try {
                    childSix.setChildWeight(Float.parseFloat(childWeight.trim()));
                } catch (NumberFormatException e) {
                    childSix.setChildWeight(null);
                }
            } else {
                childSix.setChildWeight(null);
            }

            childList.add(childSix);
        }

        //Child Seven
        if (childSevenFlag) {
            ChildModel childSeven = new ChildModel();

            if (customChildInfoLayoutSeven.stillBirthTB.isChecked()) {
                childSeven.setIsStillBirth(true);

                //still birth type
                String stillBirthTypeString = customChildInfoLayoutSeven.stillBirthTypeEditBox.getText().toString();
                if (stillBirthTypeString != null && !(stillBirthTypeString.trim().equals(""))) {
                    try {
                        Integer id = stillBirthTypeMap.get(stillBirthTypeString);
                        childSeven.setStillBirthType(id);
                    } catch (NumberFormatException e) {
                        childSeven.setStillBirthType(null);
                    }
                } else {
                    childSeven.setStillBirthType(null);
                }

            } else {
                //live child
                childSeven.setIsStillBirth(false);
                childSeven.setIsChildBreastFedInHour(customChildInfoLayoutSeven.babyBreastFeed.isChecked());
                childSeven.setHasNeededRescusition(customChildInfoLayoutSeven.rescusitation.isChecked());
                childSeven.setHasCongenitalAnomalies(customChildInfoLayoutSeven.congenitalAnomalies.isChecked());
                childSeven.setIsBCGGiven(customChildInfoLayoutSeven.bcgGiven.isChecked());
                childSeven.setIsZeroOPVGiven(customChildInfoLayoutSeven.zeroOpvGiven.isChecked());
                childSeven.setIsHepBZeroGiven(customChildInfoLayoutSeven.hepBZero.isChecked());
                childSeven.setIsVitaminKGiven(customChildInfoLayoutSeven.injVitK.isChecked());
            }
            boolean sexSelected = false;
            String sexMaleRadioButtonString = customChildInfoLayoutSeven.sexMale.getText().toString();
            if (sexMaleRadioButtonString != null && !(sexMaleRadioButtonString.trim().equals(""))) {
                for (String gender : genderTypeMap.keySet()) {
                    if (sexMaleRadioButtonString.equals(gender)) {
                        if (customChildInfoLayoutSeven.sexMale.isChecked()) {
                            Integer id = genderTypeMap.get(gender);
                            if (id != null) {
                                childSeven.setChildSex(id);
                                sexSelected = true;
                            }
                            break;
                        }
                    }
                }

            }
            String sexFemaleRadioButtonString = customChildInfoLayoutSeven.sexFemale.getText().toString();
            if (sexFemaleRadioButtonString != null && !(sexFemaleRadioButtonString.trim().equals(""))) {
                for (String gender : genderTypeMap.keySet()) {
                    if (sexFemaleRadioButtonString.equals(gender)) {
                        if (customChildInfoLayoutSeven.sexFemale.isChecked()) {
                            Integer id = genderTypeMap.get(gender);
                            if (id != null) {
                                childSeven.setChildSex(id);
                                sexSelected = true;
                            }
                            break;
                        }
                    }
                }

            }
            if (!sexSelected) {
                childSeven.setChildSex(null);
            }

            //child Weight
            String childWeight = customChildInfoLayoutSeven.weightEditBox.getText().toString();
            if (childWeight != null && !(childWeight.trim().equals(""))) {
                try {
                    childSeven.setChildWeight(Float.parseFloat(childWeight.trim()));
                } catch (NumberFormatException e) {
                    childSeven.setChildWeight(null);
                }
            } else {
                childSeven.setChildWeight(null);
            }

            childList.add(childSeven);
        }

        //Child Eight
        if (childEightFlag) {
            ChildModel childEight = new ChildModel();

            if (customChildInfoLayoutEight.stillBirthTB.isChecked()) {
                childEight.setIsStillBirth(true);

                //still birth type
                String stillBirthTypeString = customChildInfoLayoutEight.stillBirthTypeEditBox.getText().toString();
                if (stillBirthTypeString != null && !(stillBirthTypeString.trim().equals(""))) {
                    try {
                        Integer id = stillBirthTypeMap.get(stillBirthTypeString);
                        childEight.setStillBirthType(id);
                    } catch (NumberFormatException e) {
                        childEight.setStillBirthType(null);
                    }
                } else {
                    childEight.setStillBirthType(null);
                }

            } else {
                //live child
                childEight.setIsStillBirth(false);
                childEight.setIsChildBreastFedInHour(customChildInfoLayoutEight.babyBreastFeed.isChecked());
                childEight.setHasNeededRescusition(customChildInfoLayoutEight.rescusitation.isChecked());
                childEight.setHasCongenitalAnomalies(customChildInfoLayoutEight.congenitalAnomalies.isChecked());
                childEight.setIsBCGGiven(customChildInfoLayoutEight.bcgGiven.isChecked());
                childEight.setIsZeroOPVGiven(customChildInfoLayoutEight.zeroOpvGiven.isChecked());
                childEight.setIsHepBZeroGiven(customChildInfoLayoutEight.hepBZero.isChecked());
                childEight.setIsVitaminKGiven(customChildInfoLayoutEight.injVitK.isChecked());
            }
            boolean sexSelected = false;
            String sexMaleRadioButtonString = customChildInfoLayoutEight.sexMale.getText().toString();
            if (sexMaleRadioButtonString != null && !(sexMaleRadioButtonString.trim().equals(""))) {
                for (String gender : genderTypeMap.keySet()) {
                    if (sexMaleRadioButtonString.equals(gender)) {
                        if (customChildInfoLayoutEight.sexMale.isChecked()) {
                            Integer id = genderTypeMap.get(gender);
                            if (id != null) {
                                childEight.setChildSex(id);
                                sexSelected = true;
                            }
                            break;
                        }
                    }
                }

            }
            String sexFemaleRadioButtonString = customChildInfoLayoutEight.sexFemale.getText().toString();
            if (sexFemaleRadioButtonString != null && !(sexFemaleRadioButtonString.trim().equals(""))) {
                for (String gender : genderTypeMap.keySet()) {
                    if (sexFemaleRadioButtonString.equals(gender)) {
                        if (customChildInfoLayoutEight.sexFemale.isChecked()) {
                            Integer id = genderTypeMap.get(gender);
                            if (id != null) {
                                childEight.setChildSex(id);
                                sexSelected = true;
                            }
                            break;
                        }
                    }
                }

            }
            if (!sexSelected) {
                childEight.setChildSex(null);
            }

            //child Weight
            String childWeight = customChildInfoLayoutEight.weightEditBox.getText().toString();
            if (childWeight != null && !(childWeight.trim().equals(""))) {
                try {
                    childEight.setChildWeight(Float.parseFloat(childWeight.trim()));
                } catch (NumberFormatException e) {
                    childEight.setChildWeight(null);
                }
            } else {
                childEight.setChildWeight(null);
            }

            childList.add(childEight);
        }

        //Child Nine
        if (childEightFlag) {
            ChildModel childNine = new ChildModel();

            if (customChildInfoLayoutNine.stillBirthTB.isChecked()) {
                childNine.setIsStillBirth(true);

                //still birth type
                String stillBirthTypeString = customChildInfoLayoutNine.stillBirthTypeEditBox.getText().toString();
                if (stillBirthTypeString != null && !(stillBirthTypeString.trim().equals(""))) {
                    try {
                        Integer id = stillBirthTypeMap.get(stillBirthTypeString);
                        childNine.setStillBirthType(id);
                    } catch (NumberFormatException e) {
                        childNine.setStillBirthType(null);
                    }
                } else {
                    childNine.setStillBirthType(null);
                }

            } else {
                //live child
                childNine.setIsStillBirth(false);
                childNine.setIsChildBreastFedInHour(customChildInfoLayoutNine.babyBreastFeed.isChecked());
                childNine.setHasNeededRescusition(customChildInfoLayoutNine.rescusitation.isChecked());
                childNine.setHasCongenitalAnomalies(customChildInfoLayoutNine.congenitalAnomalies.isChecked());
                childNine.setIsBCGGiven(customChildInfoLayoutNine.bcgGiven.isChecked());
                childNine.setIsZeroOPVGiven(customChildInfoLayoutNine.zeroOpvGiven.isChecked());
                childNine.setIsHepBZeroGiven(customChildInfoLayoutNine.hepBZero.isChecked());
                childNine.setIsVitaminKGiven(customChildInfoLayoutNine.injVitK.isChecked());
            }
            boolean sexSelected = false;
            String sexMaleRadioButtonString = customChildInfoLayoutNine.sexMale.getText().toString();
            if (sexMaleRadioButtonString != null && !(sexMaleRadioButtonString.trim().equals(""))) {
                for (String gender : genderTypeMap.keySet()) {
                    if (sexMaleRadioButtonString.equals(gender)) {
                        if (customChildInfoLayoutNine.sexMale.isChecked()) {
                            Integer id = genderTypeMap.get(gender);
                            if (id != null) {
                                childNine.setChildSex(id);
                                sexSelected = true;
                            }
                            break;
                        }
                    }
                }

            }
            String sexFemaleRadioButtonString = customChildInfoLayoutNine.sexFemale.getText().toString();
            if (sexFemaleRadioButtonString != null && !(sexFemaleRadioButtonString.trim().equals(""))) {
                for (String gender : genderTypeMap.keySet()) {
                    if (sexFemaleRadioButtonString.equals(gender)) {
                        if (customChildInfoLayoutNine.sexFemale.isChecked()) {
                            Integer id = genderTypeMap.get(gender);
                            if (id != null) {
                                childNine.setChildSex(id);
                                sexSelected = true;
                            }
                            break;
                        }
                    }
                }

            }
            if (!sexSelected) {
                childNine.setChildSex(null);
            }

            //child Weight
            String childWeight = customChildInfoLayoutNine.weightEditBox.getText().toString();
            if (childWeight != null && !(childWeight.trim().equals(""))) {
                try {
                    childNine.setChildWeight(Float.parseFloat(childWeight.trim()));
                } catch (NumberFormatException e) {
                    childNine.setChildWeight(null);
                }
            } else {
                childNine.setChildWeight(null);
            }

            childList.add(childNine);
        }


        //Child Ten
        if (childTenFlag) {
            ChildModel childTen = new ChildModel();

            if (customChildInfoLayoutTen.stillBirthTB.isChecked()) {
                childTen.setIsStillBirth(true);

                //still birth type
                String stillBirthTypeString = customChildInfoLayoutTen.stillBirthTypeEditBox.getText().toString();
                if (stillBirthTypeString != null && !(stillBirthTypeString.trim().equals(""))) {
                    try {
                        Integer id = stillBirthTypeMap.get(stillBirthTypeString);
                        childTen.setStillBirthType(id);
                    } catch (NumberFormatException e) {
                        childTen.setStillBirthType(null);
                    }
                } else {
                    childTen.setStillBirthType(null);
                }

            } else {
                //live child
                childTen.setIsStillBirth(false);
                childTen.setIsChildBreastFedInHour(customChildInfoLayoutTen.babyBreastFeed.isChecked());
                childTen.setHasNeededRescusition(customChildInfoLayoutTen.rescusitation.isChecked());
                childTen.setHasCongenitalAnomalies(customChildInfoLayoutTen.congenitalAnomalies.isChecked());
                childTen.setIsBCGGiven(customChildInfoLayoutTen.bcgGiven.isChecked());
                childTen.setIsZeroOPVGiven(customChildInfoLayoutTen.zeroOpvGiven.isChecked());
                childTen.setIsHepBZeroGiven(customChildInfoLayoutTen.hepBZero.isChecked());
                childTen.setIsVitaminKGiven(customChildInfoLayoutTen.injVitK.isChecked());
            }
            boolean sexSelected = false;
            String sexMaleRadioButtonString = customChildInfoLayoutTen.sexMale.getText().toString();
            if (sexMaleRadioButtonString != null && !(sexMaleRadioButtonString.trim().equals(""))) {
                for (String gender : genderTypeMap.keySet()) {
                    if (sexMaleRadioButtonString.equals(gender)) {
                        if (customChildInfoLayoutTen.sexMale.isChecked()) {
                            Integer id = genderTypeMap.get(gender);
                            if (id != null) {
                                childTen.setChildSex(id);
                                sexSelected = true;
                            }
                            break;
                        }
                    }
                }

            }
            String sexFemaleRadioButtonString = customChildInfoLayoutTen.sexFemale.getText().toString();
            if (sexFemaleRadioButtonString != null && !(sexFemaleRadioButtonString.trim().equals(""))) {
                for (String gender : genderTypeMap.keySet()) {
                    if (sexFemaleRadioButtonString.equals(gender)) {
                        if (customChildInfoLayoutTen.sexFemale.isChecked()) {
                            Integer id = genderTypeMap.get(gender);
                            if (id != null) {
                                childTen.setChildSex(id);
                                sexSelected = true;
                            }
                            break;
                        }
                    }
                }

            }
            if (!sexSelected) {
                childTen.setChildSex(null);
            }

            //child Weight
            String childWeight = customChildInfoLayoutTen.weightEditBox.getText().toString();
            if (childWeight != null && !(childWeight.trim().equals(""))) {
                try {
                    childTen.setChildWeight(Float.parseFloat(childWeight.trim()));
                } catch (NumberFormatException e) {
                    childTen.setChildWeight(null);
                }
            } else {
                childTen.setChildWeight(null);
            }

            childList.add(childTen);
        }


        patientModel.setChildren(childList);

        //blood transfusion
        patientModel.setBloodTransfusionGiven(bloodTransfusion.isChecked());

        //No of pints
        String noOfPintsString = noOfPints.getText().toString();
        if (noOfPintsString != null && !(noOfPintsString.trim().equals(""))) {
            try {
                patientModel.setNoOfPints(Integer.parseInt(noOfPintsString.trim()));
            } catch (NumberFormatException e) {
                patientModel.setNoOfPints(null);
            }
        } else {
            patientModel.setNoOfPints(null);
        }

        //PPIUCD insertion
        patientModel.setPpiucdInserted(ppiucdInsertion.isChecked());


        //ifa
        patientModel.setIFAGivenInPNC(ifa.isChecked());


        //calcium vit d3
        patientModel.setCalciumVitaminD3InPNC(calciumVitD3.isChecked());


        //type of JSY
        String typeOfJsyString = typeOfJsy.getText().toString();
        if (typeOfJsyString != null && !(typeOfJsyString.trim().equals(""))) {
            try {
                Integer id = jsyTypeTypeMap.get(typeOfJsyString);
                if (id != null) {
                    patientModel.setTypeOfJSY(id);
                }
            } catch (NumberFormatException e) {
                patientModel.setTypeOfJSY(null);
            }
        } else {
            patientModel.setTypeOfJSY(null);
        }

        //brief desc of child status
        List<ChildStatusModel> childStatusList = new ArrayList<>();

        //if child one status is selected
        if (childStatusOneFlag) {
            ChildStatusModel childStatusOne = new ChildStatusModel();

            //child one status
            String childOneStatusString = customChildStatusLayoutOne.childStatusET.getText().toString();
            if (childOneStatusString != null && !(childOneStatusString.trim().equals(""))) {
                try {
                    Integer id = childStatusTypeMap.get(childOneStatusString);
                    childStatusOne.setStatus(id);
                } catch (NumberFormatException e) {
                    childStatusOne.setStatus(null);
                }
            } else {
                childStatusOne.setStatus(null);
            }

            if (childOneStatusString != null && !childOneStatusString.trim().equals("")) {
                switch (childStatusTypeMap.get(childOneStatusString)) {
                    case CHILD_STATUS_DISCHARGED_TYPE_DETAIL_ID:
                        //child one discharge date and time
                        String childOneDischargeDateAndTime = customChildStatusLayoutOne.dischargeDateTimeChildET.getText().toString();
                        if (childOneDischargeDateAndTime != null && !(childOneDischargeDateAndTime.trim().equals(""))) {
                            try {
                                Date date = simpleDateFormat.parse(childOneDischargeDateAndTime.trim());
                                childStatusOne.setDischargeDateAndTime(date);
                            } catch (ParseException e) {
                                childStatusOne.setDischargeDateAndTime(null);
                            }
                        } else {
                            childStatusOne.setDischargeDateAndTime(null);
                        }

                        //child one discharge weight
                        String childDischargeWeightText = customChildStatusLayoutOne.dischargeWeightChildET.getText().toString();
                        if (childDischargeWeightText != null && !(childDischargeWeightText.trim().equals(""))) {
                            childStatusOne.setDischargeWeight(Float.parseFloat(childDischargeWeightText.trim()));
                        } else {
                            childStatusOne.setDischargeWeight(null);
                        }

                        //child one transport to home
                        String childOneTransportToHomeString = customChildStatusLayoutOne.transportToHomeChildET.getText().toString();
                        if (childOneTransportToHomeString != null && !(childOneTransportToHomeString.trim().equals(""))) {
                            try {
                                Integer id = transportTypeMap.get(childOneTransportToHomeString);
                                childStatusOne.setTransportToHome(id);
                            } catch (NumberFormatException e) {
                                childStatusOne.setTransportToHome(null);
                            }
                        } else {
                            childStatusOne.setTransportToHome(null);
                        }
                        break;
                    case CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID:
                        //child one referred date and time
                        String childOneReferredDateAndTime = customChildStatusLayoutOne.referredDateTimeChildET.getText().toString();
                        if (childOneReferredDateAndTime != null && !(childOneReferredDateAndTime.trim().equals(""))) {
                            try {
                                Date date = simpleDateFormat.parse(childOneReferredDateAndTime.trim());
                                childStatusOne.setReferredDateAndTime(date);
                            } catch (ParseException e) {
                                childStatusOne.setReferredDateAndTime(null);
                            }
                        } else {
                            childStatusOne.setReferredDateAndTime(null);
                        }

                        //child one referred by
                        String childOneReferredByText = customChildStatusLayoutOne.referredByChildET.getText().toString();
                        if (childOneReferredByText != null && !(childOneReferredByText.trim().equals(""))) {
                            childStatusOne.setReferredBy(childOneReferredByText.trim());
                        } else {
                            childStatusOne.setReferredBy(null);
                        }

                        //child one referred cause
                        String childOneReferredCauseText = customChildStatusLayoutOne.referredCauseChildET.getText().toString();
                        if (childOneReferredCauseText != null && !(childOneReferredCauseText.trim().equals(""))) {
                            try {
                                Integer id = childReferredCauseTypeMap.get(childOneReferredCauseText);
                                childStatusOne.setReferredCause(id);
                            } catch (NumberFormatException e) {
                                childStatusOne.setReferredCause(null);
                            }
                        } else {
                            childStatusOne.setReferredCause(null);
                        }

                        //child one referred other cause
                        String childOneOtherReferredCauseText = customChildStatusLayoutOne.childReferredOtherCauseET.getText().toString();
                        if (childOneOtherReferredCauseText != null && !(childOneOtherReferredCauseText.trim().equals(""))) {
                            childStatusOne.setOtherReferredCause(childOneOtherReferredCauseText.trim());
                        } else {
                            childStatusOne.setOtherReferredCause(null);
                        }


                        //child one referred area
                        String childOneReferredAreaString = customChildStatusLayoutOne.referredAreaChildET.getText().toString();
                        if (childOneReferredAreaString != null && !(childOneReferredAreaString.trim().equals(""))) {
                            try {
                                Integer id = childReferredFacilityTypeMap.get(childOneReferredAreaString);
                                childStatusOne.setReferredTo(id);
                            } catch (NumberFormatException e) {
                                childStatusOne.setReferredTo(null);
                            }
                        } else {
                            childStatusOne.setReferredTo(null);
                        }

                        //child one referred other cause
                        String childOneOtherReferredAreaString = customChildStatusLayoutOne.referredOtherAreaChildET.getText().toString();
                        if (childOneOtherReferredAreaString != null && !(childOneOtherReferredAreaString.trim().equals(""))) {
                            childStatusOne.setOtherReferredTo(childOneOtherReferredAreaString.trim());
                        } else {
                            childStatusOne.setOtherReferredTo(null);
                        }

                        //child one referred transport
                        String childOneReferredTransportString = customChildStatusLayoutOne.referredTransportChildET.getText().toString();
                        if (childOneReferredTransportString != null && !(childOneReferredTransportString.trim().equals(""))) {
                            try {
                                Integer id = transportTypeMap.get(childOneReferredTransportString);
                                childStatusOne.setReferredTransport(id);
                            } catch (NumberFormatException e) {
                                childStatusOne.setReferredTransport(null);
                            }
                        } else {
                            childStatusOne.setReferredTransport(null);
                        }
                        break;
                    case CHILD_STATUS_LAMA_TYPE_DETAIL_ID:
                        //child one lama date and time
                        String childOneLamaDateAndTimeString = customChildStatusLayoutOne.lamaDateTimeChildET.getText().toString();
                        if (childOneLamaDateAndTimeString != null && !(childOneLamaDateAndTimeString.trim().equals(""))) {
                            try {
                                Date lamaDate = simpleDateFormat.parse(childOneLamaDateAndTimeString.trim());
                                childStatusOne.setLamaDateAndTime(lamaDate);
                            } catch (ParseException e) {
                                childStatusOne.setLamaDateAndTime(null);
                            }
                        } else {
                            childStatusOne.setLamaDateAndTime(null);
                        }
                        break;
                    case CHILD_STATUS_DEATH_TYPE_DETAIL_ID:
                        //child one death date and time
                        String childOneDeathDateAndTimeString = customChildStatusLayoutOne.childDeathDateTimeET.getText().toString();
                        if (childOneDeathDateAndTimeString != null & !childOneDeathDateAndTimeString.equals("")) {
                            try {
                                Date date = simpleDateFormat.parse(childOneDeathDateAndTimeString);
                                childStatusOne.setDeathDateAndTime(date);
                            } catch (ParseException e) {
                                childStatusOne.setDeathDateAndTime(null);
                            }
                        } else {
                            childStatusOne.setDeathDateAndTime(null);
                        }

                        //child one death cause
                        String childOneDeathCauseText = customChildStatusLayoutOne.childDeathCauseET.getText().toString();
                        if (childOneDeathCauseText != null && !(childOneDeathCauseText.trim().equals(""))) {
                            childStatusOne.setDeathCause(childOneDeathCauseText.trim());
                        } else {
                            childStatusOne.setDeathCause(null);
                        }
                        break;
                }
            }
            childStatusList.add(childStatusOne);
        }

        //if child two status is selected
        if (childStatusTwoFlag) {
            ChildStatusModel childStatusTwo = new ChildStatusModel();

            //child two status
            String childTwoStatusString = customChildStatusLayoutTwo.childStatusET.getText().toString();
            if (childTwoStatusString != null && !(childTwoStatusString.trim().equals(""))) {
                try {
                    Integer id = childStatusTypeMap.get(childTwoStatusString);
                    childStatusTwo.setStatus(id);
                } catch (NumberFormatException e) {
                    childStatusTwo.setStatus(null);
                }
            } else {
                childStatusTwo.setStatus(null);
            }

            if (childTwoStatusString != null && !childTwoStatusString.trim().equals("")) {
                switch (childStatusTypeMap.get(childTwoStatusString)) {
                    case CHILD_STATUS_DISCHARGED_TYPE_DETAIL_ID:
                        //child two discharge date and time
                        String childTwoDischargeDateAndTime = customChildStatusLayoutTwo.dischargeDateTimeChildET.getText().toString();
                        if (childTwoDischargeDateAndTime != null && !(childTwoDischargeDateAndTime.trim().equals(""))) {
                            try {
                                Date date = simpleDateFormat.parse(childTwoDischargeDateAndTime.trim());
                                childStatusTwo.setDischargeDateAndTime(date);
                            } catch (ParseException e) {
                                childStatusTwo.setDischargeDateAndTime(null);
                            }
                        } else {
                            childStatusTwo.setDischargeDateAndTime(null);
                        }

                        //child two discharge weight
                        String childDischargeWeightText = customChildStatusLayoutTwo.dischargeWeightChildET.getText().toString();
                        if (childDischargeWeightText != null && !(childDischargeWeightText.trim().equals(""))) {
                            childStatusTwo.setDischargeWeight(Float.parseFloat(childDischargeWeightText.trim()));
                        } else {
                            childStatusTwo.setDischargeWeight(null);
                        }

                        //child two transport to home
                        String childTwoTransportToHomeString = customChildStatusLayoutTwo.transportToHomeChildET.getText().toString();
                        if (childTwoTransportToHomeString != null && !(childTwoTransportToHomeString.trim().equals(""))) {
                            try {
                                Integer id = transportTypeMap.get(childTwoTransportToHomeString);
                                childStatusTwo.setTransportToHome(id);
                            } catch (NumberFormatException e) {
                                childStatusTwo.setTransportToHome(null);
                            }
                        } else {
                            childStatusTwo.setTransportToHome(null);
                        }
                        break;
                    case CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID:

                        //child two referred date and time
                        String childTwoReferredDateAndTime = customChildStatusLayoutTwo.referredDateTimeChildET.getText().toString();
                        if (childTwoReferredDateAndTime != null && !(childTwoReferredDateAndTime.trim().equals(""))) {
                            try {
                                Date date = simpleDateFormat.parse(childTwoReferredDateAndTime.trim());
                                childStatusTwo.setReferredDateAndTime(date);
                            } catch (ParseException e) {
                                childStatusTwo.setReferredDateAndTime(null);
                            }
                        } else {
                            childStatusTwo.setReferredDateAndTime(null);
                        }

                        //child two referred by
                        String childTwoReferredByText = customChildStatusLayoutTwo.referredByChildET.getText().toString();
                        if (childTwoReferredByText != null && !(childTwoReferredByText.trim().equals(""))) {
                            childStatusTwo.setReferredBy(childTwoReferredByText.trim());
                        } else {
                            childStatusTwo.setReferredBy(null);
                        }

                        //child two referred cause
                        String childTwoReferredCauseText = customChildStatusLayoutTwo.referredCauseChildET.getText().toString();
                        if (childTwoReferredCauseText != null && !(childTwoReferredCauseText.trim().equals(""))) {
                            try {
                                Integer id = childReferredCauseTypeMap.get(childTwoReferredCauseText);
                                childStatusTwo.setReferredCause(id);
                            } catch (NumberFormatException e) {
                                childStatusTwo.setReferredCause(null);
                            }
                        } else {
                            childStatusTwo.setReferredCause(null);
                        }

                        //child two referred other cause
                        String childTwoOtherReferredCauseText = customChildStatusLayoutTwo.childReferredOtherCauseET.getText().toString();
                        if (childTwoOtherReferredCauseText != null && !(childTwoOtherReferredCauseText.trim().equals(""))) {
                            childStatusTwo.setOtherReferredCause(childTwoOtherReferredCauseText.trim());
                        } else {
                            childStatusTwo.setOtherReferredCause(null);
                        }


                        //child two referred area
                        String childTwoReferredAreaString = customChildStatusLayoutTwo.referredAreaChildET.getText().toString();
                        if (childTwoReferredAreaString != null && !(childTwoReferredAreaString.trim().equals(""))) {
                            try {
                                Integer id = childReferredFacilityTypeMap.get(childTwoReferredAreaString);
                                childStatusTwo.setReferredTo(id);
                            } catch (NumberFormatException e) {
                                childStatusTwo.setReferredTo(null);
                            }
                        } else {
                            childStatusTwo.setReferredTo(null);
                        }

                        //child two referred other cause
                        String childTwoOtherReferredAreaString = customChildStatusLayoutTwo.referredOtherAreaChildET.getText().toString();
                        if (childTwoOtherReferredAreaString != null && !(childTwoOtherReferredAreaString.trim().equals(""))) {
                            childStatusTwo.setOtherReferredTo(childTwoOtherReferredAreaString.trim());
                        } else {
                            childStatusTwo.setOtherReferredTo(null);
                        }

                        //child two referred transport
                        String childTwoReferredTransportString = customChildStatusLayoutTwo.referredTransportChildET.getText().toString();
                        if (childTwoReferredTransportString != null && !(childTwoReferredTransportString.trim().equals(""))) {
                            try {
                                Integer id = transportTypeMap.get(childTwoReferredTransportString);
                                childStatusTwo.setReferredTransport(id);
                            } catch (NumberFormatException e) {
                                childStatusTwo.setReferredTransport(null);
                            }
                        } else {
                            childStatusTwo.setReferredTransport(null);
                        }

                        break;
                    case CHILD_STATUS_LAMA_TYPE_DETAIL_ID:
                        //child two lama date and time
                        String childTwoLamaDateAndTimeString = customChildStatusLayoutTwo.lamaDateTimeChildET.getText().toString();
                        if (childTwoLamaDateAndTimeString != null && !(childTwoLamaDateAndTimeString.trim().equals(""))) {
                            try {
                                Date lamaDate = simpleDateFormat.parse(childTwoLamaDateAndTimeString.trim());
                                childStatusTwo.setLamaDateAndTime(lamaDate);
                            } catch (ParseException e) {
                                childStatusTwo.setLamaDateAndTime(null);
                            }
                        } else {
                            childStatusTwo.setLamaDateAndTime(null);
                        }
                        break;
                    case CHILD_STATUS_DEATH_TYPE_DETAIL_ID:

                        //child two death date and time
                        String childTwoDeathDateAndTimeString = customChildStatusLayoutTwo.childDeathDateTimeET.getText().toString();
                        if (childTwoDeathDateAndTimeString != null & !childTwoDeathDateAndTimeString.equals("")) {
                            try {
                                Date date = simpleDateFormat.parse(childTwoDeathDateAndTimeString);
                                childStatusTwo.setDeathDateAndTime(date);
                            } catch (ParseException e) {
                                childStatusTwo.setDeathDateAndTime(null);
                            }
                        } else {
                            childStatusTwo.setDeathDateAndTime(null);
                        }

                        //child two death cause
                        String childTwoDeathCauseText = customChildStatusLayoutTwo.childDeathCauseET.getText().toString();
                        if (childTwoDeathCauseText != null && !(childTwoDeathCauseText.trim().equals(""))) {
                            childStatusTwo.setDeathCause(childTwoDeathCauseText.trim());
                        } else {
                            childStatusTwo.setDeathCause(null);
                        }
                        break;
                }
            }
            childStatusList.add(childStatusTwo);
        }

        //if child three status is selected
        if (childStatusThreeFlag) {
            ChildStatusModel childStatusThree = new ChildStatusModel();

            //child three status
            String childThreeStatusString = customChildStatusLayoutThree.childStatusET.getText().toString();
            if (childThreeStatusString != null && !(childThreeStatusString.trim().equals(""))) {
                try {
                    Integer id = childStatusTypeMap.get(childThreeStatusString);
                    childStatusThree.setStatus(id);
                } catch (NumberFormatException e) {
                    childStatusThree.setStatus(null);
                }
            } else {
                childStatusThree.setStatus(null);
            }

            if (childThreeStatusString != null && !childThreeStatusString.trim().equals("")) {
                switch (childStatusTypeMap.get(childThreeStatusString)) {
                    case CHILD_STATUS_DISCHARGED_TYPE_DETAIL_ID:
                        //child three discharge date and time
                        String childThreeDischargeDateAndTime = customChildStatusLayoutThree.dischargeDateTimeChildET.getText().toString();
                        if (childThreeDischargeDateAndTime != null && !(childThreeDischargeDateAndTime.trim().equals(""))) {
                            try {
                                Date date = simpleDateFormat.parse(childThreeDischargeDateAndTime.trim());
                                childStatusThree.setDischargeDateAndTime(date);
                            } catch (ParseException e) {
                                childStatusThree.setDischargeDateAndTime(null);
                            }
                        } else {
                            childStatusThree.setDischargeDateAndTime(null);
                        }

                        //child three discharge weight
                        String childDischargeWeightText = customChildStatusLayoutThree.dischargeWeightChildET.getText().toString();
                        if (childDischargeWeightText != null && !(childDischargeWeightText.trim().equals(""))) {
                            childStatusThree.setDischargeWeight(Float.parseFloat(childDischargeWeightText.trim()));
                        } else {
                            childStatusThree.setDischargeWeight(null);
                        }

                        //child three transport to home
                        String childThreeTransportToHomeString = customChildStatusLayoutThree.transportToHomeChildET.getText().toString();
                        if (childThreeTransportToHomeString != null && !(childThreeTransportToHomeString.trim().equals(""))) {
                            try {
                                Integer id = transportTypeMap.get(childThreeTransportToHomeString);
                                childStatusThree.setTransportToHome(id);
                            } catch (NumberFormatException e) {
                                childStatusThree.setTransportToHome(null);
                            }
                        } else {
                            childStatusThree.setTransportToHome(null);
                        }
                        break;
                    case CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID:
                        //child three referred date and time
                        String childThreeReferredDateAndTime = customChildStatusLayoutThree.referredDateTimeChildET.getText().toString();
                        if (childThreeReferredDateAndTime != null && !(childThreeReferredDateAndTime.trim().equals(""))) {
                            try {
                                Date date = simpleDateFormat.parse(childThreeReferredDateAndTime.trim());
                                childStatusThree.setReferredDateAndTime(date);
                            } catch (ParseException e) {
                                childStatusThree.setReferredDateAndTime(null);
                            }
                        } else {
                            childStatusThree.setReferredDateAndTime(null);
                        }

                        //child three referred by
                        String childThreeReferredByText = customChildStatusLayoutThree.referredByChildET.getText().toString();
                        if (childThreeReferredByText != null && !(childThreeReferredByText.trim().equals(""))) {
                            childStatusThree.setReferredBy(childThreeReferredByText.trim());
                        } else {
                            childStatusThree.setReferredBy(null);
                        }

                        //child three referred cause
                        String childThreeReferredCauseText = customChildStatusLayoutThree.referredCauseChildET.getText().toString();
                        if (childThreeReferredCauseText != null && !(childThreeReferredCauseText.trim().equals(""))) {
                            try {
                                Integer id = childReferredCauseTypeMap.get(childThreeReferredCauseText);
                                childStatusThree.setReferredCause(id);
                            } catch (NumberFormatException e) {
                                childStatusThree.setReferredCause(null);
                            }
                        } else {
                            childStatusThree.setReferredCause(null);
                        }

                        //child three referred other cause
                        String childThreeOtherReferredCauseText = customChildStatusLayoutThree.childReferredOtherCauseET.getText().toString();
                        if (childThreeOtherReferredCauseText != null && !(childThreeOtherReferredCauseText.trim().equals(""))) {
                            childStatusThree.setOtherReferredCause(childThreeOtherReferredCauseText.trim());
                        } else {
                            childStatusThree.setOtherReferredCause(null);
                        }


                        //child three referred area
                        String childThreeReferredAreaString = customChildStatusLayoutThree.referredAreaChildET.getText().toString();
                        if (childThreeReferredAreaString != null && !(childThreeReferredAreaString.trim().equals(""))) {
                            try {
                                Integer id = childReferredFacilityTypeMap.get(childThreeReferredAreaString);
                                childStatusThree.setReferredTo(id);
                            } catch (NumberFormatException e) {
                                childStatusThree.setReferredTo(null);
                            }
                        } else {
                            childStatusThree.setReferredTo(null);
                        }

                        //child three referred other cause
                        String childThreeOtherReferredAreaString = customChildStatusLayoutThree.referredOtherAreaChildET.getText().toString();
                        if (childThreeOtherReferredAreaString != null && !(childThreeOtherReferredAreaString.trim().equals(""))) {
                            childStatusThree.setOtherReferredTo(childThreeOtherReferredAreaString.trim());
                        } else {
                            childStatusThree.setOtherReferredTo(null);
                        }

                        //child three referred transport
                        String childThreeReferredTransportString = customChildStatusLayoutThree.referredTransportChildET.getText().toString();
                        if (childThreeReferredTransportString != null && !(childThreeReferredTransportString.trim().equals(""))) {
                            try {
                                Integer id = transportTypeMap.get(childThreeReferredTransportString);
                                childStatusThree.setReferredTransport(id);
                            } catch (NumberFormatException e) {
                                childStatusThree.setReferredTransport(null);
                            }
                        } else {
                            childStatusThree.setReferredTransport(null);
                        }
                        break;
                    case CHILD_STATUS_LAMA_TYPE_DETAIL_ID:
                        //child three lama date and time
                        String childThreeLamaDateAndTimeString = customChildStatusLayoutThree.lamaDateTimeChildET.getText().toString();
                        if (childThreeLamaDateAndTimeString != null && !(childThreeLamaDateAndTimeString.trim().equals(""))) {
                            try {
                                Date lamaDate = simpleDateFormat.parse(childThreeLamaDateAndTimeString.trim());
                                childStatusThree.setLamaDateAndTime(lamaDate);
                            } catch (ParseException e) {
                                childStatusThree.setLamaDateAndTime(null);
                            }
                        } else {
                            childStatusThree.setLamaDateAndTime(null);
                        }
                        break;
                    case CHILD_STATUS_DEATH_TYPE_DETAIL_ID:
                        //child three death date and time
                        String childThreeDeathDateAndTimeString = customChildStatusLayoutThree.childDeathDateTimeET.getText().toString();
                        if (childThreeDeathDateAndTimeString != null & !childThreeDeathDateAndTimeString.equals("")) {
                            try {
                                Date date = simpleDateFormat.parse(childThreeDeathDateAndTimeString);
                                childStatusThree.setDeathDateAndTime(date);
                            } catch (ParseException e) {
                                childStatusThree.setDeathDateAndTime(null);
                            }
                        } else {
                            childStatusThree.setDeathDateAndTime(null);
                        }

                        //child three death cause
                        String childThreeDeathCauseText = customChildStatusLayoutThree.childDeathCauseET.getText().toString();
                        if (childThreeDeathCauseText != null && !(childThreeDeathCauseText.trim().equals(""))) {
                            childStatusThree.setDeathCause(childThreeDeathCauseText.trim());
                        } else {
                            childStatusThree.setDeathCause(null);
                        }
                        break;
                }
            }
            childStatusList.add(childStatusThree);
        }

        //if child four status is selected
        if (childStatusFourFlag) {
            ChildStatusModel childStatusFour = new ChildStatusModel();

            //child four status
            String childFourStatusString = customChildStatusLayoutFour.childStatusET.getText().toString();
            if (childFourStatusString != null && !(childFourStatusString.trim().equals(""))) {
                try {
                    Integer id = childStatusTypeMap.get(childFourStatusString);
                    childStatusFour.setStatus(id);
                } catch (NumberFormatException e) {
                    childStatusFour.setStatus(null);
                }
            } else {
                childStatusFour.setStatus(null);
            }

            if (childFourStatusString != null && !childFourStatusString.trim().equals("")) {
                switch (childStatusTypeMap.get(childFourStatusString)) {
                    case CHILD_STATUS_DISCHARGED_TYPE_DETAIL_ID:
                        //child four discharge date and time
                        String childFourDischargeDateAndTime = customChildStatusLayoutFour.dischargeDateTimeChildET.getText().toString();
                        if (childFourDischargeDateAndTime != null && !(childFourDischargeDateAndTime.trim().equals(""))) {
                            try {
                                Date date = simpleDateFormat.parse(childFourDischargeDateAndTime.trim());
                                childStatusFour.setDischargeDateAndTime(date);
                            } catch (ParseException e) {
                                childStatusFour.setDischargeDateAndTime(null);
                            }
                        } else {
                            childStatusFour.setDischargeDateAndTime(null);
                        }

                        //child four discharge weight
                        String childDischargeWeightText = customChildStatusLayoutFour.dischargeWeightChildET.getText().toString();
                        if (childDischargeWeightText != null && !(childDischargeWeightText.trim().equals(""))) {
                            childStatusFour.setDischargeWeight(Float.parseFloat(childDischargeWeightText.trim()));
                        } else {
                            childStatusFour.setDischargeWeight(null);
                        }

                        //child four transport to home
                        String childFourTransportToHomeString = customChildStatusLayoutFour.transportToHomeChildET.getText().toString();
                        if (childFourTransportToHomeString != null && !(childFourTransportToHomeString.trim().equals(""))) {
                            try {
                                Integer id = transportTypeMap.get(childFourTransportToHomeString);
                                childStatusFour.setTransportToHome(id);
                            } catch (NumberFormatException e) {
                                childStatusFour.setTransportToHome(null);
                            }
                        } else {
                            childStatusFour.setTransportToHome(null);
                        }
                        break;
                    case CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID:
                        //child four referred date and time
                        String childFourReferredDateAndTime = customChildStatusLayoutFour.referredDateTimeChildET.getText().toString();
                        if (childFourReferredDateAndTime != null && !(childFourReferredDateAndTime.trim().equals(""))) {
                            try {
                                Date date = simpleDateFormat.parse(childFourReferredDateAndTime.trim());
                                childStatusFour.setReferredDateAndTime(date);
                            } catch (ParseException e) {
                                childStatusFour.setReferredDateAndTime(null);
                            }
                        } else {
                            childStatusFour.setReferredDateAndTime(null);
                        }

                        //child four referred by
                        String childFourReferredByText = customChildStatusLayoutFour.referredByChildET.getText().toString();
                        if (childFourReferredByText != null && !(childFourReferredByText.trim().equals(""))) {
                            childStatusFour.setReferredBy(childFourReferredByText.trim());
                        } else {
                            childStatusFour.setReferredBy(null);
                        }

                        //child four referred cause
                        String childFourReferredCauseText = customChildStatusLayoutFour.referredCauseChildET.getText().toString();
                        if (childFourReferredCauseText != null && !(childFourReferredCauseText.trim().equals(""))) {
                            try {
                                Integer id = childReferredCauseTypeMap.get(childFourReferredCauseText);
                                childStatusFour.setReferredCause(id);
                            } catch (NumberFormatException e) {
                                childStatusFour.setReferredCause(null);
                            }
                        } else {
                            childStatusFour.setReferredCause(null);
                        }

                        //child four referred other cause
                        String childFourOtherReferredCauseText = customChildStatusLayoutFour.childReferredOtherCauseET.getText().toString();
                        if (childFourOtherReferredCauseText != null && !(childFourOtherReferredCauseText.trim().equals(""))) {
                            childStatusFour.setOtherReferredCause(childFourOtherReferredCauseText.trim());
                        } else {
                            childStatusFour.setOtherReferredCause(null);
                        }


                        //child four referred area
                        String childFourReferredAreaString = customChildStatusLayoutFour.referredAreaChildET.getText().toString();
                        if (childFourReferredAreaString != null && !(childFourReferredAreaString.trim().equals(""))) {
                            try {
                                Integer id = childReferredFacilityTypeMap.get(childFourReferredAreaString);
                                childStatusFour.setReferredTo(id);
                            } catch (NumberFormatException e) {
                                childStatusFour.setReferredTo(null);
                            }
                        } else {
                            childStatusFour.setReferredTo(null);
                        }

                        //child four referred other cause
                        String childFourOtherReferredAreaString = customChildStatusLayoutFour.referredOtherAreaChildET.getText().toString();
                        if (childFourOtherReferredAreaString != null && !(childFourOtherReferredAreaString.trim().equals(""))) {
                            childStatusFour.setOtherReferredTo(childFourOtherReferredAreaString.trim());
                        } else {
                            childStatusFour.setOtherReferredTo(null);
                        }

                        //child four referred transport
                        String childFourReferredTransportString = customChildStatusLayoutFour.referredTransportChildET.getText().toString();
                        if (childFourReferredTransportString != null && !(childFourReferredTransportString.trim().equals(""))) {
                            try {
                                Integer id = transportTypeMap.get(childFourReferredTransportString);
                                childStatusFour.setReferredTransport(id);
                            } catch (NumberFormatException e) {
                                childStatusFour.setReferredTransport(null);
                            }
                        } else {
                            childStatusFour.setReferredTransport(null);
                        }
                        break;
                    case CHILD_STATUS_LAMA_TYPE_DETAIL_ID:
                        //child four lama date and time
                        String childFourLamaDateAndTimeString = customChildStatusLayoutFour.lamaDateTimeChildET.getText().toString();
                        if (childFourLamaDateAndTimeString != null && !(childFourLamaDateAndTimeString.trim().equals(""))) {
                            try {
                                Date lamaDate = simpleDateFormat.parse(childFourLamaDateAndTimeString.trim());
                                childStatusFour.setLamaDateAndTime(lamaDate);
                            } catch (ParseException e) {
                                childStatusFour.setLamaDateAndTime(null);
                            }
                        } else {
                            childStatusFour.setLamaDateAndTime(null);
                        }
                        break;
                    case CHILD_STATUS_DEATH_TYPE_DETAIL_ID:
                        //child four death date and time
                        String childFourDeathDateAndTimeString = customChildStatusLayoutFour.childDeathDateTimeET.getText().toString();
                        if (childFourDeathDateAndTimeString != null & !childFourDeathDateAndTimeString.equals("")) {
                            try {
                                Date date = simpleDateFormat.parse(childFourDeathDateAndTimeString);
                                childStatusFour.setDeathDateAndTime(date);
                            } catch (ParseException e) {
                                childStatusFour.setDeathDateAndTime(null);
                            }
                        } else {
                            childStatusFour.setDeathDateAndTime(null);
                        }

                        //child four death cause
                        String childFourDeathCauseText = customChildStatusLayoutFour.childDeathCauseET.getText().toString();
                        if (childFourDeathCauseText != null && !(childFourDeathCauseText.trim().equals(""))) {
                            childStatusFour.setDeathCause(childFourDeathCauseText.trim());
                        } else {
                            childStatusFour.setDeathCause(null);
                        }
                        break;
                }
            }
            childStatusList.add(childStatusFour);
        }

        //if child five status is selected
        if (childStatusFiveFlag) {
            ChildStatusModel childStatusFive = new ChildStatusModel();

            //child five status
            String childFiveStatusString = customChildStatusLayoutFive.childStatusET.getText().toString();
            if (childFiveStatusString != null && !(childFiveStatusString.trim().equals(""))) {
                try {
                    Integer id = childStatusTypeMap.get(childFiveStatusString);
                    childStatusFive.setStatus(id);
                } catch (NumberFormatException e) {
                    childStatusFive.setStatus(null);
                }
            } else {
                childStatusFive.setStatus(null);
            }

            if (childFiveStatusString != null && !childFiveStatusString.trim().equals("")) {
                switch (childStatusTypeMap.get(childFiveStatusString)) {
                    case CHILD_STATUS_DISCHARGED_TYPE_DETAIL_ID:
                        //child five discharge date and time
                        String childFiveDischargeDateAndTime = customChildStatusLayoutFive.dischargeDateTimeChildET.getText().toString();
                        if (childFiveDischargeDateAndTime != null && !(childFiveDischargeDateAndTime.trim().equals(""))) {
                            try {
                                Date date = simpleDateFormat.parse(childFiveDischargeDateAndTime.trim());
                                childStatusFive.setDischargeDateAndTime(date);
                            } catch (ParseException e) {
                                childStatusFive.setDischargeDateAndTime(null);
                            }
                        } else {
                            childStatusFive.setDischargeDateAndTime(null);
                        }

                        //child five discharge weight
                        String childDischargeWeightText = customChildStatusLayoutFive.dischargeWeightChildET.getText().toString();
                        if (childDischargeWeightText != null && !(childDischargeWeightText.trim().equals(""))) {
                            childStatusFive.setDischargeWeight(Float.parseFloat(childDischargeWeightText.trim()));
                        } else {
                            childStatusFive.setDischargeWeight(null);
                        }

                        //child five transport to home
                        String childFiveTransportToHomeString = customChildStatusLayoutFive.transportToHomeChildET.getText().toString();
                        if (childFiveTransportToHomeString != null && !(childFiveTransportToHomeString.trim().equals(""))) {
                            try {
                                Integer id = transportTypeMap.get(childFiveTransportToHomeString);
                                childStatusFive.setTransportToHome(id);
                            } catch (NumberFormatException e) {
                                childStatusFive.setTransportToHome(null);
                            }
                        } else {
                            childStatusFive.setTransportToHome(null);
                        }
                        break;
                    case CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID:
                        //child five referred date and time
                        String childFiveReferredDateAndTime = customChildStatusLayoutFive.referredDateTimeChildET.getText().toString();
                        if (childFiveReferredDateAndTime != null && !(childFiveReferredDateAndTime.trim().equals(""))) {
                            try {
                                Date date = simpleDateFormat.parse(childFiveReferredDateAndTime.trim());
                                childStatusFive.setReferredDateAndTime(date);
                            } catch (ParseException e) {
                                childStatusFive.setReferredDateAndTime(null);
                            }
                        } else {
                            childStatusFive.setReferredDateAndTime(null);
                        }

                        //child five referred by
                        String childFiveReferredByText = customChildStatusLayoutFive.referredByChildET.getText().toString();
                        if (childFiveReferredByText != null && !(childFiveReferredByText.trim().equals(""))) {
                            childStatusFive.setReferredBy(childFiveReferredByText.trim());
                        } else {
                            childStatusFive.setReferredBy(null);
                        }

                        //child five referred cause
                        String childFiveReferredCauseText = customChildStatusLayoutFive.referredCauseChildET.getText().toString();
                        if (childFiveReferredCauseText != null && !(childFiveReferredCauseText.trim().equals(""))) {
                            try {
                                Integer id = childReferredCauseTypeMap.get(childFiveReferredCauseText);
                                childStatusFive.setReferredCause(id);
                            } catch (NumberFormatException e) {
                                childStatusFive.setReferredCause(null);
                            }
                        } else {
                            childStatusFive.setReferredCause(null);
                        }

                        //child five referred other cause
                        String childFiveOtherReferredCauseText = customChildStatusLayoutFive.childReferredOtherCauseET.getText().toString();
                        if (childFiveOtherReferredCauseText != null && !(childFiveOtherReferredCauseText.trim().equals(""))) {
                            childStatusFive.setOtherReferredCause(childFiveOtherReferredCauseText.trim());
                        } else {
                            childStatusFive.setOtherReferredCause(null);
                        }


                        //child five referred area
                        String childFiveReferredAreaString = customChildStatusLayoutFive.referredAreaChildET.getText().toString();
                        if (childFiveReferredAreaString != null && !(childFiveReferredAreaString.trim().equals(""))) {
                            try {
                                Integer id = childReferredFacilityTypeMap.get(childFiveReferredAreaString);
                                childStatusFive.setReferredTo(id);
                            } catch (NumberFormatException e) {
                                childStatusFive.setReferredTo(null);
                            }
                        } else {
                            childStatusFive.setReferredTo(null);
                        }

                        //child five referred other cause
                        String childFiveOtherReferredAreaString = customChildStatusLayoutFive.referredOtherAreaChildET.getText().toString();
                        if (childFiveOtherReferredAreaString != null && !(childFiveOtherReferredAreaString.trim().equals(""))) {
                            childStatusFive.setOtherReferredTo(childFiveOtherReferredAreaString.trim());
                        } else {
                            childStatusFive.setOtherReferredTo(null);
                        }

                        //child five referred transport
                        String childFiveReferredTransportString = customChildStatusLayoutFive.referredTransportChildET.getText().toString();
                        if (childFiveReferredTransportString != null && !(childFiveReferredTransportString.trim().equals(""))) {
                            try {
                                Integer id = transportTypeMap.get(childFiveReferredTransportString);
                                childStatusFive.setReferredTransport(id);
                            } catch (NumberFormatException e) {
                                childStatusFive.setReferredTransport(null);
                            }
                        } else {
                            childStatusFive.setReferredTransport(null);
                        }
                        break;
                    case CHILD_STATUS_LAMA_TYPE_DETAIL_ID:
                        //child five lama date and time
                        String childFiveLamaDateAndTimeString = customChildStatusLayoutFive.lamaDateTimeChildET.getText().toString();
                        if (childFiveLamaDateAndTimeString != null && !(childFiveLamaDateAndTimeString.trim().equals(""))) {
                            try {
                                Date lamaDate = simpleDateFormat.parse(childFiveLamaDateAndTimeString.trim());
                                childStatusFive.setLamaDateAndTime(lamaDate);
                            } catch (ParseException e) {
                                childStatusFive.setLamaDateAndTime(null);
                            }
                        } else {
                            childStatusFive.setLamaDateAndTime(null);
                        }
                        break;
                    case CHILD_STATUS_DEATH_TYPE_DETAIL_ID:
                        //child five death date and time
                        String childFiveDeathDateAndTimeString = customChildStatusLayoutFive.childDeathDateTimeET.getText().toString();
                        if (childFiveDeathDateAndTimeString != null & !childFiveDeathDateAndTimeString.equals("")) {
                            try {
                                Date date = simpleDateFormat.parse(childFiveDeathDateAndTimeString);
                                childStatusFive.setDeathDateAndTime(date);
                            } catch (ParseException e) {
                                childStatusFive.setDeathDateAndTime(null);
                            }
                        } else {
                            childStatusFive.setDeathDateAndTime(null);
                        }

                        //child five death cause
                        String childFiveDeathCauseText = customChildStatusLayoutFive.childDeathCauseET.getText().toString();
                        if (childFiveDeathCauseText != null && !(childFiveDeathCauseText.trim().equals(""))) {
                            childStatusFive.setDeathCause(childFiveDeathCauseText.trim());
                        } else {
                            childStatusFive.setDeathCause(null);
                        }
                        break;
                }
            }
            childStatusList.add(childStatusFive);
        }


        //if child six status is selected
        if (childStatusSixFlag) {
            ChildStatusModel childStatusSix = new ChildStatusModel();

            //child six status
            String childSixStatusString = customChildStatusLayoutSix.childStatusET.getText().toString();
            if (childSixStatusString != null && !(childSixStatusString.trim().equals(""))) {
                try {
                    Integer id = childStatusTypeMap.get(childSixStatusString);
                    childStatusSix.setStatus(id);
                } catch (NumberFormatException e) {
                    childStatusSix.setStatus(null);
                }
            } else {
                childStatusSix.setStatus(null);
            }

            if (childSixStatusString != null && !childSixStatusString.trim().equals("")) {
                switch (childStatusTypeMap.get(childSixStatusString)) {
                    case CHILD_STATUS_DISCHARGED_TYPE_DETAIL_ID:
                        //child six discharge date and time
                        String childSixDischargeDateAndTime = customChildStatusLayoutSix.dischargeDateTimeChildET.getText().toString();
                        if (childSixDischargeDateAndTime != null && !(childSixDischargeDateAndTime.trim().equals(""))) {
                            try {
                                Date date = simpleDateFormat.parse(childSixDischargeDateAndTime.trim());
                                childStatusSix.setDischargeDateAndTime(date);
                            } catch (ParseException e) {
                                childStatusSix.setDischargeDateAndTime(null);
                            }
                        } else {
                            childStatusSix.setDischargeDateAndTime(null);
                        }

                        //child six discharge weight
                        String childDischargeWeightText = customChildStatusLayoutSix.dischargeWeightChildET.getText().toString();
                        if (childDischargeWeightText != null && !(childDischargeWeightText.trim().equals(""))) {
                            childStatusSix.setDischargeWeight(Float.parseFloat(childDischargeWeightText.trim()));
                        } else {
                            childStatusSix.setDischargeWeight(null);
                        }

                        //child six transport to home
                        String childSixTransportToHomeString = customChildStatusLayoutSix.transportToHomeChildET.getText().toString();
                        if (childSixTransportToHomeString != null && !(childSixTransportToHomeString.trim().equals(""))) {
                            try {
                                Integer id = transportTypeMap.get(childSixTransportToHomeString);
                                childStatusSix.setTransportToHome(id);
                            } catch (NumberFormatException e) {
                                childStatusSix.setTransportToHome(null);
                            }
                        } else {
                            childStatusSix.setTransportToHome(null);
                        }
                        break;
                    case CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID:
                        //child six referred date and time
                        String childSixReferredDateAndTime = customChildStatusLayoutSix.referredDateTimeChildET.getText().toString();
                        if (childSixReferredDateAndTime != null && !(childSixReferredDateAndTime.trim().equals(""))) {
                            try {
                                Date date = simpleDateFormat.parse(childSixReferredDateAndTime.trim());
                                childStatusSix.setReferredDateAndTime(date);
                            } catch (ParseException e) {
                                childStatusSix.setReferredDateAndTime(null);
                            }
                        } else {
                            childStatusSix.setReferredDateAndTime(null);
                        }

                        //child six referred by
                        String childSixReferredByText = customChildStatusLayoutSix.referredByChildET.getText().toString();
                        if (childSixReferredByText != null && !(childSixReferredByText.trim().equals(""))) {
                            childStatusSix.setReferredBy(childSixReferredByText.trim());
                        } else {
                            childStatusSix.setReferredBy(null);
                        }

                        //child six referred cause
                        String childSixReferredCauseText = customChildStatusLayoutSix.referredCauseChildET.getText().toString();
                        if (childSixReferredCauseText != null && !(childSixReferredCauseText.trim().equals(""))) {
                            try {
                                Integer id = childReferredCauseTypeMap.get(childSixReferredCauseText);
                                childStatusSix.setReferredCause(id);
                            } catch (NumberFormatException e) {
                                childStatusSix.setReferredCause(null);
                            }
                        } else {
                            childStatusSix.setReferredCause(null);
                        }

                        //child six referred other cause
                        String childSixOtherReferredCauseText = customChildStatusLayoutSix.childReferredOtherCauseET.getText().toString();
                        if (childSixOtherReferredCauseText != null && !(childSixOtherReferredCauseText.trim().equals(""))) {
                            childStatusSix.setOtherReferredCause(childSixOtherReferredCauseText.trim());
                        } else {
                            childStatusSix.setOtherReferredCause(null);
                        }


                        //child six referred area
                        String childSixReferredAreaString = customChildStatusLayoutSix.referredAreaChildET.getText().toString();
                        if (childSixReferredAreaString != null && !(childSixReferredAreaString.trim().equals(""))) {
                            try {
                                Integer id = childReferredFacilityTypeMap.get(childSixReferredAreaString);
                                childStatusSix.setReferredTo(id);
                            } catch (NumberFormatException e) {
                                childStatusSix.setReferredTo(null);
                            }
                        } else {
                            childStatusSix.setReferredTo(null);
                        }

                        //child six referred other cause
                        String childSixOtherReferredAreaString = customChildStatusLayoutSix.referredOtherAreaChildET.getText().toString();
                        if (childSixOtherReferredAreaString != null && !(childSixOtherReferredAreaString.trim().equals(""))) {
                            childStatusSix.setOtherReferredTo(childSixOtherReferredAreaString.trim());
                        } else {
                            childStatusSix.setOtherReferredTo(null);
                        }

                        //child six referred transport
                        String childSixReferredTransportString = customChildStatusLayoutSix.referredTransportChildET.getText().toString();
                        if (childSixReferredTransportString != null && !(childSixReferredTransportString.trim().equals(""))) {
                            try {
                                Integer id = transportTypeMap.get(childSixReferredTransportString);
                                childStatusSix.setReferredTransport(id);
                            } catch (NumberFormatException e) {
                                childStatusSix.setReferredTransport(null);
                            }
                        } else {
                            childStatusSix.setReferredTransport(null);
                        }
                        break;
                    case CHILD_STATUS_LAMA_TYPE_DETAIL_ID:
                        //child six lama date and time
                        String childSixLamaDateAndTimeString = customChildStatusLayoutSix.lamaDateTimeChildET.getText().toString();
                        if (childSixLamaDateAndTimeString != null && !(childSixLamaDateAndTimeString.trim().equals(""))) {
                            try {
                                Date lamaDate = simpleDateFormat.parse(childSixLamaDateAndTimeString.trim());
                                childStatusSix.setLamaDateAndTime(lamaDate);
                            } catch (ParseException e) {
                                childStatusSix.setLamaDateAndTime(null);
                            }
                        } else {
                            childStatusSix.setLamaDateAndTime(null);
                        }
                        break;
                    case CHILD_STATUS_DEATH_TYPE_DETAIL_ID:
                        //child six death date and time
                        String childSixDeathDateAndTimeString = customChildStatusLayoutSix.childDeathDateTimeET.getText().toString();
                        if (childSixDeathDateAndTimeString != null & !childSixDeathDateAndTimeString.equals("")) {
                            try {
                                Date date = simpleDateFormat.parse(childSixDeathDateAndTimeString);
                                childStatusSix.setDeathDateAndTime(date);
                            } catch (ParseException e) {
                                childStatusSix.setDeathDateAndTime(null);
                            }
                        } else {
                            childStatusSix.setDeathDateAndTime(null);
                        }

                        //child six death cause
                        String childSixDeathCauseText = customChildStatusLayoutSix.childDeathCauseET.getText().toString();
                        if (childSixDeathCauseText != null && !(childSixDeathCauseText.trim().equals(""))) {
                            childStatusSix.setDeathCause(childSixDeathCauseText.trim());
                        } else {
                            childStatusSix.setDeathCause(null);
                        }
                        break;
                }
            }
            childStatusList.add(childStatusSix);
        }


        //if child seven status is selected
        if (childStatusSevenFlag) {
            ChildStatusModel childStatusSeven = new ChildStatusModel();

            //child seven status
            String childSevenStatusString = customChildStatusLayoutSeven.childStatusET.getText().toString();
            if (childSevenStatusString != null && !(childSevenStatusString.trim().equals(""))) {
                try {
                    Integer id = childStatusTypeMap.get(childSevenStatusString);
                    childStatusSeven.setStatus(id);
                } catch (NumberFormatException e) {
                    childStatusSeven.setStatus(null);
                }
            } else {
                childStatusSeven.setStatus(null);
            }

            if (childSevenStatusString != null && !childSevenStatusString.trim().equals("")) {
                switch (childStatusTypeMap.get(childSevenStatusString)) {
                    case CHILD_STATUS_DISCHARGED_TYPE_DETAIL_ID:
                        //child seven discharge date and time
                        String childSevenDischargeDateAndTime = customChildStatusLayoutSeven.dischargeDateTimeChildET.getText().toString();
                        if (childSevenDischargeDateAndTime != null && !(childSevenDischargeDateAndTime.trim().equals(""))) {
                            try {
                                Date date = simpleDateFormat.parse(childSevenDischargeDateAndTime.trim());
                                childStatusSeven.setDischargeDateAndTime(date);
                            } catch (ParseException e) {
                                childStatusSeven.setDischargeDateAndTime(null);
                            }
                        } else {
                            childStatusSeven.setDischargeDateAndTime(null);
                        }

                        //child seven discharge weight
                        String childDischargeWeightText = customChildStatusLayoutSeven.dischargeWeightChildET.getText().toString();
                        if (childDischargeWeightText != null && !(childDischargeWeightText.trim().equals(""))) {
                            childStatusSeven.setDischargeWeight(Float.parseFloat(childDischargeWeightText.trim()));
                        } else {
                            childStatusSeven.setDischargeWeight(null);
                        }

                        //child seven transport to home
                        String childSevenTransportToHomeString = customChildStatusLayoutSeven.transportToHomeChildET.getText().toString();
                        if (childSevenTransportToHomeString != null && !(childSevenTransportToHomeString.trim().equals(""))) {
                            try {
                                Integer id = transportTypeMap.get(childSevenTransportToHomeString);
                                childStatusSeven.setTransportToHome(id);
                            } catch (NumberFormatException e) {
                                childStatusSeven.setTransportToHome(null);
                            }
                        } else {
                            childStatusSeven.setTransportToHome(null);
                        }
                        break;
                    case CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID:
                        //child seven referred date and time
                        String childSevenReferredDateAndTime = customChildStatusLayoutSeven.referredDateTimeChildET.getText().toString();
                        if (childSevenReferredDateAndTime != null && !(childSevenReferredDateAndTime.trim().equals(""))) {
                            try {
                                Date date = simpleDateFormat.parse(childSevenReferredDateAndTime.trim());
                                childStatusSeven.setReferredDateAndTime(date);
                            } catch (ParseException e) {
                                childStatusSeven.setReferredDateAndTime(null);
                            }
                        } else {
                            childStatusSeven.setReferredDateAndTime(null);
                        }

                        //child seven referred by
                        String childSevenReferredByText = customChildStatusLayoutSeven.referredByChildET.getText().toString();
                        if (childSevenReferredByText != null && !(childSevenReferredByText.trim().equals(""))) {
                            childStatusSeven.setReferredBy(childSevenReferredByText.trim());
                        } else {
                            childStatusSeven.setReferredBy(null);
                        }

                        //child seven referred cause
                        String childSevenReferredCauseText = customChildStatusLayoutSeven.referredCauseChildET.getText().toString();
                        if (childSevenReferredCauseText != null && !(childSevenReferredCauseText.trim().equals(""))) {
                            try {
                                Integer id = childReferredCauseTypeMap.get(childSevenReferredCauseText);
                                childStatusSeven.setReferredCause(id);
                            } catch (NumberFormatException e) {
                                childStatusSeven.setReferredCause(null);
                            }
                        } else {
                            childStatusSeven.setReferredCause(null);
                        }

                        //child seven referred other cause
                        String childSevenOtherReferredCauseText = customChildStatusLayoutSeven.childReferredOtherCauseET.getText().toString();
                        if (childSevenOtherReferredCauseText != null && !(childSevenOtherReferredCauseText.trim().equals(""))) {
                            childStatusSeven.setOtherReferredCause(childSevenOtherReferredCauseText.trim());
                        } else {
                            childStatusSeven.setOtherReferredCause(null);
                        }


                        //child seven referred area
                        String childSevenReferredAreaString = customChildStatusLayoutSeven.referredAreaChildET.getText().toString();
                        if (childSevenReferredAreaString != null && !(childSevenReferredAreaString.trim().equals(""))) {
                            try {
                                Integer id = childReferredFacilityTypeMap.get(childSevenReferredAreaString);
                                childStatusSeven.setReferredTo(id);
                            } catch (NumberFormatException e) {
                                childStatusSeven.setReferredTo(null);
                            }
                        } else {
                            childStatusSeven.setReferredTo(null);
                        }

                        //child seven referred other cause
                        String childSevenOtherReferredAreaString = customChildStatusLayoutSeven.referredOtherAreaChildET.getText().toString();
                        if (childSevenOtherReferredAreaString != null && !(childSevenOtherReferredAreaString.trim().equals(""))) {
                            childStatusSeven.setOtherReferredTo(childSevenOtherReferredAreaString.trim());
                        } else {
                            childStatusSeven.setOtherReferredTo(null);
                        }

                        //child seven referred transport
                        String childSevenReferredTransportString = customChildStatusLayoutSeven.referredTransportChildET.getText().toString();
                        if (childSevenReferredTransportString != null && !(childSevenReferredTransportString.trim().equals(""))) {
                            try {
                                Integer id = transportTypeMap.get(childSevenReferredTransportString);
                                childStatusSeven.setReferredTransport(id);
                            } catch (NumberFormatException e) {
                                childStatusSeven.setReferredTransport(null);
                            }
                        } else {
                            childStatusSeven.setReferredTransport(null);
                        }
                        break;
                    case CHILD_STATUS_LAMA_TYPE_DETAIL_ID:
                        //child seven lama date and time
                        String childSevenLamaDateAndTimeString = customChildStatusLayoutSeven.lamaDateTimeChildET.getText().toString();
                        if (childSevenLamaDateAndTimeString != null && !(childSevenLamaDateAndTimeString.trim().equals(""))) {
                            try {
                                Date lamaDate = simpleDateFormat.parse(childSevenLamaDateAndTimeString.trim());
                                childStatusSeven.setLamaDateAndTime(lamaDate);
                            } catch (ParseException e) {
                                childStatusSeven.setLamaDateAndTime(null);
                            }
                        } else {
                            childStatusSeven.setLamaDateAndTime(null);
                        }
                        break;
                    case CHILD_STATUS_DEATH_TYPE_DETAIL_ID:
                        //child seven death date and time
                        String childSevenDeathDateAndTimeString = customChildStatusLayoutSeven.childDeathDateTimeET.getText().toString();
                        if (childSevenDeathDateAndTimeString != null & !childSevenDeathDateAndTimeString.equals("")) {
                            try {
                                Date date = simpleDateFormat.parse(childSevenDeathDateAndTimeString);
                                childStatusSeven.setDeathDateAndTime(date);
                            } catch (ParseException e) {
                                childStatusSeven.setDeathDateAndTime(null);
                            }
                        } else {
                            childStatusSeven.setDeathDateAndTime(null);
                        }

                        //child seven death cause
                        String childSevenDeathCauseText = customChildStatusLayoutSeven.childDeathCauseET.getText().toString();
                        if (childSevenDeathCauseText != null && !(childSevenDeathCauseText.trim().equals(""))) {
                            childStatusSeven.setDeathCause(childSevenDeathCauseText.trim());
                        } else {
                            childStatusSeven.setDeathCause(null);
                        }
                        break;
                }
            }
            childStatusList.add(childStatusSeven);
        }

        //if child eight status is selected
        if (childStatusEightFlag) {
            ChildStatusModel childStatusEight = new ChildStatusModel();

            //child eight status
            String childEightStatusString = customChildStatusLayoutEight.childStatusET.getText().toString();
            if (childEightStatusString != null && !(childEightStatusString.trim().equals(""))) {
                try {
                    Integer id = childStatusTypeMap.get(childEightStatusString);
                    childStatusEight.setStatus(id);
                } catch (NumberFormatException e) {
                    childStatusEight.setStatus(null);
                }
            } else {
                childStatusEight.setStatus(null);
            }

            if (childEightStatusString != null && !childEightStatusString.trim().equals("")) {
                switch (childStatusTypeMap.get(childEightStatusString)) {
                    case CHILD_STATUS_DISCHARGED_TYPE_DETAIL_ID:
                        //child eight discharge date and time
                        String childEightDischargeDateAndTime = customChildStatusLayoutEight.dischargeDateTimeChildET.getText().toString();
                        if (childEightDischargeDateAndTime != null && !(childEightDischargeDateAndTime.trim().equals(""))) {
                            try {
                                Date date = simpleDateFormat.parse(childEightDischargeDateAndTime.trim());
                                childStatusEight.setDischargeDateAndTime(date);
                            } catch (ParseException e) {
                                childStatusEight.setDischargeDateAndTime(null);
                            }
                        } else {
                            childStatusEight.setDischargeDateAndTime(null);
                        }

                        //child eight discharge weight
                        String childDischargeWeightText = customChildStatusLayoutEight.dischargeWeightChildET.getText().toString();
                        if (childDischargeWeightText != null && !(childDischargeWeightText.trim().equals(""))) {
                            childStatusEight.setDischargeWeight(Float.parseFloat(childDischargeWeightText.trim()));
                        } else {
                            childStatusEight.setDischargeWeight(null);
                        }

                        //child eight transport to home
                        String childEightTransportToHomeString = customChildStatusLayoutEight.transportToHomeChildET.getText().toString();
                        if (childEightTransportToHomeString != null && !(childEightTransportToHomeString.trim().equals(""))) {
                            try {
                                Integer id = transportTypeMap.get(childEightTransportToHomeString);
                                childStatusEight.setTransportToHome(id);
                            } catch (NumberFormatException e) {
                                childStatusEight.setTransportToHome(null);
                            }
                        } else {
                            childStatusEight.setTransportToHome(null);
                        }
                        break;
                    case CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID:
                        //child eight referred date and time
                        String childEightReferredDateAndTime = customChildStatusLayoutEight.referredDateTimeChildET.getText().toString();
                        if (childEightReferredDateAndTime != null && !(childEightReferredDateAndTime.trim().equals(""))) {
                            try {
                                Date date = simpleDateFormat.parse(childEightReferredDateAndTime.trim());
                                childStatusEight.setReferredDateAndTime(date);
                            } catch (ParseException e) {
                                childStatusEight.setReferredDateAndTime(null);
                            }
                        } else {
                            childStatusEight.setReferredDateAndTime(null);
                        }

                        //child eight referred by
                        String childEightReferredByText = customChildStatusLayoutEight.referredByChildET.getText().toString();
                        if (childEightReferredByText != null && !(childEightReferredByText.trim().equals(""))) {
                            childStatusEight.setReferredBy(childEightReferredByText.trim());
                        } else {
                            childStatusEight.setReferredBy(null);
                        }

                        //child eight referred cause
                        String childEightReferredCauseText = customChildStatusLayoutEight.referredCauseChildET.getText().toString();
                        if (childEightReferredCauseText != null && !(childEightReferredCauseText.trim().equals(""))) {
                            try {
                                Integer id = childReferredCauseTypeMap.get(childEightReferredCauseText);
                                childStatusEight.setReferredCause(id);
                            } catch (NumberFormatException e) {
                                childStatusEight.setReferredCause(null);
                            }
                        } else {
                            childStatusEight.setReferredCause(null);
                        }

                        //child eight referred other cause
                        String childEightOtherReferredCauseText = customChildStatusLayoutEight.childReferredOtherCauseET.getText().toString();
                        if (childEightOtherReferredCauseText != null && !(childEightOtherReferredCauseText.trim().equals(""))) {
                            childStatusEight.setOtherReferredCause(childEightOtherReferredCauseText.trim());
                        } else {
                            childStatusEight.setOtherReferredCause(null);
                        }


                        //child eight referred area
                        String childEightReferredAreaString = customChildStatusLayoutEight.referredAreaChildET.getText().toString();
                        if (childEightReferredAreaString != null && !(childEightReferredAreaString.trim().equals(""))) {
                            try {
                                Integer id = childReferredFacilityTypeMap.get(childEightReferredAreaString);
                                childStatusEight.setReferredTo(id);
                            } catch (NumberFormatException e) {
                                childStatusEight.setReferredTo(null);
                            }
                        } else {
                            childStatusEight.setReferredTo(null);
                        }

                        //child eight referred other cause
                        String childEightOtherReferredAreaString = customChildStatusLayoutEight.referredOtherAreaChildET.getText().toString();
                        if (childEightOtherReferredAreaString != null && !(childEightOtherReferredAreaString.trim().equals(""))) {
                            childStatusEight.setOtherReferredTo(childEightOtherReferredAreaString.trim());
                        } else {
                            childStatusEight.setOtherReferredTo(null);
                        }

                        //child eight referred transport
                        String childEightReferredTransportString = customChildStatusLayoutEight.referredTransportChildET.getText().toString();
                        if (childEightReferredTransportString != null && !(childEightReferredTransportString.trim().equals(""))) {
                            try {
                                Integer id = transportTypeMap.get(childEightReferredTransportString);
                                childStatusEight.setReferredTransport(id);
                            } catch (NumberFormatException e) {
                                childStatusEight.setReferredTransport(null);
                            }
                        } else {
                            childStatusEight.setReferredTransport(null);
                        }
                        break;
                    case CHILD_STATUS_LAMA_TYPE_DETAIL_ID:
                        //child eight lama date and time
                        String childEightLamaDateAndTimeString = customChildStatusLayoutEight.lamaDateTimeChildET.getText().toString();
                        if (childEightLamaDateAndTimeString != null && !(childEightLamaDateAndTimeString.trim().equals(""))) {
                            try {
                                Date lamaDate = simpleDateFormat.parse(childEightLamaDateAndTimeString.trim());
                                childStatusEight.setLamaDateAndTime(lamaDate);
                            } catch (ParseException e) {
                                childStatusEight.setLamaDateAndTime(null);
                            }
                        } else {
                            childStatusEight.setLamaDateAndTime(null);
                        }
                        break;
                    case CHILD_STATUS_DEATH_TYPE_DETAIL_ID:
                        //child eight death date and time
                        String childEightDeathDateAndTimeString = customChildStatusLayoutEight.childDeathDateTimeET.getText().toString();
                        if (childEightDeathDateAndTimeString != null & !childEightDeathDateAndTimeString.equals("")) {
                            try {
                                Date date = simpleDateFormat.parse(childEightDeathDateAndTimeString);
                                childStatusEight.setDeathDateAndTime(date);
                            } catch (ParseException e) {
                                childStatusEight.setDeathDateAndTime(null);
                            }
                        } else {
                            childStatusEight.setDeathDateAndTime(null);
                        }

                        //child eight death cause
                        String childEightDeathCauseText = customChildStatusLayoutEight.childDeathCauseET.getText().toString();
                        if (childEightDeathCauseText != null && !(childEightDeathCauseText.trim().equals(""))) {
                            childStatusEight.setDeathCause(childEightDeathCauseText.trim());
                        } else {
                            childStatusEight.setDeathCause(null);
                        }
                        break;
                }
            }
            childStatusList.add(childStatusEight);
        }


        //if child nine status is selected
        if (childStatusNineFlag) {
            ChildStatusModel childStatusNine = new ChildStatusModel();

            //child nine status
            String childNineStatusString = customChildStatusLayoutNine.childStatusET.getText().toString();
            if (childNineStatusString != null && !(childNineStatusString.trim().equals(""))) {
                try {
                    Integer id = childStatusTypeMap.get(childNineStatusString);
                    childStatusNine.setStatus(id);
                } catch (NumberFormatException e) {
                    childStatusNine.setStatus(null);
                }
            } else {
                childStatusNine.setStatus(null);
            }

            if (childNineStatusString != null && !childNineStatusString.trim().equals("")) {
                switch (childStatusTypeMap.get(childNineStatusString)) {
                    case CHILD_STATUS_DISCHARGED_TYPE_DETAIL_ID:
                        //child nine discharge date and time
                        String childNineDischargeDateAndTime = customChildStatusLayoutNine.dischargeDateTimeChildET.getText().toString();
                        if (childNineDischargeDateAndTime != null && !(childNineDischargeDateAndTime.trim().equals(""))) {
                            try {
                                Date date = simpleDateFormat.parse(childNineDischargeDateAndTime.trim());
                                childStatusNine.setDischargeDateAndTime(date);
                            } catch (ParseException e) {
                                childStatusNine.setDischargeDateAndTime(null);
                            }
                        } else {
                            childStatusNine.setDischargeDateAndTime(null);
                        }

                        //child nine discharge weight
                        String childDischargeWeightText = customChildStatusLayoutNine.dischargeWeightChildET.getText().toString();
                        if (childDischargeWeightText != null && !(childDischargeWeightText.trim().equals(""))) {
                            childStatusNine.setDischargeWeight(Float.parseFloat(childDischargeWeightText.trim()));
                        } else {
                            childStatusNine.setDischargeWeight(null);
                        }

                        //child nine transport to home
                        String childNineTransportToHomeString = customChildStatusLayoutNine.transportToHomeChildET.getText().toString();
                        if (childNineTransportToHomeString != null && !(childNineTransportToHomeString.trim().equals(""))) {
                            try {
                                Integer id = transportTypeMap.get(childNineTransportToHomeString);
                                childStatusNine.setTransportToHome(id);
                            } catch (NumberFormatException e) {
                                childStatusNine.setTransportToHome(null);
                            }
                        } else {
                            childStatusNine.setTransportToHome(null);
                        }
                        break;
                    case CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID:
                        //child nine referred date and time
                        String childNineReferredDateAndTime = customChildStatusLayoutNine.referredDateTimeChildET.getText().toString();
                        if (childNineReferredDateAndTime != null && !(childNineReferredDateAndTime.trim().equals(""))) {
                            try {
                                Date date = simpleDateFormat.parse(childNineReferredDateAndTime.trim());
                                childStatusNine.setReferredDateAndTime(date);
                            } catch (ParseException e) {
                                childStatusNine.setReferredDateAndTime(null);
                            }
                        } else {
                            childStatusNine.setReferredDateAndTime(null);
                        }

                        //child nine referred by
                        String childNineReferredByText = customChildStatusLayoutNine.referredByChildET.getText().toString();
                        if (childNineReferredByText != null && !(childNineReferredByText.trim().equals(""))) {
                            childStatusNine.setReferredBy(childNineReferredByText.trim());
                        } else {
                            childStatusNine.setReferredBy(null);
                        }

                        //child nine referred cause
                        String childNineReferredCauseText = customChildStatusLayoutNine.referredCauseChildET.getText().toString();
                        if (childNineReferredCauseText != null && !(childNineReferredCauseText.trim().equals(""))) {
                            try {
                                Integer id = childReferredCauseTypeMap.get(childNineReferredCauseText);
                                childStatusNine.setReferredCause(id);
                            } catch (NumberFormatException e) {
                                childStatusNine.setReferredCause(null);
                            }
                        } else {
                            childStatusNine.setReferredCause(null);
                        }

                        //child nine referred other cause
                        String childNineOtherReferredCauseText = customChildStatusLayoutNine.childReferredOtherCauseET.getText().toString();
                        if (childNineOtherReferredCauseText != null && !(childNineOtherReferredCauseText.trim().equals(""))) {
                            childStatusNine.setOtherReferredCause(childNineOtherReferredCauseText.trim());
                        } else {
                            childStatusNine.setOtherReferredCause(null);
                        }


                        //child nine referred area
                        String childNineReferredAreaString = customChildStatusLayoutNine.referredAreaChildET.getText().toString();
                        if (childNineReferredAreaString != null && !(childNineReferredAreaString.trim().equals(""))) {
                            try {
                                Integer id = childReferredFacilityTypeMap.get(childNineReferredAreaString);
                                childStatusNine.setReferredTo(id);
                            } catch (NumberFormatException e) {
                                childStatusNine.setReferredTo(null);
                            }
                        } else {
                            childStatusNine.setReferredTo(null);
                        }

                        //child nine referred other cause
                        String childNineOtherReferredAreaString = customChildStatusLayoutNine.referredOtherAreaChildET.getText().toString();
                        if (childNineOtherReferredAreaString != null && !(childNineOtherReferredAreaString.trim().equals(""))) {
                            childStatusNine.setOtherReferredTo(childNineOtherReferredAreaString.trim());
                        } else {
                            childStatusNine.setOtherReferredTo(null);
                        }

                        //child nine referred transport
                        String childNineReferredTransportString = customChildStatusLayoutNine.referredTransportChildET.getText().toString();
                        if (childNineReferredTransportString != null && !(childNineReferredTransportString.trim().equals(""))) {
                            try {
                                Integer id = transportTypeMap.get(childNineReferredTransportString);
                                childStatusNine.setReferredTransport(id);
                            } catch (NumberFormatException e) {
                                childStatusNine.setReferredTransport(null);
                            }
                        } else {
                            childStatusNine.setReferredTransport(null);
                        }
                        break;
                    case CHILD_STATUS_LAMA_TYPE_DETAIL_ID:
                        //child nine lama date and time
                        String childNineLamaDateAndTimeString = customChildStatusLayoutNine.lamaDateTimeChildET.getText().toString();
                        if (childNineLamaDateAndTimeString != null && !(childNineLamaDateAndTimeString.trim().equals(""))) {
                            try {
                                Date lamaDate = simpleDateFormat.parse(childNineLamaDateAndTimeString.trim());
                                childStatusNine.setLamaDateAndTime(lamaDate);
                            } catch (ParseException e) {
                                childStatusNine.setLamaDateAndTime(null);
                            }
                        } else {
                            childStatusNine.setLamaDateAndTime(null);
                        }
                        break;
                    case CHILD_STATUS_DEATH_TYPE_DETAIL_ID:
                        //child nine death date and time
                        String childNineDeathDateAndTimeString = customChildStatusLayoutNine.childDeathDateTimeET.getText().toString();
                        if (childNineDeathDateAndTimeString != null & !childNineDeathDateAndTimeString.equals("")) {
                            try {
                                Date date = simpleDateFormat.parse(childNineDeathDateAndTimeString);
                                childStatusNine.setDeathDateAndTime(date);
                            } catch (ParseException e) {
                                childStatusNine.setDeathDateAndTime(null);
                            }
                        } else {
                            childStatusNine.setDeathDateAndTime(null);
                        }

                        //child nine death cause
                        String childNineDeathCauseText = customChildStatusLayoutNine.childDeathCauseET.getText().toString();
                        if (childNineDeathCauseText != null && !(childNineDeathCauseText.trim().equals(""))) {
                            childStatusNine.setDeathCause(childNineDeathCauseText.trim());
                        } else {
                            childStatusNine.setDeathCause(null);
                        }
                        break;
                }
            }
            childStatusList.add(childStatusNine);
        }

        //if child ten status is selected
        if (childStatusTenFlag) {
            ChildStatusModel childStatusTen = new ChildStatusModel();

            //child ten status
            String childTenStatusString = customChildStatusLayoutTen.childStatusET.getText().toString();
            if (childTenStatusString != null && !(childTenStatusString.trim().equals(""))) {
                try {
                    Integer id = childStatusTypeMap.get(childTenStatusString);
                    childStatusTen.setStatus(id);
                } catch (NumberFormatException e) {
                    childStatusTen.setStatus(null);
                }
            } else {
                childStatusTen.setStatus(null);
            }

            if (childTenStatusString != null && !childTenStatusString.trim().equals("")) {
                switch (childStatusTypeMap.get(childTenStatusString)) {
                    case CHILD_STATUS_DISCHARGED_TYPE_DETAIL_ID:
                        //child ten discharge date and time
                        String childTenDischargeDateAndTime = customChildStatusLayoutTen.dischargeDateTimeChildET.getText().toString();
                        if (childTenDischargeDateAndTime != null && !(childTenDischargeDateAndTime.trim().equals(""))) {
                            try {
                                Date date = simpleDateFormat.parse(childTenDischargeDateAndTime.trim());
                                childStatusTen.setDischargeDateAndTime(date);
                            } catch (ParseException e) {
                                childStatusTen.setDischargeDateAndTime(null);
                            }
                        } else {
                            childStatusTen.setDischargeDateAndTime(null);
                        }

                        //child ten discharge weight
                        String childDischargeWeightText = customChildStatusLayoutTen.dischargeWeightChildET.getText().toString();
                        if (childDischargeWeightText != null && !(childDischargeWeightText.trim().equals(""))) {
                            childStatusTen.setDischargeWeight(Float.parseFloat(childDischargeWeightText.trim()));
                        } else {
                            childStatusTen.setDischargeWeight(null);
                        }

                        //child ten transport to home
                        String childTenTransportToHomeString = customChildStatusLayoutTen.transportToHomeChildET.getText().toString();
                        if (childTenTransportToHomeString != null && !(childTenTransportToHomeString.trim().equals(""))) {
                            try {
                                Integer id = transportTypeMap.get(childTenTransportToHomeString);
                                childStatusTen.setTransportToHome(id);
                            } catch (NumberFormatException e) {
                                childStatusTen.setTransportToHome(null);
                            }
                        } else {
                            childStatusTen.setTransportToHome(null);
                        }
                        break;
                    case CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID:
                        //child ten referred date and time
                        String childTenReferredDateAndTime = customChildStatusLayoutTen.referredDateTimeChildET.getText().toString();
                        if (childTenReferredDateAndTime != null && !(childTenReferredDateAndTime.trim().equals(""))) {
                            try {
                                Date date = simpleDateFormat.parse(childTenReferredDateAndTime.trim());
                                childStatusTen.setReferredDateAndTime(date);
                            } catch (ParseException e) {
                                childStatusTen.setReferredDateAndTime(null);
                            }
                        } else {
                            childStatusTen.setReferredDateAndTime(null);
                        }

                        //child ten referred by
                        String childTenReferredByText = customChildStatusLayoutTen.referredByChildET.getText().toString();
                        if (childTenReferredByText != null && !(childTenReferredByText.trim().equals(""))) {
                            childStatusTen.setReferredBy(childTenReferredByText.trim());
                        } else {
                            childStatusTen.setReferredBy(null);
                        }

                        //child ten referred cause
                        String childTenReferredCauseText = customChildStatusLayoutTen.referredCauseChildET.getText().toString();
                        if (childTenReferredCauseText != null && !(childTenReferredCauseText.trim().equals(""))) {
                            try {
                                Integer id = childReferredCauseTypeMap.get(childTenReferredCauseText);
                                childStatusTen.setReferredCause(id);
                            } catch (NumberFormatException e) {
                                childStatusTen.setReferredCause(null);
                            }
                        } else {
                            childStatusTen.setReferredCause(null);
                        }

                        //child ten referred other cause
                        String childTenOtherReferredCauseText = customChildStatusLayoutTen.childReferredOtherCauseET.getText().toString();
                        if (childTenOtherReferredCauseText != null && !(childTenOtherReferredCauseText.trim().equals(""))) {
                            childStatusTen.setOtherReferredCause(childTenOtherReferredCauseText.trim());
                        } else {
                            childStatusTen.setOtherReferredCause(null);
                        }


                        //child ten referred area
                        String childTenReferredAreaString = customChildStatusLayoutTen.referredAreaChildET.getText().toString();
                        if (childTenReferredAreaString != null && !(childTenReferredAreaString.trim().equals(""))) {
                            try {
                                Integer id = childReferredFacilityTypeMap.get(childTenReferredAreaString);
                                childStatusTen.setReferredTo(id);
                            } catch (NumberFormatException e) {
                                childStatusTen.setReferredTo(null);
                            }
                        } else {
                            childStatusTen.setReferredTo(null);
                        }

                        //child ten referred other cause
                        String childTenOtherReferredAreaString = customChildStatusLayoutTen.referredOtherAreaChildET.getText().toString();
                        if (childTenOtherReferredAreaString != null && !(childTenOtherReferredAreaString.trim().equals(""))) {
                            childStatusTen.setOtherReferredTo(childTenOtherReferredAreaString.trim());
                        } else {
                            childStatusTen.setOtherReferredTo(null);
                        }

                        //child ten referred transport
                        String childTenReferredTransportString = customChildStatusLayoutTen.referredTransportChildET.getText().toString();
                        if (childTenReferredTransportString != null && !(childTenReferredTransportString.trim().equals(""))) {
                            try {
                                Integer id = transportTypeMap.get(childTenReferredTransportString);
                                childStatusTen.setReferredTransport(id);
                            } catch (NumberFormatException e) {
                                childStatusTen.setReferredTransport(null);
                            }
                        } else {
                            childStatusTen.setReferredTransport(null);
                        }
                        break;
                    case CHILD_STATUS_LAMA_TYPE_DETAIL_ID:
                        //child ten lama date and time
                        String childTenLamaDateAndTimeString = customChildStatusLayoutTen.lamaDateTimeChildET.getText().toString();
                        if (childTenLamaDateAndTimeString != null && !(childTenLamaDateAndTimeString.trim().equals(""))) {
                            try {
                                Date lamaDate = simpleDateFormat.parse(childTenLamaDateAndTimeString.trim());
                                childStatusTen.setLamaDateAndTime(lamaDate);
                            } catch (ParseException e) {
                                childStatusTen.setLamaDateAndTime(null);
                            }
                        } else {
                            childStatusTen.setLamaDateAndTime(null);
                        }
                        break;
                    case CHILD_STATUS_DEATH_TYPE_DETAIL_ID:
                        //child ten death date and time
                        String childTenDeathDateAndTimeString = customChildStatusLayoutTen.childDeathDateTimeET.getText().toString();
                        if (childTenDeathDateAndTimeString != null & !childTenDeathDateAndTimeString.equals("")) {
                            try {
                                Date date = simpleDateFormat.parse(childTenDeathDateAndTimeString);
                                childStatusTen.setDeathDateAndTime(date);
                            } catch (ParseException e) {
                                childStatusTen.setDeathDateAndTime(null);
                            }
                        } else {
                            childStatusTen.setDeathDateAndTime(null);
                        }

                        //child ten death cause
                        String childTenDeathCauseText = customChildStatusLayoutTen.childDeathCauseET.getText().toString();
                        if (childTenDeathCauseText != null && !(childTenDeathCauseText.trim().equals(""))) {
                            childStatusTen.setDeathCause(childTenDeathCauseText.trim());
                        } else {
                            childStatusTen.setDeathCause(null);
                        }
                        break;
                }
            }
            childStatusList.add(childStatusTen);
        }

        patientModel.setChildrenStatus(childStatusList);
    }

    public void setModelWithMotherStatus() {
//motherStatus
        String motherStatusString = statusOfMother.getText().toString();
        if (motherStatusString != null && !(motherStatusString.trim().equals(""))) {
            try {
                Integer id = motherStatusTypeMap.get(motherStatusString);
                patientModel.setMotherStatus(id);
            } catch (NumberFormatException e) {
                patientModel.setMotherStatus(null);
            }
        } else {
            patientModel.setMotherStatus(null);
        }

        //dischargeDateAndTime
        String dischargeDateAndTime = dischargeDateTimeOfMother.getText().toString();
        if (dischargeDateAndTime != null && !(dischargeDateAndTime.trim().equals(""))) {
            try {
                Date dishchargeDate = simpleDateFormat.parse(dischargeDateAndTime.trim());
                patientModel.setDischargeDateAndTime(dishchargeDate);
            } catch (ParseException e) {
                patientModel.setDischargeDateAndTime(null);
            }
        } else {
            patientModel.setDischargeDateAndTime(null);
        }


        //transport to home
        String transportToHomeString = dischargeTransportOfMother.getText().toString();
        if (transportToHomeString != null && !(transportToHomeString.trim().equals(""))) {
            try {
                Integer id = transportTypeMap.get(transportToHomeString);
                patientModel.setTransportToHome(id);
            } catch (NumberFormatException e) {
                patientModel.setTransportToHome(null);
            }
        } else {
            patientModel.setTransportToHome(null);
        }

        //referredDateAndTime
        String referredDateAndTime = referredDateTimeOfMother.getText().toString();
        if (referredDateAndTime != null && !(referredDateAndTime.trim().equals(""))) {
            try {
                Date date = simpleDateFormat.parse(referredDateAndTime.trim());
                patientModel.setReferredDateAndTime(date);
            } catch (ParseException e) {
                patientModel.setReferredDateAndTime(null);
            }
        } else {
            patientModel.setReferredDateAndTime(null);
        }


        String referredByText = referredByOfMother.getText().toString();
        if (referredByText != null && !(referredByText.trim().equals(""))) {
            patientModel.setReferredBy(referredByText.trim());
        } else {
            patientModel.setReferredBy(null);
        }

        String referredCauseText = referredCauseOfMother.getText().toString();
        if (referredCauseText != null && !(referredCauseText.trim().equals(""))) {
            try {
                Integer id = motherReferredCauseTypeMap.get(referredCauseText);
                patientModel.setReferredCause(id);
            } catch (NumberFormatException e) {
                patientModel.setReferredCause(null);
            }
        } else {
            patientModel.setReferredCause(null);
        }

        //other Referred cause mother
        String otherReferredCauseMotherString = otherReferredCauseMother.getText().toString();
        if (otherReferredCauseMotherString != null && !(otherReferredCauseMotherString.trim().equals(""))) {
            patientModel.setOtherReferredCause(otherReferredCauseMotherString.trim());
        } else {
            patientModel.setOtherReferredCause(null);
        }

        //referred facility mother
        String referredFacilityMotherString = referredAreaOfMother.getText().toString();
        if (referredFacilityMotherString != null && !(referredFacilityMotherString.trim().equals(""))) {
            try {
                Integer id = referredFacilityMap.get(referredFacilityMotherString);
                patientModel.setReferredAreaId(id);
            } catch (NumberFormatException e) {
                patientModel.setReferredAreaId(null);
            }
        } else {
            patientModel.setReferredAreaId(null);
        }

        //other Referred facility mother
        String otherReferredFacilityMotherString = otherReferredFacilityMother.getText().toString();
        if (otherReferredFacilityMotherString != null && !(otherReferredFacilityMotherString.trim().equals(""))) {
            patientModel.setOtherReferredAreaId(otherReferredFacilityMotherString.trim());
        } else {
            patientModel.setOtherReferredAreaId(null);
        }

        //referred transport
        String referredTransportString = referredTransportOfMother.getText().toString();
        if (referredTransportString != null && !(referredTransportString.trim().equals(""))) {
            try {
                Integer id = transportTypeMap.get(referredTransportString);
                patientModel.setReferredTransport(id);
            } catch (NumberFormatException e) {
                patientModel.setReferredTransport(null);
            }
        } else {
            patientModel.setReferredTransport(null);
        }


        //lamaDateAndTime
        String lamaDateAndTimeString = lamaDateTimeOfMother.getText().toString();
        if (lamaDateAndTimeString != null && !(lamaDateAndTimeString.trim().equals(""))) {
            try {
                Date lamaDate = simpleDateFormat.parse(lamaDateAndTimeString.trim());
                patientModel.setLamaDateAndTime(lamaDate);
            } catch (ParseException e) {
                patientModel.setLamaDateAndTime(null);
            }
        } else {
            patientModel.setLamaDateAndTime(null);
        }

        //patientDeathDateAndTime
        String patientDeathDateAndTimeString = deathDateTimeOfMother.getText().toString();
        if (patientDeathDateAndTimeString != null & !patientDeathDateAndTimeString.equals("")) {
            try {
                Date date = simpleDateFormat.parse(patientDeathDateAndTimeString);
                patientModel.setPatientDeathDateAndTime(date);
            } catch (ParseException e) {
                patientModel.setPatientDeathDateAndTime(null);
            }
        } else {
            patientModel.setPatientDeathDateAndTime(null);
        }

        //Patient death cause
        String deathCause = deathCauseOfMother.getText().toString();
        if (deathCause != null && !(deathCause.trim().equals(""))) {
            try {
                Integer id = motherDeathCauseTypeMap.get(deathCause.trim());
                patientModel.setPatientDeathCause(id);
            } catch (NumberFormatException e) {
                patientModel.setPatientDeathCause(null);
            }
        } else {
            patientModel.setPatientDeathCause(null);
        }

        //other Death cause mother
        String otherDeathCauseMotherString = otherDeathCauseMother.getText().toString();
        if (otherDeathCauseMotherString != null && !(otherDeathCauseMotherString.trim().equals(""))) {
            patientModel.setOtherPatientDeathCause(otherDeathCauseMotherString.trim());
        } else {
            patientModel.setOtherPatientDeathCause(null);
        }
    }

    // Showing the Dialog
    public void showDeleteLayoutDialog(final String message, final String childType) {

        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(PatientActivity.this);
        alertDialogBuilder
                .setTitle(message);
        alertDialogBuilder
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        if (childType.equals("Child Info")) {
                            switch (childCount) {
                                case 1:
                                    childOneFlag = false;
                                    deleteChildInfo(customChildInfoLayoutOne);
                                    break;
                                case 2:
                                    childTwoFlag = false;
                                    deleteChildInfo(customChildInfoLayoutTwo);
                                    break;
                                case 3:
                                    childThreeFlag = false;
                                    deleteChildInfo(customChildInfoLayoutThree);
                                    break;
                                case 4:
                                    childFourFlag = false;
                                    deleteChildInfo(customChildInfoLayoutFour);
                                    break;
                                case 5:
                                    childFiveFlag = false;
                                    deleteChildInfo(customChildInfoLayoutFive);
                                    break;
                                case 6:
                                    childSixFlag = false;
                                    deleteChildInfo(customChildInfoLayoutSix);
                                    break;
                                case 7:
                                    childSevenFlag = false;
                                    deleteChildInfo(customChildInfoLayoutSeven);
                                    break;
                                case 8:
                                    childEightFlag = false;
                                    deleteChildInfo(customChildInfoLayoutEight);
                                    break;
                                case 9:
                                    childNineFlag = false;
                                    deleteChildInfo(customChildInfoLayoutNine);
                                    break;
                                case 10:
                                    childTenFlag = false;
                                    deleteChildInfo(customChildInfoLayoutTen);
                                    break;
                            }
                        } else if (childType.equals("Child Status")) {
                            switch (childStatusCount) {
                                case 1:
                                    childStatusOneFlag = false;
                                    deleteChildStatus(customChildStatusLayoutOne);
                                    break;
                                case 2:
                                    childStatusTwoFlag = false;
                                    deleteChildStatus(customChildStatusLayoutTwo);
                                    break;
                                case 3:
                                    childStatusThreeFlag = false;
                                    deleteChildStatus(customChildStatusLayoutThree);
                                    break;
                                case 4:
                                    childStatusFourFlag = false;
                                    deleteChildStatus(customChildStatusLayoutFour);
                                    break;
                                case 5:
                                    childStatusFiveFlag = false;
                                    deleteChildStatus(customChildStatusLayoutFive);
                                    break;
                                case 6:
                                    childStatusSixFlag = false;
                                    deleteChildStatus(customChildStatusLayoutSix);
                                    break;
                                case 7:
                                    childStatusSevenFlag = false;
                                    deleteChildStatus(customChildStatusLayoutSeven);
                                    break;
                                case 8:
                                    childStatusEightFlag = false;
                                    deleteChildStatus(customChildStatusLayoutEight);
                                    break;
                                case 9:
                                    childStatusNineFlag = false;
                                    deleteChildStatus(customChildStatusLayoutNine);
                                    break;
                                case 10:
                                    childStatusTenFlag = false;
                                    deleteChildStatus(customChildStatusLayoutTen);
                                    break;
                            }
                        }
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        alertDialogBuilder.setCancelable(true);
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    public void deleteChildInfo(CustomChildInfoLayout customChildInfoLayout) {
        customChildInfoLayout.setVisibility(View.GONE);
        customChildInfoLayout = new CustomChildInfoLayout(getApplicationContext());
        if (childCount < 2) {
            addChildOne.setVisibility(View.VISIBLE);
            anotherChildLayout.setVisibility(View.GONE);
        }
        childCount--;
    }

    public void deleteChildStatus(CustomChildStatusLayout customChildStatusLayout) {
        customChildStatusLayout.setVisibility(View.GONE);
        customChildStatusLayout = new CustomChildStatusLayout(getApplicationContext());
        if (childStatusCount < 2) {
            addChildStatusOne.setVisibility(View.VISIBLE);
            anotherChildStatusLayout.setVisibility(View.GONE);
        }
        childStatusCount--;
    }

    public void setDataToFields() {
        if (patientModel != null) {
            if (patientModel.getSerialNo() != null) {
                serialNo.setText(patientModel.getSerialNo().toString());
            }
            if (patientModel.getAdmissionDateAndTime() != null) {
                setAddmisionDateAndTime.setText(simpleDateFormat.format(patientModel.getAdmissionDateAndTime()));
            }
            if (patientModel.getTypeOfPatient() != null) {
                getValueAndIndex(patientType, patientTypeMap, patientModel.getTypeOfPatient());
            }
            if (patientModel.getTypeOfFromReferredFacility() != null) {
                getValueAndIndex(referredFacilityType, referredTypeMap, patientModel.getTypeOfFromReferredFacility());
            }
            if (patientModel.getNameOfFromReferredFacility() != null) {
                facilityName.setText(patientModel.getNameOfFromReferredFacility());
            }
            if (patientModel.getPatientName() != null) {
                patientName.setText(patientModel.getPatientName());
            }
            if (patientModel.getPatientHusbandName() != null) {
                patientHusbandName.setText(patientModel.getPatientHusbandName());
            }
            if (patientModel.getStateAreaId() != null) {
                getValueAndIndex(state, stateMap, patientModel.getStateAreaId());
                if (state.getText().toString().equals(Constant.STATE_NAME)) {
                    otherState.setVisibility(View.VISIBLE);
                    detailAddressLayout.setVisibility(View.GONE);
                } else {
                    detailAddressLayout.setVisibility(View.VISIBLE);
                    otherState.setVisibility(View.GONE);
                    district.setText("");
                    block.setText("");
                    village.setText("");
                }
            }
            if (patientModel.getDetailAddressIfOtherState() != null) {
                detailAddress.setText(patientModel.getDetailAddressIfOtherState());
            }
            if (patientModel.getDistrictAreaId() != null) {
                Realm realm = LRCM.getInstance().getRealm();
                RealmResults<Area> districts = realm.where(Area.class).equalTo("parentAreaId", stateMap.get(state.getText().toString())).findAll();
                districtMap = new TreeMap<String, Integer>();
                for (Area district : districts) {
                    districtMap.put(district.getName(), district.getNid());
                }
                getValueAndIndex(district, districtMap, patientModel.getDistrictAreaId());
                realm.close();
            }
            if (patientModel.getBlockAreaId() != null) {
                Realm realm = LRCM.getInstance().getRealm();
                RealmResults<Area> blocks = realm.where(Area.class).equalTo("parentAreaId", districtMap.get(district.getText().toString())).findAll();
                blockMap = new TreeMap<String, Integer>();
                for (Area block : blocks) {
                    blockMap.put(block.getName(), block.getNid());
                }
                getValueAndIndex(block, blockMap, patientModel.getBlockAreaId());
            }
            if (patientModel.getVillage() != null) {
                village.setText(patientModel.getVillage());
            }
            if (patientModel.getMobileNo() != null) {
                mobileNo.setText((patientModel.getMobileNo().toString()));
            }
            if (patientModel.getAge() != null) {
                age.setText(patientModel.getAge().toString());
            }
            if (patientModel.getCaste() != null) {
                getValueAndIndex(cast, casteTypeMap, patientModel.getCaste());
            }
            if (patientModel.getAplOrBpl() != null) {
                String apl_bpl = "";
                for (Map.Entry entry : aPLBPLTypeMap.entrySet()) {
                    if (entry.getValue() != null && Integer.parseInt(entry.getValue().toString()) == patientModel.getAplOrBpl()) {
                        apl_bpl = ((String) entry.getKey());
                    }
                }
                if (apl_bpl.equals("APL")) {
                    rdBtnApl.setChecked(true);
                } else if (apl_bpl.equals("BPL")) {
                    rdBtnBpl.setChecked(true);
                }
            }
            if (patientModel.getNoOfNormalDeliveries() != null) {
                noOfNormalDelivery.setText(patientModel.getNoOfNormalDeliveries().toString());
            }
            if (patientModel.getNoOfAssistedDeliveries() != null) {
                noOfAssistedDelivery.setText(patientModel.getNoOfAssistedDeliveries().toString());
            }
            if (patientModel.getNoOfCSectionDeliveries() != null) {
                noOfCSectionDelivery.setText(patientModel.getNoOfCSectionDeliveries().toString());
            }
            if (patientModel.getNoOfLiveChild() != null) {
                noOfLiveChild.setText(patientModel.getNoOfLiveChild().toString());
            }
            if (patientModel.getNoOfStillBirth() != null) {
                noOfDeathChild.setText(patientModel.getNoOfStillBirth().toString());
            }
            if (patientModel.getNoOfAbortion() != null) {
                noOfAbortion.setText(patientModel.getNoOfAbortion().toString());
            }
            if (patientModel.getNoOfAntenatalCheckups() != null) {
                noOfAntenatalCheckups.setText(patientModel.getNoOfAntenatalCheckups().toString());
            }
            if (patientModel.getAntenatalCheckupDoneBy() != null) {
                getValueAndIndex(antenatalCheckupDoneBy, antenatalTypeMap, patientModel.getAntenatalCheckupDoneBy());
            }
            if (patientModel.getBpSystolic() != null) {
                systolic.setText(patientModel.getBpSystolic().toString());
            }
            if (patientModel.getBpDiastolic() != null) {
                diastolic.setText(patientModel.getBpDiastolic().toString());
            }
            if (patientModel.getPulseRatePerMinute() != null) {
                pulseRate.setText(patientModel.getPulseRatePerMinute().toString());
            }
            if (patientModel.getRespiratoryRatePerMinute() != null) {
                respiratoryRate.setText(patientModel.getRespiratoryRatePerMinute().toString());
            }
            if (patientModel.getHeartRate() != null) {
                heartBeat.setText(patientModel.getHeartRate().toString());
            }
            if (patientModel.getCervicalDilatationInCm() != null) {
                cervicalDilatation.setText(patientModel.getCervicalDilatationInCm().toString());
            }
            if (patientModel.getPatrographStarted() != null) {
                isPartographStarted.setChecked(patientModel.getPatrographStarted());
            }
            if (patientModel.getUrineAlbumine() != null) {
                getValueAndIndex(urinAlbumine, urineAlbumineTypeMap, patientModel.getUrineAlbumine());
            }
            if (patientModel.getUrineSugar() != null) {
                getValueAndIndex(urinSugar, urineSugarTypeMap, patientModel.getUrineSugar());
            }
            if (patientModel.getBloodSugarTestDone() != null) {
                isBloodSugarTestDone.setChecked(patientModel.getBloodSugarTestDone());
            }
            if (patientModel.getBloodSugarFasting() != null) {
                fasting.setText(patientModel.getBloodSugarFasting().toString());
            }
            if (patientModel.getBloodSugarPostmeal() != null) {
                postmeal.setText(patientModel.getBloodSugarPostmeal().toString());
            }
            if (patientModel.getBloodSugarRandom() != null) {
                random.setText(patientModel.getBloodSugarRandom().toString());
            }
            if (patientModel.getVdrlRPR() != null) {
                getValueAndIndex(vdrl, vdrlTypeMap, patientModel.getVdrlRPR());
            }
            if (patientModel.getSickling() != null) {
                getValueAndIndex(sickling, sicklingTypeMap, patientModel.getSickling());
            }
            if (patientModel.getHivTest() != null) {
                getValueAndIndex(hivTest, hivTestTypeMap, patientModel.getHivTest());
            }
            if (patientModel.getBloodGroup() != null) {
                getValueAndIndex(bloodGroup, bloodGroupTypeMap, patientModel.getBloodGroup());
            }
            if (patientModel.getRhType() != null) {
                getValueAndIndex(rhType, rhTypeTypeMap, patientModel.getRhType());
            }
            if (patientModel.getVehicleToFacility() != null) {
                getValueAndIndex(transportToHospital, transportTypeMap, patientModel.getVehicleToFacility());
            }
            if (patientModel.getDeliveryDateAndTime() != null) {
                deliveryStatusFlag = true;
                setDeliveryDateAndTime.setText(simpleDateFormat.format(patientModel.getDeliveryDateAndTime()));
            }
            if (patientModel.getDeliveryBy() != null) {
                deliveryBy.setText(patientModel.getDeliveryBy());
            }
            if (patientModel.getDeliveryTerm() != null) {
                getValueAndIndex(deliveryTerm, deliveryTermTypeMap, patientModel.getDeliveryTerm());
            }
            if (patientModel.getDexamethasoneGiven() != null) {
                isDexamethansoneGiven.setChecked(patientModel.getDexamethasoneGiven());
            }
            if (patientModel.getDeliveryType() != null) {
                getValueAndIndex(deliveryType, deliveryTypeTypeMap, patientModel.getDeliveryType());
            }
            if (patientModel.getDrugGivenInThirdStageOfLabor() != null) {
                getValueAndIndex(drugType, thirdStageDrugTypeMap, patientModel.getDrugGivenInThirdStageOfLabor());
            }
            if (patientModel.getWasCordClampingDelayed() != null) {
                wasCordClampingDelayed.setChecked(patientModel.getWasCordClampingDelayed());
            }
            if (patientModel.getHasGestationalDM() != null) {
                getValueAndIndex(hasGestational, gestationalTypeMap, patientModel.getHasGestationalDM());
            }
            if (patientModel.getInsulinGiven() != null) {
                isInsulin.setChecked(patientModel.getInsulinGiven());
            }
            if (patientModel.getHasHypothyroidism() != null) {
                getValueAndIndex(hasHypoyhyroidism, hypoyhyroidismTypeMap, patientModel.getHasHypothyroidism());
            }
            if (patientModel.getLeavothyroxineGiven() != null) {
                isThyroxine.setChecked(patientModel.getLeavothyroxineGiven());
            }
            if (patientModel.getHasEclampsia() != null) {
                hasEclampsia.setChecked(patientModel.getHasEclampsia());
            }
            if (patientModel.getTreatedWithMagsulf() != null) {
                isMagsulf.setChecked(patientModel.getTreatedWithMagsulf());
            }

            if (patientModel.getChildren() != null && patientModel.getChildren().size() > 0) {
                addChildOne.setVisibility(View.GONE);
                switch (patientModel.getChildren().size()) {
                    case 1:
                        getChildOne();
                        childOneFlag = true;
                        setFieldsForChildInfo(customChildInfoLayoutOne);
                        break;
                    case 2:
                        getChildOne();
                        getChildTwo();
                        childOneFlag = true;
                        childTwoFlag = true;
                        setFieldsForChildInfo(customChildInfoLayoutOne);
                        setFieldsForChildInfo(customChildInfoLayoutTwo);
                        break;
                    case 3:
                        getChildOne();
                        getChildTwo();
                        getChildThree();
                        childOneFlag = true;
                        childTwoFlag = true;
                        childThreeFlag = true;
                        setFieldsForChildInfo(customChildInfoLayoutOne);
                        setFieldsForChildInfo(customChildInfoLayoutTwo);
                        setFieldsForChildInfo(customChildInfoLayoutThree);
                        break;
                    case 4:
                        getChildOne();
                        getChildTwo();
                        getChildThree();
                        getChildFour();
                        childOneFlag = true;
                        childTwoFlag = true;
                        childThreeFlag = true;
                        childFourFlag = true;
                        setFieldsForChildInfo(customChildInfoLayoutOne);
                        setFieldsForChildInfo(customChildInfoLayoutTwo);
                        setFieldsForChildInfo(customChildInfoLayoutThree);
                        setFieldsForChildInfo(customChildInfoLayoutFour);
                        break;
                    case 5:
                        getChildOne();
                        getChildTwo();
                        getChildThree();
                        getChildFour();
                        getChildFive();
                        childOneFlag = true;
                        childTwoFlag = true;
                        childThreeFlag = true;
                        childFourFlag = true;
                        childFiveFlag = true;
                        setFieldsForChildInfo(customChildInfoLayoutOne);
                        setFieldsForChildInfo(customChildInfoLayoutTwo);
                        setFieldsForChildInfo(customChildInfoLayoutThree);
                        setFieldsForChildInfo(customChildInfoLayoutFour);
                        setFieldsForChildInfo(customChildInfoLayoutFive);
                        break;
                    case 6:
                        getChildOne();
                        getChildTwo();
                        getChildThree();
                        getChildFour();
                        getChildFive();
                        getChildSix();
                        childOneFlag = true;
                        childTwoFlag = true;
                        childThreeFlag = true;
                        childFourFlag = true;
                        childFiveFlag = true;
                        childSixFlag = true;
                        setFieldsForChildInfo(customChildInfoLayoutOne);
                        setFieldsForChildInfo(customChildInfoLayoutTwo);
                        setFieldsForChildInfo(customChildInfoLayoutThree);
                        setFieldsForChildInfo(customChildInfoLayoutFour);
                        setFieldsForChildInfo(customChildInfoLayoutFive);
                        setFieldsForChildInfo(customChildInfoLayoutSix);
                        break;
                    case 7:
                        getChildOne();
                        getChildTwo();
                        getChildThree();
                        getChildFour();
                        getChildFive();
                        getChildSix();
                        getChildSeven();
                        childOneFlag = true;
                        childTwoFlag = true;
                        childThreeFlag = true;
                        childFourFlag = true;
                        childFiveFlag = true;
                        childSixFlag = true;
                        childSevenFlag = true;
                        setFieldsForChildInfo(customChildInfoLayoutOne);
                        setFieldsForChildInfo(customChildInfoLayoutTwo);
                        setFieldsForChildInfo(customChildInfoLayoutThree);
                        setFieldsForChildInfo(customChildInfoLayoutFour);
                        setFieldsForChildInfo(customChildInfoLayoutFive);
                        setFieldsForChildInfo(customChildInfoLayoutSix);
                        setFieldsForChildInfo(customChildInfoLayoutSeven);
                        break;
                    case 8:
                        getChildOne();
                        getChildTwo();
                        getChildThree();
                        getChildFour();
                        getChildFive();
                        getChildSix();
                        getChildSeven();
                        getChildEight();
                        childOneFlag = true;
                        childTwoFlag = true;
                        childThreeFlag = true;
                        childFourFlag = true;
                        childFiveFlag = true;
                        childSixFlag = true;
                        childSevenFlag = true;
                        childEightFlag = true;
                        setFieldsForChildInfo(customChildInfoLayoutOne);
                        setFieldsForChildInfo(customChildInfoLayoutTwo);
                        setFieldsForChildInfo(customChildInfoLayoutThree);
                        setFieldsForChildInfo(customChildInfoLayoutFour);
                        setFieldsForChildInfo(customChildInfoLayoutFive);
                        setFieldsForChildInfo(customChildInfoLayoutSix);
                        setFieldsForChildInfo(customChildInfoLayoutSeven);
                        setFieldsForChildInfo(customChildInfoLayoutEight);
                        break;
                    case 9:
                        getChildOne();
                        getChildTwo();
                        getChildThree();
                        getChildFour();
                        getChildFive();
                        getChildSix();
                        getChildSeven();
                        getChildEight();
                        getChildNine();
                        childOneFlag = true;
                        childTwoFlag = true;
                        childThreeFlag = true;
                        childFourFlag = true;
                        childFiveFlag = true;
                        childSixFlag = true;
                        childSevenFlag = true;
                        childEightFlag = true;
                        childNineFlag = true;
                        setFieldsForChildInfo(customChildInfoLayoutOne);
                        setFieldsForChildInfo(customChildInfoLayoutTwo);
                        setFieldsForChildInfo(customChildInfoLayoutThree);
                        setFieldsForChildInfo(customChildInfoLayoutFour);
                        setFieldsForChildInfo(customChildInfoLayoutFive);
                        setFieldsForChildInfo(customChildInfoLayoutSix);
                        setFieldsForChildInfo(customChildInfoLayoutSeven);
                        setFieldsForChildInfo(customChildInfoLayoutEight);
                        setFieldsForChildInfo(customChildInfoLayoutNine);
                        break;
                    case 10:
                        getChildOne();
                        getChildTwo();
                        getChildThree();
                        getChildFour();
                        getChildFive();
                        getChildSix();
                        getChildSeven();
                        getChildEight();
                        getChildNine();
                        getChildTen();
                        childOneFlag = true;
                        childTwoFlag = true;
                        childThreeFlag = true;
                        childFourFlag = true;
                        childFiveFlag = true;
                        childSixFlag = true;
                        childSevenFlag = true;
                        childEightFlag = true;
                        childNineFlag = true;
                        childTenFlag = true;
                        setFieldsForChildInfo(customChildInfoLayoutOne);
                        setFieldsForChildInfo(customChildInfoLayoutTwo);
                        setFieldsForChildInfo(customChildInfoLayoutThree);
                        setFieldsForChildInfo(customChildInfoLayoutFour);
                        setFieldsForChildInfo(customChildInfoLayoutFive);
                        setFieldsForChildInfo(customChildInfoLayoutSix);
                        setFieldsForChildInfo(customChildInfoLayoutSeven);
                        setFieldsForChildInfo(customChildInfoLayoutEight);
                        setFieldsForChildInfo(customChildInfoLayoutNine);
                        setFieldsForChildInfo(customChildInfoLayoutTen);
                        break;
                    default:
                        break;
                }
            }

            if (patientModel.getChildrenStatus() != null && patientModel.getChildrenStatus().size() > 0) {
                addChildStatusOne.setVisibility(View.GONE);
                switch (patientModel.getChildrenStatus().size()) {
                    case 1:
                        getChildStatusOne();
                        childStatusOneFlag = true;
                        setFieldsForChildStatus(customChildStatusLayoutOne);
                        break;
                    case 2:
                        getChildStatusOne();
                        getChildStatusTwo();
                        childStatusOneFlag = true;
                        childStatusTwoFlag = true;
                        setFieldsForChildStatus(customChildStatusLayoutOne);
                        setFieldsForChildStatus(customChildStatusLayoutTwo);
                        break;
                    case 3:
                        getChildStatusOne();
                        getChildStatusTwo();
                        getChildStatusThree();
                        childStatusOneFlag = true;
                        childStatusTwoFlag = true;
                        childStatusThreeFlag = true;
                        setFieldsForChildStatus(customChildStatusLayoutOne);
                        setFieldsForChildStatus(customChildStatusLayoutTwo);
                        setFieldsForChildStatus(customChildStatusLayoutThree);
                        break;
                    case 4:
                        getChildStatusOne();
                        getChildStatusTwo();
                        getChildStatusThree();
                        getChildStatusFour();
                        childStatusOneFlag = true;
                        childStatusTwoFlag = true;
                        childStatusThreeFlag = true;
                        childStatusFourFlag = true;
                        setFieldsForChildStatus(customChildStatusLayoutOne);
                        setFieldsForChildStatus(customChildStatusLayoutTwo);
                        setFieldsForChildStatus(customChildStatusLayoutThree);
                        setFieldsForChildStatus(customChildStatusLayoutFour);
                        break;
                    case 5:
                        getChildStatusOne();
                        getChildStatusTwo();
                        getChildStatusThree();
                        getChildStatusFour();
                        getChildStatusFive();
                        childStatusOneFlag = true;
                        childStatusTwoFlag = true;
                        childStatusThreeFlag = true;
                        childStatusFourFlag = true;
                        childStatusFiveFlag = true;
                        setFieldsForChildStatus(customChildStatusLayoutOne);
                        setFieldsForChildStatus(customChildStatusLayoutTwo);
                        setFieldsForChildStatus(customChildStatusLayoutThree);
                        setFieldsForChildStatus(customChildStatusLayoutFour);
                        setFieldsForChildStatus(customChildStatusLayoutFive);
                        break;
                    case 6:
                        getChildStatusOne();
                        getChildStatusTwo();
                        getChildStatusThree();
                        getChildStatusFour();
                        getChildStatusFive();
                        getChildStatusSix();
                        childStatusOneFlag = true;
                        childStatusTwoFlag = true;
                        childStatusThreeFlag = true;
                        childStatusFourFlag = true;
                        childStatusFiveFlag = true;
                        childStatusSixFlag = true;
                        setFieldsForChildStatus(customChildStatusLayoutOne);
                        setFieldsForChildStatus(customChildStatusLayoutTwo);
                        setFieldsForChildStatus(customChildStatusLayoutThree);
                        setFieldsForChildStatus(customChildStatusLayoutFour);
                        setFieldsForChildStatus(customChildStatusLayoutFive);
                        setFieldsForChildStatus(customChildStatusLayoutSix);
                        break;
                    case 7:
                        getChildStatusOne();
                        getChildStatusTwo();
                        getChildStatusThree();
                        getChildStatusFour();
                        getChildStatusFive();
                        getChildStatusSix();
                        getChildStatusSeven();
                        childStatusOneFlag = true;
                        childStatusTwoFlag = true;
                        childStatusThreeFlag = true;
                        childStatusFourFlag = true;
                        childStatusFiveFlag = true;
                        childStatusSixFlag = true;
                        childStatusSevenFlag = true;
                        setFieldsForChildStatus(customChildStatusLayoutOne);
                        setFieldsForChildStatus(customChildStatusLayoutTwo);
                        setFieldsForChildStatus(customChildStatusLayoutThree);
                        setFieldsForChildStatus(customChildStatusLayoutFour);
                        setFieldsForChildStatus(customChildStatusLayoutFive);
                        setFieldsForChildStatus(customChildStatusLayoutSix);
                        setFieldsForChildStatus(customChildStatusLayoutSeven);
                        break;
                    case 8:
                        getChildStatusOne();
                        getChildStatusTwo();
                        getChildStatusThree();
                        getChildStatusFour();
                        getChildStatusFive();
                        getChildStatusSix();
                        getChildStatusSeven();
                        getChildStatusEight();
                        childStatusOneFlag = true;
                        childStatusTwoFlag = true;
                        childStatusThreeFlag = true;
                        childStatusFourFlag = true;
                        childStatusFiveFlag = true;
                        childStatusSixFlag = true;
                        childStatusSevenFlag = true;
                        childStatusEightFlag = true;
                        setFieldsForChildStatus(customChildStatusLayoutOne);
                        setFieldsForChildStatus(customChildStatusLayoutTwo);
                        setFieldsForChildStatus(customChildStatusLayoutThree);
                        setFieldsForChildStatus(customChildStatusLayoutFour);
                        setFieldsForChildStatus(customChildStatusLayoutFive);
                        setFieldsForChildStatus(customChildStatusLayoutSix);
                        setFieldsForChildStatus(customChildStatusLayoutSeven);
                        setFieldsForChildStatus(customChildStatusLayoutEight);
                        break;
                    case 9:
                        getChildStatusOne();
                        getChildStatusTwo();
                        getChildStatusThree();
                        getChildStatusFour();
                        getChildStatusFive();
                        getChildStatusSix();
                        getChildStatusSeven();
                        getChildStatusEight();
                        getChildStatusNine();
                        childStatusOneFlag = true;
                        childStatusTwoFlag = true;
                        childStatusThreeFlag = true;
                        childStatusFourFlag = true;
                        childStatusFiveFlag = true;
                        childStatusSixFlag = true;
                        childStatusSevenFlag = true;
                        childStatusEightFlag = true;
                        childStatusNineFlag = true;
                        setFieldsForChildStatus(customChildStatusLayoutOne);
                        setFieldsForChildStatus(customChildStatusLayoutTwo);
                        setFieldsForChildStatus(customChildStatusLayoutThree);
                        setFieldsForChildStatus(customChildStatusLayoutFour);
                        setFieldsForChildStatus(customChildStatusLayoutFive);
                        setFieldsForChildStatus(customChildStatusLayoutSix);
                        setFieldsForChildStatus(customChildStatusLayoutSeven);
                        setFieldsForChildStatus(customChildStatusLayoutEight);
                        setFieldsForChildStatus(customChildStatusLayoutNine);
                        break;
                    case 10:
                        getChildStatusOne();
                        getChildStatusTwo();
                        getChildStatusThree();
                        getChildStatusFour();
                        getChildStatusFive();
                        getChildStatusSix();
                        getChildStatusSeven();
                        getChildStatusEight();
                        getChildStatusNine();
                        getChildStatusTen();
                        childStatusOneFlag = true;
                        childStatusTwoFlag = true;
                        childStatusThreeFlag = true;
                        childStatusFourFlag = true;
                        childStatusFiveFlag = true;
                        childStatusSixFlag = true;
                        childStatusSevenFlag = true;
                        childStatusEightFlag = true;
                        childStatusNineFlag = true;
                        childStatusTenFlag = true;
                        setFieldsForChildStatus(customChildStatusLayoutOne);
                        setFieldsForChildStatus(customChildStatusLayoutTwo);
                        setFieldsForChildStatus(customChildStatusLayoutThree);
                        setFieldsForChildStatus(customChildStatusLayoutFour);
                        setFieldsForChildStatus(customChildStatusLayoutFive);
                        setFieldsForChildStatus(customChildStatusLayoutSix);
                        setFieldsForChildStatus(customChildStatusLayoutSeven);
                        setFieldsForChildStatus(customChildStatusLayoutEight);
                        setFieldsForChildStatus(customChildStatusLayoutNine);
                        setFieldsForChildStatus(customChildStatusLayoutTen);
                        break;
                    default:
                        break;
                }
            }

            if (patientModel.getBloodTransfusionGiven() != null) {
                bloodTransfusion.setChecked(patientModel.getBloodTransfusionGiven());
            }
            if (patientModel.getNoOfPints() != null) {
                noOfPints.setText(patientModel.getNoOfPints().toString());
            }
            if (patientModel.getPpiucdInserted() != null) {
                ppiucdInsertion.setChecked(patientModel.getPpiucdInserted());
            }
            if (patientModel.getIFAGivenInPNC() != null) {
                ifa.setChecked(patientModel.getIFAGivenInPNC());
            }
            if (patientModel.getCalciumVitaminD3InPNC() != null) {
                calciumVitD3.setChecked(patientModel.getCalciumVitaminD3InPNC());
            }
            if (patientModel.getTypeOfJSY() != null) {
                getValueAndIndex(typeOfJsy, jsyTypeTypeMap, patientModel.getTypeOfJSY());
            }
            if (patientModel.getMotherStatus() != null) {
                getValueAndIndex(statusOfMother, motherStatusTypeMap, patientModel.getMotherStatus());
                switch (patientModel.getMotherStatus()) {
                    case MOTHER_STATUS_DISCHARGED_TYPE_DETAIL_ID:
                        motherStatusLayout.setVisibility(View.VISIBLE);
                        motherDischargeLayout.setVisibility(View.VISIBLE);
                        if (patientModel.getDischargeDateAndTime() != null) {
                            dischargeDateTimeOfMother.setText(simpleDateFormat.format(patientModel.getDischargeDateAndTime()));
                        }
                        if (patientModel.getTransportToHome() != null) {
                            getValueAndIndex(dischargeTransportOfMother, transportTypeMap, patientModel.getTransportToHome());
                        }
                        break;
                    case MOTHER_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID:
                        motherStatusLayout.setVisibility(View.VISIBLE);
                        motherReferredLayout.setVisibility(View.VISIBLE);
                        if (patientModel.getReferredDateAndTime() != null) {
                            referredDateTimeOfMother.setText(simpleDateFormat.format(patientModel.getReferredDateAndTime()));
                        }
                        if (patientModel.getReferredBy() != null) {
                            referredByOfMother.setText(patientModel.getReferredBy());
                        }
                        if (patientModel.getReferredCause() != null) {
                            getValueAndIndex(referredCauseOfMother, motherReferredCauseTypeMap, patientModel.getReferredCause());
                        }
                        if (patientModel.getOtherReferredCause() != null) {
                            otherReferredCauseMother.setText(patientModel.getOtherReferredCause());
                        }
                        if (patientModel.getReferredTransport() != null) {
                            getValueAndIndex(referredTransportOfMother, transportTypeMap, patientModel.getReferredTransport());
                        }
                        if (patientModel.getReferredAreaId() != null) {
                            getValueAndIndex(referredAreaOfMother, referredFacilityMap, patientModel.getReferredAreaId());
                        }
                        if (patientModel.getOtherReferredAreaId() != null) {
                            otherReferredFacilityMother.setText(patientModel.getOtherReferredAreaId());
                        }
                        break;
                    case MOTHER_STATUS_DEATH_TYPE_DETAIL_ID:
                        motherStatusLayout.setVisibility(View.VISIBLE);
                        motherDeadLayout.setVisibility(View.VISIBLE);
                        if (patientModel.getPatientDeathCause() != null) {
                            getValueAndIndex(deathCauseOfMother, motherDeathCauseTypeMap, patientModel.getPatientDeathCause());
                        }
                        if (patientModel.getOtherPatientDeathCause() != null) {
                            otherDeathCauseMother.setText(patientModel.getOtherPatientDeathCause());
                        }
                        if (patientModel.getPatientDeathDateAndTime() != null) {
                            deathDateTimeOfMother.setText(simpleDateFormat.format(patientModel.getPatientDeathDateAndTime()));
                        }
                        break;
                    case MOTHER_STATUS_LAMA_TYPE_DETAIL_ID:
                        motherStatusLayout.setVisibility(View.VISIBLE);
                        motherLamaLayout.setVisibility(View.VISIBLE);
                        if (patientModel.getLamaDateAndTime() != null) {
                            lamaDateTimeOfMother.setText(simpleDateFormat.format(patientModel.getLamaDateAndTime()));
                        }
                        break;
                }
            }
        }
    }

    public void setFieldsForChildInfo(CustomChildInfoLayout customChildInfoLayout) {
        anotherChildLayout.setVisibility(View.VISIBLE);

        customChildInfoLayout.linearLayout.setVisibility(View.VISIBLE);

        ChildModel childTen = patientModel.getChildren().get(childCount);

        if (childTen.getChildSex() != null) {
            String sex = "";
            for (Map.Entry entry : genderTypeMap.entrySet()) {
                if (entry.getValue() != null && Integer.parseInt(entry.getValue().toString()) == childTen.getChildSex()) {
                    if ((Integer) entry.getValue() == Constant.TypeDetails.SEX_MALE_TYPE_DETAIL_ID) {
                        customChildInfoLayout.sexMale.setChecked(true);
                    } else if ((Integer) entry.getValue() == Constant.TypeDetails.SEX_FEMALE_TYPE_DETAIL_ID) {
                        customChildInfoLayout.sexFemale.setChecked(true);
                    }
                }
            }
        }
        if (childTen.getChildWeight() != null) {
            customChildInfoLayout.weightEditBox.setText(childTen.getChildWeight().toString());
        }
        if (childTen.getIsStillBirth()) {
            customChildInfoLayout.stillBirthTB.setChecked(true);
            if (childTen.getStillBirthType() != null) {
                getValueAndIndex(customChildInfoLayout.stillBirthTypeEditBox, stillBirthTypeMap, childTen.getStillBirthType());
            }
        } else {
            customChildInfoLayout.stillBirthTB.setChecked(false);
            customChildInfoLayout.congenitalAnomalies.setChecked(null == childTen.getHasCongenitalAnomalies() ? null : childTen.getHasCongenitalAnomalies());
            customChildInfoLayout.babyBreastFeed.setChecked(null == childTen.getIsChildBreastFedInHour() ? null : childTen.getIsChildBreastFedInHour());
            customChildInfoLayout.rescusitation.setChecked(null == childTen.getHasNeededRescusition() ? null : childTen.getHasNeededRescusition());
            customChildInfoLayout.bcgGiven.setChecked(null == childTen.getIsBCGGiven() ? null : childTen.getIsBCGGiven());
            customChildInfoLayout.zeroOpvGiven.setChecked(null == childTen.getIsZeroOPVGiven() ? null : childTen.getIsZeroOPVGiven());
            customChildInfoLayout.hepBZero.setChecked(null == childTen.getIsHepBZeroGiven() ? null : childTen.getIsHepBZeroGiven());
            customChildInfoLayout.injVitK.setChecked(null == childTen.getIsVitaminKGiven() ? null : childTen.getIsVitaminKGiven());
        }
        childCount++;
    }

    public void setFieldsForChildStatus(CustomChildStatusLayout customChildStatusLayout) {

        anotherChildStatusLayout.setVisibility(View.VISIBLE);
        ChildStatusModel childStatus = patientModel.getChildrenStatus().get(childStatusCount);

        if (childStatus.getStatus() != null) {
            getValueAndIndexOfChildStatus(customChildStatusLayout.childStatusET, childStatusTypeMap, childStatus.getStatus(), customChildStatusLayout);
        }

        if (childStatus.getDischargeDateAndTime() != null) {
            customChildStatusLayout.dischargeDateTimeChildET.setText(simpleDateFormat.format(childStatus.getDischargeDateAndTime()));
        }

        if (childStatus.getDischargeWeight() != null) {
            customChildStatusLayout.dischargeWeightChildET.setText(childStatus.getDischargeWeight().toString());
        }

        if (childStatus.getTransportToHome() != null) {
            getValueAndIndexOfChildStatus(customChildStatusLayout.transportToHomeChildET, transportTypeMap, childStatus.getTransportToHome(), customChildStatusLayout);
        }

        if (childStatus.getReferredDateAndTime() != null) {
            customChildStatusLayout.referredDateTimeChildET.setText(simpleDateFormat.format(childStatus.getReferredDateAndTime()));
        }

        if (childStatus.getReferredBy() != null) {
            customChildStatusLayout.referredByChildET.setText(childStatus.getReferredBy());
        }

        if (childStatus.getReferredCause() != null) {
            getValueAndIndexOfChildStatus(customChildStatusLayout.referredCauseChildET, childReferredCauseTypeMap, childStatus.getReferredCause(), customChildStatusLayout);
        }

        if (childStatus.getOtherReferredCause() != null) {
            customChildStatusLayout.childReferredOtherCauseET.setText(childStatus.getOtherReferredCause());
        }

        if (childStatus.getReferredTransport() != null) {
            getValueAndIndexOfChildStatus(customChildStatusLayout.referredTransportChildET, transportTypeMap, childStatus.getReferredTransport(), customChildStatusLayout);
        }

        if (childStatus.getReferredTo() != null) {
            getValueAndIndexOfChildStatus(customChildStatusLayout.referredAreaChildET, childReferredFacilityTypeMap, childStatus.getReferredTo(), customChildStatusLayout);
        }

        if (childStatus.getOtherReferredTo() != null) {
            customChildStatusLayout.referredOtherAreaChildET.setText(childStatus.getOtherReferredTo());
        }

        if (childStatus.getDeathCause() != null) {
            customChildStatusLayout.childDeathCauseET.setText(childStatus.getDeathCause());
        }

        if (childStatus.getDeathDateAndTime() != null) {
            customChildStatusLayout.childDeathDateTimeET.setText(simpleDateFormat.format(childStatus.getDeathDateAndTime()));
        }

        if (childStatus.getLamaDateAndTime() != null) {
            customChildStatusLayout.lamaDateTimeChildET.setText(simpleDateFormat.format(childStatus.getLamaDateAndTime()));
        }
        childStatusCount++;
    }

    public Map<String, Integer> getValueAndIndex(EditText textField, Map<String, Integer> map, Integer id) {

        for (Map.Entry entry : map.entrySet()) {
            if (entry.getValue() != null && Integer.parseInt(entry.getValue().toString()) == id) {
                textField.setText((String) entry.getKey());
                switch ((Integer) entry.getValue()) {
                    case PRE_TERM_TYPE_DETAIL_ID:
                        dexamethasoneLayout.setVisibility(View.VISIBLE);
                        break;
                    case POST_TERM_TYPE_DETAIL_ID:
                        dexamethasoneLayout.setVisibility(View.GONE);
                        break;
                    case TERM_TYPE_DETAIL_ID:
                        dexamethasoneLayout.setVisibility(View.GONE);
                        break;
                    case SELF_PATIENT_TYPE_DETAIL_ID:
                        patientTypeLayout.setVisibility(View.GONE);
                        break;
                    case REFERRED_PATIENT_TYPE_DETAIL_ID:
                        patientTypeLayout.setVisibility(View.VISIBLE);
                        break;
                    case GESTATIONAL_YES_TYPE_DETAIL_ID:
                        insulinLayout.setVisibility(View.VISIBLE);
                        break;
                    case GESTATIONAL_NO_TYPE_DETAIL_ID:
                        insulinLayout.setVisibility(View.GONE);
                        break;
                    case GESTATIONAL_DONT_TYPE_DETAIL_ID:
                        insulinLayout.setVisibility(View.GONE);
                        break;
                    case HYPOTHYRODISM_YES_TYPE_DETAIL_ID:
                        thyroxineLayout.setVisibility(View.VISIBLE);
                        break;
                    case HYPOTHYRODISM_NO_TYPE_DETAIL_ID:
                        thyroxineLayout.setVisibility(View.GONE);
                        break;
                    case HYPOTHYRODISM_DONT_TYPE_DETAIL_ID:
                        thyroxineLayout.setVisibility(View.GONE);
                        break;
                    //
                    case MOTHER_REFERRED_NON_AVAILABILITY_OF_BLOOD_TYPE_DETAIL_ID:
                        otherReferredCauseMotherLayout.setVisibility(View.GONE);
                        break;
                    case MOTHER_REFERRED_NON_AVAILABILITY_OF_CSECTION_TYPE_DETAIL_ID:
                        otherReferredCauseMotherLayout.setVisibility(View.GONE);
                        break;
                    case MOTHER_REFERRED_NON_AVAILABILITY_OF_DOCTOR_TYPE_DETAIL_ID:
                        otherReferredCauseMotherLayout.setVisibility(View.GONE);
                        break;
                    case MOTHER_REFERRED_NON_AVAILABILITY_OF_NURSHING_STAFF_TYPE_DETAIL_ID:
                        otherReferredCauseMotherLayout.setVisibility(View.GONE);
                        break;
                    case MOTHER_REFERRED_NON_AVAILABILITY_OF_DRUG_TYPE_DETAIL_ID:
                        otherReferredCauseMotherLayout.setVisibility(View.GONE);
                        break;
                    case MOTHER_REFERRED_NON_AVAILABILITY_OF_SKILLED_PERSONEL_TYPE_DETAIL_ID:
                        otherReferredCauseMotherLayout.setVisibility(View.GONE);
                        break;
                    case MOTHER_REFERRED_OTHER_TYPE_DETAIL_ID:
                        otherReferredFacilityMotherLayout.setVisibility(View.VISIBLE);
                        break;
                    //
                    case MOTHER_REFERRED_FACILITY_MEDICAL_COLLEGE_TYPE_DETAIL_ID:
                        otherReferredFacilityMotherLayout.setVisibility(View.GONE);
                        break;
                    case MOTHER_REFERRED_FACILITY_DH_TYPE_DETAIL_ID:
                        otherReferredFacilityMotherLayout.setVisibility(View.GONE);
                        break;
                    case MOTHER_REFERRED_FACILITY_CH_FRU_TYPE_DETAIL_ID:
                        otherReferredFacilityMotherLayout.setVisibility(View.GONE);
                        break;
                    case MOTHER_REFERRED_FACILITY_CH_NON_FRU_TYPE_DETAIL_ID:
                        otherReferredFacilityMotherLayout.setVisibility(View.GONE);
                        break;
                    case MOTHER_REFERRED_FACILITY_CHC_FRU_TYPE_DETAIL_ID:
                        otherReferredFacilityMotherLayout.setVisibility(View.GONE);
                        break;
                    case MOTHER_REFERRED_FACILITY_CHC_NON_FRU_TYPE_DETAIL_ID:
                        otherReferredFacilityMotherLayout.setVisibility(View.GONE);
                        break;
                    case MOTHER_REFERRED_FACILITY_PHC_24X7_TYPE_DETAIL_ID:
                        otherReferredFacilityMotherLayout.setVisibility(View.GONE);
                        break;
                    case MOTHER_REFERRED_FACILITY_PHC_NON_24X7_TYPE_DETAIL_ID:
                        otherReferredFacilityMotherLayout.setVisibility(View.GONE);
                        break;
                    case MOTHER_REFERRED_FACILITY_OTHER_TYPE_DETAIL_ID:
                        otherReferredFacilityMotherLayout.setVisibility(View.VISIBLE);
                        break;
                    //
                    case MOTHER_DEATH_ANTEPARTUM_HEMORRHAGE_TYPE_DETAIL_ID:
                        otherDeathCauseMotherLayout.setVisibility(View.GONE);
                        break;
                    case MOTHER_DEATH_INTRAPARTUM_HEMORRHAGE_TYPE_DETAIL_ID:
                        otherDeathCauseMotherLayout.setVisibility(View.GONE);
                        break;
                    case MOTHER_DEATH_POSTPARTUM_HEMORRHAGE_TYPE_DETAIL_ID:
                        otherDeathCauseMotherLayout.setVisibility(View.GONE);
                        break;
                    case MOTHER_DEATH_PEURPEREAL_SEPSIS_TYPE_DETAIL_ID:
                        otherDeathCauseMotherLayout.setVisibility(View.GONE);
                        break;
                    case MOTHER_DEATH_ABORTION_TYPE_DETAIL_ID:
                        otherDeathCauseMotherLayout.setVisibility(View.GONE);
                        break;
                    case MOTHER_OBSTRUCTED_LABOUR_TYPE_DETAIL_ID:
                        otherDeathCauseMotherLayout.setVisibility(View.GONE);
                        break;
                    case MOTHER_PREGNENCY_INCLUDED_HYPERTENSION_TYPE_DETAIL_ID:
                        otherDeathCauseMotherLayout.setVisibility(View.GONE);
                        break;
                    case MOTHER_DEATH_SEVER_PREECLAMPSIA_TYPE_DETAIL_ID:
                        otherDeathCauseMotherLayout.setVisibility(View.GONE);
                        break;
                    case MOTHER_DEATH_ECLAMPSIA_TYPE_DETAIL_ID:
                        otherDeathCauseMotherLayout.setVisibility(View.GONE);
                        break;
                    case MOTHER_DEATH_HEART_DEASESES_TYPE_DETAIL_ID:
                        otherDeathCauseMotherLayout.setVisibility(View.GONE);
                        break;
                    case MOTHER_DEATH_CEREBRAL_MALERIA_TYPE_DETAIL_ID:
                        otherDeathCauseMotherLayout.setVisibility(View.GONE);
                        break;
                    case MOTHER_DEATH_INFECTIVE_HYPETITIS_TYPE_DETAIL_ID:
                        otherDeathCauseMotherLayout.setVisibility(View.GONE);
                        break;
                    case MOTHER_DEATH_SICKLE_CELL_DEASESE_TYPE_DETAIL_ID:
                        otherDeathCauseMotherLayout.setVisibility(View.GONE);
                        break;
                    case MOTHER_DEATH_TUBERCULOSIS_TYPE_DETAIL_ID:
                        otherDeathCauseMotherLayout.setVisibility(View.GONE);
                        break;
                    case MOTHER_DEATH_RESPIRATORY_DEASESE_TYPE_DETAIL_ID:
                        otherDeathCauseMotherLayout.setVisibility(View.GONE);
                        break;
                    case MOTHER_DEATH_DRUG_REACTION_TYPE_DETAIL_ID:
                        otherDeathCauseMotherLayout.setVisibility(View.GONE);
                        break;
                    case MOTHER_DEATH_KIDNY_DEASESE_TYPE_DETAIL_ID:
                        otherDeathCauseMotherLayout.setVisibility(View.GONE);
                        break;
                    case MOTHER_DEATH_EMBOLISM_TYPE_DETAIL_ID:
                        otherDeathCauseMotherLayout.setVisibility(View.GONE);
                        break;
                    case MOTHER_DEATH_SEVERE_ANEMIA_TYPE_DETAIL_ID:
                        otherDeathCauseMotherLayout.setVisibility(View.GONE);
                        break;
                    case MOTHER_DEATH_BLOOD_TRANSFUSION_REACTION_TYPE_DETAIL_ID:
                        otherDeathCauseMotherLayout.setVisibility(View.GONE);
                        break;
                    case MOTHER_DEATH_OTHER_TYPE_DETAIL_ID:
                        otherDeathCauseMotherLayout.setVisibility(View.VISIBLE);
                        break;

                    default:
                        break;
                }
            }
        }
        return map;
    }

    public Map<String, Integer> getValueAndIndexOfChildStatus(EditText textField, Map<String, Integer> map, Integer id, CustomChildStatusLayout customChildStatusLayout) {

        for (Map.Entry entry : map.entrySet()) {
            if (entry.getValue() != null && Integer.parseInt(entry.getValue().toString()) == id) {
                textField.setText((String) entry.getKey());
                switch ((Integer) entry.getValue()) {
                    case CHILD_STATUS_DISCHARGED_TYPE_DETAIL_ID:
                        customChildStatusLayout.childDischargeLayout.setVisibility(View.VISIBLE);
                        break;
                    case CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID:
                        customChildStatusLayout.childReferredLayout.setVisibility(View.VISIBLE);
                        break;
                    case CHILD_STATUS_DEATH_TYPE_DETAIL_ID:
                        customChildStatusLayout.childDeadLayout.setVisibility(View.VISIBLE);
                        break;
                    case CHILD_STATUS_LAMA_TYPE_DETAIL_ID:
                        customChildStatusLayout.childLamaDateTimeLayout.setVisibility(View.VISIBLE);
                        break;
                    case OTHER_REFERRED_CAUSE_CHILD_TYPE_DETAILS_ID:
                        customChildStatusLayout.childReferredOtherCauseET.setVisibility(View.VISIBLE);
                        break;
                    case OTHER_REFERRED_TO_CHILD_TYPE_DETAILS_ID:
                        customChildStatusLayout.referredOtherAreaChildET.setVisibility(View.VISIBLE);
                        break;
                    default:
                        break;
                }
            }
        }
        return map;
    }

    public void disableAllViews() {
        serialNo.setEnabled(false);
        dateTimeAdmission.setEnabled(false);
        showAdmissionDateAndTime.setEnabled(false);
        patientType.setEnabled(false);
        referredFacilityType.setEnabled(false);
        facilityName.setEnabled(false);
        patientName.setEnabled(false);
        patientHusbandName.setEnabled(false);
        state.setEnabled(false);
        detailAddress.setEnabled(false);
        district.setEnabled(false);
        block.setEnabled(false);
        village.setEnabled(false);
        mobileNo.setEnabled(false);
        age.setEnabled(false);
        cast.setEnabled(false);
        rdBtnApl.setEnabled(false);
        rdBtnBpl.setEnabled(false);
        noOfNormalDelivery.setEnabled(false);
        noOfAssistedDelivery.setEnabled(false);
        noOfCSectionDelivery.setEnabled(false);
        noOfLiveChild.setEnabled(false);
        noOfDeathChild.setEnabled(false);
        noOfAbortion.setEnabled(false);
        noOfAntenatalCheckups.setEnabled(false);
        antenatalCheckupDoneBy.setEnabled(false);
        systolic.setEnabled(false);
        diastolic.setEnabled(false);
        pulseRate.setEnabled(false);
        respiratoryRate.setEnabled(false);
        heartBeat.setEnabled(false);
        cervicalDilatation.setEnabled(false);
        isPartographStarted.setEnabled(false);
        urinAlbumine.setEnabled(false);
        urinSugar.setEnabled(false);
        isBloodSugarTestDone.setEnabled(false);
        fasting.setEnabled(false);
        postmeal.setEnabled(false);
        random.setEnabled(false);
        vdrl.setEnabled(false);
        sickling.setEnabled(false);
        hivTest.setEnabled(false);
        bloodGroup.setEnabled(false);
        rhType.setEnabled(false);
        transportToHospital.setEnabled(false);
        deliveryDateTime.setEnabled(false);
        showDeliveryDateAndTime.setEnabled(false);
        deliveryBy.setEnabled(false);
        deliveryTerm.setEnabled(false);
        deliveryType.setEnabled(false);
        drugType.setEnabled(false);
        isDexamethansoneGiven.setEnabled(false);
        wasCordClampingDelayed.setEnabled(false);
        hasGestational.setEnabled(false);
        isInsulin.setEnabled(false);
        hasHypoyhyroidism.setEnabled(false);
        isThyroxine.setEnabled(false);
        hasEclampsia.setEnabled(false);
        isMagsulf.setEnabled(false);

        addChildOne.setEnabled(false);

        switch (childCount) {
            case 1:
                disableEnableCustomChildInfoLayout(customChildInfoLayoutOne, false);
                enableDisableAddChild(false);
                break;
            case 2:
                disableEnableCustomChildInfoLayout(customChildInfoLayoutOne, false);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutTwo, false);
                enableDisableAddChild(false);
                break;
            case 3:
                disableEnableCustomChildInfoLayout(customChildInfoLayoutOne, false);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutTwo, false);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutThree, false);
                enableDisableAddChild(false);
                break;
            case 4:
                disableEnableCustomChildInfoLayout(customChildInfoLayoutOne, false);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutTwo, false);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutThree, false);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutFour, false);
                enableDisableAddChild(false);
                break;
            case 5:
                disableEnableCustomChildInfoLayout(customChildInfoLayoutOne, false);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutTwo, false);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutThree, false);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutFour, false);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutFive, false);
                enableDisableAddChild(false);
                break;
            case 6:
                disableEnableCustomChildInfoLayout(customChildInfoLayoutOne, false);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutTwo, false);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutThree, false);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutFour, false);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutFive, false);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutSix, false);
                enableDisableAddChild(false);
                break;
            case 7:
                disableEnableCustomChildInfoLayout(customChildInfoLayoutOne, false);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutTwo, false);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutThree, false);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutFour, false);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutFive, false);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutSix, false);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutSeven, false);
                enableDisableAddChild(false);
                break;
            case 8:
                disableEnableCustomChildInfoLayout(customChildInfoLayoutOne, false);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutTwo, false);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutThree, false);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutFour, false);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutFive, false);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutSix, false);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutSeven, false);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutEight, false);
                enableDisableAddChild(false);
                break;
            case 9:
                disableEnableCustomChildInfoLayout(customChildInfoLayoutOne, false);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutTwo, false);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutThree, false);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutFour, false);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutFive, false);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutSix, false);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutSeven, false);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutEight, false);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutNine, false);
                enableDisableAddChild(false);
                break;
            case 10:
                disableEnableCustomChildInfoLayout(customChildInfoLayoutOne, false);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutTwo, false);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutThree, false);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutFour, false);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutFive, false);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutSix, false);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutSeven, false);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutEight, false);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutNine, false);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutTen, false);
                enableDisableAddChild(false);
                break;
        }

        addChildStatusOne.setEnabled(false);

        switch (childStatusCount) {
            case 1:
                disableEnableCustomChildStatusLayout(customChildStatusLayoutOne, false);
                enableDisableAddChildStatus(false);
                break;
            case 2:
                disableEnableCustomChildStatusLayout(customChildStatusLayoutOne, false);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutTwo, false);
                enableDisableAddChildStatus(false);
                break;
            case 3:
                disableEnableCustomChildStatusLayout(customChildStatusLayoutOne, false);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutTwo, false);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutThree, false);
                enableDisableAddChildStatus(false);
                break;
            case 4:
                disableEnableCustomChildStatusLayout(customChildStatusLayoutOne, false);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutTwo, false);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutThree, false);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutFour, false);
                enableDisableAddChildStatus(false);
                break;
            case 5:
                disableEnableCustomChildStatusLayout(customChildStatusLayoutOne, false);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutTwo, false);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutThree, false);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutFour, false);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutFive, false);
                enableDisableAddChildStatus(false);
                break;
            case 6:
                disableEnableCustomChildStatusLayout(customChildStatusLayoutOne, false);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutTwo, false);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutThree, false);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutFour, false);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutFive, false);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutSix, false);
                enableDisableAddChildStatus(false);
                break;
            case 7:
                disableEnableCustomChildStatusLayout(customChildStatusLayoutOne, false);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutTwo, false);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutThree, false);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutFour, false);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutFive, false);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutSix, false);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutSeven, false);
                enableDisableAddChildStatus(false);
                break;
            case 8:
                disableEnableCustomChildStatusLayout(customChildStatusLayoutOne, false);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutTwo, false);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutThree, false);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutFour, false);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutFive, false);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutSix, false);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutSeven, false);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutEight, false);
                enableDisableAddChildStatus(false);
                break;
            case 9:
                disableEnableCustomChildStatusLayout(customChildStatusLayoutOne, false);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutTwo, false);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutThree, false);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutFour, false);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutFive, false);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutSix, false);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutSeven, false);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutEight, false);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutNine, false);
                enableDisableAddChildStatus(false);
                break;
            case 10:
                disableEnableCustomChildStatusLayout(customChildStatusLayoutOne, false);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutTwo, false);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutThree, false);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutFour, false);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutFive, false);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutSix, false);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutSeven, false);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutEight, false);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutNine, false);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutTen, false);
                enableDisableAddChildStatus(false);
                break;
        }

        bloodTransfusion.setEnabled(false);
        noOfPints.setEnabled(false);
        ppiucdInsertion.setEnabled(false);
        ifa.setEnabled(false);
        calciumVitD3.setEnabled(false);
        typeOfJsy.setEnabled(false);
    }


    public void disableMotherStatus() {
        statusOfMother.setEnabled(false);
        dischargeDateTimeOfMother.setEnabled(false);
        showDischargeDateTimeOfMother.setEnabled(false);
        dischargeTransportOfMother.setEnabled(false);
        referredDateTimeOfMother.setEnabled(false);
        showReferredDateTimeOfMother.setEnabled(false);
        referredByOfMother.setEnabled(false);
        referredCauseOfMother.setEnabled(false);
        otherReferredCauseMother.setEnabled(false);
        referredTransportOfMother.setEnabled(false);
        referredAreaOfMother.setEnabled(false);
        otherReferredFacilityMother.setEnabled(false);
        lamaDateTimeOfMother.setEnabled(false);
        showLamaDateTimeOfMother.setEnabled(false);
        deathCauseOfMother.setEnabled(false);
        otherDeathCauseMother.setEnabled(false);
        deathDateTimeOfMother.setEnabled(false);
        showDeathDateTimeOfMother.setEnabled(false);
    }

    public void enableAllViews() {
        serialNo.setEnabled(true);
        dateTimeAdmission.setEnabled(true);
        showAdmissionDateAndTime.setEnabled(true);
        patientType.setEnabled(true);
        referredFacilityType.setEnabled(true);
        facilityName.setEnabled(true);
        patientName.setEnabled(true);
        patientHusbandName.setEnabled(true);
        state.setEnabled(true);
        detailAddress.setEnabled(true);
        district.setEnabled(true);
        block.setEnabled(true);
        village.setEnabled(true);
        mobileNo.setEnabled(true);
        age.setEnabled(true);
        cast.setEnabled(true);
        rdBtnApl.setEnabled(true);
        rdBtnBpl.setEnabled(true);
        noOfNormalDelivery.setEnabled(true);
        noOfAssistedDelivery.setEnabled(true);
        noOfCSectionDelivery.setEnabled(true);
        noOfLiveChild.setEnabled(true);
        noOfDeathChild.setEnabled(true);
        noOfAbortion.setEnabled(true);
        noOfAntenatalCheckups.setEnabled(true);
        antenatalCheckupDoneBy.setEnabled(true);
        systolic.setEnabled(true);
        diastolic.setEnabled(true);
        pulseRate.setEnabled(true);
        respiratoryRate.setEnabled(true);
        heartBeat.setEnabled(true);
        cervicalDilatation.setEnabled(true);
        isPartographStarted.setEnabled(true);
        urinAlbumine.setEnabled(true);
        urinSugar.setEnabled(true);
        isBloodSugarTestDone.setEnabled(true);
        fasting.setEnabled(true);
        postmeal.setEnabled(true);
        random.setEnabled(true);
        vdrl.setEnabled(true);
        sickling.setEnabled(true);
        hivTest.setEnabled(true);
        bloodGroup.setEnabled(true);
        rhType.setEnabled(true);
        transportToHospital.setEnabled(true);
        deliveryDateTime.setEnabled(true);
        showDeliveryDateAndTime.setEnabled(true);
        deliveryBy.setEnabled(true);
        deliveryTerm.setEnabled(true);
        deliveryType.setEnabled(true);
        drugType.setEnabled(true);
        isDexamethansoneGiven.setEnabled(true);
        wasCordClampingDelayed.setEnabled(true);
        hasGestational.setEnabled(true);
        isInsulin.setEnabled(true);
        hasHypoyhyroidism.setEnabled(true);
        isThyroxine.setEnabled(true);
        hasEclampsia.setEnabled(true);
        isMagsulf.setEnabled(true);

        addChildOne.setEnabled(true);

        switch (childCount) {
            case 1:
                disableEnableCustomChildInfoLayout(customChildInfoLayoutOne, true);
                enableDisableAddChild(true);
                break;
            case 2:
                disableEnableCustomChildInfoLayout(customChildInfoLayoutOne, true);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutTwo, true);
                enableDisableAddChild(true);
                break;
            case 3:
                disableEnableCustomChildInfoLayout(customChildInfoLayoutOne, true);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutTwo, true);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutThree, true);
                enableDisableAddChild(true);
                break;
            case 4:
                disableEnableCustomChildInfoLayout(customChildInfoLayoutOne, true);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutTwo, true);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutThree, true);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutFour, true);
                enableDisableAddChild(true);
                break;
            case 5:
                disableEnableCustomChildInfoLayout(customChildInfoLayoutOne, true);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutTwo, true);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutThree, true);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutFour, true);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutFive, true);
                enableDisableAddChild(true);
                break;
            case 6:
                disableEnableCustomChildInfoLayout(customChildInfoLayoutOne, true);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutTwo, true);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutThree, true);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutFour, true);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutFive, true);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutSix, true);
                enableDisableAddChild(true);
                break;
            case 7:
                disableEnableCustomChildInfoLayout(customChildInfoLayoutOne, true);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutTwo, true);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutThree, true);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutFour, true);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutFive, true);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutSix, true);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutSeven, true);
                enableDisableAddChild(true);
                break;
            case 8:
                disableEnableCustomChildInfoLayout(customChildInfoLayoutOne, true);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutTwo, true);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutThree, true);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutFour, true);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutFive, true);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutSix, true);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutSeven, true);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutEight, true);
                enableDisableAddChild(true);
                break;
            case 9:
                disableEnableCustomChildInfoLayout(customChildInfoLayoutOne, true);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutTwo, true);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutThree, true);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutFour, true);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutFive, true);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutSix, true);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutSeven, true);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutEight, true);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutNine, true);
                enableDisableAddChild(true);
                break;
            case 10:
                disableEnableCustomChildInfoLayout(customChildInfoLayoutOne, true);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutTwo, true);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutThree, true);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutFour, true);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutFive, true);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutSix, true);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutSeven, true);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutEight, true);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutNine, true);
                disableEnableCustomChildInfoLayout(customChildInfoLayoutTen, true);
                enableDisableAddChild(true);
                break;
        }

        addChildStatusOne.setEnabled(true);
        switch (childStatusCount) {
            case 1:
                disableEnableCustomChildStatusLayout(customChildStatusLayoutOne, true);
                enableDisableAddChildStatus(true);
                break;
            case 2:
                disableEnableCustomChildStatusLayout(customChildStatusLayoutOne, true);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutTwo, true);
                enableDisableAddChildStatus(true);
                break;
            case 3:
                disableEnableCustomChildStatusLayout(customChildStatusLayoutOne, true);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutTwo, true);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutThree, true);
                enableDisableAddChildStatus(true);
                break;
            case 4:
                disableEnableCustomChildStatusLayout(customChildStatusLayoutOne, true);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutTwo, true);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutThree, true);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutFour, true);
                enableDisableAddChildStatus(true);
                break;
            case 5:
                disableEnableCustomChildStatusLayout(customChildStatusLayoutOne, true);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutTwo, true);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutThree, true);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutFour, true);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutFive, true);
                enableDisableAddChildStatus(true);
                break;
            case 6:
                disableEnableCustomChildStatusLayout(customChildStatusLayoutOne, true);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutTwo, true);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutThree, true);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutFour, true);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutFive, true);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutSix, true);
                enableDisableAddChildStatus(true);
                break;
            case 7:
                disableEnableCustomChildStatusLayout(customChildStatusLayoutOne, true);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutTwo, true);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutThree, true);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutFour, true);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutFive, true);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutSix, true);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutSeven, true);
                enableDisableAddChildStatus(true);
                break;
            case 8:
                disableEnableCustomChildStatusLayout(customChildStatusLayoutOne, true);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutTwo, true);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutThree, true);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutFour, true);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutFive, true);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutSix, true);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutSeven, true);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutEight, true);
                enableDisableAddChildStatus(true);
                break;
            case 9:
                disableEnableCustomChildStatusLayout(customChildStatusLayoutOne, true);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutTwo, true);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutThree, true);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutFour, true);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutFive, true);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutSix, true);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutSeven, true);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutEight, true);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutNine, true);
                enableDisableAddChildStatus(true);
                break;
            case 10:
                disableEnableCustomChildStatusLayout(customChildStatusLayoutOne, true);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutTwo, true);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutThree, true);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutFour, true);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutFive, true);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutSix, true);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutSeven, true);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutEight, true);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutNine, true);
                disableEnableCustomChildStatusLayout(customChildStatusLayoutTen, true);
                enableDisableAddChildStatus(true);
                break;
        }

        bloodTransfusion.setEnabled(true);
        noOfPints.setEnabled(true);
        ppiucdInsertion.setEnabled(true);
        ifa.setEnabled(true);
        calciumVitD3.setEnabled(true);
        typeOfJsy.setEnabled(true);

        statusOfMother.setEnabled(true);
        dischargeDateTimeOfMother.setEnabled(true);
        showDischargeDateTimeOfMother.setEnabled(true);
        dischargeTransportOfMother.setEnabled(true);
        referredDateTimeOfMother.setEnabled(true);
        showReferredDateTimeOfMother.setEnabled(true);
        referredByOfMother.setEnabled(true);
        referredCauseOfMother.setEnabled(true);
        otherReferredCauseMother.setEnabled(true);
        referredTransportOfMother.setEnabled(true);
        referredAreaOfMother.setEnabled(true);
        otherReferredFacilityMother.setEnabled(true);
        lamaDateTimeOfMother.setEnabled(true);
        showLamaDateTimeOfMother.setEnabled(true);
        deathCauseOfMother.setEnabled(true);
        otherDeathCauseMother.setEnabled(true);
        deathDateTimeOfMother.setEnabled(true);
        showDeathDateTimeOfMother.setEnabled(true);
    }

    public void enableDisableAddChild(Boolean status) {
        addChild.setEnabled(status);
        deleteChild.setEnabled(status);
    }

    public void enableDisableAddChildStatus(Boolean status) {
        addChildStatus.setEnabled(status);
        deleteChildStatus.setEnabled(status);
    }

    public void disableEnableCustomChildInfoLayout(CustomChildInfoLayout customChildInfoLayout, Boolean status) {
        customChildInfoLayout.collapseLayout.setEnabled(status);
        customChildInfoLayout.stillBirthTB.setEnabled(status);
        customChildInfoLayout.sexMale.setEnabled(status);
        customChildInfoLayout.sexFemale.setEnabled(status);
        customChildInfoLayout.weightEditBox.setEnabled(status);
        customChildInfoLayout.stillBirthTypeEditBox.setEnabled(status);
        customChildInfoLayout.congenitalAnomalies.setEnabled(status);
        customChildInfoLayout.babyBreastFeed.setEnabled(status);
        customChildInfoLayout.rescusitation.setEnabled(status);
        customChildInfoLayout.bcgGiven.setEnabled(status);
        customChildInfoLayout.zeroOpvGiven.setEnabled(status);
        customChildInfoLayout.hepBZero.setEnabled(status);
        customChildInfoLayout.injVitK.setEnabled(status);
    }

    public void disableEnableCustomChildStatusLayout(CustomChildStatusLayout customChildStatusLayout, Boolean status) {
        customChildStatusLayout.collapseLayout.setEnabled(status);
        customChildStatusLayout.showDischargeDateTimeChild.setEnabled(status);
        customChildStatusLayout.showReferredDateTimeChild.setEnabled(status);
        customChildStatusLayout.showlamaDateTimeChild.setEnabled(status);
        customChildStatusLayout.showChildDeathDateTime.setEnabled(status);
        customChildStatusLayout.childStatusET.setEnabled(status);
        customChildStatusLayout.dischargeDateTimeChildET.setEnabled(status);
        customChildStatusLayout.dischargeWeightChildET.setEnabled(status);
        customChildStatusLayout.transportToHomeChildET.setEnabled(status);
        customChildStatusLayout.referredDateTimeChildET.setEnabled(status);
        customChildStatusLayout.referredByChildET.setEnabled(status);
        customChildStatusLayout.referredCauseChildET.setEnabled(status);
        customChildStatusLayout.referredOtherAreaChildET.setEnabled(status);
        customChildStatusLayout.referredTransportChildET.setEnabled(status);
        customChildStatusLayout.referredAreaChildET.setEnabled(status);
        customChildStatusLayout.childReferredOtherCauseET.setEnabled(status);
        customChildStatusLayout.lamaDateTimeChildET.setEnabled(status);
        customChildStatusLayout.childDeathCauseET.setEnabled(status);
        customChildStatusLayout.childDeathCauseET.setEnabled(status);
    }

    @Override
    public void patientSaveComplete(AsyncTaskResultModel asyncTaskResultModel) {
        if (asyncTaskResultModel != null) {
            switch (asyncTaskResultModel.getResult()) {
                case Constant.Result.SUCCESS:
                    progressDialog.dismiss();
                    Toast.makeText(this, getString(R.string.saved), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(PatientActivity.this, PatientListActivity.class);
                    startActivity(intent);
                    finish();
                    break;
                case Constant.Result.ERROR:
                    progressDialog.dismiss();
                    alertDialog.setTitle(getString(R.string.error));
                    alertDialog.setMessage(asyncTaskResultModel.getMessage());
                    alertDialog.show();
                    break;
                case Constant.Result.PATIENT_EXISTS:
                    Toast.makeText(this, getString(R.string.patient_exists), Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
        } else {
            progressDialog.dismiss();
            Toast.makeText(this, getString(R.string.error), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFocusChange(View view, boolean b) {
        switch (view.getId()) {
            case R.id.patien_type:
                if (b) {
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(patientType.getWindowToken(), 0);
                }
                break;
            case R.id.referred_facility_type:
                if (b) {
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(referredFacilityType.getWindowToken(), 0);
                }
                break;
            case R.id.mobile_number:
                if (!b) {
                    if (mobileNo != null) {
                        try {
                            String mobileNoValidationResult = validation.validateMobileNo(Long.parseLong(mobileNo.getText().toString().trim()));
                            showValidationErrorMsg(mobileNoValidationResult);
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }
                    }
                }
                break;
            case R.id.age:
                if (!b) {
                    if (age != null) {
                        try {
                            String ageValidationResult = validation.validatePatientAge(Integer.parseInt(age.getText().toString().trim()));
                            showValidationErrorMsg(ageValidationResult);
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }
                    }
                }
                break;
            case R.id.state:
                if (b) {
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(state.getWindowToken(), 0);
                }
                break;
            case R.id.cast:
                if (b) {
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(cast.getWindowToken(), 0);
                }
                break;
            case R.id.antenatal_checkup_done_by:
                if (b) {
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(antenatalCheckupDoneBy.getWindowToken(), 0);
                }
                break;
            case R.id.urin_albumine:
                if (b) {
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(urinAlbumine.getWindowToken(), 0);
                }
                break;
            case R.id.vdrl:
                if (b) {
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(vdrl.getWindowToken(), 0);
                }
                break;
            case R.id.delivery_term:
                if (b) {
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(deliveryTerm.getWindowToken(), 0);
                }
                break;
            case R.id.referred_cause_mother:
                if (b) {
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(referredCauseOfMother.getWindowToken(), 0);
                }
                break;
            case R.id.type_of_jsy:
                if (b) {
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(typeOfJsy.getWindowToken(), 0);
                }
                break;
            default:
                break;
        }
    }

    public void showValidationErrorMsg(String errorMsg) {
        if (errorMsg != null) {
            alertDialog.setTitle(getString(R.string.error));
            alertDialog.setMessage(errorMsg);
            alertDialog.show();
        }
    }

    public void clearMotherDischargedFields() {
        dischargeDateTimeOfMother.setText("");
        dischargeTransportOfMother.setText("");
    }

    public void clearMotherReferredFields() {
        referredDateTimeOfMother.setText("");
        referredByOfMother.setText("");
        referredCauseOfMother.setText("");
        referredTransportOfMother.setText("");
        referredAreaOfMother.setText("");
        otherReferredCauseMotherLayout.setVisibility(View.GONE);
        otherReferredCauseMother.setText("");
        otherReferredFacilityMotherLayout.setVisibility(View.GONE);
        otherReferredFacilityMother.setText("");
    }

    public void clearMotherLamaFields() {
        lamaDateTimeOfMother.setText("");
    }

    public void clearMotherDeadFields() {
        deathCauseOfMother.setText("");
        deathDateTimeOfMother.setText("");

        otherDeathCauseMotherLayout.setVisibility(View.GONE);
        otherDeathCauseMother.setText("");
    }

    public void clearChildDischargedFields(CustomChildStatusLayout customChildStatusLayout) {
        customChildStatusLayout.dischargeDateTimeChildET.setText("");
        customChildStatusLayout.dischargeWeightChildET.setText("");
        customChildStatusLayout.transportToHomeChildET.setText("");
    }

    public void clearChildReferredFields(CustomChildStatusLayout customChildStatusLayout) {
        customChildStatusLayout.referredDateTimeChildET.setText("");
        customChildStatusLayout.referredByChildET.setText("");
        customChildStatusLayout.referredCauseChildET.setText("");
        customChildStatusLayout.childReferredOtherCauseET.setText("");
        customChildStatusLayout.referredTransportChildET.setText("");
        customChildStatusLayout.referredAreaChildET.setText("");
        customChildStatusLayout.referredOtherAreaChildET.setText("");
    }

    public void clearChildLamaFields(CustomChildStatusLayout customChildStatusLayout) {
        customChildStatusLayout.lamaDateTimeChildET.setText("");
    }

    public void clearChildDeadFields(CustomChildStatusLayout customChildStatusLayout) {
        customChildStatusLayout.childDeathCauseET.setText("");
        customChildStatusLayout.childDeathDateTimeET.setText("");
    }

    public void showErrorMessage(String errorMessage) {
        Snackbar snackbar = Snackbar
                .make(coordinatorLayout, errorMessage, Snackbar.LENGTH_LONG)
                .setAction("Ok", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });
        snackbar.show();
    }

    public boolean onSupportNavigateUp() {
        hideSoftKeyboard();
        onBackPressed();
        return true;
    }

    public void onBackPressed() {
        if (!saveFlag) {
            finish();
        } else {
            if (getWindow().getCurrentFocus() != null) {
                getWindow().getCurrentFocus().clearFocus();
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Want to discard this page ?")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                            finish();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            //  Action for 'NO' Button
                            dialog.cancel();
                        }
                    });
            //Creating dialog box
            AlertDialog alert = builder.create();
            alert.show();
        }
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
            switch (view.getId()) {
                case R.id.gestational:
                    hideSoftKeyboard();
                    if (gestationalTypeMap != null) {
                        Set<String> gestationalTypeSet = gestationalTypeMap.keySet();
                        CharSequence[] gestationalTypeItems = gestationalTypeSet.toArray(new CharSequence[gestationalTypeSet.size()]);
                        if (gestationalTypeItems.length > 0) {
                            chooseField(gestationalTypeItems, hasGestational, "gestational");
                        }
                    }
                    break;
                case R.id.hypothyroidism:
                    hideSoftKeyboard();
                    if (hypoyhyroidismTypeMap != null) {
                        Set<String> hypoyhyroidismTypeSet = hypoyhyroidismTypeMap.keySet();
                        CharSequence[] hypoyhyroidismTypeItems = hypoyhyroidismTypeSet.toArray(new CharSequence[hypoyhyroidismTypeSet.size()]);
                        if (hypoyhyroidismTypeItems.length > 0) {
                            chooseField(hypoyhyroidismTypeItems, hasHypoyhyroidism, "hypothyroidism");
                        }
                    }
                    break;
                case R.id.referred_facility_type:
                    hideSoftKeyboard();
                    if (referredTypeMap != null) {
                        Set<String> referredTypeSet = referredTypeMap.keySet();
                        CharSequence[] referredTypeItems = referredTypeSet.toArray(new CharSequence[referredTypeSet.size()]);
                        if (referredTypeItems.length > 0) {
                            chooseField(referredTypeItems, referredFacilityType, "");
                        }
                    }
                    break;
                case R.id.state:
                    hideSoftKeyboard();
                    Set<String> stateSet = stateMap.keySet();
                    CharSequence[] stateItems = stateSet.toArray(new CharSequence[stateSet.size()]);
                    if (stateItems.length > 0) {
                        chooseField(stateItems, state, "state");
                    }
                    break;
                case R.id.district:
                    hideSoftKeyboard();
                    Realm realm1 = LRCM.getInstance().getRealm();
                    if (!state.getText().toString().isEmpty()) {
                        RealmResults<Area> districts = realm1.where(Area.class).equalTo("parentAreaId", stateMap.get(state.getText().toString())).findAll();
                        districtMap = new TreeMap<String, Integer>();
                        for (Area district : districts) {
                            districtMap.put(district.getName(), district.getNid());
                        }
                    }
                    Set<String> districtSet = districtMap.keySet();
                    CharSequence[] districtItems = districtSet.toArray(new CharSequence[districtSet.size()]);
                    if (districtItems.length > 0) {
                        chooseField(districtItems, district, "district");
                    }
                    realm1.close();
                    break;
                case R.id.block:
                    hideSoftKeyboard();
                    Realm realm2 = LRCM.getInstance().getRealm();
                    if (!district.getText().toString().isEmpty()) {
                        RealmResults<Area> blocks = realm2.where(Area.class).equalTo("parentAreaId", districtMap.get(district.getText().toString())).findAll();
                        blockMap = new TreeMap<String, Integer>();
                        for (Area block : blocks) {
                            blockMap.put(block.getName(), block.getNid());
                        }
                    }
                    Set<String> blockSet = blockMap.keySet();
                    CharSequence[] blockItems = blockSet.toArray(new CharSequence[blockSet.size()]);
                    if (blockItems.length > 0) {
                        chooseField(blockItems, block, "block");
                    }
                    realm2.close();
                    break;
                case R.id.cast:
                    hideSoftKeyboard();
                    if (casteTypeMap != null) {
                        Set<String> castSet = casteTypeMap.keySet();
                        CharSequence[] castItems = castSet.toArray(new CharSequence[castSet.size()]);
                        if (castItems.length > 0) {
                            chooseField(castItems, cast, "");
                        }
                    }
                    break;
                case R.id.antenatal_checkup_done_by:
                    hideSoftKeyboard();
                    if (antenatalTypeMap != null) {
                        Set<String> antenatalSet = antenatalTypeMap.keySet();
                        CharSequence[] antenatalItems = antenatalSet.toArray(new CharSequence[antenatalSet.size()]);
                        if (antenatalItems.length > 0) {
                            chooseField(antenatalItems, antenatalCheckupDoneBy, "");
                        }
                    }
                    break;
                case R.id.urin_albumine:
                    hideSoftKeyboard();
                    if (urineAlbumineTypeMap != null) {
                        Set<String> urinAlbumineItemsSet = urineAlbumineTypeMap.keySet();
                        final CharSequence[] urinAlbumineItems = urinAlbumineItemsSet.toArray(new CharSequence[urinAlbumineItemsSet.size()]);
                        if (urinAlbumineItems.length > 0) {
                            chooseField(urinAlbumineItems, urinAlbumine, "");
                        }
                    }
                    break;
                case R.id.urin_sugar:
                    hideSoftKeyboard();
                    if (urineSugarTypeMap != null) {
                        Set<String> urinSugarItemsSet = urineSugarTypeMap.keySet();
                        final CharSequence[] urinSugarItems = urinSugarItemsSet.toArray(new CharSequence[urinSugarItemsSet.size()]);
                        if (urinSugarItems.length > 0) {
                            chooseField(urinSugarItems, urinSugar, "");
                        }
                    }
                    break;
                case R.id.patien_type:
                    hideSoftKeyboard();
                    if (patientTypeMap != null) {
                        Set<String> patientTypeSet = patientTypeMap.keySet();
                        CharSequence[] patientTypeItems = patientTypeSet.toArray(new CharSequence[patientTypeSet.size()]);
                        if (patientTypeItems.length > 0) {
                            chooseField(patientTypeItems, patientType, "patientType");
                        }
                    }
                    break;
                case R.id.vdrl:
                    hideSoftKeyboard();
                    if (vdrlTypeMap != null) {
                        Set<String> vdlsSet = vdrlTypeMap.keySet();
                        final CharSequence[] vdrlItems = vdlsSet.toArray(new CharSequence[vdlsSet.size()]);
                        if (vdrlItems.length > 0) {
                            chooseField(vdrlItems, vdrl, "");
                        }
                    }
                    break;
                case R.id.sickling:
                    hideSoftKeyboard();
                    if (sicklingTypeMap != null) {
                        Set<String> sicklingSet = sicklingTypeMap.keySet();
                        final CharSequence[] sicklingItems = sicklingSet.toArray(new CharSequence[sicklingSet.size()]);
                        if (sicklingItems.length > 0) {
                            chooseField(sicklingItems, sickling, "");
                        }
                    }
                    break;
                case R.id.hiv_test:
                    hideSoftKeyboard();
                    if (hivTestTypeMap != null) {
                        Set<String> hivtestSet = hivTestTypeMap.keySet();
                        final CharSequence[] hivTestItems = hivtestSet.toArray(new CharSequence[hivtestSet.size()]);
                        if (hivTestItems.length > 0) {
                            chooseField(hivTestItems, hivTest, "");
                        }
                    }
                    break;
                case R.id.blood_group:
                    hideSoftKeyboard();
                    if (bloodGroupTypeMap != null) {
                        Set<String> bloodGroupSet = bloodGroupTypeMap.keySet();
                        final CharSequence[] bloodGroupItems = bloodGroupSet.toArray(new CharSequence[bloodGroupSet.size()]);
                        if (bloodGroupItems.length > 0) {
                            chooseField(bloodGroupItems, bloodGroup, "");
                        }
                    }
                    break;
                case R.id.rh_type:
                    hideSoftKeyboard();
                    if (rhTypeTypeMap != null) {
                        Set<String> rhTypeSet = rhTypeTypeMap.keySet();
                        final CharSequence[] rhTypeSetItems = rhTypeSet.toArray(new CharSequence[rhTypeSet.size()]);
                        if (rhTypeSetItems.length > 0) {
                            chooseField(rhTypeSetItems, rhType, "");
                        }
                    }
                    break;
                case R.id.transport_to_hospital:
                    hideSoftKeyboard();
                    if (transportTypeMap != null) {
                        Set<String> transportToHospitalSet = transportTypeMap.keySet();
                        final CharSequence[] transportToHospitalItems = transportToHospitalSet.toArray(new CharSequence[transportToHospitalSet.size()]);
                        if (transportToHospitalItems.length > 0) {
                            chooseField(transportToHospitalItems, transportToHospital, "");
                        }
                    }
                    break;
                case R.id.delivery_term:
                    hideSoftKeyboard();
                    if (deliveryTermTypeMap != null) {
                        Set<String> deliveryTermSet = deliveryTermTypeMap.keySet();
                        final CharSequence[] deliveryTermItems = deliveryTermSet.toArray(new CharSequence[deliveryTermSet.size()]);
                        if (deliveryTermItems.length > 0) {
                            chooseField(deliveryTermItems, deliveryTerm, "deliveryTerm");
                        }
                    }
                    break;
                case R.id.delivery_type:
                    hideSoftKeyboard();
                    if (deliveryTypeTypeMap != null) {
                        Set<String> deliveryTypeSet = deliveryTypeTypeMap.keySet();
                        final CharSequence[] deliveryTypeItems = deliveryTypeSet.toArray(new CharSequence[deliveryTypeSet.size()]);
                        if (deliveryTypeItems.length > 0) {
                            chooseField(deliveryTypeItems, deliveryType, "");
                        }
                    }
                    break;
                case R.id.drug_given:
                    hideSoftKeyboard();
                    if (thirdStageDrugTypeMap != null) {
                        Set<String> drugTypeSet = thirdStageDrugTypeMap.keySet();
                        final CharSequence[] drugTypeSetItems = drugTypeSet.toArray(new CharSequence[drugTypeSet.size()]);
                        if (drugTypeSetItems.length > 0) {
                            chooseField(drugTypeSetItems, drugType, "");
                        }
                    }
                    break;
                case R.id.type_of_jsy:
                    hideSoftKeyboard();
                    if (jsyTypeTypeMap != null) {
                        Set<String> jsyTypeSet = jsyTypeTypeMap.keySet();
                        final CharSequence[] jsyTypeItems = jsyTypeSet.toArray(new CharSequence[jsyTypeSet.size()]);
                        if (jsyTypeItems.length > 0) {
                            chooseField(jsyTypeItems, typeOfJsy, "");
                        }
                    }
                    break;
                case R.id.referred_cause_mother:
                    hideSoftKeyboard();
                    if (motherReferredCauseTypeMap != null) {
                        Set<String> referredCauseMotherSet = motherReferredCauseTypeMap.keySet();
                        final CharSequence[] referredCauseMotherItems = referredCauseMotherSet.toArray(new CharSequence[referredCauseMotherSet.size()]);
                        if (referredCauseMotherItems.length > 0) {
                            chooseField(referredCauseMotherItems, referredCauseOfMother, "referredCauseOfMother");
                        }
                    }
                    break;
                case R.id.patient_death_cause_mother:
                    hideSoftKeyboard();
                    if (motherDeathCauseTypeMap != null) {
                        Set<String> motherDeathCausechildSet = motherDeathCauseTypeMap.keySet();
                        final CharSequence[] motherDeathCauseChildItems = motherDeathCausechildSet.toArray(new CharSequence[motherDeathCausechildSet.size()]);
                        if (motherDeathCauseChildItems.length > 0) {
                            chooseField(motherDeathCauseChildItems, deathCauseOfMother, "deathCauseOfMother");
                        }
                    }
                    break;
                default:
                    break;
            }
            return true;
        }
        return false;
    }

    //Child One Dynamic Design View
    private void getChildOne() {

        customChildInfoLayoutOne = new CustomChildInfoLayout(this.getApplicationContext());
        customChildInfoLayoutOne.childTxt.setText(getResources().getString(R.string.child_info_one));
        if (customChildInfoLayoutOne.stillBirthTB.isChecked()) {
            customChildInfoLayoutOne.stillBirthLayout.setVisibility(View.VISIBLE);
            customChildInfoLayoutOne.childOtherLayout.setVisibility(View.GONE);
        } else {
            customChildInfoLayoutOne.stillBirthLayout.setVisibility(View.GONE);
            customChildInfoLayoutOne.childOtherLayout.setVisibility(View.VISIBLE);
        }
        childListHolder.addView(customChildInfoLayoutOne);

        customChildInfoLayoutOne.expandCollapseImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (customChildInfoLayoutOne.collapseViewFlag) {
                    customChildInfoLayoutOne.collapseViewFlag = false;
                    customChildInfoLayoutOne.collapseView.setVisibility(View.GONE);
                    customChildInfoLayoutOne.expandCollapseImgBtn.setBackgroundResource(R.drawable.expand_arrow);
                } else {
                    customChildInfoLayoutOne.collapseViewFlag = true;
                    customChildInfoLayoutOne.collapseView.setVisibility(View.VISIBLE);
                    customChildInfoLayoutOne.expandCollapseImgBtn.setBackgroundResource(R.drawable.collapse_arrow);
                }
            }
        });
        customChildInfoLayoutOne.stillBirthTB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    customChildInfoLayoutOne.stillBirthLayout.setVisibility(View.VISIBLE);
                    customChildInfoLayoutOne.childOtherLayout.setVisibility(View.GONE);
                    resetStillBirthFields(customChildInfoLayoutOne);
                    clearChildStatusFields(customChildStatusLayoutOne);
                } else {
                    customChildInfoLayoutOne.stillBirthLayout.setVisibility(View.GONE);
                    customChildInfoLayoutOne.childOtherLayout.setVisibility(View.VISIBLE);
                    customChildInfoLayoutOne.stillBirthTypeEditBox.setText("");
                    clearChildStatusFields(customChildStatusLayoutOne);
                }
            }
        });
        customChildInfoLayoutOne.stillBirthTypeEditBox.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    hideSoftKeyboard();
                    if (stillBirthTypeMap != null) {
                        Set<String> stillBirthSet = stillBirthTypeMap.keySet();
                        final CharSequence[] stillBirthOneItems = stillBirthSet.toArray(new CharSequence[stillBirthSet.size()]);
                        if (stillBirthOneItems.length > 0) {
                            chooseField(stillBirthOneItems, customChildInfoLayoutOne.stillBirthTypeEditBox, "");
                        }
                    }
                }
                return false;
            }
        });
        customChildInfoLayoutOne.stillBirthTypeEditBox.setInputType(0);
    }

    //Child Two Dynamic Design View
    public void getChildTwo() {

        customChildInfoLayoutTwo = new CustomChildInfoLayout(this.getApplicationContext());
        customChildInfoLayoutTwo.childTxt.setText(getResources().getString(R.string.child_info_two));
        if (customChildInfoLayoutTwo.stillBirthTB.isChecked()) {
            customChildInfoLayoutTwo.stillBirthLayout.setVisibility(View.VISIBLE);
            customChildInfoLayoutTwo.childOtherLayout.setVisibility(View.GONE);
        } else {
            customChildInfoLayoutTwo.stillBirthLayout.setVisibility(View.GONE);
            customChildInfoLayoutTwo.childOtherLayout.setVisibility(View.VISIBLE);
        }
        childListHolder.addView(customChildInfoLayoutTwo);

        customChildInfoLayoutTwo.expandCollapseImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (customChildInfoLayoutTwo.collapseViewFlag) {
                    customChildInfoLayoutTwo.collapseViewFlag = false;
                    customChildInfoLayoutTwo.collapseView.setVisibility(View.GONE);
                    customChildInfoLayoutTwo.expandCollapseImgBtn.setBackgroundResource(R.drawable.expand_arrow);
                } else {
                    customChildInfoLayoutTwo.collapseViewFlag = true;
                    customChildInfoLayoutTwo.collapseView.setVisibility(View.VISIBLE);
                    customChildInfoLayoutTwo.expandCollapseImgBtn.setBackgroundResource(R.drawable.collapse_arrow);
                }
            }
        });

        customChildInfoLayoutTwo.stillBirthTB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    customChildInfoLayoutTwo.stillBirthLayout.setVisibility(View.VISIBLE);
                    customChildInfoLayoutTwo.childOtherLayout.setVisibility(View.GONE);
                    resetStillBirthFields(customChildInfoLayoutTwo);
                    clearChildStatusFields(customChildStatusLayoutTwo);
                } else {
                    customChildInfoLayoutTwo.stillBirthLayout.setVisibility(View.GONE);
                    customChildInfoLayoutTwo.childOtherLayout.setVisibility(View.VISIBLE);
                    customChildInfoLayoutTwo.stillBirthTypeEditBox.setText("");
                    clearChildStatusFields(customChildStatusLayoutTwo);
                }
            }
        });
        customChildInfoLayoutTwo.stillBirthTypeEditBox.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    hideSoftKeyboard();
                    if (stillBirthTypeMap != null) {
                        Set<String> stillBirthSet = stillBirthTypeMap.keySet();
                        final CharSequence[] stillBirthOneItems = stillBirthSet.toArray(new CharSequence[stillBirthSet.size()]);
                        if (stillBirthOneItems.length > 0) {
                            chooseField(stillBirthOneItems, customChildInfoLayoutTwo.stillBirthTypeEditBox, "");
                        }
                    }
                }
                return false;
            }
        });
        customChildInfoLayoutTwo.stillBirthTypeEditBox.setInputType(0);
    }

    //Child Three Dynamic Design View
    public void getChildThree() {

        customChildInfoLayoutThree = new CustomChildInfoLayout(this.getApplicationContext());
        customChildInfoLayoutThree.childTxt.setText(getResources().getString(R.string.child_info_three));
        if (customChildInfoLayoutThree.stillBirthTB.isChecked()) {
            customChildInfoLayoutThree.stillBirthLayout.setVisibility(View.VISIBLE);
            customChildInfoLayoutThree.childOtherLayout.setVisibility(View.GONE);
        } else {
            customChildInfoLayoutThree.stillBirthLayout.setVisibility(View.GONE);
            customChildInfoLayoutThree.childOtherLayout.setVisibility(View.VISIBLE);
        }
        childListHolder.addView(customChildInfoLayoutThree);

        customChildInfoLayoutThree.expandCollapseImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (customChildInfoLayoutThree.collapseViewFlag) {
                    customChildInfoLayoutThree.collapseViewFlag = false;
                    customChildInfoLayoutThree.collapseView.setVisibility(View.GONE);
                    customChildInfoLayoutThree.expandCollapseImgBtn.setBackgroundResource(R.drawable.expand_arrow);
                } else {
                    customChildInfoLayoutThree.collapseViewFlag = true;
                    customChildInfoLayoutThree.collapseView.setVisibility(View.VISIBLE);
                    customChildInfoLayoutThree.expandCollapseImgBtn.setBackgroundResource(R.drawable.collapse_arrow);
                }
            }
        });
        customChildInfoLayoutThree.stillBirthTB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    customChildInfoLayoutThree.stillBirthLayout.setVisibility(View.VISIBLE);
                    customChildInfoLayoutThree.childOtherLayout.setVisibility(View.GONE);
                    resetStillBirthFields(customChildInfoLayoutThree);
                    clearChildStatusFields(customChildStatusLayoutThree);
                } else {
                    customChildInfoLayoutThree.stillBirthLayout.setVisibility(View.GONE);
                    customChildInfoLayoutThree.childOtherLayout.setVisibility(View.VISIBLE);
                    customChildInfoLayoutThree.stillBirthTypeEditBox.setText("");
                    clearChildStatusFields(customChildStatusLayoutThree);
                }
            }
        });
        customChildInfoLayoutThree.stillBirthTypeEditBox.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    hideSoftKeyboard();
                    if (stillBirthTypeMap != null) {
                        Set<String> stillBirthSet = stillBirthTypeMap.keySet();
                        final CharSequence[] stillBirthOneItems = stillBirthSet.toArray(new CharSequence[stillBirthSet.size()]);
                        if (stillBirthOneItems.length > 0) {
                            chooseField(stillBirthOneItems, customChildInfoLayoutThree.stillBirthTypeEditBox, "");
                        }
                    }
                }
                return false;
            }
        });
        customChildInfoLayoutThree.stillBirthTypeEditBox.setInputType(0);

    }

    //Child Four Dynamic Design View
    public void getChildFour() {

        customChildInfoLayoutFour = new CustomChildInfoLayout(this.getApplicationContext());
        customChildInfoLayoutFour.childTxt.setText(getResources().getString(R.string.child_info_four));
        if (customChildInfoLayoutFour.stillBirthTB.isChecked()) {
            customChildInfoLayoutFour.stillBirthLayout.setVisibility(View.VISIBLE);
            customChildInfoLayoutFour.childOtherLayout.setVisibility(View.GONE);
        } else {
            customChildInfoLayoutFour.stillBirthLayout.setVisibility(View.GONE);
            customChildInfoLayoutFour.childOtherLayout.setVisibility(View.VISIBLE);
        }
        childListHolder.addView(customChildInfoLayoutFour);

        customChildInfoLayoutFour.expandCollapseImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (customChildInfoLayoutFour.collapseViewFlag) {
                    customChildInfoLayoutFour.collapseViewFlag = false;
                    customChildInfoLayoutFour.collapseView.setVisibility(View.GONE);
                    customChildInfoLayoutFour.expandCollapseImgBtn.setBackgroundResource(R.drawable.expand_arrow);
                } else {
                    customChildInfoLayoutFour.collapseViewFlag = true;
                    customChildInfoLayoutFour.collapseView.setVisibility(View.VISIBLE);
                    customChildInfoLayoutFour.expandCollapseImgBtn.setBackgroundResource(R.drawable.collapse_arrow);
                }
            }
        });
        customChildInfoLayoutFour.stillBirthTB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    customChildInfoLayoutFour.stillBirthLayout.setVisibility(View.VISIBLE);
                    customChildInfoLayoutFour.childOtherLayout.setVisibility(View.GONE);
                    resetStillBirthFields(customChildInfoLayoutFour);
                    clearChildStatusFields(customChildStatusLayoutFour);
                } else {
                    customChildInfoLayoutFour.stillBirthLayout.setVisibility(View.GONE);
                    customChildInfoLayoutFour.childOtherLayout.setVisibility(View.VISIBLE);
                    customChildInfoLayoutFour.stillBirthTypeEditBox.setText("");
                    clearChildStatusFields(customChildStatusLayoutFour);
                }
            }
        });
        customChildInfoLayoutFour.stillBirthTypeEditBox.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    hideSoftKeyboard();
                    if (stillBirthTypeMap != null) {
                        Set<String> stillBirthSet = stillBirthTypeMap.keySet();
                        final CharSequence[] stillBirthOneItems = stillBirthSet.toArray(new CharSequence[stillBirthSet.size()]);
                        if (stillBirthOneItems.length > 0) {
                            chooseField(stillBirthOneItems, customChildInfoLayoutFour.stillBirthTypeEditBox, "");
                        }
                    }
                }
                return false;
            }
        });
        customChildInfoLayoutFour.stillBirthTypeEditBox.setInputType(0);
    }

    //Child Five Dynamic Design View
    public void getChildFive() {

        customChildInfoLayoutFive = new CustomChildInfoLayout(this.getApplicationContext());
        customChildInfoLayoutFive.childTxt.setText(getResources().getString(R.string.child_info_five));
        if (customChildInfoLayoutFive.stillBirthTB.isChecked()) {
            customChildInfoLayoutFive.stillBirthLayout.setVisibility(View.VISIBLE);
            customChildInfoLayoutFive.childOtherLayout.setVisibility(View.GONE);
        } else {
            customChildInfoLayoutFive.stillBirthLayout.setVisibility(View.GONE);
            customChildInfoLayoutFive.childOtherLayout.setVisibility(View.VISIBLE);
        }
        childListHolder.addView(customChildInfoLayoutFive);

        customChildInfoLayoutFive.expandCollapseImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (customChildInfoLayoutFive.collapseViewFlag) {
                    customChildInfoLayoutFive.collapseViewFlag = false;
                    customChildInfoLayoutFive.collapseView.setVisibility(View.GONE);
                    customChildInfoLayoutFive.expandCollapseImgBtn.setBackgroundResource(R.drawable.expand_arrow);
                } else {
                    customChildInfoLayoutFive.collapseViewFlag = true;
                    customChildInfoLayoutFive.collapseView.setVisibility(View.VISIBLE);
                    customChildInfoLayoutFive.expandCollapseImgBtn.setBackgroundResource(R.drawable.collapse_arrow);
                }
            }
        });
        customChildInfoLayoutFive.stillBirthTB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    customChildInfoLayoutFive.stillBirthLayout.setVisibility(View.VISIBLE);
                    customChildInfoLayoutFive.childOtherLayout.setVisibility(View.GONE);
                    resetStillBirthFields(customChildInfoLayoutFive);
                    clearChildStatusFields(customChildStatusLayoutFive);
                } else {
                    customChildInfoLayoutFive.stillBirthLayout.setVisibility(View.GONE);
                    customChildInfoLayoutFive.childOtherLayout.setVisibility(View.VISIBLE);
                    customChildInfoLayoutFive.stillBirthTypeEditBox.setText("");
                    clearChildStatusFields(customChildStatusLayoutFive);
                }
            }
        });
        customChildInfoLayoutFive.stillBirthTypeEditBox.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    hideSoftKeyboard();
                    if (stillBirthTypeMap != null) {
                        Set<String> stillBirthSet = stillBirthTypeMap.keySet();
                        final CharSequence[] stillBirthOneItems = stillBirthSet.toArray(new CharSequence[stillBirthSet.size()]);
                        if (stillBirthOneItems.length > 0) {
                            chooseField(stillBirthOneItems, customChildInfoLayoutFive.stillBirthTypeEditBox, "");
                        }
                    }
                }
                return false;
            }
        });
        customChildInfoLayoutFive.stillBirthTypeEditBox.setInputType(0);
    }

    //Child Six Dynamic Design View
    public void getChildSix() {

        customChildInfoLayoutSix = new CustomChildInfoLayout(this.getApplicationContext());
        customChildInfoLayoutSix.childTxt.setText(getResources().getString(R.string.child_info_six));
        if (customChildInfoLayoutSix.stillBirthTB.isChecked()) {
            customChildInfoLayoutSix.stillBirthLayout.setVisibility(View.VISIBLE);
            customChildInfoLayoutSix.childOtherLayout.setVisibility(View.GONE);
        } else {
            customChildInfoLayoutSix.stillBirthLayout.setVisibility(View.GONE);
            customChildInfoLayoutSix.childOtherLayout.setVisibility(View.VISIBLE);
        }
        childListHolder.addView(customChildInfoLayoutSix);

        customChildInfoLayoutSix.expandCollapseImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (customChildInfoLayoutSix.collapseViewFlag) {
                    customChildInfoLayoutSix.collapseViewFlag = false;
                    customChildInfoLayoutSix.collapseView.setVisibility(View.GONE);
                    customChildInfoLayoutSix.expandCollapseImgBtn.setBackgroundResource(R.drawable.expand_arrow);
                } else {
                    customChildInfoLayoutSix.collapseViewFlag = true;
                    customChildInfoLayoutSix.collapseView.setVisibility(View.VISIBLE);
                    customChildInfoLayoutSix.expandCollapseImgBtn.setBackgroundResource(R.drawable.collapse_arrow);
                }
            }
        });
        customChildInfoLayoutSix.stillBirthTB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    customChildInfoLayoutSix.stillBirthLayout.setVisibility(View.VISIBLE);
                    customChildInfoLayoutSix.childOtherLayout.setVisibility(View.GONE);
                    resetStillBirthFields(customChildInfoLayoutSix);
                    clearChildStatusFields(customChildStatusLayoutSix);
                } else {
                    customChildInfoLayoutSix.stillBirthLayout.setVisibility(View.GONE);
                    customChildInfoLayoutSix.childOtherLayout.setVisibility(View.VISIBLE);
                    customChildInfoLayoutSix.stillBirthTypeEditBox.setText("");
                    clearChildStatusFields(customChildStatusLayoutSix);
                }
            }
        });
        customChildInfoLayoutSix.stillBirthTypeEditBox.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    hideSoftKeyboard();
                    if (stillBirthTypeMap != null) {
                        Set<String> stillBirthSet = stillBirthTypeMap.keySet();
                        final CharSequence[] stillBirthOneItems = stillBirthSet.toArray(new CharSequence[stillBirthSet.size()]);
                        if (stillBirthOneItems.length > 0) {
                            chooseField(stillBirthOneItems, customChildInfoLayoutSix.stillBirthTypeEditBox, "");
                        }
                    }
                }
                return false;
            }
        });
        customChildInfoLayoutSix.stillBirthTypeEditBox.setInputType(0);
    }

    //Child Seven Dynamic Design View
    public void getChildSeven() {

        customChildInfoLayoutSeven = new CustomChildInfoLayout(this.getApplicationContext());
        customChildInfoLayoutSeven.childTxt.setText(getResources().getString(R.string.child_info_seven));
        if (customChildInfoLayoutSeven.stillBirthTB.isChecked()) {
            customChildInfoLayoutSeven.stillBirthLayout.setVisibility(View.VISIBLE);
            customChildInfoLayoutSeven.childOtherLayout.setVisibility(View.GONE);
        } else {
            customChildInfoLayoutSeven.stillBirthLayout.setVisibility(View.GONE);
            customChildInfoLayoutSeven.childOtherLayout.setVisibility(View.VISIBLE);
        }
        childListHolder.addView(customChildInfoLayoutSeven);

        customChildInfoLayoutSeven.expandCollapseImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (customChildInfoLayoutSeven.collapseViewFlag) {
                    customChildInfoLayoutSeven.collapseViewFlag = false;
                    customChildInfoLayoutSeven.collapseView.setVisibility(View.GONE);
                    customChildInfoLayoutSeven.expandCollapseImgBtn.setBackgroundResource(R.drawable.expand_arrow);
                } else {
                    customChildInfoLayoutSeven.collapseViewFlag = true;
                    customChildInfoLayoutSeven.collapseView.setVisibility(View.VISIBLE);
                    customChildInfoLayoutSeven.expandCollapseImgBtn.setBackgroundResource(R.drawable.collapse_arrow);
                }
            }
        });
        customChildInfoLayoutSeven.stillBirthTB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    customChildInfoLayoutSeven.stillBirthLayout.setVisibility(View.VISIBLE);
                    customChildInfoLayoutSeven.childOtherLayout.setVisibility(View.GONE);
                    resetStillBirthFields(customChildInfoLayoutSeven);
                    clearChildStatusFields(customChildStatusLayoutSeven);
                } else {
                    customChildInfoLayoutSeven.stillBirthLayout.setVisibility(View.GONE);
                    customChildInfoLayoutSeven.childOtherLayout.setVisibility(View.VISIBLE);
                    customChildInfoLayoutSeven.stillBirthTypeEditBox.setText("");
                    clearChildStatusFields(customChildStatusLayoutSeven);
                }
            }
        });
        customChildInfoLayoutSeven.stillBirthTypeEditBox.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    hideSoftKeyboard();
                    if (stillBirthTypeMap != null) {
                        Set<String> stillBirthSet = stillBirthTypeMap.keySet();
                        final CharSequence[] stillBirthOneItems = stillBirthSet.toArray(new CharSequence[stillBirthSet.size()]);
                        if (stillBirthOneItems.length > 0) {
                            chooseField(stillBirthOneItems, customChildInfoLayoutSeven.stillBirthTypeEditBox, "");
                        }
                    }
                }
                return false;
            }
        });
        customChildInfoLayoutSeven.stillBirthTypeEditBox.setInputType(0);
    }

    //Child Eight Dynamic Design View
    public void getChildEight() {

        customChildInfoLayoutEight = new CustomChildInfoLayout(this.getApplicationContext());
        customChildInfoLayoutEight.childTxt.setText(getResources().getString(R.string.child_info_eight));
        if (customChildInfoLayoutEight.stillBirthTB.isChecked()) {
            customChildInfoLayoutEight.stillBirthLayout.setVisibility(View.VISIBLE);
            customChildInfoLayoutEight.childOtherLayout.setVisibility(View.GONE);
        } else {
            customChildInfoLayoutEight.stillBirthLayout.setVisibility(View.GONE);
            customChildInfoLayoutEight.childOtherLayout.setVisibility(View.VISIBLE);
        }
        childListHolder.addView(customChildInfoLayoutEight);

        customChildInfoLayoutEight.expandCollapseImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (customChildInfoLayoutEight.collapseViewFlag) {
                    customChildInfoLayoutEight.collapseViewFlag = false;
                    customChildInfoLayoutEight.collapseView.setVisibility(View.GONE);
                    customChildInfoLayoutEight.expandCollapseImgBtn.setBackgroundResource(R.drawable.expand_arrow);
                } else {
                    customChildInfoLayoutEight.collapseViewFlag = true;
                    customChildInfoLayoutEight.collapseView.setVisibility(View.VISIBLE);
                    customChildInfoLayoutEight.expandCollapseImgBtn.setBackgroundResource(R.drawable.collapse_arrow);
                }
            }
        });
        customChildInfoLayoutEight.stillBirthTB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    customChildInfoLayoutEight.stillBirthLayout.setVisibility(View.VISIBLE);
                    customChildInfoLayoutEight.childOtherLayout.setVisibility(View.GONE);
                    resetStillBirthFields(customChildInfoLayoutEight);
                    clearChildStatusFields(customChildStatusLayoutEight);
                } else {
                    customChildInfoLayoutEight.stillBirthLayout.setVisibility(View.GONE);
                    customChildInfoLayoutEight.childOtherLayout.setVisibility(View.VISIBLE);
                    customChildInfoLayoutEight.stillBirthTypeEditBox.setText("");
                    clearChildStatusFields(customChildStatusLayoutEight);
                }
            }
        });
        customChildInfoLayoutEight.stillBirthTypeEditBox.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    hideSoftKeyboard();
                    if (stillBirthTypeMap != null) {
                        Set<String> stillBirthSet = stillBirthTypeMap.keySet();
                        final CharSequence[] stillBirthOneItems = stillBirthSet.toArray(new CharSequence[stillBirthSet.size()]);
                        if (stillBirthOneItems.length > 0) {
                            chooseField(stillBirthOneItems, customChildInfoLayoutEight.stillBirthTypeEditBox, "");
                        }
                    }
                }
                return false;
            }
        });
        customChildInfoLayoutEight.stillBirthTypeEditBox.setInputType(0);
    }

    //Child Nine Dynamic Design View
    public void getChildNine() {

        customChildInfoLayoutNine = new CustomChildInfoLayout(this.getApplicationContext());
        customChildInfoLayoutNine.childTxt.setText(getResources().getString(R.string.child_info_nine));
        if (customChildInfoLayoutNine.stillBirthTB.isChecked()) {
            customChildInfoLayoutNine.stillBirthLayout.setVisibility(View.VISIBLE);
            customChildInfoLayoutNine.childOtherLayout.setVisibility(View.GONE);
        } else {
            customChildInfoLayoutNine.stillBirthLayout.setVisibility(View.GONE);
            customChildInfoLayoutNine.childOtherLayout.setVisibility(View.VISIBLE);
        }
        childListHolder.addView(customChildInfoLayoutNine);

        customChildInfoLayoutNine.expandCollapseImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (customChildInfoLayoutNine.collapseViewFlag) {
                    customChildInfoLayoutNine.collapseViewFlag = false;
                    customChildInfoLayoutNine.collapseView.setVisibility(View.GONE);
                    customChildInfoLayoutNine.expandCollapseImgBtn.setBackgroundResource(R.drawable.expand_arrow);
                } else {
                    customChildInfoLayoutNine.collapseViewFlag = true;
                    customChildInfoLayoutNine.collapseView.setVisibility(View.VISIBLE);
                    customChildInfoLayoutNine.expandCollapseImgBtn.setBackgroundResource(R.drawable.collapse_arrow);
                }
            }
        });
        customChildInfoLayoutNine.stillBirthTB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    customChildInfoLayoutNine.stillBirthLayout.setVisibility(View.VISIBLE);
                    customChildInfoLayoutNine.childOtherLayout.setVisibility(View.GONE);
                    resetStillBirthFields(customChildInfoLayoutNine);
                    clearChildStatusFields(customChildStatusLayoutNine);
                } else {
                    customChildInfoLayoutNine.stillBirthLayout.setVisibility(View.GONE);
                    customChildInfoLayoutNine.childOtherLayout.setVisibility(View.VISIBLE);
                    customChildInfoLayoutNine.stillBirthTypeEditBox.setText("");
                    clearChildStatusFields(customChildStatusLayoutNine);
                }
            }
        });
        customChildInfoLayoutNine.stillBirthTypeEditBox.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    hideSoftKeyboard();
                    if (stillBirthTypeMap != null) {
                        Set<String> stillBirthSet = stillBirthTypeMap.keySet();
                        final CharSequence[] stillBirthOneItems = stillBirthSet.toArray(new CharSequence[stillBirthSet.size()]);
                        if (stillBirthOneItems.length > 0) {
                            chooseField(stillBirthOneItems, customChildInfoLayoutNine.stillBirthTypeEditBox, "");
                        }
                    }
                }
                return false;
            }
        });
        customChildInfoLayoutNine.stillBirthTypeEditBox.setInputType(0);
    }

    //Child Ten Dynamic Design View
    public void getChildTen() {

        customChildInfoLayoutTen = new CustomChildInfoLayout(this.getApplicationContext());
        customChildInfoLayoutTen.childTxt.setText(getResources().getString(R.string.child_info_ten));
        if (customChildInfoLayoutTen.stillBirthTB.isChecked()) {
            customChildInfoLayoutTen.stillBirthLayout.setVisibility(View.VISIBLE);
            customChildInfoLayoutTen.childOtherLayout.setVisibility(View.GONE);
        } else {
            customChildInfoLayoutTen.stillBirthLayout.setVisibility(View.GONE);
            customChildInfoLayoutTen.childOtherLayout.setVisibility(View.VISIBLE);
        }
        childListHolder.addView(customChildInfoLayoutTen);

        customChildInfoLayoutTen.expandCollapseImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (customChildInfoLayoutTen.collapseViewFlag) {
                    customChildInfoLayoutTen.collapseViewFlag = false;
                    customChildInfoLayoutTen.collapseView.setVisibility(View.GONE);
                    customChildInfoLayoutTen.expandCollapseImgBtn.setBackgroundResource(R.drawable.expand_arrow);
                } else {
                    customChildInfoLayoutTen.collapseViewFlag = true;
                    customChildInfoLayoutTen.collapseView.setVisibility(View.VISIBLE);
                    customChildInfoLayoutTen.expandCollapseImgBtn.setBackgroundResource(R.drawable.collapse_arrow);
                }
            }
        });
        customChildInfoLayoutTen.stillBirthTB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    customChildInfoLayoutTen.stillBirthLayout.setVisibility(View.VISIBLE);
                    customChildInfoLayoutTen.childOtherLayout.setVisibility(View.GONE);
                    resetStillBirthFields(customChildInfoLayoutTen);
                    clearChildStatusFields(customChildStatusLayoutTen);
                } else {
                    customChildInfoLayoutTen.stillBirthLayout.setVisibility(View.GONE);
                    customChildInfoLayoutTen.childOtherLayout.setVisibility(View.VISIBLE);
                    customChildInfoLayoutTen.stillBirthTypeEditBox.setText("");
                    clearChildStatusFields(customChildStatusLayoutTen);
                }
            }
        });
        customChildInfoLayoutTen.stillBirthTypeEditBox.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    hideSoftKeyboard();
                    if (stillBirthTypeMap != null) {
                        Set<String> stillBirthSet = stillBirthTypeMap.keySet();
                        final CharSequence[] stillBirthOneItems = stillBirthSet.toArray(new CharSequence[stillBirthSet.size()]);
                        if (stillBirthOneItems.length > 0) {
                            chooseField(stillBirthOneItems, customChildInfoLayoutTen.stillBirthTypeEditBox, "");
                        }
                    }
                }
                return false;
            }
        });
        customChildInfoLayoutTen.stillBirthTypeEditBox.setInputType(0);
    }

    public void resetStillBirthFields(CustomChildInfoLayout customChildInfoLayout) {
        customChildInfoLayout.congenitalAnomalies.setChecked(false);
        customChildInfoLayout.babyBreastFeed.setChecked(false);
        customChildInfoLayout.rescusitation.setChecked(false);
        customChildInfoLayout.bcgGiven.setChecked(false);
        customChildInfoLayout.zeroOpvGiven.setChecked(false);
        customChildInfoLayout.hepBZero.setChecked(false);
        customChildInfoLayout.injVitK.setChecked(false);
    }

    public void getChildStatusOne() {
        customChildStatusLayoutOne = new CustomChildStatusLayout(this.getApplicationContext());
        customChildStatusLayoutOne.addChildStatusTxt.setText(getResources().getString(R.string.child_status_one));
        customChildStatusLayoutOne.expandCollapseImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (customChildStatusLayoutOne.childStatusFlag) {
                    customChildStatusLayoutOne.childStatusFlag = false;
                    customChildStatusLayoutOne.collapseView.setVisibility(View.GONE);
                    customChildStatusLayoutOne.expandCollapseImgBtn.setBackgroundResource(R.drawable.expand_arrow);
                } else {
                    customChildStatusLayoutOne.childStatusFlag = true;
                    customChildStatusLayoutOne.collapseView.setVisibility(View.VISIBLE);
                    customChildStatusLayoutOne.expandCollapseImgBtn.setBackgroundResource(R.drawable.collapse_arrow);
                }
            }
        });
        childStatusListHolder.addView(customChildStatusLayoutOne);

        customChildStatusLayoutOne.childStatusET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                if (customChildInfoLayoutOne != null && !customChildInfoLayoutOne.stillBirthTB.isChecked()) {
                    if (childStatusTypeMap != null) {
                        Set<String> childStatusSet = childStatusTypeMap.keySet();
                        final CharSequence[] childStatusItems = childStatusSet.toArray(new CharSequence[childStatusSet.size()]);
                        if (childStatusItems.length > 0) {
                            chooseChildStatus(childStatusItems, customChildStatusLayoutOne.childStatusET, customChildStatusLayoutOne, customChildInfoLayoutOne, "Child Status", "1st");
                        }
                    }
                } else {
                    showErrorMessage(getResources().getString(R.string.restriction_adding_child_status_as_child_one_still_birth));
                }
            }
        });
        customChildStatusLayoutOne.showDischargeDateTimeChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                showDateTime(customChildStatusLayoutOne.dischargeDateTimeChildET, "");
            }
        });
        customChildStatusLayoutOne.transportToHomeChildET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                if (transportTypeMap != null) {
                    Set<String> transportChildToHomeSet = transportTypeMap.keySet();
                    final CharSequence[] transportChildToHomeItems = transportChildToHomeSet.toArray(new CharSequence[transportChildToHomeSet.size()]);
                    if (transportChildToHomeItems.length > 0) {
                        chooseField(transportChildToHomeItems, customChildStatusLayoutOne.transportToHomeChildET, "");
                    }
                }
            }
        });
        customChildStatusLayoutOne.showReferredDateTimeChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                showDateTime(customChildStatusLayoutOne.referredDateTimeChildET, "");
            }
        });
        customChildStatusLayoutOne.referredCauseChildET.setInputType(0);
        customChildStatusLayoutOne.referredCauseChildET.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    customChildStatusLayoutOne.referredCauseChildET.setText("");
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(vdrl.getWindowToken(), 0);
                }
            }
        });
        customChildStatusLayoutOne.referredCauseChildET.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    hideSoftKeyboard();
                    if (childReferredCauseTypeMap != null) {
                        Set<String> referredCausechildSet = childReferredCauseTypeMap.keySet();
                        final CharSequence[] referredCauseChildItems = referredCausechildSet.toArray(new CharSequence[referredCausechildSet.size()]);
                        if (referredCauseChildItems.length > 0) {
                            chooseChildStatus(referredCauseChildItems, customChildStatusLayoutOne.referredCauseChildET, customChildStatusLayoutOne, customChildInfoLayoutOne, "Referred Cause", "1st");
                        }
                    }
                }
                return false;
            }
        });
        customChildStatusLayoutOne.referredTransportChildET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                if (transportTypeMap != null) {
                    Set<String> referredTransportOfChildSet = transportTypeMap.keySet();
                    final CharSequence[] referredTransportOfChildItems = referredTransportOfChildSet.toArray(new CharSequence[referredTransportOfChildSet.size()]);
                    if (referredTransportOfChildItems.length > 0) {
                        chooseField(referredTransportOfChildItems, customChildStatusLayoutOne.referredTransportChildET, "");
                    }
                }
            }
        });
        customChildStatusLayoutOne.referredAreaChildET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                Set<String> referredAreaOfChildSet = childReferredFacilityTypeMap.keySet();
                CharSequence[] referredAreaOfChildItems = referredAreaOfChildSet.toArray(new CharSequence[referredAreaOfChildSet.size()]);
                if (referredAreaOfChildItems.length > 0) {
                    chooseChildStatus(referredAreaOfChildItems, customChildStatusLayoutOne.referredAreaChildET, customChildStatusLayoutOne, customChildInfoLayoutOne, "Referred Area", "1st");
                }
            }
        });
        customChildStatusLayoutOne.showChildDeathDateTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                showDateTime(customChildStatusLayoutOne.childDeathDateTimeET, "");
            }
        });
        customChildStatusLayoutOne.showlamaDateTimeChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                showDateTime(customChildStatusLayoutOne.lamaDateTimeChildET, "");
            }
        });
    }

    public void getChildStatusTwo() {
        customChildStatusLayoutTwo = new CustomChildStatusLayout(this.getApplicationContext());
        customChildStatusLayoutTwo.addChildStatusTxt.setText(getResources().getString(R.string.child_status_two));
        customChildStatusLayoutTwo.expandCollapseImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (customChildStatusLayoutTwo.childStatusFlag) {
                    customChildStatusLayoutTwo.childStatusFlag = false;
                    customChildStatusLayoutTwo.collapseView.setVisibility(View.GONE);
                    customChildStatusLayoutTwo.expandCollapseImgBtn.setBackgroundResource(R.drawable.expand_arrow);
                } else {
                    customChildStatusLayoutTwo.childStatusFlag = true;
                    customChildStatusLayoutTwo.collapseView.setVisibility(View.VISIBLE);
                    customChildStatusLayoutTwo.expandCollapseImgBtn.setBackgroundResource(R.drawable.collapse_arrow);
                }
            }
        });
        childStatusListHolder.addView(customChildStatusLayoutTwo);

        customChildStatusLayoutTwo.childStatusET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                if (customChildInfoLayoutTwo != null && !customChildInfoLayoutTwo.stillBirthTB.isChecked()) {
                    if (childStatusTypeMap != null) {
                        Set<String> childStatusSet = childStatusTypeMap.keySet();
                        final CharSequence[] childStatusItems = childStatusSet.toArray(new CharSequence[childStatusSet.size()]);
                        if (childStatusItems.length > 0) {
                            chooseChildStatus(childStatusItems, customChildStatusLayoutTwo.childStatusET, customChildStatusLayoutTwo, customChildInfoLayoutTwo, "Child Status", "2nd");
                        }
                    }
                } else {
                    showErrorMessage(getResources().getString(R.string.restriction_adding_child_status_as_child_two_still_birth));
                }
            }
        });
        customChildStatusLayoutTwo.showDischargeDateTimeChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                showDateTime(customChildStatusLayoutTwo.dischargeDateTimeChildET, "");
            }
        });
        customChildStatusLayoutTwo.transportToHomeChildET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                if (transportTypeMap != null) {
                    Set<String> transportChildToHomeSet = transportTypeMap.keySet();
                    final CharSequence[] transportChildToHomeItems = transportChildToHomeSet.toArray(new CharSequence[transportChildToHomeSet.size()]);
                    if (transportChildToHomeItems.length > 0) {
                        chooseField(transportChildToHomeItems, customChildStatusLayoutTwo.transportToHomeChildET, "");
                    }
                }
            }
        });
        customChildStatusLayoutTwo.showReferredDateTimeChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                showDateTime(customChildStatusLayoutTwo.referredDateTimeChildET, "");
            }
        });
        customChildStatusLayoutTwo.referredCauseChildET.setInputType(0);
        customChildStatusLayoutTwo.referredCauseChildET.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    customChildStatusLayoutTwo.referredCauseChildET.setText("");
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(vdrl.getWindowToken(), 0);
                }
            }
        });
        customChildStatusLayoutTwo.referredCauseChildET.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    hideSoftKeyboard();
                    if (childReferredCauseTypeMap != null) {
                        Set<String> referredCausechildSet = childReferredCauseTypeMap.keySet();
                        final CharSequence[] referredCauseChildItems = referredCausechildSet.toArray(new CharSequence[referredCausechildSet.size()]);
                        if (referredCauseChildItems.length > 0) {
                            chooseChildStatus(referredCauseChildItems, customChildStatusLayoutTwo.referredCauseChildET, customChildStatusLayoutTwo, customChildInfoLayoutTwo, "Referred Cause", "2nd");
                        }
                    }
                }
                return false;
            }
        });
        customChildStatusLayoutTwo.referredTransportChildET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                if (transportTypeMap != null) {
                    Set<String> referredTransportOfChildSet = transportTypeMap.keySet();
                    final CharSequence[] referredTransportOfChildItems = referredTransportOfChildSet.toArray(new CharSequence[referredTransportOfChildSet.size()]);
                    if (referredTransportOfChildItems.length > 0) {
                        chooseField(referredTransportOfChildItems, customChildStatusLayoutTwo.referredTransportChildET, "");
                    }
                }
            }
        });
        customChildStatusLayoutTwo.referredAreaChildET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                Set<String> referredAreaOfChildSet = childReferredFacilityTypeMap.keySet();
                CharSequence[] referredAreaOfChildItems = referredAreaOfChildSet.toArray(new CharSequence[referredAreaOfChildSet.size()]);
                if (referredAreaOfChildItems.length > 0) {
                    chooseChildStatus(referredAreaOfChildItems, customChildStatusLayoutTwo.referredAreaChildET, customChildStatusLayoutTwo, customChildInfoLayoutTwo, "Referred Area", "2nd");
                }
            }
        });
        customChildStatusLayoutTwo.showChildDeathDateTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                showDateTime(customChildStatusLayoutTwo.childDeathDateTimeET, "");
            }
        });
        customChildStatusLayoutTwo.showlamaDateTimeChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                showDateTime(customChildStatusLayoutTwo.lamaDateTimeChildET, "");
            }
        });
    }

    public void getChildStatusThree() {
        customChildStatusLayoutThree = new CustomChildStatusLayout(this.getApplicationContext());
        customChildStatusLayoutThree.addChildStatusTxt.setText(getResources().getString(R.string.child_status_three));
        customChildStatusLayoutThree.expandCollapseImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (customChildStatusLayoutThree.childStatusFlag) {
                    customChildStatusLayoutThree.childStatusFlag = false;
                    customChildStatusLayoutThree.collapseView.setVisibility(View.GONE);
                    customChildStatusLayoutThree.expandCollapseImgBtn.setBackgroundResource(R.drawable.expand_arrow);
                } else {
                    customChildStatusLayoutThree.childStatusFlag = true;
                    customChildStatusLayoutThree.collapseView.setVisibility(View.VISIBLE);
                    customChildStatusLayoutThree.expandCollapseImgBtn.setBackgroundResource(R.drawable.collapse_arrow);
                }
            }
        });
        childStatusListHolder.addView(customChildStatusLayoutThree);

        customChildStatusLayoutThree.childStatusET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                if (customChildInfoLayoutThree != null && !customChildInfoLayoutThree.stillBirthTB.isChecked()) {
                    if (childStatusTypeMap != null) {
                        Set<String> childStatusSet = childStatusTypeMap.keySet();
                        final CharSequence[] childStatusItems = childStatusSet.toArray(new CharSequence[childStatusSet.size()]);
                        if (childStatusItems.length > 0) {
                            chooseChildStatus(childStatusItems, customChildStatusLayoutThree.childStatusET, customChildStatusLayoutThree, customChildInfoLayoutThree, "Child Status", "3rd");
                        }
                    }
                } else {
                    showErrorMessage(getResources().getString(R.string.restriction_adding_child_status_as_child_three_still_birth));
                }
            }
        });
        customChildStatusLayoutThree.showDischargeDateTimeChild.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                showDateTime(customChildStatusLayoutThree.dischargeDateTimeChildET, "");
            }
        });
        customChildStatusLayoutThree.transportToHomeChildET.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                if (transportTypeMap != null) {
                    Set<String> transportChildToHomeSet = transportTypeMap.keySet();
                    final CharSequence[] transportChildToHomeItems = transportChildToHomeSet.toArray(new CharSequence[transportChildToHomeSet.size()]);
                    if (transportChildToHomeItems.length > 0) {
                        chooseField(transportChildToHomeItems, customChildStatusLayoutThree.transportToHomeChildET, "");
                    }
                }
            }
        });
        customChildStatusLayoutThree.showReferredDateTimeChild.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                showDateTime(customChildStatusLayoutThree.referredDateTimeChildET, "");
            }
        });
        customChildStatusLayoutThree.referredCauseChildET.setInputType(0);
        customChildStatusLayoutThree.referredCauseChildET.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    customChildStatusLayoutThree.referredCauseChildET.setText("");
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(vdrl.getWindowToken(), 0);
                }
            }
        });
        customChildStatusLayoutThree.referredCauseChildET.setOnTouchListener(new View.OnTouchListener()

        {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    hideSoftKeyboard();
                    if (childReferredCauseTypeMap != null) {
                        Set<String> referredCausechildSet = childReferredCauseTypeMap.keySet();
                        final CharSequence[] referredCauseChildItems = referredCausechildSet.toArray(new CharSequence[referredCausechildSet.size()]);
                        if (referredCauseChildItems.length > 0) {
                            chooseChildStatus(referredCauseChildItems, customChildStatusLayoutThree.referredCauseChildET, customChildStatusLayoutThree, customChildInfoLayoutThree, "Referred Cause", "3rd");
                        }
                    }
                }
                return false;
            }
        });
        customChildStatusLayoutThree.referredTransportChildET.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                if (transportTypeMap != null) {
                    Set<String> referredTransportOfChildSet = transportTypeMap.keySet();
                    final CharSequence[] referredTransportOfChildItems = referredTransportOfChildSet.toArray(new CharSequence[referredTransportOfChildSet.size()]);
                    if (referredTransportOfChildItems.length > 0) {
                        chooseField(referredTransportOfChildItems, customChildStatusLayoutThree.referredTransportChildET, "");
                    }
                }
            }
        });
        customChildStatusLayoutThree.referredAreaChildET.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                Set<String> referredAreaOfChildSet = childReferredFacilityTypeMap.keySet();
                CharSequence[] referredAreaOfChildItems = referredAreaOfChildSet.toArray(new CharSequence[referredAreaOfChildSet.size()]);
                if (referredAreaOfChildItems.length > 0) {
                    chooseChildStatus(referredAreaOfChildItems, customChildStatusLayoutThree.referredAreaChildET, customChildStatusLayoutThree, customChildInfoLayoutThree, "Referred Area", "3rd");
                }
            }
        });
        customChildStatusLayoutThree.showChildDeathDateTime.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                showDateTime(customChildStatusLayoutThree.childDeathDateTimeET, "");
            }
        });
        customChildStatusLayoutThree.showlamaDateTimeChild.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                showDateTime(customChildStatusLayoutThree.lamaDateTimeChildET, "");
            }
        });
    }

    public void getChildStatusFour() {
        customChildStatusLayoutFour = new CustomChildStatusLayout(this.getApplicationContext());
        customChildStatusLayoutFour.addChildStatusTxt.setText(getResources().getString(R.string.child_status_four));
        customChildStatusLayoutFour.expandCollapseImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (customChildStatusLayoutFour.childStatusFlag) {
                    customChildStatusLayoutFour.childStatusFlag = false;
                    customChildStatusLayoutFour.collapseView.setVisibility(View.GONE);
                    customChildStatusLayoutFour.expandCollapseImgBtn.setBackgroundResource(R.drawable.expand_arrow);
                } else {
                    customChildStatusLayoutFour.childStatusFlag = true;
                    customChildStatusLayoutFour.collapseView.setVisibility(View.VISIBLE);
                    customChildStatusLayoutFour.expandCollapseImgBtn.setBackgroundResource(R.drawable.collapse_arrow);
                }
            }
        });
        childStatusListHolder.addView(customChildStatusLayoutFour);

        customChildStatusLayoutFour.childStatusET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                if (customChildInfoLayoutFour != null && !customChildInfoLayoutFour.stillBirthTB.isChecked()) {
                    if (childStatusTypeMap != null) {
                        Set<String> childStatusSet = childStatusTypeMap.keySet();
                        final CharSequence[] childStatusItems = childStatusSet.toArray(new CharSequence[childStatusSet.size()]);
                        if (childStatusItems.length > 0) {
                            chooseChildStatus(childStatusItems, customChildStatusLayoutFour.childStatusET, customChildStatusLayoutFour, customChildInfoLayoutFour, "Child Status", "4th");
                        }
                    }
                } else {
                    showErrorMessage(getResources().getString(R.string.restriction_adding_child_status_as_child_four_still_birth));
                }
            }
        });
        customChildStatusLayoutFour.showDischargeDateTimeChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                showDateTime(customChildStatusLayoutFour.dischargeDateTimeChildET, "");
            }
        });
        customChildStatusLayoutFour.transportToHomeChildET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                if (transportTypeMap != null) {
                    Set<String> transportChildToHomeSet = transportTypeMap.keySet();
                    final CharSequence[] transportChildToHomeItems = transportChildToHomeSet.toArray(new CharSequence[transportChildToHomeSet.size()]);
                    if (transportChildToHomeItems.length > 0) {
                        chooseField(transportChildToHomeItems, customChildStatusLayoutFour.transportToHomeChildET, "");
                    }
                }
            }
        });
        customChildStatusLayoutFour.showReferredDateTimeChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                showDateTime(customChildStatusLayoutFour.referredDateTimeChildET, "");
            }
        });
        customChildStatusLayoutFour.referredCauseChildET.setInputType(0);
        customChildStatusLayoutFour.referredCauseChildET.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    customChildStatusLayoutFour.referredCauseChildET.setText("");
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(vdrl.getWindowToken(), 0);
                }
            }
        });
        customChildStatusLayoutFour.referredCauseChildET.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    hideSoftKeyboard();
                    if (childReferredCauseTypeMap != null) {
                        Set<String> referredCausechildSet = childReferredCauseTypeMap.keySet();
                        final CharSequence[] referredCauseChildItems = referredCausechildSet.toArray(new CharSequence[referredCausechildSet.size()]);
                        if (referredCauseChildItems.length > 0) {
                            chooseChildStatus(referredCauseChildItems, customChildStatusLayoutFour.referredCauseChildET, customChildStatusLayoutFour, customChildInfoLayoutFour, "Referred Cause", "4th");
                        }
                    }
                }
                return false;
            }
        });
        customChildStatusLayoutFour.referredTransportChildET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                if (transportTypeMap != null) {
                    Set<String> referredTransportOfChildSet = transportTypeMap.keySet();
                    final CharSequence[] referredTransportOfChildItems = referredTransportOfChildSet.toArray(new CharSequence[referredTransportOfChildSet.size()]);
                    if (referredTransportOfChildItems.length > 0) {
                        chooseField(referredTransportOfChildItems, customChildStatusLayoutFour.referredTransportChildET, "");
                    }
                }
            }
        });
        customChildStatusLayoutFour.referredAreaChildET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                Set<String> referredAreaOfChildSet = childReferredFacilityTypeMap.keySet();
                CharSequence[] referredAreaOfChildItems = referredAreaOfChildSet.toArray(new CharSequence[referredAreaOfChildSet.size()]);
                if (referredAreaOfChildItems.length > 0) {
                    chooseChildStatus(referredAreaOfChildItems, customChildStatusLayoutFour.referredAreaChildET, customChildStatusLayoutFour, customChildInfoLayoutThree, "Referred Area", "4th");
                }
            }
        });
        customChildStatusLayoutFour.showChildDeathDateTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                showDateTime(customChildStatusLayoutFour.childDeathDateTimeET, "");
            }
        });
        customChildStatusLayoutFour.showlamaDateTimeChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                showDateTime(customChildStatusLayoutFour.lamaDateTimeChildET, "");
            }
        });
    }

    public void getChildStatusFive() {
        customChildStatusLayoutFive = new CustomChildStatusLayout(this.getApplicationContext());
        customChildStatusLayoutFive.addChildStatusTxt.setText(getResources().getString(R.string.child_status_five));
        customChildStatusLayoutFive.expandCollapseImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (customChildStatusLayoutFive.childStatusFlag) {
                    customChildStatusLayoutFive.childStatusFlag = false;
                    customChildStatusLayoutFive.collapseView.setVisibility(View.GONE);
                    customChildStatusLayoutFive.expandCollapseImgBtn.setBackgroundResource(R.drawable.expand_arrow);
                } else {
                    customChildStatusLayoutFive.childStatusFlag = true;
                    customChildStatusLayoutFive.collapseView.setVisibility(View.VISIBLE);
                    customChildStatusLayoutFive.expandCollapseImgBtn.setBackgroundResource(R.drawable.collapse_arrow);
                }
            }
        });
        childStatusListHolder.addView(customChildStatusLayoutFive);

        customChildStatusLayoutFive.childStatusET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                if (customChildInfoLayoutFive != null && !customChildInfoLayoutFive.stillBirthTB.isChecked()) {
                    if (childStatusTypeMap != null) {
                        Set<String> childStatusSet = childStatusTypeMap.keySet();
                        final CharSequence[] childStatusItems = childStatusSet.toArray(new CharSequence[childStatusSet.size()]);
                        if (childStatusItems.length > 0) {
                            chooseChildStatus(childStatusItems, customChildStatusLayoutFive.childStatusET, customChildStatusLayoutFive, customChildInfoLayoutFive, "Child Status", "5th");
                        }
                    }
                } else {
                    showErrorMessage(getResources().getString(R.string.restriction_adding_child_status_as_child_five_still_birth));
                }
            }
        });
        customChildStatusLayoutFive.showDischargeDateTimeChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                showDateTime(customChildStatusLayoutFive.dischargeDateTimeChildET, "");
            }
        });
        customChildStatusLayoutFive.transportToHomeChildET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                if (transportTypeMap != null) {
                    Set<String> transportChildToHomeSet = transportTypeMap.keySet();
                    final CharSequence[] transportChildToHomeItems = transportChildToHomeSet.toArray(new CharSequence[transportChildToHomeSet.size()]);
                    if (transportChildToHomeItems.length > 0) {
                        chooseField(transportChildToHomeItems, customChildStatusLayoutFive.transportToHomeChildET, "");
                    }
                }
            }
        });
        customChildStatusLayoutFive.showReferredDateTimeChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                showDateTime(customChildStatusLayoutFive.referredDateTimeChildET, "");
            }
        });
        customChildStatusLayoutFive.referredCauseChildET.setInputType(0);
        customChildStatusLayoutFive.referredCauseChildET.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    customChildStatusLayoutFive.referredCauseChildET.setText("");
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(vdrl.getWindowToken(), 0);
                }
            }
        });
        customChildStatusLayoutFive.referredCauseChildET.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    hideSoftKeyboard();
                    if (childReferredCauseTypeMap != null) {
                        Set<String> referredCausechildSet = childReferredCauseTypeMap.keySet();
                        final CharSequence[] referredCauseChildItems = referredCausechildSet.toArray(new CharSequence[referredCausechildSet.size()]);
                        if (referredCauseChildItems.length > 0) {
                            chooseChildStatus(referredCauseChildItems, customChildStatusLayoutFive.referredCauseChildET, customChildStatusLayoutFive, customChildInfoLayoutFive, "Referred Cause", "5th");
                        }
                    }
                }
                return false;
            }
        });
        customChildStatusLayoutFive.referredTransportChildET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                if (transportTypeMap != null) {
                    Set<String> referredTransportOfChildSet = transportTypeMap.keySet();
                    final CharSequence[] referredTransportOfChildItems = referredTransportOfChildSet.toArray(new CharSequence[referredTransportOfChildSet.size()]);
                    if (referredTransportOfChildItems.length > 0) {
                        chooseField(referredTransportOfChildItems, customChildStatusLayoutFive.referredTransportChildET, "");
                    }
                }
            }
        });
        customChildStatusLayoutFive.referredAreaChildET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                Set<String> referredAreaOfChildSet = childReferredFacilityTypeMap.keySet();
                CharSequence[] referredAreaOfChildItems = referredAreaOfChildSet.toArray(new CharSequence[referredAreaOfChildSet.size()]);
                if (referredAreaOfChildItems.length > 0) {
                    chooseChildStatus(referredAreaOfChildItems, customChildStatusLayoutFive.referredAreaChildET, customChildStatusLayoutFive, customChildInfoLayoutFive, "Referred Area", "5th");
                }
            }
        });
        customChildStatusLayoutFive.showChildDeathDateTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                showDateTime(customChildStatusLayoutFive.childDeathDateTimeET, "");
            }
        });
        customChildStatusLayoutFive.showlamaDateTimeChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                showDateTime(customChildStatusLayoutFive.lamaDateTimeChildET, "");
            }
        });
    }

    public void getChildStatusSix() {
        customChildStatusLayoutSix = new CustomChildStatusLayout(this.getApplicationContext());
        customChildStatusLayoutSix.addChildStatusTxt.setText(getResources().getString(R.string.child_status_six));
        customChildStatusLayoutSix.expandCollapseImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (customChildStatusLayoutSix.childStatusFlag) {
                    customChildStatusLayoutSix.childStatusFlag = false;
                    customChildStatusLayoutSix.collapseView.setVisibility(View.GONE);
                    customChildStatusLayoutSix.expandCollapseImgBtn.setBackgroundResource(R.drawable.expand_arrow);
                } else {
                    customChildStatusLayoutSix.childStatusFlag = true;
                    customChildStatusLayoutSix.collapseView.setVisibility(View.VISIBLE);
                    customChildStatusLayoutSix.expandCollapseImgBtn.setBackgroundResource(R.drawable.collapse_arrow);
                }
            }
        });
        childStatusListHolder.addView(customChildStatusLayoutSix);

        customChildStatusLayoutSix.childStatusET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                if (customChildInfoLayoutSix != null && !customChildInfoLayoutSix.stillBirthTB.isChecked()) {
                    if (childStatusTypeMap != null) {
                        Set<String> childStatusSet = childStatusTypeMap.keySet();
                        final CharSequence[] childStatusItems = childStatusSet.toArray(new CharSequence[childStatusSet.size()]);
                        if (childStatusItems.length > 0) {
                            chooseChildStatus(childStatusItems, customChildStatusLayoutSix.childStatusET, customChildStatusLayoutSix, customChildInfoLayoutSix, "Child Status", "6th");
                        }
                    }
                } else {
                    showErrorMessage(getResources().getString(R.string.restriction_adding_child_status_as_child_six_still_birth));
                }
            }
        });
        customChildStatusLayoutSix.showDischargeDateTimeChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                showDateTime(customChildStatusLayoutSix.dischargeDateTimeChildET, "");
            }
        });
        customChildStatusLayoutSix.transportToHomeChildET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                if (transportTypeMap != null) {
                    Set<String> transportChildToHomeSet = transportTypeMap.keySet();
                    final CharSequence[] transportChildToHomeItems = transportChildToHomeSet.toArray(new CharSequence[transportChildToHomeSet.size()]);
                    if (transportChildToHomeItems.length > 0) {
                        chooseField(transportChildToHomeItems, customChildStatusLayoutSix.transportToHomeChildET, "");
                    }
                }
            }
        });
        customChildStatusLayoutSix.showReferredDateTimeChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                showDateTime(customChildStatusLayoutSix.referredDateTimeChildET, "");
            }
        });
        customChildStatusLayoutSix.referredCauseChildET.setInputType(0);
        customChildStatusLayoutSix.referredCauseChildET.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    customChildStatusLayoutSix.referredCauseChildET.setText("");
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(vdrl.getWindowToken(), 0);
                }
            }
        });
        customChildStatusLayoutSix.referredCauseChildET.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    hideSoftKeyboard();
                    if (childReferredCauseTypeMap != null) {
                        Set<String> referredCausechildSet = childReferredCauseTypeMap.keySet();
                        final CharSequence[] referredCauseChildItems = referredCausechildSet.toArray(new CharSequence[referredCausechildSet.size()]);
                        if (referredCauseChildItems.length > 0) {
                            chooseChildStatus(referredCauseChildItems, customChildStatusLayoutSix.referredCauseChildET, customChildStatusLayoutSix, customChildInfoLayoutSix, "Referred Cause", "6th");
                        }
                    }
                }
                return false;
            }
        });
        customChildStatusLayoutSix.referredTransportChildET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                if (transportTypeMap != null) {
                    Set<String> referredTransportOfChildSet = transportTypeMap.keySet();
                    final CharSequence[] referredTransportOfChildItems = referredTransportOfChildSet.toArray(new CharSequence[referredTransportOfChildSet.size()]);
                    if (referredTransportOfChildItems.length > 0) {
                        chooseField(referredTransportOfChildItems, customChildStatusLayoutSix.referredTransportChildET, "");
                    }
                }
            }
        });
        customChildStatusLayoutSix.referredAreaChildET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                Set<String> referredAreaOfChildSet = childReferredFacilityTypeMap.keySet();
                CharSequence[] referredAreaOfChildItems = referredAreaOfChildSet.toArray(new CharSequence[referredAreaOfChildSet.size()]);
                if (referredAreaOfChildItems.length > 0) {
                    chooseChildStatus(referredAreaOfChildItems, customChildStatusLayoutSix.referredAreaChildET, customChildStatusLayoutSix, customChildInfoLayoutSix, "Referred Area", "6th");
                }
            }
        });
        customChildStatusLayoutSix.showChildDeathDateTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                showDateTime(customChildStatusLayoutSix.childDeathDateTimeET, "");
            }
        });
        customChildStatusLayoutSix.showlamaDateTimeChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                showDateTime(customChildStatusLayoutSix.lamaDateTimeChildET, "");
            }
        });
    }

    public void getChildStatusSeven() {
        customChildStatusLayoutSeven = new CustomChildStatusLayout(this.getApplicationContext());
        customChildStatusLayoutSeven.addChildStatusTxt.setText(getResources().getString(R.string.child_status_seven));
        customChildStatusLayoutSeven.expandCollapseImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (customChildStatusLayoutSeven.childStatusFlag) {
                    customChildStatusLayoutSeven.childStatusFlag = false;
                    customChildStatusLayoutSeven.collapseView.setVisibility(View.GONE);
                    customChildStatusLayoutSeven.expandCollapseImgBtn.setBackgroundResource(R.drawable.expand_arrow);
                } else {
                    customChildStatusLayoutSeven.childStatusFlag = true;
                    customChildStatusLayoutSeven.collapseView.setVisibility(View.VISIBLE);
                    customChildStatusLayoutSeven.expandCollapseImgBtn.setBackgroundResource(R.drawable.collapse_arrow);
                }
            }
        });
        childStatusListHolder.addView(customChildStatusLayoutSeven);

        customChildStatusLayoutSeven.childStatusET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                if (customChildInfoLayoutSeven != null && !customChildInfoLayoutSeven.stillBirthTB.isChecked()) {
                    if (childStatusTypeMap != null) {
                        Set<String> childStatusSet = childStatusTypeMap.keySet();
                        final CharSequence[] childStatusItems = childStatusSet.toArray(new CharSequence[childStatusSet.size()]);
                        if (childStatusItems.length > 0) {
                            chooseChildStatus(childStatusItems, customChildStatusLayoutSeven.childStatusET, customChildStatusLayoutSeven, customChildInfoLayoutSeven, "Child Status", "7th");
                        }
                    }
                } else {
                    showErrorMessage(getResources().getString(R.string.restriction_adding_child_status_as_child_seven_still_birth));
                }
            }
        });
        customChildStatusLayoutSeven.showDischargeDateTimeChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                showDateTime(customChildStatusLayoutSeven.dischargeDateTimeChildET, "");
            }
        });
        customChildStatusLayoutSeven.transportToHomeChildET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                if (transportTypeMap != null) {
                    Set<String> transportChildToHomeSet = transportTypeMap.keySet();
                    final CharSequence[] transportChildToHomeItems = transportChildToHomeSet.toArray(new CharSequence[transportChildToHomeSet.size()]);
                    if (transportChildToHomeItems.length > 0) {
                        chooseField(transportChildToHomeItems, customChildStatusLayoutSeven.transportToHomeChildET, "");
                    }
                }
            }
        });
        customChildStatusLayoutSeven.showReferredDateTimeChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                showDateTime(customChildStatusLayoutSeven.referredDateTimeChildET, "");
            }
        });
        customChildStatusLayoutSeven.referredCauseChildET.setInputType(0);
        customChildStatusLayoutSeven.referredCauseChildET.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    customChildStatusLayoutSeven.referredCauseChildET.setText("");
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(vdrl.getWindowToken(), 0);
                }
            }
        });
        customChildStatusLayoutSeven.referredCauseChildET.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    hideSoftKeyboard();
                    if (childReferredCauseTypeMap != null) {
                        Set<String> referredCausechildSet = childReferredCauseTypeMap.keySet();
                        final CharSequence[] referredCauseChildItems = referredCausechildSet.toArray(new CharSequence[referredCausechildSet.size()]);
                        if (referredCauseChildItems.length > 0) {
                            chooseChildStatus(referredCauseChildItems, customChildStatusLayoutSeven.referredCauseChildET, customChildStatusLayoutSeven, customChildInfoLayoutSeven, "Referred Cause", "7th");
                        }
                    }
                }
                return false;
            }
        });
        customChildStatusLayoutSeven.referredTransportChildET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                if (transportTypeMap != null) {
                    Set<String> referredTransportOfChildSet = transportTypeMap.keySet();
                    final CharSequence[] referredTransportOfChildItems = referredTransportOfChildSet.toArray(new CharSequence[referredTransportOfChildSet.size()]);
                    if (referredTransportOfChildItems.length > 0) {
                        chooseField(referredTransportOfChildItems, customChildStatusLayoutSeven.referredTransportChildET, "");
                    }
                }
            }
        });
        customChildStatusLayoutSeven.referredAreaChildET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                Set<String> referredAreaOfChildSet = childReferredFacilityTypeMap.keySet();
                CharSequence[] referredAreaOfChildItems = referredAreaOfChildSet.toArray(new CharSequence[referredAreaOfChildSet.size()]);
                if (referredAreaOfChildItems.length > 0) {
                    chooseChildStatus(referredAreaOfChildItems, customChildStatusLayoutSeven.referredAreaChildET, customChildStatusLayoutSeven, customChildInfoLayoutSeven, "Referred Area", "7th");
                }
            }
        });
        customChildStatusLayoutSeven.showChildDeathDateTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                showDateTime(customChildStatusLayoutSeven.childDeathDateTimeET, "");
            }
        });
        customChildStatusLayoutSeven.showlamaDateTimeChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                showDateTime(customChildStatusLayoutSeven.lamaDateTimeChildET, "");
            }
        });
    }

    public void getChildStatusEight() {
        customChildStatusLayoutEight = new CustomChildStatusLayout(this.getApplicationContext());
        customChildStatusLayoutEight.addChildStatusTxt.setText(getResources().getString(R.string.child_status_eight));
        customChildStatusLayoutEight.expandCollapseImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (customChildStatusLayoutEight.childStatusFlag) {
                    customChildStatusLayoutEight.childStatusFlag = false;
                    customChildStatusLayoutEight.collapseView.setVisibility(View.GONE);
                    customChildStatusLayoutEight.expandCollapseImgBtn.setBackgroundResource(R.drawable.expand_arrow);
                } else {
                    customChildStatusLayoutEight.childStatusFlag = true;
                    customChildStatusLayoutEight.collapseView.setVisibility(View.VISIBLE);
                    customChildStatusLayoutEight.expandCollapseImgBtn.setBackgroundResource(R.drawable.collapse_arrow);
                }
            }
        });
        childStatusListHolder.addView(customChildStatusLayoutEight);

        customChildStatusLayoutEight.childStatusET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                if (customChildInfoLayoutEight != null && !customChildInfoLayoutEight.stillBirthTB.isChecked()) {
                    if (childStatusTypeMap != null) {
                        Set<String> childStatusSet = childStatusTypeMap.keySet();
                        final CharSequence[] childStatusItems = childStatusSet.toArray(new CharSequence[childStatusSet.size()]);
                        if (childStatusItems.length > 0) {
                            chooseChildStatus(childStatusItems, customChildStatusLayoutEight.childStatusET, customChildStatusLayoutEight, customChildInfoLayoutEight, "Child Status", "8th");
                        }
                    }
                } else {
                    showErrorMessage(getResources().getString(R.string.restriction_adding_child_status_as_child_eight_still_birth));
                }
            }
        });
        customChildStatusLayoutEight.showDischargeDateTimeChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                showDateTime(customChildStatusLayoutEight.dischargeDateTimeChildET, "");
            }
        });
        customChildStatusLayoutEight.transportToHomeChildET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                if (transportTypeMap != null) {
                    Set<String> transportChildToHomeSet = transportTypeMap.keySet();
                    final CharSequence[] transportChildToHomeItems = transportChildToHomeSet.toArray(new CharSequence[transportChildToHomeSet.size()]);
                    if (transportChildToHomeItems.length > 0) {
                        chooseField(transportChildToHomeItems, customChildStatusLayoutEight.transportToHomeChildET, "");
                    }
                }
            }
        });
        customChildStatusLayoutEight.showReferredDateTimeChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                showDateTime(customChildStatusLayoutEight.referredDateTimeChildET, "");
            }
        });
        customChildStatusLayoutEight.referredCauseChildET.setInputType(0);
        customChildStatusLayoutEight.referredCauseChildET.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    customChildStatusLayoutEight.referredCauseChildET.setText("");
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(vdrl.getWindowToken(), 0);
                }
            }
        });
        customChildStatusLayoutEight.referredCauseChildET.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    hideSoftKeyboard();
                    if (childReferredCauseTypeMap != null) {
                        Set<String> referredCausechildSet = childReferredCauseTypeMap.keySet();
                        final CharSequence[] referredCauseChildItems = referredCausechildSet.toArray(new CharSequence[referredCausechildSet.size()]);
                        if (referredCauseChildItems.length > 0) {
                            chooseChildStatus(referredCauseChildItems, customChildStatusLayoutEight.referredCauseChildET, customChildStatusLayoutEight, customChildInfoLayoutEight, "Referred Cause", "8th");
                        }
                    }
                }
                return false;
            }
        });
        customChildStatusLayoutEight.referredTransportChildET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                if (transportTypeMap != null) {
                    Set<String> referredTransportOfChildSet = transportTypeMap.keySet();
                    final CharSequence[] referredTransportOfChildItems = referredTransportOfChildSet.toArray(new CharSequence[referredTransportOfChildSet.size()]);
                    if (referredTransportOfChildItems.length > 0) {
                        chooseField(referredTransportOfChildItems, customChildStatusLayoutEight.referredTransportChildET, "");
                    }
                }
            }
        });
        customChildStatusLayoutEight.referredAreaChildET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                Set<String> referredAreaOfChildSet = childReferredFacilityTypeMap.keySet();
                CharSequence[] referredAreaOfChildItems = referredAreaOfChildSet.toArray(new CharSequence[referredAreaOfChildSet.size()]);
                if (referredAreaOfChildItems.length > 0) {
                    chooseChildStatus(referredAreaOfChildItems, customChildStatusLayoutEight.referredAreaChildET, customChildStatusLayoutEight, customChildInfoLayoutEight, "Referred Area", "8th");
                }
            }
        });
        customChildStatusLayoutEight.showChildDeathDateTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                showDateTime(customChildStatusLayoutEight.childDeathDateTimeET, "");
            }
        });
        customChildStatusLayoutEight.showlamaDateTimeChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                showDateTime(customChildStatusLayoutEight.lamaDateTimeChildET, "");
            }
        });
    }

    public void getChildStatusNine() {
        customChildStatusLayoutNine = new CustomChildStatusLayout(this.getApplicationContext());
        customChildStatusLayoutNine.addChildStatusTxt.setText(getResources().getString(R.string.child_status_nine));
        customChildStatusLayoutNine.expandCollapseImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (customChildStatusLayoutNine.childStatusFlag) {
                    customChildStatusLayoutNine.childStatusFlag = false;
                    customChildStatusLayoutNine.collapseView.setVisibility(View.GONE);
                    customChildStatusLayoutNine.expandCollapseImgBtn.setBackgroundResource(R.drawable.expand_arrow);
                } else {
                    customChildStatusLayoutNine.childStatusFlag = true;
                    customChildStatusLayoutNine.collapseView.setVisibility(View.VISIBLE);
                    customChildStatusLayoutNine.expandCollapseImgBtn.setBackgroundResource(R.drawable.collapse_arrow);
                }
            }
        });
        childStatusListHolder.addView(customChildStatusLayoutNine);

        customChildStatusLayoutNine.childStatusET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                if (customChildInfoLayoutNine != null && !customChildInfoLayoutNine.stillBirthTB.isChecked()) {
                    if (childStatusTypeMap != null) {
                        Set<String> childStatusSet = childStatusTypeMap.keySet();
                        final CharSequence[] childStatusItems = childStatusSet.toArray(new CharSequence[childStatusSet.size()]);
                        if (childStatusItems.length > 0) {
                            chooseChildStatus(childStatusItems, customChildStatusLayoutNine.childStatusET, customChildStatusLayoutNine, customChildInfoLayoutNine, "Child Status", "9th");
                        }
                    }
                } else {
                    showErrorMessage(getResources().getString(R.string.restriction_adding_child_status_as_child_nine_still_birth));
                }
            }
        });
        customChildStatusLayoutNine.showDischargeDateTimeChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                showDateTime(customChildStatusLayoutNine.dischargeDateTimeChildET, "");
            }
        });
        customChildStatusLayoutNine.transportToHomeChildET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                if (transportTypeMap != null) {
                    Set<String> transportChildToHomeSet = transportTypeMap.keySet();
                    final CharSequence[] transportChildToHomeItems = transportChildToHomeSet.toArray(new CharSequence[transportChildToHomeSet.size()]);
                    if (transportChildToHomeItems.length > 0) {
                        chooseField(transportChildToHomeItems, customChildStatusLayoutNine.transportToHomeChildET, "");
                    }
                }
            }
        });
        customChildStatusLayoutNine.showReferredDateTimeChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                showDateTime(customChildStatusLayoutNine.referredDateTimeChildET, "");
            }
        });
        customChildStatusLayoutNine.referredCauseChildET.setInputType(0);
        customChildStatusLayoutNine.referredCauseChildET.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    customChildStatusLayoutEight.referredCauseChildET.setText("");
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(vdrl.getWindowToken(), 0);
                }
            }
        });
        customChildStatusLayoutNine.referredCauseChildET.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    hideSoftKeyboard();
                    if (childReferredCauseTypeMap != null) {
                        Set<String> referredCausechildSet = childReferredCauseTypeMap.keySet();
                        final CharSequence[] referredCauseChildItems = referredCausechildSet.toArray(new CharSequence[referredCausechildSet.size()]);
                        if (referredCauseChildItems.length > 0) {
                            chooseChildStatus(referredCauseChildItems, customChildStatusLayoutNine.referredCauseChildET, customChildStatusLayoutNine, customChildInfoLayoutNine, "Referred Cause", "9th");
                        }
                    }
                }
                return false;
            }
        });
        customChildStatusLayoutNine.referredTransportChildET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                if (transportTypeMap != null) {
                    Set<String> referredTransportOfChildSet = transportTypeMap.keySet();
                    final CharSequence[] referredTransportOfChildItems = referredTransportOfChildSet.toArray(new CharSequence[referredTransportOfChildSet.size()]);
                    if (referredTransportOfChildItems.length > 0) {
                        chooseField(referredTransportOfChildItems, customChildStatusLayoutNine.referredTransportChildET, "");
                    }
                }
            }
        });
        customChildStatusLayoutNine.referredAreaChildET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                Set<String> referredAreaOfChildSet = childReferredFacilityTypeMap.keySet();
                CharSequence[] referredAreaOfChildItems = referredAreaOfChildSet.toArray(new CharSequence[referredAreaOfChildSet.size()]);
                if (referredAreaOfChildItems.length > 0) {
                    chooseChildStatus(referredAreaOfChildItems, customChildStatusLayoutNine.referredAreaChildET, customChildStatusLayoutNine, customChildInfoLayoutNine, "Referred Area", "9th");
                }
            }
        });
        customChildStatusLayoutNine.showChildDeathDateTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                showDateTime(customChildStatusLayoutNine.childDeathDateTimeET, "");
            }
        });
        customChildStatusLayoutNine.showlamaDateTimeChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                showDateTime(customChildStatusLayoutNine.lamaDateTimeChildET, "");
            }
        });
    }

    public void getChildStatusTen() {
        customChildStatusLayoutTen = new CustomChildStatusLayout(this.getApplicationContext());
        customChildStatusLayoutTen.addChildStatusTxt.setText(getResources().getString(R.string.child_status_ten));
        customChildStatusLayoutTen.expandCollapseImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (customChildStatusLayoutTen.childStatusFlag) {
                    customChildStatusLayoutTen.childStatusFlag = false;
                    customChildStatusLayoutTen.collapseView.setVisibility(View.GONE);
                    customChildStatusLayoutTen.expandCollapseImgBtn.setBackgroundResource(R.drawable.expand_arrow);
                } else {
                    customChildStatusLayoutTen.childStatusFlag = true;
                    customChildStatusLayoutTen.collapseView.setVisibility(View.VISIBLE);
                    customChildStatusLayoutTen.expandCollapseImgBtn.setBackgroundResource(R.drawable.collapse_arrow);
                }
            }
        });
        childStatusListHolder.addView(customChildStatusLayoutTen);

        customChildStatusLayoutTen.childStatusET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                if (customChildInfoLayoutTen != null && !customChildInfoLayoutTen.stillBirthTB.isChecked()) {
                    if (childStatusTypeMap != null) {
                        Set<String> childStatusSet = childStatusTypeMap.keySet();
                        final CharSequence[] childStatusItems = childStatusSet.toArray(new CharSequence[childStatusSet.size()]);
                        if (childStatusItems.length > 0) {
                            chooseChildStatus(childStatusItems, customChildStatusLayoutTen.childStatusET, customChildStatusLayoutTen, customChildInfoLayoutTen, "Child Status", "10th");
                        }
                    }
                } else {
                    showErrorMessage(getResources().getString(R.string.restriction_adding_child_status_as_child_ten_still_birth));
                }
            }
        });
        customChildStatusLayoutTen.showDischargeDateTimeChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                showDateTime(customChildStatusLayoutTen.dischargeDateTimeChildET, "");
            }
        });
        customChildStatusLayoutTen.transportToHomeChildET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                if (transportTypeMap != null) {
                    Set<String> transportChildToHomeSet = transportTypeMap.keySet();
                    final CharSequence[] transportChildToHomeItems = transportChildToHomeSet.toArray(new CharSequence[transportChildToHomeSet.size()]);
                    if (transportChildToHomeItems.length > 0) {
                        chooseField(transportChildToHomeItems, customChildStatusLayoutTen.transportToHomeChildET, "");
                    }
                }
            }
        });
        customChildStatusLayoutTen.showReferredDateTimeChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                showDateTime(customChildStatusLayoutTen.referredDateTimeChildET, "");
            }
        });
        customChildStatusLayoutTen.referredCauseChildET.setInputType(0);
        customChildStatusLayoutTen.referredCauseChildET.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    customChildStatusLayoutTen.referredCauseChildET.setText("");
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(vdrl.getWindowToken(), 0);
                }
            }
        });
        customChildStatusLayoutTen.referredCauseChildET.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    hideSoftKeyboard();
                    if (childReferredCauseTypeMap != null) {
                        Set<String> referredCausechildSet = childReferredCauseTypeMap.keySet();
                        final CharSequence[] referredCauseChildItems = referredCausechildSet.toArray(new CharSequence[referredCausechildSet.size()]);
                        if (referredCauseChildItems.length > 0) {
                            chooseChildStatus(referredCauseChildItems, customChildStatusLayoutTen.referredCauseChildET, customChildStatusLayoutTen, customChildInfoLayoutTen, "Referred Cause", "10th");
                        }
                    }
                }
                return false;
            }
        });
        customChildStatusLayoutTen.referredTransportChildET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                if (transportTypeMap != null) {
                    Set<String> referredTransportOfChildSet = transportTypeMap.keySet();
                    final CharSequence[] referredTransportOfChildItems = referredTransportOfChildSet.toArray(new CharSequence[referredTransportOfChildSet.size()]);
                    if (referredTransportOfChildItems.length > 0) {
                        chooseField(referredTransportOfChildItems, customChildStatusLayoutTen.referredTransportChildET, "");
                    }
                }
            }
        });
        customChildStatusLayoutTen.referredAreaChildET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                Set<String> referredAreaOfChildSet = childReferredFacilityTypeMap.keySet();
                CharSequence[] referredAreaOfChildItems = referredAreaOfChildSet.toArray(new CharSequence[referredAreaOfChildSet.size()]);
                if (referredAreaOfChildItems.length > 0) {
                    chooseChildStatus(referredAreaOfChildItems, customChildStatusLayoutTen.referredAreaChildET, customChildStatusLayoutTen, customChildInfoLayoutTen, "Referred Area", "10th");
                }
            }
        });
        customChildStatusLayoutTen.showChildDeathDateTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                showDateTime(customChildStatusLayoutTen.childDeathDateTimeET, "");
            }
        });
        customChildStatusLayoutTen.showlamaDateTimeChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard();
                showDateTime(customChildStatusLayoutTen.lamaDateTimeChildET, "");
            }
        });
    }

    public void clearChildStatusFields(CustomChildStatusLayout customChildStatusLayout) {
        if (customChildStatusLayout != null) {
            customChildStatusLayout.childStatusET.setText("");
            customChildStatusLayout.childDischargeLayout.setVisibility(View.GONE);
            customChildStatusLayout.childReferredLayout.setVisibility(View.GONE);
            customChildStatusLayout.childLamaDateTimeLayout.setVisibility(View.GONE);
            customChildStatusLayout.childDeadLayout.setVisibility(View.GONE);

            clearChildDischargedFields(customChildStatusLayout);
            clearChildReferredFields(customChildStatusLayout);
            clearChildLamaFields(customChildStatusLayout);
            clearChildDeadFields(customChildStatusLayout);
        }
    }

    public void chooseChildStatus(final CharSequence[] items, final EditText editText, final CustomChildStatusLayout customChildStatusLayout, final CustomChildInfoLayout customChildInfoLayout, final String type, final String count) {
        if (getWindow().getCurrentFocus() != null) {
            getWindow().getCurrentFocus().clearFocus();
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose");
        String selectedText = editText.getText().toString().trim();
        int slectedIndex = 0;
        if (!selectedText.equals("")) {
            for (CharSequence item : items) {
                if (item.toString().trim().equals(selectedText)) {
                    break;
                }
                slectedIndex++;
            }
        }

        builder.setSingleChoiceItems(items, slectedIndex,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int item) {
                    }
                })
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        int selectedPosition = ((AlertDialog) dialog)
                                .getListView().getCheckedItemPosition();
                        String value = items[selectedPosition].toString();
                        editText.setText(value);
                        if (value != null) {
                            switch (type) {
                                case "Child Status":
                                    switch (childStatusTypeMap.get(value)) {
                                        case CHILD_STATUS_DISCHARGED_TYPE_DETAIL_ID:
                                            customChildStatusLayout.childDischargeLayout.setVisibility(View.VISIBLE);
                                            customChildStatusLayout.childReferredLayout.setVisibility(View.GONE);
                                            customChildStatusLayout.childLamaDateTimeLayout.setVisibility(View.GONE);
                                            customChildStatusLayout.childDeadLayout.setVisibility(View.GONE);

                                            clearChildReferredFields(customChildStatusLayout);
                                            clearChildLamaFields(customChildStatusLayout);
                                            clearChildDeadFields(customChildStatusLayout);
                                            break;
                                        case CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID:
                                            customChildStatusLayout.childDischargeLayout.setVisibility(View.GONE);
                                            customChildStatusLayout.childReferredLayout.setVisibility(View.VISIBLE);
                                            customChildStatusLayout.childLamaDateTimeLayout.setVisibility(View.GONE);
                                            customChildStatusLayout.childDeadLayout.setVisibility(View.GONE);

                                            clearChildDischargedFields(customChildStatusLayout);
                                            clearChildLamaFields(customChildStatusLayout);
                                            clearChildDeadFields(customChildStatusLayout);
                                            break;
                                        case CHILD_STATUS_DEATH_TYPE_DETAIL_ID:
                                            customChildStatusLayout.childDischargeLayout.setVisibility(View.GONE);
                                            customChildStatusLayout.childReferredLayout.setVisibility(View.GONE);
                                            customChildStatusLayout.childLamaDateTimeLayout.setVisibility(View.GONE);
                                            customChildStatusLayout.childDeadLayout.setVisibility(View.VISIBLE);

                                            clearChildDischargedFields(customChildStatusLayout);
                                            clearChildReferredFields(customChildStatusLayout);
                                            clearChildLamaFields(customChildStatusLayout);
                                            break;
                                        case CHILD_STATUS_LAMA_TYPE_DETAIL_ID:
                                            customChildStatusLayout.childDischargeLayout.setVisibility(View.GONE);
                                            customChildStatusLayout.childReferredLayout.setVisibility(View.GONE);
                                            customChildStatusLayout.childLamaDateTimeLayout.setVisibility(View.VISIBLE);
                                            customChildStatusLayout.childDeadLayout.setVisibility(View.GONE);

                                            clearChildDischargedFields(customChildStatusLayout);
                                            clearChildReferredFields(customChildStatusLayout);
                                            clearChildDeadFields(customChildStatusLayout);
                                            break;
                                        default:
                                            break;
                                    }
                                    break;
                                case "Referred Cause":
                                    switch (childReferredCauseTypeMap.get(value)) {
                                        case OTHER_REFERRED_CAUSE_CHILD_TYPE_DETAILS_ID:
                                            customChildStatusLayout.childReferredOtherCauseET.setVisibility(View.VISIBLE);
                                            break;
                                        default:
                                            customChildStatusLayout.childReferredOtherCauseET.setVisibility(View.GONE);
                                            customChildStatusLayout.childReferredOtherCauseET.setText("");
                                            break;
                                    }
                                    break;
                                case "Referred Area":
                                    switch (childReferredFacilityTypeMap.get(value)) {
                                        case OTHER_REFERRED_TO_CHILD_TYPE_DETAILS_ID:
                                            customChildStatusLayout.referredOtherAreaChildET.setVisibility(View.VISIBLE);
                                            break;
                                        default:
                                            customChildStatusLayout.referredOtherAreaChildET.setVisibility(View.GONE);
                                            customChildStatusLayout.referredOtherAreaChildET.setText("");
                                            break;
                                    }
                                    break;
                                default:
                                    break;
                            }
                        }
                    }
                })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.dismiss();
                            }
                        });

        AlertDialog alert = builder.create();
        alert.show();
    }
}
