package com.jiwoolee.android_view.messaging;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.jiwoolee.android_view.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class DialogActivity extends AppCompatActivity {
    //다이얼로그 버튼 3개까지!

    TextView text11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        text11 = (TextView)findViewById(R.id.textView23);
    }

    //다이얼로그
    public void btn_dialog(View view){
        //다이얼로그 정보 관리 객체
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("기본 다이얼로그");   //제목
        builder.setMessage("다이얼로그 본문"); //본문
        builder.setIcon(R.mipmap.ic_launcher); //아이콘

        Dialog1Listener listener = new Dialog1Listener();
        //builder.setPositiveButton("Positive",null);
        builder.setPositiveButton("Positive",listener); //다이얼로그 버튼 3개 세팅(Neutral-Negative-Positive순서로)
        builder.setNeutralButton("Neutral",listener);
        builder.setNegativeButton("Negative",listener);

        builder.show(); //띄우기
    }

    //다이얼로그 리스너
    class Dialog1Listener implements DialogInterface.OnClickListener{
        @Override
        public void onClick(DialogInterface dialog, int which) {
                                                     //종류값
            //버튼 종류값으로 분기
            switch (which){
                case DialogInterface.BUTTON_POSITIVE:
                    text11.setText("Positive");
                    break;
                case DialogInterface.BUTTON_NEUTRAL:
                    text11.setText("Neutral");
                    break;
                case DialogInterface.BUTTON_NEGATIVE:
                    text11.setText("Negative");
                    break;
            }
        }
    }

    //커스텀 다이얼로그
    public void btn_dialog2(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("커스텀 다이얼로그");   //제목
        builder.setIcon(R.mipmap.ic_launcher); //아이콘

        //다이얼로그를 통해 보여줄 뷰 설정
        LayoutInflater inflater = getLayoutInflater();
        View v1 = inflater.inflate(R.layout.custom_dialog, null);
        builder.setView(v1);

        Dialog2Listener listener2 = new Dialog2Listener();

        builder.setPositiveButton("확인",listener2);
        builder.setNegativeButton("취소", listener2);

        builder.show(); //띄우기
    }

    //커스텀 다이얼로그 리스너
    class Dialog2Listener implements DialogInterface.OnClickListener{
        @Override
        public void onClick(DialogInterface dialog, int which) {
            //AlertDialog가 가지고 있는 뷰를 가져옴
            AlertDialog alert = (AlertDialog)dialog;
            EditText edit1 = (EditText)alert.findViewById(R.id.editText);
            EditText edit2 = (EditText)alert.findViewById(R.id.editText2);

            String str1 = edit1.getText().toString(); //문자열가져옴
            String str2 = edit2.getText().toString();

            text11.setText("edit1 : "+str1+"\n");
            text11.append("edit2 : "+str2);
        }
    }

    //데이트 다이얼로그
    public void btn_dialog3(View view){
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        Dialog3Listener listener3 = new Dialog3Listener();

        DatePickerDialog picker = new DatePickerDialog(this, listener3, year, month, day);
        picker.show();
    }

    //데이트 다이얼로그 리스너
    class Dialog3Listener implements DatePickerDialog.OnDateSetListener{
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                                //  년, 월(0부터시작),     일
            text11.setText(year+"년 "+(month+1)+"월 "+dayOfMonth+"일");
        }
    }

    //타임피커 다이얼로그
    public void btn_dialog4(View view){
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);

        Dialog4Listener listener4 = new Dialog4Listener();

        TimePickerDialog picker = new TimePickerDialog(this, listener4, hour, minute, false);
        picker.show();
    }

    //타임피커 다이얼로그 리스너
    class Dialog4Listener implements TimePickerDialog.OnTimeSetListener{
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            text11.setText(hourOfDay+"시 "+minute+"분");
        }
    }

    //
    //다이얼로그 버튼이 3개 이상일 때 = 리스트 다이얼로그
    String [] data_list = {"항목1", "항목2", "항목3", "항목4", "항목5"};

    //리스트 다이얼로그
    public void btn_dialog5(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("리스트 다이얼로그");   //제목

        Dialog5Listener listener5 = new Dialog5Listener();
        builder.setNegativeButton("취소", listener5);
        builder.setItems(data_list,listener5); //**

        builder.show(); //띄우기
    }

    //리스트 다이얼로그 리스너
    class Dialog5Listener implements DialogInterface.OnClickListener{
        @Override
        public void onClick(DialogInterface dialog, int which) {
            text11.setText("리스트 다이얼로그 : "+data_list[which]);
        }
    }

    //
    String [] data_list2 = {"분홍", "보라", "노랑", "초록", "파랑"};
    int [] data_list3 = {R.drawable.ad1, R.drawable.ad2, R.drawable.ad3, R.drawable.ad4, R.drawable.ad5};

    //커스텀 리스트 다이얼로그(그림)
    public void btn_dialog6(View view){
        ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
        for(int i=0; i<data_list2.length; i++){
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("data2", data_list2[i]);
            map.put("data3", data_list3[i]);

            list.add(map);
        }
        String [] keys = {"data2", "data3"};
        int [] ids = {R.id.textView24, R.id.imageView3};
        SimpleAdapter adapter = new SimpleAdapter(this, list, R.layout.custom_dialog2, keys, ids);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("커스텁 리스트 다이얼로그");

        Dialog6Listener listener6 = new Dialog6Listener();
        builder.setAdapter(adapter, listener6);
        builder.show();
    }

    //커스텀 리스트 다이얼로그 리스너(그림)
    class Dialog6Listener implements DialogInterface.OnClickListener{
        @Override
        public void onClick(DialogInterface dialog, int which) {
            text11.setText("커스텀 리스트 다이얼로그 : "+data_list2[which]);
        }
    }
}
