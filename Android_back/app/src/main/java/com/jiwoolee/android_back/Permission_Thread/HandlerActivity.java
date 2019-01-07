package com.jiwoolee.android_back.Permission_Thread;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.jiwoolee.android_back.R;

public class HandlerActivity extends AppCompatActivity {
    //반복(무한루프x -> handler!)
    //작업시간이 오래걸리지는 않지만 반복하는 경우! but, 메인쓰레드가 <쉬는 타임>이 있어야함 / 5초이상 작업 불가

    TextView text4, text5;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);

        text4 = (TextView)findViewById(R.id.textView4);
        text5 = (TextView)findViewById(R.id.textView5);

        handler = new Handler();
        ThreadClass thread = new ThreadClass();

        handler.post(thread); //*********
        //handler.postDelayed(thread, 100); //딜레이
    }

    public void btn_handler(View view){
        long now = System.currentTimeMillis();
        text4.setText("버튼 클릭 : "+now);
    }

    class ThreadClass extends Thread{
        @Override
        public void run() {
            long now = System.currentTimeMillis();
            text5.setText("핸들러 : "+now);

            handler.post(this); //현재 작업을 다시 요청*****
            //handler.postDelayed(thread, 100);
        }
    }
}
