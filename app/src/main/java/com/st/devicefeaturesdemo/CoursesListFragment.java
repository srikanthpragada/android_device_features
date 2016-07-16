package com.st.devicefeaturesdemo;


import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class CoursesListFragment extends ListFragment {

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Populate list with our static array of titles.
        setListAdapter(new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_activated_1, Courses.TITLES));
   }
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        showDetails(position);
    }


    void showDetails(int index) {

        if ( getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE )
        {
                 CourseDetailsFragment details = new CourseDetailsFragment();
                 details.showDetails(index);
                 FragmentTransaction ft = getFragmentManager().beginTransaction();
                // ft.replace(R.id.details, details);
                 ft.commit();


        }
        else
        {
            Intent intent = new Intent();
            intent.setClass(getActivity(), CourseDetailsActivity.class);
            intent.putExtra("index", index);
            startActivity(intent);
        }

    }

}
