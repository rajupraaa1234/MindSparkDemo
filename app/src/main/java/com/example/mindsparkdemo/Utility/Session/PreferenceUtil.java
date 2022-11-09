package com.example.mindsparkdemo.Utility.Session;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;



public class PreferenceUtil {

    public static final String SHARED_PREF_NAME = AppConstant.App_NAME;
    private final SharedPreferences mSpref;
    private final Context context;
    private String TAG = PreferenceUtil.class.getSimpleName();

    public PreferenceUtil(Context context) {
        this.context = context;
        mSpref = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
    }


    public static float getSharedPrefFloat(Context context, String key) {
        SharedPreferences userAcountPreference = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return userAcountPreference.getFloat(key, 0);
    }

    public int getIntData(String key) {
        return mSpref.getInt(key, 0);
    }

    public void setFloatData(Context context, String key, float value) {
        SharedPreferences.Editor appInstallInfoEditor = mSpref.edit();
        appInstallInfoEditor.putFloat(key, value);
        appInstallInfoEditor.commit();
    }

    public void setIntData(String key, int value) {
        SharedPreferences.Editor appInstallInfoEditor = mSpref.edit();
        appInstallInfoEditor.putInt(key, value);
        appInstallInfoEditor.commit();
    }

    public void setStringData(String key, String value) {
        SharedPreferences.Editor appInstallInfoEditor = mSpref.edit();
        appInstallInfoEditor.putString(key, value);
        appInstallInfoEditor.apply();
    }

    public boolean getBoolean(String key) {
        return mSpref.getBoolean(key, false);
    }

    public String getStringData(String key) {
        return mSpref.getString(key, "");

    }

    public String getStringDataFilterCount(String key) {
        return mSpref.getString(key, "0");

    }


    public void setBooleanData(String key, boolean value) {
        SharedPreferences.Editor appInstallInfoEditor = mSpref.edit();
        appInstallInfoEditor.putBoolean(key, value);
        appInstallInfoEditor.apply();
    }

    public long getLongValue(String key) {
        if (mSpref.contains(key))
            return mSpref.getLong(key, 0L);
        else
            Log.e(TAG, "KEY NOT FOUND");

        return 0l;
    }

    public void setLongData(String key, long value) {
        SharedPreferences.Editor editor = mSpref.edit();
        editor.putLong(key, value);
        editor.apply();
    }

    public void clear() {
        mSpref.edit().clear().apply();
    }

}
