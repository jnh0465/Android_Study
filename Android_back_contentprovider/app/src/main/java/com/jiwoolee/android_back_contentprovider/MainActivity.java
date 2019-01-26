package com.jiwoolee.android_back_contentprovider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextView text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = (TextView)findViewById(R.id.textView);
    }

    public void btn_intsert(View view){
        //저장할 데이터
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String date = sdf.format(new Date());

        ContentValues cv1 = new ContentValues();
        cv1.put("textData", "provider1");
        cv1.put("intData", 100);
        cv1.put("floatData", 11.11);
        cv1.put("dateData", date);

        ContentValues cv2 = new ContentValues();
        cv2.put("textData", "provider2");
        cv2.put("intData", 200);
        cv2.put("floatData", 22.22);
        cv2.put("dateData", date);

        Uri uri = Uri.parse("content://jiwoolee.com.contentprovider"); //***********
        ContentResolver resolver = getContentResolver(); //contentprovider에 작업 요청
        resolver.insert(uri, cv1); //insert작업 요청
        resolver.insert(uri, cv2);
        text1.setText("DB저장완료");
    }

    public void btn_select(View view){
        Uri uri = Uri.parse("content://jiwoolee.com.contentprovider");
        ContentResolver resolver = getContentResolver(); //contentprovider에 작업 요청

        Cursor c = resolver.query(uri, null, null, null, null);
        text1.setText("");

        while(c.moveToNext()){
            int idx_pos = c.getColumnIndex("idx"); // 컬럼의 인덱스 번호를 추출
            int textData_pos = c.getColumnIndex("textData");
            int intData_pos = c.getColumnIndex("intData");
            int floatData_pos = c.getColumnIndex("floatData");
            int dateData_pos = c.getColumnIndex("dateData");

            int idx = c.getInt(idx_pos); // 컬럼 인덱스 번호를 통해 데이터를 가져옴
            String textData = c.getString(textData_pos);
            int intData = c.getInt(intData_pos);
            double floatData = c.getDouble(floatData_pos);
            String dateData = c.getString(dateData_pos);

            text1.append("idx : " + idx + "\n");
            text1.append("textData : " + textData + "\n");
            text1.append("intData : " + intData + "\n");
            text1.append("floatData : " + floatData + "\n");
            text1.append("dateData : " + dateData + "\n\n");
        }
    }

    public void btn_updeate(View view){
        ContentValues cv = new ContentValues();
        cv.put("textData", "update");
        String where = "idx=?";
        String [] args = {"1"};

        Uri uri = Uri.parse("content://jiwoolee.com.contentprovider");
        ContentResolver resolver = getContentResolver();
        resolver.update(uri, cv, where, args);

        text1.setText("수정완료");
    }

    public void btn_delete(View view){
        String where = "idx=?";
        String [] args = {"1"};

        Uri uri = Uri.parse("content://jiwoolee.com.contentprovider");
        ContentResolver resolver = getContentResolver();
        resolver.delete(uri, where, args);

        text1.setText("삭제완료");
    }
}
