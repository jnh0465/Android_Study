package com.jiwoolee.android_back.Fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.jiwoolee.android_back.R;

public class DialfragmentActivity extends AppCompatActivity {
    //AlertDialog를 fragment에서 사용하도록,

    TextView text36;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialfragment);

        text36 = (TextView)findViewById(R.id.textView36);
    }

    public void btn_dialfrag(View view){
        DialFragment dial = new DialFragment(); //다이얼로그를 띄울 프레그먼트 객체 생성
        FragmentManager manager = getSupportFragmentManager();
        dial.show(manager, "tag"); //다이얼로그 프레그먼트를 띄움
    }
}
