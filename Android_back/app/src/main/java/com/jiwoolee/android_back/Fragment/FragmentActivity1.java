package com.jiwoolee.android_back.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.jiwoolee.android_back.R;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

public class FragmentActivity1 extends AppCompatActivity {
    //AddToBackStack fragment 뒤로가기

    FirstFragment first = new FirstFragment();
    SecondFragment second = new SecondFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
    }

    public void btn_first(View view){
        FragmentManager manager = getSupportFragmentManager(); //프레그먼트 관리 객체
        FragmentTransaction tran = manager.beginTransaction(); //프레그먼트 변경 관리 객체
        //tran.add(R.id.container, first); //프레그먼트 추가
        tran.replace(R.id.container, first); //프레그먼트 대체

        tran.addToBackStack(null); //프레그먼트 변경사항을 백스텍에 포함
        tran.commit();
    }

    public void btn_second(View view){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction tran = manager.beginTransaction();
        tran.replace(R.id.container, second);
        tran.addToBackStack(null);
        tran.commit();
    }
}
