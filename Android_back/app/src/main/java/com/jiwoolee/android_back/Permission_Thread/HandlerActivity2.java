package com.jiwoolee.android_back.Permission_Thread;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.jiwoolee.android_back.R;

public class HandlerActivity2 extends AppCompatActivity {
    //쓰레드에서 코드 처리 중 화면 처리가 필요할때 Handler이용

    TextView text6, text7;
    boolean isRunning = false; //무한루프를 종료하기 위한 변수
    DisplayHandler handler; //일반쓰레드에서 요청한 화면처리용 핸들러

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler2);

        text6 = (TextView)findViewById(R.id.textView6);
        text7 = (TextView)findViewById(R.id.textView7);
        handler = new DisplayHandler();

//        while (true){
//            SystemClock.sleep(100);
//            long now = System.currentTimeMillis();
//            text7.setText("무한루프"+now);
//        }

        isRunning = true;
        ThreadClass thread = new ThreadClass();
        thread.start();
    }

    public void btn_handler2(View view){
        long now = System.currentTimeMillis();
        text6.setText("버튼 클릭 : "+now);
    }

    class ThreadClass extends Thread{
        @Override
        public void run() {
            while (isRunning){
                long now = System.currentTimeMillis();
                //Log.d("test", "쓰레드 : "+now);
                //text7.setText("쓰레드 : "+now);

                SystemClock.sleep(100);
                handler.sendEmptyMessage(0); //*********0은 작업구분
                SystemClock.sleep(100);
                handler.sendEmptyMessage(1);
                SystemClock.sleep(100);

                int a=10, b=20;
                // 핸들러 요청을 할 떄 화면 처리를 위한 데이터 전달!
                Message msg = new Message();
                msg.what = 2;
                msg.arg1 = ++a; msg.arg2 = ++b; msg.obj = now; //정수값 2개 객체 1개
                handler.sendMessage(msg);
            }
        }
    }

    //*************
    //개발자가 발생시킨 쓰레드에서 화면 처리를 하기위해 작업을 요청하면 자동으로 호출되는 메서드(메인쓰레드처리)
    class DisplayHandler extends Handler{
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
//            long now = System.currentTimeMillis();
//            text7.setText("핸들러 : "+now);
            switch (msg.what){
                case 0:
                    text7.setText("핸들러1");
                    break;
                case 1:
                    text7.setText("핸들러2");
                    break;
                case 2:
                    text7.setText(msg.arg1+", "+msg.arg2+", "+msg.obj);
                    break;
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
