package com.example.lab3_bt2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    CheckBox duahau, duachuot, duacai, duamuoi;
    RadioButton tm, online;
    TextView dhang;
    Button mua;
    String dhau = "",dchuot = "", dcai = "", dmuoi = "", httt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        duahau = (CheckBox) findViewById(R.id.checkbox_duahau);
        duachuot = (CheckBox) findViewById(R.id.checkbox_duachuot);
        duacai = (CheckBox) findViewById(R.id.checkbox_duacai);
        duamuoi = (CheckBox) findViewById(R.id.checkbox_duamuoi);
        tm =(RadioButton) findViewById(R.id.rdo_tm);
        online =(RadioButton) findViewById(R.id.rdo_online);
        dhang = (TextView) findViewById(R.id.donhang);
        mua = (Button) findViewById(R.id.mua);

        duahau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(duahau.isChecked()) {
                    dhau = duahau.getText().toString();
                } else {
                    dhau = "";
                }
            }
        });
        duachuot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(duachuot.isChecked()) {
                    dchuot = ',' + duachuot.getText().toString();
                } else {
                    dchuot = "";
                }
            }
        });
        duacai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(duacai.isChecked()) {
                    dcai = ',' + duacai.getText().toString() ;
                } else {
                    dcai = "";
                }
            }
        });
        duamuoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(duamuoi.isChecked()) {
                    dmuoi = ',' + duamuoi.getText().toString();
                } else {
                    dmuoi = "";
                }
            }
        });
        tm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tm.isChecked()) {
                    httt =  tm.getText().toString();
                } else {
                    httt = "";
                }
            }
        });
        online.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(online.isChecked()) {
                    httt = online.getText().toString();
                } else {
                    httt = "";
                }
            }
        });

        mua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dhang.setText("Loại dưa: " + dhau + dchuot + dcai +dmuoi + "\n" +
                        "Hình thức thanh toán: " + httt);
            }
        });

    }
}