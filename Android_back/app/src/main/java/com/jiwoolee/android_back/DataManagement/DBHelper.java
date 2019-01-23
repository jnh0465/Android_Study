package com.jiwoolee.android_back.DataManagement;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

//SQLite 연결
public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context){
        super(context, "Test.db", null, 1);
        //super(context, "Test.db", null, 2);
        //DB 이름                 구조변경시 버전(테이블2->3개)
    }

    @Override
    public void onCreate(SQLiteDatabase db) { //Test.db 여부 확인, 없을시 생성하고 다시 호출 / 테이블 생성, 기타
        //Log.d("test", "DB 생성");
        String sql = "create table TestTable("
                + "idx integer primary key autoincrement, "
                + "textData text not null, "
                + "intData integer not null, "
                + "floatData real not null, "
                + "dateData date not null"
                + ")";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Log.d("test", "old : "+oldVersion);
        //Log.d("test", "new : "+newVersion);
        switch (oldVersion){
            case 1 :
                // 1에서 2 버전 형태로 테이블 구조를 변경시키는 작업을 한다.
            case 2 :
                // 2에서 3버전 형태로 테이블 구조를 변경시키는 작업을 한다.
            case 3 :
                // 3에서 4버전 형태로 테이블 구조를 변경시키는 작업을 한다.
        }
    }
}