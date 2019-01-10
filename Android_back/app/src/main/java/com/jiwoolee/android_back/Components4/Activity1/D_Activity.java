package com.jiwoolee.android_back.Components4.Activity1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.jiwoolee.android_back.R;

public class D_Activity extends AppCompatActivity {
    TextView text27;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d);

        text27 = (TextView)findViewById(R.id.textView27);
        Intent intent = getIntent();

        TestClass t1 = intent.getParcelableExtra("test1");   // CREATOR.createFromParcel() 호출해 retunr값을 반환

        text27.setText("t1.data10 : " + t1.data10 + "\n");
        text27.append("t1.data20 : " + t1.data20);
    }

    public void btn_intent3(View view){
        Intent intent = new Intent();

        TestClass t2 = new TestClass();
        t2.data10 = 200;
        t2.data20 = "D->TestClass(Parcelable)->A";

        intent.putExtra("test2", t2);
        setResult(RESULT_OK, intent);
        finish();
    }
}








