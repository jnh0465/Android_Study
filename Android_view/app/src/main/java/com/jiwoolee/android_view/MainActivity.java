package com.jiwoolee.android_view;

import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jiwoolee.android_view.messaging.DialogActivity;
import com.jiwoolee.android_view.messaging.NotificationActivity;
import com.jiwoolee.android_view.messaging.PendingintentActivity;
import com.jiwoolee.android_view.messaging.StylenotificationActivity;
import com.jiwoolee.android_view.messaging.ToastActivity;
import com.jiwoolee.android_view.adapterview.CustomadaptActivity;
import com.jiwoolee.android_view.adapterview.CustomlistviewActivity;
import com.jiwoolee.android_view.adapterview.CustomlistviewActivity2;
import com.jiwoolee.android_view.adapterview.SpinnerActivity;
import com.jiwoolee.android_view.adapterview.TwolinelistviewActivity;
import com.jiwoolee.android_view.adapterview.ViewpagerActivity;
import com.jiwoolee.android_view.menu.ActionbarActivity;
import com.jiwoolee.android_view.menu.ContextmenuActivity;
import com.jiwoolee.android_view.menu.OptionmenuActivity;
import com.jiwoolee.android_view.menu.PopupmenuActivity;
import com.jiwoolee.android_view.view.ButtonActivity;
import com.jiwoolee.android_view.view.CheckboxActivity;
import com.jiwoolee.android_view.view.EdittextActivity;
import com.jiwoolee.android_view.view.ImageviewActivity;
import com.jiwoolee.android_view.view.ProgressbarActivity;
import com.jiwoolee.android_view.view.SeekbarActivity;

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

        Button button_progressbar = (Button) findViewById(R.id.button_progressbar);
        button_progressbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this, ProgressbarActivity.class);
                startActivity(intent);
            }
        });

        Button button_seekbar = (Button) findViewById(R.id.button_seekbar);
        button_seekbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this, SeekbarActivity.class);
                startActivity(intent);
            }
        });

        Button button_edittext = (Button) findViewById(R.id.button_edittext);
        button_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this, EdittextActivity.class);
                startActivity(intent);
            }
        });

        Button button_imageview = (Button) findViewById(R.id.button_imageview);
        button_imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this, ImageviewActivity.class);
                startActivity(intent);
            }
        });

        Button button_costomlistview = (Button) findViewById(R.id.button_costomlistview);
        button_costomlistview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this, CustomlistviewActivity.class);
                startActivity(intent);
            }
        });

        Button button_costomlistview2 = (Button) findViewById(R.id.button_costomlistview2);
        button_costomlistview2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this, CustomlistviewActivity2.class);
                startActivity(intent);
            }
        });

        Button button_twoline = (Button) findViewById(R.id.button_twoline);
        button_twoline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this, TwolinelistviewActivity.class);
                startActivity(intent);
            }
        });

        Button button_customadpater = (Button) findViewById(R.id.button_customadpater);
        button_customadpater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this, CustomadaptActivity.class);
                startActivity(intent);
            }
        });

        Button button_spinner = (Button) findViewById(R.id.button_spinner);
        button_spinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this, SpinnerActivity.class);
                startActivity(intent);
            }
        });

        Button button_viewpager = (Button) findViewById(R.id.button_viewpager);
        button_viewpager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this, ViewpagerActivity.class);
                startActivity(intent);
            }
        });

        Button button_optionmenu = (Button) findViewById(R.id.button_optionmenu);
        button_optionmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this, OptionmenuActivity.class);
                startActivity(intent);
            }
        });

        Button button_contextmenu = (Button) findViewById(R.id.button_contextmenu);
        button_contextmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this, ContextmenuActivity.class);
                startActivity(intent);
            }
        });

        Button button_popupmenu = (Button) findViewById(R.id.button_popupmenu);
        button_popupmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this, PopupmenuActivity.class);
                startActivity(intent);
            }
        });

        Button button_actionbar = (Button) findViewById(R.id.button_actionbar);
        button_actionbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this, ActionbarActivity.class);
                startActivity(intent);
            }
        });

        Button button_toast = (Button) findViewById(R.id.button_toast);
        button_toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this, ToastActivity.class);
                startActivity(intent);
            }
        });

        Button button_dialog = (Button) findViewById(R.id.button_dialog);
        button_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this, DialogActivity.class);
                startActivity(intent);
            }
        });

        Button button_notification = (Button) findViewById(R.id.button_notification);
        button_notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this, NotificationActivity.class);
                startActivity(intent);
            }
        });

        Button button_pendingintent = (Button) findViewById(R.id.button_pendingintent);
        button_pendingintent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this, PendingintentActivity.class);
                startActivity(intent);
            }
        });

        Button button_stylenotification = (Button) findViewById(R.id.button_stylenotification);
        button_stylenotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this, StylenotificationActivity.class);
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
