package com.jiwoolee.android_view.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.jiwoolee.android_view.R;

import org.w3c.dom.Text;

public class EdittextActivity extends AppCompatActivity {
    EditText edit1;
    TextView text1;

    //edittext simeOptions 키보드의 엔터버튼 변경

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edittext);

        edit1=(EditText)findViewById(R.id.editText1);
        text1=(TextView)findViewById(R.id.textView3);

        EnterListener listener = new EnterListener();
        edit1.setOnEditorActionListener(listener);

        WatcherClass watcher = new WatcherClass();
        edit1.addTextChangedListener(watcher);
    }

    public void btn12Method(View view){
        edit1.setText("새롭게 설정한 문자열");
    }

    public void btn13Method(View view){
        String str = edit1.getText().toString();
        text1.setText("입력한 문자열 : "+str);
    }

    //엔터키 누르면 반응하는 리스너
    class EnterListener implements TextView.OnEditorActionListener{
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            String str = v.getText().toString();
            text1.setText("입력한 문자열 : "+str);

            //return false;  //입력후 키보드 사라짐
            return true;     //입력후 키보드 유지
        }
    }

    //입력할 때 마다 반응하는 리스너
    class WatcherClass implements TextWatcher{
        //문자열값이 변경되었을 때
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            text1.setText("문자열 변경중 : "+s);
        }

        //문자열값이 변경되기 전
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        //문자열값이 변경된 이후
        @Override
        public void afterTextChanged(Editable s) {
        }
    }
}
