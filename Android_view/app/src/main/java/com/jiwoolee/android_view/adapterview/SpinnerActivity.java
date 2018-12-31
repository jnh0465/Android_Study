package com.jiwoolee.android_view.adapterview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.jiwoolee.android_view.R;

import java.util.ArrayList;

public class SpinnerActivity extends AppCompatActivity {
    //사용자가 항목 AdapterView

    String [] data6 = {
            "스피너1", "스피너2", "스피너3", "스피너4", "스피너5"
    };
    Spinner spin1;
    TextView text4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        spin1 = (Spinner)findViewById(R.id.spinner);
        text4 = (TextView)findViewById(R.id.textView11);

        //어뎁터 생성   android.R.layout.simple_spinner_item == 안드로이드 제공레이아웃
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data6);
        //드롭다운으로 나타나는 항목 리스트의 뷰
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //에뎁터를 스피너에 적용
        spin1.setAdapter(adapter);

        SpinnerListener listener = new SpinnerListener();
        spin1.setOnItemSelectedListener(listener);
    }

    public void btnMethod1(View view){
        int index = spin1.getSelectedItemPosition();         //스피너에서 선택된 항목의 인덱스 값 추출
        text4.setText("선택된 항목 : "+data6[index]);
    }

    //스피너에서 항목을 선택하자마자 반응하는 리스너
    class SpinnerListener implements AdapterView.OnItemSelectedListener{
        //선택했을 때
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            text4.setText(data6[position]);
        }

        //아무것도 선택하지 않았을 때
        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
}
