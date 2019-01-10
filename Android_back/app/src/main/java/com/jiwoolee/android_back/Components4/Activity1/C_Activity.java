package com.jiwoolee.android_back.Components4.Activity1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.jiwoolee.android_back.R;

public class C_Activity extends AppCompatActivity {

    TextView text25;
    final int C_ACTIVITY = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);

        text25 = (TextView)findViewById(R.id.textView25);

        //*************
        Intent intent = getIntent();
        int data1 = intent.getIntExtra("data1", 0);
        double data2 = intent.getDoubleExtra("data1", 0.0);
        boolean data3 = intent.getBooleanExtra("data3", false);
        String data4 = intent.getStringExtra("data4");

        text25.setText("data1 : "+data1+"\n");
        text25.append("data2 : "+data2+"\n");
        text25.append("data3 : "+data3+"\n");
        text25.append("data4 : "+data4);
    }

    public void btn_intent2(View view){
        Intent intent = new Intent();
        intent.putExtra("value1", 200);
        intent.putExtra("value2", 22.22);
        intent.putExtra("value3", true);
        intent.putExtra("value4", "C에서 온 데이터");
        setResult(C_ACTIVITY, intent); //****
        finish();
    }
}
