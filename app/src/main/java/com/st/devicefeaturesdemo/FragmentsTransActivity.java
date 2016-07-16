package com.st.devicefeaturesdemo;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class FragmentsTransActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragments_trans);
    }

    public void placeFragment(Fragment f)
    {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, f);
        fragmentTransaction.commit();
    }

    public void placeOne(View v) {
        FragmentOne fragment = new FragmentOne();
        placeFragment(fragment);
    }

    public void placeTwo(View v) {
        Fragment fragment = new FragmentTwo();
        placeFragment(fragment);
    }
}
