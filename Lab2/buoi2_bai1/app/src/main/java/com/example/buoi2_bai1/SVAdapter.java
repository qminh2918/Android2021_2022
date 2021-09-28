package com.example.buoi2_bai1;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class SVAdapter extends BaseAdapter {
    Activity activity;
    List<com.example.buoi2_bai1.SV> svList;

    public SVAdapter(Activity activity, List<com.example.buoi2_bai1.SV> foodList) {
        this.activity = activity;
        this.svList = foodList;
    }

    @Override
    public int getCount() {
        return svList.size();
    }

    @Override
    public Object getItem(int position) {
        return svList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View View, ViewGroup parent) {
        LayoutInflater layoutInflater=activity.getLayoutInflater();
        View=layoutInflater.inflate(R.layout.item_listview,null);
        ImageView image=View.findViewById(R.id.thump);
        TextView tieude=View.findViewById(R.id.name);
        TextView noidung=View.findViewById(R.id.info);
        com.example.buoi2_bai1.SV food = svList.get(position);
        image.setImageResource(food.getId());
        tieude.setText(food.getTitle());
        noidung.setText(food.getContent());
        return View;
    }
}
