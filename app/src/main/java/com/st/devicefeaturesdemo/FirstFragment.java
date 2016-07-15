package com.st.devicefeaturesdemo;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Date;

public class FirstFragment extends Fragment {
    TextView tv;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_first,container);
        tv = (TextView) view.findViewById(R.id.textView);
        return view;
    }

    public void showDate()
    {
        tv.setText( new Date().toString());

    }
}
