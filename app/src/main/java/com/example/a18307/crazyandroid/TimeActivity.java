package com.example.a18307.crazyandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.TextClock;

public class TimeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        AnalogClock analogClock=findViewById(R.id.aClock1);
        TextClock textClock=findViewById(R.id.tClock1);
    }
}
