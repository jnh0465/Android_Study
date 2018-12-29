package com.jiwoolee.android_view.adapterview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.jiwoolee.android_view.R;

public class CustomlistviewActivity extends AppCompatActivity {
    //textview가 하나일경우 = ArrayAdapter!!!!

    ListView list1;
    TextView text1;
    //리스트뷰 구성을 위해 필요한 문자열 배열
    String [] data1 = {
            "리스트1", "리스트2", "리스트3", "리스트4", "리스트5", "리스트6", "리스트7", "리스트8", "리스트9", "리스트10", "리스트11", "리스트12"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customlistview);

        text1 = (TextView)findViewById(R.id.textView7);
        list1 = (ListView)findViewById(R.id.list1);
        //몇개의 항목?           => 배열, 리스트 개수
        //각 항목에 어떤 데이터? => 배열, 리스트에 들어있는 값
        //각 항목은 어떤 모양?   => 레이아웃

        //리스트뷰에 어뎁터 설정
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data1); //control 클릭해서 simple_list_item_1 확인가능, ****안드로이드제공
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.customlayout_row, R.id.textView_row,data1); // 레이아웃커스텀
        list1.setAdapter(adapter);

        ListListener listener = new ListListener();
        list1.setOnItemClickListener(listener);
    }

    //항목 터치시 호출되는 메서드
    class ListListener implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //position = 사용자가 터치한 항목의 인덱스 번호
            text1.setText(data1[position]);
        }
    }
}
