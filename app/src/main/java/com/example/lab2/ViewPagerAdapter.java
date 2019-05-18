package com.example.lab2;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ViewPagerAdapter extends PagerAdapter {

    ArrayList<JSONClass> jsonItem;
    Context context;

    public ViewPagerAdapter(Context context, ArrayList<JSONClass> jsonItem){
        this.context = context;
        this.jsonItem = jsonItem;
    }

    @Override
    public int getCount() {
        return jsonItem.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup collection, int position) {
        JSONClass technology = jsonItem.get(position);
        LayoutInflater inflater = LayoutInflater.from(context);
        ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.pages, collection, false);
        Picasso.get()
                .load("https://raw.githubusercontent.com/wesleywerner/ancient-tech/02decf875616dd9692b31658d92e64a20d99f816/src/images/tech/" + technology.getGraphic())
                .into((ImageView)layout.findViewById(R.id.imagepages));

        TextView text = layout.findViewById(R.id.textpages);
        text.setText(technology.getHelptext());
        collection.addView(layout);
        return layout;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return jsonItem.get(position).getName();
    }
}
