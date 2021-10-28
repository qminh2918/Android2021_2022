package com.example.lab6_3;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class StaffAdapter extends BaseAdapter {
    Activity activity;
    List<Staff> dataList;
    public StaffAdapter(Activity activity, List<Staff> dataList){
        this.activity=activity;
        this.dataList=dataList;
    }
    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int i) {
        return dataList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater=activity.getLayoutInflater();
        view=inflater.inflate(R.layout.item_staff,null);
        ImageView anh=view.findViewById(R.id.thumb);
        TextView ten=view.findViewById(R.id.name);
        TextView sdt=view.findViewById(R.id.phone);
        TextView gtinh=view.findViewById(R.id.gender);
        Staff staff=dataList.get(i);
        anh.setImageResource(staff.getId());
        ten.setText(staff.getTen());
        sdt.setText(staff.getSdt());
        gtinh.setText(staff.getGtinh());


        return view;
    }
}
