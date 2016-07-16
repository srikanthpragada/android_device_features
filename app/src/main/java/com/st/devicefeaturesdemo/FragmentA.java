package com.st.devicefeaturesdemo;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class FragmentA extends Fragment {
    private Button btnShow;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_a, container, false);
        btnShow = (Button) v.findViewById(R.id.btnShow);
        btnShow.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.d("Fragments","Button in FragementA clicked");

                        Activity activity = getActivity();
                        if (activity instanceof  DateListener) {
                            DateListener listener = (DateListener) activity;
                            listener.showDate();
                        }
                    }
                }
        );
        return v;
    }

}
