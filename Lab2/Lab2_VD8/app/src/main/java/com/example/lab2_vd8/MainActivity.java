package com.example.lab2_vd8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btngo;
    EditText edtname,edtage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtname = (EditText) findViewById(R.id.edtname);
        edtage = (EditText) findViewById(R.id.edtage);
        btngo = (Button) findViewById(R.id.btngo);
        btngo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!edtname.getText().toString().equals("")
                        && !edtage.getText().toString().equals("")) {
                    String a = edtname.getText().toString();
                    String b = edtage.getText().toString();
                    Toast.makeText(MainActivity.this, "Tên:" + a + ",tuổi " + b,
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Không được để trống",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}