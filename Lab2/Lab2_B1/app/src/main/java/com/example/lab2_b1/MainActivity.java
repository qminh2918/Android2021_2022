package com.example.lab2_b1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView list; //khai bao doi tuong
    ArrayList<String> arr = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = (ListView)findViewById(R.id.listview); //anh xa sang ListView ben XML
        list.setDivider(null);

        arr.add("Cam");
        arr.add("Xoai");
        arr.add("Tao");
        arr.add("Oi");

        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, arr);
        list.setAdapter(adapter);
    }


}