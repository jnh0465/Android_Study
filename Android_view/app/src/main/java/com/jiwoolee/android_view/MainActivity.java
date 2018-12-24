package com.jiwoolee.android_view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button_view = (Button) findViewById(R.id.button_view);
        button_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this, ButtonActivity.class);
                startActivity(intent);
            }
        });

        Button button_checkbox = (Button) findViewById(R.id.button_checkbox);
        button_checkbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this, CheckboxActivity.class);
                startActivity(intent);
            }
        });
    }

    /*

    //
    // Activity가 생성될 때 자동으로 호출
    // 화면 회전이 발생했을 때 자동으로 호출
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //System.out.println("onCreate 메서드 호출");
        Log.d("test", "onCreate 메서드 호출");
    }

    // onCreate 메서드 호출 이후에 자동으로 호출
    // Activity가 (정지) 상태가 되었다가 활동상태로 돌아올 때 자동으로 호출
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("test", "onStart 메서드 호출");
    }

    // 다시 복원했을때 호출
    // onStart 메서드 호출 이후에 자동으로 호출
    // Activity가 (일시정지=팝업창) 되었다가 다시 돌아올 때 자동으로 호출
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("test", "onResume 메서드 호출");
    }

    // Activity가 (정지) 상태가 되었다가 활동상태로 돌아올 때 onStart 메서드 전에 호출 onRestart -> onStart
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("test", "onRestart 메서드 호출");
    }

    // 정지가 되면 무조건 호출!
    // Activity가 (일시정지) 상태가 될 때 호출
    // 화면상에서 완전히 사라지거나 현재 화면 위에 작은 팝업창 같은 것이 나타날 때 호출
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("test", "onPause 메서드 호출");
    }

    // Activity가 화면에서 사라질 때 호출
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("test", "onStop 메서드 호출");
    }

    //
    // 현재 Activity의 수행이 완전히 종료되어 메모리상에서 제거될 때 호출
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("test", "onDestroy 메서드 호출");
    }
    */
}
