package com.jiwoolee.android_back.DataManagement;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.jiwoolee.android_back.R;

public class ScreenrotationActivity extends AppCompatActivity {

    /*
     manifest에서 화면 세로로 고정
      <activity android:name=".DataManagement.ScreenrotationActivity"
                android:screenOrientation="portrait"/>
     */

    EditText edit3;
    TextView text49;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screenrotation);

        edit3 = (EditText)findViewById(R.id.editText3);
        text49 = (TextView)findViewById(R.id.textView49);

        //화면 회전이 발생했을 경우만 처리
        if(savedInstanceState != null){
            String str2 = savedInstanceState.getString("data1");
            text49.setText(str2);
        }
    }

    public void btn_screenfirst(View view){
        String str = edit3.getText().toString();
        text49.setText(str);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {     //화면 회전 발생시 호출되는 메서드
        super.onSaveInstanceState(outState);

        outState.putString("data1", text49.getText().toString()); //화면 복원에 필요한 데이터 저장
    }
}
