package nz.co.redice.demoservice.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Calendar;

import javax.inject.Inject;

import dagger.hilt.android.qualifiers.ApplicationContext;

import static android.content.Context.MODE_PRIVATE;

public class PrefHelper {

    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    private static final String MY_PREFS = "my prefs";
    private static final String MUTE_STATE = "mute state";
    private static final String SLEEP_TIME = "sleep time";
    private static final String WAKEUP_TIME = "wakeup time";

    private Context mContext;

    @Inject
    public PrefHelper(@ApplicationContext Context context) {
        mContext = context;
        mSharedPreferences = mContext.getSharedPreferences(MY_PREFS, MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();
    }

    public void addMuteState(Boolean state) {
        mEditor.putBoolean(MUTE_STATE, state);
        mEditor.apply();
    }

    public Boolean getMuteState() {
        return mSharedPreferences.getBoolean(MUTE_STATE, false);
    }

    public void setSleepTime(Long time) {
        mEditor.putLong(SLEEP_TIME, time).apply();
    }

    public Long getSleepTime() {
        return mSharedPreferences.getLong(SLEEP_TIME, Calendar.getInstance().getTimeInMillis());
    }

    public void setWakeUpTime(Long time) {
        mEditor.putLong(WAKEUP_TIME, time).apply();
    }
    public Long getWakeUpTime() {
        return mSharedPreferences.getLong(WAKEUP_TIME, Calendar.getInstance().getTimeInMillis());
    }



}