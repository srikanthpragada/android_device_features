package com.st.devicefeaturesdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CourseDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_details);


        CourseDetailsFragment details = new CourseDetailsFragment();
        details.setArguments(getIntent().getExtras());
        getFragmentManager().beginTransaction().add(android.R.id.content, details).commit();
    }
}
