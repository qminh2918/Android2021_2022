package com.example.lab33;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SwitchCompat sc1,sc2,sc3,sc4,sc5,sc6,sc7;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sc1 = findViewById(R.id.switch1);
        sc2 = findViewById(R.id.switch2);
        sc3 = findViewById(R.id.switch3);
        sc4 = findViewById(R.id.switch4);
        sc5 = findViewById(R.id.switch5);
        sc6 = findViewById(R.id.switch6);
        sc7 = findViewById(R.id.switch7);
    sc1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (sc1.isChecked()) {
                sc1.setChecked(false);
                Toast.makeText(MainActivity.this, "Wifi is off", Toast.LENGTH_SHORT).show();
            } else {
                sc1.setChecked(true);
                Toast.makeText(MainActivity.this, "Wifi is on", Toast.LENGTH_SHORT).show();
            }

        }
    });
    sc2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (sc2.isChecked()) {
                sc2.setChecked(false);
                Toast.makeText(MainActivity.this, "Mạng 3G đang tắt ", Toast.LENGTH_SHORT).show();
            } else {
                sc2.setChecked(true);
                Toast.makeText(MainActivity.this, "Mạng 3G đang bật ", Toast.LENGTH_SHORT).show();
            }
        }
    });
    sc3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (sc3.isChecked()) {
                sc3.setChecked(false);
                Toast.makeText(MainActivity.this, "NFC tắt  ", Toast.LENGTH_SHORT).show();
            } else {
                sc3.setChecked(true);
                Toast.makeText(MainActivity.this, "NFC bật ", Toast.LENGTH_SHORT).show();
            }
        }
    });
        sc4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sc4.isChecked()) {
                    sc4.setChecked(false);
                    Toast.makeText(MainActivity.this, "Mạng 3G đang tắt ", Toast.LENGTH_SHORT).show();
                } else {
                    sc4.setChecked(true);
                    Toast.makeText(MainActivity.this, "Mạng 3G đang bật ", Toast.LENGTH_SHORT).show();
                }
            }
        });
        sc5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sc5.isChecked()) {
                    sc5.setChecked(false);
                    Toast.makeText(MainActivity.this, "Mạng 3G đang tắt ", Toast.LENGTH_SHORT).show();
                } else {
                    sc5.setChecked(true);
                    Toast.makeText(MainActivity.this, "Mạng 3G đang bật ", Toast.LENGTH_SHORT).show();
                }
            }
        });
        sc6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sc6.isChecked()) {
                    sc6.setChecked(false);
                    Toast.makeText(MainActivity.this, "Mạng 3G đang tắt ", Toast.LENGTH_SHORT).show();
                } else {
                    sc6.setChecked(true);
                    Toast.makeText(MainActivity.this, "Mạng 3G đang bật ", Toast.LENGTH_SHORT).show();
                }
            }
        });
        sc7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sc7.isChecked()) {
                    sc7.setChecked(false);
                    Toast.makeText(MainActivity.this, "Mạng 3G đang tắt ", Toast.LENGTH_SHORT).show();
                } else {
                    sc7.setChecked(true);
                    Toast.makeText(MainActivity.this, "Mạng 3G đang bật ", Toast.LENGTH_SHORT).show();
                }
            }
        });
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(MainActivity.this, "Bạn vừa lưu lựa chọn của mình  ", Toast.LENGTH_SHORT).show();
//            }
//        });

    }
}