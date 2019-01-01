package com.jiwoolee.android_view.adapterview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.jiwoolee.android_view.R;

public class CustomadaptActivity  extends AppCompatActivity {
    //리스트뷰 + 특별한 기능 추가
    //BaseAdapter

    ListView list4;
    TextView text4;

    String [] data6 = {
            "리스트1", "리스트2", "리스트3", "리스트4", "리스트5"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customadapter);

        text4 = (TextView)findViewById(R.id.textView10);
        list4 = (ListView)findViewById(R.id.list4);

        ListAdapter adapter = new ListAdapter();
        list4.setAdapter(adapter);
    }

    //항목 터치시 호출되는 메서드
    class ListAdapter extends BaseAdapter{
        BtnListener listener = new BtnListener();

        //리스트뷰 내의 전체 항목의 개수 반환
        @Override
        public int getCount() {
            return data6.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        //리스트 뷰 항목 하나를 구성하여 반환
        //항목이 10개면 getView method 10번 호출
        //항목이 100개라면 100개 호출하는 것이 아니라 화면에 보이는 개수(예를들면 10개)만큼 호출
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //postion 몇 번째 항목인지
            //convertview 재사용가능한(스크롤내릴시 없어지는 항목들, 밑에 안보이는 항목들)

            //재사용가능한 뷰가 없다면 뷰를 만듦
            if(convertView==null){
                LayoutInflater inflater = getLayoutInflater();
                convertView = inflater.inflate(R.layout.customlayout_adapter, null);
            }
            //뷰를 구성
            TextView sub_text = (TextView)convertView.findViewById(R.id.textView9);
            Button sub_btn1 = (Button)convertView.findViewById(R.id.button17);
            Button sub_btn2 = (Button)convertView.findViewById(R.id.button18);

            sub_btn1.setOnClickListener(listener);
            sub_btn2.setOnClickListener(listener);

            //***********버튼에 인덱스 값 저장
            sub_btn1.setTag(position);
            sub_btn2.setTag(position);

            sub_text.setText(data6[position]);

            //뷰를 반환
            return convertView;
        }
    }

    //항목에 배치된 버튼 셋팅 리스너
    class  BtnListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            int id = v.getId();

            //********리스트의 인덱스값 추출
            int position = (Integer)v.getTag();

            switch (id){
                case R.id.button17 :
                    text4.setText("첫번째 버튼을 눌렀습니다"+position);
                    break;
                case R.id.button18 :
                    text4.setText("두번째 버튼을 눌렀습니다"+position);
                    break;
            }
        }
    }
}
