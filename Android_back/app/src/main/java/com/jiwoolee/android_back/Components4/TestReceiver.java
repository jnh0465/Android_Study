package com.jiwoolee.android_back.Components4;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class TestReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        String str = "BroadCast Receiver 동작";
        Toast t1 = Toast.makeText(context, str, Toast.LENGTH_SHORT);
        t1.show();
    }
}
