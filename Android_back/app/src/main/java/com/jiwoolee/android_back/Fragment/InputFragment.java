package com.jiwoolee.android_back.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.jiwoolee.android_back.R;

public class InputFragment extends Fragment {

    Button btn;
    EditText edit1, edit2;

    public InputFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_input, container, false); //프레그먼트가 관리할 뷰 생성

        btn = (Button)view.findViewById(R.id.button22);
        edit1 = (EditText)view.findViewById(R.id.editText);
        edit2 = (EditText)view.findViewById(R.id.editText2);

        BtnListener listener = new BtnListener();
        btn.setOnClickListener(listener);
        return view;
    }

    class BtnListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Activitycontroller activity = (Activitycontroller)getActivity(); //Activitycontroller activity 객체 추출
            activity.value1 = edit1.getText().toString(); //EditText 입력값을 ActivityController activity의 변수에 담는다
            activity.value2 = edit2.getText().toString();

            activity.setFragment("result"); //ResultFragment 호출
        }
    }
}
