package com.st.devicefeaturesdemo;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class FragmentA extends Fragment {
    private DateListener mListener;

    public FragmentA() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_a, container, false);
    }

    public void displayDate(View v)
    {
        Log.d("Fragments","showDate() in FragmentA");
        if (mListener != null) {
            mListener.showDate();
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof DateListener) {
            mListener = (DateListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement DateListener");
        }

        Log.d("Fragments", "mListener = " + mListener.toString());
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

}
