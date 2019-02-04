package com.jiwoolee.android_back.Network;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.jiwoolee.android_back.R;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class JsonActivity extends AppCompatActivity {

    TextView text56;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);

        text56 = (TextView)findViewById(R.id.textView56);
    }

    public void btn_json(View view){
        NetworkThread thread = new NetworkThread();
        thread.start();
    }

    class NetworkThread extends Thread{
        @Override
        public void run() {
            try{
                String site = "http://192.168.193.77:8090/JsonServer/Json.jsp";
                URL url = new URL(site);
                URLConnection conn = url.openConnection();

                InputStream is = conn.getInputStream();
                InputStreamReader isr = new InputStreamReader(is, "UTF-8");
                BufferedReader br = new BufferedReader(isr);

                String str = null;
                StringBuffer buf = new StringBuffer();
                do{
                    str = br.readLine(); //읽고
                    if(str != null){
                        buf.append(str); //쌓고
                    }
                }while(str != null);

                String data = buf.toString();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        text56.setText("");
                    }
                });

                //json 배열 객체
                JSONArray root = new JSONArray(data);
                for(int i=0; i<root.length(); i++){
                    JSONObject obj = root.getJSONObject(i);
                    final String data1 = obj.getString("data1");
                    final int data2 = obj.getInt("data2");
                    final double data3 = obj.getDouble("data3");

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            text56.append("data1 : "+data1+"\n");
                            text56.append("data2 : "+data2+"\n");
                            text56.append("data3 : "+data3+"\n\n");
                        }
                    });
                }

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
