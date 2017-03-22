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
    public void setSettings(){
        Calendar calendar = Calendar.getInstance();
        int hour;
        int minutes;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            hour = timePicker.getHour();
            minutes = timePicker.getMinute();
        } else {
            hour = timePicker.getCurrentHour();
            minutes = timePicker.getCurrentMinute();
        }
    }
}
