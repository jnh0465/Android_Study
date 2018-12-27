package com.jiwoolee.android_view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

public class SeekbarActivity extends AppCompatActivity {
    SeekBar seek1, seek2;
    TextView text1, text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seekbar);

        seek1 = (SeekBar)findViewById(R.id.seekBar);
        seek2 = (SeekBar)findViewById(R.id.seekBar2);
        text1 = (TextView) findViewById(R.id.textView);
        text2 = (TextView) findViewById(R.id.textView2);

        SeekBarListener listener = new SeekBarListener();
        seek1.setOnSeekBarChangeListener(listener);
        seek2.setOnSeekBarChangeListener(listener);
    }

    //증가
    public void btn8Method(View view){
        seek1.incrementProgressBy(1);
        seek2.incrementProgressBy(1);
    }

    //감소
    public void btn9Method(View view){
        seek1.incrementProgressBy(-1);
        seek2.incrementProgressBy(-1);
    }

    //지정
    public void btn10Method(View view){
        seek1.setProgress(8);
        seek2.setProgress(3);
    }

    //
    public void btn11Method(View view){
        int value1 = seek1.getProgress();
        int value2 = seek2.getProgress();

        text1.setText("seek1: "+value1);
        text2.setText("seek2: "+value2);
    }

    class SeekBarListener implements SeekBar.OnSeekBarChangeListener{

        //값을 변경시켰을 때 호출되는 메서드
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        // fromUser true:사용자에 의해 false:코드에 의해
            int id = seekBar.getId();
            switch (id){
                case R.id.seekBar:
                    text1.setText("첫번째 Seekbar : "+progress);
                    break;
                case R.id.seekBar2:
                    text1.setText("두번째 Seekbar : "+progress);
                    break;
            }

            if(fromUser==true){
                text2.setText("사용자에 의해 변경되었습니다.");
            }else {
                text2.setText("코드에 의해 변경되었습니다.");
            }
        }

        //값을 변경하기 위해 터치하면 호출되는 메서드
        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            int id = seekBar.getId();
            switch (id){
                case R.id.seekBar:
                    text2.setText("첫번째 Seekbar를 터치했습니다.");
                    break;
                case R.id.seekBar2:
                    text2.setText("두번째 Seekbar를 터치했습니다.");
                    break;
            }
        }

        //값을 변경하고 터치를 때면 호출되는 메서드
        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            int id = seekBar.getId();
            switch (id){
                case R.id.seekBar:
                    text2.setText("첫번째 Seekbar를 떼었습니다.");
                    break;
                case R.id.seekBar2:
                    text2.setText("두번째 Seekbar를 떼었습니다.");
                    break;
            }
        }
    }
}
