package org.sdrc.lrcasemanagement.activity;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.telephony.TelephonyManager;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.sdrc.lrcasemanagement.R;
import org.sdrc.lrcasemanagement.asynctask.LoginAsyncTask;
import org.sdrc.lrcasemanagement.listener.LoginListener;
import org.sdrc.lrcasemanagement.model.LoginDataModel;
import org.sdrc.lrcasemanagement.model.realmmodel.Area;
import org.sdrc.lrcasemanagement.model.realmmodel.Child;
import org.sdrc.lrcasemanagement.model.realmmodel.ChildStatus;
import org.sdrc.lrcasemanagement.model.realmmodel.Data;
import org.sdrc.lrcasemanagement.model.realmmodel.Patient;
import org.sdrc.lrcasemanagement.model.realmmodel.SysConfig;
import org.sdrc.lrcasemanagement.model.realmmodel.Type;
import org.sdrc.lrcasemanagement.model.realmmodel.TypeDetails;
import org.sdrc.lrcasemanagement.model.realmmodel.User;
import org.sdrc.lrcasemanagement.util.Constant;
import org.sdrc.lrcasemanagement.util.LRCM;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

public class LoginActivity extends AppCompatActivity implements LoginListener {

    private static final String TAG = LoginActivity.class.getName();

    private ProgressDialog progressDialog;
    private AlertDialog alertDialog;
    private ImageView showHide;
    Boolean showHideFlag = false;
    private TextInputLayout passwordTxt;

    public static final int MY_PERMISSIONS_REQUEST_READ_PHONE_STATE = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(getString(R.string.activity_title_login));
        setSupportActionBar(toolbar);
        LRCM.getInstance().setApplicationContext(LoginActivity.this);
//        Realm realm = LRCM.getInstance().getRealm();
//        realm.beginTransaction();
//        RealmResults<Patient> results = realm.where(Patient.class).findAll();
//        Patient p = results.get(0);
//        p.setClosed(false);
//        realm.commitTransaction();
//        Toast.makeText(this, "" + p.getClosed(), Toast.LENGTH_SHORT).show();
//        LRCM.getInstance().closeRealm();

        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );

        if (Build.VERSION.SDK_INT >= 6.0) {
            if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.READ_PHONE_STATE)
                    == PackageManager.PERMISSION_GRANTED) {
                callPhoneState();
            } else {
                if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_PHONE_STATE)) {
                    Toast.makeText(getApplicationContext(), "Phone state requried to read the phone state", Toast.LENGTH_SHORT).show();
                }
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_STATE}, MY_PERMISSIONS_REQUEST_READ_PHONE_STATE);
            }
        } else {
            callPhoneState();
        }

        //progress dialog code
        progressDialog = new ProgressDialog(LoginActivity.this);
        progressDialog.setTitle(getString(R.string.logging_in));
        progressDialog.setMessage(getString(R.string.please_wait));
        progressDialog.setCancelable(false);

        //alert dialog code
        alertDialog = new AlertDialog.Builder(LoginActivity.this).create();
        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, getString(R.string.ok), new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                alertDialog.dismiss();
            }
        });

        passwordTxt = (TextInputLayout) findViewById(R.id.passwordWrapper);
        showHide = (ImageView) findViewById(R.id.show_hide);
        showHide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (showHideFlag) {
                    passwordTxt.getEditText().setTransformationMethod(PasswordTransformationMethod.getInstance());
                    showHide.setImageResource(R.drawable.show);
                    showHideFlag = false;
                } else {
                    passwordTxt.getEditText().setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    showHide.setImageResource(R.drawable.hide);
                    showHideFlag = true;
                }
            }
        });
    }


    public void callPhoneState() {
        ((Button) findViewById(R.id.login_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                int sync_timeout_in_second = 60;

                //if somebody give string value in the strings.xml, we have to handle that
                try {
                    sync_timeout_in_second = Integer.parseInt(getString(R.string.login_timeout_in_second));
                } catch (Exception e) {
                    Log.w(TAG, getString(R.string.invalid_timeout));
                }
                LRCM.getInstance().setApplicationContext(LoginActivity.this);
                LoginAsyncTask loginAsyncTask = new LoginAsyncTask();
                loginAsyncTask.setLoginListener(LoginActivity.this);

                if (((EditText) findViewById(R.id.username_text_field)).getText().toString().equals("") ||
                        ((EditText) findViewById(R.id.password_text_field)).getText().toString().equals("")) {
                    Toast.makeText(getApplication(), R.string.invalid_credentials, Toast.LENGTH_SHORT).show();
                } else {
                    Realm realm = LRCM.getInstance().getRealm();
                    User user = realm.where(User.class).findFirst();
                    TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
                    String imei = telephonyManager.getDeviceId();
                    LRCM.getInstance().setImei(imei);
                    if (user == null) {
                        progressDialog.show();
                    }

                    LRCM.getInstance().closeRealm();

                    loginAsyncTask.execute(
                            ((EditText) findViewById(R.id.username_text_field)).getText().toString(),
                            ((EditText) findViewById(R.id.password_text_field)).getText().toString(),
                            getString(R.string.server_url), sync_timeout_in_second, isNetworkAvailable(), imei);

                }
            }
        });
    }

    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_READ_PHONE_STATE: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                    callPhoneState();
                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }
        }
    }

    @Override
    public void loginComplete(LoginDataModel loginDataModel) {
        if (loginDataModel != null) {
            switch (loginDataModel.getResult()) {
                case Constant.Result.SUCCESS:
                    progressDialog.dismiss();
                    //Temporary we are going to Patient list activity. Later we will go via home
                    Intent intent = new Intent(LoginActivity.this, PatientListActivity.class);
                    startActivity(intent);
                    finish();
                    break;
                case Constant.Result.NO_INTERNET:
                    progressDialog.dismiss();
                    Toast.makeText(this, getString(R.string.internet_check), Toast.LENGTH_SHORT).show();
                    break;
                case Constant.Result.NO_IMEI:
                    progressDialog.dismiss();
                    Toast.makeText(this, getString(R.string.no_imei), Toast.LENGTH_SHORT).show();
                    break;
                case Constant.Result.ERROR:
                    progressDialog.dismiss();
                    alertDialog.setTitle(getString(R.string.error));
                    alertDialog.setMessage(loginDataModel.getMessage());
                    alertDialog.show();
                    break;
                case Constant.Result.SERVER_ERROR:
                    progressDialog.dismiss();
                    alertDialog.setTitle(getString(R.string.error));
                    alertDialog.setMessage(loginDataModel.getMessage());
                    alertDialog.show();
                    break;
                case Constant.Result.INVALID_CREDENTIALS:
                    progressDialog.dismiss();
                    Toast.makeText(this, getString(R.string.invalid_credentials), Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
        } else {
            progressDialog.dismiss();
            Toast.makeText(this, getString(R.string.error), Toast.LENGTH_SHORT).show();
        }

    }

    /**
     * This method will check whethere there is a network connectivity or not
     *
     * @return true if there is network connectivity, false if there is not network connectivity
     */
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

}
