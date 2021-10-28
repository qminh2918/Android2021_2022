package com.example.lab3_bt1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText hoten, tuoi;
    Spinner quequan;
    Button register;
    String ht;
    String t;
    String qq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hoten = (EditText) findViewById(R.id.hoten);
        tuoi = (EditText) findViewById(R.id.tuoi);
        quequan = (Spinner) findViewById(R.id.quequan);
        register = (Button) findViewById(R.id.register);
        String[] arr = {"Hà Nội", "Thành phố Hồ Chí Minh", "Hải Phòng", "Đà Nẵng"};
        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, arr);
        quequan.setAdapter(adapter);

//        ht = hoten.getText().toString();
//        t = tuoi.getText().toString();


        quequan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                qq = quequan.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Họ tên: " + hoten.getText().toString()
                                + ",tuổi: "+ tuoi.getText().toString() + ",quê quán: "+qq,
                        Toast.LENGTH_LONG).show();
            }
        });

    }
}