package com.jiwoolee.android_back.Components4;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class SystemReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();         // 안드로이드os가 리시버를 찾기위해 사용한 이름 추출
        switch (action){
            case "android.provider.Telephony.SMS_RECEIVED":
                Bundle bundle = intent.getExtras();
                if(bundle!=null){
                    Object [] obj = (Object [])bundle.get("pdus"); //문자메세지 정보객체 추출
                    SmsMessage [] msg = new SmsMessage[obj.length];
                    for(int i=0; i<obj.length; i++){
                        msg[i]=SmsMessage.createFromPdu((byte[])obj[i]);
                    }
                    for(SmsMessage a1:msg){
                        String number = a1.getOriginatingAddress();
                        String str = a1.getMessageBody();
                        String a2 = number+" : "+str;
                        Toast t1 = Toast.makeText(context, a2, Toast.LENGTH_SHORT);
                        t1.show();
                    }
                }
                break;
        }
    }
}
