package com.jiwoolee.android_back.Network;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.jiwoolee.android_back.R;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;

public class HttpActivity extends AppCompatActivity {
    //socket처럼 온라인 유지x
    //9.0 부터는 http 기본 차단
    //mainfest에 android:usesCleartextTraffic="true"

    TextView text53;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http);

        text53 = (TextView)findViewById(R.id.textView53);
    }

    public void btn_http(View view){
        NetworkThread thread = new NetworkThread();
        thread.start();
    }

    class NetworkThread extends Thread{
        @Override
        public void run() {
            try{
                String site = "http://192.168.193.77:8090/HttpServer/http.jsp";
                URL url = new URL(site);
                URLConnection conn = url.openConnection();

                InputStream is = conn.getInputStream();
                InputStreamReader isr = new InputStreamReader(is, "UTF-8");
                BufferedReader br = new BufferedReader(isr);

                String str =null;
                StringBuffer  buf = new StringBuffer();
                do{
                    str = br.readLine(); //읽고
                    if(str != null){
                        buf.append(str); //쌓고
                    }
                }while(str != null);

                final String str2 = buf.toString();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        text53.setText(str2);
                    }
                });

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
