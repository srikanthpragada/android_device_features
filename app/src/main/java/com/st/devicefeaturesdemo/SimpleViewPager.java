package com.st.devicefeaturesdemo;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class SimpleViewPager extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_view_pager);

        ViewPager  vp = (ViewPager) findViewById(R.id.viewPager);
        CustomPagerAdapter cpa = new CustomPagerAdapter(this, getPicture());
        vp.setAdapter(cpa);
    }

    public List<Picture> getPicture() {

        ArrayList<Picture> pics = new ArrayList<>();
        pics.add( new  Picture(R.drawable.billgates,"Bill Gates"));
        pics.add( new  Picture(R.drawable.classroom,"Classroom"));
        pics.add( new  Picture(R.drawable.ship,"Ship With Tugs"));
        pics.add( new  Picture(R.drawable.work,"Work"));

        return pics;

    }
}
