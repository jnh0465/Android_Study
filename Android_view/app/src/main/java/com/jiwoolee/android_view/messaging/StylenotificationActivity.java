package com.jiwoolee.android_view.messaging;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.jiwoolee.android_view.R;

public class StylenotificationActivity extends AppCompatActivity {
    //big picture style
    //big text style
    //inbox style

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stylenotification);

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

    public void btn_stylenotipic(View view){
        NotificationCompat.Builder builder = getNotificationBuilder("style", "스타일 채널");
        builder.setSmallIcon(android.R.drawable.ic_menu_agenda); //작은 아이콘
        builder.setContentTitle("Big Picture"); //타이틀
        builder.setContentText("Big Picture Notification"); //내용

        //big picture *************
        NotificationCompat.BigPictureStyle big = new NotificationCompat.BigPictureStyle(builder);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ad1);
        big.bigPicture(bitmap);
        big.setBigContentTitle("Big Content Title");
        big.setSummaryText("Summary Text");

        Notification notification = builder.build(); //메세지 객체 생성
        NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE); //알림메세지 관리 객체
        manager.notify(10, notification); //알림 메세지 출력
    }


    public void btn_stylenotitext(View view){
        NotificationCompat.Builder builder = getNotificationBuilder("style", "스타일 채널");
        builder.setSmallIcon(android.R.drawable.ic_menu_call); //작은 아이콘
        builder.setContentTitle("Big Text"); //타이틀
        builder.setContentText("Big Text Notification"); //내용

        //big text *************
        NotificationCompat.BigTextStyle big = new NotificationCompat.BigTextStyle(builder);
        big.setBigContentTitle("Big Text Title");
        big.setSummaryText("Summary Text");
        big.bigText("123456789101112131415161718192021222324252627282930");

        Notification notification = builder.build(); //메세지 객체 생성
        NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE); //알림메세지 관리 객체
        manager.notify(20, notification); //알림 메세지 출력
    }

    public void btn_stylenotiinbox(View view){
        NotificationCompat.Builder builder = getNotificationBuilder("style", "스타일 채널");
        builder.setSmallIcon(android.R.drawable.ic_menu_day); //작은 아이콘
        builder.setContentTitle("Inbox"); //타이틀
        builder.setContentText("Inbox Notification"); //내용

        //inbox *************
        NotificationCompat.InboxStyle inbox = new NotificationCompat.InboxStyle(builder);
        inbox.setBigContentTitle("Inbox Title");
        inbox.setSummaryText("Inbox Text");
        inbox.addLine("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        inbox.addLine("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
        inbox.addLine("cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc");


        Notification notification = builder.build(); //메세지 객체 생성
        NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE); //알림메세지 관리 객체
        manager.notify(30, notification); //알림 메세지 출력
    }
}