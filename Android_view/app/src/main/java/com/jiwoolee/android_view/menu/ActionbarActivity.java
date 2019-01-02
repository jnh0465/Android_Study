package com.jiwoolee.android_view.menu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.SearchView;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.jiwoolee.android_view.R;

public class ActionbarActivity extends AppCompatActivity {
    //optinmenu + actionbar 속성 몇가지
    //****showAsAction // collapseActionView-actionViewClass(검색기능만들때 주로사용)


    TextView text9, text10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actionbar);

        text9 = (TextView)findViewById(R.id.textView18);
        text10 = (TextView)findViewById(R.id.textView19);
    }

    //옵션메뉴구성
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.actionbar_menu,menu);

        //검색 뷰가 설정되어 있는 항목 객체 추출
        MenuItem search_item = menu.findItem(R.id.actionitem5);
        //액션뷰로 설정된 뷰 추출
        SearchView search_view = (SearchView)search_item.getActionView();

        //안내문구설정
        search_view.setQueryHint("검색어를 입력해주세요");

        SearchviewListener listener = new SearchviewListener();
        search_view.setOnQueryTextListener(listener);

        return super.onCreateOptionsMenu(menu);
    }

    //옵션메뉴 터치시
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.actionitem1:
                text9.setText("메뉴1 선택");
                break;
            case R.id.actionitem2:
                text9.setText("메뉴2 선택");
                break;
            case R.id.actionitem3:
                text9.setText("메뉴3 선택");
                break;
            case R.id.actionitem4:
                text9.setText("메뉴4 선택");
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    //써치뷰의 리스너
    class SearchviewListener implements SearchView.OnQueryTextListener{
        @Override
        public boolean onQueryTextChange(String newText) {
            text10.setText(newText);
            return false;
        }
        @Override
        public boolean onQueryTextSubmit(String query) {
            text10.setText(query);
            return false;
        }
    }
}
