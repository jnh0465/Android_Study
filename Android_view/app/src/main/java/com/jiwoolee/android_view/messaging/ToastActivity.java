package com.jiwoolee.android_view.messaging;

import android.content.Context;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jiwoolee.android_view.R;

public class ToastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);

    }

    public void btn_toast(View view){
        Toast t1 = Toast.makeText(this,"토스트 메세지", Toast.LENGTH_SHORT);
        t1.show();
    }

    public void btn_toast2(View view) {
        //뷰 객체 생성
        LayoutInflater inflater = getLayoutInflater();
        View v1 = inflater.inflate(R.layout.custom_toast, null);

        //
        //뷰가 가지고 있는 뷰 추출
        ImageView img_toast = (ImageView)v1.findViewById(R.id.imageView5);
        TextView text_toast = (TextView)v1.findViewById(R.id.textView22);
        img_toast.setImageResource(R.drawable.ic_launcher_background);
        text_toast.setText("커스텀 토스트");

        v1.setBackgroundResource(android.R.drawable.toast_frame);         //뷰의 배경을 토스트 전용 배경 이미지로 설정(어두운 회색)
        text_toast.setTextColor(Color.BLUE);                              //글씨 색
        //

        Toast t2 = new Toast(this);
        t2.setView(v1);

        t2.setGravity(Gravity.CENTER, 0,0);              //토스트 위치(화면중앙, CENTER를 중앙으로해서 X축으로 0만큼, Y축으로 0만큼)
        t2.setDuration(Toast.LENGTH_SHORT);                               //토스트 시간
        t2.show();
    }
}
