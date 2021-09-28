package com.example.lab2_b3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TextView tv;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv= (TextView) findViewById(R.id.textview);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.setTextColor(Color.RED);
            }
        });
    }
}