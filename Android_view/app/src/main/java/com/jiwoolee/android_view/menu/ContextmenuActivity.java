package com.jiwoolee.android_view.menu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

public class ContextmenuActivity extends AppCompatActivity {
    //화면에 배치된 뷰에 설정하는 메뉴
    //뷰를 길게 누르면 메뉴나옴 - 일반적으로 사용안함
    //보통 리스트뷰의 항목에 대한 컨테스트 뷰로 사용
    //registerForContextMenu

    TextView text7;
    ListView list_menu;
    String [] data_menu={
            "항목1", "항목2", "항목3", "항목4", "항목5"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contextmenu);

        text7 = (TextView)findViewById(R.id.textView16);
        list_menu = (ListView) findViewById(R.id.list_menu);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data_menu);
        list_menu.setAdapter(adapter);

        ListListener listener = new ListListener();
        list_menu.setOnItemClickListener(listener);

        registerForContextMenu(text7); //
        registerForContextMenu(list_menu); //
    }

    //context메뉴가 설정되어있는 뷰를 길게 누르면 호출되는 메서드
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
                    // ContextMenu를 구성하기 위한 객체, 뷰, ****ContextMenu에 대한 정보를 가지고 있는 객체
        super.onCreateContextMenu(menu, v, menuInfo);

        //xml
        MenuInflater inflater = getMenuInflater();

        int view_id = v.getId();
        switch (view_id){
            case R.id.textView16:
                menu.setHeaderIcon(R.mipmap.ic_launcher);         //아이콘세팅
                menu.setHeaderTitle("텍스트뷰의 메뉴"); //제목세팅
                inflater.inflate(R.menu.textview_menu, menu);
                break;
            case R.id.list_menu:
                //사용자가 길게 누른 항목의 인덱스를 가져옴
                AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)menuInfo;

                menu.setHeaderTitle("리스트뷰의 메뉴 : "+info.position); //***position마다 분기해 항목마다 메뉴를 다르게 사용가능
                inflater.inflate(R.menu.listview_menu, menu);
                break;
        }
    }

    //context메뉴 항목 터치하면 호출되는 메서드
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        //context메뉴가 두개 이상일 수 있음 -> 사용자가 선택한 메뉴 항목의 id 추출
        int id = item.getItemId();

        //사용자가 길게 누른 항목의 인덱스 번호 추출
        ContextMenu.ContextMenuInfo info = item.getMenuInfo();
        int position = 0;
        if(info!=null&&info instanceof AdapterView.AdapterContextMenuInfo){
            AdapterView.AdapterContextMenuInfo info2 = (AdapterView.AdapterContextMenuInfo)info;
            position = info2.position;
        }

        switch (id){
            case R.id.textitem1:
                text7.setText("텍스트뷰 메뉴1 선택");
                break;
            case R.id.textitem2:
                text7.setText("텍스트뷰 메뉴2 선택");
                break;

            case R.id.listitem1:
                text7.setText("리스트뷰 메뉴1 선택 : "+position);
                break;
            case R.id.listitem2:
                text7.setText("리스트뷰 메뉴2 선택 : "+position);
                break;
        }
        return super.onContextItemSelected(item);
    }

    //리스트뷰 터치
    class ListListener implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            text7.setText("아이템 클릭 : "+data_menu[position]);
        }
    }
}
