package com.example.sqliteb3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class HTQLSach extends AppCompatActivity {
    ListView lst1;
    ArrayList<String> titles = new ArrayList<String>();
    ArrayAdapter arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_htqlsach);
        lst1 = findViewById(R.id.lst1);
        SQLiteDatabase db = openOrCreateDatabase("superpos", Context.MODE_PRIVATE,null);
        final Cursor c = db.rawQuery("select * from sach",null);
        int id = c.getColumnIndex("id");
        int tensach = c.getColumnIndex("tensach");
        int ngay = c.getColumnIndex("ngay");
        int tentg = c.getColumnIndex("tentg");
        titles.clear();
        arrayAdapter = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,titles);
        lst1.setAdapter(arrayAdapter);

        final ArrayList<qls> qlss = new ArrayList<qls>();
        if(c.moveToFirst()){
            do{
                qls pr = new qls();
                pr.id = c.getString(id);
                pr.tensach= c.getString(tensach);
                pr.ngay = c.getString(ngay);
                pr.tentg = c.getString(tentg);
                qlss.add(pr);
                titles.add(c.getString(id) + "\t" + c.getString(tensach) + "\t"  +c.getString(ngay)+ "\t"  + c.getString(tentg));

            }while(c.moveToNext());

            arrayAdapter.notifyDataSetChanged();
            lst1.invalidateViews();
        }
    }
}