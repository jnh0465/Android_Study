package com.jiwoolee.android_back.Permission_Thread;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.jiwoolee.android_back.R;

public class AsynctaskActivity extends AppCompatActivity {
    //비동기

    TextView text8, text9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asynctask);

        text8 = (TextView)findViewById(R.id.textView8);
        text9 = (TextView)findViewById(R.id.textView9);

        Asynctask async = new Asynctask();
        async.execute(10,20); //가동
    }

    public void btn_asynctask(View view){
        long now = System.currentTimeMillis();
        text8.setText("버튼 클릭 : "+now);
    }

    //Asynctask
    class Asynctask extends AsyncTask<Integer, Long, String>{
        //doInBackground()전에 호출, 메인쓰레드에서 처리 / 일반 쓰레드로 처리할 작업 동작 전 필요한 사전작업 처리
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            text9.setText("onPreExecute()");
        }

        //<일반쓰레드>에서 처리 / 네트워크 or 오래걸리는 작업 (화면처리x)
        @Override
        protected String doInBackground(Integer... integers) {
            int a = integers[0], b = integers[1];

            for(int i=0; i<5; i++){
                SystemClock.sleep(1000);
                a++;
                b++;
                Log.d("test",a+", "+b);
                //화면처리
                long now = System.currentTimeMillis();
                publishProgress(now);
            }
            return "작업 종료";
        }

        //doInBackground()내에서 화면처리가 필요할 때 (publishProgress()), 메인쓰레드 처리
        @Override
        protected void onProgressUpdate(Long... values) {
            super.onProgressUpdate(values);
            text9.setText("onProgressUpdate() : "+values[0]);
        }

        //doInBackground()완료 후 호출, 메인쓰레드 처리, doInBackground() return 값이 들어옴
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            text9.setText("onPostExecute() : "+s);
        }
    }
}
