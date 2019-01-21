package com.jiwoolee.android_back.Fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.jiwoolee.android_back.R;

public class DialFragment extends DialogFragment {
    public DialFragment() {
        // Required empty public constructor
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        DialfragmentActivity activity = (DialfragmentActivity)getActivity(); //Activitycontroller activity 객체 추출
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        builder.setTitle("타이틀");
        builder.setMessage("메세지");

        DialogListener listener = new DialogListener();
        builder.setPositiveButton("Positive", listener);
        builder.setNeutralButton("Neutral", listener);
        builder.setNegativeButton("Negative", listener);

        AlertDialog alert = builder.create();
        return alert;
    }

    class DialogListener implements DialogInterface.OnClickListener{ //버튼 처리
        @Override
        public void onClick(DialogInterface dialog, int which) {
            DialfragmentActivity activity = (DialfragmentActivity)getActivity(); //Activitycontroller activity 객체 추출
            switch (which){
                case DialogInterface.BUTTON_POSITIVE:
                    activity.text36.setText("positive");
                    break;
                case DialogInterface.BUTTON_NEUTRAL:
                    activity.text36.setText("neutral");
                    break;
                case DialogInterface.BUTTON_NEGATIVE:
                    activity.text36.setText("negative");
                    break;
            }
        }
    }
}
