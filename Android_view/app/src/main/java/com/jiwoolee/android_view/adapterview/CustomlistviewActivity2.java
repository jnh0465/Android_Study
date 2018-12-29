package com.jiwoolee.android_view.adapterview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.jiwoolee.android_view.R;

import java.util.ArrayList;
import java.util.HashMap;

public class CustomlistviewActivity2 extends AppCompatActivity {
    //textview가 두개 이상일 경우 = SimpleAdapter!!!!
    //이미지하나 텍스트두개

    ListView list2;
    TextView text2;
    int [] img = {
            R.drawable.ad1, R.drawable.ad2, R.drawable.ad3, R.drawable.ad4, R.drawable.ad5
    };
    String [] data2 = {
            "리스트1", "리스트2", "리스트3", "리스트4", "리스트5"
    };
    String [] data3 = {
            "1", "2", "3", "4", "5"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customlistview2);

        text2 = (TextView)findViewById(R.id.textView8);
        list2 = (ListView)findViewById(R.id.list2);

        //항목하나를 구성하기 위한 데이터를 HashMap에 다 담음
        //HashMap을 항목의 개수만큼 만듦(순서대로)
        //HashMape들을 ArrayList에 담아줌
        //ArrayList를 Adapter에 세팅

        //데이터를 가지고 있는 ArrayList 생성
        ArrayList<HashMap<String,Object>> data_list = new ArrayList<HashMap<String, Object>>();
        //데이터를 담는다
        for(int i=0; i<img.length; i++){
            //항목 하나를 구성하기 위한 데이터를 HashMap에 담는다
            HashMap<String,Object> map = new HashMap<String, Object>();
            map.put("img",img[i]);
            map.put("data2",data2[i]);
            map.put("data3",data3[i]);

            //ArrayList에 담음
            data_list.add(map);
        }

        String [] keys = {"img","data2","data3"};                               //HashMape 객체에 데이터를 저장할 때 사용한 이름 배열
        int [] ids = {R.id.imageView4, R.id.textView_row2, R.id.textView_row3}; // 데이터를 셋팅할 뷰의 id
        //각각의 key의 이름으로 map의 데이터를 추출해서 img[i], data2[i], data3[i]의 값을 R.id.imageView4, R.id.textView_row2, R.id.textView_row3에 해당하는 뷰에 세팅

        //어뎁터 세팅
        SimpleAdapter adapter = new SimpleAdapter(this, data_list, R.layout.customlayout_row2, keys, ids);
        list2.setAdapter(adapter);

        ListListener2 listener = new ListListener2();
        list2.setOnItemClickListener(listener);
    }

    //항목 터치시 호출되는 메서드
    class ListListener2 implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //position = 사용자가 터치한 항목의 인덱스 번호
            text2.setText(data2[position]);
        }
    }
}
