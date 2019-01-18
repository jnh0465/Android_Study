package com.jiwoolee.android_back.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Switch;

import com.jiwoolee.android_back.R;

public class Activitycontroller extends AppCompatActivity {
    //MVC패턴
    //전체 화면을 fragment로 만들경우 Controller=Activity, View=Fragment
    //fragment는 onClick X, listener O

    InputFragment input = new InputFragment();
    ResultFragment result = new ResultFragment();

    String value1, value2; //공통적으로 사용할 변수

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activitycontroller);

        setFragment("input"); //InputFragment 배치
    }

    public void setFragment(String name){ //프레그먼트 관리 메서드
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction tran = manager.beginTransaction();
        switch (name){
            case "input":
                tran.replace(R.id.controller_container, input);
                break;
            case "result":
                tran.replace(R.id.controller_container, result);
                tran.addToBackStack(null);
                break;
        }
        tran.commit();
    }
}
