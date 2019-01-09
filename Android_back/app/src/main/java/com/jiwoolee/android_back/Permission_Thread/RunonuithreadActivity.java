package com.jiwoolee.android_back.Permission_Thread;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.jiwoolee.android_back.R;

public class RunonuithreadActivity extends AppCompatActivity {
    //개발자가 발생시킨 일반 쓰레드의 코드 일부를 메인쓰레드에서 처리하도록하는 메서드
    //핸들러와 비슷. 핸들러는 모듈(여러번), runOnUiThread()는 한번만
    //1)Thread+Handler 2)Asynctask 3)Thread+runOnUiThread // 다 같은데 편한 방법 선택

    TextView text11, text12;
    boolean isRunning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_runonuithread);

        text11 = (TextView)findViewById(R.id.textView11);
        text12 = (TextView)findViewById(R.id.textView12);

        isRunning = true;
        ThreadClass thread = new ThreadClass();
        thread.start();
    }


    public void btn_runonui(View view){
        long now = System.currentTimeMillis();
        text11.setText("버튼 클릭 : " + now);
    }

    class ThreadClass extends Thread{
        @Override
        public void run() {
            while(isRunning){
                SystemClock.sleep(100);

                final long time = System.currentTimeMillis();
                //Log.d("test", "쓰래드 : " + time);
                // 일반 쓰래드에서 화면 처리가 필요할 경우 runOnUiThread 메서드를 사용한다. **************
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        text12.setText("쓰래드 : " + time);
                    }
                });
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        isRunning = false;
    }
}
