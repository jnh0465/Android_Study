package com.jiwoolee.android_back.DataManagement;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.jiwoolee.android_back.Components4.Activity1.B_Activity;
import com.jiwoolee.android_back.Components4.Activity1.C_Activity;
import com.jiwoolee.android_back.Components4.Activity1.D_Activity;
import com.jiwoolee.android_back.Components4.Activity1.TestClass;
import com.jiwoolee.android_back.R;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

//내부저장소(해당어플통해서만접근, openFileOutput/Input), 외부저장소(FileInputStream/Output)

public class FileActivity extends AppCompatActivity {

    TextView text39;
    String [] permission_list = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };
    String path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);

        text39 = (TextView)findViewById(R.id.textView39);

        checkPermission();
        File f1 = Environment.getExternalStorageDirectory(); //저장할 외부저장소의 경로 구함
        String a1 = f1.getAbsolutePath();
        String a2 = getPackageName(); //패키지명을 구함
        path = a1+"/android/data/"+a2;  //android/data/패키지명으로 저장시 어플삭제시 같이 삭제가 된다.
    }

    public void btn_iw(View view){
        try{
            //내부저장소와 연결된 쓰기 스트림 추출
            FileOutputStream fos = openFileOutput("myFile.dat", MODE_PRIVATE); //MODE_PRIVATE=덮어쓰기 //추출
            DataOutputStream dos = new DataOutputStream(fos);

            dos.writeInt(100); //데이터 쓰기
            dos.writeDouble(11.11);
            dos.writeBoolean(true);
            dos.writeUTF("내부저장소");

            dos.flush(); //파일닫기
            dos.close();

            text39.setText("내부저장소 쓰기 완료");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void btn_ir(View view){
        try{
            FileInputStream fis = openFileInput("myFile.dat");
            DataInputStream dis = new DataInputStream(fis);

            int data1 = dis.readInt();
            double data2 = dis.readDouble();
            boolean data3 = dis.readBoolean();
            String data4 = dis.readUTF();

            dis.close();

            text39.setText("data1 : "+data1+"\n");
            text39.append("data2 : "+data2+"\n");
            text39.append("data3 : "+data3+"\n");
            text39.append("data4 : "+data4);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void checkPermission(){ //외부저장소 권한확인
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.M){
            return;
        }
        for(String permission : permission_list){
            int chk = checkCallingOrSelfPermission(permission);
            if(chk == PackageManager.PERMISSION_DENIED){
                requestPermissions(permission_list, 0);
                break;
            }
        }
    }

    public void checkExternalDirectory(){ //외부저장소 경로여부 확인 후 없으면 생성
        File file = new File(path);
        if(file.exists()==false){
            file.mkdir();
        }
    }

    public void btn_ow(View view){
        try{
            checkExternalDirectory();

            FileOutputStream fos = new FileOutputStream(path+"/sd_file.dat"); //생성
            DataOutputStream dos = new DataOutputStream(fos);

            dos.writeInt(200); //데이터 쓰기
            dos.writeDouble(22.22);
            dos.writeBoolean(false);
            dos.writeUTF("외부저장소");

            dos.flush(); //파일닫기
            dos.close();

            text39.setText("외부저장소 쓰기 완료");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void btn_or(View view){
        try{
            FileInputStream fis = new FileInputStream(path+"/sd_file.dat");
            DataInputStream dis = new DataInputStream(fis);

            int data1 = dis.readInt();
            double data2 = dis.readDouble();
            boolean data3 = dis.readBoolean();
            String data4 = dis.readUTF();

            dis.close();

            text39.setText("data1 : "+data1+"\n");
            text39.append("data2 : "+data2+"\n");
            text39.append("data3 : "+data3+"\n");
            text39.append("data4 : "+data4);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
