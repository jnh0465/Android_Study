package com.jiwoolee.android_back.DataManagement;

import android.Manifest;
import android.content.ContentValues;
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
    // 1) 표준 SQL 쿼리문 사용
    // 2) 클래스 이용

    TextView text40, text43;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);

        text40 = (TextView)findViewById(R.id.textView40);
        text43 = (TextView)findViewById(R.id.textView43);
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

    public void btn_insert_class(View view){
        DBHelper2 helper = new DBHelper2(this);
        SQLiteDatabase db = helper.getWritableDatabase();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()); //2019-01-15
        String date = sdf.format(new Date());

        //String sql = "insert into TestTable (textData, intData, floatData, dateData) values (?, ?, ?, ?)";
        ContentValues cv1 = new ContentValues();
        cv1.put("textData", "insert_class1"); //컬렴명/데이터값 지정
        cv1.put("intData", 100);
        cv1.put("floatData", 11.11);
        cv1.put("dateData", date);

        ContentValues cv2 = new ContentValues();
        cv2.put("textData", "insert_class2");
        cv2.put("intData", 200);
        cv2.put("floatData", 22.22);
        cv2.put("dateData", date);

        db.insert("TestTable2", null, cv1); //테이블명 지정
        db.insert("TestTable2", null, cv2);
        db.close();

        text43.setText("DB저장완료");
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

    public void btn_DB_class(View view){
        DBHelper2 helper = new DBHelper2(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        text43.setText("");

        //select 컬럼명들 from 테이블명 where 조건절 group by 기준컬럼 having 조건절 order by 컬럼명
        Cursor c = db.query("TestTable2", null, null, null, null, null, null);

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

            text43.append("idx : " + idx + "\n");
            text43.append("textData : " + textData + "\n");
            text43.append("intData : " + intData + "\n");
            text43.append("floatData : " + floatData + "\n");
            text43.append("dateData : " + dateData + "\n\n");
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

    public void btn_update_class(View view){
        DBHelper2 helper = new DBHelper2(this);
        SQLiteDatabase db = helper.getWritableDatabase();

        //String sql = "update TestTable set textData = ? where idx = ?";
        ContentValues cv = new ContentValues();
        cv.put("textData", "update");
        String where = "idx=?"; //조건절
        String [] args = {"1"};
        db.update("TestTable2", cv, where, args);
        db.close();

        text43.setText("수정완료");
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

    public void btn_delete_class(View view){
        DBHelper2 helper = new DBHelper2(this);
        SQLiteDatabase db = helper.getWritableDatabase();

        //String sql = "delete from TestTable where idx=?";
        String where = "idx=?"; //조건절
        String [] args = {"2"};

        db.delete("TestTable2", where, args);
        db.close();

        text43.setText("삭제 완료");
    }
}
