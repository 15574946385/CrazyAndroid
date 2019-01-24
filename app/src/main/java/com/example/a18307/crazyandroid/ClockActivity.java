package com.example.a18307.crazyandroid;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

public class ClockActivity extends AppCompatActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock);
        Button button=findViewById(R.id.btn_clock);
        //为按钮设置监听器
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar currentTime=Calendar.getInstance();
                //Intent intent=new Intent(ClockActivity.this,AlarmActivity.class);
                //startActivity(intent);
                //创建TimePickerDialog实例，并显示出来
                new TimePickerDialog(ClockActivity.this, 0, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourofDay, int minute) {
                        //指定启动AlarmActivity组件
                        Intent intent=new Intent(ClockActivity.this,AlarmActivity.class);
                        //创建PendingIntent对象
                        PendingIntent pendingIntent=PendingIntent.getActivity(ClockActivity.this,0,intent,0);
                        Calendar calendar=Calendar.getInstance();
                        calendar.setTimeInMillis(System.currentTimeMillis());
                        //根据用户选择时间来设置Calendar对象
                        calendar.set(Calendar.HOUR,hourofDay);
                        calendar.set(Calendar.MINUTE,minute);
                        //获取AlarmManager对象
                        AlarmManager alarmManager=(AlarmManager)getSystemService(ALARM_SERVICE);

                        //设置AlarmManager将在Calendar对应的时间启动指定组件
                        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),pendingIntent);
                        //显示闹铃设置成功的提示信息
                        Toast.makeText(ClockActivity.this,"成功",Toast.LENGTH_SHORT).show();
                    }
                },currentTime.get(Calendar.HOUR_OF_DAY),currentTime.get(Calendar.MINUTE),false).show();

            }
        });
    }
}


