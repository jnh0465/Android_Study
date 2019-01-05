package com.jiwoolee.android_back;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jiwoolee.android_back.Permission_Thread.PermissionActivity;
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

    }
}
