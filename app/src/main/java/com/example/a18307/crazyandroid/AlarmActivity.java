package com.example.a18307.crazyandroid;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

public class AlarmActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //加载指定音乐，并创建MediaPlayer对象
        mediaPlayer=MediaPlayer.create(this,R.raw.hotel_california);
        mediaPlayer.setLooping(true);
        //播放音乐
        mediaPlayer.start();
        //创建一个对话框
        new AlertDialog.Builder(AlarmActivity.this).setTitle("闹钟")
        .setMessage("闹钟响了,Go").setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //停止音乐
                mediaPlayer.stop();
                //结束该Activitry
                AlarmActivity.this.finish();
            }
        }).show();
    }
}
