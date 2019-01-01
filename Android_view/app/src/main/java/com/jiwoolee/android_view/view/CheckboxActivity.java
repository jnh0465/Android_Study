package com.jiwoolee.android_view.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.jiwoolee.android_view.R;

public class CheckboxActivity extends AppCompatActivity {
    TextView text2;
    CheckBox check1, check2, check3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkbox);

        text2 = (TextView)findViewById(R.id.text2);
        check1 = (CheckBox)findViewById(R.id.checkBox);
        check2 = (CheckBox)findViewById(R.id.checkBox2);
        check3 = (CheckBox)findViewById(R.id.checkBox3);

        CheckBoxListener listener_check = new CheckBoxListener();
        check1.setOnCheckedChangeListener(listener_check);
        check2.setOnCheckedChangeListener(listener_check);
        check3.setOnCheckedChangeListener(listener_check);
    }

    //체크상태 가져오기
    public void btn1Method(View view){
        text2.setText("");
        boolean a1 = check1.isChecked();
        boolean a2 = check2.isChecked();
        boolean a3 = check3.isChecked();

        if(a1==true){
            text2.append("첫번째 체크박스 체크\n");
        }
        if(a2==true){
            text2.append("두번째 체크박스 체크\n");
        }
        if(a3==true){
            text2.append("세번째 체크박스 체크\n");
        }
    }

    //체크박스 모두 선택
    public void btn2Method(View view){
        check1.setChecked(true);
        check2.setChecked(true);
        check3.setChecked(true);
    }

    //체크박스 모두 해제
    public void btn3Method(View view){
        check1.setChecked(false);
        check2.setChecked(false);
        check3.setChecked(false);
    }

    //체크상태 토글
    public void btn4Method(View view){
        check1.toggle();
        check2.toggle();
        check3.toggle();
    }

    class CheckBoxListener implements CompoundButton.OnCheckedChangeListener{
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            int id = buttonView.getId(); //
            switch (id){
                case R.id.checkBox:
                    if(isChecked==true)
                        text2.setText("첫번째 체크박스 체크\n");
                    else
                        text2.setText("첫번째 체크박스 해제\n");
                    break;
                case R.id.checkBox2:
                    if(isChecked==true)
                        text2.setText("두번째 체크박스 체크\n");
                    else
                        text2.setText("두번째 체크박스 해제\n");
                    break;
                case R.id.checkBox3:
                    if(isChecked==true)
                        text2.setText("세번째 체크박스 체크\n");
                    else
                        text2.setText("세번째 체크박스 해제\n");
                    break;
            }
        }
    }

}
