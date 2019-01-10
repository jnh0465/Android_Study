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
    final int C_ACTIVITY = 2;
    final int D_ACTIVITY = 3;

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

    public void btn_toc(View view){
        //Intent로 데이터 전달
        Intent intent = new Intent(this, C_Activity.class);
        intent.putExtra("data1", 100);
        intent.putExtra("data2", 11.11);
        intent.putExtra("data3", true);
        intent.putExtra("data4", "A에서 온 데이터");
        startActivityForResult(intent, C_ACTIVITY);
    }

    public void btn_tod(View view){
        Intent intent = new Intent(this, D_Activity.class);

        TestClass t1 = new TestClass();
        t1.data10 = 100;
        t1.data20 = "A->TestClass(Parcelable)->D";

        // 객체가 가지고 있는 writeToParcel 메서드를 호출한다.
        intent.putExtra("test1", t1);

        // startActivity(intent);
        startActivityForResult(intent, D_ACTIVITY);
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

            case C_ACTIVITY:
                int value1 = data.getIntExtra("value1", 0);
                double value2 = data.getDoubleExtra("value2", 0.0);
                boolean value3 = data.getBooleanExtra("value3", false);
                String value4 = data.getStringExtra("value4");

                text22.setText("C Activity에서 돌아옴 - onActivityResult()\n");
                text22.append("value1 : "+value1+"\n");
                text22.append("value2 : "+value2+"\n");
                text22.append("value3 : "+value3+"\n");
                text22.append("value4 : "+value4);
                break;
        }

        if(requestCode == D_ACTIVITY){
            if(resultCode == RESULT_OK){
                // 객체를 추출한다.
                TestClass t2 = data.getParcelableExtra("test2");

                text22.setText("D Activity에서 돌아옴 - onActivityResult()\n");
                text22.append("t2.data10 : " + t2.data10 + "\n");
                text22.append("t2.data20 : " + t2.data20);
            }
        }
    }
}
