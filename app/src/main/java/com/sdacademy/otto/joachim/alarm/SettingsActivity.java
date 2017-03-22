package com.sdacademy.otto.joachim.alarm;

import android.content.SharedPreferences;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TimePicker;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SettingsActivity extends AppCompatActivity {

    public static final String TAG = "alarm_shared_preferences";
    public static final String HOUR_KEY = "hour";
    public static final String MINUTES_KEY = "minutes";
    SharedPreferences sharedPreferences;

    @BindView(R.id.SettingsTimePicker)
    TimePicker timePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        ButterKnife.bind(this);
        timePicker.setIs24HourView(true);
        sharedPreferences = getSharedPreferences(TAG, MODE_PRIVATE);
    }

    @OnClick(R.id.SetButton)
    public void setSettings() {
        Calendar calendar = Calendar.getInstance();
        int hour = getHour();
        int minutes = getMinutes();
        saveDataToSharedPreferences(hour, minutes);
    }

    private int getMinutes() {
        int minutes;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            minutes = timePicker.getMinute();
        } else {
            minutes = timePicker.getCurrentMinute();
        }
        return minutes;
    }

    private int getHour() {
        int hour;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            hour = timePicker.getHour();
        } else {
            hour = timePicker.getCurrentHour();
        }
        return hour;
    }

    private void saveDataToSharedPreferences(int hour, int minutes) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(HOUR_KEY, hour);
        editor.putInt(MINUTES_KEY, minutes);
        editor.apply();
    }
}
