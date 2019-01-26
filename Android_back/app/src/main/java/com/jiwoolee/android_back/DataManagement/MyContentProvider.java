package com.jiwoolee.android_back.DataManagement;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import com.jiwoolee.android_back.DataManagement.DBHelper_cp;

public class MyContentProvider extends ContentProvider {
    public MyContentProvider() {
    }

    @Override
    public String getType(Uri uri) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public boolean onCreate() {
        return false;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        DBHelper_cp helper = new DBHelper_cp(getContext()); //액티비티에선 context를 자동으로 상속받기 떄문에 적지 않았음
        SQLiteDatabase db = helper.getWritableDatabase();

        db.insert("TestTable_cp", null, values); //저장처리

        return uri;  //manifests의 android:authorities="jiwoolee.com.contentprovider"
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        //                         컬럼명                조건절         조건절 ?에 들어가는 값     정렬기준
        DBHelper_cp helper = new DBHelper_cp(getContext());
        SQLiteDatabase db = helper.getWritableDatabase();

        Cursor c = db.query("TestTable_cp", projection, selection, selectionArgs, null, null, sortOrder);
        return c;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
                    //                                  조건절             조건절에 들어갈 값
        DBHelper_cp helper = new DBHelper_cp(getContext());
        SQLiteDatabase db = helper.getWritableDatabase();

        int cnt = db.update("TestTable_cp", values, selection, selectionArgs); //수정된 row된 개수
        return  cnt;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        DBHelper_cp helper = new DBHelper_cp(getContext());
        SQLiteDatabase db = helper.getWritableDatabase();

        int cnt = db.delete("TestTable_cp", selection, selectionArgs);
        return cnt;
    }
}
