package com.example.resultoptions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    RadioButton radio1,radio2,radio3,radio4;
    RadioGroup radioGp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        int selectedId = radioGroup.getCheckedRadioButtonId();
        radio1 = (RadioButton) findViewById(R.id.r1);
        radio2 = (RadioButton)  findViewById(R.id.r2);
        radio3 = (RadioButton) findViewById(R.id.r3);
        radio4 = (RadioButton) findViewById(R.id.r4);
        radioGp =findViewById(R.id.radioGroup);
        radioGp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch(checkedId){
                    case R.id.r1:
                        // khởi tạo hành động là 1 intent có 2 tham số truyền vào là Mainactivity là màn hiện tại
                        // còn giaiptbac2 là màn c
                        Intent intent = new Intent(MainActivity.this,sohoanhao.class);
                        // khởi chạy activity đó lên
                        startActivity(intent);
                        break;
                    case R.id.r2:
                        // khởi tạo hành động là 1 intent có 2 tham số truyền vào là Mainactivity là màn hiện tại
                        // còn giaiptbac2 là màn c
                        Intent i = new Intent(MainActivity.this,songuyento.class);
                        // khởi chạy activity đó lên
                        startActivity(i);
                        break;
                    case R.id.r3:
                        // khởi tạo hành động là 1 intent có 2 tham số truyền vào là Mainactivity là màn hiện tại
                        // còn giaiptbac2 là màn c
                        Intent k = new Intent(MainActivity.this,giaiptbac1.class);
                        // khởi chạy activity đó lên
                        startActivity(k);
                        break;
                    case R.id.r4:
                        // khởi tạo hành động là 1 intent có 2 tham số truyền vào là Mainactivity là màn hiện tại
                        // còn giaiptbac2 là màn c
                        Intent l = new Intent(MainActivity.this,giaiptbac2.class);
                        // khởi chạy activity đó lên
                        startActivity(l);
                        break;
                }
            }
        });

    }
}