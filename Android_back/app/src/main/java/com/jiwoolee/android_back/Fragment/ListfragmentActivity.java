package com.jiwoolee.android_back.Fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.jiwoolee.android_back.R;

public class ListfragmentActivity extends AppCompatActivity {
    //fragment안에 listview 사용
    //listview의 id가 @android:id/list로 설정되어 있으면 자동으로 listview를 찾아 관리

    ListFragment list = new ListFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listfragment);

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction tran = manager.beginTransaction();
        tran.replace(R.id.list_container, list);
        tran.commit();
    }
}
