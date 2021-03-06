package com.example.sqliteb3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class QLSach extends AppCompatActivity {
    EditText ed1,ed2;
    Button b1,b2;
    Spinner sprinner;
    ArrayList<String> titles = new ArrayList<String>();
    ArrayAdapter arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qlsach);
        ed1 = findViewById(R.id.tensach);
        ed2 = findViewById(R.id.ngay);
        sprinner = findViewById(R.id.tgid);
        b1 = findViewById(R.id.btn1);
        b2 = findViewById(R.id.btn2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insert();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(QLSach.this,MainActivity.class);
                startActivity(i);
            }
        });
        SQLiteDatabase db = openOrCreateDatabase("superpos", Context.MODE_PRIVATE,null);
        final Cursor c = db.rawQuery("select * from tacgia",null);

        int tentg = c.getColumnIndex("tentg");
        titles.clear();
        arrayAdapter = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,titles);
        sprinner.setAdapter(arrayAdapter);

        final ArrayList<tgia> tgg = new ArrayList<tgia>();
        if(c.moveToFirst()){
            do{
                tgia ca = new tgia();
                ca.tentg = c.getString(tentg);
                tgg.add(ca);
                titles.add(c.getString(tentg));

            }while(c.moveToNext());

            arrayAdapter.notifyDataSetChanged();
        }

    }
    public void insert() {
        try {
            String tensach = ed1.getText().toString();
            String ngay = ed2.getText().toString();
            String tentg = sprinner.getSelectedItem().toString();

            // t???o csdl l?? superpos
            SQLiteDatabase db = openOrCreateDatabase("superpos", Context.MODE_PRIVATE, null);
            //
            db.execSQL("CREATE TABLE IF NOT EXISTS sach(id INTEGER PRIMARY KEY AUTOINCREMENT,tensach VARCHAR, ngay VARCHAR,tentg VARCHAR)");

            // t???o c??u truy v???n
            String sql = "insert into sach (tensach,ngay,tentg) values(?,?,?)";
            // truy v???n
            SQLiteStatement statement = db.compileStatement(sql);
            // chu???n b???
            statement.bindString(1, tensach);
            statement.bindString(2, ngay);
            statement.bindString(3, tentg);
            // l??u v??o database
            statement.execute();
            //Hi???n th??? k???t qu??? th??nh c??ng k
            Toast.makeText(this, "Th??m s??ch th??nh c??ng  ", Toast.LENGTH_LONG).show();
            // sau ???? hu??? d??? li???u v??? r???ng
            ed1.setText("");
            ed2.setText("");
            ed1.requestFocus();
        } catch (Exception ex) {
            Toast.makeText(this, "S??ch ch??a th??m v??o database   ", Toast.LENGTH_LONG).show();
        }
    }
}