package com.jiwoolee.android_view.messaging;

import android.app.DatePickerDialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.TimePicker;

import com.jiwoolee.android_view.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class NotificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

    }

    //안드로이드 8.0 이상 대응 Notification.Builder 생성 메서드
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

    public void btn_noti(View view){
        NotificationCompat.Builder builder = getNotificationBuilder("channel1", "첫번째 채널");
        builder.setSmallIcon(android.R.drawable.ic_menu_search); //작은 아이콘
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher); //큰 아이콘
        builder.setLargeIcon(bitmap);
        builder.setNumber(100); //숫자
        builder.setContentTitle("Content title"); //타이틀
        builder.setContentText("Content text"); //내용

        Notification notification = builder.build(); //메세지 객체 생성
        NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE); //알림메세지 관리 객체
        manager.notify(10, notification); //알림 메세지 출력
    }

    public void btn_noti2(View view){
        NotificationCompat.Builder builder = getNotificationBuilder("channel1", "첫번째 채널");
        builder.setSmallIcon(android.R.drawable.ic_menu_search); //작은 아이콘
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher); //큰 아이콘
        builder.setLargeIcon(bitmap);
        builder.setNumber(100); //숫자
        builder.setContentTitle("Content title2"); //타이틀
        builder.setContentText("Content text2"); //내용

        Notification notification = builder.build(); //메세지 객체 생성
        NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE); //알림메세지 관리 객체
        manager.notify(20, notification); //알림 메세지 출력
    }
}