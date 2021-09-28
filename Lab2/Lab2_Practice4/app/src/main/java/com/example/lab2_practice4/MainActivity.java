package com.example.lab2_practice4;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Spinner sp;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = (Spinner) findViewById(R.id.spinner1);
        String[] arr ={"Black", "White", "Red", "Green", "Blue"};
        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, arr);
        spinner.setAdapter(adapter);
        sp = (Spinner) findViewById(R.id.spinner1);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String temp = sp.getSelectedItem().toString();
                tv= (TextView) findViewById(R.id.textview);
                switch (temp) {
                    case "Black": {
                        tv.setTextColor(Color.BLACK);
                    }; break;
                    case "White": {
                        tv.setTextColor(Color.WHITE);
                    }; break;
                    case "Red": {
                        tv.setTextColor(Color.RED);

                    }; break;
                    case "Green": {
                        tv.setTextColor(Color.GREEN);
                    }; break;
                    case "Blue": {
//                        tv= (TextView) findViewById(R.id.textview);
                        tv.setTextColor(Color.BLUE);
                    }; break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}