package org.sdrc.lrcasemanagement.customclass;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.text.InputFilter;
import android.text.InputType;
import android.text.method.DigitsKeyListener;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import org.sdrc.lrcasemanagement.R;

/**
 * Created by Jagat Bandhu Sahoo(jagat@sdrc.co.in) on 3/18/2017.
 */

public class CustomChildStatusLayout extends LinearLayout {

    public boolean childStatusFlag = false;
    public LinearLayout linearLayout, collapseLayout, collapseView, childDischargeLayout, dischargeDateTimeLayout,
            childReferredLayout,referredDateTimeLayout, childLamaDateTimeLayout, lamaDateTimeLayout, childDeadLayout,
            childDeathDateTimeLayout;
    public TextView addChildStatusTxt, childStatusTxt, dischargeDateTimeChild, dischargeWeightChild, transportToHomeChild,
            referredDateTime, referredByChild, referredCauseChild, childReferredOtherCause, referredTransportChild,
            referredAreaChild, referredOtherAreaChild, lamaDateTime, childDeathCause, childDeathDateTime;
    public ImageView expandCollapseImgBtn, showDischargeDateTimeChild, showReferredDateTimeChild, showlamaDateTimeChild, showChildDeathDateTime;
    public EditText childStatusET, dischargeDateTimeChildET, dischargeWeightChildET, transportToHomeChildET,
            referredDateTimeChildET, referredByChildET, referredCauseChildET, childReferredOtherCauseET,
            referredTransportChildET, referredAreaChildET, referredOtherAreaChildET, lamaDateTimeChildET,
            childDeathCauseET, childDeathDateTimeET;

    public CustomChildStatusLayout(final Context context) {
        super(context);

        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 5, 0, 0);
        setOrientation(VERTICAL);
        setLayoutParams(params);

        LayoutParams params1 = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        linearLayout = new LinearLayout(context);
        linearLayout.setLayoutParams(params1);
        linearLayout.setOrientation(VERTICAL);
        linearLayout.setBackgroundResource(R.drawable.grey_border);
        addView(linearLayout);

        LayoutParams collapseLayoutParam = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        collapseLayout = new LinearLayout(context);
        collapseLayout.setLayoutParams(collapseLayoutParam);
        collapseLayout.setBackgroundColor(ContextCompat.getColor(context, R.color.grey));
        collapseLayout.setOrientation(HORIZONTAL);
        collapseLayout.setWeightSum(10f);
        linearLayout.addView(collapseLayout);

        LinearLayout.LayoutParams addChildStatusTxtParams = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT);
        addChildStatusTxtParams.weight = 9f;
        addChildStatusTxtParams.setMargins(15,15,15,15);
        addChildStatusTxt =  new TextView(context);
        addChildStatusTxt.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.sixteen));
        addChildStatusTxt.setTypeface(addChildStatusTxt.getTypeface(), Typeface.BOLD);
        addChildStatusTxt.setLayoutParams(addChildStatusTxtParams);
        addChildStatusTxt.setText(getResources().getString(R.string.child_status));
        addChildStatusTxt.setTextColor(Color.parseColor("#ffffff"));
        collapseLayout.addView(addChildStatusTxt);

        LinearLayout.LayoutParams expandCollpaseImgBtnParams = new LinearLayout.LayoutParams(0, 50);
        expandCollpaseImgBtnParams.weight = 1f;
        expandCollpaseImgBtnParams.setMargins(0,10,10,10);
        expandCollapseImgBtn = new ImageView(context);
        expandCollapseImgBtn.setLayoutParams(expandCollpaseImgBtnParams);
        expandCollapseImgBtn.setBackgroundResource(R.drawable.expand_arrow);
        collapseLayout.addView(expandCollapseImgBtn);

        LayoutParams collapseViewParam = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        collapseView = new LinearLayout(context);
        collapseView.setLayoutParams(collapseViewParam);
        collapseView.setOrientation(VERTICAL);
        collapseView.setPadding(15,15,15,15);
        collapseView.setVisibility(GONE);
        linearLayout.addView(collapseView);

        childStatusTxt = new TextView(context);
        childStatusTxt.setText(getResources().getString(R.string.status_of_child));
        childStatusTxt.setTextColor(Color.parseColor("#000000"));
        childStatusTxt.setPadding(0,0,0,0);
        childStatusTxt.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.sixteen));
        collapseView.addView(childStatusTxt);

        LinearLayout.LayoutParams childStatusETParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
        childStatusETParams.setMargins(0,8,0,0);
        childStatusET = new EditText(context);
        childStatusET.setLayoutParams(childStatusETParams);
        childStatusET.setBackgroundResource(R.drawable.grey_border);
        childStatusET.setFocusable(false);
        childStatusET.setTextColor(ContextCompat.getColor(context, R.color.grey));
        childStatusET.setHintTextColor(ContextCompat.getColor(context, R.color.hint_grey));
        childStatusET.setHint(getResources().getString(R.string.child_status_hint));
        childStatusET.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.sixteen));
        childStatusET.setPadding(10,2,15,2);
        childStatusET.setSingleLine();
        childStatusET.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_keyboard_arrow_down, 0);
        collapseView.addView(childStatusET);

        //Child Discharge Layout
        childDischargeLayout = new LinearLayout(context);
        childDischargeLayout.setOrientation(VERTICAL);
        childDischargeLayout.setVisibility(GONE);
        collapseView.addView(childDischargeLayout);

        LinearLayout.LayoutParams dischargeDateTimeChildParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        dischargeDateTimeChildParams.setMargins(0,15,0,0);
        dischargeDateTimeChild = new TextView(context);
        dischargeDateTimeChild.setLayoutParams(dischargeDateTimeChildParams);
        dischargeDateTimeChild.setText(getResources().getString(R.string.discharge_date_time_child));
        dischargeDateTimeChild.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.sixteen));
        dischargeDateTimeChild.setTextColor(ContextCompat.getColor(context, R.color.black));
        childDischargeLayout.addView(dischargeDateTimeChild);

        LinearLayout.LayoutParams dischargeDateTimeLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
        dischargeDateTimeLayoutParams.setMargins(0,8,0,20);
        dischargeDateTimeLayout = new LinearLayout(context);
        dischargeDateTimeLayout.setLayoutParams(dischargeDateTimeLayoutParams);
        dischargeDateTimeLayout.setWeightSum(10f);
        childDischargeLayout.addView(dischargeDateTimeLayout);

        LinearLayout.LayoutParams dischargeDateTimeChildETParams = new LinearLayout.LayoutParams(0,LayoutParams.WRAP_CONTENT);
        dischargeDateTimeChildETParams.weight = 9f;
        dischargeDateTimeChildETParams.setMargins(0,0,10,0);
        dischargeDateTimeChildET = new EditText(context);
        dischargeDateTimeChildET.setLayoutParams(dischargeDateTimeChildETParams);
        dischargeDateTimeChildET.setBackgroundResource(R.drawable.grey_border);
        dischargeDateTimeChildET.setTextColor(ContextCompat.getColor(context, R.color.grey));
        dischargeDateTimeChildET.setHintTextColor(ContextCompat.getColor(context, R.color.hint_grey));
        dischargeDateTimeChildET.setHint(getResources().getString(R.string.discharge_date_time_hint));
        dischargeDateTimeChildET.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.sixteen));
        dischargeDateTimeChildET.setPadding(10,12,15,12);
        dischargeDateTimeChildET.setFocusable(false);
        dischargeDateTimeLayout.addView(dischargeDateTimeChildET);

        LinearLayout.LayoutParams showDischargDateTimeChildParams = new LinearLayout.LayoutParams(0,LayoutParams.WRAP_CONTENT);
        showDischargDateTimeChildParams.weight = 1f;
        LinearLayout showDischargDateTimeChildLayout = new LinearLayout(context);
        showDischargDateTimeChildLayout.setLayoutParams(showDischargDateTimeChildParams);
        dischargeDateTimeLayout.addView(showDischargDateTimeChildLayout);

        showDischargeDateTimeChild = new ImageView(context);
        showDischargeDateTimeChild.setBackgroundResource(R.drawable.datepicker);
        showDischargeDateTimeChild.setScaleType(ImageView.ScaleType.CENTER_CROP);
        showDischargeDateTimeChild.setAdjustViewBounds(true);
        showDischargDateTimeChildLayout.addView(showDischargeDateTimeChild);

        dischargeWeightChild = new TextView(context);
        dischargeWeightChild.setText(getResources().getString(R.string.discharge_weight));
        dischargeWeightChild.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.sixteen));
        dischargeWeightChild.setTextColor(ContextCompat.getColor(context, R.color.black));
        childDischargeLayout.addView(dischargeWeightChild);

        LinearLayout.LayoutParams dischargeWeightChildETParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
        dischargeWeightChildETParams.setMargins(0,8,0,0);
        dischargeWeightChildET = new EditText(context);
        dischargeWeightChildET.setLayoutParams(dischargeWeightChildETParams);
        dischargeWeightChildET.setBackgroundResource(R.drawable.grey_border);
        dischargeWeightChildET.setTextColor(ContextCompat.getColor(context, R.color.grey));
        dischargeWeightChildET.setHintTextColor(ContextCompat.getColor(context, R.color.hint_grey));
        dischargeWeightChildET.setHint(getResources().getString(R.string.discharge_weight_hint));
        dischargeWeightChildET.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.sixteen));
        dischargeWeightChildET.setPadding(10,12,15,12);
        dischargeWeightChildET.setInputType(InputType.TYPE_CLASS_NUMBER);
        dischargeWeightChildET.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL);
        dischargeWeightChildET.setKeyListener(DigitsKeyListener.getInstance(false,true));
        int maxLengthofWeight = 4;
        dischargeWeightChildET.setFilters(new InputFilter[] {new InputFilter.LengthFilter(maxLengthofWeight)});
        dischargeWeightChildET.setSingleLine();
        childDischargeLayout.addView(dischargeWeightChildET);

        LinearLayout.LayoutParams transportToHomeChildParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        transportToHomeChildParams.setMargins(0,15,0,0);
        transportToHomeChild = new TextView(context);
        transportToHomeChild.setLayoutParams(transportToHomeChildParams);
        transportToHomeChild.setText(getResources().getString(R.string.transport_to_home_child));
        transportToHomeChild.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.sixteen));
        transportToHomeChild.setTextColor(ContextCompat.getColor(context, R.color.black));
        childDischargeLayout.addView(transportToHomeChild);

        LinearLayout.LayoutParams transportToHomeChildETParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
        transportToHomeChildETParams.setMargins(0,8,0,0);
        transportToHomeChildET = new EditText(context);
        transportToHomeChildET.setLayoutParams(transportToHomeChildETParams);
        transportToHomeChildET.setFocusable(false);
        transportToHomeChildET.setBackgroundResource(R.drawable.grey_border);
        transportToHomeChildET.setTextColor(ContextCompat.getColor(context, R.color.grey));
        transportToHomeChildET.setHintTextColor(ContextCompat.getColor(context, R.color.hint_grey));
        transportToHomeChildET.setHint(getResources().getString(R.string.transport_to_home_hint));
        transportToHomeChildET.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.sixteen));
        transportToHomeChildET.setPadding(10,2,15,2);
        transportToHomeChildET.setSingleLine();
        transportToHomeChildET.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_keyboard_arrow_down, 0);
        childDischargeLayout.addView(transportToHomeChildET);

        //Child Referred Layout
        childReferredLayout = new LinearLayout(context);
        childReferredLayout.setOrientation(VERTICAL);
        childReferredLayout.setVisibility(GONE);
        collapseView.addView(childReferredLayout);

        LinearLayout.LayoutParams referredDateTimeParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        referredDateTimeParams.setMargins(0,20,0,0);
        referredDateTime = new TextView(context);
        referredDateTime.setText(getResources().getString(R.string.referred_date_time_child));
        referredDateTime.setLayoutParams(referredDateTimeParams);
        referredDateTime.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.sixteen));
        referredDateTime.setTextColor(ContextCompat.getColor(context, R.color.black));
        childReferredLayout.addView(referredDateTime);

        LinearLayout.LayoutParams referredDateTimeLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
        referredDateTimeLayoutParams.setMargins(0,8,0,20);
        referredDateTimeLayout = new LinearLayout(context);
        referredDateTimeLayout.setLayoutParams(referredDateTimeLayoutParams);
        referredDateTimeLayout.setWeightSum(10f);
        childReferredLayout.addView(referredDateTimeLayout);

        LinearLayout.LayoutParams referredDateTimeChildETParams = new LinearLayout.LayoutParams(0,LayoutParams.WRAP_CONTENT);
        referredDateTimeChildETParams.weight = 9f;
        referredDateTimeChildETParams.setMargins(0,0,10,0);
        referredDateTimeChildET = new EditText(context);
        referredDateTimeChildET.setLayoutParams(referredDateTimeChildETParams);
        referredDateTimeChildET.setBackgroundResource(R.drawable.grey_border);
        referredDateTimeChildET.setTextColor(ContextCompat.getColor(context, R.color.grey));
        referredDateTimeChildET.setHintTextColor(ContextCompat.getColor(context, R.color.hint_grey));
        referredDateTimeChildET.setHint(getResources().getString(R.string.referred_date_time_hint));
        referredDateTimeChildET.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.sixteen));
        referredDateTimeChildET.setPadding(10,12,15,12);
        referredDateTimeChildET.setFocusable(false);
        referredDateTimeLayout.addView(referredDateTimeChildET);

        LinearLayout.LayoutParams showReferredDateTimeChildParams = new LinearLayout.LayoutParams(0,LayoutParams.WRAP_CONTENT);
        showReferredDateTimeChildParams.weight = 1f;
        LinearLayout showReferredDateTimeChildLayout = new LinearLayout(context);
        showReferredDateTimeChildLayout.setLayoutParams(showReferredDateTimeChildParams);
        referredDateTimeLayout.addView(showReferredDateTimeChildLayout);

        showReferredDateTimeChild = new ImageView(context);
        showReferredDateTimeChild.setBackgroundResource(R.drawable.datepicker);
        showReferredDateTimeChild.setScaleType(ImageView.ScaleType.CENTER_CROP);
        showReferredDateTimeChild.setAdjustViewBounds(true);
        showReferredDateTimeChildLayout.addView(showReferredDateTimeChild);

        referredByChild = new TextView(context);
        referredByChild.setText(getResources().getString(R.string.referred_by_child));
        referredByChild.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.sixteen));
        referredByChild.setTextColor(ContextCompat.getColor(context, R.color.black));
        childReferredLayout.addView(referredByChild);

        LinearLayout.LayoutParams referredByChildETParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
        referredByChildETParams.setMargins(0,8,0,0);
        referredByChildET = new EditText(context);
        referredByChildET.setLayoutParams(referredByChildETParams);
        referredByChildET.setBackgroundResource(R.drawable.grey_border);
        referredByChildET.setTextColor(ContextCompat.getColor(context, R.color.grey));
        referredByChildET.setHintTextColor(ContextCompat.getColor(context, R.color.hint_grey));
        referredByChildET.setHint(getResources().getString(R.string.referred_by_hint));
        referredByChildET.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.sixteen));
        referredByChildET.setPadding(10,12,15,12);
        referredByChildET.setSingleLine();
        childReferredLayout.addView(referredByChildET);

        LinearLayout.LayoutParams referredCauseChildParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
        referredCauseChildParams.setMargins(0,15,0,0);
        referredCauseChild = new TextView(context);
        referredCauseChild.setLayoutParams(referredCauseChildParams);
        referredCauseChild.setText(getResources().getString(R.string.referred_cause_child));
        referredCauseChild.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.sixteen));
        referredCauseChild.setTextColor(ContextCompat.getColor(context, R.color.black));
        childReferredLayout.addView(referredCauseChild);

        LinearLayout.LayoutParams referredCauseChildETParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
        referredCauseChildETParams.setMargins(0,8,0,0);
        referredCauseChildET = new EditText(context);
        referredCauseChildET.setLayoutParams(referredCauseChildETParams);
        referredCauseChildET.setBackgroundResource(R.drawable.grey_border);
        referredCauseChildET.setTextColor(ContextCompat.getColor(context, R.color.grey));
        referredCauseChildET.setHintTextColor(ContextCompat.getColor(context, R.color.hint_grey));
        referredCauseChildET.setHint(getResources().getString(R.string.referred_cause_hint));
        referredCauseChildET.setInputType(0);
        referredCauseChildET.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.sixteen));
        referredCauseChildET.setPadding(10,2,15,2);
        referredCauseChildET.setSingleLine();
        referredCauseChildET.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_keyboard_arrow_down, 0);
        childReferredLayout.addView(referredCauseChildET);

        /*LinearLayout.LayoutParams childReferredOtherCauseParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
        childReferredOtherCauseParams.setMargins(0,0,0,0);
        childReferredOtherCause = new TextView(context);
        childReferredOtherCause.setLayoutParams(childReferredOtherCauseParams);
        childReferredOtherCause.setText("Cause of death");
        childReferredOtherCause.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.sixteen));
        childReferredOtherCause.setTextColor(ContextCompat.getColor(context, R.color.black));
        childReferredLayout.addView(childReferredOtherCause);*/

        LinearLayout.LayoutParams childReferredOtherCauseETParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
        childReferredOtherCauseETParams.setMargins(0,8,0,0);
        childReferredOtherCauseET = new EditText(context);
        childReferredOtherCauseET.setLayoutParams(childReferredOtherCauseETParams);
        childReferredOtherCauseET.setBackgroundResource(R.drawable.grey_border);
        childReferredOtherCauseET.setTextColor(ContextCompat.getColor(context, R.color.grey));
        childReferredOtherCauseET.setHintTextColor(ContextCompat.getColor(context, R.color.hint_grey));
        childReferredOtherCauseET.setHint(getResources().getString(R.string.referred_other_cause_child_hint));
        childReferredOtherCauseET.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.sixteen));
        childReferredOtherCauseET.setPadding(10,12,15,12);
        childReferredOtherCauseET.setSingleLine();
        childReferredOtherCauseET.setVisibility(GONE);
        childReferredLayout.addView(childReferredOtherCauseET);

        LinearLayout.LayoutParams referredTransportChildParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
        referredTransportChildParams.setMargins(0,15,0,0);
        referredTransportChild = new TextView(context);
        referredTransportChild.setLayoutParams(referredTransportChildParams);
        referredTransportChild.setText(getResources().getString(R.string.referred_transport_child));
        referredTransportChild.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.sixteen));
        referredTransportChild.setTextColor(ContextCompat.getColor(context, R.color.black));
        childReferredLayout.addView(referredTransportChild);

        LinearLayout.LayoutParams referredTransportChildETParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
        referredTransportChildETParams.setMargins(0,8,0,0);
        referredTransportChildET = new EditText(context);
        referredTransportChildET.setLayoutParams(referredTransportChildETParams);
        referredTransportChildET.setBackgroundResource(R.drawable.grey_border);
        referredTransportChildET.setTextColor(ContextCompat.getColor(context, R.color.grey));
        referredTransportChildET.setHintTextColor(ContextCompat.getColor(context, R.color.hint_grey));
        referredTransportChildET.setHint(getResources().getString(R.string.referred_transport_hint));
        referredTransportChildET.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.sixteen));
        referredTransportChildET.setPadding(10,2,15,2);
        referredTransportChildET.setSingleLine();
        referredTransportChildET.setFocusable(false);
        referredTransportChildET.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_keyboard_arrow_down, 0);
        childReferredLayout.addView(referredTransportChildET);

        LinearLayout.LayoutParams referredAreaChildParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
        referredAreaChildParams.setMargins(0,15,0,0);
        referredAreaChild = new TextView(context);
        referredAreaChild.setLayoutParams(referredAreaChildParams);
        referredAreaChild.setText(getResources().getString(R.string.referred_facility_name_child));
        referredAreaChild.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.sixteen));
        referredAreaChild.setTextColor(ContextCompat.getColor(context, R.color.black));
        childReferredLayout.addView(referredAreaChild);

        LinearLayout.LayoutParams referredAreaChildETParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
        referredAreaChildETParams.setMargins(0,8,0,0);
        referredAreaChildET = new EditText(context);
        referredAreaChildET.setLayoutParams(referredAreaChildETParams);
        referredAreaChildET.setBackgroundResource(R.drawable.grey_border);
        referredAreaChildET.setTextColor(ContextCompat.getColor(context, R.color.grey));
        referredAreaChildET.setHintTextColor(ContextCompat.getColor(context, R.color.hint_grey));
        referredAreaChildET.setHint(getResources().getString(R.string.referred_facility_name_hint));
        referredAreaChildET.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.sixteen));
        referredAreaChildET.setPadding(10,2,15,2);
        referredAreaChildET.setSingleLine();
        referredAreaChildET.setFocusable(false);
        referredAreaChildET.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_keyboard_arrow_down, 0);
        childReferredLayout.addView(referredAreaChildET);

        /*LinearLayout.LayoutParams referredOtherAreaChildParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
        referredOtherAreaChildParams.setMargins(0,0,0,0);
        referredOtherAreaChild = new TextView(context);
        referredOtherAreaChild.setLayoutParams(referredOtherAreaChildParams);
        referredOtherAreaChild.setText("Cause of death");
        referredOtherAreaChild.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.sixteen));
        referredOtherAreaChild.setTextColor(ContextCompat.getColor(context, R.color.black));
        childReferredLayout.addView(referredOtherAreaChild);*/

        LinearLayout.LayoutParams referredOtherAreaChildETParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
        referredOtherAreaChildETParams.setMargins(0,8,0,0);
        referredOtherAreaChildET = new EditText(context);
        referredOtherAreaChildET.setLayoutParams(childReferredOtherCauseETParams);
        referredOtherAreaChildET.setBackgroundResource(R.drawable.grey_border);
        referredOtherAreaChildET.setTextColor(ContextCompat.getColor(context, R.color.grey));
        referredOtherAreaChildET.setHintTextColor(ContextCompat.getColor(context, R.color.hint_grey));
        referredOtherAreaChildET.setHint(getResources().getString(R.string.referred_other_facility_name_hint));
        referredOtherAreaChildET.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.sixteen));
        referredOtherAreaChildET.setPadding(10,12,15,12);
        referredOtherAreaChildET.setSingleLine();
        referredOtherAreaChildET.setVisibility(GONE);
        childReferredLayout.addView(referredOtherAreaChildET);


        childLamaDateTimeLayout = new LinearLayout(context);
        childLamaDateTimeLayout.setOrientation(VERTICAL);
        childLamaDateTimeLayout.setVisibility(GONE);
        collapseView.addView(childLamaDateTimeLayout);

        LinearLayout.LayoutParams lamaDateTimeParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        lamaDateTimeParams.setMargins(0,20,0,0);
        lamaDateTime = new TextView(context);
        lamaDateTime.setText(getResources().getString(R.string.lama_date_time_child));
        lamaDateTime.setLayoutParams(lamaDateTimeParams);
        lamaDateTime.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.sixteen));
        lamaDateTime.setTextColor(ContextCompat.getColor(context, R.color.black));
        childLamaDateTimeLayout.addView(lamaDateTime);

        LinearLayout.LayoutParams lamaDateTimeLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
        lamaDateTimeLayoutParams.setMargins(0,8,0,20);
        lamaDateTimeLayout = new LinearLayout(context);
        lamaDateTimeLayout.setLayoutParams(lamaDateTimeLayoutParams);
        lamaDateTimeLayout.setWeightSum(10f);
        childLamaDateTimeLayout.addView(lamaDateTimeLayout);

        LinearLayout.LayoutParams lamaDateTimeChildETParams = new LinearLayout.LayoutParams(0,LayoutParams.WRAP_CONTENT);
        lamaDateTimeChildETParams.weight = 9f;
        lamaDateTimeChildETParams.setMargins(0,0,10,0);
        lamaDateTimeChildET = new EditText(context);
        lamaDateTimeChildET.setLayoutParams(lamaDateTimeChildETParams);
        lamaDateTimeChildET.setBackgroundResource(R.drawable.grey_border);
        lamaDateTimeChildET.setTextColor(ContextCompat.getColor(context, R.color.grey));
        lamaDateTimeChildET.setHintTextColor(ContextCompat.getColor(context, R.color.hint_grey));
        lamaDateTimeChildET.setHint(getResources().getString(R.string.lama_date_time_hint));
        lamaDateTimeChildET.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.sixteen));
        lamaDateTimeChildET.setPadding(10,12,15,12);
        lamaDateTimeChildET.setFocusable(false);
        lamaDateTimeLayout.addView(lamaDateTimeChildET);

        LinearLayout.LayoutParams showlamaDateTimeChildParams = new LinearLayout.LayoutParams(0,LayoutParams.WRAP_CONTENT);
        showlamaDateTimeChildParams.weight = 1f;
        LinearLayout  showlamaDateTimeChildLayout = new LinearLayout(context);
        showlamaDateTimeChildLayout.setLayoutParams(showlamaDateTimeChildParams);
        lamaDateTimeLayout.addView(showlamaDateTimeChildLayout);

        showlamaDateTimeChild = new ImageView(context);
        showlamaDateTimeChild.setBackgroundResource(R.drawable.datepicker);
        showlamaDateTimeChild.setScaleType(ImageView.ScaleType.CENTER_CROP);
        showlamaDateTimeChild.setAdjustViewBounds(true);
        showlamaDateTimeChildLayout.addView(showlamaDateTimeChild);

        childDeadLayout = new LinearLayout(context);
        childDeadLayout.setOrientation(VERTICAL);
        childDeadLayout.setVisibility(GONE);
        collapseView.addView(childDeadLayout);

        LinearLayout.LayoutParams childDeathCauseParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
        childDeathCauseParams.setMargins(0,12,0,0);
        childDeathCause = new TextView(context);
        childDeathCause.setLayoutParams(childDeathCauseParams);
        childDeathCause.setText(getResources().getString(R.string.child_death_cause));
        childDeathCause.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.sixteen));
        childDeathCause.setTextColor(ContextCompat.getColor(context, R.color.black));
        childDeadLayout.addView(childDeathCause);

        LinearLayout.LayoutParams childDeathCauseETParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
        childDeathCauseETParams.setMargins(0,8,0,0);
        childDeathCauseET = new EditText(context);
        childDeathCauseET.setLayoutParams(childDeathCauseETParams);
        childDeathCauseET.setBackgroundResource(R.drawable.grey_border);
        childDeathCauseET.setTextColor(ContextCompat.getColor(context, R.color.grey));
        childDeathCauseET.setHintTextColor(ContextCompat.getColor(context, R.color.hint_grey));
        childDeathCauseET.setHint(getResources().getString(R.string.child_death_cause_hint));
        childDeathCauseET.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.sixteen));
        childDeathCauseET.setPadding(10,12,15,12);
        childDeathCauseET.setSingleLine();
        childDeadLayout.addView(childDeathCauseET);

        LinearLayout.LayoutParams childDeathDateTimeParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        childDeathDateTimeParams.setMargins(0,20,0,0);
        childDeathDateTime = new TextView(context);
        childDeathDateTime.setText(getResources().getString(R.string.child_death_date_time));
        childDeathDateTime.setLayoutParams(childDeathDateTimeParams);
        childDeathDateTime.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.sixteen));
        childDeathDateTime.setTextColor(ContextCompat.getColor(context, R.color.black));
        childDeadLayout.addView(childDeathDateTime);

        LinearLayout.LayoutParams childDeathDateTimeLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
        childDeathDateTimeLayoutParams.setMargins(0,8,0,20);
        childDeathDateTimeLayout = new LinearLayout(context);
        childDeathDateTimeLayout.setLayoutParams(childDeathDateTimeLayoutParams);
        childDeathDateTimeLayout.setWeightSum(10f);
        childDeadLayout.addView(childDeathDateTimeLayout);

        LinearLayout.LayoutParams childDeathDateTimeETParams = new LinearLayout.LayoutParams(0,LayoutParams.WRAP_CONTENT);
        childDeathDateTimeETParams.weight = 9f;
        childDeathDateTimeETParams.setMargins(0,0,10,0);
        childDeathDateTimeET = new EditText(context);
        childDeathDateTimeET.setLayoutParams(childDeathDateTimeETParams);
        childDeathDateTimeET.setBackgroundResource(R.drawable.grey_border);
        childDeathDateTimeET.setTextColor(ContextCompat.getColor(context, R.color.grey));
        childDeathDateTimeET.setHintTextColor(ContextCompat.getColor(context, R.color.hint_grey));
        childDeathDateTimeET.setHint(getResources().getString(R.string.child_death_date_time_hint));
        childDeathDateTimeET.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.sixteen));
        childDeathDateTimeET.setPadding(10,12,15,12);
        childDeathDateTimeET.setFocusable(false);
        childDeathDateTimeLayout.addView(childDeathDateTimeET);

        LinearLayout.LayoutParams showChildDeathDateTimeParams = new LinearLayout.LayoutParams(0,LayoutParams.WRAP_CONTENT);
        showChildDeathDateTimeParams.weight = 1f;
        LinearLayout  showChildDeathDateTimeLayout = new LinearLayout(context);
        showChildDeathDateTimeLayout.setLayoutParams(showChildDeathDateTimeParams);
        childDeathDateTimeLayout.addView(showChildDeathDateTimeLayout);

        showChildDeathDateTime = new ImageView(context);
        showChildDeathDateTime.setBackgroundResource(R.drawable.datepicker);
        showChildDeathDateTime.setScaleType(ImageView.ScaleType.CENTER_CROP);
        showChildDeathDateTime.setAdjustViewBounds(true);
        showChildDeathDateTimeLayout.addView(showChildDeathDateTime);

    }
}
