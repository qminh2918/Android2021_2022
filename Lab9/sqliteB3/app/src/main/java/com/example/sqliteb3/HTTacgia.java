package com.example.sqliteb3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class HTTacgia extends AppCompatActivity {
    ListView lst1;
    ArrayList<String> titles = new ArrayList<String>();
    ArrayAdapter arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_httacgia);
        lst1 = findViewById(R.id.lst1);
        SQLiteDatabase db = openOrCreateDatabase("superpos", Context.MODE_PRIVATE,null);
        final Cursor c = db.rawQuery("select * from tacgia",null);
        int id = c.getColumnIndex("id");
        int tentg = c.getColumnIndex("tentg");
        titles.clear();
        arrayAdapter = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,titles);
        lst1.setAdapter(arrayAdapter);
        final ArrayList<tgia> tgg = new ArrayList<tgia>();
        if(c.moveToFirst()){
            do{
                tgia tg = new tgia();
                tg.id = c.getString(id);
                tg.tentg = c.getString(tentg);
                tgg.add(tg);
                titles.add(c.getString(id) + "\t"+"\t" + c.getString(tentg));

            }while(c.moveToNext());

            arrayAdapter.notifyDataSetChanged();
            lst1.invalidateViews();
        }
    }
}