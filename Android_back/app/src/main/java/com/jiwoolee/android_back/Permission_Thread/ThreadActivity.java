package com.jiwoolee.android_back.Permission_Thread;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.jiwoolee.android_back.R;

public class ThreadActivity extends AppCompatActivity {
    //쓰레드 = 비동기, 네트워크에 필요
    //ANR(Application Not Respond) = 메인스레드가 바쁠때(무한루프..) 화면 작업이 발생하면 ANR발생(흰화면) -> 메인스레드는 반드시 끝나야함
    //오레오(8.0)부터 개발자가 발생시킨 쓰레드에서 화면처리 가능

    TextView text2, text3;
    boolean isRunning = false; //쓰레드 동작 여부

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);

        text2 = (TextView)findViewById(R.id.textView2);
        text3 = (TextView)findViewById(R.id.textView3);

//        while (true){
//            SystemClock.sleep(100);
//            long now = System.currentTimeMillis();
//            text3.setText("무한루프"+now);
//        }

        //쓰레드 발생
        isRunning = true;
        ThreadClass thread = new ThreadClass();
        thread.start();
    }

    public void btn_thread(View view){
        long now = System.currentTimeMillis();
        text2.setText("버튼 클릭 : "+now);
    }

    //쓰레드 클래스
    class ThreadClass extends Thread{
        @Override
        public void run() {
            while (isRunning){
                SystemClock.sleep(100);
                long now = System.currentTimeMillis();
                //Log.d("test", "쓰레드 : "+now);
                text3.setText("쓰레드 : "+now);
            }
        }
    }

    //어플이 꺼졌을 때 쓰레드 종료
    @Override
    protected void onDestroy() {
        super.onDestroy();
        isRunning = false;
    }
}
