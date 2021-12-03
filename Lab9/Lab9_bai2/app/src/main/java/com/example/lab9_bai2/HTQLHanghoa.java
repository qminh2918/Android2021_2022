package com.example.lab9_bai2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class HTQLHanghoa extends AppCompatActivity {
    ListView lst1;
    ArrayList<String> titles = new ArrayList<String>();
    ArrayAdapter arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_htqlhanghoa);
        lst1 = findViewById(R.id.lst1);
        SQLiteDatabase db = openOrCreateDatabase("superpos", Context.MODE_PRIVATE,null);
        final Cursor c = db.rawQuery("select * from hanghoa",null);
        int ma = c.getColumnIndex("ma");
        int ten = c.getColumnIndex("ten");
        int soluong = c.getColumnIndex("soluong");
        int dongia = c.getColumnIndex("dongia");
        int donvitinh = c.getColumnIndex("donvitinh");

        titles.clear();
        arrayAdapter = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,titles);
        lst1.setAdapter(arrayAdapter);

        final ArrayList<qlhh> qlss = new ArrayList<qlhh>();
        if(c.moveToFirst()){
            do{
                qlhh pr = new qlhh();
                pr.ma= c.getString(ma);
                pr.ten = c.getString(ten);
                pr.soluong = c.getString(soluong);
                pr.dongia = c.getString(dongia);
                pr.donvitinh = c.getString(donvitinh);
                qlss.add(pr);
                titles.add(c.getString(ma) + "\t"  +c.getString(ten)+ "\t"  + c.getString(soluong)
                        + "\t"  + c.getString(dongia) + "\t"  + c.getString(donvitinh));

            }while(c.moveToNext());

            arrayAdapter.notifyDataSetChanged();
            lst1.invalidateViews();
        }
    }
}