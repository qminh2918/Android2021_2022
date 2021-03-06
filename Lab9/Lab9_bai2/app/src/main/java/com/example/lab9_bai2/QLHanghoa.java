package com.example.lab9_bai2;

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

public class QLHanghoa extends AppCompatActivity {
    EditText ed1,ed2,ed3,ed4, ed5, ed6;
    Button b1,b2, b3, b4;
    ArrayList<String> titles = new ArrayList<String>();
    ArrayAdapter arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qlhanghoa);
        ed1 = findViewById(R.id.ma);
        ed2 = findViewById(R.id.ten);
        ed3 = findViewById(R.id.soluong);
        ed4 = findViewById(R.id.dongia);
        ed5 = findViewById(R.id.donvitinh);
        ed6 = findViewById(R.id.ma_old);
        b1 = findViewById(R.id.btn3);
        b2 = findViewById(R.id.btn4);
        b3 = findViewById(R.id.btn1);
        b4 = findViewById(R.id.btn2);

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                delete();
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update();
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insert();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(QLHanghoa.this,MainActivity.class);
                startActivity(i);
            }
        });
    }

    public void delete() {
        try {

            String ma = ed1.getText().toString();

            // t???o csdl l?? superpos
            SQLiteDatabase db = openOrCreateDatabase("superpos", Context.MODE_PRIVATE, null);
            //

            // t???o c??u truy v???n
            String sql = "delete from hanghoa where ma = "+ ma;
            // truy v???n
            SQLiteStatement statement = db.compileStatement(sql);
            statement.execute();
            //Hi???n th??? k???t qu??? th??nh c??ng k
            Toast.makeText(this, "X??a h??ng h??a th??nh c??ng  ", Toast.LENGTH_LONG).show();
            // sau ???? hu??? d??? li???u v??? r???ng
            ed1.setText("");
            ed2.setText("");
            ed3.setText("");
            ed4.setText("");
            ed5.setText("");
            ed1.requestFocus();

        } catch (Exception ex) {
            Toast.makeText(this, "H??ng h??a ch??a x??a ???????c   ", Toast.LENGTH_LONG).show();
        }
    }

    public void update() {
        try {
            String ma_old = ed6.getText().toString();
            String ma = ed1.getText().toString();
            String ten = ed2.getText().toString();
            String soluong = ed3.getText().toString();
            String dongia = ed4.getText().toString();
            String donvitinh = ed5.getText().toString();

            // t???o csdl l?? superpos
            SQLiteDatabase db = openOrCreateDatabase("superpos", Context.MODE_PRIVATE, null);
            //

            // t???o c??u truy v???n
            String sql = "update hanghoa set ma = "+ma+",ten ="+ten+",soluong = "+soluong+",dongia = "+dongia+",donvitinh = "+donvitinh +" where ma ="+ma_old;
            // truy v???n
            SQLiteStatement statement = db.compileStatement(sql);
            statement.execute();
            //Hi???n th??? k???t qu??? th??nh c??ng k
            Toast.makeText(this, "S???a h??ng h??a th??nh c??ng  ", Toast.LENGTH_LONG).show();
            // sau ???? hu??? d??? li???u v??? r???ng
            ed1.setText("");
            ed2.setText("");
            ed3.setText("");
            ed4.setText("");
            ed5.setText("");
            ed1.requestFocus();

        } catch (Exception ex) {
            Toast.makeText(this, "H??ng h??a ch??a s???a ???????c   ", Toast.LENGTH_LONG).show();
        }
    }

    public void insert() {
        try {
            String ma = ed1.getText().toString();
            String ten = ed2.getText().toString();
            String soluong = ed3.getText().toString();
            String dongia = ed4.getText().toString();
            String donvitinh = ed5.getText().toString();

            // t???o csdl l?? superpos
            SQLiteDatabase db = openOrCreateDatabase("superpos", Context.MODE_PRIVATE, null);
            //
            db.execSQL("CREATE TABLE IF NOT EXISTS hanghoa(ma VARCHAR PRIMARY KEY, ten VARCHAR,soluong VARCHAR, dongia VARCHAR,donvitinh VARCHAR)");

            // t???o c??u truy v???n
            String sql = "insert into hanghoa (ma,ten,soluong,dongia,donvitinh) values(?,?,?,?,?)";
            // truy v???n
            SQLiteStatement statement = db.compileStatement(sql);
            // chu???n b???
            statement.bindString(1, ma);
            statement.bindString(2, ten);
            statement.bindString(3, soluong);
            statement.bindString(2, dongia);
            statement.bindString(3, donvitinh);
            // l??u v??o database
            statement.execute();
            //Hi???n th??? k???t qu??? th??nh c??ng k
            Toast.makeText(this, "Th??m h??ng h??a th??nh c??ng  ", Toast.LENGTH_LONG).show();
            // sau ???? hu??? d??? li???u v??? r???ng
            ed1.setText("");
            ed2.setText("");
            ed3.setText("");
            ed4.setText("");
            ed5.setText("");
            ed1.requestFocus();
        } catch (Exception ex) {
            Toast.makeText(this, "H??ng h??a ch??a th??m v??o database   ", Toast.LENGTH_LONG).show();
        }
    }
}