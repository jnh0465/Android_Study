package com.jiwoolee.android_back.DataManagement;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.jiwoolee.android_back.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ContentproviderActivity extends AppCompatActivity {
    //어플이 저장한 데이터를 다른 어플이 사용할 수 있도록 / 4대 구성요소 중 하나
    //SQLite의 데이터를 다른 어플로 매개체 역할인듯, 전권은X

    TextView text45;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contentprovider);

        text45 = (TextView)findViewById(R.id.textView45);
    }

    public void btn_select(View view){
        DBHelper_cp helper = new DBHelper_cp(this);
        SQLiteDatabase db = helper.getWritableDatabase();

        String sql = "select * from TestTable_cp";
        Cursor c = db.rawQuery(sql, null); // 쿼리실행

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

            text45.append("idx : " + idx + "\n");
            text45.append("textData : " + textData + "\n");
            text45.append("intData : " + intData + "\n");
            text45.append("floatData : " + floatData + "\n");
            text45.append("dateData : " + dateData + "\n\n");
        }
        db.close();
    }
}
