package com.st.devicefeaturesdemo;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Date;


public class FragmentB extends Fragment {
    TextView tvDate;

    public FragmentB() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_b, container, false);
        tvDate = (TextView) view.findViewById(R.id.textDate);
        return view;
    }

    public void showDate()
    {
        tvDate.setText( new Date().toString());
    }

}
