package com.jiwoolee.android_back.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.jiwoolee.android_back.R;

public class ResultFragment extends Fragment {

    Button btn2;
    TextView text33, text34;

    public ResultFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result, container, false);

        btn2 = (Button)view.findViewById(R.id.button23);
        text33 = (TextView)view.findViewById(R.id.textView33);
        text34 = (TextView)view.findViewById(R.id.textView34);

        Activitycontroller activity = (Activitycontroller)getActivity(); //Activitycontroller activity 객체 추출
        text33.setText(activity.value1);
        text34.setText(activity.value2);

        BtnListener2 listener = new BtnListener2();
        btn2.setOnClickListener(listener);
        return view;
    }

    class BtnListener2 implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Activitycontroller activity = (Activitycontroller)getActivity();
            FragmentManager manager = activity.getSupportFragmentManager();
            manager.popBackStack(); //이전 프레그먼트로 이동
        }
    }
}
