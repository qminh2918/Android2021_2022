package com.example.lab8_vd3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText txt1,txt2;
    Button btnshow;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt1 =(EditText)findViewById(R.id.txtname);
        txt2 = (EditText)findViewById(R.id.txtlop);
        btnshow = (Button)findViewById(R.id.btnShow);
        btnshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this, MyBroadcastReceiver.class);
                String str = "Xin chào " + txt1.getText().toString()+" Lớp "+ txt2.getText().toString();
                intent.putExtra("bm",str);
                sendBroadcast(intent);
            }
        });
    }
}