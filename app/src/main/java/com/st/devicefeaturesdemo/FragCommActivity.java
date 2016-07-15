package com.st.devicefeaturesdemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class FragCommActivity extends Activity  implements  DateListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frag_comm);
    }

    public void showDate() {
        Log.d("Fragments", "showDate()");
    }
}
