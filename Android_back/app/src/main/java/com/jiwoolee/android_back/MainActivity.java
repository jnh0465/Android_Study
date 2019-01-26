package com.jiwoolee.android_back;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jiwoolee.android_back.Components4.Activity1.A_Activity;
import com.jiwoolee.android_back.Components4.Activity2.E_Activity;
import com.jiwoolee.android_back.Components4.BroadCastActivity;
import com.jiwoolee.android_back.Components4.IPCActivity;
import com.jiwoolee.android_back.DataManagement.ContentproviderActivity;
import com.jiwoolee.android_back.DataManagement.DBActivity;
import com.jiwoolee.android_back.DataManagement.FileActivity;
import com.jiwoolee.android_back.Fragment.Activitycontroller;
import com.jiwoolee.android_back.Fragment.DialfragmentActivity;
import com.jiwoolee.android_back.Fragment.FragmentActivity1;
import com.jiwoolee.android_back.Fragment.ListfragmentActivity;
import com.jiwoolee.android_back.Permission_Thread.AsynctaskActivity;
import com.jiwoolee.android_back.Permission_Thread.HandlerActivity;
import com.jiwoolee.android_back.Permission_Thread.HandlerActivity2;
import com.jiwoolee.android_back.Permission_Thread.PermissionActivity;
import com.jiwoolee.android_back.Permission_Thread.RunonuithreadActivity;
import com.jiwoolee.android_back.Permission_Thread.ThreadActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button_permission = (Button) findViewById(R.id.button_permission);
        button_permission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this, PermissionActivity.class);
                startActivity(intent);
            }
        });

        Button button_thread = (Button) findViewById(R.id.button_thread);
        button_thread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this, ThreadActivity.class);
                startActivity(intent);
            }
        });

        Button button_handler1 = (Button) findViewById(R.id.button_handler1);
        button_handler1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this, HandlerActivity.class);
                startActivity(intent);
            }
        });

        Button button_handler2 = (Button) findViewById(R.id.button_handler2);
        button_handler2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this, HandlerActivity2.class);
                startActivity(intent);
            }
        });

        Button button_asynctask = (Button) findViewById(R.id.button_asynctask);
        button_asynctask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this, AsynctaskActivity.class);
                startActivity(intent);
            }
        });

        Button button_runonuithread = (Button) findViewById(R.id.button_runonuithread);
        button_runonuithread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this, RunonuithreadActivity.class);
                startActivity(intent);
            }
        });

        Button button_activity = (Button) findViewById(R.id.button_activity);
        button_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this, A_Activity.class);
                startActivity(intent);
            }
        });

        Button button_activity2 = (Button) findViewById(R.id.button_activity2);
        button_activity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this, E_Activity.class);
                startActivity(intent);
            }
        });

        Button button_broadcast = (Button) findViewById(R.id.button_broadcast);
        button_broadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this, BroadCastActivity.class);
                startActivity(intent);
            }
        });

        Button button_ipc = (Button) findViewById(R.id.button_ipc);
        button_ipc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this, IPCActivity.class);
                startActivity(intent);
            }
        });

        Button button_fragment = (Button) findViewById(R.id.button_fragment);
        button_fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this, FragmentActivity1.class);
                startActivity(intent);
            }
        });

        Button button_activitycontroller = (Button) findViewById(R.id.button_activitycontroller);
        button_activitycontroller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this, Activitycontroller.class);
                startActivity(intent);
            }
        });

        Button button_listfragment = (Button) findViewById(R.id.button_listfragment);
        button_listfragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this, ListfragmentActivity.class);

                startActivity(intent);
            }
        });

        Button button_dialfragment = (Button) findViewById(R.id.button_dialfragment);
        button_dialfragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this, DialfragmentActivity.class);
                startActivity(intent);
            }
        });

        Button button_file = (Button) findViewById(R.id.button_file);
        button_file.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this, FileActivity.class);
                startActivity(intent);
            }
        });

        Button button_db1 = (Button) findViewById(R.id.button_db1);
        button_db1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this, DBActivity.class);
                startActivity(intent);
            }
        });

        Button button_contentprovider = (Button) findViewById(R.id.button_contentprovider);
        button_contentprovider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this, ContentproviderActivity.class);
                startActivity(intent);
            }
        });
    }
}
