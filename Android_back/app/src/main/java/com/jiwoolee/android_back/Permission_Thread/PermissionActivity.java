package com.jiwoolee.android_back.Permission_Thread;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jiwoolee.android_back.R;

public class PermissionActivity extends AppCompatActivity {
    /*
    in manifest
    <uses-permission android:name="android.permission.INTERNET"></uses-permission>
    <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION"></uses-permission>
    <uses-permission android:name="android.permission.READ_CONTACTS"></uses-permission>
    <uses-permission android:name="android.permission.WRITE_CONTACTS"></uses-permission>
    <uses-permission android:name="android.permission.SEND_SMS"></uses-permission>
    <uses-permission android:name="android.permission.RECEIVE_SMS"></uses-permission>
     */

    TextView text1;
    //체크할 권한 목록
    String [] permission_list = {
            Manifest.permission.INTERNET,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.READ_CONTACTS,
            Manifest.permission.WRITE_CONTACTS,
            Manifest.permission.SEND_SMS,
            Manifest.permission.RECEIVE_SMS
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);

        text1 = (TextView)findViewById(R.id.textView);

        checkPermission();
    }

    //권한 체크
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

    //위의 requestPermissions 창이 사라지면 자동으로 이 메서드 호출
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
                                                // 0                 permission_list 그대로           해당권한의 허용여부
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        text1.setText("");

        for (int i=0; i<grantResults.length; i++){
            if(grantResults[i]==PackageManager.PERMISSION_GRANTED) {
                text1.append(permissions[i] + "허용\n");
            }else{
                text1.append(permissions[i] + "거부\n");
            }
        }
    }
}
