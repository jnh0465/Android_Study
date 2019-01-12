package com.jiwoolee.android_back;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jiwoolee.android_back.Components4.Activity1.A_Activity;
import com.jiwoolee.android_back.Components4.Activity2.E_Activity;
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
    }
}
