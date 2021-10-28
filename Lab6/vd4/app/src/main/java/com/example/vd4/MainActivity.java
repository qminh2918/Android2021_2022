package com.example.vd4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<ThoiTiet> listCountry = new ArrayList<ThoiTiet>();
    ListView mList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        mList = (ListView) findViewById(R.id.list);
        AdapterTT adapter = new AdapterTT(MainActivity.this, R.layout.layout_hang,
                listCountry);
        mList.setAdapter(adapter);
    }
    public void init() {
        ThoiTiet tt = new ThoiTiet(R.drawable.ic_launcher_foreground, "Berlin",
                "Snowing", "0");
        listCountry.add(tt);
        ThoiTiet tt2 = new ThoiTiet(R.drawable.ic_launcher_foreground, "Bangalore",
                "Thunderstorms", "23");
        listCountry.add (tt2);
        ThoiTiet tt3 = new ThoiTiet(R.drawable.ic_launcher_foreground, "London",
                "Rainy", "5");
        listCountry.add(tt3);
        ThoiTiet tt4 = new ThoiTiet(R.drawable.ic_launcher_foreground, "New York",
                "Cloundy", "18");
        listCountry.add(tt4);
        ThoiTiet tt5 = new ThoiTiet(R.drawable.ic_launcher_foreground, "Sydney",
                "Sunny", "32");
        listCountry.add(tt5);
    }
}