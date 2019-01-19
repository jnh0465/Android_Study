package com.jiwoolee.android_back.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.jiwoolee.android_back.R;

public class ListFragment extends android.support.v4.app.ListFragment {

    TextView text35;
    String [] list = {"항목1", "항목2", "항목3", "항목4", "항목5"};

    public ListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        text35 = (TextView)view.findViewById(R.id.textView35);
        ListfragmentActivity activity = (ListfragmentActivity)getActivity(); //Activitycontroller activity 객체 추출
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(activity, android.R.layout.simple_list_item_1, list);
        setListAdapter(adapter);

        return view;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) { //리스트뷰 항목 터치 메서드
        super.onListItemClick(l, v, position, id);
        text35.setText("선택한 항목 : "+list[position]);
    }
}
