package com.example.sqliteb3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TacGia extends AppCompatActivity {
    EditText ed1;
    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tac_gia);
        ed1 = findViewById(R.id.tentg);
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
                Intent i = new Intent(TacGia.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
    public void insert(){
        try{
            String tentg = ed1.getText().toString();
            // tạo csdl là superpos
            SQLiteDatabase db = openOrCreateDatabase("superpos", Context.MODE_PRIVATE,null);
            //
            db.execSQL("CREATE TABLE IF NOT EXISTS tacgia(id INTEGER PRIMARY KEY AUTOINCREMENT,tentg VARCHAR)");

            // tạo câu truy vấn
            String sql = "insert into tacgia (tentg) values(?)";
            // truy vấn
            SQLiteStatement statement = db.compileStatement(sql);
            // chuẩn bị
            statement.bindString(1,tentg);
            // lưu vào database
            statement.execute();
            //Hiển thị kết quả thành công k
            Toast.makeText(this,"Thêm tác giả thành công ",Toast.LENGTH_LONG).show();
            // sau đó huỷ dữ liệu về rỗng
            ed1.setText("");
            ed1.requestFocus();
        }catch(Exception ex){
            Toast.makeText(this,"Thêm tác giả thất bại  ",Toast.LENGTH_LONG).show();
        }
    }
}