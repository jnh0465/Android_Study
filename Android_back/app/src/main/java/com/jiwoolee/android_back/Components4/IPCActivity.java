package com.jiwoolee.android_back.Components4;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import android.service.autofill.TextValueSanitizer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.jiwoolee.android_back.R;

import java.util.List;

public class IPCActivity extends AppCompatActivity {
    //현재 실행중인 서비스에 접속하는 개념

    // 접속한 서비스 객체
    IPCService ipc_service = null;
    // 서비스 접속을 관리하는 객체
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            // 전달 받은 바인더 클래스를 이용해 서비스 객체를 추출한다.
            IPCService.LocalBinder binder = (IPCService.LocalBinder)service;
            ipc_service = binder.getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            ipc_service = null;
        }
    };

    // 뷰의 주소 값을 담을 참조변수
    TextView text30;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ipc);

        // 뷰의 주소 값을 받는다.
        text30 = (TextView)findViewById(R.id.textView30);

        Intent intent = new Intent(this, IPCService.class);
        // 현재 서비스가 가동중인지 확인한다.
        boolean chk = isServiceRunning("com.jiwoolee.android_back.Components4.IPCService");

        if(chk == false) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                startForegroundService(intent);
            } else {
                startService(intent);
            }
        }
        bindService(intent, connection, BIND_AUTO_CREATE);         // 서비스에 접속한다.
    }

    public void btnMethod(View view){
        // 서비스 객체의 메서드를 호출해 값을 반환받는다.
        int value = ipc_service.getNumber();
        text30.setText("value : " + value);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(connection);         // 접속중인 서비스를 해제한다.
    }

    // 현재 지정된 서비스가 가동중인지 확인한다.
    public boolean isServiceRunning(String name) {
        ActivityManager manager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        // 현재 실행중인 서비스의 이름을 가져온다.
        List<ActivityManager.RunningServiceInfo> list = manager.getRunningServices(Integer.MAX_VALUE);
        for (ActivityManager.RunningServiceInfo info : list) {
            if (info.service.getClassName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}








