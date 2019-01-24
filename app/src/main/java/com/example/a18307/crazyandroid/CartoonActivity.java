package com.example.a18307.crazyandroid;

import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import java.util.Timer;

import java.util.TimerTask;

public class CartoonActivity extends AppCompatActivity {
    int [] images=new int[]{R.drawable.p1,R.drawable.p2,R.drawable.p3,R.drawable.p4,
            R.drawable.p5,R.drawable.p6,R.drawable.p7,R.drawable.p8};
    int currentId=0;
    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartoon);
        final ImageView imageView=findViewById(R.id.image_cartoon);
            final Handler myHandler=new Handler(){
                @Override

                public void handleMessage(Message msg){
                    //接收发送过来的Message,如果发送的不是Message而是int型，就存在msg.what中
                    //判定
                    if (msg.what==0x1234){
                        //向组件中传入照片，根据余数来选择
                        imageView.setImageResource(images[currentId % images.length]);
                        currentId++;
                    }
                }
            };
        /*
            通过Timer组件调用schedule方法，创建一个计时器
            Timer创建TimerTask对象，这个对象本身是一个线程，
            每隔1.2秒向Handler中发送空消息，只传一个int
        */
        new Timer().schedule(new TimerTask(){
                @Override
                public void run(){
                    myHandler.sendEmptyMessage(0x1234);
                }

        },0,1200);
    }
}
