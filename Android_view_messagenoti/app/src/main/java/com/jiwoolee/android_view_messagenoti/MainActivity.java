package com.jiwoolee.android_view_messagenoti;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Person;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Icon;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btn_messagenoti(View view){
        NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE); //알림메세지 관리 객체

        NotificationChannel channel = new NotificationChannel("message", "message style", NotificationManager.IMPORTANCE_HIGH); //채널 객체
        channel.enableLights(true); //단말기 LED사용 여부
        channel.setLightColor(Color.RED); //LED색상
        channel.enableVibration(true); //진동여부

        manager.createNotificationChannel(channel); //객체에 채널등록
        Notification.Builder builder = new Notification.Builder(this, "message");
        builder.setSmallIcon(android.R.drawable.ic_menu_search); //작은 아이콘
        builder.setContentTitle("Message title"); //타이틀
        builder.setContentText("Message text"); //내용

        Person.Builder builder1 = new Person.Builder();
        Icon icon1 = Icon.createWithResource(this, android.R.drawable.ic_menu_call);
        builder1.setIcon(icon1);
        builder1.setName("가");
        Person user1 = builder1.build();

        Person.Builder builder2 = new Person.Builder();
        Icon icon2 = Icon.createWithResource(this, android.R.drawable.ic_menu_camera);
        builder1.setIcon(icon2);
        builder1.setName("나");
        Person user2 = builder1.build();

        Notification.MessagingStyle style = new Notification.MessagingStyle(user1);
        style.addMessage("첫번째 메시지", System.currentTimeMillis(), user1);
        style.addMessage("두번째 메시지", System.currentTimeMillis(), user2);
        style.addMessage("세번째 메시지", System.currentTimeMillis(), user1);
        style.addMessage("네번째 메시지", System.currentTimeMillis(), user2);

        builder.setStyle(style);

        Notification notification = builder.build();
        manager.notify(10, notification);
    }
}
