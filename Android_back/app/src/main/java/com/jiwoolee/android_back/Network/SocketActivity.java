package com.jiwoolee.android_back.Network;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.jiwoolee.android_back.R;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SocketActivity extends AppCompatActivity {
    //socket
    // 프로그램종료시까지 온라인으로 연결, 자바에서 구현방법과 동일
    // 데이터 주고받기 + 접속 관리

    TextView text52;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_socket);

        text52 = (TextView)findViewById(R.id.textView52);
    }

    public void btn_access(View view){
        NetworkThread thread = new NetworkThread();
        thread.start();
    }

    //네트워크 처리 쓰레드
    class NetworkThread extends Thread{
        @Override
        public void run() {
            try{
                //서버 접속
                final Socket socket = new Socket("192.168.193.77", 55555); //ipconfig
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        text52.setText(socket.toString());
//                    }
//                });

                //입출력 스트림 추출
                InputStream is = socket.getInputStream();
                OutputStream os = socket.getOutputStream();
                DataInputStream dis = new DataInputStream(is);
                DataOutputStream dos = new DataOutputStream(os);

                final int data1 = dis.readInt();
                final double data2 = dis.readDouble();
                final boolean data3 = dis.readBoolean();
                final String data4 = dis.readUTF();

                dos.writeInt(200);
                dos.writeDouble(22.22);
                dos.writeBoolean(false);
                dos.writeUTF("클라이언트가 보낸 문자열");

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        text52.setText("data1 : "+data1+"\n");
                        text52.append("data2 : "+data2+"\n");
                        text52.append("data3 : "+data3+"\n");
                        text52.append("data4 : "+data4+"\n");
                    }
                });

                socket.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
