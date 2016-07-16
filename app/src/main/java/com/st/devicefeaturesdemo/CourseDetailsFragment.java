package com.st.devicefeaturesdemo;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class CourseDetailsFragment extends Fragment {


    public CourseDetailsFragment() {
        // Required empty public constructor
    }

    public void showDetails(int index) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_course_details, container, false);
    }

}
