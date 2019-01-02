package com.jiwoolee.android_view.menu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu; //가급적 support.v7붙은걸로 사용
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.jiwoolee.android_view.R;

public class PopupmenuActivity extends AppCompatActivity {
    //코드를 통해 구성
    //버튼누르면 텍스트뷰에 메뉴를 띄움
    //getMenu

    TextView text8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popupmenu);

        text8 = (TextView)findViewById(R.id.textView17);

    }

    public void btnMethod_popup(View view){
        //팝업메뉴 객체 생성
        PopupMenu popup = new PopupMenu(this, text8);
        //팝업메뉴 관리 객체 추출
        Menu menu = popup.getMenu();
        //메뉴구성
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.popup_menu, menu);

        //팝업메뉴 리스너 설정
        PopupListener listener = new PopupListener();
        popup.setOnMenuItemClickListener(listener);

        //메뉴를 나타나게 함
        popup.show();
    }

    class PopupListener implements PopupMenu.OnMenuItemClickListener{
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            //선택한 메뉴 id값 추출
            int id = item.getItemId();
            switch (id){
                case R.id.popupitem1:
                    text8.setText("메뉴1 선택");
                    break;
                case R.id.popupitem2:
                    text8.setText("메뉴2 선택");
                    break;
                case R.id.popupitem3:
                    text8.setText("메뉴3 선택");
                    break;
            }
            return false;
        }
    }
}
