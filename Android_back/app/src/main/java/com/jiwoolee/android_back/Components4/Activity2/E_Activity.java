package com.jiwoolee.android_back.Components4.Activity2;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.jiwoolee.android_back.R;

public class E_Activity extends AppCompatActivity {

    String [] permission_list = {
            Manifest.permission.CALL_PHONE
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e);
        checkPermission();
    }

    public void btn_toview(View view){
        Intent intent = new Intent("com.to.view");
        startActivity(intent);
    }

    public void btn_map(View view){
        Uri uri = Uri.parse("geo:37.243243, 131.861601");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void btn_web(View view){
        Uri uri = Uri.parse("http://developer.android.com");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void btn_dial(View view){
        Uri uri = Uri.parse("tel:00000000000");
        Intent intent = new Intent(Intent.ACTION_DIAL, uri);
        startActivity(intent);
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

    public void btn_call(View view){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            int check = checkCallingOrSelfPermission(Manifest.permission.CALL_PHONE); //허용여부 확인
            if(check== PackageManager.PERMISSION_DENIED){ //거부상태일 때
                return;
            }
        }

        Uri uri = Uri.parse("tel:00000000000");
        Intent intent = new Intent(Intent.ACTION_CALL, uri);
        startActivity(intent);
    }
}
