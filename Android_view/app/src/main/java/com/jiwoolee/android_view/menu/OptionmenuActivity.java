package com.jiwoolee.android_view.menu;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jiwoolee.android_view.R;

import java.util.ArrayList;

public class OptionmenuActivity extends AppCompatActivity {
    //onCreateOptionsMenu
    //res폴더-menu
    //1/ xml을 이용해==정형화 2/코드를 이용해==유동적

    TextView text6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_optionmenu);

        text6 = (TextView)findViewById(R.id.textView15);
    }

    //액티비티가 화면에 나타날 때 메뉴 구성을 위해 호출되는 메세드
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /*
        //1/ xml을 이용해

        //xml을 통해 메뉴를 구성하는 객체를 추출
        MenuInflater inflater = getMenuInflater();
        //메뉴구성
        inflater.inflate(R.menu.option_menu, menu);
        */

        //2/코드를 이용해

        menu.add(Menu.NONE, Menu.FIRST, Menu.NONE, "코드메뉴1");
         //                    id값                  문자열
        //menu.add(Menu.NONE, Menu.FIRST+1, Menu.NONE, "코드메뉴2");
        Menu sub = menu.addSubMenu("코드메뉴2");
        sub.add(Menu.NONE, Menu.FIRST+10, Menu.NONE, "코드서브메뉴1");
        sub.add(Menu.NONE, Menu.FIRST+11, Menu.NONE, "코드서브메뉴2");

        menu.add(Menu.NONE, Menu.FIRST+2, Menu.NONE, "코드메뉴3");

        return true; //상단 메뉴 점점점 나타남
    }

    //옵션메뉴 항목 터치시 호출되는 메서드
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        /*
        switch (id){
            case R.id.Item1:
                text6.setText("메뉴1 선택");
                break;
            case R.id.Item2_1:
                text6.setText("서브메뉴1 선택");
                break;
            case R.id.Item2_2:
                text6.setText("서브메뉴2 선택");
                break;
            case R.id.Item3:
                text6.setText("메뉴3 선택");
                break;
        }
        */

        switch (id){
            case Menu.FIRST:
                text6.setText("코드메뉴1 선택");
                break;
            case Menu.FIRST+10:
                text6.setText("코드서브메뉴1 선택");
                break;
            case Menu.FIRST+11:
                text6.setText("코드서브메뉴2 선택");
                break;
            case Menu.FIRST+2:
                text6.setText("코드메뉴3 선택");
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
