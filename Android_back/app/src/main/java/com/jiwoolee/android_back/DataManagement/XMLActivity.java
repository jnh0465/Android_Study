package com.jiwoolee.android_back.DataManagement;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.jiwoolee.android_back.R;

public class XMLActivity extends AppCompatActivity {

    TextView text46;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xml);

        text46 = (TextView)findViewById(R.id.textView46);
    }

    public void btn_string(View view){         //string.xml
//        Resources res = getResources();
//        String str1 = res.getString(R.string.str2);
//        text46.setText(str1);

        text46.setText(R.string.str2); //위와 같은 의미
    }

    public void btn_stringarray(View view){    //string_array.xml
        Resources res = getResources();
        String [] array = res.getStringArray(R.array.data_array);

        text46.setText("");
        for(String str1 : array){
            text46.append(str1+"\n");
        }
    }

    public void btn_textcolor(View view){     //color.xml
//        text46.setTextColor(Color.RED); //색상
//        int color = Color.rgb(26, 106, 129); //rgb
//        int color = Color.argb(50,26, 106, 129); //투명도

        int color = ContextCompat.getColor(this, R.color.color1);
        text46.setTextColor(color);
    }

    public void btn_size(View view){         //dimen.xml
        //dp / sp(폰트크기)
        Resources res = getResources();
        float px = res.getDimension(R.dimen.px);
        float dp = res.getDimension(R.dimen.dp);
        float sp = res.getDimension(R.dimen.sp);

        text46.setText("px : "+px+"\n");
        text46.append("dp : "+dp+"\n");
        text46.append("sp : "+sp+"\n");

        text46.setTextSize(10*dp);
    }
}
