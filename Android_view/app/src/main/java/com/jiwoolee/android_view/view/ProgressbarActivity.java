package com.jiwoolee.android_view.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.jiwoolee.android_view.R;

public class ProgressbarActivity extends AppCompatActivity {
    ProgressBar bar4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progressbar);

        bar4 = (ProgressBar)findViewById(R.id.progressBar4);
    }

    //추가
    public void btn5Method(View view){
        bar4.incrementProgressBy(5);
    }

    //감소
    public void btn6Method(View view){
        bar4.incrementProgressBy(-5);
    }

    //지정
    public void btn7Method(View view){
        bar4.setProgress(80);
    }
}
