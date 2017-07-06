package org.sdrc.lrcasemanagement.activity;

import android.app.DatePickerDialog;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.sdrc.lrcasemanagement.R;
import org.sdrc.lrcasemanagement.model.ChildModel;
import org.sdrc.lrcasemanagement.model.realmmodel.Child;
import org.sdrc.lrcasemanagement.model.realmmodel.ChildStatus;
import org.sdrc.lrcasemanagement.model.realmmodel.Patient;
import org.sdrc.lrcasemanagement.util.Constant;
import org.sdrc.lrcasemanagement.util.LRCM;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

public class SummaryActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView startDatePicker, endDatePicker;
    private TextView caseOpened, caseClosed, deliveryCount, totalCase, referredIn, referredOut, noOfCasesReferredOutChild, deliveriesConductedMorningEightToEveningEight,
            deliveriesConductedEveningEightToMorningEight,
            noOfCSection, cSectionDoneMorningEightToEveningEight, cSectionDoneEveningEightToMorningEight,
            noOfLiveBirths, noOfStillBirths, noOfMaleLiveBirth, noOfMaleStillBirth, noOfFemaleLiveBirth,
            noOfFemaleStillBirth, noOfFreshStillBirths, noOfMaceratedStillBirths, noOfBabiesGivenNewbornResuscitation,
            noOfMothersDischargedBeforeFourtyeightHours, noOfMothersDischargedAfterFourtyeightHours,
            noOfLBWForLiveBirth, noOfLBWForStillBirth, noOfNormalWeightBabiesForLiveBirth, noOfNormalWeightBabiesForStillBirth, noOfMaternalDeaths, noOfNewbornDeaths,
            noOfObstetricComplicationsTreatedWithMagsulf, noOfLiveBirthsImmunizedForBCG, noOfLiveBirthsImmunizedForOPV,
            noOfLiveBirthsImmunizedForHEPB, noOfBabiesInitiatedBreastfeedingWithinOneHour, noOfPncCasesWithPpiucdInserted, noOfPretermLaborCasesTreatedWithCorticosteroides;
    private EditText startDateText, endDateText;

    private DateFormat outputFormatter = new SimpleDateFormat("MM/dd/yyyy");

    private Calendar c;
    private int mYear, mMonth, mDay, closedCaseCount, openedCaseCount, deliveryCaseCount, referredInCount, referredOutCount, noOfCasesReferredOutChildCount,
            deliveriesConductedMorningEightToEveningEightCount, deliveriesConductedEveningEightToMorningEightCount,
            noOfCSectionCount, cSectionDoneMorningEightToEveningEightCount, cSectionDoneEveningEightToMorningEightCount,
            noOfLiveBirthsCount, noOfStillBirthsCount, noOfMaleLiveBirthCount, noOfMaleStillBirthCount, noOfFemaleLiveBirthCount,
            noOfFemaleStillBirthCount, noOfFreshStillBirthsCount, noOfMaceratedStillBirthsCount, noOfLBWForLiveBirthCount, noOfLBWForStillBirthCount,
            noOfNormalWeightBabiesForLiveBirthCount, noOfNormalWeightBabiesForStillBirthCount, noOfBabiesGivenNewbornResuscitationCount,
            noOfMothersDischargedBeforeFourtyeightHoursCount, noOfMothersDischargedAfterFourtyeightHoursCount,
            noOfMaternalDeathsCount, noOfNewbornDeathsCount, noOfObstetricComplicationsTreatedWithMagsulfCount,
            noOfLiveBirthsImmunizedForBCGCount, noOfLiveBirthsImmunizedForOPVCount,
            noOfLiveBirthsImmunizedForHEPBCount, noOfBabiesInitiatedBreastfeedingWithinOneHourCount, noOfPncCasesWithPpiucdInsertedCount,
            noOfPretermLaborCasesTreatedWithCorticosteroidesCount, totalCaseCount, selectedStartDay, selectedStartMonth, selectedStartYear, selectedEndDay, selectedEndMonth,
            selectedEndYear;
    private Date minDate, selectedStartDate, currentDate, selectedEndDate, firstDateOfMonth;

    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(getString(R.string.activity_title_summary));
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        startDatePicker = (ImageView) findViewById(R.id.show_start_date);
        startDatePicker.setOnClickListener(this);
        endDatePicker = (ImageView) findViewById(R.id.show_end_date);
        endDatePicker.setOnClickListener(this);

        caseOpened = (TextView) findViewById(R.id.case_opened_text);
        caseClosed = (TextView) findViewById(R.id.case_closed_text);
        deliveryCount = (TextView) findViewById(R.id.deliveries_conducted_text);
        referredIn = (TextView) findViewById(R.id.no_of_cases_referred_in);
        referredOut = (TextView) findViewById(R.id.no_of_cases_referred_out);
        noOfCasesReferredOutChild = (TextView) findViewById(R.id.no_of_cases_referred_out_child);
        deliveriesConductedMorningEightToEveningEight = (TextView) findViewById(R.id.deliveries_conducted_morning_eight_to_evening_eight);
        deliveriesConductedEveningEightToMorningEight = (TextView) findViewById(R.id.deliveries_conducted_evening_eight_to_morning_eight);
        noOfCSection = (TextView) findViewById(R.id.no_of_c_section);
        cSectionDoneMorningEightToEveningEight = (TextView) findViewById(R.id.c_section_done_morning_eight_to_evening_eight);
        cSectionDoneEveningEightToMorningEight = (TextView) findViewById(R.id.c_section_done_evening_eight_to_morning_eight);
        noOfLiveBirths = (TextView) findViewById(R.id.no_of_live_births);
        noOfStillBirths = (TextView) findViewById(R.id.no_of_still_births);
        noOfMaleLiveBirth = (TextView) findViewById(R.id.no_of_male_live_birth);
        noOfMaleStillBirth = (TextView) findViewById(R.id.no_of_male_still_birth);
        noOfFemaleLiveBirth = (TextView) findViewById(R.id.no_of_female_live_birth);
        noOfFemaleStillBirth = (TextView) findViewById(R.id.no_of_female_still_birth);
        noOfFreshStillBirths = (TextView) findViewById(R.id.no_of_fresh_still_births);
        noOfMaceratedStillBirths = (TextView) findViewById(R.id.no_of_macerated_still_births);
        noOfLBWForLiveBirth = (TextView) findViewById(R.id.no_of_lbw_for_live_births);
        noOfLBWForStillBirth = (TextView) findViewById(R.id.no_of_lbw_for_still_births);
        noOfNormalWeightBabiesForLiveBirth = (TextView) findViewById(R.id.no_of_normal_weight_babies_live_birth);
        noOfNormalWeightBabiesForStillBirth = (TextView) findViewById(R.id.no_of_normal_weight_babies_still_birth);
        noOfBabiesGivenNewbornResuscitation = (TextView) findViewById(R.id.no_of_babies_given_newborn_resuscitation);
        noOfMothersDischargedBeforeFourtyeightHours = (TextView) findViewById(R.id.no_of_mothers_discharged_before_fourtyeight_hours);
        noOfMothersDischargedAfterFourtyeightHours = (TextView) findViewById(R.id.no_of_mothers_discharged_after_fourtyeight_hours);
        totalCase = (TextView) findViewById(R.id.case_total_text);
        noOfMothersDischargedBeforeFourtyeightHours = (TextView) findViewById(R.id.no_of_mothers_discharged_before_fourtyeight_hours);
        noOfMothersDischargedAfterFourtyeightHours = (TextView) findViewById(R.id.no_of_mothers_discharged_after_fourtyeight_hours);
        noOfMaternalDeaths = (TextView) findViewById(R.id.no_of_maternal_deaths);
        noOfNewbornDeaths = (TextView) findViewById(R.id.no_of_newborn_deaths);
        noOfObstetricComplicationsTreatedWithMagsulf = (TextView) findViewById(R.id.no_of_obstetric_complications_treated_with_magsulf);
        noOfLiveBirthsImmunizedForBCG = (TextView) findViewById(R.id.no_of_live_births_immunized_for_bcg);
        noOfLiveBirthsImmunizedForOPV = (TextView) findViewById(R.id.no_of_live_births_immunized_for_opv);
        noOfLiveBirthsImmunizedForHEPB = (TextView) findViewById(R.id.no_of_live_births_immunized_for_hepb);
        noOfPretermLaborCasesTreatedWithCorticosteroides = (TextView) findViewById(R.id.no_of_preterm_labor_cases_treated_with_corticosteroides);
        noOfBabiesInitiatedBreastfeedingWithinOneHour = (TextView) findViewById(R.id.no_of_babies_initiated_breastfeeding_within_one_hour);
        noOfPncCasesWithPpiucdInserted = (TextView) findViewById(R.id.no_of_pnc_cases_with_ppiucd_inserted);
        startDateText = (EditText) findViewById(R.id.start_date);
        endDateText = (EditText) findViewById(R.id.end_date);

        realm = LRCM.getInstance().getRealm();

        //Get CurrentDate and save the instance
        c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        try {
            currentDate = outputFormatter.parse(outputFormatter.format(c.getTime()));
        } catch (ParseException pe) {
            currentDate = c.getTime();
        }

        minDate = realm.where(Patient.class).minimumDate("admissionDateAndTime");
        //maxDate = realm.where(Patient.class).maximumDate("admissionDateAndTime");
        //selectedStartDate = minDate;

        //get FirstDate of month
        int firstDay = Calendar.getInstance().getActualMinimum(Calendar.DAY_OF_MONTH);
        Calendar firstDayCalendar = new GregorianCalendar(mYear, mMonth, firstDay);
        firstDateOfMonth = firstDayCalendar.getTime();

        //Calendar lastDayCalendar = new GregorianCalendar(mYear, mMonth, mDay);

        closedCaseCount = 0;
        openedCaseCount = 0;
        deliveryCaseCount = 0;
        referredInCount = 0;
        referredOutCount = 0;
        noOfCasesReferredOutChildCount = 0;
        deliveriesConductedMorningEightToEveningEightCount = 0;
        deliveriesConductedEveningEightToMorningEightCount = 0;
        noOfCSectionCount = 0;
        cSectionDoneMorningEightToEveningEightCount = 0;
        cSectionDoneEveningEightToMorningEightCount = 0;
        noOfLiveBirthsCount = 0;
        noOfStillBirthsCount = 0;
        noOfMaleLiveBirthCount = 0;
        noOfMaleStillBirthCount = 0;
        noOfFemaleLiveBirthCount = 0;
        noOfFemaleStillBirthCount = 0;
        noOfFreshStillBirthsCount = 0;
        noOfMaceratedStillBirthsCount = 0;
        noOfLBWForLiveBirthCount = 0;
        noOfLBWForStillBirthCount = 0;
        noOfNormalWeightBabiesForLiveBirthCount = 0;
        noOfNormalWeightBabiesForStillBirthCount = 0;
        noOfBabiesGivenNewbornResuscitationCount = 0;
        noOfMothersDischargedBeforeFourtyeightHoursCount = 0;
        noOfMothersDischargedAfterFourtyeightHoursCount = 0;
        noOfMaternalDeathsCount = 0;
        noOfNewbornDeathsCount = 0;
        noOfObstetricComplicationsTreatedWithMagsulfCount = 0;
        noOfLiveBirthsImmunizedForBCGCount = 0;
        noOfLiveBirthsImmunizedForOPVCount = 0;
        noOfLiveBirthsImmunizedForHEPBCount = 0;
        noOfPretermLaborCasesTreatedWithCorticosteroidesCount = 0;
        noOfBabiesInitiatedBreastfeedingWithinOneHourCount = 0;
        noOfPncCasesWithPpiucdInsertedCount = 0;
        totalCaseCount = 0;

        selectedStartDate = firstDateOfMonth;
        selectedEndDate = currentDate;

        selectedStartDay = firstDayCalendar.get(Calendar.DAY_OF_MONTH);
        selectedStartMonth = firstDayCalendar.get(Calendar.MONTH);
        selectedStartYear = firstDayCalendar.get(Calendar.YEAR);

        selectedEndDay = c.get(Calendar.DAY_OF_MONTH);
        selectedEndMonth = c.get(Calendar.MONTH);
        selectedEndYear = c.get(Calendar.YEAR);

        if (minDate == null) {
            minDate = currentDate;
        } else {
            try {
                minDate = outputFormatter.parse(outputFormatter.format(minDate));
            } catch (ParseException pe) {
                minDate = null;
            }

        }

        if (minDate.after(selectedStartDate)) {
            selectedStartDate = minDate;
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(minDate);

            selectedStartYear = calendar.get(Calendar.YEAR);
            selectedStartMonth = calendar.get(Calendar.MONTH);
            selectedStartDay = calendar.get(Calendar.DAY_OF_MONTH);
        }

        String selectedStartDateText = getDateString(selectedStartDate);
        startDateText.setText(selectedStartDateText);

        String selectedEndDateText = getDateString(currentDate);
        endDateText.setText(selectedEndDateText);

        showSummary();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.show_start_date:
                showStartDateDialog(startDateText);
                break;
            case R.id.show_end_date:
                showEndDateDialog(endDateText);
                break;
            default:
                break;
        }
    }

    public void showStartDateDialog(final EditText dateText) {

        DatePickerDialog dpd = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        Calendar myCalendar = new GregorianCalendar(year, monthOfYear, dayOfMonth);

                        selectedStartDate = myCalendar.getTime();

                        selectedStartDay = dayOfMonth;
                        selectedStartMonth = monthOfYear;
                        selectedStartYear = year;

                        String selectedDate = getDateString(selectedStartDate);

                        dateText.setText(selectedDate);
                        showSummary();

                    }
                }, mYear, mMonth, mDay);
        Calendar maxDate = Calendar.getInstance();
        maxDate.setTime(selectedEndDate);
        maxDate.set(maxDate.HOUR_OF_DAY, 23);
        maxDate.set(maxDate.MINUTE, 59);
        maxDate.set(maxDate.SECOND, 59);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            dpd.getDatePicker().setMinDate(minDate.getTime());
        }
        dpd.getDatePicker().setMaxDate(maxDate.getTimeInMillis());
        dpd.updateDate(selectedStartYear, selectedStartMonth, selectedStartDay);
        dpd.show();
    }

    public void showEndDateDialog(final EditText dateText) {

        DatePickerDialog dpd = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        Calendar myCalendar = new GregorianCalendar(year, monthOfYear, dayOfMonth);
                        selectedEndDate = myCalendar.getTime();

                        selectedEndDay = dayOfMonth;
                        selectedEndMonth = monthOfYear;
                        selectedEndYear = year;

                        String selectedDate = getDateString(selectedEndDate);

                        dateText.setText(selectedDate);
                        showSummary();

                    }
                }, mYear, mMonth, mDay);
        Calendar maxDate = Calendar.getInstance();
        maxDate.set(Calendar.HOUR_OF_DAY, 23);
        maxDate.set(Calendar.MINUTE, 59);
        maxDate.set(Calendar.SECOND, 59);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            dpd.getDatePicker().setMinDate(selectedStartDate.getTime());
        }
        dpd.getDatePicker().setMaxDate(maxDate.getTimeInMillis());
        dpd.updateDate(selectedEndYear, selectedEndMonth, selectedEndDay);
        dpd.show();
    }

    public void showSummary() {

        openedCaseCount = 0;
        closedCaseCount = 0;
        deliveryCaseCount = 0;
        referredInCount = 0;
        referredOutCount = 0;
        noOfCasesReferredOutChildCount = 0;
        deliveriesConductedMorningEightToEveningEightCount = 0;
        deliveriesConductedEveningEightToMorningEightCount = 0;
        noOfCSectionCount = 0;
        cSectionDoneMorningEightToEveningEightCount = 0;
        cSectionDoneEveningEightToMorningEightCount = 0;
        noOfLiveBirthsCount = 0;
        noOfStillBirthsCount = 0;
        noOfMaleLiveBirthCount = 0;
        noOfMaleStillBirthCount = 0;
        noOfFemaleLiveBirthCount = 0;
        noOfFemaleStillBirthCount = 0;
        noOfFreshStillBirthsCount = 0;
        noOfMaceratedStillBirthsCount = 0;
        noOfLBWForLiveBirthCount = 0;
        noOfLBWForStillBirthCount = 0;
        noOfNormalWeightBabiesForLiveBirthCount = 0;
        noOfNormalWeightBabiesForStillBirthCount = 0;
        noOfBabiesGivenNewbornResuscitationCount = 0;
        noOfMothersDischargedBeforeFourtyeightHoursCount = 0;
        noOfMothersDischargedAfterFourtyeightHoursCount = 0;
        noOfMaternalDeathsCount = 0;
        noOfNewbornDeathsCount = 0;
        noOfObstetricComplicationsTreatedWithMagsulfCount = 0;
        noOfLiveBirthsImmunizedForBCGCount = 0;
        noOfLiveBirthsImmunizedForOPVCount = 0;
        noOfLiveBirthsImmunizedForHEPBCount = 0;
        noOfPretermLaborCasesTreatedWithCorticosteroidesCount = 0;
        noOfBabiesInitiatedBreastfeedingWithinOneHourCount = 0;
        noOfPncCasesWithPpiucdInsertedCount = 0;
        totalCaseCount = 0;

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(selectedEndDate);
        Calendar tempCalendar = new GregorianCalendar(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH) + 1);
        Date temEndDate = tempCalendar.getTime();

        RealmQuery query = realm.where(Patient.class).between("admissionDateAndTime", selectedStartDate, temEndDate);
        RealmResults<Patient> results = query.findAll();
        totalCaseCount = results.size();
        for (Patient patient : results) {
            if (patient.getClosed() == null || !patient.getClosed()) {
                openedCaseCount++;
            } else {
                closedCaseCount++;
            }

            if (patient.getDeliveryDateAndTime() != null) {
                deliveryCaseCount++;
            }

            if (patient.getTypeOfPatient() != null && patient.getTypeOfPatient() == Constant.TypeDetails.REFERRED_PATIENT_TYPE_DETAIL_ID) {
                referredInCount++;
            }

            if (patient.getMotherStatus() != null && patient.getMotherStatus() == Constant.TypeDetails.MOTHER_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID) {
                referredOutCount++;
            }

            if (patient.getChildStatus() != null && patient.getChildren().size() > 0) {
                for (ChildStatus status : patient.getChildStatus()) {
                    if (status.getStatus() != null && status.getStatus() == Constant.TypeDetails.CHILD_STATUS_REFERRED_TO_HIGHER_FACILITY_TYPE_DETAIL_ID) {
                        noOfCasesReferredOutChildCount++;
                    } else if (status.getStatus() != null && status.getStatus() == Constant.TypeDetails.CHILD_STATUS_DEATH_TYPE_DETAIL_ID){
                        noOfNewbornDeathsCount++;
                    }
                }
            }

            if (patient.getDeliveryDateAndTime() != null) {
                Calendar cal = Calendar.getInstance();
                cal.setTime(patient.getDeliveryDateAndTime());
                int hours = cal.get(Calendar.HOUR_OF_DAY);
                if (hours >= 8 && hours < 20) {
                    deliveriesConductedMorningEightToEveningEightCount++;
                } else {
                    deliveriesConductedEveningEightToMorningEightCount++;
                }
            }
            if (patient.getDeliveryType() != null && patient.getDeliveryType() == Constant.TypeDetails.DELIVERY_TYPE_CSECTION_TYPE_DETAIL_ID) {
                noOfCSectionCount++;
                if (patient.getDeliveryDateAndTime() != null) {
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(patient.getDeliveryDateAndTime());
                    int hours = cal.get(Calendar.HOUR_OF_DAY);
                    if (hours >= 8 && hours < 20) {
                        cSectionDoneMorningEightToEveningEightCount++;
                    } else {
                        cSectionDoneEveningEightToMorningEightCount++;
                    }
                }
            }
            if (patient.getTreatedWithMagsulf() != null && patient.getTreatedWithMagsulf()){
                noOfObstetricComplicationsTreatedWithMagsulfCount++;
            }

            if (patient.getChildren() != null && patient.getChildren().size() > 0) {
                for (Child child : patient.getChildren()) {
                    if (!child.getStillBirth()) {
                        noOfLiveBirthsCount++;
                        if (child.getChildSex() != null && child.getChildSex() == Constant.TypeDetails.SEX_MALE_TYPE_DETAIL_ID) {
                            noOfMaleLiveBirthCount++;
                        } else if (child.getChildSex() != null && child.getChildSex() == Constant.TypeDetails.SEX_FEMALE_TYPE_DETAIL_ID) {
                            noOfFemaleLiveBirthCount++;
                        }
                        if (child.getChildWeight() != null && child.getChildWeight() < Constant.CHILD_WEIGHT_FOR_LBW_LIVE_BIRTH) {
                            noOfLBWForLiveBirthCount++;
                        } else if (child.getChildWeight() != null && child.getChildWeight() >= Constant.CHILD_WEIGHT_FOR_LBW_LIVE_BIRTH){
                            noOfNormalWeightBabiesForLiveBirthCount++;
                        }
                        if (child.getHasNeededRescusition() != null && child.getHasNeededRescusition()) {
                            noOfBabiesGivenNewbornResuscitationCount++;
                        }
                        if (child.getBCGGiven() != null && child.getBCGGiven()){
                            noOfLiveBirthsImmunizedForBCGCount++;
                        }
                        if (child.getZeroOPVGiven() != null && child.getZeroOPVGiven()){
                            noOfLiveBirthsImmunizedForOPVCount++;
                        }
                        if (child.getHepBZeroGiven() != null && child.getHepBZeroGiven()){
                            noOfLiveBirthsImmunizedForHEPBCount++;
                        }
                        if (child.getChildBreastFedInHour() != null && child.getChildBreastFedInHour()){
                            noOfBabiesInitiatedBreastfeedingWithinOneHourCount++;
                        }
                    } else {
                        noOfStillBirthsCount++;
                        if (child.getChildSex() != null && child.getChildSex() == Constant.TypeDetails.SEX_MALE_TYPE_DETAIL_ID) {
                            noOfMaleStillBirthCount++;
                        } else if (child.getChildSex() != null && child.getChildSex() == Constant.TypeDetails.SEX_FEMALE_TYPE_DETAIL_ID) {
                            noOfFemaleStillBirthCount++;
                        }
                        if (child.getStillBirthType() != null && child.getStillBirthType() == Constant.TypeDetails.FRESH_STILL_BIRTH_TYPE_DETAILS_ID) {
                            noOfFreshStillBirthsCount++;
                        } else if (child.getStillBirthType() != null && child.getStillBirthType() == Constant.TypeDetails.MACERATED_STILL_BIRTH_TYPE_DETAILS_ID) {
                            noOfMaceratedStillBirthsCount++;
                        }
                        if (child.getChildWeight() != null && child.getChildWeight() < Constant.CHILD_WEIGHT_FOR_LBW_STILL_BIRTH) {
                            noOfLBWForStillBirthCount++;
                        } else if (child.getChildWeight() != null && child.getChildWeight() >= Constant.CHILD_WEIGHT_FOR_LBW_STILL_BIRTH){
                            noOfNormalWeightBabiesForStillBirthCount++;
                        }
                    }

                }
            }
            if (patient.getMotherStatus() != null && patient.getMotherStatus() == Constant.TypeDetails.MOTHER_STATUS_DISCHARGED_TYPE_DETAIL_ID) {
                if (patient.getDeliveryDateAndTime() != null && patient.getDischargeDateAndTime() != null) {
                    final int MILLI_TO_HOUR = 1000 * 60 * 60;
                    int hour = (int) (patient.getDischargeDateAndTime().getTime() - patient.getDeliveryDateAndTime().getTime()) / MILLI_TO_HOUR;
                    if (hour < 48) {
                        noOfMothersDischargedBeforeFourtyeightHoursCount++;
                    } else {
                        noOfMothersDischargedAfterFourtyeightHoursCount++;
                    }
                }
            }
            if (patient.getMotherStatus() != null && patient.getMotherStatus() == Constant.TypeDetails.MOTHER_STATUS_DEATH_TYPE_DETAIL_ID) {
                noOfMaternalDeathsCount++;
            }
            if (patient.getPpiucdInserted() != null && patient.getPpiucdInserted()){
                noOfPncCasesWithPpiucdInsertedCount++;
            }
            if (patient.getDexamethasoneGiven() != null && patient.getDexamethasoneGiven()){
                noOfPretermLaborCasesTreatedWithCorticosteroidesCount++;
            }

        }
        caseOpened.setText(": " + openedCaseCount + "");
        caseClosed.setText(": " + closedCaseCount + "");
        deliveryCount.setText(": " + deliveryCaseCount + "");
        referredIn.setText(": " + referredInCount + "");
        referredOut.setText(": " + referredOutCount + "");
        noOfCasesReferredOutChild.setText(": " + noOfCasesReferredOutChildCount + "");
        deliveriesConductedMorningEightToEveningEight.setText(": " + deliveriesConductedMorningEightToEveningEightCount + "");
        deliveriesConductedEveningEightToMorningEight.setText(": " + deliveriesConductedEveningEightToMorningEightCount + "");
        noOfCSection.setText(": " + noOfCSectionCount + "");
        cSectionDoneMorningEightToEveningEight.setText(": " + cSectionDoneMorningEightToEveningEightCount + "");
        cSectionDoneEveningEightToMorningEight.setText(": " + cSectionDoneEveningEightToMorningEightCount + "");
        noOfLiveBirths.setText(": " + noOfLiveBirthsCount + "");
        noOfStillBirths.setText(": " + noOfStillBirthsCount + "");
        noOfMaleLiveBirth.setText(": " + noOfMaleLiveBirthCount + "");
        noOfMaleStillBirth.setText(": " + noOfMaleStillBirthCount + "");
        noOfFemaleLiveBirth.setText(": " + noOfFemaleLiveBirthCount + "");
        noOfFemaleStillBirth.setText(": " + noOfFemaleStillBirthCount + "");
        noOfFreshStillBirths.setText(": " + noOfFreshStillBirthsCount + "");
        noOfMaceratedStillBirths.setText(": " + noOfMaceratedStillBirthsCount + "");
        noOfLBWForLiveBirth.setText(": " + noOfLBWForLiveBirthCount + "");
        noOfLBWForStillBirth.setText(": " + noOfLBWForStillBirthCount + "");
        noOfNormalWeightBabiesForLiveBirth.setText(": " + noOfNormalWeightBabiesForLiveBirthCount + "");
        noOfNormalWeightBabiesForStillBirth.setText(": " + noOfNormalWeightBabiesForStillBirthCount + "");
        noOfBabiesGivenNewbornResuscitation.setText(": " + noOfBabiesGivenNewbornResuscitationCount + "");
        noOfMothersDischargedBeforeFourtyeightHours.setText(": " + noOfMothersDischargedBeforeFourtyeightHoursCount + "");
        noOfMothersDischargedAfterFourtyeightHours.setText(": " + noOfMothersDischargedAfterFourtyeightHoursCount + "");
        noOfMaternalDeaths.setText(": " + noOfMaternalDeathsCount + "");
        noOfNewbornDeaths.setText(": " + noOfNewbornDeathsCount + "");
        noOfObstetricComplicationsTreatedWithMagsulf.setText(": " + noOfObstetricComplicationsTreatedWithMagsulfCount + "");
        noOfLiveBirthsImmunizedForBCG.setText(": " + noOfLiveBirthsImmunizedForBCGCount + "");
        noOfLiveBirthsImmunizedForOPV.setText(": " + noOfLiveBirthsImmunizedForOPVCount + "");
        noOfLiveBirthsImmunizedForHEPB.setText(": " + noOfLiveBirthsImmunizedForHEPBCount + "");
        noOfPretermLaborCasesTreatedWithCorticosteroides.setText(": " + noOfPretermLaborCasesTreatedWithCorticosteroidesCount + "");
        noOfBabiesInitiatedBreastfeedingWithinOneHour.setText(": " + noOfBabiesInitiatedBreastfeedingWithinOneHourCount + "");
        noOfPncCasesWithPpiucdInserted.setText(": " + noOfPncCasesWithPpiucdInsertedCount + "");
        totalCase.setText(": " + totalCaseCount + "");
    }

    public String getDateString(Date date) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        String formattedDay = (String.valueOf(day));
        String formattedMonth = (String.valueOf(month));

        if (day < 10) {
            formattedDay = "0" + day;
        }

        if (month < 10) {
            formattedMonth = "0" + month;
        }
        return (formattedDay + "-" + formattedMonth + "-" + year);
    }

    public boolean onSupportNavigateUp() {
        finish();
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
