package com.jiwoolee.android_view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ButtonActivity extends AppCompatActivity {
    TextView text1;
    Button button1, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);

        text1 = (TextView)findViewById(R.id.text1);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);

        ButtonActivity.BtnListener12 listener12 = new ButtonActivity.BtnListener12();
        button1.setOnClickListener(listener12);
        button2.setOnClickListener(listener12);
    }

    class BtnListener12 implements View.OnClickListener{
        @Override
        public void onClick(View v){
            int id = v.getId(); // 뷰 id값 추출
            switch (id){        // id로 분기
                case R.id.button1:
                    text1.setText("첫번째 버튼 누름");
                    break;
                case R.id.button2:
                    text1.setText("두번째 버튼 누름");
                    break;
            }
        }
    }
}
