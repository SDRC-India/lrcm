package org.sdrc.lrcasemanagement.customclass;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.text.InputFilter;
import android.text.InputType;
import android.text.method.DigitsKeyListener;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import org.sdrc.lrcasemanagement.R;

/**
 * Created by SDRC_DEV on 2/28/2017.
 */

public class CustomChildInfoLayout extends LinearLayout {

    public TextView childTxt, stillBirthTxt, childSexTxt, childWeightTxt, stillBirthType, congenitalAnomaliesTxt,
            babyBreastFeedTxt, rescusitationTxt, bcgGivenTxt, zeroOpvGivenTxt, hepBZeroGivenTxt, injVitKGivenTxt;
    public View view;
    public RadioGroup sexRadioGroup;
    public ToggleButton stillBirthTB, congenitalAnomalies, babyBreastFeed, rescusitation, bcgGiven, zeroOpvGiven, hepBZero, injVitK;
    public RadioButton sexMale, sexFemale;
    public EditText weightEditBox, stillBirthTypeEditBox;
    public LinearLayout linearLayout, collapseLayout, collapseView, stillBirthLayout, childOtherLayout;
    public ImageView expandCollapseImgBtn;
    public boolean collapseViewFlag = false;
    int newWidth;
    public CustomChildInfoLayout(final Context context) {
        super(context);

        DisplayMetrics metrics = this.getResources().getDisplayMetrics();
        int width = metrics.widthPixels;
        if (width > 720)
            newWidth = width/7;
        else
            newWidth = width/5;

        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        params.setMargins(0,5,0,0);
        setOrientation(VERTICAL);
        setLayoutParams(params);

        LayoutParams params1 = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        linearLayout = new LinearLayout(context, null, R.style.AppTheme);
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

        LinearLayout.LayoutParams childTxtParams = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT);
        childTxtParams.weight =9f;
        childTxtParams.setMargins(15,15,15,15);
        childTxt =  new TextView(context);
        childTxt.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.sixteen));
        childTxt.setTypeface(childTxt.getTypeface(), Typeface.BOLD);
        childTxt.setLayoutParams(childTxtParams);
        childTxt.setText("Child Info");
        childTxt.setTextColor(Color.parseColor("#ffffff"));
        collapseLayout.addView(childTxt);

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

        RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        params2.setMargins(0,15,0,0);
        RelativeLayout stillChildLayout = new RelativeLayout(context);
        stillChildLayout.setLayoutParams(params2);
        collapseView.addView(stillChildLayout);

        RelativeLayout.LayoutParams stillBirthTxtParam = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        stillBirthTxtParam.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        stillBirthTxt = new TextView(context);
        stillBirthTxt.setLayoutParams(stillBirthTxtParam);
        stillBirthTxt.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.sixteen));
        stillBirthTxt.setText(getResources().getString(R.string.still_child));
        stillBirthTxt.setPadding(0,15,0,0);
        stillBirthTxt.setTextColor(Color.parseColor("#000000"));
        stillChildLayout.addView(stillBirthTxt);

        RelativeLayout.LayoutParams stillBirthTBParam = new RelativeLayout.LayoutParams(newWidth, RelativeLayout.LayoutParams.WRAP_CONTENT);
        stillBirthTBParam.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        stillBirthTB = new ToggleButton(new ContextThemeWrapper(context, R.style.Theme_AppCompat_Light_NoActionBar));
        stillBirthTB.setLayoutParams(stillBirthTBParam);
        stillBirthTB.setTextOff("NO");
        stillBirthTB.setTextOn("YES");
        stillBirthTB.setChecked(false);
        stillChildLayout.addView(stillBirthTB);

        childSexTxt =  new TextView(context);
        childSexTxt.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.sixteen));
        childSexTxt.setText(getResources().getString(R.string.sex));
        childSexTxt.setTextColor(Color.parseColor("#000000"));
        collapseView.addView(childSexTxt);

        LayoutParams childSexParam = new LayoutParams(LayoutParams.MATCH_PARENT, 70);
        childSexParam.setMargins(0,15,0,0);
        sexRadioGroup = new RadioGroup(context);
        sexRadioGroup.setLayoutParams(childSexParam);
        sexRadioGroup.setGravity(Gravity.CENTER_VERTICAL);
        sexRadioGroup.setOrientation(HORIZONTAL);
        sexRadioGroup.setBackgroundResource(R.drawable.grey_border);
        sexRadioGroup.setPadding(10,10,10,10);
        collapseView.addView(sexRadioGroup);

        sexMale = new RadioButton(new ContextThemeWrapper(context, R.style.Theme_AppCompat_Light_NoActionBar));
        sexMale.setText(getResources().getString(R.string.male));
        sexMale.setPadding(0,0,20,0);
        sexMale.setTextColor(Color.parseColor("#000000"));
        sexRadioGroup.addView(sexMale);


        sexFemale = new RadioButton(new ContextThemeWrapper(context, R.style.Theme_AppCompat_Light_NoActionBar));
        sexFemale.setText(getResources().getString(R.string.female));
        sexFemale.setTextColor(Color.parseColor("#000000"));
        sexRadioGroup.addView(sexFemale);

        LayoutParams childWeightParam = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        childWeightParam.setMargins(0,15,0,0);
        LinearLayout childWeightLayout = new LinearLayout(context);
        childWeightLayout.setLayoutParams(childWeightParam);
        childWeightLayout.setOrientation(HORIZONTAL);
        collapseView.addView(childWeightLayout);

        LayoutParams weightTxtParam = new LayoutParams(0, LayoutParams.WRAP_CONTENT,4f);
        childWeightTxt =  new TextView(context);
        childWeightTxt.setLayoutParams(weightTxtParam);
        childWeightTxt.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.sixteen));
        childWeightTxt.setText(getResources().getString(R.string.weight));
        childWeightTxt.setTextColor(Color.parseColor("#000000"));
        childWeightLayout.addView(childWeightTxt);

        LayoutParams weightEditParam = new LayoutParams(0, 70 ,3f);
        weightEditBox = new EditText(context);
        weightEditBox.setLayoutParams(weightEditParam);
        weightEditBox.setBackgroundResource(R.drawable.grey_border);
        weightEditBox.setTextColor(Color.parseColor("#000000"));
        weightEditBox.setHintTextColor(ContextCompat.getColor(context, R.color.grey));
        weightEditBox.setHint(getResources().getString(R.string.weight_in_kg));
        weightEditBox.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.sixteen));
        weightEditBox.setPadding(15,5,5,5);
        weightEditBox.setInputType(InputType.TYPE_CLASS_NUMBER);
        weightEditBox.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL);
        weightEditBox.setKeyListener(DigitsKeyListener.getInstance(false,true));
        int maxLengthofWeight = 4;
        weightEditBox.setFilters(new InputFilter[] {new InputFilter.LengthFilter(maxLengthofWeight)});
        weightEditBox.setSingleLine();
        childWeightLayout.addView(weightEditBox);

        LayoutParams stillBirthParam = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        stillBirthParam.setMargins(0,15,0,0);
        stillBirthLayout = new LinearLayout(context);
        stillBirthLayout.setLayoutParams(stillBirthParam);
        stillBirthLayout.setOrientation(VERTICAL);
        collapseView.addView(stillBirthLayout);

        stillBirthType =  new TextView(context);
        stillBirthType.setText(getResources().getString(R.string.still_birth_type));
        stillBirthType.setTextColor(Color.parseColor("#000000"));
        stillBirthType.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.sixteen));
        stillBirthLayout.addView(stillBirthType);

        LayoutParams stillBirthTypeParam = new LayoutParams(LayoutParams.MATCH_PARENT, 70);
        stillBirthTypeParam.setMargins(0,10,0,0);
        stillBirthTypeEditBox = new EditText(context);
        stillBirthTypeEditBox.setBackgroundResource(R.drawable.grey_border);
        stillBirthTypeEditBox.setLayoutParams(stillBirthTypeParam);
        stillBirthTypeEditBox.setTextColor(Color.parseColor("#000000"));
        stillBirthTypeEditBox.setHintTextColor(Color.parseColor("#000000"));
        stillBirthTypeEditBox.setPadding(15,5,5,5);
        stillBirthTypeEditBox.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.sixteen));
        stillBirthTypeEditBox.setHint(getResources().getString(R.string.choose));
        stillBirthLayout.addView(stillBirthTypeEditBox);

        LayoutParams childLayoutParam = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        childOtherLayout = new LinearLayout(context);
        childOtherLayout.setLayoutParams(childLayoutParam);
        childOtherLayout.setOrientation(VERTICAL);
        collapseView.addView(childOtherLayout);

        LinearLayout childLayout1 = new LinearLayout(context);
        childLayout1.setPadding(0,15,0,0);
        childLayout1.setOrientation(HORIZONTAL);
        childLayout1.setWeightSum(10f);
        childOtherLayout.addView(childLayout1);

        LinearLayout.LayoutParams congenitalAnomaliesTxtParam = new LinearLayout.LayoutParams(0,LinearLayout.LayoutParams.WRAP_CONTENT);
        if (width > 720){
            congenitalAnomaliesTxtParam.weight = 8.4f;
        } else {
            congenitalAnomaliesTxtParam.weight = 7.7f;
        }
        congenitalAnomaliesTxtParam.gravity = Gravity.CENTER_VERTICAL;
        congenitalAnomaliesTxt = new TextView(context);
        congenitalAnomaliesTxt.setLayoutParams(congenitalAnomaliesTxtParam);
        congenitalAnomaliesTxt.setText(getResources().getString(R.string.congenital_anomalies));
        congenitalAnomaliesTxt.setTextColor(Color.parseColor("#000000"));
        congenitalAnomaliesTxt.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.sixteen));
        childLayout1.addView(congenitalAnomaliesTxt);

        LinearLayout.LayoutParams congenitalAnomaliesParam = new LinearLayout.LayoutParams(0,LinearLayout.LayoutParams.WRAP_CONTENT);
        if (width > 720){
            congenitalAnomaliesParam.weight = 1.6f;
        } else {
            congenitalAnomaliesParam.weight = 2.3f;
        }
        congenitalAnomalies = new ToggleButton(new ContextThemeWrapper(context, R.style.Theme_AppCompat_Light_NoActionBar));
        congenitalAnomalies.setLayoutParams(congenitalAnomaliesParam);
        congenitalAnomalies.setTextOff("NO");
        congenitalAnomalies.setTextOn("YES");
        congenitalAnomalies.setChecked(false);
        childLayout1.addView(congenitalAnomalies);

        LinearLayout childLayout2 = new LinearLayout(context);
        childLayout2.setPadding(0,15,0,0);
        childLayout2.setOrientation(HORIZONTAL);
        childLayout2.setWeightSum(10f);
        childOtherLayout.addView(childLayout2);

        LinearLayout.LayoutParams babyBreastFeedTxtParam = new LinearLayout.LayoutParams(0,LinearLayout.LayoutParams.WRAP_CONTENT);
        if (width > 720){
            babyBreastFeedTxtParam.weight = 8.4f;
        } else {
            babyBreastFeedTxtParam.weight = 7.7f;
        }
        babyBreastFeedTxtParam.gravity = Gravity.CENTER_VERTICAL;
        babyBreastFeedTxt = new TextView(context);
        babyBreastFeedTxt.setLayoutParams(babyBreastFeedTxtParam);
        babyBreastFeedTxt.setText(getResources().getString(R.string.breat_feed));
        babyBreastFeedTxt.setTextColor(Color.parseColor("#000000"));
        babyBreastFeedTxt.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.sixteen));
        childLayout2.addView(babyBreastFeedTxt);

        LinearLayout.LayoutParams babyBreastFeedParam = new LinearLayout.LayoutParams(0,LinearLayout.LayoutParams.WRAP_CONTENT);
        if (width > 720){
            babyBreastFeedParam.weight = 1.6f;
        } else {
            babyBreastFeedParam.weight = 2.3f;
        }
        babyBreastFeed = new ToggleButton(new ContextThemeWrapper(context, R.style.Theme_AppCompat_Light_NoActionBar));
        babyBreastFeed.setLayoutParams(babyBreastFeedParam);
        babyBreastFeed.setTextOff("NO");
        babyBreastFeed.setTextOn("YES");
        babyBreastFeed.setChecked(false);
        childLayout2.addView(babyBreastFeed);


        LinearLayout childLayout3 = new LinearLayout(context);
        childLayout3.setPadding(0,15,0,0);
        childLayout3.setOrientation(HORIZONTAL);
        childLayout3.setWeightSum(10f);
        childOtherLayout.addView(childLayout3);

        LinearLayout.LayoutParams rescusitationTxtParam = new LinearLayout.LayoutParams(0,LinearLayout.LayoutParams.WRAP_CONTENT);
        if (width > 720){
            rescusitationTxtParam.weight = 8.4f;
        } else {
            rescusitationTxtParam.weight = 7.7f;
        }
        rescusitationTxtParam.gravity = Gravity.CENTER_VERTICAL;
        rescusitationTxt = new TextView(context);
        rescusitationTxt.setLayoutParams(rescusitationTxtParam);
        rescusitationTxt.setText(getResources().getString(R.string.rescusitation));
        rescusitationTxt.setTextColor(Color.parseColor("#000000"));
        rescusitationTxt.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.sixteen));
        childLayout3.addView(rescusitationTxt);

        LinearLayout.LayoutParams rescusitationParam = new LinearLayout.LayoutParams(0,LinearLayout.LayoutParams.WRAP_CONTENT);
        if (width > 720){
            rescusitationParam.weight = 1.6f;
        } else {
            rescusitationParam.weight = 2.3f;
        }
        rescusitation = new ToggleButton(new ContextThemeWrapper(context, R.style.Theme_AppCompat_Light_NoActionBar));
        rescusitation.setLayoutParams(rescusitationParam);
        rescusitation.setTextOff("NO");
        rescusitation.setTextOn("YES");
        rescusitation.setChecked(false);
        childLayout3.addView(rescusitation);


        LinearLayout childLayout4 = new LinearLayout(context);
        childLayout4.setPadding(0,15,0,0);
        childLayout4.setOrientation(HORIZONTAL);
        childLayout4.setWeightSum(10f);
        childOtherLayout.addView(childLayout4);

        LinearLayout.LayoutParams bcgGivenTxtParam = new LinearLayout.LayoutParams(0,LinearLayout.LayoutParams.WRAP_CONTENT);
        if (width > 720){
            bcgGivenTxtParam.weight = 8.4f;
        } else {
            bcgGivenTxtParam.weight = 7.7f;
        }
        bcgGivenTxtParam.gravity = Gravity.CENTER_VERTICAL;
        bcgGivenTxt = new TextView(context);
        bcgGivenTxt.setLayoutParams(bcgGivenTxtParam);
        bcgGivenTxt.setText(getResources().getString(R.string.bcg));
        bcgGivenTxt.setTextColor(Color.parseColor("#000000"));
        bcgGivenTxt.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.sixteen));
        childLayout4.addView(bcgGivenTxt);

        LinearLayout.LayoutParams bcgGivenParam = new LinearLayout.LayoutParams(0,LinearLayout.LayoutParams.WRAP_CONTENT);
        if (width > 720){
            bcgGivenParam.weight = 1.6f;
        } else {
            bcgGivenParam.weight = 2.3f;
        }
        bcgGiven = new ToggleButton(new ContextThemeWrapper(context, R.style.Theme_AppCompat_Light_NoActionBar));
        bcgGiven.setLayoutParams(bcgGivenParam);
        bcgGiven.setTextOff("NO");
        bcgGiven.setTextOn("YES");
        bcgGiven.setChecked(false);
        childLayout4.addView(bcgGiven);


        LinearLayout childLayout5 = new LinearLayout(context);
        childLayout5.setPadding(0,15,0,0);
        childLayout5.setOrientation(HORIZONTAL);
        childLayout5.setWeightSum(10f);
        childOtherLayout.addView(childLayout5);

        LinearLayout.LayoutParams zeroOpvGivenTxtParam = new LinearLayout.LayoutParams(0,LinearLayout.LayoutParams.WRAP_CONTENT);
        if (width > 720){
            zeroOpvGivenTxtParam.weight = 8.4f;
        } else {
            zeroOpvGivenTxtParam.weight = 7.7f;
        }
        zeroOpvGivenTxtParam.gravity = Gravity.CENTER_VERTICAL;
        zeroOpvGivenTxt = new TextView(context);
        zeroOpvGivenTxt.setLayoutParams(zeroOpvGivenTxtParam);
        zeroOpvGivenTxt.setText(getResources().getString(R.string.opv));
        zeroOpvGivenTxt.setTextColor(Color.parseColor("#000000"));
        zeroOpvGivenTxt.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.sixteen));
        childLayout5.addView(zeroOpvGivenTxt);

        LinearLayout.LayoutParams zeroOpvGivenParam = new LinearLayout.LayoutParams(0,LinearLayout.LayoutParams.WRAP_CONTENT);
        if (width > 720){
            zeroOpvGivenParam.weight = 1.6f;
        } else {
            zeroOpvGivenParam.weight = 2.3f;
        }
        zeroOpvGiven = new ToggleButton(new ContextThemeWrapper(context, R.style.Theme_AppCompat_Light_NoActionBar));
        zeroOpvGiven.setLayoutParams(zeroOpvGivenParam);
        zeroOpvGiven.setTextOff("NO");
        zeroOpvGiven.setTextOn("YES");
        zeroOpvGiven.setChecked(false);
        childLayout5.addView(zeroOpvGiven);

        LinearLayout childLayout6 = new LinearLayout(context);
        childLayout6.setPadding(0,15,0,0);
        childLayout6.setOrientation(HORIZONTAL);
        childLayout6.setWeightSum(10f);
        childOtherLayout.addView(childLayout6);

        LinearLayout.LayoutParams hepBZeroGivenTxtParam = new LinearLayout.LayoutParams(0,LinearLayout.LayoutParams.WRAP_CONTENT);
        if (width > 720){
            hepBZeroGivenTxtParam.weight = 8.4f;
        } else {
            hepBZeroGivenTxtParam.weight = 7.7f;
        }
        hepBZeroGivenTxtParam.gravity = Gravity.CENTER_VERTICAL;
        hepBZeroGivenTxt = new TextView(context);
        hepBZeroGivenTxt.setLayoutParams(hepBZeroGivenTxtParam);
        hepBZeroGivenTxt.setText(getResources().getString(R.string.hbv));
        hepBZeroGivenTxt.setTextColor(Color.parseColor("#000000"));
        hepBZeroGivenTxt.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.sixteen));
        childLayout6.addView(hepBZeroGivenTxt);

        LinearLayout.LayoutParams hepBZeroGiven = new LinearLayout.LayoutParams(0,LinearLayout.LayoutParams.WRAP_CONTENT);
        if (width > 720){
            hepBZeroGiven.weight = 1.6f;
        } else {
            hepBZeroGiven.weight = 2.3f;
        }
        hepBZero = new ToggleButton(new ContextThemeWrapper(context, R.style.Theme_AppCompat_Light_NoActionBar));
        hepBZero.setLayoutParams(hepBZeroGiven);
        hepBZero.setTextOff("NO");
        hepBZero.setTextOn("YES");
        hepBZero.setChecked(false);
        childLayout6.addView( hepBZero);


        LinearLayout childLayout7 = new LinearLayout(context);
        childLayout7.setPadding(0,15,0,0);
        childLayout7.setOrientation(HORIZONTAL);
        childLayout7.setWeightSum(10f);
        childOtherLayout.addView(childLayout7);

        LinearLayout.LayoutParams injVitKGivenTxtParam = new LinearLayout.LayoutParams(0,LinearLayout.LayoutParams.WRAP_CONTENT);
        if (width > 720){
            injVitKGivenTxtParam.weight = 8.4f;
        } else {
            injVitKGivenTxtParam.weight = 7.7f;
        }
        injVitKGivenTxtParam.gravity = Gravity.CENTER_VERTICAL;
        injVitKGivenTxt = new TextView(context);
        injVitKGivenTxt.setLayoutParams(injVitKGivenTxtParam);
        injVitKGivenTxt.setText(getResources().getString(R.string.vit_k_inj));
        injVitKGivenTxt.setTextColor(Color.parseColor("#000000"));
        injVitKGivenTxt.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.sixteen));
        childLayout7.addView(injVitKGivenTxt);

        LinearLayout.LayoutParams injVitKGiven = new LinearLayout.LayoutParams(0,LinearLayout.LayoutParams.WRAP_CONTENT);
        if (width > 720){
            injVitKGiven.weight = 1.6f;
        } else {
            injVitKGiven.weight = 2.3f;
        }
        injVitK = new ToggleButton(new ContextThemeWrapper(context, R.style.Theme_AppCompat_Light_NoActionBar));
        injVitK.setLayoutParams(injVitKGiven);
        injVitK.setTextOff("NO");
        injVitK.setTextOn("YES");
        injVitK.setChecked(false);
        childLayout7.addView( injVitK);

    }
}
