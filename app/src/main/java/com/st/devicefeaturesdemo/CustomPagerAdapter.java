package com.st.devicefeaturesdemo;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class CustomPagerAdapter extends PagerAdapter {

    private List<Picture> pictures;
    private LayoutInflater inflater;

    public CustomPagerAdapter(Context context, List<Picture> pictures) {
        this.pictures = pictures;
        inflater =  (LayoutInflater) context.getSystemService(  Context.LAYOUT_INFLATER_SERVICE);

    }
    @Override
    public int getCount() {
        return pictures.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int pos) {
        View itemView =  inflater.inflate( R.layout.image_item, container,false);

        ImageView img= (ImageView) itemView.findViewById(R.id.image);
        TextView text= (TextView) itemView.findViewById(R.id.textTitle);

        Picture pic = pictures.get(pos);

        img.setImageResource( pic.getImageId());
        text.setText( pic.getTitle());

        container.addView(itemView);

        return itemView;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView( (View) object);
    }
}
