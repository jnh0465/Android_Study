package com.jiwoolee.android_back.Components4.Activity1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.jiwoolee.android_back.R;

public class B_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
    }

    public void btn_b_ok(View view){
        setResult(RESULT_OK); //실행 결과 세팅
        finish();
    }

    public void btn_b_canceled(View view){
        setResult(RESULT_CANCELED); // 기본값
        finish();
    }

    public void btn_b_firstuser(View view){
        setResult(RESULT_FIRST_USER); //실행 결과 세팅
        finish();
    }
}
