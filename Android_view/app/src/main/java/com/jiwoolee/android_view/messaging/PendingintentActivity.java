package com.jiwoolee.android_view.messaging;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jiwoolee.android_view.MainActivity;
import com.jiwoolee.android_view.R;

public class PendingintentActivity extends AppCompatActivity {
    //Notification 메세지를 통해 Activity 실행

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pendingintent);

    }

    public void btn_pending(View view){
        NotificationCompat.Builder builder = getNotificationBuilder("pendding", "pendding intent");
        builder.setSmallIcon(android.R.drawable.ic_menu_camera); //작은 아이콘
        builder.setContentTitle("Notification"); //타이틀
        builder.setContentText("Notification"); //내용
        builder.setAutoCancel(true); //메세지를 터치하면 자동으로 사라짐****

        //메세지를 터치하면 실행될 activity *******
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pending = PendingIntent.getActivity(this, 10, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pending);

        Notification notification = builder.build(); //메세지 객체 생성
        NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE); //알림메세지 관리 객체
        manager.notify(10, notification); //알림 메세지 출력
    }


    public NotificationCompat.Builder getNotificationBuilder(String id, String name){
        NotificationCompat.Builder builder = null;

        //os버전별 분기
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){ //오레오 이상
            NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE); //알림메세지 관리 객체

            NotificationChannel channel = new NotificationChannel(id, name, NotificationManager.IMPORTANCE_HIGH); //채널 객체
            channel.enableLights(true); //단말기 LED사용 여부
            channel.setLightColor(Color.RED); //LED색상
            channel.enableVibration(true); //진동여부

            manager.createNotificationChannel(channel); //객체에 채널등록
            builder = new NotificationCompat.Builder(this, id);
        }else{
            builder = new NotificationCompat.Builder(this);
        }
        return builder;
    }
}
