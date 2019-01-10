package com.jiwoolee.android_back.Components4.Activity1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.jiwoolee.android_back.R;

public class A_Activity extends AppCompatActivity {
    /*
     안드로이드 4대 구성요소는 모두 manifest에 등록되어 있어야함
        <activity android:name=".Components4.ActivityActivity">
        </activity>
     */

    //A activity에서 B activity를 실행하고 다시 A로 돌아왔을 때 어떤 처리 필요 = startActivity()가 아닌 startActivityForResult()
    //startActivityForResult()를 이용해 B로 가고 다시 A로 돌아오면 자동으로 onActivityResult() 호출

    final int B_ACTIVITY = 1; //액티비티 구분하기 위한 값

    TextView text22;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        text22 = (TextView)findViewById(R.id.textView22);
    }

    public void btn_tob(View view){
        Intent intent = new Intent(this, B_Activity.class);
        //startActivity(intent);
        startActivityForResult(intent, B_ACTIVITY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
                                    // 분기,     B에서의 ***setResult로 설정한 값, intent 값
        super.onActivityResult(requestCode, resultCode, data);
        //text17.setText("다른 Activity 실행 후 돌아옴(onActivityResult())"); //requestCode로 분기(startActivityForResult(intent,_____(이 값)))
        switch (requestCode){
            case B_ACTIVITY:
                text22.setText("B Activity에서 돌아옴 - onActivityResult()\n");
                switch (resultCode){
                    case RESULT_OK:
                        text22.append("requestCode : RESULT_OK");
                        break;
                    case RESULT_CANCELED:
                        text22.append("requestCode : RESULT_CANCELED");
                        break;
                    case RESULT_FIRST_USER:
                        text22.append("requestCode : RESULT_FIRST_USER");
                        break;
                }
                break;
        }
    }
}
