package com.jiwoolee.android_view.adapterview;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.jiwoolee.android_view.R;

import java.util.ArrayList;

public class ViewpagerActivity extends AppCompatActivity {
    //광고창!
    //PageAdapter

    ViewPager viewPager;
    TextView text5;
    //viewpager를 통해 보여줄 view 객체를 가지고 있는 arraylist
    ArrayList<View> viewList = new ArrayList<View>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);

        viewPager = (ViewPager)findViewById(R.id.pager);
        text5 = (TextView)findViewById(R.id.textView12);

        //view 객체 생성해 arraylist에 담음
        LayoutInflater inflater = getLayoutInflater();
        View v1 = inflater.inflate(R.layout.viewpager_view1, null);
        View v2 = inflater.inflate(R.layout.viewpager_view2, null);

        viewList.add(v1);
        viewList.add(v2);

        CustomAdapter adapter = new CustomAdapter();
        viewPager.setAdapter(adapter);

        PagerListener listener = new PagerListener();
        viewPager.addOnPageChangeListener(listener);
    }

    class CustomAdapter extends PagerAdapter{
        //뷰페이저를 통해 보여줄 항목의 개수
        @Override
        public int getCount() {
            return viewList.size();
        }

        //뷰페이저를 통해 보여줄 뷰 객체를 반환
        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            //position번째 뷰 객체를 뷰 페이저에 세팅, 반환
            viewPager.addView(viewList.get(position));
            return viewList.get(position);
        }

        //instantiateItem 메서드에서 반환한 뷰 객체를 사용할 것인지 여부를 결정
        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view==object; //같은 객체일경우만 보여주기
        }

        //뷰가 제거될 때 호출
        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            viewPager.removeView((View)object);
        }
    }

    class PagerListener implements ViewPager.OnPageChangeListener{
        //view의 전환이 완료되었을 때 호출
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            text5.setText(position+"번 째 뷰");
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }

        @Override
        public void onPageSelected(int position) {

        }
    }

}
