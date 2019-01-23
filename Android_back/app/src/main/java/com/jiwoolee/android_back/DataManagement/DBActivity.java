package com.jiwoolee.android_back.DataManagement;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.jiwoolee.android_back.R;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DBActivity extends AppCompatActivity {
    //SQLite = 안드로이드 내장 DB, MySQL과 유사

    TextView text40;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);

        text40 = (TextView)findViewById(R.id.textView40);
    }

    public void btn_insert(View view){
        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();

        String sql = "insert into TestTable (textData, intData, floatData, dateData) values (?, ?, ?, ?)";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()); //2019-01-15
        String date = sdf.format(new Date());

        String [] arg1 = {"insert1", "100", "11.11", date}; // ???? 에 바인딩될 값 배열
        String [] arg2 = {"insert2", "200", "22.22", date};

        db.execSQL(sql, arg1); // 저장
        db.execSQL(sql, arg2);
        db.close();

        text40.setText("DB저장완료");
    }

    public void btn_DB(View view){
        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();

        String sql = "select * from TestTable";
        Cursor c = db.rawQuery(sql, null); // 쿼리실행

//        String sql = "select * from TestTable where idx = ?";
//        String [] arg1 = {"1"};
//        Cursor c = db.rawQuery(sql, arg1);

        text40.setText("");

        while(c.moveToNext()){ //1->2->3->4->
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

            text40.append("idx : " + idx + "\n");
            text40.append("textData : " + textData + "\n");
            text40.append("intData : " + intData + "\n");
            text40.append("floatData : " + floatData + "\n");
            text40.append("dateData : " + dateData + "\n\n");
        }
        db.close();
    }

    public void btn_update(View view){
        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();

        String sql = "update TestTable set textData = ? where idx = ?";
        String [] args = {"update", "1"};

        db.execSQL(sql, args);
        db.close();

        text40.setText("수정완료");
    }

    public void btn_delete(View view){
        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();

        String sql = "delete from TestTable where idx=?";
        String [] args = {"2"};

        db.execSQL(sql, args);
        db.close();

        text40.setText("삭제 완료");
    }
}
