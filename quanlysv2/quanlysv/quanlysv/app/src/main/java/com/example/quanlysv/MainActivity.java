package com.example.quanlysv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.quanlysv.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    final String DATABASE_NAME="quanly.sqlite";
    SQLiteDatabase database;
    ListView listView;
    ArrayList<SinhVien> list;
    AdapterSV adapter;
    Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        readData();
    }

    private void addControls() {
        btnAdd=findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,AddActivity.class);
                startActivity(intent);
            }
        });
        listView=findViewById(R.id.listView);
        list=new ArrayList<>();
        adapter=new AdapterSV(this, list);
        listView.setAdapter(adapter);
    }

    private void readData(){//trich du lieu tu sql
        database=Database.initDatabase(this,DATABASE_NAME);
        Cursor c = database.rawQuery("select * from SinhVien",null);
        list.clear();
        for(int i=0;i<c.getCount();i++){
            c.moveToPosition(i);
            String msv=c.getString(0);
            String ten=c.getString(1);
            String que=c.getString(2);
            String diem=c.getString(3);
            byte[] anh=c.getBlob(4);
            list.add(new SinhVien(msv,ten,que,diem,anh));
        }
        adapter.notifyDataSetChanged();
    }
}