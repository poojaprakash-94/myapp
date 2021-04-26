package com.example.myapp.helper;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;

public class PrefManager
{
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;
    int PRIVATE_MODE = 0;
    private static final String KEY_CODE = "code";
    private static final String KEY_NUMBER = "number";
    private static final String KEY_IS_LOGGED_IN = "is_logged";
    private static final String PREF_NAME = "myapp_data";
    private static final String KEY_IS_WAITING_FOR_SMS ="is_waiting_for_sms";


    public PrefManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setIsWaitingForSms(boolean isWaiting) {
        editor.putBoolean(KEY_IS_WAITING_FOR_SMS, isWaiting);
        editor.commit();
    }

    public boolean isWaitingForSms() {
        return pref.getBoolean(KEY_IS_WAITING_FOR_SMS, false);
    }

    public void setMobileNumber(String mobileNumber) {
        editor.putString(KEY_CODE, mobileNumber);
        editor.commit();
    }

    public String getMobileNumber() {
        return pref.getString(KEY_CODE, null);
    }

    public void createLogin(String code,String number) {
        editor.putString(KEY_CODE, code);
        editor.putString(KEY_NUMBER, number);
        editor.putBoolean(KEY_IS_LOGGED_IN, true);
        editor.commit();
    }

    public boolean isLoggedIn() {
        return pref.getBoolean(KEY_IS_LOGGED_IN, false);
    }

    public void clearSession() {
        editor.clear();
        editor.commit();
    }

    public HashMap<String, String> getUserDetails() {
        HashMap<String, String> profile = new HashMap<>();
        profile.put("name", pref.getString(KEY_CODE, null));
        profile.put("mobile", pref.getString(KEY_NUMBER, null));
        return profile;
    }
}
