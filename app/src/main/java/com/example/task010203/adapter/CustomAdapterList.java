package com.example.task010203.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.task010203.R;


public class CustomAdapterList extends BaseAdapter {

    Context context;
    int[] data_images;
    String[] data_name;
    LayoutInflater inflater;


    public CustomAdapterList(Context context, int[] data_images, String[] data_name) {
        this.context = context;
        this.data_images = data_images;
        this.data_name = data_name;
        inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data_name.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view1;

        view1=inflater.inflate(R.layout.listdesign,null);

        ImageView imageView;
        TextView textView;

        imageView=(ImageView)view1.findViewById(R.id.imge);
        textView=(TextView)view1.findViewById(R.id.txt);

        imageView.setImageResource(data_images[i]);
        textView.setText(data_name[i]);


        return view1;
    }
}
