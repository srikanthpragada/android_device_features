package com.st.devicefeaturesdemo;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class FragmentsDemo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragments_demo);
    }

    public void  showDate(View v) {
          FragmentManager fm = getFragmentManager();
          FirstFragment ff = (FirstFragment) fm.findFragmentById(R.id.firstFragment);
          ff.showDate();
    }
}
