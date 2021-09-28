package com.example.lab2_vd7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public class CustomAdapter extends BaseAdapter {
        Context context;
        String[] list;
        int[] flags;
        LayoutInflater inflater;

        public CustomAdapter(Context context, String[] country, int[] flag) {
            this.context = context;
            this.list = country;
            this.flags = flag;
            inflater = LayoutInflater.from(context);
        }
        @Override
        public int getCount() {
            return list.length;
        }
        @Override
        public Object getItem(int position) {
            return null;
        }
        @Override
        public long getItemId(int position) {
            return 0;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            convertView=inflater.inflate(R.layout.layout_item,parent,false);
            TextView country=(TextView) convertView.findViewById(R.id.name);
            ImageView flag=(ImageView)convertView.findViewById(R.id.imgflag);
            country.setText(list[position]);
            flag.setImageResource(flags[position]);
            return convertView;
        }
    }

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = (Spinner) findViewById(R.id.spinner1);
        String[] arr = {"Vietnam", "England", "USA", "Switzerland"};
        int[] flag = {R.drawable.vietnam, R.drawable.uk, R.drawable.us, R.drawable.swizerland};
        CustomAdapter adapter = new CustomAdapter(this, arr, flag);
        spinner.setAdapter(adapter);
    }
}