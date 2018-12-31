package com.jiwoolee.android_view.adapterview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.jiwoolee.android_view.R;

import java.util.ArrayList;
import java.util.HashMap;

public class TwolinelistviewActivity extends AppCompatActivity {
    //textview가 두개 이상일 경우 = SimpleAdapter!!!! ****안드로이드제공

    ListView list3;
    TextView text3;
    String [] data4 = {
            "리스트1", "리스트2", "리스트3", "리스트4", "리스트5"
    };
    String [] data5 = {
            "1", "2", "3", "4", "5"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twolinelistview);

        text3 = (TextView)findViewById(R.id.textView4);
        list3 = (ListView)findViewById(R.id.list3);

        ArrayList<HashMap<String,Object>> data_list = new ArrayList<HashMap<String, Object>>();
        for(int i=0; i<data4.length; i++){
            HashMap<String,Object> map = new HashMap<String, Object>();
            map.put("str1",data4[i]);
            map.put("str2",data5[i]);

            data_list.add(map);
        }

        String [] keys = {"str1","str2"};

        //android.R.layout.simple_list_item_2 *******textview 2개, control 클릭으로 확인가능
        int [] ids = {android.R.id.text1, android.R.id.text2};

        SimpleAdapter adapter = new SimpleAdapter(this, data_list, android.R.layout.simple_list_item_2, keys, ids);
        list3.setAdapter(adapter);

        ListListener3 listener = new ListListener3();
        list3.setOnItemClickListener(listener);
    }

    //항목 터치시 호출되는 메서드
    class ListListener3 implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //position = 사용자가 터치한 항목의 인덱스 번호
            text3.setText(data4[position]);
        }
    }
}
