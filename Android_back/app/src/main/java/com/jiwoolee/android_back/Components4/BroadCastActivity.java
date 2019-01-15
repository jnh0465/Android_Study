package com.jiwoolee.android_back.Components4;

import android.Manifest;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.jiwoolee.android_back.R;

public class BroadCastActivity extends AppCompatActivity {
    //명시적 인텐트(클래스명 직접기술, 한 번에 하나만), 암시적 인텐트(intent filter를 통해 설정한 이름 이용, 선택or모두)
    //8.0부터 달라짐

    TestReceiver tr;

    String [] permission_list = {
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.RECEIVE_SMS
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);

        //8.0이상이면 암시적 인텐트를 코드로 등록
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            tr = new TestReceiver();
            IntentFilter filter = new IntentFilter("com.jiwoolee.br");
            registerReceiver(tr, filter);
        }

        checkPermission();
    }

    @Override
    protected void onDestroy() { //어플 종료시 꺼줘야함
        super.onDestroy();
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            if(tr != null){
                unregisterReceiver(tr);
                tr = null;
            }
        }
    }

    public void btn_eintent(View view){
        //명시적 인텐트
        Intent intent = new Intent();
        intent.setClassName("com.jiwoolee.android_back", "com.jiwoolee.android_back.Components4.TestReceiver");
        sendBroadcast(intent);
    }

    public void btn_iintent(View view){
        //암시적 인텐트(8.0미만)
        /*
        in androidmanifest
           <receiver
            android:name=".TestReceiver"
            android:enabled="true"
            android:exported="true">
            <intent-filter>
                <action android:name="com.jiwoolee.br"></action>
            </intent-filter>
        </receiver>
         */
        Intent intent = new Intent("com.jiwoolee.br");
        sendBroadcast(intent);

        //암시적 인텐트(8.0이상_제약사항) -> 코드로
    }

    public void checkPermission(){
        //6.0(마시멜로)미만이면 권한이 안되기 때문에 메서드 종료
        if(Build.VERSION.SDK_INT<Build.VERSION_CODES.M){
            return;
        }

        for(String permission : permission_list){
            int check = checkCallingOrSelfPermission(permission); //허용여부 확인
            if(check== PackageManager.PERMISSION_DENIED){ //거부상태일 때
                requestPermissions(permission_list, 0); //사용자에게 권한 허용여부 창 띄우기
            }
        }
    }
}
