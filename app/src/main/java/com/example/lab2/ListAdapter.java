package com.example.lab2;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends BaseAdapter {

    List<JSONClass> jsonItem;
    ArrayList<Bitmap> imageBM;
    Context context;

    private static LayoutInflater inflater = null;

    public ListAdapter(Context context, List<JSONClass> technologies) {
        this.jsonItem = technologies;
        this.context = context;
        imageBM = new ArrayList<>(technologies.size());
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return jsonItem.size();
    }

    @Override
    public Object getItem(int position) {
        return jsonItem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        JSONClass technology = jsonItem.get(position);
        View view = convertView;
        if (view == null)
            view = inflater.inflate(R.layout.imagelist, null);
        Picasso.get()
                .load("https://raw.githubusercontent.com/wesleywerner/ancient-tech/02decf875616dd9692b31658d92e64a20d99f816/src/images/tech/" + technology.getGraphic())
                .into((ImageView)view.findViewById(R.id.image));

        TextView text = view.findViewById(R.id.text);
        text.setText(technology.getName());
        return view;
    }





}
