package com.jiwoolee.android_view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class ImageviewActivity extends AppCompatActivity {
    // drawble  어플 내부에서 사용하는 이미지
    // mipmap = 비트맵->벡터로 변환
    //          단말기별, 단말기별 해상도별(이미지,아이콘 확대축소)로 최적화된 이미지 제공
    //          주로 아이콘

    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imageview);

        img=(ImageView)findViewById(R.id.imageView2);
        img.setImageResource(R.drawable.ad1);
    }

}
